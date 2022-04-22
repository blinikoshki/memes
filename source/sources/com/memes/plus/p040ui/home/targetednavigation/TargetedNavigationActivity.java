package com.memes.plus.p040ui.home.targetednavigation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.TargetedNavigationActivityBinding;
import com.memes.plus.p040ui.profile.ProfileFragmentProxy;
import com.memes.plus.p040ui.tagged_posts.TaggedPostsFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tools.targetednavigation.TargetedNavigation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/home/targetednavigation/TargetedNavigationActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/TargetedNavigationActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/TargetedNavigationActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "consumeStartPage", "", "fragmentContainerId", "", "loadProfilePageNavigation", "request", "Ltools/targetednavigation/TargetedNavigation$ProfilePageRequest;", "loadTaggedPostsNavigation", "Ltools/targetednavigation/TargetedNavigation$HashTagPageRequest;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.targetednavigation.TargetedNavigationActivity */
/* compiled from: TargetedNavigationActivity.kt */
public final class TargetedNavigationActivity extends BaseActivity {
    private final Lazy binding$delegate = LazyKt.lazy(new TargetedNavigationActivity$binding$2(this));

    private final TargetedNavigationActivityBinding getBinding() {
        return (TargetedNavigationActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TargetedNavigationActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        consumeStartPage();
    }

    public int fragmentContainerId() {
        FragmentContainerView fragmentContainerView = getBinding().fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "binding.fragmentContainer");
        return fragmentContainerView.getId();
    }

    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private final void consumeStartPage() {
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent != null ? intent.getParcelableExtra(TargetedNavigation.EXTRA_TARGET_PARCEL) : null;
        if (parcelableExtra == null) {
            finish();
        } else if (parcelableExtra instanceof TargetedNavigation.ProfilePageRequest) {
            loadProfilePageNavigation((TargetedNavigation.ProfilePageRequest) parcelableExtra);
        } else if (parcelableExtra instanceof TargetedNavigation.HashTagPageRequest) {
            loadTaggedPostsNavigation((TargetedNavigation.HashTagPageRequest) parcelableExtra);
        }
    }

    private final void loadProfilePageNavigation(TargetedNavigation.ProfilePageRequest profilePageRequest) {
        ActivityHandle.DefaultImpls.replaceFragment$default(this, ProfileFragmentProxy.INSTANCE.newInstance(profilePageRequest.getTargetUserId(), profilePageRequest.getTargetUserName()), ProfileFragmentProxy.TAG, false, 4, (Object) null);
    }

    private final void loadTaggedPostsNavigation(TargetedNavigation.HashTagPageRequest hashTagPageRequest) {
        ActivityHandle.DefaultImpls.replaceFragment$default(this, TaggedPostsFragment.Companion.newInstance(hashTagPageRequest.getHashTag()), TaggedPostsFragment.TAG, false, 4, (Object) null);
    }
}
