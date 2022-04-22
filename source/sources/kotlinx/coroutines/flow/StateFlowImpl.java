package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010052\b\u0012\u0004\u0012\u00028\u0000062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u000008B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010\u000fR\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000*8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u000e¢\u0006\u0012\u0012\u0004\b3\u0010$\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u00064"}, mo26107d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, mo26108k = 1, mo26109mv = {1, 4, 0})
/* compiled from: StateFlow.kt */
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private volatile Object _state;
    private int sequence;

    public static /* synthetic */ void getValue$annotations() {
    }

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    public T getValue() {
        T t = NullSurrogateKt.NULL;
        T t2 = this._state;
        if (t2 == t) {
            return null;
        }
        return t2;
    }

    public void setValue(T t) {
        if (t == null) {
            t = NullSurrogateKt.NULL;
        }
        updateState((Object) null, t);
    }

    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = NullSurrogateKt.NULL;
        }
        if (t2 == null) {
            t2 = NullSurrogateKt.NULL;
        }
        return updateState(t, t2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r8 == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        r0 = r8.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        if (r3 >= r0) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        r4 = r8[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r4 == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        r4.makePending();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r8 = r6.sequence;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
        if (r8 != r7) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
        r6.sequence = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r7 = (kotlinx.coroutines.flow.StateFlowSlot[]) getSlots();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0054, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0055, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean updateState(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r0 = r6.getSlots()
            kotlinx.coroutines.flow.StateFlowSlot[] r0 = (kotlinx.coroutines.flow.StateFlowSlot[]) r0
            monitor-enter(r6)
            java.lang.Object r0 = r6._state     // Catch:{ all -> 0x0062 }
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0016
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)     // Catch:{ all -> 0x0062 }
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x0016
            monitor-exit(r6)
            return r1
        L_0x0016:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)     // Catch:{ all -> 0x0062 }
            if (r7 == 0) goto L_0x001e
            monitor-exit(r6)
            return r2
        L_0x001e:
            r6._state = r8     // Catch:{ all -> 0x0062 }
            int r7 = r6.sequence     // Catch:{ all -> 0x0062 }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x005c
            int r7 = r7 + r2
            r6.sequence = r7     // Catch:{ all -> 0x0062 }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r8 = r6.getSlots()     // Catch:{ all -> 0x0062 }
            kotlinx.coroutines.flow.StateFlowSlot[] r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8     // Catch:{ all -> 0x0062 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0062 }
            monitor-exit(r6)
        L_0x0032:
            if (r8 == 0) goto L_0x0042
            int r0 = r8.length
            r3 = 0
        L_0x0036:
            if (r3 >= r0) goto L_0x0042
            r4 = r8[r3]
            if (r4 == 0) goto L_0x003f
            r4.makePending()
        L_0x003f:
            int r3 = r3 + 1
            goto L_0x0036
        L_0x0042:
            monitor-enter(r6)
            int r8 = r6.sequence     // Catch:{ all -> 0x0059 }
            if (r8 != r7) goto L_0x004c
            int r7 = r7 + r2
            r6.sequence = r7     // Catch:{ all -> 0x0059 }
            monitor-exit(r6)
            return r2
        L_0x004c:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r7 = r6.getSlots()     // Catch:{ all -> 0x0059 }
            kotlinx.coroutines.flow.StateFlowSlot[] r7 = (kotlinx.coroutines.flow.StateFlowSlot[]) r7     // Catch:{ all -> 0x0059 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0059 }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0032
        L_0x0059:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x005c:
            int r7 = r7 + 2
            r6.sequence = r7     // Catch:{ all -> 0x0062 }
            monitor-exit(r6)
            return r2
        L_0x0062:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.updateState(java.lang.Object, java.lang.Object):boolean");
    }

    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }

    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: kotlinx.coroutines.flow.StateFlowSlot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: kotlinx.coroutines.flow.StateFlowImpl} */
    /* JADX WARNING: type inference failed for: r13v9, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c1 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c3 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8 A[Catch:{ all -> 0x0078 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d9 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e1 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x007b
            if (r2 == r6) goto L_0x0066
            if (r2 == r5) goto L_0x004d
            if (r2 != r4) goto L_0x0045
            java.lang.Object r12 = r0.L$5
            java.lang.Object r12 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r7 = (kotlinx.coroutines.flow.StateFlowSlot) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r9 = (kotlinx.coroutines.flow.StateFlowImpl) r9
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0078 }
            goto L_0x00ad
        L_0x0045:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x004d:
            java.lang.Object r12 = r0.L$5
            java.lang.Object r2 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r7 = (kotlinx.coroutines.flow.StateFlowSlot) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r9 = (kotlinx.coroutines.flow.StateFlowImpl) r9
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0078 }
            goto L_0x00da
        L_0x0066:
            java.lang.Object r12 = r0.L$2
            r7 = r12
            kotlinx.coroutines.flow.StateFlowSlot r7 = (kotlinx.coroutines.flow.StateFlowSlot) r7
            java.lang.Object r12 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r12 = (kotlinx.coroutines.flow.FlowCollector) r12
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlinx.coroutines.flow.StateFlowImpl r9 = (kotlinx.coroutines.flow.StateFlowImpl) r9
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0078 }
            goto L_0x009c
        L_0x0078:
            r12 = move-exception
            goto L_0x00f8
        L_0x007b:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r13 = r11.allocateSlot()
            r7 = r13
            kotlinx.coroutines.flow.StateFlowSlot r7 = (kotlinx.coroutines.flow.StateFlowSlot) r7
            boolean r13 = r12 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00f6 }
            if (r13 == 0) goto L_0x009b
            r13 = r12
            kotlinx.coroutines.flow.SubscribedFlowCollector r13 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r13     // Catch:{ all -> 0x00f6 }
            r0.L$0 = r11     // Catch:{ all -> 0x00f6 }
            r0.L$1 = r12     // Catch:{ all -> 0x00f6 }
            r0.L$2 = r7     // Catch:{ all -> 0x00f6 }
            r0.label = r6     // Catch:{ all -> 0x00f6 }
            java.lang.Object r13 = r13.onSubscription(r0)     // Catch:{ all -> 0x00f6 }
            if (r13 != r1) goto L_0x009b
            return r1
        L_0x009b:
            r9 = r11
        L_0x009c:
            kotlin.coroutines.CoroutineContext r13 = r0.getContext()     // Catch:{ all -> 0x0078 }
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x0078 }
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2     // Catch:{ all -> 0x0078 }
            kotlin.coroutines.CoroutineContext$Element r13 = r13.get(r2)     // Catch:{ all -> 0x0078 }
            kotlinx.coroutines.Job r13 = (kotlinx.coroutines.Job) r13     // Catch:{ all -> 0x0078 }
            r8 = r12
            r2 = r13
            r12 = r3
        L_0x00ad:
            java.lang.Object r13 = r9._state     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x00b4
            kotlinx.coroutines.JobKt.ensureActive((kotlinx.coroutines.Job) r2)     // Catch:{ all -> 0x0078 }
        L_0x00b4:
            if (r12 == 0) goto L_0x00bd
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)     // Catch:{ all -> 0x0078 }
            r10 = r10 ^ r6
            if (r10 == 0) goto L_0x00db
        L_0x00bd:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ all -> 0x0078 }
            if (r13 != r10) goto L_0x00c3
            r10 = r3
            goto L_0x00c4
        L_0x00c3:
            r10 = r13
        L_0x00c4:
            r0.L$0 = r9     // Catch:{ all -> 0x0078 }
            r0.L$1 = r8     // Catch:{ all -> 0x0078 }
            r0.L$2 = r7     // Catch:{ all -> 0x0078 }
            r0.L$3 = r2     // Catch:{ all -> 0x0078 }
            r0.L$4 = r12     // Catch:{ all -> 0x0078 }
            r0.L$5 = r13     // Catch:{ all -> 0x0078 }
            r0.label = r5     // Catch:{ all -> 0x0078 }
            java.lang.Object r12 = r8.emit(r10, r0)     // Catch:{ all -> 0x0078 }
            if (r12 != r1) goto L_0x00d9
            return r1
        L_0x00d9:
            r12 = r13
        L_0x00da:
            r13 = r12
        L_0x00db:
            boolean r10 = r7.takePending()     // Catch:{ all -> 0x0078 }
            if (r10 != 0) goto L_0x00ad
            r0.L$0 = r9     // Catch:{ all -> 0x0078 }
            r0.L$1 = r8     // Catch:{ all -> 0x0078 }
            r0.L$2 = r7     // Catch:{ all -> 0x0078 }
            r0.L$3 = r2     // Catch:{ all -> 0x0078 }
            r0.L$4 = r12     // Catch:{ all -> 0x0078 }
            r0.L$5 = r13     // Catch:{ all -> 0x0078 }
            r0.label = r4     // Catch:{ all -> 0x0078 }
            java.lang.Object r13 = r7.awaitPending(r0)     // Catch:{ all -> 0x0078 }
            if (r13 != r1) goto L_0x00ad
            return r1
        L_0x00f6:
            r12 = move-exception
            r9 = r11
        L_0x00f8:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r7 = (kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot) r7
            r9.freeSlot(r7)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* access modifiers changed from: protected */
    public StateFlowSlot[] createSlotArray(int i) {
        return new StateFlowSlot[i];
    }

    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }
}
