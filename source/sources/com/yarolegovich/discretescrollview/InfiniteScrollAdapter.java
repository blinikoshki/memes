package com.yarolegovich.discretescrollview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager;
import java.util.Locale;

public class InfiniteScrollAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> implements DiscreteScrollLayoutManager.InitialPositionProvider {
    private static final int CENTER = 1073741823;
    private static final int RESET_BOUND = 100;
    private DiscreteScrollLayoutManager layoutManager;
    private RecyclerView.Adapter<T> wrapped;

    public static <T extends RecyclerView.ViewHolder> InfiniteScrollAdapter<T> wrap(RecyclerView.Adapter<T> adapter) {
        return new InfiniteScrollAdapter<>(adapter);
    }

    public InfiniteScrollAdapter(RecyclerView.Adapter<T> adapter) {
        this.wrapped = adapter;
        adapter.registerAdapterDataObserver(new DataSetChangeDelegate());
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.wrapped.onAttachedToRecyclerView(recyclerView);
        if (recyclerView instanceof DiscreteScrollView) {
            this.layoutManager = (DiscreteScrollLayoutManager) recyclerView.getLayoutManager();
            return;
        }
        throw new RuntimeException(recyclerView.getContext().getString(C4632R.string.dsv_ex_msg_adapter_wrong_recycler));
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.wrapped.onDetachedFromRecyclerView(recyclerView);
        this.layoutManager = null;
    }

    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.wrapped.onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(T t, int i) {
        if (isResetRequired(i)) {
            setPosition(mapPositionToReal(this.layoutManager.getCurrentPosition()) + 1073741823);
        } else {
            this.wrapped.onBindViewHolder(t, mapPositionToReal(i));
        }
    }

    public int getItemViewType(int i) {
        return this.wrapped.getItemViewType(mapPositionToReal(i));
    }

    public int getItemCount() {
        if (isInfinite()) {
            return Integer.MAX_VALUE;
        }
        return this.wrapped.getItemCount();
    }

    public int getRealItemCount() {
        return this.wrapped.getItemCount();
    }

    public int getRealCurrentPosition() {
        return getRealPosition(this.layoutManager.getCurrentPosition());
    }

    public int getRealPosition(int i) {
        return mapPositionToReal(i);
    }

    public int getClosestPosition(int i) {
        int i2;
        ensureValidPosition(i);
        int currentPosition = this.layoutManager.getCurrentPosition();
        int mapPositionToReal = mapPositionToReal(currentPosition);
        if (i == mapPositionToReal) {
            return currentPosition;
        }
        int i3 = i - mapPositionToReal;
        int i4 = currentPosition + i3;
        if (i > mapPositionToReal) {
            i2 = i3 - this.wrapped.getItemCount();
        } else {
            i2 = i3 + this.wrapped.getItemCount();
        }
        int i5 = i2 + currentPosition;
        int abs = Math.abs(currentPosition - i4);
        int abs2 = Math.abs(currentPosition - i5);
        return abs == abs2 ? i4 > currentPosition ? i4 : i5 : abs < abs2 ? i4 : i5;
    }

    private int mapPositionToReal(int i) {
        if (i >= 1073741823) {
            return (i - 1073741823) % this.wrapped.getItemCount();
        }
        int itemCount = (1073741823 - i) % this.wrapped.getItemCount();
        if (itemCount == 0) {
            return 0;
        }
        return this.wrapped.getItemCount() - itemCount;
    }

    private boolean isResetRequired(int i) {
        return isInfinite() && (i <= 100 || i >= 2147483547);
    }

    private void ensureValidPosition(int i) {
        if (i >= this.wrapped.getItemCount()) {
            throw new IndexOutOfBoundsException(String.format(Locale.US, "requested position is outside adapter's bounds: position=%d, size=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.wrapped.getItemCount())}));
        }
    }

    private boolean isInfinite() {
        return this.wrapped.getItemCount() > 1;
    }

    public int getInitialPosition() {
        return isInfinite() ? 1073741823 : 0;
    }

    /* access modifiers changed from: private */
    public void setPosition(int i) {
        this.layoutManager.scrollToPosition(i);
    }

    private class DataSetChangeDelegate extends RecyclerView.AdapterDataObserver {
        private DataSetChangeDelegate() {
        }

        public void onChanged() {
            InfiniteScrollAdapter infiniteScrollAdapter = InfiniteScrollAdapter.this;
            infiniteScrollAdapter.setPosition(infiniteScrollAdapter.getInitialPosition());
            InfiniteScrollAdapter.this.notifyDataSetChanged();
        }

        public void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        public void onItemRangeChanged(int i, int i2) {
            InfiniteScrollAdapter infiniteScrollAdapter = InfiniteScrollAdapter.this;
            infiniteScrollAdapter.notifyItemRangeChanged(0, infiniteScrollAdapter.getItemCount());
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            InfiniteScrollAdapter infiniteScrollAdapter = InfiniteScrollAdapter.this;
            infiniteScrollAdapter.notifyItemRangeChanged(0, infiniteScrollAdapter.getItemCount(), obj);
        }
    }
}
