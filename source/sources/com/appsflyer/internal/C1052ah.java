package com.appsflyer.internal;

/* renamed from: com.appsflyer.internal.ah */
public class C1052ah {
    public static void AFDateFormat(byte[] bArr, byte b, long j) {
        for (int i = 0; i < bArr.length; i++) {
            if (((1 << i) & j) != 0) {
                bArr[i] = (byte) (bArr[i] ^ b);
            }
        }
    }
}
