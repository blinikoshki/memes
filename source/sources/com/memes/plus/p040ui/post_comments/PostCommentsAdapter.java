package com.memes.plus.p040ui.post_comments;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.getstream.sdk.chat.model.ModelType;
import com.memes.commons.enhancedtext.socialtext.SocialTextView;
import com.memes.commons.recycleradapter.AdapterViewHolderPayload;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.PrettyCounter;
import com.memes.commons.util.PrettyTime;
import com.memes.network.memes.MemesSession;
import com.memes.plus.ApiRouting;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.databinding.CommentsLoaderItemBinding;
import com.memes.plus.databinding.SingleCommentReplyItemBinding;
import com.memes.plus.databinding.SingleCommentRowBinding;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 02\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0004./01B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000fJ\u0010\u0010$\u001a\u0004\u0018\u00010\u001f2\u0006\u0010#\u001a\u00020\u000fJ\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010&\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001fJ\u000e\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001fJ\u000e\u0010+\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001fJ\u0016\u0010,\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentsAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/post_comments/BaseCommentModel;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "context", "Landroid/content/Context;", "adapterListener", "Lcom/memes/plus/ui/post_comments/PostCommentsAdapterListener;", "(Landroid/content/Context;Lcom/memes/plus/ui/post_comments/PostCommentsAdapterListener;)V", "addRepliesToComment", "", "listOfReplies", "", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "commentId", "", "shouldChangeState", "", "addSingleReply", "reply", "animateComment", "position", "", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "deleteComment", "targetComment", "Lcom/memes/plus/ui/post_comments/PostComment;", "deleteReply", "targetReply", "findItemPositionWithId", "id", "getComment", "getItemViewType", "likeReply", "removeListReplies", "updateComment", "updatedComment", "updateLikedFlag", "updateReply", "updateViewRepliesUI", "state", "CommentsRefreshViewHolder", "CommentsViewHolder", "Companion", "RepliesViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsAdapter */
/* compiled from: PostCommentsAdapter.kt */
public final class PostCommentsAdapter extends BaseRecyclerAdapter<BaseCommentModel, BaseViewHolder<BaseCommentModel>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAYLOAD_ANIMATE_COMMENT = "payload_animate_comment";
    public static final String PAYLOAD_LIKE_CHANGE = "payload_like_change";
    public static final String PAYLOAD_LIKE_REPLY = "payload_reply_like_change";
    public static final String PAYLOAD_STATE_CHANGE = "payload_state_change";
    public static final String PAYLOAD_UPDATE_COMMENT = "payload_update_comment";
    public static final int STATE_LOADED = 1;
    public static final int STATE_LOADING = 3;
    public static final int STATE_NOT_LOADED = 2;
    public static final int VIEW_TYPE_COMMENT = 20;
    public static final int VIEW_TYPE_LOAD = 22;
    public static final int VIEW_TYPE_REPLY = 21;
    /* access modifiers changed from: private */
    public final PostCommentsAdapterListener adapterListener;
    /* access modifiers changed from: private */
    public final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostCommentsAdapter(Context context2, PostCommentsAdapterListener postCommentsAdapterListener) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(postCommentsAdapterListener, "adapterListener");
        this.context = context2;
        this.adapterListener = postCommentsAdapterListener;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentsAdapter$Companion;", "", "()V", "PAYLOAD_ANIMATE_COMMENT", "", "PAYLOAD_LIKE_CHANGE", "PAYLOAD_LIKE_REPLY", "PAYLOAD_STATE_CHANGE", "PAYLOAD_UPDATE_COMMENT", "STATE_LOADED", "", "STATE_LOADING", "STATE_NOT_LOADED", "VIEW_TYPE_COMMENT", "VIEW_TYPE_LOAD", "VIEW_TYPE_REPLY", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentsAdapter$Companion */
    /* compiled from: PostCommentsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseViewHolder<BaseCommentModel> createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (i) {
            case 20:
                SingleCommentRowBinding inflate = SingleCommentRowBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "SingleCommentRowBinding.…(inflater, parent, false)");
                return new CommentsViewHolder(this, inflate);
            case 21:
                SingleCommentReplyItemBinding inflate2 = SingleCommentReplyItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "SingleCommentReplyItemBi…(inflater, parent, false)");
                return new RepliesViewHolder(this, inflate2);
            case 22:
                CommentsLoaderItemBinding inflate3 = CommentsLoaderItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "CommentsLoaderItemBindin…(inflater, parent, false)");
                return new CommentsRefreshViewHolder(this, inflate3);
            default:
                throw new RuntimeException("Unknown view type: " + i);
        }
    }

    public int getItemViewType(int i) {
        BaseCommentModel baseCommentModel = (BaseCommentModel) getItemAt(i);
        if (baseCommentModel instanceof CommentsLoader) {
            return 22;
        }
        if (baseCommentModel instanceof Reply) {
            return 21;
        }
        boolean z = baseCommentModel instanceof PostComment;
        return 20;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0016\u0010\u001d\u001a\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006!"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentsAdapter$CommentsViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/post_comments/BaseCommentModel;", "binding", "Lcom/memes/plus/databinding/SingleCommentRowBinding;", "(Lcom/memes/plus/ui/post_comments/PostCommentsAdapter;Lcom/memes/plus/databinding/SingleCommentRowBinding;)V", "comment", "Lcom/memes/plus/ui/post_comments/PostComment;", "animate", "", "invokeReplyProcess", "likePostCommentTemporarily", "loadMedia", "mediaType", "", "setItem", "item", "showPostCommentLikeCount", "postCommentLikesCount", "", "showPostCommentLikes", "togglePostCommentLike", "unlikePostCommentTemporarily", "updateComment", "commentText", "", "updateLoadingStates", "state", "updateViewAllReplies", "updateWithPayload", "payloads", "", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder */
    /* compiled from: PostCommentsAdapter.kt */
    public final class CommentsViewHolder extends BaseViewHolder<BaseCommentModel> {
        private final SingleCommentRowBinding binding;
        /* access modifiers changed from: private */
        public PostComment comment;
        final /* synthetic */ PostCommentsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public CommentsViewHolder(com.memes.plus.p040ui.post_comments.PostCommentsAdapter r2, com.memes.plus.databinding.SingleCommentRowBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.RelativeLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.TextView r2 = r3.viewRepliesTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$1 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.ImageView r2 = r3.commentContentImageView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$2 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$2
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                com.memes.plus.custom.UserAvatarView r2 = r3.profilePicImageView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$3 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$3
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                com.memes.commons.enhancedtext.socialtext.SocialTextView r2 = r3.userCommentTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$4 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$4
                r0.<init>(r1)
                com.memes.commons.enhancedtext.socialtext.SocialTextView$OnLinkClickListener r0 = (com.memes.commons.enhancedtext.socialtext.SocialTextView.OnLinkClickListener) r0
                r2.setOnLinkClickListener(r0)
                android.widget.ImageView r2 = r3.likeImageView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$5 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$5
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.commentReplyTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$6 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$6
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.editTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$7 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$7
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.deleteTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$8 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$8
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.reportTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$9 r3 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsViewHolder$9
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.post_comments.PostCommentsAdapter.CommentsViewHolder.<init>(com.memes.plus.ui.post_comments.PostCommentsAdapter, com.memes.plus.databinding.SingleCommentRowBinding):void");
        }

        public static final /* synthetic */ PostComment access$getComment$p(CommentsViewHolder commentsViewHolder) {
            PostComment postComment = commentsViewHolder.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            return postComment;
        }

        public void setItem(BaseCommentModel baseCommentModel) {
            Intrinsics.checkNotNullParameter(baseCommentModel, "item");
            PostComment postComment = (PostComment) baseCommentModel;
            this.comment = postComment;
            this.binding.profilePicImageView.setProUser(postComment.isProUser());
            UserAvatarView userAvatarView = this.binding.profilePicImageView;
            PostComment postComment2 = this.comment;
            if (postComment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            userAvatarView.loadUrl(postComment2.getProfileImgThumb(), C4199R.C4202drawable.placeholder_profile, 100);
            TextView textView = this.binding.userNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.userNameTextView");
            PostComment postComment3 = this.comment;
            if (postComment3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            textView.setText(postComment3.getUsername());
            TextView textView2 = this.binding.likesCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.likesCountTextView");
            StringBuilder sb = new StringBuilder();
            PrettyCounter prettyCounter = PrettyCounter.INSTANCE;
            PostComment postComment4 = this.comment;
            if (postComment4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            sb.append(prettyCounter.apply(String.valueOf(postComment4.getTotalLikesOnComment()), false));
            sb.append(" Likes");
            textView2.setText(sb.toString());
            TextView textView3 = this.binding.commentTimeTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.commentTimeTextView");
            PrettyTime prettyTime = PrettyTime.INSTANCE;
            PostComment postComment5 = this.comment;
            if (postComment5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            textView3.setText(prettyTime.getConciseTimeAgoString(Long.valueOf(postComment5.getCreatedDate())));
            PostComment postComment6 = this.comment;
            if (postComment6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            if (postComment6.getTotalReplies() > 0) {
                RelativeLayout relativeLayout = this.binding.viewRepliesRelativeLayout;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.viewRepliesRelativeLayout");
                relativeLayout.setVisibility(0);
            } else {
                RelativeLayout relativeLayout2 = this.binding.viewRepliesRelativeLayout;
                Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.viewRepliesRelativeLayout");
                relativeLayout2.setVisibility(8);
            }
            PostComment postComment7 = this.comment;
            if (postComment7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            if (postComment7.getILikeComment()) {
                this.binding.likeImageView.setImageResource(C4199R.C4202drawable.ic_heart_filled);
            } else {
                this.binding.likeImageView.setImageResource(C4199R.C4202drawable.heart_empty);
            }
            PostComment postComment8 = this.comment;
            if (postComment8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            loadMedia(postComment8.getCommentType());
            PostComment postComment9 = this.comment;
            if (postComment9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            boolean z = true;
            if (!Intrinsics.areEqual((Object) postComment9.getUserId(), (Object) MemesSession.INSTANCE.getUserId())) {
                TextView textView4 = this.binding.deleteTextView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.deleteTextView");
                textView4.setVisibility(8);
                TextView textView5 = this.binding.editTextView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.editTextView");
                textView5.setVisibility(8);
                TextView textView6 = this.binding.reportTextView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.reportTextView");
                textView6.setVisibility(0);
                return;
            }
            TextView textView7 = this.binding.deleteTextView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.deleteTextView");
            textView7.setVisibility(0);
            PostComment postComment10 = this.comment;
            if (postComment10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            CharSequence commentText = postComment10.getCommentText();
            if (!(commentText == null || commentText.length() == 0)) {
                z = false;
            }
            if (!z) {
                TextView textView8 = this.binding.editTextView;
                Intrinsics.checkNotNullExpressionValue(textView8, "binding.editTextView");
                textView8.setVisibility(0);
            }
            TextView textView9 = this.binding.reportTextView;
            Intrinsics.checkNotNullExpressionValue(textView9, "binding.reportTextView");
            textView9.setVisibility(8);
        }

        private final void loadMedia(int i) {
            String str = "";
            boolean z = true;
            if (i == 0) {
                ImageView imageView = this.binding.commentContentImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.commentContentImageView");
                imageView.setVisibility(8);
                SocialTextView socialTextView = this.binding.userCommentTextView;
                Intrinsics.checkNotNullExpressionValue(socialTextView, "binding.userCommentTextView");
                socialTextView.setVisibility(0);
                PostComment postComment = this.comment;
                if (postComment == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("comment");
                }
                CharSequence commentText = postComment.getCommentText();
                if (!(commentText == null || commentText.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    PostComment postComment2 = this.comment;
                    if (postComment2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("comment");
                    }
                    str = ExtensionsKt.encode(postComment2.getCommentText());
                }
                this.binding.userCommentTextView.setLinkText(str);
            } else if (i == 1) {
                PostComment postComment3 = this.comment;
                if (postComment3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("comment");
                }
                CharSequence commentImage = postComment3.getCommentImage();
                if (!(commentImage == null || StringsKt.isBlank(commentImage))) {
                    ImageView imageView2 = this.binding.commentContentImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.commentContentImageView");
                    imageView2.setVisibility(0);
                    SocialTextView socialTextView2 = this.binding.userCommentTextView;
                    Intrinsics.checkNotNullExpressionValue(socialTextView2, "binding.userCommentTextView");
                    socialTextView2.setVisibility(0);
                    PostComment postComment4 = this.comment;
                    if (postComment4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("comment");
                    }
                    CharSequence commentText2 = postComment4.getCommentText();
                    if (!(commentText2 == null || commentText2.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        PostComment postComment5 = this.comment;
                        if (postComment5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("comment");
                        }
                        str = ExtensionsKt.encode(postComment5.getCommentText());
                    }
                    this.binding.userCommentTextView.setLinkText(str);
                    PostComment postComment6 = this.comment;
                    if (postComment6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("comment");
                    }
                    ((RequestBuilder) ((RequestBuilder) Glide.with(this.this$0.context).load(postComment6.getCommentImageUrl()).placeholder((int) C4199R.C4202drawable.ic_placeholder)).override(150, 150)).into(this.binding.commentContentImageView);
                }
            } else if (i == 4) {
                PostComment postComment7 = this.comment;
                if (postComment7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("comment");
                }
                CharSequence commentImage2 = postComment7.getCommentImage();
                if (!(commentImage2 == null || StringsKt.isBlank(commentImage2))) {
                    ImageView imageView3 = this.binding.commentContentImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.commentContentImageView");
                    imageView3.setVisibility(0);
                    SocialTextView socialTextView3 = this.binding.userCommentTextView;
                    Intrinsics.checkNotNullExpressionValue(socialTextView3, "binding.userCommentTextView");
                    socialTextView3.setVisibility(0);
                    PostComment postComment8 = this.comment;
                    if (postComment8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("comment");
                    }
                    CharSequence commentText3 = postComment8.getCommentText();
                    if (!(commentText3 == null || commentText3.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        PostComment postComment9 = this.comment;
                        if (postComment9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("comment");
                        }
                        str = ExtensionsKt.encode(postComment9.getCommentText());
                    }
                    this.binding.userCommentTextView.setLinkText(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(ApiRouting.GIPHY_CONTENT_ENDPOINT);
                    PostComment postComment10 = this.comment;
                    if (postComment10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("comment");
                    }
                    sb.append(postComment10.getCommentImage());
                    sb.append("/giphy.gif");
                    ((RequestBuilder) ((RequestBuilder) Glide.with(this.this$0.context).asGif().load(sb.toString()).placeholder((int) C4199R.C4202drawable.ic_placeholder)).override(150, 150)).into(this.binding.commentContentImageView);
                }
            }
        }

        /* access modifiers changed from: private */
        public final void updateLoadingStates(int i) {
            if (i == 1) {
                TextView textView = this.binding.viewRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.viewRepliesTextView");
                textView.setVisibility(0);
                TextView textView2 = this.binding.loadingRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.loadingRepliesTextView");
                textView2.setVisibility(8);
                TextView textView3 = this.binding.viewRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.viewRepliesTextView");
                textView3.setText("Hide replies");
            } else if (i == 2) {
                TextView textView4 = this.binding.viewRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.viewRepliesTextView");
                textView4.setVisibility(0);
                TextView textView5 = this.binding.loadingRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.loadingRepliesTextView");
                textView5.setVisibility(8);
                TextView textView6 = this.binding.viewRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.viewRepliesTextView");
                textView6.setText("View replies");
            } else if (i == 3) {
                TextView textView7 = this.binding.viewRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.viewRepliesTextView");
                textView7.setVisibility(8);
                TextView textView8 = this.binding.loadingRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView8, "binding.loadingRepliesTextView");
                textView8.setVisibility(0);
            }
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            postComment.setLoadingState(i);
            updateViewAllReplies();
        }

        private final void updateViewAllReplies() {
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            if (postComment.getTotalReplies() == 0) {
                RelativeLayout relativeLayout = this.binding.viewRepliesRelativeLayout;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.viewRepliesRelativeLayout");
                relativeLayout.setVisibility(0);
                TextView textView = this.binding.loadingRepliesTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.loadingRepliesTextView");
                textView.setVisibility(8);
            }
        }

        private final void updateComment(String str) {
            this.binding.userCommentTextView.setLinkText(ExtensionsKt.encode(str));
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            postComment.setCommentText(str);
        }

        public void updateWithPayload(List<Object> list) {
            Intrinsics.checkNotNullParameter(list, "payloads");
            for (Object next : list) {
                if (next instanceof AdapterViewHolderPayload) {
                    AdapterViewHolderPayload adapterViewHolderPayload = (AdapterViewHolderPayload) next;
                    String key = adapterViewHolderPayload.getKey();
                    switch (key.hashCode()) {
                        case -1903578544:
                            if (!key.equals(PostCommentsAdapter.PAYLOAD_ANIMATE_COMMENT)) {
                                break;
                            } else {
                                Object value = adapterViewHolderPayload.getValue();
                                Objects.requireNonNull(value, "null cannot be cast to non-null type com.memes.plus.ui.post_comments.PostComment");
                                this.comment = (PostComment) value;
                                animate();
                                break;
                            }
                        case -1740680153:
                            if (!key.equals("payload_like_change")) {
                                break;
                            } else {
                                Object value2 = adapterViewHolderPayload.getValue();
                                Objects.requireNonNull(value2, "null cannot be cast to non-null type com.memes.plus.ui.post_comments.PostComment");
                                PostComment postComment = (PostComment) value2;
                                PostComment postComment2 = this.comment;
                                if (postComment2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("comment");
                                }
                                postComment2.setILikeComment(postComment.getILikeComment());
                                PostComment postComment3 = this.comment;
                                if (postComment3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("comment");
                                }
                                postComment3.setTotalLikesOnComment(postComment.getTotalLikesOnComment());
                                showPostCommentLikes();
                                break;
                            }
                        case -1006553553:
                            if (!key.equals(PostCommentsAdapter.PAYLOAD_STATE_CHANGE)) {
                                break;
                            } else {
                                Object value3 = adapterViewHolderPayload.getValue();
                                Objects.requireNonNull(value3, "null cannot be cast to non-null type kotlin.Int");
                                int intValue = ((Integer) value3).intValue();
                                PostComment postComment4 = this.comment;
                                if (postComment4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("comment");
                                }
                                postComment4.setLoadingState(intValue);
                                PostComment postComment5 = this.comment;
                                if (postComment5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("comment");
                                }
                                updateLoadingStates(postComment5.getLoadingState());
                                break;
                            }
                        case 370439098:
                            if (!key.equals(PostCommentsAdapter.PAYLOAD_UPDATE_COMMENT)) {
                                break;
                            } else {
                                Object value4 = adapterViewHolderPayload.getValue();
                                Objects.requireNonNull(value4, "null cannot be cast to non-null type kotlin.String");
                                updateComment((String) value4);
                                break;
                            }
                    }
                }
            }
            super.updateWithPayload(list);
        }

        private final void showPostCommentLikes() {
            ImageView imageView = this.binding.likeImageView;
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            imageView.setImageResource(postComment.getILikeComment() ? C4199R.mipmap.heart_filled : C4199R.C4202drawable.heart_empty);
            PostComment postComment2 = this.comment;
            if (postComment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            showPostCommentLikeCount(postComment2.getTotalLikesOnComment());
        }

        private final void animate() {
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            if (postComment.getShouldAnimate()) {
                this.binding.userCommentLinearLayout.startAnimation(AnimationUtils.loadAnimation(this.this$0.context, C4199R.anim.animation_bounce));
            }
        }

        private final void showPostCommentLikeCount(long j) {
            CharSequence charSequence;
            TextView textView = this.binding.likesCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.likesCountTextView");
            int i = (j > 1 ? 1 : (j == 1 ? 0 : -1));
            if (i == 0) {
                charSequence = j + " Like";
            } else if (i > 0) {
                charSequence = PrettyCounter.INSTANCE.apply(j) + " Likes";
            }
            textView.setText(charSequence);
        }

        /* access modifiers changed from: private */
        public final void togglePostCommentLike() {
            PostCommentsAdapterListener access$getAdapterListener$p = this.this$0.adapterListener;
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            access$getAdapterListener$p.onCommentLikeButtonClicked(postComment);
            PostComment postComment2 = this.comment;
            if (postComment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            if (postComment2.getILikeComment()) {
                unlikePostCommentTemporarily();
            } else {
                likePostCommentTemporarily();
            }
        }

        /* access modifiers changed from: private */
        public final void invokeReplyProcess() {
            PostCommentsAdapterListener access$getAdapterListener$p = this.this$0.adapterListener;
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            access$getAdapterListener$p.onCommentReplyClicked(postComment);
        }

        private final void likePostCommentTemporarily() {
            this.binding.likeImageView.setImageResource(C4199R.mipmap.heart_filled);
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            showPostCommentLikeCount(postComment.getTotalLikesOnComment() + 1);
        }

        private final void unlikePostCommentTemporarily() {
            this.binding.likeImageView.setImageResource(C4199R.mipmap.heart_empty);
            PostComment postComment = this.comment;
            if (postComment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("comment");
            }
            showPostCommentLikeCount(postComment.getTotalLikesOnComment() - 1);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0016\u0010\u0015\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentsAdapter$RepliesViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/post_comments/BaseCommentModel;", "binding", "Lcom/memes/plus/databinding/SingleCommentReplyItemBinding;", "(Lcom/memes/plus/ui/post_comments/PostCommentsAdapter;Lcom/memes/plus/databinding/SingleCommentReplyItemBinding;)V", "reply", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "likeReplyTemporarily", "", "loadReplyMedia", "mediaType", "", "setItem", "item", "showLikesOnReply", "showReplyLikeCount", "replyLikesCount", "", "toggleReplyLike", "unlikeReplyTemporarily", "updateWithPayload", "payloads", "", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder */
    /* compiled from: PostCommentsAdapter.kt */
    public final class RepliesViewHolder extends BaseViewHolder<BaseCommentModel> {
        private final SingleCommentReplyItemBinding binding;
        /* access modifiers changed from: private */
        public Reply reply;
        final /* synthetic */ PostCommentsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public RepliesViewHolder(com.memes.plus.p040ui.post_comments.PostCommentsAdapter r2, com.memes.plus.databinding.SingleCommentReplyItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.RelativeLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.TextView r2 = r3.replyReplyTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$1 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.replyDeleteTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$2 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$2
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.replyReportTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$3 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$3
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.ImageView r2 = r3.replyLikeImageView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$4 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$4
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.TextView r2 = r3.replyEditTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$5 r0 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$5
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                com.memes.commons.enhancedtext.socialtext.SocialTextView r2 = r3.userCommentTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$6 r3 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$RepliesViewHolder$6
                r3.<init>(r1)
                com.memes.commons.enhancedtext.socialtext.SocialTextView$OnLinkClickListener r3 = (com.memes.commons.enhancedtext.socialtext.SocialTextView.OnLinkClickListener) r3
                r2.setOnLinkClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.post_comments.PostCommentsAdapter.RepliesViewHolder.<init>(com.memes.plus.ui.post_comments.PostCommentsAdapter, com.memes.plus.databinding.SingleCommentReplyItemBinding):void");
        }

        public static final /* synthetic */ Reply access$getReply$p(RepliesViewHolder repliesViewHolder) {
            Reply reply2 = repliesViewHolder.reply;
            if (reply2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            return reply2;
        }

        public void setItem(BaseCommentModel baseCommentModel) {
            Intrinsics.checkNotNullParameter(baseCommentModel, "item");
            Reply reply2 = (Reply) baseCommentModel;
            this.reply = reply2;
            this.binding.profilePicImageView.setOnClickListener(new PostCommentsAdapter$RepliesViewHolder$setItem$1(this));
            this.binding.profilePicImageView.setOnClickListener(new PostCommentsAdapter$RepliesViewHolder$setItem$2(this));
            this.binding.profilePicImageView.setProUser(reply2.isProUser());
            UserAvatarView userAvatarView = this.binding.profilePicImageView;
            Reply reply3 = this.reply;
            if (reply3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            userAvatarView.loadUrl(reply3.getProfileImgThumb(), C4199R.C4202drawable.placeholder_profile, 100);
            TextView textView = this.binding.userNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.userNameTextView");
            Reply reply4 = this.reply;
            if (reply4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            textView.setText(reply4.getUsername());
            SocialTextView socialTextView = this.binding.userCommentTextView;
            Reply reply5 = this.reply;
            if (reply5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            socialTextView.setLinkText(ExtensionsKt.encode(reply5.getCommentText()));
            TextView textView2 = this.binding.commentTimeTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.commentTimeTextView");
            PrettyTime prettyTime = PrettyTime.INSTANCE;
            Reply reply6 = this.reply;
            if (reply6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            textView2.setText(prettyTime.getConciseTimeAgoString(Long.valueOf(reply6.getCreatedDate())));
            Reply reply7 = this.reply;
            if (reply7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            if (Intrinsics.areEqual((Object) reply7.getUserId(), (Object) MemesSession.INSTANCE.getUserId())) {
                TextView textView3 = this.binding.replyDeleteTextView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.replyDeleteTextView");
                textView3.setVisibility(0);
                TextView textView4 = this.binding.replyEditTextView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.replyEditTextView");
                textView4.setVisibility(0);
                TextView textView5 = this.binding.replyReportTextView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.replyReportTextView");
                textView5.setVisibility(8);
            } else {
                TextView textView6 = this.binding.replyDeleteTextView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.replyDeleteTextView");
                textView6.setVisibility(8);
                TextView textView7 = this.binding.replyEditTextView;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.replyEditTextView");
                textView7.setVisibility(8);
                TextView textView8 = this.binding.replyReportTextView;
                Intrinsics.checkNotNullExpressionValue(textView8, "binding.replyReportTextView");
                textView8.setVisibility(0);
            }
            Reply reply8 = this.reply;
            if (reply8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            Integer replyType = reply8.getReplyType();
            if (replyType != null) {
                loadReplyMedia(replyType.intValue());
            }
            showLikesOnReply();
        }

        /* access modifiers changed from: private */
        public final void toggleReplyLike() {
            PostCommentsAdapterListener access$getAdapterListener$p = this.this$0.adapterListener;
            Reply reply2 = this.reply;
            if (reply2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            access$getAdapterListener$p.onLikeReplyClicked(reply2);
            Reply reply3 = this.reply;
            if (reply3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            if (reply3.getILikeReply()) {
                unlikeReplyTemporarily();
            } else {
                likeReplyTemporarily();
            }
        }

        private final void loadReplyMedia(int i) {
            boolean z = false;
            if (i == 0) {
                ImageView imageView = this.binding.commentContentImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.commentContentImageView");
                imageView.setVisibility(8);
                SocialTextView socialTextView = this.binding.userCommentTextView;
                Intrinsics.checkNotNullExpressionValue(socialTextView, "binding.userCommentTextView");
                socialTextView.setVisibility(0);
                SocialTextView socialTextView2 = this.binding.userCommentTextView;
                Reply reply2 = this.reply;
                if (reply2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                }
                socialTextView2.setLinkText(ExtensionsKt.encode(reply2.getCommentText()));
            } else if (i == 1) {
                Reply reply3 = this.reply;
                if (reply3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                }
                CharSequence replyImage = reply3.getReplyImage();
                if (!(replyImage == null || StringsKt.isBlank(replyImage))) {
                    ImageView imageView2 = this.binding.commentContentImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.commentContentImageView");
                    imageView2.setVisibility(0);
                    SocialTextView socialTextView3 = this.binding.userCommentTextView;
                    Intrinsics.checkNotNullExpressionValue(socialTextView3, "binding.userCommentTextView");
                    socialTextView3.setVisibility(0);
                    Reply reply4 = this.reply;
                    if (reply4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                    }
                    CharSequence commentText = reply4.getCommentText();
                    if (commentText == null || commentText.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        SocialTextView socialTextView4 = this.binding.userCommentTextView;
                        Reply reply5 = this.reply;
                        if (reply5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                        }
                        socialTextView4.setLinkText(ExtensionsKt.encode(reply5.getCommentText()));
                    }
                    Reply reply6 = this.reply;
                    if (reply6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                    }
                    ((RequestBuilder) ((RequestBuilder) Glide.with(this.this$0.context).load(reply6.getReplyImageUrl()).placeholder((int) C4199R.C4202drawable.ic_placeholder)).override(150, 150)).into(this.binding.commentContentImageView);
                }
            } else if (i == 4) {
                Reply reply7 = this.reply;
                if (reply7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                }
                CharSequence replyImage2 = reply7.getReplyImage();
                if (!(replyImage2 == null || StringsKt.isBlank(replyImage2))) {
                    ImageView imageView3 = this.binding.commentContentImageView;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.commentContentImageView");
                    imageView3.setVisibility(0);
                    SocialTextView socialTextView5 = this.binding.userCommentTextView;
                    Intrinsics.checkNotNullExpressionValue(socialTextView5, "binding.userCommentTextView");
                    socialTextView5.setVisibility(0);
                    Reply reply8 = this.reply;
                    if (reply8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                    }
                    CharSequence commentText2 = reply8.getCommentText();
                    if (commentText2 == null || commentText2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        SocialTextView socialTextView6 = this.binding.userCommentTextView;
                        Reply reply9 = this.reply;
                        if (reply9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                        }
                        socialTextView6.setLinkText(ExtensionsKt.encode(reply9.getCommentText()));
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(ApiRouting.GIPHY_CONTENT_ENDPOINT);
                    Reply reply10 = this.reply;
                    if (reply10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                    }
                    sb.append(reply10.getReplyImage());
                    sb.append("/giphy.gif");
                    ((RequestBuilder) ((RequestBuilder) Glide.with(this.this$0.context).asGif().load(sb.toString()).placeholder((int) C4199R.C4202drawable.ic_placeholder)).override(150, 150)).into(this.binding.commentContentImageView);
                }
            }
        }

        private final void showLikesOnReply() {
            ImageView imageView = this.binding.replyLikeImageView;
            Reply reply2 = this.reply;
            if (reply2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            imageView.setImageResource(reply2.getILikeReply() ? C4199R.mipmap.heart_filled : C4199R.C4202drawable.heart_empty);
            Reply reply3 = this.reply;
            if (reply3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            showReplyLikeCount(reply3.getReplyLikes());
        }

        private final void likeReplyTemporarily() {
            this.binding.replyLikeImageView.setImageResource(C4199R.mipmap.heart_filled);
            Reply reply2 = this.reply;
            if (reply2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            showReplyLikeCount(reply2.getReplyLikes() + 1);
        }

        private final void unlikeReplyTemporarily() {
            this.binding.replyLikeImageView.setImageResource(C4199R.mipmap.heart_empty);
            Reply reply2 = this.reply;
            if (reply2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
            }
            showReplyLikeCount(reply2.getReplyLikes() - 1);
        }

        private final void showReplyLikeCount(long j) {
            CharSequence charSequence;
            TextView textView = this.binding.replyLikesCountTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.replyLikesCountTextView");
            int i = (j > 1 ? 1 : (j == 1 ? 0 : -1));
            if (i == 0) {
                charSequence = j + " Like";
            } else if (i > 0) {
                charSequence = PrettyCounter.INSTANCE.apply(j) + " Likes";
            }
            textView.setText(charSequence);
        }

        public void updateWithPayload(List<Object> list) {
            Intrinsics.checkNotNullParameter(list, "payloads");
            for (Object next : list) {
                if (next instanceof AdapterViewHolderPayload) {
                    AdapterViewHolderPayload adapterViewHolderPayload = (AdapterViewHolderPayload) next;
                    String key = adapterViewHolderPayload.getKey();
                    if (key.hashCode() == 148446994 && key.equals(PostCommentsAdapter.PAYLOAD_LIKE_REPLY)) {
                        Object value = adapterViewHolderPayload.getValue();
                        Objects.requireNonNull(value, "null cannot be cast to non-null type com.memes.plus.ui.post_comments.reply.Reply");
                        Reply reply2 = (Reply) value;
                        Reply reply3 = this.reply;
                        if (reply3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                        }
                        reply3.setILikeComment(reply2.getILikeComment());
                        Reply reply4 = this.reply;
                        if (reply4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ModelType.message_reply);
                        }
                        reply4.setReplyLikes(RangesKt.coerceAtLeast(reply2.getReplyLikes(), 0));
                        showLikesOnReply();
                    }
                }
            }
            super.updateWithPayload(list);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/PostCommentsAdapter$CommentsRefreshViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/post_comments/BaseCommentModel;", "binding", "Lcom/memes/plus/databinding/CommentsLoaderItemBinding;", "(Lcom/memes/plus/ui/post_comments/PostCommentsAdapter;Lcom/memes/plus/databinding/CommentsLoaderItemBinding;)V", "getBinding", "()Lcom/memes/plus/databinding/CommentsLoaderItemBinding;", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsRefreshViewHolder */
    /* compiled from: PostCommentsAdapter.kt */
    public final class CommentsRefreshViewHolder extends BaseViewHolder<BaseCommentModel> {
        private final CommentsLoaderItemBinding binding;
        final /* synthetic */ PostCommentsAdapter this$0;

        public void setItem(BaseCommentModel baseCommentModel) {
            Intrinsics.checkNotNullParameter(baseCommentModel, "item");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public CommentsRefreshViewHolder(com.memes.plus.p040ui.post_comments.PostCommentsAdapter r2, com.memes.plus.databinding.CommentsLoaderItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                androidx.constraintlayout.widget.ConstraintLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.TextView r2 = r3.loaderTextView
                com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsRefreshViewHolder$1 r3 = new com.memes.plus.ui.post_comments.PostCommentsAdapter$CommentsRefreshViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.post_comments.PostCommentsAdapter.CommentsRefreshViewHolder.<init>(com.memes.plus.ui.post_comments.PostCommentsAdapter, com.memes.plus.databinding.CommentsLoaderItemBinding):void");
        }

        public final CommentsLoaderItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void updateLikedFlag(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "updatedComment");
        int i = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if (!(baseCommentModel instanceof PostComment) || !Intrinsics.areEqual((Object) ((PostComment) baseCommentModel).getCommentId(), (Object) postComment.getCommentId())) {
                i++;
            } else {
                notifyItemChanged(i, new AdapterViewHolderPayload("payload_like_change", postComment));
                return;
            }
        }
    }

    public final void updateViewRepliesUI(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "commentId");
        int i2 = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if (!(baseCommentModel instanceof PostComment) || !Intrinsics.areEqual((Object) ((PostComment) baseCommentModel).getCommentId(), (Object) str)) {
                i2++;
            } else {
                notifyItemChanged(i2, new AdapterViewHolderPayload(PAYLOAD_STATE_CHANGE, Integer.valueOf(i)));
                return;
            }
        }
    }

    public static /* synthetic */ void addRepliesToComment$default(PostCommentsAdapter postCommentsAdapter, List list, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        postCommentsAdapter.addRepliesToComment(list, str, z);
    }

    public final void addRepliesToComment(List<Reply> list, String str, boolean z) {
        Intrinsics.checkNotNullParameter(list, "listOfReplies");
        Intrinsics.checkNotNullParameter(str, "commentId");
        removeListReplies(str);
        if (!list.isEmpty()) {
            int i = 0;
            for (BaseCommentModel baseCommentModel : getItems()) {
                if (baseCommentModel instanceof PostComment) {
                    PostComment postComment = (PostComment) baseCommentModel;
                    if (Intrinsics.areEqual((Object) str, (Object) postComment.getCommentId())) {
                        for (Reply addItemAt : CollectionsKt.reversed(list)) {
                            postComment.setTotalReplies(1);
                            addItemAt(1 + i, addItemAt);
                        }
                        updateViewRepliesUI(str, 1);
                        return;
                    }
                }
                i++;
            }
        }
    }

    public final void updateComment(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "updatedComment");
        int i = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if (!(baseCommentModel instanceof PostComment) || !Intrinsics.areEqual((Object) ((PostComment) baseCommentModel).getCommentId(), (Object) postComment.getCommentId())) {
                i++;
            } else {
                notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_UPDATE_COMMENT, postComment.getCommentText()));
                return;
            }
        }
    }

    public final void deleteComment(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "targetComment");
        int i = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if (!(baseCommentModel instanceof PostComment) || !Intrinsics.areEqual((Object) ((PostComment) baseCommentModel).getCommentId(), (Object) postComment.getCommentId())) {
                i++;
            } else {
                String commentId = postComment.getCommentId();
                Intrinsics.checkNotNull(commentId);
                removeListReplies(commentId);
                removeItemAt(i);
                return;
            }
        }
    }

    public final void deleteReply(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "targetReply");
        int i = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if ((baseCommentModel instanceof Reply) && (postComment instanceof Reply)) {
                Reply reply = (Reply) baseCommentModel;
                if (Intrinsics.areEqual((Object) postComment.getReplyId(), (Object) reply.getReplyId())) {
                    removeItemAt(i);
                    if (reply.getTotalReplies() > 1) {
                        reply.setTotalReplies(reply.getTotalReplies() - 1);
                        Log.e("Total Comments  :", String.valueOf(reply.getTotalReplies()));
                        if (reply.getTotalReplies() == 0) {
                            String commentId = reply.getCommentId();
                            Intrinsics.checkNotNull(commentId);
                            updateViewRepliesUI(commentId, 2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            i++;
        }
    }

    public final void likeReply(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "targetReply");
        int i = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if (!(baseCommentModel instanceof Reply) || !(postComment instanceof Reply) || !Intrinsics.areEqual((Object) postComment.getReplyId(), (Object) ((Reply) baseCommentModel).getReplyId())) {
                i++;
            } else {
                notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_LIKE_REPLY, baseCommentModel));
                return;
            }
        }
    }

    public final void updateReply(PostComment postComment) {
        Intrinsics.checkNotNullParameter(postComment, "targetReply");
        int i = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if ((baseCommentModel instanceof Reply) && (postComment instanceof Reply)) {
                Reply reply = (Reply) baseCommentModel;
                if (Intrinsics.areEqual((Object) postComment.getReplyId(), (Object) reply.getReplyId())) {
                    reply.setCommentText(postComment.getCommentText());
                    notifyItemChanged(i);
                    return;
                }
            }
            i++;
        }
    }

    public final void addSingleReply(Reply reply) {
        Intrinsics.checkNotNullParameter(reply, ModelType.message_reply);
        int i = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if (baseCommentModel instanceof PostComment) {
                PostComment postComment = (PostComment) baseCommentModel;
                if (Intrinsics.areEqual((Object) reply.getCommentId(), (Object) postComment.getCommentId())) {
                    postComment.setTotalReplies(1);
                    notifyItemChanged(i);
                    addItemAt(i + postComment.getTotalReplies(), reply);
                    return;
                }
            }
            i++;
        }
    }

    public final int findItemPositionWithId(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        int i = 0;
        for (BaseCommentModel baseCommentModel : getItems()) {
            if ((baseCommentModel instanceof PostComment) && Intrinsics.areEqual((Object) ((PostComment) baseCommentModel).getCommentId(), (Object) str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final PostComment getComment(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        for (BaseCommentModel baseCommentModel : getItems()) {
            if (baseCommentModel instanceof PostComment) {
                PostComment postComment = (PostComment) baseCommentModel;
                if (Intrinsics.areEqual((Object) postComment.getCommentId(), (Object) str)) {
                    return postComment;
                }
            }
        }
        return null;
    }

    public final void animateComment(int i) {
        Object itemAt = getItemAt(i);
        if (!(itemAt instanceof PostComment)) {
            itemAt = null;
        }
        PostComment postComment = (PostComment) itemAt;
        if (postComment != null) {
            postComment.setShouldAnimate(true);
            notifyItemChanged(i, new AdapterViewHolderPayload(PAYLOAD_ANIMATE_COMMENT, postComment));
        }
    }

    public final void removeListReplies(String str) {
        Intrinsics.checkNotNullParameter(str, "commentId");
        ListIterator listIterator = getItems().listIterator();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        while (listIterator.hasNext()) {
            BaseCommentModel baseCommentModel = (BaseCommentModel) listIterator.next();
            if ((baseCommentModel instanceof Reply) && Intrinsics.areEqual((Object) ((Reply) baseCommentModel).getCommentId(), (Object) str)) {
                Timber.m300d("Removing item " + str + " at " + i3, new Object[0]);
                if (i == -1) {
                    i = i3;
                }
                listIterator.remove();
                i2++;
            }
            i3++;
        }
        updateViewRepliesUI(str, 2);
        Timber.m300d("Notifying: from " + i + " to " + (i + i2), new Object[0]);
        notifyItemRangeRemoved(i, i2);
    }
}
