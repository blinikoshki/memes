package com.getstream.sdk.chat.utils;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.core.internal.coroutines.DispatcherProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\nJ\u0013\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\nJ\b\u0010\u000f\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/StartStopBuffer;", "T", "", "()V", "active", "Ljava/util/concurrent/atomic/AtomicBoolean;", "events", "Ljava/util/Queue;", "func", "Lkotlin/Function1;", "", "enqueueData", "data", "(Ljava/lang/Object;)V", "hold", "propagateData", "subscribe", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: StartStopBuffer.kt */
public final class StartStopBuffer<T> {
    /* access modifiers changed from: private */
    public AtomicBoolean active = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public final Queue<T> events = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public Function1<? super T, Unit> func;

    public final void hold() {
        this.active.set(false);
    }

    public final void active() {
        this.active.set(true);
        if (this.func != null) {
            propagateData();
        }
    }

    private final void propagateData() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(DispatcherProvider.INSTANCE.getIO()), (CoroutineContext) null, (CoroutineStart) null, new StartStopBuffer$propagateData$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void subscribe(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        this.func = function1;
        if (this.active.get()) {
            propagateData();
        }
    }

    public final void enqueueData(T t) {
        this.events.offer(t);
        if (this.active.get()) {
            propagateData();
        }
    }
}
