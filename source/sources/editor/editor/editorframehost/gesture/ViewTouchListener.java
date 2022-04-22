package editor.editor.editorframehost.gesture;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import editor.editor.editorframehost.gesture.ScaleGestureDetector;
import timber.log.Timber;

public class ViewTouchListener implements View.OnTouchListener {
    private static final int INVALID_POINTER_ID = -1;
    private int fingers = 0;
    private final GestureDetector gestureDetector;
    /* access modifiers changed from: private */
    public String identifier;
    /* access modifiers changed from: private */
    public boolean isRotateEnabled = true;
    /* access modifiers changed from: private */
    public boolean isScaleEnabled = true;
    /* access modifiers changed from: private */
    public boolean isTextPinchZoomable;
    /* access modifiers changed from: private */
    public boolean isTranslateEnabled = true;
    private int[] location = new int[2];
    private int mActivePointerId = -1;
    private float mPrevRawX;
    private float mPrevRawY;
    private float mPrevX;
    private float mPrevY;
    /* access modifiers changed from: private */
    public float maximumScale = 10.0f;
    /* access modifiers changed from: private */
    public float minimumScale = 0.5f;
    private Rect outRect;
    private FrameLayout parentView;
    private ScaleGestureDetector scaleGestureDetector;
    /* access modifiers changed from: private */
    public View targetView;
    /* access modifiers changed from: private */
    public ViewTouchCallback touchCallback;

    private static float adjustAngle(float f) {
        return f > 180.0f ? f - 360.0f : f < -180.0f ? f + 360.0f : f;
    }

