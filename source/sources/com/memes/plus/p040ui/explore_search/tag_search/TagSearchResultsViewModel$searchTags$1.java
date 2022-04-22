package com.memes.plus.p040ui.explore_search.tag_search;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import p015io.reactivex.disposables.Disposable;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.tag_search.TagSearchResultsViewModel$searchTags$1 */
/* compiled from: TagSearchResultsViewModel.kt */
final /* synthetic */ class TagSearchResultsViewModel$searchTags$1 extends MutablePropertyReference0Impl {
    TagSearchResultsViewModel$searchTags$1(TagSearchResultsViewModel tagSearchResultsViewModel) {
        super(tagSearchResultsViewModel, TagSearchResultsViewModel.class, "searchRequestDisposable", "getSearchRequestDisposable()Lio/reactivex/disposables/Disposable;", 0);
    }

    public Object get() {
        return TagSearchResultsViewModel.access$getSearchRequestDisposable$p((TagSearchResultsViewModel) this.receiver);
    }

    public void set(Object obj) {
        ((TagSearchResultsViewModel) this.receiver).searchRequestDisposable = (Disposable) obj;
    }
}
