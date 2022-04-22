package editor.optionsui.frame.frameresize;

import editor.optionsui.frame.frameresize.ResizeFrameItem;
import editor.optionsui.frame.frameresize.ResizeFrameViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "Leditor/optionsui/frame/frameresize/ResizeFrameItem$Preview;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.optionsui.frame.frameresize.ResizeFrameViewModel$1$sizes$1", mo26808f = "ResizeFrameViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: ResizeFrameViewModel.kt */
final class ResizeFrameViewModel$1$sizes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ResizeFrameItem.Preview>>, Object> {
    int label;
    final /* synthetic */ ResizeFrameViewModel.C48471 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ResizeFrameViewModel$1$sizes$1(ResizeFrameViewModel.C48471 r1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = r1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ResizeFrameViewModel$1$sizes$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ResizeFrameViewModel$1$sizes$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Iterable<FrameSize> frameSizes = this.this$0.this$0.assetsProvider.getFrameSizes();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(frameSizes, 10));
            for (FrameSize preview : frameSizes) {
                arrayList.add(new ResizeFrameItem.Preview(preview));
            }
            return (List) arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
