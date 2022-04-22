package editor.mediaselection.paints;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import com.memes.commons.aspectratio.AspectRatioFrameLayout;
import com.memes.editor.databinding.NMediaSelectionCategoryItemBinding;
import editor.mediaselection.BaseMediaCategoryAdapter;
import editor.optionsui.layerpaint.LayerPaint;
import editor.util.DrawableUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eBO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012@\u0010\u0005\u001a<\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\u0002`\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo26107d2 = {"Leditor/mediaselection/paints/PatternsHorizontalSelectionAdapter;", "Leditor/mediaselection/BaseMediaCategoryAdapter;", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "context", "Landroid/content/Context;", "itemSelectionCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "", "selected", "Leditor/mediaselection/ItemSelectedCallback;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "patternDrawablesMap", "Ljava/util/HashMap;", "", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;", "getItemId", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PatternViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PatternsHorizontalSelectionAdapter.kt */
public final class PatternsHorizontalSelectionAdapter extends BaseMediaCategoryAdapter<LayerPaint.Pattern> {
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final HashMap<String, Drawable> patternDrawablesMap = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PatternsHorizontalSelectionAdapter(Context context2, Function2<? super LayerPaint.Pattern, ? super Boolean, Boolean> function2) {
        super(context2, function2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function2, "itemSelectionCallback");
        this.context = context2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NMediaSelectionCategoryItemBinding inflate = NMediaSelectionCategoryItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NMediaSelectionCategoryI…\t\t\tparent,\n\t\t\t\tfalse\n\t\t\t)");
        return new PatternViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof PatternViewHolder) {
            ((PatternViewHolder) viewHolder).setItem((LayerPaint.Pattern) getItemAt(i));
        }
    }

    public String getItemId(LayerPaint.Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "item");
        return pattern.getIdentifier();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo26107d2 = {"Leditor/mediaselection/paints/PatternsHorizontalSelectionAdapter$PatternViewHolder;", "Leditor/mediaselection/BaseMediaCategoryAdapter$BaseMediaCategoryItemViewHolder;", "Leditor/mediaselection/BaseMediaCategoryAdapter;", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "binding", "Lcom/memes/editor/databinding/NMediaSelectionCategoryItemBinding;", "(Leditor/mediaselection/paints/PatternsHorizontalSelectionAdapter;Lcom/memes/editor/databinding/NMediaSelectionCategoryItemBinding;)V", "pattern", "cleanup", "", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "getItem", "loadPattern", "onSelectionIndicatorVisibilityChanged", "isVisible", "", "setItem", "item", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: PatternsHorizontalSelectionAdapter.kt */
    private final class PatternViewHolder extends BaseMediaCategoryAdapter<LayerPaint.Pattern>.BaseMediaCategoryItemViewHolder {
        private final NMediaSelectionCategoryItemBinding binding;
        private LayerPaint.Pattern pattern;
        final /* synthetic */ PatternsHorizontalSelectionAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PatternViewHolder(editor.mediaselection.paints.PatternsHorizontalSelectionAdapter r3, com.memes.editor.databinding.NMediaSelectionCategoryItemBinding r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.paints.PatternsHorizontalSelectionAdapter.PatternViewHolder.<init>(editor.mediaselection.paints.PatternsHorizontalSelectionAdapter, com.memes.editor.databinding.NMediaSelectionCategoryItemBinding):void");
        }

        public LayerPaint.Pattern getItem() {
            LayerPaint.Pattern pattern2 = this.pattern;
            if (pattern2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pattern");
            }
            return pattern2;
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

        public void setItem(LayerPaint.Pattern pattern2) {
            Intrinsics.checkNotNullParameter(pattern2, "item");
            this.pattern = pattern2;
            AspectRatioFrameLayout aspectRatioFrameLayout = this.binding.aspectRatioFrameLayout;
            LayerPaint.Pattern pattern3 = this.pattern;
            if (pattern3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pattern");
            }
            aspectRatioFrameLayout.setAspectRatio(pattern3.aspectRatio());
            LayerPaint.Pattern pattern4 = this.pattern;
            if (pattern4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pattern");
            }
            loadPattern(pattern4);
            super.setItem(pattern2);
        }

        public void cleanup(RequestManager requestManager) {
            Intrinsics.checkNotNullParameter(requestManager, "glideRequestManager");
            requestManager.clear((View) this.binding.imageView);
        }

        private final void loadPattern(LayerPaint.Pattern pattern2) {
            Drawable drawable;
            String id = pattern2.getId();
            if (!this.this$0.patternDrawablesMap.containsKey(id) || (drawable = (Drawable) this.this$0.patternDrawablesMap.get(id)) == null) {
                Drawable createDrawable = DrawableUtil.INSTANCE.createDrawable(this.this$0.context, pattern2);
                this.this$0.patternDrawablesMap.put(id, createDrawable);
                this.binding.imageView.setImageDrawable(createDrawable);
                return;
            }
            this.binding.imageView.setImageDrawable(drawable);
        }
    }
}
