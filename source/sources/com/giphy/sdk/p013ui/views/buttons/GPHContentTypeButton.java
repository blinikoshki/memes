package com.giphy.sdk.p013ui.views.buttons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.giphy.sdk.p013ui.utils.BitmapExtensionsKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0019@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, mo26107d2 = {"Lcom/giphy/sdk/ui/views/buttons/GPHContentTypeButton;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundRect", "Landroid/graphics/RectF;", "bitmapRect", "value", "Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;", "color", "getColor", "()Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;", "setColor", "(Lcom/giphy/sdk/ui/views/buttons/GPHGifButtonColor;)V", "drawPaint", "Landroid/graphics/Paint;", "gifBitmap", "Landroid/graphics/Bitmap;", "gradientShader", "Landroid/graphics/LinearGradient;", "Lcom/giphy/sdk/ui/views/buttons/GPHContentTypeButtonStyle;", "style", "getStyle", "()Lcom/giphy/sdk/ui/views/buttons/GPHContentTypeButtonStyle;", "setStyle", "(Lcom/giphy/sdk/ui/views/buttons/GPHContentTypeButtonStyle;)V", "styleButton", "", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.views.buttons.GPHContentTypeButton */
/* compiled from: GPHContentTypeButton.kt */
public final class GPHContentTypeButton extends ImageView {
    private HashMap _$_findViewCache;
    private final RectF backgroundRect;
    private final RectF bitmapRect;
    private GPHGifButtonColor color;
    private final Paint drawPaint;
    private Bitmap gifBitmap;
    private LinearGradient gradientShader;
    private GPHContentTypeButtonStyle style;

    public GPHContentTypeButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GPHContentTypeButton(Context context, AttributeSet attributeSet) {
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
    public /* synthetic */ GPHContentTypeButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public GPHContentTypeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.drawPaint = paint;
        this.style = GPHContentTypeButtonStyle.Companion.getDefaultSetting();
        this.color = GPHGifButtonColor.pink;
        this.backgroundRect = new RectF();
        this.bitmapRect = new RectF();
        paint.setAntiAlias(true);
    }

    public final GPHContentTypeButtonStyle getStyle() {
        return this.style;
    }

    public final void setStyle(GPHContentTypeButtonStyle gPHContentTypeButtonStyle) {
        Intrinsics.checkParameterIsNotNull(gPHContentTypeButtonStyle, "value");
        this.style = gPHContentTypeButtonStyle;
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
        this.drawPaint.setStyle(Paint.Style.FILL);
        this.drawPaint.setColor(-1);
        this.drawPaint.setShader((Shader) null);
        this.gradientShader = new LinearGradient(this.backgroundRect.left, this.backgroundRect.bottom, this.backgroundRect.right, this.backgroundRect.top, this.color.getColors(), new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        Drawable drawable = getResources().getDrawable(this.style.getImage$ui_sdk_release());
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkExpressionValueIsNotNull(bitmap, "(resources.getDrawable(s…as BitmapDrawable).bitmap");
            Bitmap tintedWithLinearGradientColors = BitmapExtensionsKt.tintedWithLinearGradientColors(bitmap, this.color.getColors());
            this.gifBitmap = tintedWithLinearGradientColors;
            if (tintedWithLinearGradientColors == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gifBitmap");
            }
            setImageBitmap(tintedWithLinearGradientColors);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }
}
