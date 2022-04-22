package top.defaults.drawabletoolbox;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.StateSet;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 2}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u0004J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#J&\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020\u0000J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010-\u001a\u00020#J\u0016\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#J\u000e\u00100\u001a\u00020\u00002\u0006\u00100\u001a\u00020\nJ\u0012\u00101\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u000203H\u0007J\u0006\u00104\u001a\u00020\u0000J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020#J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J\u0012\u00108\u001a\u00020\u00002\b\b\u0002\u00109\u001a\u000203H\u0007J%\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010=\u001a\u00020#J\u0016\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\nJ\u000e\u0010@\u001a\u00020\u00002\u0006\u0010>\u001a\u00020#J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010>\u001a\u00020#J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\nJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\nJ\u0006\u0010D\u001a\u00020\u0000J\b\u0010E\u001a\u000203H\u0002J\b\u0010F\u001a\u000203H\u0002J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\nJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\nJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010I\u001a\u00020#J\b\u0010J\u001a\u000203H\u0002J\u0006\u0010K\u001a\u00020\u0000J\u0006\u0010L\u001a\u00020\u0000J\u0006\u0010M\u001a\u00020\u0000J\u0006\u0010N\u001a\u00020\u0000J\b\u0010O\u001a\u000203H\u0002J\b\u0010P\u001a\u000203H\u0002J\b\u0010Q\u001a\u000203H\u0002J\u000e\u0010R\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\nJ\u0006\u0010S\u001a\u00020\u0000J\u0016\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020#J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020#J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010V\u001a\u00020#J\u0006\u0010W\u001a\u00020\u0000J\u0006\u0010X\u001a\u00020\u0000J\u0006\u0010Y\u001a\u00020\u0000J\u0012\u0010Z\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u000203H\u0007J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020\nJ\u000e\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u000206J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\nJ\u0012\u0010`\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u000203H\u0007J\u000e\u0010`\u001a\u00020\u00002\u0006\u0010-\u001a\u00020#J\u0016\u0010`\u001a\u00020\u00002\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#J\u0006\u0010a\u001a\u00020\u0000J\u0012\u0010b\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u000203H\u0007J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010b\u001a\u00020#J\u0016\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020#2\u0006\u0010d\u001a\u00020#J\u000e\u0010e\u001a\u00020\u00002\u0006\u0010f\u001a\u00020\nJ\u000e\u0010d\u001a\u00020\u00002\u0006\u0010b\u001a\u00020#J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020\nJ\u000e\u0010c\u001a\u00020\u00002\u0006\u0010b\u001a\u00020#J\u0010\u0010i\u001a\u00020j2\u0006\u0010\u0018\u001a\u00020kH\u0002J\u000e\u0010l\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\nJ\u0006\u0010m\u001a\u00020\u0000J\b\u0010n\u001a\u000203H\u0002J\u000e\u0010o\u001a\u00020\u00002\u0006\u0010o\u001a\u00020\nJ\u0016\u0010o\u001a\u00020\u00002\u0006\u0010p\u001a\u00020\n2\u0006\u0010G\u001a\u00020\nJ\u000e\u0010q\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\nJ\u0015\u0010\f\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010rJ\u0015\u0010\u000e\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010rJ\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010rJ\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010rJ\u000e\u0010s\u001a\u00020\u00002\u0006\u0010^\u001a\u000206J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\nJ\u000e\u0010t\u001a\u00020\u00002\u0006\u0010t\u001a\u00020\nJ\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010rJ\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010rJ\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010rJ\u000e\u0010u\u001a\u00020\u00002\u0006\u0010^\u001a\u000206J\u000e\u0010v\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\nJ\u0006\u0010w\u001a\u00020\u0000J\u000e\u0010x\u001a\u00020\u00002\u0006\u0010x\u001a\u00020\nJ\u000e\u0010y\u001a\u00020\u00002\u0006\u0010y\u001a\u00020#J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010-\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\nJ\u0012\u0010z\u001a\u00020\u00002\b\b\u0002\u0010z\u001a\u000203H\u0007J\u0006\u0010{\u001a\u00020\u0000J\u000e\u0010{\u001a\u00020\u00002\u0006\u0010|\u001a\u000203J\u0012\u0010}\u001a\u00020\u00002\b\b\u0002\u0010|\u001a\u000203H\u0007J\u000e\u0010p\u001a\u00020\u00002\u0006\u0010p\u001a\u00020\nJ\u0010\u0010~\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0011\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0013\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\rR&\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00160\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo26107d2 = {"Ltop/defaults/drawabletoolbox/DrawableBuilder;", "", "()V", "baseDrawable", "Landroid/graphics/drawable/Drawable;", "order", "Ljava/util/concurrent/atomic/AtomicInteger;", "properties", "Ltop/defaults/drawabletoolbox/DrawableProperties;", "rotateOrder", "", "scaleOrder", "solidColorDisabled", "Ljava/lang/Integer;", "solidColorPressed", "solidColorPressedWhenRippleUnsupported", "solidColorSelected", "strokeColorDisabled", "strokeColorPressed", "strokeColorSelected", "transformsMap", "Ljava/util/TreeMap;", "Lkotlin/Function1;", "angle", "drawable", "batch", "bottomLeftRadius", "bottomRightRadius", "build", "buildDisabledDrawable", "buildNormalDrawable", "buildPressedDrawable", "buildSelectedDrawable", "center", "centerX", "", "centerY", "centerColor", "cornerRadii", "topLeftRadius", "topRightRadius", "cornerRadius", "dashGap", "dashWidth", "dashed", "degrees", "fromDegrees", "toDegrees", "endColor", "flip", "boolean", "", "flipVertical", "getSolidColorStateList", "Landroid/content/res/ColorStateList;", "getStrokeColorStateList", "gradient", "useGradient", "gradientColors", "startColor", "(IILjava/lang/Integer;)Ltop/defaults/drawabletoolbox/DrawableBuilder;", "gradientRadius", "radius", "type", "gradientRadiusInFraction", "gradientRadiusInPixel", "gradientRadiusType", "gradientType", "hairlineBordered", "hasSolidColorStateList", "hasStrokeColorStateList", "height", "innerRadius", "innerRadiusRatio", "isRippleSupported", "line", "linearGradient", "longDashed", "mediumDashed", "needRotateDrawable", "needScaleDrawable", "needStateListDrawable", "orientation", "oval", "pivot", "pivotX", "pivotY", "radialGradient", "rectangle", "ring", "ripple", "rippleColor", "color", "rippleColorStateList", "colorStateList", "rippleRadius", "rotate", "rounded", "scale", "scaleWidth", "scaleHeight", "scaleGravity", "gravity", "scaleLevel", "level", "setupGradientDrawable", "", "Landroid/graphics/drawable/GradientDrawable;", "shape", "shortDashed", "shouldFallbackRipple", "size", "width", "solidColor", "(Ljava/lang/Integer;)Ltop/defaults/drawabletoolbox/DrawableBuilder;", "solidColorStateList", "strokeColor", "strokeColorStateList", "strokeWidth", "sweepGradient", "thickness", "thicknessRatio", "useCenterColor", "useLevelForGradient", "use", "useLevelForRing", "wrap", "wrapRotateIfNeeded", "wrapScaleIfNeeded", "drawabletoolbox_release"}, mo26108k = 1, mo26109mv = {1, 1, 11})
/* compiled from: DrawableBuilder.kt */
public final class DrawableBuilder {
    private Drawable baseDrawable;
    private AtomicInteger order = new AtomicInteger(1);
    private DrawableProperties properties;
    private int rotateOrder;
    private int scaleOrder;
    private Integer solidColorDisabled;
    private Integer solidColorPressed;
    private Integer solidColorPressedWhenRippleUnsupported;
    private Integer solidColorSelected;
    private Integer strokeColorDisabled;
    private Integer strokeColorPressed;
    private Integer strokeColorSelected;
    private TreeMap<Integer, Function1<Drawable, Drawable>> transformsMap = new TreeMap<>();

