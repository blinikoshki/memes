package com.giphy.sdk.p013ui.views.buttons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.giphy.sdk.p013ui.utils.BitmapExtensionsKt;
import com.giphy.sdk.p013ui.utils.IntExtensionsKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001+\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\r\u0010*\u001a\u00020+H\u0003¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020'H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020 @FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006."}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHGifButton;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeBorderSize", "", "backgroundRect", "Landroid/graphics/RectF;", "bitmapRect", "value", "Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;", "color", "getColor", "()Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;", "setColor", "(Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;)V", "defaultBorderSize", "defaultCornerRadius", "drawPaint", "Landroid/graphics/Paint;", "gifBitmap", "Landroid/graphics/Bitmap;", "gradientShader", "Landroid/graphics/LinearGradient;", "halfSizeBorder", "getHalfSizeBorder", "()F", "Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonStyle;", "style", "getStyle", "()Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonStyle;", "setStyle", "(Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonStyle;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "roundCornersProvider", "com/giphy/sdk/ui/views/buttons/GPHGifButton$roundCornersProvider$1", "()Lcom/giphy/sdk/ui/views/buttons/GPHGifButton$roundCornersProvider$1;", "styleButton", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.buttons.GPHGifButton */
/* compiled from: GPHGifButton.kt */
public final class GPHGifButton extends ImageView {
    private HashMap _$_findViewCache;
    private float activeBorderSize;
    private final RectF backgroundRect;
    private final RectF bitmapRect;
    private GPHGifButtonColor color;
    private final int defaultBorderSize;
    /* access modifiers changed from: private */
    public final int defaultCornerRadius;
    private final Paint drawPaint;
    private Bitmap gifBitmap;
    private LinearGradient gradientShader;
    private GPHGifButtonStyle style;

    public GPHGifButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GPHGifButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GPHGifButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public GPHGifButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.defaultCornerRadius = IntExtensionsKt.getPx(2);
        this.defaultBorderSize = IntExtensionsKt.getPx(1);
        Paint paint = new Paint();
        this.drawPaint = paint;
        this.style = GPHGifButtonStyle.Companion.getDefaultSetting();
        this.color = GPHGifButtonColor.pink;
        this.backgroundRect = new RectF();
        this.bitmapRect = new RectF();
        Drawable drawable = getResources().getDrawable(this.style.getImage$ui_sdk_release());
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkExpressionValueIsNotNull(bitmap, "(resources.getDrawable(s…as BitmapDrawable).bitmap");
            this.gifBitmap = bitmap;
            paint.setAntiAlias(true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }

    public final GPHGifButtonStyle getStyle() {
        return this.style;
    }

    public final void setStyle(GPHGifButtonStyle gPHGifButtonStyle) {
        Intrinsics.checkParameterIsNotNull(gPHGifButtonStyle, "value");
        this.style = gPHGifButtonStyle;
        this.activeBorderSize = gPHGifButtonStyle.getMasked$ui_sdk_release() ? (float) IntExtensionsKt.getPx(this.defaultBorderSize) : 0.0f;
        styleButton();
    }

    public final GPHGifButtonColor getColor() {
        return this.color;
    }

    public final void setColor(GPHGifButtonColor gPHGifButtonColor) {
        Intrinsics.checkParameterIsNotNull(gPHGifButtonColor, "value");
        this.color = gPHGifButtonColor;
        styleButton();
    }

    private final void styleButton() {
        this.drawPaint.setStyle(this.style.getMasked$ui_sdk_release() ? Paint.Style.STROKE : Paint.Style.FILL);
        this.drawPaint.setColor(-1);
        this.drawPaint.setStrokeWidth(this.activeBorderSize);
        this.drawPaint.setShader((Shader) null);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 200.0f, 200.0f, this.color.getColors(), new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.gradientShader = linearGradient;
        this.drawPaint.setShader(linearGradient);
        this.drawPaint.setColor(ArraysKt.first(this.color.getColors()));
        Drawable drawable = getResources().getDrawable(this.style.getImage$ui_sdk_release());
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkExpressionValueIsNotNull(bitmap, "(resources.getDrawable(s…as BitmapDrawable).bitmap");
            Bitmap tintedWithLinearGradientColors = BitmapExtensionsKt.tintedWithLinearGradientColors(bitmap, this.color.getColors());
            this.gifBitmap = tintedWithLinearGradientColors;
            setImageBitmap(tintedWithLinearGradientColors);
            if (!this.style.getMasked$ui_sdk_release() && this.style.getRounded$ui_sdk_release() && Build.VERSION.SDK_INT >= 21) {
                setOutlineProvider(roundCornersProvider());
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.style.getMasked$ui_sdk_release()) {
            return;
        }
        if (this.style.getRounded$ui_sdk_release()) {
            if (Build.VERSION.SDK_INT >= 21 && canvas != null) {
                canvas.drawRoundRect(getHalfSizeBorder(), getHalfSizeBorder(), ((float) getWidth()) - getHalfSizeBorder(), ((float) getHeight()) - getHalfSizeBorder(), (float) IntExtensionsKt.getPx(this.defaultCornerRadius), (float) IntExtensionsKt.getPx(this.defaultCornerRadius), this.drawPaint);
            }
        } else if (canvas != null) {
            canvas.drawRect(getHalfSizeBorder(), getHalfSizeBorder(), ((float) getWidth()) - getHalfSizeBorder(), ((float) getHeight()) - getHalfSizeBorder(), this.drawPaint);
        }
    }

    private final GPHGifButton$roundCornersProvider$1 roundCornersProvider() {
        return new GPHGifButton$roundCornersProvider$1(this);
    }

    private final float getHalfSizeBorder() {
        return this.activeBorderSize / ((float) 2);
    }
}
