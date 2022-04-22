package com.memes.plus.p040ui.post_comments;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.model.ModelType;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "reply", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$registerViewModel$14 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$registerViewModel$14<T> implements Observer<Reply> {
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$registerViewModel$14(PostCommentsActivity postCommentsActivity) {
        this.this$0 = postCommentsActivity;
    }

    public final void onChanged(Reply reply) {
        EditText editText = this.this$0.getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        ExtensionsKt.clearText(editText);
        ImageView imageView = this.this$0.getBinding().gifSelectionImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.gifSelectionImageView");
        imageView.setVisibility(0);
        RelativeLayout relativeLayout = this.this$0.getBinding().gifWrapperRelativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.gifWrapperRelativeLayout");
        if (relativeLayout.getVisibility() == 0) {
            this.this$0.setGifWrapperVisibility(false);
        }
        PostCommentsAdapter access$getCommentsAdapter$p = PostCommentsActivity.access$getCommentsAdapter$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(reply, ModelType.message_reply);
        access$getCommentsAdapter$p.updateReply(reply);
        this.this$0.getViewModel().setCommentId((String) null);
    }
}
