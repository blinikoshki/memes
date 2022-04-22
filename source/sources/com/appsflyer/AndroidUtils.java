package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class AndroidUtils {
    public static boolean isServiceAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentServices(intent, 0).size() > 0;
    }

    public static boolean isPermissionAvailable(Context context, String str) {
        if (str != null) {
            int checkPermission = context.checkPermission(str, Process.myPid(), Process.myUid());
            StringBuilder sb = new StringBuilder("is Permission Available: ");
            sb.append(str);
            sb.append("; res: ");
            sb.append(checkPermission);
            AFLogger.afRDLog(sb.toString());
            return checkPermission == 0;
        }
        throw new IllegalArgumentException("permission is null");
    }

    static boolean $$a() {
        return Build.BRAND.equals("OPPO");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        if (r2.equals(com.appsflyer.share.Constants.URL_CAMPAIGN) != false) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Map<java.lang.String, java.lang.String> valueOf(android.content.Context r12, java.util.Map<java.lang.String, java.lang.String> r13, android.net.Uri r14) {
        /*
            java.lang.String r0 = "install_time"
            java.util.Set r1 = r14.getQueryParameterNames()
            java.util.Iterator r1 = r1.iterator()
        L_0x000a:
            boolean r2 = r1.hasNext()
            r3 = 0
            java.lang.String r4 = "media_source"
            java.lang.String r5 = "agency"
            if (r2 == 0) goto L_0x006a
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r6 = r14.getQueryParameter(r2)
            boolean r7 = r13.containsKey(r2)
            if (r7 != 0) goto L_0x0065
            r7 = -1
            int r8 = r2.hashCode()
            r9 = -1420799080(0xffffffffab505398, float:-7.4012454E-13)
            r10 = 2
            r11 = 1
            if (r8 == r9) goto L_0x004e
            r9 = 99
            if (r8 == r9) goto L_0x0045
            r3 = 110987(0x1b18b, float:1.55526E-40)
            if (r8 == r3) goto L_0x003b
            goto L_0x0058
        L_0x003b:
            java.lang.String r3 = "pid"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0058
            r3 = 1
            goto L_0x0059
        L_0x0045:
            java.lang.String r8 = "c"
            boolean r8 = r2.equals(r8)
            if (r8 == 0) goto L_0x0058
            goto L_0x0059
        L_0x004e:
            java.lang.String r3 = "af_prt"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0058
            r3 = 2
            goto L_0x0059
        L_0x0058:
            r3 = -1
        L_0x0059:
            if (r3 == 0) goto L_0x0062
            if (r3 == r11) goto L_0x0066
            if (r3 == r10) goto L_0x0060
            goto L_0x0065
        L_0x0060:
            r4 = r5
            goto L_0x0066
        L_0x0062:
            java.lang.String r4 = "campaign"
            goto L_0x0066
        L_0x0065:
            r4 = r2
        L_0x0066:
            r13.put(r4, r6)
            goto L_0x000a
        L_0x006a:
            boolean r1 = r13.containsKey(r0)     // Catch:{ Exception -> 0x008d }
            if (r1 != 0) goto L_0x0093
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss"
            java.text.SimpleDateFormat r1 = com.appsflyer.AFDateFormat.getDataFormatter(r1)     // Catch:{ Exception -> 0x008d }
            android.content.pm.PackageManager r2 = r12.getPackageManager()     // Catch:{ Exception -> 0x008d }
            java.lang.String r12 = r12.getPackageName()     // Catch:{ Exception -> 0x008d }
            android.content.pm.PackageInfo r12 = r2.getPackageInfo(r12, r3)     // Catch:{ Exception -> 0x008d }
            long r2 = r12.firstInstallTime     // Catch:{ Exception -> 0x008d }
            java.lang.String r12 = com.appsflyer.AFDateFormat.dateFormatUTC(r1, r2)     // Catch:{ Exception -> 0x008d }
            r13.put(r0, r12)     // Catch:{ Exception -> 0x008d }
            goto L_0x0093
        L_0x008d:
            r12 = move-exception
            java.lang.String r0 = "Could not fetch install time. "
            com.appsflyer.AFLogger.afErrorLog(r0, r12)
        L_0x0093:
            java.lang.String r12 = "af_deeplink"
            boolean r12 = r13.containsKey(r12)
            if (r12 == 0) goto L_0x00a8
            java.lang.String r12 = "af_status"
            boolean r0 = r13.containsKey(r12)
            if (r0 != 0) goto L_0x00a8
            java.lang.String r0 = "Non-organic"
            r13.put(r12, r0)
        L_0x00a8:
            boolean r12 = r13.containsKey(r5)
            if (r12 == 0) goto L_0x00b1
            r13.remove(r4)
        L_0x00b1:
            java.lang.String r12 = r14.getPath()
            if (r12 == 0) goto L_0x00bc
            java.lang.String r0 = "path"
            r13.put(r0, r12)
        L_0x00bc:
            java.lang.String r12 = r14.getScheme()
            if (r12 == 0) goto L_0x00c7
            java.lang.String r0 = "scheme"
            r13.put(r0, r12)
        L_0x00c7:
            java.lang.String r12 = r14.getHost()
            if (r12 == 0) goto L_0x00d2
            java.lang.String r14 = "host"
            r13.put(r14, r12)
        L_0x00d2:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AndroidUtils.valueOf(android.content.Context, java.util.Map, android.net.Uri):java.util.Map");
    }

    public static String signature(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException, CertificateException, NoSuchAlgorithmException {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        if (signatureArr == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        instance.update(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded());
        return String.format("%032X", new Object[]{new BigInteger(1, instance.digest())});
    }

    public static long getVersionCode(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return 0;
        }
    }

    public static String getVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return "";
        }
    }
}
