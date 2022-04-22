package androidx.paging;

import androidx.paging.PageResult;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import java.util.concurrent.Executor;

class TiledPagedList<T> extends PagedList<T> implements PagedStorage.Callback {
    /* access modifiers changed from: private */
    public final PositionalDataSource<T> mDataSource;
    /* access modifiers changed from: private */
    public PageResult.Receiver<T> mReceiver = new PageResult.Receiver<T>() {
        public void onPageResult(int i, PageResult<T> pageResult) {
            if (pageResult.isInvalid()) {
                TiledPagedList.this.detach();
            } else if (!TiledPagedList.this.isDetached()) {
                if (i == 0 || i == 3) {
                    if (TiledPagedList.this.mStorage.getPageCount() == 0) {
                        TiledPagedList.this.mStorage.initAndSplit(pageResult.leadingNulls, pageResult.page, pageResult.trailingNulls, pageResult.positionOffset, TiledPagedList.this.mConfig.pageSize, TiledPagedList.this);
                    } else {
                        TiledPagedList.this.mStorage.insertPage(pageResult.positionOffset, pageResult.page, TiledPagedList.this);
                    }
                    if (TiledPagedList.this.mBoundaryCallback != null) {
                        boolean z = true;
                        boolean z2 = TiledPagedList.this.mStorage.size() == 0;
                        boolean z3 = !z2 && pageResult.leadingNulls == 0 && pageResult.positionOffset == 0;
                        int size = TiledPagedList.this.size();
                        if (z2 || (!(i == 0 && pageResult.trailingNulls == 0) && (i != 3 || pageResult.positionOffset + TiledPagedList.this.mConfig.pageSize < size))) {
                            z = false;
                        }
                        TiledPagedList.this.deferBoundaryCallbacks(z2, z3, z);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("unexpected resultType" + i);
            }
        }
    };

    /* access modifiers changed from: package-private */
    public boolean isContiguous() {
        return false;
    }

    TiledPagedList(PositionalDataSource<T> positionalDataSource, Executor executor, Executor executor2, PagedList.BoundaryCallback<T> boundaryCallback, PagedList.Config config, int i) {
        super(new PagedStorage(), executor, executor2, boundaryCallback, config);
        this.mDataSource = positionalDataSource;
        int i2 = this.mConfig.pageSize;
        this.mLastLoad = i;
        if (positionalDataSource.isInvalid()) {
            detach();
            return;
        }
        int max = Math.max(Math.round((float) (this.mConfig.initialLoadSizeHint / i2)), 2) * i2;
        positionalDataSource.dispatchLoadInitial(true, Math.max(0, Math.round((float) ((i - (max / 2)) / i2)) * i2), max, i2, this.mMainThreadExecutor, this.mReceiver);
    }

    public DataSource<?, T> getDataSource() {
        return this.mDataSource;
    }

    public Object getLastKey() {
        return Integer.valueOf(this.mLastLoad);
    }

    /* access modifiers changed from: protected */
    public void dispatchUpdatesSinceSnapshot(PagedList<T> pagedList, PagedList.Callback callback) {
        PagedStorage<T> pagedStorage = pagedList.mStorage;
        if (pagedStorage.isEmpty() || this.mStorage.size() != pagedStorage.size()) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        int i = this.mConfig.pageSize;
        int leadingNullCount = this.mStorage.getLeadingNullCount() / i;
        int pageCount = this.mStorage.getPageCount();
        int i2 = 0;
        while (i2 < pageCount) {
            int i3 = i2 + leadingNullCount;
            int i4 = 0;
            while (i4 < this.mStorage.getPageCount()) {
                int i5 = i3 + i4;
                if (!this.mStorage.hasPage(i, i5) || pagedStorage.hasPage(i, i5)) {
                    break;
                }
                i4++;
            }
            if (i4 > 0) {
                callback.onChanged(i3 * i, i * i4);
                i2 += i4 - 1;
            }
            i2++;
        }
    }

    /* access modifiers changed from: protected */
    public void loadAroundInternal(int i) {
        this.mStorage.allocatePlaceholders(i, this.mConfig.prefetchDistance, this.mConfig.pageSize, this);
    }

    public void onInitialized(int i) {
        notifyInserted(0, i);
    }

    public void onPagePrepended(int i, int i2, int i3) {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public void onPageAppended(int i, int i2, int i3) {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public void onPagePlaceholderInserted(final int i) {
        this.mBackgroundThreadExecutor.execute(new Runnable() {
            public void run() {
                if (!TiledPagedList.this.isDetached()) {
                    int i = TiledPagedList.this.mConfig.pageSize;
                    if (TiledPagedList.this.mDataSource.isInvalid()) {
                        TiledPagedList.this.detach();
                        return;
                    }
                    int i2 = i * i;
                    TiledPagedList.this.mDataSource.dispatchLoadRange(3, i2, Math.min(i, TiledPagedList.this.mStorage.size() - i2), TiledPagedList.this.mMainThreadExecutor, TiledPagedList.this.mReceiver);
                }
            }
        });
    }

    public void onPageInserted(int i, int i2) {
        notifyChanged(i, i2);
    }
}
