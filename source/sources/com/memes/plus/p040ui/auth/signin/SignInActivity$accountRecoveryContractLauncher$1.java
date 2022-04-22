package com.memes.plus.p040ui.auth.signin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.memes.commons.util.ActivityResultExtKt;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signin.SignInActivity$accountRecoveryContractLauncher$1 */
/* compiled from: SignInActivity.kt */
final class SignInActivity$accountRecoveryContractLauncher$1<O> implements ActivityResultCallback<ActivityResult> {
    final /* synthetic */ SignInActivity this$0;

    SignInActivity$accountRecoveryContractLauncher$1(SignInActivity signInActivity) {
        this.this$0 = signInActivity;
    }

    public final void onActivityResult(ActivityResult activityResult) {
        Intrinsics.checkNotNullExpressionValue(activityResult, "result");
        if (ActivityResultExtKt.isOk(activityResult)) {
            this.this$0.getBinding().highlightedToastView.show((int) C4199R.string.account_recovery_success_msg);
        }
    }
}
