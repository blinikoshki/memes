package com.memes.plus.p040ui.auth.recovery.stages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.databinding.AuthRecoveryRequestCodeFragmentBinding;
import com.memes.plus.p040ui.auth.recovery.AccountRecoveryViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/recovery/stages/RecoveryRequestCodeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/memes/plus/databinding/AuthRecoveryRequestCodeFragmentBinding;", "recoveryViewModel", "Lcom/memes/plus/ui/auth/recovery/AccountRecoveryViewModel;", "getRecoveryViewModel", "()Lcom/memes/plus/ui/auth/recovery/AccountRecoveryViewModel;", "recoveryViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryRequestCodeFragment */
/* compiled from: RecoveryRequestCodeFragment.kt */
public final class RecoveryRequestCodeFragment extends Fragment {
    /* access modifiers changed from: private */
    public AuthRecoveryRequestCodeFragmentBinding binding;
    private final Lazy recoveryViewModel$delegate = LazyKt.lazy(new RecoveryRequestCodeFragment$recoveryViewModel$2(this));

    /* access modifiers changed from: private */
    public final AccountRecoveryViewModel getRecoveryViewModel() {
        return (AccountRecoveryViewModel) this.recoveryViewModel$delegate.getValue();
    }

    public static final /* synthetic */ AuthRecoveryRequestCodeFragmentBinding access$getBinding$p(RecoveryRequestCodeFragment recoveryRequestCodeFragment) {
        AuthRecoveryRequestCodeFragmentBinding authRecoveryRequestCodeFragmentBinding = recoveryRequestCodeFragment.binding;
        if (authRecoveryRequestCodeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return authRecoveryRequestCodeFragmentBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        AuthRecoveryRequestCodeFragmentBinding inflate = AuthRecoveryRequestCodeFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "AuthRecoveryRequestCodeF…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        AuthRecoveryRequestCodeFragmentBinding authRecoveryRequestCodeFragmentBinding = this.binding;
        if (authRecoveryRequestCodeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authRecoveryRequestCodeFragmentBinding.backImageView.setOnClickListener(new RecoveryRequestCodeFragment$onViewCreated$1(this));
        AuthRecoveryRequestCodeFragmentBinding authRecoveryRequestCodeFragmentBinding2 = this.binding;
        if (authRecoveryRequestCodeFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText = authRecoveryRequestCodeFragmentBinding2.identityEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.identityEditText");
        textInputEditText.addTextChangedListener(new C4225x32ed7777(this));
        AuthRecoveryRequestCodeFragmentBinding authRecoveryRequestCodeFragmentBinding3 = this.binding;
        if (authRecoveryRequestCodeFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        authRecoveryRequestCodeFragmentBinding3.submitButton.setOnClickListener(new RecoveryRequestCodeFragment$onViewCreated$3(this));
        getRecoveryViewModel().onClearIdentityInput().observe(getViewLifecycleOwner(), new RecoveryRequestCodeFragment$onViewCreated$4(this));
        SoftKeyboardUtil softKeyboardUtil = SoftKeyboardUtil.INSTANCE;
        AuthRecoveryRequestCodeFragmentBinding authRecoveryRequestCodeFragmentBinding4 = this.binding;
        if (authRecoveryRequestCodeFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputEditText textInputEditText2 = authRecoveryRequestCodeFragmentBinding4.identityEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.identityEditText");
        softKeyboardUtil.showKeyboard(textInputEditText2);
    }
}
