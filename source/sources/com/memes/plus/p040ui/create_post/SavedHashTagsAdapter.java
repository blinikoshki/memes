package com.memes.plus.p040ui.create_post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.memes.commons.recycleradapter.BaseRecyclerAdapter;
import com.memes.commons.recycleradapter.BaseViewHolder;
import com.memes.plus.databinding.SavedHashTagItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0010\u0011B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter;", "Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "", "Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter$HashTagViewHolder;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter$Callback;", "(Landroid/content/Context;Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter$Callback;)V", "createItemViewHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "Callback", "HashTagViewHolder", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.create_post.SavedHashTagsAdapter */
/* compiled from: SavedHashTagsAdapter.kt */
public final class SavedHashTagsAdapter extends BaseRecyclerAdapter<String, HashTagViewHolder> {
    /* access modifiers changed from: private */
    public final Callback callback;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter$Callback;", "", "onDeleteHashTagTapped", "", "hashTag", "", "onHashTagTapped", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.SavedHashTagsAdapter$Callback */
    /* compiled from: SavedHashTagsAdapter.kt */
    public interface Callback {
        void onDeleteHashTagTapped(String str);

        void onHashTagTapped(String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedHashTagsAdapter(Context context, Callback callback2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public HashTagViewHolder createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        SavedHashTagItemBinding inflate = SavedHashTagItemBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "SavedHashTagItemBinding.…(inflater, parent, false)");
        return new HashTagViewHolder(this, inflate);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter$HashTagViewHolder;", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "", "binding", "Lcom/memes/plus/databinding/SavedHashTagItemBinding;", "(Lcom/memes/plus/ui/create_post/SavedHashTagsAdapter;Lcom/memes/plus/databinding/SavedHashTagItemBinding;)V", "hashTag", "setItem", "", "item", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.create_post.SavedHashTagsAdapter$HashTagViewHolder */
    /* compiled from: SavedHashTagsAdapter.kt */
    public final class HashTagViewHolder extends BaseViewHolder<String> {
        private final SavedHashTagItemBinding binding;
        /* access modifiers changed from: private */
        public String hashTag;
        final /* synthetic */ SavedHashTagsAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public HashTagViewHolder(com.memes.plus.p040ui.create_post.SavedHashTagsAdapter r2, com.memes.plus.databinding.SavedHashTagItemBinding r3) {
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
                com.memes.plus.ui.create_post.SavedHashTagsAdapter$HashTagViewHolder$1 r0 = new com.memes.plus.ui.create_post.SavedHashTagsAdapter$HashTagViewHolder$1
                r0.<init>(r1)
                android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
                r2.setOnClickListener(r0)
                android.widget.ImageView r2 = r3.deleteImageView
                com.memes.plus.ui.create_post.SavedHashTagsAdapter$HashTagViewHolder$2 r3 = new com.memes.plus.ui.create_post.SavedHashTagsAdapter$HashTagViewHolder$2
                r3.<init>(r1)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r2.setOnClickListener(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.create_post.SavedHashTagsAdapter.HashTagViewHolder.<init>(com.memes.plus.ui.create_post.SavedHashTagsAdapter, com.memes.plus.databinding.SavedHashTagItemBinding):void");
        }

        public static final /* synthetic */ String access$getHashTag$p(HashTagViewHolder hashTagViewHolder) {
            String str = hashTagViewHolder.hashTag;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hashTag");
            }
            return str;
        }

        public void setItem(String str) {
            CharSequence charSequence;
            Intrinsics.checkNotNullParameter(str, "item");
            this.hashTag = str;
            TextView textView = this.binding.hashTagTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.hashTagTextView");
            if (StringsKt.startsWith$default(str, "#", false, 2, (Object) null)) {
                charSequence = str;
            } else {
                charSequence = '#' + str;
            }
            textView.setText(charSequence);
        }
    }
}
