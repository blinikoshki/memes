package com.memes.plus.p040ui.tagged_posts;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.base.upgrades.OnFragmentBackPressed;
import com.memes.plus.databinding.TaggedPostsFragmentBinding;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001<B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\u001a\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020.H\u0016J\b\u00108\u001a\u00020\u001fH\u0016J\b\u00109\u001a\u00020\u001fH\u0016J\u0010\u0010:\u001a\u00020\u001f2\u0006\u00107\u001a\u00020.H\u0016J\b\u0010;\u001a\u00020\u001fH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001c¨\u0006="}, mo26107d2 = {"Lcom/memes/plus/ui/tagged_posts/TaggedPostsFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/TaggedPostsFragmentBinding;", "Lcom/memes/plus/base/upgrades/OnFragmentBackPressed;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "Lcom/memes/plus/ui/posts/PostsLayoutSwitcher$Callback;", "()V", "facebookIntegrationViewModel", "Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "getFacebookIntegrationViewModel", "()Lcom/memes/plus/integrations/facebook/FacebookIntegrationViewModel;", "facebookIntegrationViewModel$delegate", "Lkotlin/Lazy;", "postActionHandler", "Lcom/memes/plus/ui/posts/PostAction$Handler;", "getPostActionHandler", "()Lcom/memes/plus/ui/posts/PostAction$Handler;", "postActionHandler$delegate", "postOperationsViewModel", "Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "getPostOperationsViewModel", "()Lcom/memes/plus/ui/posts/post_basics/PostOperationsViewModel;", "postOperationsViewModel$delegate", "postsLayoutSwitcher", "Lcom/memes/plus/ui/posts/PostsLayoutSwitcher;", "taggedPostsViewModel", "Lcom/memes/plus/ui/tagged_posts/TaggedPostsViewModel;", "getTaggedPostsViewModel", "()Lcom/memes/plus/ui/tagged_posts/TaggedPostsViewModel;", "taggedPostsViewModel$delegate", "afterViewCreated", "", "attachPostOperationsObservers", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onDestroy", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onFragmentBackPressed", "", "onLoadMorePosts", "viewingMode", "onObserversRequested", "onPause", "onPostViewingModeChanged", "onResume", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.tagged_posts.TaggedPostsFragment */
/* compiled from: TaggedPostsFragment.kt */
public final class TaggedPostsFragment extends BaseFragment<TaggedPostsFragmentBinding> implements OnFragmentBackPressed, ContentLayout.Callback, PostsLayoutSwitcher.Callback {
    public static final String ARG_HASH_TAG = "argument_hash_tag";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "TaggedPostsFragment";
    private final Lazy facebookIntegrationViewModel$delegate = LazyKt.lazy(new TaggedPostsFragment$facebookIntegrationViewModel$2(this));
    private final Lazy postActionHandler$delegate = LazyKt.lazy(new TaggedPostsFragment$postActionHandler$2(this));
    private final Lazy postOperationsViewModel$delegate = LazyKt.lazy(new TaggedPostsFragment$postOperationsViewModel$2(this));
    /* access modifiers changed from: private */
    public PostsLayoutSwitcher postsLayoutSwitcher;
    private final Lazy taggedPostsViewModel$delegate = LazyKt.lazy(new TaggedPostsFragment$taggedPostsViewModel$2(this));

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

    private final TaggedPostsViewModel getTaggedPostsViewModel() {
        return (TaggedPostsViewModel) this.taggedPostsViewModel$delegate.getValue();
    }

    public void onPostViewingModeChanged(int i) {
    }

