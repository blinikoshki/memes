package editor.tools.videotrim.timeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J(\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u0006\u0010\u001f\u001a\u00020\u0015J\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0014\u0010\"\u001a\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110#J\u0010\u0010$\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo26107d2 = {"Leditor/tools/videotrim/timeline/BitmapTimeLineView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPaint", "Landroid/graphics/Paint;", "getBgPaint", "()Landroid/graphics/Paint;", "bgPaint$delegate", "Lkotlin/Lazy;", "bitmaps", "", "Landroid/graphics/Bitmap;", "callback", "Leditor/tools/videotrim/timeline/BitmapTimelineCallback;", "clearBitmaps", "", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldW", "oldH", "refresh", "width", "height", "setBitmaps", "", "setCallback", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BitmapTimeLineView.kt */
public class BitmapTimeLineView extends View {
    private final Lazy bgPaint$delegate;
    private final List<Bitmap> bitmaps;
    private BitmapTimelineCallback callback;

    public BitmapTimeLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    private final Paint getBgPaint() {
        return (Paint) this.bgPaint$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BitmapTimeLineView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BitmapTimeLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.bitmaps = new ArrayList();
        this.bgPaint$delegate = LazyKt.lazy(BitmapTimeLineView$bgPaint$2.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        if (!this.bitmaps.isEmpty()) {
            float height = (float) getHeight();
            float f = 0.0f;
            for (Bitmap next : this.bitmaps) {
                if (f <= ((float) getWidth())) {
                    canvas.drawBitmap(next, f, 0.0f, (Paint) null);
                    if (height != 0.0f) {
                        f += height;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            refresh();
        }
    }

    public final void setCallback(BitmapTimelineCallback bitmapTimelineCallback) {
        this.callback = bitmapTimelineCallback;
    }

    public final void setBitmaps(List<Bitmap> list) {
        Intrinsics.checkNotNullParameter(list, "bitmaps");
        clearBitmaps();
        this.bitmaps.addAll(list);
        invalidate();
    }

    public final void refresh() {
        if (getWidth() != 0 && getHeight() != 0) {
            refresh(getWidth(), getHeight());
        }
    }

    private final void refresh(int i, int i2) {
        int i3 = (i / i2) + 1;
        BitmapTimelineCallback bitmapTimelineCallback = this.callback;
        if (bitmapTimelineCallback != null) {
            bitmapTimelineCallback.onRequestTimelineBitmaps(i3, i2);
        }
        clearBitmaps();
        invalidate();
    }

    public final void clearBitmaps() {
        if (!this.bitmaps.isEmpty()) {
            for (Bitmap recycle : this.bitmaps) {
                recycle.recycle();
            }
            this.bitmaps.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        clearBitmaps();
        super.onDetachedFromWindow();
    }
}
