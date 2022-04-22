package com.memes.plus.p040ui.home.feeds;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayoutMediator;
import com.memes.plus.databinding.HomeActivityBinding;
import com.memes.plus.events.EventNotifier;
import com.memes.plus.events.ScrollState;
import com.memes.plus.p040ui.home.feeds.HomeFeedsManager$pageChangeCallback$2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/ui/home/feeds/HomeFeedsManager;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "binding", "Lcom/memes/plus/databinding/HomeActivityBinding;", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/memes/plus/databinding/HomeActivityBinding;)V", "pageChangeCallback", "com/memes/plus/ui/home/feeds/HomeFeedsManager$pageChangeCallback$2$1", "getPageChangeCallback", "()Lcom/memes/plus/ui/home/feeds/HomeFeedsManager$pageChangeCallback$2$1;", "pageChangeCallback$delegate", "Lkotlin/Lazy;", "expandAppBarLayout", "", "initViewPager", "resetScroll", "setInvitesViewTapListener", "listener", "Landroid/view/View$OnClickListener;", "setShownFeedType", "feedType", "Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "setSocialNotificationButtonTapListener", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.feeds.HomeFeedsManager */
/* compiled from: HomeFeedsManager.kt */
public final class HomeFeedsManager {
    private final AppCompatActivity activity;
    private final HomeActivityBinding binding;
    private final Lazy pageChangeCallback$delegate = LazyKt.lazy(new HomeFeedsManager$pageChangeCallback$2(this));

    private final HomeFeedsManager$pageChangeCallback$2.C42701 getPageChangeCallback() {
        return (HomeFeedsManager$pageChangeCallback$2.C42701) this.pageChangeCallback$delegate.getValue();
    }

    public HomeFeedsManager(AppCompatActivity appCompatActivity, HomeActivityBinding homeActivityBinding) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(homeActivityBinding, "binding");
        this.activity = appCompatActivity;
        this.binding = homeActivityBinding;
        initViewPager();
        homeActivityBinding.includedHomePostsBar.headerMemeImageView.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ HomeFeedsManager this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.resetScroll();
            }
        });
    }

    private final void initViewPager() {
        HomeFeedsPagerAdapter homeFeedsPagerAdapter = new HomeFeedsPagerAdapter(this.activity);
        ViewPager2 viewPager2 = this.binding.postsViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.postsViewPager");
        viewPager2.setAdapter(homeFeedsPagerAdapter);
        new TabLayoutMediator(this.binding.includedHomePostsBar.homeTabLayout, this.binding.postsViewPager, new HomeFeedsManager$initViewPager$1(homeFeedsPagerAdapter)).attach();
        this.binding.postsViewPager.registerOnPageChangeCallback(getPageChangeCallback());
    }

    public final void setShownFeedType(HomeFeedType homeFeedType) {
        Intrinsics.checkNotNullParameter(homeFeedType, "feedType");
        ViewPager2 viewPager2 = this.binding.postsViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.postsViewPager");
        viewPager2.setCurrentItem(homeFeedType.getPosition());
    }

    public final void setSocialNotificationButtonTapListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.binding.includedHomePostsBar.socialNotifiationsImageView.setOnClickListener(onClickListener);
    }

    public final void setInvitesViewTapListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.binding.includedHomePostsBar.inviteTextView.setOnClickListener(onClickListener);
    }

    public final void resetScroll() {
        FrameLayout frameLayout = this.binding.fragmentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fragmentContainer");
        if (!(frameLayout.getVisibility() == 0)) {
            EventNotifier.INSTANCE.notifyPostScroll(ScrollState.RESET);
            expandAppBarLayout();
        }
    }

    /* access modifiers changed from: private */
    public final void expandAppBarLayout() {
        this.binding.includedHomePostsBar.appBarLayout.setExpanded(true, true);
    }
}
