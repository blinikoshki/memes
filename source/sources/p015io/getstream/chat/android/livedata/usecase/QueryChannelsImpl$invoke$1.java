package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsController;
import p015io.getstream.chat.android.livedata.controller.QueryChannelsControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.QueryChannelsImpl$invoke$1", mo26808f = "QueryChannelsImpl.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.QueryChannelsImpl$invoke$1 */
/* compiled from: QueryChannelsImpl.kt */
final class QueryChannelsImpl$invoke$1 extends SuspendLambda implements Function1<Continuation<? super Result<QueryChannelsController>>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ int $messageLimit;
    final /* synthetic */ QueryChannelsControllerImpl $queryChannelsControllerImpl;
    int label;
    final /* synthetic */ QueryChannelsImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryChannelsImpl$invoke$1(QueryChannelsImpl queryChannelsImpl, int i, QueryChannelsControllerImpl queryChannelsControllerImpl, int i2, Continuation continuation) {
        super(1, continuation);
        this.this$0 = queryChannelsImpl;
        this.$limit = i;
        this.$queryChannelsControllerImpl = queryChannelsControllerImpl;
        this.$messageLimit = i2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new QueryChannelsImpl$invoke$1(this.this$0, this.$limit, this.$queryChannelsControllerImpl, this.$messageLimit, continuation);
    }

    public final Object invoke(Object obj) {
        return ((QueryChannelsImpl$invoke$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$limit > 0) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(this.this$0.domainImpl.getScope$stream_chat_android_offline_release(), (CoroutineContext) null, (CoroutineStart) null, new C50571(this, (Continuation) null), 3, (Object) null);
            }
            return new Result(this.$queryChannelsControllerImpl);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.QueryChannelsImpl$invoke$1$1", mo26808f = "QueryChannelsImpl.kt", mo26809i = {}, mo26810l = {49}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: io.getstream.chat.android.livedata.usecase.QueryChannelsImpl$invoke$1$1 */
    /* compiled from: QueryChannelsImpl.kt */
    static final class C50571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ QueryChannelsImpl$invoke$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C50571(this.this$0, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C50571) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                QueryChannelsControllerImpl queryChannelsControllerImpl = this.this$0.$queryChannelsControllerImpl;
                int i2 = this.this$0.$limit;
                int i3 = this.this$0.$messageLimit;
                this.label = 1;
                if (QueryChannelsControllerImpl.query$default(queryChannelsControllerImpl, i2, i3, 0, this, 4, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