    public static final /* synthetic */ PostsLayoutSwitcher access$getPostsLayoutSwitcher$p(TaggedPostsFragment taggedPostsFragment) {
        PostsLayoutSwitcher postsLayoutSwitcher2 = taggedPostsFragment.postsLayoutSwitcher;
        if (postsLayoutSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        return postsLayoutSwitcher2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/tagged_posts/TaggedPostsFragment$Companion;", "", "()V", "ARG_HASH_TAG", "", "TAG", "newInstance", "Lcom/memes/plus/ui/tagged_posts/TaggedPostsFragment;", "hashTag", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.tagged_posts.TaggedPostsFragment$Companion */
    /* compiled from: TaggedPostsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TaggedPostsFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "hashTag");
            TaggedPostsFragment taggedPostsFragment = new TaggedPostsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TaggedPostsFragment.ARG_HASH_TAG, str);
            taggedPostsFragment.setArguments(bundle);
            return taggedPostsFragment;
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        enableEventBus();
        super.onAttach(context);
    }

    public TaggedPostsFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        TaggedPostsFragmentBinding inflate = TaggedPostsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "TaggedPostsFragmentBindi…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((TaggedPostsFragmentBinding) getBinding()).contentLayout.setCallback(this);
        if (this.postsLayoutSwitcher == null) {
            RecyclerView recyclerView = ((TaggedPostsFragmentBinding) getBinding()).taggedPostsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().taggedPostsRecyclerView");
            this.postsLayoutSwitcher = new PostsLayoutSwitcher(recyclerView, getPostActionHandler(), this);
        } else {
            PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
            if (postsLayoutSwitcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
            }
            RecyclerView recyclerView2 = ((TaggedPostsFragmentBinding) getBinding()).taggedPostsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().taggedPostsRecyclerView");
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
        ((TaggedPostsFragmentBinding) getBinding()).topBarLayout.topBarBackImageView.setOnClickListener(new TaggedPostsFragment$onBindingComplete$2(this));
        PostsLayoutSwitcher postsLayoutSwitcher5 = this.postsLayoutSwitcher;
        if (postsLayoutSwitcher5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        PostsLayoutSwitcher.initPostsLayoutHelper$default(postsLayoutSwitcher5, 2, false, 2, (Object) null);
    }

    public void onObserversRequested() {
        getActivityHandle().registerViewModel(getTaggedPostsViewModel());
        getTaggedPostsViewModel().getContentVisibilityLiveData().observe(getViewLifecycleOwner(), new TaggedPostsFragment$onObserversRequested$1(this));
        getTaggedPostsViewModel().getTaggedPostsLiveData().observe(getViewLifecycleOwner(), new TaggedPostsFragment$onObserversRequested$2(this));
        attachPostOperationsObservers();
    }

    public void afterViewCreated() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_HASH_TAG) : null;
        getTaggedPostsViewModel().setHashTag(string);
        TextView textView = ((TaggedPostsFragmentBinding) getBinding()).topBarLayout.topBarTitleTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "getBinding().topBarLayout.topBarTitleTextView");
        textView.setText(string);
        PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
        if (postsLayoutSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        if (postsLayoutSwitcher2.hasNoPage()) {
            getTaggedPostsViewModel().fetchTaggedPosts();
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
        super.onResume();
    }

    public void onDestroy() {
        BaseFragment baseFragment = this;
        if (baseFragment.hasBinding()) {
            TaggedPostsFragmentBinding taggedPostsFragmentBinding = (TaggedPostsFragmentBinding) baseFragment.getBinding();
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

    public void onLoadMorePosts(int i) {
        getTaggedPostsViewModel().fetchTaggedPosts();
    }

    public boolean onFragmentBackPressed() {
        PostsLayoutSwitcher postsLayoutSwitcher2 = this.postsLayoutSwitcher;
        if (postsLayoutSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLayoutSwitcher");
        }
        return postsLayoutSwitcher2.handleBackAction();
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((TaggedPostsFragmentBinding) getBinding()).contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            getTaggedPostsViewModel().fetchTaggedPosts();
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
        getPostOperationsViewModel().postLikeUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$1(this));
        getPostOperationsViewModel().postSaveUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$2(this));
        getPostOperationsViewModel().postDeleteUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$3(this));
        getPostOperationsViewModel().postReportUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$4(this));
        getPostOperationsViewModel().postNotificationsUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$5(this));
        getPostOperationsViewModel().userFollowUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$6(this));
        getPostOperationsViewModel().postShareUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$7(this));
        getPostOperationsViewModel().postContentDownloadUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$8(this));
        getPostOperationsViewModel().postRepostUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$9(this));
        getPostOperationsViewModel().postTaggedUsersUpdated().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$10(this));
        getPostOperationsViewModel().postCommentLikeUpdated().observe(this, new TaggedPostsFragment$attachPostOperationsObservers$11(this));
        getPostOperationsViewModel().playbackSoundSetting().observe(getViewLifecycleOwner(), new TaggedPostsFragment$attachPostOperationsObservers$12(this));
    }
}
