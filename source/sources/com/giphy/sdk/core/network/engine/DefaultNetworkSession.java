package com.giphy.sdk.core.network.engine;

import android.net.Uri;
import com.giphy.sdk.core.models.Meta;
import com.giphy.sdk.core.models.json.BooleanDeserializer;
import com.giphy.sdk.core.models.json.DateDeserializer;
import com.giphy.sdk.core.models.json.DateSerializer;
import com.giphy.sdk.core.models.json.IntDeserializer;
import com.giphy.sdk.core.models.json.MainAdapterFactory;
import com.giphy.sdk.core.network.api.GPHApiClient;
import com.giphy.sdk.core.network.response.ErrorResponse;
import com.giphy.sdk.core.threading.ApiTask;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p017io.TextStreamsKt;
import kotlin.text.Charsets;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007Jr\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016Jh\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aH\u0016J3\u0010\u001f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0018H\u0002¢\u0006\u0002\u0010$R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/engine/DefaultNetworkSession;", "Lcom/giphy/sdk/core/network/engine/NetworkSession;", "()V", "networkRequestExecutor", "Ljava/util/concurrent/ExecutorService;", "completionExecutor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/Executor;)V", "getCompletionExecutor", "()Ljava/util/concurrent/Executor;", "completionExecutor1", "getNetworkRequestExecutor", "()Ljava/util/concurrent/ExecutorService;", "networkRequestExecutor1", "postStringConnection", "Lcom/giphy/sdk/core/threading/ApiTask;", "T", "serverUrl", "Landroid/net/Uri;", "path", "", "method", "Lcom/giphy/sdk/core/network/api/GPHApiClient$HTTPMethod;", "responseClass", "Ljava/lang/Class;", "queryStrings", "", "headers", "requestBody", "", "queryStringConnection", "readJsonResponse", "url", "Ljava/net/URL;", "connection", "Ljava/net/HttpURLConnection;", "(Ljava/net/URL;Ljava/net/HttpURLConnection;Ljava/lang/Class;)Ljava/lang/Object;", "Companion", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: DefaultNetworkSession.kt */
public final class DefaultNetworkSession implements NetworkSession {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Gson GSON_INSTANCE = new GsonBuilder().registerTypeHierarchyAdapter(Date.class, new DateDeserializer()).registerTypeHierarchyAdapter(Date.class, new DateSerializer()).registerTypeHierarchyAdapter(Boolean.TYPE, new BooleanDeserializer()).registerTypeHierarchyAdapter(Integer.TYPE, new IntDeserializer()).registerTypeAdapterFactory(new MainAdapterFactory()).create();
    private final Executor completionExecutor1;
    private final ExecutorService networkRequestExecutor1;

    public DefaultNetworkSession() {
        this.networkRequestExecutor1 = ApiTask.Companion.getNetworkRequestExecutor();
        this.completionExecutor1 = ApiTask.Companion.getCompletionExecutor();
    }

    public DefaultNetworkSession(ExecutorService executorService, Executor executor) {
        Intrinsics.checkParameterIsNotNull(executorService, "networkRequestExecutor");
        Intrinsics.checkParameterIsNotNull(executor, "completionExecutor");
        this.networkRequestExecutor1 = executorService;
        this.completionExecutor1 = executor;
    }

    public ExecutorService getNetworkRequestExecutor() {
        return this.networkRequestExecutor1;
    }

    public Executor getCompletionExecutor() {
        return this.completionExecutor1;
    }

    public <T> ApiTask<T> queryStringConnection(Uri uri, String str, GPHApiClient.HTTPMethod hTTPMethod, Class<T> cls, Map<String, String> map, Map<String, String> map2) {
        Intrinsics.checkParameterIsNotNull(uri, "serverUrl");
        Intrinsics.checkParameterIsNotNull(hTTPMethod, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkParameterIsNotNull(cls, "responseClass");
        return postStringConnection(uri, str, hTTPMethod, cls, map, map2, (Object) null);
    }

    public <T> ApiTask<T> postStringConnection(Uri uri, String str, GPHApiClient.HTTPMethod hTTPMethod, Class<T> cls, Map<String, String> map, Map<String, String> map2, Object obj) {
        Intrinsics.checkParameterIsNotNull(uri, "serverUrl");
        Intrinsics.checkParameterIsNotNull(hTTPMethod, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkParameterIsNotNull(cls, "responseClass");
        return new ApiTask<>(new DefaultNetworkSession$postStringConnection$1(this, uri, str, map, hTTPMethod, map2, obj, cls), getNetworkRequestExecutor(), getCompletionExecutor());
    }

    /* access modifiers changed from: private */
    public final <T> T readJsonResponse(URL url, HttpURLConnection httpURLConnection, Class<T> cls) throws IOException, ApiException {
        T t;
        int responseCode = httpURLConnection.getResponseCode();
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 202;
        if (z) {
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.checkExpressionValueIsNotNull(inputStream, "connection.inputStream");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            t = TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
        } else {
            InputStream errorStream = httpURLConnection.getErrorStream();
            Intrinsics.checkExpressionValueIsNotNull(errorStream, "connection.errorStream");
            Reader inputStreamReader2 = new InputStreamReader(errorStream, Charsets.UTF_8);
            t = TextStreamsKt.readText(inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192));
        }
        if (!z) {
            try {
                ErrorResponse errorResponse = (ErrorResponse) GSON_INSTANCE.fromJson((String) t, ErrorResponse.class);
                if (errorResponse.getMeta() == null) {
                    errorResponse.setMeta(new Meta(responseCode, errorResponse.getMessage(), (String) null, 4, (DefaultConstructorMarker) null));
                }
                Intrinsics.checkExpressionValueIsNotNull(errorResponse, "errorResponse");
                throw new ApiException(errorResponse);
            } catch (JsonParseException e) {
                throw new ApiException("Unable to parse server error response : " + url + " : " + t + " : " + e.getMessage(), new ErrorResponse(responseCode, t));
            }
        } else if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
            return (Object) t;
        } else {
            return GSON_INSTANCE.fromJson((String) t, cls);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo26107d2 = {"Lcom/giphy/sdk/core/network/engine/DefaultNetworkSession$Companion;", "", "()V", "GSON_INSTANCE", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGSON_INSTANCE", "()Lcom/google/gson/Gson;", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: DefaultNetworkSession.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Gson getGSON_INSTANCE() {
            return DefaultNetworkSession.GSON_INSTANCE;
        }
    }
}
