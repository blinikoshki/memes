package com.memes.plus.p040ui.auth.recovery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.commons.util.SoftKeyboardUtil;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.AuthAccountRecoveryActivityBinding;
import com.memes.plus.p040ui.auth.recovery.stages.AccountRecoveryStage;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/recovery/AccountRecoveryActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/AuthAccountRecoveryActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/AuthAccountRecoveryActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "recoveryViewModel", "Lcom/memes/plus/ui/auth/recovery/AccountRecoveryViewModel;", "getRecoveryViewModel", "()Lcom/memes/plus/ui/auth/recovery/AccountRecoveryViewModel;", "recoveryViewModel$delegate", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.recovery.AccountRecoveryActivity */
/* compiled from: AccountRecoveryActivity.kt */
public final class AccountRecoveryActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy binding$delegate = LazyKt.lazy(new AccountRecoveryActivity$binding$2(this));
    private final Lazy recoveryViewModel$delegate = LazyKt.lazy(new AccountRecoveryActivity$recoveryViewModel$2(this));

    /* access modifiers changed from: private */
    public final AuthAccountRecoveryActivityBinding getBinding() {
        return (AuthAccountRecoveryActivityBinding) this.binding$delegate.getValue();
    }

    private final AccountRecoveryViewModel getRecoveryViewModel() {
        return (AccountRecoveryViewModel) this.recoveryViewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/recovery/AccountRecoveryActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.recovery.AccountRecoveryActivity$Companion */
    /* compiled from: AccountRecoveryActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, AccountRecoveryActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AuthAccountRecoveryActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getRecoveryViewModel());
        AccountRecoveryPagerAdapter accountRecoveryPagerAdapter = new AccountRecoveryPagerAdapter(this);
        ViewPager2 viewPager2 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setOffscreenPageLimit(accountRecoveryPagerAdapter.getItemCount());
        ViewPager2 viewPager22 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager22, "binding.viewPager");
        viewPager22.setUserInputEnabled(false);
        ViewPager2 viewPager23 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager23, "binding.viewPager");
        viewPager23.setAdapter(accountRecoveryPagerAdapter);
        LifecycleOwner lifecycleOwner = this;
        getRecoveryViewModel().onRecoveryStageChanged().observe(lifecycleOwner, new AccountRecoveryActivity$onCreate$1(this));
        getRecoveryViewModel().onRecoveryCompleted().observe(lifecycleOwner, new AccountRecoveryActivity$onCreate$2(this));
    }

    public void onBackPressed() {
        SoftKeyboardUtil.INSTANCE.hideKeyboard((Activity) this);
        ViewPager2 viewPager2 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        int currentItem = viewPager2.getCurrentItem();
        AccountRecoveryStage accountRecoveryStage = null;
        if (currentItem == AccountRecoveryStage.INPUT_NEW_PASSWORD.getPosition()) {
            accountRecoveryStage = AccountRecoveryStage.CONFIRM_OTP;
        } else if (currentItem == AccountRecoveryStage.CONFIRM_OTP.getPosition()) {
            accountRecoveryStage = AccountRecoveryStage.REQUEST_OTP;
        } else {
            int position = AccountRecoveryStage.REQUEST_OTP.getPosition();
        }
        if (accountRecoveryStage != null) {
            getRecoveryViewModel().changeStage(accountRecoveryStage);
        } else {
            super.onBackPressed();
        }
    }
}
