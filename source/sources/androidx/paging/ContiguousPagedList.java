package androidx.paging;

import androidx.paging.PageResult;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import java.util.List;
import java.util.concurrent.Executor;

class ContiguousPagedList<K, V> extends PagedList<V> implements PagedStorage.Callback {
    static final int LAST_LOAD_UNSPECIFIED = -1;
    private int mAppendItemsRequested = 0;
    private boolean mAppendWorkerRunning = false;
    /* access modifiers changed from: private */
    public final ContiguousDataSource<K, V> mDataSource;
    private int mPrependItemsRequested = 0;
    private boolean mPrependWorkerRunning = false;
    /* access modifiers changed from: private */
    public PageResult.Receiver<V> mReceiver = new PageResult.Receiver<V>() {
        public void onPageResult(int i, PageResult<V> pageResult) {
            if (pageResult.isInvalid()) {
                ContiguousPagedList.this.detach();
            } else if (!ContiguousPagedList.this.isDetached()) {
                List<T> list = pageResult.page;
                boolean z = true;
                if (i == 0) {
                    ContiguousPagedList.this.mStorage.init(pageResult.leadingNulls, list, pageResult.trailingNulls, pageResult.positionOffset, ContiguousPagedList.this);
                    if (ContiguousPagedList.this.mLastLoad == -1) {
                        ContiguousPagedList.this.mLastLoad = pageResult.leadingNulls + pageResult.positionOffset + (list.size() / 2);
                    }
                } else if (i == 1) {
                    ContiguousPagedList.this.mStorage.appendPage(list, ContiguousPagedList.this);
                } else if (i == 2) {
                    ContiguousPagedList.this.mStorage.prependPage(list, ContiguousPagedList.this);
                } else {
                    throw new IllegalArgumentException("unexpected resultType " + i);
                }
                if (ContiguousPagedList.this.mBoundaryCallback != null) {
                    boolean z2 = ContiguousPagedList.this.mStorage.size() == 0;
                    boolean z3 = !z2 && i == 2 && pageResult.page.size() == 0;
                    if (!(!z2 && i == 1 && pageResult.page.size() == 0)) {
                        z = false;
                    }
                    ContiguousPagedList.this.deferBoundaryCallbacks(z2, z3, z);
                }
            }
        }
    };

    /* access modifiers changed from: package-private */
    public boolean isContiguous() {
        return true;
    }

    ContiguousPagedList(ContiguousDataSource<K, V> contiguousDataSource, Executor executor, Executor executor2, PagedList.BoundaryCallback<V> boundaryCallback, PagedList.Config config, K k, int i) {
        super(new PagedStorage(), executor, executor2, boundaryCallback, config);
        this.mDataSource = contiguousDataSource;
        this.mLastLoad = i;
        if (contiguousDataSource.isInvalid()) {
            detach();
            return;
        }
        contiguousDataSource.dispatchLoadInitial(k, this.mConfig.initialLoadSizeHint, this.mConfig.pageSize, this.mConfig.enablePlaceholders, this.mMainThreadExecutor, this.mReceiver);
    }

