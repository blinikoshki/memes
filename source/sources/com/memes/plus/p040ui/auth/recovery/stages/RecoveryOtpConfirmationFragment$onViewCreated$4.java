package com.memes.plus.p040ui.auth.recovery.stages;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.commons.util.SoftKeyboardUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryOtpConfirmationFragment$onViewCreated$4 */
/* compiled from: RecoveryOtpConfirmationFragment.kt */
final class RecoveryOtpConfirmationFragment$onViewCreated$4 implements View.OnClickListener {
    final /* synthetic */ RecoveryOtpConfirmationFragment this$0;

    RecoveryOtpConfirmationFragment$onViewCreated$4(RecoveryOtpConfirmationFragment recoveryOtpConfirmationFragment) {
        this.this$0 = recoveryOtpConfirmationFragment;
    }

    public final void onClick(View view) {
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        TextInputEditText textInputEditText = RecoveryOtpConfirmationFragment.access$getBinding$p(this.this$0).otpEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.otpEditText");
        softKeyboardUtil.hideKeyboard((EditText) textInputEditText);
        this.this$0.getRecoveryViewModel().confirmOtp();
    }
}
