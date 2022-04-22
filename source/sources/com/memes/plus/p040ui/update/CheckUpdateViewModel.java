package com.memes.plus.p040ui.update;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.MemesSession;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.util.OneShotLiveData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0002J\u0011\u0010\u001d\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0006\u0010%\u001a\u00020\u001aR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0011\u0010\u0013\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, mo26107d2 = {"Lcom/memes/plus/ui/update/CheckUpdateViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/plus/data/storage/StorageRepository;)V", "forceUpdateDialogLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getForceUpdateDialogLiveData", "()Landroidx/lifecycle/MutableLiveData;", "receivedUpdateConfig", "Lcom/memes/plus/ui/update/AppUpdateConfig;", "showAuthPromptPageLiveData", "Lcom/memes/plus/util/OneShotLiveData;", "getShowAuthPromptPageLiveData", "()Lcom/memes/plus/util/OneShotLiveData;", "showCheckingUpdatesLiveData", "", "getShowCheckingUpdatesLiveData", "showHomePageLiveData", "getShowHomePageLiveData", "showWelcomePageLiveData", "getShowWelcomePageLiveData", "skippableUpdateDialogLiveData", "getSkippableUpdateDialogLiveData", "checkForUpdate", "", "ensureUpdateRequired", "fetchLastAppUpdateConfig", "fetchRemoteConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppUpdateRemoteConfig", "hasLocalAppUpdateConfig", "isConfigRefreshRequired", "moveToNextNavigation", "saveAppUpdateConfig", "config", "skipForceUpdate", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.update.CheckUpdateViewModel */
/* compiled from: CheckUpdateViewModel.kt */
public final class CheckUpdateViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REMOTE_CONFIG_REFRESH_INTERVAL = 43200000;
    private final MutableLiveData<String> forceUpdateDialogLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public AppUpdateConfig receivedUpdateConfig;
    private final OneShotLiveData showAuthPromptPageLiveData = new OneShotLiveData();
    private final MutableLiveData<Boolean> showCheckingUpdatesLiveData = new MutableLiveData<>();
    private final OneShotLiveData showHomePageLiveData = new OneShotLiveData();
    private final OneShotLiveData showWelcomePageLiveData = new OneShotLiveData();
    private final MutableLiveData<String> skippableUpdateDialogLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;

    public CheckUpdateViewModel(StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.storageRepository = storageRepository2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/update/CheckUpdateViewModel$Companion;", "", "()V", "REMOTE_CONFIG_REFRESH_INTERVAL", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.update.CheckUpdateViewModel$Companion */
    /* compiled from: CheckUpdateViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final MutableLiveData<Boolean> getShowCheckingUpdatesLiveData() {
        return this.showCheckingUpdatesLiveData;
    }

    public final MutableLiveData<String> getForceUpdateDialogLiveData() {
        return this.forceUpdateDialogLiveData;
    }

    public final MutableLiveData<String> getSkippableUpdateDialogLiveData() {
        return this.skippableUpdateDialogLiveData;
    }

    public final OneShotLiveData getShowHomePageLiveData() {
        return this.showHomePageLiveData;
    }

    public final OneShotLiveData getShowWelcomePageLiveData() {
        return this.showWelcomePageLiveData;
    }

    public final OneShotLiveData getShowAuthPromptPageLiveData() {
        return this.showAuthPromptPageLiveData;
    }

    public final void skipForceUpdate() {
        moveToNextNavigation();
    }

    public final void ensureUpdateRequired() {
        AppUpdateConfig appUpdateConfig = this.receivedUpdateConfig;
        if (appUpdateConfig != null && appUpdateConfig.isUpdateAvailable()) {
            this.showCheckingUpdatesLiveData.setValue(false);
            if (appUpdateConfig.isForceUpdateRequired()) {
                this.forceUpdateDialogLiveData.setValue(appUpdateConfig.getPackageName());
            } else {
                this.skippableUpdateDialogLiveData.setValue(appUpdateConfig.getPackageName());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void moveToNextNavigation() {
        if (MemesSession.INSTANCE.isEmpty()) {
            this.showAuthPromptPageLiveData.pewpewpew();
        } else {
            this.showHomePageLiveData.shoot();
        }
    }

    /* access modifiers changed from: private */
    public final boolean isConfigRefreshRequired() {
        AppUpdateConfig fetchLastAppUpdateConfig = fetchLastAppUpdateConfig();
        if (fetchLastAppUpdateConfig == null || fetchLastAppUpdateConfig.getLastFetchedAt() == 0 || fetchLastAppUpdateConfig.getTargetVersion() != 73 || System.currentTimeMillis() - fetchLastAppUpdateConfig.getLastFetchedAt() > ((long) REMOTE_CONFIG_REFRESH_INTERVAL)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean hasLocalAppUpdateConfig() {
        AppUpdateConfig fetchLastAppUpdateConfig = fetchLastAppUpdateConfig();
        return (fetchLastAppUpdateConfig == null || fetchLastAppUpdateConfig.getLastFetchedAt() == 0) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void saveAppUpdateConfig(AppUpdateConfig appUpdateConfig) {
        appUpdateConfig.setLastFetchedAt(System.currentTimeMillis());
        StorageRepository storageRepository2 = this.storageRepository;
        String json = new Gson().toJson((Object) appUpdateConfig);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(config)");
        storageRepository2.appUpdateConfig(json);
    }

    /* access modifiers changed from: private */
    public final AppUpdateConfig fetchLastAppUpdateConfig() {
        String appUpdateConfig = this.storageRepository.appUpdateConfig();
        CharSequence charSequence = appUpdateConfig;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return (AppUpdateConfig) new Gson().fromJson(appUpdateConfig, AppUpdateConfig.class);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object fetchRemoteConfig(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CheckUpdateViewModel$fetchRemoteConfig$2((Continuation) null), continuation);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object getAppUpdateRemoteConfig(Continuation<? super AppUpdateConfig> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CheckUpdateViewModel$getAppUpdateRemoteConfig$2((Continuation) null), continuation);
    }

    public final void checkForUpdate() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), new C4350x65e53dec(CoroutineExceptionHandler.Key, this), (CoroutineStart) null, new CheckUpdateViewModel$checkForUpdate$1(this, (Continuation) null), 2, (Object) null);
    }
}
