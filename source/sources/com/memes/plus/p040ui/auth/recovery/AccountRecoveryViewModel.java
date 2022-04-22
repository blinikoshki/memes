package com.memes.plus.p040ui.auth.recovery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.plus.C4199R;
import com.memes.plus.p040ui.auth.recovery.stages.AccountRecoveryStage;
import com.memes.plus.util.Constants;
import com.memes.plus.util.validation.Validations;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001f\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070!J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070!J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0!J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0!J\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0!J\u0010\u0010'\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0002J\u0006\u0010+\u001a\u00020\u0019J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0006\u0010,\u001a\u00020\u0019J\u0006\u0010-\u001a\u00020\u0019J \u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u0019H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/recovery/AccountRecoveryViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "memesDataSource", "Lcom/memes/network/memes/api/MemesDataSource;", "(Lcom/memes/network/memes/api/MemesDataSource;)V", "_clearIdentityInput", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_clearOtpInput", "_clearPasswordInput", "_recoveryCompleted", "", "_recoveryStageChanged", "Lcom/memes/plus/ui/auth/recovery/stages/AccountRecoveryStage;", "_resendOtpTimerText", "confirmedPasswordInput", "identityInput", "newPasswordInput", "otpInput", "otpUserId", "recoveryExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "resendTimerTextJob", "Lkotlinx/coroutines/Job;", "changeStage", "", "stage", "confirmOtp", "confirmedPasswordInputChanged", "goToStage", "identityInputChanged", "newPasswordInputChanged", "onClearIdentityInput", "Landroidx/lifecycle/LiveData;", "onClearOtpInput", "onClearPasswordInput", "onRecoveryCompleted", "onRecoveryStageChanged", "onResendOtpTimerTextChanged", "otpInputChanged", "readableSecondsFormat", "seconds", "", "requestOtp", "resendOtp", "resetPassword", "userId", "otp", "newPassword", "startResendOtpTimer", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.AccountRecoveryViewModel */
/* compiled from: AccountRecoveryViewModel.kt */
public final class AccountRecoveryViewModel extends BaseViewModel {
    private final SingleLiveEvent<Boolean> _clearIdentityInput = new SingleLiveEvent<>();
    private final SingleLiveEvent<Boolean> _clearOtpInput = new SingleLiveEvent<>();
    private final SingleLiveEvent<Boolean> _clearPasswordInput = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<String> _recoveryCompleted = new SingleLiveEvent<>();
    private final SingleLiveEvent<AccountRecoveryStage> _recoveryStageChanged = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<String> _resendOtpTimerText = new SingleLiveEvent<>();
    private String confirmedPasswordInput;
    private String identityInput;
    /* access modifiers changed from: private */
    public final MemesDataSource memesDataSource;
    private String newPasswordInput;
    private String otpInput;
    /* access modifiers changed from: private */
    public String otpUserId;
    private final CoroutineExceptionHandler recoveryExceptionHandler = new C4219x586c4ab0(CoroutineExceptionHandler.Key, this);
    private Job resendTimerTextJob;

    public AccountRecoveryViewModel(MemesDataSource memesDataSource2) {
        Intrinsics.checkNotNullParameter(memesDataSource2, "memesDataSource");
        this.memesDataSource = memesDataSource2;
    }

    public final LiveData<AccountRecoveryStage> onRecoveryStageChanged() {
        return this._recoveryStageChanged;
    }

    public final LiveData<String> onResendOtpTimerTextChanged() {
        return this._resendOtpTimerText;
    }

    public final LiveData<String> onRecoveryCompleted() {
        return this._recoveryCompleted;
    }

    public final LiveData<Boolean> onClearIdentityInput() {
        return this._clearIdentityInput;
    }

    public final LiveData<Boolean> onClearOtpInput() {
        return this._clearOtpInput;
    }

    public final LiveData<Boolean> onClearPasswordInput() {
        return this._clearPasswordInput;
    }

    public final void identityInputChanged(String str) {
        this.identityInput = str;
    }

    public final void otpInputChanged(String str) {
        this.otpInput = str;
    }

    public final void newPasswordInputChanged(String str) {
        this.newPasswordInput = str;
    }

    public final void confirmedPasswordInputChanged(String str) {
        this.confirmedPasswordInput = str;
    }

    public final void changeStage(AccountRecoveryStage accountRecoveryStage) {
        Intrinsics.checkNotNullParameter(accountRecoveryStage, "stage");
        goToStage(accountRecoveryStage);
    }

