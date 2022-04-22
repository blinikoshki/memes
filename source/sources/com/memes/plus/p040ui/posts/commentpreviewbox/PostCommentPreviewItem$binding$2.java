package com.memes.plus.p040ui.posts.commentpreviewbox;

import android.content.Context;
import android.view.LayoutInflater;
import com.memes.plus.databinding.PostCommentPreviewItemBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/databinding/PostCommentPreviewItemBinding;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.commentpreviewbox.PostCommentPreviewItem$binding$2 */
/* compiled from: PostCommentPreviewItem.kt */
final class PostCommentPreviewItem$binding$2 extends Lambda implements Function0<PostCommentPreviewItemBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PostCommentPreviewItem this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostCommentPreviewItem$binding$2(PostCommentPreviewItem postCommentPreviewItem, Context context) {
        super(0);
        this.this$0 = postCommentPreviewItem;
        this.$context = context;
    }

    public final PostCommentPreviewItemBinding invoke() {
        return PostCommentPreviewItemBinding.inflate(LayoutInflater.from(this.$context), this.this$0, true);
    }
}
