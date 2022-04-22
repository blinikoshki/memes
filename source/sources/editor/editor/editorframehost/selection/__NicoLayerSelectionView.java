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
import editor.editor.editorframehost.gesture.Vector2D;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.text.TextEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001:\u0001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J \u0010A\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\nH\u0002J \u0010D\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\nH\u0002J\b\u0010E\u001a\u0004\u0018\u00010FJ\u0012\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0006\u0010K\u001a\u00020>J \u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u0014H\u0002J \u0010Q\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u0014H\u0002J\u0010\u0010R\u001a\u00020>2\u0006\u0010S\u001a\u00020TH\u0002J \u0010U\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u0014H\u0002J\u0006\u0010V\u001a\u00020>J\u0018\u0010W\u001a\u00020>2\u0006\u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u0014H\u0002J(\u0010Z\u001a\u00020>2\u0006\u0010[\u001a\u00020\u00142\u0006\u0010\\\u001a\u00020\u00142\u0006\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u0014H\u0002J\u001a\u0010_\u001a\u00020>2\u0012\u0010`\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030!j\u0002`\"J\u000e\u0010a\u001a\u00020>2\u0006\u0010b\u001a\u00020$R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010!j\u0004\u0018\u0001`\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b&\u0010\u0010R\u000e\u0010(\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001b\u00108\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b:\u0010\u0012\u001a\u0004\b9\u0010\u0010R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, mo26107d2 = {"Leditor/editor/editorframehost/selection/__NicoLayerSelectionView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bottomLeftCornerPoint", "Landroid/graphics/PointF;", "bottomLeftDrawable", "Landroid/graphics/drawable/Drawable;", "bottomRightCornerPoint", "bottomRightDrawable", "cornerHandlePaint", "Landroid/graphics/Paint;", "getCornerHandlePaint", "()Landroid/graphics/Paint;", "cornerHandlePaint$delegate", "Lkotlin/Lazy;", "cornerHandleRadius", "", "cornerPoints", "", "enclosingPoints", "enclosingRect", "Landroid/graphics/Rect;", "lastTouchX", "lastTouchY", "rotateHandleDrawable", "rotateHandlePoint", "saveHandleDrawable", "saveHandlePoint", "selectedEntity", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "selectionListener", "Leditor/editor/editorframehost/selection/NicoLayerSelectionListener;", "selectionPaint", "getSelectionPaint", "selectionPaint$delegate", "sideBottomDrawable", "sideBottomPoint", "sideHandleHorizontal", "sideHandleVertical", "sideLeftDrawable", "sideLeftPoint", "sidePoints", "sideRightDrawable", "sideRightPoint", "sideTopDrawable", "sideTopPoint", "topLeftCornerPoint", "topLeftDrawable", "topRightCornerPoint", "topRightDrawable", "touchRect", "touchSelectionPaint", "getTouchSelectionPaint", "touchSelectionPaint$delegate", "touchState", "Leditor/editor/editorframehost/selection/__NicoLayerSelectionView$TouchState;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawCorner", "point", "drawable", "drawSide", "getSelectedEntityToken", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "redraw", "refreshCornersMap", "matrix", "Landroid/graphics/Matrix;", "width", "height", "refreshEnclosingMap", "refreshMapping", "view", "Landroid/view/View;", "refreshSidesMap", "resetSelectedView", "resizeBy", "displacementX", "displacementY", "rotateTo", "ax", "ay", "bx", "by", "setSelectedEntity", "entity", "setSelectionListener", "listener", "TouchState", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: __NicoLayerSelectionView.kt */
public final class __NicoLayerSelectionView extends FrameLayout {
    private final PointF bottomLeftCornerPoint = new PointF();
    private final Drawable bottomLeftDrawable;
    private final PointF bottomRightCornerPoint = new PointF();
    private final Drawable bottomRightDrawable;
    private final Lazy cornerHandlePaint$delegate = LazyKt.lazy(__NicoLayerSelectionView$cornerHandlePaint$2.INSTANCE);
    private final float cornerHandleRadius = 30.0f;
    private final float[] cornerPoints = new float[12];
    private final float[] enclosingPoints = new float[16];
    private final Rect enclosingRect = new Rect();
    private float lastTouchX;
    private float lastTouchY;
    private final Drawable rotateHandleDrawable;
    private final PointF rotateHandlePoint = new PointF();
    private final Drawable saveHandleDrawable;
    private final PointF saveHandlePoint = new PointF();
    private CoreEntity<?, ?> selectedEntity;
    private NicoLayerSelectionListener selectionListener;
    private final Lazy selectionPaint$delegate = LazyKt.lazy(__NicoLayerSelectionView$selectionPaint$2.INSTANCE);
    private final Drawable sideBottomDrawable;
    private final PointF sideBottomPoint = new PointF();
    private final float sideHandleHorizontal = 48.0f;
    private final float sideHandleVertical = 20.0f;
    private final Drawable sideLeftDrawable;
    private final PointF sideLeftPoint = new PointF();
    private final float[] sidePoints = new float[8];
    private final Drawable sideRightDrawable;
    private final PointF sideRightPoint = new PointF();
    private final Drawable sideTopDrawable;
    private final PointF sideTopPoint = new PointF();
    private final PointF topLeftCornerPoint = new PointF();
    private final Drawable topLeftDrawable;
    private final PointF topRightCornerPoint = new PointF();
    private final Drawable topRightDrawable;
    private Rect touchRect = new Rect();
    private final Lazy touchSelectionPaint$delegate = LazyKt.lazy(__NicoLayerSelectionView$touchSelectionPaint$2.INSTANCE);
    private TouchState touchState = TouchState.NONE;

    private final Paint getCornerHandlePaint() {
        return (Paint) this.cornerHandlePaint$delegate.getValue();
    }

    private final Paint getSelectionPaint() {
        return (Paint) this.selectionPaint$delegate.getValue();
    }

    private final Paint getTouchSelectionPaint() {
        return (Paint) this.touchSelectionPaint$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public __NicoLayerSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        setWillNotDraw(false);
        setClipToPadding(false);
        Drawable drawable = getResources().getDrawable(C4175R.C4178drawable.icon_selection_corner_top_left, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable, "resources.getDrawable(R.…on_corner_top_left, null)");
        this.topLeftDrawable = drawable;
        Drawable drawable2 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_corner_top_right, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable2, "resources.getDrawable(R.…n_corner_top_right, null)");
        this.topRightDrawable = drawable2;
        Drawable drawable3 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_corner_bottom_left, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable3, "resources.getDrawable(R.…corner_bottom_left, null)");
        this.bottomLeftDrawable = drawable3;
        Drawable drawable4 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_corner_bottom_right, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable4, "resources.getDrawable(R.…orner_bottom_right, null)");
        this.bottomRightDrawable = drawable4;
        Drawable drawable5 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_side_left, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable5, "resources.getDrawable(R.…election_side_left, null)");
        this.sideLeftDrawable = drawable5;
        Drawable drawable6 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_side_top, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable6, "resources.getDrawable(R.…selection_side_top, null)");
        this.sideTopDrawable = drawable6;
        Drawable drawable7 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_side_right, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable7, "resources.getDrawable(R.…lection_side_right, null)");
        this.sideRightDrawable = drawable7;
        Drawable drawable8 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_side_bottom, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable8, "resources.getDrawable(R.…ection_side_bottom, null)");
        this.sideBottomDrawable = drawable8;
        Drawable drawable9 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_handle_save, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable9, "resources.getDrawable(R.…ection_handle_save, null)");
        this.saveHandleDrawable = drawable9;
        Drawable drawable10 = getResources().getDrawable(C4175R.C4178drawable.icon_selection_handle_rotate, (Resources.Theme) null);
        Intrinsics.checkNotNullExpressionValue(drawable10, "resources.getDrawable(R.…tion_handle_rotate, null)");
        this.rotateHandleDrawable = drawable10;
        getCornerHandlePaint().setShadowLayer(4.0f, 0.0f, 1.0f, -16777216);
        setLayerType(1, getCornerHandlePaint());
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo26107d2 = {"Leditor/editor/editorframehost/selection/__NicoLayerSelectionView$TouchState;", "", "(Ljava/lang/String;I)V", "isResizing", "", "isRotating", "NONE", "RESIZING", "ROTATING", "SAVE", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: __NicoLayerSelectionView.kt */
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
            getSelectionPaint().setColor(-16776961);
            canvas.drawLines(this.enclosingPoints, getSelectionPaint());
            if (((coreEntity instanceof TextEntity) && coreEntity.isWatermark()) || ((coreEntity instanceof MediaEntity) && coreEntity.isWatermark())) {
                drawCorner(canvas, this.saveHandlePoint, this.saveHandleDrawable);
            }
        }
    }

    private final void drawCorner(Canvas canvas, PointF pointF, Drawable drawable) {
        canvas.drawCircle(pointF.x, pointF.y, this.cornerHandleRadius, getCornerHandlePaint());
        drawable.setBounds(MathKt.roundToInt(pointF.x - (this.cornerHandleRadius * 0.7f)), MathKt.roundToInt(pointF.y - (this.cornerHandleRadius * 0.7f)), MathKt.roundToInt(pointF.x + (this.cornerHandleRadius * 0.7f)), MathKt.roundToInt(pointF.y + (this.cornerHandleRadius * 0.7f)));
        drawable.draw(canvas);
    }

    private final void drawSide(Canvas canvas, PointF pointF, Drawable drawable) {
        float f = pointF.x - this.sideHandleHorizontal;
        float f2 = pointF.y - this.sideHandleVertical;
        float f3 = pointF.x + this.sideHandleHorizontal;
        float f4 = pointF.y;
        float f5 = this.sideHandleVertical;
        canvas.drawRoundRect(f, f2, f3, f4 + f5, this.sideHandleHorizontal / 4.0f, f5 / 4.0f, getTouchSelectionPaint());
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
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = f;
        fArr[3] = 0.0f;
        fArr[4] = f;
        fArr[5] = 0.0f;
        fArr[6] = f;
        fArr[7] = f2;
        fArr[8] = f;
        fArr[9] = f2;
        fArr[10] = 0.0f;
        fArr[11] = f2;
        fArr[12] = 0.0f;
        fArr[13] = f2;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        matrix.mapPoints(fArr);
        this.enclosingRect.set(MathKt.roundToInt(this.enclosingPoints[0]), MathKt.roundToInt(this.enclosingPoints[1]), MathKt.roundToInt(this.enclosingPoints[6]), MathKt.roundToInt(this.enclosingPoints[7]));
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
        PointF pointF = this.topLeftCornerPoint;
        float[] fArr2 = this.cornerPoints;
        pointF.set(fArr2[0], fArr2[1]);
        PointF pointF2 = this.topRightCornerPoint;
        float[] fArr3 = this.cornerPoints;
        pointF2.set(fArr3[2], fArr3[3]);
        PointF pointF3 = this.bottomLeftCornerPoint;
        float[] fArr4 = this.cornerPoints;
        pointF3.set(fArr4[4], fArr4[5]);
        PointF pointF4 = this.bottomRightCornerPoint;
        float[] fArr5 = this.cornerPoints;
        pointF4.set(fArr5[6], fArr5[7]);
        PointF pointF5 = this.rotateHandlePoint;
        float[] fArr6 = this.cornerPoints;
        pointF5.set(fArr6[8], fArr6[9]);
        PointF pointF6 = this.saveHandlePoint;
        float[] fArr7 = this.cornerPoints;
        pointF6.set(fArr7[10], fArr7[11]);
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
        PointF pointF = this.sideLeftPoint;
        float[] fArr2 = this.sidePoints;
        pointF.set(fArr2[0], fArr2[1]);
        PointF pointF2 = this.sideTopPoint;
        float[] fArr3 = this.sidePoints;
        pointF2.set(fArr3[2], fArr3[3]);
        PointF pointF3 = this.sideRightPoint;
        float[] fArr4 = this.sidePoints;
        pointF3.set(fArr4[4], fArr4[5]);
        PointF pointF4 = this.sideBottomPoint;
        float[] fArr5 = this.sidePoints;
        pointF4.set(fArr5[6], fArr5[7]);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NicoLayerSelectionListener nicoLayerSelectionListener;
        if (motionEvent == null) {
            return false;
        }
        int roundToInt = MathKt.roundToInt(motionEvent.getX());
        int roundToInt2 = MathKt.roundToInt(motionEvent.getY());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastTouchX = motionEvent.getX();
            this.lastTouchY = motionEvent.getY();
            this.touchRect.set(MathKt.roundToInt(this.saveHandlePoint.x - (this.cornerHandleRadius * 1.4f)), MathKt.roundToInt(this.saveHandlePoint.y - (this.cornerHandleRadius * 1.4f)), MathKt.roundToInt(this.saveHandlePoint.x + (this.cornerHandleRadius * 1.4f)), MathKt.roundToInt(this.saveHandlePoint.y + (this.cornerHandleRadius * 1.4f)));
            if (this.touchRect.contains(roundToInt, roundToInt2)) {
                this.touchState = TouchState.SAVE;
            }
        } else if (action == 1) {
            if (this.touchState == TouchState.SAVE && (nicoLayerSelectionListener = this.selectionListener) != null) {
                nicoLayerSelectionListener.onSaveAsWatermarkTapped(this.selectedEntity);
            }
            this.touchState = TouchState.NONE;
        } else if (action == 2) {
            float x = motionEvent.getX() - this.lastTouchX;
            float y = motionEvent.getY() - this.lastTouchY;
            if (this.touchState.isResizing()) {
                resizeBy(x, y);
                redraw();
            } else if (this.touchState.isRotating()) {
                rotateTo(this.lastTouchX, this.lastTouchY, motionEvent.getY(), motionEvent.getY());
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

    public final void setSelectedEntity(CoreEntity<?, ?> coreEntity) {
        Intrinsics.checkNotNullParameter(coreEntity, "entity");
        this.selectedEntity = coreEntity;
        invalidate();
    }

    public final void setSelectionListener(NicoLayerSelectionListener nicoLayerSelectionListener) {
        Intrinsics.checkNotNullParameter(nicoLayerSelectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.selectionListener = nicoLayerSelectionListener;
    }

    public final String getSelectedEntityToken() {
        CoreEntity<?, ?> coreEntity = this.selectedEntity;
        if (coreEntity != null) {
            return coreEntity.getToken();
        }
        return null;
    }

    public final void redraw() {
        bringToFront();
        invalidate();
    }

    public final void resetSelectedView() {
        this.selectedEntity = null;
        invalidate();
    }

    private final void resizeBy(float f, float f2) {
        int roundToInt;
        CoreEntity<?, ?> coreEntity = this.selectedEntity;
        Intrinsics.checkNotNull(coreEntity);
        View view = coreEntity.getView();
        System.out.println("~> view.rotation: " + view.getRotation());
        int roundToInt2 = MathKt.roundToInt(((float) view.getWidth()) + f);
        if (roundToInt2 >= 100 && (roundToInt = MathKt.roundToInt(((float) view.getHeight()) + f2)) >= 100) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = roundToInt2;
            layoutParams.height = roundToInt;
            view.setLayoutParams(layoutParams);
        }
    }

    private final void rotateTo(float f, float f2, float f3, float f4) {
        CoreEntity<?, ?> coreEntity = this.selectedEntity;
        Intrinsics.checkNotNull(coreEntity);
        View view = coreEntity.getView();
        float angle = Vector2D.Companion.getAngle(new Vector2D(f, f2), new Vector2D(f3, f4));
        System.out.println("~> " + angle);
        view.setPivotX(((float) view.getWidth()) / 2.0f);
        view.setPivotY(((float) view.getHeight()) / 2.0f);
        view.setRotation(view.getRotation() + ((float) 4));
    }
}
