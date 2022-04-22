package com.memes.plus.p040ui.explore_search.people_search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.custom.picasso_plus.CircleTransformation;
import com.memes.plus.databinding.CatalogueRecentlySearchedPersonItemBinding;
import com.memes.plus.databinding.CatalogueSearchHeaderItemBinding;
import com.memes.plus.databinding.CatalogueSearchPeopleItemBinding;
import com.memes.plus.databinding.CatalogueSuggestedPersonItemBinding;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.CatalogueSuggestedPerson;
import com.memes.plus.p040ui.explore_search.people_search.suggestions.RecentlySearchedPerson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "context", "Landroid/content/Context;", "adapterListener", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultAdapterListener;", "(Landroid/content/Context;Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultAdapterListener;)V", "circleTransformation", "Lcom/memes/plus/custom/picasso_plus/CircleTransformation;", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemViewType", "position", "Companion", "ItemsHeaderViewHolder", "PeopleSearchResultViewHolder", "RecentlySearchedPersonViewHolder", "SuggestedPersonViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter */
/* compiled from: PeopleSearchResultsAdapter.kt */
public final class PeopleSearchResultsAdapter extends BaseRecyclerAdapter<CatalogueSearchResult, BaseViewHolder<CatalogueSearchResult>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_HEADER = 5684;
    public static final int TYPE_RECENTLY_SEARCHED_PERSON = 5686;
    public static final int TYPE_SEARCH_RESULT = 5687;
    public static final int TYPE_SUGGESTED_USER = 5685;
    /* access modifiers changed from: private */
    public final PeopleSearchResultAdapterListener adapterListener;
    private final CircleTransformation circleTransformation = new CircleTransformation();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeopleSearchResultsAdapter(Context context, PeopleSearchResultAdapterListener peopleSearchResultAdapterListener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(peopleSearchResultAdapterListener, "adapterListener");
        this.adapterListener = peopleSearchResultAdapterListener;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "TYPE_RECENTLY_SEARCHED_PERSON", "TYPE_SEARCH_RESULT", "TYPE_SUGGESTED_USER", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$Companion */
    /* compiled from: PeopleSearchResultsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseViewHolder<CatalogueSearchResult> createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        switch (i) {
            case TYPE_HEADER /*5684*/:
                CatalogueSearchHeaderItemBinding inflate = CatalogueSearchHeaderItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "CatalogueSearchHeaderIte…(inflater, parent, false)");
                return new ItemsHeaderViewHolder(this, inflate);
            case TYPE_SUGGESTED_USER /*5685*/:
                CatalogueSuggestedPersonItemBinding inflate2 = CatalogueSuggestedPersonItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "CatalogueSuggestedPerson…(inflater, parent, false)");
                return new SuggestedPersonViewHolder(this, inflate2);
            case TYPE_RECENTLY_SEARCHED_PERSON /*5686*/:
                CatalogueRecentlySearchedPersonItemBinding inflate3 = CatalogueRecentlySearchedPersonItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "CatalogueRecentlySearche…(inflater, parent, false)");
                return new RecentlySearchedPersonViewHolder(this, inflate3);
            case TYPE_SEARCH_RESULT /*5687*/:
                CatalogueSearchPeopleItemBinding inflate4 = CatalogueSearchPeopleItemBinding.inflate(layoutInflater, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate4, "CatalogueSearchPeopleIte…(inflater, parent, false)");
                return new PeopleSearchResultViewHolder(this, inflate4);
            default:
                throw new RuntimeException("Unknown View Type: " + i);
        }
    }

    public int getItemViewType(int i) {
        CatalogueSearchResult catalogueSearchResult = (CatalogueSearchResult) getItemAt(i);
        if (catalogueSearchResult instanceof CatalogueHeader) {
            return TYPE_HEADER;
        }
        if (catalogueSearchResult instanceof CatalogueSuggestedPerson) {
            return TYPE_SUGGESTED_USER;
        }
        if (catalogueSearchResult instanceof RecentlySearchedPerson) {
            return TYPE_RECENTLY_SEARCHED_PERSON;
        }
        if (catalogueSearchResult instanceof PeopleSearchResult) {
            return TYPE_SEARCH_RESULT;
        }
        return super.getItemViewType(i);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter$ItemsHeaderViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "binding", "Lcom/memes/plus/databinding/CatalogueSearchHeaderItemBinding;", "(Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;Lcom/memes/plus/databinding/CatalogueSearchHeaderItemBinding;)V", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$ItemsHeaderViewHolder */
    /* compiled from: PeopleSearchResultsAdapter.kt */
    public final class ItemsHeaderViewHolder extends BaseViewHolder<CatalogueSearchResult> {
        private final CatalogueSearchHeaderItemBinding binding;
        final /* synthetic */ PeopleSearchResultsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ItemsHeaderViewHolder(com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter r2, com.memes.plus.databinding.CatalogueSearchHeaderItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.TextView r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter.ItemsHeaderViewHolder.<init>(com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter, com.memes.plus.databinding.CatalogueSearchHeaderItemBinding):void");
        }

        public void setItem(CatalogueSearchResult catalogueSearchResult) {
            Intrinsics.checkNotNullParameter(catalogueSearchResult, "item");
            TextView textView = this.binding.headerTitleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.headerTitleTextView");
            textView.setText(((CatalogueHeader) catalogueSearchResult).getHeaderTitle());
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter$SuggestedPersonViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "binding", "Lcom/memes/plus/databinding/CatalogueSuggestedPersonItemBinding;", "(Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;Lcom/memes/plus/databinding/CatalogueSuggestedPersonItemBinding;)V", "suggestedPerson", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/CatalogueSuggestedPerson;", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$SuggestedPersonViewHolder */
    /* compiled from: PeopleSearchResultsAdapter.kt */
    public final class SuggestedPersonViewHolder extends BaseViewHolder<CatalogueSearchResult> {
        private final CatalogueSuggestedPersonItemBinding binding;
        /* access modifiers changed from: private */
        public CatalogueSuggestedPerson suggestedPerson;
        final /* synthetic */ PeopleSearchResultsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SuggestedPersonViewHolder(com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter r2, com.memes.plus.databinding.CatalogueSuggestedPersonItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.LinearLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.LinearLayout r2 = r3.getRoot()
                com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$SuggestedPersonViewHolder$1 r0 = new com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$SuggestedPersonViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.ImageView r2 = r3.personRemoveImageView
                com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$SuggestedPersonViewHolder$2 r3 = new com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$SuggestedPersonViewHolder$2
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter.SuggestedPersonViewHolder.<init>(com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter, com.memes.plus.databinding.CatalogueSuggestedPersonItemBinding):void");
        }

        public static final /* synthetic */ CatalogueSuggestedPerson access$getSuggestedPerson$p(SuggestedPersonViewHolder suggestedPersonViewHolder) {
            CatalogueSuggestedPerson catalogueSuggestedPerson = suggestedPersonViewHolder.suggestedPerson;
            if (catalogueSuggestedPerson == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestedPerson");
            }
            return catalogueSuggestedPerson;
        }

        public void setItem(CatalogueSearchResult catalogueSearchResult) {
            Intrinsics.checkNotNullParameter(catalogueSearchResult, "item");
            this.suggestedPerson = (CatalogueSuggestedPerson) catalogueSearchResult;
            TextView textView = this.binding.personNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.personNameTextView");
            CatalogueSuggestedPerson catalogueSuggestedPerson = this.suggestedPerson;
            if (catalogueSuggestedPerson == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestedPerson");
            }
            textView.setText(catalogueSuggestedPerson.getUserName());
            UserAvatarView userAvatarView = this.binding.personImageView;
            CatalogueSuggestedPerson catalogueSuggestedPerson2 = this.suggestedPerson;
            if (catalogueSuggestedPerson2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestedPerson");
            }
            userAvatarView.setProUser(catalogueSuggestedPerson2.isProUser());
            UserAvatarView userAvatarView2 = this.binding.personImageView;
            CatalogueSuggestedPerson catalogueSuggestedPerson3 = this.suggestedPerson;
            if (catalogueSuggestedPerson3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestedPerson");
            }
            UserAvatarView.loadUrl$default(userAvatarView2, catalogueSuggestedPerson3.getProfileImageThumbUrl(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter$RecentlySearchedPersonViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "binding", "Lcom/memes/plus/databinding/CatalogueRecentlySearchedPersonItemBinding;", "(Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;Lcom/memes/plus/databinding/CatalogueRecentlySearchedPersonItemBinding;)V", "searchedPerson", "Lcom/memes/plus/ui/explore_search/people_search/suggestions/RecentlySearchedPerson;", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$RecentlySearchedPersonViewHolder */
    /* compiled from: PeopleSearchResultsAdapter.kt */
    public final class RecentlySearchedPersonViewHolder extends BaseViewHolder<CatalogueSearchResult> {
        private final CatalogueRecentlySearchedPersonItemBinding binding;
        /* access modifiers changed from: private */
        public RecentlySearchedPerson searchedPerson;
        final /* synthetic */ PeopleSearchResultsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public RecentlySearchedPersonViewHolder(com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter r2, com.memes.plus.databinding.CatalogueRecentlySearchedPersonItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.LinearLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.LinearLayout r2 = r3.getRoot()
                com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$RecentlySearchedPersonViewHolder$1 r0 = new com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$RecentlySearchedPersonViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.ImageView r2 = r3.personRemoveImageView
                com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$RecentlySearchedPersonViewHolder$2 r3 = new com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$RecentlySearchedPersonViewHolder$2
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter.RecentlySearchedPersonViewHolder.<init>(com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter, com.memes.plus.databinding.CatalogueRecentlySearchedPersonItemBinding):void");
        }

        public static final /* synthetic */ RecentlySearchedPerson access$getSearchedPerson$p(RecentlySearchedPersonViewHolder recentlySearchedPersonViewHolder) {
            RecentlySearchedPerson recentlySearchedPerson = recentlySearchedPersonViewHolder.searchedPerson;
            if (recentlySearchedPerson == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchedPerson");
            }
            return recentlySearchedPerson;
        }

        public void setItem(CatalogueSearchResult catalogueSearchResult) {
            Intrinsics.checkNotNullParameter(catalogueSearchResult, "item");
            RecentlySearchedPerson recentlySearchedPerson = (RecentlySearchedPerson) catalogueSearchResult;
            this.searchedPerson = recentlySearchedPerson;
            TextView textView = this.binding.personNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.personNameTextView");
            RecentlySearchedPerson recentlySearchedPerson2 = this.searchedPerson;
            if (recentlySearchedPerson2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchedPerson");
            }
            textView.setText(recentlySearchedPerson2.getUserName());
            this.binding.personImageView.setProUser(recentlySearchedPerson.isProUser());
            UserAvatarView userAvatarView = this.binding.personImageView;
            RecentlySearchedPerson recentlySearchedPerson3 = this.searchedPerson;
            if (recentlySearchedPerson3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchedPerson");
            }
            UserAvatarView.loadUrl$default(userAvatarView, recentlySearchedPerson3.getProfileImageThumbUrl(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter$PeopleSearchResultViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/explore_search/people_search/CatalogueSearchResult;", "binding", "Lcom/memes/plus/databinding/CatalogueSearchPeopleItemBinding;", "(Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResultsAdapter;Lcom/memes/plus/databinding/CatalogueSearchPeopleItemBinding;)V", "peopleSearchResult", "Lcom/memes/plus/ui/explore_search/people_search/PeopleSearchResult;", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$PeopleSearchResultViewHolder */
    /* compiled from: PeopleSearchResultsAdapter.kt */
    public final class PeopleSearchResultViewHolder extends BaseViewHolder<CatalogueSearchResult> {
        private final CatalogueSearchPeopleItemBinding binding;
        /* access modifiers changed from: private */
        public PeopleSearchResult peopleSearchResult;
        final /* synthetic */ PeopleSearchResultsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PeopleSearchResultViewHolder(com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter r2, com.memes.plus.databinding.CatalogueSearchPeopleItemBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r1.this$0 = r2
                android.widget.LinearLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.view.View r2 = (android.view.View) r2
                r1.<init>(r2)
                r1.binding = r3
                android.widget.LinearLayout r2 = r3.getRoot()
                com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$PeopleSearchResultViewHolder$1 r3 = new com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter$PeopleSearchResultViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.explore_search.people_search.PeopleSearchResultsAdapter.PeopleSearchResultViewHolder.<init>(com.memes.plus.ui.explore_search.people_search.PeopleSearchResultsAdapter, com.memes.plus.databinding.CatalogueSearchPeopleItemBinding):void");
        }

        public static final /* synthetic */ PeopleSearchResult access$getPeopleSearchResult$p(PeopleSearchResultViewHolder peopleSearchResultViewHolder) {
            PeopleSearchResult peopleSearchResult2 = peopleSearchResultViewHolder.peopleSearchResult;
            if (peopleSearchResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peopleSearchResult");
            }
            return peopleSearchResult2;
        }

        public void setItem(CatalogueSearchResult catalogueSearchResult) {
            Intrinsics.checkNotNullParameter(catalogueSearchResult, "item");
            PeopleSearchResult peopleSearchResult2 = (PeopleSearchResult) catalogueSearchResult;
            this.peopleSearchResult = peopleSearchResult2;
            TextView textView = this.binding.searchResultPersonNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.searchResultPersonNameTextView");
            PeopleSearchResult peopleSearchResult3 = this.peopleSearchResult;
            if (peopleSearchResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peopleSearchResult");
            }
            textView.setText(peopleSearchResult3.getUserName());
            TextView textView2 = this.binding.searchResultPersonFollowersTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.searchResultPersonFollowersTextView");
            PeopleSearchResult peopleSearchResult4 = this.peopleSearchResult;
            if (peopleSearchResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peopleSearchResult");
            }
            textView2.setText(peopleSearchResult4.getFullName());
            this.binding.searchResultPersonImageView.setProUser(peopleSearchResult2.isProUser());
            UserAvatarView userAvatarView = this.binding.searchResultPersonImageView;
            PeopleSearchResult peopleSearchResult5 = this.peopleSearchResult;
            if (peopleSearchResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peopleSearchResult");
            }
            UserAvatarView.loadUrl$default(userAvatarView, peopleSearchResult5.getProfileImageThumbUrl(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        }
    }
}
