package com.giphy.sdk.analytics.network.api;

import android.net.Uri;
import com.giphy.sdk.analytics.GiphyPingbacks;
import com.giphy.sdk.analytics.models.Session;
import com.giphy.sdk.analytics.models.SessionsRequestData;
import com.giphy.sdk.analytics.network.api.Constants;
import com.giphy.sdk.analytics.network.engine.DefaultNetworkSession;
import com.giphy.sdk.analytics.network.engine.NetworkSession;
import com.giphy.sdk.analytics.network.response.PingbackResponse;
import com.giphy.sdk.analytics.network.response.RandomIdResponse;
import com.giphy.sdk.analytics.threading.ApiTask;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jp\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000eH\u0016J\"\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J(\u0010%\u001a\u0006\u0012\u0002\b\u00030\u001f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006)"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/network/api/GPHPingbackClient;", "Lcom/giphy/sdk/analytics/network/api/GPHPingbackApi;", "apiKey", "", "networkSession", "Lcom/giphy/sdk/analytics/network/engine/NetworkSession;", "(Ljava/lang/String;Lcom/giphy/sdk/analytics/network/engine/NetworkSession;)V", "getApiKey", "()Ljava/lang/String;", "applicationJson", "getApplicationJson", "getNetworkSession", "()Lcom/giphy/sdk/analytics/network/engine/NetworkSession;", "postStringConnectionWithRandomId", "Lcom/giphy/sdk/analytics/threading/ApiTask;", "T", "Lcom/giphy/sdk/analytics/network/response/GenericResponse;", "serverUrl", "Landroid/net/Uri;", "path", "method", "responseClass", "Ljava/lang/Class;", "queryStrings", "", "headers", "requestBody", "Lcom/giphy/sdk/analytics/models/SessionsRequestData;", "randomIdTask", "Lcom/giphy/sdk/analytics/network/response/RandomIdResponse;", "submitSession", "Ljava/util/concurrent/Future;", "session", "Lcom/giphy/sdk/analytics/models/Session;", "completionHandler", "Lcom/giphy/sdk/analytics/network/api/CompletionHandler;", "Lcom/giphy/sdk/analytics/network/response/PingbackResponse;", "submitSessions", "sessions", "", "Companion", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GPHPingbackClient.kt */
public final class GPHPingbackClient implements GPHPingbackApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HTTP_GET = "GET";
    public static final String HTTP_POST = "POST";
    private final String apiKey;
    private final String applicationJson;
    private final NetworkSession networkSession;

    public GPHPingbackClient(String str) {
        this(str, (NetworkSession) null, 2, (DefaultConstructorMarker) null);
    }

    public GPHPingbackClient(String str, NetworkSession networkSession2) {
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
        Intrinsics.checkParameterIsNotNull(networkSession2, "networkSession");
        this.apiKey = str;
        this.networkSession = networkSession2;
        this.applicationJson = "application/json";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GPHPingbackClient(String str, NetworkSession networkSession2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new DefaultNetworkSession() : networkSession2);
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final NetworkSession getNetworkSession() {
        return this.networkSession;
    }

    public final String getApplicationJson() {
        return this.applicationJson;
    }

    public Future<?> submitSession(Session session, CompletionHandler<PingbackResponse> completionHandler) {
        Intrinsics.checkParameterIsNotNull(session, "session");
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(Constants.INSTANCE.getAPI_KEY(), this.apiKey), TuplesKt.m181to(Constants.INSTANCE.getPINGBACK_ID(), session.getUser().getUserId()));
        Map plus = MapsKt.plus(MapsKt.hashMapOf(TuplesKt.m181to(Constants.INSTANCE.getCONTENT_TYPE(), this.applicationJson)), (HashMap) GiphyPingbacks.INSTANCE.getAdditionalHeaders());
        Uri pingback_server_url = Constants.INSTANCE.getPINGBACK_SERVER_URL();
        Intrinsics.checkExpressionValueIsNotNull(pingback_server_url, "Constants.PINGBACK_SERVER_URL");
        return postStringConnectionWithRandomId(pingback_server_url, Constants.Paths.INSTANCE.getPINGBACK(), HTTP_POST, PingbackResponse.class, hashMapOf, plus, new SessionsRequestData(session)).executeAsyncTask(completionHandler);
    }

    public Future<?> submitSessions(List<Session> list, CompletionHandler<PingbackResponse> completionHandler) {
        Intrinsics.checkParameterIsNotNull(list, "sessions");
        Intrinsics.checkParameterIsNotNull(completionHandler, "completionHandler");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(Constants.INSTANCE.getAPI_KEY(), this.apiKey));
        if (!list.isEmpty()) {
            hashMapOf.put(Constants.INSTANCE.getPINGBACK_ID(), list.get(0).getUser().getUserId());
        }
        Map plus = MapsKt.plus(MapsKt.hashMapOf(TuplesKt.m181to(Constants.INSTANCE.getCONTENT_TYPE(), this.applicationJson)), (HashMap) GiphyPingbacks.INSTANCE.getAdditionalHeaders());
        Uri pingback_server_url = Constants.INSTANCE.getPINGBACK_SERVER_URL();
        Intrinsics.checkExpressionValueIsNotNull(pingback_server_url, "Constants.PINGBACK_SERVER_URL");
        return postStringConnectionWithRandomId(pingback_server_url, Constants.Paths.INSTANCE.getPINGBACK(), HTTP_POST, PingbackResponse.class, hashMapOf, plus, new SessionsRequestData(list)).executeAsyncTask(completionHandler);
    }

    public ApiTask<RandomIdResponse> randomIdTask() {
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.m181to(Constants.INSTANCE.getAPI_KEY(), this.apiKey));
        Map plus = MapsKt.plus(MapsKt.hashMapOf(TuplesKt.m181to(Constants.INSTANCE.getCONTENT_TYPE(), this.applicationJson)), (HashMap) GiphyPingbacks.INSTANCE.getAdditionalHeaders());
        NetworkSession networkSession2 = this.networkSession;
        Uri server_url = Constants.INSTANCE.getSERVER_URL();
        Intrinsics.checkExpressionValueIsNotNull(server_url, "Constants.SERVER_URL");
        return networkSession2.queryStringConnection(server_url, Constants.Paths.INSTANCE.getRANDOM_ID(), HTTP_GET, RandomIdResponse.class, hashMapOf, plus);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.giphy.sdk.analytics.network.response.GenericResponse> com.giphy.sdk.analytics.threading.ApiTask<T> postStringConnectionWithRandomId(android.net.Uri r13, java.lang.String r14, java.lang.String r15, java.lang.Class<T> r16, java.util.Map<java.lang.String, java.lang.String> r17, java.util.Map<java.lang.String, java.lang.String> r18, com.giphy.sdk.analytics.models.SessionsRequestData r19) {
        /*
            r12 = this;
            r9 = r12
            java.lang.String r0 = "serverUrl"
            r3 = r13
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
            java.lang.String r0 = "path"
            r4 = r14
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            java.lang.String r0 = "method"
            r5 = r15
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r15, r0)
            java.lang.String r0 = "responseClass"
            r6 = r16
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.String r0 = "requestBody"
            r8 = r19
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.util.List r0 = r19.getSessions()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 0
            r7 = 1
            if (r1 == 0) goto L_0x0038
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0038
        L_0x0036:
            r2 = 1
            goto L_0x0061
        L_0x0038:
            java.util.Iterator r0 = r0.iterator()
        L_0x003c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()
            com.giphy.sdk.analytics.models.Session r1 = (com.giphy.sdk.analytics.models.Session) r1
            com.giphy.sdk.analytics.models.User r1 = r1.getUser()
            java.lang.String r1 = r1.getRandomId()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x005d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r1 = 0
            goto L_0x005e
        L_0x005d:
            r1 = 1
        L_0x005e:
            r1 = r1 ^ r7
            if (r1 != 0) goto L_0x003c
        L_0x0061:
            if (r2 == 0) goto L_0x0075
            com.giphy.sdk.analytics.network.engine.NetworkSession r1 = r9.networkSession
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            com.giphy.sdk.analytics.threading.ApiTask r0 = r1.postStringConnection(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x009b
        L_0x0075:
            com.giphy.sdk.analytics.threading.ApiTask r10 = new com.giphy.sdk.analytics.threading.ApiTask
            com.giphy.sdk.analytics.network.api.GPHPingbackClient$postStringConnectionWithRandomId$2 r11 = new com.giphy.sdk.analytics.network.api.GPHPingbackClient$postStringConnectionWithRandomId$2
            r0 = r11
            r1 = r12
            r2 = r19
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r11 = (java.util.concurrent.Callable) r11
            com.giphy.sdk.analytics.network.engine.NetworkSession r0 = r9.networkSession
            java.util.concurrent.ExecutorService r0 = r0.getNetworkRequestExecutor()
            com.giphy.sdk.analytics.network.engine.NetworkSession r1 = r9.networkSession
            java.util.concurrent.Executor r1 = r1.getCompletionExecutor()
            r10.<init>(r11, r0, r1)
            r0 = r10
        L_0x009b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.giphy.sdk.analytics.network.api.GPHPingbackClient.postStringConnectionWithRandomId(android.net.Uri, java.lang.String, java.lang.String, java.lang.Class, java.util.Map, java.util.Map, com.giphy.sdk.analytics.models.SessionsRequestData):com.giphy.sdk.analytics.threading.ApiTask");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/network/api/GPHPingbackClient$Companion;", "", "()V", "HTTP_GET", "", "HTTP_POST", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
    /* compiled from: GPHPingbackClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
