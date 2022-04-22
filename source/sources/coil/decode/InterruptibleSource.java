package coil.decode;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u00012#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bB\u0019\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u0013\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo26107d2 = {"Lcoil/decode/InterruptibleSource;", "Lokio/ForwardingSource;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "delegate", "Lokio/Source;", "(Lkotlinx/coroutines/CancellableContinuation;Lokio/Source;)V", "_state", "Ljava/util/concurrent/atomic/AtomicInteger;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "clearInterrupt", "invalidState", "", "state", "", "invoke", "read", "", "sink", "Lokio/Buffer;", "byteCount", "setInterruptible", "interruptible", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: InterruptibleSource.kt */
public final class InterruptibleSource extends ForwardingSource implements Function1<Throwable, Unit> {
    private final AtomicInteger _state = new AtomicInteger(1);
    private final Thread targetThread = Thread.currentThread();

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterruptibleSource(CancellableContinuation<?> cancellableContinuation, Source source) {
        super(source);
        int i;
        Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
        Intrinsics.checkNotNullParameter(source, "delegate");
        cancellableContinuation.invokeOnCancellation(this);
        InterruptibleSource interruptibleSource = this;
        AtomicInteger atomicInteger = interruptibleSource._state;
        do {
            i = atomicInteger.get();
            if (i != 1) {
                if (i != 3 && i != 4 && i != 5) {
                    interruptibleSource.invalidState(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!interruptibleSource._state.compareAndSet(i, 1));
    }

    /* JADX INFO: finally extract failed */
    public long read(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        try {
            setInterruptible(false);
            long read = super.read(buffer, j);
            setInterruptible(true);
            return read;
        } catch (Throwable th) {
            setInterruptible(true);
            throw th;
        }
    }

    private final void setInterruptible(boolean z) {
        AtomicInteger atomicInteger = this._state;
        while (true) {
            int i = atomicInteger.get();
            if (i == 0 || i == 1) {
                if (this._state.compareAndSet(i, true ^ z ? 1 : 0)) {
                    return;
                }
            } else if (i != 3) {
                if (i != 4) {
                    if (i == 5) {
                        Thread.interrupted();
                        return;
                    } else {
                        invalidState(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (this._state.compareAndSet(i, 4)) {
                this.targetThread.interrupt();
                this._state.set(5);
                return;
            }
        }
    }

    public final void clearInterrupt() {
        AtomicInteger atomicInteger = this._state;
        while (true) {
            int i = atomicInteger.get();
            if (i == 0 || i == 3) {
                if (this._state.compareAndSet(i, 2)) {
                    return;
                }
            } else if (i != 4) {
                if (i == 5) {
                    Thread.interrupted();
                    return;
                } else {
                    invalidState(i);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    public void invoke(Throwable th) {
        AtomicInteger atomicInteger = this._state;
        while (true) {
            int i = atomicInteger.get();
            if (i != 0) {
                if (i != 1) {
                    if (i != 2 && i != 3 && i != 4 && i != 5) {
                        invalidState(i);
                        throw new KotlinNothingValueException();
                    }
                    return;
                } else if (this._state.compareAndSet(i, 3)) {
                    return;
                }
            } else if (this._state.compareAndSet(i, 4)) {
                this.targetThread.interrupt();
                this._state.set(5);
                return;
            }
        }
    }

    private final Void invalidState(int i) {
        throw new IllegalStateException(("Illegal state: " + i).toString());
    }
}
