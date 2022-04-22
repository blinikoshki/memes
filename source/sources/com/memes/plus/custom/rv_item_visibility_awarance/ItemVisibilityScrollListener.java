package com.memes.plus.custom.rv_item_visibility_awarance;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Lcom/memes/plus/custom/rv_item_visibility_awarance/ItemVisibilityScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "holderRect", "Landroid/graphics/Rect;", "scrollState", "", "checkVisibilityChangesOn", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onScrollStateChanged", "onScrolled", "dx", "dy", "updateActiveItem", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ItemVisibilityScrollListener.kt */
public abstract class ItemVisibilityScrollListener extends RecyclerView.OnScrollListener {
    private final Rect holderRect = new Rect();
    private final LinearLayoutManager layoutManager;
    private int scrollState = -1;

    public ItemVisibilityScrollListener(LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        this.layoutManager = linearLayoutManager;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.scrollState != 2) {
            updateActiveItem(recyclerView);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.scrollState = i;
        if (i == 0) {
            updateActiveItem(recyclerView);
        }
    }

    public final void checkVisibilityChangesOn(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.postDelayed(new ItemVisibilityScrollListener$checkVisibilityChangesOn$1(recyclerView), 200);
    }

    private final void updateActiveItem(RecyclerView recyclerView) {
        int findFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            while (true) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition instanceof VisibilityAware)) {
                    VisibilityAware visibilityAware = (VisibilityAware) findViewHolderForAdapterPosition;
                    View visibilityTargetView = visibilityAware.getVisibilityTargetView();
                    visibilityTargetView.getLocalVisibleRect(this.holderRect);
                    if (visibilityTargetView.getHeight() == this.holderRect.height() && this.holderRect.bottom >= 0 && this.holderRect.top == 0) {
                        visibilityAware.onVisibilityChanged(1);
                    } else {
                        visibilityAware.onVisibilityChanged(2);
                    }
                }
                if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                    findFirstVisibleItemPosition++;
                } else {
                    return;
                }
            }
        }
    }
}
