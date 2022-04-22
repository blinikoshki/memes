package com.memes.plus.p040ui.profile.profile_posts;

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
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.network.memes.MemesSession;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.databinding.ProfilePostsFragmentBinding;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.events.PostCommentDeleteEvent;
import com.memes.plus.events.PostCommentEvent;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.PostEditedEvent;
import com.memes.plus.events.PostPreviewCommentEvent;
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
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00015B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020\u001cH\u0016J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\u001cH\u0016J\b\u00104\u001a\u00020\u001cH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u00066"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/profile_posts/ProfilePostsFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/ProfilePostsFragmentBinding;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "facebookIntegrationViewModel", "Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "getFacebookIntegrationViewModel", "()Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "facebookIntegrationViewModel$delegate", "Lkotlin/Lazy;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "postActionHandler", "Lcom/memes/plus/ui/posts/PostAction$Handler;", "getPostActionHandler", "()Lcom/memes/plus/ui/posts/PostAction$Handler;", "postActionHandler$delegate", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "getPostOperationsViewModel", "()Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "postOperationsViewModel$delegate", "postsLinearAdapter", "Lcom/memes/plus/ui/posts/PostsLinearAdapter;", "profilePostsViewModel", "Lcom/memes/plus/ui/profile/profile_posts/ProfilePostsViewModel;", "afterViewCreated", "", "attachPostOperationsObservers", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getPostsLinearAdapter", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onDestroy", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onObserversRequested", "onPause", "onResume", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsFragment */
/* compiled from: ProfilePostsFragment.kt */
public final class ProfilePostsFragment extends BaseFragment<ProfilePostsFragmentBinding> implements ContentLayout.Callback {
    private static final String ARG_TARGET_POST_POSITION = "argument_target_post_position";
    private static final String ARG_TARGET_POST_TAB = "argument_target_post_tab";
    private static final String ARG_TARGET_USERNAME = "argument_target_username";
    private static final String ARG_TARGET_USER_ID = "argument_target_user_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ProfilePostsFragment";
    private final Lazy facebookIntegrationViewModel$delegate = LazyKt.lazy(new ProfilePostsFragment$facebookIntegrationViewModel$2(this));
    private LinearLayoutManager layoutManager;
    private final Lazy postActionHandler$delegate = LazyKt.lazy(new ProfilePostsFragment$postActionHandler$2(this));
    private final Lazy postOperationsViewModel$delegate = LazyKt.lazy(new ProfilePostsFragment$postOperationsViewModel$2(this));
    /* access modifiers changed from: private */
    public PostsLinearAdapter postsLinearAdapter;
    /* access modifiers changed from: private */
    public ProfilePostsViewModel profilePostsViewModel;

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

    public static final /* synthetic */ PostsLinearAdapter access$getPostsLinearAdapter$p(ProfilePostsFragment profilePostsFragment) {
        PostsLinearAdapter postsLinearAdapter2 = profilePostsFragment.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        return postsLinearAdapter2;
    }

    public static final /* synthetic */ ProfilePostsViewModel access$getProfilePostsViewModel$p(ProfilePostsFragment profilePostsFragment) {
        ProfilePostsViewModel profilePostsViewModel2 = profilePostsFragment.profilePostsViewModel;
        if (profilePostsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profilePostsViewModel");
        }
        return profilePostsViewModel2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fJ,\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/profile_posts/ProfilePostsFragment$Companion;", "", "()V", "ARG_TARGET_POST_POSITION", "", "ARG_TARGET_POST_TAB", "ARG_TARGET_USERNAME", "ARG_TARGET_USER_ID", "TAG", "newInstance", "Lcom/memes/plus/ui/profile/profile_posts/ProfilePostsFragment;", "targetPostTab", "", "targetPostPosition", "targetUserId", "targetUserName", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsFragment$Companion */
    /* compiled from: ProfilePostsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ProfilePostsFragment newInstance$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return companion.newInstance(i, i2);
        }

        public final ProfilePostsFragment newInstance(int i, int i2) {
            return newInstance(MemesSession.INSTANCE.getUserId(), MemesSession.INSTANCE.getUserName(), i, i2);
        }

        public static /* synthetic */ ProfilePostsFragment newInstance$default(Companion companion, String str, String str2, int i, int i2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                i2 = 0;
            }
            return companion.newInstance(str, str2, i, i2);
        }

