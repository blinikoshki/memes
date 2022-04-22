package com.facebook.common.util;

import org.apache.commons.lang3.StringUtils;

public class Hex {
    private static final byte[] DIGITS = new byte[103];
    private static final char[] FIRST_CHAR = new char[256];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] SECOND_CHAR = new char[256];

    static {
        for (int i = 0; i < 256; i++) {
            char[] cArr = FIRST_CHAR;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(i >> 4) & 15];
            SECOND_CHAR[i] = cArr2[i & 15];
        }
        for (int i2 = 0; i2 <= 70; i2++) {
            DIGITS[i2] = -1;
        }
        for (byte b = 0; b < 10; b = (byte) (b + 1)) {
            DIGITS[b + 48] = b;
        }
        for (byte b2 = 0; b2 < 6; b2 = (byte) (b2 + 1)) {
            byte[] bArr = DIGITS;
            byte b3 = (byte) (b2 + 10);
            bArr[b2 + 65] = b3;
            bArr[b2 + 97] = b3;
        }
    }

    public static String byte2Hex(int i) {
        if (i > 255 || i < 0) {
            throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
        }
        return String.valueOf(FIRST_CHAR[i]) + String.valueOf(SECOND_CHAR[i]);
    }

    public static String encodeHex(byte[] bArr, boolean z) {
        byte b;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length && ((b = bArr[i] & 255) != 0 || !z)) {
            int i3 = i2 + 1;
            cArr[i2] = FIRST_CHAR[b];
            i2 = i3 + 1;
            cArr[i3] = SECOND_CHAR[b];
            i++;
        }
        return new String(cArr, 0, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r8 = DIGITS;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decodeHex(java.lang.String r11) {
        /*
            int r0 = r11.length()
            r1 = r0 & 1
            if (r1 != 0) goto L_0x0057
            int r1 = r0 >> 1
            byte[] r1 = new byte[r1]
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x000f:
            r5 = 1
            if (r3 >= r0) goto L_0x003d
            int r6 = r3 + 1
            char r3 = r11.charAt(r3)
            r7 = 102(0x66, float:1.43E-43)
            if (r3 <= r7) goto L_0x001e
        L_0x001c:
            r2 = 1
            goto L_0x003d
        L_0x001e:
            byte[] r8 = DIGITS
            byte r3 = r8[r3]
            r9 = -1
            if (r3 != r9) goto L_0x0026
            goto L_0x001c
        L_0x0026:
            int r10 = r6 + 1
            char r6 = r11.charAt(r6)
            if (r6 <= r7) goto L_0x002f
            goto L_0x001c
        L_0x002f:
            byte r6 = r8[r6]
            if (r6 != r9) goto L_0x0034
            goto L_0x001c
        L_0x0034:
            int r3 = r3 << 4
            r3 = r3 | r6
            byte r3 = (byte) r3
            r1[r4] = r3
            int r4 = r4 + r5
            r3 = r10
            goto L_0x000f
        L_0x003d:
            if (r2 != 0) goto L_0x0040
            return r1
        L_0x0040:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid hexadecimal digit: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        L_0x0057:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Odd number of characters."
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.util.Hex.decodeHex(java.lang.String):byte[]");
    }

    public static byte[] hexStringToByteArray(String str) {
        return decodeHex(str.replaceAll(StringUtils.SPACE, ""));
    }
}
