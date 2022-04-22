package editor.optionsui.layout.wireframes;

import androidx.lifecycle.MutableLiveData;
import editor.optionsui.layout.wireframes.WireframeItem;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import wireframe.language.Wireframe;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "editor.optionsui.layout.wireframes.WireframesViewModel$loadWireframes$1", mo26808f = "WireframesViewModel.kt", mo26809i = {}, mo26810l = {42}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: WireframesViewModel.kt */
final class WireframesViewModel$loadWireframes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WireframesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WireframesViewModel$loadWireframes$1(WireframesViewModel wireframesViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = wireframesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new WireframesViewModel$loadWireframes$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((WireframesViewModel$loadWireframes$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new WireframesViewModel$loadWireframes$1$wireframes$1(this, (Continuation) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        this.this$0.loadedWireframes.clear();
        this.this$0.loadedWireframes.addAll(list);
        this.this$0._wireframes.setValue(list);
        MutableLiveData access$get_wireframeItems$p = this.this$0._wireframeItems;
        Iterable<Wireframe> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Wireframe preview : iterable) {
            arrayList.add(new WireframeItem.Preview(preview));
        }
        access$get_wireframeItems$p.setValue((List) arrayList);
        return Unit.INSTANCE;
    }
}