        public final ProfilePostsFragment newInstance(String str, String str2, int i, int i2) {
            Bundle bundle = new Bundle();
            bundle.putString("argument_target_user_id", str);
            bundle.putString("argument_target_username", str2);
            bundle.putInt(ProfilePostsFragment.ARG_TARGET_POST_TAB, i);
            bundle.putInt(ProfilePostsFragment.ARG_TARGET_POST_POSITION, i2);
            ProfilePostsFragment profilePostsFragment = new ProfilePostsFragment();
            profilePostsFragment.setArguments(bundle);
            return profilePostsFragment;
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        enableEventBus();
        super.onAttach(context);
    }

    public ProfilePostsFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ProfilePostsFragmentBinding inflate = ProfilePostsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ProfilePostsFragmentBind…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((ProfilePostsFragmentBinding) getBinding()).contentLayout.setCallback(this);
        ((ProfilePostsFragmentBinding) getBinding()).topBarLayout.topBarBackImageView.setOnClickListener(new ProfilePostsFragment$onBindingComplete$1(this));
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = ((ProfilePostsFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().postsRecyclerView");
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        ((ProfilePostsFragmentBinding) getBinding()).postsRecyclerView.clearOnScrollListeners();
        RecyclerView recyclerView2 = ((ProfilePostsFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().postsRecyclerView");
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        ExtKt.addVisibilityTracker(recyclerView2, linearLayoutManager2);
        RecyclerView recyclerView3 = ((ProfilePostsFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "getBinding().postsRecyclerView");
        LinearLayoutManager linearLayoutManager3 = this.layoutManager;
        if (linearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        ExtensionsKt.addPaginator(recyclerView3, linearLayoutManager3, new ProfilePostsFragment$onBindingComplete$2(this));
        this.postsLinearAdapter = getPostsLinearAdapter();
        RecyclerView recyclerView4 = ((ProfilePostsFragmentBinding) getBinding()).postsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "getBinding().postsRecyclerView");
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        recyclerView4.setAdapter(postsLinearAdapter2);
        ((ProfilePostsFragmentBinding) getBinding()).postsRecyclerView.setHasFixedSize(true);
    }

    public void onObserversRequested() {
        Bundle arguments = getArguments();
        T t = null;
        String string = arguments != null ? arguments.getString("argument_target_user_id") : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("argument_target_username") : null;
        Bundle arguments3 = getArguments();
        Integer valueOf = arguments3 != null ? Integer.valueOf(arguments3.getInt(ARG_TARGET_POST_TAB)) : null;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            t = Integer.valueOf(arguments4.getInt(ARG_TARGET_POST_POSITION));
        }
        objectRef.element = t;
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new BaseViewModelFactory(new ProfilePostsFragment$onObserversRequested$1(string, string2, valueOf))).get(ProfilePostsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        this.profilePostsViewModel = (ProfilePostsViewModel) viewModel;
        ActivityHandle activityHandle = getActivityHandle();
        ProfilePostsViewModel profilePostsViewModel2 = this.profilePostsViewModel;
        if (profilePostsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profilePostsViewModel");
        }
        activityHandle.registerViewModel(profilePostsViewModel2);
        ProfilePostsViewModel profilePostsViewModel3 = this.profilePostsViewModel;
        if (profilePostsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profilePostsViewModel");
        }
        profilePostsViewModel3.getTopBarTitleLiveData().observe(getViewLifecycleOwner(), new ProfilePostsFragment$onObserversRequested$2(this));
        ProfilePostsViewModel profilePostsViewModel4 = this.profilePostsViewModel;
        if (profilePostsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profilePostsViewModel");
        }
        profilePostsViewModel4.getContentVisibilityLiveData().observe(getViewLifecycleOwner(), new ProfilePostsFragment$onObserversRequested$3(this));
        ProfilePostsViewModel profilePostsViewModel5 = this.profilePostsViewModel;
        if (profilePostsViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profilePostsViewModel");
        }
        profilePostsViewModel5.getPostsLiveData().observe(getViewLifecycleOwner(), new ProfilePostsFragment$onObserversRequested$4(this, objectRef));
        attachPostOperationsObservers();
    }

    public void afterViewCreated() {
        if (getPostsLinearAdapter().hasNoPage()) {
            ProfilePostsViewModel profilePostsViewModel2 = this.profilePostsViewModel;
            if (profilePostsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profilePostsViewModel");
            }
            ProfilePostsViewModel.fetchPosts$default(profilePostsViewModel2, false, 1, (Object) null);
        }
    }

    public void onPause() {
        getPostsLinearAdapter().pausePlayer();
        super.onPause();
    }

    public void onResume() {
        getPostsLinearAdapter().resumePlayer();
        super.onResume();
    }

    public void onDestroy() {
        BaseFragment baseFragment = this;
        if (baseFragment.hasBinding()) {
            ((ProfilePostsFragmentBinding) baseFragment.getBinding()).postsRecyclerView.clearOnScrollListeners();
            getPostsLinearAdapter().releasePlayer();
        } else {
            Timber.m303e("safeBinding() prevented a null-binding call.", new Object[0]);
        }
        super.onDestroy();
    }

    private final PostsLinearAdapter getPostsLinearAdapter() {
        if (this.postsLinearAdapter == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            this.postsLinearAdapter = new PostsLinearAdapter(requireContext, getPostActionHandler(), (InviteItemTapListener) null, (AppRatingItemTapListener) null, 12, (DefaultConstructorMarker) null);
        }
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        return postsLinearAdapter2;
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((ProfilePostsFragmentBinding) getBinding()).contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            ProfilePostsViewModel profilePostsViewModel2 = this.profilePostsViewModel;
            if (profilePostsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profilePostsViewModel");
            }
            ProfilePostsViewModel.fetchPosts$default(profilePostsViewModel2, false, 1, (Object) null);
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
                    } else if (notifiableEvent instanceof PostEditedEvent) {
                        PostsLinearAdapter postsLinearAdapter7 = this.postsLinearAdapter;
                        if (postsLinearAdapter7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter7.consume((PostEditedEvent) notifiableEvent);
                    } else if (notifiableEvent instanceof PostPreviewCommentEvent) {
                        PostsLinearAdapter postsLinearAdapter8 = this.postsLinearAdapter;
                        if (postsLinearAdapter8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                        }
                        postsLinearAdapter8.consume((PostPreviewCommentEvent) notifiableEvent);
                    } else {
                        super.onEventReceived(notifiableEvent);
                    }
                }
            }
        }
    }

    private final void attachPostOperationsObservers() {
        getPostOperationsViewModel().postLikeUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$1(this));
        getPostOperationsViewModel().postSaveUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$2(this));
        getPostOperationsViewModel().postDeleteUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$3(this));
        getPostOperationsViewModel().postReportUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$4(this));
        getPostOperationsViewModel().postNotificationsUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$5(this));
        getPostOperationsViewModel().userFollowUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$6(this));
        getPostOperationsViewModel().postShareUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$7(this));
        getPostOperationsViewModel().postContentDownloadUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$8(this));
        getPostOperationsViewModel().postRepostUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$9(this));
        getPostOperationsViewModel().postTaggedUsersUpdated().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$10(this));
        getPostOperationsViewModel().postCommentLikeUpdated().observe(this, new ProfilePostsFragment$attachPostOperationsObservers$11(this));
        getPostOperationsViewModel().playbackSoundSetting().observe(getViewLifecycleOwner(), new ProfilePostsFragment$attachPostOperationsObservers$12(this));
    }
}
