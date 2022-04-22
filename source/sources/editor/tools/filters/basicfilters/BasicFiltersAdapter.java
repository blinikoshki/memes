package editor.tools.filters.basicfilters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.editor.databinding.NBasicFilterDividerItemBinding;
import com.memes.editor.databinding.NBasicFilterPreviewItemBinding;
import editor.core.NicoRecyclerAdapter;
import editor.core.ViewHolderPayload;
import editor.gpu.conflation.GlConflatedFilter;
import editor.tools.filters.basicfilters.BasicFilter;
import editor.tools.filters.conflation.FilterType;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\b\u0000\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004()*+B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0016J!\u0010!\u001a\u00020\u00172\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120#\"\u00020\u0012H\u0002¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo26107d2 = {"Leditor/tools/filters/basicfilters/BasicFiltersAdapter;", "Leditor/core/NicoRecyclerAdapter;", "Leditor/tools/filters/basicfilters/BasicFilter;", "context", "Landroid/content/Context;", "callback", "Leditor/tools/filters/basicfilters/BasicFiltersAdapter$Callback;", "(Landroid/content/Context;Leditor/tools/filters/basicfilters/BasicFiltersAdapter$Callback;)V", "filterType", "Leditor/tools/filters/conflation/FilterType;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "selectedFilterName", "", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshSelectedFilterByName", "filterNames", "", "([Ljava/lang/String;)V", "setFilterType", "setSelectedFilterName", "filterName", "Callback", "Companion", "FilterDividerViewHolder", "FilterPreviewViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BasicFiltersAdapter.kt */
public final class BasicFiltersAdapter extends NicoRecyclerAdapter<BasicFilter> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PAYLOAD_SELECTION_INDICATOR = "payload:selection_indicator";
    private static final int TYPE_DIVIDER = 999;
    private static final int TYPE_PREVIEW = 998;
    /* access modifiers changed from: private */
    public final Callback callback;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public FilterType filterType = FilterType.IMAGE;
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new BasicFiltersAdapter$layoutInflater$2(this));
    /* access modifiers changed from: private */
    public String selectedFilterName;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/tools/filters/basicfilters/BasicFiltersAdapter$Callback;", "", "onBasicFilterSelected", "", "filterPreview", "Leditor/tools/filters/basicfilters/BasicFilter$Preview;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BasicFiltersAdapter.kt */
    public interface Callback {
        void onBasicFilterSelected(BasicFilter.Preview preview);
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public BasicFiltersAdapter(Context context2, Callback callback2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Leditor/tools/filters/basicfilters/BasicFiltersAdapter$Companion;", "", "()V", "PAYLOAD_SELECTION_INDICATOR", "", "TYPE_DIVIDER", "", "TYPE_PREVIEW", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BasicFiltersAdapter.kt */
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
            NBasicFilterPreviewItemBinding inflate = NBasicFilterPreviewItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "NBasicFilterPreviewItemB…tInflater, parent, false)");
            return new FilterPreviewViewHolder(this, inflate);
        } else if (i == 999) {
            NBasicFilterDividerItemBinding inflate2 = NBasicFilterDividerItemBinding.inflate(getLayoutInflater(), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "NBasicFilterDividerItemB…tInflater, parent, false)");
            return new FilterDividerViewHolder(this, inflate2);
        } else {
            throw new RuntimeException("Unknown view-type: " + i);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof FilterPreviewViewHolder) {
            Object itemAt = getItemAt(i);
            Objects.requireNonNull(itemAt, "null cannot be cast to non-null type editor.tools.filters.basicfilters.BasicFilter.Preview");
            ((FilterPreviewViewHolder) viewHolder).setItem((BasicFilter.Preview) itemAt);
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
        BasicFilter basicFilter = (BasicFilter) getItemAt(i);
        if (basicFilter instanceof BasicFilter.Preview) {
            return TYPE_PREVIEW;
        }
        if (basicFilter instanceof BasicFilter.Divider) {
            return 999;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void refreshSelectedFilterByName(String... strArr) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            BasicFilter basicFilter = (BasicFilter) getItemAt(i);
            if (basicFilter instanceof BasicFilter.Preview) {
                BasicFilter.Preview preview = (BasicFilter.Preview) basicFilter;
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

    public final void setFilterType(FilterType filterType2) {
        Intrinsics.checkNotNullParameter(filterType2, "filterType");
        this.filterType = filterType2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/tools/filters/basicfilters/BasicFiltersAdapter$FilterPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NBasicFilterPreviewItemBinding;", "(Leditor/tools/filters/basicfilters/BasicFiltersAdapter;Lcom/memes/editor/databinding/NBasicFilterPreviewItemBinding;)V", "filterPreview", "Leditor/tools/filters/basicfilters/BasicFilter$Preview;", "setItem", "", "setSelected", "selected", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BasicFiltersAdapter.kt */
    public final class FilterPreviewViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final NBasicFilterPreviewItemBinding binding;
        /* access modifiers changed from: private */
        public BasicFilter.Preview filterPreview;
        final /* synthetic */ BasicFiltersAdapter this$0;

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FilterType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[FilterType.IMAGE.ordinal()] = 1;
                iArr[FilterType.VIDEO.ordinal()] = 2;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FilterPreviewViewHolder(BasicFiltersAdapter basicFiltersAdapter, NBasicFilterPreviewItemBinding nBasicFilterPreviewItemBinding) {
            super(nBasicFilterPreviewItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nBasicFilterPreviewItemBinding, "binding");
            this.this$0 = basicFiltersAdapter;
            this.binding = nBasicFilterPreviewItemBinding;
            nBasicFilterPreviewItemBinding.getRoot().setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FilterPreviewViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    BasicFiltersAdapter basicFiltersAdapter = this.this$0.this$0;
                    ConstraintLayout root = this.this$0.binding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    basicFiltersAdapter.scrollToCenterHorizontally(root);
                    this.this$0.this$0.callback.onBasicFilterSelected(FilterPreviewViewHolder.access$getFilterPreview$p(this.this$0));
                }
            });
        }

        public static final /* synthetic */ BasicFilter.Preview access$getFilterPreview$p(FilterPreviewViewHolder filterPreviewViewHolder) {
            BasicFilter.Preview preview = filterPreviewViewHolder.filterPreview;
            if (preview == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterPreview");
            }
            return preview;
        }

        public final void setItem(BasicFilter.Preview preview) {
            int i;
            Intrinsics.checkNotNullParameter(preview, "filterPreview");
            this.filterPreview = preview;
            GlConflatedFilter filter = preview.getFilter();
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setText(filter.name());
            ImageView imageView = this.binding.iconImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconImageView");
            ViewCornerOutlineProviderKt.roundCorners$default((View) imageView, 10.0f, (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.this$0.filterType.ordinal()];
            if (i2 == 1) {
                i = filter.getPhotoPreviewDrawableRes();
            } else if (i2 == 2) {
                i = filter.getVideoPreviewDrawableRes();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.binding.iconImageView.setImageResource(i);
            setSelected(Intrinsics.areEqual((Object) filter.name(), (Object) this.this$0.selectedFilterName));
        }

        public final void setSelected(boolean z) {
            TextView textView = this.binding.titleTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleTextView");
            textView.setSelected(z);
            LinearLayout linearLayout = this.binding.iconImageViewLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.iconImageViewLayout");
            linearLayout.setSelected(z);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/tools/filters/basicfilters/BasicFiltersAdapter$FilterDividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/memes/editor/databinding/NBasicFilterDividerItemBinding;", "(Leditor/tools/filters/basicfilters/BasicFiltersAdapter;Lcom/memes/editor/databinding/NBasicFilterDividerItemBinding;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BasicFiltersAdapter.kt */
    public final class FilterDividerViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ BasicFiltersAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FilterDividerViewHolder(BasicFiltersAdapter basicFiltersAdapter, NBasicFilterDividerItemBinding nBasicFilterDividerItemBinding) {
            super(nBasicFilterDividerItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(nBasicFilterDividerItemBinding, "binding");
            this.this$0 = basicFiltersAdapter;
        }
    }
}
