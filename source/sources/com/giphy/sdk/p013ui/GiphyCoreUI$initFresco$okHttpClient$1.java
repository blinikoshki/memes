package com.giphy.sdk.p013ui;

import com.giphy.sdk.core.GiphyCore;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "Lokhttp3/Response;", "kotlin.jvm.PlatformType", "chain", "Lokhttp3/Interceptor$Chain;", "intercept"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.GiphyCoreUI$initFresco$okHttpClient$1 */
/* compiled from: GiphyCoreUI.kt */
final class GiphyCoreUI$initFresco$okHttpClient$1 implements Interceptor {
    public static final GiphyCoreUI$initFresco$okHttpClient$1 INSTANCE = new GiphyCoreUI$initFresco$okHttpClient$1();

    GiphyCoreUI$initFresco$okHttpClient$1() {
    }

    public final Response intercept(Interceptor.Chain chain) {
        Request.Builder newBuilder = chain.request().newBuilder();
        for (Map.Entry entry : GiphyCore.INSTANCE.getAdditionalHeaders().entrySet()) {
            newBuilder.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        return chain.proceed(newBuilder.build());
    }
}
