package com.memes.plus.custom;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: UserAvatarView.kt */
final class UserAvatarView$onSizeChanged$1 implements Runnable {

    /* renamed from: $w */
    final /* synthetic */ int f1022$w;
    final /* synthetic */ UserAvatarView this$0;

    UserAvatarView$onSizeChanged$1(UserAvatarView userAvatarView, int i) {
        this.this$0 = userAvatarView;
        this.f1022$w = i;
    }

    public final void run() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) this.this$0);
        ImageView imageView = this.this$0.getBinding().proUserIndicatorView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.proUserIndicatorView");
        int id = imageView.getId();
        AppCompatImageView appCompatImageView = this.this$0.getBinding().avatarImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.avatarImageView");
        constraintSet.constrainCircle(id, appCompatImageView.getId(), this.f1022$w / 2, 45.0f);
        constraintSet.applyTo(this.this$0);
        AppCompatImageView appCompatImageView2 = this.this$0.getBinding().avatarImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "binding.avatarImageView");
        float width = ((float) appCompatImageView2.getWidth()) * 0.7f;
        ImageView imageView2 = this.this$0.getBinding().proUserIndicatorView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.proUserIndicatorView");
        View view = imageView2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        layoutParams3.width = MathKt.roundToInt(width);
        layoutParams3.height = MathKt.roundToInt(width);
        view.setLayoutParams(layoutParams2);
    }
}
