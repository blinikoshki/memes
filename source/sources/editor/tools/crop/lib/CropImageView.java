package editor.tools.crop.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.exifinterface.media.ExifInterface;
import com.memes.editor.C4175R;
import editor.tools.crop.lib.BitmapLoadingWorkerTask;
import editor.tools.crop.lib.BitmapUtils;
import editor.tools.crop.lib.CropOverlayView;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class CropImageView extends FrameLayout {
    private CropImageAnimation mAnimation;
    private boolean mAutoZoomEnabled;
    private Bitmap mBitmap;
    private WeakReference<BitmapLoadingWorkerTask> mBitmapLoadingWorkerTask;
    private final CropOverlayView mCropOverlayView;
    private int mDegreesRotated;
    private boolean mFlipHorizontally;
    private boolean mFlipVertically;
    private final Matrix mImageInverseMatrix;
    private final Matrix mImageMatrix;
    private final float[] mImagePoints;
    private int mImageResource;
    public final ImageView mImageView;
    private int mInitialDegreesRotated;
    private int mLayoutHeight;
    private int mLayoutWidth;
    private Uri mLoadedImageUri;
    private int mLoadedSampleSize;
    private int mMaxZoom;
    /* access modifiers changed from: private */
    public OnSetCropOverlayReleasedListener mOnCropOverlayReleasedListener;
    /* access modifiers changed from: private */
    public OnSetCropOverlayMovedListener mOnSetCropOverlayMovedListener;
    private OnSetCropWindowChangeListener mOnSetCropWindowChangeListener;
    private OnSetImageUriCompleteListener mOnSetImageUriCompleteListener;
    private final ProgressBar mProgressBar;
    private RectF mRestoreCropWindowRect;
    private int mRestoreDegreesRotated;
    private boolean mSaveBitmapToInstanceState;
    private Uri mSaveInstanceStateBitmapUri;
    private final float[] mScaleImagePoints;
    private ScaleType mScaleType;
    private boolean mShowCropOverlay;
    private boolean mShowProgressBar;
    private boolean mSizeChanged;
    private float mZoom;
    private float mZoomOffsetX;
    private float mZoomOffsetY;

    public enum CropShape {
        RECTANGLE,
        OVAL
    }

    public enum Guidelines {
        OFF,
        ON_TOUCH,
        ON
    }

    public interface OnSetCropOverlayMovedListener {
        void onCropOverlayMoved(Rect rect);
    }

    public interface OnSetCropOverlayReleasedListener {
        void onCropOverlayReleased(Rect rect);
    }

    public interface OnSetCropWindowChangeListener {
        void onCropWindowChanged();
    }

    public interface OnSetImageUriCompleteListener {
        void onSetImageUriComplete(CropImageView cropImageView, Uri uri, Exception exc);
    }

    public enum RequestSizeOptions {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    public enum ScaleType {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mImageMatrix = new Matrix();
        this.mImageInverseMatrix = new Matrix();
        this.mImagePoints = new float[8];
        this.mScaleImagePoints = new float[8];
        this.mSaveBitmapToInstanceState = false;
        this.mShowCropOverlay = true;
        this.mShowProgressBar = true;
        this.mAutoZoomEnabled = true;
        this.mLoadedSampleSize = 1;
        this.mZoom = 1.0f;
        CropImageOptions cropImageOptions = new CropImageOptions();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.CropImageView, 0, 0);
            try {
                cropImageOptions.fixAspectRatio = obtainStyledAttributes.getBoolean(C4175R.styleable.CropImageView_cropFixAspectRatio, cropImageOptions.fixAspectRatio);
                cropImageOptions.aspectRatioX = obtainStyledAttributes.getInteger(C4175R.styleable.CropImageView_cropAspectRatioX, cropImageOptions.aspectRatioX);
                cropImageOptions.aspectRatioY = obtainStyledAttributes.getInteger(C4175R.styleable.CropImageView_cropAspectRatioY, cropImageOptions.aspectRatioY);
                cropImageOptions.scaleType = ScaleType.values()[obtainStyledAttributes.getInt(C4175R.styleable.CropImageView_cropScaleType, cropImageOptions.scaleType.ordinal())];
                cropImageOptions.autoZoomEnabled = obtainStyledAttributes.getBoolean(C4175R.styleable.CropImageView_cropAutoZoomEnabled, cropImageOptions.autoZoomEnabled);
                cropImageOptions.multiTouchEnabled = obtainStyledAttributes.getBoolean(C4175R.styleable.CropImageView_cropMultiTouchEnabled, cropImageOptions.multiTouchEnabled);
                cropImageOptions.maxZoom = obtainStyledAttributes.getInteger(C4175R.styleable.CropImageView_cropMaxZoom, cropImageOptions.maxZoom);
                cropImageOptions.cropShape = CropShape.values()[obtainStyledAttributes.getInt(C4175R.styleable.CropImageView_cropShape, cropImageOptions.cropShape.ordinal())];
                cropImageOptions.guidelines = Guidelines.values()[obtainStyledAttributes.getInt(C4175R.styleable.CropImageView_cropGuidelines, cropImageOptions.guidelines.ordinal())];
                cropImageOptions.snapRadius = obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropSnapRadius, cropImageOptions.snapRadius);
                cropImageOptions.touchRadius = obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropTouchRadius, cropImageOptions.touchRadius);
                cropImageOptions.initialCropWindowPaddingRatio = obtainStyledAttributes.getFloat(C4175R.styleable.CropImageView_cropInitialCropWindowPaddingRatio, cropImageOptions.initialCropWindowPaddingRatio);
                cropImageOptions.borderLineThickness = obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropBorderLineThickness, cropImageOptions.borderLineThickness);
                cropImageOptions.borderLineColor = obtainStyledAttributes.getInteger(C4175R.styleable.CropImageView_cropBorderLineColor, cropImageOptions.borderLineColor);
                cropImageOptions.borderCornerThickness = obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropBorderCornerThickness, cropImageOptions.borderCornerThickness);
                cropImageOptions.borderCornerOffset = obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropBorderCornerOffset, cropImageOptions.borderCornerOffset);
                cropImageOptions.borderCornerLength = obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropBorderCornerLength, cropImageOptions.borderCornerLength);
                cropImageOptions.borderCornerColor = obtainStyledAttributes.getInteger(C4175R.styleable.CropImageView_cropBorderCornerColor, cropImageOptions.borderCornerColor);
                cropImageOptions.guidelinesThickness = obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropGuidelinesThickness, cropImageOptions.guidelinesThickness);
                cropImageOptions.guidelinesColor = obtainStyledAttributes.getInteger(C4175R.styleable.CropImageView_cropGuidelinesColor, cropImageOptions.guidelinesColor);
                cropImageOptions.backgroundColor = obtainStyledAttributes.getInteger(C4175R.styleable.CropImageView_cropBackgroundColor, cropImageOptions.backgroundColor);
                cropImageOptions.showCropOverlay = obtainStyledAttributes.getBoolean(C4175R.styleable.CropImageView_cropShowCropOverlay, this.mShowCropOverlay);
                cropImageOptions.showProgressBar = obtainStyledAttributes.getBoolean(C4175R.styleable.CropImageView_cropShowProgressBar, this.mShowProgressBar);
                cropImageOptions.borderCornerThickness = obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropBorderCornerThickness, cropImageOptions.borderCornerThickness);
                cropImageOptions.minCropWindowWidth = (int) obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropMinCropWindowWidth, (float) cropImageOptions.minCropWindowWidth);
                cropImageOptions.minCropWindowHeight = (int) obtainStyledAttributes.getDimension(C4175R.styleable.CropImageView_cropMinCropWindowHeight, (float) cropImageOptions.minCropWindowHeight);
                cropImageOptions.minCropResultWidth = (int) obtainStyledAttributes.getFloat(C4175R.styleable.CropImageView_cropMinCropResultWidthPX, (float) cropImageOptions.minCropResultWidth);
                cropImageOptions.minCropResultHeight = (int) obtainStyledAttributes.getFloat(C4175R.styleable.CropImageView_cropMinCropResultHeightPX, (float) cropImageOptions.minCropResultHeight);
                cropImageOptions.maxCropResultWidth = (int) obtainStyledAttributes.getFloat(C4175R.styleable.CropImageView_cropMaxCropResultWidthPX, (float) cropImageOptions.maxCropResultWidth);
                cropImageOptions.maxCropResultHeight = (int) obtainStyledAttributes.getFloat(C4175R.styleable.CropImageView_cropMaxCropResultHeightPX, (float) cropImageOptions.maxCropResultHeight);
                cropImageOptions.flipHorizontally = obtainStyledAttributes.getBoolean(C4175R.styleable.CropImageView_cropFlipHorizontally, cropImageOptions.flipHorizontally);
                cropImageOptions.flipVertically = obtainStyledAttributes.getBoolean(C4175R.styleable.CropImageView_cropFlipHorizontally, cropImageOptions.flipVertically);
                this.mSaveBitmapToInstanceState = obtainStyledAttributes.getBoolean(C4175R.styleable.CropImageView_cropSaveBitmapToInstanceState, this.mSaveBitmapToInstanceState);
                if (obtainStyledAttributes.hasValue(C4175R.styleable.CropImageView_cropAspectRatioX) && obtainStyledAttributes.hasValue(C4175R.styleable.CropImageView_cropAspectRatioX) && !obtainStyledAttributes.hasValue(C4175R.styleable.CropImageView_cropFixAspectRatio)) {
                    cropImageOptions.fixAspectRatio = true;
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        cropImageOptions.validate();
        this.mScaleType = cropImageOptions.scaleType;
        this.mAutoZoomEnabled = cropImageOptions.autoZoomEnabled;
        this.mMaxZoom = cropImageOptions.maxZoom;
        this.mShowCropOverlay = cropImageOptions.showCropOverlay;
        this.mShowProgressBar = cropImageOptions.showProgressBar;
        this.mFlipHorizontally = cropImageOptions.flipHorizontally;
        this.mFlipVertically = cropImageOptions.flipVertically;
        View inflate = LayoutInflater.from(context).inflate(C4175R.C4181layout.n_crop_image_view, this, true);
        ImageView imageView = (ImageView) inflate.findViewById(C4175R.C4179id.ImageView_image);
        this.mImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) inflate.findViewById(C4175R.C4179id.CropOverlayView);
        this.mCropOverlayView = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(new CropOverlayView.CropWindowChangeListener() {
            public void onCropWindowChanged(boolean z) {
                CropImageView.this.handleCropWindowChanged(z, true);
                OnSetCropOverlayReleasedListener access$100 = CropImageView.this.mOnCropOverlayReleasedListener;
                if (access$100 != null && !z) {
                    access$100.onCropOverlayReleased(CropImageView.this.getCropRect());
                }
                OnSetCropOverlayMovedListener access$200 = CropImageView.this.mOnSetCropOverlayMovedListener;
                if (access$200 != null && z) {
                    access$200.onCropOverlayMoved(CropImageView.this.getCropRect());
                }
            }
        });
        cropOverlayView.setInitialAttributeValues(cropImageOptions);
        this.mProgressBar = (ProgressBar) inflate.findViewById(C4175R.C4179id.CropProgressBar);
        setProgressBarVisibility();
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            this.mZoom = 1.0f;
            this.mZoomOffsetY = 0.0f;
            this.mZoomOffsetX = 0.0f;
            this.mCropOverlayView.resetCropOverlayView();
            requestLayout();
        }
    }

    public CropShape getCropShape() {
        return this.mCropOverlayView.getCropShape();
    }

    public void setCropShape(CropShape cropShape) {
        this.mCropOverlayView.setCropShape(cropShape);
    }

    public boolean isAutoZoomEnabled() {
        return this.mAutoZoomEnabled;
    }

    public void setAutoZoomEnabled(boolean z) {
        if (this.mAutoZoomEnabled != z) {
            this.mAutoZoomEnabled = z;
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z) {
        if (this.mCropOverlayView.setMultiTouchEnabled(z)) {
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public int getMaxZoom() {
        return this.mMaxZoom;
    }

    public void setMaxZoom(int i) {
        if (this.mMaxZoom != i && i > 0) {
            this.mMaxZoom = i;
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.invalidate();
        }
    }

    public void setMinCropResultSize(int i, int i2) {
        this.mCropOverlayView.setMinCropResultSize(i, i2);
    }

    public void setMaxCropResultSize(int i, int i2) {
        this.mCropOverlayView.setMaxCropResultSize(i, i2);
    }

    public int getRotatedDegrees() {
        return this.mDegreesRotated;
    }

    public void setRotatedDegrees(int i) {
        int i2 = this.mDegreesRotated;
        if (i2 != i) {
            rotateImage(i - i2);
        }
    }

    public boolean isFixAspectRatio() {
        return this.mCropOverlayView.isFixAspectRatio();
    }

    public void setFixedAspectRatio(boolean z) {
        this.mCropOverlayView.setFixedAspectRatio(z);
    }

    public boolean isFlippedHorizontally() {
        return this.mFlipHorizontally;
    }

    public void setFlippedHorizontally(boolean z) {
        if (this.mFlipHorizontally != z) {
            this.mFlipHorizontally = z;
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public boolean isFlippedVertically() {
        return this.mFlipVertically;
    }

    public void setFlippedVertically(boolean z) {
        if (this.mFlipVertically != z) {
            this.mFlipVertically = z;
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public Guidelines getGuidelines() {
        return this.mCropOverlayView.getGuidelines();
    }

    public void setGuidelines(Guidelines guidelines) {
        this.mCropOverlayView.setGuidelines(guidelines);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.mCropOverlayView.getAspectRatioX()), Integer.valueOf(this.mCropOverlayView.getAspectRatioY()));
    }

    public void setAspectRatio(int i, int i2) {
        this.mCropOverlayView.setAspectRatioX(i);
        this.mCropOverlayView.setAspectRatioY(i2);
        setFixedAspectRatio(true);
    }

    public void clearAspectRatio() {
        this.mCropOverlayView.setAspectRatioX(1);
        this.mCropOverlayView.setAspectRatioY(1);
        setFixedAspectRatio(false);
    }

    public void setSnapRadius(float f) {
        if (f >= 0.0f) {
            this.mCropOverlayView.setSnapRadius(f);
        }
    }

    public boolean isShowProgressBar() {
        return this.mShowProgressBar;
    }

    public void setShowProgressBar(boolean z) {
        if (this.mShowProgressBar != z) {
            this.mShowProgressBar = z;
            setProgressBarVisibility();
        }
    }

    public boolean isShowCropOverlay() {
        return this.mShowCropOverlay;
    }

    public void setShowCropOverlay(boolean z) {
        if (this.mShowCropOverlay != z) {
            this.mShowCropOverlay = z;
            setCropOverlayVisibility();
        }
    }

    public boolean isSaveBitmapToInstanceState() {
        return this.mSaveBitmapToInstanceState;
    }

    public void setSaveBitmapToInstanceState(boolean z) {
        this.mSaveBitmapToInstanceState = z;
    }

    public int getImageResource() {
        return this.mImageResource;
    }

    public Uri getImageUri() {
        return this.mLoadedImageUri;
    }

    public Rect getWholeImageRect() {
        int i = this.mLoadedSampleSize;
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i, bitmap.getHeight() * i);
    }

    public Rect getCropRect() {
        int i = this.mLoadedSampleSize;
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return null;
        }
        return BitmapUtils.getRectFromPoints(getCropPoints(), bitmap.getWidth() * i, i * bitmap.getHeight(), this.mCropOverlayView.isFixAspectRatio(), this.mCropOverlayView.getAspectRatioX(), this.mCropOverlayView.getAspectRatioY());
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.mCropOverlayView.getCropWindowRect();
        float[] fArr = {cropWindowRect.left, cropWindowRect.top, cropWindowRect.right, cropWindowRect.top, cropWindowRect.right, cropWindowRect.bottom, cropWindowRect.left, cropWindowRect.bottom};
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        this.mImageInverseMatrix.mapPoints(fArr);
        for (int i = 0; i < 8; i++) {
            fArr[i] = fArr[i] * ((float) this.mLoadedSampleSize);
        }
        return fArr;
    }

    public void setCropRect(Rect rect) {
        this.mCropOverlayView.setInitialCropWindowRect(rect);
    }

    public void resetCropRect(boolean z) {
        this.mZoom = 1.0f;
        this.mZoomOffsetX = 0.0f;
        this.mZoomOffsetY = 0.0f;
        if (!z) {
            this.mDegreesRotated = this.mInitialDegreesRotated;
        }
        this.mFlipHorizontally = false;
        this.mFlipVertically = false;
        applyImageMatrix((float) getWidth(), (float) getHeight(), false, false);
        this.mCropOverlayView.resetCropWindowRect();
    }

    public void setOnSetCropOverlayReleasedListener(OnSetCropOverlayReleasedListener onSetCropOverlayReleasedListener) {
        this.mOnCropOverlayReleasedListener = onSetCropOverlayReleasedListener;
    }

    public void setOnSetCropOverlayMovedListener(OnSetCropOverlayMovedListener onSetCropOverlayMovedListener) {
        this.mOnSetCropOverlayMovedListener = onSetCropOverlayMovedListener;
    }

    public void setOnCropWindowChangedListener(OnSetCropWindowChangeListener onSetCropWindowChangeListener) {
        this.mOnSetCropWindowChangeListener = onSetCropWindowChangeListener;
    }

    public void setOnSetImageUriCompleteListener(OnSetImageUriCompleteListener onSetImageUriCompleteListener) {
        this.mOnSetImageUriCompleteListener = onSetImageUriCompleteListener;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
        setBitmap(bitmap, 0, (Uri) null, 1, 0);
    }

    public void setImageBitmap(Bitmap bitmap, ExifInterface exifInterface) {
        int i;
        Bitmap bitmap2;
        if (bitmap == null || exifInterface == null) {
            bitmap2 = bitmap;
            i = 0;
        } else {
            BitmapUtils.RotateBitmapResult rotateBitmapByExif = BitmapUtils.rotateBitmapByExif(bitmap, exifInterface);
            Bitmap bitmap3 = rotateBitmapByExif.bitmap;
            int i2 = rotateBitmapByExif.degrees;
            this.mInitialDegreesRotated = rotateBitmapByExif.degrees;
            bitmap2 = bitmap3;
            i = i2;
        }
        this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
        setBitmap(bitmap2, 0, (Uri) null, 1, i);
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
            setBitmap(BitmapFactory.decodeResource(getResources(), i), i, (Uri) null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri == null) {
            OnSetImageUriCompleteListener onSetImageUriCompleteListener = this.mOnSetImageUriCompleteListener;
            if (onSetImageUriCompleteListener != null) {
                onSetImageUriCompleteListener.onSetImageUriComplete(this, (Uri) null, new RuntimeException("Unable to load image uri; Null uri received."));
                return;
            }
            return;
        }
        WeakReference<BitmapLoadingWorkerTask> weakReference = this.mBitmapLoadingWorkerTask;
        BitmapLoadingWorkerTask bitmapLoadingWorkerTask = weakReference != null ? (BitmapLoadingWorkerTask) weakReference.get() : null;
        if (bitmapLoadingWorkerTask != null) {
            bitmapLoadingWorkerTask.cancel(true);
        }
        clearImageInt();
        this.mRestoreCropWindowRect = null;
        this.mRestoreDegreesRotated = 0;
        this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
        WeakReference<BitmapLoadingWorkerTask> weakReference2 = new WeakReference<>(new BitmapLoadingWorkerTask(this, uri));
        this.mBitmapLoadingWorkerTask = weakReference2;
        ((BitmapLoadingWorkerTask) weakReference2.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        setProgressBarVisibility();
    }

    public void clearImage() {
        clearImageInt();
        this.mCropOverlayView.setInitialCropWindowRect((Rect) null);
    }

    public void rotateImage(int i) {
        int i2;
        int i3 = i;
        if (this.mBitmap != null) {
            if (i3 < 0) {
                i2 = (i3 % 360) + 360;
            } else {
                i2 = i3 % 360;
            }
            boolean z = !this.mCropOverlayView.isFixAspectRatio() && ((i2 > 45 && i2 < 135) || (i2 > 215 && i2 < 305));
            BitmapUtils.RECT.set(this.mCropOverlayView.getCropWindowRect());
            RectF rectF = BitmapUtils.RECT;
            float height = (z ? rectF.height() : rectF.width()) / 2.0f;
            RectF rectF2 = BitmapUtils.RECT;
            float width = (z ? rectF2.width() : rectF2.height()) / 2.0f;
            if (z) {
                boolean z2 = this.mFlipHorizontally;
                this.mFlipHorizontally = this.mFlipVertically;
                this.mFlipVertically = z2;
            }
            this.mImageMatrix.invert(this.mImageInverseMatrix);
            BitmapUtils.POINTS[0] = BitmapUtils.RECT.centerX();
            BitmapUtils.POINTS[1] = BitmapUtils.RECT.centerY();
            BitmapUtils.POINTS[2] = 0.0f;
            BitmapUtils.POINTS[3] = 0.0f;
            BitmapUtils.POINTS[4] = 1.0f;
            BitmapUtils.POINTS[5] = 0.0f;
            this.mImageInverseMatrix.mapPoints(BitmapUtils.POINTS);
            this.mDegreesRotated = (this.mDegreesRotated + i2) % 360;
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
            this.mImageMatrix.mapPoints(BitmapUtils.POINTS2, BitmapUtils.POINTS);
            float sqrt = (float) (((double) this.mZoom) / Math.sqrt(Math.pow((double) (BitmapUtils.POINTS2[4] - BitmapUtils.POINTS2[2]), 2.0d) + Math.pow((double) (BitmapUtils.POINTS2[5] - BitmapUtils.POINTS2[3]), 2.0d)));
            this.mZoom = sqrt;
            this.mZoom = Math.max(sqrt, 1.0f);
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
            this.mImageMatrix.mapPoints(BitmapUtils.POINTS2, BitmapUtils.POINTS);
            double sqrt2 = Math.sqrt(Math.pow((double) (BitmapUtils.POINTS2[4] - BitmapUtils.POINTS2[2]), 2.0d) + Math.pow((double) (BitmapUtils.POINTS2[5] - BitmapUtils.POINTS2[3]), 2.0d));
            float f = (float) (((double) height) * sqrt2);
            float f2 = (float) (((double) width) * sqrt2);
            BitmapUtils.RECT.set(BitmapUtils.POINTS2[0] - f, BitmapUtils.POINTS2[1] - f2, BitmapUtils.POINTS2[0] + f, BitmapUtils.POINTS2[1] + f2);
            this.mCropOverlayView.resetCropOverlayView();
            this.mCropOverlayView.setCropWindowRect(BitmapUtils.RECT);
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
            handleCropWindowChanged(false, false);
            this.mCropOverlayView.fixCurrentCropWindowRect();
        }
    }

    public void flipImageHorizontally() {
        this.mFlipHorizontally = !this.mFlipHorizontally;
        applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
    }

    public void flipImageVertically() {
        this.mFlipVertically = !this.mFlipVertically;
        applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
    }

    /* access modifiers changed from: package-private */
    public void onSetImageUriAsyncComplete(BitmapLoadingWorkerTask.Result result) {
        this.mBitmapLoadingWorkerTask = null;
        setProgressBarVisibility();
        if (result.error == null) {
            this.mInitialDegreesRotated = result.degreesRotated;
            setBitmap(result.bitmap, 0, result.uri, result.loadSampleSize, result.degreesRotated);
        }
        OnSetImageUriCompleteListener onSetImageUriCompleteListener = this.mOnSetImageUriCompleteListener;
        if (onSetImageUriCompleteListener != null) {
            onSetImageUriCompleteListener.onSetImageUriComplete(this, result.uri, result.error);
        }
    }

    private void setBitmap(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.mImageView.clearAnimation();
            clearImageInt();
            this.mBitmap = bitmap;
            this.mImageView.setImageBitmap(bitmap);
            this.mLoadedImageUri = uri;
            this.mImageResource = i;
            this.mLoadedSampleSize = i2;
            this.mDegreesRotated = i3;
            applyImageMatrix((float) getWidth(), (float) getHeight(), true, false);
            CropOverlayView cropOverlayView = this.mCropOverlayView;
            if (cropOverlayView != null) {
                cropOverlayView.resetCropOverlayView();
                setCropOverlayVisibility();
            }
        }
    }

    private void clearImageInt() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && (this.mImageResource > 0 || this.mLoadedImageUri != null)) {
            bitmap.recycle();
        }
        this.mBitmap = null;
        this.mImageResource = 0;
        this.mLoadedImageUri = null;
        this.mLoadedSampleSize = 1;
        this.mDegreesRotated = 0;
        this.mZoom = 1.0f;
        this.mZoomOffsetX = 0.0f;
        this.mZoomOffsetY = 0.0f;
        this.mImageMatrix.reset();
        this.mSaveInstanceStateBitmapUri = null;
        this.mImageView.setImageBitmap((Bitmap) null);
        setCropOverlayVisibility();
    }

    public Parcelable onSaveInstanceState() {
        BitmapLoadingWorkerTask bitmapLoadingWorkerTask;
        if (this.mLoadedImageUri == null && this.mBitmap == null && this.mImageResource < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.mLoadedImageUri;
        if (this.mSaveBitmapToInstanceState && uri == null && this.mImageResource < 1) {
            uri = BitmapUtils.writeTempStateStoreBitmap(getContext(), this.mBitmap, this.mSaveInstanceStateBitmapUri);
            this.mSaveInstanceStateBitmapUri = uri;
        }
        if (!(uri == null || this.mBitmap == null)) {
            String uuid = UUID.randomUUID().toString();
            BitmapUtils.mStateBitmap = new Pair<>(uuid, new WeakReference(this.mBitmap));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        WeakReference<BitmapLoadingWorkerTask> weakReference = this.mBitmapLoadingWorkerTask;
        if (!(weakReference == null || (bitmapLoadingWorkerTask = (BitmapLoadingWorkerTask) weakReference.get()) == null)) {
            bundle.putParcelable("LOADING_IMAGE_URI", bitmapLoadingWorkerTask.getUri());
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.mImageResource);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.mLoadedSampleSize);
        bundle.putInt("DEGREES_ROTATED", this.mDegreesRotated);
        bundle.putParcelable("INITIAL_CROP_RECT", this.mCropOverlayView.getInitialCropWindowRect());
        BitmapUtils.RECT.set(this.mCropOverlayView.getCropWindowRect());
        this.mImageMatrix.invert(this.mImageInverseMatrix);
        this.mImageInverseMatrix.mapRect(BitmapUtils.RECT);
        bundle.putParcelable("CROP_WINDOW_RECT", BitmapUtils.RECT);
        bundle.putString("CROP_SHAPE", this.mCropOverlayView.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.mAutoZoomEnabled);
        bundle.putInt("CROP_MAX_ZOOM", this.mMaxZoom);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.mFlipHorizontally);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.mFlipVertically);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.mBitmapLoadingWorkerTask == null && this.mLoadedImageUri == null && this.mBitmap == null && this.mImageResource == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Bitmap bitmap = (BitmapUtils.mStateBitmap == null || !((String) BitmapUtils.mStateBitmap.first).equals(string)) ? null : (Bitmap) ((WeakReference) BitmapUtils.mStateBitmap.second).get();
                        BitmapUtils.mStateBitmap = null;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            setBitmap(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.mLoadedImageUri == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    int i = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i > 0) {
                        setImageResource(i);
                    } else {
                        Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                        if (uri2 != null) {
                            setImageUriAsync(uri2);
                        }
                    }
                }
                int i2 = bundle.getInt("DEGREES_ROTATED");
                this.mRestoreDegreesRotated = i2;
                this.mDegreesRotated = i2;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.mCropOverlayView.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.mRestoreCropWindowRect = rectF;
                }
                this.mCropOverlayView.setCropShape(CropShape.valueOf(bundle.getString("CROP_SHAPE")));
                this.mAutoZoomEnabled = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.mMaxZoom = bundle.getInt("CROP_MAX_ZOOM");
                this.mFlipHorizontally = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.mFlipVertically = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width = size < this.mBitmap.getWidth() ? ((double) size) / ((double) this.mBitmap.getWidth()) : Double.POSITIVE_INFINITY;
            double height = size2 < this.mBitmap.getHeight() ? ((double) size2) / ((double) this.mBitmap.getHeight()) : Double.POSITIVE_INFINITY;
            if (width == Double.POSITIVE_INFINITY && height == Double.POSITIVE_INFINITY) {
                i4 = this.mBitmap.getWidth();
                i3 = this.mBitmap.getHeight();
            } else if (width <= height) {
                i3 = (int) (((double) this.mBitmap.getHeight()) * width);
                i4 = size;
            } else {
                i4 = (int) (((double) this.mBitmap.getWidth()) * height);
                i3 = size2;
            }
            int onMeasureSpec = getOnMeasureSpec(mode, size, i4);
            int onMeasureSpec2 = getOnMeasureSpec(mode2, size2, i3);
            this.mLayoutWidth = onMeasureSpec;
            this.mLayoutHeight = onMeasureSpec2;
            setMeasuredDimension(onMeasureSpec, onMeasureSpec2);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mLayoutWidth <= 0 || this.mLayoutHeight <= 0) {
            updateImageBounds(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.mLayoutWidth;
        layoutParams.height = this.mLayoutHeight;
        setLayoutParams(layoutParams);
        if (this.mBitmap != null) {
            float f = (float) (i3 - i);
            float f2 = (float) (i4 - i2);
            applyImageMatrix(f, f2, true, false);
            if (this.mRestoreCropWindowRect != null) {
                int i5 = this.mRestoreDegreesRotated;
                if (i5 != this.mInitialDegreesRotated) {
                    this.mDegreesRotated = i5;
                    applyImageMatrix(f, f2, true, false);
                }
                this.mImageMatrix.mapRect(this.mRestoreCropWindowRect);
                this.mCropOverlayView.setCropWindowRect(this.mRestoreCropWindowRect);
                handleCropWindowChanged(false, false);
                this.mCropOverlayView.fixCurrentCropWindowRect();
                this.mRestoreCropWindowRect = null;
            } else if (this.mSizeChanged) {
                this.mSizeChanged = false;
                handleCropWindowChanged(false, false);
            }
        } else {
            updateImageBounds(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mSizeChanged = i3 > 0 && i4 > 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleCropWindowChanged(boolean r12, boolean r13) {
        /*
            r11 = this;
            int r0 = r11.getWidth()
            int r1 = r11.getHeight()
            android.graphics.Bitmap r2 = r11.mBitmap
            if (r2 == 0) goto L_0x0102
            if (r0 <= 0) goto L_0x0102
            if (r1 <= 0) goto L_0x0102
            editor.tools.crop.lib.CropOverlayView r2 = r11.mCropOverlayView
            android.graphics.RectF r2 = r2.getCropWindowRect()
            r3 = 0
            if (r12 == 0) goto L_0x003b
            float r13 = r2.left
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 < 0) goto L_0x0033
            float r13 = r2.top
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 < 0) goto L_0x0033
            float r13 = r2.right
            float r3 = (float) r0
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 > 0) goto L_0x0033
            float r13 = r2.bottom
            float r2 = (float) r1
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x00f9
        L_0x0033:
            float r13 = (float) r0
            float r0 = (float) r1
            r1 = 0
            r11.applyImageMatrix(r13, r0, r1, r1)
            goto L_0x00f9
        L_0x003b:
            boolean r4 = r11.mAutoZoomEnabled
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r4 != 0) goto L_0x0047
            float r4 = r11.mZoom
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00f9
        L_0x0047:
            float r4 = r11.mZoom
            int r6 = r11.mMaxZoom
            float r6 = (float) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0089
            float r4 = r2.width()
            float r6 = (float) r0
            r7 = 1056964608(0x3f000000, float:0.5)
            float r8 = r6 * r7
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0089
            float r4 = r2.height()
            float r8 = (float) r1
            float r7 = r7 * r8
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0089
            int r4 = r11.mMaxZoom
            float r4 = (float) r4
            float r7 = r2.width()
            float r9 = r11.mZoom
            float r7 = r7 / r9
            r9 = 1059313418(0x3f23d70a, float:0.64)
            float r7 = r7 / r9
            float r6 = r6 / r7
            float r7 = r2.height()
            float r10 = r11.mZoom
            float r7 = r7 / r10
            float r7 = r7 / r9
            float r8 = r8 / r7
            float r6 = java.lang.Math.min(r6, r8)
            float r4 = java.lang.Math.min(r4, r6)
            goto L_0x008a
        L_0x0089:
            r4 = 0
        L_0x008a:
            float r6 = r11.mZoom
            int r6 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c7
            float r6 = r2.width()
            float r7 = (float) r0
            r8 = 1059481190(0x3f266666, float:0.65)
            float r9 = r7 * r8
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x00a9
            float r6 = r2.height()
            float r9 = (float) r1
            float r9 = r9 * r8
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c7
        L_0x00a9:
            float r4 = r2.width()
            float r6 = r11.mZoom
            float r4 = r4 / r6
            r6 = 1057132380(0x3f028f5c, float:0.51)
            float r4 = r4 / r6
            float r7 = r7 / r4
            float r4 = (float) r1
            float r2 = r2.height()
            float r8 = r11.mZoom
            float r2 = r2 / r8
            float r2 = r2 / r6
            float r4 = r4 / r2
            float r2 = java.lang.Math.min(r7, r4)
            float r4 = java.lang.Math.max(r5, r2)
        L_0x00c7:
            boolean r2 = r11.mAutoZoomEnabled
            if (r2 != 0) goto L_0x00cc
            goto L_0x00cd
        L_0x00cc:
            r5 = r4
        L_0x00cd:
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x00f9
            float r2 = r11.mZoom
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00f9
            if (r13 == 0) goto L_0x00f1
            editor.tools.crop.lib.CropImageAnimation r2 = r11.mAnimation
            if (r2 != 0) goto L_0x00e8
            editor.tools.crop.lib.CropImageAnimation r2 = new editor.tools.crop.lib.CropImageAnimation
            android.widget.ImageView r3 = r11.mImageView
            editor.tools.crop.lib.CropOverlayView r4 = r11.mCropOverlayView
            r2.<init>(r3, r4)
            r11.mAnimation = r2
        L_0x00e8:
            editor.tools.crop.lib.CropImageAnimation r2 = r11.mAnimation
            float[] r3 = r11.mImagePoints
            android.graphics.Matrix r4 = r11.mImageMatrix
            r2.setStartState(r3, r4)
        L_0x00f1:
            r11.mZoom = r5
            float r0 = (float) r0
            float r1 = (float) r1
            r2 = 1
            r11.applyImageMatrix(r0, r1, r2, r13)
        L_0x00f9:
            editor.tools.crop.lib.CropImageView$OnSetCropWindowChangeListener r13 = r11.mOnSetCropWindowChangeListener
            if (r13 == 0) goto L_0x0102
            if (r12 != 0) goto L_0x0102
            r13.onCropWindowChanged()
        L_0x0102:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.tools.crop.lib.CropImageView.handleCropWindowChanged(boolean, boolean):void");
    }

    private void applyImageMatrix(float f, float f2, boolean z, boolean z2) {
        float f3;
        if (this.mBitmap != null) {
            float f4 = 0.0f;
            if (f > 0.0f && f2 > 0.0f) {
                this.mImageMatrix.invert(this.mImageInverseMatrix);
                RectF cropWindowRect = this.mCropOverlayView.getCropWindowRect();
                this.mImageInverseMatrix.mapRect(cropWindowRect);
                this.mImageMatrix.reset();
                this.mImageMatrix.postTranslate((f - ((float) this.mBitmap.getWidth())) / 2.0f, (f2 - ((float) this.mBitmap.getHeight())) / 2.0f);
                mapImagePointsByImageMatrix();
                int i = this.mDegreesRotated;
                if (i > 0) {
                    this.mImageMatrix.postRotate((float) i, BitmapUtils.getRectCenterX(this.mImagePoints), BitmapUtils.getRectCenterY(this.mImagePoints));
                    mapImagePointsByImageMatrix();
                }
                float min = Math.min(f / BitmapUtils.getRectWidth(this.mImagePoints), f2 / BitmapUtils.getRectHeight(this.mImagePoints));
                if (this.mScaleType == ScaleType.FIT_CENTER || ((this.mScaleType == ScaleType.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.mAutoZoomEnabled))) {
                    this.mImageMatrix.postScale(min, min, BitmapUtils.getRectCenterX(this.mImagePoints), BitmapUtils.getRectCenterY(this.mImagePoints));
                    mapImagePointsByImageMatrix();
                }
                float f5 = this.mFlipHorizontally ? -this.mZoom : this.mZoom;
                float f6 = this.mFlipVertically ? -this.mZoom : this.mZoom;
                this.mImageMatrix.postScale(f5, f6, BitmapUtils.getRectCenterX(this.mImagePoints), BitmapUtils.getRectCenterY(this.mImagePoints));
                mapImagePointsByImageMatrix();
                this.mImageMatrix.mapRect(cropWindowRect);
                if (z) {
                    if (f > BitmapUtils.getRectWidth(this.mImagePoints)) {
                        f3 = 0.0f;
                    } else {
                        f3 = Math.max(Math.min((f / 2.0f) - cropWindowRect.centerX(), -BitmapUtils.getRectLeft(this.mImagePoints)), ((float) getWidth()) - BitmapUtils.getRectRight(this.mImagePoints)) / f5;
                    }
                    this.mZoomOffsetX = f3;
                    if (f2 <= BitmapUtils.getRectHeight(this.mImagePoints)) {
                        f4 = Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerY(), -BitmapUtils.getRectTop(this.mImagePoints)), ((float) getHeight()) - BitmapUtils.getRectBottom(this.mImagePoints)) / f6;
                    }
                    this.mZoomOffsetY = f4;
                } else {
                    this.mZoomOffsetX = Math.min(Math.max(this.mZoomOffsetX * f5, -cropWindowRect.left), (-cropWindowRect.right) + f) / f5;
                    this.mZoomOffsetY = Math.min(Math.max(this.mZoomOffsetY * f6, -cropWindowRect.top), (-cropWindowRect.bottom) + f2) / f6;
                }
                this.mImageMatrix.postTranslate(this.mZoomOffsetX * f5, this.mZoomOffsetY * f6);
                cropWindowRect.offset(this.mZoomOffsetX * f5, this.mZoomOffsetY * f6);
                this.mCropOverlayView.setCropWindowRect(cropWindowRect);
                mapImagePointsByImageMatrix();
                this.mCropOverlayView.invalidate();
                if (z2) {
                    this.mAnimation.setEndState(this.mImagePoints, this.mImageMatrix);
                    this.mImageView.startAnimation(this.mAnimation);
                } else {
                    this.mImageView.setImageMatrix(this.mImageMatrix);
                }
                updateImageBounds(false);
            }
        }
    }

    private void mapImagePointsByImageMatrix() {
        float[] fArr = this.mImagePoints;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = (float) this.mBitmap.getWidth();
        float[] fArr2 = this.mImagePoints;
        fArr2[3] = 0.0f;
        fArr2[4] = (float) this.mBitmap.getWidth();
        this.mImagePoints[5] = (float) this.mBitmap.getHeight();
        float[] fArr3 = this.mImagePoints;
        fArr3[6] = 0.0f;
        fArr3[7] = (float) this.mBitmap.getHeight();
        this.mImageMatrix.mapPoints(this.mImagePoints);
        float[] fArr4 = this.mScaleImagePoints;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.mImageMatrix.mapPoints(fArr4);
    }

    private static int getOnMeasureSpec(int i, int i2, int i3) {
        if (i == 1073741824) {
            return i2;
        }
        return i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    private void setCropOverlayVisibility() {
        CropOverlayView cropOverlayView = this.mCropOverlayView;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.mShowCropOverlay || this.mBitmap == null) ? 4 : 0);
        }
    }

    private void setProgressBarVisibility() {
        int i = 0;
        boolean z = this.mShowProgressBar && this.mBitmap == null && this.mBitmapLoadingWorkerTask != null;
        ProgressBar progressBar = this.mProgressBar;
        if (!z) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }

    private void updateImageBounds(boolean z) {
        if (this.mBitmap != null && !z) {
            this.mCropOverlayView.setCropWindowLimits((float) getWidth(), (float) getHeight(), (((float) this.mLoadedSampleSize) * 100.0f) / BitmapUtils.getRectWidth(this.mScaleImagePoints), (((float) this.mLoadedSampleSize) * 100.0f) / BitmapUtils.getRectHeight(this.mScaleImagePoints));
        }
        this.mCropOverlayView.setBounds(z ? null : this.mImagePoints, getWidth(), getHeight());
    }

    public static class CropResult {
        private final Bitmap mBitmap;
        private final float[] mCropPoints;
        private final Rect mCropRect;
        private final Exception mError;
        private final Bitmap mOriginalBitmap;
        private final Uri mOriginalUri;
        private final int mRotation;
        private final int mSampleSize;
        private final Uri mUri;
        private final Rect mWholeImageRect;

        CropResult(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i, int i2) {
            this.mOriginalBitmap = bitmap;
            this.mOriginalUri = uri;
            this.mBitmap = bitmap2;
            this.mUri = uri2;
            this.mError = exc;
            this.mCropPoints = fArr;
            this.mCropRect = rect;
            this.mWholeImageRect = rect2;
            this.mRotation = i;
            this.mSampleSize = i2;
        }

        public Bitmap getOriginalBitmap() {
            return this.mOriginalBitmap;
        }

        public Uri getOriginalUri() {
            return this.mOriginalUri;
        }

        public boolean isSuccessful() {
            return this.mError == null;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public Exception getError() {
            return this.mError;
        }

        public float[] getCropPoints() {
            return this.mCropPoints;
        }

        public Rect getCropRect() {
            return this.mCropRect;
        }

        public Rect getWholeImageRect() {
            return this.mWholeImageRect;
        }

        public int getRotation() {
            return this.mRotation;
        }

        public int getSampleSize() {
            return this.mSampleSize;
        }
    }
}
