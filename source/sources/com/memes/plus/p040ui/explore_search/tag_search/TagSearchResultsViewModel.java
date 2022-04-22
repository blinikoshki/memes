package com.memes.plus.p040ui.explore_search.tag_search;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.data.storage.StorageRepository;
import com.memes.plus.p040ui.explore_search.ExploreSearchRequest;
import com.memes.plus.p040ui.explore_search.ExploreSearchType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.reactivex.android.schedulers.AndroidSchedulers;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "repository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/plus/data/storage/StorageRepository;)V", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "resultsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "getResultsLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "resultsPaginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "searchKeyword", "", "searchRequestDisposable", "Lio/reactivex/disposables/Disposable;", "searchKeywordChanged", "", "newSearchKeyword", "searchTags", "storeTagToLocal", "tag", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.tag_search.TagSearchResultsViewModel */
/* compiled from: TagSearchResultsViewModel.kt */
public final class TagSearchResultsViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData;
    private final MemesRepository repository;
    private final SingleLiveEvent<AdapterUpdate<TagSearchResult>> resultsLiveData;
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo resultsPaginationInfo;
    private String searchKeyword;
    /* access modifiers changed from: private */
    public Disposable searchRequestDisposable;
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;

    public static final /* synthetic */ Disposable access$getSearchRequestDisposable$p(TagSearchResultsViewModel tagSearchResultsViewModel) {
        Disposable disposable = tagSearchResultsViewModel.searchRequestDisposable;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRequestDisposable");
        }
        return disposable;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TagSearchResultsViewModel(MemesRepository memesRepository, StorageRepository storageRepository2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(memesRepository, (i & 2) != 0 ? null : storageRepository2);
    }

    public TagSearchResultsViewModel(MemesRepository memesRepository, StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(memesRepository, "repository");
        this.repository = memesRepository;
        this.storageRepository = storageRepository2;
        this.resultsLiveData = new SingleLiveEvent<>();
        this.contentVisibilityLiveData = new MutableLiveData<>();
    }

    public final SingleLiveEvent<AdapterUpdate<TagSearchResult>> getResultsLiveData() {
        return this.resultsLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final void searchKeywordChanged(String str) {
        this.searchKeyword = str;
        this.resultsPaginationInfo = null;
    }

    public final void searchTags() {
        if (this.searchRequestDisposable != null) {
            Disposable disposable = this.searchRequestDisposable;
            if (disposable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchRequestDisposable");
            }
            if (!disposable.isDisposed()) {
                Disposable disposable2 = this.searchRequestDisposable;
                if (disposable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchRequestDisposable");
                }
                disposable2.dispose();
                showContent(this.contentVisibilityLiveData);
            }
        }
        if (this.searchKeyword == null) {
            this.resultsLiveData.setValue(null);
            return;
        }
        PageBasedPaginationInfo pageBasedPaginationInfo = this.resultsPaginationInfo;
        if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
            PageBasedPaginationInfo pageBasedPaginationInfo2 = this.resultsPaginationInfo;
            int currentPage = pageBasedPaginationInfo2 != null ? pageBasedPaginationInfo2.getCurrentPage() : 0;
            if (currentPage == 0) {
                BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
            }
            ExploreSearchRequest exploreSearchRequest = new ExploreSearchRequest();
            exploreSearchRequest.setKeyword(this.searchKeyword);
            exploreSearchRequest.setCatalogueType(ExploreSearchType.TAGS);
            exploreSearchRequest.setPage(currentPage + 1);
            this.repository.searchTags(exploreSearchRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new TagSearchResultsViewModel$searchTags$2(this, currentPage));
        }
    }

    public final void storeTagToLocal(String str) {
        if (this.storageRepository != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TagSearchResultsViewModel$storeTagToLocal$1(this, str, (Continuation) null), 3, (Object) null);
        }
    }
}
