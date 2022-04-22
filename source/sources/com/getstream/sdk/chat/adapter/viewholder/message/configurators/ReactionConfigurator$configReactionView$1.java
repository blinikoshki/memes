package com.getstream.sdk.chat.adapter.viewholder.message.configurators;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onTouch"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ReactionConfigurator.kt */
final class ReactionConfigurator$configReactionView$1 implements View.OnTouchListener {
    final /* synthetic */ Message $message;
    final /* synthetic */ ReactionConfigurator this$0;

    ReactionConfigurator$configReactionView$1(ReactionConfigurator reactionConfigurator, Message message) {
        this.this$0 = reactionConfigurator;
        this.$message = message;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.this$0.reactionViewClickListener.onReactionViewClick(this.$message);
        return false;
    }
}
