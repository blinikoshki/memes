package editor.tools.crop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.databinding.NCropOptionDividerItemBinding;
import com.memes.editor.databinding.NCropOptionPreviewItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.tools.crop.CropOption;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0016J\u0006\u0010#\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo26107d2 = {"Leditor/tools/crop/CropOptionsAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/tools/crop/CropOption;", "context", "Landroid/content/Context;", "cropOptionSelected", "Lkotlin/Function1;", "Leditor/tools/crop/CropOption$Preview;", "Lkotlin/ParameterName;", "name", "cropPreview", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "cropPreviewMaxHeight", "", "getCropPreviewMaxHeight", "()I", "cropPreviewMaxHeight$delegate", "Lkotlin/Lazy;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "selectedPosition", "getItemViewType", "position", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetSelectedCropOption", "Companion", "CropPreviewViewHolder", "DividerViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CropOptionsAdapter.kt */
public final class CropOptionsAdapter extends NicoRecyclerAdapter<CropOption> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TYPE_DIVIDER = 157;
    private static final int TYPE_PREVIEW = 156;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public Function1<? super CropOption.Preview, Unit> cropOptionSelected;
    private final Lazy cropPreviewMaxHeight$delegate = LazyKt.lazy(new CropOptionsAdapter$cropPreviewMaxHeight$2(this));
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new CropOptionsAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public int selectedPosition;

    /* access modifiers changed from: private */
    public final int getCropPreviewMaxHeight() {
        return ((Number) this.cropPreviewMaxHeight$delegate.getValue()).intValue();
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public CropOptionsAdapter(Context context2, Function1<? super CropOption.Preview, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "cropOptionSelected");
        this.context = context2;
        this.cropOptionSelected = function1;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Leditor/tools/crop/CropOptionsAdapter$Companion;", "", "()V", "TYPE_DIVIDER", "", "TYPE_PREVIEW", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CropOptionsAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == TYPE_PREVIEW) {
            NCropOptionPreviewItemBinding inflate = NCropOptionPreviewItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "NCropOptionPreviewItemBi…tInflater, parent, false)");
            return new CropPreviewViewHolder(this, inflate);
        } else if (i == TYPE_DIVIDER) {
            NCropOptionDividerItemBinding inflate2 = NCropOptionDividerItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "NCropOptionDividerItemBi…tInflater, parent, false)");
            return new DividerViewHolder(this, inflate2);
        } else {
            throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof CropPreviewViewHolder) {
            Object itemAt = getItemAt(i);
            Objects.requireNonNull(itemAt, "null cannot be cast to non-null type editor.tools.crop.CropOption.Preview");
            ((CropPreviewViewHolder) viewHolder).setItem((CropOption.Preview) itemAt);
        }
    }

    public int getItemViewType(int i) {
        CropOption cropOption = (CropOption) getItemAt(i);
        if ((cropOption instanceof CropOption.Preview) || (cropOption instanceof CropOption.FreestylePreview)) {
            return TYPE_PREVIEW;
        }
        if (cropOption instanceof CropOption.Divider) {
            return TYPE_DIVIDER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void resetSelectedCropOption() {
        int i = this.selectedPosition;
        if (i == 0) {
            notifyItemChanged(i);
            return;
        }
        this.selectedPosition = 0;
        notifyItemChanged(i);
        notifyItemChanged(this.selectedPosition);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/tools/crop/CropOptionsAdapter$CropPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NCropOptionPreviewItemBinding;", "(Leditor/tools/crop/CropOptionsAdapter;Lcom/memes/editor/databinding/NCropOptionPreviewItemBinding;)V", "cropPreview", "Leditor/tools/crop/CropOption$Preview;", "setItem", "", "showIcon", "showSelection", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CropOptionsAdapter.kt */
    public final class CropPreviewViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final NCropOptionPreviewItemBinding binding;
        /* access modifiers changed from: private */
        public CropOption.Preview cropPreview;
        final /* synthetic */ CropOptionsAdapter this$0;

        private final void showIcon() {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CropPreviewViewHolder(CropOptionsAdapter cropOptionsAdapter, NCropOptionPreviewItemBinding nCropOptionPreviewItemBinding) {
            super(nCropOptionPreviewItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nCropOptionPreviewItemBinding, "binding");
            this.this$0 = cropOptionsAdapter;
            this.binding = nCropOptionPreviewItemBinding;
            nCropOptionPreviewItemBinding.background.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ CropPreviewViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    if (this.this$0.this$0.selectedPosition != this.this$0.getAdapterPosition()) {
                        this.this$0.this$0.notifyItemChanged(this.this$0.this$0.selectedPosition);
                        this.this$0.this$0.selectedPosition = this.this$0.getAdapterPosition();
                        this.this$0.showSelection();
                        CropOptionsAdapter cropOptionsAdapter = this.this$0.this$0;
                        ConstraintLayout root = this.this$0.binding.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        cropOptionsAdapter.scrollToCenterHorizontally(root);
                        this.this$0.this$0.cropOptionSelected.invoke(CropPreviewViewHolder.access$getCropPreview$p(this.this$0));
                    }
                }
            });
        }

        public static final /* synthetic */ CropOption.Preview access$getCropPreview$p(CropPreviewViewHolder cropPreviewViewHolder) {
            CropOption.Preview preview = cropPreviewViewHolder.cropPreview;
            if (preview == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropPreview");
            }
            return preview;
        }

        public final void setItem(CropOption.Preview preview) {
            Intrinsics.checkNotNullParameter(preview, "cropPreview");
            this.cropPreview = preview;
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setText(preview.toString());
            showIcon();
            View view = this.binding.background;
            Intrinsics.checkNotNullExpressionValue(view, "binding.background");
            view.getLayoutParams().width = MathKt.roundToInt(preview.ratio() * ((float) this.this$0.getCropPreviewMaxHeight()));
            showSelection();
        }

        /* access modifiers changed from: private */
        public final void showSelection() {
            boolean z = this.this$0.selectedPosition == getAdapterPosition();
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setSelected(z);
            ImageView imageView = this.binding.iconImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconImageView");
            imageView.setSelected(z);
            View view = this.binding.background;
            Intrinsics.checkNotNullExpressionValue(view, "binding.background");
            view.setSelected(z);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/tools/crop/CropOptionsAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NCropOptionDividerItemBinding;", "(Leditor/tools/crop/CropOptionsAdapter;Lcom/memes/editor/databinding/NCropOptionDividerItemBinding;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: CropOptionsAdapter.kt */
    public final class DividerViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ CropOptionsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DividerViewHolder(CropOptionsAdapter cropOptionsAdapter, NCropOptionDividerItemBinding nCropOptionDividerItemBinding) {
            super(nCropOptionDividerItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nCropOptionDividerItemBinding, "binding");
            this.this$0 = cropOptionsAdapter;
        }
    }
}
