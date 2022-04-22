package editor.tools.videotrim.rangeseekbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: RangeSeekBarView.kt */
final class RangeSeekBarView$strokePaint$2 extends Lambda implements Function0<Paint> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RangeSeekBarView$strokePaint$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final Paint invoke() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        Resources resources = this.$context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        paint.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, resources.getDisplayMetrics()));
        paint.setColor((int) 4294967295L);
        return paint;
    }
}
