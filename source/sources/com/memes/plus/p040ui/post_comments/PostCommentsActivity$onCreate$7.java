package com.memes.plus.p040ui.post_comments;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$onCreate$7 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$onCreate$7 implements View.OnClickListener {
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$onCreate$7(PostCommentsActivity postCommentsActivity) {
        this.this$0 = postCommentsActivity;
    }

    public final void onClick(View view) {
        RelativeLayout relativeLayout = this.this$0.getBinding().replyingRelativeLayout;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.replyingRelativeLayout");
        relativeLayout.setVisibility(8);
        EditText editText = this.this$0.getBinding().addCommentEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.addCommentEditText");
        ExtensionsKt.clearText(editText);
        this.this$0.hidePostButton();
    }
}
