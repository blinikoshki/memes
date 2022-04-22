package p015io.getstream.chat.android.client.call;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.errors.ChatErrorCode;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import p015io.getstream.chat.android.client.errors.ChatRequestError;
import p015io.getstream.chat.android.client.parser.ChatParser;
import p015io.getstream.chat.android.client.utils.Result;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J0\u0010\u0015\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0004\u0012\u00020\u00140\u0018H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo26107d2 = {"Lio/getstream/chat/android/client/call/RetrofitCall;", "T", "", "Lio/getstream/chat/android/client/call/Call;", "call", "Lretrofit2/Call;", "parser", "Lio/getstream/chat/android/client/parser/ChatParser;", "callbackExecutor", "Ljava/util/concurrent/Executor;", "(Lretrofit2/Call;Lio/getstream/chat/android/client/parser/ChatParser;Ljava/util/concurrent/Executor;)V", "getCall", "()Lretrofit2/Call;", "canceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCanceled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setCanceled", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "cancel", "", "enqueue", "callback", "Lio/getstream/chat/android/client/call/Call$Callback;", "Lkotlin/Function1;", "Lio/getstream/chat/android/client/utils/Result;", "execute", "failedError", "Lio/getstream/chat/android/client/errors/ChatError;", "t", "", "failedResult", "getResult", "retroCall", "retrofitResponse", "Lretrofit2/Response;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.RetrofitCall */
/* compiled from: RetrofitCall.kt */
public final class RetrofitCall<T> implements Call<T> {
    private final Call<T> call;
    /* access modifiers changed from: private */
    public final Executor callbackExecutor;
    private AtomicBoolean canceled = new AtomicBoolean(false);
    private final ChatParser parser;

    public RetrofitCall(Call<T> call2, ChatParser chatParser, Executor executor) {
        Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(chatParser, "parser");
        Intrinsics.checkNotNullParameter(executor, "callbackExecutor");
        this.call = call2;
        this.parser = chatParser;
        this.callbackExecutor = executor;
    }

    public void enqueue() {
        Call.DefaultImpls.enqueue(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the enqueue method with a Callback<T> parameter instead")
    public void enqueue(Function1<? super Result<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Call.DefaultImpls.enqueue(this, function1);
    }

    public final retrofit2.Call<T> getCall() {
        return this.call;
    }

    /* access modifiers changed from: protected */
    public final AtomicBoolean getCanceled() {
        return this.canceled;
    }

    /* access modifiers changed from: protected */
    public final void setCanceled(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.canceled = atomicBoolean;
    }

    public void cancel() {
        this.canceled.set(true);
        this.call.cancel();
    }

    public Result<T> execute() {
        return execute(this.call);
    }

    public void enqueue(Call.Callback<T> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        enqueue(this.call, new RetrofitCall$enqueue$1(this, callback));
    }

    private final Result<T> execute(retrofit2.Call<T> call2) {
        return getResult(call2);
    }

    private final void enqueue(retrofit2.Call<T> call2, Function1<? super Result<T>, Unit> function1) {
        call2.enqueue(new RetrofitCall$enqueue$2(this, function1));
    }

    /* access modifiers changed from: private */
    public final Result<T> failedResult(Throwable th) {
        return new Result<>(failedError(th));
    }

    private final ChatError failedError(Throwable th) {
        if (th instanceof ChatError) {
            return (ChatError) th;
        }
        if (!(th instanceof ChatRequestError)) {
            return ChatNetworkError.Companion.create$default(ChatNetworkError.Companion, ChatErrorCode.NETWORK_FAILED, th, 0, 4, (Object) null);
        }
        ChatRequestError chatRequestError = (ChatRequestError) th;
        return ChatNetworkError.Companion.create(chatRequestError.getStreamCode(), String.valueOf(th.getMessage()), chatRequestError.getStatusCode(), th.getCause());
    }

    private final Result<T> getResult(retrofit2.Call<T> call2) {
        try {
            Response<T> execute = call2.execute();
            Intrinsics.checkNotNullExpressionValue(execute, "retrofitResponse");
            return getResult(execute);
        } catch (Throwable th) {
            return failedResult(th);
        }
    }

    /* access modifiers changed from: private */
    public final Result<T> getResult(Response<T> response) {
        if (response.isSuccessful()) {
            try {
                T body = response.body();
                Intrinsics.checkNotNull(body);
                Intrinsics.checkNotNullExpressionValue(body, "retrofitResponse.body()!!");
                return new Result<>(body);
            } catch (Throwable th) {
                return new Result<>(failedError(th));
            }
        } else {
            ChatParser chatParser = this.parser;
            okhttp3.Response raw = response.raw();
            Intrinsics.checkNotNullExpressionValue(raw, "retrofitResponse.raw()");
            return new Result<>((ChatError) chatParser.toError(raw));
        }
    }
}
