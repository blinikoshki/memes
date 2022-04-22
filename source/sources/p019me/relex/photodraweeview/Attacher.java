package p019me.relex.photodraweeview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.widget.ScrollerCompat;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import java.lang.ref.WeakReference;

/* renamed from: me.relex.photodraweeview.Attacher */
public class Attacher implements IAttacher, View.OnTouchListener, OnScaleDragGestureListener {
    private static final int EDGE_BOTH = 2;
    private static final int EDGE_LEFT = 0;
    private static final int EDGE_NONE = -1;
    private static final int EDGE_RIGHT = 1;
    private boolean mAllowParentInterceptOnEdge = true;
    private boolean mBlockParentIntercept = false;
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect = new RectF();
    private WeakReference<DraweeView<GenericDraweeHierarchy>> mDraweeView;
    private GestureDetectorCompat mGestureDetector;
    private int mImageInfoHeight = -1;
    private int mImageInfoWidth = -1;
    /* access modifiers changed from: private */
    public View.OnLongClickListener mLongClickListener;
    /* access modifiers changed from: private */
    public final Matrix mMatrix = new Matrix();
    private final float[] mMatrixValues = new float[9];
    private float mMaxScale = 3.0f;
    private float mMidScale = 1.75f;
    private float mMinScale = 1.0f;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangeListener mScaleChangeListener;
    private ScaleDragDetector mScaleDragDetector;
    private int mScrollEdge = 2;
    private OnViewTapListener mViewTapListener;
    /* access modifiers changed from: private */
    public long mZoomDuration = 200;
    /* access modifiers changed from: private */
    public final Interpolator mZoomInterpolator = new AccelerateDecelerateInterpolator();

