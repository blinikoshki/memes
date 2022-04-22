package com.giphy.sdk.p013ui.views;

import android.content.Context;
import android.view.View;
import com.giphy.sdk.p013ui.utils.GifUtils;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GPHMediaActionsView$viewOnGiphyAction$1 */
/* compiled from: GPHMediaActionsView.kt */
final class GPHMediaActionsView$viewOnGiphyAction$1 implements View.OnClickListener {
    final /* synthetic */ GPHMediaActionsView this$0;

    GPHMediaActionsView$viewOnGiphyAction$1(GPHMediaActionsView gPHMediaActionsView) {
        this.this$0 = gPHMediaActionsView;
    }

    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        if (context != null) {
            context.startActivity(GifUtils.INSTANCE.getViewGifIntent(this.this$0.getMedia()));
        }
        this.this$0.dismiss();
    }
}
