package com.giphy.sdk.p013ui.views;

import android.view.View;
import com.giphy.sdk.p013ui.views.GiphyDialogFragment;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, mo26107d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$onViewCreated$7 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$onViewCreated$7 implements View.OnLayoutChangeListener {
    final /* synthetic */ GiphyDialogFragment this$0;

    GiphyDialogFragment$onViewCreated$7(GiphyDialogFragment giphyDialogFragment) {
        this.this$0 = giphyDialogFragment;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GPHMediaActionsView access$getGiphyActionsView$p = this.this$0.giphyActionsView;
        if (access$getGiphyActionsView$p != null) {
            access$getGiphyActionsView$p.dismiss();
        }
        if (i8 != i4) {
            GiphyDialogFragment.KeyboardState keyboardState = i8 > i4 ? GiphyDialogFragment.KeyboardState.OPEN : GiphyDialogFragment.KeyboardState.CLOSED;
            if (keyboardState != this.this$0.keyboardState) {
                this.this$0.setKeyboardState(keyboardState);
            }
        }
    }
}
