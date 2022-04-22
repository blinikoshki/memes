package com.memes.plus.p040ui.explore_search.people_search;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsViewModel$disposeImmediateDisposables$1 */
/* compiled from: PeopleSearchResultsViewModel.kt */
final /* synthetic */ class PeopleSearchResultsViewModel$disposeImmediateDisposables$1 extends MutablePropertyReference0Impl {
    PeopleSearchResultsViewModel$disposeImmediateDisposables$1(PeopleSearchResultsViewModel peopleSearchResultsViewModel) {
        super(peopleSearchResultsViewModel, PeopleSearchResultsViewModel.class, "searchRequestDisposable", "getSearchRequestDisposable()Lio/reactivex/disposables/Disposable;", 0);
    }

    public Object get() {
        return PeopleSearchResultsViewModel.access$getSearchRequestDisposable$p((PeopleSearchResultsViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((PeopleSearchResultsViewModel) this.receiver).searchRequestDisposable = (Disposable) obj;
    }
}
