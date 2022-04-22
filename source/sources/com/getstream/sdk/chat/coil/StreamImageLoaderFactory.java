package com.getstream.sdk.chat.coil;

import android.content.Context;
import android.os.Build;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.ImageLoaderFactory;
import coil.decode.Decoder;
import coil.decode.GifDecoder;
import coil.decode.ImageDecoderDecoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u001f\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/coil/StreamImageLoaderFactory;", "Lcoil/ImageLoaderFactory;", "context", "Landroid/content/Context;", "builder", "Lkotlin/Function1;", "Lcoil/ImageLoader$Builder;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "newImageLoader", "Lcoil/ImageLoader;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StreamImageLoaderFactory.kt */
public final class StreamImageLoaderFactory implements ImageLoaderFactory {
    private final Function1<ImageLoader.Builder, Unit> builder;
    /* access modifiers changed from: private */
    public final Context context;

    public StreamImageLoaderFactory(Context context2, Function1<? super ImageLoader.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "builder");
        this.context = context2;
        this.builder = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StreamImageLoaderFactory(Context context2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i & 2) != 0 ? C17081.INSTANCE : function1);
    }

    public ImageLoader newImageLoader() {
        ImageLoader.Builder okHttpClient = new ImageLoader.Builder(this.context).availableMemoryPercentage(0.25d).allowHardware(false).crossfade(true).okHttpClient((Function0<? extends OkHttpClient>) new StreamImageLoaderFactory$newImageLoader$1(this));
        ComponentRegistry.Builder builder2 = new ComponentRegistry.Builder();
        if (Build.VERSION.SDK_INT >= 28) {
            builder2.add((Decoder) new ImageDecoderDecoder());
        } else {
            builder2.add((Decoder) new GifDecoder());
        }
        Unit unit = Unit.INSTANCE;
        ImageLoader.Builder componentRegistry = okHttpClient.componentRegistry(builder2.build());
        this.builder.invoke(componentRegistry);
        return componentRegistry.build();
    }
}
