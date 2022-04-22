package com.memes.plus.p040ui.update;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.memes.commons.util.ActivityStarter;
import com.memes.commons.util.Intents;
import com.memes.plus.C4199R;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.CheckUpdateActivityBinding;
import com.memes.plus.p040ui.home.routing.HomeRouting;
import com.memes.plus.util.StyledAlertDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0014J\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/plus/ui/update/CheckUpdateActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/CheckUpdateActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/CheckUpdateActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/memes/plus/ui/update/CheckUpdateViewModel;", "getViewModel", "()Lcom/memes/plus/ui/update/CheckUpdateViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showAppUpdateDialog", "packageName", "", "canSkip", "", "showHomePage", "showPlayStore", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.update.CheckUpdateActivity */
/* compiled from: CheckUpdateActivity.kt */
public final class CheckUpdateActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy binding$delegate = LazyKt.lazy(new CheckUpdateActivity$binding$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new CheckUpdateActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final CheckUpdateActivityBinding getBinding() {
        return (CheckUpdateActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CheckUpdateViewModel getViewModel() {
        return (CheckUpdateViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/update/CheckUpdateActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.update.CheckUpdateActivity$Companion */
    /* compiled from: CheckUpdateActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, CheckUpdateActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CheckUpdateActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getViewModel());
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getShowHomePageLiveData().observe(lifecycleOwner, new CheckUpdateActivity$onCreate$1(this));
        getViewModel().getShowWelcomePageLiveData().observe(lifecycleOwner, new CheckUpdateActivity$onCreate$2(this));
        getViewModel().getShowAuthPromptPageLiveData().observe(lifecycleOwner, new CheckUpdateActivity$onCreate$3(this));
        getViewModel().getShowCheckingUpdatesLiveData().observe(lifecycleOwner, new CheckUpdateActivity$onCreate$4(this));
        getViewModel().getForceUpdateDialogLiveData().observe(lifecycleOwner, new CheckUpdateActivity$onCreate$5(this));
        getViewModel().getSkippableUpdateDialogLiveData().observe(lifecycleOwner, new CheckUpdateActivity$onCreate$6(this));
        getViewModel().checkForUpdate();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getViewModel().ensureUpdateRequired();
    }

    static /* synthetic */ void showAppUpdateDialog$default(CheckUpdateActivity checkUpdateActivity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        checkUpdateActivity.showAppUpdateDialog(str, z);
    }

    /* access modifiers changed from: private */
    public final void showAppUpdateDialog(String str, boolean z) {
        AlertDialog.Builder positiveButton = StyledAlertDialog.INSTANCE.builder(this).setTitle(C4199R.string.force_update_title).setMessage(C4199R.string.force_update_message).setCancelable(false).setPositiveButton(C4199R.string.force_update_action, new CheckUpdateActivity$showAppUpdateDialog$dialogBuilder$1(this, str));
        if (z) {
            positiveButton.setNeutralButton(C4199R.string.skip, new CheckUpdateActivity$showAppUpdateDialog$1(this));
        }
        positiveButton.show();
    }

    /* access modifiers changed from: private */
    public final void showPlayStore(String str) {
        Intent playStoreIntent = Intents.INSTANCE.getPlayStoreIntent(this, str);
        if (playStoreIntent == null) {
            showHomePage();
        } else {
            startActivity(playStoreIntent);
        }
    }

    /* access modifiers changed from: private */
    public final void showHomePage() {
        ActivityStarter.Companion.mo57312of(HomeRouting.INSTANCE.getIntent(this)).finishCurrentActivity().startFrom((Activity) this);
    }
}
