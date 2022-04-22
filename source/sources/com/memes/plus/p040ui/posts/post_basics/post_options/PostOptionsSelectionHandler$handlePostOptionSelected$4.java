package com.memes.plus.p040ui.posts.post_basics.post_options;

import android.content.DialogInterface;
import com.memes.plus.p040ui.posts.Post;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.post_basics.post_options.PostOptionsSelectionHandler$handlePostOptionSelected$4 */
/* compiled from: PostOptionsSelectionHandler.kt */
final class PostOptionsSelectionHandler$handlePostOptionSelected$4 implements DialogInterface.OnClickListener {
    final /* synthetic */ Post $post;
    final /* synthetic */ PostOptionsSelectionHandler this$0;

    PostOptionsSelectionHandler$handlePostOptionSelected$4(PostOptionsSelectionHandler postOptionsSelectionHandler, Post post) {
        this.this$0 = postOptionsSelectionHandler;
        this.$post = post;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.this$0.postOperationsViewModel.deletePost(this.$post);
    }
}
