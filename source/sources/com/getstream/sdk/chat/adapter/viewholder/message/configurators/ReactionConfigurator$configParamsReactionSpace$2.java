package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ReactionConfigurator.kt */
final class ReactionConfigurator$configParamsReactionSpace$2 implements Runnable {
    final /* synthetic */ ConstraintLayout.LayoutParams $params;
    final /* synthetic */ ReactionConfigurator this$0;

    ReactionConfigurator$configParamsReactionSpace$2(ReactionConfigurator reactionConfigurator, ConstraintLayout.LayoutParams layoutParams) {
        this.this$0 = reactionConfigurator;
        this.$params = layoutParams;
    }

    public final void run() {
        ConstraintLayout.LayoutParams layoutParams = this.$params;
        RecyclerView recyclerView = this.this$0.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.reactionsRecyclerView");
        layoutParams.width = recyclerView.getHeight() / 3;
        Space space = this.this$0.binding.spaceReactionTail;
        Intrinsics.checkNotNullExpressionValue(space, "binding.spaceReactionTail");
        space.setLayoutParams(this.$params);
    }
}
