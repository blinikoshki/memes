package com.giphy.sdk.p013ui.views;

import android.app.Dialog;
import android.content.Context;
import android.widget.EditText;
import com.giphy.sdk.p013ui.C1800R;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo26107d2 = {"com/giphy/sdk/ui/views/GiphyDialogFragment$onCreateDialog$dialog$1", "Landroid/app/Dialog;", "onBackPressed", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphyDialogFragment$onCreateDialog$dialog$1 */
/* compiled from: GiphyDialogFragment.kt */
public final class GiphyDialogFragment$onCreateDialog$dialog$1 extends Dialog {
    final /* synthetic */ GiphyDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GiphyDialogFragment$onCreateDialog$dialog$1(GiphyDialogFragment giphyDialogFragment, Context context, int i) {
        super(context, i);
        this.this$0 = giphyDialogFragment;
    }

    public void onBackPressed() {
        EditText editText;
        if (this.this$0.isAttributionVisible) {
            this.this$0.hideAttribution();
        } else if (this.this$0.isSearchFocused()) {
            GiphySearchBar access$getSearchBar$p = this.this$0.searchBar;
            if (access$getSearchBar$p != null) {
                access$getSearchBar$p.dismissKeyboard();
            }
        } else {
            CharSequence access$getQuery$p = this.this$0.query;
            if (!(access$getQuery$p == null || access$getQuery$p.length() == 0)) {
                GiphySearchBar access$getSearchBar$p2 = this.this$0.searchBar;
                if (access$getSearchBar$p2 != null) {
                    access$getSearchBar$p2.dismissKeyboard();
                }
                GiphySearchBar access$getSearchBar$p3 = this.this$0.searchBar;
                if (access$getSearchBar$p3 != null && (editText = (EditText) access$getSearchBar$p3._$_findCachedViewById(C1800R.C1803id.searchInput)) != null) {
                    editText.setText((CharSequence) null);
                    return;
                }
                return;
            }
            super.onBackPressed();
        }
    }
}
