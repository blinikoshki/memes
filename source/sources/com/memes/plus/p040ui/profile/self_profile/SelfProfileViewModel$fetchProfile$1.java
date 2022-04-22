package com.memes.plus.p040ui.profile.self_profile;

import androidx.lifecycle.MutableLiveData;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.storage.InstantStorage;
import com.memes.plus.util.SmartSingleObserver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/profile/self_profile/SelfProfileViewModel$fetchProfile$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/profile/self_profile/SelfProfile;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.self_profile.SelfProfileViewModel$fetchProfile$1 */
/* compiled from: SelfProfileViewModel.kt */
public final class SelfProfileViewModel$fetchProfile$1 extends SmartSingleObserver<UniversalResult<SelfProfile>> {
    final /* synthetic */ SelfProfileViewModel this$0;

    SelfProfileViewModel$fetchProfile$1(SelfProfileViewModel selfProfileViewModel) {
        this.this$0 = selfProfileViewModel;
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.addDisposable(disposable);
    }

    public void onSuccess(UniversalResult<SelfProfile> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        if (universalResult.isError()) {
            if (universalResult.isSessionExpired()) {
                SelfProfileViewModel selfProfileViewModel = this.this$0;
                selfProfileViewModel.showLoginError(selfProfileViewModel.getFullPageContentLayoutLiveData(), universalResult.getMessage());
                return;
            }
            SelfProfileViewModel selfProfileViewModel2 = this.this$0;
            MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData = selfProfileViewModel2.getFullPageContentLayoutLiveData();
            selfProfileViewModel2.showError(fullPageContentLayoutLiveData, "Error: " + universalResult.getMessage());
        } else if (universalResult.hasNoItems()) {
            SelfProfileViewModel selfProfileViewModel3 = this.this$0;
            MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData2 = selfProfileViewModel3.getFullPageContentLayoutLiveData();
            selfProfileViewModel3.showContentNotAvailable(fullPageContentLayoutLiveData2, "Error: " + universalResult.getMessage());
        } else {
            SelfProfileViewModel selfProfileViewModel4 = this.this$0;
            List<SelfProfile> items = universalResult.getItems();
            SelfProfile selfProfile = items != null ? items.get(0) : null;
            Intrinsics.checkNotNull(selfProfile);
            selfProfileViewModel4.selfProfile = selfProfile;
            this.this$0.getProfileLiveData().setValue(this.this$0.selfProfile);
            InstantStorage.INSTANCE.saveProfile(this.this$0.storageRepository, this.this$0.selfProfile);
            SelfProfileViewModel selfProfileViewModel5 = this.this$0;
            selfProfileViewModel5.showContent(selfProfileViewModel5.getFullPageContentLayoutLiveData());
            if (this.this$0.getPostsLiveData().getValue() == null) {
                this.this$0.fetchPosts();
            }
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        SelfProfileViewModel selfProfileViewModel = this.this$0;
        MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData = selfProfileViewModel.getFullPageContentLayoutLiveData();
        selfProfileViewModel.showError(fullPageContentLayoutLiveData, "Error: " + str);
    }
}
