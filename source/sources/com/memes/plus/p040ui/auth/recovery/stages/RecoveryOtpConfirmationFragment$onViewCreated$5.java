package com.memes.plus.p040ui.auth.recovery.stages;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "text", "", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryOtpConfirmationFragment$onViewCreated$5 */
/* compiled from: RecoveryOtpConfirmationFragment.kt */
final class RecoveryOtpConfirmationFragment$onViewCreated$5<T> implements Observer<String> {
    final /* synthetic */ RecoveryOtpConfirmationFragment this$0;

    RecoveryOtpConfirmationFragment$onViewCreated$5(RecoveryOtpConfirmationFragment recoveryOtpConfirmationFragment) {
        this.this$0 = recoveryOtpConfirmationFragment;
    }

    public final void onChanged(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            RecoveryOtpConfirmationFragment.access$getBinding$p(this.this$0).resendOtpTextView.setText(C4199R.string.resend);
            TextView textView = RecoveryOtpConfirmationFragment.access$getBinding$p(this.this$0).resendOtpTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.resendOtpTextView");
            textView.setSelected(true);
            return;
        }
        TextView textView2 = RecoveryOtpConfirmationFragment.access$getBinding$p(this.this$0).resendOtpTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.resendOtpTextView");
        textView2.setText(this.this$0.getString(C4199R.string.format_resend_timer, str));
        TextView textView3 = RecoveryOtpConfirmationFragment.access$getBinding$p(this.this$0).resendOtpTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.resendOtpTextView");
        textView3.setSelected(false);
    }
}
