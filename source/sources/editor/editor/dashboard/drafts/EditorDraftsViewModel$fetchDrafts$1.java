package editor.editor.dashboard.drafts;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.editor.dashboard.drafts.EditorDraftsViewModel$fetchDrafts$1", mo26808f = "EditorDraftsViewModel.kt", mo26809i = {}, mo26810l = {55}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: EditorDraftsViewModel.kt */
final class EditorDraftsViewModel$fetchDrafts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EditorDraftsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorDraftsViewModel$fetchDrafts$1(EditorDraftsViewModel editorDraftsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = editorDraftsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new EditorDraftsViewModel$fetchDrafts$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EditorDraftsViewModel$fetchDrafts$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new EditorDraftsViewModel$fetchDrafts$1$drafts$1(this, (Continuation) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0._draftsLiveData.setValue((List) obj);
        return Unit.INSTANCE;
    }
}