    public Attacher(DraweeView<GenericDraweeHierarchy> draweeView) {
        this.mDraweeView = new WeakReference<>(draweeView);
        draweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        draweeView.setOnTouchListener(this);
        this.mScaleDragDetector = new ScaleDragDetector(draweeView.getContext(), this);
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(draweeView.getContext(), new GestureDetector.SimpleOnGestureListener() {
            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
                if (Attacher.this.mLongClickListener != null) {
                    Attacher.this.mLongClickListener.onLongClick(Attacher.this.getDraweeView());
                }
            }
        });
        this.mGestureDetector = gestureDetectorCompat;
        gestureDetectorCompat.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
        }
    }

    public DraweeView<GenericDraweeHierarchy> getDraweeView() {
        return (DraweeView) this.mDraweeView.get();
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public void setMaximumScale(float f) {
        checkZoomLevels(this.mMinScale, this.mMidScale, f);
        this.mMaxScale = f;
    }

    public void setMediumScale(float f) {
        checkZoomLevels(this.mMinScale, f, this.mMaxScale);
        this.mMidScale = f;
    }

    public void setMinimumScale(float f) {
        checkZoomLevels(f, this.mMidScale, this.mMaxScale);
        this.mMinScale = f;
    }

    public float getScale() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) getMatrixValue(this.mMatrix, 0), 2.0d)) + ((float) Math.pow((double) getMatrixValue(this.mMatrix, 3), 2.0d))));
    }

    public void setScale(float f) {
        setScale(f, false);
    }

    public void setScale(float f, boolean z) {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null) {
            setScale(f, (float) (draweeView.getRight() / 2), (float) (draweeView.getBottom() / 2), false);
        }
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null && f >= this.mMinScale && f <= this.mMaxScale) {
            if (z) {
                draweeView.post(new AnimatedZoomRunnable(getScale(), f, f2, f3));
                return;
            }
            this.mMatrix.setScale(f, f, f2, f3);
            checkMatrixAndInvalidate();
        }
    }

    public void setZoomTransitionDuration(long j) {
        if (j < 0) {
            j = 200;
        }
        this.mZoomDuration = j;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.mScaleChangeListener = onScaleChangeListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    public OnPhotoTapListener getOnPhotoTapListener() {
        return this.mPhotoTapListener;
    }

    public OnViewTapListener getOnViewTapListener() {
        return this.mViewTapListener;
    }

    public void update(int i, int i2) {
        this.mImageInfoWidth = i;
        this.mImageInfoHeight = i2;
        updateBaseMatrix();
    }

    private static void checkZoomLevels(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        } else if (f2 >= f3) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private int getViewWidth() {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null) {
            return (draweeView.getWidth() - draweeView.getPaddingLeft()) - draweeView.getPaddingRight();
        }
        return 0;
    }

    private int getViewHeight() {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null) {
            return (draweeView.getHeight() - draweeView.getPaddingTop()) - draweeView.getPaddingBottom();
        }
        return 0;
    }

    private float getMatrixValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    public Matrix getDrawMatrix() {
        return this.mMatrix;
    }

    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public void checkMatrixAndInvalidate() {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null && checkMatrixBounds()) {
            draweeView.invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkMatrixBounds() {
        /*
            r9 = this;
            android.graphics.Matrix r0 = r9.getDrawMatrix()
            android.graphics.RectF r0 = r9.getDisplayRect(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            float r2 = r0.height()
            float r3 = r0.width()
            int r4 = r9.getViewHeight()
            float r4 = (float) r4
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0026
            float r4 = r4 - r2
            float r4 = r4 / r5
            float r2 = r0.top
        L_0x0024:
            float r4 = r4 - r2
            goto L_0x003a
        L_0x0026:
            float r2 = r0.top
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x0030
            float r2 = r0.top
            float r4 = -r2
            goto L_0x003a
        L_0x0030:
            float r2 = r0.bottom
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0039
            float r2 = r0.bottom
            goto L_0x0024
        L_0x0039:
            r4 = 0
        L_0x003a:
            int r2 = r9.getViewWidth()
            float r2 = (float) r2
            r7 = 1
            int r8 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r8 > 0) goto L_0x004e
            float r2 = r2 - r3
            float r2 = r2 / r5
            float r0 = r0.left
            float r6 = r2 - r0
            r0 = 2
            r9.mScrollEdge = r0
            goto L_0x006a
        L_0x004e:
            float r3 = r0.left
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x005a
            float r0 = r0.left
            float r6 = -r0
            r9.mScrollEdge = r1
            goto L_0x006a
        L_0x005a:
            float r1 = r0.right
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0067
            float r0 = r0.right
            float r6 = r2 - r0
            r9.mScrollEdge = r7
            goto L_0x006a
        L_0x0067:
            r0 = -1
            r9.mScrollEdge = r0
        L_0x006a:
            android.graphics.Matrix r0 = r9.mMatrix
            r0.postTranslate(r6, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p019me.relex.photodraweeview.Attacher.checkMatrixBounds():boolean");
    }

    private RectF getDisplayRect(Matrix matrix) {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView == null) {
            return null;
        }
        int i = this.mImageInfoWidth;
        if (i == -1 && this.mImageInfoHeight == -1) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, (float) i, (float) this.mImageInfoHeight);
        draweeView.getHierarchy().getActualImageBounds(this.mDisplayRect);
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    private void updateBaseMatrix() {
        if (this.mImageInfoWidth != -1 || this.mImageInfoHeight != -1) {
            resetMatrix();
        }
    }

    private void resetMatrix() {
        this.mMatrix.reset();
        checkMatrixBounds();
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null) {
            draweeView.invalidate();
        }
    }

    private void checkMinScale() {
        RectF displayRect;
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null && getScale() < this.mMinScale && (displayRect = getDisplayRect()) != null) {
            draweeView.post(new AnimatedZoomRunnable(getScale(), this.mMinScale, displayRect.centerX(), displayRect.centerY()));
        }
    }

    public void onScale(float f, float f2, float f3) {
        if (getScale() < this.mMaxScale || f < 1.0f) {
            OnScaleChangeListener onScaleChangeListener = this.mScaleChangeListener;
            if (onScaleChangeListener != null) {
                onScaleChangeListener.onScaleChange(f, f2, f3);
            }
            this.mMatrix.postScale(f, f, f2, f3);
            checkMatrixAndInvalidate();
        }
    }

    public void onScaleEnd() {
        checkMinScale();
    }

    public void onDrag(float f, float f2) {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null && !this.mScaleDragDetector.isScaling()) {
            this.mMatrix.postTranslate(f, f2);
            checkMatrixAndInvalidate();
            ViewParent parent = draweeView.getParent();
            if (parent != null) {
                if (!this.mAllowParentInterceptOnEdge || this.mScaleDragDetector.isScaling() || this.mBlockParentIntercept) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                int i = this.mScrollEdge;
                if (i == 2 || ((i == 0 && f >= 1.0f) || (i == 1 && f <= -1.0f))) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }
    }

    public void onFling(float f, float f2, float f3, float f4) {
        DraweeView<GenericDraweeHierarchy> draweeView = getDraweeView();
        if (draweeView != null) {
            FlingRunnable flingRunnable = new FlingRunnable(draweeView.getContext());
            this.mCurrentFlingRunnable = flingRunnable;
            flingRunnable.fling(getViewWidth(), getViewHeight(), (int) f3, (int) f4);
            draweeView.post(this.mCurrentFlingRunnable);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        ViewParent parent;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            ViewParent parent2 = view.getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
            cancelFling();
        } else if ((actionMasked == 1 || actionMasked == 3) && (parent = view.getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        boolean isScaling = this.mScaleDragDetector.isScaling();
        boolean isDragging = this.mScaleDragDetector.isDragging();
        boolean onTouchEvent = this.mScaleDragDetector.onTouchEvent(motionEvent);
        boolean z2 = !isScaling && !this.mScaleDragDetector.isScaling();
        boolean z3 = !isDragging && !this.mScaleDragDetector.isDragging();
        if (z2 && z3) {
            z = true;
        }
        this.mBlockParentIntercept = z;
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        return onTouchEvent;
    }

    /* renamed from: me.relex.photodraweeview.Attacher$AnimatedZoomRunnable */
    private class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        public void run() {
            DraweeView<GenericDraweeHierarchy> draweeView = Attacher.this.getDraweeView();
            if (draweeView != null) {
                float interpolate = interpolate();
                float f = this.mZoomStart;
                Attacher.this.onScale((f + ((this.mZoomEnd - f) * interpolate)) / Attacher.this.getScale(), this.mFocalX, this.mFocalY);
                if (interpolate < 1.0f) {
                    Attacher.this.postOnAnimation(draweeView, this);
                }
            }
        }

        private float interpolate() {
            return Attacher.this.mZoomInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / ((float) Attacher.this.mZoomDuration)));
        }
    }

    /* renamed from: me.relex.photodraweeview.Attacher$FlingRunnable */
    private class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerCompat mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = ScrollerCompat.create(context);
        }

        public void cancelFling() {
            this.mScroller.abortAnimation();
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF displayRect = Attacher.this.getDisplayRect();
            if (displayRect != null) {
                int round = Math.round(-displayRect.left);
                float f = (float) i;
                if (f < displayRect.width()) {
                    i5 = Math.round(displayRect.width() - f);
                    i6 = 0;
                } else {
                    i6 = round;
                    i5 = i6;
                }
                int round2 = Math.round(-displayRect.top);
                float f2 = (float) i2;
                if (f2 < displayRect.height()) {
                    i7 = Math.round(displayRect.height() - f2);
                    i8 = 0;
                } else {
                    i8 = round2;
                    i7 = i8;
                }
                this.mCurrentX = round;
                this.mCurrentY = round2;
                if (round != i5 || round2 != i7) {
                    this.mScroller.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        public void run() {
            DraweeView<GenericDraweeHierarchy> draweeView;
            if (!this.mScroller.isFinished() && (draweeView = Attacher.this.getDraweeView()) != null && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                Attacher.this.mMatrix.postTranslate((float) (this.mCurrentX - currX), (float) (this.mCurrentY - currY));
                draweeView.invalidate();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                Attacher.this.postOnAnimation(draweeView, this);
            }
        }
    }

    private void cancelFling() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    /* access modifiers changed from: private */
    public void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        cancelFling();
    }
}
