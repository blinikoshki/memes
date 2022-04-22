package editor.editor.equipment.property;

import android.graphics.Rect;
import editor.common.corners.NicoCornerType;
import editor.optionsui.layerpaint.LayerPaint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\n\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\r\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Background", "Corner", "Fixture", "FlipHorizontal", "FlipVertical", "Opacity", "Placement", "Rotation", "Scale", "Translate", "Leditor/editor/equipment/property/TextProperty;", "Leditor/editor/equipment/property/MediaProperty;", "Leditor/editor/equipment/property/FrameProperty;", "Leditor/editor/equipment/property/NicoProperty$Background;", "Leditor/editor/equipment/property/NicoProperty$Opacity;", "Leditor/editor/equipment/property/NicoProperty$Translate;", "Leditor/editor/equipment/property/NicoProperty$Placement;", "Leditor/editor/equipment/property/NicoProperty$Rotation;", "Leditor/editor/equipment/property/NicoProperty$Scale;", "Leditor/editor/equipment/property/NicoProperty$FlipHorizontal;", "Leditor/editor/equipment/property/NicoProperty$FlipVertical;", "Leditor/editor/equipment/property/NicoProperty$Corner;", "Leditor/editor/equipment/property/NicoProperty$Fixture;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoProperty.kt */
public abstract class NicoProperty {
    private final String name;

    private NicoProperty(String str) {
        this.name = str;
    }

