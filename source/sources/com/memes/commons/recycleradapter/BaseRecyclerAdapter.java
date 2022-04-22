package com.memes.commons.recycleradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.recycleradapter.BaseViewHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0017\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u001b\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u001e2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&J\u001e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000b2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&J\u0016\u0010)\u001a\u00020\u001e2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010+J\u001e\u0010,\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000b2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010+J\u0016\u0010-\u001a\u00020\u001e2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010+J\u0006\u0010.\u001a\u00020\u001eJ\u0010\u0010/\u001a\u00020\u001e2\b\b\u0002\u00100\u001a\u000201J\u0006\u00102\u001a\u00020\u001eJ%\u00103\u001a\u00028\u00012\u0006\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000bH&¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020\u000b2\b\b\u0001\u0010:\u001a\u00020\u000bJ\u0015\u0010;\u001a\u0004\u0018\u00018\u00002\u0006\u0010\"\u001a\u00020\u000b¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020\u000bH\u0016J\u0017\u0010>\u001a\u0004\u0018\u00010\u000b2\u0006\u00107\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010?J\f\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J/\u0010A\u001a\u00020B2\b\b\u0001\u0010C\u001a\u00020\u000b2\u0018\b\u0002\u0010D\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010F0E\"\u0004\u0018\u00010F¢\u0006\u0002\u0010GJ\u0006\u0010H\u001a\u000201J\u0006\u0010I\u001a\u000201J\u0006\u0010J\u001a\u000201J\u0010\u0010K\u001a\u0002012\u0006\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010L\u001a\u00020\u001eH\u0002J\u0010\u0010M\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001d\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00028\u00012\u0006\u0010\"\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010PJ+\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00028\u00012\u0006\u0010\"\u001a\u00020\u000b2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020F0\u0014H\u0016¢\u0006\u0002\u0010RJ\u001d\u0010S\u001a\u00028\u00012\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010TJ\u000e\u0010U\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\tJ\u000e\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020\u000bJ\u0016\u0010Z\u001a\u00020\u001e2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&J\u0015\u0010[\u001a\u00020\u001e2\b\u0010\\\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R7\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, mo26107d2 = {"Lcom/memes/commons/recycleradapter/BaseRecyclerAdapter;", "ITEM", "HOLDER", "Lcom/memes/commons/recycleradapter/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemCountChangeListener", "Lcom/memes/commons/recycleradapter/AdapterItemCountChangeListener;", "itemCountLimit", "", "itemHeightCaches", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getItemHeightCaches", "()Ljava/util/HashMap;", "itemHeightCaches$delegate", "Lkotlin/Lazy;", "items", "", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "addItem", "", "newItem", "(Ljava/lang/Object;)V", "addItemAt", "position", "(ILjava/lang/Object;)V", "addItems", "newItems", "", "addItemsAt", "index", "applyAdapterUpdate", "adapterUpdate", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "applyAdapterUpdateAt", "applyAdapterUpdateWithShuffle", "clear", "clearItemCountLimit", "notify", "", "clearItemHeightCaches", "createItemViewHolder", "inflater", "parent", "Landroid/view/ViewGroup;", "viewType", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Lcom/memes/commons/recycleradapter/BaseViewHolder;", "getColor", "colorRes", "getItemAt", "(I)Ljava/lang/Object;", "getItemCount", "getItemTag", "(I)Ljava/lang/Integer;", "getItems", "getString", "", "textRes", "arguments", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "hasItemCountLimit", "hasNoPage", "isItemCountLimitInEffect", "isPositionInBounds", "notifyItemCountChanged", "onAttachedToRecyclerView", "onBindViewHolder", "holder", "(Lcom/memes/commons/recycleradapter/BaseViewHolder;I)V", "payloads", "(Lcom/memes/commons/recycleradapter/BaseViewHolder;ILjava/util/List;)V", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/memes/commons/recycleradapter/BaseViewHolder;", "removeItemAt", "setAdapterItemCountChangeListener", "listener", "setItemCountLimit", "limit", "setItems", "setSingleItem", "item", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseRecyclerAdapter.kt */
public abstract class BaseRecyclerAdapter<ITEM, HOLDER extends BaseViewHolder<ITEM>> extends RecyclerView.Adapter<HOLDER> {
    /* access modifiers changed from: private */
    public final Context context;
    private AdapterItemCountChangeListener itemCountChangeListener;
    private int itemCountLimit = Integer.MAX_VALUE;
    private final Lazy itemHeightCaches$delegate = LazyKt.lazy(BaseRecyclerAdapter$itemHeightCaches$2.INSTANCE);
    private List<ITEM> items = new ArrayList();
    private final Lazy layoutInflater$delegate = LazyKt.lazy(new BaseRecyclerAdapter$layoutInflater$2(this));
    private RecyclerView recyclerView;

    private final HashMap<Integer, Integer> getItemHeightCaches() {
        return (HashMap) this.itemHeightCaches$delegate.getValue();
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    public abstract HOLDER createItemViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int i);

    public Integer getItemTag(int i) {
        return null;
    }

