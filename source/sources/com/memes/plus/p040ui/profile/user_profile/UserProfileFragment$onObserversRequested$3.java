package com.memes.plus.p040ui.profile.user_profile;

import android.widget.Button;
import androidx.lifecycle.Observer;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.databinding.UserProfileFragmentBinding;
import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$onObserversRequested$3 */
/* compiled from: UserProfileFragment.kt */
final class UserProfileFragment$onObserversRequested$3<T> implements Observer<AdapterUpdate<Post>> {
    final /* synthetic */ UserProfileFragment this$0;

    UserProfileFragment$onObserversRequested$3(UserProfileFragment userProfileFragment) {
        this.this$0 = userProfileFragment;
    }

    public final void onChanged(AdapterUpdate<Post> adapterUpdate) {
        Button button = ((UserProfileFragmentBinding) this.this$0.getBinding()).seeAllPostsButton;
        Intrinsics.checkNotNullExpressionValue(button, "getBinding().seeAllPostsButton");
        button.setVisibility(adapterUpdate.count() >= 20 ? 0 : 8);
        UserProfileFragment.access$getPostsStaggeredAdapter$p(this.this$0).applyAdapterUpdate(adapterUpdate.keepOnly(20));
    }
}
