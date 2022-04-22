package com.getstream.sdk.chat.utils.roundedImageView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.DecelerateInterpolator;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.getstream.sdk.chat.C1673R;
import java.util.Locale;

public class CircularImageView extends AppCompatImageView implements Checkable {
    private static final int DEFAULT_BACKGROUND_COLOR = -2236963;
    private static final int DEFAULT_BORDER_COLOR = -1;
    private static final int DEFAULT_CHECKED_BACKGROUND_COLOR = -4473925;
    private static final int DEFAULT_CHECK_STROKE_COLOR = -1;
    private static final float DEFAULT_CHECK_STROKE_WIDTH_IN_DP = 3.0f;
    private static final int DEFAULT_SHADOW_COLOR = -10066330;
    private static final float DEFAULT_SHADOW_RADIUS = 0.0f;
    private static final int DEFAULT_TEXT_COLOR = -16777216;
    private static final String TAG = "CircularImageView";
    private boolean mAllowCheckStateAnimation;
    private boolean mAllowCheckStateShadow;
    private int mAlpha;
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    private Paint mBitmapPaint;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private Paint mCheckMarkPaint;
    /* access modifiers changed from: private */
    public boolean mChecked;
    private int mCheckedBackgroundColor;
    private Paint mCheckedBackgroundPaint;
    private int mHeight;
    private int mLongStrokeHeight;
    private Path mPath;
    private int mRadius;
    private int mShadowColor;
    private float mShadowRadius;
    private String mText;
    private int mTextColor;
    private Paint mTextPaint;
    private int mTextSize;
    private int mWidth;

    /* access modifiers changed from: protected */
    public boolean shouldDrawBorder() {
        return true;
    }

