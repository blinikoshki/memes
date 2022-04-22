package com.memes.plus.p040ui.profile.user_profile;

import androidx.lifecycle.MutableLiveData;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.util.SmartSingleObserver;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/profile/user_profile/UserProfileViewModel$fetchProfile$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/profile/user_profile/UserProfileResponse;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.user_profile.UserProfileViewModel$fetchProfile$1 */
/* compiled from: UserProfileViewModel.kt */
public final class UserProfileViewModel$fetchProfile$1 extends SmartSingleObserver<UniversalResult<UserProfileResponse>> {
    final /* synthetic */ UserProfileViewModel this$0;

    UserProfileViewModel$fetchProfile$1(UserProfileViewModel userProfileViewModel) {
        this.this$0 = userProfileViewModel;
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.addDisposable(disposable);
    }

    public void onSuccess(UniversalResult<UserProfileResponse> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        this.this$0.hideBlockingProgressDialog();
        if (universalResult.isError()) {
            if (universalResult.isSessionExpired()) {
                UserProfileViewModel userProfileViewModel = this.this$0;
                userProfileViewModel.showLoginError(userProfileViewModel.getFullPageContentLayoutLiveData(), universalResult.getMessage());
                return;
            }
            UserProfileViewModel userProfileViewModel2 = this.this$0;
            MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData = userProfileViewModel2.getFullPageContentLayoutLiveData();
            userProfileViewModel2.showError(fullPageContentLayoutLiveData, "Error: " + universalResult.getMessage());
        } else if (universalResult.hasNoItem()) {
            UserProfileViewModel userProfileViewModel3 = this.this$0;
            MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData2 = userProfileViewModel3.getFullPageContentLayoutLiveData();
            userProfileViewModel3.showContentNotAvailable(fullPageContentLayoutLiveData2, "Error: " + universalResult.getMessage());
        } else {
            UserProfileResponse item = universalResult.getItem();
            if (item == null) {
                UserProfileViewModel userProfileViewModel4 = this.this$0;
                MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData3 = userProfileViewModel4.getFullPageContentLayoutLiveData();
                userProfileViewModel4.showContentNotAvailable(fullPageContentLayoutLiveData3, "Error Empty Response: " + universalResult.getMessage());
                return;
            }
            UserProfile userProfile = item.getUserProfile();
            if (userProfile == null) {
                UserProfileViewModel userProfileViewModel5 = this.this$0;
                MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData4 = userProfileViewModel5.getFullPageContentLayoutLiveData();
                userProfileViewModel5.showContentNotAvailable(fullPageContentLayoutLiveData4, "Error Empty Profile: " + universalResult.getMessage());
                return;
            }
            this.this$0.userProfile = userProfile;
            this.this$0.getProfileLiveData().setValue(item);
            UserProfileViewModel userProfileViewModel6 = this.this$0;
            userProfileViewModel6.showContent(userProfileViewModel6.getFullPageContentLayoutLiveData());
            Collection data = item.getData();
            if (data == null || data.isEmpty()) {
                UserProfileViewModel userProfileViewModel7 = this.this$0;
                userProfileViewModel7.showContentNotAvailable(userProfileViewModel7.getPostsContentLayoutLiveData(), universalResult.getMessage());
                this.this$0.setSeeMoreButtonVisibility(false);
                return;
            }
            this.this$0.getPostsLiveData().setValue(new AdapterUpdate(0, item.getData()));
            UserProfileViewModel userProfileViewModel8 = this.this$0;
            userProfileViewModel8.showContent(userProfileViewModel8.getPostsContentLayoutLiveData());
            this.this$0.setSeeMoreButtonVisibility(true);
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        UserProfileViewModel userProfileViewModel = this.this$0;
        MutableLiveData<ContentVisibilityAction> fullPageContentLayoutLiveData = userProfileViewModel.getFullPageContentLayoutLiveData();
        userProfileViewModel.showError(fullPageContentLayoutLiveData, "Error: " + str);
        this.this$0.setSeeMoreButtonVisibility(false);
    }
}
