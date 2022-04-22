package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, mo26107d2 = {"<anonymous>", "", "it", "", "invoke", "kotlinx/coroutines/sync/MutexImpl$lockSuspend$2$1$1", "kotlinx/coroutines/sync/MutexImpl$$special$$inlined$loop$lambda$1"}, mo26108k = 3, mo26109mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.MutexImpl$lockSuspend$$inlined$suspendCancellableCoroutineReusable$lambda$1 */
/* compiled from: Mutex.kt */
final class C2368xac82bc2a extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellableContinuation $cont$inlined;
    final /* synthetic */ Object $owner$inlined;
    final /* synthetic */ MutexImpl.LockCont $waiter$inlined;
    final /* synthetic */ MutexImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2368xac82bc2a(CancellableContinuation cancellableContinuation, MutexImpl.LockCont lockCont, MutexImpl mutexImpl, Object obj) {
        super(1);
        this.$cont$inlined = cancellableContinuation;
        this.$waiter$inlined = lockCont;
        this.this$0 = mutexImpl;
        this.$owner$inlined = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        this.this$0.unlock(this.$owner$inlined);
    }
}
