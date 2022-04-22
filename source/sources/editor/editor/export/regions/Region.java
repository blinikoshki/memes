package editor.editor.export.regions;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, mo26107d2 = {"Leditor/editor/export/regions/Region;", "", "x", "", "y", "width", "height", "(IIII)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "isValid", "", "multiply", "", "value", "", "toRect", "Landroid/graphics/Rect;", "toString", "", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Region.kt */
public class Region {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private int height;
    private int width;

    /* renamed from: x */
    private int f1428x;

    /* renamed from: y */
    private int f1429y;

    public Region(int i, int i2, int i3, int i4) {
        this.f1428x = i;
        this.f1429y = i2;
        this.width = i3;
        this.height = i4;
    }

    public final int getX() {
        return this.f1428x;
    }

    public final void setX(int i) {
        this.f1428x = i;
    }

    public final int getY() {
        return this.f1429y;
    }

    public final void setY(int i) {
        this.f1429y = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/editor/export/regions/Region$Companion;", "", "()V", "empty", "Leditor/editor/export/regions/Region;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Region.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Region empty() {
            return new Region(0, 0, 0, 0);
        }
    }

    public final void multiply(int i) {
        this.f1428x *= i;
        this.f1429y *= i;
        this.width *= i;
        this.height *= i;
    }

    public final void multiply(float f) {
        this.f1428x = MathKt.roundToInt(((float) this.f1428x) * f);
        this.f1429y = MathKt.roundToInt(((float) this.f1429y) * f);
        this.width = MathKt.roundToInt(((float) this.width) * f);
        this.height = MathKt.roundToInt(((float) this.height) * f);
    }

    public final Rect toRect() {
        int i = this.f1428x;
        int i2 = this.f1429y;
        return new Rect(i, i2, this.width + i, this.height + i2);
    }

    public final boolean isValid() {
        if (this.width > 0 && this.height > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Region(x=" + this.f1428x + ", y=" + this.f1429y + ", width=" + this.width + ", height=" + this.height + ')';
    }
}
