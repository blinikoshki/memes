package com.memes.plus.p040ui.posts.post;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.C4199R;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.databinding.PostFragmentBinding;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.events.PostCommentDeleteEvent;
import com.memes.plus.events.PostCommentEvent;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.PostPlaybackSoundMuteEvent;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.integrations.facebook.FacebookIntegrationViewModel;
import com.memes.plus.p040ui.apprating.AppRatingItemTapListener;
import com.memes.plus.p040ui.posts.PostAction;
import com.memes.plus.p040ui.posts.PostsLinearAdapter;
import com.memes.plus.p040ui.posts.invite.InviteItemTapListener;
import com.memes.plus.p040ui.posts.post_basics.PostOperationsViewModel;
import com.memes.plus.util.ExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00014B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020\u001cH\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u001cH\u0016J\b\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\u001cH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u00065"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post/PostFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/PostFragmentBinding;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "facebookIntegrationViewModel", "Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "getFacebookIntegrationViewModel", "()Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "facebookIntegrationViewModel$delegate", "Lkotlin/Lazy;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "postActionHandler", "Lcom/memes/plus/ui/posts/PostAction$Handler;", "getPostActionHandler", "()Lcom/memes/plus/ui/posts/PostAction$Handler;", "postActionHandler$delegate", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "getPostOperationsViewModel", "()Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "postOperationsViewModel$delegate", "postViewModel", "Lcom/memes/plus/ui/posts/post/PostViewModel;", "postsLinearAdapter", "Lcom/memes/plus/ui/posts/PostsLinearAdapter;", "afterViewCreated", "", "attachPostOperationsObservers", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onDestroy", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onObserversRequested", "onPause", "onResume", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post.PostFragment */
/* compiled from: PostFragment.kt */
public final class PostFragment extends BaseFragment<PostFragmentBinding> implements ContentLayout.Callback {
    private static final String ARG_POST_ID = "argument_post_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "PostFragment";
    private final Lazy facebookIntegrationViewModel$delegate = LazyKt.lazy(new PostFragment$facebookIntegrationViewModel$2(this));
    private LinearLayoutManager layoutManager;
    private final Lazy postActionHandler$delegate = LazyKt.lazy(new PostFragment$postActionHandler$2(this));
    private final Lazy postOperationsViewModel$delegate = LazyKt.lazy(new PostFragment$postOperationsViewModel$2(this));
    private PostViewModel postViewModel;
    /* access modifiers changed from: private */
    public PostsLinearAdapter postsLinearAdapter;

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

