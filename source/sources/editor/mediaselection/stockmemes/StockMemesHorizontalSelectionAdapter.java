package editor.mediaselection.stockmemes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.editor.databinding.NMediaSelectionCategoryItemBinding;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import editor.mediaselection.BaseMediaCategoryAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aBO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012@\u0010\u0005\u001a<\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\u0002`\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¨\u0006\u001b"}, mo26107d2 = {"Leditor/mediaselection/stockmemes/StockMemesHorizontalSelectionAdapter;", "Leditor/mediaselection/BaseMediaCategoryAdapter;", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "context", "Landroid/content/Context;", "itemSelectionCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "", "selected", "Leditor/mediaselection/ItemSelectedCallback;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "getItemId", "", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "StockMemeViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StockMemesHorizontalSelectionAdapter.kt */
public final class StockMemesHorizontalSelectionAdapter extends BaseMediaCategoryAdapter<StockMeme> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StockMemesHorizontalSelectionAdapter(Context context, Function2<? super StockMeme, ? super Boolean, Boolean> function2) {
        super(context, function2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function2, "itemSelectionCallback");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NMediaSelectionCategoryItemBinding inflate = NMediaSelectionCategoryItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaSelectionCategoryI…,\n\t\t\tparent,\n\t\t\tfalse\n\t\t)");
        return new StockMemeViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof StockMemeViewHolder) {
            ((StockMemeViewHolder) viewHolder).setItem((StockMeme) getItemAt(i));
        }
    }

    public String getItemId(StockMeme stockMeme) {
        Intrinsics.checkNotNullParameter(stockMeme, "item");
        return stockMeme.getIdentifier();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Leditor/mediaselection/stockmemes/StockMemesHorizontalSelectionAdapter$StockMemeViewHolder;", "Leditor/mediaselection/BaseMediaCategoryAdapter$BaseMediaCategoryItemViewHolder;", "Leditor/mediaselection/BaseMediaCategoryAdapter;", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "binding", "Lcom/memes/editor/databinding/NMediaSelectionCategoryItemBinding;", "(Leditor/mediaselection/stockmemes/StockMemesHorizontalSelectionAdapter;Lcom/memes/editor/databinding/NMediaSelectionCategoryItemBinding;)V", "stockMeme", "cleanup", "", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "getItem", "onSelectionIndicatorVisibilityChanged", "isVisible", "", "setItem", "item", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: StockMemesHorizontalSelectionAdapter.kt */
    private final class StockMemeViewHolder extends BaseMediaCategoryAdapter<StockMeme>.BaseMediaCategoryItemViewHolder {
        private final NMediaSelectionCategoryItemBinding binding;
        private StockMeme stockMeme;
        final /* synthetic */ StockMemesHorizontalSelectionAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public StockMemeViewHolder(editor.mediaselection.stockmemes.StockMemesHorizontalSelectionAdapter r3, com.memes.editor.databinding.NMediaSelectionCategoryItemBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.this$0 = r3
                com.memes.commons.aspectratio.AspectRatioFrameLayout r0 = r4.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.view.View r0 = (android.view.View) r0
                r2.<init>(r3, r0)
                r2.binding = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.stockmemes.StockMemesHorizontalSelectionAdapter.StockMemeViewHolder.<init>(editor.mediaselection.stockmemes.StockMemesHorizontalSelectionAdapter, com.memes.editor.databinding.NMediaSelectionCategoryItemBinding):void");
        }

        public StockMeme getItem() {
            StockMeme stockMeme2 = this.stockMeme;
            if (stockMeme2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stockMeme");
            }
            return stockMeme2;
        }

        public void onSelectionIndicatorVisibilityChanged(boolean z) {
            if (z) {
                View view = this.binding.selectionIndicator;
                Intrinsics.checkNotNullExpressionValue(view, "binding.selectionIndicator");
                view.setVisibility(0);
                return;
            }
            View view2 = this.binding.selectionIndicator;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.selectionIndicator");
            view2.setVisibility(8);
        }

        public void setItem(StockMeme stockMeme2) {
            Intrinsics.checkNotNullParameter(stockMeme2, "item");
            this.stockMeme = stockMeme2;
            AspectRatioFrameLayout aspectRatioFrameLayout = this.binding.aspectRatioFrameLayout;
            StockMeme stockMeme3 = this.stockMeme;
            if (stockMeme3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stockMeme");
            }
            aspectRatioFrameLayout.setAspectRatio(stockMeme3.aspectRatio());
            RequestManager access$getGlideRequestManager = this.this$0.getGlideRequestManager();
            StockMeme stockMeme4 = this.stockMeme;
            if (stockMeme4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stockMeme");
            }
            ((RequestBuilder) ((RequestBuilder) access$getGlideRequestManager.load(stockMeme4.absoluteThumbUrl()).diskCacheStrategy(DiskCacheStrategy.DATA)).skipMemoryCache(true)).into(this.binding.imageView);
            super.setItem(stockMeme2);
        }

        public void cleanup(RequestManager requestManager) {
            Intrinsics.checkNotNullParameter(requestManager, "glideRequestManager");
            requestManager.clear((View) this.binding.imageView);
        }
    }
}
