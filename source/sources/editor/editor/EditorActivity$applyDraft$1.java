package editor.editor;

import editor.editor.dashboard.drafts.EditorDraft;
import editor.editor.dashboard.drafts.EditorDraftsViewModel;
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
@DebugMetadata(mo26807c = "editor.editor.EditorActivity$applyDraft$1", mo26808f = "EditorActivity.kt", mo26809i = {}, mo26810l = {479}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EditorActivity.kt */
final class EditorActivity$applyDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $draftId;
    int label;
    final /* synthetic */ EditorActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorActivity$applyDraft$1(EditorActivity editorActivity, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorActivity;
        this.$draftId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorActivity$applyDraft$1(this.this$0, this.$draftId, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorActivity$applyDraft$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            EditorDraftsViewModel access$getDraftsViewModel$p = this.this$0.getDraftsViewModel();
            String str = this.$draftId;
            this.label = 1;
            obj = access$getDraftsViewModel$p.importDraft(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getFrame().apply((EditorDraft) obj);
        return Unit.INSTANCE;
    }
}
