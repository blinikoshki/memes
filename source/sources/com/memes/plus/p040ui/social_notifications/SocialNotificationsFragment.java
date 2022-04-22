package com.memes.plus.p040ui.social_notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.C4199R;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.bottom_navigation.BaseBottomNavigationFragment;
import com.memes.plus.base.upgrades.ResettableScroll;
import com.memes.plus.databinding.SocialNotificationsTabFragmentBinding;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.p040ui.posts.post.PostFragment;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import com.memes.plus.p040ui.profile.ProfileFragmentProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u00013B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\u0010\u00101\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0016J\b\u00102\u001a\u00020\u0018H\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsFragment;", "Lcom/memes/plus/base/bottom_navigation/BaseBottomNavigationFragment;", "Lcom/memes/plus/databinding/SocialNotificationsTabFragmentBinding;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapterListener;", "Lcom/memes/plus/base/upgrades/ResettableScroll;", "()V", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "notificationsAdapter", "Lcom/memes/plus/ui/social_notifications/SocialNotificationsAdapter;", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "getPostOperationsViewModel", "()Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "postOperationsViewModel$delegate", "Lkotlin/Lazy;", "socialNotificationsViewModel", "Lcom/memes/plus/ui/social_notifications/SocialNotificationsViewModel;", "getSocialNotificationsViewModel", "()Lcom/memes/plus/ui/social_notifications/SocialNotificationsViewModel;", "socialNotificationsViewModel$delegate", "afterViewCreated", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onFollowNotificationAuthorViewTapped", "notification", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "onNewPostNotificationContentViewTapped", "onObserversRequested", "onRefresh", "onSocialNotificationAuthorViewTapped", "resetScroll", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsFragment */
/* compiled from: SocialNotificationsFragment.kt */
public final class SocialNotificationsFragment extends BaseBottomNavigationFragment<SocialNotificationsTabFragmentBinding> implements ContentLayout.Callback, SwipeRefreshLayout.OnRefreshListener, SocialNotificationsAdapterListener, ResettableScroll {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "SocialNotificationsFragment";
    private LinearLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public SocialNotificationsAdapter notificationsAdapter;
    private final Lazy postOperationsViewModel$delegate = LazyKt.lazy(new SocialNotificationsFragment$postOperationsViewModel$2(this));
    private final Lazy socialNotificationsViewModel$delegate = LazyKt.lazy(new SocialNotificationsFragment$socialNotificationsViewModel$2(this));

