package com.memes.plus.util;

import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MultiStateButton.kt */
final class MultiStateButton$init$1 implements View.OnTouchListener {
    final /* synthetic */ MultiStateButton this$0;

    MultiStateButton$init$1(MultiStateButton multiStateButton) {
        this.this$0 = multiStateButton;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) view;
        if (!imageView.isClickable()) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            imageView.getDrawable().setColorFilter(this.this$0.mPressedColor, PorterDuff.Mode.SRC_IN);
        } else if (motionEvent.getAction() == 1) {
            imageView.getDrawable().clearColorFilter();
        }
        return false;
    }
}
