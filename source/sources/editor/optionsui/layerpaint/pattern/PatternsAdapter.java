package editor.optionsui.layerpaint.pattern;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.databinding.NPatternValueItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.optionsui.layerpaint.LayerPaint;
import editor.util.DrawableUtil;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J!\u0010\u001e\u001a\u00020\u00152\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100 \"\u00020\u0010H\u0002¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8DX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Leditor/optionsui/layerpaint/pattern/PatternsAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "context", "Landroid/content/Context;", "callback", "Leditor/optionsui/layerpaint/pattern/PatternsAdapter$Callback;", "(Landroid/content/Context;Leditor/optionsui/layerpaint/pattern/PatternsAdapter$Callback;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "patternDrawablesMap", "Ljava/util/HashMap;", "", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;", "selectedPaintId", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshPatternsById", "paintIds", "", "([Ljava/lang/String;)V", "setSelectedPattern", "paint", "Leditor/optionsui/layerpaint/LayerPaint;", "Callback", "PatternViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PatternsAdapter.kt */
public class PatternsAdapter extends NicoRecyclerAdapter<LayerPaint.Pattern> {
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new PatternsAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public final HashMap<String, Drawable> patternDrawablesMap = new HashMap<>();
    /* access modifiers changed from: private */
    public String selectedPaintId;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/optionsui/layerpaint/pattern/PatternsAdapter$Callback;", "", "onPatternSelected", "", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: PatternsAdapter.kt */
    public interface Callback {
        void onPatternSelected(LayerPaint.Pattern pattern);
    }

    /* access modifiers changed from: protected */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public PatternsAdapter(Context context2, Callback callback2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NPatternValueItemBinding inflate = NPatternValueItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NPatternValueItemBinding…tInflater, parent, false)");
        return new PatternViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof PatternViewHolder) {
            ((PatternViewHolder) viewHolder).setItem((LayerPaint.Pattern) getItemAt(i));
        }
    }

    public final void setSelectedPattern(LayerPaint layerPaint) {
        String str = this.selectedPaintId;
        String id = layerPaint instanceof LayerPaint.Pattern ? layerPaint.getId() : null;
        this.selectedPaintId = id;
        if (str == null) {
            if (id != null) {
                refreshPatternsById(id);
            }
        } else if (id == null) {
            refreshPatternsById(str);
        } else {
            refreshPatternsById(str, id);
        }
    }

    private final void refreshPatternsById(String... strArr) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (ArraysKt.contains((T[]) strArr, ((LayerPaint.Pattern) getItemAt(i)).getId())) {
                notifyItemChanged(i);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Leditor/optionsui/layerpaint/pattern/PatternsAdapter$PatternViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NPatternValueItemBinding;", "(Leditor/optionsui/layerpaint/pattern/PatternsAdapter;Lcom/memes/editor/databinding/NPatternValueItemBinding;)V", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Pattern;", "loadPattern", "", "setItem", "setSelected", "selected", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: PatternsAdapter.kt */
    public final class PatternViewHolder extends RecyclerView.ViewHolder {
        private final NPatternValueItemBinding binding;
        /* access modifiers changed from: private */
        public LayerPaint.Pattern paint;
        final /* synthetic */ PatternsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PatternViewHolder(PatternsAdapter patternsAdapter, NPatternValueItemBinding nPatternValueItemBinding) {
            super(nPatternValueItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nPatternValueItemBinding, "binding");
            this.this$0 = patternsAdapter;
            this.binding = nPatternValueItemBinding;
            nPatternValueItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ PatternViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.callback.onPatternSelected(PatternViewHolder.access$getPaint$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ LayerPaint.Pattern access$getPaint$p(PatternViewHolder patternViewHolder) {
            LayerPaint.Pattern pattern = patternViewHolder.paint;
            if (pattern == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            return pattern;
        }

        public final void setItem(LayerPaint.Pattern pattern) {
            Intrinsics.checkNotNullParameter(pattern, "paint");
            this.paint = pattern;
            loadPattern();
            setSelected(Intrinsics.areEqual((Object) pattern.getId(), (Object) this.this$0.selectedPaintId));
        }

        private final void loadPattern() {
            Drawable drawable;
            LayerPaint.Pattern pattern = this.paint;
            if (pattern == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            String id = pattern.getId();
            if (!this.this$0.patternDrawablesMap.containsKey(id) || (drawable = (Drawable) this.this$0.patternDrawablesMap.get(id)) == null) {
                DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
                Context access$getContext$p = this.this$0.context;
                LayerPaint.Pattern pattern2 = this.paint;
                if (pattern2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                }
                Drawable createDrawable = drawableUtil.createDrawable(access$getContext$p, pattern2);
                this.this$0.patternDrawablesMap.put(id, createDrawable);
                this.binding.patternImageView.setImageDrawable(createDrawable);
                return;
            }
            this.binding.patternImageView.setImageDrawable(drawable);
        }

        private final void setSelected(boolean z) {
            if (z) {
                ImageView imageView = this.binding.patternImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.patternImageView");
                imageView.setAlpha(0.4f);
                View view = this.binding.patternSelectionView;
                Intrinsics.checkNotNullExpressionValue(view, "binding.patternSelectionView");
                view.setVisibility(0);
                return;
            }
            ImageView imageView2 = this.binding.patternImageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.patternImageView");
            imageView2.setAlpha(1.0f);
            View view2 = this.binding.patternSelectionView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.patternSelectionView");
            view2.setVisibility(8);
        }
    }
}
