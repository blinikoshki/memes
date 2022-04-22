package p015io.getstream.chat.android.client.api;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.utils.ProgressCallback;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/utils/Result;", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "io.getstream.chat.android.client.api.GsonChatApi$sendImage$1", mo26808f = "GsonChatApi.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: io.getstream.chat.android.client.api.GsonChatApi$sendImage$1 */
/* compiled from: GsonChatApi.kt */
final class GsonChatApi$sendImage$1 extends SuspendLambda implements Function1<Continuation<? super Result<String>>, Object> {
    final /* synthetic */ ProgressCallback $callback;
    final /* synthetic */ String $channelId;
    final /* synthetic */ String $channelType;
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ GsonChatApi this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GsonChatApi$sendImage$1(GsonChatApi gsonChatApi, ProgressCallback progressCallback, String str, String str2, File file, Continuation continuation) {
        super(1, continuation);
        this.this$0 = gsonChatApi;
        this.$callback = progressCallback;
        this.$channelType = str;
        this.$channelId = str2;
        this.$file = file;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new GsonChatApi$sendImage$1(this.this$0, this.$callback, this.$channelType, this.$channelId, this.$file, continuation);
    }

    public final Object invoke(Object obj) {
        return ((GsonChatApi$sendImage$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$callback != null) {
                str = this.this$0.fileUploader.sendImage(this.$channelType, this.$channelId, this.this$0.userId, this.this$0.connectionId, this.$file, this.$callback);
            } else {
                str = this.this$0.fileUploader.sendImage(this.$channelType, this.$channelId, this.this$0.userId, this.this$0.connectionId, this.$file);
            }
            if (str != null) {
                return new Result(str);
            }
            return new Result(new ChatError("Upload failed", (Throwable) null, 2, (DefaultConstructorMarker) null));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
