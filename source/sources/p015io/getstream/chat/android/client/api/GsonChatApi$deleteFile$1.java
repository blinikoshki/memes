package p015io.getstream.chat.android.client.api;

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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.api.GsonChatApi$deleteFile$1", mo26808f = "GsonChatApi.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$deleteFile$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$deleteFile$1 extends SuspendLambda implements Function1<Continuation<? super Result<Unit>>, Object> {
    final /* synthetic */ String $channelId;
    final /* synthetic */ String $channelType;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ GsonChatApi this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GsonChatApi$deleteFile$1(GsonChatApi gsonChatApi, String str, String str2, String str3, Continuation continuation) {
        super(1, continuation);
        this.this$0 = gsonChatApi;
        this.$channelType = str;
        this.$channelId = str2;
        this.$url = str3;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new GsonChatApi$deleteFile$1(this.this$0, this.$channelType, this.$channelId, this.$url, continuation);
    }

    public final Object invoke(Object obj) {
        return ((GsonChatApi$deleteFile$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.fileUploader.deleteFile(this.$channelType, this.$channelId, this.this$0.userId, this.this$0.connectionId, this.$url);
            return new Result(Unit.INSTANCE);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
