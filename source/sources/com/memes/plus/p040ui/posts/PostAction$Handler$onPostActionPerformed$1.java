package com.memes.plus.p040ui.posts;

import com.memes.commons.choices.Choice;
import com.memes.commons.choices.ChoicesBottomSheet;
import com.memes.plus.p040ui.posts.PostAction;
import com.memes.plus.p040ui.posts.post_basics.post_options.PostOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "selectedChoice", "Lcom/memes/commons/choices/Choice;", "onChoiceSelected"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.posts.PostAction$Handler$onPostActionPerformed$1 */
/* compiled from: PostAction.kt */
final class PostAction$Handler$onPostActionPerformed$1 implements ChoicesBottomSheet.Callback {
    final /* synthetic */ Post $post;
    final /* synthetic */ PostAction.Handler this$0;

    PostAction$Handler$onPostActionPerformed$1(PostAction.Handler handler, Post post) {
        this.this$0 = handler;
        this.$post = post;
    }

    public final void onChoiceSelected(Choice choice) {
        Intrinsics.checkNotNullParameter(choice, "selectedChoice");
        this.this$0.getPostOptionsSelectionHandler().handlePostOptionSelected(PostOption.valueOf(choice.getId()), this.$post);
    }
}
