package editor.optionsui.layerpaint.color;

import editor.optionsui.layerpaint.LayerPaint;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo26107d2 = {"<anonymous>", "", "Leditor/optionsui/layerpaint/LayerPaint$Color;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.optionsui.layerpaint.color.ColorsViewModel$fetchColors$2", mo26808f = "ColorsViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: ColorsViewModel.kt */
final class ColorsViewModel$fetchColors$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LayerPaint.Color>>, Object> {
    int label;
    final /* synthetic */ ColorsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ColorsViewModel$fetchColors$2(ColorsViewModel colorsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = colorsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ColorsViewModel$fetchColors$2(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ColorsViewModel$fetchColors$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.assetsProvider.getColors();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
