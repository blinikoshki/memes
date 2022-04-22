package com.giphy.sdk.p013ui.views.buttons;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo26107d2 = {"com/giphy/sdk/ui/views/buttons/GPHGifButton$roundCornersProvider$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.buttons.GPHGifButton$roundCornersProvider$1 */
/* compiled from: GPHGifButton.kt */
public final class GPHGifButton$roundCornersProvider$1 extends ViewOutlineProvider {
    final /* synthetic */ GPHGifButton this$0;

    GPHGifButton$roundCornersProvider$1(GPHGifButton gPHGifButton) {
        this.this$0 = gPHGifButton;
    }

    public void getOutline(View view, Outline outline) {
        if (outline != null) {
            outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), this.this$0.getStyle().getRounded$ui_sdk_release() ? (float) IntExtensionsKt.getPx(this.this$0.defaultCornerRadius) : 0.0f);
        }
        if (view != null) {
            view.setClipToOutline(true);
        }
    }
}
