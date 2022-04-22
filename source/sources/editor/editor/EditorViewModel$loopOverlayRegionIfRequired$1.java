package editor.editor;

import editor.editor.export.regions.OverlayRegion;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, mo26107d2 = {"loopOverlayRegionIfRequired", "", "overlayRegion", "Leditor/editor/export/regions/OverlayRegion;", "longestVideoDurationMillis", "", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.EditorViewModel", mo26808f = "EditorViewModel.kt", mo26809i = {0, 0, 0, 1}, mo26810l = {192, 203}, mo26811m = "loopOverlayRegionIfRequired", mo26812n = {"this", "overlayRegion", "longestVideoDurationMillis", "overlayRegion"}, mo26813s = {"L$0", "L$1", "J$0", "L$0"})
/* compiled from: EditorViewModel.kt */
final class EditorViewModel$loopOverlayRegionIfRequired$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorViewModel$loopOverlayRegionIfRequired$1(EditorViewModel editorViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = editorViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loopOverlayRegionIfRequired((OverlayRegion) null, 0, this);
    }
}