    public BaseRecyclerAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        this.recyclerView = recyclerView2;
    }

    public HOLDER onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        HOLDER createItemViewHolder = createItemViewHolder(layoutInflater, viewGroup, i);
        Integer itemTag = getItemTag(i);
        if (itemTag != null) {
            View view = createItemViewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            view.setTag(itemTag);
        }
        return createItemViewHolder;
    }

    public void onBindViewHolder(HOLDER holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object itemAt = getItemAt(i);
        if (itemAt != null) {
            holder.setItem(itemAt);
            return;
        }
        throw new IllegalStateException("Item with " + i + " is not found in provided data source");
    }

    public void onBindViewHolder(HOLDER holder, int i, List<Object> list) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (!list.isEmpty()) {
            holder.updateWithPayload(list);
        } else {
            super.onBindViewHolder((RecyclerView.ViewHolder) holder, i, list);
        }
    }

    public int getItemCount() {
        int size = this.items.size();
        int i = this.itemCountLimit;
        return size > i ? i : size;
    }

    public final void setAdapterItemCountChangeListener(AdapterItemCountChangeListener adapterItemCountChangeListener) {
        Intrinsics.checkNotNullParameter(adapterItemCountChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.itemCountChangeListener = adapterItemCountChangeListener;
    }

    private final boolean isPositionInBounds(int i) {
        return i >= 0 && getItemCount() >= i;
    }

    public final List<ITEM> getItems() {
        return this.items;
    }

    public final ITEM getItemAt(int i) {
        if (isPositionInBounds(i)) {
            return this.items.get(i);
        }
        return null;
    }

    public final void addItemAt(int i, ITEM item) {
        if (item != null) {
            this.items.add(i, item);
            notifyItemInserted(i);
            notifyItemCountChanged();
        }
    }

    public final void addItem(ITEM item) {
        if (item != null) {
            this.items.add(item);
            notifyItemInserted(getItemCount() - 1);
            notifyItemCountChanged();
        }
    }

    public final void addItems(List<? extends ITEM> list) {
        if (list != null && !list.isEmpty()) {
            int itemCount = getItemCount();
            this.items.addAll(list);
            notifyItemRangeInserted(itemCount, list.size());
            notifyItemCountChanged();
        }
    }

    public final void addItemsAt(int i, List<? extends ITEM> list) {
        if (list != null && !list.isEmpty()) {
            this.items.addAll(i, list);
            notifyItemRangeInserted(i, list.size());
            notifyItemCountChanged();
        }
    }

    public final void setSingleItem(ITEM item) {
        this.items.clear();
        if (item != null) {
            this.items.add(item);
        }
        notifyDataSetChanged();
        notifyItemCountChanged();
    }

    public final void setItems(List<? extends ITEM> list) {
        this.items.clear();
        if (list != null) {
            this.items.addAll(list);
        }
        notifyDataSetChanged();
        notifyItemCountChanged();
    }

    public final boolean hasNoPage() {
        return getItemCount() < 1;
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

    public final void applyAdapterUpdateAt(int i, AdapterUpdate<ITEM> adapterUpdate) {
        if (adapterUpdate == null) {
            setItems((List) null);
        } else if (adapterUpdate.getPage() < 1) {
            setItems(adapterUpdate.getItems());
        } else {
            addItemsAt(i, adapterUpdate.getItems());
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

    public final void removeItemAt(int i) {
        Timber.m300d("Removing item at: " + i, new Object[0]);
        int itemCount = getItemCount();
        if (i >= 0 && itemCount > i) {
            this.items.remove(i);
            notifyItemRemoved(i);
            if (isItemCountLimitInEffect()) {
                notifyItemInserted(itemCount);
            }
            notifyItemCountChanged();
        }
    }

    public final void clear() {
        this.items.clear();
        notifyDataSetChanged();
        notifyItemCountChanged();
    }

    public final void clearItemHeightCaches() {
        getItemHeightCaches().clear();
    }

    public final void setItemCountLimit(int i) {
        this.itemCountLimit = i;
    }

    public final boolean hasItemCountLimit() {
        return this.itemCountLimit != Integer.MAX_VALUE;
    }

    public final boolean isItemCountLimitInEffect() {
        return hasItemCountLimit() && this.items.size() > this.itemCountLimit;
    }

    public static /* synthetic */ void clearItemCountLimit$default(BaseRecyclerAdapter baseRecyclerAdapter, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseRecyclerAdapter.clearItemCountLimit(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearItemCountLimit");
    }

    public final void clearItemCountLimit(boolean z) {
        this.itemCountLimit = Integer.MAX_VALUE;
        if (z) {
            notifyDataSetChanged();
        }
    }

    private final void notifyItemCountChanged() {
        Timber.m300d("Adapter.notifyItemCountChanged(" + getItemCount() + ')', new Object[0]);
        clearItemHeightCaches();
        AdapterItemCountChangeListener adapterItemCountChangeListener = this.itemCountChangeListener;
        if (adapterItemCountChangeListener != null) {
            adapterItemCountChangeListener.onItemCountChanged(getItemCount());
        }
    }

    public static /* synthetic */ String getString$default(BaseRecyclerAdapter baseRecyclerAdapter, int i, Object[] objArr, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                objArr = new Object[0];
            }
            return baseRecyclerAdapter.getString(i, objArr);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
    }

    public final String getString(int i, Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "arguments");
        String string = this.context.getString(i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(textRes, *arguments)");
        return string;
    }

    public final int getColor(int i) {
        return ContextCompat.getColor(this.context, i);
    }
}
