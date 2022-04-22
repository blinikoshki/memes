package com.google.android.gms.internal.p026firebaseauthapi;

import com.appsflyer.internal.referrer.Payload;
import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvg */
/* compiled from: com.google.firebase:firebase-auth@@20.0.2 */
public final class zzvg {
    public static void zza(String str, zzun zzun, zzve zzve, Type type, zzur zzur) {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream;
        BufferedReader bufferedReader;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzun.zza().getBytes(Charset.defaultCharset());
            int length = bytes.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzur.zza(httpURLConnection);
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), length);
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (zzb(responseCode)) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            String sb2 = sb.toString();
            if (!zzb(responseCode)) {
                zzve.zza((String) zzum.zza(sb2, String.class));
                return;
            } else {
                zzve.zzb((zzuo) zzum.zza(sb2, type));
                return;
            }
            throw th;
            throw th;
        } catch (SocketTimeoutException unused) {
            zzve.zza(Payload.RESPONSE_TIMEOUT);
        } catch (zzqe | IOException | JSONException e) {
            zzve.zza(e.getMessage());
        } catch (Throwable th) {
            zzlp.zza(th, th);
        }
    }

    private static final boolean zzb(int i) {
        return i >= 200 && i < 300;
    }
}
