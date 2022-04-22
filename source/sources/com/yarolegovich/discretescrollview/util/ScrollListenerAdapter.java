package com.yarolegovich.discretescrollview.util;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

public class ScrollListenerAdapter<T extends RecyclerView.ViewHolder> implements DiscreteScrollView.ScrollStateChangeListener<T> {
    private DiscreteScrollView.ScrollListener<T> adaptee;

    public void onScrollEnd(T t, int i) {
    }

    public void onScrollStart(T t, int i) {
    }

    public ScrollListenerAdapter(DiscreteScrollView.ScrollListener<T> scrollListener) {
        this.adaptee = scrollListener;
    }

    public void onScroll(float f, int i, int i2, T t, T t2) {
        this.adaptee.onScroll(f, i, i2, t, t2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ScrollListenerAdapter) {
            return this.adaptee.equals(((ScrollListenerAdapter) obj).adaptee);
        }
        return super.equals(obj);
    }
}
