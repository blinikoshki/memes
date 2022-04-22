package editor.optionsui.layerpaint.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NColorValueItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.optionsui.layerpaint.LayerPaint;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000234B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\tH\u0016J\u0018\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0016J!\u0010,\u001a\u00020$2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0.\"\u00020\"H\u0002¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u000102R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8DX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8DX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\t8DX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000bR\u001b\u0010\u0016\u001a\u00020\t8DX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0017\u0010\u000bR\u001b\u0010\u0019\u001a\u00020\u001a8DX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001a8DX\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b\u001f\u0010\u001cR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo26107d2 = {"Leditor/optionsui/layerpaint/color/ColorsAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "context", "Landroid/content/Context;", "callback", "Leditor/optionsui/layerpaint/color/ColorsAdapter$Callback;", "(Landroid/content/Context;Leditor/optionsui/layerpaint/color/ColorsAdapter$Callback;)V", "colorItemMargin", "", "getColorItemMargin", "()I", "colorItemMargin$delegate", "Lkotlin/Lazy;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "normalColorItemHeight", "getNormalColorItemHeight", "normalColorItemHeight$delegate", "selectedColorItemHeight", "getSelectedColorItemHeight", "selectedColorItemHeight$delegate", "selectedItemElevation", "", "getSelectedItemElevation", "()F", "selectedItemElevation$delegate", "selectedItemIconElevation", "getSelectedItemIconElevation", "selectedItemIconElevation$delegate", "selectedPaintId", "", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshColorsById", "paintIds", "", "([Ljava/lang/String;)V", "setSelectedColor", "paint", "Leditor/optionsui/layerpaint/LayerPaint;", "Callback", "ColorViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ColorsAdapter.kt */
public class ColorsAdapter extends NicoRecyclerAdapter<LayerPaint.Color> {
    /* access modifiers changed from: private */
    public final Callback callback;
    private final Lazy colorItemMargin$delegate = LazyKt.lazy(new ColorsAdapter$colorItemMargin$2(this));
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new ColorsAdapter$layoutInflater$2(this));
    private final Lazy normalColorItemHeight$delegate = LazyKt.lazy(new ColorsAdapter$normalColorItemHeight$2(this));
    private final Lazy selectedColorItemHeight$delegate = LazyKt.lazy(new ColorsAdapter$selectedColorItemHeight$2(this));
    private final Lazy selectedItemElevation$delegate = LazyKt.lazy(new ColorsAdapter$selectedItemElevation$2(this));
    private final Lazy selectedItemIconElevation$delegate = LazyKt.lazy(new ColorsAdapter$selectedItemIconElevation$2(this));
    /* access modifiers changed from: private */
    public String selectedPaintId;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Leditor/optionsui/layerpaint/color/ColorsAdapter$Callback;", "", "onColorSelected", "", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "onCustomizeColorPaintSelected", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ColorsAdapter.kt */
    public interface Callback {
        void onColorSelected(LayerPaint.Color color);

        void onCustomizeColorPaintSelected(LayerPaint.Color color);
    }

    /* access modifiers changed from: protected */
    public final int getColorItemMargin() {
        return ((Number) this.colorItemMargin$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: protected */
    public final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final int getNormalColorItemHeight() {
        return ((Number) this.normalColorItemHeight$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: protected */
    public final int getSelectedColorItemHeight() {
        return ((Number) this.selectedColorItemHeight$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: protected */
    public final float getSelectedItemElevation() {
        return ((Number) this.selectedItemElevation$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: protected */
    public final float getSelectedItemIconElevation() {
        return ((Number) this.selectedItemIconElevation$delegate.getValue()).floatValue();
    }

    public ColorsAdapter(Context context2, Callback callback2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        NColorValueItemBinding inflate = NColorValueItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NColorValueItemBinding\n\t…tInflater, parent, false)");
        return new ColorViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ColorViewHolder) {
            ((ColorViewHolder) viewHolder).setItem((LayerPaint.Color) getItemAt(i));
        }
    }

    public final void setSelectedColor(LayerPaint layerPaint) {
        String str = this.selectedPaintId;
        String id = layerPaint instanceof LayerPaint.Color ? layerPaint.getId() : null;
        this.selectedPaintId = id;
        if (str == null) {
            if (id != null) {
                refreshColorsById(id);
            }
        } else if (id == null) {
            refreshColorsById(str);
        } else {
            refreshColorsById(str, id);
        }
    }

    private final void refreshColorsById(String... strArr) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (ArraysKt.contains((T[]) strArr, ((LayerPaint.Color) getItemAt(i)).getId())) {
                notifyItemChanged(i);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/optionsui/layerpaint/color/ColorsAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NColorValueItemBinding;", "(Leditor/optionsui/layerpaint/color/ColorsAdapter;Lcom/memes/editor/databinding/NColorValueItemBinding;)V", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "setItem", "", "showNormalItem", "showSelectedItem", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ColorsAdapter.kt */
    public final class ColorViewHolder extends RecyclerView.ViewHolder {
        private final NColorValueItemBinding binding;
        /* access modifiers changed from: private */
        public LayerPaint.Color paint;
        final /* synthetic */ ColorsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ColorViewHolder(ColorsAdapter colorsAdapter, NColorValueItemBinding nColorValueItemBinding) {
            super(nColorValueItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nColorValueItemBinding, "binding");
            this.this$0 = colorsAdapter;
            this.binding = nColorValueItemBinding;
            nColorValueItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ ColorViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    if (Intrinsics.areEqual((Object) ColorViewHolder.access$getPaint$p(this.this$0).getId(), (Object) this.this$0.this$0.selectedPaintId)) {
                        this.this$0.this$0.callback.onCustomizeColorPaintSelected(ColorViewHolder.access$getPaint$p(this.this$0));
                    } else {
                        this.this$0.this$0.callback.onColorSelected(ColorViewHolder.access$getPaint$p(this.this$0));
                    }
                }
            });
        }

        public static final /* synthetic */ LayerPaint.Color access$getPaint$p(ColorViewHolder colorViewHolder) {
            LayerPaint.Color color = colorViewHolder.paint;
            if (color == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            return color;
        }

        public final void setItem(LayerPaint.Color color) {
            Intrinsics.checkNotNullParameter(color, "paint");
            this.paint = color;
            if (Intrinsics.areEqual((Object) color.getId(), (Object) this.this$0.selectedPaintId)) {
                showSelectedItem();
            } else {
                showNormalItem();
            }
        }

        private final void showNormalItem() {
            ConstraintLayout root = this.binding.getRoot();
            LayerPaint.Color color = this.paint;
            if (color == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            root.setBackgroundColor(color.colorInt());
            ConstraintLayout root2 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.setBackgroundTintList((ColorStateList) null);
            ViewCompat.setElevation(this.binding.getRoot(), 0.0f);
            ViewCompat.setElevation(this.binding.customizeColorView, 0.0f);
            ImageView imageView = this.binding.customizeColorView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.customizeColorView");
            imageView.setVisibility(8);
            ConstraintLayout root3 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            View view = root3;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            RecyclerView.LayoutParams layoutParams3 = (RecyclerView.LayoutParams) layoutParams2;
            layoutParams3.height = this.this$0.getNormalColorItemHeight();
            layoutParams3.setMargins(0, this.this$0.getColorItemMargin(), 0, this.this$0.getColorItemMargin());
            view.setLayoutParams(layoutParams2);
        }

        private final void showSelectedItem() {
            this.binding.getRoot().setBackgroundResource(C4175R.C4178drawable.n_selected_color_value_shape);
            ConstraintLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            LayerPaint.Color color = this.paint;
            if (color == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            root.setBackgroundTintList(ColorStateList.valueOf(color.colorInt()));
            ViewCompat.setElevation(this.binding.getRoot(), this.this$0.getSelectedItemElevation());
            ViewCompat.setElevation(this.binding.customizeColorView, this.this$0.getSelectedItemIconElevation());
            ImageView imageView = this.binding.customizeColorView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.customizeColorView");
            imageView.setVisibility(0);
            ConstraintLayout root2 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            View view = root2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            RecyclerView.LayoutParams layoutParams3 = (RecyclerView.LayoutParams) layoutParams2;
            layoutParams3.height = this.this$0.getSelectedColorItemHeight();
            layoutParams3.setMargins(0, 0, 0, 0);
            view.setLayoutParams(layoutParams2);
        }
    }
}
