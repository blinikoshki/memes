package com.memes.plus.p040ui.posts.commentpreviewbox;

import android.view.View;
import com.memes.plus.p040ui.auth.auth_prompt.MagicalClickableSpan;
import com.memes.plus.p040ui.posts.PostAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/memes/plus/ui/posts/commentpreviewbox/PostCommentPreviewItem$createSpannableTextContent$1", "Lcom/memes/plus/ui/auth/auth_prompt/MagicalClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.commentpreviewbox.PostCommentPreviewItem$createSpannableTextContent$1 */
/* compiled from: PostCommentPreviewItem.kt */
public final class PostCommentPreviewItem$createSpannableTextContent$1 extends MagicalClickableSpan {
    final /* synthetic */ PostCommentPreviewItem this$0;

    PostCommentPreviewItem$createSpannableTextContent$1(PostCommentPreviewItem postCommentPreviewItem) {
        this.this$0 = postCommentPreviewItem;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        PostCommentPreviewItem.access$getPostActionListener$p(this.this$0).onPostActionPerformed(PostAction.ViewProfile.Companion.ofAuthor(PostCommentPreviewItem.access$getComment$p(this.this$0)));
    }
}
