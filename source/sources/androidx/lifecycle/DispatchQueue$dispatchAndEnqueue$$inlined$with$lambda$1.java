package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo26107d2 = {"<anonymous>", "", "run", "androidx/lifecycle/DispatchQueue$dispatchAndEnqueue$1$1"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: DispatchQueue.kt */
final class DispatchQueue$dispatchAndEnqueue$$inlined$with$lambda$1 implements Runnable {
    final /* synthetic */ CoroutineContext $context$inlined;
    final /* synthetic */ Runnable $runnable$inlined;
    final /* synthetic */ DispatchQueue this$0;

    DispatchQueue$dispatchAndEnqueue$$inlined$with$lambda$1(DispatchQueue dispatchQueue, CoroutineContext coroutineContext, Runnable runnable) {
        this.this$0 = dispatchQueue;
        this.$context$inlined = coroutineContext;
        this.$runnable$inlined = runnable;
    }

    public final void run() {
        this.this$0.enqueue(this.$runnable$inlined);
    }
}