    public /* synthetic */ NicoProperty(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getName() {
        return this.name;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$Background;", "Leditor/editor/equipment/property/NicoProperty;", "value", "Leditor/optionsui/layerpaint/LayerPaint;", "(Leditor/optionsui/layerpaint/LayerPaint;)V", "getValue", "()Leditor/optionsui/layerpaint/LayerPaint;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Background extends NicoProperty {
        private final LayerPaint value;

        public static /* synthetic */ Background copy$default(Background background, LayerPaint layerPaint, int i, Object obj) {
            if ((i & 1) != 0) {
                layerPaint = background.value;
            }
            return background.copy(layerPaint);
        }

        public final LayerPaint component1() {
            return this.value;
        }

        public final Background copy(LayerPaint layerPaint) {
            Intrinsics.checkNotNullParameter(layerPaint, "value");
            return new Background(layerPaint);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Background) && Intrinsics.areEqual((Object) this.value, (Object) ((Background) obj).value);
            }
            return true;
        }

        public int hashCode() {
            LayerPaint layerPaint = this.value;
            if (layerPaint != null) {
                return layerPaint.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Background(value=" + this.value + ")";
        }

        public final LayerPaint getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Background(LayerPaint layerPaint) {
            super("background", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(layerPaint, "value");
            this.value = layerPaint;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$Opacity;", "Leditor/editor/equipment/property/NicoProperty;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Opacity extends NicoProperty {
        private final float value;

        public static /* synthetic */ Opacity copy$default(Opacity opacity, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = opacity.value;
            }
            return opacity.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final Opacity copy(float f) {
            return new Opacity(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Opacity) && Float.compare(this.value, ((Opacity) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "Opacity(value=" + this.value + ")";
        }

        public final float getValue() {
            return this.value;
        }

        public Opacity(float f) {
            super("opacity", (DefaultConstructorMarker) null);
            this.value = f;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$Translate;", "Leditor/editor/equipment/property/NicoProperty;", "valueX", "", "valueY", "(FF)V", "getValueX", "()F", "getValueY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Translate extends NicoProperty {
        private final float valueX;
        private final float valueY;

        public static /* synthetic */ Translate copy$default(Translate translate, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = translate.valueX;
            }
            if ((i & 2) != 0) {
                f2 = translate.valueY;
            }
            return translate.copy(f, f2);
        }

        public final float component1() {
            return this.valueX;
        }

        public final float component2() {
            return this.valueY;
        }

        public final Translate copy(float f, float f2) {
            return new Translate(f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Translate)) {
                return false;
            }
            Translate translate = (Translate) obj;
            return Float.compare(this.valueX, translate.valueX) == 0 && Float.compare(this.valueY, translate.valueY) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.valueX) * 31) + Float.floatToIntBits(this.valueY);
        }

        public String toString() {
            return "Translate(valueX=" + this.valueX + ", valueY=" + this.valueY + ")";
        }

        public final float getValueX() {
            return this.valueX;
        }

        public final float getValueY() {
            return this.valueY;
        }

        public Translate(float f, float f2) {
            super("translate", (DefaultConstructorMarker) null);
            this.valueX = f;
            this.valueY = f2;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$Placement;", "Leditor/editor/equipment/property/NicoProperty;", "value", "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;)V", "getValue", "()Landroid/graphics/Rect;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Placement extends NicoProperty {
        private final Rect value;

        public static /* synthetic */ Placement copy$default(Placement placement, Rect rect, int i, Object obj) {
            if ((i & 1) != 0) {
                rect = placement.value;
            }
            return placement.copy(rect);
        }

        public final Rect component1() {
            return this.value;
        }

        public final Placement copy(Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "value");
            return new Placement(rect);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Placement) && Intrinsics.areEqual((Object) this.value, (Object) ((Placement) obj).value);
            }
            return true;
        }

        public int hashCode() {
            Rect rect = this.value;
            if (rect != null) {
                return rect.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Placement(value=" + this.value + ")";
        }

        public final Rect getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Placement(Rect rect) {
            super("placement", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(rect, "value");
            this.value = rect;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$Rotation;", "Leditor/editor/equipment/property/NicoProperty;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Rotation extends NicoProperty {
        private final float value;

        public static /* synthetic */ Rotation copy$default(Rotation rotation, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = rotation.value;
            }
            return rotation.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final Rotation copy(float f) {
            return new Rotation(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Rotation) && Float.compare(this.value, ((Rotation) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "Rotation(value=" + this.value + ")";
        }

        public final float getValue() {
            return this.value;
        }

        public Rotation(float f) {
            super("rotation", (DefaultConstructorMarker) null);
            this.value = f;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$Scale;", "Leditor/editor/equipment/property/NicoProperty;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Scale extends NicoProperty {
        private final float value;

        public static /* synthetic */ Scale copy$default(Scale scale, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = scale.value;
            }
            return scale.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final Scale copy(float f) {
            return new Scale(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Scale) && Float.compare(this.value, ((Scale) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "Scale(value=" + this.value + ")";
        }

        public final float getValue() {
            return this.value;
        }

        public Scale(float f) {
            super("scale", (DefaultConstructorMarker) null);
            this.value = f;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$FlipHorizontal;", "Leditor/editor/equipment/property/NicoProperty;", "value", "", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class FlipHorizontal extends NicoProperty {
        private final boolean value;

        public static /* synthetic */ FlipHorizontal copy$default(FlipHorizontal flipHorizontal, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = flipHorizontal.value;
            }
            return flipHorizontal.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final FlipHorizontal copy(boolean z) {
            return new FlipHorizontal(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof FlipHorizontal) && this.value == ((FlipHorizontal) obj).value;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "FlipHorizontal(value=" + this.value + ")";
        }

        public final boolean getValue() {
            return this.value;
        }

        public FlipHorizontal(boolean z) {
            super("flip-horizontal", (DefaultConstructorMarker) null);
            this.value = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$FlipVertical;", "Leditor/editor/equipment/property/NicoProperty;", "value", "", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class FlipVertical extends NicoProperty {
        private final boolean value;

        public static /* synthetic */ FlipVertical copy$default(FlipVertical flipVertical, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = flipVertical.value;
            }
            return flipVertical.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final FlipVertical copy(boolean z) {
            return new FlipVertical(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof FlipVertical) && this.value == ((FlipVertical) obj).value;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "FlipVertical(value=" + this.value + ")";
        }

        public final boolean getValue() {
            return this.value;
        }

        public FlipVertical(boolean z) {
            super("flip-vertical", (DefaultConstructorMarker) null);
            this.value = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$Corner;", "Leditor/editor/equipment/property/NicoProperty;", "value", "Leditor/common/corners/NicoCornerType;", "(Leditor/common/corners/NicoCornerType;)V", "getValue", "()Leditor/common/corners/NicoCornerType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Corner extends NicoProperty {
        private final NicoCornerType value;

        public static /* synthetic */ Corner copy$default(Corner corner, NicoCornerType nicoCornerType, int i, Object obj) {
            if ((i & 1) != 0) {
                nicoCornerType = corner.value;
            }
            return corner.copy(nicoCornerType);
        }

        public final NicoCornerType component1() {
            return this.value;
        }

        public final Corner copy(NicoCornerType nicoCornerType) {
            Intrinsics.checkNotNullParameter(nicoCornerType, "value");
            return new Corner(nicoCornerType);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Corner) && Intrinsics.areEqual((Object) this.value, (Object) ((Corner) obj).value);
            }
            return true;
        }

        public int hashCode() {
            NicoCornerType nicoCornerType = this.value;
            if (nicoCornerType != null) {
                return nicoCornerType.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Corner(value=" + this.value + ")";
        }

        public final NicoCornerType getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Corner(NicoCornerType nicoCornerType) {
            super("corner", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(nicoCornerType, "value");
            this.value = nicoCornerType;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/editor/equipment/property/NicoProperty$Fixture;", "Leditor/editor/equipment/property/NicoProperty;", "value", "", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class Fixture extends NicoProperty {
        private final boolean value;

        public Fixture() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Fixture copy$default(Fixture fixture, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = fixture.value;
            }
            return fixture.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final Fixture copy(boolean z) {
            return new Fixture(z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Fixture) && this.value == ((Fixture) obj).value;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "Fixture(value=" + this.value + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Fixture(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getValue() {
            return this.value;
        }

        public Fixture(boolean z) {
            super("fixed-ability", (DefaultConstructorMarker) null);
            this.value = z;
        }
    }
}
