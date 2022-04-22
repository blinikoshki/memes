package editor.editor.editorframehost.frame;

import editor.editor.equipment.core.CoreEntity;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
final class EditorFrame$onSizeChanged$1 implements Runnable {

    /* renamed from: $h */
    final /* synthetic */ int f1426$h;

    /* renamed from: $w */
    final /* synthetic */ int f1427$w;
    final /* synthetic */ EditorFrame this$0;

    EditorFrame$onSizeChanged$1(EditorFrame editorFrame, int i, int i2) {
        this.this$0 = editorFrame;
        this.f1427$w = i;
        this.f1426$h = i2;
    }

    public final void run() {
        Timber.m300d("~> onSizeChanged() newWidth=" + this.f1427$w + "; newHeight=" + this.f1426$h, new Object[0]);
        if (this.f1427$w != this.this$0.lastFrameWidth || this.f1426$h != this.this$0.lastFrameHeight) {
            this.this$0.lastFrameWidth = this.f1427$w;
            this.this$0.lastFrameHeight = this.f1426$h;
            if (this.this$0.f1536wireframe == null && this.this$0.draft == null) {
                Collection<CoreEntity> values = this.this$0.entities.values();
                Intrinsics.checkNotNullExpressionValue(values, "entities.values");
                for (CoreEntity coreEntity : values) {
                    EditorFrame editorFrame = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(coreEntity, "entity");
                    boolean unused = editorFrame.relocateEntityIfOutOfBounds(coreEntity);
                }
            }
            EditorFrame editorFrame2 = this.this$0;
            editorFrame2.applyWireframe(editorFrame2.f1536wireframe);
            EditorFrame editorFrame3 = this.this$0;
            editorFrame3.applyDraft(editorFrame3.draft);
        }
    }
}
