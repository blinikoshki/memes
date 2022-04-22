package editor.tools.videotrim.rangeseekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0019J\u0010\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\nH\u0002J\u0010\u00105\u001a\u0002012\u0006\u00104\u001a\u00020\nH\u0002J\u0012\u00106\u001a\u0004\u0018\u00010\n2\u0006\u00107\u001a\u00020\u0012H\u0002J\u0018\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0012H\u0002J\u0006\u0010:\u001a\u00020\u001fJ\u0010\u0010;\u001a\u0002012\u0006\u00107\u001a\u00020\u0012H\u0002J\b\u0010<\u001a\u000201H\u0002J\u0010\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020?H\u0014J\u0010\u0010@\u001a\u0002012\u0006\u00107\u001a\u00020\u0012H\u0002J\u0018\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007H\u0014J\u0010\u0010D\u001a\u0002012\u0006\u00104\u001a\u00020\nH\u0002J\u0010\u0010E\u001a\u0002012\u0006\u00104\u001a\u00020\nH\u0002J\u0010\u0010F\u001a\u0002012\u0006\u00107\u001a\u00020\u0012H\u0002J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020IH\u0017J\u0016\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u0012J\u0016\u0010M\u001a\u0002012\u0006\u0010N\u001a\u00020\u00122\u0006\u0010O\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b!\u0010\u000eR\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b%\u0010\u000eR\u000e\u0010'\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b.\u0010\u000e¨\u0006P"}, mo26107d2 = {"Leditor/tools/videotrim/rangeseekbar/RangeSeekBarView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentThumb", "Leditor/tools/videotrim/rangeseekbar/Thumb;", "edgeCirclePaint", "Landroid/graphics/Paint;", "getEdgeCirclePaint", "()Landroid/graphics/Paint;", "edgeCirclePaint$delegate", "Lkotlin/Lazy;", "edgeCircleRadius", "", "getEdgeCircleRadius", "()F", "edgeCircleRadius$delegate", "endThumb", "listeners", "Ljava/util/HashSet;", "Leditor/tools/videotrim/rangeseekbar/OnRangeSeekBarListener;", "Lkotlin/collections/HashSet;", "maxSeparation", "minSeparation", "pixelStartX", "ready", "", "shadowPaint", "getShadowPaint", "shadowPaint$delegate", "startThumb", "strokePaint", "getStrokePaint", "strokePaint$delegate", "thumbTouchExtraMultiplier", "thumbWidth", "getThumbWidth", "()I", "thumbWidth$delegate", "totalPixelDistance", "touchPaint", "getTouchPaint", "touchPaint$delegate", "addOnRangeSeekBarListener", "", "listener", "calculateThumbPosition", "thumb", "calculateThumbValue", "findClosestThumb", "touchPositionX", "getThumbDistanceFromX", "thumbPositionX", "isReady", "onCenterThumbMoved", "onCreated", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onEndThumbMoved", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSeek", "onSeekStop", "onStartThumbMoved", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setSeparationRange", "minSeparationPercent", "maxSeparationPercent", "setThumbValues", "startValue", "endValue", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RangeSeekBarView.kt */
public final class RangeSeekBarView extends View {
    private Thumb currentThumb;
    private final Lazy edgeCirclePaint$delegate;
    private final Lazy edgeCircleRadius$delegate;
    private Thumb endThumb;
    private HashSet<OnRangeSeekBarListener> listeners;
    private float maxSeparation;
    private float minSeparation;
    private float pixelStartX;
    private boolean ready;
    private final Lazy shadowPaint$delegate;
    private Thumb startThumb;
    private final Lazy strokePaint$delegate;
    private final float thumbTouchExtraMultiplier;
    private final Lazy thumbWidth$delegate;
    private float totalPixelDistance;
    private final Lazy touchPaint$delegate;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ThumbType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ThumbType.START.ordinal()] = 1;
            iArr[ThumbType.CENTER.ordinal()] = 2;
            iArr[ThumbType.END.ordinal()] = 3;
            int[] iArr2 = new int[ThumbType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ThumbType.START.ordinal()] = 1;
            iArr2[ThumbType.END.ordinal()] = 2;
        }
    }

    public RangeSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    private final Paint getEdgeCirclePaint() {
        return (Paint) this.edgeCirclePaint$delegate.getValue();
    }

    private final float getEdgeCircleRadius() {
        return ((Number) this.edgeCircleRadius$delegate.getValue()).floatValue();
    }

    private final Paint getShadowPaint() {
        return (Paint) this.shadowPaint$delegate.getValue();
    }

    private final Paint getStrokePaint() {
        return (Paint) this.strokePaint$delegate.getValue();
    }

    private final Paint getTouchPaint() {
        return (Paint) this.touchPaint$delegate.getValue();
    }

    public final int getThumbWidth() {
        return ((Number) this.thumbWidth$delegate.getValue()).intValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RangeSeekBarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RangeSeekBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.thumbTouchExtraMultiplier = 1.0f;
        this.startThumb = new Thumb(ThumbType.START);
        this.endThumb = new Thumb(ThumbType.END);
        this.currentThumb = this.startThumb;
        this.shadowPaint$delegate = LazyKt.lazy(RangeSeekBarView$shadowPaint$2.INSTANCE);
        this.strokePaint$delegate = LazyKt.lazy(new RangeSeekBarView$strokePaint$2(context));
        this.edgeCirclePaint$delegate = LazyKt.lazy(RangeSeekBarView$edgeCirclePaint$2.INSTANCE);
        this.touchPaint$delegate = LazyKt.lazy(RangeSeekBarView$touchPaint$2.INSTANCE);
        this.listeners = new HashSet<>();
        this.thumbWidth$delegate = LazyKt.lazy(new RangeSeekBarView$thumbWidth$2(context));
        this.edgeCircleRadius$delegate = LazyKt.lazy(new RangeSeekBarView$edgeCircleRadius$2(context));
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        float thumbWidth = (float) getThumbWidth();
        this.pixelStartX = thumbWidth;
        this.totalPixelDistance = ((float) measuredWidth) - (thumbWidth * ((float) 2));
        if (!this.ready) {
            this.startThumb.setValue(0.0f);
            this.startThumb.setPosition(this.pixelStartX);
            this.endThumb.setValue(100.0f);
            this.endThumb.setPosition(this.pixelStartX + this.totalPixelDistance);
            this.ready = true;
            onCreated();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float position = this.startThumb.getPosition() + ((float) getPaddingLeft());
        float f = this.pixelStartX;
        if (position > f) {
            canvas.drawRect(f, 0.0f, position, (float) getHeight(), getShadowPaint());
        }
        float position2 = this.endThumb.getPosition() - ((float) getPaddingRight());
        float f2 = this.pixelStartX;
        float f3 = this.totalPixelDistance;
        if (position2 < f2 + f3) {
            canvas.drawRect(position2, 0.0f, f2 + f3, (float) getHeight(), getShadowPaint());
        }
        canvas.drawRect(this.startThumb.getPosition() + ((float) getPaddingLeft()), getStrokePaint().getStrokeWidth() / 2.0f, this.endThumb.getPosition() - ((float) getPaddingRight()), ((float) getHeight()) - (getStrokePaint().getStrokeWidth() / 2.0f), getStrokePaint());
        canvas.drawCircle(this.startThumb.getPosition() + ((float) getPaddingLeft()), ((float) getHeight()) / 2.0f, getEdgeCircleRadius(), getEdgeCirclePaint());
        canvas.drawCircle(this.endThumb.getPosition() - ((float) getPaddingRight()), ((float) getHeight()) / 2.0f, getEdgeCircleRadius(), getEdgeCirclePaint());
        if (isInEditMode()) {
            getTouchPaint().setColor(1157562368);
            canvas.drawRect(this.startThumb.getPosition() - (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier), 0.0f, this.startThumb.getPosition() + (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier), (float) getHeight(), getTouchPaint());
            canvas.drawRect(this.endThumb.getPosition() - (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier), 0.0f, this.endThumb.getPosition() + (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier), (float) getHeight(), getTouchPaint());
            getTouchPaint().setColor(1140915968);
            canvas.drawRect(this.startThumb.getPosition() + (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier), 0.0f, this.endThumb.getPosition() - (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier), (float) getHeight(), getTouchPaint());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            Thumb findClosestThumb = findClosestThumb(x);
            if (findClosestThumb == null) {
                this.currentThumb = NullThumb.INSTANCE;
                return false;
            }
            this.currentThumb = findClosestThumb;
            findClosestThumb.setLastTouchX(x);
            return true;
        } else if (action == 1) {
            Thumb thumb = this.currentThumb;
            if (thumb instanceof NullThumb) {
                return false;
            }
            onSeekStop(thumb);
            return true;
        } else if (action != 2) {
            return false;
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[this.currentThumb.getType().ordinal()];
            if (i == 1) {
                onStartThumbMoved(x);
            } else if (i == 2) {
                onCenterThumbMoved(x);
            } else if (i == 3) {
                onEndThumbMoved(x);
            }
            invalidate();
            return true;
        }
    }

    private final void onStartThumbMoved(float f) {
        float lastTouchX = f - this.startThumb.getLastTouchX();
        float position = this.startThumb.getPosition() + lastTouchX;
        if (position >= this.endThumb.getPosition() - this.minSeparation) {
            this.startThumb.setPosition(this.endThumb.getPosition() - this.minSeparation);
        } else {
            float f2 = this.pixelStartX;
            if (position <= f2) {
                this.startThumb.setPosition(f2);
                if (lastTouchX < ((float) 0) && this.endThumb.getPosition() - this.startThumb.getPosition() > this.maxSeparation) {
                    this.endThumb.setPosition(this.startThumb.getPosition() + this.maxSeparation);
                    calculateThumbValue(this.endThumb);
                }
            } else {
                if (lastTouchX < ((float) 0)) {
                    float f3 = this.maxSeparation;
                    if (this.endThumb.getPosition() - position > f3) {
                        this.endThumb.setPosition(position + f3);
                        calculateThumbValue(this.endThumb);
                    }
                }
                Thumb thumb = this.startThumb;
                thumb.setPosition(thumb.getPosition() + lastTouchX);
                this.startThumb.setLastTouchX(f);
            }
        }
        calculateThumbValue(this.startThumb);
    }

    private final void onCenterThumbMoved(float f) {
        float lastTouchX = f - CenterThumb.INSTANCE.getLastTouchX();
        float position = this.startThumb.getPosition() + lastTouchX;
        float position2 = this.endThumb.getPosition() + lastTouchX;
        float coerceIn = RangesKt.coerceIn(position2 - position, this.minSeparation, this.maxSeparation);
        float f2 = this.pixelStartX;
        if (position <= f2) {
            this.startThumb.setPosition(f2);
            this.endThumb.setPosition(this.startThumb.getPosition() + coerceIn);
        } else {
            float f3 = this.totalPixelDistance;
            if (position2 >= f2 + f3) {
                this.endThumb.setPosition(f2 + f3);
                this.startThumb.setPosition(this.endThumb.getPosition() - coerceIn);
            } else {
                this.startThumb.setPosition(position);
                this.endThumb.setPosition(position2);
                CenterThumb.INSTANCE.setLastTouchX(f);
            }
        }
        calculateThumbValue(this.startThumb);
        calculateThumbValue(this.endThumb);
    }

    private final void onEndThumbMoved(float f) {
        float lastTouchX = f - this.endThumb.getLastTouchX();
        float position = this.endThumb.getPosition() + lastTouchX;
        if (position <= this.startThumb.getPosition() + this.minSeparation) {
            this.endThumb.setPosition(this.startThumb.getPosition() + this.minSeparation);
        } else {
            float f2 = this.pixelStartX;
            float f3 = this.totalPixelDistance;
            if (position >= f2 + f3) {
                this.endThumb.setPosition(f2 + f3);
                if (lastTouchX > ((float) 0) && this.endThumb.getPosition() - this.startThumb.getPosition() > this.maxSeparation) {
                    this.startThumb.setPosition(this.endThumb.getPosition() - this.maxSeparation);
                    calculateThumbValue(this.startThumb);
                }
            } else {
                if (lastTouchX > ((float) 0)) {
                    float f4 = this.maxSeparation;
                    if (position - this.startThumb.getPosition() > f4) {
                        this.startThumb.setPosition(position - f4);
                        calculateThumbValue(this.startThumb);
                    }
                }
                Thumb thumb = this.endThumb;
                thumb.setPosition(thumb.getPosition() + lastTouchX);
                this.endThumb.setLastTouchX(f);
            }
        }
        calculateThumbValue(this.endThumb);
    }

    private final void calculateThumbValue(Thumb thumb) {
        float f;
        float f2;
        float f3;
        int i = WhenMappings.$EnumSwitchMapping$1[thumb.getType().ordinal()];
        if (i == 1) {
            f3 = (thumb.getPosition() - this.pixelStartX) * ((float) 100);
            f2 = this.totalPixelDistance;
        } else if (i != 2) {
            f = thumb.getValue();
            thumb.setValue(f);
            onSeek(thumb);
        } else {
            f3 = (thumb.getPosition() - this.pixelStartX) * ((float) 100);
            f2 = this.totalPixelDistance;
        }
        f = f3 / f2;
        thumb.setValue(f);
        onSeek(thumb);
    }

    private final void calculateThumbPosition(Thumb thumb) {
        thumb.setPosition(this.pixelStartX + ((this.totalPixelDistance * thumb.getValue()) / 100.0f));
    }

    public final boolean isReady() {
        return this.ready;
    }

    public final void setThumbValues(float f, float f2) {
        this.startThumb.setValue(f);
        calculateThumbPosition(this.startThumb);
        this.endThumb.setValue(f2);
        calculateThumbPosition(this.endThumb);
        invalidate();
    }

    public final void setSeparationRange(float f, float f2) {
        float f3 = this.totalPixelDistance;
        this.minSeparation = (f * f3) / 100.0f;
        this.maxSeparation = (f3 * f2) / 100.0f;
    }

    private final Thumb findClosestThumb(float f) {
        float thumbDistanceFromX = getThumbDistanceFromX(this.startThumb.getPosition(), f);
        float thumbDistanceFromX2 = getThumbDistanceFromX(this.endThumb.getPosition(), f);
        if (thumbDistanceFromX == Float.MAX_VALUE && thumbDistanceFromX2 == Float.MAX_VALUE) {
            float position = this.startThumb.getPosition() + (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier);
            float position2 = this.endThumb.getPosition() - (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier);
            if (f < position || f > position2) {
                return null;
            }
            return CenterThumb.INSTANCE;
        } else if (thumbDistanceFromX <= thumbDistanceFromX2) {
            return this.startThumb;
        } else {
            if (thumbDistanceFromX2 < thumbDistanceFromX) {
                return this.endThumb;
            }
            return null;
        }
    }

    private final float getThumbDistanceFromX(float f, float f2) {
        float thumbWidth = (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier) + f;
        if (f2 < f - (((float) getThumbWidth()) * this.thumbTouchExtraMultiplier) || f2 > thumbWidth) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f - f2);
    }

    public final void addOnRangeSeekBarListener(OnRangeSeekBarListener onRangeSeekBarListener) {
        Intrinsics.checkNotNullParameter(onRangeSeekBarListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(onRangeSeekBarListener);
    }

    private final void onCreated() {
        for (OnRangeSeekBarListener onSeekRangeCreated : this.listeners) {
            onSeekRangeCreated.onSeekRangeCreated(this);
        }
    }

    private final void onSeek(Thumb thumb) {
        for (OnRangeSeekBarListener onSeekRangeChanged : this.listeners) {
            onSeekRangeChanged.onSeekRangeChanged(this, thumb.getType(), thumb.getValue());
        }
    }

    private final void onSeekStop(Thumb thumb) {
        for (OnRangeSeekBarListener onSeekRangeStopped : this.listeners) {
            onSeekRangeStopped.onSeekRangeStopped(this, thumb.getType(), thumb.getValue());
        }
    }
}
