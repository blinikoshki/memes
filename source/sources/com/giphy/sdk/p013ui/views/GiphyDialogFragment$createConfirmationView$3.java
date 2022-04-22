package com.giphy.sdk.p013ui.views;

import android.view.View;
import com.giphy.sdk.p013ui.C1800R;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$createConfirmationView$3 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$createConfirmationView$3 implements View.OnClickListener {
    final /* synthetic */ GiphyDialogFragment this$0;

    GiphyDialogFragment$createConfirmationView$3(GiphyDialogFragment giphyDialogFragment) {
        this.this$0 = giphyDialogFragment;
    }

    public final void onClick(View view) {
        GiphyDialogFragment giphyDialogFragment = this.this$0;
        GifView gifView = (GifView) giphyDialogFragment._$_findCachedViewById(C1800R.C1803id.gphGifView);
        giphyDialogFragment.openGiphyApp(gifView != null ? gifView.getMedia() : null);
    }
}
