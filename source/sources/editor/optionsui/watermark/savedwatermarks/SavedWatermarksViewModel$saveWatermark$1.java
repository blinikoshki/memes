package editor.optionsui.watermark.savedwatermarks;

import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.frame.FrameEntity;
import editor.optionsui.watermark.Watermark;
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
@DebugMetadata(mo26807c = "editor.optionsui.watermark.savedwatermarks.SavedWatermarksViewModel$saveWatermark$1", mo26808f = "SavedWatermarksViewModel.kt", mo26809i = {}, mo26810l = {92}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: SavedWatermarksViewModel.kt */
final class SavedWatermarksViewModel$saveWatermark$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoreEntity $entity;
    final /* synthetic */ FrameEntity $frameEntity;
    int label;
    final /* synthetic */ SavedWatermarksViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SavedWatermarksViewModel$saveWatermark$1(SavedWatermarksViewModel savedWatermarksViewModel, FrameEntity frameEntity, CoreEntity coreEntity, Continuation continuation) {
        super(2, continuation);
        this.this$0 = savedWatermarksViewModel;
        this.$frameEntity = frameEntity;
        this.$entity = coreEntity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SavedWatermarksViewModel$saveWatermark$1(this.this$0, this.$frameEntity, this.$entity, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SavedWatermarksViewModel$saveWatermark$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showBlockingProgress("Saving Watermark...");
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new SavedWatermarksViewModel$saveWatermark$1$savedWatermark$1(this, (Continuation) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.hideBlockingProgress();
        this.this$0.notifyWatermarkSaved((Watermark) obj);
        return Unit.INSTANCE;
    }
}
