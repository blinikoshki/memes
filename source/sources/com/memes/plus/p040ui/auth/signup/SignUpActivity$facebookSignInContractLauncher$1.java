package com.memes.plus.p040ui.auth.signup;

import androidx.activity.result.ActivityResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "complete", "", "kotlin.jvm.PlatformType", "onActivityResult", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signup.SignUpActivity$facebookSignInContractLauncher$1 */
/* compiled from: SignUpActivity.kt */
final class SignUpActivity$facebookSignInContractLauncher$1<O> implements ActivityResultCallback<Boolean> {
    final /* synthetic */ SignUpActivity this$0;

    SignUpActivity$facebookSignInContractLauncher$1(SignUpActivity signUpActivity) {
        this.this$0 = signUpActivity;
    }

    public final void onActivityResult(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "complete");
        if (bool.booleanValue()) {
            this.this$0.notifySignUpComplete();
        }
    }
}
