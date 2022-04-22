package editor.editor.equipment.text;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import editor.editor.equipment.text.effects.TextEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/text/TextLayerView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "textEffect", "Leditor/editor/equipment/text/effects/TextEffect;", "drawEffect", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "setEffect", "effect", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextLayerView.kt */
public class TextLayerView extends AppCompatTextView {
    private TextEffect textEffect;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextLayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setEffect(TextEffect textEffect2) {
        Intrinsics.checkNotNullParameter(textEffect2, "effect");
        this.textEffect = textEffect2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        drawEffect(canvas);
        super.onDraw(canvas);
    }

    private final void drawEffect(Canvas canvas) {
        TextEffect textEffect2;
        if (canvas != null && (textEffect2 = this.textEffect) != null) {
            textEffect2.onDraw(canvas);
        }
    }
}
