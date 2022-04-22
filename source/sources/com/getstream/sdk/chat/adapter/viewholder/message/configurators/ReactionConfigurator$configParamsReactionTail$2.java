package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ReactionConfigurator.kt */
final class ReactionConfigurator$configParamsReactionTail$2 implements Runnable {
    final /* synthetic */ ConstraintLayout.LayoutParams $params;
    final /* synthetic */ ReactionConfigurator this$0;

    ReactionConfigurator$configParamsReactionTail$2(ReactionConfigurator reactionConfigurator, ConstraintLayout.LayoutParams layoutParams) {
        this.this$0 = reactionConfigurator;
        this.$params = layoutParams;
    }

    public final void run() {
        ConstraintLayout.LayoutParams layoutParams = this.$params;
        RecyclerView recyclerView = this.this$0.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.reactionsRecyclerView");
        layoutParams.height = recyclerView.getHeight();
        ConstraintLayout.LayoutParams layoutParams2 = this.$params;
        RecyclerView recyclerView2 = this.this$0.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.reactionsRecyclerView");
        layoutParams2.width = recyclerView2.getHeight();
        ConstraintLayout.LayoutParams layoutParams3 = this.$params;
        RecyclerView recyclerView3 = this.this$0.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.reactionsRecyclerView");
        layoutParams3.topMargin = recyclerView3.getHeight() / 3;
        ImageView imageView = this.this$0.binding.ivTail;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTail");
        imageView.setLayoutParams(this.$params);
    }
}
