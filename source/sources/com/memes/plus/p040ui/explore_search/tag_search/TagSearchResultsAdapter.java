package com.memes.plus.p040ui.explore_search.tag_search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.C4199R;
import com.memes.plus.custom.picasso_plus.CircleTransformation;
import com.memes.plus.databinding.CatalogueSearchTagItemBinding;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapter$TagSearchResultViewHolder;", "context", "Landroid/content/Context;", "adapterListener", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapterListener;", "(Landroid/content/Context;Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapterListener;)V", "circleTransformation", "Lcom/memes/plus/custom/picasso_plus/CircleTransformation;", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "TagSearchResultViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.explore_search.tag_search.TagSearchResultsAdapter */
/* compiled from: TagSearchResultsAdapter.kt */
public final class TagSearchResultsAdapter extends BaseRecyclerAdapter<TagSearchResult, TagSearchResultViewHolder> {
    /* access modifiers changed from: private */
    public final TagSearchResultsAdapterListener adapterListener;
    /* access modifiers changed from: private */
    public final CircleTransformation circleTransformation = new CircleTransformation();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TagSearchResultsAdapter(Context context, TagSearchResultsAdapterListener tagSearchResultsAdapterListener) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tagSearchResultsAdapterListener, "adapterListener");
        this.adapterListener = tagSearchResultsAdapterListener;
    }

    public TagSearchResultViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        CatalogueSearchTagItemBinding inflate = CatalogueSearchTagItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "CatalogueSearchTagItemBi…(inflater, parent, false)");
        return new TagSearchResultViewHolder(this, inflate);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapter$TagSearchResultViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResult;", "binding", "Lcom/memes/plus/databinding/CatalogueSearchTagItemBinding;", "(Lcom/memes/plus/ui/explore_search/tag_search/TagSearchResultsAdapter;Lcom/memes/plus/databinding/CatalogueSearchTagItemBinding;)V", "tagSearchResult", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.explore_search.tag_search.TagSearchResultsAdapter$TagSearchResultViewHolder */
    /* compiled from: TagSearchResultsAdapter.kt */
    public final class TagSearchResultViewHolder extends BaseViewHolder<TagSearchResult> {
        private final CatalogueSearchTagItemBinding binding;
        /* access modifiers changed from: private */
        public TagSearchResult tagSearchResult;
        final /* synthetic */ TagSearchResultsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TagSearchResultViewHolder(com.memes.plus.p040ui.explore_search.tag_search.TagSearchResultsAdapter r2, com.memes.plus.databinding.CatalogueSearchTagItemBinding r3) {
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
                com.memes.plus.ui.explore_search.tag_search.TagSearchResultsAdapter$TagSearchResultViewHolder$1 r3 = new com.memes.plus.ui.explore_search.tag_search.TagSearchResultsAdapter$TagSearchResultViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.explore_search.tag_search.TagSearchResultsAdapter.TagSearchResultViewHolder.<init>(com.memes.plus.ui.explore_search.tag_search.TagSearchResultsAdapter, com.memes.plus.databinding.CatalogueSearchTagItemBinding):void");
        }

        public static final /* synthetic */ TagSearchResult access$getTagSearchResult$p(TagSearchResultViewHolder tagSearchResultViewHolder) {
            TagSearchResult tagSearchResult2 = tagSearchResultViewHolder.tagSearchResult;
            if (tagSearchResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagSearchResult");
            }
            return tagSearchResult2;
        }

        public void setItem(TagSearchResult tagSearchResult2) {
            Intrinsics.checkNotNullParameter(tagSearchResult2, "item");
            this.tagSearchResult = tagSearchResult2;
            TextView textView = this.binding.searchResultTagNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.searchResultTagNameTextView");
            TagSearchResult tagSearchResult3 = this.tagSearchResult;
            if (tagSearchResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagSearchResult");
            }
            textView.setText(tagSearchResult3.getTagName());
            TextView textView2 = this.binding.searchResultTagPostsTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.searchResultTagPostsTextView");
            TagSearchResultsAdapter tagSearchResultsAdapter = this.this$0;
            Object[] objArr = new Object[1];
            TagSearchResult tagSearchResult4 = this.tagSearchResult;
            if (tagSearchResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagSearchResult");
            }
            objArr[0] = tagSearchResult4.getTotalPostsCount();
            textView2.setText(tagSearchResultsAdapter.getString(C4199R.string.format_posts_count, objArr));
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            PicassoExtKt.log$default(picasso, (Object) this, "drawable/ic_hashtag", (String) null, 4, (Object) null).load((int) C4199R.C4202drawable.ic_hashtag).transform((Transformation) this.this$0.circleTransformation).into(this.binding.searchResultTagImageView);
        }
    }
}
