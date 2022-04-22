package com.memes.plus.p040ui.auth.recovery.stages;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.commons.util.SoftKeyboardUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryRequestCodeFragment$onViewCreated$3 */
/* compiled from: RecoveryRequestCodeFragment.kt */
final class RecoveryRequestCodeFragment$onViewCreated$3 implements View.OnClickListener {
    final /* synthetic */ RecoveryRequestCodeFragment this$0;

    RecoveryRequestCodeFragment$onViewCreated$3(RecoveryRequestCodeFragment recoveryRequestCodeFragment) {
        this.this$0 = recoveryRequestCodeFragment;
    }

    public final void onClick(View view) {
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        TextInputEditText textInputEditText = RecoveryRequestCodeFragment.access$getBinding$p(this.this$0).identityEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.identityEditText");
        softKeyboardUtil.hideKeyboard((EditText) textInputEditText);
        this.this$0.getRecoveryViewModel().requestOtp();
    }
}
