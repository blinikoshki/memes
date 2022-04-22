package com.getstream.sdk.chat.coil;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "intercept"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.coil.StreamImageLoaderFactory$newImageLoader$1$cacheControlInterceptor$1 */
/* compiled from: StreamImageLoaderFactory.kt */
final class C1709xdbaca4f6 implements Interceptor {
    public static final C1709xdbaca4f6 INSTANCE = new C1709xdbaca4f6();

    C1709xdbaca4f6() {
    }

    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request()).newBuilder().header(HttpHeaders.CACHE_CONTROL, "max-age=3600,public").build();
    }
}
