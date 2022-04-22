package editor.editor.equipment.core;

import android.graphics.Rect;
import com.google.gson.annotations.JsonAdapter;
import editor.common.corners.NicoCornerType;
import editor.editor.equipment.core.metadata.LayerMetadata;
import editor.editor.equipment.text.TextConfig;
import editor.optionsui.layerpaint.LayerPaint;
import editor.optionsui.layerpaint.LayerPaintJsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0000H\u0016J\b\u00108\u001a\u000206H\u0016J\u0006\u00109\u001a\u000206J\b\u0010:\u001a\u00020;H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(R\u001a\u00102\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(¨\u0006<"}, mo26107d2 = {"Leditor/editor/equipment/core/CoreStyle;", "", "()V", "background", "Leditor/optionsui/layerpaint/LayerPaint;", "getBackground", "()Leditor/optionsui/layerpaint/LayerPaint;", "setBackground", "(Leditor/optionsui/layerpaint/LayerPaint;)V", "cornerType", "Leditor/common/corners/NicoCornerType;", "getCornerType", "()Leditor/common/corners/NicoCornerType;", "setCornerType", "(Leditor/common/corners/NicoCornerType;)V", "fixture", "", "getFixture", "()Z", "setFixture", "(Z)V", "flippedHorizontal", "getFlippedHorizontal", "setFlippedHorizontal", "flippedVertical", "getFlippedVertical", "setFlippedVertical", "isPlaceholder", "setPlaceholder", "isWatermark", "setWatermark", "metadata", "Leditor/editor/equipment/core/metadata/LayerMetadata;", "getMetadata", "()Leditor/editor/equipment/core/metadata/LayerMetadata;", "opacity", "", "getOpacity", "()F", "setOpacity", "(F)V", "placement", "Landroid/graphics/Rect;", "getPlacement", "()Landroid/graphics/Rect;", "setPlacement", "(Landroid/graphics/Rect;)V", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "copy", "", "into", "reset", "resetScale", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CoreStyle.kt */
public class CoreStyle {
    @JsonAdapter(LayerPaintJsonAdapter.class)
    private LayerPaint background = new LayerPaint.Color(TextConfig.DEFAULT_BACKGROUND_COLOR);
    private NicoCornerType cornerType = NicoCornerType.SQUARE;
    private boolean fixture = true;
    private boolean flippedHorizontal;
    private boolean flippedVertical;
    private boolean isPlaceholder;
    private boolean isWatermark;
    private final LayerMetadata metadata = new LayerMetadata();
    private float opacity = CoreConfig.INSTANCE.getOpacityRange().getDefault();
    private Rect placement = new Rect();
    private float rotation = CoreConfig.INSTANCE.getRotationRange().getDefault();
    private float scale = CoreConfig.INSTANCE.getScaleRange().getDefault();

    public final LayerMetadata getMetadata() {
        return this.metadata;
    }

    public final LayerPaint getBackground() {
        return this.background;
    }

    public final void setBackground(LayerPaint layerPaint) {
        Intrinsics.checkNotNullParameter(layerPaint, "<set-?>");
        this.background = layerPaint;
    }

    public final float getOpacity() {
        return this.opacity;
    }

    public final void setOpacity(float f) {
        this.opacity = f;
    }

    public final Rect getPlacement() {
        return this.placement;
    }

    public final void setPlacement(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<set-?>");
        this.placement = rect;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final void setRotation(float f) {
        this.rotation = f;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    public final boolean getFlippedHorizontal() {
        return this.flippedHorizontal;
    }

    public final void setFlippedHorizontal(boolean z) {
        this.flippedHorizontal = z;
    }

    public final boolean getFlippedVertical() {
        return this.flippedVertical;
    }

    public final void setFlippedVertical(boolean z) {
        this.flippedVertical = z;
    }

    public final NicoCornerType getCornerType() {
        return this.cornerType;
    }

    public final void setCornerType(NicoCornerType nicoCornerType) {
        Intrinsics.checkNotNullParameter(nicoCornerType, "<set-?>");
        this.cornerType = nicoCornerType;
    }

    public final boolean getFixture() {
        return this.fixture;
    }

    public final void setFixture(boolean z) {
        this.fixture = z;
    }

    public final boolean isWatermark() {
        return this.isWatermark;
    }

    public final void setWatermark(boolean z) {
        this.isWatermark = z;
    }

    public final boolean isPlaceholder() {
        return this.isPlaceholder;
    }

    public final void setPlaceholder(boolean z) {
        this.isPlaceholder = z;
    }

    public final void resetScale() {
        this.scale = CoreConfig.INSTANCE.getScaleRange().getDefault();
    }

    public void copy(CoreStyle coreStyle) {
        Intrinsics.checkNotNullParameter(coreStyle, "into");
        coreStyle.background = this.background;
        coreStyle.opacity = this.opacity;
        coreStyle.placement = this.placement;
        coreStyle.rotation = this.rotation;
        coreStyle.scale = this.scale;
        coreStyle.flippedHorizontal = this.flippedHorizontal;
        coreStyle.flippedVertical = this.flippedVertical;
        coreStyle.cornerType = this.cornerType;
        coreStyle.fixture = this.fixture;
        coreStyle.isWatermark = this.isWatermark;
        coreStyle.isPlaceholder = this.isPlaceholder;
    }

    public void reset() {
        new CoreStyle().copy(this);
    }

    public String toString() {
        return "CoreStyle(" + "background='" + this.background + "', " + "opacity=" + this.opacity + ", " + "placement=" + this.placement + ", " + "rotation=" + this.rotation + ", " + "scale=" + this.scale + ", " + "flippedHorizontal=" + this.flippedHorizontal + ", " + "flippedVertical=" + this.flippedVertical + ", " + "cornerType=" + this.cornerType + ',' + "fixture=" + this.fixture + ',' + "isWatermark=" + this.isWatermark + ',' + "isPlaceholder=" + this.isPlaceholder + ")";
    }
}
