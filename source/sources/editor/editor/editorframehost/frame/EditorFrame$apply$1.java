package editor.editor.editorframehost.frame;

import editor.editor.dashboard.drafts.EditorDraft;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.text.TextEntity;
import editor.editor.equipment.text.TextStyle;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
final class EditorFrame$apply$1 implements Runnable {
    final /* synthetic */ EditorDraft $draft;
    final /* synthetic */ EditorFrame this$0;

    EditorFrame$apply$1(EditorFrame editorFrame, EditorDraft editorDraft) {
        this.this$0 = editorFrame;
        this.$draft = editorDraft;
    }

    public final void run() {
        if (this.$draft.getFrameStyle() != null) {
            this.this$0.getFrameEntity().applyStyle(this.$draft.getFrameStyle());
        }
        this.this$0.postDelayed(new Runnable(this) {
            final /* synthetic */ EditorFrame$apply$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                List<TextStyle> textStyles = this.this$0.$draft.getTextStyles();
                if (textStyles != null) {
                    for (TextStyle access$createTextEntity : textStyles) {
                        TextEntity unused = this.this$0.this$0.createTextEntity(access$createTextEntity, false);
                    }
                }
                List<MediaStyle> mediaStyles = this.this$0.$draft.getMediaStyles();
                if (mediaStyles != null) {
                    for (MediaStyle access$createMediaEntity : mediaStyles) {
                        MediaEntity unused2 = this.this$0.this$0.createMediaEntity(access$createMediaEntity, false);
                    }
                }
                this.this$0.this$0.applyDraft(this.this$0.$draft);
            }
        }, 400);
    }
}
