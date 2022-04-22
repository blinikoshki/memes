package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    private enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return isSameDay(instance, instance2);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date != null && date2 != null) {
            return date.getTime() == date2.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.getTime().getTime() == calendar2.getTime().getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, (Locale) null, strArr);
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, (Locale) null, strArr);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, (Locale) null, strArr, false);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        SimpleDateFormat simpleDateFormat;
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        if (locale == null) {
            simpleDateFormat = new SimpleDateFormat();
        } else {
            simpleDateFormat = new SimpleDateFormat("", locale);
        }
        simpleDateFormat.setLenient(z);
        ParsePosition parsePosition = new ParsePosition(0);
        for (String str2 : strArr) {
            simpleDateFormat.applyPattern(str2.endsWith("ZZ") ? str2.substring(0, str2.length() - 1) : str2);
            parsePosition.setIndex(0);
            String replaceAll = str2.endsWith("ZZ") ? str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2") : str;
            Date parse = simpleDateFormat.parse(replaceAll, parsePosition);
            if (parse != null && parsePosition.getIndex() == replaceAll.length()) {
                return parse;
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Date addYears(Date date, int i) {
        return add(date, 1, i);
    }

    public static Date addMonths(Date date, int i) {
        return add(date, 2, i);
    }

    public static Date addWeeks(Date date, int i) {
        return add(date, 3, i);
    }

    public static Date addDays(Date date, int i) {
        return add(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return add(date, 11, i);
    }

    public static Date addMinutes(Date date, int i) {
        return add(date, 12, i);
    }

    public static Date addSeconds(Date date, int i) {
        return add(date, 13, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return add(date, 14, i);
    }

    private static Date add(Date date, int i, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(i, i2);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date setYears(Date date, int i) {
        return set(date, 1, i);
    }

    public static Date setMonths(Date date, int i) {
        return set(date, 2, i);
    }

    public static Date setDays(Date date, int i) {
        return set(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return set(date, 11, i);
    }

    public static Date setMinutes(Date date, int i) {
        return set(date, 12, i);
    }

    public static Date setSeconds(Date date, int i) {
        return set(date, 13, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return set(date, 14, i);
    }

    private static Date set(Date date, int i, int i2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setLenient(false);
            instance.setTime(date);
            instance.set(i, i2);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar toCalendar(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public static Date round(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i, ModifyType.ROUND);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.ROUND);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return round((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
    }

    public static Date truncate(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i, ModifyType.TRUNCATE);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.TRUNCATE);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return truncate((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
    }

    public static Date ceiling(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            modify(instance, i, ModifyType.CEILING);
            return instance.getTime();
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar ceiling(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.CEILING);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date ceiling(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return ceiling((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0138 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void modify(java.util.Calendar r16, int r17, org.apache.commons.lang3.time.DateUtils.ModifyType r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 1
            int r4 = r0.get(r3)
            r5 = 280000000(0x10b07600, float:6.960157E-29)
            if (r4 > r5) goto L_0x015b
            r4 = 14
            if (r1 != r4) goto L_0x0015
            return
        L_0x0015:
            java.util.Date r5 = r16.getTime()
            long r6 = r5.getTime()
            int r4 = r0.get(r4)
            org.apache.commons.lang3.time.DateUtils$ModifyType r8 = org.apache.commons.lang3.time.DateUtils.ModifyType.TRUNCATE
            if (r8 == r2) goto L_0x0029
            r8 = 500(0x1f4, float:7.0E-43)
            if (r4 >= r8) goto L_0x002b
        L_0x0029:
            long r8 = (long) r4
            long r6 = r6 - r8
        L_0x002b:
            r4 = 13
            if (r1 != r4) goto L_0x0031
            r9 = 1
            goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            int r4 = r0.get(r4)
            r10 = 30
            if (r9 != 0) goto L_0x0046
            org.apache.commons.lang3.time.DateUtils$ModifyType r11 = org.apache.commons.lang3.time.DateUtils.ModifyType.TRUNCATE
            if (r11 == r2) goto L_0x0040
            if (r4 >= r10) goto L_0x0046
        L_0x0040:
            long r11 = (long) r4
            r13 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r13
            long r6 = r6 - r11
        L_0x0046:
            r4 = 12
            if (r1 != r4) goto L_0x004b
            r9 = 1
        L_0x004b:
            int r11 = r0.get(r4)
            if (r9 != 0) goto L_0x005e
            org.apache.commons.lang3.time.DateUtils$ModifyType r9 = org.apache.commons.lang3.time.DateUtils.ModifyType.TRUNCATE
            if (r9 == r2) goto L_0x0057
            if (r11 >= r10) goto L_0x005e
        L_0x0057:
            long r9 = (long) r11
            r11 = 60000(0xea60, double:2.9644E-319)
            long r9 = r9 * r11
            long r6 = r6 - r9
        L_0x005e:
            long r9 = r5.getTime()
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x006c
            r5.setTime(r6)
            r0.setTime(r5)
        L_0x006c:
            int[][] r5 = fields
            int r6 = r5.length
            r7 = 0
            r9 = 0
        L_0x0071:
            if (r7 >= r6) goto L_0x013f
            r10 = r5[r7]
            int r11 = r10.length
            r12 = 0
        L_0x0077:
            r13 = 15
            r14 = 2
            r15 = 1001(0x3e9, float:1.403E-42)
            r4 = 5
            if (r12 >= r11) goto L_0x00ca
            r8 = r10[r12]
            if (r8 != r1) goto L_0x00c4
            org.apache.commons.lang3.time.DateUtils$ModifyType r5 = org.apache.commons.lang3.time.DateUtils.ModifyType.CEILING
            if (r2 == r5) goto L_0x008d
            org.apache.commons.lang3.time.DateUtils$ModifyType r5 = org.apache.commons.lang3.time.DateUtils.ModifyType.ROUND
            if (r2 != r5) goto L_0x00c3
            if (r9 == 0) goto L_0x00c3
        L_0x008d:
            if (r1 != r15) goto L_0x00a2
            int r1 = r0.get(r4)
            if (r1 != r3) goto L_0x0099
            r0.add(r4, r13)
            goto L_0x00c3
        L_0x0099:
            r1 = -15
            r0.add(r4, r1)
            r0.add(r14, r3)
            goto L_0x00c3
        L_0x00a2:
            r2 = 9
            if (r1 != r2) goto L_0x00bd
            r1 = 11
            int r2 = r0.get(r1)
            if (r2 != 0) goto L_0x00b4
            r2 = 12
            r0.add(r1, r2)
            goto L_0x00c3
        L_0x00b4:
            r2 = -12
            r0.add(r1, r2)
            r0.add(r4, r3)
            goto L_0x00c3
        L_0x00bd:
            r8 = 0
            r1 = r10[r8]
            r0.add(r1, r3)
        L_0x00c3:
            return
        L_0x00c4:
            r8 = 0
            int r12 = r12 + 1
            r4 = 12
            goto L_0x0077
        L_0x00ca:
            r8 = 0
            r11 = 9
            if (r1 == r11) goto L_0x00eb
            if (r1 == r15) goto L_0x00d4
        L_0x00d1:
            r8 = 12
            goto L_0x0106
        L_0x00d4:
            r11 = r10[r8]
            if (r11 != r4) goto L_0x00d1
            int r4 = r0.get(r4)
            int r4 = r4 - r3
            if (r4 < r13) goto L_0x00e1
            int r4 = r4 + -15
        L_0x00e1:
            r8 = 7
            if (r4 <= r8) goto L_0x00e6
            r9 = 1
            goto L_0x00e7
        L_0x00e6:
            r9 = 0
        L_0x00e7:
            r11 = r9
            r8 = 12
            goto L_0x0103
        L_0x00eb:
            r4 = 0
            r8 = r10[r4]
            r4 = 11
            if (r8 != r4) goto L_0x00d1
            int r4 = r0.get(r4)
            r8 = 12
            if (r4 < r8) goto L_0x00fc
            int r4 = r4 + -12
        L_0x00fc:
            r9 = 6
            if (r4 < r9) goto L_0x0101
            r9 = 1
            goto L_0x0102
        L_0x0101:
            r9 = 0
        L_0x0102:
            r11 = r9
        L_0x0103:
            r9 = r4
            r4 = 1
            goto L_0x0109
        L_0x0106:
            r11 = r9
            r4 = 0
            r9 = 0
        L_0x0109:
            if (r4 != 0) goto L_0x0129
            r4 = 0
            r9 = r10[r4]
            int r9 = r0.getActualMinimum(r9)
            r11 = r10[r4]
            int r11 = r0.getActualMaximum(r11)
            r12 = r10[r4]
            int r12 = r0.get(r12)
            int r12 = r12 - r9
            int r11 = r11 - r9
            int r11 = r11 / r14
            if (r12 <= r11) goto L_0x0125
            r9 = 1
            goto L_0x0126
        L_0x0125:
            r9 = 0
        L_0x0126:
            r11 = r9
            r9 = r12
            goto L_0x012a
        L_0x0129:
            r4 = 0
        L_0x012a:
            if (r9 == 0) goto L_0x0138
            r12 = r10[r4]
            r10 = r10[r4]
            int r10 = r0.get(r10)
            int r10 = r10 - r9
            r0.set(r12, r10)
        L_0x0138:
            int r7 = r7 + 1
            r9 = r11
            r4 = 12
            goto L_0x0071
        L_0x013f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The field "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " is not supported"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x015b:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Calendar value too large for accurate calculations"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.modify(java.util.Calendar, int, org.apache.commons.lang3.time.DateUtils$ModifyType):void");
    }

    public static Iterator<Calendar> iterator(Date date, int i) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return iterator(instance, i);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Iterator<java.util.Calendar> iterator(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L_0x0092
            r0 = -1
            r1 = 2
            r2 = 5
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L_0x0041;
                case 2: goto L_0x0041;
                case 3: goto L_0x0041;
                case 4: goto L_0x0041;
                case 5: goto L_0x0026;
                case 6: goto L_0x0026;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The range style "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " is not valid."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.<init>(r9)
            throw r8
        L_0x0026:
            java.util.Calendar r8 = truncate((java.util.Calendar) r8, (int) r1)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r1, r3)
            r5.add(r2, r0)
            r6 = 6
            if (r9 != r6) goto L_0x003c
            r6 = r5
            r5 = r8
            goto L_0x0067
        L_0x003c:
            r6 = r5
            r1 = 1
            r5 = r8
            r8 = 7
            goto L_0x0068
        L_0x0041:
            java.util.Calendar r5 = truncate((java.util.Calendar) r8, (int) r2)
            java.util.Calendar r6 = truncate((java.util.Calendar) r8, (int) r2)
            if (r9 == r1) goto L_0x0067
            r1 = 3
            if (r9 == r1) goto L_0x0060
            r7 = 4
            if (r9 == r7) goto L_0x0054
            r8 = 7
            r1 = 1
            goto L_0x0068
        L_0x0054:
            int r9 = r8.get(r4)
            int r9 = r9 - r1
            int r8 = r8.get(r4)
            int r8 = r8 + r1
            r1 = r9
            goto L_0x0068
        L_0x0060:
            int r1 = r8.get(r4)
            int r8 = r1 + -1
            goto L_0x0068
        L_0x0067:
            r8 = 1
        L_0x0068:
            if (r1 >= r3) goto L_0x006c
            int r1 = r1 + 7
        L_0x006c:
            if (r1 <= r4) goto L_0x0070
            int r1 = r1 + -7
        L_0x0070:
            if (r8 >= r3) goto L_0x0074
            int r8 = r8 + 7
        L_0x0074:
            if (r8 <= r4) goto L_0x0078
            int r8 = r8 + -7
        L_0x0078:
            int r9 = r5.get(r4)
            if (r9 == r1) goto L_0x0082
            r5.add(r2, r0)
            goto L_0x0078
        L_0x0082:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L_0x008c
            r6.add(r2, r3)
            goto L_0x0082
        L_0x008c:
            org.apache.commons.lang3.time.DateUtils$DateIterator r8 = new org.apache.commons.lang3.time.DateUtils$DateIterator
            r8.<init>(r5, r6)
            return r8
        L_0x0092:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "The date must not be null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.iterator(java.util.Calendar, int):java.util.Iterator");
    }

    public static Iterator<?> iterator(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return iterator((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.SECONDS);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return getFragment(date, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInHours(Date date, int i) {
        return getFragment(date, i, TimeUnit.HOURS);
    }

    public static long getFragmentInDays(Date date, int i) {
        return getFragment(date, i, TimeUnit.DAYS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.SECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.HOURS);
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.DAYS);
    }

    private static long getFragment(Date date, int i, TimeUnit timeUnit) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            return getFragment(instance, i, timeUnit);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    private static long getFragment(Calendar calendar, int i, TimeUnit timeUnit) {
        long j;
        if (calendar != null) {
            long j2 = 0;
            int i2 = timeUnit == TimeUnit.DAYS ? 0 : 1;
            if (i != 1) {
                if (i == 2) {
                    j = timeUnit.convert((long) (calendar.get(5) - i2), TimeUnit.DAYS);
                }
                if (i != 1 || i == 2 || i == 5 || i == 6) {
                    j2 += timeUnit.convert((long) calendar.get(11), TimeUnit.HOURS);
                } else {
                    switch (i) {
                        case 11:
                            break;
                        case 12:
                            break;
                        case 13:
                            break;
                        case 14:
                            return j2;
                        default:
                            throw new IllegalArgumentException("The fragment " + i + " is not supported");
                    }
                }
                j2 += timeUnit.convert((long) calendar.get(12), TimeUnit.MINUTES);
                j2 += timeUnit.convert((long) calendar.get(13), TimeUnit.SECONDS);
                return j2 + timeUnit.convert((long) calendar.get(14), TimeUnit.MILLISECONDS);
            }
            j = timeUnit.convert((long) (calendar.get(6) - i2), TimeUnit.DAYS);
            j2 = 0 + j;
            if (i != 1) {
            }
            j2 += timeUnit.convert((long) calendar.get(11), TimeUnit.HOURS);
            j2 += timeUnit.convert((long) calendar.get(12), TimeUnit.MINUTES);
            j2 += timeUnit.convert((long) calendar.get(13), TimeUnit.SECONDS);
            return j2 + timeUnit.convert((long) calendar.get(14), TimeUnit.MILLISECONDS);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i) {
        return truncatedCompareTo(calendar, calendar2, i) == 0;
    }

    public static boolean truncatedEquals(Date date, Date date2, int i) {
        return truncatedCompareTo(date, date2, i) == 0;
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i) {
        return truncate(calendar, i).compareTo(truncate(calendar2, i));
    }

    public static int truncatedCompareTo(Date date, Date date2, int i) {
        return truncate(date, i).compareTo(truncate(date2, i));
    }

    static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        public Calendar next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return (Calendar) this.spot.clone();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
