package com.memes.plus.p040ui.profile.profile_posts;

import androidx.lifecycle.Observer;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.databinding.ProfilePostsFragmentBinding;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.PostsLinearAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "adapterUpdate", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsFragment$onObserversRequested$4 */
/* compiled from: ProfilePostsFragment.kt */
final class ProfilePostsFragment$onObserversRequested$4<T> implements Observer<AdapterUpdate<Post>> {
    final /* synthetic */ Ref.ObjectRef $targetPostPosition;
    final /* synthetic */ ProfilePostsFragment this$0;

    ProfilePostsFragment$onObserversRequested$4(ProfilePostsFragment profilePostsFragment, Ref.ObjectRef objectRef) {
        this.this$0 = profilePostsFragment;
        this.$targetPostPosition = objectRef;
    }

    public final void onChanged(AdapterUpdate<Post> adapterUpdate) {
        PostsLinearAdapter access$getPostsLinearAdapter$p = ProfilePostsFragment.access$getPostsLinearAdapter$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(adapterUpdate, "adapterUpdate");
        access$getPostsLinearAdapter$p.applyPostsAdapterUpdate(adapterUpdate);
        Integer num = (Integer) this.$targetPostPosition.element;
        if (num != null && num.intValue() > 0) {
            ((ProfilePostsFragmentBinding) this.this$0.getBinding()).postsRecyclerView.scrollToPosition(num.intValue());
            this.$targetPostPosition.element = 0;
        }
    }
}
