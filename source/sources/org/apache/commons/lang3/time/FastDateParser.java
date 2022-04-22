package org.apache.commons.lang3.time;

import com.memes.eventtracker.util.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FastDateParser implements DateParser, Serializable {
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) {
        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 100) {
                parseInt = fastDateParser.adjustYear(parseInt);
            }
            calendar.set(1, parseInt);
        }
    };
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy HOUR12_STRATEGY = new NumberStrategy(10) {
        /* access modifiers changed from: package-private */
        public int modify(int i) {
            if (i == 12) {
                return 0;
            }
            return i;
        }
    };
    private static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) {
        /* access modifiers changed from: package-private */
        public int modify(int i) {
            if (i == 24) {
                return 0;
            }
            return i;
        }
    };
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    private static final Strategy ISO_8601_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::?\\d{2})?))");
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) {
        /* access modifiers changed from: package-private */
        public int modify(int i) {
            return i - 1;
        }
    };
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final Pattern formatPattern = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|S+|W+|X+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");
    private static final long serialVersionUID = 2;
    private final int century;
    private transient String currentFormatField;
    private final Locale locale;
    private transient Strategy nextStrategy;
    private transient Pattern parsePattern;
    private final String pattern;
    private final int startYear;
    private transient Strategy[] strategies;
    private final TimeZone timeZone;

    protected FastDateParser(String str, TimeZone timeZone2, Locale locale2) {
        this(str, timeZone2, locale2, (Date) null);
    }

    protected FastDateParser(String str, TimeZone timeZone2, Locale locale2, Date date) {
        int i;
        this.pattern = str;
        this.timeZone = timeZone2;
        this.locale = locale2;
        Calendar instance = Calendar.getInstance(timeZone2, locale2);
        if (date != null) {
            instance.setTime(date);
            i = instance.get(1);
        } else if (locale2.equals(JAPANESE_IMPERIAL)) {
            i = 0;
        } else {
            instance.setTime(new Date());
            i = instance.get(1) - 80;
        }
        int i2 = (i / 100) * 100;
        this.century = i2;
        this.startYear = i - i2;
        init(instance);
    }

    private void init(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Matcher matcher = formatPattern.matcher(this.pattern);
        if (matcher.lookingAt()) {
            String group = matcher.group();
            this.currentFormatField = group;
            Strategy strategy = getStrategy(group, calendar);
            while (true) {
                matcher.region(matcher.end(), matcher.regionEnd());
                if (!matcher.lookingAt()) {
                    break;
                }
                String group2 = matcher.group();
                this.nextStrategy = getStrategy(group2, calendar);
                if (strategy.addRegex(this, sb)) {
                    arrayList.add(strategy);
                }
                this.currentFormatField = group2;
                strategy = this.nextStrategy;
            }
            this.nextStrategy = null;
            if (matcher.regionStart() == matcher.regionEnd()) {
                if (strategy.addRegex(this, sb)) {
                    arrayList.add(strategy);
                }
                this.currentFormatField = null;
                this.strategies = (Strategy[]) arrayList.toArray(new Strategy[arrayList.size()]);
                this.parsePattern = Pattern.compile(sb.toString());
                return;
            }
            throw new IllegalArgumentException("Failed to parse \"" + this.pattern + "\" ; gave up at index " + matcher.regionStart());
        }
        throw new IllegalArgumentException("Illegal pattern character '" + this.pattern.charAt(matcher.regionStart()) + "'");
    }

    public String getPattern() {
        return this.pattern;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public Locale getLocale() {
        return this.locale;
    }

    /* access modifiers changed from: package-private */
    public Pattern getParsePattern() {
        return this.parsePattern;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        if (!this.pattern.equals(fastDateParser.pattern) || !this.timeZone.equals(fastDateParser.timeZone) || !this.locale.equals(fastDateParser.locale)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + Util.EVENT_ID_SEPARATOR + this.locale + Util.EVENT_ID_SEPARATOR + this.timeZone.getID() + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    public Date parse(String str) throws ParseException {
        Date parse = parse(str, new ParsePosition(0));
        if (parse != null) {
            return parse;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\n" + "Unparseable date: \"" + str + "\" does not match " + this.parsePattern.pattern(), 0);
        }
        throw new ParseException("Unparseable date: \"" + str + "\" does not match " + this.parsePattern.pattern(), 0);
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        Matcher matcher = this.parsePattern.matcher(str.substring(index));
        if (!matcher.lookingAt()) {
            return null;
        }
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        instance.clear();
        int i = 0;
        while (true) {
            Strategy[] strategyArr = this.strategies;
            if (i < strategyArr.length) {
                int i2 = i + 1;
                strategyArr[i].setCalendar(this, instance, matcher.group(i2));
                i = i2;
            } else {
                parsePosition.setIndex(index + matcher.end());
                return instance.getTime();
            }
        }
    }

    /* access modifiers changed from: private */
    public static StringBuilder escapeRegex(StringBuilder sb, String str, boolean z) {
        sb.append("\\Q");
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != '\'') {
                if (charAt == '\\' && (i = i + 1) != str.length()) {
                    sb.append(charAt);
                    charAt = str.charAt(i);
                    if (charAt == 'E') {
                        sb.append("E\\\\E\\");
                        charAt = 'Q';
                    }
                }
            } else if (!z) {
                continue;
            } else {
                i++;
                if (i == str.length()) {
                    return sb;
                }
                charAt = str.charAt(i);
            }
            sb.append(charAt);
            i++;
        }
        sb.append("\\E");
        return sb;
    }

    /* access modifiers changed from: private */
    public static Map<String, Integer> getDisplayNames(int i, Calendar calendar, Locale locale2) {
        return calendar.getDisplayNames(i, 0, locale2);
    }

    /* access modifiers changed from: private */
    public int adjustYear(int i) {
        int i2 = this.century + i;
        return i >= this.startYear ? i2 : i2 + 100;
    }

    /* access modifiers changed from: package-private */
    public boolean isNextNumber() {
        Strategy strategy = this.nextStrategy;
        return strategy != null && strategy.isNumber();
    }

    /* access modifiers changed from: package-private */
    public int getFieldWidth() {
        return this.currentFormatField.length();
    }

    private static abstract class Strategy {
        /* access modifiers changed from: package-private */
        public abstract boolean addRegex(FastDateParser fastDateParser, StringBuilder sb);

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
        }

        private Strategy() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0085, code lost:
        return new org.apache.commons.lang3.time.FastDateParser.CopyQuotedStrategy(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.lang3.time.FastDateParser.Strategy getStrategy(java.lang.String r5, java.util.Calendar r6) {
        /*
            r4 = this;
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 87
            if (r1 == r2) goto L_0x00a2
            r2 = 88
            if (r1 == r2) goto L_0x0099
            r2 = 121(0x79, float:1.7E-43)
            r3 = 2
            if (r1 == r2) goto L_0x008d
            r2 = 122(0x7a, float:1.71E-43)
            if (r1 == r2) goto L_0x0086
            switch(r1) {
                case 39: goto L_0x006a;
                case 75: goto L_0x0067;
                case 77: goto L_0x0058;
                case 83: goto L_0x0055;
                case 90: goto L_0x004a;
                case 97: goto L_0x0043;
                case 100: goto L_0x0040;
                case 104: goto L_0x003d;
                case 107: goto L_0x003a;
                case 109: goto L_0x0037;
                case 115: goto L_0x0034;
                case 119: goto L_0x0031;
                default: goto L_0x0019;
            }
        L_0x0019:
            switch(r1) {
                case 68: goto L_0x002e;
                case 69: goto L_0x0028;
                case 70: goto L_0x0025;
                case 71: goto L_0x0020;
                case 72: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0080
        L_0x001d:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = HOUR_OF_DAY_STRATEGY
            return r5
        L_0x0020:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = r4.getLocaleSpecificStrategy(r0, r6)
            return r5
        L_0x0025:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = DAY_OF_WEEK_IN_MONTH_STRATEGY
            return r5
        L_0x0028:
            r5 = 7
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = r4.getLocaleSpecificStrategy(r5, r6)
            return r5
        L_0x002e:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = DAY_OF_YEAR_STRATEGY
            return r5
        L_0x0031:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = WEEK_OF_YEAR_STRATEGY
            return r5
        L_0x0034:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = SECOND_STRATEGY
            return r5
        L_0x0037:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = MINUTE_STRATEGY
            return r5
        L_0x003a:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = HOUR24_OF_DAY_STRATEGY
            return r5
        L_0x003d:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = HOUR12_STRATEGY
            return r5
        L_0x0040:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = DAY_OF_MONTH_STRATEGY
            return r5
        L_0x0043:
            r5 = 9
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = r4.getLocaleSpecificStrategy(r5, r6)
            return r5
        L_0x004a:
            java.lang.String r0 = "ZZ"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0086
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = ISO_8601_STRATEGY
            return r5
        L_0x0055:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = MILLISECOND_STRATEGY
            return r5
        L_0x0058:
            int r5 = r5.length()
            r0 = 3
            if (r5 < r0) goto L_0x0064
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = r4.getLocaleSpecificStrategy(r3, r6)
            goto L_0x0066
        L_0x0064:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = NUMBER_MONTH_STRATEGY
        L_0x0066:
            return r5
        L_0x0067:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = HOUR_STRATEGY
            return r5
        L_0x006a:
            int r6 = r5.length()
            if (r6 <= r3) goto L_0x0080
            org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy r6 = new org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy
            int r0 = r5.length()
            r1 = 1
            int r0 = r0 - r1
            java.lang.String r5 = r5.substring(r1, r0)
            r6.<init>(r5)
            return r6
        L_0x0080:
            org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy r6 = new org.apache.commons.lang3.time.FastDateParser$CopyQuotedStrategy
            r6.<init>(r5)
            return r6
        L_0x0086:
            r5 = 15
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = r4.getLocaleSpecificStrategy(r5, r6)
            return r5
        L_0x008d:
            int r5 = r5.length()
            if (r5 <= r3) goto L_0x0096
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = LITERAL_YEAR_STRATEGY
            goto L_0x0098
        L_0x0096:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = ABBREVIATED_YEAR_STRATEGY
        L_0x0098:
            return r5
        L_0x0099:
            int r5 = r5.length()
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = org.apache.commons.lang3.time.FastDateParser.ISO8601TimeZoneStrategy.getStrategy(r5)
            return r5
        L_0x00a2:
            org.apache.commons.lang3.time.FastDateParser$Strategy r5 = WEEK_OF_MONTH_STRATEGY
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.FastDateParser.getStrategy(java.lang.String, java.util.Calendar):org.apache.commons.lang3.time.FastDateParser$Strategy");
    }

    private static ConcurrentMap<Locale, Strategy> getCache(int i) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        ConcurrentMap<Locale, Strategy>[] concurrentMapArr = caches;
        synchronized (concurrentMapArr) {
            if (concurrentMapArr[i] == null) {
                concurrentMapArr[i] = new ConcurrentHashMap(3);
            }
            concurrentMap = concurrentMapArr[i];
        }
        return concurrentMap;
    }

    private Strategy getLocaleSpecificStrategy(int i, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i);
        Strategy strategy = (Strategy) cache.get(this.locale);
        if (strategy == null) {
            strategy = i == 15 ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(i, calendar, this.locale);
            Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return strategy;
    }

    private static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            char charAt = this.formatField.charAt(0);
            if (charAt == '\'') {
                charAt = this.formatField.charAt(1);
            }
            return Character.isDigit(charAt);
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            StringBuilder unused = FastDateParser.escapeRegex(sb, this.formatField, true);
            return false;
        }
    }

    private static class CaseInsensitiveTextStrategy extends Strategy {
        private final int field;
        private final Map<String, Integer> lKeyValues = new HashMap();
        private final Locale locale;

        CaseInsensitiveTextStrategy(int i, Calendar calendar, Locale locale2) {
            super();
            this.field = i;
            this.locale = locale2;
            Map access$200 = FastDateParser.getDisplayNames(i, calendar, locale2);
            for (Map.Entry entry : access$200.entrySet()) {
                this.lKeyValues.put(((String) entry.getKey()).toLowerCase(locale2), entry.getValue());
            }
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append("((?iu)");
            for (String access$100 : this.lKeyValues.keySet()) {
                FastDateParser.escapeRegex(sb, access$100, false).append('|');
            }
            sb.setCharAt(sb.length() - 1, ')');
            return true;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            Integer num = this.lKeyValues.get(str.toLowerCase(this.locale));
            if (num == null) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(" not in (");
                for (String append : this.lKeyValues.keySet()) {
                    sb.append(append);
                    sb.append(' ');
                }
                sb.setCharAt(sb.length() - 1, ')');
                throw new IllegalArgumentException(sb.toString());
            }
            calendar.set(this.field, num.intValue());
        }
    }

    private static class NumberStrategy extends Strategy {
        private final int field;

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public int modify(int i) {
            return i;
        }

        NumberStrategy(int i) {
            super();
            this.field = i;
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            if (fastDateParser.isNextNumber()) {
                sb.append("(\\p{Nd}{");
                sb.append(fastDateParser.getFieldWidth());
                sb.append("}+)");
                return true;
            }
            sb.append("(\\p{Nd}++)");
            return true;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.set(this.field, modify(Integer.parseInt(str)));
        }
    }

    private static class TimeZoneStrategy extends Strategy {

        /* renamed from: ID */
        private static final int f477ID = 0;
        private static final int LONG_DST = 3;
        private static final int LONG_STD = 1;
        private static final int SHORT_DST = 4;
        private static final int SHORT_STD = 2;
        private final SortedMap<String, TimeZone> tzNames = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        private final String validTimeZoneChars;

        TimeZoneStrategy(Locale locale) {
            super();
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                if (!strArr[0].startsWith("GMT")) {
                    TimeZone timeZone = TimeZone.getTimeZone(strArr[0]);
                    if (!this.tzNames.containsKey(strArr[1])) {
                        this.tzNames.put(strArr[1], timeZone);
                    }
                    if (!this.tzNames.containsKey(strArr[2])) {
                        this.tzNames.put(strArr[2], timeZone);
                    }
                    if (timeZone.useDaylightTime()) {
                        if (!this.tzNames.containsKey(strArr[3])) {
                            this.tzNames.put(strArr[3], timeZone);
                        }
                        if (!this.tzNames.containsKey(strArr[4])) {
                            this.tzNames.put(strArr[4], timeZone);
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(GMT[+-]\\d{1,2}:\\d{2}");
            sb.append('|');
            sb.append("[+-]\\d{4}");
            sb.append('|');
            for (String access$100 : this.tzNames.keySet()) {
                FastDateParser.escapeRegex(sb, access$100, false).append('|');
            }
            sb.setCharAt(sb.length() - 1, ')');
            this.validTimeZoneChars = sb.toString();
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append(this.validTimeZoneChars);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone timeZone;
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                timeZone = TimeZone.getTimeZone("GMT" + str);
            } else if (str.startsWith("GMT")) {
                timeZone = TimeZone.getTimeZone(str);
            } else {
                timeZone = (TimeZone) this.tzNames.get(str);
                if (timeZone == null) {
                    throw new IllegalArgumentException(str + " is not a supported timezone name");
                }
            }
            calendar.setTimeZone(timeZone);
        }
    }

    private static class ISO8601TimeZoneStrategy extends Strategy {
        private static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
        private static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
        private static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");
        private final String pattern;

        ISO8601TimeZoneStrategy(String str) {
            super();
            this.pattern = str;
        }

        /* access modifiers changed from: package-private */
        public boolean addRegex(FastDateParser fastDateParser, StringBuilder sb) {
            sb.append(this.pattern);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            if (str.equals("Z")) {
                calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
                return;
            }
            calendar.setTimeZone(TimeZone.getTimeZone("GMT" + str));
        }

        static Strategy getStrategy(int i) {
            if (i == 1) {
                return ISO_8601_1_STRATEGY;
            }
            if (i == 2) {
                return ISO_8601_2_STRATEGY;
            }
            if (i == 3) {
                return ISO_8601_3_STRATEGY;
            }
            throw new IllegalArgumentException("invalid number of X");
        }
    }
}
