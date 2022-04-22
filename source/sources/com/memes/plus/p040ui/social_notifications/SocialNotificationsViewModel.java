package com.memes.plus.p040ui.social_notifications;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.source.memes.MemesRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.android.schedulers.AndroidSchedulers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\t¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/ui/social_notifications/SocialNotificationsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;)V", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "notificationsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/social_notifications/SocialNotification;", "getNotificationsLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "paginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "swipeRefreshLayoutLiveData", "", "getSwipeRefreshLayoutLiveData", "fetchSocialNotifications", "", "forceRefresh", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.social_notifications.SocialNotificationsViewModel */
/* compiled from: SocialNotificationsViewModel.kt */
public final class SocialNotificationsViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private final SingleLiveEvent<AdapterUpdate<SocialNotification>> notificationsLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo paginationInfo;
    private final MemesRepository repository;
    private final MutableLiveData<Boolean> swipeRefreshLayoutLiveData = new MutableLiveData<>();

    public SocialNotificationsViewModel(MemesRepository memesRepository) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        this.repository = memesRepository;
    }

    public final SingleLiveEvent<AdapterUpdate<SocialNotification>> getNotificationsLiveData() {
        return this.notificationsLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final MutableLiveData<Boolean> getSwipeRefreshLayoutLiveData() {
        return this.swipeRefreshLayoutLiveData;
    }

    public static /* synthetic */ void fetchSocialNotifications$default(SocialNotificationsViewModel socialNotificationsViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        socialNotificationsViewModel.fetchSocialNotifications(z);
    }

    public final void fetchSocialNotifications(boolean z) {
        if (z) {
            this.paginationInfo = null;
        }
        PageBasedPaginationInfo pageBasedPaginationInfo = this.paginationInfo;
        if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
            PageBasedPaginationInfo pageBasedPaginationInfo2 = this.paginationInfo;
            int currentPage = pageBasedPaginationInfo2 != null ? pageBasedPaginationInfo2.getCurrentPage() : 0;
            if (currentPage == 0 && !z) {
                BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
            }
            this.repository.fetchSocialNotifications(currentPage + 1).observeOn(AndroidSchedulers.mainThread()).subscribe(new SocialNotificationsViewModel$fetchSocialNotifications$1(this, currentPage));
        }
    }
}
