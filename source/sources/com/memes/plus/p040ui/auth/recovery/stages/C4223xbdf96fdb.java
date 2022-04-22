package com.memes.plus.p040ui.auth.recovery.stages;

import android.text.Editable;
import android.text.TextWatcher;
import com.memes.plus.p040ui.auth.recovery.AccountRecoveryViewModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, mo26107d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryOtpConfirmationFragment$onViewCreated$$inlined$addTextChangedListener$1 */
/* compiled from: TextView.kt */
public final class C4223xbdf96fdb implements TextWatcher {
    final /* synthetic */ RecoveryOtpConfirmationFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C4223xbdf96fdb(RecoveryOtpConfirmationFragment recoveryOtpConfirmationFragment) {
        this.this$0 = recoveryOtpConfirmationFragment;
    }

    public void afterTextChanged(Editable editable) {
        String str;
        String obj;
        AccountRecoveryViewModel access$getRecoveryViewModel$p = this.this$0.getRecoveryViewModel();
        if (editable == null || (obj = editable.toString()) == null) {
            str = null;
        } else {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            str = StringsKt.trim((CharSequence) obj).toString();
        }
        access$getRecoveryViewModel$p.otpInputChanged(str);
    }
}
