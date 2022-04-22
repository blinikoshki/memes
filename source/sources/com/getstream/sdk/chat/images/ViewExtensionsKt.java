package com.getstream.sdk.chat.images;

import android.net.Uri;
import android.widget.ImageView;
import com.getstream.sdk.chat.images.StreamImageLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\f\u001aQ\u0010\r\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, mo26107d2 = {"load", "", "Landroid/widget/ImageView;", "data", "", "placeholderResId", "", "transformation", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;", "onStart", "Lkotlin/Function0;", "onComplete", "(Landroid/widget/ImageView;Ljava/lang/Object;Ljava/lang/Integer;Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "loadVideoThumbnail", "uri", "Landroid/net/Uri;", "(Landroid/widget/ImageView;Landroid/net/Uri;Ljava/lang/Integer;Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: ViewExtensions.kt */
public final class ViewExtensionsKt {
    public static /* synthetic */ void load$default(ImageView imageView, Object obj, Integer num, StreamImageLoader.ImageTransformation imageTransformation, Function0 function0, Function0 function02, int i, Object obj2) {
        if ((i & 2) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            imageTransformation = StreamImageLoader.ImageTransformation.None.INSTANCE;
        }
        StreamImageLoader.ImageTransformation imageTransformation2 = imageTransformation;
        if ((i & 8) != 0) {
            function0 = ViewExtensionsKt$load$1.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 16) != 0) {
            function02 = ViewExtensionsKt$load$2.INSTANCE;
        }
        load(imageView, obj, num2, imageTransformation2, function03, function02);
    }

    @InternalStreamChatApi
    public static final void load(ImageView imageView, Object obj, Integer num, StreamImageLoader.ImageTransformation imageTransformation, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(imageView, "$this$load");
        Intrinsics.checkNotNullParameter(imageTransformation, "transformation");
        Intrinsics.checkNotNullParameter(function0, "onStart");
        Intrinsics.checkNotNullParameter(function02, "onComplete");
        StreamImageLoader.Companion.instance().load(imageView, obj, num, imageTransformation, function0, function02);
    }

    public static /* synthetic */ void loadVideoThumbnail$default(ImageView imageView, Uri uri, Integer num, StreamImageLoader.ImageTransformation imageTransformation, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            imageTransformation = StreamImageLoader.ImageTransformation.None.INSTANCE;
        }
        StreamImageLoader.ImageTransformation imageTransformation2 = imageTransformation;
        if ((i & 8) != 0) {
            function0 = ViewExtensionsKt$loadVideoThumbnail$1.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 16) != 0) {
            function02 = ViewExtensionsKt$loadVideoThumbnail$2.INSTANCE;
        }
        loadVideoThumbnail(imageView, uri, num2, imageTransformation2, function03, function02);
    }

    @InternalStreamChatApi
    public static final void loadVideoThumbnail(ImageView imageView, Uri uri, Integer num, StreamImageLoader.ImageTransformation imageTransformation, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(imageView, "$this$loadVideoThumbnail");
        Intrinsics.checkNotNullParameter(imageTransformation, "transformation");
        Intrinsics.checkNotNullParameter(function0, "onStart");
        Intrinsics.checkNotNullParameter(function02, "onComplete");
        StreamImageLoader.Companion.instance().loadVideoThumbnail(imageView, uri, num, imageTransformation, function0, function02);
    }
}
