package editor.signature.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import editor.signature.C4903R;
import editor.signature.utils.Bezier;
import editor.signature.utils.ControlTimedPoints;
import editor.signature.utils.SvgBuilder;
import editor.signature.utils.TimedPoint;
import editor.signature.view.ViewCompat;
import editor.signature.view.ViewTreeObserverCompat;
import java.util.ArrayList;
import java.util.List;

public class SignaturePad extends View {
    private static final String TAG = "editor.signature.views.SignaturePad";
    private final boolean DEFAULT_ATTR_CLEAR_ON_DOUBLE_CLICK = false;
    private final int DEFAULT_ATTR_PEN_COLOR = -16777216;
    private final int DEFAULT_ATTR_PEN_MAX_WIDTH_PX = 7;
    private final int DEFAULT_ATTR_PEN_MIN_WIDTH_PX = 3;
    private final boolean DEFAULT_ATTR_SAVE_STATE = true;
    private final float DEFAULT_ATTR_VELOCITY_FILTER_WEIGHT = 0.9f;
    private Bezier mBezierCached = new Bezier();
    private Bitmap mBitmapSavedState;
    private boolean mClearOnDoubleClick;
    private ControlTimedPoints mControlTimedPointsCached = new ControlTimedPoints();
    private RectF mDirtyRect;
    private GestureDetector mGestureDetector;
    private Boolean mHasEditState;
    private boolean mIsEmpty;
    private float mLastTouchX;
    private float mLastTouchY;
    private float mLastVelocity;
    private float mLastWidth;
    private int mMaxWidth;
    private int mMinWidth;
    private OnSignedListener mOnSignedListener;
    private Paint mPaint = new Paint();
    private List<TimedPoint> mPoints;
    private List<TimedPoint> mPointsCache = new ArrayList();
    private Bitmap mSignatureBitmap = null;
    private Canvas mSignatureBitmapCanvas = null;
    private final SvgBuilder mSvgBuilder = new SvgBuilder();
    private float mVelocityFilterWeight;

    public interface OnSignedListener {
        void onClear();

        void onSigned();

        void onStartSigning();
    }