    public static final /* synthetic */ PostsLinearAdapter access$getPostsLinearAdapter$p(PostFragment postFragment) {
        PostsLinearAdapter postsLinearAdapter2 = postFragment.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        return postsLinearAdapter2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/post/PostFragment$Companion;", "", "()V", "ARG_POST_ID", "", "TAG", "newInstance", "Lcom/memes/plus/ui/posts/post/PostFragment;", "postId", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.post.PostFragment$Companion */
    /* compiled from: PostFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostFragment newInstance(String str) {
            Bundle bundle = new Bundle();
            bundle.putString(PostFragment.ARG_POST_ID, str);
            PostFragment postFragment = new PostFragment();
            postFragment.setArguments(bundle);
            return postFragment;
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        enableEventBus();
        super.onAttach(context);
    }

    public PostFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PostFragmentBinding inflate = PostFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "PostFragmentBinding.infl…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((PostFragmentBinding) getBinding()).contentLayout.setCallback(this);
        ((PostFragmentBinding) getBinding()).includedTopBar.topBarTitleTextView.setText(C4199R.string.post);
        ((PostFragmentBinding) getBinding()).includedTopBar.topBarBackImageView.setOnClickListener(new PostFragment$onBindingComplete$1(this));
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = ((PostFragmentBinding) getBinding()).postAndCommentsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().postAndCommentsRecyclerView");
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        ((PostFragmentBinding) getBinding()).postAndCommentsRecyclerView.clearOnScrollListeners();
        RecyclerView recyclerView2 = ((PostFragmentBinding) getBinding()).postAndCommentsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().postAndCommentsRecyclerView");
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        ExtKt.addVisibilityTracker(recyclerView2, linearLayoutManager2);
        if (this.postsLinearAdapter == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            this.postsLinearAdapter = new PostsLinearAdapter(requireContext, getPostActionHandler(), (InviteItemTapListener) null, (AppRatingItemTapListener) null, 12, (DefaultConstructorMarker) null);
        }
        RecyclerView recyclerView3 = ((PostFragmentBinding) getBinding()).postAndCommentsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "getBinding().postAndCommentsRecyclerView");
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        recyclerView3.setAdapter(postsLinearAdapter2);
        ((PostFragmentBinding) getBinding()).postAndCommentsRecyclerView.setHasFixedSize(true);
    }

    public void onObserversRequested() {
        Bundle arguments = getArguments();
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new BaseViewModelFactory(new PostFragment$onObserversRequested$1(arguments != null ? arguments.getString(ARG_POST_ID) : null))).get(PostViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        this.postViewModel = (PostViewModel) viewModel;
        ActivityHandle activityHandle = getActivityHandle();
        PostViewModel postViewModel2 = this.postViewModel;
        if (postViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postViewModel");
        }
        activityHandle.registerViewModel(postViewModel2);
        PostViewModel postViewModel3 = this.postViewModel;
        if (postViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postViewModel");
        }
        postViewModel3.getContentVisibilityLiveData().observe(getViewLifecycleOwner(), new PostFragment$onObserversRequested$2(this));
        PostViewModel postViewModel4 = this.postViewModel;
        if (postViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postViewModel");
        }
        postViewModel4.getPostLiveData().observe(getViewLifecycleOwner(), new PostFragment$onObserversRequested$3(this));
        attachPostOperationsObservers();
    }

    public void afterViewCreated() {
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        if (postsLinearAdapter2.hasNoPage()) {
            PostViewModel postViewModel2 = this.postViewModel;
            if (postViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postViewModel");
            }
            postViewModel2.fetchPost();
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
            ((PostFragmentBinding) baseFragment.getBinding()).postAndCommentsRecyclerView.clearOnScrollListeners();
            PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
            if (postsLinearAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
            }
            postsLinearAdapter2.releasePlayer();
        } else {
            Timber.m303e("safeBinding() prevented a null-binding call.", new Object[0]);
        }
        super.onDestroy();
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((PostFragmentBinding) getBinding()).contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            PostViewModel postViewModel2 = this.postViewModel;
            if (postViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postViewModel");
            }
            postViewModel2.fetchPost();
            return;
        }
        super.onContentLayoutErrorResolutionButtonTapped(i, i2);
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
                    if (notifiableEvent instanceof UserFollowEvent) {
                        PostsLinearAdapter postsLinearAdapter3 = this.postsLinearAdapter;
                        if (postsLinearAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter3.consume((UserFollowEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostDeletedEvent) {
                        PostsLinearAdapter postsLinearAdapter4 = this.postsLinearAdapter;
                        if (postsLinearAdapter4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter4.consume((PostDeletedEvent) notifiableEvent);
                        ((PostFragmentBinding) getBinding()).contentLayout.showContentNotAvailable(getString(C4199R.string.error_post_deleted));
                    } else if (notifiableEvent instanceof PostCommentEvent) {
                        PostsLinearAdapter postsLinearAdapter5 = this.postsLinearAdapter;
                        if (postsLinearAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter5.consume((PostCommentEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostCommentDeleteEvent) {
                        PostsLinearAdapter postsLinearAdapter6 = this.postsLinearAdapter;
                        if (postsLinearAdapter6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter6.consume((PostCommentDeleteEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostPlaybackSoundMuteEvent) {
                        PostsLinearAdapter postsLinearAdapter7 = this.postsLinearAdapter;
                        if (postsLinearAdapter7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter7.consume(((PostPlaybackSoundMuteEvent) notifiableEvent).isMuted());
                    } else {
                        super.onEventReceived(notifiableEvent);
                    }
                }
            }
        }
    }

    private final void attachPostOperationsObservers() {
        getPostOperationsViewModel().postLikeUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$1(this));
        getPostOperationsViewModel().postSaveUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$2(this));
        getPostOperationsViewModel().postDeleteUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$3(this));
        getPostOperationsViewModel().postReportUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$4(this));
        getPostOperationsViewModel().postNotificationsUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$5(this));
        getPostOperationsViewModel().userFollowUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$6(this));
        getPostOperationsViewModel().postShareUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$7(this));
        getPostOperationsViewModel().postContentDownloadUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$8(this));
        getPostOperationsViewModel().postRepostUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$9(this));
        getPostOperationsViewModel().postTaggedUsersUpdated().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$10(this));
        getPostOperationsViewModel().postCommentLikeUpdated().observe(this, new PostFragment$attachPostOperationsObservers$11(this));
        getPostOperationsViewModel().playbackSoundSetting().observe(getViewLifecycleOwner(), new PostFragment$attachPostOperationsObservers$12(this));
    }
}
