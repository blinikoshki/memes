package androidx.paging;

import androidx.paging.AsyncPagedListDiffer;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagedListDiffer<T> mDiffer;
    private final AsyncPagedListDiffer.PagedListListener<T> mListener;

    public void onCurrentListChanged(PagedList<T> pagedList) {
    }

    protected PagedListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        C05611 r0 = new AsyncPagedListDiffer.PagedListListener<T>() {
            public void onCurrentListChanged(PagedList<T> pagedList) {
                PagedListAdapter.this.onCurrentListChanged(pagedList);
            }
        };
        this.mListener = r0;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>((RecyclerView.Adapter) this, itemCallback);
        this.mDiffer = asyncPagedListDiffer;
        asyncPagedListDiffer.mListener = r0;
    }

    protected PagedListAdapter(AsyncDifferConfig<T> asyncDifferConfig) {
        C05611 r0 = new AsyncPagedListDiffer.PagedListListener<T>() {
            public void onCurrentListChanged(PagedList<T> pagedList) {
                PagedListAdapter.this.onCurrentListChanged(pagedList);
            }
        };
        this.mListener = r0;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer = asyncPagedListDiffer;
        asyncPagedListDiffer.mListener = r0;
    }

    public void submitList(PagedList<T> pagedList) {
        this.mDiffer.submitList(pagedList);
    }

    /* access modifiers changed from: protected */
    public T getItem(int i) {
        return this.mDiffer.getItem(i);
    }

    public int getItemCount() {
        return this.mDiffer.getItemCount();
    }

    public PagedList<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }
}
