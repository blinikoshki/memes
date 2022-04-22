package editor.editor.equipment.property;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\u0001\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/editor/equipment/property/FrameProperty;", "Leditor/editor/equipment/property/NicoProperty;", "identifier", "", "(Ljava/lang/String;)V", "AspectRatio", "Leditor/editor/equipment/property/FrameProperty$AspectRatio;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoProperty.kt */
public abstract class FrameProperty extends NicoProperty {
    private FrameProperty(String str) {
        super(str, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ FrameProperty(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Leditor/editor/equipment/property/FrameProperty$AspectRatio;", "Leditor/editor/equipment/property/FrameProperty;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: NicoProperty.kt */
    public static final class AspectRatio extends FrameProperty {
        private final float value;

        public static /* synthetic */ AspectRatio copy$default(AspectRatio aspectRatio, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = aspectRatio.value;
            }
            return aspectRatio.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final AspectRatio copy(float f) {
            return new AspectRatio(f);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof AspectRatio) && Float.compare(this.value, ((AspectRatio) obj).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.value);
        }

        public String toString() {
            return "AspectRatio(value=" + this.value + ")";
        }

        public final float getValue() {
            return this.value;
        }

        public AspectRatio(float f) {
            super("aspect-ratio", (DefaultConstructorMarker) null);
            this.value = f;
        }
    }
}
