package com.memes.plus.p040ui.profile.edit_profile.notification_settings;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.memes.MemesSession;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.source.memes.MemesRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;)V", "didNotificationStatusChanged", "", "getDidNotificationStatusChanged", "()Z", "setDidNotificationStatusChanged", "(Z)V", "notificationObserver", "com/memes/plus/ui/profile/edit_profile/notification_settings/NotificationViewModel$notificationObserver$1", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationViewModel$notificationObserver$1;", "notificationSettingsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/plus/ui/profile/edit_profile/notification_settings/NotificationSettingsRequest;", "getNotificationSettingsLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "applyNotificationSettings", "", "request", "fetchNotificationSettings", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.edit_profile.notification_settings.NotificationViewModel */
/* compiled from: NotificationViewModel.kt */
public final class NotificationViewModel extends BaseRxJavaViewModel {
    private boolean didNotificationStatusChanged;
    private final NotificationViewModel$notificationObserver$1 notificationObserver = new NotificationViewModel$notificationObserver$1(this);
    private final SingleLiveEvent<NotificationSettingsRequest> notificationSettingsLiveData = new SingleLiveEvent<>();
    private final MemesRepository repository;

    public NotificationViewModel(MemesRepository memesRepository) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        this.repository = memesRepository;
    }

    public final SingleLiveEvent<NotificationSettingsRequest> getNotificationSettingsLiveData() {
        return this.notificationSettingsLiveData;
    }

    public final boolean getDidNotificationStatusChanged() {
        return this.didNotificationStatusChanged;
    }

    public final void setDidNotificationStatusChanged(boolean z) {
        this.didNotificationStatusChanged = z;
    }

    public final void applyNotificationSettings(NotificationSettingsRequest notificationSettingsRequest) {
        Intrinsics.checkNotNullParameter(notificationSettingsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        this.didNotificationStatusChanged = notificationSettingsRequest.getHasNotificationStatusChanged();
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        this.repository.changeNotificationStatus(notificationSettingsRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(this.notificationObserver);
    }

    public final void fetchNotificationSettings() {
        this.didNotificationStatusChanged = false;
        BaseViewModel.showBlockingProgressDialog$default(this, (String) null, 1, (Object) null);
        NotificationSettingsRequest notificationSettingsRequest = new NotificationSettingsRequest();
        notificationSettingsRequest.setUserId(MemesSession.INSTANCE.getUserId());
        notificationSettingsRequest.setLoginToken(MemesSession.INSTANCE.getToken());
        this.repository.toggleNotificationStatus(notificationSettingsRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(this.notificationObserver);
    }
}