    public ViewTouchListener(View view, FrameLayout frameLayout, boolean z, String str, ViewTouchCallback viewTouchCallback) {
        this.targetView = view;
        this.parentView = frameLayout;
        this.isTextPinchZoomable = z;
        this.identifier = str;
        this.touchCallback = viewTouchCallback;
        this.scaleGestureDetector = new ScaleGestureDetector(new ScaleGestureListener());
        this.gestureDetector = new GestureDetector(view.getContext(), new GestureListener());
        if (frameLayout != null) {
            this.outRect = new Rect(frameLayout.getLeft(), frameLayout.getTop(), frameLayout.getRight(), frameLayout.getBottom());
        } else {
            this.outRect = new Rect(0, 0, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public static void move(View view, TransformInfo transformInfo) {
        computeRenderOffset(view, transformInfo.pivotX, transformInfo.pivotY);
        adjustTranslation(view, transformInfo.deltaX, transformInfo.deltaY);
        float max = Math.max(transformInfo.minimumScale, Math.min(transformInfo.maximumScale, view.getScaleX() * transformInfo.deltaScale));
        view.setScaleX(max);
        view.setScaleY(max);
        view.setRotation(adjustAngle(view.getRotation() + transformInfo.deltaAngle));
    }

    private static void adjustTranslation(View view, float f, float f2) {
        float[] fArr = {f, f2};
        view.getMatrix().mapVectors(fArr);
        view.setTranslationX(view.getTranslationX() + fArr[0]);
        view.setTranslationY(view.getTranslationY() + fArr[1]);
    }

    private static void computeRenderOffset(View view, float f, float f2) {
        if (view.getPivotX() != f || view.getPivotY() != f2) {
            float[] fArr = {0.0f, 0.0f};
            view.getMatrix().mapPoints(fArr);
            view.setPivotX(f);
            view.setPivotY(f2);
            float[] fArr2 = {0.0f, 0.0f};
            view.getMatrix().mapPoints(fArr2);
            float f3 = fArr2[0] - fArr[0];
            float f4 = fArr2[1] - fArr[1];
            view.setTranslationX(view.getTranslationX() - f3);
            view.setTranslationY(view.getTranslationY() - f4);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.scaleGestureDetector.onTouchEvent(view, motionEvent);
        this.gestureDetector.onTouchEvent(motionEvent);
        if (!this.isTranslateEnabled) {
            return true;
        }
        int action = motionEvent.getAction();
        motionEvent.getRawX();
        motionEvent.getRawY();
        int actionMasked = motionEvent.getActionMasked() & action;
        int i = 0;
        if (actionMasked == 0) {
            Timber.m300d("ACTION_DOWN", new Object[0]);
            this.fingers = 1;
            this.mPrevX = motionEvent.getX();
            this.mPrevY = motionEvent.getY();
            this.mPrevRawX = motionEvent.getRawX();
            this.mPrevRawY = motionEvent.getRawY();
            this.mActivePointerId = motionEvent.getPointerId(0);
            view.bringToFront();
            ViewTouchCallback viewTouchCallback = this.touchCallback;
            if (viewTouchCallback != null) {
                viewTouchCallback.onOverlayViewDragStarted(this.identifier, view);
            }
        } else if (actionMasked == 1) {
            Timber.m300d("ACTION_UP", new Object[0]);
            this.fingers = 0;
            this.mActivePointerId = -1;
            ViewTouchCallback viewTouchCallback2 = this.touchCallback;
            if (viewTouchCallback2 != null) {
                viewTouchCallback2.onOverlayViewDragStopped(this.identifier, view);
            }
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex != -1) {
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                if (!this.scaleGestureDetector.isInProgress()) {
                    adjustTranslation(view, x - this.mPrevX, y - this.mPrevY);
                }
                ViewTouchCallback viewTouchCallback3 = this.touchCallback;
                if (viewTouchCallback3 != null) {
                    viewTouchCallback3.onOverlayViewDragging(this.identifier, view);
                }
            }
        } else if (actionMasked == 3) {
            Timber.m300d("ACTION_CANCEL", new Object[0]);
            this.mActivePointerId = -1;
        } else if (actionMasked == 5) {
            Timber.m300d("ACTION_POINTER_DOWN", new Object[0]);
            this.fingers++;
            ViewTouchCallback viewTouchCallback4 = this.touchCallback;
            if (viewTouchCallback4 != null) {
                viewTouchCallback4.onOverlayViewDragStopped(this.identifier, view);
            }
        } else if (actionMasked == 6) {
            Timber.m300d("ACTION_POINTER_UP", new Object[0]);
            this.fingers--;
            int i2 = (65280 & action) >> 8;
            if (motionEvent.getPointerId(i2) == this.mActivePointerId) {
                if (i2 == 0) {
                    i = 1;
                }
                this.mPrevX = motionEvent.getX(i);
                this.mPrevY = motionEvent.getY(i);
                this.mActivePointerId = motionEvent.getPointerId(i);
            }
        }
        return true;
    }

    private boolean isViewInBounds(View view, int i, int i2) {
        view.getDrawingRect(this.outRect);
        view.getLocationOnScreen(this.location);
        Rect rect = this.outRect;
        int[] iArr = this.location;
        rect.offset(iArr[0], iArr[1]);
        return this.outRect.contains(i, i2);
    }

    private class ScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private float mPivotX;
        private float mPivotY;
        private Vector2D mPrevSpanVector;

        private ScaleGestureListener() {
            this.mPrevSpanVector = new Vector2D();
        }

        public boolean onScaleBegin(View view, ScaleGestureDetector scaleGestureDetector) {
            this.mPivotX = scaleGestureDetector.getFocusX();
            this.mPivotY = scaleGestureDetector.getFocusY();
            this.mPrevSpanVector.set(scaleGestureDetector.getCurrentSpanVector());
            return ViewTouchListener.this.isTextPinchZoomable;
        }

        public boolean onScale(View view, ScaleGestureDetector scaleGestureDetector) {
            TransformInfo transformInfo = new TransformInfo();
            transformInfo.deltaScale = ViewTouchListener.this.isScaleEnabled ? scaleGestureDetector.getScaleFactor() : 1.0f;
            float f = 0.0f;
            transformInfo.deltaAngle = ViewTouchListener.this.isRotateEnabled ? Vector2D.Companion.getAngle(this.mPrevSpanVector, scaleGestureDetector.getCurrentSpanVector()) : 0.0f;
            transformInfo.deltaX = ViewTouchListener.this.isTranslateEnabled ? scaleGestureDetector.getFocusX() - this.mPivotX : 0.0f;
            if (ViewTouchListener.this.isTranslateEnabled) {
                f = scaleGestureDetector.getFocusY() - this.mPivotY;
            }
            transformInfo.deltaY = f;
            transformInfo.pivotX = this.mPivotX;
            transformInfo.pivotY = this.mPivotY;
            transformInfo.minimumScale = ViewTouchListener.this.minimumScale;
            transformInfo.maximumScale = ViewTouchListener.this.maximumScale;
            ViewTouchListener.move(view, transformInfo);
            return !ViewTouchListener.this.isTextPinchZoomable;
        }
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (ViewTouchListener.this.touchCallback == null) {
                return true;
            }
            ViewTouchListener.this.touchCallback.onOverlayViewTapped(ViewTouchListener.this.identifier, ViewTouchListener.this.targetView, false);
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            if (ViewTouchListener.this.touchCallback != null) {
                ViewTouchListener.this.touchCallback.onOverlayViewLongPressed(ViewTouchListener.this.identifier, ViewTouchListener.this.targetView);
            }
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ViewTouchListener.this.touchCallback != null) {
                ViewTouchListener.this.touchCallback.onOverlayViewTapped(ViewTouchListener.this.identifier, ViewTouchListener.this.targetView, true);
            }
            return true;
        }
    }
}
