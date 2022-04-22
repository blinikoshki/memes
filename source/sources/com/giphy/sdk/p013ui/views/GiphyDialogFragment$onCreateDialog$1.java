package com.giphy.sdk.p013ui.views;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import com.giphy.sdk.p013ui.views.GiphyDialogFragment;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$onCreateDialog$1 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$onCreateDialog$1 implements DialogInterface.OnShowListener {
    final /* synthetic */ GiphyDialogFragment this$0;

    GiphyDialogFragment$onCreateDialog$1(GiphyDialogFragment giphyDialogFragment) {
        this.this$0 = giphyDialogFragment;
    }

    public final void onShow(DialogInterface dialogInterface) {
        GiphyDialogFragment giphyDialogFragment = this.this$0;
        giphyDialogFragment.fullBaseViewHeight = GiphyDialogFragment.access$getBaseView$p(giphyDialogFragment).getHeight();
        int i = GiphyDialogFragment.WhenMappings.$EnumSwitchMapping$1[GiphyDialogFragment.access$getGiphySettings$p(this.this$0).getGridType().ordinal()];
        if (i == 1 || i == 2) {
            this.this$0.openAnimator.setFloatValues(new float[]{(float) this.this$0.fullBaseViewHeight, ((float) this.this$0.fullBaseViewHeight) * 0.25f});
        } else if (i == 3) {
            this.this$0.openAnimator.setFloatValues(new float[]{((float) this.this$0.fullBaseViewHeight) - ((float) GiphyDialogFragment.access$getGifsRecyclerView$p(this.this$0).getTop()), 0.0f});
        }
        ValueAnimator access$getOpenAnimator$p = this.this$0.openAnimator;
        if (access$getOpenAnimator$p != null) {
            access$getOpenAnimator$p.start();
        }
    }
}
