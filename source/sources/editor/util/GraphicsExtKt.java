package editor.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001ad\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0015"}, mo26107d2 = {"aspectRatio", "", "Landroid/graphics/Rect;", "drawRoundedCornersRect", "", "Landroid/graphics/Canvas;", "left", "top", "right", "bottom", "centerX", "centerY", "topLeftCorner", "", "topRightCorner", "bottomRightCorner", "bottomLeftCorner", "paint", "Landroid/graphics/Paint;", "heightF", "widthF", "editor_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: GraphicsExt.kt */
public final class GraphicsExtKt {
    public static final float aspectRatio(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "$this$aspectRatio");
        return widthF(rect) / heightF(rect);
    }

    public static final float widthF(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "$this$widthF");
        return (float) rect.width();
    }

    public static final float heightF(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "$this$heightF");
        return (float) rect.height();
    }

    public static final void drawRoundedCornersRect(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, Paint paint) {
        Canvas canvas2 = canvas;
        float f7 = f3;
        Paint paint2 = paint;
        Intrinsics.checkNotNullParameter(canvas, "$this$drawRoundedCornersRect");
        Intrinsics.checkNotNullParameter(paint2, "paint");
        Path path = new Path();
        float f8 = (float) 0;
        float f9 = f5 < f8 ? 0.0f : f5;
        float f10 = f6 < f8 ? 0.0f : f6;
        float f11 = f7 - f;
        float f12 = f4 - f2;
        float f13 = (float) 2;
        float f14 = f11 / f13;
        if (f9 > f14) {
            f9 = f14;
        }
        float f15 = f12 / f13;
        if (f10 > f15) {
            f10 = f15;
        }
        float f16 = f11 - (f13 * f9);
        float f17 = f12 - (f13 * f10);
        path.moveTo(f3, f2 + f10);
        if (z2) {
            float f18 = -f10;
            path.rQuadTo(0.0f, f18, -f9, f18);
        } else {
            path.rLineTo(0.0f, -f10);
            path.rLineTo(-f9, 0.0f);
        }
        path.rLineTo(-f16, 0.0f);
        if (z) {
            float f19 = -f9;
            path.rQuadTo(f19, 0.0f, f19, f10);
        } else {
            path.rLineTo(-f9, 0.0f);
            path.rLineTo(0.0f, f10);
        }
        path.rLineTo(0.0f, f17);
        if (z4) {
            path.rQuadTo(0.0f, f10, f9, f10);
        } else {
            path.rLineTo(0.0f, f10);
            path.rLineTo(f9, 0.0f);
        }
        path.rLineTo(f16, 0.0f);
        if (z3) {
            path.rQuadTo(f9, 0.0f, f9, -f10);
        } else {
            path.rLineTo(f9, 0.0f);
            path.rLineTo(0.0f, -f10);
        }
        path.rLineTo(0.0f, -f17);
        path.close();
        canvas.drawPath(path, paint2);
    }
}
