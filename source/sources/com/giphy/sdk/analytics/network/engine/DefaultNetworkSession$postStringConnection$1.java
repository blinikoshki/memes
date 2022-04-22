package com.giphy.sdk.analytics.network.engine;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "T", "Lcom/giphy/sdk/analytics/network/response/GenericResponse;", "call", "()Lcom/giphy/sdk/analytics/network/response/GenericResponse;"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: DefaultNetworkSession.kt */
final class DefaultNetworkSession$postStringConnection$1<V> implements Callable<T> {
    final /* synthetic */ Map $headers;
    final /* synthetic */ String $method;
    final /* synthetic */ String $path;
    final /* synthetic */ Map $queryStrings;
    final /* synthetic */ Object $requestBody;
    final /* synthetic */ Class $responseClass;
    final /* synthetic */ Uri $serverUrl;
    final /* synthetic */ DefaultNetworkSession this$0;

    DefaultNetworkSession$postStringConnection$1(DefaultNetworkSession defaultNetworkSession, Uri uri, String str, Map map, String str2, Map map2, Object obj, Class cls) {
        this.this$0 = defaultNetworkSession;
        this.$serverUrl = uri;
        this.$path = str;
        this.$queryStrings = map;
        this.$method = str2;
        this.$headers = map2;
        this.$requestBody = obj;
        this.$responseClass = cls;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fa A[Catch:{ all -> 0x0108 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T call() {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            java.net.URL r0 = (java.net.URL) r0
            android.net.Uri r2 = r6.$serverUrl     // Catch:{ all -> 0x00e7 }
            android.net.Uri$Builder r2 = r2.buildUpon()     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = r6.$path     // Catch:{ all -> 0x00e7 }
            android.net.Uri$Builder r2 = r2.appendEncodedPath(r3)     // Catch:{ all -> 0x00e7 }
            java.util.Map r3 = r6.$queryStrings     // Catch:{ all -> 0x00e7 }
            if (r3 == 0) goto L_0x003a
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x00e7 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00e7 }
        L_0x001e:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00e7 }
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00e7 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x00e7 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x00e7 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00e7 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x00e7 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00e7 }
            r2.appendQueryParameter(r5, r4)     // Catch:{ all -> 0x00e7 }
            goto L_0x001e
        L_0x003a:
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x00e7 }
            android.net.Uri r2 = r2.build()     // Catch:{ all -> 0x00e7 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e7 }
            r3.<init>(r2)     // Catch:{ all -> 0x00e7 }
            java.net.URLConnection r0 = r3.openConnection()     // Catch:{ all -> 0x00e4 }
            if (r0 == 0) goto L_0x00dc
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r6.$method     // Catch:{ all -> 0x00d9 }
            r0.setRequestMethod(r1)     // Catch:{ all -> 0x00d9 }
            java.util.Map r1 = r6.$headers     // Catch:{ all -> 0x00d9 }
            if (r1 == 0) goto L_0x007c
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x00d9 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00d9 }
        L_0x0060:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00d9 }
            if (r2 == 0) goto L_0x007c
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00d9 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00d9 }
            java.lang.Object r4 = r2.getKey()     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00d9 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00d9 }
            r0.setRequestProperty(r4, r2)     // Catch:{ all -> 0x00d9 }
            goto L_0x0060
        L_0x007c:
            java.lang.String r1 = r6.$method     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = "POST"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x00d9 }
            if (r1 == 0) goto L_0x00c8
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ all -> 0x00d9 }
            r0.connect()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r1 = r6.$requestBody     // Catch:{ all -> 0x00d9 }
            if (r1 == 0) goto L_0x00cb
            com.giphy.sdk.analytics.network.engine.DefaultNetworkSession$Companion r1 = com.giphy.sdk.analytics.network.engine.DefaultNetworkSession.Companion     // Catch:{ all -> 0x00d9 }
            com.google.gson.Gson r1 = r1.getGSON_INSTANCE()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r2 = r6.$requestBody     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = r1.toJson((java.lang.Object) r2)     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = "GSON_INSTANCE.toJson(requestBody)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = "Charset.forName(charsetName)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)     // Catch:{ all -> 0x00d9 }
            if (r1 == 0) goto L_0x00c0
            byte[] r1 = r1.getBytes(r2)     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = "(this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch:{ all -> 0x00d9 }
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ all -> 0x00d9 }
            r2.write(r1)     // Catch:{ all -> 0x00d9 }
            goto L_0x00cb
        L_0x00c0:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r2)     // Catch:{ all -> 0x00d9 }
            throw r1     // Catch:{ all -> 0x00d9 }
        L_0x00c8:
            r0.connect()     // Catch:{ all -> 0x00d9 }
        L_0x00cb:
            com.giphy.sdk.analytics.network.engine.DefaultNetworkSession r1 = r6.this$0     // Catch:{ all -> 0x00d9 }
            java.lang.Class r2 = r6.$responseClass     // Catch:{ all -> 0x00d9 }
            com.giphy.sdk.analytics.network.response.GenericResponse r1 = r1.readJsonResponse(r3, r0, r2)     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00d8
            r0.disconnect()
        L_0x00d8:
            return r1
        L_0x00d9:
            r2 = move-exception
            r1 = r0
            goto L_0x00e5
        L_0x00dc:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r2)     // Catch:{ all -> 0x00e4 }
            throw r0     // Catch:{ all -> 0x00e4 }
        L_0x00e4:
            r2 = move-exception
        L_0x00e5:
            r0 = r3
            goto L_0x00e8
        L_0x00e7:
            r2 = move-exception
        L_0x00e8:
            java.lang.Class<com.giphy.sdk.analytics.network.engine.NetworkSession> r3 = com.giphy.sdk.analytics.network.engine.NetworkSession.class
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r4.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r5 = "Unable to perform network request for url="
            r4.append(r5)     // Catch:{ all -> 0x0108 }
            if (r0 != 0) goto L_0x00fd
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0108 }
        L_0x00fd:
            r4.append(r0)     // Catch:{ all -> 0x0108 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0108 }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x0108 }
            throw r2     // Catch:{ all -> 0x0108 }
        L_0x0108:
            r0 = move-exception
            if (r1 == 0) goto L_0x010e
            r1.disconnect()
        L_0x010e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.analytics.network.engine.DefaultNetworkSession$postStringConnection$1.call():com.giphy.sdk.analytics.network.response.GenericResponse");
    }
}
