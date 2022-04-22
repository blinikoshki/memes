package com.getstream.sdk.chat.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import coil.ImageLoader;
import coil.fetch.VideoFrameUriFetcher;
import coil.request.ImageRequest;
import coil.transform.CircleCropTransformation;
import coil.transform.RoundedCornersTransformation;
import com.getstream.sdk.chat.coil.StreamCoil;
import com.getstream.sdk.chat.images.StreamImageLoader;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016¢\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017JM\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, mo26107d2 = {"Lcom/getstream/sdk/chat/images/CoilStreamImageLoader;", "Lcom/getstream/sdk/chat/images/StreamImageLoader;", "()V", "load", "", "target", "Landroid/widget/ImageView;", "data", "", "placeholderResId", "", "transformation", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;", "onStart", "Lkotlin/Function0;", "onComplete", "(Landroid/widget/ImageView;Ljava/lang/Object;Ljava/lang/Integer;Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "loadAsBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadVideoThumbnail", "uri", "Landroid/net/Uri;", "(Landroid/widget/ImageView;Landroid/net/Uri;Ljava/lang/Integer;Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "applyTransformation", "Lcoil/request/ImageRequest$Builder;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CoilStreamImageLoader.kt */
public final class CoilStreamImageLoader implements StreamImageLoader {
    public static final CoilStreamImageLoader INSTANCE = new CoilStreamImageLoader();

    private CoilStreamImageLoader() {
    }

    public Object loadAsBitmap(Context context, String str, StreamImageLoader.ImageTransformation imageTransformation, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(DispatcherProvider.INSTANCE.getIO(), new CoilStreamImageLoader$loadAsBitmap$2(str, context, imageTransformation, (Continuation) null), continuation);
    }

    public void load(ImageView imageView, Object obj, Integer num, StreamImageLoader.ImageTransformation imageTransformation, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(imageView, "target");
        Intrinsics.checkNotNullParameter(imageTransformation, "transformation");
        Intrinsics.checkNotNullParameter(function0, "onStart");
        Intrinsics.checkNotNullParameter(function02, "onComplete");
        Context context = imageView.getContext();
        StreamCoil streamCoil = StreamCoil.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageLoader imageLoader$stream_chat_android_ui_common_release = streamCoil.imageLoader$stream_chat_android_ui_common_release(context);
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(obj).target(imageView);
        if (num != null) {
            target.placeholder(num.intValue());
        }
        target.listener(new CoilStreamImageLoader$load$$inlined$loadAny$lambda$1(num, function0, function02, imageTransformation));
        INSTANCE.applyTransformation(target, imageTransformation);
        imageLoader$stream_chat_android_ui_common_release.enqueue(target.build());
    }

    public void loadVideoThumbnail(ImageView imageView, Uri uri, Integer num, StreamImageLoader.ImageTransformation imageTransformation, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(imageView, "target");
        Intrinsics.checkNotNullParameter(imageTransformation, "transformation");
        Intrinsics.checkNotNullParameter(function0, "onStart");
        Intrinsics.checkNotNullParameter(function02, "onComplete");
        Context context = imageView.getContext();
        StreamCoil streamCoil = StreamCoil.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageLoader imageLoader$stream_chat_android_ui_common_release = streamCoil.imageLoader$stream_chat_android_ui_common_release(context);
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(uri).target(imageView);
        if (num != null) {
            target.placeholder(num.intValue());
        }
        target.listener(new C1710xc14049a7(num, function0, function02, context, imageTransformation));
        target.fetcher(new VideoFrameUriFetcher(context), Uri.class);
        INSTANCE.applyTransformation(target, imageTransformation);
        imageLoader$stream_chat_android_ui_common_release.enqueue(target.build());
    }

    /* access modifiers changed from: private */
    public final ImageRequest.Builder applyTransformation(ImageRequest.Builder builder, StreamImageLoader.ImageTransformation imageTransformation) {
        if (imageTransformation instanceof StreamImageLoader.ImageTransformation.None) {
            return builder;
        }
        if (imageTransformation instanceof StreamImageLoader.ImageTransformation.Circle) {
            return builder.transformations(new CircleCropTransformation());
        } else if (imageTransformation instanceof StreamImageLoader.ImageTransformation.RoundedCorners) {
            return builder.transformations(new RoundedCornersTransformation(((StreamImageLoader.ImageTransformation.RoundedCorners) imageTransformation).getRadius()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
