package com.memes.plus.p040ui.post_comments;

import com.memes.plus.p040ui.post_comments.reply.Reply;
import com.memes.plus.util.DialogUtil;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/memes/plus/ui/post_comments/PostCommentsActivity$onReplyDeleteClicked$1", "Lcom/memes/plus/util/DialogUtil$Callback;", "", "onResult", "", "result", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$onReplyDeleteClicked$1 */
/* compiled from: PostCommentsActivity.kt */
public final class PostCommentsActivity$onReplyDeleteClicked$1 implements DialogUtil.Callback<Boolean> {
    final /* synthetic */ Reply $comment;
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$onReplyDeleteClicked$1(PostCommentsActivity postCommentsActivity, Reply reply) {
        this.this$0 = postCommentsActivity;
        this.$comment = reply;
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult(((Boolean) obj).booleanValue());
    }

    public void onResult(boolean z) {
        if (z) {
            this.this$0.getViewModel().deleteReplyToComment(this.$comment);
        }
    }
}