    /* JADX INFO: finally extract failed */
    public SignaturePad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4903R.styleable.SignaturePad, 0, 0);
        try {
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(C4903R.styleable.SignaturePad_penMinWidth, convertDpToPx(3.0f));
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(C4903R.styleable.SignaturePad_penMaxWidth, convertDpToPx(7.0f));
            this.mPaint.setColor(obtainStyledAttributes.getColor(C4903R.styleable.SignaturePad_penColor, -16777216));
            this.mVelocityFilterWeight = obtainStyledAttributes.getFloat(C4903R.styleable.SignaturePad_velocityFilterWeight, 0.9f);
            this.mClearOnDoubleClick = obtainStyledAttributes.getBoolean(C4903R.styleable.SignaturePad_clearOnDoubleClick, false);
            obtainStyledAttributes.recycle();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mPaint.setStrokeJoin(Paint.Join.ROUND);
            this.mDirtyRect = new RectF();
            clearView();
            this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    return SignaturePad.this.onDoubleClick();
                }
            });
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        try {
            Bundle bundle = new Bundle();
            bundle.putParcelable("superState", super.onSaveInstanceState());
            Boolean bool = this.mHasEditState;
            if (bool == null || bool.booleanValue()) {
                this.mBitmapSavedState = getTransparentSignatureBitmap();
            }
            bundle.putParcelable("signatureBitmap", this.mBitmapSavedState);
            return bundle;
        } catch (Exception e) {
            Log.w(TAG, String.format("Error saving instance state: %s", new Object[]{e.getMessage()}));
            return super.onSaveInstanceState();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setSignatureBitmap((Bitmap) bundle.getParcelable("signatureBitmap"));
            this.mBitmapSavedState = (Bitmap) bundle.getParcelable("signatureBitmap");
            parcelable = bundle.getParcelable("superState");
        }
        this.mHasEditState = false;
        super.onRestoreInstanceState(parcelable);
    }

    public void setPenColorRes(int i) {
        try {
            setPenColor(getResources().getColor(i));
        } catch (Resources.NotFoundException unused) {
            setPenColor(Color.parseColor("#000000"));
        }
    }

    public void setPenColor(int i) {
        this.mPaint.setColor(i);
    }

    public void setMinWidth(float f) {
        int convertDpToPx = convertDpToPx(f);
        this.mMinWidth = convertDpToPx;
        this.mLastWidth = ((float) (convertDpToPx + this.mMaxWidth)) / 2.0f;
    }

    public void setMaxWidth(float f) {
        int convertDpToPx = convertDpToPx(f);
        this.mMaxWidth = convertDpToPx;
        this.mLastWidth = ((float) (this.mMinWidth + convertDpToPx)) / 2.0f;
    }

    public void setVelocityFilterWeight(float f) {
        this.mVelocityFilterWeight = f;
    }

    public void clearView() {
        this.mSvgBuilder.clear();
        this.mPoints = new ArrayList();
        this.mLastVelocity = 0.0f;
        this.mLastWidth = ((float) (this.mMinWidth + this.mMaxWidth)) / 2.0f;
        if (this.mSignatureBitmap != null) {
            this.mSignatureBitmap = null;
            ensureSignatureBitmap();
        }
        setIsEmpty(true);
        invalidate();
    }

    public void clear() {
        clearView();
        this.mHasEditState = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.mPoints.clear();
            if (!this.mGestureDetector.onTouchEvent(motionEvent)) {
                this.mLastTouchX = x;
                this.mLastTouchY = y;
                addPoint(getNewPoint(x, y));
                OnSignedListener onSignedListener = this.mOnSignedListener;
                if (onSignedListener != null) {
                    onSignedListener.onStartSigning();
                }
            }
            invalidate((int) (this.mDirtyRect.left - ((float) this.mMaxWidth)), (int) (this.mDirtyRect.top - ((float) this.mMaxWidth)), (int) (this.mDirtyRect.right + ((float) this.mMaxWidth)), (int) (this.mDirtyRect.bottom + ((float) this.mMaxWidth)));
            return true;
        } else if (action == 1) {
            resetDirtyRect(x, y);
            addPoint(getNewPoint(x, y));
            getParent().requestDisallowInterceptTouchEvent(true);
            invalidate((int) (this.mDirtyRect.left - ((float) this.mMaxWidth)), (int) (this.mDirtyRect.top - ((float) this.mMaxWidth)), (int) (this.mDirtyRect.right + ((float) this.mMaxWidth)), (int) (this.mDirtyRect.bottom + ((float) this.mMaxWidth)));
            return true;
        } else if (action != 2) {
            return false;
        }
        resetDirtyRect(x, y);
        addPoint(getNewPoint(x, y));
        setIsEmpty(false);
        invalidate((int) (this.mDirtyRect.left - ((float) this.mMaxWidth)), (int) (this.mDirtyRect.top - ((float) this.mMaxWidth)), (int) (this.mDirtyRect.right + ((float) this.mMaxWidth)), (int) (this.mDirtyRect.bottom + ((float) this.mMaxWidth)));
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.mSignatureBitmap;
        if (bitmap != null && bitmap.isRecycled()) {
            this.mSignatureBitmap = null;
        }
        ensureSignatureBitmap();
        canvas.drawBitmap(this.mSignatureBitmap, 0.0f, 0.0f, this.mPaint);
    }

    public void setOnSignedListener(OnSignedListener onSignedListener) {
        this.mOnSignedListener = onSignedListener;
    }

    public boolean isEmpty() {
        return this.mIsEmpty;
    }

    public String getSignatureSvg() {
        return this.mSvgBuilder.build(getTransparentSignatureBitmap().getWidth(), getTransparentSignatureBitmap().getHeight());
    }

    public Bitmap getSignatureBitmap() {
        Bitmap transparentSignatureBitmap = getTransparentSignatureBitmap();
        Bitmap createBitmap = Bitmap.createBitmap(transparentSignatureBitmap.getWidth(), transparentSignatureBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(transparentSignatureBitmap, 0.0f, 0.0f, (Paint) null);
        return createBitmap;
    }

    public void setSignatureBitmap(final Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            Log.w(TAG, "Null bitmap passed to setSignatureBitmap(); clearing pad and returning;");
            clear();
        } else if (ViewCompat.isLaidOut(this)) {
            clearView();
            ensureSignatureBitmap();
            RectF rectF = new RectF();
            RectF rectF2 = new RectF();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            rectF.set(0.0f, 0.0f, (float) width, (float) height);
            rectF2.set(0.0f, 0.0f, (float) width2, (float) height2);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            new Canvas(this.mSignatureBitmap).drawBitmap(bitmap, matrix, (Paint) null);
            setIsEmpty(false);
            invalidate();
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ViewTreeObserverCompat.removeOnGlobalLayoutListener(SignaturePad.this.getViewTreeObserver(), this);
                    SignaturePad.this.setSignatureBitmap(bitmap);
                }
            });
        }
    }

    public Bitmap getTransparentSignatureBitmap() {
        ensureSignatureBitmap();
        return this.mSignatureBitmap;
    }

    public Bitmap getTransparentSignatureBitmap(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (!z) {
            return getTransparentSignatureBitmap();
        }
        ensureSignatureBitmap();
        int height = this.mSignatureBitmap.getHeight();
        int width = this.mSignatureBitmap.getWidth();
        int i = Integer.MAX_VALUE;
        boolean z6 = false;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < width; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= height) {
                    z5 = false;
                    break;
                } else if (this.mSignatureBitmap.getPixel(i3, i4) != 0) {
                    i2 = i3;
                    z6 = true;
                    z5 = true;
                    break;
                } else {
                    i4++;
                }
            }
            if (z5) {
                break;
            }
        }
        if (!z6) {
            return null;
        }
        for (int i5 = 0; i5 < height; i5++) {
            int i6 = i2;
            while (true) {
                if (i6 >= width) {
                    z4 = false;
                    break;
                } else if (this.mSignatureBitmap.getPixel(i6, i5) != 0) {
                    i = i5;
                    z4 = true;
                    break;
                } else {
                    i6++;
                }
            }
            if (z4) {
                break;
            }
        }
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MIN_VALUE;
        for (int i9 = width - 1; i9 >= i2; i9--) {
            int i10 = i;
            while (true) {
                if (i10 >= height) {
                    z3 = false;
                    break;
                } else if (this.mSignatureBitmap.getPixel(i9, i10) != 0) {
                    i8 = i9;
                    z3 = true;
                    break;
                } else {
                    i10++;
                }
            }
            if (z3) {
                break;
            }
        }
        for (int i11 = height - 1; i11 >= i; i11--) {
            int i12 = i2;
            while (true) {
                if (i12 > i8) {
                    z2 = false;
                    break;
                } else if (this.mSignatureBitmap.getPixel(i12, i11) != 0) {
                    i7 = i11;
                    z2 = true;
                    break;
                } else {
                    i12++;
                }
            }
            if (z2) {
                break;
            }
        }
        return Bitmap.createBitmap(this.mSignatureBitmap, i2, i, i8 - i2, i7 - i);
    }

    /* access modifiers changed from: private */
    public boolean onDoubleClick() {
        if (!this.mClearOnDoubleClick) {
            return false;
        }
        clearView();
        return true;
    }

    private TimedPoint getNewPoint(float f, float f2) {
        TimedPoint timedPoint;
        int size = this.mPointsCache.size();
        if (size == 0) {
            timedPoint = new TimedPoint();
        } else {
            timedPoint = this.mPointsCache.remove(size - 1);
        }
        return timedPoint.set(f, f2);
    }

    private void recyclePoint(TimedPoint timedPoint) {
        this.mPointsCache.add(timedPoint);
    }

    private void addPoint(TimedPoint timedPoint) {
        this.mPoints.add(timedPoint);
        int size = this.mPoints.size();
        if (size > 3) {
            ControlTimedPoints calculateCurveControlPoints = calculateCurveControlPoints(this.mPoints.get(0), this.mPoints.get(1), this.mPoints.get(2));
            TimedPoint timedPoint2 = calculateCurveControlPoints.f1437c2;
            recyclePoint(calculateCurveControlPoints.f1436c1);
            ControlTimedPoints calculateCurveControlPoints2 = calculateCurveControlPoints(this.mPoints.get(1), this.mPoints.get(2), this.mPoints.get(3));
            TimedPoint timedPoint3 = calculateCurveControlPoints2.f1436c1;
            recyclePoint(calculateCurveControlPoints2.f1437c2);
            Bezier bezier = this.mBezierCached.set(this.mPoints.get(1), timedPoint2, timedPoint3, this.mPoints.get(2));
            float velocityFrom = bezier.endPoint.velocityFrom(bezier.startPoint);
            if (Float.isNaN(velocityFrom)) {
                velocityFrom = 0.0f;
            }
            float f = this.mVelocityFilterWeight;
            float f2 = (velocityFrom * f) + ((1.0f - f) * this.mLastVelocity);
            float strokeWidth = strokeWidth(f2);
            addBezier(bezier, this.mLastWidth, strokeWidth);
            this.mLastVelocity = f2;
            this.mLastWidth = strokeWidth;
            recyclePoint(this.mPoints.remove(0));
            recyclePoint(timedPoint2);
            recyclePoint(timedPoint3);
        } else if (size == 1) {
            TimedPoint timedPoint4 = this.mPoints.get(0);
            this.mPoints.add(getNewPoint(timedPoint4.f1440x, timedPoint4.f1441y));
        }
        this.mHasEditState = true;
    }

    private void addBezier(Bezier bezier, float f, float f2) {
        this.mSvgBuilder.append(bezier, (f + f2) / 2.0f);
        ensureSignatureBitmap();
        float strokeWidth = this.mPaint.getStrokeWidth();
        float f3 = f2 - f;
        float ceil = (float) Math.ceil((double) bezier.length());
        int i = 0;
        while (true) {
            float f4 = (float) i;
            if (f4 < ceil) {
                float f5 = f4 / ceil;
                float f6 = f5 * f5;
                float f7 = f6 * f5;
                float f8 = 1.0f - f5;
                float f9 = f8 * f8;
                float f10 = f9 * f8;
                float f11 = f9 * 3.0f * f5;
                float f12 = f8 * 3.0f * f6;
                float f13 = (bezier.startPoint.f1440x * f10) + (bezier.control1.f1440x * f11) + (bezier.control2.f1440x * f12) + (bezier.endPoint.f1440x * f7);
                float f14 = (f10 * bezier.startPoint.f1441y) + (f11 * bezier.control1.f1441y) + (f12 * bezier.control2.f1441y) + (bezier.endPoint.f1441y * f7);
                this.mPaint.setStrokeWidth((f7 * f3) + f);
                this.mSignatureBitmapCanvas.drawPoint(f13, f14, this.mPaint);
                expandDirtyRect(f13, f14);
                i++;
            } else {
                this.mPaint.setStrokeWidth(strokeWidth);
                return;
            }
        }
    }

    private ControlTimedPoints calculateCurveControlPoints(TimedPoint timedPoint, TimedPoint timedPoint2, TimedPoint timedPoint3) {
        float f = timedPoint.f1440x - timedPoint2.f1440x;
        float f2 = timedPoint.f1441y - timedPoint2.f1441y;
        float f3 = timedPoint2.f1440x - timedPoint3.f1440x;
        float f4 = timedPoint2.f1441y - timedPoint3.f1441y;
        float f5 = (timedPoint.f1440x + timedPoint2.f1440x) / 2.0f;
        float f6 = (timedPoint.f1441y + timedPoint2.f1441y) / 2.0f;
        float f7 = (timedPoint2.f1440x + timedPoint3.f1440x) / 2.0f;
        float f8 = (timedPoint2.f1441y + timedPoint3.f1441y) / 2.0f;
        float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        float sqrt2 = (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        float f9 = f5 - f7;
        float f10 = f6 - f8;
        float f11 = sqrt2 / (sqrt + sqrt2);
        if (Float.isNaN(f11)) {
            f11 = 0.0f;
        }
        float f12 = timedPoint2.f1440x - ((f9 * f11) + f7);
        float f13 = timedPoint2.f1441y - ((f10 * f11) + f8);
        return this.mControlTimedPointsCached.set(getNewPoint(f5 + f12, f6 + f13), getNewPoint(f7 + f12, f8 + f13));
    }

    private float strokeWidth(float f) {
        return Math.max(((float) this.mMaxWidth) / (f + 1.0f), (float) this.mMinWidth);
    }

    private void expandDirtyRect(float f, float f2) {
        if (f < this.mDirtyRect.left) {
            this.mDirtyRect.left = f;
        } else if (f > this.mDirtyRect.right) {
            this.mDirtyRect.right = f;
        }
        if (f2 < this.mDirtyRect.top) {
            this.mDirtyRect.top = f2;
        } else if (f2 > this.mDirtyRect.bottom) {
            this.mDirtyRect.bottom = f2;
        }
    }

    private void resetDirtyRect(float f, float f2) {
        this.mDirtyRect.left = Math.min(this.mLastTouchX, f);
        this.mDirtyRect.right = Math.max(this.mLastTouchX, f);
        this.mDirtyRect.top = Math.min(this.mLastTouchY, f2);
        this.mDirtyRect.bottom = Math.max(this.mLastTouchY, f2);
    }

    private void setIsEmpty(boolean z) {
        this.mIsEmpty = z;
        OnSignedListener onSignedListener = this.mOnSignedListener;
        if (onSignedListener == null) {
            return;
        }
        if (z) {
            onSignedListener.onClear();
        } else {
            onSignedListener.onSigned();
        }
    }

    private void ensureSignatureBitmap() {
        if (this.mSignatureBitmap == null) {
            this.mSignatureBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.mSignatureBitmapCanvas = new Canvas(this.mSignatureBitmap);
        }
    }

    private int convertDpToPx(float f) {
        return Math.round(getContext().getResources().getDisplayMetrics().density * f);
    }

    public List<TimedPoint> getPoints() {
        return this.mPoints;
    }
}
