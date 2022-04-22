package editor.trash;

import android.view.View;
import com.facebook.imagepipeline.common.RotationOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a$\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0000¨\u0006\t"}, mo26107d2 = {"print", "", "Landroid/view/View;", "rotatedPoint", "", "x", "", "y", "title", "editor_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: Trash.kt */
public final class TrashKt {
    public static final void print(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$print");
        view.post(new TrashKt$print$1(view));
    }

    public static final String rotatedPoint(View view, float f, float f2, String str) {
        Intrinsics.checkNotNullParameter(view, "$this$rotatedPoint");
        Intrinsics.checkNotNullParameter(str, "title");
        float pivotX = f - view.getPivotX();
        float pivotY = f2 - view.getPivotY();
        double rotation = (((double) view.getRotation()) * 3.141592653589793d) / ((double) RotationOptions.ROTATE_180);
        double d = (double) pivotX;
        double d2 = (double) pivotY;
        double cos = ((Math.cos(rotation) * d) - (Math.sin(rotation) * d2)) + ((double) view.getPivotX());
        double sin = (d * Math.sin(rotation)) + (d2 * Math.cos(rotation)) + ((double) view.getPivotY());
        return str + " rotate-point: (" + cos + ", " + sin + ')';
    }
}
