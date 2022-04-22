package com.getstream.sdk.chat.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import com.getstream.sdk.chat.coil.StreamCoil;
import com.getstream.sdk.chat.images.StreamImageLoader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.getstream.sdk.chat.images.CoilStreamImageLoader$loadAsBitmap$2", mo26808f = "CoilStreamImageLoader.kt", mo26809i = {}, mo26810l = {30}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: CoilStreamImageLoader.kt */
final class CoilStreamImageLoader$loadAsBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ StreamImageLoader.ImageTransformation $transformation;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoilStreamImageLoader$loadAsBitmap$2(String str, Context context, StreamImageLoader.ImageTransformation imageTransformation, Continuation continuation) {
        super(2, continuation);
        this.$url = str;
        this.$context = context;
        this.$transformation = imageTransformation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CoilStreamImageLoader$loadAsBitmap$2(this.$url, this.$context, this.$transformation, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CoilStreamImageLoader$loadAsBitmap$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$url;
            if (Boxing.boxBoolean(StringsKt.isBlank(str)).booleanValue()) {
                str = null;
            }
            if (str == null) {
                return null;
            }
            ImageLoader imageLoader$stream_chat_android_ui_common_release = StreamCoil.INSTANCE.imageLoader$stream_chat_android_ui_common_release(this.$context);
            ImageRequest build = CoilStreamImageLoader.INSTANCE.applyTransformation(new ImageRequest.Builder(this.$context).data(str), this.$transformation).build();
            this.label = 1;
            obj = imageLoader$stream_chat_android_ui_common_release.execute(build, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Drawable drawable = ((ImageResult) obj).getDrawable();
        if (!(drawable instanceof BitmapDrawable)) {
            drawable = null;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getBitmap();
        }
        return null;
    }
}
