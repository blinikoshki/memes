package com.memes.plus.p040ui.auth.recovery.stages;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.memes.commons.viewmodel.BaseViewModelFactory;
import com.memes.plus.p040ui.auth.recovery.AccountRecoveryViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/auth/recovery/AccountRecoveryViewModel;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.stages.RecoveryOtpConfirmationFragment$recoveryViewModel$2 */
/* compiled from: RecoveryOtpConfirmationFragment.kt */
final class RecoveryOtpConfirmationFragment$recoveryViewModel$2 extends Lambda implements Function0<AccountRecoveryViewModel> {
    final /* synthetic */ RecoveryOtpConfirmationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecoveryOtpConfirmationFragment$recoveryViewModel$2(RecoveryOtpConfirmationFragment recoveryOtpConfirmationFragment) {
        super(0);
        this.this$0 = recoveryOtpConfirmationFragment;
    }

    public final AccountRecoveryViewModel invoke() {
        ViewModel viewModel;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Function0 function0 = C42241.INSTANCE;
        if (function0 == null) {
            viewModel = new ViewModelProvider(requireActivity).get(AccountRecoveryViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(T::class.java)");
        } else {
            viewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) new BaseViewModelFactory(function0)).get(AccountRecoveryViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ator)).get(T::class.java)");
        }
        return (AccountRecoveryViewModel) viewModel;
    }
}