    private final PostOperationsViewModel getPostOperationsViewModel() {
        return (PostOperationsViewModel) this.postOperationsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SocialNotificationsViewModel getSocialNotificationsViewModel() {
        return (SocialNotificationsViewModel) this.socialNotificationsViewModel$delegate.getValue();
    }

    public static final /* synthetic */ SocialNotificationsAdapter access$getNotificationsAdapter$p(SocialNotificationsFragment socialNotificationsFragment) {
        SocialNotificationsAdapter socialNotificationsAdapter = socialNotificationsFragment.notificationsAdapter;
        if (socialNotificationsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsAdapter");
        }
        return socialNotificationsAdapter;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/memes/plus/ui/social_notifications/SocialNotificationsFragment;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsFragment$Companion */
    /* compiled from: SocialNotificationsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SocialNotificationsFragment newInstance() {
            return new SocialNotificationsFragment();
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        enableEventBus();
        super.onAttach(context);
    }

    public SocialNotificationsTabFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        SocialNotificationsTabFragmentBinding inflate = SocialNotificationsTabFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "SocialNotificationsTabFr…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((SocialNotificationsTabFragmentBinding) getBinding()).contentLayout.setCallback(this);
        ((SocialNotificationsTabFragmentBinding) getBinding()).swipeRefreshLayout.setOnRefreshListener(this);
        ((SocialNotificationsTabFragmentBinding) getBinding()).includedTopBar.topBarTitleTextView.setText(C4199R.string.notifications);
        ((SocialNotificationsTabFragmentBinding) getBinding()).includedTopBar.topBarBackImageView.setOnClickListener(new SocialNotificationsFragment$onBindingComplete$1(this));
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = ((SocialNotificationsTabFragmentBinding) getBinding()).notificationsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().notificationsRecyclerView");
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        ((SocialNotificationsTabFragmentBinding) getBinding()).notificationsRecyclerView.clearOnScrollListeners();
        RecyclerView recyclerView2 = ((SocialNotificationsTabFragmentBinding) getBinding()).notificationsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().notificationsRecyclerView");
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        ExtensionsKt.addPaginator(recyclerView2, linearLayoutManager2, new SocialNotificationsFragment$onBindingComplete$2(this));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.notificationsAdapter = new SocialNotificationsAdapter(requireContext, this);
        RecyclerView recyclerView3 = ((SocialNotificationsTabFragmentBinding) getBinding()).notificationsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "getBinding().notificationsRecyclerView");
        SocialNotificationsAdapter socialNotificationsAdapter = this.notificationsAdapter;
        if (socialNotificationsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsAdapter");
        }
        recyclerView3.setAdapter(socialNotificationsAdapter);
        ((SocialNotificationsTabFragmentBinding) getBinding()).notificationsRecyclerView.setHasFixedSize(true);
    }

    public void onObserversRequested() {
        getActivityHandle().registerViewModel(getSocialNotificationsViewModel());
        getSocialNotificationsViewModel().getContentVisibilityLiveData().observe(getViewLifecycleOwner(), new SocialNotificationsFragment$onObserversRequested$1(this));
        getSocialNotificationsViewModel().getSwipeRefreshLayoutLiveData().observe(getViewLifecycleOwner(), new SocialNotificationsFragment$onObserversRequested$2(this));
        getSocialNotificationsViewModel().getNotificationsLiveData().observe(getViewLifecycleOwner(), new SocialNotificationsFragment$onObserversRequested$3(this));
        getPostOperationsViewModel().userFollowUpdated().observe(getViewLifecycleOwner(), new SocialNotificationsFragment$onObserversRequested$4(this));
    }

    public void afterViewCreated() {
        SocialNotificationsAdapter socialNotificationsAdapter = this.notificationsAdapter;
        if (socialNotificationsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsAdapter");
        }
        if (socialNotificationsAdapter.hasNoPage()) {
            SocialNotificationsViewModel.fetchSocialNotifications$default(getSocialNotificationsViewModel(), false, 1, (Object) null);
        }
    }

    public void onRefresh() {
        getSocialNotificationsViewModel().fetchSocialNotifications(true);
    }

    public void resetScroll() {
        ((SocialNotificationsTabFragmentBinding) getBinding()).notificationsRecyclerView.smoothScrollToPosition(0);
    }

    public void onSocialNotificationAuthorViewTapped(SocialNotification socialNotification) {
        Intrinsics.checkNotNullParameter(socialNotification, "notification");
        ActivityHandle.DefaultImpls.replaceFragment$default(getActivityHandle(), ProfileFragmentProxy.INSTANCE.newInstance(socialNotification.getAuthorId(), socialNotification.getAuthorUserName()), ProfileFragmentProxy.TAG, false, 4, (Object) null);
    }

    public void onNewPostNotificationContentViewTapped(SocialNotification socialNotification) {
        Intrinsics.checkNotNullParameter(socialNotification, "notification");
        ActivityHandle.DefaultImpls.replaceFragment$default(getActivityHandle(), PostFragment.Companion.newInstance(socialNotification.getDataId()), PostFragment.TAG, false, 4, (Object) null);
    }

    public void onFollowNotificationAuthorViewTapped(SocialNotification socialNotification) {
        Intrinsics.checkNotNullParameter(socialNotification, "notification");
        getPostOperationsViewModel().toggleFollowUser(socialNotification);
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((SocialNotificationsTabFragmentBinding) getBinding()).contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            SocialNotificationsViewModel.fetchSocialNotifications$default(getSocialNotificationsViewModel(), false, 1, (Object) null);
        } else {
            super.onContentLayoutErrorResolutionButtonTapped(i, i2);
        }
    }

    public void onEventReceived(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        if (!notifiableEvent.consumedBy(virtualId())) {
            notifiableEvent.consume(virtualId());
            if (this.notificationsAdapter != null) {
                if (notifiableEvent instanceof UserFollowEvent) {
                    SocialNotificationsAdapter socialNotificationsAdapter = this.notificationsAdapter;
                    if (socialNotificationsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationsAdapter");
                    }
                    socialNotificationsAdapter.consume((UserFollowEvent) notifiableEvent);
                } else if (notifiableEvent instanceof PostDeletedEvent) {
                    SocialNotificationsAdapter socialNotificationsAdapter2 = this.notificationsAdapter;
                    if (socialNotificationsAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationsAdapter");
                    }
                    socialNotificationsAdapter2.consume((PostDeletedEvent) notifiableEvent);
                } else {
                    super.onEventReceived(notifiableEvent);
                }
            }
        }
    }
}
