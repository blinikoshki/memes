package editor.trash;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: Trash.kt */
final class TrashKt$print$1 implements Runnable {
    final /* synthetic */ View $this_print;

    TrashKt$print$1(View view) {
        this.$this_print = view;
    }

    public final void run() {
        StringBuilder sb = new StringBuilder();
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("View.print()");
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n\t\t\t.appe…\t\t.append(\"View.print()\")");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("pivot(pX=" + this.$this_print.getPivotX() + ", pY=" + this.$this_print.getPivotY() + ')');
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("coord(x=" + this.$this_print.getX() + ", y=" + this.$this_print.getY() + ", w=" + this.$this_print.getWidth() + ", h=" + this.$this_print.getHeight() + ')');
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("scale(sX=");
        sb2.append(this.$this_print.getScaleX());
        sb2.append(", sY=");
        sb2.append(this.$this_print.getScaleY());
        sb2.append(')');
        sb.append(sb2.toString());
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append("rotation(r=" + this.$this_print.getRotation() + ", rX=" + this.$this_print.getRotationX() + ", rY=" + this.$this_print.getRotationY() + ')');
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        Rect rect = new Rect();
        this.$this_print.getLocalVisibleRect(rect);
        sb.append("local-visible rect: " + rect);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        this.$this_print.getGlobalVisibleRect(rect);
        sb.append("global-visible rect: " + rect);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        this.$this_print.getHitRect(rect);
        sb.append("hit rect: " + rect);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        this.$this_print.getDrawingRect(rect);
        sb.append("drawing rect: " + rect);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        View view = this.$this_print;
        sb.append(TrashKt.rotatedPoint(view, view.getX(), this.$this_print.getY(), "OX, OY"));
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        View view2 = this.$this_print;
        sb.append(TrashKt.rotatedPoint(view2, view2.getX(), this.$this_print.getY() + ((float) this.$this_print.getHeight()), "OX, WY"));
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        View view3 = this.$this_print;
        sb.append(TrashKt.rotatedPoint(view3, view3.getX() + ((float) this.$this_print.getWidth()), this.$this_print.getY(), "WX, OY"));
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        View view4 = this.$this_print;
        sb.append(TrashKt.rotatedPoint(view4, view4.getX() + ((float) this.$this_print.getWidth()), this.$this_print.getY() + ((float) this.$this_print.getHeight()), "WX, WY"));
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        Timber.m300d(sb.toString(), new Object[0]);
    }
}
