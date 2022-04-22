package editor.editor.editorframehost.frame;

import android.view.View;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.frame.FrameLayer;
import editor.editor.equipment.property.NicoProperty;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
final class EditorFrame$moveEntityToCenter$1 implements Runnable {
    final /* synthetic */ CoreEntity $entity;
    final /* synthetic */ View $entityView;
    final /* synthetic */ EditorFrame this$0;

    EditorFrame$moveEntityToCenter$1(EditorFrame editorFrame, View view, CoreEntity coreEntity) {
        this.this$0 = editorFrame;
        this.$entityView = view;
        this.$entity = coreEntity;
    }

    public final void run() {
        this.$entity.applyProperty(new NicoProperty.Translate(((float) (((FrameLayer) this.this$0.getFrameEntity().getLayer()).getWidth() - this.$entityView.getWidth())) / 2.0f, ((float) (((FrameLayer) this.this$0.getFrameEntity().getLayer()).getHeight() - this.$entityView.getHeight())) / 2.0f));
    }
}
