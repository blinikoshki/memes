package editor.optionsui.text.textpaint;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NColorValueItemBinding;
import editor.editor.equipment.text.TextConfig;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.color.ColorsAdapter;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo26107d2 = {"Leditor/optionsui/text/textpaint/TextPaintsAdapter;", "Leditor/optionsui/layerpaint/color/ColorsAdapter;", "context", "Landroid/content/Context;", "callback", "Leditor/optionsui/layerpaint/color/ColorsAdapter$Callback;", "(Landroid/content/Context;Leditor/optionsui/layerpaint/color/ColorsAdapter$Callback;)V", "getCallback", "()Leditor/optionsui/layerpaint/color/ColorsAdapter$Callback;", "getContext", "()Landroid/content/Context;", "selectionTarget", "Leditor/optionsui/text/textpaint/TextPaintSelectionTarget;", "transparentColorIndex", "", "transparentColorPaint", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "changeSelectionTarget", "", "getItemViewType", "position", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeTransparentPaintChoice", "showTransparentPaintChoice", "Companion", "TransparentTextPaintViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextPaintsAdapter.kt */
public final class TextPaintsAdapter extends ColorsAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_TRANSPARENT_PAINT = 581;
    private final ColorsAdapter.Callback callback;
    private final Context context;
    private TextPaintSelectionTarget selectionTarget = TextPaintSelectionTarget.FONT;
    private final int transparentColorIndex;
    private final LayerPaint.Color transparentColorPaint = new LayerPaint.Color(TextConfig.DEFAULT_BACKGROUND_COLOR);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextPaintSelectionTarget.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TextPaintSelectionTarget.FONT.ordinal()] = 1;
            iArr[TextPaintSelectionTarget.BACKGROUND.ordinal()] = 2;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final ColorsAdapter.Callback getCallback() {
        return this.callback;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextPaintsAdapter(Context context2, ColorsAdapter.Callback callback2) {
        super(context2, callback2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/text/textpaint/TextPaintsAdapter$Companion;", "", "()V", "TYPE_TRANSPARENT_PAINT", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextPaintsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i != 581) {
            return super.onCreateViewHolder(viewGroup, i);
        }
        NColorValueItemBinding inflate = NColorValueItemBinding.inflate(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "NColorValueItemBinding\n …tInflater, parent, false)");
        return new TransparentTextPaintViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof TransparentTextPaintViewHolder) {
            ((TransparentTextPaintViewHolder) viewHolder).setItem((LayerPaint.Color) getItemAt(i));
        } else if (viewHolder instanceof ColorsAdapter.ColorViewHolder) {
            ((ColorsAdapter.ColorViewHolder) viewHolder).setItem((LayerPaint.Color) getItemAt(i));
        }
    }

    public int getItemViewType(int i) {
        if (i != this.transparentColorIndex || !Intrinsics.areEqual((Object) (LayerPaint.Color) getItemAt(i), (Object) this.transparentColorPaint)) {
            return super.getItemViewType(i);
        }
        return TYPE_TRANSPARENT_PAINT;
    }

    public final void changeSelectionTarget(TextPaintSelectionTarget textPaintSelectionTarget) {
        Intrinsics.checkNotNullParameter(textPaintSelectionTarget, "selectionTarget");
        this.selectionTarget = textPaintSelectionTarget;
        int i = WhenMappings.$EnumSwitchMapping$0[textPaintSelectionTarget.ordinal()];
        if (i == 1) {
            removeTransparentPaintChoice();
        } else if (i == 2) {
            showTransparentPaintChoice();
        }
    }

    private final void showTransparentPaintChoice() {
        if (!Intrinsics.areEqual((Object) (LayerPaint.Color) getItemAt(this.transparentColorIndex), (Object) this.transparentColorPaint)) {
            addItemAt(this.transparentColorIndex, this.transparentColorPaint);
        }
    }

    private final void removeTransparentPaintChoice() {
        if (Intrinsics.areEqual((Object) (LayerPaint.Color) getItemAt(this.transparentColorIndex), (Object) this.transparentColorPaint)) {
            removeItemAt(this.transparentColorIndex);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/optionsui/text/textpaint/TextPaintsAdapter$TransparentTextPaintViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NColorValueItemBinding;", "(Leditor/optionsui/text/textpaint/TextPaintsAdapter;Lcom/memes/editor/databinding/NColorValueItemBinding;)V", "paint", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "setItem", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: TextPaintsAdapter.kt */
    public final class TransparentTextPaintViewHolder extends RecyclerView.ViewHolder {
        private final NColorValueItemBinding binding;
        /* access modifiers changed from: private */
        public LayerPaint.Color paint;
        final /* synthetic */ TextPaintsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransparentTextPaintViewHolder(TextPaintsAdapter textPaintsAdapter, NColorValueItemBinding nColorValueItemBinding) {
            super(nColorValueItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nColorValueItemBinding, "binding");
            this.this$0 = textPaintsAdapter;
            this.binding = nColorValueItemBinding;
            nColorValueItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ TransparentTextPaintViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.getCallback().onColorSelected(TransparentTextPaintViewHolder.access$getPaint$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ LayerPaint.Color access$getPaint$p(TransparentTextPaintViewHolder transparentTextPaintViewHolder) {
            LayerPaint.Color color = transparentTextPaintViewHolder.paint;
            if (color == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
            }
            return color;
        }

        public final void setItem(LayerPaint.Color color) {
            Intrinsics.checkNotNullParameter(color, "paint");
            this.paint = color;
            this.binding.getRoot().setBackgroundResource(C4175R.C4178drawable.n_selected_color_value_shape);
            ConstraintLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setBackgroundTintList(ColorStateList.valueOf(-1));
            this.binding.customizeColorView.setImageResource(C4175R.C4178drawable.icon_circle_ban);
            ConstraintLayout root2 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            View view = root2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            RecyclerView.LayoutParams layoutParams3 = (RecyclerView.LayoutParams) layoutParams2;
            layoutParams3.height = this.this$0.getNormalColorItemHeight();
            layoutParams3.setMargins(0, this.this$0.getColorItemMargin(), this.this$0.getColorItemMargin() * 2, this.this$0.getColorItemMargin());
            view.setLayoutParams(layoutParams2);
        }
    }
}
