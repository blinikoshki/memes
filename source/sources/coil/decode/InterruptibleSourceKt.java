package coil.decode;

import java.io.InterruptedIOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okio.Source;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\fHHø\u0001\u0000¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo26107d2 = {"FINISHED", "", "INTERRUPTED", "INTERRUPTING", "PENDING", "UNINTERRUPTIBLE", "WORKING", "withInterruptibleSource", "T", "source", "Lokio/Source;", "block", "Lkotlin/Function1;", "(Lokio/Source;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: InterruptibleSource.kt */
public final class InterruptibleSourceKt {
    private static final int FINISHED = 2;
    private static final int INTERRUPTED = 5;
    private static final int INTERRUPTING = 4;
    private static final int PENDING = 3;
    private static final int UNINTERRUPTIBLE = 1;
    private static final int WORKING = 0;

    private static final Object withInterruptibleSource$$forInline(Source source, Function1 function1, Continuation continuation) {
        InterruptibleSource interruptibleSource;
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        try {
            interruptibleSource = new InterruptibleSource(cancellableContinuation, source);
            Object invoke = function1.invoke(interruptibleSource);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m1029constructorimpl(invoke));
            InlineMarker.finallyStart(1);
            interruptibleSource.clearInterrupt();
            InlineMarker.finallyEnd(1);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
            return result;
        } catch (Exception e) {
            if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                Throwable initCause = new CancellationException("Blocking call was interrupted due to parent cancellation.").initCause(e);
                Intrinsics.checkNotNullExpressionValue(initCause, "CancellationException(\"B…n.\").initCause(exception)");
                throw initCause;
            }
            throw e;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            interruptibleSource.clearInterrupt();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final <T> Object withInterruptibleSource(Source source, Function1<? super Source, ? extends T> function1, Continuation<? super T> continuation) {
        InterruptibleSource interruptibleSource;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        try {
            interruptibleSource = new InterruptibleSource(cancellableContinuation, source);
            Object invoke = function1.invoke(interruptibleSource);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m1029constructorimpl(invoke));
            InlineMarker.finallyStart(1);
            interruptibleSource.clearInterrupt();
            InlineMarker.finallyEnd(1);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Exception e) {
            if ((e instanceof InterruptedException) || (e instanceof InterruptedIOException)) {
                Throwable initCause = new CancellationException("Blocking call was interrupted due to parent cancellation.").initCause(e);
                Intrinsics.checkNotNullExpressionValue(initCause, "CancellationException(\"B…n.\").initCause(exception)");
                throw initCause;
            }
            throw e;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            interruptibleSource.clearInterrupt();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
