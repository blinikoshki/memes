package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, mo26107d2 = {"<anonymous>", "", "R", "run", "androidx/work/ListenableFutureKt$await$2$1"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: ListenableFuture.kt */
public final class OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $cancellableContinuation;
    final /* synthetic */ ListenableFuture $this_await$inlined;

    public OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await$inlined = listenableFuture;
    }

    public final void run() {
        try {
            Object obj = this.$this_await$inlined.get();
            Result.Companion companion = Result.Companion;
            this.$cancellableContinuation.resumeWith(Result.m1029constructorimpl(obj));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.cancel(cause);
                return;
            }
            Result.Companion companion2 = Result.Companion;
            this.$cancellableContinuation.resumeWith(Result.m1029constructorimpl(ResultKt.createFailure(cause)));
        }
    }
}
