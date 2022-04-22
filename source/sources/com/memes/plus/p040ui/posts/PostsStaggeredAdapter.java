package com.memes.plus.p040ui.posts;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.databinding.PostStaggeredItemBinding;
import com.memes.plus.databinding.SnippetPostMediaProgressBarBinding;
import com.memes.plus.events.PostDeletedEvent;
import com.memes.plus.events.PostNotificationsSubscriptionEvent;
import com.memes.plus.events.UserFollowEvent;
import com.memes.plus.p040ui.posts.post_basics.follow_user.FollowUserResult;
import com.memes.plus.p040ui.posts.post_basics.post_delete.PostDeleteResult;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0013J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0014J$\u0010\u0015\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsStaggeredAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/posts/Post;", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapter$PostViewHolder;", "context", "Landroid/content/Context;", "staggeredAdapterListener", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapterListener;", "(Landroid/content/Context;Lcom/memes/plus/ui/posts/PostsStaggeredAdapterListener;)V", "constantAspectRatio", "", "applyUpdate", "", "result", "Lcom/memes/plus/ui/posts/post_basics/follow_user/FollowUserResult;", "Lcom/memes/plus/ui/posts/post_basics/post_delete/PostDeleteResult;", "consume", "event", "Lcom/memes/plus/events/PostDeletedEvent;", "Lcom/memes/plus/events/PostNotificationsSubscriptionEvent;", "Lcom/memes/plus/events/UserFollowEvent;", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "setConstantAspectRatio", "aspectRatio", "updateLikedFlag", "updatedPost", "updateSavedStatus", "PostViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostsStaggeredAdapter */
/* compiled from: PostsStaggeredAdapter.kt */
public final class PostsStaggeredAdapter extends BaseRecyclerAdapter<Post, PostViewHolder> {
    /* access modifiers changed from: private */
    public float constantAspectRatio;
    /* access modifiers changed from: private */
    public final PostsStaggeredAdapterListener staggeredAdapterListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostsStaggeredAdapter(Context context, PostsStaggeredAdapterListener postsStaggeredAdapterListener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(postsStaggeredAdapterListener, "staggeredAdapterListener");
        this.staggeredAdapterListener = postsStaggeredAdapterListener;
    }