    /* access modifiers changed from: package-private */
    public void dispatchUpdatesSinceSnapshot(PagedList<V> pagedList, PagedList.Callback callback) {
        PagedStorage<T> pagedStorage = pagedList.mStorage;
        int numberAppended = this.mStorage.getNumberAppended() - pagedStorage.getNumberAppended();
        int numberPrepended = this.mStorage.getNumberPrepended() - pagedStorage.getNumberPrepended();
        int trailingNullCount = pagedStorage.getTrailingNullCount();
        int leadingNullCount = pagedStorage.getLeadingNullCount();
        if (pagedStorage.isEmpty() || numberAppended < 0 || numberPrepended < 0 || this.mStorage.getTrailingNullCount() != Math.max(trailingNullCount - numberAppended, 0) || this.mStorage.getLeadingNullCount() != Math.max(leadingNullCount - numberPrepended, 0) || this.mStorage.getStorageCount() != pagedStorage.getStorageCount() + numberAppended + numberPrepended) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        if (numberAppended != 0) {
            int min = Math.min(trailingNullCount, numberAppended);
            int i = numberAppended - min;
            int leadingNullCount2 = pagedStorage.getLeadingNullCount() + pagedStorage.getStorageCount();
            if (min != 0) {
                callback.onChanged(leadingNullCount2, min);
            }
            if (i != 0) {
                callback.onInserted(leadingNullCount2 + min, i);
            }
        }
        if (numberPrepended != 0) {
            int min2 = Math.min(leadingNullCount, numberPrepended);
            int i2 = numberPrepended - min2;
            if (min2 != 0) {
                callback.onChanged(leadingNullCount, min2);
            }
            if (i2 != 0) {
                callback.onInserted(0, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void loadAroundInternal(int i) {
        int leadingNullCount = this.mConfig.prefetchDistance - (i - this.mStorage.getLeadingNullCount());
        int leadingNullCount2 = (i + this.mConfig.prefetchDistance) - (this.mStorage.getLeadingNullCount() + this.mStorage.getStorageCount());
        int max = Math.max(leadingNullCount, this.mPrependItemsRequested);
        this.mPrependItemsRequested = max;
        if (max > 0) {
            schedulePrepend();
        }
        int max2 = Math.max(leadingNullCount2, this.mAppendItemsRequested);
        this.mAppendItemsRequested = max2;
        if (max2 > 0) {
            scheduleAppend();
        }
    }

    private void schedulePrepend() {
        if (!this.mPrependWorkerRunning) {
            this.mPrependWorkerRunning = true;
            final int leadingNullCount = this.mStorage.getLeadingNullCount() + this.mStorage.getPositionOffset();
            final Object firstLoadedItem = this.mStorage.getFirstLoadedItem();
            this.mBackgroundThreadExecutor.execute(new Runnable() {
                public void run() {
                    if (!ContiguousPagedList.this.isDetached()) {
                        if (ContiguousPagedList.this.mDataSource.isInvalid()) {
                            ContiguousPagedList.this.detach();
                        } else {
                            ContiguousPagedList.this.mDataSource.dispatchLoadBefore(leadingNullCount, firstLoadedItem, ContiguousPagedList.this.mConfig.pageSize, ContiguousPagedList.this.mMainThreadExecutor, ContiguousPagedList.this.mReceiver);
                        }
                    }
                }
            });
        }
    }

    private void scheduleAppend() {
        if (!this.mAppendWorkerRunning) {
            this.mAppendWorkerRunning = true;
            final int leadingNullCount = ((this.mStorage.getLeadingNullCount() + this.mStorage.getStorageCount()) - 1) + this.mStorage.getPositionOffset();
            final Object lastLoadedItem = this.mStorage.getLastLoadedItem();
            this.mBackgroundThreadExecutor.execute(new Runnable() {
                public void run() {
                    if (!ContiguousPagedList.this.isDetached()) {
                        if (ContiguousPagedList.this.mDataSource.isInvalid()) {
                            ContiguousPagedList.this.detach();
                        } else {
                            ContiguousPagedList.this.mDataSource.dispatchLoadAfter(leadingNullCount, lastLoadedItem, ContiguousPagedList.this.mConfig.pageSize, ContiguousPagedList.this.mMainThreadExecutor, ContiguousPagedList.this.mReceiver);
                        }
                    }
                }
            });
        }
    }

    public DataSource<?, V> getDataSource() {
        return this.mDataSource;
    }

    public Object getLastKey() {
        return this.mDataSource.getKey(this.mLastLoad, this.mLastItem);
    }

    public void onInitialized(int i) {
        notifyInserted(0, i);
    }

    public void onPagePrepended(int i, int i2, int i3) {
        int i4 = (this.mPrependItemsRequested - i2) - i3;
        this.mPrependItemsRequested = i4;
        this.mPrependWorkerRunning = false;
        if (i4 > 0) {
            schedulePrepend();
        }
        notifyChanged(i, i2);
        notifyInserted(0, i3);
        offsetAccessIndices(i3);
    }

    public void onPageAppended(int i, int i2, int i3) {
        int i4 = (this.mAppendItemsRequested - i2) - i3;
        this.mAppendItemsRequested = i4;
        this.mAppendWorkerRunning = false;
        if (i4 > 0) {
            scheduleAppend();
        }
        notifyChanged(i, i2);
        notifyInserted(i + i2, i3);
    }

    public void onPagePlaceholderInserted(int i) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }

    public void onPageInserted(int i, int i2) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }
}
