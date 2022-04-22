package com.memes.plus.p040ui.post_comments;

import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.p040ui.post_comments.reply.Reply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Lcom/memes/plus/ui/post_comments/reply/Reply;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$registerViewModel$6 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$registerViewModel$6<T> implements Observer<Reply> {
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$registerViewModel$6(PostCommentsActivity postCommentsActivity) {
        this.this$0 = postCommentsActivity;
    }

    public final void onChanged(Reply reply) {
        PostCommentsActivity.access$getPageScrollListener$p(this.this$0).disable();
        PostCommentsActivity.access$getPageScrollListener$p(this.this$0).disable();
        PostCommentsAdapter access$getCommentsAdapter$p = PostCommentsActivity.access$getCommentsAdapter$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(reply, "it");
        access$getCommentsAdapter$p.addSingleReply(reply);
        RelativeLayout relativeLayout = this.this$0.getBinding().replyingRelativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.replyingRelativeLayout");
        relativeLayout.setVisibility(8);
        EditText editText = this.this$0.getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        ExtensionsKt.clearText(editText);
        this.this$0.getBinding().commentsRecyclerView.post(new Runnable(this) {
            final /* synthetic */ PostCommentsActivity$registerViewModel$6 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                PostCommentsActivity.access$getPageScrollListener$p(this.this$0.this$0).enable();
            }
        });
        RelativeLayout relativeLayout2 = this.this$0.getBinding().gifWrapperRelativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.gifWrapperRelativeLayout");
        if (relativeLayout2.getVisibility() == 0) {
            this.this$0.setGifWrapperVisibility(false);
        }
        if (this.this$0.getViewModel().getCommentImagePath() != null) {
            this.this$0.getViewModel().setCommentImagePath((String) null);
        }
        if (this.this$0.getViewModel().getPostComment() == null) {
            this.this$0.getViewModel().setPostComment((PostComment) null);
        }
    }
}
