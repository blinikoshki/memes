package com.memes.plus.data.domain;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import com.memes.plus.App;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u0002¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/data/domain/StaticRequestInterceptor;", "Lokhttp3/Interceptor;", "()V", "bodyToString", "", "requestBody", "Lokhttp3/RequestBody;", "createBodyWithParams", "existingRequestBody", "paramMap", "", "defaultParams", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "processApplicationJsonRequestBody", "processFormDataRequestBody", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StaticRequestInterceptor.kt */
public final class StaticRequestInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        RequestBody createBodyWithParams = createBodyWithParams(request.body(), defaultParams());
        Request.Builder addHeader = request.newBuilder().addHeader(HttpHeaders.CONTENT_TYPE, "application/json").addHeader("vApp", "73").addHeader("vAndroid", String.valueOf(Build.VERSION.SDK_INT));
        if (createBodyWithParams != null) {
            addHeader.post(createBodyWithParams);
        }
        return chain.proceed(addHeader.build());
    }

    private final Map<String, String> defaultParams() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("device_type", ExifInterface.GPS_MEASUREMENT_2D);
        return hashMap;
    }

    private final RequestBody createBodyWithParams(RequestBody requestBody, Map<String, String> map) {
        if (requestBody == null) {
            return requestBody;
        }
        MediaType contentType = requestBody.contentType();
        String subtype = contentType != null ? contentType.subtype() : null;
        return (subtype == null || !StringsKt.contains$default((CharSequence) subtype, (CharSequence) "json", false, 2, (Object) null)) ? requestBody : processApplicationJsonRequestBody(requestBody, map);
    }

    private final RequestBody processApplicationJsonRequestBody(RequestBody requestBody, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject(bodyToString(requestBody));
            if (!map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            }
            RequestBody.Companion companion = RequestBody.Companion;
            MediaType contentType = requestBody.contentType();
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "obj.toString()");
            return companion.create(contentType, jSONObject2);
        } catch (JSONException e) {
            App.Companion.crashReporter().report((Throwable) e);
            return null;
        }
    }

    private final RequestBody processFormDataRequestBody(RequestBody requestBody, Map<String, String> map) {
        boolean z = true;
        FormBody.Builder builder = new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null);
        if (!map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                builder.add((String) next.getKey(), (String) next.getValue());
            }
        }
        FormBody build = builder.build();
        String bodyToString = bodyToString(requestBody);
        StringBuilder sb = new StringBuilder();
        sb.append(bodyToString);
        if (bodyToString.length() <= 0) {
            z = false;
        }
        sb.append(z ? "&" : "");
        sb.append(bodyToString(build));
        return RequestBody.Companion.create(requestBody.contentType(), sb.toString());
    }

    private final String bodyToString(RequestBody requestBody) {
        try {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            return buffer.readUtf8();
        } catch (IOException unused) {
            return "did not work";
        }
    }
}
