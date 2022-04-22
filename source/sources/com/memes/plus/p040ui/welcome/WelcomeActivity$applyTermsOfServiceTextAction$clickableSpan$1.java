package com.memes.plus.p040ui.welcome;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo26107d2 = {"com/memes/plus/ui/welcome/WelcomeActivity$applyTermsOfServiceTextAction$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "paint", "Landroid/text/TextPaint;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.welcome.WelcomeActivity$applyTermsOfServiceTextAction$clickableSpan$1 */
/* compiled from: WelcomeActivity.kt */
public final class WelcomeActivity$applyTermsOfServiceTextAction$clickableSpan$1 extends ClickableSpan {
    final /* synthetic */ WelcomeActivity this$0;

    WelcomeActivity$applyTermsOfServiceTextAction$clickableSpan$1(WelcomeActivity welcomeActivity) {
        this.this$0 = welcomeActivity;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        this.this$0.showTermsOfServicePage();
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(true);
    }
}
