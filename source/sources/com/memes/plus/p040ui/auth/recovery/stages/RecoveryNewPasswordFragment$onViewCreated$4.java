package com.memes.plus.p040ui.auth.recovery.stages;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.commons.util.SoftKeyboardUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryNewPasswordFragment$onViewCreated$4 */
/* compiled from: RecoveryNewPasswordFragment.kt */
final class RecoveryNewPasswordFragment$onViewCreated$4 implements View.OnClickListener {
    final /* synthetic */ RecoveryNewPasswordFragment this$0;

    RecoveryNewPasswordFragment$onViewCreated$4(RecoveryNewPasswordFragment recoveryNewPasswordFragment) {
        this.this$0 = recoveryNewPasswordFragment;
    }

    public final void onClick(View view) {
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        TextInputEditText textInputEditText = RecoveryNewPasswordFragment.access$getBinding$p(this.this$0).newPasswordEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.newPasswordEditText");
        softKeyboardUtil.hideKeyboard((EditText) textInputEditText);
        SoftKeyboardUtil softKeyboardUtil2 = SoftKeyboardUtil.INSTANCE;
        TextInputEditText textInputEditText2 = RecoveryNewPasswordFragment.access$getBinding$p(this.this$0).confirmPasswordEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.confirmPasswordEditText");
        softKeyboardUtil2.hideKeyboard((EditText) textInputEditText2);
        this.this$0.getRecoveryViewModel().resetPassword();
    }
}
