package com.getstream.sdk.chat.coil;

import android.content.Context;
import coil.ImageLoader;
import coil.ImageLoaderFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0002\b\fJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\u0004*\u00020\b8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, mo26107d2 = {"Lcom/getstream/sdk/chat/coil/StreamCoil;", "", "()V", "imageLoader", "Lcoil/ImageLoader;", "imageLoaderFactory", "Lcoil/ImageLoaderFactory;", "streamImageLoader", "Landroid/content/Context;", "getStreamImageLoader$stream_chat_android_ui_common_release", "(Landroid/content/Context;)Lcoil/ImageLoader;", "context", "imageLoader$stream_chat_android_ui_common_release", "newImageLoader", "newImageLoaderFactory", "setImageLoader", "", "factory", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StreamCoil.kt */
public final class StreamCoil {
    public static final StreamCoil INSTANCE = new StreamCoil();
    private static ImageLoader imageLoader;
    private static ImageLoaderFactory imageLoaderFactory;

    private StreamCoil() {
    }

    public final synchronized void setImageLoader(ImageLoaderFactory imageLoaderFactory2) {
        Intrinsics.checkNotNullParameter(imageLoaderFactory2, "factory");
        imageLoaderFactory = imageLoaderFactory2;
        imageLoader = null;
    }

    public final ImageLoader imageLoader$stream_chat_android_ui_common_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageLoader imageLoader2 = imageLoader;
        return imageLoader2 != null ? imageLoader2 : newImageLoader(context);
    }

    private final synchronized ImageLoader newImageLoader(Context context) {
        ImageLoader imageLoader2 = imageLoader;
        if (imageLoader2 != null) {
            return imageLoader2;
        }
        ImageLoaderFactory imageLoaderFactory2 = imageLoaderFactory;
        if (imageLoaderFactory2 == null) {
            imageLoaderFactory2 = newImageLoaderFactory(context);
        }
        ImageLoader newImageLoader = imageLoaderFactory2.newImageLoader();
        imageLoader = newImageLoader;
        return newImageLoader;
    }

    private final ImageLoaderFactory newImageLoaderFactory(Context context) {
        ImageLoaderFactory streamImageLoaderFactory = new StreamImageLoaderFactory(context, (Function1) null, 2, (DefaultConstructorMarker) null);
        imageLoaderFactory = streamImageLoaderFactory;
        return streamImageLoaderFactory;
    }

    public final ImageLoader getStreamImageLoader$stream_chat_android_ui_common_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$streamImageLoader");
        return imageLoader$stream_chat_android_ui_common_release(context);
    }
}
