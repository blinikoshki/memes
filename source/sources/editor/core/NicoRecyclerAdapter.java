package editor.core;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018J\u0016\u0010\u0019\u001a\u00020\f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018J\u0010\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016J\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0015J\b\u0010!\u001a\u00020\fH\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010#\u001a\u00020\fJ\u0013\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u000e\u0010%\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0006J\u0018\u0010+\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006,"}, mo26107d2 = {"Leditor/core/NicoRecyclerAdapter;", "ITEM", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "itemCountChangeListener", "Leditor/core/ItemCountChangeListener;", "items", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "addItem", "", "item", "(Ljava/lang/Object;)V", "addItemAt", "position", "", "(ILjava/lang/Object;)V", "addItems", "newItems", "", "applyAdapterUpdate", "adapterUpdate", "Leditor/core/AdapterUpdate;", "applyAdapterUpdateWithShuffle", "clear", "notify", "", "getItemAt", "(I)Ljava/lang/Object;", "getItemCount", "getItems", "notifyItemCountChanged", "onAttachedToRecyclerView", "removeAllItems", "removeItem", "removeItemAt", "scrollToCenterHorizontally", "itemView", "Landroid/view/View;", "setItemCountChangeListener", "listener", "setItems", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoRecyclerAdapter.kt */
public abstract class NicoRecyclerAdapter<ITEM> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ItemCountChangeListener itemCountChangeListener;
    private final List<ITEM> items = new ArrayList();
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(NicoRecyclerAdapter nicoRecyclerAdapter) {
        RecyclerView recyclerView2 = nicoRecyclerAdapter.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView2;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView2);
        this.recyclerView = recyclerView2;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public final List<ITEM> getItems() {
        return this.items;
    }

    public void setItems(List<? extends ITEM> list) {
        boolean z = false;
        clear(false);
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z = true;
        }
        if (!z) {
            this.items.addAll(collection);
            notifyDataSetChanged();
            notifyItemCountChanged();
        }
    }

    public final ITEM getItemAt(int i) {
        return this.items.get(i);
    }

    public void addItems(List<? extends ITEM> list) {
        if (list != null && !list.isEmpty()) {
            int itemCount = getItemCount();
            this.items.addAll(list);
            notifyItemRangeInserted(itemCount, list.size());
            notifyItemCountChanged();
        }
    }

    public final void addItemAt(int i, ITEM item) {
        this.items.add(i, item);
        notifyItemInserted(i);
        notifyItemCountChanged();
    }

    public void addItem(ITEM item) {
        this.items.add(item);
        notifyItemInserted(this.items.size());
        notifyItemCountChanged();
    }

    public final void applyAdapterUpdate(AdapterUpdate<ITEM> adapterUpdate) {
        if (adapterUpdate == null) {
            setItems((List) null);
        } else if (adapterUpdate.getPage() < 1) {
            setItems(adapterUpdate.getItems());
        } else {
            addItems(adapterUpdate.getItems());
        }
    }

    public final void applyAdapterUpdateWithShuffle(AdapterUpdate<ITEM> adapterUpdate) {
        List list = null;
        if (adapterUpdate == null) {
            setItems((List) null);
            return;
        }
        int page = adapterUpdate.getPage();
        List<ITEM> items2 = adapterUpdate.getItems();
        if (items2 != null) {
            list = CollectionsKt.shuffled(items2);
        }
        applyAdapterUpdate(new AdapterUpdate(page, list));
    }

    public final void removeItem(ITEM item) {
        removeItemAt(this.items.indexOf(item));
    }

    public final void removeItemAt(int i) {
        if (i >= 0) {
            this.items.remove(i);
            notifyItemRemoved(i);
            notifyItemCountChanged();
        }
    }

    public final void removeAllItems() {
        int size = this.items.size();
        this.items.clear();
        notifyItemRangeRemoved(0, size);
        notifyItemCountChanged();
    }

    public static /* synthetic */ void clear$default(NicoRecyclerAdapter nicoRecyclerAdapter, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            nicoRecyclerAdapter.clear(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clear");
    }

    public final void clear(boolean z) {
        this.items.clear();
        if (z) {
            notifyDataSetChanged();
            notifyItemCountChanged();
        }
    }

    public final void scrollToCenterHorizontally(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        if (this.recyclerView != null) {
            int width = view.getWidth();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int marginStart = width + (layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams) : 0);
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            int width2 = recyclerView2.getWidth();
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            int paddingStart = width2 - recyclerView3.getPaddingStart();
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            int paddingEnd = paddingStart - recyclerView4.getPaddingEnd();
            if (marginStart > 0 && paddingEnd > 0) {
                int i = (paddingEnd - marginStart) / 2;
                RecyclerView recyclerView5 = this.recyclerView;
                if (recyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                int childAdapterPosition = recyclerView5.getChildAdapterPosition(view);
                if (childAdapterPosition != -1) {
                    RecyclerView recyclerView6 = this.recyclerView;
                    if (recyclerView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    }
                    RecyclerView.LayoutManager layoutManager = recyclerView6.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(childAdapterPosition, i);
                    }
                }
            }
        }
    }

    public final void setItemCountChangeListener(ItemCountChangeListener itemCountChangeListener2) {
        Intrinsics.checkNotNullParameter(itemCountChangeListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.itemCountChangeListener = itemCountChangeListener2;
    }

    private final void notifyItemCountChanged() {
        int size = this.items.size();
        Timber.m300d("onItemCountChanged: " + size, new Object[0]);
        ItemCountChangeListener itemCountChangeListener2 = this.itemCountChangeListener;
        if (itemCountChangeListener2 != null) {
            itemCountChangeListener2.onItemCountChanged(this, size);
        }
    }
}
