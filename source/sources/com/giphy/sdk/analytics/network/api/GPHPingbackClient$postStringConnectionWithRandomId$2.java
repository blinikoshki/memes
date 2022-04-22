package com.giphy.sdk.analytics.network.api;

import android.net.Uri;
import com.giphy.sdk.analytics.GiphyPingbacks;
import com.giphy.sdk.analytics.models.Session;
import com.giphy.sdk.analytics.models.SessionsRequestData;
import com.giphy.sdk.analytics.network.response.GenericResponse;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "T", "Lcom/giphy/sdk/analytics/network/response/GenericResponse;", "call", "()Lcom/giphy/sdk/analytics/network/response/GenericResponse;"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: GPHPingbackClient.kt */
final class GPHPingbackClient$postStringConnectionWithRandomId$2<V> implements Callable<T> {
    final /* synthetic */ Map $headers;
    final /* synthetic */ String $method;
    final /* synthetic */ String $path;
    final /* synthetic */ Map $queryStrings;
    final /* synthetic */ SessionsRequestData $requestBody;
    final /* synthetic */ Class $responseClass;
    final /* synthetic */ Uri $serverUrl;
    final /* synthetic */ GPHPingbackClient this$0;

    GPHPingbackClient$postStringConnectionWithRandomId$2(GPHPingbackClient gPHPingbackClient, SessionsRequestData sessionsRequestData, Uri uri, String str, String str2, Class cls, Map map, Map map2) {
        this.this$0 = gPHPingbackClient;
        this.$requestBody = sessionsRequestData;
        this.$serverUrl = uri;
        this.$path = str;
        this.$method = str2;
        this.$responseClass = cls;
        this.$queryStrings = map;
        this.$headers = map2;
    }

    public final T call() {
        String randomId = GiphyPingbacks.INSTANCE.getRandomId();
        CharSequence charSequence = randomId;
        if (charSequence == null || charSequence.length() == 0) {
            randomId = GiphyPingbacks.INSTANCE.fetchAndStoreRandomIdTask().executeImmediately();
        }
        if (randomId != null) {
            for (Session user : this.$requestBody.getSessions()) {
                user.getUser().setRandomId(randomId);
            }
        }
        return (GenericResponse) this.this$0.getNetworkSession().postStringConnection(this.$serverUrl, this.$path, this.$method, this.$responseClass, this.$queryStrings, this.$headers, this.$requestBody).executeImmediately();
    }
}
