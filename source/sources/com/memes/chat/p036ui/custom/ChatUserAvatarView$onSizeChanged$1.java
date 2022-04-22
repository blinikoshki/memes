package com.memes.chat.p036ui.custom;

import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.custom.ChatUserAvatarView$onSizeChanged$1 */
/* compiled from: ChatUserAvatarView.kt */
final class ChatUserAvatarView$onSizeChanged$1 implements Runnable {

    /* renamed from: $w */
    final /* synthetic */ int f938$w;
    final /* synthetic */ ChatUserAvatarView this$0;

    ChatUserAvatarView$onSizeChanged$1(ChatUserAvatarView chatUserAvatarView, int i) {
        this.this$0 = chatUserAvatarView;
        this.f938$w = i;
    }

    public final void run() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) this.this$0);
        ImageView imageView = this.this$0.getBinding().presenceIndicatorView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.presenceIndicatorView");
        int id = imageView.getId();
        AppCompatImageView appCompatImageView = this.this$0.getBinding().avatarImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.avatarImageView");
        constraintSet.constrainCircle(id, appCompatImageView.getId(), this.f938$w / 2, 45.0f);
        constraintSet.applyTo(this.this$0);
        ImageView imageView2 = this.this$0.getBinding().presenceIndicatorView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.presenceIndicatorView");
        imageView2.setScaleX(0.35f);
        ImageView imageView3 = this.this$0.getBinding().presenceIndicatorView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.presenceIndicatorView");
        imageView3.setScaleY(0.35f);
    }
}
