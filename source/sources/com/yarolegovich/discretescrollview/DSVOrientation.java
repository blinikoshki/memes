package com.yarolegovich.discretescrollview;

import android.graphics.Point;
import android.view.View;

public enum DSVOrientation {
    HORIZONTAL {
        /* access modifiers changed from: package-private */
        public Helper createHelper() {
            return new HorizontalHelper();
        }
    },
    VERTICAL {
        /* access modifiers changed from: package-private */
        public Helper createHelper() {
            return new VerticalHelper();
        }
    };

    interface Helper {
        boolean canScrollHorizontally();

        boolean canScrollVertically();

        float getDistanceFromCenter(Point point, int i, int i2);

        int getDistanceToChangeCurrent(int i, int i2);

        int getFlingVelocity(int i, int i2);

        int getPendingDx(int i);

        int getPendingDy(int i);

        int getViewEnd(int i, int i2);

        boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager);

        boolean isViewVisible(Point point, int i, int i2, int i3, int i4);

        void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy);

        void setCurrentViewCenter(Point point, int i, Point point2);

        void shiftViewCenter(Direction direction, int i, Point point);
    }

    /* access modifiers changed from: package-private */
    public abstract Helper createHelper();

    protected static class HorizontalHelper implements Helper {
        public boolean canScrollHorizontally() {
            return true;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public int getDistanceToChangeCurrent(int i, int i2) {
            return i;
        }

        public int getFlingVelocity(int i, int i2) {
            return i;
        }

        public int getPendingDx(int i) {
            return i;
        }

        public int getPendingDy(int i) {
            return 0;
        }

        public int getViewEnd(int i, int i2) {
            return i;
        }

        protected HorizontalHelper() {
        }

        public void setCurrentViewCenter(Point point, int i, Point point2) {
            point2.set(point.x - i, point.y);
        }

        public void shiftViewCenter(Direction direction, int i, Point point) {
            point.set(point.x + direction.applyTo(i), point.y);
        }

        public boolean isViewVisible(Point point, int i, int i2, int i3, int i4) {
            return point.x - i < i3 + i4 && point.x + i > (-i4);
        }

        public boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager) {
            View firstChild = discreteScrollLayoutManager.getFirstChild();
            View lastChild = discreteScrollLayoutManager.getLastChild();
            int i = -discreteScrollLayoutManager.getExtraLayoutSpace();
            int width = discreteScrollLayoutManager.getWidth() + discreteScrollLayoutManager.getExtraLayoutSpace();
            boolean z = discreteScrollLayoutManager.getDecoratedLeft(firstChild) > i && discreteScrollLayoutManager.getPosition(firstChild) > 0;
            boolean z2 = discreteScrollLayoutManager.getDecoratedRight(lastChild) < width && discreteScrollLayoutManager.getPosition(lastChild) < discreteScrollLayoutManager.getItemCount() - 1;
            if (z || z2) {
                return true;
            }
            return false;
        }

        public void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy) {
            recyclerViewProxy.offsetChildrenHorizontal(i);
        }

        public float getDistanceFromCenter(Point point, int i, int i2) {
            return (float) (i - point.x);
        }
    }

    protected static class VerticalHelper implements Helper {
        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return true;
        }

        public int getDistanceToChangeCurrent(int i, int i2) {
            return i2;
        }

        public int getFlingVelocity(int i, int i2) {
            return i2;
        }

        public int getPendingDx(int i) {
            return 0;
        }

        public int getPendingDy(int i) {
            return i;
        }

        public int getViewEnd(int i, int i2) {
            return i2;
        }

        protected VerticalHelper() {
        }

        public void setCurrentViewCenter(Point point, int i, Point point2) {
            point2.set(point.x, point.y - i);
        }

        public void shiftViewCenter(Direction direction, int i, Point point) {
            point.set(point.x, point.y + direction.applyTo(i));
        }

        public void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy) {
            recyclerViewProxy.offsetChildrenVertical(i);
        }

        public float getDistanceFromCenter(Point point, int i, int i2) {
            return (float) (i2 - point.y);
        }

        public boolean isViewVisible(Point point, int i, int i2, int i3, int i4) {
            return point.y - i2 < i3 + i4 && point.y + i2 > (-i4);
        }

        public boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager) {
            View firstChild = discreteScrollLayoutManager.getFirstChild();
            View lastChild = discreteScrollLayoutManager.getLastChild();
            int i = -discreteScrollLayoutManager.getExtraLayoutSpace();
            int height = discreteScrollLayoutManager.getHeight() + discreteScrollLayoutManager.getExtraLayoutSpace();
            boolean z = discreteScrollLayoutManager.getDecoratedTop(firstChild) > i && discreteScrollLayoutManager.getPosition(firstChild) > 0;
            boolean z2 = discreteScrollLayoutManager.getDecoratedBottom(lastChild) < height && discreteScrollLayoutManager.getPosition(lastChild) < discreteScrollLayoutManager.getItemCount() - 1;
            if (z || z2) {
                return true;
            }
            return false;
        }
    }
}
