package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.utils.extensions.ConstraintLayoutKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ReactionConfigurator.kt */
final class ReactionConfigurator$configParamsReactionRecyclerView$1 implements Runnable {
    final /* synthetic */ MessageListItem.MessageItem $messageItem;
    final /* synthetic */ ReactionConfigurator this$0;

    ReactionConfigurator$configParamsReactionRecyclerView$1(ReactionConfigurator reactionConfigurator, MessageListItem.MessageItem messageItem) {
        this.this$0 = reactionConfigurator;
        this.$messageItem = messageItem;
    }

    public final void run() {
        RecyclerView recyclerView = this.this$0.binding.reactionsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.reactionsRecyclerView");
        if (recyclerView.getVisibility() != 8) {
            ConstraintLayout root = this.this$0.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ConstraintLayoutKt.updateConstraints(root, C17071.INSTANCE);
            RecyclerView recyclerView2 = this.this$0.binding.reactionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.reactionsRecyclerView");
            View view = recyclerView2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
            if (!(!this.$messageItem.getMessage().getAttachments().isEmpty())) {
                int dimensionPixelSize = this.this$0.context.getResources().getDimensionPixelSize(C1673R.dimen.stream_reaction_margin);
                TextView textView = this.this$0.binding.tvText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
                int width = textView.getWidth() + dimensionPixelSize;
                RecyclerView recyclerView3 = this.this$0.binding.reactionsRecyclerView;
                Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.reactionsRecyclerView");
                if (width < recyclerView3.getWidth()) {
                    if (this.$messageItem.isMine()) {
                        layoutParams3.endToEnd = C1673R.C1677id.tv_text;
                    } else {
                        layoutParams3.startToStart = C1673R.C1677id.tv_text;
                    }
                } else if (this.$messageItem.isMine()) {
                    layoutParams3.startToStart = C1673R.C1677id.space_reaction_tail;
                } else {
                    layoutParams3.endToEnd = C1673R.C1677id.space_reaction_tail;
                }
            } else if (this.$messageItem.isMine()) {
                layoutParams3.startToStart = C1673R.C1677id.space_reaction_tail;
            } else {
                layoutParams3.endToEnd = C1673R.C1677id.space_reaction_tail;
            }
            view.setLayoutParams(layoutParams2);
            RecyclerView recyclerView4 = this.this$0.binding.reactionsRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.reactionsRecyclerView");
            recyclerView4.setVisibility(0);
            ImageView imageView = this.this$0.binding.ivTail;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTail");
            imageView.setVisibility(0);
            this.this$0.configParamsReadIndicator.invoke(this.$messageItem);
        }
    }
}
