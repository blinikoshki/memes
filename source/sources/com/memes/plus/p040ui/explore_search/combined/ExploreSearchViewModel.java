package com.memes.plus.p040ui.explore_search.combined;

import androidx.lifecycle.MutableLiveData;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.plus.base.BaseRxJavaViewModel;
import com.memes.plus.data.mapped_response.PageBasedPaginationInfo;
import com.memes.plus.data.source.memes.MemesRepository;
import com.memes.plus.p040ui.explore_search.ExploreSearchRequest;
import com.memes.plus.p040ui.explore_search.ExploreSearchType;
import com.memes.plus.p040ui.explore_search.people_search.CatalogueSearchResult;
import com.memes.plus.p040ui.explore_search.tag_search.TagSearchResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.android.schedulers.AndroidSchedulers;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/combined/ExploreSearchViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "memesRepository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;)V", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "resultTagSearchLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "getResultTagSearchLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "resultsLiveData", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "getResultsLiveData", "resultsPaginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "searchKeyword", "", "searchRequestDisposable", "Lio/reactivex/disposables/Disposable;", "suggestedPeopleDisposable", "disposeImmediateDisposables", "", "search", "type", "searchKeywordChanged", "newSearchKeyword", "searchPeople", "searchTags", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.combined.ExploreSearchViewModel */
/* compiled from: ExploreSearchViewModel.kt */
public final class ExploreSearchViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private final MemesRepository memesRepository;
    private final SingleLiveEvent<AdapterUpdate<TagSearchResult>> resultTagSearchLiveData = new SingleLiveEvent<>();
    private final SingleLiveEvent<AdapterUpdate<CatalogueSearchResult>> resultsLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo resultsPaginationInfo;
    private String searchKeyword;
    /* access modifiers changed from: private */
    public Disposable searchRequestDisposable;
    /* access modifiers changed from: private */
    public Disposable suggestedPeopleDisposable;

    public static final /* synthetic */ Disposable access$getSearchRequestDisposable$p(ExploreSearchViewModel exploreSearchViewModel) {
        Disposable disposable = exploreSearchViewModel.searchRequestDisposable;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRequestDisposable");
        }
        return disposable;
    }

    public static final /* synthetic */ Disposable access$getSuggestedPeopleDisposable$p(ExploreSearchViewModel exploreSearchViewModel) {
        Disposable disposable = exploreSearchViewModel.suggestedPeopleDisposable;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestedPeopleDisposable");
        }
        return disposable;
    }

    public ExploreSearchViewModel(MemesRepository memesRepository2) {
        Intrinsics.checkNotNullParameter(memesRepository2, "memesRepository");
        this.memesRepository = memesRepository2;
    }

    public final SingleLiveEvent<AdapterUpdate<CatalogueSearchResult>> getResultsLiveData() {
        return this.resultsLiveData;
    }

    public final SingleLiveEvent<AdapterUpdate<TagSearchResult>> getResultTagSearchLiveData() {
        return this.resultTagSearchLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final void searchKeywordChanged(String str) {
        this.searchKeyword = str;
        this.resultsPaginationInfo = null;
    }

    public static /* synthetic */ void search$default(ExploreSearchViewModel exploreSearchViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ExploreSearchType.PEOPLE;
        }
        exploreSearchViewModel.search(str);
    }

    public final void search(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        int hashCode = str.hashCode();
        if (hashCode != -991808881) {
            if (hashCode == 3552281 && str.equals(ExploreSearchType.TAGS)) {
                searchTags();
            }
        } else if (str.equals(ExploreSearchType.PEOPLE)) {
            searchPeople();
        }
    }

    private final void searchPeople() {
        disposeImmediateDisposables();
        PageBasedPaginationInfo pageBasedPaginationInfo = this.resultsPaginationInfo;
        if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
            PageBasedPaginationInfo pageBasedPaginationInfo2 = this.resultsPaginationInfo;
            int currentPage = pageBasedPaginationInfo2 != null ? pageBasedPaginationInfo2.getCurrentPage() : 0;
            if (currentPage == 0) {
                BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
            }
            ExploreSearchRequest exploreSearchRequest = new ExploreSearchRequest();
            exploreSearchRequest.setKeyword(this.searchKeyword);
            exploreSearchRequest.setCatalogueType(ExploreSearchType.PEOPLE);
            exploreSearchRequest.setPage(currentPage + 1);
            this.memesRepository.searchPeople(exploreSearchRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new ExploreSearchViewModel$searchPeople$1(this, currentPage));
        }
    }

    private final void searchTags() {
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
            this.memesRepository.searchTags(exploreSearchRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new ExploreSearchViewModel$searchTags$2(this, currentPage));
        }
    }

    private final void disposeImmediateDisposables() {
        ExploreSearchViewModel exploreSearchViewModel = this;
        if (exploreSearchViewModel.searchRequestDisposable != null) {
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
            }
        }
        if (exploreSearchViewModel.suggestedPeopleDisposable != null) {
            Disposable disposable3 = this.suggestedPeopleDisposable;
            if (disposable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestedPeopleDisposable");
            }
            if (!disposable3.isDisposed()) {
                Disposable disposable4 = this.suggestedPeopleDisposable;
                if (disposable4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("suggestedPeopleDisposable");
                }
                disposable4.dispose();
            }
        }
    }
}
