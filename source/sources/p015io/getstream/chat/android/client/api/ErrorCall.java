package p015io.getstream.chat.android.client.api;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/ErrorCall;", "T", "", "Lio/getstream/chat/android/client/call/Call;", "e", "Lio/getstream/chat/android/client/errors/ChatError;", "(Lio/getstream/chat/android/client/errors/ChatError;)V", "cancel", "", "enqueue", "callback", "Lio/getstream/chat/android/client/call/Call$Callback;", "execute", "Lio/getstream/chat/android/client/utils/Result;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.ErrorCall */
/* compiled from: ErrorCall.kt */
public final class ErrorCall<T> implements Call<T> {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ChatError f1445e;

    public void cancel() {
    }

    public ErrorCall(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "e");
        this.f1445e = chatError;
    }

    public void enqueue() {
        Call.DefaultImpls.enqueue(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the enqueue method with a Callback<T> parameter instead")
    public void enqueue(Function1<? super Result<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Call.DefaultImpls.enqueue(this, function1);
    }

    public Result<T> execute() {
        return new Result<>(this.f1445e);
    }

    public void enqueue(Call.Callback<T> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, DispatcherProvider.INSTANCE.getMain(), (CoroutineStart) null, new ErrorCall$enqueue$1(this, callback, (Continuation) null), 2, (Object) null);
    }
}
