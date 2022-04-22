package editor.editor.editorframehost.selection;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.editor.C4175R;
import editor.editor.equipment.core.CoreEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001PB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J \u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u0019H\u0002J\u001a\u00101\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u001b2\b\b\u0002\u00102\u001a\u00020\u000eH\u0002J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0006\u00107\u001a\u00020+J \u00108\u001a\u00020+2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0002J \u0010=\u001a\u00020+2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0010\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@H\u0002J \u0010A\u001a\u00020+2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0006\u0010B\u001a\u00020+J\u0018\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000eH\u0002J(\u0010F\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u001bH\u0002J\u001a\u0010L\u001a\u00020+2\u0012\u0010M\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001fj\u0002` J\u000e\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\"R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001fj\u0004\u0018\u0001` X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b$\u0010\nR\u000e\u0010&\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, mo26107d2 = {"Leditor/editor/editorframehost/selection/NicoLayerSelectionView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cornerHandlePaint", "Landroid/graphics/Paint;", "getCornerHandlePaint", "()Landroid/graphics/Paint;", "cornerHandlePaint$delegate", "Lkotlin/Lazy;", "cornerHandleRadius", "", "cornerPoints", "", "enclosingPoints", "enclosingRect", "Landroid/graphics/Rect;", "lastTouchX", "lastTouchY", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "resizeHandleDrawable", "Landroid/graphics/drawable/Drawable;", "resizeHandlePoint", "Landroid/graphics/PointF;", "saveHandleDrawable", "saveHandlePoint", "selectedEntity", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "selectionListener", "Leditor/editor/editorframehost/selection/NicoLayerSelectionListener;", "selectionPaint", "getSelectionPaint", "selectionPaint$delegate", "sidePoints", "touchRect", "touchState", "Leditor/editor/editorframehost/selection/NicoLayerSelectionView$TouchState;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "point", "drawable", "getHandleRectAroundPoint", "radius", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "redraw", "refreshCornersMap", "matrix", "Landroid/graphics/Matrix;", "width", "height", "refreshEnclosingMap", "refreshMapping", "view", "Landroid/view/View;", "refreshSidesMap", "resetSelectedView", "resizeBy", "displacementX", "displacementY", "rotatePoint", "cx", "cy", "angle", "", "p", "setSelectedEntity", "entity", "setSelectionListener", "listener", "TouchState", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoLayerSelectionView.kt */
public final class NicoLayerSelectionView extends FrameLayout {
    private final Lazy cornerHandlePaint$delegate = LazyKt.lazy(NicoLayerSelectionView$cornerHandlePaint$2.INSTANCE);
    private final float cornerHandleRadius = 30.0f;
    private final float[] cornerPoints = new float[12];
    private final float[] enclosingPoints = new float[16];
    private final Rect enclosingRect = new Rect();
    private float lastTouchX;
    private float lastTouchY;
    private final View.OnLayoutChangeListener layoutChangeListener = new NicoLayerSelectionView$layoutChangeListener$1(this);
    private final Drawable resizeHandleDrawable;
    private final PointF resizeHandlePoint = new PointF();
    private final Drawable saveHandleDrawable;
    private final PointF saveHandlePoint = new PointF();
    private CoreEntity<?, ?> selectedEntity;
    private NicoLayerSelectionListener selectionListener;
    private final Lazy selectionPaint$delegate = LazyKt.lazy(NicoLayerSelectionView$selectionPaint$2.INSTANCE);
    private final float[] sidePoints = new float[8];
    private Rect touchRect = new Rect();
    private TouchState touchState = TouchState.NONE;

    private final Paint getCornerHandlePaint() {
        return (Paint) this.cornerHandlePaint$delegate.getValue();
    }

    private final Paint getSelectionPaint() {
        return (Paint) this.selectionPaint$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NicoLayerSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        setWillNotDraw(false);
        setClipToPadding(false);
        Drawable drawable = getResources().getDrawable(C4175R.C4178drawable.icon_resize, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable, "resources.getDrawable(R.…awable.icon_resize, null)");
        this.resizeHandleDrawable = drawable;
        Drawable drawable2 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_handle_save, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable2, "resources.getDrawable(R.…ection_handle_save, null)");
        this.saveHandleDrawable = drawable2;
        getSelectionPaint().setShadowLayer(2.0f, 0.0f, 0.0f, -16777216);
        setLayerType(1, getSelectionPaint());
        getCornerHandlePaint().setShadowLayer(4.0f, 0.0f, 1.0f, -16777216);
        setLayerType(1, getCornerHandlePaint());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo26107d2 = {"Leditor/editor/editorframehost/selection/NicoLayerSelectionView$TouchState;", "", "(Ljava/lang/String;I)V", "isResizing", "", "isRotating", "NONE", "RESIZING", "ROTATING", "SAVE", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoLayerSelectionView.kt */
    public enum TouchState {
        NONE,
        RESIZING,
        ROTATING,
        SAVE;

        public final boolean isResizing() {
            return this == RESIZING;
        }

        public final boolean isRotating() {
            return this == ROTATING;
        }
    }

    public void draw(Canvas canvas) {
        CoreEntity<?, ?> coreEntity;
        super.draw(canvas);
        if (canvas != null && (coreEntity = this.selectedEntity) != null) {
            refreshMapping(coreEntity.getView());
            getSelectionPaint().setColor(-3355444);
            canvas.drawLines(this.enclosingPoints, getSelectionPaint());
            drawCorner(canvas, this.resizeHandlePoint, this.resizeHandleDrawable);
            if (coreEntity.isWatermark()) {
                drawCorner(canvas, this.saveHandlePoint, this.saveHandleDrawable);
            }
        }
    }

    private final void drawCorner(Canvas canvas, PointF pointF, Drawable drawable) {
        canvas.drawCircle(pointF.x, pointF.y, this.cornerHandleRadius, getCornerHandlePaint());
        drawable.setBounds(MathKt.roundToInt(pointF.x - (this.cornerHandleRadius * 0.7f)), MathKt.roundToInt(pointF.y - (this.cornerHandleRadius * 0.7f)), MathKt.roundToInt(pointF.x + (this.cornerHandleRadius * 0.7f)), MathKt.roundToInt(pointF.y + (this.cornerHandleRadius * 0.7f)));
        drawable.draw(canvas);
    }

    private final void refreshMapping(View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        Matrix matrix = view.getMatrix();
        Intrinsics.checkNotNullExpressionValue(matrix, "view.matrix");
        refreshEnclosingMap(matrix, width, height);
        Matrix matrix2 = view.getMatrix();
        Intrinsics.checkNotNullExpressionValue(matrix2, "view.matrix");
        refreshCornersMap(matrix2, width, height);
        Matrix matrix3 = view.getMatrix();
        Intrinsics.checkNotNullExpressionValue(matrix3, "view.matrix");
        refreshSidesMap(matrix3, width, height);
    }

    private final void refreshEnclosingMap(Matrix matrix, float f, float f2) {
        float[] fArr = this.enclosingPoints;
        fArr[0] = -8.0f;
        fArr[1] = -8.0f;
        float f3 = f + 8.0f;
        fArr[2] = f3;
        fArr[3] = -8.0f;
        fArr[4] = f3;
        fArr[5] = -8.0f;
        fArr[6] = f3;
        float f4 = f2 + 8.0f;
        fArr[7] = f4;
        fArr[8] = f3;
        fArr[9] = f4;
        fArr[10] = -8.0f;
        fArr[11] = f4;
        fArr[12] = -8.0f;
        fArr[13] = f4;
        fArr[14] = -8.0f;
        fArr[15] = -8.0f;
        matrix.mapPoints(fArr);
        float[] fArr2 = this.enclosingPoints;
        float f5 = fArr2[0];
        float f6 = fArr2[1];
        float f7 = fArr2[6];
        float f8 = fArr2[7];
        if (!Float.isNaN(f5) && !Float.isNaN(f6) && !Float.isNaN(f7) && !Float.isNaN(f8)) {
            this.enclosingRect.set(MathKt.roundToInt(this.enclosingPoints[0]), MathKt.roundToInt(this.enclosingPoints[1]), MathKt.roundToInt(this.enclosingPoints[6]), MathKt.roundToInt(this.enclosingPoints[7]));
        }
    }

    private final void refreshCornersMap(Matrix matrix, float f, float f2) {
        float[] fArr = this.cornerPoints;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = f2;
        fArr[6] = f;
        fArr[7] = f2;
        float f3 = f / 2.0f;
        fArr[8] = f3;
        fArr[9] = f2 + ((float) 90);
        fArr[10] = f3;
        fArr[11] = -40.0f;
        matrix.mapPoints(fArr);
        PointF pointF = this.resizeHandlePoint;
        float[] fArr2 = this.cornerPoints;
        pointF.set(fArr2[6], fArr2[7]);
        PointF pointF2 = this.saveHandlePoint;
        float[] fArr3 = this.cornerPoints;
        pointF2.set(fArr3[10], fArr3[11]);
    }

    private final void refreshSidesMap(Matrix matrix, float f, float f2) {
        float[] fArr = this.sidePoints;
        fArr[0] = 0.0f;
        float f3 = f2 / 2.0f;
        fArr[1] = f3;
        float f4 = f / 2.0f;
        fArr[2] = f4;
        fArr[3] = 0.0f;
        fArr[4] = f;
        fArr[5] = f3;
        fArr[6] = f4;
        fArr[7] = f2;
        matrix.mapPoints(fArr);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NicoLayerSelectionListener nicoLayerSelectionListener;
        if (motionEvent == null) {
            return false;
        }
        int roundToInt = MathKt.roundToInt(motionEvent.getX());
        int roundToInt2 = MathKt.roundToInt(motionEvent.getY());
        int action = motionEvent.getAction();
        View view = null;
        if (action == 0) {
            this.lastTouchX = motionEvent.getX();
            this.lastTouchY = motionEvent.getY();
            this.touchRect.set(getHandleRectAroundPoint$default(this, this.saveHandlePoint, 0.0f, 2, (Object) null));
            if (this.touchRect.contains(roundToInt, roundToInt2)) {
                this.touchState = TouchState.SAVE;
            }
            this.touchRect.set(getHandleRectAroundPoint$default(this, this.resizeHandlePoint, 0.0f, 2, (Object) null));
            if (this.touchRect.contains(roundToInt, roundToInt2)) {
                this.touchState = TouchState.RESIZING;
            }
        } else if (action == 1) {
            if (this.touchState == TouchState.SAVE && (nicoLayerSelectionListener = this.selectionListener) != null) {
                nicoLayerSelectionListener.onSaveAsWatermarkTapped(this.selectedEntity);
            }
            this.touchState = TouchState.NONE;
        } else if (action == 2) {
            CoreEntity<?, ?> coreEntity = this.selectedEntity;
            if (coreEntity != null) {
                view = coreEntity.getView();
            }
            PointF rotatePoint = rotatePoint(this.lastTouchX, this.lastTouchY, -(view != null ? Float.valueOf(view.getRotation()) : 0).doubleValue(), new PointF(motionEvent.getX(), motionEvent.getY()));
            float f = rotatePoint.x - this.lastTouchX;
            float f2 = rotatePoint.y - this.lastTouchY;
            if (this.touchState.isResizing()) {
                resizeBy(f, f2);
                redraw();
            }
        }
        this.lastTouchX = motionEvent.getX();
        this.lastTouchY = motionEvent.getY();
        if (this.touchState != TouchState.NONE) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    static /* synthetic */ Rect getHandleRectAroundPoint$default(NicoLayerSelectionView nicoLayerSelectionView, PointF pointF, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = nicoLayerSelectionView.cornerHandleRadius * 2.0f;
        }
        return nicoLayerSelectionView.getHandleRectAroundPoint(pointF, f);
    }

    private final Rect getHandleRectAroundPoint(PointF pointF, float f) {
        return new Rect(MathKt.roundToInt(pointF.x - f), MathKt.roundToInt(pointF.y - f), MathKt.roundToInt(pointF.x + f), MathKt.roundToInt(pointF.y + f));
    }

    private final PointF rotatePoint(float f, float f2, double d, PointF pointF) {
        double sin = Math.sin(Math.toRadians(d));
        double cos = Math.cos(Math.toRadians(d));
        pointF.x -= f;
        pointF.y -= f2;
        pointF.x = (float) (((((double) pointF.x) * cos) - (((double) pointF.y) * sin)) + ((double) f));
        pointF.y = (float) ((((double) pointF.x) * sin) + (((double) pointF.y) * cos) + ((double) f2));
        return pointF;
    }

    public final void setSelectedEntity(CoreEntity<?, ?> coreEntity) {
        Intrinsics.checkNotNullParameter(coreEntity, "entity");
        resetSelectedView();
        coreEntity.getView().addOnLayoutChangeListener(this.layoutChangeListener);
        this.selectedEntity = coreEntity;
        redraw();
    }

    public final void setSelectionListener(NicoLayerSelectionListener nicoLayerSelectionListener) {
        Intrinsics.checkNotNullParameter(nicoLayerSelectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.selectionListener = nicoLayerSelectionListener;
    }

    public final void redraw() {
        bringToFront();
        invalidate();
    }

    public final void resetSelectedView() {
        CoreEntity<?, ?> coreEntity = this.selectedEntity;
        if (coreEntity != null) {
            coreEntity.getView().removeOnLayoutChangeListener(this.layoutChangeListener);
        }
        this.selectedEntity = null;
        invalidate();
    }

    private final void resizeBy(float f, float f2) {
        View view;
        CoreEntity<?, ?> coreEntity = this.selectedEntity;
        if (coreEntity != null && (view = coreEntity.getView()) != null) {
            int roundToInt = MathKt.roundToInt(((float) view.getWidth()) + f);
            int i = 100;
            if (roundToInt < 100) {
                roundToInt = 100;
            }
            int roundToInt2 = MathKt.roundToInt(((float) view.getHeight()) + f2);
            if (roundToInt2 >= 100) {
                i = roundToInt2;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = roundToInt;
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
            NicoLayerSelectionListener nicoLayerSelectionListener = this.selectionListener;
            if (nicoLayerSelectionListener != null) {
                nicoLayerSelectionListener.onEntityResized(this.selectedEntity, f, f2);
            }
        }
    }
}
