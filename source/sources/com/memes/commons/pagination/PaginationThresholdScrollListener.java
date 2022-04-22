package com.memes.commons.pagination;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.pagination.Paginator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/commons/pagination/PaginationThresholdScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lcom/memes/commons/pagination/Paginator;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "currentPage", "", "enabled", "", "loadMoreListener", "Lcom/memes/commons/pagination/Paginator$OnLoadMoreListener;", "loading", "previousTotalItemCount", "startingPageIndex", "threshold", "detach", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "disable", "enable", "enableResettingState", "onScrolled", "recyclerView", "dx", "dy", "resetState", "setOnLoadMoreListener", "listener", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PaginationThresholdScrollListener.kt */
public final class PaginationThresholdScrollListener extends RecyclerView.OnScrollListener implements Paginator {
    private int currentPage;
    private boolean enabled = true;
    private final RecyclerView.LayoutManager layoutManager;
    private Paginator.OnLoadMoreListener loadMoreListener;
    private boolean loading = true;
    private int previousTotalItemCount;
    private final int startingPageIndex;
    private final int threshold = 8;

    public PaginationThresholdScrollListener(RecyclerView.LayoutManager layoutManager2) {
        Intrinsics.checkNotNullParameter(layoutManager2, "layoutManager");
        this.layoutManager = layoutManager2;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (!this.enabled) {
            super.onScrolled(recyclerView, i, i2);
            return;
        }
        RecyclerView.LayoutManager layoutManager2 = this.layoutManager;
        if (layoutManager2 instanceof LinearLayoutManager) {
            i3 = ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition();
        } else if (layoutManager2 instanceof GridLayoutManager) {
            i3 = ((GridLayoutManager) layoutManager2).findLastVisibleItemPosition();
        } else if (layoutManager2 instanceof StaggeredGridLayoutManager) {
            i3 = ((StaggeredGridLayoutManager) layoutManager2).findLastVisibleItemPositions(new int[3])[0];
        } else {
            i3 = 0;
        }
        int itemCount = this.layoutManager.getItemCount();
        if (itemCount < this.previousTotalItemCount) {
            this.currentPage = this.startingPageIndex;
            this.previousTotalItemCount = itemCount;
            if (itemCount == 0) {
                this.loading = true;
            }
        }
        if (this.loading && itemCount > this.previousTotalItemCount) {
            this.loading = false;
            this.previousTotalItemCount = itemCount;
        }
        if (!this.loading && i3 + this.threshold > itemCount) {
            this.currentPage++;
            Paginator.OnLoadMoreListener onLoadMoreListener = this.loadMoreListener;
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMore();
            }
            this.loading = true;
        }
    }

    public void setOnLoadMoreListener(Paginator.OnLoadMoreListener onLoadMoreListener) {
        Intrinsics.checkNotNullParameter(onLoadMoreListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.loadMoreListener = onLoadMoreListener;
    }

    public void enable() {
        this.enabled = true;
    }

    public void enableResettingState() {
        enable();
        resetState();
    }

    public void disable() {
        this.enabled = false;
    }

    public void resetState() {
        this.currentPage = this.startingPageIndex;
        this.previousTotalItemCount = 0;
        this.loading = true;
    }

    public void detach(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        recyclerView.removeOnScrollListener(this);
    }
}
