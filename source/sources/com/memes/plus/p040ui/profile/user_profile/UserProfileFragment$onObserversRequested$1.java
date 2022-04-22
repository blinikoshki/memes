package com.memes.plus.p040ui.profile.user_profile;

import com.memes.commons.output.OutputTargetGenerator;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/profile/user_profile/UserProfileViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$onObserversRequested$1 */
/* compiled from: UserProfileFragment.kt */
final class UserProfileFragment$onObserversRequested$1 extends Lambda implements Function0<UserProfileViewModel> {
    final /* synthetic */ UserProfileFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserProfileFragment$onObserversRequested$1(UserProfileFragment userProfileFragment) {
        super(0);
        this.this$0 = userProfileFragment;
    }

    public final UserProfileViewModel invoke() {
        return new UserProfileViewModel(this.this$0.targetUserId, this.this$0.targetUserName, RepositoryInjection.INSTANCE.memesRepository(), OutputTargetGenerator.Companion.fromMemesDirectory());
    }
}
