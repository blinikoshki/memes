package com.giphy.sdk.analytics;

import com.giphy.sdk.analytics.models.RandomId;
import com.giphy.sdk.analytics.network.api.GPHPingbackClient;
import com.giphy.sdk.analytics.network.engine.NetworkSession;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "call"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: GiphyPingbacks.kt */
final class GiphyPingbacks$fetchAndStoreRandomIdTask$1<V> implements Callable<String> {
    public static final GiphyPingbacks$fetchAndStoreRandomIdTask$1 INSTANCE = new GiphyPingbacks$fetchAndStoreRandomIdTask$1();

    GiphyPingbacks$fetchAndStoreRandomIdTask$1() {
    }

    public final String call() {
        String str = null;
        String str2 = null;
        try {
            RandomId data = new GPHPingbackClient(GiphyPingbacks.access$getApiKey$p(GiphyPingbacks.INSTANCE), (NetworkSession) null, 2, (DefaultConstructorMarker) null).randomIdTask().executeImmediately().getData();
            if (data != null) {
                str = data.getRandomId();
            }
            if (str == null) {
                return str;
            }
            try {
                GiphyPingbacks.INSTANCE.storeRandomId(str);
                return str;
            } catch (Exception unused) {
                str2 = str;
            }
        } catch (Exception unused2) {
            return str2;
        }
    }
}
