package com.google.android.gms.internal.p026firebaseauthapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.internal.zzai;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztw */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zztw extends AsyncTask<Void, Void, zztv> {
    private static final Logger zza = new Logger("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference<zzty> zzd;
    private final Uri.Builder zze;
    private final String zzf;

    public zztw(String str, String str2, Intent intent, zzty zzty) {
        this.zzb = Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(intent);
        String checkNotEmpty = Preconditions.checkNotEmpty(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder buildUpon = Uri.parse(zzty.zzc(checkNotEmpty)).buildUpon();
        buildUpon.appendPath("getProjectConfig").appendQueryParameter("key", checkNotEmpty).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) Preconditions.checkNotNull(str2));
        this.zzc = buildUpon.build().toString();
        this.zzd = new WeakReference<>(zzty);
        this.zze = zzty.zzd(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final void onPostExecute(zztv zztv) {
        String str;
        Uri.Builder builder;
        zzty zzty = (zzty) this.zzd.get();
        String str2 = null;
        if (zztv != null) {
            str2 = zztv.zza();
            str = zztv.zzb();
        } else {
            str = null;
        }
        if (zzty == null) {
            zza.mo39950e("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (TextUtils.isEmpty(str2) || (builder = this.zze) == null) {
            zzty.zze(this.zzb, zzai.zza(str));
        } else {
            builder.authority(str2);
            zzty.zza(this.zze.build(), this.zzb);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3 = zza;
        r1 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r1).length() + 75);
        r5.append("Error parsing error message from response body in getErrorMessageFromBody. ");
        r5.append(r1);
        r3.mo39957w(r5.toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fc, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fd, code lost:
        r2 = zza;
        r1 = java.lang.String.valueOf(r1);
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r1).length() + 33);
        r4.append("ConversionException encountered: ");
        r4.append(r1);
        r2.mo39950e(r4.toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0124, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0125, code lost:
        r2 = zza;
        r1 = java.lang.String.valueOf(r1);
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r1).length() + 26);
        r4.append("Null pointer encountered: ");
        r4.append(r1);
        r2.mo39950e(r4.toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e1 A[Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fc A[ExcHandler: zzqe (r1v6 'e' com.google.android.gms.internal.firebase-auth-api.zzqe A[CUSTOM_DECLARE]), Splitter:B:4:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0124 A[ExcHandler: NullPointerException (r1v3 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:4:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r7) {
        /*
            r6 = this;
            java.lang.Void[] r7 = (java.lang.Void[]) r7
            java.lang.String r7 = r6.zzf
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            r0 = 0
            if (r7 != 0) goto L_0x0013
            java.lang.String r7 = r6.zzf
            com.google.android.gms.internal.firebase-auth-api.zztv r0 = com.google.android.gms.internal.p026firebaseauthapi.zztv.zzc(r7)
            goto L_0x0173
        L_0x0013:
            r7 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r2 = r6.zzc     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r1.<init>(r2)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.ref.WeakReference<com.google.android.gms.internal.firebase-auth-api.zzty> r2 = r6.zzd     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            com.google.android.gms.internal.firebase-auth-api.zzty r2 = (com.google.android.gms.internal.p026firebaseauthapi.zzty) r2     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.net.HttpURLConnection r1 = r2.zzb(r1)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json; charset=UTF-8"
            r1.addRequestProperty(r3, r4)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r3 = 60000(0xea60, float:8.4078E-41)
            r1.setConnectTimeout(r3)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            com.google.android.gms.internal.firebase-auth-api.zzur r3 = new com.google.android.gms.internal.firebase-auth-api.zzur     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            android.content.Context r2 = r2.zzf()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            com.google.android.gms.internal.firebase-auth-api.zzup r4 = com.google.android.gms.internal.p026firebaseauthapi.zzup.zzb()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r4 = r4.zza()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r3.zza(r1)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 128(0x80, float:1.794E-43)
            if (r2 == r3) goto L_0x00be
            int r3 = r1.getResponseCode()     // Catch:{ IOException -> 0x0077, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r5 = 400(0x190, float:5.6E-43)
            if (r3 < r5) goto L_0x0075
            java.io.InputStream r1 = r1.getErrorStream()     // Catch:{ IOException -> 0x0077, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            if (r1 != 0) goto L_0x0063
            java.lang.String r1 = "WEB_INTERNAL_ERROR:Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again."
            goto L_0x009f
        L_0x0063:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0077, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            byte[] r1 = zza(r1, r4)     // Catch:{ IOException -> 0x0077, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0077, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.Object r1 = com.google.android.gms.internal.p026firebaseauthapi.zzum.zza(r3, r1)     // Catch:{ IOException -> 0x0077, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x0077, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            goto L_0x009f
        L_0x0075:
            r1 = r0
            goto L_0x009f
        L_0x0077:
            r1 = move-exception
            com.google.android.gms.common.logging.Logger r3 = zza     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            int r4 = r4.length()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            int r4 = r4 + 75
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r5.<init>(r4)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r4 = "Error parsing error message from response body in getErrorMessageFromBody. "
            r5.append(r4)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r5.append(r1)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r3.mo39957w(r1, r4)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            goto L_0x0075
        L_0x009f:
            com.google.android.gms.common.logging.Logger r3 = zza     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r4[r7] = r1     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r5 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r4[r5] = r2     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r2 = "Error getting project config. Failed with %s %s"
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r3.mo39950e(r2, r4)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            com.google.android.gms.internal.firebase-auth-api.zztv r0 = com.google.android.gms.internal.p026firebaseauthapi.zztv.zzd(r1)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            goto L_0x0173
        L_0x00be:
            com.google.android.gms.internal.firebase-auth-api.zzwu r2 = new com.google.android.gms.internal.firebase-auth-api.zzwu     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r2.<init>()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            byte[] r1 = zza(r1, r4)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r3.<init>(r1)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            r2.zzc(r3)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.util.List r1 = r2.zzb()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
        L_0x00db:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            if (r2 == 0) goto L_0x0173
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            java.lang.String r3 = "firebaseapp.com"
            boolean r3 = r2.endsWith(r3)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            if (r3 != 0) goto L_0x00f7
            java.lang.String r3 = "web.app"
            boolean r3 = r2.endsWith(r3)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            if (r3 == 0) goto L_0x00db
        L_0x00f7:
            com.google.android.gms.internal.firebase-auth-api.zztv r0 = com.google.android.gms.internal.p026firebaseauthapi.zztv.zzc(r2)     // Catch:{ IOException -> 0x014c, NullPointerException -> 0x0124, zzqe -> 0x00fc }
            goto L_0x0173
        L_0x00fc:
            r1 = move-exception
            com.google.android.gms.common.logging.Logger r2 = zza
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r3 = r3 + 33
            r4.<init>(r3)
            java.lang.String r3 = "ConversionException encountered: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r2.mo39950e(r1, r7)
            goto L_0x0173
        L_0x0124:
            r1 = move-exception
            com.google.android.gms.common.logging.Logger r2 = zza
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r3 = r3 + 26
            r4.<init>(r3)
            java.lang.String r3 = "Null pointer encountered: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r2.mo39950e(r1, r7)
            goto L_0x0173
        L_0x014c:
            r1 = move-exception
            com.google.android.gms.common.logging.Logger r2 = zza
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r3 = r3 + 22
            r4.<init>(r3)
            java.lang.String r3 = "IOException occurred: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r2.mo39950e(r1, r7)
        L_0x0173:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p026firebaseauthapi.zztw.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onCancelled(Object obj) {
        zztv zztv = (zztv) obj;
        onPostExecute((zztv) null);
    }
}
