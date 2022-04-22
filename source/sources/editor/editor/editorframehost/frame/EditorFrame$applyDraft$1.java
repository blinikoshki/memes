package editor.editor.editorframehost.frame;

import editor.editor.equipment.core.CoreEntity;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
final class EditorFrame$applyDraft$1 implements Runnable {
    final /* synthetic */ int $frameHeight;
    final /* synthetic */ int $frameWidth;
    final /* synthetic */ EditorFrame this$0;

    EditorFrame$applyDraft$1(EditorFrame editorFrame, int i, int i2) {
        this.this$0 = editorFrame;
        this.$frameWidth = i;
        this.$frameHeight = i2;
    }

    public final void run() {
        Collection<CoreEntity> values = this.this$0.entities.values();
        Intrinsics.checkNotNullExpressionValue(values, "entities.values");
        for (CoreEntity coreEntity : values) {
            EditorFrame editorFrame = this.this$0;
            Intrinsics.checkNotNullExpressionValue(coreEntity, "entity");
            editorFrame.applyMetadata(coreEntity, this.$frameWidth, this.$frameHeight);
        }
    }
}
