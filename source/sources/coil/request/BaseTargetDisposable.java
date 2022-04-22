package coil.request;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo26107d2 = {"Lcoil/request/BaseTargetDisposable;", "Lcoil/request/Disposable;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "isDisposed", "", "()Z", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: Disposable.kt */
public final class BaseTargetDisposable implements Disposable {
    private final Job job;

    public BaseTargetDisposable(Job job2) {
        Intrinsics.checkNotNullParameter(job2, "job");
        this.job = job2;
    }

    public boolean isDisposed() {
        return !this.job.isActive();
    }

    public void dispose() {
        if (!isDisposed()) {
            Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        }
    }

    public Object await(Continuation<? super Unit> continuation) {
        if (isDisposed()) {
            return Unit.INSTANCE;
        }
        Object join = this.job.join(continuation);
        if (join == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return join;
        }
        return Unit.INSTANCE;
    }
}
