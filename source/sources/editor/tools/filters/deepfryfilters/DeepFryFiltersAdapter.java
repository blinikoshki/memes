package editor.tools.filters.deepfryfilters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.editor.C4175R;
import com.memes.editor.databinding.NDeepFryFilterDividerItemBinding;
import com.memes.editor.databinding.NDeepFryFilterPreviewItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.core.ViewHolderPayload;
import editor.gpu.conflation.GlConflatedFilter;
import editor.tools.filters.deepfryfilters.DeepFryFilter;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\b\u0000\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004)*+,B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0016J!\u0010!\u001a\u00020\u00172\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120#\"\u00020\u0012H\u0002¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\tJ\u000e\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo26107d2 = {"Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/tools/filters/deepfryfilters/DeepFryFilter;", "context", "Landroid/content/Context;", "callback", "Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter$Callback;", "(Landroid/content/Context;Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter$Callback;)V", "hasPremiumPlan", "", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "selectedFilterName", "", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshSelectedFilterByName", "filterNames", "", "([Ljava/lang/String;)V", "setHasPremiumPlan", "enabled", "setSelectedFilterName", "filterName", "Callback", "Companion", "FilterDividerViewHolder", "FilterPreviewViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DeepFryFiltersAdapter.kt */
public final class DeepFryFiltersAdapter extends NicoRecyclerAdapter<DeepFryFilter> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PAYLOAD_SELECTION_INDICATOR = "payload:selection_indicator";
    private static final int TYPE_DIVIDER = 999;
    private static final int TYPE_PREVIEW = 998;
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public boolean hasPremiumPlan;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new DeepFryFiltersAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public String selectedFilterName;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter$Callback;", "", "onDeepFryFilterSelected", "", "filterPreview", "Leditor/tools/filters/deepfryfilters/DeepFryFilter$Preview;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DeepFryFiltersAdapter.kt */
    public interface Callback {
        void onDeepFryFilterSelected(DeepFryFilter.Preview preview);
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public DeepFryFiltersAdapter(Context context2, Callback callback2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter$Companion;", "", "()V", "PAYLOAD_SELECTION_INDICATOR", "", "TYPE_DIVIDER", "", "TYPE_PREVIEW", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DeepFryFiltersAdapter.kt */
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
            NDeepFryFilterPreviewItemBinding inflate = NDeepFryFilterPreviewItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "NDeepFryFilterPreviewIte…tInflater, parent, false)");
            return new FilterPreviewViewHolder(this, inflate);
        } else if (i == 999) {
            NDeepFryFilterDividerItemBinding inflate2 = NDeepFryFilterDividerItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "NDeepFryFilterDividerIte…tInflater, parent, false)");
            return new FilterDividerViewHolder(this, inflate2);
        } else {
            throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof FilterPreviewViewHolder) {
            Object itemAt = getItemAt(i);
            Objects.requireNonNull(itemAt, "null cannot be cast to non-null type editor.tools.filters.deepfryfilters.DeepFryFilter.Preview");
            ((FilterPreviewViewHolder) viewHolder).setItem((DeepFryFilter.Preview) itemAt);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (viewHolder instanceof FilterPreviewViewHolder) {
            if (!list.isEmpty()) {
                for (Object next : list) {
                    if (next instanceof ViewHolderPayload) {
                        ViewHolderPayload viewHolderPayload = (ViewHolderPayload) next;
                        if (Intrinsics.areEqual((Object) viewHolderPayload.getKey(), (Object) PAYLOAD_SELECTION_INDICATOR)) {
                            Object value = viewHolderPayload.getValue();
                            Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                            ((FilterPreviewViewHolder) viewHolder).setSelected(((Boolean) value).booleanValue());
                        }
                    }
                }
                return;
            }
            super.onBindViewHolder(viewHolder, i, list);
        }
    }

    public int getItemViewType(int i) {
        DeepFryFilter deepFryFilter = (DeepFryFilter) getItemAt(i);
        if (deepFryFilter instanceof DeepFryFilter.Preview) {
            return TYPE_PREVIEW;
        }
        if (deepFryFilter instanceof DeepFryFilter.Divider) {
            return 999;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void refreshSelectedFilterByName(String... strArr) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            DeepFryFilter deepFryFilter = (DeepFryFilter) getItemAt(i);
            if (deepFryFilter instanceof DeepFryFilter.Preview) {
                DeepFryFilter.Preview preview = (DeepFryFilter.Preview) deepFryFilter;
                if (ArraysKt.contains((T[]) strArr, preview.getFilter().name())) {
                    notifyItemChanged(i, new ViewHolderPayload(PAYLOAD_SELECTION_INDICATOR, Boolean.valueOf(Intrinsics.areEqual((Object) preview.getFilter().name(), (Object) this.selectedFilterName))));
                }
            }
        }
    }

    public final void setSelectedFilterName(String str) {
        Intrinsics.checkNotNullParameter(str, "filterName");
        String str2 = this.selectedFilterName;
        this.selectedFilterName = str;
        if (str2 == null) {
            refreshSelectedFilterByName(str);
            return;
        }
        refreshSelectedFilterByName(str2, str);
    }

    public final void setHasPremiumPlan(boolean z) {
        if (this.hasPremiumPlan != z) {
            this.hasPremiumPlan = z;
            notifyDataSetChanged();
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter$FilterPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NDeepFryFilterPreviewItemBinding;", "(Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter;Lcom/memes/editor/databinding/NDeepFryFilterPreviewItemBinding;)V", "filterPreview", "Leditor/tools/filters/deepfryfilters/DeepFryFilter$Preview;", "setItem", "", "setSelected", "selected", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DeepFryFiltersAdapter.kt */
    public final class FilterPreviewViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final NDeepFryFilterPreviewItemBinding binding;
        /* access modifiers changed from: private */
        public DeepFryFilter.Preview filterPreview;
        final /* synthetic */ DeepFryFiltersAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FilterPreviewViewHolder(DeepFryFiltersAdapter deepFryFiltersAdapter, NDeepFryFilterPreviewItemBinding nDeepFryFilterPreviewItemBinding) {
            super(nDeepFryFilterPreviewItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nDeepFryFilterPreviewItemBinding, "binding");
            this.this$0 = deepFryFiltersAdapter;
            this.binding = nDeepFryFilterPreviewItemBinding;
            nDeepFryFilterPreviewItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FilterPreviewViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    DeepFryFiltersAdapter deepFryFiltersAdapter = this.this$0.this$0;
                    ConstraintLayout root = this.this$0.binding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    deepFryFiltersAdapter.scrollToCenterHorizontally(root);
                    this.this$0.this$0.callback.onDeepFryFilterSelected(FilterPreviewViewHolder.access$getFilterPreview$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ DeepFryFilter.Preview access$getFilterPreview$p(FilterPreviewViewHolder filterPreviewViewHolder) {
            DeepFryFilter.Preview preview = filterPreviewViewHolder.filterPreview;
            if (preview == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterPreview");
            }
            return preview;
        }

        public final void setItem(DeepFryFilter.Preview preview) {
            Intrinsics.checkNotNullParameter(preview, "filterPreview");
            this.filterPreview = preview;
            GlConflatedFilter filter = preview.getFilter();
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setText(filter.name());
            ImageView imageView = this.binding.iconImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconImageView");
            ViewCornerOutlineProviderKt.roundCorners$default((View) imageView, 10.0f, (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
            if (Intrinsics.areEqual((Object) filter.name(), (Object) "None")) {
                FrameLayout frameLayout = this.binding.iconImageViewLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.iconImageViewLayout");
                frameLayout.setBackgroundTintList(ContextCompat.getColorStateList(this.this$0.context, C4175R.C4177color.n_filter_none_item_preview_bg_tint));
                ImageView imageView2 = this.binding.iconImageView;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.iconImageView");
                imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ImageView imageView3 = this.binding.iconImageView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.iconImageView");
                imageView3.setImageTintList(ContextCompat.getColorStateList(this.this$0.context, C4175R.C4177color.n_filter_icon_preview_tint));
            } else {
                FrameLayout frameLayout2 = this.binding.iconImageViewLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.iconImageViewLayout");
                frameLayout2.setBackgroundTintList(ContextCompat.getColorStateList(this.this$0.context, C4175R.C4177color.n_filter_preview_bg_tint));
                ImageView imageView4 = this.binding.iconImageView;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.iconImageView");
                imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
                ImageView imageView5 = this.binding.iconImageView;
                Intrinsics.checkNotNullExpressionValue(imageView5, "binding.iconImageView");
                imageView5.setImageTintList((ColorStateList) null);
            }
            this.binding.iconImageView.setImageResource(filter.getPhotoPreviewDrawableRes());
            View view = this.binding.premiumIndicatorView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.premiumIndicatorView");
            view.setVisibility((this.this$0.hasPremiumPlan || !filter.isPremium()) ? 8 : 0);
            setSelected(Intrinsics.areEqual((Object) filter.name(), (Object) this.this$0.selectedFilterName));
        }

        public final void setSelected(boolean z) {
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setSelected(z);
            FrameLayout frameLayout = this.binding.iconImageViewLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.iconImageViewLayout");
            frameLayout.setSelected(z);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter$FilterDividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NDeepFryFilterDividerItemBinding;", "(Leditor/tools/filters/deepfryfilters/DeepFryFiltersAdapter;Lcom/memes/editor/databinding/NDeepFryFilterDividerItemBinding;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: DeepFryFiltersAdapter.kt */
    public final class FilterDividerViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ DeepFryFiltersAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FilterDividerViewHolder(DeepFryFiltersAdapter deepFryFiltersAdapter, NDeepFryFilterDividerItemBinding nDeepFryFilterDividerItemBinding) {
            super(nDeepFryFilterDividerItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nDeepFryFilterDividerItemBinding, "binding");
            this.this$0 = deepFryFiltersAdapter;
        }
    }
}
