package com.memes.plus.p040ui.profile.profile_posts;

import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/profile/profile_posts/ProfilePostsViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsFragment$onObserversRequested$1 */
/* compiled from: ProfilePostsFragment.kt */
final class ProfilePostsFragment$onObserversRequested$1 extends Lambda implements Function0<ProfilePostsViewModel> {
    final /* synthetic */ Integer $targetPostTab;
    final /* synthetic */ String $targetUserId;
    final /* synthetic */ String $targetUserName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfilePostsFragment$onObserversRequested$1(String str, String str2, Integer num) {
        super(0);
        this.$targetUserId = str;
        this.$targetUserName = str2;
        this.$targetPostTab = num;
    }

    public final ProfilePostsViewModel invoke() {
        return new ProfilePostsViewModel(this.$targetUserId, this.$targetUserName, this.$targetPostTab, RepositoryInjection.INSTANCE.memesRepository());
    }
}
