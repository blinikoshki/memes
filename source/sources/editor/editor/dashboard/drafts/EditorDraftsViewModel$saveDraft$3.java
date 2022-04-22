package editor.editor.dashboard.drafts;

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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Leditor/editor/dashboard/drafts/EditorDraft;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.dashboard.drafts.EditorDraftsViewModel$saveDraft$3", mo26808f = "EditorDraftsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EditorDraftsViewModel.kt */
final class EditorDraftsViewModel$saveDraft$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EditorDraft>, Object> {
    final /* synthetic */ EditorDraft $draft;
    int label;
    final /* synthetic */ EditorDraftsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftsViewModel$saveDraft$3(EditorDraftsViewModel editorDraftsViewModel, EditorDraft editorDraft, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorDraftsViewModel;
        this.$draft = editorDraft;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorDraftsViewModel$saveDraft$3(this.this$0, this.$draft, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorDraftsViewModel$saveDraft$3) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.draftsDao.insertAll(this.$draft);
            return this.$draft;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
