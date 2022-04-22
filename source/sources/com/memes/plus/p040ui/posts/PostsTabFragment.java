package com.memes.plus.p040ui.posts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.recycleradapter.AdapterItemCountChangeListener;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.Intents;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.base.upgrades.ResettableScroll;
import com.memes.plus.custom.rv_item_visibility_awarance.ItemVisibilityScrollListener;
import com.memes.plus.databinding.PostsTabFragmentBinding;
import com.memes.plus.events.EventNotifier;
import com.memes.plus.events.FullPostLikedEvent;
import com.memes.plus.events.InviteClosedEvent;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.events.PlayerState;
import com.memes.plus.events.PostCommentDeleteEvent;
import com.memes.plus.events.PostCommentEvent;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.PostEditedEvent;
import com.memes.plus.events.PostPlaybackSoundMuteEvent;
import com.memes.plus.events.PostPlayerEvent;
import com.memes.plus.events.PostPreviewCommentEvent;
import com.memes.plus.events.PostScrollEvent;
import com.memes.plus.events.ScrollState;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.integrations.facebook.FacebookIntegrationViewModel;
import com.memes.plus.p040ui.apprating.AppRatingItemTapListener;
import com.memes.plus.p040ui.home.feeds.HomeFeedType;
import com.memes.plus.p040ui.posts.PostAction;
import com.memes.plus.p040ui.posts.invite.InviteItemTapListener;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import com.memes.plus.util.ExtKt;
import com.memes.plus.util.LocalIntents;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0001GB\u0005¢\u0006\u0002\u0010\tJ\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0002J\u001a\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0018\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0016J\b\u0010:\u001a\u00020(H\u0016J\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020(H\u0016J\b\u0010?\u001a\u00020(H\u0016J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u000208H\u0016J\b\u0010B\u001a\u00020(H\u0016J\b\u0010C\u001a\u00020(H\u0016J\b\u0010D\u001a\u00020(H\u0016J\b\u0010E\u001a\u00020(H\u0016J\b\u0010F\u001a\u00020(H\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000¨\u0006H"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsTabFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/PostsTabFragmentBinding;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "Lcom/memes/plus/base/upgrades/ResettableScroll;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/memes/commons/recycleradapter/AdapterItemCountChangeListener;", "Lcom/memes/plus/ui/posts/invite/InviteItemTapListener;", "Lcom/memes/plus/ui/apprating/AppRatingItemTapListener;", "()V", "facebookIntegrationViewModel", "Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "getFacebookIntegrationViewModel", "()Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "facebookIntegrationViewModel$delegate", "Lkotlin/Lazy;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "paginator", "Lcom/memes/commons/pagination/Paginator;", "postActionHandler", "Lcom/memes/plus/ui/posts/PostAction$Handler;", "getPostActionHandler", "()Lcom/memes/plus/ui/posts/PostAction$Handler;", "postActionHandler$delegate", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "getPostOperationsViewModel", "()Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "postOperationsViewModel$delegate", "postsLinearAdapter", "Lcom/memes/plus/ui/posts/PostsLinearAdapter;", "postsViewModel", "Lcom/memes/plus/ui/posts/PostsViewModel;", "getPostsViewModel", "()Lcom/memes/plus/ui/posts/PostsViewModel;", "postsViewModel$delegate", "visibilityTracker", "Lcom/memes/plus/custom/rv_item_visibility_awarance/ItemVisibilityScrollListener;", "afterViewCreated", "", "attachPostOperationsObservers", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onAppRatingItemTapped", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onDestroy", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onInviteItemClosed", "onInviteItemTapped", "onItemCountChanged", "newCount", "onObserversRequested", "onPause", "onRefresh", "onResume", "resetScroll", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsTabFragment */
/* compiled from: PostsTabFragment.kt */
public final class PostsTabFragment extends BaseFragment<PostsTabFragmentBinding> implements ContentLayout.Callback, ResettableScroll, SwipeRefreshLayout.OnRefreshListener, AdapterItemCountChangeListener, InviteItemTapListener, AppRatingItemTapListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_FEED_TYPE = "intent_extra_feed_type";
    public static final String TAG = "PostsTabFragment";
    private final Lazy facebookIntegrationViewModel$delegate = LazyKt.lazy(new PostsTabFragment$facebookIntegrationViewModel$2(this));
    /* access modifiers changed from: private */
    public LinearLayoutManager layoutManager;
    private Paginator paginator;
    private final Lazy postActionHandler$delegate = LazyKt.lazy(new PostsTabFragment$postActionHandler$2(this));
    private final Lazy postOperationsViewModel$delegate = LazyKt.lazy(new PostsTabFragment$postOperationsViewModel$2(this));
    /* access modifiers changed from: private */
    public PostsLinearAdapter postsLinearAdapter;
    private final Lazy postsViewModel$delegate = LazyKt.lazy(new PostsTabFragment$postsViewModel$2(this));
    private ItemVisibilityScrollListener visibilityTracker;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsTabFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PlayerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PlayerState.PAUSE.ordinal()] = 1;
            iArr[PlayerState.PLAY.ordinal()] = 2;
            int[] iArr2 = new int[ScrollState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ScrollState.RESET.ordinal()] = 1;
        }
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

    /* access modifiers changed from: private */
    public final PostsViewModel getPostsViewModel() {
        return (PostsViewModel) this.postsViewModel$delegate.getValue();
    }

    public static final /* synthetic */ LinearLayoutManager access$getLayoutManager$p(PostsTabFragment postsTabFragment) {
        LinearLayoutManager linearLayoutManager = postsTabFragment.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        return linearLayoutManager;
    }

    public static final /* synthetic */ PostsLinearAdapter access$getPostsLinearAdapter$p(PostsTabFragment postsTabFragment) {
        PostsLinearAdapter postsLinearAdapter2 = postsTabFragment.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        return postsLinearAdapter2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsTabFragment$Companion;", "", "()V", "EXTRA_FEED_TYPE", "", "TAG", "newInstance", "Lcom/memes/plus/ui/posts/PostsTabFragment;", "feedType", "Lcom/memes/plus/ui/home/feeds/HomeFeedType;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsTabFragment$Companion */
    /* compiled from: PostsTabFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostsTabFragment newInstance(HomeFeedType homeFeedType) {
            Intrinsics.checkNotNullParameter(homeFeedType, "feedType");
            Bundle bundle = new Bundle();
            bundle.putSerializable(PostsTabFragment.EXTRA_FEED_TYPE, homeFeedType);
            PostsTabFragment postsTabFragment = new PostsTabFragment();
            postsTabFragment.setArguments(bundle);
            return postsTabFragment;
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        enableEventBus();
        super.onAttach(context);
    }

    public PostsTabFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PostsTabFragmentBinding inflate = PostsTabFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "PostsTabFragmentBinding.…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((PostsTabFragmentBinding) getBinding()).contentLayout.setCallback(this);
        ((PostsTabFragmentBinding) getBinding()).swipeRefreshLayout.setOnRefreshListener(this);
        getPostsViewModel().fetchSuggestedProfiles();
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = ((PostsTabFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().postsRecyclerView");
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        ((PostsTabFragmentBinding) getBinding()).postsRecyclerView.clearOnScrollListeners();
        RecyclerView recyclerView2 = ((PostsTabFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().postsRecyclerView");
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        this.visibilityTracker = ExtKt.addVisibilityTracker(recyclerView2, linearLayoutManager2);
        RecyclerView recyclerView3 = ((PostsTabFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "getBinding().postsRecyclerView");
        LinearLayoutManager linearLayoutManager3 = this.layoutManager;
        if (linearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        this.paginator = ExtensionsKt.addPaginator(recyclerView3, linearLayoutManager3, new PostsTabFragment$onBindingComplete$1(this));
        if (this.postsLinearAdapter == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            PostsLinearAdapter postsLinearAdapter2 = new PostsLinearAdapter(requireContext, getPostActionHandler(), this, this);
            this.postsLinearAdapter = postsLinearAdapter2;
            if (postsLinearAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
            }
            postsLinearAdapter2.setAdapterItemCountChangeListener(this);
        }
        RecyclerView recyclerView4 = ((PostsTabFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "getBinding().postsRecyclerView");
        PostsLinearAdapter postsLinearAdapter3 = this.postsLinearAdapter;
        if (postsLinearAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        recyclerView4.setAdapter(postsLinearAdapter3);
        ((PostsTabFragmentBinding) getBinding()).postsRecyclerView.setHasFixedSize(true);
    }

    public void onObserversRequested() {
        getActivityHandle().registerViewModel(getPostsViewModel());
        getPostsViewModel().getContentVisibilityLiveData().observe(getViewLifecycleOwner(), new PostsTabFragment$onObserversRequested$1(this));
        getPostsViewModel().getSwipeRefreshLayoutLiveData().observe(getViewLifecycleOwner(), new PostsTabFragment$onObserversRequested$2(this));
        getPostsViewModel().getPostsLiveData().observe(getViewLifecycleOwner(), new PostsTabFragment$onObserversRequested$3(this));
        attachPostOperationsObservers();
    }

    public void afterViewCreated() {
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(EXTRA_FEED_TYPE) : null;
        if (!(serializable instanceof HomeFeedType)) {
            serializable = null;
        }
        HomeFeedType homeFeedType = (HomeFeedType) serializable;
        if (homeFeedType != null) {
            getPostsViewModel().setFeedType(homeFeedType);
        }
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        if (postsLinearAdapter2.hasNoPage()) {
            PostsViewModel.fetchPosts$default(getPostsViewModel(), false, 1, (Object) null);
        }
    }

    public void onPause() {
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.pausePlayer();
        super.onPause();
    }

    public void onResume() {
        BaseFragment baseFragment = this;
        if (baseFragment.hasBinding()) {
            PostsTabFragmentBinding postsTabFragmentBinding = (PostsTabFragmentBinding) baseFragment.getBinding();
            if (this.layoutManager != null) {
                Paginator paginator2 = this.paginator;
                if (paginator2 != null) {
                    RecyclerView recyclerView = postsTabFragmentBinding.postsRecyclerView;
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.postsRecyclerView");
                    paginator2.detach(recyclerView);
                }
                RecyclerView recyclerView2 = postsTabFragmentBinding.postsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.postsRecyclerView");
                LinearLayoutManager linearLayoutManager = this.layoutManager;
                if (linearLayoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                }
                this.paginator = ExtensionsKt.addPaginator(recyclerView2, linearLayoutManager, new PostsTabFragment$onResume$$inlined$safeBinding$lambda$1(this));
            }
        } else {
            Timber.m303e("safeBinding() prevented a null-binding call.", new Object[0]);
        }
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.resumePlayer();
        super.onResume();
    }

    public void onDestroy() {
        BaseFragment baseFragment = this;
        if (baseFragment.hasBinding()) {
            PostsTabFragmentBinding postsTabFragmentBinding = (PostsTabFragmentBinding) baseFragment.getBinding();
            if (this.postsLinearAdapter != null) {
                postsTabFragmentBinding.postsRecyclerView.clearOnScrollListeners();
                PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
                if (postsLinearAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                }
                postsLinearAdapter2.releasePlayer();
            }
        } else {
            Timber.m303e("safeBinding() prevented a null-binding call.", new Object[0]);
        }
        super.onDestroy();
    }

    public void onRefresh() {
        Paginator paginator2 = this.paginator;
        if (paginator2 != null) {
            paginator2.resetState();
        }
        getPostsViewModel().fetchPosts(true);
    }

    public void resetScroll() {
        if (hasBinding()) {
            ((PostsTabFragmentBinding) getBinding()).postsRecyclerView.scrollToPosition(0);
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((PostsTabFragmentBinding) getBinding()).contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            PostsViewModel.fetchPosts$default(getPostsViewModel(), false, 1, (Object) null);
        } else {
            super.onContentLayoutErrorResolutionButtonTapped(i, i2);
        }
    }

    public void onItemCountChanged(int i) {
        ItemVisibilityScrollListener itemVisibilityScrollListener = this.visibilityTracker;
        if (itemVisibilityScrollListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visibilityTracker");
        }
        RecyclerView recyclerView = ((PostsTabFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().postsRecyclerView");
        itemVisibilityScrollListener.checkVisibilityChangesOn(recyclerView);
    }

    public void onEventReceived(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        if (!notifiableEvent.consumedBy(virtualId())) {
            notifiableEvent.consume(virtualId());
            if (this.postsLinearAdapter != null) {
                PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
                if (postsLinearAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                }
                if (postsLinearAdapter2.getItemCount() != 0) {
                    if (notifiableEvent instanceof PostPlayerEvent) {
                        int i = WhenMappings.$EnumSwitchMapping$0[((PostPlayerEvent) notifiableEvent).getState().ordinal()];
                        if (i == 1) {
                            PostsLinearAdapter postsLinearAdapter3 = this.postsLinearAdapter;
                            if (postsLinearAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                            }
                            postsLinearAdapter3.pausePlayer();
                        } else if (i == 2) {
                            PostsLinearAdapter postsLinearAdapter4 = this.postsLinearAdapter;
                            if (postsLinearAdapter4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                            }
                            postsLinearAdapter4.resumePlayer();
                        }
                    }
                    if (notifiableEvent instanceof PostScrollEvent) {
                        if (WhenMappings.$EnumSwitchMapping$1[((PostScrollEvent) notifiableEvent).getState().ordinal()] == 1) {
                            resetScroll();
                        }
                    }
                    if (notifiableEvent instanceof FullPostLikedEvent) {
                        PostsLinearAdapter postsLinearAdapter5 = this.postsLinearAdapter;
                        if (postsLinearAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter5.updateLikedFlag(((FullPostLikedEvent) notifiableEvent).getPost());
                    }
                    if (notifiableEvent instanceof InviteClosedEvent) {
                        PostsLinearAdapter postsLinearAdapter6 = this.postsLinearAdapter;
                        if (postsLinearAdapter6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter6.removeInviteBoxes();
                    }
                    if (notifiableEvent instanceof UserFollowEvent) {
                        PostsLinearAdapter postsLinearAdapter7 = this.postsLinearAdapter;
                        if (postsLinearAdapter7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter7.consume((UserFollowEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostDeletedEvent) {
                        PostsLinearAdapter postsLinearAdapter8 = this.postsLinearAdapter;
                        if (postsLinearAdapter8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter8.consume((PostDeletedEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostPreviewCommentEvent) {
                        PostsLinearAdapter postsLinearAdapter9 = this.postsLinearAdapter;
                        if (postsLinearAdapter9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter9.consume((PostPreviewCommentEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostCommentEvent) {
                        PostsLinearAdapter postsLinearAdapter10 = this.postsLinearAdapter;
                        if (postsLinearAdapter10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter10.consume((PostCommentEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostCommentDeleteEvent) {
                        PostsLinearAdapter postsLinearAdapter11 = this.postsLinearAdapter;
                        if (postsLinearAdapter11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter11.consume((PostCommentDeleteEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostEditedEvent) {
                        PostsLinearAdapter postsLinearAdapter12 = this.postsLinearAdapter;
                        if (postsLinearAdapter12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter12.consume((PostEditedEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostPlaybackSoundMuteEvent) {
                        PostsLinearAdapter postsLinearAdapter13 = this.postsLinearAdapter;
                        if (postsLinearAdapter13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter13.consume(((PostPlaybackSoundMuteEvent) notifiableEvent).isMuted());
                    } else {
                        super.onEventReceived(notifiableEvent);
                    }
                }
            }
        }
    }

    public void onInviteItemTapped() {
        LocalIntents localIntents = LocalIntents.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intent inviteFriendsIntent = localIntents.getInviteFriendsIntent(requireContext);
        if (inviteFriendsIntent != null) {
            startActivity(inviteFriendsIntent);
        }
    }

    public void onInviteItemClosed() {
        getPostsViewModel().closeInvite();
        EventNotifier.INSTANCE.notifyInviteClosed();
    }

    public void onAppRatingItemTapped() {
        getPostsViewModel().setAppRatingConfirmed(true);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intent playStoreIntent$default = Intents.getPlayStoreIntent$default(Intents.INSTANCE, requireContext, (String) null, 2, (Object) null);
        if (playStoreIntent$default == null) {
            ExtensionsKt.toast(requireContext, (int) C4199R.string.error_rate_app);
        } else {
            startActivity(playStoreIntent$default);
        }
    }

    private final void attachPostOperationsObservers() {
        getPostOperationsViewModel().postLikeUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$1(this));
        getPostOperationsViewModel().postSaveUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$2(this));
        getPostOperationsViewModel().postDeleteUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$3(this));
        getPostOperationsViewModel().postReportUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$4(this));
        getPostOperationsViewModel().postNotificationsUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$5(this));
        getPostOperationsViewModel().userFollowUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$6(this));
        getPostOperationsViewModel().postShareUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$7(this));
        getPostOperationsViewModel().postContentDownloadUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$8(this));
        getPostOperationsViewModel().postRepostUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$9(this));
        getPostOperationsViewModel().postTaggedUsersUpdated().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$10(this));
        getPostOperationsViewModel().postCommentLikeUpdated().observe(this, new PostsTabFragment$attachPostOperationsObservers$11(this));
        getPostOperationsViewModel().playbackSoundSetting().observe(getViewLifecycleOwner(), new PostsTabFragment$attachPostOperationsObservers$12(this));
    }
}
