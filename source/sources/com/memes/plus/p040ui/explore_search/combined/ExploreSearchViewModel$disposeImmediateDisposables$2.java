package com.memes.plus.p040ui.explore_search.combined;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.combined.ExploreSearchViewModel$disposeImmediateDisposables$2 */
/* compiled from: ExploreSearchViewModel.kt */
final /* synthetic */ class ExploreSearchViewModel$disposeImmediateDisposables$2 extends MutablePropertyReference0Impl {
    ExploreSearchViewModel$disposeImmediateDisposables$2(ExploreSearchViewModel exploreSearchViewModel) {
        super(exploreSearchViewModel, ExploreSearchViewModel.class, "suggestedPeopleDisposable", "getSuggestedPeopleDisposable()Lio/reactivex/disposables/Disposable;", 0);
    }

    public Object get() {
        return ExploreSearchViewModel.access$getSuggestedPeopleDisposable$p((ExploreSearchViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((ExploreSearchViewModel) this.receiver).suggestedPeopleDisposable = (Disposable) obj;
    }
}
