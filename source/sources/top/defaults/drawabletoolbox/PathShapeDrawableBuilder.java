package top.defaults.drawabletoolbox;

import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u001e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/PathShapeDrawableBuilder;", "", "()V", "height", "", "path", "Landroid/graphics/Path;", "pathStandardHeight", "", "pathStandardWidth", "width", "build", "Landroid/graphics/drawable/ShapeDrawable;", "custom", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shapeDrawable", "", "size", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: PathShapeDrawableBuilder.kt */
public final class PathShapeDrawableBuilder {
    private int height = -1;
    private Path path;
    private float pathStandardHeight = 100.0f;
    private float pathStandardWidth = 100.0f;
    private int width = -1;

    public final PathShapeDrawableBuilder path(Path path2, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(path2, "path");
        PathShapeDrawableBuilder pathShapeDrawableBuilder = this;
        pathShapeDrawableBuilder.path = path2;
        pathShapeDrawableBuilder.pathStandardWidth = f;
        pathShapeDrawableBuilder.pathStandardHeight = f2;
        return pathShapeDrawableBuilder;
    }

    public final PathShapeDrawableBuilder width(int i) {
        PathShapeDrawableBuilder pathShapeDrawableBuilder = this;
        pathShapeDrawableBuilder.width = i;
        return pathShapeDrawableBuilder;
    }

    public final PathShapeDrawableBuilder height(int i) {
        PathShapeDrawableBuilder pathShapeDrawableBuilder = this;
        pathShapeDrawableBuilder.height = i;
        return pathShapeDrawableBuilder;
    }

    public final PathShapeDrawableBuilder size(int i) {
        PathShapeDrawableBuilder pathShapeDrawableBuilder = this;
        pathShapeDrawableBuilder.width(i).height(i);
        return pathShapeDrawableBuilder;
    }

    public static /* bridge */ /* synthetic */ ShapeDrawable build$default(PathShapeDrawableBuilder pathShapeDrawableBuilder, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return pathShapeDrawableBuilder.build(function1);
    }

    public final ShapeDrawable build(Function1<? super ShapeDrawable, Unit> function1) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        if (this.path != null && this.width > 0 && this.height > 0) {
            shapeDrawable.setShape(new PathShape(this.path, this.pathStandardWidth, this.pathStandardHeight));
            shapeDrawable.setIntrinsicWidth(this.width);
            shapeDrawable.setIntrinsicHeight(this.height);
            if (function1 != null) {
                function1.invoke(shapeDrawable);
            }
        }
        return shapeDrawable;
    }
}
