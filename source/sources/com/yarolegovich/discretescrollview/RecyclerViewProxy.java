package com.yarolegovich.discretescrollview;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewProxy {
    private RecyclerView.LayoutManager layoutManager;

    public RecyclerViewProxy(RecyclerView.LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public void attachView(View view) {
        this.layoutManager.attachView(view);
    }

    public void detachView(View view) {
        this.layoutManager.detachView(view);
    }

    public void detachAndScrapView(View view, RecyclerView.Recycler recycler) {
        this.layoutManager.detachAndScrapView(view, recycler);
    }

    public void detachAndScrapAttachedViews(RecyclerView.Recycler recycler) {
        this.layoutManager.detachAndScrapAttachedViews(recycler);
    }

    public void recycleView(View view, RecyclerView.Recycler recycler) {
        recycler.recycleView(view);
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        this.layoutManager.removeAndRecycleAllViews(recycler);
    }

    public int getChildCount() {
        return this.layoutManager.getChildCount();
    }

    public int getItemCount() {
        return this.layoutManager.getItemCount();
    }

    public View getMeasuredChildForAdapterPosition(int i, RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(i);
        this.layoutManager.addView(viewForPosition);
        this.layoutManager.measureChildWithMargins(viewForPosition, 0, 0);
        return viewForPosition;
    }

    public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
        this.layoutManager.layoutDecoratedWithMargins(view, i, i2, i3, i4);
    }

    public View getChildAt(int i) {
        return this.layoutManager.getChildAt(i);
    }

    public int getPosition(View view) {
        return this.layoutManager.getPosition(view);
    }

    public int getMeasuredWidthWithMargin(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return this.layoutManager.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    public int getMeasuredHeightWithMargin(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return this.layoutManager.getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public int getWidth() {
        return this.layoutManager.getWidth();
    }

    public int getHeight() {
        return this.layoutManager.getHeight();
    }

    public void offsetChildrenHorizontal(int i) {
        this.layoutManager.offsetChildrenHorizontal(i);
    }

    public void offsetChildrenVertical(int i) {
        this.layoutManager.offsetChildrenVertical(i);
    }

    public void requestLayout() {
        this.layoutManager.requestLayout();
    }

    public void startSmoothScroll(RecyclerView.SmoothScroller smoothScroller) {
        this.layoutManager.startSmoothScroll(smoothScroller);
    }

    public void removeAllViews() {
        this.layoutManager.removeAllViews();
    }
}
