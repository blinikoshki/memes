package com.getstream.sdk.chat.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bJU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&¢\u0006\u0002\u0010\u000eJ-\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015JU\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&¢\u0006\u0002\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, mo26107d2 = {"Lcom/getstream/sdk/chat/images/StreamImageLoader;", "", "load", "", "target", "Landroid/widget/ImageView;", "data", "placeholderResId", "", "transformation", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;", "onStart", "Lkotlin/Function0;", "onComplete", "(Landroid/widget/ImageView;Ljava/lang/Object;Ljava/lang/Integer;Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "loadAsBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadVideoThumbnail", "uri", "Landroid/net/Uri;", "(Landroid/widget/ImageView;Landroid/net/Uri;Ljava/lang/Integer;Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Companion", "ImageTransformation", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StreamImageLoader.kt */
public interface StreamImageLoader {
    public static final Companion Companion = Companion.$$INSTANCE;

    void load(ImageView imageView, Object obj, Integer num, ImageTransformation imageTransformation, Function0<Unit> function0, Function0<Unit> function02);

    Object loadAsBitmap(Context context, String str, ImageTransformation imageTransformation, Continuation<? super Bitmap> continuation);

    void loadVideoThumbnail(ImageView imageView, Uri uri, Integer num, ImageTransformation imageTransformation, Function0<Unit> function0, Function0<Unit> function02);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/getstream/sdk/chat/images/StreamImageLoader$Companion;", "", "()V", "instance", "Lcom/getstream/sdk/chat/images/StreamImageLoader;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: StreamImageLoader.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final StreamImageLoader instance() {
            return CoilStreamImageLoader.INSTANCE;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: StreamImageLoader.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void load$default(StreamImageLoader streamImageLoader, ImageView imageView, Object obj, Integer num, ImageTransformation imageTransformation, Function0 function0, Function0 function02, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    num = null;
                }
                Integer num2 = num;
                if ((i & 8) != 0) {
                    imageTransformation = ImageTransformation.None.INSTANCE;
                }
                ImageTransformation imageTransformation2 = imageTransformation;
                if ((i & 16) != 0) {
                    function0 = StreamImageLoader$load$1.INSTANCE;
                }
                Function0 function03 = function0;
                if ((i & 32) != 0) {
                    function02 = StreamImageLoader$load$2.INSTANCE;
                }
                streamImageLoader.load(imageView, obj, num2, imageTransformation2, function03, function02);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
        }

        public static /* synthetic */ void loadVideoThumbnail$default(StreamImageLoader streamImageLoader, ImageView imageView, Uri uri, Integer num, ImageTransformation imageTransformation, Function0 function0, Function0 function02, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    num = null;
                }
                Integer num2 = num;
                if ((i & 8) != 0) {
                    imageTransformation = ImageTransformation.None.INSTANCE;
                }
                ImageTransformation imageTransformation2 = imageTransformation;
                if ((i & 16) != 0) {
                    function0 = StreamImageLoader$loadVideoThumbnail$1.INSTANCE;
                }
                Function0 function03 = function0;
                if ((i & 32) != 0) {
                    function02 = StreamImageLoader$loadVideoThumbnail$2.INSTANCE;
                }
                streamImageLoader.loadVideoThumbnail(imageView, uri, num2, imageTransformation2, function03, function02);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadVideoThumbnail");
        }

        public static /* synthetic */ Object loadAsBitmap$default(StreamImageLoader streamImageLoader, Context context, String str, ImageTransformation imageTransformation, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    imageTransformation = ImageTransformation.None.INSTANCE;
                }
                return streamImageLoader.loadAsBitmap(context, str, imageTransformation, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAsBitmap");
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;", "", "()V", "Circle", "None", "RoundedCorners", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation$None;", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation$Circle;", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation$RoundedCorners;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: StreamImageLoader.kt */
    public static abstract class ImageTransformation {

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation$None;", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: StreamImageLoader.kt */
        public static final class None extends ImageTransformation {
            public static final None INSTANCE = new None();

            private None() {
                super((DefaultConstructorMarker) null);
            }
        }

        private ImageTransformation() {
        }

        public /* synthetic */ ImageTransformation(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation$Circle;", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;", "()V", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: StreamImageLoader.kt */
        public static final class Circle extends ImageTransformation {
            public static final Circle INSTANCE = new Circle();

            private Circle() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation$RoundedCorners;", "Lcom/getstream/sdk/chat/images/StreamImageLoader$ImageTransformation;", "radius", "", "(F)V", "getRadius", "()F", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* compiled from: StreamImageLoader.kt */
        public static final class RoundedCorners extends ImageTransformation {
            private final float radius;

            public RoundedCorners(float f) {
                super((DefaultConstructorMarker) null);
                this.radius = f;
            }

            public final float getRadius() {
                return this.radius;
            }
        }
    }
}
