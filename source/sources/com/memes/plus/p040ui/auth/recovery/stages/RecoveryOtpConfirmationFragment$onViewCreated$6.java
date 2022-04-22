package com.memes.plus.p040ui.auth.recovery.stages;

import androidx.lifecycle.Observer;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryOtpConfirmationFragment$onViewCreated$6 */
/* compiled from: RecoveryOtpConfirmationFragment.kt */
final class RecoveryOtpConfirmationFragment$onViewCreated$6<T> implements Observer<Boolean> {
    final /* synthetic */ RecoveryOtpConfirmationFragment this$0;

    RecoveryOtpConfirmationFragment$onViewCreated$6(RecoveryOtpConfirmationFragment recoveryOtpConfirmationFragment) {
        this.this$0 = recoveryOtpConfirmationFragment;
    }

    public final void onChanged(Boolean bool) {
        TextInputEditText textInputEditText = RecoveryOtpConfirmationFragment.access$getBinding$p(this.this$0).otpEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.otpEditText");
        textInputEditText.setText((CharSequence) null);
    }
}
