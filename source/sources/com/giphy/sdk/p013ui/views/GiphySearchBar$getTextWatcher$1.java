package com.giphy.sdk.p013ui.views;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo26107d2 = {"com/giphy/sdk/ui/views/GiphySearchBar$getTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.GiphySearchBar$getTextWatcher$1 */
/* compiled from: GiphySearchBar.kt */
public final class GiphySearchBar$getTextWatcher$1 implements TextWatcher {
    final /* synthetic */ GiphySearchBar this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    GiphySearchBar$getTextWatcher$1(GiphySearchBar giphySearchBar) {
        this.this$0 = giphySearchBar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.this$0.applyClearBtnLogic();
    }

    public void afterTextChanged(Editable editable) {
        this.this$0.getGifQueryListener().invoke(String.valueOf(editable));
    }
}
