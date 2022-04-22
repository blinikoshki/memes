package editor.common.colorshadeselector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.memes.editor.C4175R;
import editor.util.GraphicsExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001AB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0002J\u0012\u0010/\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J(\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0014J\u0012\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u0017H\u0016J\b\u00109\u001a\u00020\nH\u0002J\u0016\u0010:\u001a\u00020%2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0<H\u0002J\u000e\u0010=\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010>\u001a\u00020%2\u0006\u0010&\u001a\u00020\n2\b\b\u0002\u0010?\u001a\u00020\u0017J\u000e\u0010@\u001a\u00020%2\u0006\u0010&\u001a\u00020\nR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0019\u0010\u000eR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, mo26107d2 = {"Leditor/common/colorshadeselector/ColorShadeSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Leditor/common/colorshadeselector/ColorShadeSelector$Callback;", "cellCount", "", "cellPaint", "Landroid/graphics/Paint;", "getCellPaint", "()Landroid/graphics/Paint;", "cellPaint$delegate", "Lkotlin/Lazy;", "cellRect", "Landroid/graphics/RectF;", "cellSize", "colors", "", "hasIndicatorShadow", "", "indicatorBorderPaint", "getIndicatorBorderPaint", "indicatorBorderPaint$delegate", "indicatorBorderRadius", "", "indicatorRadius", "indicatorShadow", "isClick", "selectedColor", "sourceColor", "stripHeight", "viewWidth", "drawCell", "", "color", "canvas", "Landroid/graphics/Canvas;", "drawCellEndRounding", "drawCellStartRounding", "drawIndicator", "getColorAtPoint", "x", "y", "onDraw", "onSizeChanged", "width", "height", "oldWidth", "oldHeight", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "recalculateCellSize", "setColors", "newColors", "", "setOnColorChangedListener", "setSelectedColor", "useCallback", "setSourceColor", "Callback", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ColorShadeSelector.kt */
public final class ColorShadeSelector extends View {
    private Callback callback;
    private int cellCount = 7;
    private final Lazy cellPaint$delegate = LazyKt.lazy(ColorShadeSelector$cellPaint$2.INSTANCE);
    private final RectF cellRect = new RectF();
    private int cellSize;
    private final List<Integer> colors = new ArrayList();
    private boolean hasIndicatorShadow = true;
    private final Lazy indicatorBorderPaint$delegate;
    private float indicatorBorderRadius;
    private float indicatorRadius;
    private final float indicatorShadow;
    private boolean isClick;
    private int selectedColor = -1;
    private int sourceColor = -1;
    private float stripHeight;
    private int viewWidth;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/common/colorshadeselector/ColorShadeSelector$Callback;", "", "onColorChanged", "", "newColor", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ColorShadeSelector.kt */
    public interface Callback {
        void onColorChanged(int i);
    }

    private final Paint getCellPaint() {
        return (Paint) this.cellPaint$delegate.getValue();
    }

    private final Paint getIndicatorBorderPaint() {
        return (Paint) this.indicatorBorderPaint$delegate.getValue();
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ColorShadeSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(C4175R.dimen._2sdp);
        this.indicatorShadow = dimensionPixelSize;
        this.indicatorBorderPaint$delegate = LazyKt.lazy(ColorShadeSelector$indicatorBorderPaint$2.INSTANCE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.ColorShadeSelector, 0, 0);
        try {
            this.cellCount = obtainStyledAttributes.getInteger(C4175R.styleable.ColorShadeSelector_cps_cells, this.cellCount);
            this.sourceColor = obtainStyledAttributes.getColor(C4175R.styleable.ColorShadeSelector_cps_color, this.sourceColor);
            this.stripHeight = (float) obtainStyledAttributes.getDimensionPixelSize(C4175R.styleable.ColorShadeSelector_cps_strip_height, getResources().getDimensionPixelSize(C4175R.dimen._7sdp));
            this.indicatorRadius = (float) obtainStyledAttributes.getDimensionPixelSize(C4175R.styleable.ColorShadeSelector_cps_indicator_radius, getResources().getDimensionPixelSize(C4175R.dimen._6sdp));
            this.indicatorBorderRadius = (float) obtainStyledAttributes.getDimensionPixelSize(C4175R.styleable.ColorShadeSelector_cps_indicator_border_radius, getResources().getDimensionPixelSize(C4175R.dimen._7sdp));
            this.hasIndicatorShadow = obtainStyledAttributes.getBoolean(C4175R.styleable.ColorShadeSelector_cps_indicator_shadow, this.hasIndicatorShadow);
            obtainStyledAttributes.recycle();
            if (this.hasIndicatorShadow) {
                getIndicatorBorderPaint().setShadowLayer(dimensionPixelSize, 0.0f, 1.0f, -16777216);
                setLayerType(1, getIndicatorBorderPaint());
            }
            setSourceColor(this.sourceColor);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setSourceColor(int i) {
        this.sourceColor = i;
        this.selectedColor = i;
        setColors(ColorShadesGenerator.INSTANCE.generateShadesOf(i, this.cellCount));
    }

    private final void setColors(List<Integer> list) {
        this.colors.clear();
        this.colors.addAll(list);
        if (!this.colors.contains(Integer.valueOf(this.selectedColor))) {
            List<Integer> list2 = this.colors;
            this.selectedColor = list2.get(list2.size() / 2).intValue();
        }
        recalculateCellSize();
        invalidate();
    }

    public static /* synthetic */ void setSelectedColor$default(ColorShadeSelector colorShadeSelector, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        colorShadeSelector.setSelectedColor(i, z);
    }

    public final void setSelectedColor(int i, boolean z) {
        Callback callback2;
        if (this.selectedColor != i) {
            this.selectedColor = i;
            invalidate();
            if (z && (callback2 = this.callback) != null) {
                callback2.onColorChanged(i);
            }
        }
    }

    public final void setOnColorChangedListener(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            this.cellRect.left = (float) getPaddingStart();
            this.cellRect.top = (((float) getHeight()) / 2.0f) - (this.stripHeight / 2.0f);
            RectF rectF = this.cellRect;
            rectF.right = rectF.left;
            RectF rectF2 = this.cellRect;
            rectF2.bottom = rectF2.top + this.stripHeight;
            int i = 0;
            for (Object next : this.colors) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int intValue = ((Number) next).intValue();
                drawCell(intValue, canvas);
                if (i == 0) {
                    drawCellStartRounding(canvas);
                } else if (i == this.colors.size() - 1) {
                    drawCellEndRounding(canvas);
                }
                if (intValue == this.selectedColor) {
                    getCellPaint().setColor(intValue);
                    drawIndicator(canvas);
                }
                i = i2;
            }
        }
    }

    private final void drawCell(int i, Canvas canvas) {
        getCellPaint().setColor(i);
        RectF rectF = this.cellRect;
        rectF.left = rectF.right;
        this.cellRect.right += (float) this.cellSize;
        canvas.drawRect(this.cellRect, getCellPaint());
    }

    private final void drawCellStartRounding(Canvas canvas) {
        GraphicsExtKt.drawRoundedCornersRect(canvas, this.cellRect.left - (this.stripHeight / ((float) 4)), this.cellRect.top, this.cellRect.left, this.cellRect.top + this.stripHeight, this.cellRect.left, this.cellRect.top + (this.cellRect.height() / ((float) 2)), true, false, false, true, getCellPaint());
    }

    private final void drawCellEndRounding(Canvas canvas) {
        GraphicsExtKt.drawRoundedCornersRect(canvas, this.cellRect.right, this.cellRect.top, this.cellRect.right + (this.stripHeight / ((float) 4)), this.cellRect.top + this.stripHeight, this.cellRect.right, this.cellRect.top + (this.cellRect.height() / ((float) 2)), false, true, true, false, getCellPaint());
    }

    private final void drawIndicator(Canvas canvas) {
        canvas.drawCircle(this.cellRect.centerX(), this.cellRect.centerY(), this.indicatorBorderRadius, getIndicatorBorderPaint());
        canvas.drawCircle(this.cellRect.centerX(), this.cellRect.centerY(), this.indicatorRadius, getCellPaint());
    }

    public boolean performClick() {
        return super.performClick();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.isClick = true;
        } else if (valueOf != null && valueOf.intValue() == 1) {
            setSelectedColor$default(this, getColorAtPoint((int) motionEvent.getX(), (int) motionEvent.getY()), false, 2, (Object) null);
            if (this.isClick) {
                performClick();
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            setSelectedColor$default(this, getColorAtPoint((int) motionEvent.getX(), (int) motionEvent.getY()), false, 2, (Object) null);
        } else if (valueOf != null && valueOf.intValue() == 3) {
            this.isClick = false;
        } else if (valueOf != null && valueOf.intValue() == 4) {
            this.isClick = false;
        }
        return true;
    }

    private final int getColorAtPoint(int i, int i2) {
        int paddingStart = getPaddingStart();
        for (Number intValue : this.colors) {
            int intValue2 = intValue.intValue();
            int i3 = this.cellSize + paddingStart;
            if (paddingStart <= i && i3 >= i) {
                return intValue2;
            }
            paddingStart = i3;
        }
        return this.selectedColor;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.viewWidth = i;
        recalculateCellSize();
        super.onSizeChanged(i, i2, i3, i4);
    }

    private final int recalculateCellSize() {
        int roundToInt = MathKt.roundToInt(((float) ((this.viewWidth - getPaddingStart()) - getPaddingEnd())) / ((float) this.colors.size()));
        this.cellSize = roundToInt;
        return roundToInt;
    }
}
