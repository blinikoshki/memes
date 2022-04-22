package com.snapchat.kit.sdk.core.networking;

import java.util.Arrays;
import java.util.List;

/* renamed from: com.snapchat.kit.sdk.core.networking.j */
final class C4458j {

    /* renamed from: a */
    private static final List<String> f1268a = Arrays.asList(new String[]{"sha256/1XUWswVGCeFUaI5FKrhY7R+dIrDXIzTtDy/WDGcjAoY=", "sha256/8ca6Zwz8iOTfUpc8rkIPCgid1HQUT+WAbEIAZOFZEik=", "sha256/uUwZgwDOxcBXrQcntwu+kYFpkiVkOaezL0WYEZ3anJc=", "sha256/I/Lt/z7ekCWanjD0Cvj5EqXls2lOaThEA0H2Bg4BT/o=", "sha256/Wd8xe/qfTwq3ylFNd3IpaqLHZbh2ZNCLluVzmeNkcpw=", "sha256/O4rGMvpV1NfGyWRRTZ6v92jubDQNBdwlK+E35oZJ9qo=", "sha256/i7WTqTvh0OioIruIfFR4kMPnBqrS2rdiVPl/s2uC/CY=", "sha256/WoiWRyIOVNa9ihaBciRSC7XHjliYS9VwUGOIud4PB18=", "sha256/r/mIkG3eEpVdm+u/ko/cwxzOMo1bk4TyHIlByibiA5E=", "sha256/Fe7TOVlLME+M+Ee0dzcdjW/sYfTbKwGvWJ58U7Ncrkw="});

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1 = r1.build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        return r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0040 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized okhttp3.CertificatePinner m918a() {
        /*
            java.lang.Class<com.snapchat.kit.sdk.core.networking.j> r0 = com.snapchat.kit.sdk.core.networking.C4458j.class
            monitor-enter(r0)
            okhttp3.CertificatePinner$Builder r1 = new okhttp3.CertificatePinner$Builder     // Catch:{ all -> 0x0046 }
            r1.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "https://api.snapkit.com"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ NullPointerException -> 0x0040 }
            java.lang.String r2 = r2.getHost()     // Catch:{ NullPointerException -> 0x0040 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x001e
            okhttp3.CertificatePinner r1 = r1.build()     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)
            return r1
        L_0x001e:
            java.util.List<java.lang.String> r3 = f1268a     // Catch:{ all -> 0x0046 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0046 }
        L_0x0024:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0046 }
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0046 }
            r6 = 0
            r5[r6] = r4     // Catch:{ all -> 0x0046 }
            r1.add(r2, r5)     // Catch:{ all -> 0x0046 }
            goto L_0x0024
        L_0x003a:
            okhttp3.CertificatePinner r1 = r1.build()     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)
            return r1
        L_0x0040:
            okhttp3.CertificatePinner r1 = r1.build()     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)
            return r1
        L_0x0046:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snapchat.kit.sdk.core.networking.C4458j.m918a():okhttp3.CertificatePinner");
    }
}
