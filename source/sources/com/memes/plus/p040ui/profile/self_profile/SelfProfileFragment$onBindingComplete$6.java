package com.memes.plus.p040ui.profile.self_profile;

import android.view.View;
import com.google.android.material.tabs.TabLayout;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.databinding.SelfProfileFragmentBinding;
import com.memes.plus.p040ui.profile.profile_posts.ProfilePostsFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileFragment$onBindingComplete$6 */
/* compiled from: SelfProfileFragment.kt */
final class SelfProfileFragment$onBindingComplete$6 implements View.OnClickListener {
    final /* synthetic */ SelfProfileFragment this$0;

    SelfProfileFragment$onBindingComplete$6(SelfProfileFragment selfProfileFragment) {
        this.this$0 = selfProfileFragment;
    }

    public final void onClick(View view) {
        ActivityHandle activityHandle = this.this$0.getActivityHandle();
        ProfilePostsFragment.Companion companion = ProfilePostsFragment.Companion;
        TabLayout tabLayout = ((SelfProfileFragmentBinding) this.this$0.getBinding()).postsTabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "getBinding().postsTabLayout");
        ActivityHandle.DefaultImpls.replaceFragment$default(activityHandle, ProfilePostsFragment.Companion.newInstance$default(companion, tabLayout.getSelectedTabPosition(), 0, 2, (Object) null), ProfilePostsFragment.TAG, false, 4, (Object) null);
    }
}
