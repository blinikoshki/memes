package com.memes.plus.p040ui.user_listing;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.util.SmartSingleObserver;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/user_listing/UserListingViewModel$fetchUserListing$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/user_listing/ListedUser;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UserListingViewModel$fetchUserListing$1 */
/* compiled from: UserListingViewModel.kt */
public final class UserListingViewModel$fetchUserListing$1 extends SmartSingleObserver<UniversalResult<ListedUser>> {
    final /* synthetic */ int $currentPage;
    final /* synthetic */ UserListingViewModel this$0;

    UserListingViewModel$fetchUserListing$1(UserListingViewModel userListingViewModel, int i) {
        this.this$0 = userListingViewModel;
        this.$currentPage = i;
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.addDisposable(disposable);
    }

    public void onSuccess(UniversalResult<ListedUser> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        if (!universalResult.isError()) {
            List<ListedUser> items = universalResult.getItems();
            Collection collection = items;
            if (collection == null || collection.isEmpty()) {
                UserListingViewModel userListingViewModel = this.this$0;
                userListingViewModel.showContentNotAvailable(userListingViewModel.getContentVisibilityLiveData(), "No users found");
                return;
            }
            this.this$0.cachedListedUsers.addAll(collection);
            this.this$0.getListedUsersLiveData().setValue(new AdapterUpdate(this.$currentPage, items));
            this.this$0.usersPaginationInfo = (PageBasedPaginationInfo) universalResult.getPagination();
            UserListingViewModel userListingViewModel2 = this.this$0;
            userListingViewModel2.showContent(userListingViewModel2.getContentVisibilityLiveData());
        } else if (universalResult.isSessionExpired()) {
            this.this$0.showSessionExpiredDialog(universalResult.getMessage());
        } else {
            UserListingViewModel userListingViewModel3 = this.this$0;
            userListingViewModel3.showError(userListingViewModel3.getContentVisibilityLiveData(), universalResult.getMessage());
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        UserListingViewModel userListingViewModel = this.this$0;
        userListingViewModel.showError(userListingViewModel.getContentVisibilityLiveData(), str);
    }
}
