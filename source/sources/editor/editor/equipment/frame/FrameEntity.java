package editor.editor.equipment.frame;

import android.view.ViewGroup;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.property.FrameProperty;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\fH\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, mo26107d2 = {"Leditor/editor/equipment/frame/FrameEntity;", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/editor/equipment/frame/FrameLayer;", "Leditor/editor/equipment/frame/FrameStyle;", "layer", "style", "(Leditor/editor/equipment/frame/FrameLayer;Leditor/editor/equipment/frame/FrameStyle;)V", "token", "", "getToken", "()Ljava/lang/String;", "apply", "", "property", "Leditor/editor/equipment/property/FrameProperty$AspectRatio;", "applyProperty", "Leditor/editor/equipment/property/FrameProperty;", "applyPropertyBundle", "bundle", "Leditor/editor/equipment/property/NicoPropertyBundle;", "duplicate", "parent", "Landroid/view/ViewGroup;", "getBackgroundOpacityPercentage", "", "refreshStyle", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameEntity.kt */
public final class FrameEntity extends CoreEntity<FrameLayer, FrameStyle> {
    private final String token;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FrameEntity(FrameLayer frameLayer, FrameStyle frameStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(frameLayer, (i & 2) != 0 ? new FrameStyle() : frameStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameEntity(FrameLayer frameLayer, FrameStyle frameStyle) {
        super(frameLayer, frameStyle);
        Intrinsics.checkNotNullParameter(frameLayer, "layer");
        Intrinsics.checkNotNullParameter(frameStyle, "style");
        this.token = createEntityToken("frame");
        refreshStyle();
    }

    public String getToken() {
        return this.token;
    }

    public FrameEntity duplicate(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        throw new RuntimeException("Duplicating a FrameEntity is not allowed");
    }

    public final int getBackgroundOpacityPercentage() {
        return MathKt.roundToInt(((FrameStyle) getStyle()).getOpacity() * ((float) 100));
    }

    /* access modifiers changed from: protected */
    public void refreshStyle() {
        applyPropertyBundle(NicoPropertyBundle.Companion.from(getToken(), new FrameProperty.AspectRatio(((FrameStyle) getStyle()).getAspectRatio())));
        super.refreshStyle();
    }

    public void applyPropertyBundle(NicoPropertyBundle nicoPropertyBundle) {
        Intrinsics.checkNotNullParameter(nicoPropertyBundle, "bundle");
        for (NicoProperty next : nicoPropertyBundle.getProperties()) {
            if (next instanceof FrameProperty) {
                applyProperty((FrameProperty) next);
            } else {
                applyProperty(next);
            }
        }
    }

    public final void applyProperty(FrameProperty frameProperty) {
        Intrinsics.checkNotNullParameter(frameProperty, "property");
        if (frameProperty instanceof FrameProperty.AspectRatio) {
            apply((FrameProperty.AspectRatio) frameProperty);
        }
        notifyPropertyApplied(frameProperty);
    }

    private final void apply(FrameProperty.AspectRatio aspectRatio) {
        ((FrameStyle) getStyle()).setAspectRatio(aspectRatio.getValue());
        ((FrameLayer) getLayer()).setAspectRatio(aspectRatio.getValue());
    }
}
