package com.memes.plus.p040ui.home;

import androidx.lifecycle.Observer;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "iconPath", "", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.HomeActivity$initObservers$1 */
/* compiled from: HomeActivity.kt */
final class HomeActivity$initObservers$1<T> implements Observer<String> {
    final /* synthetic */ HomeActivity this$0;

    HomeActivity$initObservers$1(HomeActivity homeActivity) {
        this.this$0 = homeActivity;
    }

    public final void onChanged(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.this$0.getBinding().bottomTabsView.setTabIcon(4, (int) C4199R.C4202drawable.placeholder_profile);
        } else {
            this.this$0.getBinding().bottomTabsView.setTabIcon(4, str);
        }
    }
}