    public PostViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        PostStaggeredItemBinding inflate = PostStaggeredItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "PostStaggeredItemBinding…(inflater, parent, false)");
        return new PostViewHolder(this, inflate);
    }

    public final void setConstantAspectRatio(float f) {
        this.constantAspectRatio = f;
    }

    public final void updateLikedFlag(Post post) {
        Intrinsics.checkNotNullParameter(post, "updatedPost");
        int i = 0;
        for (Post post2 : getItems()) {
            if (Intrinsics.areEqual((Object) post2.getPostId(), (Object) post.getPostId())) {
                post2.setLiked(post.getLiked());
                post2.setTotalLikes(post.getTotalLikes());
                notifyItemChanged(i);
                return;
            }
            i++;
        }
    }

    public final void updateSavedStatus(Post post) {
        Intrinsics.checkNotNullParameter(post, "updatedPost");
        int i = 0;
        for (Post post2 : getItems()) {
            if (Intrinsics.areEqual((Object) post2.getPostId(), (Object) post.getPostId())) {
                post2.setSaved(post.getSaved());
                notifyItemChanged(i);
                return;
            }
            i++;
        }
    }

    public final void applyUpdate(PostDeleteResult postDeleteResult) {
        Intrinsics.checkNotNullParameter(postDeleteResult, "result");
        int i = 0;
        for (Post postId : getItems()) {
            if (Intrinsics.areEqual((Object) postId.getPostId(), (Object) postDeleteResult.getPostId())) {
                removeItemAt(i);
                return;
            }
            i++;
        }
    }

    public final void applyUpdate(FollowUserResult followUserResult) {
        Intrinsics.checkNotNullParameter(followUserResult, "result");
        for (Post post : getItems()) {
            if (Intrinsics.areEqual((Object) post.getUserId(), (Object) followUserResult.getUserId())) {
                post.setIamfollowing(followUserResult.getFollowed());
            }
        }
    }

    public final void consume(UserFollowEvent userFollowEvent) {
        Intrinsics.checkNotNullParameter(userFollowEvent, "event");
        for (Post post : getItems()) {
            if (Intrinsics.areEqual((Object) post.getUserId(), (Object) userFollowEvent.getUserId())) {
                post.setIamfollowing(userFollowEvent.getFollowed());
            }
        }
    }

    public final void consume(PostNotificationsSubscriptionEvent postNotificationsSubscriptionEvent) {
        Intrinsics.checkNotNullParameter(postNotificationsSubscriptionEvent, "result");
        for (Post post : getItems()) {
            if (Intrinsics.areEqual((Object) post.getUserId(), (Object) postNotificationsSubscriptionEvent.getUserId())) {
                post.setNotificationsEnabled(postNotificationsSubscriptionEvent.getEnabled());
            }
        }
    }

    public final void consume(PostDeletedEvent postDeletedEvent) {
        Intrinsics.checkNotNullParameter(postDeletedEvent, "event");
        int i = 0;
        for (Post postId : getItems()) {
            if (Intrinsics.areEqual((Object) postId.getPostId(), (Object) postDeletedEvent.getPostId())) {
                removeItemAt(i);
                return;
            }
            i++;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/PostsStaggeredAdapter$PostViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/posts/Post;", "binding", "Lcom/memes/plus/databinding/PostStaggeredItemBinding;", "(Lcom/memes/plus/ui/posts/PostsStaggeredAdapter;Lcom/memes/plus/databinding/PostStaggeredItemBinding;)V", "picassoCallback", "com/memes/plus/ui/posts/PostsStaggeredAdapter$PostViewHolder$picassoCallback$1", "Lcom/memes/plus/ui/posts/PostsStaggeredAdapter$PostViewHolder$picassoCallback$1;", "post", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.posts.PostsStaggeredAdapter$PostViewHolder */
    /* compiled from: PostsStaggeredAdapter.kt */
    public final class PostViewHolder extends BaseViewHolder<Post> {
        /* access modifiers changed from: private */
        public final PostStaggeredItemBinding binding;
        private final PostsStaggeredAdapter$PostViewHolder$picassoCallback$1 picassoCallback = new PostsStaggeredAdapter$PostViewHolder$picassoCallback$1(this);
        /* access modifiers changed from: private */
        public Post post;
        final /* synthetic */ PostsStaggeredAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PostViewHolder(com.memes.plus.p040ui.posts.PostsStaggeredAdapter r2, com.memes.plus.databinding.PostStaggeredItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                com.memes.commons.aspectratio.AspectRatioFrameLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                com.memes.plus.ui.posts.PostsStaggeredAdapter$PostViewHolder$picassoCallback$1 r2 = new com.memes.plus.ui.posts.PostsStaggeredAdapter$PostViewHolder$picassoCallback$1
                r2.<init>(r1)
                r1.picassoCallback = r2
                com.memes.commons.aspectratio.AspectRatioFrameLayout r2 = r3.getRoot()
                com.memes.plus.ui.posts.PostsStaggeredAdapter$PostViewHolder$1 r3 = new com.memes.plus.ui.posts.PostsStaggeredAdapter$PostViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.posts.PostsStaggeredAdapter.PostViewHolder.<init>(com.memes.plus.ui.posts.PostsStaggeredAdapter, com.memes.plus.databinding.PostStaggeredItemBinding):void");
        }

        public static final /* synthetic */ Post access$getPost$p(PostViewHolder postViewHolder) {
            Post post2 = postViewHolder.post;
            if (post2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            return post2;
        }

        public void setItem(Post post2) {
            Intrinsics.checkNotNullParameter(post2, "item");
            this.post = post2;
            if (this.this$0.constantAspectRatio > ((float) 0)) {
                this.binding.postMediaContainer.setAspectRatio(this.this$0.constantAspectRatio);
            } else {
                AspectRatioFrameLayout aspectRatioFrameLayout = this.binding.postMediaContainer;
                Post post3 = this.post;
                if (post3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("post");
                }
                aspectRatioFrameLayout.setAspectRatio(post3.aspectRatio());
            }
            ImageView imageView = this.binding.postContentTypeView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.postContentTypeView");
            Post post4 = this.post;
            if (post4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            imageView.setVisibility(post4.contentType() == 2 ? 0 : 8);
            SnippetPostMediaProgressBarBinding snippetPostMediaProgressBarBinding = this.binding.includedMediaProgressLayout;
            Intrinsics.checkNotNullExpressionValue(snippetPostMediaProgressBarBinding, "binding.includedMediaProgressLayout");
            LinearLayout root = snippetPostMediaProgressBarBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.includedMediaProgressLayout.root");
            root.setVisibility(0);
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            Post post5 = this.post;
            if (post5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            Uri mediaThumbUrl = post5.mediaThumbUrl();
            Picasso log$default = PicassoExtKt.log$default(picasso, (Object) this, mediaThumbUrl != null ? mediaThumbUrl.toString() : null, (String) null, 4, (Object) null);
            Post post6 = this.post;
            if (post6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("post");
            }
            log$default.load(post6.mediaThumbUrl()).into(this.binding.postContentImageView, this.picassoCallback);
        }
    }
}
