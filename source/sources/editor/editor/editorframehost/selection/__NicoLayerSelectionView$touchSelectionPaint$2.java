package editor.editor.editorframehost.selection;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: __NicoLayerSelectionView.kt */
final class __NicoLayerSelectionView$touchSelectionPaint$2 extends Lambda implements Function0<Paint> {
    public static final __NicoLayerSelectionView$touchSelectionPaint$2 INSTANCE = new __NicoLayerSelectionView$touchSelectionPaint$2();

    __NicoLayerSelectionView$touchSelectionPaint$2() {
        super(0);
    }

    public final Paint invoke() {
        Paint paint = new Paint();
        paint.setColor(1157562368);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        return paint;
    }
}
