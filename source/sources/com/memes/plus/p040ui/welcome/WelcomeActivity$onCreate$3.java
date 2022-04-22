package com.memes.plus.p040ui.welcome;

import android.widget.ImageView;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "alpha", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Float;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.welcome.WelcomeActivity$onCreate$3 */
/* compiled from: WelcomeActivity.kt */
final class WelcomeActivity$onCreate$3<T> implements Observer<Float> {
    final /* synthetic */ WelcomeActivity this$0;

    WelcomeActivity$onCreate$3(WelcomeActivity welcomeActivity) {
        this.this$0 = welcomeActivity;
    }

    public final void onChanged(Float f) {
        ImageView imageView = this.this$0.getBinding().backgroundImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backgroundImageView");
        Intrinsics.checkNotNullExpressionValue(f, "alpha");
        imageView.setAlpha(f.floatValue());
    }
}
