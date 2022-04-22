package com.appsflyer.internal;

import com.google.common.base.Ascii;

/* renamed from: com.appsflyer.internal.ad */
public class C1049ad {
    static final int[] $$a = new int[256];
    static final byte[] $$b = new byte[256];
    static final int[] AFDateFormat = new int[256];
    private static int[] collectIntentsFromActivities = new int[10];
    static final int[] getDataFormatter = new int[256];
    static final byte[] valueOf = new byte[256];
    static final int[] values = new int[256];

    static {
        byte[] bArr;
        byte b;
        byte b2 = 1;
        byte b3 = 1;
        do {
            b2 = (byte) (((b2 & 128) != 0 ? Ascii.ESC : 0) ^ ((b2 << 1) ^ b2));
            byte b4 = (byte) (b3 ^ (b3 << 1));
            byte b5 = (byte) (b4 ^ (b4 << 2));
            byte b6 = (byte) (b5 ^ (b5 << 4));
            b3 = (byte) (b6 ^ ((b6 & 128) != 0 ? (byte) 9 : 0));
            bArr = $$b;
            b = b2 & 255;
            byte b7 = b3 & 255;
            bArr[b] = (byte) (((((b3 ^ 99) ^ ((b7 << 1) | (b7 >> 7))) ^ ((b7 << 2) | (b7 >> 6))) ^ ((b7 << 3) | (b7 >> 5))) ^ ((b7 >> 4) | (b7 << 4)));
        } while (b != 1);
        bArr[0] = 99;
        for (int i = 0; i < 256; i++) {
            byte b8 = $$b[i] & 255;
            valueOf[b8] = (byte) i;
            int i2 = i << 1;
            if (i2 >= 256) {
                i2 ^= 283;
            }
            int i3 = i2 << 1;
            if (i3 >= 256) {
                i3 ^= 283;
            }
            int i4 = i3 << 1;
            if (i4 >= 256) {
                i4 ^= 283;
            }
            int i5 = i4 ^ i;
            int i6 = ((i2 ^ (i3 ^ i4)) << 24) | (i5 << 16) | ((i5 ^ i3) << 8) | (i5 ^ i2);
            $$a[b8] = i6;
            AFDateFormat[b8] = (i6 >>> 8) | (i6 << 24);
            values[b8] = (i6 >>> 16) | (i6 << 16);
            getDataFormatter[b8] = (i6 << 8) | (i6 >>> 24);
        }
        collectIntentsFromActivities[0] = 16777216;
        int i7 = 1;
        for (int i8 = 1; i8 < 10; i8++) {
            i7 <<= 1;
            if (i7 >= 256) {
                i7 ^= 283;
            }
            collectIntentsFromActivities[i8] = i7 << 24;
        }
    }

    static int[] values(byte[] bArr, int i) throws IllegalArgumentException {
        if (bArr.length == 16) {
            int i2 = (i + 1) * 4;
            int[] iArr = new int[i2];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i4 < 4) {
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                byte b = (bArr[i5] << Ascii.CAN) | ((bArr[i6] & 255) << Ascii.DLE);
                int i8 = i7 + 1;
                iArr[i4] = b | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                i4++;
                i5 = i8 + 1;
            }
            int i9 = 0;
            int i10 = 4;
            while (i10 < i2) {
                int i11 = iArr[i10 - 1];
                if (i3 == 0) {
                    byte[] bArr2 = $$b;
                    i11 = ((bArr2[i11 >>> 24] & 255) | (((bArr2[(i11 >>> 16) & 255] << Ascii.CAN) | ((bArr2[(i11 >>> 8) & 255] & 255) << Ascii.DLE)) | ((bArr2[i11 & 255] & 255) << 8))) ^ collectIntentsFromActivities[i9];
                    i9++;
                    i3 = 4;
                }
                iArr[i10] = i11 ^ iArr[i10 - 4];
                i10++;
                i3--;
            }
            return iArr;
        }
        throw new IllegalArgumentException();
    }

    static int[] $$b(byte[] bArr, int i) throws IllegalArgumentException {
        int[] values2 = values(bArr, i);
        if (bArr.length == 16) {
            int i2 = 4;
            int[] iArr = new int[((i + 1) * 4)];
            int i3 = i * 4;
            int i4 = i3 + 1;
            iArr[0] = values2[i3];
            int i5 = i4 + 1;
            int i6 = values2[i4];
            int i7 = 1;
            iArr[1] = i6;
            int i8 = i5 + 1;
            iArr[2] = values2[i5];
            iArr[3] = values2[i8];
            int i9 = i8 - 7;
            while (i7 < i) {
                int i10 = i9 + 1;
                int i11 = values2[i9];
                int i12 = i2 + 1;
                int[] iArr2 = $$a;
                byte[] bArr2 = $$b;
                int i13 = iArr2[bArr2[i11 >>> 24] & 255];
                int[] iArr3 = AFDateFormat;
                int i14 = i13 ^ iArr3[bArr2[(i11 >>> 16) & 255] & 255];
                int[] iArr4 = values;
                int i15 = i14 ^ iArr4[bArr2[(i11 >>> 8) & 255] & 255];
                int[] iArr5 = getDataFormatter;
                iArr[i2] = iArr5[bArr2[i11 & 255] & 255] ^ i15;
                int i16 = i10 + 1;
                int i17 = values2[i10];
                int i18 = i12 + 1;
                iArr[i12] = iArr5[bArr2[i17 & 255] & 255] ^ ((iArr2[bArr2[i17 >>> 24] & 255] ^ iArr3[bArr2[(i17 >>> 16) & 255] & 255]) ^ iArr4[bArr2[(i17 >>> 8) & 255] & 255]);
                int i19 = i16 + 1;
                int i20 = values2[i16];
                int i21 = i18 + 1;
                iArr[i18] = iArr5[bArr2[i20 & 255] & 255] ^ ((iArr2[bArr2[i20 >>> 24] & 255] ^ iArr3[bArr2[(i20 >>> 16) & 255] & 255]) ^ iArr4[bArr2[(i20 >>> 8) & 255] & 255]);
                int i22 = values2[i19];
                int i23 = i21 + 1;
                iArr[i21] = iArr5[bArr2[i22 & 255] & 255] ^ ((iArr2[bArr2[i22 >>> 24] & 255] ^ iArr3[bArr2[(i22 >>> 16) & 255] & 255]) ^ iArr4[bArr2[(i22 >>> 8) & 255] & 255]);
                i9 = i19 - 7;
                i7++;
                i2 = i23;
            }
            int i24 = i2 + 1;
            int i25 = i9 + 1;
            iArr[i2] = values2[i9];
            int i26 = i24 + 1;
            int i27 = i25 + 1;
            iArr[i24] = values2[i25];
            iArr[i26] = values2[i27];
            iArr[i26 + 1] = values2[i27 + 1];
            return iArr;
        }
        throw new IllegalArgumentException();
    }

    public static byte[][] values(int i) {
        byte[][] bArr = new byte[4][];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i >>> (i2 << 3);
            bArr[i2] = new byte[]{(byte) (i3 & 3), (byte) ((i3 >> 2) & 3), (byte) ((i3 >> 4) & 3), (byte) ((i3 >> 6) & 3)};
        }
        return bArr;
    }
}
