package com.yarolegovich.discretescrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import com.yarolegovich.discretescrollview.util.ScrollListenerAdapter;
import java.util.ArrayList;
import java.util.List;

public class DiscreteScrollView extends RecyclerView {
    private static final int DEFAULT_ORIENTATION = DSVOrientation.HORIZONTAL.ordinal();
    public static final int NO_POSITION = -1;
    /* access modifiers changed from: private */
    public boolean isOverScrollEnabled;
    /* access modifiers changed from: private */
    public DiscreteScrollLayoutManager layoutManager;
    /* access modifiers changed from: private */
    public List<OnItemChangedListener> onItemChangedListeners;
    /* access modifiers changed from: private */
    public List<ScrollStateChangeListener> scrollStateChangeListeners;

    public interface OnItemChangedListener<T extends RecyclerView.ViewHolder> {
        void onCurrentItemChanged(T t, int i);
    }

    public interface ScrollListener<T extends RecyclerView.ViewHolder> {
        void onScroll(float f, int i, int i2, T t, T t2);
    }

    public interface ScrollStateChangeListener<T extends RecyclerView.ViewHolder> {
        void onScroll(float f, int i, int i2, T t, T t2);

        void onScrollEnd(T t, int i);

        void onScrollStart(T t, int i);
    }

