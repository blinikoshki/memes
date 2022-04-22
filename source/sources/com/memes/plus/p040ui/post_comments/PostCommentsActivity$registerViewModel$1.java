package com.memes.plus.p040ui.post_comments;

import androidx.lifecycle.Observer;
import com.memes.commons.recycleradapter.AdapterUpdate;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "adapterUpdate", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/post_comments/BaseCommentModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$registerViewModel$1 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$registerViewModel$1<T> implements Observer<AdapterUpdate<BaseCommentModel>> {
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$registerViewModel$1(PostCommentsActivity postCommentsActivity) {
        this.this$0 = postCommentsActivity;
    }

    public final void onChanged(AdapterUpdate<BaseCommentModel> adapterUpdate) {
        PostCommentAction postCommentAction;
        PostCommentsActivity.access$getCommentsAdapter$p(this.this$0).applyAdapterUpdateAt(1, adapterUpdate);
        if (adapterUpdate.getPage() == 0 && (postCommentAction = (PostCommentAction) this.this$0.getIntent().getParcelableExtra("intent_extra_comment_action")) != null) {
            this.this$0.applyPostCommentAction(postCommentAction);
        }
    }
}
