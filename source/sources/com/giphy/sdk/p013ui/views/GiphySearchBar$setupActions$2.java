package com.giphy.sdk.p013ui.views;

import android.view.View;
import android.widget.EditText;
import com.giphy.sdk.p013ui.C1800R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphySearchBar$setupActions$2 */
/* compiled from: GiphySearchBar.kt */
final class GiphySearchBar$setupActions$2 implements View.OnClickListener {
    final /* synthetic */ GiphySearchBar this$0;

    GiphySearchBar$setupActions$2(GiphySearchBar giphySearchBar) {
        this.this$0 = giphySearchBar;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C1800R.C1803id.searchInput);
        Intrinsics.checkExpressionValueIsNotNull(editText, "searchInput");
        editText.setText((CharSequence) null);
    }
}
