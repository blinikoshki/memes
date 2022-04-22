package editor.editor.dashboard.drafts;

import editor.contentport.draft.EditorDraftExporter;
import editor.editor.editorframehost.frame.EditorFrame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.dashboard.drafts.EditorDraftsViewModel$saveDraft$1", mo26808f = "EditorDraftsViewModel.kt", mo26809i = {0}, mo26810l = {86}, mo26811m = "invokeSuspend", mo26812n = {"draft"}, mo26813s = {"L$0"})
/* compiled from: EditorDraftsViewModel.kt */
final class EditorDraftsViewModel$saveDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EditorFrame $frame;
    final /* synthetic */ String $id;
    final /* synthetic */ String $thumbnailPath;
    Object L$0;
    int label;
    final /* synthetic */ EditorDraftsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftsViewModel$saveDraft$1(EditorDraftsViewModel editorDraftsViewModel, EditorFrame editorFrame, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorDraftsViewModel;
        this.$frame = editorFrame;
        this.$thumbnailPath = str;
        this.$id = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorDraftsViewModel$saveDraft$1(this.this$0, this.$frame, this.$thumbnailPath, this.$id, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorDraftsViewModel$saveDraft$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        EditorDraft editorDraft;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showBlockingProgress("Creating Draft...");
            EditorDraft export = new EditorDraftExporter(this.$frame, this.this$0.getPortUtil(), this.$thumbnailPath).export(this.$id);
            EditorDraftsViewModel editorDraftsViewModel = this.this$0;
            this.L$0 = export;
            this.label = 1;
            if (editorDraftsViewModel.saveDraft(export, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            editorDraft = export;
        } else if (i == 1) {
            editorDraft = (EditorDraft) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.hideBlockingProgress();
        this.this$0._draftSavedLiveData.setValue(editorDraft);
        return Unit.INSTANCE;
    }
}
