package com.memes.plus.p040ui.profile.edit_profile.notification_settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.memes.plus.base.BaseActivity;
import com.memes.plus.databinding.NotificationSettingsActivityBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsActivity;", "Lcom/memes/plus/base/BaseActivity;", "()V", "binding", "Lcom/memes/plus/databinding/NotificationSettingsActivityBinding;", "getBinding", "()Lcom/memes/plus/databinding/NotificationSettingsActivityBinding;", "binding$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationViewModel;", "getViewModel", "()Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.notification_settings.NotificationSettingsActivity */
/* compiled from: NotificationSettingsActivity.kt */
public final class NotificationSettingsActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy binding$delegate = LazyKt.lazy(new NotificationSettingsActivity$binding$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new NotificationSettingsActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final NotificationSettingsActivityBinding getBinding() {
        return (NotificationSettingsActivityBinding) this.binding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NotificationViewModel getViewModel() {
        return (NotificationViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.profile.edit_profile.notification_settings.NotificationSettingsActivity$Companion */
    /* compiled from: NotificationSettingsActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent getStartIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, NotificationSettingsActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotificationSettingsActivityBinding binding = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding, "binding");
        setContentView((View) binding.getRoot());
        registerViewModel(getViewModel());
        getBinding().saveButton.setOnClickListener(new NotificationSettingsActivity$onCreate$1(this));
        getBinding().backNavigationImage.setOnClickListener(new NotificationSettingsActivity$onCreate$2(this));
        getViewModel().getNotificationSettingsLiveData().observe(this, new NotificationSettingsActivity$onCreate$3(this));
        getViewModel().fetchNotificationSettings();
    }
}
