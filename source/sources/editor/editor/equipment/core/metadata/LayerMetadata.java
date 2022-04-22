package editor.editor.equipment.core.metadata;

import android.graphics.Rect;
import editor.editor.equipment.core.CoreLayer;
import editor.util.ExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\"\u0010\u0017\u001a\u00020\u00162\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0000J&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Leditor/editor/equipment/core/metadata/LayerMetadata;", "", "()V", "relativeCenterHitX", "", "relativeCenterHitY", "relativeHeight", "relativeWidth", "getAbsoluteCenterHitX", "totalWidth", "", "getAbsoluteCenterHitY", "totalHeight", "getAbsoluteHeight", "getAbsoluteHeightInt", "getAbsoluteWidth", "getAbsoluteWidthInt", "getAbsoluteX", "getAbsoluteY", "isEmpty", "", "setEmpty", "", "update", "layer", "Leditor/editor/equipment/core/CoreLayer;", "metadata", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: LayerMetadata.kt */
public final class LayerMetadata {
    private float relativeCenterHitX;
    private float relativeCenterHitY;
    private float relativeHeight;
    private float relativeWidth;

    public final boolean isEmpty() {
        return this.relativeWidth == 0.0f || this.relativeHeight == 0.0f || this.relativeCenterHitX == 0.0f || this.relativeCenterHitY == 0.0f;
    }

    public final void setEmpty() {
        this.relativeWidth = 0.0f;
        this.relativeHeight = 0.0f;
        this.relativeCenterHitX = 0.0f;
        this.relativeCenterHitY = 0.0f;
    }

    public final float getAbsoluteX(int i) {
        return ((float) i) * ((this.relativeCenterHitX - (this.relativeWidth / 2.0f)) / 100.0f);
    }

    public final float getAbsoluteY(int i) {
        return ((float) i) * ((this.relativeCenterHitY - (this.relativeHeight / 2.0f)) / 100.0f);
    }

    public final float getAbsoluteWidth(int i) {
        return ((float) i) * (this.relativeWidth / 100.0f);
    }

    public final int getAbsoluteWidthInt(int i) {
        return MathKt.roundToInt(getAbsoluteWidth(i));
    }

    public final float getAbsoluteHeight(int i) {
        return ((float) i) * (this.relativeHeight / 100.0f);
    }

    public final int getAbsoluteHeightInt(int i) {
        return MathKt.roundToInt(getAbsoluteHeight(i));
    }

    public final float getAbsoluteCenterHitX(int i) {
        return ((float) i) * (this.relativeCenterHitX / 100.0f);
    }

    public final float getAbsoluteCenterHitY(int i) {
        return ((float) i) * (this.relativeCenterHitY / 100.0f);
    }

    public final void update(CoreLayer<?> coreLayer, int i, int i2) {
        Intrinsics.checkNotNullParameter(coreLayer, "layer");
        Rect drawingRect = coreLayer.getDrawingRect();
        this.relativeWidth = ExtKt.percentage((Number) Integer.valueOf(drawingRect.width()), (Number) Integer.valueOf(i));
        this.relativeHeight = ExtKt.percentage((Number) Integer.valueOf(drawingRect.height()), (Number) Integer.valueOf(i2));
        Rect hitRect = coreLayer.getHitRect();
        this.relativeCenterHitX = ExtKt.percentage((Number) Float.valueOf(hitRect.exactCenterX()), (Number) Integer.valueOf(i));
        this.relativeCenterHitY = ExtKt.percentage((Number) Float.valueOf(hitRect.exactCenterY()), (Number) Integer.valueOf(i2));
    }

    public final void update(LayerMetadata layerMetadata) {
        Intrinsics.checkNotNullParameter(layerMetadata, TtmlNode.TAG_METADATA);
        this.relativeWidth = layerMetadata.relativeWidth;
        this.relativeHeight = layerMetadata.relativeHeight;
        this.relativeCenterHitX = layerMetadata.relativeCenterHitX;
        this.relativeCenterHitY = layerMetadata.relativeCenterHitY;
    }

    public final void update(float f, float f2, float f3, float f4) {
        this.relativeWidth = f;
        this.relativeHeight = f2;
        this.relativeCenterHitX = f3;
        this.relativeCenterHitY = f4;
    }
}
