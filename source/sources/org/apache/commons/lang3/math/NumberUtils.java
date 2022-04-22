package org.apache.commons.lang3.math;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import editor.editor.equipment.core.CoreConfig;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_ZERO = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_ZERO = 0;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_ZERO = 0L;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_ZERO = 0;

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int compare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public static int compare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0);
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static short toShort(String str) {
        return toShort(str, 0);
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:(1:60)|61|(1:66)(1:65)|67|(5:69|(3:71|(2:73|(2:75|(1:77)))|(2:93|94)(3:87|88|89))|95|96|(1:102))|103|104|(1:110)|111|112|113) */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01be, code lost:
        throw new java.lang.NumberFormatException(r0 + " is not a valid number.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01de, code lost:
        return createLong(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01e3, code lost:
        return createBigInteger(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013d, code lost:
        if (r2 == 'l') goto L_0x013f;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x018f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x01a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:126:0x01da */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Number createNumber(java.lang.String r17) throws java.lang.NumberFormatException {
        /*
            r0 = r17
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r2 = org.apache.commons.lang3.StringUtils.isBlank(r17)
            if (r2 != 0) goto L_0x0226
            r2 = 6
            java.lang.String r3 = "0x"
            java.lang.String r4 = "0X"
            java.lang.String r5 = "-0x"
            java.lang.String r6 = "-0X"
            java.lang.String r7 = "#"
            java.lang.String r8 = "-#"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}
            r4 = 0
            r5 = 0
        L_0x001f:
            if (r5 >= r2) goto L_0x0032
            r6 = r3[r5]
            boolean r7 = r0.startsWith(r6)
            if (r7 == 0) goto L_0x002f
            int r2 = r6.length()
            int r2 = r2 + r4
            goto L_0x0033
        L_0x002f:
            int r5 = r5 + 1
            goto L_0x001f
        L_0x0032:
            r2 = 0
        L_0x0033:
            r3 = 16
            if (r2 <= 0) goto L_0x0071
            r1 = r2
        L_0x0038:
            int r5 = r17.length()
            if (r2 >= r5) goto L_0x004b
            char r4 = r0.charAt(r2)
            r5 = 48
            if (r4 != r5) goto L_0x004b
            int r1 = r1 + 1
            int r2 = r2 + 1
            goto L_0x0038
        L_0x004b:
            int r2 = r17.length()
            int r2 = r2 - r1
            if (r2 > r3) goto L_0x006c
            r1 = 55
            if (r2 != r3) goto L_0x0059
            if (r4 <= r1) goto L_0x0059
            goto L_0x006c
        L_0x0059:
            r3 = 8
            if (r2 > r3) goto L_0x0067
            if (r2 != r3) goto L_0x0062
            if (r4 <= r1) goto L_0x0062
            goto L_0x0067
        L_0x0062:
            java.lang.Integer r0 = createInteger(r17)
            return r0
        L_0x0067:
            java.lang.Long r0 = createLong(r17)
            return r0
        L_0x006c:
            java.math.BigInteger r0 = createBigInteger(r17)
            return r0
        L_0x0071:
            int r2 = r17.length()
            r5 = 1
            int r2 = r2 - r5
            char r2 = r0.charAt(r2)
            r6 = 46
            int r7 = r0.indexOf(r6)
            r8 = 101(0x65, float:1.42E-43)
            int r8 = r0.indexOf(r8)
            r9 = 69
            int r9 = r0.indexOf(r9)
            int r8 = r8 + r9
            int r8 = r8 + r5
            java.lang.String r9 = " is not a valid number."
            r10 = -1
            if (r7 <= r10) goto L_0x00c9
            if (r8 <= r10) goto L_0x00ba
            if (r8 < r7) goto L_0x00a5
            int r11 = r17.length()
            if (r8 > r11) goto L_0x00a5
            int r11 = r7 + 1
            java.lang.String r11 = r0.substring(r11, r8)
            goto L_0x00c0
        L_0x00a5:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00ba:
            int r11 = r7 + 1
            java.lang.String r11 = r0.substring(r11)
        L_0x00c0:
            java.lang.String r7 = getMantissa(r0, r7)
            int r12 = r11.length()
            goto L_0x00f1
        L_0x00c9:
            if (r8 <= r10) goto L_0x00eb
            int r7 = r17.length()
            if (r8 > r7) goto L_0x00d6
            java.lang.String r7 = getMantissa(r0, r8)
            goto L_0x00ef
        L_0x00d6:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00eb:
            java.lang.String r7 = getMantissa(r17)
        L_0x00ef:
            r11 = r1
            r12 = 0
        L_0x00f1:
            boolean r13 = java.lang.Character.isDigit(r2)
            r14 = 0
            r15 = 0
            if (r13 != 0) goto L_0x01bf
            if (r2 == r6) goto L_0x01bf
            if (r8 <= r10) goto L_0x010f
            int r3 = r17.length()
            int r3 = r3 - r5
            if (r8 >= r3) goto L_0x010f
            int r8 = r8 + r5
            int r1 = r17.length()
            int r1 = r1 - r5
            java.lang.String r1 = r0.substring(r8, r1)
        L_0x010f:
            int r3 = r17.length()
            int r3 = r3 - r5
            java.lang.String r3 = r0.substring(r4, r3)
            boolean r6 = isAllZeros(r7)
            if (r6 == 0) goto L_0x0126
            boolean r6 = isAllZeros(r1)
            if (r6 == 0) goto L_0x0126
            r6 = 1
            goto L_0x0127
        L_0x0126:
            r6 = 0
        L_0x0127:
            r7 = 68
            if (r2 == r7) goto L_0x018f
            r7 = 70
            if (r2 == r7) goto L_0x017a
            r7 = 76
            if (r2 == r7) goto L_0x013f
            r7 = 100
            if (r2 == r7) goto L_0x018f
            r7 = 102(0x66, float:1.43E-43)
            if (r2 == r7) goto L_0x017a
            r6 = 108(0x6c, float:1.51E-43)
            if (r2 != r6) goto L_0x01aa
        L_0x013f:
            if (r11 != 0) goto L_0x0165
            if (r1 != 0) goto L_0x0165
            char r1 = r3.charAt(r4)
            r2 = 45
            if (r1 != r2) goto L_0x0155
            java.lang.String r1 = r3.substring(r5)
            boolean r1 = isDigits(r1)
            if (r1 != 0) goto L_0x015b
        L_0x0155:
            boolean r1 = isDigits(r3)
            if (r1 == 0) goto L_0x0165
        L_0x015b:
            java.lang.Long r0 = createLong(r3)     // Catch:{ NumberFormatException -> 0x0160 }
            return r0
        L_0x0160:
            java.math.BigInteger r0 = createBigInteger(r3)
            return r0
        L_0x0165:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x017a:
            java.lang.Float r1 = createFloat(r3)     // Catch:{ NumberFormatException -> 0x018f }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x018f }
            if (r2 != 0) goto L_0x018f
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x018f }
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x018e
            if (r6 == 0) goto L_0x018f
        L_0x018e:
            return r1
        L_0x018f:
            java.lang.Double r1 = createDouble(r3)     // Catch:{ NumberFormatException -> 0x01a5 }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x01a5 }
            if (r2 != 0) goto L_0x01a5
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x01a5 }
            double r4 = (double) r2
            int r2 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x01a4
            if (r6 == 0) goto L_0x01a5
        L_0x01a4:
            return r1
        L_0x01a5:
            java.math.BigDecimal r0 = createBigDecimal(r3)     // Catch:{ NumberFormatException -> 0x01aa }
            return r0
        L_0x01aa:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01bf:
            if (r8 <= r10) goto L_0x01d1
            int r2 = r17.length()
            int r2 = r2 - r5
            if (r8 >= r2) goto L_0x01d1
            int r8 = r8 + r5
            int r1 = r17.length()
            java.lang.String r1 = r0.substring(r8, r1)
        L_0x01d1:
            if (r11 != 0) goto L_0x01e4
            if (r1 != 0) goto L_0x01e4
            java.lang.Integer r0 = createInteger(r17)     // Catch:{ NumberFormatException -> 0x01da }
            return r0
        L_0x01da:
            java.lang.Long r0 = createLong(r17)     // Catch:{ NumberFormatException -> 0x01df }
            return r0
        L_0x01df:
            java.math.BigInteger r0 = createBigInteger(r17)
            return r0
        L_0x01e4:
            boolean r2 = isAllZeros(r7)
            if (r2 == 0) goto L_0x01f1
            boolean r1 = isAllZeros(r1)
            if (r1 == 0) goto L_0x01f1
            r4 = 1
        L_0x01f1:
            r1 = 7
            if (r12 > r1) goto L_0x020a
            java.lang.Float r1 = createFloat(r17)     // Catch:{ NumberFormatException -> 0x0209 }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x0209 }
            if (r2 != 0) goto L_0x020a
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x0209 }
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x0208
            if (r4 == 0) goto L_0x020a
        L_0x0208:
            return r1
        L_0x0209:
        L_0x020a:
            if (r12 > r3) goto L_0x0221
            java.lang.Double r1 = createDouble(r17)     // Catch:{ NumberFormatException -> 0x0221 }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x0221 }
            if (r2 != 0) goto L_0x0221
            double r2 = r1.doubleValue()     // Catch:{ NumberFormatException -> 0x0221 }
            int r5 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r5 != 0) goto L_0x0220
            if (r4 == 0) goto L_0x0221
        L_0x0220:
            return r1
        L_0x0221:
            java.math.BigDecimal r0 = createBigDecimal(r17)
            return r0
        L_0x0226:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "A blank string is not a valid number"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static String getMantissa(String str, int i) {
        char charAt = str.charAt(0);
        return charAt == '-' || charAt == '+' ? str.substring(1, i) : str.substring(0, i);
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        if (str.length() > 0) {
            return true;
        }
        return false;
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.math.BigInteger createBigInteger(java.lang.String r5) {
        /*
            if (r5 != 0) goto L_0x0004
            r5 = 0
            return r5
        L_0x0004:
            r0 = 10
            java.lang.String r1 = "-"
            boolean r1 = r5.startsWith(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            java.lang.String r1 = "0x"
            boolean r1 = r5.startsWith(r1, r2)
            r4 = 16
            if (r1 != 0) goto L_0x0045
            java.lang.String r1 = "0X"
            boolean r1 = r5.startsWith(r1, r2)
            if (r1 == 0) goto L_0x0026
            goto L_0x0045
        L_0x0026:
            java.lang.String r1 = "#"
            boolean r1 = r5.startsWith(r1, r2)
            if (r1 == 0) goto L_0x0031
            int r2 = r2 + 1
            goto L_0x0047
        L_0x0031:
            java.lang.String r1 = "0"
            boolean r1 = r5.startsWith(r1, r2)
            if (r1 == 0) goto L_0x0049
            int r1 = r5.length()
            int r4 = r2 + 1
            if (r1 <= r4) goto L_0x0049
            r0 = 8
            r2 = r4
            goto L_0x0049
        L_0x0045:
            int r2 = r2 + 2
        L_0x0047:
            r0 = 16
        L_0x0049:
            java.math.BigInteger r1 = new java.math.BigInteger
            java.lang.String r5 = r5.substring(r2)
            r1.<init>(r5, r0)
            if (r3 == 0) goto L_0x0058
            java.math.BigInteger r1 = r1.negate()
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createBigInteger(java.lang.String):java.math.BigInteger");
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        } else if (!str.trim().startsWith("--")) {
            return new BigDecimal(str);
        } else {
            throw new NumberFormatException(str + " is not a valid number.");
        }
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] < j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] < s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] < b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] < d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] < f) {
                f = fArr[i];
            }
        }
        return f;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] > s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] > b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] > d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] > f) {
                f = fArr[i];
            }
        }
        return f;
    }

    private static void validateArray(Object obj) {
        if (obj != null) {
            Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
            return;
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0093, code lost:
        if (r3 >= r0.length) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0097, code lost:
        if (r0[r3] < '0') goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x009b, code lost:
        if (r0[r3] > '9') goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x009d, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a0, code lost:
        if (r0[r3] == 'e') goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00a4, code lost:
        if (r0[r3] != 'E') goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a9, code lost:
        if (r0[r3] != '.') goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ab, code lost:
        if (r13 != false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ad, code lost:
        if (r12 == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00b0, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00b1, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b2, code lost:
        if (r6 != false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00b8, code lost:
        if (r0[r3] == 'd') goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00be, code lost:
        if (r0[r3] == 'D') goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00c2, code lost:
        if (r0[r3] == 'f') goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00c8, code lost:
        if (r0[r3] != 'F') goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00ca, code lost:
        return r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00cf, code lost:
        if (r0[r3] == 'l') goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00d5, code lost:
        if (r0[r3] != 'L') goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00d8, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00d9, code lost:
        if (r11 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00db, code lost:
        if (r12 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00dd, code lost:
        if (r13 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00df, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x00e1, code lost:
        if (r6 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00e3, code lost:
        if (r11 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00e5, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNumber(java.lang.String r16) {
        /*
            boolean r0 = org.apache.commons.lang3.StringUtils.isEmpty(r16)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            char[] r0 = r16.toCharArray()
            int r2 = r0.length
            char r3 = r0[r1]
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L_0x0016
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            int r6 = r3 + 1
            r7 = 70
            r8 = 102(0x66, float:1.43E-43)
            r9 = 57
            r10 = 48
            if (r2 <= r6) goto L_0x0079
            char r11 = r0[r3]
            if (r11 != r10) goto L_0x0079
            char r11 = r0[r6]
            r12 = 120(0x78, float:1.68E-43)
            if (r11 == r12) goto L_0x004f
            char r11 = r0[r6]
            r12 = 88
            if (r11 != r12) goto L_0x0034
            goto L_0x004f
        L_0x0034:
            char r11 = r0[r6]
            boolean r11 = java.lang.Character.isDigit(r11)
            if (r11 == 0) goto L_0x0079
        L_0x003c:
            int r2 = r0.length
            if (r6 >= r2) goto L_0x004e
            char r2 = r0[r6]
            if (r2 < r10) goto L_0x004d
            char r2 = r0[r6]
            r3 = 55
            if (r2 <= r3) goto L_0x004a
            goto L_0x004d
        L_0x004a:
            int r6 = r6 + 1
            goto L_0x003c
        L_0x004d:
            return r1
        L_0x004e:
            return r5
        L_0x004f:
            int r3 = r3 + 2
            if (r3 != r2) goto L_0x0054
            return r1
        L_0x0054:
            int r2 = r0.length
            if (r3 >= r2) goto L_0x0078
            char r2 = r0[r3]
            if (r2 < r10) goto L_0x005f
            char r2 = r0[r3]
            if (r2 <= r9) goto L_0x0074
        L_0x005f:
            char r2 = r0[r3]
            r4 = 97
            if (r2 < r4) goto L_0x0069
            char r2 = r0[r3]
            if (r2 <= r8) goto L_0x0074
        L_0x0069:
            char r2 = r0[r3]
            r4 = 65
            if (r2 < r4) goto L_0x0077
            char r2 = r0[r3]
            if (r2 <= r7) goto L_0x0074
            goto L_0x0077
        L_0x0074:
            int r3 = r3 + 1
            goto L_0x0054
        L_0x0077:
            return r1
        L_0x0078:
            return r5
        L_0x0079:
            int r2 = r2 + -1
            r6 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x007f:
            r14 = 69
            r15 = 101(0x65, float:1.42E-43)
            r4 = 46
            if (r3 < r2) goto L_0x00e7
            int r7 = r2 + 1
            if (r3 >= r7) goto L_0x0092
            if (r6 == 0) goto L_0x0092
            if (r11 != 0) goto L_0x0092
            r7 = 70
            goto L_0x00e7
        L_0x0092:
            int r2 = r0.length
            if (r3 >= r2) goto L_0x00e1
            char r2 = r0[r3]
            if (r2 < r10) goto L_0x009e
            char r2 = r0[r3]
            if (r2 > r9) goto L_0x009e
            return r5
        L_0x009e:
            char r2 = r0[r3]
            if (r2 == r15) goto L_0x00e0
            char r2 = r0[r3]
            if (r2 != r14) goto L_0x00a7
            goto L_0x00e0
        L_0x00a7:
            char r2 = r0[r3]
            if (r2 != r4) goto L_0x00b2
            if (r13 != 0) goto L_0x00b1
            if (r12 == 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            return r11
        L_0x00b1:
            return r1
        L_0x00b2:
            if (r6 != 0) goto L_0x00cb
            char r2 = r0[r3]
            r4 = 100
            if (r2 == r4) goto L_0x00ca
            char r2 = r0[r3]
            r4 = 68
            if (r2 == r4) goto L_0x00ca
            char r2 = r0[r3]
            if (r2 == r8) goto L_0x00ca
            char r2 = r0[r3]
            r7 = 70
            if (r2 != r7) goto L_0x00cb
        L_0x00ca:
            return r11
        L_0x00cb:
            char r2 = r0[r3]
            r4 = 108(0x6c, float:1.51E-43)
            if (r2 == r4) goto L_0x00d9
            char r0 = r0[r3]
            r2 = 76
            if (r0 != r2) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            return r1
        L_0x00d9:
            if (r11 == 0) goto L_0x00e0
            if (r12 != 0) goto L_0x00e0
            if (r13 != 0) goto L_0x00e0
            r1 = 1
        L_0x00e0:
            return r1
        L_0x00e1:
            if (r6 != 0) goto L_0x00e6
            if (r11 == 0) goto L_0x00e6
            r1 = 1
        L_0x00e6:
            return r1
        L_0x00e7:
            char r5 = r0[r3]
            if (r5 < r10) goto L_0x00f4
            char r5 = r0[r3]
            if (r5 > r9) goto L_0x00f4
            r5 = 45
            r6 = 0
            r11 = 1
            goto L_0x012b
        L_0x00f4:
            char r5 = r0[r3]
            if (r5 != r4) goto L_0x0102
            if (r13 != 0) goto L_0x0101
            if (r12 == 0) goto L_0x00fd
            goto L_0x0101
        L_0x00fd:
            r5 = 45
            r13 = 1
            goto L_0x012b
        L_0x0101:
            return r1
        L_0x0102:
            char r4 = r0[r3]
            if (r4 == r15) goto L_0x0121
            char r4 = r0[r3]
            if (r4 != r14) goto L_0x010b
            goto L_0x0121
        L_0x010b:
            char r4 = r0[r3]
            r5 = 43
            if (r4 == r5) goto L_0x0119
            char r4 = r0[r3]
            r5 = 45
            if (r4 != r5) goto L_0x0118
            goto L_0x011b
        L_0x0118:
            return r1
        L_0x0119:
            r5 = 45
        L_0x011b:
            if (r6 != 0) goto L_0x011e
            return r1
        L_0x011e:
            r6 = 0
            r11 = 0
            goto L_0x012b
        L_0x0121:
            r5 = 45
            if (r12 == 0) goto L_0x0126
            return r1
        L_0x0126:
            if (r11 != 0) goto L_0x0129
            return r1
        L_0x0129:
            r6 = 1
            r12 = 1
        L_0x012b:
            int r3 = r3 + 1
            r4 = 45
            r5 = 1
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.isNumber(java.lang.String):boolean");
    }

    public static boolean isParsable(String str) {
        if (StringUtils.endsWith(str, ".")) {
            return false;
        }
        if (StringUtils.startsWith(str, CoreConfig.ENTITY_TOKEN_PREFIX)) {
            return isDigits(StringUtils.replaceOnce(str.substring(1), ".", ""));
        }
        return isDigits(StringUtils.replaceOnce(str, ".", ""));
    }
}
