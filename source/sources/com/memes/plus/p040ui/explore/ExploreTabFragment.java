package com.memes.plus.p040ui.explore;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.App;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.base.bottom_navigation.BaseBottomNavigationFragment;
import com.memes.plus.base.upgrades.OnFragmentBackPressed;
import com.memes.plus.base.upgrades.ResettableScroll;
import com.memes.plus.databinding.TopPostsTabFragmentBinding;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.integrations.facebook.FacebookIntegrationViewModel;
import com.memes.plus.p040ui.posts.PostAction;
import com.memes.plus.p040ui.posts.PostsLayoutSwitcher;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001@B\u0005¢\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0002J\u001a\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u00020!H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u000200H\u0016J\b\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020!H\u0016J\u0010\u0010<\u001a\u00020!2\u0006\u00109\u001a\u000200H\u0016J\b\u0010=\u001a\u00020!H\u0016J\b\u0010>\u001a\u00020!H\u0016J\b\u0010?\u001a\u00020!H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000¨\u0006A"}, mo26107d2 = {"Lcom/memes/plus/ui/explore/ExploreTabFragment;", "Lcom/memes/plus/base/bottom_navigation/BaseBottomNavigationFragment;", "Lcom/memes/plus/databinding/TopPostsTabFragmentBinding;", "Lcom/memes/plus/base/upgrades/OnFragmentBackPressed;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "Lcom/memes/plus/base/upgrades/ResettableScroll;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/memes/plus/ui/posts/PostsLayoutSwitcher$Callback;", "()V", "exploreViewModel", "Lcom/memes/plus/ui/explore/ExploreViewModel;", "getExploreViewModel", "()Lcom/memes/plus/ui/explore/ExploreViewModel;", "exploreViewModel$delegate", "Lkotlin/Lazy;", "facebookIntegrationViewModel", "Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "getFacebookIntegrationViewModel", "()Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "facebookIntegrationViewModel$delegate", "postActionHandler", "Lcom/memes/plus/ui/posts/PostAction$Handler;", "getPostActionHandler", "()Lcom/memes/plus/ui/posts/PostAction$Handler;", "postActionHandler$delegate", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "getPostOperationsViewModel", "()Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "postOperationsViewModel$delegate", "postsLayoutSwitcher", "Lcom/memes/plus/ui/posts/PostsLayoutSwitcher;", "afterViewCreated", "", "attachPostOperationsObservers", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onDestroy", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onFragmentBackPressed", "", "onLoadMorePosts", "viewingMode", "onObserversRequested", "onPause", "onPostViewingModeChanged", "onRefresh", "onResume", "resetScroll", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore.ExploreTabFragment */
/* compiled from: ExploreTabFragment.kt */
public final class ExploreTabFragment extends BaseBottomNavigationFragment<TopPostsTabFragmentBinding> implements OnFragmentBackPressed, ContentLayout.Callback, ResettableScroll, SwipeRefreshLayout.OnRefreshListener, PostsLayoutSwitcher.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "TopPostsTabFragment";
    private final Lazy exploreViewModel$delegate = LazyKt.lazy(new ExploreTabFragment$exploreViewModel$2(this));
    private final Lazy facebookIntegrationViewModel$delegate = LazyKt.lazy(new ExploreTabFragment$facebookIntegrationViewModel$2(this));
    private final Lazy postActionHandler$delegate = LazyKt.lazy(new ExploreTabFragment$postActionHandler$2(this));
    private final Lazy postOperationsViewModel$delegate = LazyKt.lazy(new ExploreTabFragment$postOperationsViewModel$2(this));
    /* access modifiers changed from: private */
    public PostsLayoutSwitcher postsLayoutSwitcher;

    private final ExploreViewModel getExploreViewModel() {
        return (ExploreViewModel) this.exploreViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FacebookIntegrationViewModel getFacebookIntegrationViewModel() {
        return (FacebookIntegrationViewModel) this.facebookIntegrationViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PostAction.Handler getPostActionHandler() {
        return (PostAction.Handler) this.postActionHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PostOperationsViewModel getPostOperationsViewModel() {
        return (PostOperationsViewModel) this.postOperationsViewModel$delegate.getValue();
    }

    public static final /* synthetic */ PostsLayoutSwitcher access$getPostsLayoutSwitcher$p(ExploreTabFragment exploreTabFragment) {
        PostsLayoutSwitcher postsLayoutSwitcher2 = exploreTabFragment.postsLayoutSwitcher;
        if (postsLayoutSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        return postsLayoutSwitcher2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/explore/ExploreTabFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/memes/plus/ui/explore/ExploreTabFragment;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore.ExploreTabFragment$Companion */
    /* compiled from: ExploreTabFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExploreTabFragment newInstance() {
            return new ExploreTabFragment();
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        enableEventBus();
        super.onAttach(context);
    }

    public TopPostsTabFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        TopPostsTabFragmentBinding inflate = TopPostsTabFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "TopPostsTabFragmentBindi…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((TopPostsTabFragmentBinding) getBinding()).topPostsContentLayout.setCallback(this);
        ((TopPostsTabFragmentBinding) getBinding()).swipeRefreshLayout.setOnRefreshListener(this);
        if (this.postsLayoutSwitcher == null) {
            RecyclerView recyclerView = ((TopPostsTabFragmentBinding) getBinding()).topPostsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().topPostsRecyclerView");
            this.postsLayoutSwitcher = new PostsLayoutSwitcher(recyclerView, getPostActionHandler(), this);
        } else {
            PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
            if (postsLayoutSwitcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
            }
            RecyclerView recyclerView2 = ((TopPostsTabFragmentBinding) getBinding()).topPostsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().topPostsRecyclerView");
            postsLayoutSwitcher2.setRecyclerView(recyclerView2);
            PostsLayoutSwitcher postsLayoutSwitcher3 = this.postsLayoutSwitcher;
            if (postsLayoutSwitcher3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
            }
            postsLayoutSwitcher3.setPostActionListener(getPostActionHandler());
            PostsLayoutSwitcher postsLayoutSwitcher4 = this.postsLayoutSwitcher;
            if (postsLayoutSwitcher4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
            }
            postsLayoutSwitcher4.setCallback(this);
        }
        ((TopPostsTabFragmentBinding) getBinding()).includedSearchBoxMaskLayout.searchMaskLayout.setOnClickListener(new ExploreTabFragment$onBindingComplete$2(this));
        PostsLayoutSwitcher postsLayoutSwitcher5 = this.postsLayoutSwitcher;
        if (postsLayoutSwitcher5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        PostsLayoutSwitcher.initPostsLayoutHelper$default(postsLayoutSwitcher5, 2, false, 2, (Object) null);
    }

    public void onObserversRequested() {
        getActivityHandle().registerViewModel(getExploreViewModel());
        getExploreViewModel().getContentVisibilityLiveData().observe(getViewLifecycleOwner(), new ExploreTabFragment$onObserversRequested$1(this));
        getExploreViewModel().getSwipeRefreshLayoutLiveData().observe(getViewLifecycleOwner(), new ExploreTabFragment$onObserversRequested$2(this));
        getExploreViewModel().getTopPostsLiveData().observe(getViewLifecycleOwner(), new ExploreTabFragment$onObserversRequested$3(this));
        attachPostOperationsObservers();
    }

    public void afterViewCreated() {
        PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
        if (postsLayoutSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        if (postsLayoutSwitcher2.hasNoPage()) {
            ExploreViewModel.fetchTopPosts$default(getExploreViewModel(), false, 1, (Object) null);
        }
    }

    public void onPause() {
        if (this.postsLayoutSwitcher != null) {
            PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
            if (postsLayoutSwitcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
            }
            postsLayoutSwitcher2.pause();
        }
        super.onPause();
    }

    public void onResume() {
        if (this.postsLayoutSwitcher != null) {
            PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
            if (postsLayoutSwitcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
            }
            postsLayoutSwitcher2.resume();
        }
        setSelectedBottomNavigationTab(1);
        super.onResume();
    }

    public void onDestroy() {
        BaseFragment baseFragment = this;
        if (baseFragment.hasBinding()) {
            TopPostsTabFragmentBinding topPostsTabFragmentBinding = (TopPostsTabFragmentBinding) baseFragment.getBinding();
            if (this.postsLayoutSwitcher != null) {
                PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
                if (postsLayoutSwitcher2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
                }
                postsLayoutSwitcher2.destroy();
            }
        } else {
            Timber.m303e("safeBinding() prevented a null-binding call.", new Object[0]);
        }
        super.onDestroy();
    }

    public void onPostViewingModeChanged(int i) {
        if (i == 2) {
            LinearLayout linearLayout = ((TopPostsTabFragmentBinding) getBinding()).includedSearchBoxMaskLayout.searchMaskLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "getBinding().includedSea…skLayout.searchMaskLayout");
            linearLayout.setVisibility(0);
            App.Companion.trackingManager().onExploreGridUiViewed();
        } else if (i == 1) {
            LinearLayout linearLayout2 = ((TopPostsTabFragmentBinding) getBinding()).includedSearchBoxMaskLayout.searchMaskLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "getBinding().includedSea…skLayout.searchMaskLayout");
            linearLayout2.setVisibility(8);
            App.Companion.trackingManager().onExploreLinearUiViewed();
        }
    }

    public void onLoadMorePosts(int i) {
        ExploreViewModel.fetchTopPosts$default(getExploreViewModel(), false, 1, (Object) null);
    }

    public boolean onFragmentBackPressed() {
        PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
        if (postsLayoutSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        return postsLayoutSwitcher2.handleBackAction();
    }

    public void onRefresh() {
        PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
        if (postsLayoutSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        postsLayoutSwitcher2.resetPaginator();
        getExploreViewModel().fetchTopPosts(true);
    }

    public void resetScroll() {
        if (hasBinding()) {
            PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
            if (postsLayoutSwitcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
            }
            postsLayoutSwitcher2.resetToStaggeredLayout();
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((TopPostsTabFragmentBinding) getBinding()).topPostsContentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().topPostsContentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            ExploreViewModel.fetchTopPosts$default(getExploreViewModel(), false, 1, (Object) null);
        } else {
            super.onContentLayoutErrorResolutionButtonTapped(i, i2);
        }
    }

    public void onEventReceived(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        if (!notifiableEvent.consumedBy(virtualId())) {
            notifiableEvent.consume(virtualId());
            if (this.postsLayoutSwitcher != null) {
                PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
                if (postsLayoutSwitcher2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
                }
                if (!postsLayoutSwitcher2.consume(notifiableEvent)) {
                    super.onEventReceived(notifiableEvent);
                }
            }
        }
    }

    private final void attachPostOperationsObservers() {
        getPostOperationsViewModel().postLikeUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$1(this));
        getPostOperationsViewModel().postSaveUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$2(this));
        getPostOperationsViewModel().postDeleteUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$3(this));
        getPostOperationsViewModel().postReportUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$4(this));
        getPostOperationsViewModel().postNotificationsUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$5(this));
        getPostOperationsViewModel().userFollowUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$6(this));
        getPostOperationsViewModel().postShareUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$7(this));
        getPostOperationsViewModel().postContentDownloadUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$8(this));
        getPostOperationsViewModel().postRepostUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$9(this));
        getPostOperationsViewModel().postTaggedUsersUpdated().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$10(this));
        getPostOperationsViewModel().postCommentLikeUpdated().observe(this, new ExploreTabFragment$attachPostOperationsObservers$11(this));
        getPostOperationsViewModel().playbackSoundSetting().observe(getViewLifecycleOwner(), new ExploreTabFragment$attachPostOperationsObservers$12(this));
    }
}
