package editor.editor.equipment.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.memes.commons.util.Bitmaps;
import editor.editor.equipment.core.CoreLayer;
import editor.editor.equipment.core.CoreStyle;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.property.OnNPropertyAppliedListener;
import editor.optionsui.layerpaint.LayerPaint;
import editor.util.DrawableUtil;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0015\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0015H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0017H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0018H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0019H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001aH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001cH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0016J\u0013\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eJ\u001a\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.J\u001c\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00101\u001a\u000202H&J\u0006\u00103\u001a\u00020\u0012J\u0006\u00104\u001a\u00020\u0012J\u000b\u00105\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u00107\u001a\u00028\u0001¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020\u0012H\u0016J\u0006\u0010<\u001a\u00020(J\u0006\u0010=\u001a\u00020(J\u0006\u0010>\u001a\u00020(J\u0006\u0010?\u001a\u00020(J\u000e\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020BJ\u000e\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020CJ\u0016\u0010@\u001a\u00020\u00122\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EJ\u0016\u0010@\u001a\u00020\u00122\u0006\u0010D\u001a\u00020.2\u0006\u0010F\u001a\u00020.J\u000e\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020IJ\u000e\u0010J\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001fJ\b\u0010K\u001a\u00020\u0012H\u0015J\u0006\u0010L\u001a\u00020(J\u000e\u0010M\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\u000bJ\u0010\u0010O\u001a\u00020\u00122\b\b\u0002\u0010P\u001a\u00020(R\u0010\u0010\u0006\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006Q"}, mo26107d2 = {"Leditor/editor/equipment/core/CoreEntity;", "LAYER", "Leditor/editor/equipment/core/CoreLayer;", "STYLE", "Leditor/editor/equipment/core/CoreStyle;", "", "layer", "style", "(Leditor/editor/equipment/core/CoreLayer;Leditor/editor/equipment/core/CoreStyle;)V", "Leditor/editor/equipment/core/CoreLayer;", "nPropertyAppliedListener", "Leditor/editor/equipment/property/OnNPropertyAppliedListener;", "Leditor/editor/equipment/core/CoreStyle;", "token", "", "getToken", "()Ljava/lang/String;", "apply", "", "property", "Leditor/editor/equipment/property/NicoProperty$Background;", "Leditor/editor/equipment/property/NicoProperty$Corner;", "Leditor/editor/equipment/property/NicoProperty$Fixture;", "Leditor/editor/equipment/property/NicoProperty$FlipHorizontal;", "Leditor/editor/equipment/property/NicoProperty$FlipVertical;", "Leditor/editor/equipment/property/NicoProperty$Opacity;", "Leditor/editor/equipment/property/NicoProperty$Placement;", "Leditor/editor/equipment/property/NicoProperty$Rotation;", "Leditor/editor/equipment/property/NicoProperty$Scale;", "Leditor/editor/equipment/property/NicoProperty$Translate;", "applyProperty", "Leditor/editor/equipment/property/NicoProperty;", "applyPropertyBundle", "bundle", "Leditor/editor/equipment/property/NicoPropertyBundle;", "applyStyle", "newStyle", "(Leditor/editor/equipment/core/CoreStyle;)V", "changeVisibility", "visible", "", "createEntityToken", "identifier", "createThumbnail", "Landroid/graphics/Bitmap;", "maxWidth", "", "maxHeight", "duplicate", "parent", "Landroid/view/ViewGroup;", "enablePlaceholder", "enableWatermark", "getLayer", "()Leditor/editor/equipment/core/CoreLayer;", "getStyle", "()Leditor/editor/equipment/core/CoreStyle;", "getView", "Landroid/view/View;", "hide", "isFixture", "isPlaceholder", "isVisible", "isWatermark", "moveCenterTo", "point", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "x", "", "y", "moveCenterToCenterOf", "rect", "Landroid/graphics/Rect;", "notifyPropertyApplied", "refreshStyle", "remove", "setOnNPropertyAppliedListener", "listener", "show", "bringToFront", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CoreEntity.kt */
public abstract class CoreEntity<LAYER extends CoreLayer<?>, STYLE extends CoreStyle> {
    private final LAYER layer;
    private OnNPropertyAppliedListener nPropertyAppliedListener;
    private final STYLE style;

    public abstract CoreEntity<LAYER, STYLE> duplicate(ViewGroup viewGroup);

    public abstract String getToken();

    public CoreEntity(LAYER layer2, STYLE style2) {
        Intrinsics.checkNotNullParameter(layer2, "layer");
        Intrinsics.checkNotNullParameter(style2, "style");
        this.layer = layer2;
        this.style = style2;
    }

    public final LAYER getLayer() {
        return this.layer;
    }

    public final STYLE getStyle() {
        return this.style;
    }

    public final View getView() {
        return this.layer.underlyingView();
    }

    public final boolean remove() {
        return this.layer.remove();
    }

    public final void applyStyle(STYLE style2) {
        Intrinsics.checkNotNullParameter(style2, "newStyle");
        style2.copy(this.style);
        refreshStyle();
    }

    /* access modifiers changed from: protected */
    public void refreshStyle() {
        applyPropertyBundle(NicoPropertyBundle.Companion.from(getToken(), new NicoProperty.Background(this.style.getBackground()), new NicoProperty.Opacity(this.style.getOpacity()), new NicoProperty.Placement(this.style.getPlacement()), new NicoProperty.Rotation(this.style.getRotation()), new NicoProperty.Scale(this.style.getScale()), new NicoProperty.FlipHorizontal(this.style.getFlippedHorizontal()), new NicoProperty.FlipVertical(this.style.getFlippedVertical()), new NicoProperty.Corner(this.style.getCornerType())));
    }

    public final void notifyPropertyApplied(NicoProperty nicoProperty) {
        Intrinsics.checkNotNullParameter(nicoProperty, "property");
        OnNPropertyAppliedListener onNPropertyAppliedListener = this.nPropertyAppliedListener;
        if (onNPropertyAppliedListener != null) {
            onNPropertyAppliedListener.onNPropertyApplied(this, nicoProperty);
        }
    }

    public final void setOnNPropertyAppliedListener(OnNPropertyAppliedListener onNPropertyAppliedListener) {
        Intrinsics.checkNotNullParameter(onNPropertyAppliedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.nPropertyAppliedListener = onNPropertyAppliedListener;
    }

    public final boolean isFixture() {
        return this.style.getFixture();
    }

    public void applyPropertyBundle(NicoPropertyBundle nicoPropertyBundle) {
        Intrinsics.checkNotNullParameter(nicoPropertyBundle, "bundle");
        for (NicoProperty applyProperty : nicoPropertyBundle.getProperties()) {
            applyProperty(applyProperty);
        }
    }

    public final void applyProperty(NicoProperty nicoProperty) {
        Intrinsics.checkNotNullParameter(nicoProperty, "property");
        if (nicoProperty instanceof NicoProperty.Background) {
            apply((NicoProperty.Background) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.Opacity) {
            apply((NicoProperty.Opacity) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.Translate) {
            apply((NicoProperty.Translate) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.Placement) {
            apply((NicoProperty.Placement) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.Rotation) {
            apply((NicoProperty.Rotation) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.Scale) {
            apply((NicoProperty.Scale) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.FlipHorizontal) {
            apply((NicoProperty.FlipHorizontal) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.FlipVertical) {
            apply((NicoProperty.FlipVertical) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.Corner) {
            apply((NicoProperty.Corner) nicoProperty);
        } else if (nicoProperty instanceof NicoProperty.Fixture) {
            apply((NicoProperty.Fixture) nicoProperty);
        }
        notifyPropertyApplied(nicoProperty);
    }

    private final void apply(NicoProperty.Background background) {
        LayerPaint value = background.getValue();
        this.style.setBackground(value);
        if (value instanceof LayerPaint.Color) {
            getLayer().setBackground((Drawable) null);
            getLayer().setBackgroundColor(((LayerPaint.Color) value).colorInt());
        } else if (value instanceof LayerPaint.Gradient) {
            Drawable createDrawable = DrawableUtil.INSTANCE.createDrawable((LayerPaint.Gradient) value);
            getLayer().setBackgroundColor(0);
            getLayer().setBackground(createDrawable);
        } else if (value instanceof LayerPaint.Pattern) {
            getLayer().setBackgroundColor(0);
            DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
            Context context = getView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getView().context");
            getLayer().setBackground(drawableUtil.createTileDrawable(context, (LayerPaint.Pattern) value));
        }
    }

    private final void apply(NicoProperty.Opacity opacity) {
        this.style.setOpacity(opacity.getValue());
        getLayer().setOpacity(opacity.getValue());
    }

    private final void apply(NicoProperty.Translate translate) {
        getLayer().translateBy(translate.getValueX(), translate.getValueY());
    }

    private final void apply(NicoProperty.Placement placement) {
        if (!placement.getValue().isEmpty()) {
            this.style.setPlacement(placement.getValue());
        }
    }

    private final void apply(NicoProperty.Rotation rotation) {
        this.style.setRotation(rotation.getValue());
        getLayer().setRotation(rotation.getValue());
    }

    private final void apply(NicoProperty.Scale scale) {
        this.style.setScale(scale.getValue());
        getLayer().setScale(scale.getValue());
    }

    private final void apply(NicoProperty.FlipHorizontal flipHorizontal) {
        this.style.setFlippedHorizontal(flipHorizontal.getValue());
        getLayer().setFlippedHorizontally(flipHorizontal.getValue());
    }

    private final void apply(NicoProperty.FlipVertical flipVertical) {
        this.style.setFlippedVertical(flipVertical.getValue());
        getLayer().setFlippedVertically(flipVertical.getValue());
    }

    private final void apply(NicoProperty.Corner corner) {
        this.style.setCornerType(corner.getValue());
        getLayer().setCornerType(corner.getValue());
    }

    private final void apply(NicoProperty.Fixture fixture) {
        this.style.setFixture(fixture.getValue());
        if (!this.style.getFixture()) {
            getView().setOnTouchListener((View.OnTouchListener) null);
        }
    }

    public static /* synthetic */ Bitmap createThumbnail$default(CoreEntity coreEntity, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 512;
            }
            if ((i3 & 2) != 0) {
                i2 = 512;
            }
            return coreEntity.createThumbnail(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createThumbnail");
    }

    public final Bitmap createThumbnail(int i, int i2) {
        float f;
        float f2;
        float f3;
        int width = this.layer.getWidth();
        int height = this.layer.getHeight();
        if (width > i) {
            f2 = (float) i;
            f3 = (float) width;
        } else if (height > i2) {
            f2 = (float) i2;
            f3 = (float) height;
        } else {
            f = 1.0f;
            return Bitmaps.createBitmapFromView$default(Bitmaps.INSTANCE, this.layer.underlyingView(), width, height, f, 0.0f, 16, (Object) null);
        }
        f = f2 / f3;
        return Bitmaps.createBitmapFromView$default(Bitmaps.INSTANCE, this.layer.underlyingView(), width, height, f, 0.0f, 16, (Object) null);
    }

    public final void moveCenterTo(float f, float f2) {
        this.layer.resetPivot();
        this.style.resetScale();
        CoreLayer.animateTo$default(this.layer, f - this.layer.halfWidth(), f2 - this.layer.halfHeight(), this.style.getScale(), 0.0f, 8, (Object) null);
    }

    public final void moveCenterTo(int i, int i2) {
        moveCenterTo((float) i, (float) i2);
    }

    public final void moveCenterTo(Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        moveCenterTo(point.x, point.y);
    }

    public final void moveCenterTo(PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "point");
        moveCenterTo(pointF.x, pointF.y);
    }

    public final void moveCenterToCenterOf(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        moveCenterTo(rect.exactCenterX(), rect.exactCenterY());
    }

    public final boolean isVisible() {
        return getLayer().isVisible();
    }

    public final void changeVisibility(boolean z) {
        if (z) {
            show$default(this, false, 1, (Object) null);
        } else {
            hide();
        }
    }

    public static /* synthetic */ void show$default(CoreEntity coreEntity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            coreEntity.show(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public final void show(boolean z) {
        if (z) {
            getLayer().bringToFront();
        }
        getLayer().show();
    }

    public void hide() {
        getLayer().hide();
    }

    public final boolean isPlaceholder() {
        return this.style.isPlaceholder();
    }

    public final void enablePlaceholder() {
        this.style.setPlaceholder(true);
    }

    public final boolean isWatermark() {
        return this.style.isWatermark();
    }

    public final void enableWatermark() {
        this.style.setWatermark(true);
    }

    public final String createEntityToken(String str) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        return CoreConfig.ENTITY_TOKEN_PREFIX + str + '-' + UUID.randomUUID().toString();
    }
}
