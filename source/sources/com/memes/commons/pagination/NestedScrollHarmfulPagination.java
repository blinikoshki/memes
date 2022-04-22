package com.memes.commons.pagination;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/commons/pagination/NestedScrollHarmfulPagination;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "()V", "currentPage", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "loading", "", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "nextPageFunction", "Lkotlin/Function0;", "", "paginatedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "previousTotalItemCount", "recyclerView", "enablePagination", "findRecyclerView", "view", "Landroid/view/View;", "onScrollChanged", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "Not to be used.Causes OOM if you are caching data.Avoid using RecyclerView inside another Scroller.")
/* compiled from: NestedScrollHarmfulPagination.kt */
public final class NestedScrollHarmfulPagination implements ViewTreeObserver.OnScrollChangedListener {
    private int currentPage;
    private RecyclerView.LayoutManager layoutManager;
    private boolean loading = true;
    private NestedScrollView nestedScrollView;
    private Function0<Unit> nextPageFunction;
    private RecyclerView paginatedRecyclerView;
    private int previousTotalItemCount;
    private RecyclerView recyclerView;

    public final void enablePagination(NestedScrollView nestedScrollView2, RecyclerView recyclerView2, RecyclerView.LayoutManager layoutManager2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(nestedScrollView2, "nestedScrollView");
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        Intrinsics.checkNotNullParameter(layoutManager2, "layoutManager");
        Intrinsics.checkNotNullParameter(function0, "nextPageFunction");
        this.nestedScrollView = nestedScrollView2;
        this.recyclerView = recyclerView2;
        this.layoutManager = layoutManager2;
        this.nextPageFunction = function0;
        ViewCompat.setNestedScrollingEnabled(recyclerView2, false);
        ViewTreeObserver viewTreeObserver = nestedScrollView2.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnScrollChangedListener(this);
        }
        ViewTreeObserver viewTreeObserver2 = nestedScrollView2.getViewTreeObserver();
        if (viewTreeObserver2 != null) {
            viewTreeObserver2.addOnScrollChangedListener(this);
        }
    }

    public void onScrollChanged() {
        if (this.paginatedRecyclerView == null) {
            NestedScrollView nestedScrollView2 = this.nestedScrollView;
            if (nestedScrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
            }
            View childAt = nestedScrollView2.getChildAt(0);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            RecyclerView findRecyclerView = findRecyclerView((ViewGroup) childAt);
            if (findRecyclerView != null) {
                this.paginatedRecyclerView = findRecyclerView;
            }
        }
        RecyclerView recyclerView2 = this.paginatedRecyclerView;
        if (recyclerView2 != null) {
            RecyclerView.LayoutManager layoutManager2 = this.layoutManager;
            if (layoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            }
            int itemCount = layoutManager2.getItemCount();
            if (itemCount < this.previousTotalItemCount) {
                this.currentPage = 0;
                this.previousTotalItemCount = itemCount;
                if (itemCount == 0) {
                    this.loading = true;
                }
            }
            if (this.loading && itemCount > this.previousTotalItemCount) {
                this.loading = false;
                this.previousTotalItemCount = itemCount;
            }
            if (!this.loading) {
                int bottom = recyclerView2.getBottom();
                NestedScrollView nestedScrollView3 = this.nestedScrollView;
                if (nestedScrollView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
                }
                int height = nestedScrollView3.getHeight();
                NestedScrollView nestedScrollView4 = this.nestedScrollView;
                if (nestedScrollView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
                }
                if (bottom - (height + nestedScrollView4.getScrollY()) < 200) {
                    this.currentPage++;
                    Function0<Unit> function0 = this.nextPageFunction;
                    if (function0 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("nextPageFunction");
                    }
                    function0.invoke();
                    this.loading = true;
                }
            }
        }
    }

    private final RecyclerView findRecyclerView(View view) {
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(i)");
            RecyclerView findRecyclerView = findRecyclerView(childAt);
            if (findRecyclerView != null) {
                return findRecyclerView;
            }
        }
        return null;
    }
}