    public DiscreteScrollView(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.scrollStateChangeListeners = new ArrayList();
        this.onItemChangedListeners = new ArrayList();
        int i = DEFAULT_ORIENTATION;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C4632R.styleable.DiscreteScrollView);
            i = obtainStyledAttributes.getInt(C4632R.styleable.DiscreteScrollView_dsv_orientation, i);
            obtainStyledAttributes.recycle();
        }
        this.isOverScrollEnabled = getOverScrollMode() != 2;
        DiscreteScrollLayoutManager discreteScrollLayoutManager = new DiscreteScrollLayoutManager(getContext(), new ScrollStateListener(), DSVOrientation.values()[i]);
        this.layoutManager = discreteScrollLayoutManager;
        setLayoutManager(discreteScrollLayoutManager);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager2) {
        if (layoutManager2 instanceof DiscreteScrollLayoutManager) {
            super.setLayoutManager(layoutManager2);
            return;
        }
        throw new IllegalArgumentException(getContext().getString(C4632R.string.dsv_ex_msg_dont_set_lm));
    }

    public boolean fling(int i, int i2) {
        boolean fling = super.fling(i, i2);
        if (fling) {
            this.layoutManager.onFling(i, i2);
        } else {
            this.layoutManager.returnToCurrentPosition();
        }
        return fling;
    }

    public RecyclerView.ViewHolder getViewHolder(int i) {
        View findViewByPosition = this.layoutManager.findViewByPosition(i);
        if (findViewByPosition != null) {
            return getChildViewHolder(findViewByPosition);
        }
        return null;
    }

    public int getCurrentItem() {
        return this.layoutManager.getCurrentPosition();
    }

    public void setItemTransformer(DiscreteScrollItemTransformer discreteScrollItemTransformer) {
        this.layoutManager.setItemTransformer(discreteScrollItemTransformer);
    }

    public void setItemTransitionTimeMillis(int i) {
        this.layoutManager.setTimeForItemSettle(i);
    }

    public void setSlideOnFling(boolean z) {
        this.layoutManager.setShouldSlideOnFling(z);
    }

    public void setSlideOnFlingThreshold(int i) {
        this.layoutManager.setSlideOnFlingThreshold(i);
    }

    public void setOrientation(DSVOrientation dSVOrientation) {
        this.layoutManager.setOrientation(dSVOrientation);
    }

    public void setOffscreenItems(int i) {
        this.layoutManager.setOffscreenItems(i);
    }

    public void setClampTransformProgressAfter(int i) {
        if (i > 1) {
            this.layoutManager.setTransformClampItemCount(i);
            return;
        }
        throw new IllegalArgumentException("must be >= 1");
    }

    public void setOverScrollEnabled(boolean z) {
        this.isOverScrollEnabled = z;
        setOverScrollMode(2);
    }

    public void addScrollStateChangeListener(ScrollStateChangeListener<?> scrollStateChangeListener) {
        this.scrollStateChangeListeners.add(scrollStateChangeListener);
    }

    public void addScrollListener(ScrollListener<?> scrollListener) {
        addScrollStateChangeListener(new ScrollListenerAdapter(scrollListener));
    }

    public void addOnItemChangedListener(OnItemChangedListener<?> onItemChangedListener) {
        this.onItemChangedListeners.add(onItemChangedListener);
    }

    public void removeScrollStateChangeListener(ScrollStateChangeListener<?> scrollStateChangeListener) {
        this.scrollStateChangeListeners.remove(scrollStateChangeListener);
    }

    public void removeScrollListener(ScrollListener<?> scrollListener) {
        removeScrollStateChangeListener(new ScrollListenerAdapter(scrollListener));
    }

    public void removeItemChangedListener(OnItemChangedListener<?> onItemChangedListener) {
        this.onItemChangedListeners.remove(onItemChangedListener);
    }

    /* access modifiers changed from: private */
    public void notifyScrollStart(RecyclerView.ViewHolder viewHolder, int i) {
        for (ScrollStateChangeListener onScrollStart : this.scrollStateChangeListeners) {
            onScrollStart.onScrollStart(viewHolder, i);
        }
    }

    /* access modifiers changed from: private */
    public void notifyScrollEnd(RecyclerView.ViewHolder viewHolder, int i) {
        for (ScrollStateChangeListener onScrollEnd : this.scrollStateChangeListeners) {
            onScrollEnd.onScrollEnd(viewHolder, i);
        }
    }

    /* access modifiers changed from: private */
    public void notifyScroll(float f, int i, int i2, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        for (ScrollStateChangeListener onScroll : this.scrollStateChangeListeners) {
            onScroll.onScroll(f, i, i2, viewHolder, viewHolder2);
        }
    }

    /* access modifiers changed from: private */
    public void notifyCurrentItemChanged(RecyclerView.ViewHolder viewHolder, int i) {
        for (OnItemChangedListener onCurrentItemChanged : this.onItemChangedListeners) {
            onCurrentItemChanged.onCurrentItemChanged(viewHolder, i);
        }
    }

    /* access modifiers changed from: private */
    public void notifyCurrentItemChanged() {
        if (!this.onItemChangedListeners.isEmpty()) {
            int currentPosition = this.layoutManager.getCurrentPosition();
            notifyCurrentItemChanged(getViewHolder(currentPosition), currentPosition);
        }
    }

    private class ScrollStateListener implements DiscreteScrollLayoutManager.ScrollStateListener {
        private ScrollStateListener() {
        }

        public void onIsBoundReachedFlagChange(boolean z) {
            if (DiscreteScrollView.this.isOverScrollEnabled) {
                DiscreteScrollView.this.setOverScrollMode(z ? 0 : 2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
            r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.access$300(r3.this$0).getCurrentPosition();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onScrollStart() {
            /*
                r3 = this;
                com.yarolegovich.discretescrollview.DiscreteScrollView r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                java.util.List r0 = r0.scrollStateChangeListeners
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x000d
                return
            L_0x000d:
                com.yarolegovich.discretescrollview.DiscreteScrollView r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager r0 = r0.layoutManager
                int r0 = r0.getCurrentPosition()
                com.yarolegovich.discretescrollview.DiscreteScrollView r1 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.getViewHolder(r0)
                if (r1 == 0) goto L_0x0024
                com.yarolegovich.discretescrollview.DiscreteScrollView r2 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                r2.notifyScrollStart(r1, r0)
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yarolegovich.discretescrollview.DiscreteScrollView.ScrollStateListener.onScrollStart():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
            r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.access$300(r3.this$0).getCurrentPosition();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onScrollEnd() {
            /*
                r3 = this;
                com.yarolegovich.discretescrollview.DiscreteScrollView r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                java.util.List r0 = r0.onItemChangedListeners
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0019
                com.yarolegovich.discretescrollview.DiscreteScrollView r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                java.util.List r0 = r0.scrollStateChangeListeners
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0019
                return
            L_0x0019:
                com.yarolegovich.discretescrollview.DiscreteScrollView r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager r0 = r0.layoutManager
                int r0 = r0.getCurrentPosition()
                com.yarolegovich.discretescrollview.DiscreteScrollView r1 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.getViewHolder(r0)
                if (r1 == 0) goto L_0x0035
                com.yarolegovich.discretescrollview.DiscreteScrollView r2 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                r2.notifyScrollEnd(r1, r0)
                com.yarolegovich.discretescrollview.DiscreteScrollView r2 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                r2.notifyCurrentItemChanged(r1, r0)
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yarolegovich.discretescrollview.DiscreteScrollView.ScrollStateListener.onScrollEnd():void");
        }

        public void onScroll(float f) {
            int currentItem;
            int nextPosition;
            if (!DiscreteScrollView.this.scrollStateChangeListeners.isEmpty() && (currentItem = DiscreteScrollView.this.getCurrentItem()) != (nextPosition = DiscreteScrollView.this.layoutManager.getNextPosition())) {
                DiscreteScrollView discreteScrollView = DiscreteScrollView.this;
                discreteScrollView.notifyScroll(f, currentItem, nextPosition, discreteScrollView.getViewHolder(currentItem), DiscreteScrollView.this.getViewHolder(nextPosition));
            }
        }

        public void onCurrentViewFirstLayout() {
            DiscreteScrollView.this.post(new Runnable() {
                public void run() {
                    DiscreteScrollView.this.notifyCurrentItemChanged();
                }
            });
        }

        public void onDataSetChangeChangedPosition() {
            DiscreteScrollView.this.notifyCurrentItemChanged();
        }
    }
}
