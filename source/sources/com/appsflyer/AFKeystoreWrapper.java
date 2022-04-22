package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import com.memes.eventtracker.util.Util;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

class AFKeystoreWrapper {
    final Object $$a = new Object();
    String $$b;
    int AFDateFormat;
    private Context valueOf;
    KeyStore values;

    public AFKeystoreWrapper(Context context) {
        this.valueOf = context;
        this.$$b = "";
        this.AFDateFormat = 0;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.values = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r1 = r4.split(com.memes.eventtracker.util.Util.EVENT_ID_SEPARATOR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r1.length != 3) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        com.appsflyer.AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = r1[1].trim().split("=");
        r1 = r1[2].trim().split("=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r3.length != 2) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r1.length != 2) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        r7.$$b = r3[1].trim();
        r7.AFDateFormat = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        r1 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean valueOf() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.$$a
            monitor-enter(r0)
            java.security.KeyStore r1 = r7.values     // Catch:{ all -> 0x008d }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x008a
            java.util.Enumeration r1 = r1.aliases()     // Catch:{ all -> 0x006e }
        L_0x000d:
            boolean r4 = r1.hasMoreElements()     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r1.nextElement()     // Catch:{ all -> 0x006e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x000d
            boolean r5 = AFDateFormat(r4)     // Catch:{ all -> 0x006e }
            if (r5 == 0) goto L_0x000d
            java.lang.String r1 = ","
            java.lang.String[] r1 = r4.split(r1)     // Catch:{ all -> 0x006e }
            int r5 = r1.length     // Catch:{ all -> 0x006e }
            r6 = 3
            if (r5 != r6) goto L_0x008a
            java.lang.String r5 = "Found a matching AF key with alias:\n"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ all -> 0x006e }
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x006e }
            r3 = r1[r2]     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "="
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x006c }
            r4 = 2
            r1 = r1[r4]     // Catch:{ all -> 0x006c }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006c }
            java.lang.String r5 = "="
            java.lang.String[] r1 = r1.split(r5)     // Catch:{ all -> 0x006c }
            int r5 = r3.length     // Catch:{ all -> 0x006c }
            if (r5 != r4) goto L_0x008b
            int r5 = r1.length     // Catch:{ all -> 0x006c }
            if (r5 != r4) goto L_0x008b
            r3 = r3[r2]     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006c }
            r7.$$b = r3     // Catch:{ all -> 0x006c }
            r1 = r1[r2]     // Catch:{ all -> 0x006c }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006c }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x006c }
            r7.AFDateFormat = r1     // Catch:{ all -> 0x006c }
            goto L_0x008b
        L_0x006c:
            r1 = move-exception
            goto L_0x0070
        L_0x006e:
            r1 = move-exception
            r2 = 0
        L_0x0070:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            java.lang.String r4 = "Couldn't list KeyStore Aliases: "
            r3.<init>(r4)     // Catch:{ all -> 0x008d }
            java.lang.Class r4 = r1.getClass()     // Catch:{ all -> 0x008d }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x008d }
            r3.append(r4)     // Catch:{ all -> 0x008d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008d }
            com.appsflyer.AFLogger.afErrorLog(r3, r1)     // Catch:{ all -> 0x008d }
            goto L_0x008b
        L_0x008a:
            r2 = 0
        L_0x008b:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return r2
        L_0x008d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AFKeystoreWrapper.valueOf():boolean");
    }

    /* access modifiers changed from: package-private */
    public final void values(String str) {
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 5);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            synchronized (this.$$a) {
                if (!this.values.containsAlias(str)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else if (Build.VERSION.SDK_INT >= 18 && !AndroidUtils.$$a()) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.valueOf).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    }
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                } else {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception ");
            sb.append(th.getMessage());
            sb.append(" occurred");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    private static boolean AFDateFormat(String str) {
        return str.startsWith("com.appsflyer");
    }

    /* access modifiers changed from: package-private */
    public final String values() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.appsflyer,");
        synchronized (this.$$a) {
            sb.append("KSAppsFlyerId=");
            sb.append(this.$$b);
            sb.append(Util.EVENT_ID_SEPARATOR);
            sb.append("KSAppsFlyerRICounter=");
            sb.append(this.AFDateFormat);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String AFDateFormat() {
        String str;
        synchronized (this.$$a) {
            str = this.$$b;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final int $$a() {
        int i;
        synchronized (this.$$a) {
            i = this.AFDateFormat;
        }
        return i;
    }
}
