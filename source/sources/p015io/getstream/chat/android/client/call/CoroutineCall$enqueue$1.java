package p015io.getstream.chat.android.client.call;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.call.CoroutineCall$enqueue$1", mo26808f = "CoroutineCall.kt", mo26809i = {0}, mo26810l = {30, 31}, mo26811m = "invokeSuspend", mo26812n = {"result"}, mo26813s = {"L$0"})
/* renamed from: io.getstream.chat.android.client.call.CoroutineCall$enqueue$1 */
/* compiled from: CoroutineCall.kt */
final class CoroutineCall$enqueue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Call.Callback $callback;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CoroutineCall this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineCall$enqueue$1(CoroutineCall coroutineCall, Call.Callback callback, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coroutineCall;
        this.$callback = callback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CoroutineCall$enqueue$1(this.this$0, this.$callback, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CoroutineCall$enqueue$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(T t) {
        final Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        T coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(t);
            objectRef2 = new Ref.ObjectRef();
            Function1 suspendingTask = this.this$0.getSuspendingTask();
            this.L$0 = objectRef2;
            this.L$1 = objectRef2;
            this.label = 1;
            t = suspendingTask.invoke(this);
            if (t == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else if (i == 1) {
            objectRef2 = (Ref.ObjectRef) this.L$1;
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(t);
        } else if (i == 2) {
            ResultKt.throwOnFailure(t);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2.element = (Result) t;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(DispatcherProvider.INSTANCE.getMain(), new C49471(this, (Continuation) null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo26107d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "io.getstream.chat.android.client.call.CoroutineCall$enqueue$1$1", mo26808f = "CoroutineCall.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: io.getstream.chat.android.client.call.CoroutineCall$enqueue$1$1 */
    /* compiled from: CoroutineCall.kt */
    static final class C49471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoroutineCall$enqueue$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C49471(this.this$0, objectRef, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C49471) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.$callback.onResult((Result) objectRef.element);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
