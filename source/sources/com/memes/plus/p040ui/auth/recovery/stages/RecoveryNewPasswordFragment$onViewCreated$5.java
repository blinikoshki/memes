package com.memes.plus.p040ui.auth.recovery.stages;

import androidx.lifecycle.Observer;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryNewPasswordFragment$onViewCreated$5 */
/* compiled from: RecoveryNewPasswordFragment.kt */
final class RecoveryNewPasswordFragment$onViewCreated$5<T> implements Observer<Boolean> {
    final /* synthetic */ RecoveryNewPasswordFragment this$0;

    RecoveryNewPasswordFragment$onViewCreated$5(RecoveryNewPasswordFragment recoveryNewPasswordFragment) {
        this.this$0 = recoveryNewPasswordFragment;
    }

    public final void onChanged(Boolean bool) {
        TextInputEditText textInputEditText = RecoveryNewPasswordFragment.access$getBinding$p(this.this$0).newPasswordEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.newPasswordEditText");
        CharSequence charSequence = null;
        textInputEditText.setText(charSequence);
        TextInputEditText textInputEditText2 = RecoveryNewPasswordFragment.access$getBinding$p(this.this$0).confirmPasswordEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.confirmPasswordEditText");
        textInputEditText2.setText(charSequence);
    }
}
