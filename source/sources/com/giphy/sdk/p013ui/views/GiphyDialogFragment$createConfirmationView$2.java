package com.giphy.sdk.p013ui.views;

import android.view.View;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.p013ui.C1800R;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$createConfirmationView$2 */
/* compiled from: GiphyDialogFragment.kt */
final class GiphyDialogFragment$createConfirmationView$2 implements View.OnClickListener {
    final /* synthetic */ GiphyDialogFragment this$0;

    GiphyDialogFragment$createConfirmationView$2(GiphyDialogFragment giphyDialogFragment) {
        this.this$0 = giphyDialogFragment;
    }

    public final void onClick(View view) {
        Media media;
        GifView gifView = (GifView) this.this$0._$_findCachedViewById(C1800R.C1803id.gphGifView);
        if (gifView != null && (media = gifView.getMedia()) != null) {
            this.this$0.deliverGif(media);
        }
    }
}
