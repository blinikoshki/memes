package com.memes.plus.p040ui.post_comments;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "canLoad", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.PostCommentsActivity$registerViewModel$2 */
/* compiled from: PostCommentsActivity.kt */
final class PostCommentsActivity$registerViewModel$2<T> implements Observer<Boolean> {
    final /* synthetic */ PostCommentsActivity this$0;

    PostCommentsActivity$registerViewModel$2(PostCommentsActivity postCommentsActivity) {
        this.this$0 = postCommentsActivity;
    }

    public final void onChanged(Boolean bool) {
        PostCommentsActivity.access$getCommentsAdapter$p(this.this$0).removeItemAt(0);
        PostCommentsActivity.access$getCommentsAdapter$p(this.this$0).notifyItemRemoved(0);
    }
}
