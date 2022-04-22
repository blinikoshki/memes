package com.memes.plus.p040ui.explore_search.people_search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.util.ExtensionsKt;
import com.memes.plus.App;
import com.memes.plus.base.ActivityHandle;
import com.memes.plus.base.BaseFragment;
import com.memes.plus.base.upgrades.Searchable;
import com.memes.plus.databinding.CatalogueSearchResultsFragmentBinding;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.CatalogueSuggestedPerson;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.RecentlySearchedPerson;
import com.memes.plus.p040ui.profile.ProfileFragmentProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001(B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8DX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsFragment;", "Lcom/memes/plus/base/BaseFragment;", "Lcom/memes/plus/databinding/CatalogueSearchResultsFragmentBinding;", "Lcom/memes/plus/base/upgrades/Searchable;", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultAdapterListener;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "peopleSearchResultsAdapter", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;", "viewModel", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsViewModel;", "getViewModel", "()Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "afterViewCreated", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onDestroy", "onObserversRequested", "onPeopleSearchResultTapped", "peopleSearchResult", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "onRemoveSuggestedPersonViewTapped", "search", "keyword", "", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsFragment */
/* compiled from: PeopleSearchResultsFragment.kt */
public class PeopleSearchResultsFragment extends BaseFragment<CatalogueSearchResultsFragmentBinding> implements Searchable, PeopleSearchResultAdapterListener, ContentLayout.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "PeopleSearchResultsFragment";
    private LinearLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public PeopleSearchResultsAdapter peopleSearchResultsAdapter;
    private final Lazy viewModel$delegate = LazyKt.lazy(new PeopleSearchResultsFragment$viewModel$2(this));

    /* access modifiers changed from: protected */
    public final PeopleSearchResultsViewModel getViewModel() {
        return (PeopleSearchResultsViewModel) this.viewModel$delegate.getValue();
    }

    public static final /* synthetic */ PeopleSearchResultsAdapter access$getPeopleSearchResultsAdapter$p(PeopleSearchResultsFragment peopleSearchResultsFragment) {
        PeopleSearchResultsAdapter peopleSearchResultsAdapter2 = peopleSearchResultsFragment.peopleSearchResultsAdapter;
        if (peopleSearchResultsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peopleSearchResultsAdapter");
        }
        return peopleSearchResultsAdapter2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsFragment$Companion;", "", "()V", "TAG", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsFragment$Companion */
    /* compiled from: PeopleSearchResultsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CatalogueSearchResultsFragmentBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        CatalogueSearchResultsFragmentBinding inflate = CatalogueSearchResultsFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "CatalogueSearchResultsFr…flater, container, false)");
        return inflate;
    }

    public void onBindingComplete(Bundle bundle) {
        ((CatalogueSearchResultsFragmentBinding) getBinding()).contentLayout.setCallback(this);
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = ((CatalogueSearchResultsFragmentBinding) getBinding()).searchResultsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "getBinding().searchResultsRecyclerView");
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        ((CatalogueSearchResultsFragmentBinding) getBinding()).searchResultsRecyclerView.clearOnScrollListeners();
        RecyclerView recyclerView2 = ((CatalogueSearchResultsFragmentBinding) getBinding()).searchResultsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "getBinding().searchResultsRecyclerView");
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        ExtensionsKt.addPaginator(recyclerView2, linearLayoutManager2, new PeopleSearchResultsFragment$onBindingComplete$1(this));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        PeopleSearchResultsAdapter peopleSearchResultsAdapter2 = new PeopleSearchResultsAdapter(requireContext, this);
        RecyclerView recyclerView3 = ((CatalogueSearchResultsFragmentBinding) getBinding()).searchResultsRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "getBinding().searchResultsRecyclerView");
        recyclerView3.setAdapter(peopleSearchResultsAdapter2);
        Unit unit = Unit.INSTANCE;
        this.peopleSearchResultsAdapter = peopleSearchResultsAdapter2;
    }

    public void onObserversRequested() {
        getActivityHandle().registerViewModel(getViewModel());
        getViewModel().getContentVisibilityLiveData().observe(getViewLifecycleOwner(), new PeopleSearchResultsFragment$onObserversRequested$1(this));
        getViewModel().getResultsLiveData().observe(getViewLifecycleOwner(), new PeopleSearchResultsFragment$onObserversRequested$2(this));
    }

    public void afterViewCreated() {
        PeopleSearchResultsAdapter peopleSearchResultsAdapter2 = this.peopleSearchResultsAdapter;
        if (peopleSearchResultsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peopleSearchResultsAdapter");
        }
        if (peopleSearchResultsAdapter2.hasNoPage()) {
            getViewModel().fetchSuggestedPeople();
        }
    }

    public void search(String str) {
        if (isAdded()) {
            getViewModel().searchKeywordChanged(str);
            getViewModel().searchPeople();
        }
    }

    public void onPeopleSearchResultTapped(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
        if (!(peopleSearchResult instanceof RecentlySearchedPerson) && !(peopleSearchResult instanceof CatalogueSuggestedPerson)) {
            getViewModel().addRecentlySearchedUser(peopleSearchResult);
        }
        getActivityHandle().popFragment();
        ActivityHandle.DefaultImpls.replaceFragment$default(getActivityHandle(), ProfileFragmentProxy.INSTANCE.newInstance(peopleSearchResult.getId(), peopleSearchResult.getUserName()), ProfileFragmentProxy.TAG, false, 4, (Object) null);
        App.Companion.trackingManager().onUserMentionTapped(peopleSearchResult.getUserName());
    }

    public void onRemoveSuggestedPersonViewTapped(PeopleSearchResult peopleSearchResult) {
        Intrinsics.checkNotNullParameter(peopleSearchResult, "peopleSearchResult");
        if (peopleSearchResult instanceof CatalogueSuggestedPerson) {
            getViewModel().removeSuggestedPerson((CatalogueSuggestedPerson) peopleSearchResult);
        } else if (peopleSearchResult instanceof RecentlySearchedPerson) {
            getViewModel().removeRecentlySearchedPerson((RecentlySearchedPerson) peopleSearchResult);
        }
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        ContentLayout contentLayout = ((CatalogueSearchResultsFragmentBinding) getBinding()).contentLayout;
        Intrinsics.checkNotNullExpressionValue(contentLayout, "getBinding().contentLayout");
        if (i == contentLayout.getId() && i2 == 1211) {
            getViewModel().searchPeople();
        } else {
            super.onContentLayoutErrorResolutionButtonTapped(i, i2);
        }
    }

    public void onDestroy() {
        BaseFragment baseFragment = this;
        if (baseFragment.hasBinding()) {
            ((CatalogueSearchResultsFragmentBinding) baseFragment.getBinding()).searchResultsRecyclerView.clearOnScrollListeners();
        } else {
            Timber.m303e("safeBinding() prevented a null-binding call.", new Object[0]);
        }
        super.onDestroy();
    }
}
