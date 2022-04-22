package com.memes.plus.p040ui.post_comments;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$onCreate$3 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$onCreate$3 implements View.OnClickListener {
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$onCreate$3(PostCommentsActivity postCommentsActivity) {
        this.this$0 = postCommentsActivity;
    }

    public final void onClick(View view) {
        this.this$0.hidePostButton();
        RecyclerView recyclerView = this.this$0.getBinding().userSearchRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.userSearchRecyclerView");
        boolean z = true;
        if (recyclerView.getVisibility() == 0) {
            RecyclerView recyclerView2 = this.this$0.getBinding().userSearchRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.userSearchRecyclerView");
            recyclerView2.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.this$0.getBinding().replyingRelativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.replyingRelativeLayout");
        if (relativeLayout.getVisibility() == 0) {
            ImageView imageView = this.this$0.getBinding().gifSelectionImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.gifSelectionImageView");
            if (imageView.getVisibility() != 0) {
                z = false;
            }
            if (z) {
                this.this$0.addReply();
            } else {
                this.this$0.updateReply();
            }
        } else {
            ImageView imageView2 = this.this$0.getBinding().gifSelectionImageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.gifSelectionImageView");
            if (imageView2.getVisibility() != 0) {
                z = false;
            }
            if (z) {
                this.this$0.addComment();
            } else {
                this.this$0.updateComment();
            }
        }
    }
}
