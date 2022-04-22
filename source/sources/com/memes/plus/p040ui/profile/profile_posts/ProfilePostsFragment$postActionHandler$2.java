package com.memes.plus.p040ui.profile.profile_posts;

import android.content.Context;
import com.memes.plus.p040ui.posts.PostAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/posts/PostAction$Handler;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsFragment$postActionHandler$2 */
/* compiled from: ProfilePostsFragment.kt */
final class ProfilePostsFragment$postActionHandler$2 extends Lambda implements Function0<PostAction.Handler> {
    final /* synthetic */ ProfilePostsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfilePostsFragment$postActionHandler$2(ProfilePostsFragment profilePostsFragment) {
        super(0);
        this.this$0 = profilePostsFragment;
    }

    public final PostAction.Handler invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ProfilePostsFragment profilePostsFragment = this.this$0;
        return new PostAction.Handler(requireContext, profilePostsFragment, profilePostsFragment.getPostOperationsViewModel(), this.this$0.getFacebookIntegrationViewModel());
    }
}
