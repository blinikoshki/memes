package editor.optionsui.layout.wireframes;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NWireframeDividerItemBinding;
import com.memes.editor.databinding.NWireframePreviewItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.optionsui.layout.wireframes.WireframeItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wireframe.language.Wireframe;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u0000\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00040123B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000fH\u0016J!\u0010'\u001a\u00020\u000b2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180)\"\u00020\u0018H\u0002¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010-H\u0016J\u000e\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u0018R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframesAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/optionsui/layout/wireframes/WireframeItem;", "context", "Landroid/content/Context;", "onWireframeSelected", "Lkotlin/Function1;", "Lwireframe/language/Wireframe;", "Lkotlin/ParameterName;", "name", "wireframe", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "allowedLayoutViewTypes", "", "", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "selectedWireframeId", "", "wireframePreviewCornerRadius", "", "getWireframePreviewCornerRadius", "()F", "wireframePreviewCornerRadius$delegate", "getItemViewType", "position", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshWireframesById", "ids", "", "([Ljava/lang/String;)V", "setItems", "newItems", "", "setSelectedWireframeId", "id", "Companion", "DividerViewHolder", "WireframeIconPreviewViewHolder", "WireframeLayoutPreviewViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: WireframesAdapter.kt */
public final class WireframesAdapter extends NicoRecyclerAdapter<WireframeItem> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TYPE_DIVIDER = 157;
    private static final int TYPE_ICON_PREVIEW = 156;
    private final List<Integer> allowedLayoutViewTypes = new ArrayList();
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new WireframesAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public final Function1<Wireframe, Unit> onWireframeSelected;
    /* access modifiers changed from: private */
    public String selectedWireframeId;
    private final Lazy wireframePreviewCornerRadius$delegate = LazyKt.lazy(new WireframesAdapter$wireframePreviewCornerRadius$2(this));

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final float getWireframePreviewCornerRadius() {
        return ((Number) this.wireframePreviewCornerRadius$delegate.getValue()).floatValue();
    }

    public WireframesAdapter(Context context2, Function1<? super Wireframe, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "onWireframeSelected");
        this.context = context2;
        this.onWireframeSelected = function1;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframesAdapter$Companion;", "", "()V", "TYPE_DIVIDER", "", "TYPE_ICON_PREVIEW", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WireframesAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void setItems(List<? extends WireframeItem> list) {
        this.allowedLayoutViewTypes.clear();
        if (list != null) {
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (next instanceof WireframeItem.Preview) {
                    arrayList.add(next);
                }
            }
            Collection arrayList2 = new ArrayList();
            for (Object next2 : (List) arrayList) {
                if (((WireframeItem.Preview) next2).getWireframe().hasLayout()) {
                    arrayList2.add(next2);
                }
            }
            Iterable<WireframeItem.Preview> iterable = (List) arrayList2;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (WireframeItem.Preview wireframe2 : iterable) {
                arrayList3.add(Integer.valueOf(wireframe2.getWireframe().getLayoutResId()));
            }
            this.allowedLayoutViewTypes.addAll((List) arrayList3);
        }
        super.setItems(list);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == TYPE_ICON_PREVIEW) {
            NWireframePreviewItemBinding inflate = NWireframePreviewItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "NWireframePreviewItemBin…tInflater, parent, false)");
            return new WireframeIconPreviewViewHolder(this, inflate);
        } else if (i == TYPE_DIVIDER) {
            NWireframeDividerItemBinding inflate2 = NWireframeDividerItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "NWireframeDividerItemBin…tInflater, parent, false)");
            return new DividerViewHolder(this, inflate2);
        } else if (this.allowedLayoutViewTypes.contains(Integer.valueOf(i))) {
            View inflate3 = getLayoutInflater().inflate(i, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, TtmlNode.TAG_LAYOUT);
            return new WireframeLayoutPreviewViewHolder(this, inflate3);
        } else {
            throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof WireframeIconPreviewViewHolder) {
            Object itemAt = getItemAt(i);
            Objects.requireNonNull(itemAt, "null cannot be cast to non-null type editor.optionsui.layout.wireframes.WireframeItem.Preview");
            ((WireframeIconPreviewViewHolder) viewHolder).setItem(((WireframeItem.Preview) itemAt).getWireframe());
        } else if (viewHolder instanceof WireframeLayoutPreviewViewHolder) {
            Object itemAt2 = getItemAt(i);
            Objects.requireNonNull(itemAt2, "null cannot be cast to non-null type editor.optionsui.layout.wireframes.WireframeItem.Preview");
            ((WireframeLayoutPreviewViewHolder) viewHolder).setItem(((WireframeItem.Preview) itemAt2).getWireframe());
        }
    }

    public int getItemViewType(int i) {
        WireframeItem wireframeItem = (WireframeItem) getItemAt(i);
        if (wireframeItem instanceof WireframeItem.Preview) {
            WireframeItem.Preview preview = (WireframeItem.Preview) wireframeItem;
            if (preview.getWireframe().hasLayout()) {
                return preview.getWireframe().getLayoutResId();
            }
            if (preview.getWireframe().hasIcon()) {
                return TYPE_ICON_PREVIEW;
            }
            throw new RuntimeException("Wireframe preview must have a layout or icon resource.");
        } else if (wireframeItem instanceof WireframeItem.Divider) {
            return TYPE_DIVIDER;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setSelectedWireframeId(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str2 = this.selectedWireframeId;
        if (Intrinsics.areEqual((Object) str2, (Object) str)) {
            refreshWireframesById(str2);
            return;
        }
        if (str2 != null) {
            refreshWireframesById(str2, str);
        } else {
            refreshWireframesById(str);
        }
        this.selectedWireframeId = str;
    }

    private final void refreshWireframesById(String... strArr) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            WireframeItem wireframeItem = (WireframeItem) getItemAt(i);
            if ((wireframeItem instanceof WireframeItem.Preview) && ArraysKt.contains((T[]) strArr, ((WireframeItem.Preview) wireframeItem).getWireframe().getId())) {
                notifyItemChanged(i);
            }
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframesAdapter$WireframeIconPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NWireframePreviewItemBinding;", "(Leditor/optionsui/layout/wireframes/WireframesAdapter;Lcom/memes/editor/databinding/NWireframePreviewItemBinding;)V", "wireframe", "Lwireframe/language/Wireframe;", "setItem", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WireframesAdapter.kt */
    private final class WireframeIconPreviewViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final NWireframePreviewItemBinding binding;
        final /* synthetic */ WireframesAdapter this$0;
        /* access modifiers changed from: private */

        /* renamed from: wireframe  reason: collision with root package name */
        public Wireframe f1538wireframe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WireframeIconPreviewViewHolder(WireframesAdapter wireframesAdapter, NWireframePreviewItemBinding nWireframePreviewItemBinding) {
            super(nWireframePreviewItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nWireframePreviewItemBinding, "binding");
            this.this$0 = wireframesAdapter;
            this.binding = nWireframePreviewItemBinding;
            nWireframePreviewItemBinding.background.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WireframeIconPreviewViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    WireframesAdapter wireframesAdapter = this.this$0.this$0;
                    ConstraintLayout root = this.this$0.binding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    wireframesAdapter.scrollToCenterHorizontally(root);
                    this.this$0.this$0.onWireframeSelected.invoke(WireframeIconPreviewViewHolder.access$getWireframe$p(this.this$0));
                }
            });
            ConstraintLayout root = nWireframePreviewItemBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ViewCornerOutlineProviderKt.roundCorners$default((View) root, wireframesAdapter.getWireframePreviewCornerRadius(), (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
        }

        public static final /* synthetic */ Wireframe access$getWireframe$p(WireframeIconPreviewViewHolder wireframeIconPreviewViewHolder) {
            Wireframe wireframe2 = wireframeIconPreviewViewHolder.f1538wireframe;
            if (wireframe2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wireframe");
            }
            return wireframe2;
        }

        public final void setItem(Wireframe wireframe2) {
            Intrinsics.checkNotNullParameter(wireframe2, "wireframe");
            this.f1538wireframe = wireframe2;
            if (wireframe2.hasIcon()) {
                this.binding.previewImageView.setImageResource(wireframe2.getIconResId());
            } else {
                this.binding.previewImageView.setImageResource(C4175R.C4178drawable.icon_wf_2);
            }
            boolean areEqual = Intrinsics.areEqual((Object) wireframe2.getId(), (Object) this.this$0.selectedWireframeId);
            View view = this.binding.background;
            Intrinsics.checkNotNullExpressionValue(view, "binding.background");
            view.setSelected(areEqual);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframesAdapter$WireframeLayoutPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Leditor/optionsui/layout/wireframes/WireframesAdapter;Landroid/view/View;)V", "wireframe", "Lwireframe/language/Wireframe;", "setItem", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WireframesAdapter.kt */
    private final class WireframeLayoutPreviewViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ WireframesAdapter this$0;
        /* access modifiers changed from: private */

        /* renamed from: wireframe  reason: collision with root package name */
        public Wireframe f1539wireframe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WireframeLayoutPreviewViewHolder(WireframesAdapter wireframesAdapter, final View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = wireframesAdapter;
            view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(wireframesAdapter.context, C4175R.C4176animator.scale_touch_effect));
            view.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WireframeLayoutPreviewViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    this.this$0.this$0.scrollToCenterHorizontally(view);
                    this.this$0.this$0.onWireframeSelected.invoke(WireframeLayoutPreviewViewHolder.access$getWireframe$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ Wireframe access$getWireframe$p(WireframeLayoutPreviewViewHolder wireframeLayoutPreviewViewHolder) {
            Wireframe wireframe2 = wireframeLayoutPreviewViewHolder.f1539wireframe;
            if (wireframe2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wireframe");
            }
            return wireframe2;
        }

        public final void setItem(Wireframe wireframe2) {
            Intrinsics.checkNotNullParameter(wireframe2, "wireframe");
            this.f1539wireframe = wireframe2;
            boolean areEqual = Intrinsics.areEqual((Object) wireframe2.getId(), (Object) this.this$0.selectedWireframeId);
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            view.setSelected(areEqual);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/optionsui/layout/wireframes/WireframesAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NWireframeDividerItemBinding;", "(Leditor/optionsui/layout/wireframes/WireframesAdapter;Lcom/memes/editor/databinding/NWireframeDividerItemBinding;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: WireframesAdapter.kt */
    private final class DividerViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ WireframesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DividerViewHolder(WireframesAdapter wireframesAdapter, NWireframeDividerItemBinding nWireframeDividerItemBinding) {
            super(nWireframeDividerItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nWireframeDividerItemBinding, "binding");
            this.this$0 = wireframesAdapter;
        }
    }
}
