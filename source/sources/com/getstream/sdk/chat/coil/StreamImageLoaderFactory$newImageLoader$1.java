package com.getstream.sdk.chat.coil;

import coil.util.CoilUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: StreamImageLoaderFactory.kt */
final class StreamImageLoaderFactory$newImageLoader$1 extends Lambda implements Function0<OkHttpClient> {
    final /* synthetic */ StreamImageLoaderFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamImageLoaderFactory$newImageLoader$1(StreamImageLoaderFactory streamImageLoaderFactory) {
        super(0);
        this.this$0 = streamImageLoaderFactory;
    }

    public final OkHttpClient invoke() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(dispatcher.getMaxRequests());
        return new OkHttpClient.Builder().cache(CoilUtils.createDefaultCache(this.this$0.context)).dispatcher(dispatcher).addNetworkInterceptor(C1709xdbaca4f6.INSTANCE).build();
    }
}
