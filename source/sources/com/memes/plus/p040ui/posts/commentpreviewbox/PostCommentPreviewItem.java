package com.memes.plus.p040ui.posts.commentpreviewbox;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.enhancedtext.socialtext.SocialTextView;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.commons.util.ExtensionsKt;
import com.memes.commons.util.PrettyCounter;
import com.memes.plus.ApiRouting;
import com.memes.plus.C4199R;
import com.memes.plus.databinding.PostCommentPreviewItemBinding;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.p040ui.posts.PostAction;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\u0006\u0010\u001c\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/plus/ui/posts/commentpreviewbox/PostCommentPreviewItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/memes/plus/databinding/PostCommentPreviewItemBinding;", "getBinding", "()Lcom/memes/plus/databinding/PostCommentPreviewItemBinding;", "binding$delegate", "Lkotlin/Lazy;", "comment", "Lcom/memes/plus/ui/posts/commentpreviewbox/PostPreviewComment;", "post", "Lcom/memes/plus/ui/posts/Post;", "postActionListener", "Lcom/memes/plus/ui/posts/PostAction$Listener;", "createSpannableTextContent", "Landroid/text/Spannable;", "load", "", "listener", "loadGifComment", "loadImageComment", "loadTextComment", "onFinishInflate", "reset", "showText", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.commentpreviewbox.PostCommentPreviewItem */
/* compiled from: PostCommentPreviewItem.kt */
public final class PostCommentPreviewItem extends LinearLayout {
    private final Lazy binding$delegate;
    /* access modifiers changed from: private */
    public PostPreviewComment comment;
    /* access modifiers changed from: private */
    public Post post;
    /* access modifiers changed from: private */
    public PostAction.Listener postActionListener;

    /* access modifiers changed from: private */
    public final PostCommentPreviewItemBinding getBinding() {
        return (PostCommentPreviewItemBinding) this.binding$delegate.getValue();
    }

    public static final /* synthetic */ PostPreviewComment access$getComment$p(PostCommentPreviewItem postCommentPreviewItem) {
        PostPreviewComment postPreviewComment = postCommentPreviewItem.comment;
        if (postPreviewComment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comment");
        }
        return postPreviewComment;
    }

    public static final /* synthetic */ Post access$getPost$p(PostCommentPreviewItem postCommentPreviewItem) {
        Post post2 = postCommentPreviewItem.post;
        if (post2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("post");
        }
        return post2;
    }

