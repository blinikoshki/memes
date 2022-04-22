package com.memes.plus.p040ui.profile.profile_posts;

import androidx.lifecycle.MutableLiveData;
import com.facebook.share.internal.ShareConstants;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.PaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.util.SmartSingleObserver;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/profile/profile_posts/ProfilePostsViewModel$fetchPosts$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/posts/Post;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.profile.profile_posts.ProfilePostsViewModel$fetchPosts$1 */
/* compiled from: ProfilePostsViewModel.kt */
public final class ProfilePostsViewModel$fetchPosts$1 extends SmartSingleObserver<UniversalResult<Post>> {
    final /* synthetic */ int $currentPage;
    final /* synthetic */ ProfilePostsViewModel this$0;

    ProfilePostsViewModel$fetchPosts$1(ProfilePostsViewModel profilePostsViewModel, int i) {
        this.this$0 = profilePostsViewModel;
        this.$currentPage = i;
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.addDisposable(disposable);
    }

    public void onSuccess(UniversalResult<Post> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        if (universalResult.isError()) {
            if (universalResult.isSessionExpired()) {
                ProfilePostsViewModel profilePostsViewModel = this.this$0;
                profilePostsViewModel.showLoginError(profilePostsViewModel.getContentVisibilityLiveData(), universalResult.getMessage());
                return;
            }
            ProfilePostsViewModel profilePostsViewModel2 = this.this$0;
            MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = profilePostsViewModel2.getContentVisibilityLiveData();
            profilePostsViewModel2.showError(contentVisibilityLiveData, "Error: " + universalResult.getMessage());
        } else if (universalResult.hasNoItems()) {
            ProfilePostsViewModel profilePostsViewModel3 = this.this$0;
            MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData2 = profilePostsViewModel3.getContentVisibilityLiveData();
            profilePostsViewModel3.showContentNotAvailable(contentVisibilityLiveData2, "Error: " + universalResult.getMessage());
        } else {
            ProfilePostsViewModel profilePostsViewModel4 = this.this$0;
            PaginationInfo pagination = universalResult.getPagination();
            Objects.requireNonNull(pagination, "null cannot be cast to non-null type com.memes.plus.data.mapped_response.PageBasedPaginationInfo");
            profilePostsViewModel4.postsPaginationInfo = (PageBasedPaginationInfo) pagination;
            this.this$0.getPostsLiveData().setValue(new AdapterUpdate(this.$currentPage, universalResult.getItems()));
            ProfilePostsViewModel profilePostsViewModel5 = this.this$0;
            profilePostsViewModel5.showContent(profilePostsViewModel5.getContentVisibilityLiveData());
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        ProfilePostsViewModel profilePostsViewModel = this.this$0;
        MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = profilePostsViewModel.getContentVisibilityLiveData();
        profilePostsViewModel.showError(contentVisibilityLiveData, "Error: " + str);
    }
}
