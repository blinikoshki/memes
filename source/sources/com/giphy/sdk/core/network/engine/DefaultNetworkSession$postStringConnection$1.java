package com.giphy.sdk.core.network.engine;

import android.net.Uri;
import com.giphy.sdk.core.network.api.GPHApiClient;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo26107d2 = {"<anonymous>", "T", "call", "()Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: DefaultNetworkSession.kt */
final class DefaultNetworkSession$postStringConnection$1<V> implements Callable<T> {
    final /* synthetic */ Map $headers;
    final /* synthetic */ GPHApiClient.HTTPMethod $method;
    final /* synthetic */ String $path;
    final /* synthetic */ Map $queryStrings;
    final /* synthetic */ Object $requestBody;
    final /* synthetic */ Class $responseClass;
    final /* synthetic */ Uri $serverUrl;
    final /* synthetic */ DefaultNetworkSession this$0;

    DefaultNetworkSession$postStringConnection$1(DefaultNetworkSession defaultNetworkSession, Uri uri, String str, Map map, GPHApiClient.HTTPMethod hTTPMethod, Map map2, Object obj, Class cls) {
        this.this$0 = defaultNetworkSession;
        this.$serverUrl = uri;
        this.$path = str;
        this.$queryStrings = map;
        this.$method = hTTPMethod;
        this.$headers = map2;
        this.$requestBody = obj;
        this.$responseClass = cls;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fb A[Catch:{ all -> 0x0109 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T call() {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            java.net.URL r0 = (java.net.URL) r0
            android.net.Uri r2 = r6.$serverUrl     // Catch:{ all -> 0x00e8 }
            android.net.Uri$Builder r2 = r2.buildUpon()     // Catch:{ all -> 0x00e8 }
            java.lang.String r3 = r6.$path     // Catch:{ all -> 0x00e8 }
            if (r3 == 0) goto L_0x0013
            r2.appendEncodedPath(r3)     // Catch:{ all -> 0x00e8 }
        L_0x0013:
            java.util.Map r3 = r6.$queryStrings     // Catch:{ all -> 0x00e8 }
            if (r3 == 0) goto L_0x003b
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x00e8 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00e8 }
        L_0x001f:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00e8 }
            if (r4 == 0) goto L_0x003b
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00e8 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x00e8 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x00e8 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00e8 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00e8 }
            r2.appendQueryParameter(r5, r4)     // Catch:{ all -> 0x00e8 }
            goto L_0x001f
        L_0x003b:
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x00e8 }
            android.net.Uri r2 = r2.build()     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e8 }
            r3.<init>(r2)     // Catch:{ all -> 0x00e8 }
            java.net.URLConnection r0 = r3.openConnection()     // Catch:{ all -> 0x00e5 }
            if (r0 == 0) goto L_0x00dd
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x00e5 }
            com.giphy.sdk.core.network.api.GPHApiClient$HTTPMethod r1 = r6.$method     // Catch:{ all -> 0x00da }
            java.lang.String r1 = r1.name()     // Catch:{ all -> 0x00da }
            r0.setRequestMethod(r1)     // Catch:{ all -> 0x00da }
            java.util.Map r1 = r6.$headers     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x0081
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x00da }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00da }
        L_0x0065:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00da }
            if (r2 == 0) goto L_0x0081
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00da }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00da }
            java.lang.Object r4 = r2.getKey()     // Catch:{ all -> 0x00da }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00da }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00da }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00da }
            r0.setRequestProperty(r4, r2)     // Catch:{ all -> 0x00da }
            goto L_0x0065
        L_0x0081:
            com.giphy.sdk.core.network.api.GPHApiClient$HTTPMethod r1 = r6.$method     // Catch:{ all -> 0x00da }
            com.giphy.sdk.core.network.api.GPHApiClient$HTTPMethod r2 = com.giphy.sdk.core.network.api.GPHApiClient.HTTPMethod.POST     // Catch:{ all -> 0x00da }
            if (r1 != r2) goto L_0x00c9
            r1 = 1
            r0.setDoOutput(r1)     // Catch:{ all -> 0x00da }
            r0.connect()     // Catch:{ all -> 0x00da }
            java.lang.Object r1 = r6.$requestBody     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00cc
            com.giphy.sdk.core.network.engine.DefaultNetworkSession$Companion r1 = com.giphy.sdk.core.network.engine.DefaultNetworkSession.Companion     // Catch:{ all -> 0x00da }
            com.google.gson.Gson r1 = r1.getGSON_INSTANCE()     // Catch:{ all -> 0x00da }
            java.lang.Object r2 = r6.$requestBody     // Catch:{ all -> 0x00da }
            java.lang.String r1 = r1.toJson((java.lang.Object) r2)     // Catch:{ all -> 0x00da }
            java.lang.String r2 = "GSON_INSTANCE.toJson(requestBody)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch:{ all -> 0x00da }
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r4 = "Charset.forName(charsetName)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00c1
            byte[] r1 = r1.getBytes(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r2 = "(this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch:{ all -> 0x00da }
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ all -> 0x00da }
            r2.write(r1)     // Catch:{ all -> 0x00da }
            goto L_0x00cc
        L_0x00c1:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException     // Catch:{ all -> 0x00da }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r2)     // Catch:{ all -> 0x00da }
            throw r1     // Catch:{ all -> 0x00da }
        L_0x00c9:
            r0.connect()     // Catch:{ all -> 0x00da }
        L_0x00cc:
            com.giphy.sdk.core.network.engine.DefaultNetworkSession r1 = r6.this$0     // Catch:{ all -> 0x00da }
            java.lang.Class r2 = r6.$responseClass     // Catch:{ all -> 0x00da }
            java.lang.Object r1 = r1.readJsonResponse(r3, r0, r2)     // Catch:{ all -> 0x00da }
            if (r0 == 0) goto L_0x00d9
            r0.disconnect()
        L_0x00d9:
            return r1
        L_0x00da:
            r2 = move-exception
            r1 = r0
            goto L_0x00e6
        L_0x00dd:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r2)     // Catch:{ all -> 0x00e5 }
            throw r0     // Catch:{ all -> 0x00e5 }
        L_0x00e5:
            r2 = move-exception
        L_0x00e6:
            r0 = r3
            goto L_0x00e9
        L_0x00e8:
            r2 = move-exception
        L_0x00e9:
            java.lang.Class<com.giphy.sdk.core.network.engine.NetworkSession> r3 = com.giphy.sdk.core.network.engine.NetworkSession.class
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0109 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            r4.<init>()     // Catch:{ all -> 0x0109 }
            java.lang.String r5 = "Unable to perform network request for url="
            r4.append(r5)     // Catch:{ all -> 0x0109 }
            if (r0 != 0) goto L_0x00fe
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0109 }
        L_0x00fe:
            r4.append(r0)     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0109 }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x0109 }
            throw r2     // Catch:{ all -> 0x0109 }
        L_0x0109:
            r0 = move-exception
            if (r1 == 0) goto L_0x010f
            r1.disconnect()
        L_0x010f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.core.network.engine.DefaultNetworkSession$postStringConnection$1.call():java.lang.Object");
    }
}
