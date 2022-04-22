package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.concurrent.Executor;

public class AsyncPagedListDiffer<T> {
    final AsyncDifferConfig<T> mConfig;
    private boolean mIsContiguous;
    private int mLastAccessIndex;
    PagedListListener<T> mListener;
    Executor mMainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
    int mMaxScheduledGeneration;
    private PagedList<T> mPagedList;
    private PagedList.Callback mPagedListCallback = new PagedList.Callback() {
        public void onInserted(int i, int i2) {
            AsyncPagedListDiffer.this.mUpdateCallback.onInserted(i, i2);
        }

        public void onRemoved(int i, int i2) {
            AsyncPagedListDiffer.this.mUpdateCallback.onRemoved(i, i2);
        }

        public void onChanged(int i, int i2) {
            AsyncPagedListDiffer.this.mUpdateCallback.onChanged(i, i2, (Object) null);
        }
    };
    private PagedList<T> mSnapshot;
    final ListUpdateCallback mUpdateCallback;

    interface PagedListListener<T> {
        void onCurrentListChanged(PagedList<T> pagedList);
    }

    public AsyncPagedListDiffer(RecyclerView.Adapter adapter, DiffUtil.ItemCallback<T> itemCallback) {
        this.mUpdateCallback = new AdapterListUpdateCallback(adapter);
        this.mConfig = new AsyncDifferConfig.Builder(itemCallback).build();
    }

    public AsyncPagedListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
    }

    public T getItem(int i) {
        PagedList<T> pagedList = this.mPagedList;
        if (pagedList == null) {
            PagedList<T> pagedList2 = this.mSnapshot;
            if (pagedList2 != null) {
                return pagedList2.get(i);
            }
            throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
        }
        pagedList.loadAround(i);
        return this.mPagedList.get(i);
    }

    public int getItemCount() {
        PagedList<T> pagedList = this.mPagedList;
        if (pagedList != null) {
            return pagedList.size();
        }
        PagedList<T> pagedList2 = this.mSnapshot;
        if (pagedList2 == null) {
            return 0;
        }
        return pagedList2.size();
    }

    public void submitList(PagedList<T> pagedList) {
        if (pagedList != null) {
            if (this.mPagedList == null && this.mSnapshot == null) {
                this.mIsContiguous = pagedList.isContiguous();
            } else if (pagedList.isContiguous() != this.mIsContiguous) {
                throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
            }
        }
        final int i = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i;
        PagedList<T> pagedList2 = this.mPagedList;
        if (pagedList != pagedList2) {
            if (pagedList == null) {
                int itemCount = getItemCount();
                PagedList<T> pagedList3 = this.mPagedList;
                if (pagedList3 != null) {
                    pagedList3.removeWeakCallback(this.mPagedListCallback);
                    this.mPagedList = null;
                } else if (this.mSnapshot != null) {
                    this.mSnapshot = null;
                }
                this.mUpdateCallback.onRemoved(0, itemCount);
                PagedListListener<T> pagedListListener = this.mListener;
                if (pagedListListener != null) {
                    pagedListListener.onCurrentListChanged((PagedList<T>) null);
                }
            } else if (pagedList2 == null && this.mSnapshot == null) {
                this.mPagedList = pagedList;
                pagedList.addWeakCallback((List<T>) null, this.mPagedListCallback);
                this.mUpdateCallback.onInserted(0, pagedList.size());
                PagedListListener<T> pagedListListener2 = this.mListener;
                if (pagedListListener2 != null) {
                    pagedListListener2.onCurrentListChanged(pagedList);
                }
            } else {
                if (pagedList2 != null) {
                    pagedList2.removeWeakCallback(this.mPagedListCallback);
                    this.mSnapshot = (PagedList) this.mPagedList.snapshot();
                    this.mPagedList = null;
                }
                final PagedList<T> pagedList4 = this.mSnapshot;
                if (pagedList4 == null || this.mPagedList != null) {
                    throw new IllegalStateException("must be in snapshot state to diff");
                }
                final PagedList pagedList5 = (PagedList) pagedList.snapshot();
                final PagedList<T> pagedList6 = pagedList;
                this.mConfig.getBackgroundThreadExecutor().execute(new Runnable() {
                    public void run() {
                        final DiffUtil.DiffResult computeDiff = PagedStorageDiffHelper.computeDiff(pagedList4.mStorage, pagedList5.mStorage, AsyncPagedListDiffer.this.mConfig.getDiffCallback());
                        AsyncPagedListDiffer.this.mMainThreadExecutor.execute(new Runnable() {
                            public void run() {
                                if (AsyncPagedListDiffer.this.mMaxScheduledGeneration == i) {
                                    AsyncPagedListDiffer.this.latchPagedList(pagedList6, pagedList5, computeDiff, pagedList4.mLastLoad);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void latchPagedList(PagedList<T> pagedList, PagedList<T> pagedList2, DiffUtil.DiffResult diffResult, int i) {
        PagedList<T> pagedList3 = this.mSnapshot;
        if (pagedList3 == null || this.mPagedList != null) {
            throw new IllegalStateException("must be in snapshot state to apply diff");
        }
        this.mPagedList = pagedList;
        this.mSnapshot = null;
        PagedStorageDiffHelper.dispatchDiff(this.mUpdateCallback, pagedList3.mStorage, pagedList.mStorage, diffResult);
        pagedList.addWeakCallback(pagedList2, this.mPagedListCallback);
        int transformAnchorIndex = PagedStorageDiffHelper.transformAnchorIndex(diffResult, pagedList3.mStorage, pagedList2.mStorage, i);
        PagedList<T> pagedList4 = this.mPagedList;
        pagedList4.mLastLoad = Math.max(0, Math.min(pagedList4.size(), transformAnchorIndex));
        PagedListListener<T> pagedListListener = this.mListener;
        if (pagedListListener != null) {
            pagedListListener.onCurrentListChanged(this.mPagedList);
        }
    }

    public PagedList<T> getCurrentList() {
        PagedList<T> pagedList = this.mSnapshot;
        if (pagedList != null) {
            return pagedList;
        }
        return this.mPagedList;
    }
}
