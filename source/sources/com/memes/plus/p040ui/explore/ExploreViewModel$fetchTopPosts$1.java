package com.memes.plus.p040ui.explore;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.PaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.p040ui.posts.Post;
import com.memes.plus.util.SmartSingleObserver;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/explore/ExploreViewModel$fetchTopPosts$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/posts/Post;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore.ExploreViewModel$fetchTopPosts$1 */
/* compiled from: ExploreViewModel.kt */
public final class ExploreViewModel$fetchTopPosts$1 extends SmartSingleObserver<UniversalResult<Post>> {
    final /* synthetic */ int $currentPage;
    final /* synthetic */ ExploreViewModel this$0;

    ExploreViewModel$fetchTopPosts$1(ExploreViewModel exploreViewModel, int i) {
        this.this$0 = exploreViewModel;
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
                ExploreViewModel exploreViewModel = this.this$0;
                exploreViewModel.showLoginError(exploreViewModel.getContentVisibilityLiveData(), universalResult.getMessage());
                return;
            }
            ExploreViewModel exploreViewModel2 = this.this$0;
            exploreViewModel2.showError(exploreViewModel2.getContentVisibilityLiveData(), universalResult.getMessage());
        } else if (universalResult.hasNoItems()) {
            ExploreViewModel exploreViewModel3 = this.this$0;
            BaseViewModel.showContentNotAvailable$default(exploreViewModel3, exploreViewModel3.getContentVisibilityLiveData(), (String) null, 2, (Object) null);
        } else {
            this.this$0.getTopPostsLiveData().setValue(new AdapterUpdate(this.$currentPage, universalResult.getItems()));
            ExploreViewModel exploreViewModel4 = this.this$0;
            PaginationInfo pagination = universalResult.getPagination();
            Objects.requireNonNull(pagination, "null cannot be cast to non-null type com.memes.plus.data.mapped_response.PageBasedPaginationInfo");
            exploreViewModel4.postsPaginationInfo = (PageBasedPaginationInfo) pagination;
            ExploreViewModel exploreViewModel5 = this.this$0;
            exploreViewModel5.showContent(exploreViewModel5.getContentVisibilityLiveData());
            this.this$0.getSwipeRefreshLayoutLiveData().setValue(false);
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        ExploreViewModel exploreViewModel = this.this$0;
        exploreViewModel.showError(exploreViewModel.getContentVisibilityLiveData(), str);
        this.this$0.getSwipeRefreshLayoutLiveData().setValue(false);
    }
}
