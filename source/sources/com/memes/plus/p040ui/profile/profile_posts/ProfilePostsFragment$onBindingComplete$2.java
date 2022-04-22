package com.memes.plus.p040ui.profile.profile_posts;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsFragment$onBindingComplete$2 */
/* compiled from: ProfilePostsFragment.kt */
final class ProfilePostsFragment$onBindingComplete$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ProfilePostsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfilePostsFragment$onBindingComplete$2(ProfilePostsFragment profilePostsFragment) {
        super(0);
        this.this$0 = profilePostsFragment;
    }

    public final void invoke() {
        ProfilePostsViewModel.fetchPosts$default(ProfilePostsFragment.access$getProfilePostsViewModel$p(this.this$0), false, 1, (Object) null);
    }
}
