package editor.optionsui.layerpaint.gradient;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.databinding.NGradientValueItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.optionsui.layerpaint.LayerPaint;
import editor.util.DrawableUtil;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J!\u0010\u001e\u001a\u00020\u00152\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0 \"\u00020\nH\u0002¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8DX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Leditor/optionsui/layerpaint/gradient/GradientsAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "context", "Landroid/content/Context;", "callback", "Leditor/optionsui/layerpaint/gradient/GradientsAdapter$Callback;", "(Landroid/content/Context;Leditor/optionsui/layerpaint/gradient/GradientsAdapter$Callback;)V", "gradientDrawablesMap", "Ljava/util/HashMap;", "", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "selectedPaintId", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshGradientsById", "paintIds", "", "([Ljava/lang/String;)V", "setSelectedGradient", "paint", "Leditor/optionsui/layerpaint/LayerPaint;", "Callback", "GradientViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GradientsAdapter.kt */
public class GradientsAdapter extends NicoRecyclerAdapter<LayerPaint.Gradient> {
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final HashMap<String, Drawable> gradientDrawablesMap = new HashMap<>();
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new GradientsAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public String selectedPaintId;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/optionsui/layerpaint/gradient/GradientsAdapter$Callback;", "", "onGradientSelected", "", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: GradientsAdapter.kt */
    public interface Callback {
        void onGradientSelected(LayerPaint.Gradient gradient);
    }

    /* access modifiers changed from: protected */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public GradientsAdapter(Context context2, Callback callback2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NGradientValueItemBinding inflate = NGradientValueItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NGradientValueItemBindin…tInflater, parent, false)");
        return new GradientViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof GradientViewHolder) {
            ((GradientViewHolder) viewHolder).setItem((LayerPaint.Gradient) getItemAt(i));
        }
    }

    public final void setSelectedGradient(LayerPaint layerPaint) {
        String str = this.selectedPaintId;
        String id = layerPaint instanceof LayerPaint.Gradient ? layerPaint.getId() : null;
        this.selectedPaintId = id;
        if (str == null) {
            if (id != null) {
                refreshGradientsById(id);
            }
        } else if (id == null) {
            refreshGradientsById(str);
        } else {
            refreshGradientsById(str, id);
        }
    }

    private final void refreshGradientsById(String... strArr) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (ArraysKt.contains((T[]) strArr, ((LayerPaint.Gradient) getItemAt(i)).getId())) {
                notifyItemChanged(i);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Leditor/optionsui/layerpaint/gradient/GradientsAdapter$GradientViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NGradientValueItemBinding;", "(Leditor/optionsui/layerpaint/gradient/GradientsAdapter;Lcom/memes/editor/databinding/NGradientValueItemBinding;)V", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Gradient;", "loadGradient", "", "setItem", "setSelected", "selected", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: GradientsAdapter.kt */
    public final class GradientViewHolder extends RecyclerView.ViewHolder {
        private final NGradientValueItemBinding binding;
        /* access modifiers changed from: private */
        public LayerPaint.Gradient paint;
        final /* synthetic */ GradientsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GradientViewHolder(GradientsAdapter gradientsAdapter, NGradientValueItemBinding nGradientValueItemBinding) {
            super(nGradientValueItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nGradientValueItemBinding, "binding");
            this.this$0 = gradientsAdapter;
            this.binding = nGradientValueItemBinding;
            nGradientValueItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ GradientViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.callback.onGradientSelected(GradientViewHolder.access$getPaint$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ LayerPaint.Gradient access$getPaint$p(GradientViewHolder gradientViewHolder) {
            LayerPaint.Gradient gradient = gradientViewHolder.paint;
            if (gradient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            return gradient;
        }

        public final void setItem(LayerPaint.Gradient gradient) {
            Intrinsics.checkNotNullParameter(gradient, "paint");
            this.paint = gradient;
            loadGradient();
            setSelected(Intrinsics.areEqual((Object) gradient.getId(), (Object) this.this$0.selectedPaintId));
        }

        private final void loadGradient() {
            Drawable drawable;
            LayerPaint.Gradient gradient = this.paint;
            if (gradient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            String id = gradient.getId();
            if (!this.this$0.gradientDrawablesMap.containsKey(id) || (drawable = (Drawable) this.this$0.gradientDrawablesMap.get(id)) == null) {
                DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
                LayerPaint.Gradient gradient2 = this.paint;
                if (gradient2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                }
                Drawable createDrawable = drawableUtil.createDrawable(gradient2);
                this.this$0.gradientDrawablesMap.put(id, createDrawable);
                ImageView imageView = this.binding.gradientImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.gradientImageView");
                imageView.setBackground(createDrawable);
                return;
            }
            ImageView imageView2 = this.binding.gradientImageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.gradientImageView");
            imageView2.setBackground(drawable);
        }

        private final void setSelected(boolean z) {
            if (z) {
                ImageView imageView = this.binding.gradientImageView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.gradientImageView");
                imageView.setAlpha(0.4f);
                View view = this.binding.gradientSelectionView;
                Intrinsics.checkNotNullExpressionValue(view, "binding.gradientSelectionView");
                view.setVisibility(0);
                return;
            }
            ImageView imageView2 = this.binding.gradientImageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.gradientImageView");
            imageView2.setAlpha(1.0f);
            View view2 = this.binding.gradientSelectionView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.gradientSelectionView");
            view2.setVisibility(8);
        }
    }
}