    public final DrawableBuilder flip() {
        return flip$default(this, false, 1, (Object) null);
    }

    public final DrawableBuilder gradient() {
        return gradient$default(this, false, 1, (Object) null);
    }

    public final DrawableBuilder ripple() {
        return ripple$default(this, false, 1, (Object) null);
    }

    public final DrawableBuilder rotate() {
        return rotate$default(this, false, 1, (Object) null);
    }

    public final DrawableBuilder scale() {
        return scale$default(this, false, 1, (Object) null);
    }

    public final DrawableBuilder useCenterColor() {
        return useCenterColor$default(this, false, 1, (Object) null);
    }

    public final DrawableBuilder useLevelForRing() {
        return useLevelForRing$default(this, false, 1, (Object) null);
    }

    public DrawableBuilder() {
        DrawableProperties drawableProperties = r1;
        DrawableProperties drawableProperties2 = new DrawableProperties(0, 0, 0.0f, 0, 0.0f, false, 0, 0, 0, 0, 0, false, 0, 0, 0.0f, 0.0f, false, 0, (Integer) null, 0, 0, 0.0f, false, 0, 0, 0, (ColorStateList) null, 0, 0, (ColorStateList) null, 0, 0, false, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, false, 0, false, 0, (ColorStateList) null, 0, -1, 65535, (DefaultConstructorMarker) null);
        this.properties = drawableProperties;
    }

