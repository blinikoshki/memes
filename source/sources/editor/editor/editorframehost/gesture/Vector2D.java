package editor.editor.editorframehost.gesture;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\n"}, mo26107d2 = {"Leditor/editor/editorframehost/gesture/Vector2D;", "Landroid/graphics/PointF;", "()V", "x", "", "y", "(FF)V", "normalize", "", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Vector2D.kt */
public final class Vector2D extends PointF {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, mo26107d2 = {"Leditor/editor/editorframehost/gesture/Vector2D$Companion;", "", "()V", "getAngle", "", "vector1", "Leditor/editor/editorframehost/gesture/Vector2D;", "vector2", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Vector2D.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float getAngle(Vector2D vector2D, Vector2D vector2D2) {
            Intrinsics.checkNotNullParameter(vector2D, "vector1");
            Intrinsics.checkNotNullParameter(vector2D2, "vector2");
            vector2D.normalize();
            vector2D2.normalize();
            return (float) ((Math.atan2((double) vector2D2.y, (double) vector2D2.x) - Math.atan2((double) vector2D.y, (double) vector2D.x)) * 57.29577951308232d);
        }
    }

    public Vector2D() {
    }

    public Vector2D(float f, float f2) {
        super(f, f2);
    }

    /* access modifiers changed from: private */
    public final void normalize() {
        float sqrt = (float) Math.sqrt(((double) (this.x * this.x)) + (((double) this.y) * ((double) this.y)));
        this.x /= sqrt;
        this.y /= sqrt;
    }
}
