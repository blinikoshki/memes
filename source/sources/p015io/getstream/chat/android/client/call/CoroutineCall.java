package p015io.getstream.chat.android.client.call;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B4\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/client/call/CoroutineCall;", "T", "", "Lio/getstream/chat/android/client/call/Call;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "suspendingTask", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lio/getstream/chat/android/client/utils/Result;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "job", "Lkotlinx/coroutines/Job;", "getSuspendingTask", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "cancel", "", "enqueue", "callback", "Lio/getstream/chat/android/client/call/Call$Callback;", "execute", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.CoroutineCall */
/* compiled from: CoroutineCall.kt */
public final class CoroutineCall<T> implements Call<T> {
    private Job job;
    private final CoroutineScope scope;
    private final Function1<Continuation<? super Result<T>>, Object> suspendingTask;

    public CoroutineCall(CoroutineScope coroutineScope, Function1<? super Continuation<? super Result<T>>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function1, "suspendingTask");
        this.scope = coroutineScope;
        this.suspendingTask = function1;
    }

    public void enqueue() {
        Call.DefaultImpls.enqueue(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the enqueue method with a Callback<T> parameter instead")
    public void enqueue(Function1<? super Result<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Call.DefaultImpls.enqueue(this, function1);
    }

    public final Function1<Continuation<? super Result<T>>, Object> getSuspendingTask() {
        return this.suspendingTask;
    }

    public void cancel() {
        Job job2 = this.job;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    public Result<T> execute() {
        return (Result) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new CoroutineCall$execute$1(this, (Continuation) null), 1, (Object) null);
    }

    public void enqueue(Call.Callback<T> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.job = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new CoroutineCall$enqueue$1(this, callback, (Continuation) null), 3, (Object) null);
    }
}