    public CircularImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mAlpha = 255;
        this.mAllowCheckStateAnimation = true;
        this.mAllowCheckStateShadow = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = attributeSet != null ? context.getTheme().obtainStyledAttributes(attributeSet, C1673R.styleable.Stream_CircularImageView, 0, 0) : null;
        this.mBorderColor = -1;
        this.mBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        this.mCheckedBackgroundColor = DEFAULT_CHECKED_BACKGROUND_COLOR;
        this.mShadowRadius = 0.0f;
        this.mShadowColor = DEFAULT_SHADOW_COLOR;
        if (obtainStyledAttributes != null) {
            this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.Stream_CircularImageView_stream_ci_borderWidth, 0);
            this.mBorderColor = obtainStyledAttributes.getColor(C1673R.styleable.Stream_CircularImageView_stream_ci_borderColor, -1);
            this.mBackgroundColor = obtainStyledAttributes.getColor(C1673R.styleable.Stream_CircularImageView_stream_ci_placeholderBackgroundColor, DEFAULT_BACKGROUND_COLOR);
            this.mText = obtainStyledAttributes.getString(C1673R.styleable.Stream_CircularImageView_stream_ci_placeholderText);
            this.mTextColor = obtainStyledAttributes.getColor(C1673R.styleable.Stream_CircularImageView_stream_ci_placeholderTextColor, -16777216);
            this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.Stream_CircularImageView_stream_ci_placeholderTextSize, 0);
            this.mChecked = obtainStyledAttributes.getBoolean(C1673R.styleable.Stream_CircularImageView_stream_ci_checked, false);
            this.mCheckedBackgroundColor = obtainStyledAttributes.getColor(C1673R.styleable.Stream_CircularImageView_stream_ci_checkedStateBackgroundColor, DEFAULT_CHECKED_BACKGROUND_COLOR);
            this.mShadowRadius = Math.max(obtainStyledAttributes.getFloat(C1673R.styleable.Stream_CircularImageView_stream_ci_shadowRadius, 0.0f), 0.0f);
            this.mShadowColor = obtainStyledAttributes.getColor(C1673R.styleable.Stream_CircularImageView_stream_ci_shadowColor, DEFAULT_SHADOW_COLOR);
            obtainStyledAttributes.recycle();
        }
        this.mBitmapPaint = new Paint(1);
        setBorderInternal(this.mBorderWidth, this.mBorderColor, false);
        setPlaceholderTextInternal(this.mText, this.mTextColor, this.mTextSize, 0, false);
        Paint paint = new Paint();
        this.mBackgroundPaint = paint;
        paint.setAntiAlias(true);
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mCheckedBackgroundPaint = paint2;
        paint2.setColor(this.mCheckedBackgroundColor);
        this.mCheckedBackgroundPaint.setStyle(Paint.Style.FILL);
        this.mCheckMarkPaint = getCheckMarkPaint();
        setShadowInternal(this.mShadowRadius, this.mShadowColor, false);
    }

    private void setBorderInternal(int i, int i2, boolean z) {
        this.mBorderWidth = i;
        this.mBorderColor = i2;
        if (this.mBorderPaint == null) {
            Paint paint = new Paint();
            this.mBorderPaint = paint;
            paint.setAntiAlias(true);
            this.mBorderPaint.setStyle(Paint.Style.FILL);
        }
        Paint paint2 = this.mBorderPaint;
        if (paint2 != null) {
            paint2.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth((float) Math.max(0, this.mBorderWidth));
        }
        if (z) {
            invalidate();
        }
    }

    private void setShadowInternal(float f, int i, boolean z) {
        this.mShadowRadius = f;
        this.mShadowColor = i;
        this.mBorderPaint.clearShadowLayer();
        this.mCheckedBackgroundPaint.clearShadowLayer();
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, this.mBorderPaint);
            setLayerType(1, this.mCheckedBackgroundPaint);
        }
        Paint paint = this.mBorderPaint;
        float f2 = this.mShadowRadius;
        paint.setShadowLayer(f2, 0.0f, f2 / 2.0f, this.mShadowColor);
        if (this.mAllowCheckStateShadow) {
            Paint paint2 = this.mCheckedBackgroundPaint;
            float f3 = this.mShadowRadius;
            paint2.setShadowLayer(f3, 0.0f, f3 / 2.0f, this.mShadowColor);
        }
        if (z) {
            invalidate();
        }
    }

    private void setPlaceholderTextInternal(String str, int i, int i2, int i3, boolean z) {
        String formatPlaceholderText = formatPlaceholderText(str);
        this.mText = formatPlaceholderText;
        this.mTextColor = i;
        this.mTextSize = i2;
        if (this.mTextPaint == null && i2 > 0 && !TextUtils.isEmpty(formatPlaceholderText)) {
            this.mTextPaint = getTextPaint();
        }
        Paint paint = this.mTextPaint;
        if (paint != null) {
            paint.setColor(i);
            this.mTextPaint.setTextSize((float) i2);
            if (i3 != 0) {
                this.mTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, i3));
            }
        }
        if (z) {
            invalidate();
        }
    }

    private void setPlaceholderTextInternal(String str, int i, int i2, Typeface typeface, boolean z) {
        String formatPlaceholderText = formatPlaceholderText(str);
        this.mText = formatPlaceholderText;
        this.mTextColor = i;
        this.mTextSize = i2;
        if (this.mTextPaint == null && i2 > 0 && !TextUtils.isEmpty(formatPlaceholderText)) {
            this.mTextPaint = getTextPaint();
        }
        Paint paint = this.mTextPaint;
        if (paint != null) {
            paint.setColor(i);
            this.mTextPaint.setTextSize((float) i2);
            if (typeface != null) {
                this.mTextPaint.setTypeface(typeface);
            }
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        int min = Math.min(i, i2) / 2;
        this.mRadius = min;
        this.mLongStrokeHeight = min;
        if (this.mBitmapPaint != null) {
            updateBitmapShader();
        }
    }

    public void invalidate() {
        super.invalidate();
        if (this.mBitmapPaint != null) {
            updateBitmapShader();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.mBitmapPaint;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public int getImageAlpha() {
        return this.mAlpha;
    }

    public void setImageAlpha(int i) {
        int i2 = i & 255;
        if (this.mAlpha != i2) {
            this.mAlpha = i2;
            Paint paint = this.mBitmapPaint;
            if (paint != null) {
                paint.setAlpha(i2);
            }
            Paint paint2 = this.mBorderPaint;
            if (paint2 != null) {
                paint2.setAlpha(i2);
            }
            Paint paint3 = this.mBackgroundPaint;
            if (paint3 != null) {
                paint3.setAlpha(i2);
            }
            Paint paint4 = this.mCheckMarkPaint;
            if (paint4 != null) {
                paint4.setAlpha(i2);
            }
            Paint paint5 = this.mCheckedBackgroundPaint;
            if (paint5 != null) {
                paint5.setAlpha(i2);
            }
            Paint paint6 = this.mTextPaint;
            if (paint6 != null) {
                paint6.setAlpha(i2);
            }
            invalidate();
        }
    }

    public final void setBorderWidth(int i, int i2) {
        if (i2 >= 0) {
            setBorderInternal((int) TypedValue.applyDimension(i, (float) i2, getResources().getDisplayMetrics()), this.mBorderColor, true);
            return;
        }
        throw new IllegalArgumentException("Border width cannot be less than zero.");
    }

    public final void setBorderColor(int i) {
        if (i != this.mBorderColor) {
            setBorderInternal(this.mBorderWidth, i, true);
        }
    }

    public final void setCheckedStateBackgroundColor(int i) {
        Paint paint;
        if (!(i == this.mCheckedBackgroundColor || (paint = this.mCheckedBackgroundPaint) == null)) {
            paint.setColor(i);
            if (isChecked()) {
                invalidate();
            }
        }
        this.mCheckedBackgroundColor = i;
    }

    public final void setPlaceholder(String str) {
        if (!str.equalsIgnoreCase(this.mText)) {
            setPlaceholderTextInternal(str, this.mTextColor, this.mTextSize, 0, true);
        }
    }

    public final void setPlaceholderTextSize(int i, int i2, int i3) {
        if (i2 >= 0) {
            setPlaceholderTextInternal(this.mText, this.mTextColor, (int) TypedValue.applyDimension(i, (float) i2, getResources().getDisplayMetrics()), i3, true);
            return;
        }
        throw new IllegalArgumentException("Text size cannot be less than zero.");
    }

    public final void setPlaceholderTextSize(int i, int i2, Typeface typeface) {
        if (i2 >= 0) {
            setPlaceholderTextInternal(this.mText, this.mTextColor, (int) TypedValue.applyDimension(i, (float) i2, getResources().getDisplayMetrics()), typeface, true);
            return;
        }
        throw new IllegalArgumentException("Text size cannot be less than zero.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPlaceholder(java.lang.String r9, int r10, int r11) {
        /*
            r8 = this;
            int r0 = r8.mBackgroundColor
            r1 = 1
            if (r10 == r0) goto L_0x0010
            r8.mBackgroundColor = r10
            android.graphics.Paint r0 = r8.mBackgroundPaint
            if (r0 == 0) goto L_0x0010
            r0.setColor(r10)
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r9 == 0) goto L_0x0028
            java.lang.String r2 = r8.mText
            if (r2 == 0) goto L_0x0028
            boolean r2 = r9.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0028
            int r2 = r8.mBackgroundColor
            if (r10 != r2) goto L_0x0028
            int r10 = r8.mTextColor
            if (r11 == r10) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r0
            goto L_0x0032
        L_0x0028:
            int r5 = r8.mTextSize
            r6 = 0
            r7 = 0
            r2 = r8
            r3 = r9
            r4 = r11
            r2.setPlaceholderTextInternal((java.lang.String) r3, (int) r4, (int) r5, (int) r6, (boolean) r7)
        L_0x0032:
            if (r1 == 0) goto L_0x0037
            r8.invalidate()
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.roundedImageView.CircularImageView.setPlaceholder(java.lang.String, int, int):void");
    }

    public final void allowCheckStateAnimation(boolean z) {
        this.mAllowCheckStateAnimation = z;
    }

    public void setShadowRadius(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Shadow radius cannot be less than zero.");
        } else if (f != this.mShadowRadius) {
            setShadowInternal(f, this.mShadowColor, true);
        }
    }

    public void setShadowColor(int i) {
        if (i != this.mShadowColor) {
            setShadowInternal(this.mShadowRadius, i, true);
        }
    }

    public void allowCheckStateShadow(boolean z) {
        if (z != this.mAllowCheckStateShadow) {
            this.mAllowCheckStateShadow = z;
            setShadowInternal(this.mShadowRadius, this.mShadowColor, true);
        }
    }

    /* access modifiers changed from: protected */
    public String formatPlaceholderText(String str) {
        String trim = str != null ? str.trim() : null;
        int length = trim != null ? trim.length() : 0;
        if (length > 0) {
            return trim.substring(0, Math.min(2, length)).toUpperCase(Locale.getDefault());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Paint getTextPaint() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(Typeface.DEFAULT);
        paint.setTextAlign(Paint.Align.CENTER);
        return paint;
    }

    /* access modifiers changed from: protected */
    public Paint getCheckMarkPaint() {
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) getCheckMarkStrokeWidthInPixels());
        return paint;
    }

    /* access modifiers changed from: protected */
    public int getCheckMarkStrokeWidthInPixels() {
        return (int) TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.mWidth;
        int i2 = i / 2;
        int i3 = this.mHeight;
        int i4 = i3 / 2;
        if (this.mChecked) {
            drawCheckedState(canvas, i, i3);
            return;
        }
        int i5 = 0;
        int i6 = shouldDrawBorder() ? this.mBorderWidth : 0;
        Paint paint = this.mBorderPaint;
        if (paint != null) {
            canvas.drawCircle((float) i2, (float) i4, ((float) this.mRadius) - ((this.mShadowRadius * 1.5f) + 1.0f), paint);
        }
        if (i6 > 0) {
            i5 = i6;
        }
        int i7 = (int) (((float) i5) + (this.mShadowRadius * 1.5f));
        if (getDrawable() != null) {
            canvas.drawCircle((float) i2, (float) i4, (float) (this.mRadius - i7), this.mBitmapPaint);
            return;
        }
        float f = (float) i2;
        canvas.drawCircle(f, (float) i4, (float) (this.mRadius - i7), this.mBackgroundPaint);
        if (this.mTextPaint != null && !TextUtils.isEmpty(this.mText)) {
            canvas.drawText(this.mText, f, (float) ((int) ((((float) this.mHeight) - (this.mTextPaint.ascent() + this.mTextPaint.descent())) * 0.5f)), this.mTextPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void drawCheckedState(Canvas canvas, int i, int i2) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float f = (float) i3;
        float f2 = (float) i4;
        canvas.drawCircle(f, f2, ((float) this.mRadius) - (this.mShadowRadius * 1.5f), this.mCheckedBackgroundPaint);
        canvas.save();
        int i5 = this.mLongStrokeHeight;
        int i6 = (int) (((float) i5) * 0.4f);
        int i7 = (int) (((float) i5) * 0.5f);
        int i8 = (int) (((float) i6) * 0.3f);
        int i9 = i3 + i8;
        int i10 = i4 - i8;
        this.mPath.reset();
        float f3 = (float) i9;
        this.mPath.moveTo(f3, (float) (i10 - i7));
        float f4 = (float) (i10 + i7);
        this.mPath.lineTo(f3, f4);
        this.mPath.moveTo(f3 + (((float) getCheckMarkStrokeWidthInPixels()) * 0.5f), f4);
        this.mPath.lineTo((float) (i9 - i6), f4);
        canvas.rotate(45.0f, f, f2);
        canvas.drawPath(this.mPath, this.mCheckMarkPaint);
        canvas.restore();
    }

    private void updateBitmapShader() {
        Drawable drawable = getDrawable();
        Bitmap bitmap = (drawable == null || !(drawable instanceof BitmapDrawable)) ? null : ((BitmapDrawable) drawable).getBitmap();
        if (bitmap == null) {
            this.mBitmapPaint.setShader((Shader) null);
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = this.mRadius * 2;
        int i2 = 0;
        int i3 = shouldDrawBorder() ? this.mBorderWidth : 0;
        if (i3 > 0) {
            i2 = i3 * 2;
        }
        float min = ((float) (i - ((int) (((float) i2) + (this.mShadowRadius * 1.5f))))) / ((float) Math.min(height, width));
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        matrix.postTranslate((float) Math.round((((float) this.mWidth) - (((float) width) * min)) * 0.5f), (float) Math.round((((float) this.mHeight) - (((float) height) * min)) * 0.5f));
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        this.mBitmapPaint.setShader(bitmapShader);
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(final boolean z) {
        if (this.mChecked != z) {
            if (this.mAllowCheckStateAnimation) {
                final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, 0.0f});
                ofFloat.setDuration(150);
                ofFloat.setInterpolator(decelerateInterpolator);
                ofFloat.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        boolean unused = CircularImageView.this.mChecked = z;
                        CircularImageView.this.invalidate();
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(CircularImageView.this, "scaleX", new float[]{0.0f, 1.0f});
                        ofFloat.setDuration(150);
                        ofFloat.setInterpolator(decelerateInterpolator);
                        ofFloat.start();
                    }
                });
                ofFloat.start();
                return;
            }
            this.mChecked = z;
            invalidate();
        }
    }

    public void toggle() {
        setChecked(!this.mChecked);
    }
}
