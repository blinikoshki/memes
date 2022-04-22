package com.memes.plus.p040ui.profile.self_profile;

import com.memes.plus.databinding.SelfProfileFragmentBinding;
import com.memes.plus.integrations.screenshots.ProfileScreenshotItem;
import com.memes.plus.integrations.screenshots.ScreenshotItem;
import com.memes.plus.integrations.snapchat.SnapchatIntegrationViewModel;
import com.memes.plus.p040ui.profile.self_profile.header.SelfProfileHeaderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileFragment$onShareProfileToSnapchatButtonTapped$1 */
/* compiled from: SelfProfileFragment.kt */
final class SelfProfileFragment$onShareProfileToSnapchatButtonTapped$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $userProfileId;
    final /* synthetic */ SelfProfileFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfProfileFragment$onShareProfileToSnapchatButtonTapped$1(SelfProfileFragment selfProfileFragment, String str) {
        super(0);
        this.this$0 = selfProfileFragment;
        this.$userProfileId = str;
    }

    public final void invoke() {
        SnapchatIntegrationViewModel access$getSnapchatIntegrationViewModel$p = this.this$0.getSnapchatIntegrationViewModel();
        String str = this.$userProfileId;
        SelfProfileHeaderView selfProfileHeaderView = ((SelfProfileFragmentBinding) this.this$0.getBinding()).profileHeaderView;
        Intrinsics.checkNotNullExpressionValue(selfProfileHeaderView, "getBinding().profileHeaderView");
        access$getSnapchatIntegrationViewModel$p.shareProfile(str, (ScreenshotItem) new ProfileScreenshotItem(selfProfileHeaderView));
    }
}
