package com.memes.plus.p040ui.profile.user_profile;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.memes.commons.media.MediaType;
import com.memes.commons.util.ActivityStarter;
import com.memes.plus.p040ui.media_viewer.MediaViewerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileFragment$loadProfileImage$1 */
/* compiled from: UserProfileFragment.kt */
final class UserProfileFragment$loadProfileImage$1 implements View.OnClickListener {
    final /* synthetic */ String $imagePath;
    final /* synthetic */ UserProfileFragment this$0;

    UserProfileFragment$loadProfileImage$1(UserProfileFragment userProfileFragment, String str) {
        this.this$0 = userProfileFragment;
        this.$imagePath = str;
    }

    public final void onClick(View view) {
        MediaViewerActivity.Companion companion = MediaViewerActivity.Companion;
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ActivityStarter.Companion.mo57312of(companion.getStartIntent(requireContext, MediaType.NETWORK_PHOTO, this.$imagePath)).startFrom((Fragment) this.this$0);
    }
}
