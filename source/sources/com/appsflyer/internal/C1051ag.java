package com.appsflyer.internal;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.appsflyer.internal.ag */
public class C1051ag extends FilterInputStream {
    private static final short values = ((short) ((int) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d))));
    private byte[] $$a = new byte[8];
    private byte[] $$b = new byte[8];
    private int AFDateFormat = 8;
    private int AFDeepLinkManager = 8;
    private int AFEvent;
    private int collectIntentsFromActivities = Integer.MAX_VALUE;
    private int dateFormatUTC;
    private int getDataFormatter;
    private int getInstance;
    private int requestListener;
    private int urlString;
    private byte[] valueOf = new byte[8];

    public boolean markSupported() {
        return false;
    }

    public C1051ag(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        super(inputStream);
        this.dateFormatUTC = Math.min(Math.max(i2, 5), 16);
        this.getDataFormatter = i3;
        if (i3 == 3) {
            System.arraycopy(bArr, 0, this.$$a, 0, 8);
        }
        long j = ((((long) iArr[0]) & 4294967295L) << 32) | (4294967295L & ((long) iArr[1]));
        if (i == 0) {
            this.getInstance = (int) j;
            long j2 = j >> 3;
            short s = values;
            this.AFEvent = (int) ((((long) s) * j2) >> 32);
            this.requestListener = (int) (j >> 32);
            this.urlString = (int) (j2 + ((long) s));
            return;
        }
        int i4 = (int) j;
        this.getInstance = i4;
        this.AFEvent = i4 * i;
        this.requestListener = i4 ^ i;
        this.urlString = (int) (j >> 32);
    }

    public int read() throws IOException {
        $$a();
        int i = this.AFDateFormat;
        if (i >= this.AFDeepLinkManager) {
            return -1;
        }
        byte[] bArr = this.$$b;
        this.AFDateFormat = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            $$a();
            int i5 = this.AFDateFormat;
            if (i5 < this.AFDeepLinkManager) {
                byte[] bArr2 = this.$$b;
                this.AFDateFormat = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }

    public long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public int available() throws IOException {
        $$a();
        return this.AFDeepLinkManager - this.AFDateFormat;
    }

    private void $$b() {
        if (this.getDataFormatter == 3) {
            byte[] bArr = this.$$b;
            System.arraycopy(bArr, 0, this.valueOf, 0, bArr.length);
        }
        byte[] bArr2 = this.$$b;
        int i = ((bArr2[0] << Ascii.CAN) & -16777216) + ((bArr2[1] << Ascii.DLE) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255);
        int i2 = (-16777216 & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << Ascii.DLE)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i3 = 0;
        while (true) {
            int i4 = this.dateFormatUTC;
            if (i3 >= i4) {
                break;
            }
            short s = values;
            i2 -= ((((i4 - i3) * s) + i) ^ ((i << 4) + this.requestListener)) ^ ((i >>> 5) + this.urlString);
            i -= (((i2 << 4) + this.getInstance) ^ ((s * (i4 - i3)) + i2)) ^ ((i2 >>> 5) + this.AFEvent);
            i3++;
        }
        byte[] bArr3 = this.$$b;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.getDataFormatter == 3) {
            for (int i5 = 0; i5 < 8; i5++) {
                byte[] bArr4 = this.$$b;
                bArr4[i5] = (byte) (bArr4[i5] ^ this.$$a[i5]);
            }
            byte[] bArr5 = this.valueOf;
            System.arraycopy(bArr5, 0, this.$$a, 0, bArr5.length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int $$a() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.collectIntentsFromActivities
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.collectIntentsFromActivities = r0
        L_0x000f:
            int r0 = r7.AFDateFormat
            r1 = 8
            if (r0 != r1) goto L_0x005a
            byte[] r0 = r7.$$b
            int r2 = r7.collectIntentsFromActivities
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0054
            r2 = 1
        L_0x0023:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.$$b
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0032
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0023
        L_0x0032:
            if (r2 < r1) goto L_0x004e
            r7.$$b()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.collectIntentsFromActivities = r0
            r7.AFDateFormat = r4
            if (r0 >= 0) goto L_0x004b
            byte[] r0 = r7.$$b
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004b:
            r7.AFDeepLinkManager = r1
            goto L_0x005a
        L_0x004e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0054:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x005a:
            int r0 = r7.AFDeepLinkManager
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1051ag.$$a():int");
    }
}
