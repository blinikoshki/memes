package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 0})
/* compiled from: Mutex.kt */
final class MutexImpl$LockSelect$completeResumeLockWaiter$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MutexImpl.LockSelect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutexImpl$LockSelect$completeResumeLockWaiter$2(MutexImpl.LockSelect lockSelect) {
        super(1);
        this.this$0 = lockSelect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        MutexImpl.this.unlock(this.this$0.owner);
    }
}
