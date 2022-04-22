package com.memes.plus.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.util.ActivityStarter;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.App;
import com.memes.plus.C4199R;
import com.memes.plus.events.NotifiableEvent;
import com.memes.plus.p040ui.auth.auth_prompt.AuthPromptActivity;
import com.memes.plus.p040ui.splash.SplashActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u0006H\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0017J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0017J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\b\u0010\u001d\u001a\u00020\u0012H\u0014J\b\u0010\u001e\u001a\u00020\u0012H\u0014J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u000fH\u0014J\b\u0010!\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0016J \u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0012H\u0002J$\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010/\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u00060"}, mo26107d2 = {"Lcom/memes/plus/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/memes/plus/base/ActivityHandle;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "isBlockingProgressDialogVisible", "", "isPaused", "kProgressHUD", "Lcom/kaopiz/kprogresshud/KProgressHUD;", "beforeBinding", "fragmentContainerId", "", "isNewProcess", "savedInstanceState", "Landroid/os/Bundle;", "isStartedForResult", "onBackPressed", "", "onBlockingProgressDialogVisibilityChanged", "isVisible", "onContentLayoutErrorResolutionButtonTapped", "who", "why", "onCreate", "onDestroy", "onEventReceived", "event", "Lcom/memes/plus/events/NotifiableEvent;", "onPause", "onResume", "onSaveInstanceState", "outState", "popFragment", "registerViewModel", "viewModel", "Lcom/memes/commons/viewmodel/BaseViewModel;", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "fragmentTag", "", "addToBackStack", "showAuthPrompt", "showBlockingProgressDialog", "shouldShow", "message", "cancellable", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity extends AppCompatActivity implements ActivityHandle, ContentLayout.Callback {
    private boolean isBlockingProgressDialogVisible;
    private boolean isPaused;
    /* access modifiers changed from: private */
    public KProgressHUD kProgressHUD;

    public boolean beforeBinding() {
        return true;
    }

    public int fragmentContainerId() {
        return C4199R.C4203id.fragment_container;
    }

    public static final /* synthetic */ KProgressHUD access$getKProgressHUD$p(BaseActivity baseActivity) {
        KProgressHUD kProgressHUD2 = baseActivity.kProgressHUD;
        if (kProgressHUD2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kProgressHUD");
        }
        return kProgressHUD2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!beforeBinding()) {
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isStartedForResult() {
        return getCallingActivity() != null;
    }

    public void registerViewModel(BaseViewModel baseViewModel) {
        Intrinsics.checkNotNullParameter(baseViewModel, "viewModel");
        LifecycleOwner lifecycleOwner = this;
        baseViewModel.getToastLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$1(this));
        baseViewModel.getToastResLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$2(this));
        baseViewModel.getBlockingProgressLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$3(this));
        baseViewModel.getBlockingProgressMessageLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$4(this));
        baseViewModel.getInformationDialogLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$5(this));
        baseViewModel.getSessionExpiredLiveData().observe(lifecycleOwner, new BaseActivity$registerViewModel$6(this));
    }

    public void replaceFragment(Fragment fragment, String str, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "fragmentTag");
        getSupportFragmentManager().beginTransaction().replace(fragmentContainerId(), fragment).addToBackStack(str).commitAllowingStateLoss();
    }

    public void popFragment() {
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
        if (this.kProgressHUD == null) {
            KProgressHUD dimAmount = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel(str).setCancellable(z2).setAnimationSpeed(2).setDimAmount(0.5f);
            Intrinsics.checkNotNullExpressionValue(dimAmount, "KProgressHUD.create(this…)\n\t\t\t\t.setDimAmount(0.5f)");
            this.kProgressHUD = dimAmount;
        }
        if (z) {
            KProgressHUD kProgressHUD2 = this.kProgressHUD;
            if (kProgressHUD2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("kProgressHUD");
            }
            kProgressHUD2.show();
            onBlockingProgressDialogVisibilityChanged(true);
        } else {
            KProgressHUD kProgressHUD3 = this.kProgressHUD;
            if (kProgressHUD3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("kProgressHUD");
            }
            kProgressHUD3.dismiss();
            onBlockingProgressDialogVisibilityChanged(false);
        }
        KProgressHUD kProgressHUD4 = this.kProgressHUD;
        if (kProgressHUD4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kProgressHUD");
        }
        return kProgressHUD4;
    }

    /* access modifiers changed from: private */
    public final void showAuthPrompt() {
        ActivityStarter.Companion.mo57312of(AuthPromptActivity.Companion.getStartIntent(this)).startFrom((Activity) this);
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        if (i2 == 1212) {
            showAuthPrompt();
        }
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.isPaused = true;
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
            return;
        }
        Timber.m303e("EventBus was not registered to " + this + ", yet we wanted to unregister it.", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
            return;
        }
        Timber.m303e("EventBus was already registered to " + this + ", yet we wanted to register it.", new Object[0]);
    }

    @Subscribe(sticky = false, threadMode = ThreadMode.MAIN)
    public void onEventReceived(NotifiableEvent notifiableEvent) {
        Intrinsics.checkNotNullParameter(notifiableEvent, "event");
        Timber.m303e("Unhandled event received: " + notifiableEvent, new Object[0]);
    }

    public void onBackPressed() {
        finish();
    }

    private final boolean isNewProcess(Bundle bundle) {
        if (bundle == null || !(!Intrinsics.areEqual((Object) bundle.getString(App.PID_KEY), (Object) String.valueOf(Process.myPid())))) {
            return false;
        }
        ActivityStarter.Companion.mo57312of(SplashActivity.Companion.getStartIntent(this)).clearStack().finishAffinity().startFrom((Activity) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(App.PID_KEY, String.valueOf(Process.myPid()));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.isPaused = true;
        super.onDestroy();
    }
}
