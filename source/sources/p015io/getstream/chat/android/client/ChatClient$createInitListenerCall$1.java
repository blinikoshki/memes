package p015io.getstream.chat.android.client;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.models.ConnectionData;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¨\u0006\n"}, mo26107d2 = {"io/getstream/chat/android/client/ChatClient$createInitListenerCall$1", "Lio/getstream/chat/android/client/call/Call;", "Lio/getstream/chat/android/client/models/ConnectionData;", "cancel", "", "enqueue", "callback", "Lio/getstream/chat/android/client/call/Call$Callback;", "execute", "Lio/getstream/chat/android/client/utils/Result;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.ChatClient$createInitListenerCall$1 */
/* compiled from: ChatClient.kt */
public final class ChatClient$createInitListenerCall$1 implements Call<ConnectionData> {
    final /* synthetic */ Function1 $performCall;

    public void cancel() {
    }

    ChatClient$createInitListenerCall$1(Function1 function1) {
        this.$performCall = function1;
    }

    public void enqueue() {
        Call.DefaultImpls.enqueue(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the enqueue method with a Callback<T> parameter instead")
    public void enqueue(Function1<? super Result<ConnectionData>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Call.DefaultImpls.enqueue(this, function1);
    }

    public Result<ConnectionData> execute() {
        return (Result) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new ChatClient$createInitListenerCall$1$execute$1(this, (Continuation) null), 1, (Object) null);
    }

    public void enqueue(Call.Callback<ConnectionData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.$performCall.invoke(new ChatClient$createInitListenerCall$1$enqueue$1(callback));
    }
}
