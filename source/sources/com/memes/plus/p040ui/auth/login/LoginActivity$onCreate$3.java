package com.memes.plus.p040ui.auth.login;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "required", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.login.LoginActivity$onCreate$3 */
/* compiled from: LoginActivity.kt */
final class LoginActivity$onCreate$3<T> implements Observer<Boolean> {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onCreate$3(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void onChanged(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "required");
        if (bool.booleanValue()) {
            ConstraintLayout constraintLayout = this.this$0.getBinding().fbEmailPromptLayout;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.fbEmailPromptLayout");
            constraintLayout.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout2 = this.this$0.getBinding().fbEmailPromptLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.fbEmailPromptLayout");
        constraintLayout2.setVisibility(8);
    }
}
