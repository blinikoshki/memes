package com.memes.plus.p040ui.auth.recovery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.memes.plus.p040ui.auth.recovery.stages.AccountRecoveryStage;
import com.memes.plus.p040ui.auth.recovery.stages.RecoveryNewPasswordFragment;
import com.memes.plus.p040ui.auth.recovery.stages.RecoveryOtpConfirmationFragment;
import com.memes.plus.p040ui.auth.recovery.stages.RecoveryRequestCodeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/recovery/AccountRecoveryPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.AccountRecoveryPagerAdapter */
/* compiled from: AccountRecoveryPagerAdapter.kt */
public final class AccountRecoveryPagerAdapter extends FragmentStateAdapter {
    public int getItemCount() {
        return 3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountRecoveryPagerAdapter(AppCompatActivity appCompatActivity) {
        super((FragmentActivity) appCompatActivity);
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
    }

    public Fragment createFragment(int i) {
        Timber.m300d(this + ".createFragment(" + i + ')', new Object[0]);
        if (i == AccountRecoveryStage.REQUEST_OTP.getPosition()) {
            return new RecoveryRequestCodeFragment();
        }
        if (i == AccountRecoveryStage.CONFIRM_OTP.getPosition()) {
            return new RecoveryOtpConfirmationFragment();
        }
        if (i == AccountRecoveryStage.INPUT_NEW_PASSWORD.getPosition()) {
            return new RecoveryNewPasswordFragment();
        }
        throw new RuntimeException("Unknown position: " + i);
    }
}
