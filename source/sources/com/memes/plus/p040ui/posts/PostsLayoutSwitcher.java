package com.memes.plus.p040ui.posts;

import android.content.Context;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.PostEditedEvent;
import com.memes.plus.events.PostNotificationsSubscriptionEvent;
import com.memes.plus.events.PostPlaybackSoundMuteEvent;
import com.memes.plus.events.PostPreviewCommentEvent;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.p040ui.apprating.AppRatingItemTapListener;
import com.memes.plus.p040ui.posts.PostAction;
import com.memes.plus.p040ui.posts.commentpreviewbox.PostPreviewComment;
import com.memes.plus.p040ui.posts.invite.InviteItemTapListener;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserResult;
import com.memes.plus.p040ui.posts.post_basics.post_delete.PostDeleteResult;
import com.memes.plus.util.ExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 J2\u00020\u0001:\u0002IJB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)J\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020*J\u000e\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020'2\u0006\u0010,\u001a\u00020*J\u000e\u00101\u001a\u00020'2\u0006\u0010.\u001a\u000202J\u000e\u00101\u001a\u00020'2\u0006\u0010.\u001a\u000203J\b\u00104\u001a\u00020'H\u0002J\u000e\u00105\u001a\u00020%2\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020'J\u0006\u00109\u001a\u00020%J\u0006\u0010:\u001a\u00020%J\u0018\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020%J\u0018\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020*H\u0016J\u0006\u0010?\u001a\u00020'J\u0006\u0010@\u001a\u00020'J\u000e\u0010A\u001a\u00020'2\u0006\u0010>\u001a\u00020\u000eJ\u0006\u0010B\u001a\u00020'J\u0006\u0010C\u001a\u00020'J\u0006\u0010D\u001a\u00020'J\u001a\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\u000e2\b\b\u0002\u0010>\u001a\u00020\u000eH\u0002J\u000e\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020%R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLayoutSwitcher;", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapterListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "postActionListener", "Lcom/memes/plus/ui/posts/PostAction$Listener;", "callback", "Lcom/memes/plus/ui/posts/PostsLayoutSwitcher$Callback;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/memes/plus/ui/posts/PostAction$Listener;Lcom/memes/plus/ui/posts/PostsLayoutSwitcher$Callback;)V", "getCallback", "()Lcom/memes/plus/ui/posts/PostsLayoutSwitcher$Callback;", "setCallback", "(Lcom/memes/plus/ui/posts/PostsLayoutSwitcher$Callback;)V", "currentPostViewingMode", "", "defaultPostViewingMode", "paginator", "Lcom/memes/commons/pagination/Paginator;", "getPostActionListener", "()Lcom/memes/plus/ui/posts/PostAction$Listener;", "setPostActionListener", "(Lcom/memes/plus/ui/posts/PostAction$Listener;)V", "postsLinearAdapter", "Lcom/memes/plus/ui/posts/PostsLinearAdapter;", "postsLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "postsStaggeredAdapter", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapter;", "postsStaggeredGridLayoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "staggeredRecyclerViewState", "Landroid/os/Parcelable;", "usePagination", "", "applyAdapterUpdate", "", "adapterUpdate", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/posts/Post;", "applyPostLikeUpdate", "post", "applyPostPreviewCommentUpdate", "result", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "applyPostSaveUpdate", "applyUpdate", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserResult;", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteResult;", "attachPaginator", "consume", "event", "Lcom/memes/plus/events/NotifiableEvent;", "destroy", "handleBackAction", "hasNoPage", "initPostsLayoutHelper", "postViewingMode", "onStaggeredPostTapped", "position", "pause", "resetPaginator", "resetScrollToPosition", "resetToLinearLayout", "resetToStaggeredLayout", "resume", "setPostViewingMode", "viewingMode", "updatePostPlaybackSoundMuted", "isMute", "Callback", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsLayoutSwitcher */
/* compiled from: PostsLayoutSwitcher.kt */
public final class PostsLayoutSwitcher implements PostsStaggeredAdapterListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "PostsLayoutHelper";
    private Callback callback;
    /* access modifiers changed from: private */
    public int currentPostViewingMode = 2;
    private int defaultPostViewingMode = 2;
    private Paginator paginator;
    private PostAction.Listener postActionListener;
    /* access modifiers changed from: private */
    public PostsLinearAdapter postsLinearAdapter;
    private LinearLayoutManager postsLinearLayoutManager;
    /* access modifiers changed from: private */
    public PostsStaggeredAdapter postsStaggeredAdapter;
    private StaggeredGridLayoutManager postsStaggeredGridLayoutManager;
    private RecyclerView recyclerView;
    private Parcelable staggeredRecyclerViewState;
    private boolean usePagination = true;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLayoutSwitcher$Callback;", "", "onLoadMorePosts", "", "viewingMode", "", "onPostViewingModeChanged", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLayoutSwitcher$Callback */
    /* compiled from: PostsLayoutSwitcher.kt */
    public interface Callback {

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        /* renamed from: com.memes.plus.ui.posts.PostsLayoutSwitcher$Callback$DefaultImpls */
        /* compiled from: PostsLayoutSwitcher.kt */
        public static final class DefaultImpls {
            public static void onLoadMorePosts(Callback callback, int i) {
            }

            public static void onPostViewingModeChanged(Callback callback, int i) {
            }
        }

        void onLoadMorePosts(int i);

        void onPostViewingModeChanged(int i);
    }

    public PostsLayoutSwitcher(RecyclerView recyclerView2, PostAction.Listener listener, Callback callback2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        Intrinsics.checkNotNullParameter(listener, "postActionListener");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.recyclerView = recyclerView2;
        this.postActionListener = listener;
        this.callback = callback2;
    }

    public static final /* synthetic */ PostsLinearAdapter access$getPostsLinearAdapter$p(PostsLayoutSwitcher postsLayoutSwitcher) {
        PostsLinearAdapter postsLinearAdapter2 = postsLayoutSwitcher.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        return postsLinearAdapter2;
    }

    public static final /* synthetic */ PostsStaggeredAdapter access$getPostsStaggeredAdapter$p(PostsLayoutSwitcher postsLayoutSwitcher) {
        PostsStaggeredAdapter postsStaggeredAdapter2 = postsLayoutSwitcher.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        return postsStaggeredAdapter2;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "<set-?>");
        this.recyclerView = recyclerView2;
    }

    public final PostAction.Listener getPostActionListener() {
        return this.postActionListener;
    }

    public final void setPostActionListener(PostAction.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "<set-?>");
        this.postActionListener = listener;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "<set-?>");
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsLayoutSwitcher$Companion;", "", "()V", "TAG", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsLayoutSwitcher$Companion */
    /* compiled from: PostsLayoutSwitcher.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void initPostsLayoutHelper$default(PostsLayoutSwitcher postsLayoutSwitcher, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        postsLayoutSwitcher.initPostsLayoutHelper(i, z);
    }

    public final void initPostsLayoutHelper(int i, boolean z) {
        this.defaultPostViewingMode = i;
        this.usePagination = z;
        this.postsLinearLayoutManager = new LinearLayoutManager(this.recyclerView.getContext());
        PostsLayoutSwitcher postsLayoutSwitcher = this;
        if (postsLayoutSwitcher.postsLinearAdapter == null) {
            Context context = this.recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
            this.postsLinearAdapter = new PostsLinearAdapter(context, this.postActionListener, (InviteItemTapListener) null, (AppRatingItemTapListener) null, 12, (DefaultConstructorMarker) null);
        }
        this.postsStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        if (postsLayoutSwitcher.postsStaggeredAdapter == null) {
            Context context2 = this.recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "recyclerView.context");
            this.postsStaggeredAdapter = new PostsStaggeredAdapter(context2, this);
        }
        setPostViewingMode$default(this, i, 0, 2, (Object) null);
    }

    public final boolean hasNoPage() {
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        return postsLinearAdapter2.hasNoPage();
    }

    public final void applyAdapterUpdate(AdapterUpdate<Post> adapterUpdate) {
        Intrinsics.checkNotNullParameter(adapterUpdate, "adapterUpdate");
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.applyPostsAdapterUpdate(adapterUpdate);
        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        postsStaggeredAdapter2.applyAdapterUpdate(adapterUpdate);
    }

    public final void applyPostLikeUpdate(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.updateLikedFlag(post);
        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        postsStaggeredAdapter2.updateLikedFlag(post);
    }

    public final void applyPostSaveUpdate(Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.updateSavedStatus(post);
        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        postsStaggeredAdapter2.updateSavedStatus(post);
    }

    public final void applyUpdate(PostDeleteResult postDeleteResult) {
        Intrinsics.checkNotNullParameter(postDeleteResult, "result");
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.consume(postDeleteResult);
        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        postsStaggeredAdapter2.applyUpdate(postDeleteResult);
    }

    public final void applyUpdate(FollowUserResult followUserResult) {
        Intrinsics.checkNotNullParameter(followUserResult, "result");
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.consume(followUserResult);
        PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
        if (postsStaggeredAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
        }
        postsStaggeredAdapter2.applyUpdate(followUserResult);
    }

    public final void applyPostPreviewCommentUpdate(PostPreviewComment postPreviewComment) {
        Intrinsics.checkNotNullParameter(postPreviewComment, "result");
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.consume(postPreviewComment);
    }

    public final void updatePostPlaybackSoundMuted(boolean z) {
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.consume(z);
    }

    public final boolean consume(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        PostsLayoutSwitcher postsLayoutSwitcher = this;
        if (!(postsLayoutSwitcher.postsLinearAdapter == null || postsLayoutSwitcher.postsStaggeredAdapter == null)) {
            if (notifiableEvent instanceof UserFollowEvent) {
                PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
                if (postsLinearAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                }
                UserFollowEvent userFollowEvent = (UserFollowEvent) notifiableEvent;
                postsLinearAdapter2.consume(userFollowEvent);
                PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
                if (postsStaggeredAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
                }
                postsStaggeredAdapter2.consume(userFollowEvent);
                return true;
            } else if (notifiableEvent instanceof PostNotificationsSubscriptionEvent) {
                PostsLinearAdapter postsLinearAdapter3 = this.postsLinearAdapter;
                if (postsLinearAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                }
                PostNotificationsSubscriptionEvent postNotificationsSubscriptionEvent = (PostNotificationsSubscriptionEvent) notifiableEvent;
                postsLinearAdapter3.consume(postNotificationsSubscriptionEvent);
                PostsStaggeredAdapter postsStaggeredAdapter3 = this.postsStaggeredAdapter;
                if (postsStaggeredAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
                }
                postsStaggeredAdapter3.consume(postNotificationsSubscriptionEvent);
                return true;
            } else if (notifiableEvent instanceof PostDeletedEvent) {
                PostsLinearAdapter postsLinearAdapter4 = this.postsLinearAdapter;
                if (postsLinearAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                }
                PostDeletedEvent postDeletedEvent = (PostDeletedEvent) notifiableEvent;
                postsLinearAdapter4.consume(postDeletedEvent);
                PostsStaggeredAdapter postsStaggeredAdapter4 = this.postsStaggeredAdapter;
                if (postsStaggeredAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
                }
                postsStaggeredAdapter4.consume(postDeletedEvent);
                return true;
            } else if (notifiableEvent instanceof PostEditedEvent) {
                PostsLinearAdapter postsLinearAdapter5 = this.postsLinearAdapter;
                if (postsLinearAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                }
                postsLinearAdapter5.consume((PostEditedEvent) notifiableEvent);
                return true;
            } else if (notifiableEvent instanceof PostPreviewCommentEvent) {
                PostsLinearAdapter postsLinearAdapter6 = this.postsLinearAdapter;
                if (postsLinearAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                }
                postsLinearAdapter6.consume((PostPreviewCommentEvent) notifiableEvent);
                return true;
            } else if (notifiableEvent instanceof PostPlaybackSoundMuteEvent) {
                PostsLinearAdapter postsLinearAdapter7 = this.postsLinearAdapter;
                if (postsLinearAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
                }
                postsLinearAdapter7.consume(((PostPlaybackSoundMuteEvent) notifiableEvent).isMuted());
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void setPostViewingMode$default(PostsLayoutSwitcher postsLayoutSwitcher, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        postsLayoutSwitcher.setPostViewingMode(i, i2);
    }

    private final void setPostViewingMode(int i, int i2) {
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.releasePlayer();
        this.currentPostViewingMode = i;
        this.callback.onPostViewingModeChanged(i);
        if (i == 2) {
            RecyclerView recyclerView2 = this.recyclerView;
            StaggeredGridLayoutManager staggeredGridLayoutManager = this.postsStaggeredGridLayoutManager;
            if (staggeredGridLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredGridLayoutManager");
            }
            recyclerView2.setLayoutManager(staggeredGridLayoutManager);
            this.recyclerView.clearOnScrollListeners();
            RecyclerView recyclerView3 = this.recyclerView;
            PostsStaggeredAdapter postsStaggeredAdapter2 = this.postsStaggeredAdapter;
            if (postsStaggeredAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsStaggeredAdapter");
            }
            recyclerView3.setAdapter(postsStaggeredAdapter2);
            RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.onRestoreInstanceState(this.staggeredRecyclerViewState);
            }
        } else if (i == 1) {
            RecyclerView recyclerView4 = this.recyclerView;
            LinearLayoutManager linearLayoutManager = this.postsLinearLayoutManager;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLinearLayoutManager");
            }
            recyclerView4.setLayoutManager(linearLayoutManager);
            this.recyclerView.clearOnScrollListeners();
            RecyclerView recyclerView5 = this.recyclerView;
            LinearLayoutManager linearLayoutManager2 = this.postsLinearLayoutManager;
            if (linearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLinearLayoutManager");
            }
            ExtKt.addVisibilityTracker(recyclerView5, linearLayoutManager2);
            RecyclerView recyclerView6 = this.recyclerView;
            PostsLinearAdapter postsLinearAdapter3 = this.postsLinearAdapter;
            if (postsLinearAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
            }
            recyclerView6.setAdapter(postsLinearAdapter3);
            this.recyclerView.scrollToPosition(i2);
        }
        attachPaginator();
    }

    public void onStaggeredPostTapped(int i, Post post) {
        Intrinsics.checkNotNullParameter(post, "post");
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        this.staggeredRecyclerViewState = layoutManager != null ? layoutManager.onSaveInstanceState() : null;
        setPostViewingMode(1, i);
    }

    private final void attachPaginator() {
        RecyclerView.LayoutManager layoutManager;
        Paginator paginator2 = this.paginator;
        if (paginator2 != null) {
            paginator2.detach(this.recyclerView);
        }
        if (this.usePagination && (layoutManager = this.recyclerView.getLayoutManager()) != null) {
            this.paginator = ExtensionsKt.addPaginator(this.recyclerView, layoutManager, new PostsLayoutSwitcher$attachPaginator$1(this));
        }
    }

    public final boolean handleBackAction() {
        int i = this.currentPostViewingMode;
        if (i == this.defaultPostViewingMode) {
            return false;
        }
        if (i == 1) {
            setPostViewingMode$default(this, 2, 0, 2, (Object) null);
        }
        return true;
    }

    public final void resetToLinearLayout() {
        if (this.currentPostViewingMode == 2) {
            setPostViewingMode$default(this, 1, 0, 2, (Object) null);
        }
        resetScrollToPosition(0);
    }

    public final void resetToStaggeredLayout() {
        if (this.currentPostViewingMode == 1) {
            setPostViewingMode$default(this, 2, 0, 2, (Object) null);
        }
        resetScrollToPosition(0);
    }

    public final void resetScrollToPosition(int i) {
        this.recyclerView.smoothScrollToPosition(i);
    }

    public final void resetPaginator() {
        Paginator paginator2 = this.paginator;
        if (paginator2 != null) {
            paginator2.resetState();
        }
    }

    public final void pause() {
        if (this.currentPostViewingMode == 1) {
            PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
            if (postsLinearAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
            }
            postsLinearAdapter2.pausePlayer();
        }
    }

    public final void resume() {
        attachPaginator();
        if (this.currentPostViewingMode == 1) {
            PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
            if (postsLinearAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
            }
            postsLinearAdapter2.resumePlayer();
        }
    }

    public final void destroy() {
        PostsLinearAdapter postsLinearAdapter2 = this.postsLinearAdapter;
        if (postsLinearAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postsLinearAdapter");
        }
        postsLinearAdapter2.releasePlayer();
        this.recyclerView.clearOnScrollListeners();
    }
}
