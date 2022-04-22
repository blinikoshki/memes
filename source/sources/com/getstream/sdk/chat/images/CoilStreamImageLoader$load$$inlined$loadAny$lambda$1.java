package com.getstream.sdk.chat.images;

import coil.request.ImageRequest;
import coil.request.ImageResult;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.images.StreamImageLoader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r¸\u0006\u000e"}, mo26107d2 = {"coil/request/ImageRequest$Builder$listener$5", "Lcoil/request/ImageRequest$Listener;", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "throwable", "", "onStart", "onSuccess", "metadata", "Lcoil/request/ImageResult$Metadata;", "coil-base_release", "com/getstream/sdk/chat/images/CoilStreamImageLoader$$special$$inlined$listener$1"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ImageRequest.kt */
public final class CoilStreamImageLoader$load$$inlined$loadAny$lambda$1 implements ImageRequest.Listener {
    final /* synthetic */ Function0 $onComplete$inlined;
    final /* synthetic */ Function0 $onStart$inlined;
    final /* synthetic */ Integer $placeholderResId$inlined;
    final /* synthetic */ StreamImageLoader.ImageTransformation $transformation$inlined;

    public CoilStreamImageLoader$load$$inlined$loadAny$lambda$1(Integer num, Function0 function0, Function0 function02, StreamImageLoader.ImageTransformation imageTransformation) {
        this.$placeholderResId$inlined = num;
        this.$onStart$inlined = function0;
        this.$onComplete$inlined = function02;
        this.$transformation$inlined = imageTransformation;
    }

    public void onStart(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        this.$onStart$inlined.invoke();
    }

    public void onCancel(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        this.$onComplete$inlined.invoke();
    }

    public void onError(ImageRequest imageRequest, Throwable th) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(th, "throwable");
        this.$onComplete$inlined.invoke();
    }

    public void onSuccess(ImageRequest imageRequest, ImageResult.Metadata metadata) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(metadata, TtmlNode.TAG_METADATA);
        this.$onComplete$inlined.invoke();
    }
}
