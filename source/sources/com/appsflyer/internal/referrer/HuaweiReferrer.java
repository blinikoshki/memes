package com.appsflyer.internal.referrer;

import android.content.Context;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.internal.ContentFetcher;
import java.util.Map;

public class HuaweiReferrer extends ContentProviderReferrer {
    public HuaweiReferrer(Runnable runnable) {
        super(Payload.SOURCE_HUAWEI, runnable);
    }

    public void start(Context context) {
        C10752 r0 = new ContentFetcher<Map<String, Object>>(context, "com.huawei.appmarket.commondata", "FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212", "3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F") {
            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x00f9, code lost:
                if (r2 != null) goto L_0x010b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0109, code lost:
                if (r2 == null) goto L_0x010e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x010b, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x010e, code lost:
                r11.$$b.finish();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0117, code lost:
                return r11.$$b.map;
             */
            /* renamed from: valueOf */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.Map<java.lang.String, java.lang.Object> query() {
                /*
                    r11 = this;
                    java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
                    java.lang.String r1 = "response"
                    android.content.Context r2 = r11.context
                    android.content.pm.PackageManager r2 = r2.getPackageManager()
                    java.lang.String r3 = r11.authority
                    r4 = 128(0x80, float:1.794E-43)
                    android.content.pm.ProviderInfo r2 = r2.resolveContentProvider(r3, r4)
                    java.lang.String r2 = r2.packageName
                    com.appsflyer.internal.referrer.HuaweiReferrer r3 = com.appsflyer.internal.referrer.HuaweiReferrer.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.map
                    android.content.Context r4 = r11.context
                    long r4 = com.appsflyer.AndroidUtils.getVersionCode(r4, r2)
                    java.lang.Long r4 = java.lang.Long.valueOf(r4)
                    java.lang.String r5 = "api_ver"
                    r3.put(r5, r4)
                    com.appsflyer.internal.referrer.HuaweiReferrer r3 = com.appsflyer.internal.referrer.HuaweiReferrer.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.map
                    android.content.Context r4 = r11.context
                    java.lang.String r2 = com.appsflyer.AndroidUtils.getVersionName(r4, r2)
                    java.lang.String r4 = "api_ver_name"
                    r3.put(r4, r2)
                    r2 = 0
                    android.content.Context r3 = r11.context     // Catch:{ Exception -> 0x00fe }
                    android.content.ContentResolver r4 = r3.getContentResolver()     // Catch:{ Exception -> 0x00fe }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r5 = "content://"
                    r3.<init>(r5)     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r5 = r11.authority     // Catch:{ Exception -> 0x00fe }
                    r3.append(r5)     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r5 = "/item/5"
                    r3.append(r5)     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00fe }
                    android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00fe }
                    r6 = 0
                    r7 = 0
                    r3 = 1
                    java.lang.String[] r8 = new java.lang.String[r3]     // Catch:{ Exception -> 0x00fe }
                    android.content.Context r9 = r11.context     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r9 = r9.getPackageName()     // Catch:{ Exception -> 0x00fe }
                    r10 = 0
                    r8[r10] = r9     // Catch:{ Exception -> 0x00fe }
                    r9 = 0
                    android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00fe }
                    if (r2 == 0) goto L_0x00f0
                    boolean r4 = r2.moveToFirst()     // Catch:{ Exception -> 0x00fe }
                    if (r4 == 0) goto L_0x00e8
                    com.appsflyer.internal.referrer.HuaweiReferrer r4 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ Exception -> 0x00fe }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.map     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r5 = "OK"
                    r4.put(r1, r5)     // Catch:{ Exception -> 0x00fe }
                    com.appsflyer.internal.referrer.HuaweiReferrer r4 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ Exception -> 0x00fe }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.map     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r5 = "referrer"
                    java.lang.String r6 = r2.getString(r10)     // Catch:{ Exception -> 0x00fe }
                    r4.put(r5, r6)     // Catch:{ Exception -> 0x00fe }
                    com.appsflyer.internal.referrer.HuaweiReferrer r4 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ Exception -> 0x00fe }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.map     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r5 = "click_ts"
                    long r6 = r2.getLong(r3)     // Catch:{ Exception -> 0x00fe }
                    java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00fe }
                    r4.put(r5, r3)     // Catch:{ Exception -> 0x00fe }
                    com.appsflyer.internal.referrer.HuaweiReferrer r3 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ Exception -> 0x00fe }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.map     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r4 = "install_end_ts"
                    r5 = 2
                    long r5 = r2.getLong(r5)     // Catch:{ Exception -> 0x00fe }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00fe }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x00fe }
                    int r3 = r2.getColumnCount()     // Catch:{ Exception -> 0x00fe }
                    r4 = 3
                    if (r3 <= r4) goto L_0x00f9
                    com.appsflyer.internal.referrer.HuaweiReferrer r3 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ Exception -> 0x00fe }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.map     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r5 = "install_begin_ts"
                    long r6 = r2.getLong(r4)     // Catch:{ Exception -> 0x00fe }
                    java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00fe }
                    r3.put(r5, r4)     // Catch:{ Exception -> 0x00fe }
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x00fe }
                    r3.<init>()     // Catch:{ Exception -> 0x00fe }
                    r4 = 4
                    java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00fe }
                    if (r4 == 0) goto L_0x00d4
                    java.lang.String r5 = "track_id"
                    r3.put(r5, r4)     // Catch:{ Exception -> 0x00fe }
                L_0x00d4:
                    java.lang.String r4 = "referrer_ex"
                    r5 = 5
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x00fe }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x00fe }
                    com.appsflyer.internal.referrer.HuaweiReferrer r4 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ Exception -> 0x00fe }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.map     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r5 = "huawei_custom"
                    r4.put(r5, r3)     // Catch:{ Exception -> 0x00fe }
                    goto L_0x00f9
                L_0x00e8:
                    com.appsflyer.internal.referrer.HuaweiReferrer r3 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ Exception -> 0x00fe }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.map     // Catch:{ Exception -> 0x00fe }
                    r3.put(r1, r0)     // Catch:{ Exception -> 0x00fe }
                    goto L_0x00f9
                L_0x00f0:
                    com.appsflyer.internal.referrer.HuaweiReferrer r3 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ Exception -> 0x00fe }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.map     // Catch:{ Exception -> 0x00fe }
                    java.lang.String r4 = "SERVICE_UNAVAILABLE"
                    r3.put(r1, r4)     // Catch:{ Exception -> 0x00fe }
                L_0x00f9:
                    if (r2 == 0) goto L_0x010e
                    goto L_0x010b
                L_0x00fc:
                    r0 = move-exception
                    goto L_0x0118
                L_0x00fe:
                    r3 = move-exception
                    com.appsflyer.internal.referrer.HuaweiReferrer r4 = com.appsflyer.internal.referrer.HuaweiReferrer.this     // Catch:{ all -> 0x00fc }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.map     // Catch:{ all -> 0x00fc }
                    r4.put(r1, r0)     // Catch:{ all -> 0x00fc }
                    r11.onError(r3)     // Catch:{ all -> 0x00fc }
                    if (r2 == 0) goto L_0x010e
                L_0x010b:
                    r2.close()
                L_0x010e:
                    com.appsflyer.internal.referrer.HuaweiReferrer r0 = com.appsflyer.internal.referrer.HuaweiReferrer.this
                    r0.finish()
                    com.appsflyer.internal.referrer.HuaweiReferrer r0 = com.appsflyer.internal.referrer.HuaweiReferrer.this
                    java.util.Map<java.lang.String, java.lang.Object> r0 = r0.map
                    return r0
                L_0x0118:
                    if (r2 == 0) goto L_0x011d
                    r2.close()
                L_0x011d:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.referrer.HuaweiReferrer.C10752.query():java.util.Map");
            }
        };
        if (AppsFlyerLibCore.getInstance().getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(context), false) <= 0 && r0.valid()) {
            r0.start();
            start();
        }
    }
}