    public final DrawableBuilder batch(DrawableProperties drawableProperties) {
        Intrinsics.checkParameterIsNotNull(drawableProperties, "properties");
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties = drawableProperties.copy();
        return drawableBuilder;
    }

    public final DrawableBuilder baseDrawable(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.baseDrawable = drawable;
        return drawableBuilder;
    }

    public final DrawableBuilder shape(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.shape = i;
        return drawableBuilder;
    }

    public final DrawableBuilder rectangle() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.shape(0);
        return drawableBuilder;
    }

    public final DrawableBuilder oval() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.shape(1);
        return drawableBuilder;
    }

    public final DrawableBuilder line() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.shape(2);
        return drawableBuilder;
    }

    public final DrawableBuilder ring() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.shape(3);
        return drawableBuilder;
    }

    public final DrawableBuilder innerRadius(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.innerRadius = i;
        return drawableBuilder;
    }

    public final DrawableBuilder innerRadiusRatio(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.innerRadiusRatio = f;
        return drawableBuilder;
    }

    public final DrawableBuilder thickness(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.thickness = i;
        return drawableBuilder;
    }

    public final DrawableBuilder thicknessRatio(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.thicknessRatio = f;
        return drawableBuilder;
    }

    public static /* bridge */ /* synthetic */ DrawableBuilder useLevelForRing$default(DrawableBuilder drawableBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return drawableBuilder.useLevelForRing(z);
    }

    public final DrawableBuilder useLevelForRing(boolean z) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.useLevelForRing = z;
        return drawableBuilder;
    }

    public final DrawableBuilder cornerRadius(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.setCornerRadius(i);
        return drawableBuilder;
    }

    public final DrawableBuilder topLeftRadius(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.topLeftRadius = i;
        return drawableBuilder;
    }

    public final DrawableBuilder topRightRadius(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.topRightRadius = i;
        return drawableBuilder;
    }

    public final DrawableBuilder bottomRightRadius(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.bottomRightRadius = i;
        return drawableBuilder;
    }

    public final DrawableBuilder bottomLeftRadius(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.bottomLeftRadius = i;
        return drawableBuilder;
    }

    public final DrawableBuilder rounded() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.cornerRadius(Integer.MAX_VALUE);
        return drawableBuilder;
    }

    public final DrawableBuilder cornerRadii(int i, int i2, int i3, int i4) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.topLeftRadius(i);
        drawableBuilder.topRightRadius(i2);
        drawableBuilder.bottomRightRadius(i3);
        drawableBuilder.bottomLeftRadius(i4);
        return drawableBuilder;
    }

    public static /* bridge */ /* synthetic */ DrawableBuilder gradient$default(DrawableBuilder drawableBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return drawableBuilder.gradient(z);
    }

    public final DrawableBuilder gradient(boolean z) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.useGradient = z;
        return drawableBuilder;
    }

    public final DrawableBuilder gradientType(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.type = i;
        return drawableBuilder;
    }

    public final DrawableBuilder linearGradient() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.gradientType(0);
        return drawableBuilder;
    }

    public final DrawableBuilder radialGradient() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.gradientType(1);
        return drawableBuilder;
    }

    public final DrawableBuilder sweepGradient() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.gradientType(2);
        return drawableBuilder;
    }

    public final DrawableBuilder angle(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.angle = i;
        return drawableBuilder;
    }

    public final DrawableBuilder centerX(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.centerX = f;
        return drawableBuilder;
    }

    public final DrawableBuilder centerY(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.centerY = f;
        return drawableBuilder;
    }

    public final DrawableBuilder center(float f, float f2) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.centerX(f);
        drawableBuilder.centerY(f2);
        return drawableBuilder;
    }

    public static /* bridge */ /* synthetic */ DrawableBuilder useCenterColor$default(DrawableBuilder drawableBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return drawableBuilder.useCenterColor(z);
    }

    public final DrawableBuilder useCenterColor(boolean z) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.useCenterColor = z;
        return drawableBuilder;
    }

    public final DrawableBuilder startColor(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.startColor = i;
        return drawableBuilder;
    }

    public final DrawableBuilder centerColor(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.centerColor = Integer.valueOf(i);
        drawableBuilder.useCenterColor(true);
        return drawableBuilder;
    }

    public final DrawableBuilder endColor(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.endColor = i;
        return drawableBuilder;
    }

    public final DrawableBuilder gradientColors(int i, int i2, Integer num) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.startColor(i);
        drawableBuilder.endColor(i2);
        drawableBuilder.useCenterColor(num != null);
        if (num != null) {
            drawableBuilder.centerColor(num.intValue());
        }
        return drawableBuilder;
    }

    public final DrawableBuilder gradientRadiusType(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.gradientRadiusType = i;
        return drawableBuilder;
    }

    public final DrawableBuilder gradientRadius(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.gradientRadius = f;
        return drawableBuilder;
    }

    public final DrawableBuilder gradientRadius(float f, int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.gradientRadius(f);
        drawableBuilder.gradientRadiusType(i);
        return drawableBuilder;
    }

    public final DrawableBuilder gradientRadiusInPixel(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.gradientRadius(f);
        drawableBuilder.gradientRadiusType(0);
        return drawableBuilder;
    }

    public final DrawableBuilder gradientRadiusInFraction(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.gradientRadius(f);
        drawableBuilder.gradientRadiusType(1);
        return drawableBuilder;
    }

    public final DrawableBuilder useLevelForGradient(boolean z) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.useLevelForGradient = z;
        return drawableBuilder;
    }

    public final DrawableBuilder useLevelForGradient() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.useLevelForGradient(true);
        return drawableBuilder;
    }

    public final DrawableBuilder width(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.width = i;
        return drawableBuilder;
    }

    public final DrawableBuilder height(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.height = i;
        return drawableBuilder;
    }

    public final DrawableBuilder size(int i, int i2) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.width(i);
        drawableBuilder.height(i2);
        return drawableBuilder;
    }

    public final DrawableBuilder size(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.width(i).height(i);
        return drawableBuilder;
    }

    public final DrawableBuilder solidColor(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.solidColor = i;
        return drawableBuilder;
    }

    public final DrawableBuilder solidColorPressed(Integer num) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.solidColorPressed = num;
        return drawableBuilder;
    }

    public final DrawableBuilder solidColorPressedWhenRippleUnsupported(Integer num) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.solidColorPressedWhenRippleUnsupported = num;
        return drawableBuilder;
    }

    public final DrawableBuilder solidColorDisabled(Integer num) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.solidColorDisabled = num;
        return drawableBuilder;
    }

    public final DrawableBuilder solidColorSelected(Integer num) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.solidColorSelected = num;
        return drawableBuilder;
    }

    public final DrawableBuilder solidColorStateList(ColorStateList colorStateList) {
        Intrinsics.checkParameterIsNotNull(colorStateList, "colorStateList");
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.solidColorStateList = colorStateList;
        return drawableBuilder;
    }

    public final DrawableBuilder strokeWidth(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.strokeWidth = i;
        return drawableBuilder;
    }

    public final DrawableBuilder strokeColor(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.strokeColor = i;
        return drawableBuilder;
    }

    public final DrawableBuilder strokeColorPressed(Integer num) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.strokeColorPressed = num;
        return drawableBuilder;
    }

    public final DrawableBuilder strokeColorDisabled(Integer num) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.strokeColorDisabled = num;
        return drawableBuilder;
    }

    public final DrawableBuilder strokeColorSelected(Integer num) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.strokeColorSelected = num;
        return drawableBuilder;
    }

    public final DrawableBuilder strokeColorStateList(ColorStateList colorStateList) {
        Intrinsics.checkParameterIsNotNull(colorStateList, "colorStateList");
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.strokeColorStateList = colorStateList;
        return drawableBuilder;
    }

    public final DrawableBuilder dashWidth(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.dashWidth = i;
        return drawableBuilder;
    }

    public final DrawableBuilder dashGap(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.dashGap = i;
        return drawableBuilder;
    }

    public final DrawableBuilder hairlineBordered() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.strokeWidth(1);
        return drawableBuilder;
    }

    public final DrawableBuilder shortDashed() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.dashWidth(12).dashGap(12);
        return drawableBuilder;
    }

    public final DrawableBuilder mediumDashed() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.dashWidth(24).dashGap(24);
        return drawableBuilder;
    }

    public final DrawableBuilder longDashed() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.dashWidth(36).dashGap(36);
        return drawableBuilder;
    }

    public final DrawableBuilder dashed() {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.mediumDashed();
        return drawableBuilder;
    }

    public static /* bridge */ /* synthetic */ DrawableBuilder rotate$default(DrawableBuilder drawableBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return drawableBuilder.rotate(z);
    }

    public final DrawableBuilder rotate(boolean z) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.useRotate = z;
        drawableBuilder.rotateOrder = z ? drawableBuilder.order.getAndIncrement() : 0;
        return drawableBuilder;
    }

    public final DrawableBuilder pivotX(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.pivotX = f;
        return drawableBuilder;
    }

    public final DrawableBuilder pivotY(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.pivotY = f;
        return drawableBuilder;
    }

    public final DrawableBuilder pivot(float f, float f2) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.pivotX(f).pivotY(f2);
        return drawableBuilder;
    }

    public final DrawableBuilder fromDegrees(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.fromDegrees = f;
        return drawableBuilder;
    }

    public final DrawableBuilder toDegrees(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.toDegrees = f;
        return drawableBuilder;
    }

    public final DrawableBuilder degrees(float f, float f2) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.fromDegrees(f).toDegrees(f2);
        return drawableBuilder;
    }

    public final DrawableBuilder degrees(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.fromDegrees(f).toDegrees(f);
        return drawableBuilder;
    }

    public final DrawableBuilder rotate(float f, float f2) {
        DrawableBuilder drawableBuilder = this;
        rotate$default(drawableBuilder, false, 1, (Object) null).fromDegrees(f).toDegrees(f2);
        return drawableBuilder;
    }

    public final DrawableBuilder rotate(float f) {
        DrawableBuilder drawableBuilder = this;
        rotate$default(drawableBuilder, false, 1, (Object) null).degrees(f);
        return drawableBuilder;
    }

    public static /* bridge */ /* synthetic */ DrawableBuilder scale$default(DrawableBuilder drawableBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return drawableBuilder.scale(z);
    }

    public final DrawableBuilder scale(boolean z) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.useScale = z;
        drawableBuilder.scaleOrder = z ? drawableBuilder.order.getAndIncrement() : 0;
        return drawableBuilder;
    }

    public final DrawableBuilder scaleLevel(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.scaleLevel = i;
        return drawableBuilder;
    }

    public final DrawableBuilder scaleGravity(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.scaleGravity = i;
        return drawableBuilder;
    }

    public final DrawableBuilder scaleWidth(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.scaleWidth = f;
        return drawableBuilder;
    }

    public final DrawableBuilder scaleHeight(float f) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.scaleHeight = f;
        return drawableBuilder;
    }

    public final DrawableBuilder scale(float f) {
        DrawableBuilder drawableBuilder = this;
        scale$default(drawableBuilder, false, 1, (Object) null).scaleWidth(f).scaleHeight(f);
        return drawableBuilder;
    }

    public final DrawableBuilder scale(float f, float f2) {
        DrawableBuilder drawableBuilder = this;
        scale$default(drawableBuilder, false, 1, (Object) null).scaleWidth(f).scaleHeight(f2);
        return drawableBuilder;
    }

    public static /* bridge */ /* synthetic */ DrawableBuilder flip$default(DrawableBuilder drawableBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return drawableBuilder.flip(z);
    }

    public final DrawableBuilder flip(boolean z) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.useFlip = z;
        return drawableBuilder;
    }

    public final DrawableBuilder orientation(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.orientation = i;
        return drawableBuilder;
    }

    public final DrawableBuilder flipVertical() {
        DrawableBuilder drawableBuilder = this;
        flip$default(drawableBuilder, false, 1, (Object) null).orientation(1);
        return drawableBuilder;
    }

    public static /* bridge */ /* synthetic */ DrawableBuilder ripple$default(DrawableBuilder drawableBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return drawableBuilder.ripple(z);
    }

    public final DrawableBuilder ripple(boolean z) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.useRipple = z;
        return drawableBuilder;
    }

    public final DrawableBuilder rippleColor(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.rippleColor = i;
        return drawableBuilder;
    }

    public final DrawableBuilder rippleColorStateList(ColorStateList colorStateList) {
        Intrinsics.checkParameterIsNotNull(colorStateList, "colorStateList");
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.rippleColorStateList = colorStateList;
        return drawableBuilder;
    }

    public final DrawableBuilder rippleRadius(int i) {
        DrawableBuilder drawableBuilder = this;
        drawableBuilder.properties.rippleRadius = i;
        return drawableBuilder;
    }

    public final Drawable build() {
        Drawable drawable;
        Drawable drawable2 = this.baseDrawable;
        if (drawable2 != null) {
            if (drawable2 == null) {
                Intrinsics.throwNpe();
            }
            return wrap(drawable2);
        }
        if (shouldFallbackRipple()) {
            Integer num = this.solidColorPressedWhenRippleUnsupported;
            if (num != null) {
                solidColorPressed(num);
            } else {
                solidColorPressed(Integer.valueOf(this.properties.rippleColor));
            }
        }
        if (needStateListDrawable()) {
            drawable = new StateListDrawableBuilder().pressed(buildPressedDrawable()).disabled(buildDisabledDrawable()).selected(buildSelectedDrawable()).normal(buildNormalDrawable()).build();
        } else {
            drawable = new GradientDrawable();
            setupGradientDrawable((GradientDrawable) drawable);
        }
        return wrap(drawable);
    }

    private final ColorStateList getSolidColorStateList() {
        if (this.properties.solidColorStateList != null) {
            ColorStateList colorStateList = this.properties.solidColorStateList;
            if (colorStateList == null) {
                Intrinsics.throwNpe();
            }
            return colorStateList;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Integer num = this.solidColorPressed;
        if (num != null) {
            int intValue = num.intValue();
            arrayList.add(new int[]{16842919});
            arrayList2.add(Integer.valueOf(intValue));
        }
        Integer num2 = this.solidColorDisabled;
        if (num2 != null) {
            int intValue2 = num2.intValue();
            arrayList.add(new int[]{-16842910});
            arrayList2.add(Integer.valueOf(intValue2));
        }
        Integer num3 = this.solidColorSelected;
        if (num3 != null) {
            int intValue3 = num3.intValue();
            arrayList.add(new int[]{16842913});
            arrayList2.add(Integer.valueOf(intValue3));
        }
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        arrayList.add(iArr);
        arrayList2.add(Integer.valueOf(this.properties.solidColor));
        Object[] array = arrayList.toArray(new int[0][]);
        if (array != null) {
            return new ColorStateList((int[][]) array, CollectionsKt.toIntArray(arrayList2));
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final ColorStateList getStrokeColorStateList() {
        if (this.properties.strokeColorStateList != null) {
            ColorStateList colorStateList = this.properties.strokeColorStateList;
            if (colorStateList == null) {
                Intrinsics.throwNpe();
            }
            return colorStateList;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Integer num = this.strokeColorPressed;
        if (num != null) {
            int intValue = num.intValue();
            arrayList.add(new int[]{16842919});
            arrayList2.add(Integer.valueOf(intValue));
        }
        Integer num2 = this.strokeColorDisabled;
        if (num2 != null) {
            int intValue2 = num2.intValue();
            arrayList.add(new int[]{-16842910});
            arrayList2.add(Integer.valueOf(intValue2));
        }
        Integer num3 = this.strokeColorSelected;
        if (num3 != null) {
            int intValue3 = num3.intValue();
            arrayList.add(new int[]{16842913});
            arrayList2.add(Integer.valueOf(intValue3));
        }
        int[] iArr = StateSet.WILD_CARD;
        Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
        arrayList.add(iArr);
        arrayList2.add(Integer.valueOf(this.properties.strokeColor));
        Object[] array = arrayList.toArray(new int[0][]);
        if (array != null) {
            return new ColorStateList((int[][]) array, CollectionsKt.toIntArray(arrayList2));
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final Drawable buildPressedDrawable() {
        if (this.solidColorPressed == null && this.strokeColorPressed == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        setupGradientDrawable(gradientDrawable);
        Integer num = this.solidColorPressed;
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        Integer num2 = this.strokeColorPressed;
        if (num2 != null) {
            CompatibleKt.setStrokeColor(gradientDrawable, num2.intValue());
        }
        return gradientDrawable;
    }

    private final Drawable buildDisabledDrawable() {
        if (this.solidColorDisabled == null && this.strokeColorDisabled == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        setupGradientDrawable(gradientDrawable);
        Integer num = this.solidColorDisabled;
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        Integer num2 = this.strokeColorDisabled;
        if (num2 != null) {
            CompatibleKt.setStrokeColor(gradientDrawable, num2.intValue());
        }
        return gradientDrawable;
    }

    private final Drawable buildSelectedDrawable() {
        if (this.solidColorSelected == null && this.strokeColorSelected == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        setupGradientDrawable(gradientDrawable);
        Integer num = this.solidColorSelected;
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        Integer num2 = this.strokeColorSelected;
        if (num2 != null) {
            CompatibleKt.setStrokeColor(gradientDrawable, num2.intValue());
        }
        return gradientDrawable;
    }

    private final Drawable buildNormalDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        setupGradientDrawable(gradientDrawable);
        return gradientDrawable;
    }

    private final void setupGradientDrawable(GradientDrawable gradientDrawable) {
        DrawableProperties drawableProperties = this.properties;
        gradientDrawable.setShape(drawableProperties.shape);
        if (drawableProperties.shape == 3) {
            CompatibleKt.setInnerRadius(gradientDrawable, drawableProperties.innerRadius);
            CompatibleKt.setInnerRadiusRatio(gradientDrawable, drawableProperties.innerRadiusRatio);
            CompatibleKt.setThickness(gradientDrawable, drawableProperties.thickness);
            CompatibleKt.setThicknessRatio(gradientDrawable, drawableProperties.thicknessRatio);
            CompatibleKt.setUseLevelForShape(gradientDrawable, drawableProperties.useLevelForRing);
        }
        gradientDrawable.setCornerRadii(drawableProperties.getCornerRadii());
        if (drawableProperties.useGradient) {
            gradientDrawable.setGradientType(drawableProperties.type);
            CompatibleKt.setGradientRadiusType(gradientDrawable, drawableProperties.gradientRadiusType);
            CompatibleKt.setGradientRadius(gradientDrawable, drawableProperties.gradientRadius);
            gradientDrawable.setGradientCenter(drawableProperties.centerX, drawableProperties.centerY);
            CompatibleKt.setOrientation(gradientDrawable, drawableProperties.getOrientation());
            CompatibleKt.setColors(gradientDrawable, drawableProperties.getColors());
            gradientDrawable.setUseLevel(drawableProperties.useLevelForGradient);
        } else if (Build.VERSION.SDK_INT >= 21) {
            gradientDrawable.setColor(getSolidColorStateList());
        } else {
            gradientDrawable.setColor(drawableProperties.solidColor);
        }
        gradientDrawable.setSize(drawableProperties.width, drawableProperties.height);
        if (Build.VERSION.SDK_INT >= 21) {
            gradientDrawable.setStroke(drawableProperties.strokeWidth, getStrokeColorStateList(), (float) drawableProperties.dashWidth, (float) drawableProperties.dashGap);
        } else {
            gradientDrawable.setStroke(drawableProperties.strokeWidth, drawableProperties.strokeColor, (float) drawableProperties.dashWidth, (float) drawableProperties.dashGap);
        }
    }

    private final boolean needStateListDrawable() {
        return Build.VERSION.SDK_INT < 21 && (hasStrokeColorStateList() || (!this.properties.useGradient && hasSolidColorStateList()));
    }

    private final boolean needRotateDrawable() {
        return this.properties.useRotate && !(this.properties.pivotX == 0.5f && this.properties.pivotY == 0.5f && this.properties.fromDegrees == 0.0f && this.properties.toDegrees == 0.0f);
    }

    private final boolean needScaleDrawable() {
        return this.properties.useScale;
    }

    private final Drawable wrap(Drawable drawable) {
        int i = this.rotateOrder;
        if (i > 0) {
            this.transformsMap.put(Integer.valueOf(i), new DrawableBuilder$wrap$1(this));
        }
        int i2 = this.scaleOrder;
        if (i2 > 0) {
            this.transformsMap.put(Integer.valueOf(i2), new DrawableBuilder$wrap$2(this));
        }
        for (Function1<Drawable, Drawable> invoke : this.transformsMap.values()) {
            drawable = (Drawable) invoke.invoke(drawable);
        }
        if (this.properties.useFlip) {
            drawable = ((FlipDrawableBuilder) new FlipDrawableBuilder().drawable(drawable)).orientation(this.properties.orientation).build();
        }
        return (!isRippleSupported() || !this.properties.useRipple) ? drawable : ((RippleDrawableBuilder) new RippleDrawableBuilder().drawable(drawable)).color(this.properties.rippleColor).colorStateList(this.properties.rippleColorStateList).radius(this.properties.rippleRadius).build();
    }

    private final boolean shouldFallbackRipple() {
        return this.properties.useRipple && !isRippleSupported();
    }

    private final boolean isRippleSupported() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: private */
    public final Drawable wrapRotateIfNeeded(Drawable drawable) {
        if (!needRotateDrawable()) {
            return drawable;
        }
        DrawableProperties drawableProperties = this.properties;
        return ((RotateDrawableBuilder) new RotateDrawableBuilder().drawable(drawable)).pivotX(drawableProperties.pivotX).pivotY(drawableProperties.pivotY).fromDegrees(drawableProperties.fromDegrees).toDegrees(drawableProperties.toDegrees).build();
    }

    /* access modifiers changed from: private */
    public final Drawable wrapScaleIfNeeded(Drawable drawable) {
        if (!needScaleDrawable()) {
            return drawable;
        }
        DrawableProperties drawableProperties = this.properties;
        return ((ScaleDrawableBuilder) new ScaleDrawableBuilder().drawable(drawable)).level(drawableProperties.scaleLevel).scaleGravity(drawableProperties.scaleGravity).scaleWidth(drawableProperties.scaleWidth).scaleHeight(drawableProperties.scaleHeight).build();
    }

    private final boolean hasSolidColorStateList() {
        return (this.solidColorPressed == null && this.solidColorDisabled == null && this.solidColorSelected == null) ? false : true;
    }

    private final boolean hasStrokeColorStateList() {
        return (this.strokeColorPressed == null && this.strokeColorDisabled == null && this.strokeColorSelected == null) ? false : true;
    }
}
