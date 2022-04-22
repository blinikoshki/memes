package com.giphy.sdk.core.network.api;

import android.net.Uri;
import com.giphy.sdk.analytics.GiphyPingbacks;
import com.giphy.sdk.core.GiphyCore;
import com.giphy.sdk.core.network.api.GPHApiClient;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, mo26107d2 = {"<anonymous>", "T", "call", "()Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: GPHApiClient.kt */
final class GPHApiClient$queryStringConnectionWrapper$1<V> implements Callable<T> {
    final /* synthetic */ GPHApiClient.HTTPMethod $method;
    final /* synthetic */ String $path;
    final /* synthetic */ Map $queryStrings;
    final /* synthetic */ Class $responseClass;
    final /* synthetic */ Uri $serverUrl;
    final /* synthetic */ GPHApiClient this$0;

    GPHApiClient$queryStringConnectionWrapper$1(GPHApiClient gPHApiClient, Map map, Uri uri, String str, GPHApiClient.HTTPMethod hTTPMethod, Class cls) {
        this.this$0 = gPHApiClient;
        this.$queryStrings = map;
        this.$serverUrl = uri;
        this.$path = str;
        this.$method = hTTPMethod;
        this.$responseClass = cls;
    }

    public final T call() {
        Map map;
        String randomId = GiphyPingbacks.INSTANCE.getRandomId();
        CharSequence charSequence = randomId;
        if (charSequence == null || charSequence.length() == 0) {
            randomId = GiphyPingbacks.INSTANCE.fetchAndStoreRandomIdTask().executeImmediately();
        }
        if (!(randomId == null || (map = this.$queryStrings) == null)) {
            String str = (String) map.put("random_id", randomId);
        }
        return this.this$0.getNetworkSession().queryStringConnection(this.$serverUrl, this.$path, this.$method, this.$responseClass, this.$queryStrings, GiphyCore.INSTANCE.getAdditionalHeaders()).executeImmediately();
    }
}
