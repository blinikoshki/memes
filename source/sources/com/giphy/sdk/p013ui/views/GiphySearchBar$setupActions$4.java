package com.giphy.sdk.p013ui.views;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo26107d2 = {"<anonymous>", "", "view", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphySearchBar$setupActions$4 */
/* compiled from: GiphySearchBar.kt */
final class GiphySearchBar$setupActions$4 implements TextView.OnEditorActionListener {
    final /* synthetic */ GiphySearchBar this$0;

    GiphySearchBar$setupActions$4(GiphySearchBar giphySearchBar) {
        this.this$0 = giphySearchBar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3 && i != 0 && i != 2) {
            return false;
        }
        if (!this.this$0.getHideKeyboardOnSearch()) {
            return true;
        }
        this.this$0.dismissKeyboard();
        return true;
    }
}
