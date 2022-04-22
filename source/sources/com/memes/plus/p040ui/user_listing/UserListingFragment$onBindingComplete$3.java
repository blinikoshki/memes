package com.memes.plus.p040ui.user_listing;

import android.view.View;
import android.widget.EditText;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.databinding.UserListingFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UserListingFragment$onBindingComplete$3 */
/* compiled from: UserListingFragment.kt */
final class UserListingFragment$onBindingComplete$3 implements View.OnClickListener {
    final /* synthetic */ UserListingFragment this$0;

    UserListingFragment$onBindingComplete$3(UserListingFragment userListingFragment) {
        this.this$0 = userListingFragment;
    }

    public final void onClick(View view) {
        EditText editText = ((UserListingFragmentBinding) this.this$0.getBinding()).searchBoxLayout.searchEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "getBinding().searchBoxLayout.searchEditText");
        ExtensionsKt.clearText(editText);
    }
}
