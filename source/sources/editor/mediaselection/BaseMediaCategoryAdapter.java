package editor.mediaselection;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.memes.commons.outlineprovider.ViewCornerOutlineProvider;
import com.memes.commons.outlineprovider.ViewCornerOutlineProviderKt;
import com.memes.editor.C4175R;
import editor.core.NicoRecyclerAdapter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001,BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012F\b\u0002\u0010\u0005\u001a@\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f¢\u0006\u0002\u0010\rJ\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0004J\u0015\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0017H\u0004J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\nJ \u0010(\u001a\u00020#2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000RL\u0010\u0005\u001a@\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, mo26107d2 = {"Leditor/mediaselection/BaseMediaCategoryAdapter;", "T", "Leditor/core/NicoRecyclerAdapter;", "context", "Landroid/content/Context;", "itemSelectionCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "", "selected", "Leditor/mediaselection/ItemSelectedCallback;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "defaultCornerRadius", "", "getDefaultCornerRadius", "()F", "defaultCornerRadius$delegate", "Lkotlin/Lazy;", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "selectedItemsSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getCornerRadius", "getGlideRequestManager", "getItemId", "(Ljava/lang/Object;)Ljava/lang/String;", "getLayoutInflater", "onViewRecycled", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setItemSelectedById", "targetItemId", "setSelectedItemIds", "itemIds", "", "notify", "BaseMediaCategoryItemViewHolder", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseMediaCategoryAdapter.kt */
public abstract class BaseMediaCategoryAdapter<T> extends NicoRecyclerAdapter<T> {
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy defaultCornerRadius$delegate;
    private final RequestManager glideRequestManager;
    /* access modifiers changed from: private */
    public final Function2<T, Boolean, Boolean> itemSelectionCallback;
    private final LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public final HashSet<String> selectedItemsSet;

    private final float getDefaultCornerRadius() {
        return ((Number) this.defaultCornerRadius$delegate.getValue()).floatValue();
    }

    public abstract String getItemId(T t);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseMediaCategoryAdapter(Context context2, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i & 2) != 0 ? null : function2);
    }

    public BaseMediaCategoryAdapter(Context context2, Function2<? super T, ? super Boolean, Boolean> function2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.itemSelectionCallback = function2;
        RequestManager with = Glide.with(context2);
        Intrinsics.checkNotNullExpressionValue(with, "Glide.with(context)");
        this.glideRequestManager = with;
        this.layoutInflater = LayoutInflater.from(context2);
        this.defaultCornerRadius$delegate = LazyKt.lazy(new BaseMediaCategoryAdapter$defaultCornerRadius$2(this));
        this.selectedItemsSet = new HashSet<>();
    }

    /* access modifiers changed from: protected */
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater2 = this.layoutInflater;
        Intrinsics.checkNotNullExpressionValue(layoutInflater2, "layoutInflater");
        return layoutInflater2;
    }

    /* access modifiers changed from: protected */
    public final RequestManager getGlideRequestManager() {
        return this.glideRequestManager;
    }

    public float getCornerRadius() {
        return getDefaultCornerRadius();
    }

    public static /* synthetic */ void setSelectedItemIds$default(BaseMediaCategoryAdapter baseMediaCategoryAdapter, List list, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            baseMediaCategoryAdapter.setSelectedItemIds(list, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSelectedItemIds");
    }

    public final void setSelectedItemIds(List<String> list, boolean z) {
        this.selectedItemsSet.clear();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            for (String add : list) {
                this.selectedItemsSet.add(add);
            }
        }
        if (z) {
            notifyDataSetChanged();
        }
    }

    public final void setItemSelectedById(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetItemId");
        if (z) {
            this.selectedItemsSet.add(str);
        } else {
            this.selectedItemsSet.remove(str);
        }
        int i = 0;
        for (Object itemId : getItems()) {
            if (Intrinsics.areEqual((Object) getItemId(itemId), (Object) str)) {
                notifyItemChanged(i);
                return;
            }
            i++;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\r\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH&J\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002¨\u0006\u0014"}, mo26107d2 = {"Leditor/mediaselection/BaseMediaCategoryAdapter$BaseMediaCategoryItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Leditor/mediaselection/BaseMediaCategoryAdapter;Landroid/view/View;)V", "cleanup", "", "glideRequestManager", "Lcom/bumptech/glide/RequestManager;", "getItem", "()Ljava/lang/Object;", "onSelectionIndicatorVisibilityChanged", "isVisible", "", "setItem", "item", "(Ljava/lang/Object;)V", "setSelected", "selected", "showSelectionIndicator", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BaseMediaCategoryAdapter.kt */
    public abstract class BaseMediaCategoryItemViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ BaseMediaCategoryAdapter this$0;

        public abstract void cleanup(RequestManager requestManager);

        public abstract T getItem();

        public abstract void onSelectionIndicatorVisibilityChanged(boolean z);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BaseMediaCategoryItemViewHolder(BaseMediaCategoryAdapter baseMediaCategoryAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = baseMediaCategoryAdapter;
            ViewCornerOutlineProviderKt.roundCorners$default(view, baseMediaCategoryAdapter.getCornerRadius(), (ViewCornerOutlineProvider.CornerType) null, 2, (Object) null);
            view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(baseMediaCategoryAdapter.context, C4175R.C4176animator.scale_touch_effect));
            view.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ BaseMediaCategoryItemViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    Object item = this.this$0.getItem();
                    boolean contains = this.this$0.this$0.selectedItemsSet.contains(this.this$0.this$0.getItemId(item));
                    Function2 access$getItemSelectionCallback$p = this.this$0.this$0.itemSelectionCallback;
                    Boolean bool = access$getItemSelectionCallback$p != null ? (Boolean) access$getItemSelectionCallback$p.invoke(item, Boolean.valueOf(!contains)) : null;
                    if (bool != null) {
                        this.this$0.setSelected(bool.booleanValue());
                    }
                }
            });
        }

        public void setItem(T t) {
            showSelectionIndicator();
        }

        private final void showSelectionIndicator() {
            onSelectionIndicatorVisibilityChanged(this.this$0.selectedItemsSet.contains(this.this$0.getItemId(getItem())));
        }

        /* access modifiers changed from: private */
        public final void setSelected(boolean z) {
            String itemId = this.this$0.getItemId(getItem());
            if (z) {
                this.this$0.selectedItemsSet.add(itemId);
            } else {
                this.this$0.selectedItemsSet.remove(itemId);
            }
            onSelectionIndicatorVisibilityChanged(z);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof BaseMediaCategoryItemViewHolder) {
            ((BaseMediaCategoryItemViewHolder) viewHolder).cleanup(this.glideRequestManager);
        }
        super.onViewRecycled(viewHolder);
    }
}
