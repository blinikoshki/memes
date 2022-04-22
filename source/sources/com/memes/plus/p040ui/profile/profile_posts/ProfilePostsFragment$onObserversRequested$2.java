package com.memes.plus.p040ui.profile.profile_posts;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.ProfilePostsFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "userName", "", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsFragment$onObserversRequested$2 */
/* compiled from: ProfilePostsFragment.kt */
final class ProfilePostsFragment$onObserversRequested$2<T> implements Observer<String> {
    final /* synthetic */ ProfilePostsFragment this$0;

    ProfilePostsFragment$onObserversRequested$2(ProfilePostsFragment profilePostsFragment) {
        this.this$0 = profilePostsFragment;
    }

    public final void onChanged(String str) {
        CharSequence charSequence;
        TextView textView = ((ProfilePostsFragmentBinding) this.this$0.getBinding()).topBarLayout.topBarTitleTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "getBinding().topBarLayout.topBarTitleTextView");
        CharSequence charSequence2 = str;
        if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
            charSequence = this.this$0.getString(C4199R.string.format_user_posts, str);
        }
        textView.setText(charSequence);
    }
}
