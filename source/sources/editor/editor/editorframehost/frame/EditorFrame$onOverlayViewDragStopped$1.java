package editor.editor.editorframehost.frame;

import android.graphics.Rect;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.core.CoreLayer;
import editor.editor.equipment.property.NicoProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
final class EditorFrame$onOverlayViewDragStopped$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CoreEntity $entity;
    final /* synthetic */ String $identifier;
    final /* synthetic */ CoreLayer $layer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorFrame$onOverlayViewDragStopped$1(CoreLayer coreLayer, String str, CoreEntity coreEntity) {
        super(0);
        this.$layer = coreLayer;
        this.$identifier = str;
        this.$entity = coreEntity;
    }

    public final void invoke() {
        Rect hitRect = this.$layer.getHitRect();
        float rotation = this.$layer.getRotation();
        float scale = this.$layer.getScale();
        this.$entity.applyPropertyBundle(NicoPropertyBundle.Companion.from(this.$identifier, new NicoProperty.Placement(hitRect), new NicoProperty.Rotation(rotation), new NicoProperty.Scale(scale)));
    }
}
