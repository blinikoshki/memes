package com.memes.commons.pagination;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/commons/pagination/Paginator;", "", "detach", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "disable", "enable", "enableResettingState", "resetState", "setOnLoadMoreListener", "listener", "Lcom/memes/commons/pagination/Paginator$OnLoadMoreListener;", "Companion", "OnLoadMoreListener", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Paginator.kt */
public interface Paginator {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo26107d2 = {"Lcom/memes/commons/pagination/Paginator$OnLoadMoreListener;", "", "onLoadMore", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Paginator.kt */
    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    void detach(RecyclerView recyclerView);

    void disable();

    void enable();

    void enableResettingState();

    void resetState();

    void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, mo26107d2 = {"Lcom/memes/commons/pagination/Paginator$Companion;", "", "()V", "create", "Lcom/memes/commons/pagination/Paginator;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "createClearingPreviousListeners", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Paginator.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Paginator create(RecyclerView.LayoutManager layoutManager, RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            PaginationThresholdScrollListener paginationThresholdScrollListener = new PaginationThresholdScrollListener(layoutManager);
            recyclerView.addOnScrollListener(paginationThresholdScrollListener);
            return paginationThresholdScrollListener;
        }

        public final Paginator createClearingPreviousListeners(RecyclerView.LayoutManager layoutManager, RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            recyclerView.clearOnScrollListeners();
            return create(layoutManager, recyclerView);
        }
    }
}
