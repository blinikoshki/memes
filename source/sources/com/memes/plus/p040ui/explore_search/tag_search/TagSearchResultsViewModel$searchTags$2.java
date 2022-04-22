package com.memes.plus.p040ui.explore_search.tag_search;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.mapped_response.PaginationInfo;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.util.SmartSingleObserver;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000f"}, mo26107d2 = {"com/memes/plus/ui/explore_search/tag_search/TagSearchResultsViewModel$searchTags$2", "Lcom/memes/plus/util/SmartSingleObserver;", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "onError", "", "message", "", "throwable", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "universalResult", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.tag_search.TagSearchResultsViewModel$searchTags$2 */
/* compiled from: TagSearchResultsViewModel.kt */
public final class TagSearchResultsViewModel$searchTags$2 extends SmartSingleObserver<UniversalResult<TagSearchResult>> {
    final /* synthetic */ int $currentPage;
    final /* synthetic */ TagSearchResultsViewModel this$0;

    TagSearchResultsViewModel$searchTags$2(TagSearchResultsViewModel tagSearchResultsViewModel, int i) {
        this.this$0 = tagSearchResultsViewModel;
        this.$currentPage = i;
    }

    public void onSubscribe(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
        this.this$0.searchRequestDisposable = disposable;
        this.this$0.addDisposable(disposable);
    }

    public void onSuccess(UniversalResult<TagSearchResult> universalResult) {
        Intrinsics.checkNotNullParameter(universalResult, "universalResult");
        if (universalResult.isError()) {
            if (universalResult.isSessionExpired()) {
                TagSearchResultsViewModel tagSearchResultsViewModel = this.this$0;
                tagSearchResultsViewModel.showLoginError(tagSearchResultsViewModel.getContentVisibilityLiveData(), universalResult.getMessage());
                return;
            }
            TagSearchResultsViewModel tagSearchResultsViewModel2 = this.this$0;
            tagSearchResultsViewModel2.showError(tagSearchResultsViewModel2.getContentVisibilityLiveData(), universalResult.getMessage());
        } else if (universalResult.hasNoItems()) {
            TagSearchResultsViewModel tagSearchResultsViewModel3 = this.this$0;
            BaseViewModel.showContentNotAvailable$default(tagSearchResultsViewModel3, tagSearchResultsViewModel3.getContentVisibilityLiveData(), (String) null, 2, (Object) null);
        } else {
            this.this$0.getResultsLiveData().setValue(new AdapterUpdate(this.$currentPage, universalResult.getItems()));
            TagSearchResultsViewModel tagSearchResultsViewModel4 = this.this$0;
            PaginationInfo pagination = universalResult.getPagination();
            Objects.requireNonNull(pagination, "null cannot be cast to non-null type com.memes.plus.data.mapped_response.PageBasedPaginationInfo");
            tagSearchResultsViewModel4.resultsPaginationInfo = (PageBasedPaginationInfo) pagination;
            TagSearchResultsViewModel tagSearchResultsViewModel5 = this.this$0;
            tagSearchResultsViewModel5.showContent(tagSearchResultsViewModel5.getContentVisibilityLiveData());
        }
    }

    public void onError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        TagSearchResultsViewModel tagSearchResultsViewModel = this.this$0;
        tagSearchResultsViewModel.showError(tagSearchResultsViewModel.getContentVisibilityLiveData(), str);
    }
}
