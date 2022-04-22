package com.getstream.sdk.chat.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/EndlessScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "loadMoreThreshold", "", "loadMoreListener", "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "paginationEnabled", "", "scrollStateReset", "checkScrollDown", "dy", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "checkScrollUp", "disablePagination", "enablePagination", "onScrollStateChanged", "newState", "onScrolled", "dx", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EndlessScrollListener.kt */
public final class EndlessScrollListener extends RecyclerView.OnScrollListener {
    /* access modifiers changed from: private */
    public final Function0<Unit> loadMoreListener;
    private final int loadMoreThreshold;
    /* access modifiers changed from: private */
    public boolean paginationEnabled;
    private boolean scrollStateReset;

    public EndlessScrollListener(int i, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "loadMoreListener");
        this.loadMoreThreshold = i;
        this.loadMoreListener = function0;
        if (i >= 0) {
            this.scrollStateReset = true;
            return;
        }
        throw new IllegalArgumentException("Load more threshold must not be negative".toString());
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.paginationEnabled) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager.getStackFromEnd()) {
                    checkScrollUp(i2, linearLayoutManager, recyclerView);
                } else {
                    checkScrollDown(i2, linearLayoutManager, recyclerView);
                }
            } else {
                throw new IllegalStateException("EndlessScrollListener supports only LinearLayoutManager");
            }
        }
    }

    private final void checkScrollUp(int i, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView) {
        if (i < 0) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            if (this.scrollStateReset && findFirstVisibleItemPosition <= this.loadMoreThreshold) {
                this.scrollStateReset = false;
                recyclerView.post(new EndlessScrollListener$checkScrollUp$1(this));
            }
        }
    }

    private final void checkScrollDown(int i, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView) {
        if (i > 0) {
            int itemCount = linearLayoutManager.getItemCount() - linearLayoutManager.findLastVisibleItemPosition();
            if (this.scrollStateReset && itemCount <= this.loadMoreThreshold) {
                this.scrollStateReset = false;
                recyclerView.post(new EndlessScrollListener$checkScrollDown$1(this));
            }
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (i == 0 || i == 1) {
            this.scrollStateReset = true;
        }
    }

    public final void enablePagination() {
        this.paginationEnabled = true;
    }

    public final void disablePagination() {
        this.paginationEnabled = false;
    }
}
