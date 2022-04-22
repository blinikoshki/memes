package com.memes.commons.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.commons.viewmodel.ViewModelRegistrar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0017J\b\u0010\r\u001a\u00020\nH\u0016J\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0012H\u0002J!\u0010\u0013\u001a\u00020\n2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0015\"\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007J$\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\"\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo26107d2 = {"Lcom/memes/commons/activity/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/memes/commons/viewmodel/ViewModelRegistrar;", "()V", "blockingProgressDialog", "Lcom/kaopiz/kprogresshud/KProgressHUD;", "isBlockingProgressDialogVisible", "", "isStartedForResult", "onBackPressed", "", "onBlockingProgressDialogVisibilityChanged", "isVisible", "onSessionExpired", "popFragment", "registerViewModel", "viewModel", "Landroidx/lifecycle/ViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "registerViewModels", "viewModels", "", "([Landroidx/lifecycle/ViewModel;)V", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "fragmentTag", "", "fragmentContainer", "", "addToBackStack", "showBlockingProgressDialog", "shouldShow", "message", "cancellable", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity extends AppCompatActivity implements ViewModelRegistrar {
    /* access modifiers changed from: private */
    public KProgressHUD blockingProgressDialog;
    private boolean isBlockingProgressDialogVisible;

    public static final /* synthetic */ KProgressHUD access$getBlockingProgressDialog$p(BaseActivity baseActivity) {
        KProgressHUD kProgressHUD = baseActivity.blockingProgressDialog;
        if (kProgressHUD == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingProgressDialog");
        }
        return kProgressHUD;
    }

    /* access modifiers changed from: protected */
    public final boolean isStartedForResult() {
        return getCallingActivity() != null;
    }

    public void onSessionExpired() {
        throw new RuntimeException("Session Expired :(");
    }

    public void onBackPressed() {
        finish();
    }

    private final void registerViewModel(ViewModel viewModel) {
        if (viewModel instanceof LifecycleObserver) {
            getLifecycle().addObserver((LifecycleObserver) viewModel);
        }
        if (viewModel instanceof BaseViewModel) {
            registerViewModel((BaseViewModel) viewModel);
        }
    }

    private final void registerViewModel(BaseViewModel baseViewModel) {
        LifecycleOwner lifecycleOwner = this;
        baseViewModel.getToastLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$1(this));
        baseViewModel.getToastResLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$2(this));
        baseViewModel.getBlockingProgressLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$3(this));
        baseViewModel.getBlockingProgressMessageLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$4(this));
        baseViewModel.getSessionExpiredLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$5(this));
    }

    public final void replaceFragment(Fragment fragment, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "fragmentTag");
        getSupportFragmentManager().beginTransaction().replace(i, fragment).addToBackStack(str).commitAllowingStateLoss();
    }

    public final void popFragment() {
        getSupportFragmentManager().popBackStack();
    }

    public void onBlockingProgressDialogVisibilityChanged(boolean z) {
        this.isBlockingProgressDialogVisible = z;
    }

    public final boolean isBlockingProgressDialogVisible() {
        return this.isBlockingProgressDialogVisible;
    }

    public static /* synthetic */ KProgressHUD showBlockingProgressDialog$default(BaseActivity baseActivity, boolean z, String str, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str = "Please wait...";
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return baseActivity.showBlockingProgressDialog(z, str, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBlockingProgressDialog");
    }

    public final KProgressHUD showBlockingProgressDialog(boolean z, String str, boolean z2) {
        if (this.blockingProgressDialog == null) {
            KProgressHUD dimAmount = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel(str).setCancellable(z2).setAnimationSpeed(2).setDimAmount(0.5f);
            Intrinsics.checkNotNullExpressionValue(dimAmount, "KProgressHUD.create(this…)\n\t\t\t\t.setDimAmount(0.5f)");
            this.blockingProgressDialog = dimAmount;
        }
        if (z) {
            KProgressHUD kProgressHUD = this.blockingProgressDialog;
            if (kProgressHUD == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockingProgressDialog");
            }
            kProgressHUD.show();
            onBlockingProgressDialogVisibilityChanged(true);
        } else {
            KProgressHUD kProgressHUD2 = this.blockingProgressDialog;
            if (kProgressHUD2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockingProgressDialog");
            }
            kProgressHUD2.dismiss();
            onBlockingProgressDialogVisibilityChanged(false);
        }
        KProgressHUD kProgressHUD3 = this.blockingProgressDialog;
        if (kProgressHUD3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingProgressDialog");
        }
        return kProgressHUD3;
    }

    public void registerViewModels(ViewModel... viewModelArr) {
        Intrinsics.checkNotNullParameter(viewModelArr, "viewModels");
        for (ViewModel registerViewModel : viewModelArr) {
            registerViewModel(registerViewModel);
        }
    }
}
