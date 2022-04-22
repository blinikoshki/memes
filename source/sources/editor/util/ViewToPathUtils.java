package editor.util;

import android.graphics.Path;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Leditor/util/ViewToPathUtils;", "", "()V", "points", "", "createBoundsPath", "Landroid/graphics/Path;", "view", "Landroid/view/View;", "viewIntersects", "", "view1", "view2", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ViewToPathUtils.kt */
public final class ViewToPathUtils {
    private final float[] points = new float[16];

    public final boolean viewIntersects(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "view1");
        Intrinsics.checkNotNullParameter(view2, "view2");
        Path createBoundsPath = createBoundsPath(view);
        return createBoundsPath.op(createBoundsPath(view2), Path.Op.INTERSECT) && !createBoundsPath.isEmpty();
    }

    public final Path createBoundsPath(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        if (this.points.length == 16) {
            float width = (float) view.getWidth();
            float height = (float) view.getHeight();
            float[] fArr = this.points;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = width;
            fArr[3] = 0.0f;
            fArr[4] = width;
            fArr[5] = 0.0f;
            fArr[6] = width;
            fArr[7] = height;
            fArr[8] = width;
            fArr[9] = height;
            fArr[10] = 0.0f;
            fArr[11] = height;
            fArr[12] = 0.0f;
            fArr[13] = height;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            view.getMatrix().mapPoints(this.points);
            Path path = new Path();
            float[] fArr2 = this.points;
            path.moveTo(fArr2[0], fArr2[1]);
            float[] fArr3 = this.points;
            path.lineTo(fArr3[2], fArr3[3]);
            float[] fArr4 = this.points;
            path.lineTo(fArr4[6], fArr4[7]);
            float[] fArr5 = this.points;
            path.lineTo(fArr5[10], fArr5[11]);
            path.close();
            return path;
        }
        throw new RuntimeException("Points array must be of 16 elements.");
    }
}
