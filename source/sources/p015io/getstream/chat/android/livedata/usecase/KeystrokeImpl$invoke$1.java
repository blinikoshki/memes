package p015io.getstream.chat.android.livedata.usecase;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.livedata.controller.ChannelControllerImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.livedata.usecase.KeystrokeImpl$invoke$1", mo26808f = "KeystrokeImpl.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.livedata.usecase.KeystrokeImpl$invoke$1 */
/* compiled from: KeystrokeImpl.kt */
final class KeystrokeImpl$invoke$1 extends SuspendLambda implements Function1<Continuation<? super Result<Boolean>>, Object> {
    final /* synthetic */ ChannelControllerImpl $channelController;
    final /* synthetic */ String $parentId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeystrokeImpl$invoke$1(ChannelControllerImpl channelControllerImpl, String str, Continuation continuation) {
        super(1, continuation);
        this.$channelController = channelControllerImpl;
        this.$parentId = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new KeystrokeImpl$invoke$1(this.$channelController, this.$parentId, continuation);
    }

    public final Object invoke(Object obj) {
        return ((KeystrokeImpl$invoke$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$channelController.keystroke(this.$parentId);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
