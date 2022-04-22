package com.memes.plus.p040ui.explore_search.people_search;

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
import com.memes.plus.p040ui.explore_search.people_search.suggestions.CatalogueSuggestedPerson;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.RecentlySearchedPerson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.reactivex.android.schedulers.AndroidSchedulers;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u001eH\u0002J\u0006\u0010#\u001a\u00020\u001eJ\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u0015J\u0006\u0010,\u001a\u00020\u001eJ\b\u0010-\u001a\u00020\u001eH\u0002R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsViewModel;", "Lcom/memes/plus/base/BaseRxJavaViewModel;", "memesRepository", "Lcom/memes/plus/data/source/memes/MemesRepository;", "storageRepository", "Lcom/memes/plus/data/storage/StorageRepository;", "(Lcom/memes/plus/data/source/memes/MemesRepository;Lcom/memes/plus/data/storage/StorageRepository;)V", "contentVisibilityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "getContentVisibilityLiveData", "()Landroidx/lifecycle/MutableLiveData;", "resultsLiveData", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "getResultsLiveData", "()Lcom/memes/commons/util/SingleLiveEvent;", "resultsPaginationInfo", "Lcom/memes/plus/data/mapped_response/PageBasedPaginationInfo;", "searchKeyword", "", "searchRequestDisposable", "Lio/reactivex/disposables/Disposable;", "shouldShowSuggestedUsers", "", "suggestedPeopleDisposable", "suggestedUsers", "", "addRecentlySearchedUser", "", "peopleSearchResult", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "disableSuggestedUsers", "disposeImmediateDisposables", "fetchSuggestedPeople", "removeRecentlySearchedPerson", "removedSearchedPerson", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/RecentlySearchedPerson;", "removeSuggestedPerson", "removedSuggestedPerson", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/CatalogueSuggestedPerson;", "searchKeywordChanged", "newSearchKeyword", "searchPeople", "showSuggestedUsers", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsViewModel */
/* compiled from: PeopleSearchResultsViewModel.kt */
public final class PeopleSearchResultsViewModel extends BaseRxJavaViewModel {
    private final MutableLiveData<ContentVisibilityAction> contentVisibilityLiveData = new MutableLiveData<>();
    private final MemesRepository memesRepository;
    private final SingleLiveEvent<AdapterUpdate<CatalogueSearchResult>> resultsLiveData = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo resultsPaginationInfo;
    private String searchKeyword;
    /* access modifiers changed from: private */
    public Disposable searchRequestDisposable;
    private boolean shouldShowSuggestedUsers = true;
    /* access modifiers changed from: private */
    public final StorageRepository storageRepository;
    /* access modifiers changed from: private */
    public Disposable suggestedPeopleDisposable;
    /* access modifiers changed from: private */
    public List<CatalogueSearchResult> suggestedUsers = new ArrayList();

    public static final /* synthetic */ Disposable access$getSearchRequestDisposable$p(PeopleSearchResultsViewModel peopleSearchResultsViewModel) {
        Disposable disposable = peopleSearchResultsViewModel.searchRequestDisposable;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchRequestDisposable");
        }
        return disposable;
    }

    public static final /* synthetic */ Disposable access$getSuggestedPeopleDisposable$p(PeopleSearchResultsViewModel peopleSearchResultsViewModel) {
        Disposable disposable = peopleSearchResultsViewModel.suggestedPeopleDisposable;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestedPeopleDisposable");
        }
        return disposable;
    }

    public PeopleSearchResultsViewModel(MemesRepository memesRepository2, StorageRepository storageRepository2) {
        Intrinsics.checkNotNullParameter(memesRepository2, "memesRepository");
        Intrinsics.checkNotNullParameter(storageRepository2, "storageRepository");
        this.memesRepository = memesRepository2;
        this.storageRepository = storageRepository2;
    }

    public final SingleLiveEvent<AdapterUpdate<CatalogueSearchResult>> getResultsLiveData() {
        return this.resultsLiveData;
    }

    public final MutableLiveData<ContentVisibilityAction> getContentVisibilityLiveData() {
        return this.contentVisibilityLiveData;
    }

    public final void searchKeywordChanged(String str) {
        this.searchKeyword = str;
        this.resultsPaginationInfo = null;
    }

    public final void disableSuggestedUsers() {
        this.shouldShowSuggestedUsers = false;
    }

    public final void searchPeople() {
        disposeImmediateDisposables();
        if (this.searchKeyword != null) {
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
                this.memesRepository.searchPeople(exploreSearchRequest).observeOn(AndroidSchedulers.mainThread()).subscribe(new PeopleSearchResultsViewModel$searchPeople$1(this, currentPage));
            }
        } else if (this.shouldShowSuggestedUsers) {
            fetchSuggestedPeople();
        } else {
            this.resultsLiveData.setValue(null);
            this.resultsPaginationInfo = null;
            showContent(this.contentVisibilityLiveData);
        }
    }

    public final void fetchSuggestedPeople() {
        disposeImmediateDisposables();
        Collection collection = this.suggestedUsers;
        if (!(collection == null || collection.isEmpty())) {
            showSuggestedUsers();
            return;
        }
        BaseViewModel.showProgress$default(this, this.contentVisibilityLiveData, (String) null, 2, (Object) null);
        this.memesRepository.fetchSuggestedUsers().observeOn(AndroidSchedulers.mainThread()).subscribe(new PeopleSearchResultsViewModel$fetchSuggestedPeople$1(this));
    }

    public final void addRecentlySearchedUser(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PeopleSearchResultsViewModel$addRecentlySearchedUser$1(this, peopleSearchResult, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showSuggestedUsers() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PeopleSearchResultsViewModel$showSuggestedUsers$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void removeSuggestedPerson(CatalogueSuggestedPerson catalogueSuggestedPerson) {
        Intrinsics.checkNotNullParameter(catalogueSuggestedPerson, "removedSuggestedPerson");
        Collection collection = this.suggestedUsers;
        int i = 0;
        if (!(collection == null || collection.isEmpty())) {
            Iterator it = this.suggestedUsers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CatalogueSearchResult catalogueSearchResult = (CatalogueSearchResult) it.next();
                if ((catalogueSearchResult instanceof CatalogueSuggestedPerson) && Intrinsics.areEqual((Object) ((CatalogueSuggestedPerson) catalogueSearchResult).getId(), (Object) catalogueSuggestedPerson.getId())) {
                    this.suggestedUsers.remove(i);
                    break;
                }
                i++;
            }
            if (this.suggestedUsers.size() == 0) {
                this.suggestedUsers.clear();
                showSuggestedUsers();
            }
        }
    }

    public final void removeRecentlySearchedPerson(RecentlySearchedPerson recentlySearchedPerson) {
        Intrinsics.checkNotNullParameter(recentlySearchedPerson, "removedSearchedPerson");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PeopleSearchResultsViewModel$removeRecentlySearchedPerson$1(this, recentlySearchedPerson, (Continuation) null), 3, (Object) null);
    }

    private final void disposeImmediateDisposables() {
        PeopleSearchResultsViewModel peopleSearchResultsViewModel = this;
        if (peopleSearchResultsViewModel.searchRequestDisposable != null) {
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
        if (peopleSearchResultsViewModel.suggestedPeopleDisposable != null) {
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