    public final void requestOtp() {
        int forEmail;
        String str = this.identityInput;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            toast((int) C4199R.string.error_email_or_username_empty);
        } else if (!StringsKt.contains$default(charSequence, (CharSequence) "@", false, 2, (Object) null) || (forEmail = Validations.INSTANCE.forEmail(str)) == 5) {
            requestOtp(str);
        } else if (forEmail == 1) {
            toast((int) C4199R.string.error_email_empty);
        } else if (forEmail != 2) {
            toast(Constants.UNUSUAL_ERROR);
        } else {
            toast((int) C4199R.string.error_email_invalid);
        }
    }

    public final void resendOtp() {
        String str = this.identityInput;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            toast((int) C4199R.string.error_email_or_username_empty);
            goToStage(AccountRecoveryStage.REQUEST_OTP);
            return;
        }
        requestOtp(str);
    }

    private final Job requestOtp(String str) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.recoveryExceptionHandler, (CoroutineStart) null, new AccountRecoveryViewModel$requestOtp$1(this, str, (Continuation) null), 2, (Object) null);
    }

    public final void confirmOtp() {
        CharSequence charSequence = this.identityInput;
        boolean z = false;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            toast((int) C4199R.string.error_email_or_username_empty);
            goToStage(AccountRecoveryStage.REQUEST_OTP);
            return;
        }
        CharSequence charSequence2 = this.otpUserId;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            toast((int) C4199R.string.error_invalid_recovery_stage);
            goToStage(AccountRecoveryStage.REQUEST_OTP);
            return;
        }
        CharSequence charSequence3 = this.otpInput;
        if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
            z = true;
        }
        if (z) {
            toast((int) C4199R.string.error_empty_otp);
        } else {
            goToStage(AccountRecoveryStage.INPUT_NEW_PASSWORD);
        }
    }

    public final void resetPassword() {
        CharSequence charSequence = this.identityInput;
        boolean z = false;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            toast((int) C4199R.string.error_invalid_recovery_stage);
            goToStage(AccountRecoveryStage.REQUEST_OTP);
            return;
        }
        String str = this.otpUserId;
        CharSequence charSequence2 = str;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            toast((int) C4199R.string.error_invalid_recovery_stage);
            goToStage(AccountRecoveryStage.REQUEST_OTP);
            return;
        }
        String str2 = this.otpInput;
        CharSequence charSequence3 = str2;
        if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
            toast((int) C4199R.string.error_invalid_recovery_stage);
            goToStage(AccountRecoveryStage.REQUEST_OTP);
            return;
        }
        String str3 = this.newPasswordInput;
        CharSequence charSequence4 = str3;
        if (charSequence4 == null || StringsKt.isBlank(charSequence4)) {
            toast((int) C4199R.string.error_empty_new_password);
            return;
        }
        String str4 = this.confirmedPasswordInput;
        CharSequence charSequence5 = str4;
        if (charSequence5 == null || StringsKt.isBlank(charSequence5)) {
            z = true;
        }
        if (z) {
            toast((int) C4199R.string.error_empty_confirmed_password);
        } else if (!Intrinsics.areEqual((Object) str3, (Object) str4)) {
            toast((int) C4199R.string.error_new_password_mismatch);
        } else {
            resetPassword(str, str2, str3);
        }
    }

    private final Job resetPassword(String str, String str2, String str3) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.recoveryExceptionHandler, (CoroutineStart) null, new AccountRecoveryViewModel$resetPassword$1(this, str, str2, str3, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void goToStage(AccountRecoveryStage accountRecoveryStage) {
        if (accountRecoveryStage == AccountRecoveryStage.REQUEST_OTP) {
            this._clearOtpInput.setValue(true);
            this._clearPasswordInput.setValue(true);
        }
        if (accountRecoveryStage == AccountRecoveryStage.CONFIRM_OTP) {
            this._clearOtpInput.setValue(true);
            this._clearPasswordInput.setValue(true);
        }
        if (accountRecoveryStage == AccountRecoveryStage.INPUT_NEW_PASSWORD) {
            this._clearPasswordInput.setValue(true);
        }
        this._recoveryStageChanged.setValue(accountRecoveryStage);
    }

    /* access modifiers changed from: private */
    public final void startResendOtpTimer() {
        Job job = this.resendTimerTextJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.resendTimerTextJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AccountRecoveryViewModel$startResendOtpTimer$1(this, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final String readableSecondsFormat(int i) {
        int i2 = i % 60;
        int floor = (int) Math.floor(((double) i) / 60.0d);
        StringBuilder sb = new StringBuilder();
        String str = "0";
        sb.append(floor < 10 ? str : "");
        sb.append(floor);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        if (i2 >= 10) {
            str = "";
        }
        sb3.append(str);
        sb3.append(i2);
        String sb4 = sb3.toString();
        return sb2 + ':' + sb4;
    }
}
