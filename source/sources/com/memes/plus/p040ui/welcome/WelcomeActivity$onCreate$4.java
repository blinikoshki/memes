package com.memes.plus.p040ui.welcome;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "color", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.welcome.WelcomeActivity$onCreate$4 */
/* compiled from: WelcomeActivity.kt */
final class WelcomeActivity$onCreate$4<T> implements Observer<Pair<? extends Long, ? extends Long>> {
    final /* synthetic */ WelcomeActivity this$0;

    WelcomeActivity$onCreate$4(WelcomeActivity welcomeActivity) {
        this.this$0 = welcomeActivity;
    }

    public final void onChanged(Pair<Long, Long> pair) {
        this.this$0.getBinding().mimicBlur1ImageView.setBackgroundColor((int) pair.getFirst().longValue());
        this.this$0.getBinding().mimicBlur2ImageView.setBackgroundColor((int) pair.getSecond().longValue());
    }
}
