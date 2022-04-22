package com.giphy.sdk.p013ui.views;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.giphy.sdk.p013ui.views.GifView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, mo26107d2 = {"com/giphy/sdk/ui/views/GifView$getControllerListener$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFailure", "", "id", "", "throwable", "", "onFinalImageSet", "imageInfo", "anim", "Landroid/graphics/drawable/Animatable;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GifView$getControllerListener$1 */
/* compiled from: GifView.kt */
public final class GifView$getControllerListener$1 extends BaseControllerListener<ImageInfo> {
    final /* synthetic */ GifView this$0;

    GifView$getControllerListener$1(GifView gifView) {
        this.this$0 = gifView;
    }

    public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
        this.this$0.onFinalImageSet(str, imageInfo, animatable);
    }

    public void onFailure(String str, Throwable th) {
        GifView.GifCallback gifCallback = this.this$0.getGifCallback();
        if (gifCallback != null) {
            gifCallback.onFailure(th);
        }
    }
}
