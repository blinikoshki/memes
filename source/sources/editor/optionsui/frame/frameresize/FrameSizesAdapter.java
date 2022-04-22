package editor.optionsui.frame.frameresize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NResizeFrameDividerItemBinding;
import com.memes.editor.databinding.NResizeFramePreviewItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.optionsui.frame.frameresize.ResizeFrameItem;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\b\u0000\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003)*+B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000eH\u0016J\u0014\u0010$\u001a\u00020\u000b2\n\u0010%\u001a\u00020&\"\u00020\u001aH\u0002J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u001aR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/FrameSizesAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/frame/frameresize/ResizeFrameItem;", "context", "Landroid/content/Context;", "onFrameSizeSelected", "Lkotlin/Function1;", "Leditor/optionsui/frame/frameresize/FrameSize;", "Lkotlin/ParameterName;", "name", "frameSize", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "framePreviewMaxHeight", "", "getFramePreviewMaxHeight", "()I", "framePreviewMaxHeight$delegate", "Lkotlin/Lazy;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "selectedFrameRatio", "", "getItemViewType", "position", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshFramesByFrameRatio", "ratios", "", "setSelectedFrameRatio", "ratio", "Companion", "DividerViewHolder", "FrameSizeViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameSizesAdapter.kt */
public final class FrameSizesAdapter extends NicoRecyclerAdapter<ResizeFrameItem> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TYPE_DIVIDER = 157;
    private static final int TYPE_PREVIEW = 156;
    private final Lazy framePreviewMaxHeight$delegate;
    private final Lazy layoutInflater$delegate;
    /* access modifiers changed from: private */
    public final Function1<FrameSize, Unit> onFrameSizeSelected;
    /* access modifiers changed from: private */
    public float selectedFrameRatio = 1.0f;

    /* access modifiers changed from: private */
    public final int getFramePreviewMaxHeight() {
        return ((Number) this.framePreviewMaxHeight$delegate.getValue()).intValue();
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public FrameSizesAdapter(Context context, Function1<? super FrameSize, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "onFrameSizeSelected");
        this.onFrameSizeSelected = function1;
        this.layoutInflater$delegate = LazyKt.lazy(new FrameSizesAdapter$layoutInflater$2(context));
        this.framePreviewMaxHeight$delegate = LazyKt.lazy(new FrameSizesAdapter$framePreviewMaxHeight$2(context));
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/FrameSizesAdapter$Companion;", "", "()V", "TYPE_DIVIDER", "", "TYPE_PREVIEW", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FrameSizesAdapter.kt */
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
            NResizeFramePreviewItemBinding inflate = NResizeFramePreviewItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "NResizeFramePreviewItemB…tInflater, parent, false)");
            return new FrameSizeViewHolder(this, inflate);
        } else if (i == TYPE_DIVIDER) {
            NResizeFrameDividerItemBinding inflate2 = NResizeFrameDividerItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "NResizeFrameDividerItemB…tInflater, parent, false)");
            return new DividerViewHolder(this, inflate2);
        } else {
            throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof FrameSizeViewHolder) {
            Object itemAt = getItemAt(i);
            Objects.requireNonNull(itemAt, "null cannot be cast to non-null type editor.optionsui.frame.frameresize.ResizeFrameItem.Preview");
            ((FrameSizeViewHolder) viewHolder).setItem(((ResizeFrameItem.Preview) itemAt).getSize());
        }
    }

    public int getItemViewType(int i) {
        ResizeFrameItem resizeFrameItem = (ResizeFrameItem) getItemAt(i);
        if (resizeFrameItem instanceof ResizeFrameItem.Preview) {
            return TYPE_PREVIEW;
        }
        if (resizeFrameItem instanceof ResizeFrameItem.Divider) {
            return TYPE_DIVIDER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setSelectedFrameRatio(float f) {
        float f2 = this.selectedFrameRatio;
        this.selectedFrameRatio = f;
        if (f2 == f) {
            refreshFramesByFrameRatio(f);
            return;
        }
        refreshFramesByFrameRatio(f2, f);
    }

    private final void refreshFramesByFrameRatio(float... fArr) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            ResizeFrameItem resizeFrameItem = (ResizeFrameItem) getItemAt(i);
            if ((resizeFrameItem instanceof ResizeFrameItem.Preview) && ArraysKt.contains(fArr, ((ResizeFrameItem.Preview) resizeFrameItem).getSize().ratio())) {
                notifyItemChanged(i);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/FrameSizesAdapter$FrameSizeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NResizeFramePreviewItemBinding;", "(Leditor/optionsui/frame/frameresize/FrameSizesAdapter;Lcom/memes/editor/databinding/NResizeFramePreviewItemBinding;)V", "frameSize", "Leditor/optionsui/frame/frameresize/FrameSize;", "setItem", "", "setSelectedFrame", "isSelected", "", "showIcon", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FrameSizesAdapter.kt */
    public final class FrameSizeViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final NResizeFramePreviewItemBinding binding;
        /* access modifiers changed from: private */
        public FrameSize frameSize;
        final /* synthetic */ FrameSizesAdapter this$0;

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FrameSizeType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[FrameSizeType.ORIGINAL.ordinal()] = 1;
                iArr[FrameSizeType.CUSTOM.ordinal()] = 2;
                iArr[FrameSizeType.INSTAGRAM.ordinal()] = 3;
                iArr[FrameSizeType.FACEBOOK.ordinal()] = 4;
                iArr[FrameSizeType.TWITTER.ordinal()] = 5;
                iArr[FrameSizeType.PINTEREST.ordinal()] = 6;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FrameSizeViewHolder(FrameSizesAdapter frameSizesAdapter, NResizeFramePreviewItemBinding nResizeFramePreviewItemBinding) {
            super(nResizeFramePreviewItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nResizeFramePreviewItemBinding, "binding");
            this.this$0 = frameSizesAdapter;
            this.binding = nResizeFramePreviewItemBinding;
            nResizeFramePreviewItemBinding.background.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FrameSizeViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    FrameSizesAdapter frameSizesAdapter = this.this$0.this$0;
                    ConstraintLayout root = this.this$0.binding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    frameSizesAdapter.scrollToCenterHorizontally(root);
                    this.this$0.this$0.onFrameSizeSelected.invoke(FrameSizeViewHolder.access$getFrameSize$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ FrameSize access$getFrameSize$p(FrameSizeViewHolder frameSizeViewHolder) {
            FrameSize frameSize2 = frameSizeViewHolder.frameSize;
            if (frameSize2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameSize");
            }
            return frameSize2;
        }

        public final void setItem(FrameSize frameSize2) {
            Intrinsics.checkNotNullParameter(frameSize2, "frameSize");
            this.frameSize = frameSize2;
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setText(frameSize2.getTitle());
            showIcon();
            View view = this.binding.background;
            Intrinsics.checkNotNullExpressionValue(view, "binding.background");
            view.getLayoutParams().width = MathKt.roundToInt(frameSize2.ratio() * ((float) this.this$0.getFramePreviewMaxHeight()));
            setSelectedFrame(frameSize2.ratio() == this.this$0.selectedFrameRatio);
        }

        private final void showIcon() {
            int i;
            ImageView imageView = this.binding.iconImageView;
            FrameSize frameSize2 = this.frameSize;
            if (frameSize2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameSize");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[frameSize2.getType().ordinal()]) {
                case 1:
                    i = 0;
                    break;
                case 2:
                    i = C4175R.C4178drawable.icon_tune;
                    break;
                case 3:
                    i = C4175R.C4178drawable.icon_instagram;
                    break;
                case 4:
                    i = C4175R.C4178drawable.icon_facebook;
                    break;
                case 5:
                    i = C4175R.C4178drawable.icon_twitter;
                    break;
                case 6:
                    i = C4175R.C4178drawable.icon_pinterest;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            imageView.setImageResource(i);
        }

        private final void setSelectedFrame(boolean z) {
            ImageView imageView = this.binding.iconImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconImageView");
            imageView.setSelected(z);
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setSelected(z);
            View view = this.binding.background;
            Intrinsics.checkNotNullExpressionValue(view, "binding.background");
            view.setSelected(z);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/FrameSizesAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NResizeFrameDividerItemBinding;", "(Leditor/optionsui/frame/frameresize/FrameSizesAdapter;Lcom/memes/editor/databinding/NResizeFrameDividerItemBinding;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: FrameSizesAdapter.kt */
    public final class DividerViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ FrameSizesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DividerViewHolder(FrameSizesAdapter frameSizesAdapter, NResizeFrameDividerItemBinding nResizeFrameDividerItemBinding) {
            super(nResizeFrameDividerItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nResizeFrameDividerItemBinding, "binding");
            this.this$0 = frameSizesAdapter;
        }
    }
}
