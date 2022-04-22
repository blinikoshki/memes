package com.memes.plus.p040ui.posts.commentpreviewbox;

import android.view.View;
import com.memes.plus.p040ui.posts.PostAction;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.commentpreviewbox.PostCommentPreviewItem$onFinishInflate$2 */
/* compiled from: PostCommentPreviewItem.kt */
final class PostCommentPreviewItem$onFinishInflate$2 implements View.OnClickListener {
    final /* synthetic */ PostCommentPreviewItem this$0;

    PostCommentPreviewItem$onFinishInflate$2(PostCommentPreviewItem postCommentPreviewItem) {
        this.this$0 = postCommentPreviewItem;
    }

    public final void onClick(View view) {
        PostCommentPreviewItem.access$getPostActionListener$p(this.this$0).onPostActionPerformed(new PostAction.ViewComments(PostCommentPreviewItem.access$getPost$p(this.this$0), PostCommentPreviewItem.access$getComment$p(this.this$0)));
    }
}
