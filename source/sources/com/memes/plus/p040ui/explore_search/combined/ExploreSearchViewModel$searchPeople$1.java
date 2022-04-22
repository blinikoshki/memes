package com.memes.plus.p040ui.explore_search.combined;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.PaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResult;
import com.memes.plus.util.SmartSingleObserver;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/explore_search/combined/ExploreSearchViewModel$searchPeople$1", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.combined.ExploreSearchViewModel$searchPeople$1 */
/* compiled from: ExploreSearchViewModel.kt */
public final class ExploreSearchViewModel$searchPeople$1 extends SmartSingleObserver<UniversalResult<PeopleSearchResult>> {
    final /* synthetic */ int $currentPage;
    final /* synthetic */ ExploreSearchViewModel this$0;

    ExploreSearchViewModel$searchPeople$1(ExploreSearchViewModel exploreSearchViewModel, int i) {
        this.this$0 = exploreSearchViewModel;
        this.$currentPage = i;
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.searchRequestDisposable = disposable;
        this.this$0.addDisposable(disposable);
    }

    public void onSuccess(UniversalResult<PeopleSearchResult> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        if (universalResult.isError()) {
            if (universalResult.isSessionExpired()) {
                ExploreSearchViewModel exploreSearchViewModel = this.this$0;
                exploreSearchViewModel.showLoginError(exploreSearchViewModel.getContentVisibilityLiveData(), universalResult.getMessage());
                return;
            }
            ExploreSearchViewModel exploreSearchViewModel2 = this.this$0;
            exploreSearchViewModel2.showError(exploreSearchViewModel2.getContentVisibilityLiveData(), universalResult.getMessage());
        } else if (universalResult.hasNoItems()) {
            ExploreSearchViewModel exploreSearchViewModel3 = this.this$0;
            BaseViewModel.showContentNotAvailable$default(exploreSearchViewModel3, exploreSearchViewModel3.getContentVisibilityLiveData(), (String) null, 2, (Object) null);
        } else {
            this.this$0.getResultsLiveData().setValue(new AdapterUpdate(this.$currentPage, universalResult.getItems()));
            ExploreSearchViewModel exploreSearchViewModel4 = this.this$0;
            PaginationInfo pagination = universalResult.getPagination();
            Objects.requireNonNull(pagination, "null cannot be cast to non-null type com.memes.plus.data.mapped_response.PageBasedPaginationInfo");
            exploreSearchViewModel4.resultsPaginationInfo = (PageBasedPaginationInfo) pagination;
            ExploreSearchViewModel exploreSearchViewModel5 = this.this$0;
            exploreSearchViewModel5.showContent(exploreSearchViewModel5.getContentVisibilityLiveData());
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        ExploreSearchViewModel exploreSearchViewModel = this.this$0;
        exploreSearchViewModel.showError(exploreSearchViewModel.getContentVisibilityLiveData(), str);
    }
}
