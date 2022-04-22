package editor.editor.editorframehost.frame;

import com.memes.editor.C4175R;
import editor.editor.editorframehost.selection.NicoLayerSelectionView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"<anonymous>", "Leditor/editor/editorframehost/selection/NicoLayerSelectionView;", "kotlin.jvm.PlatformType", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
final class EditorFrame$selectionView$2 extends Lambda implements Function0<NicoLayerSelectionView> {
    final /* synthetic */ EditorFrame this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorFrame$selectionView$2(EditorFrame editorFrame) {
        super(0);
        this.this$0 = editorFrame;
    }

    public final NicoLayerSelectionView invoke() {
        NicoLayerSelectionView nicoLayerSelectionView = (NicoLayerSelectionView) this.this$0.findViewById(C4175R.C4179id.selection_view);
        nicoLayerSelectionView.setSelectionListener(this.this$0);
        return nicoLayerSelectionView;
    }
}
