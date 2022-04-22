package org.threeten.p022bp.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.p022bp.temporal.ChronoField;
import org.threeten.p022bp.temporal.IsoFields;
import org.threeten.p022bp.temporal.TemporalField;

/* renamed from: org.threeten.bp.format.SimpleDateTimeTextProvider */
final class SimpleDateTimeTextProvider extends DateTimeTextProvider {
    /* access modifiers changed from: private */
    public static final Comparator<Map.Entry<String, Long>> COMPARATOR = new Comparator<Map.Entry<String, Long>>() {
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            return entry2.getKey().length() - entry.getKey().length();
        }
    };
    private final ConcurrentMap<Map.Entry<TemporalField, Locale>, Object> cache = new ConcurrentHashMap(16, 0.75f, 2);

    SimpleDateTimeTextProvider() {
    }

    public String getText(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
        Object findStore = findStore(temporalField, locale);
        if (findStore instanceof LocaleStore) {
            return ((LocaleStore) findStore).getText(j, textStyle);
        }
        return null;
    }

    public Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale) {
        Object findStore = findStore(temporalField, locale);
        if (findStore instanceof LocaleStore) {
            return ((LocaleStore) findStore).getTextIterator(textStyle);
        }
        return null;
    }

    private Object findStore(TemporalField temporalField, Locale locale) {
        Map.Entry createEntry = createEntry(temporalField, locale);
        Object obj = this.cache.get(createEntry);
        if (obj != null) {
            return obj;
        }
        this.cache.putIfAbsent(createEntry, createStore(temporalField, locale));
        return this.cache.get(createEntry);
    }

    private Object createStore(TemporalField temporalField, Locale locale) {
        TemporalField temporalField2 = temporalField;
        Locale locale2 = locale;
        if (temporalField2 == ChronoField.MONTH_OF_YEAR) {
            DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
            HashMap hashMap = new HashMap();
            String[] months = instance.getMonths();
            DateFormatSymbols dateFormatSymbols = instance;
            HashMap hashMap2 = new HashMap();
            hashMap2.put(1L, months[0]);
            hashMap2.put(2L, months[1]);
            hashMap2.put(3L, months[2]);
            hashMap2.put(4L, months[3]);
            hashMap2.put(5L, months[4]);
            hashMap2.put(6L, months[5]);
            hashMap2.put(7L, months[6]);
            hashMap2.put(8L, months[7]);
            hashMap2.put(9L, months[8]);
            hashMap2.put(10L, months[9]);
            hashMap2.put(11L, months[10]);
            hashMap2.put(12L, months[11]);
            hashMap.put(TextStyle.FULL, hashMap2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(1, narrowMonth(1, months[0], locale2));
            hashMap3.put(2L, narrowMonth(2, months[1], locale2));
            hashMap3.put(3L, narrowMonth(3, months[2], locale2));
            hashMap3.put(4L, narrowMonth(4, months[3], locale2));
            hashMap3.put(5L, narrowMonth(5, months[4], locale2));
            hashMap3.put(6L, narrowMonth(6, months[5], locale2));
            hashMap3.put(7L, narrowMonth(7, months[6], locale2));
            hashMap3.put(8L, narrowMonth(8, months[7], locale2));
            hashMap3.put(9L, narrowMonth(9, months[8], locale2));
            hashMap3.put(10L, narrowMonth(10, months[9], locale2));
            hashMap3.put(11L, narrowMonth(11, months[10], locale2));
            hashMap3.put(12, narrowMonth(12, months[11], locale2));
            HashMap hashMap4 = hashMap;
            hashMap4.put(TextStyle.NARROW, hashMap3);
            String[] shortMonths = dateFormatSymbols.getShortMonths();
            HashMap hashMap5 = new HashMap();
            hashMap5.put(1, shortMonths[0]);
            hashMap5.put(2L, shortMonths[1]);
            hashMap5.put(3L, shortMonths[2]);
            hashMap5.put(4L, shortMonths[3]);
            hashMap5.put(5L, shortMonths[4]);
            hashMap5.put(6L, shortMonths[5]);
            hashMap5.put(7L, shortMonths[6]);
            hashMap5.put(8L, shortMonths[7]);
            hashMap5.put(9L, shortMonths[8]);
            hashMap5.put(10L, shortMonths[9]);
            hashMap5.put(11, shortMonths[10]);
            hashMap5.put(12, shortMonths[11]);
            hashMap4.put(TextStyle.SHORT, hashMap5);
            return createLocaleStore(hashMap4);
        } else if (temporalField2 == ChronoField.DAY_OF_WEEK) {
            DateFormatSymbols instance2 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap6 = new HashMap();
            String[] weekdays = instance2.getWeekdays();
            HashMap hashMap7 = new HashMap();
            hashMap7.put(1, weekdays[2]);
            hashMap7.put(2L, weekdays[3]);
            hashMap7.put(3L, weekdays[4]);
            hashMap7.put(4L, weekdays[5]);
            hashMap7.put(5L, weekdays[6]);
            hashMap7.put(6L, weekdays[7]);
            hashMap7.put(7L, weekdays[1]);
            hashMap6.put(TextStyle.FULL, hashMap7);
            HashMap hashMap8 = new HashMap();
            hashMap8.put(1, narrowDayOfWeek(1, weekdays[2], locale2));
            hashMap8.put(2L, narrowDayOfWeek(2, weekdays[3], locale2));
            hashMap8.put(3L, narrowDayOfWeek(3, weekdays[4], locale2));
            hashMap8.put(4L, narrowDayOfWeek(4, weekdays[5], locale2));
            hashMap8.put(5L, narrowDayOfWeek(5, weekdays[6], locale2));
            hashMap8.put(6L, narrowDayOfWeek(6, weekdays[7], locale2));
            hashMap8.put(7L, narrowDayOfWeek(7, weekdays[1], locale2));
            hashMap6.put(TextStyle.NARROW, hashMap8);
            String[] shortWeekdays = instance2.getShortWeekdays();
            HashMap hashMap9 = new HashMap();
            hashMap9.put(1, shortWeekdays[2]);
            hashMap9.put(2L, shortWeekdays[3]);
            hashMap9.put(3L, shortWeekdays[4]);
            hashMap9.put(4L, shortWeekdays[5]);
            hashMap9.put(5L, shortWeekdays[6]);
            hashMap9.put(6L, shortWeekdays[7]);
            hashMap9.put(7L, shortWeekdays[1]);
            hashMap6.put(TextStyle.SHORT, hashMap9);
            return createLocaleStore(hashMap6);
        } else if (temporalField2 == ChronoField.AMPM_OF_DAY) {
            DateFormatSymbols instance3 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap10 = new HashMap();
            String[] amPmStrings = instance3.getAmPmStrings();
            HashMap hashMap11 = new HashMap();
            hashMap11.put(0L, amPmStrings[0]);
            hashMap11.put(1, amPmStrings[1]);
            hashMap10.put(TextStyle.FULL, hashMap11);
            hashMap10.put(TextStyle.SHORT, hashMap11);
            return createLocaleStore(hashMap10);
        } else if (temporalField2 == ChronoField.ERA) {
            DateFormatSymbols instance4 = DateFormatSymbols.getInstance(locale);
            HashMap hashMap12 = new HashMap();
            String[] eras = instance4.getEras();
            HashMap hashMap13 = new HashMap();
            hashMap13.put(0L, eras[0]);
            hashMap13.put(1, eras[1]);
            hashMap12.put(TextStyle.SHORT, hashMap13);
            if (locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
                HashMap hashMap14 = new HashMap();
                hashMap14.put(0L, "Before Christ");
                hashMap14.put(1, "Anno Domini");
                hashMap12.put(TextStyle.FULL, hashMap14);
            } else {
                hashMap12.put(TextStyle.FULL, hashMap13);
            }
            HashMap hashMap15 = new HashMap();
            hashMap15.put(0L, eras[0].substring(0, 1));
            hashMap15.put(1, eras[1].substring(0, 1));
            hashMap12.put(TextStyle.NARROW, hashMap15);
            return createLocaleStore(hashMap12);
        } else if (temporalField2 != IsoFields.QUARTER_OF_YEAR) {
            return "";
        } else {
            HashMap hashMap16 = new HashMap();
            HashMap hashMap17 = new HashMap();
            hashMap17.put(1, "Q1");
            hashMap17.put(2L, "Q2");
            hashMap17.put(3L, "Q3");
            hashMap17.put(4L, "Q4");
            hashMap16.put(TextStyle.SHORT, hashMap17);
            HashMap hashMap18 = new HashMap();
            hashMap18.put(1, "1st quarter");
            hashMap18.put(2L, "2nd quarter");
            hashMap18.put(3L, "3rd quarter");
            hashMap18.put(4L, "4th quarter");
            hashMap16.put(TextStyle.FULL, hashMap18);
            return createLocaleStore(hashMap16);
        }
    }

    private String narrowMonth(int i, String str, Locale locale) {
        if (locale.getLanguage().equals("zh") && locale.getCountry().equals("CN")) {
            switch (i) {
                case 1:
                    return "一";
                case 2:
                    return "二";
                case 3:
                    return "三";
                case 4:
                    return "四";
                case 5:
                    return "五";
                case 6:
                    return "六";
                case 7:
                    return "七";
                case 8:
                    return "八";
                case 9:
                    return "九";
                case 10:
                    return "十";
                case 11:
                    return "十一";
                case 12:
                    return "十二";
            }
        }
        if (locale.getLanguage().equals("ar")) {
            switch (i) {
                case 1:
                    return "ي";
                case 2:
                    return "ف";
                case 3:
                    return "م";
                case 4:
                    return "أ";
                case 5:
                    return "و";
                case 6:
                    return "ن";
                case 7:
                    return "ل";
                case 8:
                    return "غ";
                case 9:
                    return "س";
                case 10:
                    return "ك";
                case 11:
                    return "ب";
                case 12:
                    return "د";
            }
        }
        if (!locale.getLanguage().equals("ja") || !locale.getCountry().equals("JP")) {
            return str.substring(0, 1);
        }
        return Integer.toString(i);
    }

    private String narrowDayOfWeek(int i, String str, Locale locale) {
        if (locale.getLanguage().equals("zh") && locale.getCountry().equals("CN")) {
            switch (i) {
                case 1:
                    return "一";
                case 2:
                    return "二";
                case 3:
                    return "三";
                case 4:
                    return "四";
                case 5:
                    return "五";
                case 6:
                    return "六";
                case 7:
                    return "日";
            }
        }
        if (locale.getLanguage().equals("ar")) {
            switch (i) {
                case 1:
                    return "ن";
                case 2:
                    return "ث";
                case 3:
                    return "ر";
                case 4:
                    return "خ";
                case 5:
                    return "ج";
                case 6:
                    return "س";
                case 7:
                    return "ح";
            }
        }
        return str.substring(0, 1);
    }

    /* access modifiers changed from: private */
    public static <A, B> Map.Entry<A, B> createEntry(A a, B b) {
        return new AbstractMap.SimpleImmutableEntry(a, b);
    }

    private static LocaleStore createLocaleStore(Map<TextStyle, Map<Long, String>> map) {
        map.put(TextStyle.FULL_STANDALONE, map.get(TextStyle.FULL));
        map.put(TextStyle.SHORT_STANDALONE, map.get(TextStyle.SHORT));
        if (map.containsKey(TextStyle.NARROW) && !map.containsKey(TextStyle.NARROW_STANDALONE)) {
            map.put(TextStyle.NARROW_STANDALONE, map.get(TextStyle.NARROW));
        }
        return new LocaleStore(map);
    }

    /* renamed from: org.threeten.bp.format.SimpleDateTimeTextProvider$LocaleStore */
    static final class LocaleStore {
        private final Map<TextStyle, List<Map.Entry<String, Long>>> parsable;
        private final Map<TextStyle, Map<Long, String>> valueTextMap;

        LocaleStore(Map<TextStyle, Map<Long, String>> map) {
            this.valueTextMap = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (TextStyle next : map.keySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry : map.get(next).entrySet()) {
                    Object put = hashMap2.put(entry.getValue(), SimpleDateTimeTextProvider.createEntry(entry.getValue(), entry.getKey()));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort(arrayList2, SimpleDateTimeTextProvider.COMPARATOR);
                hashMap.put(next, arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put((Object) null, arrayList);
            }
            Collections.sort(arrayList, SimpleDateTimeTextProvider.COMPARATOR);
            this.parsable = hashMap;
        }

        /* access modifiers changed from: package-private */
        public String getText(long j, TextStyle textStyle) {
            Map map = this.valueTextMap.get(textStyle);
            if (map != null) {
                return (String) map.get(Long.valueOf(j));
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<String, Long>> getTextIterator(TextStyle textStyle) {
            List list = this.parsable.get(textStyle);
            if (list != null) {
                return list.iterator();
            }
            return null;
        }
    }
}
