package p015io.getstream.chat.android.livedata.usecase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.MarkAllReadImpl$invoke$1", mo26808f = "MarkAllReadImpl.kt", mo26809i = {}, mo26810l = {32}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.MarkAllReadImpl$invoke$1 */
/* compiled from: MarkAllReadImpl.kt */
final class MarkAllReadImpl$invoke$1 extends SuspendLambda implements Function1<Continuation<? super Result<Boolean>>, Object> {
    int label;
    final /* synthetic */ MarkAllReadImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MarkAllReadImpl$invoke$1(MarkAllReadImpl markAllReadImpl, Continuation continuation) {
        super(1, continuation);
        this.this$0 = markAllReadImpl;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new MarkAllReadImpl$invoke$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj) {
        return ((MarkAllReadImpl$invoke$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Iterable<ChannelControllerImpl> allActiveChannels$stream_chat_android_offline_release = this.this$0.domain.allActiveChannels$stream_chat_android_offline_release();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allActiveChannels$stream_chat_android_offline_release, 10));
            for (ChannelControllerImpl markAllReadImpl$invoke$1$1$1 : allActiveChannels$stream_chat_android_offline_release) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(this.this$0.domain.getScope$stream_chat_android_offline_release(), DispatcherProvider.INSTANCE.getMain(), (CoroutineStart) null, new MarkAllReadImpl$invoke$1$1$1(markAllReadImpl$invoke$1$1$1, (Continuation) null), 2, (Object) null));
            }
            this.label = 1;
            if (AwaitKt.awaitAll((List) arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.domain.getClient$stream_chat_android_offline_release().markAllRead().execute();
        return new Result(Boxing.boxBoolean(true));
    }
}
