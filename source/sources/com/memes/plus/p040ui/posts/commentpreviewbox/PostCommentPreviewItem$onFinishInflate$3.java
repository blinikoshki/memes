package com.memes.plus.p040ui.posts.commentpreviewbox;

import com.memes.commons.enhancedtext.socialtext.SocialTextView;
import com.memes.plus.p040ui.posts.PostAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "linkType", "", "matchedText", "", "kotlin.jvm.PlatformType", "onLinkClicked"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.commentpreviewbox.PostCommentPreviewItem$onFinishInflate$3 */
/* compiled from: PostCommentPreviewItem.kt */
final class PostCommentPreviewItem$onFinishInflate$3 implements SocialTextView.OnLinkClickListener {
    final /* synthetic */ PostCommentPreviewItem this$0;

    PostCommentPreviewItem$onFinishInflate$3(PostCommentPreviewItem postCommentPreviewItem) {
        this.this$0 = postCommentPreviewItem;
    }

    public final void onLinkClicked(int i, String str) {
        PostAction.Listener access$getPostActionListener$p = PostCommentPreviewItem.access$getPostActionListener$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(str, "matchedText");
        access$getPostActionListener$p.onPostActionPerformed(new PostAction.HighlightedTextTapped(i, str));
    }
}
