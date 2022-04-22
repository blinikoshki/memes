package p015io.getstream.chat.android.client.call;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B!\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\f2\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u000fH\u0016J\u001a\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0011H\u0016J<\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00050\u0011\"\b\b\u0002\u0010\u0001*\u00020\u0002\"\b\b\u0003\u0010\u0003*\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0011H\u0002J<\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00050\u0011\"\b\b\u0002\u0010\u0001*\u00020\u0002\"\b\b\u0003\u0010\u0003*\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0011H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/client/call/ZipCall;", "A", "", "B", "Lio/getstream/chat/android/client/call/Call;", "Lkotlin/Pair;", "callA", "callB", "(Lio/getstream/chat/android/client/call/Call;Lio/getstream/chat/android/client/call/Call;)V", "job", "Lkotlinx/coroutines/Job;", "cancel", "", "enqueue", "callback", "Lio/getstream/chat/android/client/call/Call$Callback;", "execute", "Lio/getstream/chat/android/client/utils/Result;", "getErrorA", "resultA", "getErrorB", "resultB", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.ZipCall */
/* compiled from: ZipCall.kt */
public final class ZipCall<A, B> implements Call<Pair<? extends A, ? extends B>> {
    /* access modifiers changed from: private */
    public final Call<A> callA;
    /* access modifiers changed from: private */
    public final Call<B> callB;
    private Job job;

    public ZipCall(Call<A> call, Call<B> call2) {
        Intrinsics.checkNotNullParameter(call, "callA");
        Intrinsics.checkNotNullParameter(call2, "callB");
        this.callA = call;
        this.callB = call2;
    }

    public void enqueue() {
        Call.DefaultImpls.enqueue(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use the enqueue method with a Callback<T> parameter instead")
    public void enqueue(Function1<? super Result<Pair<A, B>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Call.DefaultImpls.enqueue(this, function1);
    }

    public void cancel() {
        Job job2 = this.job;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    public Result<Pair<A, B>> execute() {
        CompletableJob Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
        this.job = Job$default;
        return (Result) BuildersKt.runBlocking(Job$default, new ZipCall$execute$1(this, (Continuation) null));
    }

    public void enqueue(Call.Callback<Pair<A, B>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.job = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new ZipCall$enqueue$2(this, new ZipCall$enqueue$1(callback, (Continuation) null), (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final <A, B> Result<Pair<A, B>> getErrorA(Result<A> result) {
        return new Result<>(new ChatError("Error executing callA", result.error().getCause()));
    }

    /* access modifiers changed from: private */
    public final <A, B> Result<Pair<A, B>> getErrorB(Result<B> result) {
        return new Result<>(new ChatError("Error executing callB", result.error().getCause()));
    }
}
