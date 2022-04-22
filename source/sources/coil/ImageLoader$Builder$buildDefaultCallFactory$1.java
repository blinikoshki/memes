package coil;

import android.content.Context;
import coil.ImageLoader;
import coil.util.CoilUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lokhttp3/Call$Factory;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: ImageLoader.kt */
final class ImageLoader$Builder$buildDefaultCallFactory$1 extends Lambda implements Function0<Call.Factory> {
    final /* synthetic */ ImageLoader.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageLoader$Builder$buildDefaultCallFactory$1(ImageLoader.Builder builder) {
        super(0);
        this.this$0 = builder;
    }

    public final Call.Factory invoke() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Context access$getApplicationContext$p = this.this$0.applicationContext;
        Intrinsics.checkNotNullExpressionValue(access$getApplicationContext$p, "applicationContext");
        OkHttpClient build = builder.cache(CoilUtils.createDefaultCache(access$getApplicationContext$p)).build();
        Intrinsics.checkNotNullExpressionValue(build, "OkHttpClient.Builder()\n …\n                .build()");
        return build;
    }
}
