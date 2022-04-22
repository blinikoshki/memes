package editor.editor.equipment.text.effects;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.TextPaint;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\n\u0010\u0007\u001a\u00020\b\"\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Leditor/editor/equipment/text/effects/MultiColorTextEffect;", "Leditor/editor/equipment/text/effects/TextEffect;", "textView", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "colorSpeed", "", "colors", "", "linearGradient", "Landroid/graphics/LinearGradient;", "matrix", "Landroid/graphics/Matrix;", "initPaint", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColors", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MultiColorTextEffect.kt */
public class MultiColorTextEffect implements TextEffect {
    private float colorSpeed = 50.0f;
    private int[] colors = {SupportMenu.CATEGORY_MASK, -16777216};
    private LinearGradient linearGradient;
    private final Matrix matrix = new Matrix();
    private final TextView textView;

    public MultiColorTextEffect(TextView textView2) {
        Intrinsics.checkNotNullParameter(textView2, "textView");
        this.textView = textView2;
        initPaint();
    }

    private final void initPaint() {
        this.linearGradient = new LinearGradient(0.0f, 0.0f, (float) this.textView.getWidth(), (float) this.textView.getHeight(), this.colors, (float[]) null, Shader.TileMode.MIRROR);
        TextPaint paint = this.textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "textView.paint");
        paint.setShader(this.linearGradient);
    }

    public final void setColors(int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "colors");
        this.colors = iArr;
        initPaint();
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.matrix.postTranslate(this.colorSpeed, 0.0f);
        LinearGradient linearGradient2 = this.linearGradient;
        if (linearGradient2 != null) {
            linearGradient2.setLocalMatrix(this.matrix);
        }
        this.textView.postInvalidateDelayed(100);
    }
}
