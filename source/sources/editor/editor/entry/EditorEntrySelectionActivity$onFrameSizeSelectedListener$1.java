package editor.editor.entry;

import editor.editor.entry.framesizes.EntryFrameSizesAdapter;
import editor.mediaselection.MediaSelectionActivity;
import editor.mediaselection.MediaSelectionConfig;
import editor.optionsui.frame.frameresize.FrameSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "frameSize", "Leditor/optionsui/frame/frameresize/FrameSize;", "onFrameSizeSelected"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
final class EditorEntrySelectionActivity$onFrameSizeSelectedListener$1 implements EntryFrameSizesAdapter.Callback {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    EditorEntrySelectionActivity$onFrameSizeSelectedListener$1(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        this.this$0 = editorEntrySelectionActivity;
    }

    public final void onFrameSizeSelected(FrameSize frameSize) {
        Intrinsics.checkNotNullParameter(frameSize, "frameSize");
        if (!frameSize.isValid()) {
            this.this$0.showFrameSizeInputSheet();
            return;
        }
        this.this$0.startActivity(MediaSelectionActivity.Companion.getStartIntent(this.this$0, new MediaSelectionConfig(0, (List) null, false, 7, (DefaultConstructorMarker) null), frameSize));
    }
}
