package com.memes.plus.p040ui.create_post.captionsuggestions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.custom.picasso_plus.CircleTransformation;
import com.memes.plus.databinding.CatalogueSearchPeopleItemBinding;
import com.memes.plus.databinding.CatalogueSearchTagItemBinding;
import com.memes.plus.p040ui.create_post.captionsuggestions.CaptionTagSuggestion;
import com.memes.plus.util.picasso.PicassoExtKt;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00152\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0004\u0014\u0015\u0016\u0017B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter$Callback;", "(Landroid/content/Context;Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter$Callback;)V", "circleTransformation", "Lcom/memes/plus/custom/picasso_plus/CircleTransformation;", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemViewType", "position", "Callback", "Companion", "HashTagSuggestionViewHolder", "PeopleSuggestionViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter */
/* compiled from: CaptionTagSuggestionsAdapter.kt */
public final class CaptionTagSuggestionsAdapter extends BaseRecyclerAdapter<CaptionTagSuggestion, BaseViewHolder<CaptionTagSuggestion>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TYPE_HASH_TAG_SUGGESTION = 3457;
    private static final int TYPE_PEOPLE_SUGGESTION = 3456;
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public final CircleTransformation circleTransformation = new CircleTransformation();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter$Callback;", "", "onCaptionTagSuggestionTapped", "", "suggestion", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter$Callback */
    /* compiled from: CaptionTagSuggestionsAdapter.kt */
    public interface Callback {
        void onCaptionTagSuggestionTapped(CaptionTagSuggestion captionTagSuggestion);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptionTagSuggestionsAdapter(Context context, Callback callback2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter$Companion;", "", "()V", "TYPE_HASH_TAG_SUGGESTION", "", "TYPE_PEOPLE_SUGGESTION", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter$Companion */
    /* compiled from: CaptionTagSuggestionsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseViewHolder<CaptionTagSuggestion> createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == TYPE_PEOPLE_SUGGESTION) {
            CatalogueSearchPeopleItemBinding inflate = CatalogueSearchPeopleItemBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "CatalogueSearchPeopleIte…(inflater, parent, false)");
            return new PeopleSuggestionViewHolder(this, inflate);
        } else if (i == TYPE_HASH_TAG_SUGGESTION) {
            CatalogueSearchTagItemBinding inflate2 = CatalogueSearchTagItemBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "CatalogueSearchTagItemBi…(inflater, parent, false)");
            return new HashTagSuggestionViewHolder(this, inflate2);
        } else {
            throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public int getItemViewType(int i) {
        CaptionTagSuggestion captionTagSuggestion = (CaptionTagSuggestion) getItemAt(i);
        if (captionTagSuggestion instanceof CaptionTagSuggestion.PeopleSuggestion) {
            return TYPE_PEOPLE_SUGGESTION;
        }
        if (captionTagSuggestion instanceof CaptionTagSuggestion.HashTagSuggestion) {
            return TYPE_HASH_TAG_SUGGESTION;
        }
        return super.getItemViewType(i);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter$PeopleSuggestionViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion;", "binding", "Lcom/memes/plus/databinding/CatalogueSearchPeopleItemBinding;", "(Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter;Lcom/memes/plus/databinding/CatalogueSearchPeopleItemBinding;)V", "suggestion", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion$PeopleSuggestion;", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter$PeopleSuggestionViewHolder */
    /* compiled from: CaptionTagSuggestionsAdapter.kt */
    public final class PeopleSuggestionViewHolder extends BaseViewHolder<CaptionTagSuggestion> {
        private final CatalogueSearchPeopleItemBinding binding;
        /* access modifiers changed from: private */
        public CaptionTagSuggestion.PeopleSuggestion suggestion;
        final /* synthetic */ CaptionTagSuggestionsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PeopleSuggestionViewHolder(com.memes.plus.p040ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter r2, com.memes.plus.databinding.CatalogueSearchPeopleItemBinding r3) {
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
                com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter$PeopleSuggestionViewHolder$1 r3 = new com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter$PeopleSuggestionViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter.PeopleSuggestionViewHolder.<init>(com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter, com.memes.plus.databinding.CatalogueSearchPeopleItemBinding):void");
        }

        public static final /* synthetic */ CaptionTagSuggestion.PeopleSuggestion access$getSuggestion$p(PeopleSuggestionViewHolder peopleSuggestionViewHolder) {
            CaptionTagSuggestion.PeopleSuggestion peopleSuggestion = peopleSuggestionViewHolder.suggestion;
            if (peopleSuggestion == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            return peopleSuggestion;
        }

        public void setItem(CaptionTagSuggestion captionTagSuggestion) {
            Intrinsics.checkNotNullParameter(captionTagSuggestion, "item");
            this.suggestion = (CaptionTagSuggestion.PeopleSuggestion) captionTagSuggestion;
            TextView textView = this.binding.searchResultPersonNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.searchResultPersonNameTextView");
            CaptionTagSuggestion.PeopleSuggestion peopleSuggestion = this.suggestion;
            if (peopleSuggestion == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            textView.setText(peopleSuggestion.getUserName());
            TextView textView2 = this.binding.searchResultPersonFollowersTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.searchResultPersonFollowersTextView");
            CaptionTagSuggestion.PeopleSuggestion peopleSuggestion2 = this.suggestion;
            if (peopleSuggestion2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            textView2.setText(peopleSuggestion2.getFullName());
            UserAvatarView userAvatarView = this.binding.searchResultPersonImageView;
            CaptionTagSuggestion.PeopleSuggestion peopleSuggestion3 = this.suggestion;
            if (peopleSuggestion3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            UserAvatarView.loadUrl$default(userAvatarView, peopleSuggestion3.getProfileImageThumbUrl(), C4199R.C4202drawable.placeholder_profile, (Integer) null, 4, (Object) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter$HashTagSuggestionViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion;", "binding", "Lcom/memes/plus/databinding/CatalogueSearchTagItemBinding;", "(Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestionsAdapter;Lcom/memes/plus/databinding/CatalogueSearchTagItemBinding;)V", "suggestion", "Lcom/memes/plus/ui/create_post/captionsuggestions/CaptionTagSuggestion$HashTagSuggestion;", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter$HashTagSuggestionViewHolder */
    /* compiled from: CaptionTagSuggestionsAdapter.kt */
    public final class HashTagSuggestionViewHolder extends BaseViewHolder<CaptionTagSuggestion> {
        private final CatalogueSearchTagItemBinding binding;
        /* access modifiers changed from: private */
        public CaptionTagSuggestion.HashTagSuggestion suggestion;
        final /* synthetic */ CaptionTagSuggestionsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public HashTagSuggestionViewHolder(com.memes.plus.p040ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter r2, com.memes.plus.databinding.CatalogueSearchTagItemBinding r3) {
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
                com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter$HashTagSuggestionViewHolder$1 r3 = new com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter$HashTagSuggestionViewHolder$1
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter.HashTagSuggestionViewHolder.<init>(com.memes.plus.ui.create_post.captionsuggestions.CaptionTagSuggestionsAdapter, com.memes.plus.databinding.CatalogueSearchTagItemBinding):void");
        }

        public static final /* synthetic */ CaptionTagSuggestion.HashTagSuggestion access$getSuggestion$p(HashTagSuggestionViewHolder hashTagSuggestionViewHolder) {
            CaptionTagSuggestion.HashTagSuggestion hashTagSuggestion = hashTagSuggestionViewHolder.suggestion;
            if (hashTagSuggestion == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            return hashTagSuggestion;
        }

        public void setItem(CaptionTagSuggestion captionTagSuggestion) {
            Intrinsics.checkNotNullParameter(captionTagSuggestion, "item");
            this.suggestion = (CaptionTagSuggestion.HashTagSuggestion) captionTagSuggestion;
            TextView textView = this.binding.searchResultTagNameTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.searchResultTagNameTextView");
            CaptionTagSuggestion.HashTagSuggestion hashTagSuggestion = this.suggestion;
            if (hashTagSuggestion == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            textView.setText(hashTagSuggestion.getTagName());
            TextView textView2 = this.binding.searchResultTagPostsTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.searchResultTagPostsTextView");
            CaptionTagSuggestionsAdapter captionTagSuggestionsAdapter = this.this$0;
            Object[] objArr = new Object[1];
            CaptionTagSuggestion.HashTagSuggestion hashTagSuggestion2 = this.suggestion;
            if (hashTagSuggestion2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestion");
            }
            objArr[0] = hashTagSuggestion2.getTotalPostsCount();
            textView2.setText(captionTagSuggestionsAdapter.getString(C4199R.string.format_posts_count, objArr));
            Picasso picasso = Picasso.get();
            Intrinsics.checkNotNullExpressionValue(picasso, "Picasso.get()");
            PicassoExtKt.log$default(picasso, (Object) this, "drawable/ic_hashtag", (String) null, 4, (Object) null).load((int) C4199R.C4202drawable.ic_hashtag).transform((Transformation) this.this$0.circleTransformation).into(this.binding.searchResultTagImageView);
        }
    }
}
