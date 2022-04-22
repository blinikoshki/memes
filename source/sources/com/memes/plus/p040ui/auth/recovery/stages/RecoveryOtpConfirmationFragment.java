package com.memes.plus.p040ui.auth.recovery.stages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.databinding.AuthRecoveryOtpConfirmationFragmentBinding;
import com.memes.plus.p040ui.auth.recovery.AccountRecoveryViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/recovery/stages/RecoveryOtpConfirmationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/plus/databinding/AuthRecoveryOtpConfirmationFragmentBinding;", "recoveryViewModel", "Lcom/memes/plus/ui/auth/recovery/AccountRecoveryViewModel;", "getRecoveryViewModel", "()Lcom/memes/plus/ui/auth/recovery/AccountRecoveryViewModel;", "recoveryViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryOtpConfirmationFragment */
/* compiled from: RecoveryOtpConfirmationFragment.kt */
public final class RecoveryOtpConfirmationFragment extends Fragment {
    /* access modifiers changed from: private */
    public AuthRecoveryOtpConfirmationFragmentBinding binding;
    private final Lazy recoveryViewModel$delegate = LazyKt.lazy(new RecoveryOtpConfirmationFragment$recoveryViewModel$2(this));

    /* access modifiers changed from: private */
    public final AccountRecoveryViewModel getRecoveryViewModel() {
        return (AccountRecoveryViewModel) this.recoveryViewModel$delegate.getValue();
    }

    public static final /* synthetic */ AuthRecoveryOtpConfirmationFragmentBinding access$getBinding$p(RecoveryOtpConfirmationFragment recoveryOtpConfirmationFragment) {
        AuthRecoveryOtpConfirmationFragmentBinding authRecoveryOtpConfirmationFragmentBinding = recoveryOtpConfirmationFragment.binding;
        if (authRecoveryOtpConfirmationFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return authRecoveryOtpConfirmationFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        AuthRecoveryOtpConfirmationFragmentBinding inflate = AuthRecoveryOtpConfirmationFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "AuthRecoveryOtpConfirmat…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        AuthRecoveryOtpConfirmationFragmentBinding authRecoveryOtpConfirmationFragmentBinding = this.binding;
        if (authRecoveryOtpConfirmationFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authRecoveryOtpConfirmationFragmentBinding.backImageView.setOnClickListener(new RecoveryOtpConfirmationFragment$onViewCreated$1(this));
        AuthRecoveryOtpConfirmationFragmentBinding authRecoveryOtpConfirmationFragmentBinding2 = this.binding;
        if (authRecoveryOtpConfirmationFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = authRecoveryOtpConfirmationFragmentBinding2.otpEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.otpEditText");
        textInputEditText.addTextChangedListener(new C4223xbdf96fdb(this));
        AuthRecoveryOtpConfirmationFragmentBinding authRecoveryOtpConfirmationFragmentBinding3 = this.binding;
        if (authRecoveryOtpConfirmationFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authRecoveryOtpConfirmationFragmentBinding3.resendOtpTextView.setOnClickListener(new RecoveryOtpConfirmationFragment$onViewCreated$3(this));
        AuthRecoveryOtpConfirmationFragmentBinding authRecoveryOtpConfirmationFragmentBinding4 = this.binding;
        if (authRecoveryOtpConfirmationFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authRecoveryOtpConfirmationFragmentBinding4.submitButton.setOnClickListener(new RecoveryOtpConfirmationFragment$onViewCreated$4(this));
        getRecoveryViewModel().onResendOtpTimerTextChanged().observe(getViewLifecycleOwner(), new RecoveryOtpConfirmationFragment$onViewCreated$5(this));
        getRecoveryViewModel().onClearOtpInput().observe(getViewLifecycleOwner(), new RecoveryOtpConfirmationFragment$onViewCreated$6(this));
    }

    public void onResume() {
        super.onResume();
        AuthRecoveryOtpConfirmationFragmentBinding authRecoveryOtpConfirmationFragmentBinding = this.binding;
        if (authRecoveryOtpConfirmationFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = authRecoveryOtpConfirmationFragmentBinding.otpEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.otpEditText");
        CharSequence text = textInputEditText.getText();
        if (text == null || StringsKt.isBlank(text)) {
            SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
            AuthRecoveryOtpConfirmationFragmentBinding authRecoveryOtpConfirmationFragmentBinding2 = this.binding;
            if (authRecoveryOtpConfirmationFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputEditText textInputEditText2 = authRecoveryOtpConfirmationFragmentBinding2.otpEditText;
            Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.otpEditText");
            softKeyboardUtil.showKeyboard(textInputEditText2);
        }
    }
}