    public static final /* synthetic */ PostAction.Listener access$getPostActionListener$p(PostCommentPreviewItem postCommentPreviewItem) {
        PostAction.Listener listener = postCommentPreviewItem.postActionListener;
        if (listener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postActionListener");
        }
        return listener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostCommentPreviewItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new PostCommentPreviewItem$binding$2(this, context));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        getBinding();
        super.onFinishInflate();
        getBinding().commentContentTextView.setOnClickListener(new PostCommentPreviewItem$onFinishInflate$1(this));
        getBinding().commentContentImageView.setOnClickListener(new PostCommentPreviewItem$onFinishInflate$2(this));
        getBinding().commentContentTextView.setOnLinkClickListener(new PostCommentPreviewItem$onFinishInflate$3(this));
        getBinding().commentLikeImageView.setOnClickListener(new PostCommentPreviewItem$onFinishInflate$4(this));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        float dimension = context.getResources().getDimension(C4199R.dimen._5sdp);
        ImageView imageView = getBinding().commentContentImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.commentContentImageView");
        ViewCornerOutlineProviderKt.roundCorners$default((View) imageView, dimension, (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
    }

    public final void load(Post post2, PostPreviewComment postPreviewComment, PostAction.Listener listener) {
        Intrinsics.checkNotNullParameter(post2, "post");
        Intrinsics.checkNotNullParameter(postPreviewComment, "comment");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.post = post2;
        this.comment = postPreviewComment;
        this.postActionListener = listener;
        Integer totalLikesCount = postPreviewComment.getTotalLikesCount();
        String apply$default = PrettyCounter.apply$default(PrettyCounter.INSTANCE, String.valueOf(totalLikesCount != null ? totalLikesCount.intValue() : 0), false, 2, (Object) null);
        TextView textView = getBinding().commentLikesCountTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.commentLikesCountTextView");
        textView.setText(apply$default);
        boolean selfCommentLiked = postPreviewComment.getSelfCommentLiked();
        ImageView imageView = getBinding().commentLikeImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.commentLikeImageView");
        imageView.setSelected(selfCommentLiked);
        int type = postPreviewComment.getType();
        if (type == 0) {
            loadTextComment(postPreviewComment);
        } else if (type == 1) {
            loadImageComment(postPreviewComment);
        } else if (type != 4) {
            reset();
        } else {
            loadGifComment(postPreviewComment);
        }
    }

    private final void showText() {
        SocialTextView socialTextView = getBinding().commentContentTextView;
        Intrinsics.checkNotNullExpressionValue(socialTextView, "binding.commentContentTextView");
        socialTextView.setVisibility(0);
        getBinding().commentContentTextView.setText(createSpannableTextContent());
    }

    private final void loadTextComment(PostPreviewComment postPreviewComment) {
        showText();
        ImageView imageView = getBinding().commentContentImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.commentContentImageView");
        imageView.setVisibility(8);
    }

    private final void loadImageComment(PostPreviewComment postPreviewComment) {
        showText();
        String commentImageUrl = postPreviewComment.getCommentImageUrl();
        CharSequence charSequence = commentImageUrl;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            ImageView imageView = getBinding().commentContentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.commentContentImageView");
            imageView.setVisibility(8);
            return;
        }
        ((RequestBuilder) Glide.with(getContext()).load(commentImageUrl).placeholder((int) C4199R.C4202drawable.ic_placeholder)).into(getBinding().commentContentImageView);
        ImageView imageView2 = getBinding().commentContentImageView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.commentContentImageView");
        imageView2.setVisibility(0);
    }

    private final void loadGifComment(PostPreviewComment postPreviewComment) {
        showText();
        String commentImageUrl = postPreviewComment.getCommentImageUrl();
        CharSequence charSequence = commentImageUrl;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            ImageView imageView = getBinding().commentContentImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.commentContentImageView");
            imageView.setVisibility(8);
            return;
        }
        ((RequestBuilder) Glide.with(getContext()).asGif().load(ApiRouting.GIPHY_CONTENT_ENDPOINT + commentImageUrl + "/giphy.gif").placeholder((int) C4199R.C4202drawable.ic_placeholder)).into(getBinding().commentContentImageView);
        ImageView imageView2 = getBinding().commentContentImageView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.commentContentImageView");
        imageView2.setVisibility(0);
    }

    public final void reset() {
        SocialTextView socialTextView = getBinding().commentContentTextView;
        Intrinsics.checkNotNullExpressionValue(socialTextView, "binding.commentContentTextView");
        socialTextView.setText("");
        getBinding().commentContentImageView.setImageResource(0);
        ImageView imageView = getBinding().commentContentImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.commentContentImageView");
        imageView.setVisibility(8);
    }

    private final Spannable createSpannableTextContent() {
        PostPreviewComment postPreviewComment = this.comment;
        if (postPreviewComment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comment");
        }
        String text = postPreviewComment.getText();
        if (text == null) {
            text = "";
        }
        String encode = ExtensionsKt.encode(text);
        PostPreviewComment postPreviewComment2 = this.comment;
        if (postPreviewComment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("comment");
        }
        SpannableString spannableString = new SpannableString(postPreviewComment2.getAuthorUserName());
        spannableString.setSpan(new ForegroundColorSpan((int) 4288256409L), 0, spannableString.length(), 33);
        spannableString.setSpan(new PostCommentPreviewItem$createSpannableTextContent$1(this), 0, spannableString.length(), 17);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
        spannableStringBuilder.append("  ");
        spannableStringBuilder.append(getBinding().commentContentTextView.createSpansFor(encode));
        return spannableStringBuilder;
    }
}
