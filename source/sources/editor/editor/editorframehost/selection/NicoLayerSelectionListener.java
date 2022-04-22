package editor.editor.editorframehost.selection;

import editor.editor.equipment.core.CoreEntity;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J \u0010\n\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H&¨\u0006\u000b"}, mo26107d2 = {"Leditor/editor/editorframehost/selection/NicoLayerSelectionListener;", "", "onEntityResized", "", "entity", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "displacementX", "", "displacementY", "onSaveAsWatermarkTapped", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoLayerSelectionListener.kt */
public interface NicoLayerSelectionListener {
    void onEntityResized(CoreEntity<?, ?> coreEntity, float f, float f2);

    void onSaveAsWatermarkTapped(CoreEntity<?, ?> coreEntity);
}
