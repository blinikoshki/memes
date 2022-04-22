package com.memes.plus.p040ui.auth.recovery;

import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.plus.p040ui.auth.recovery.stages.AccountRecoveryStage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "stage", "Lcom/memes/plus/ui/auth/recovery/stages/AccountRecoveryStage;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.AccountRecoveryActivity$onCreate$1 */
/* compiled from: AccountRecoveryActivity.kt */
final class AccountRecoveryActivity$onCreate$1<T> implements Observer<AccountRecoveryStage> {
    final /* synthetic */ AccountRecoveryActivity this$0;

    AccountRecoveryActivity$onCreate$1(AccountRecoveryActivity accountRecoveryActivity) {
        this.this$0 = accountRecoveryActivity;
    }

    public final void onChanged(AccountRecoveryStage accountRecoveryStage) {
        int position = accountRecoveryStage.getPosition();
        ViewPager2 viewPager2 = this.this$0.getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setCurrentItem(position);
    }
}
