package p015io.getstream.chat.android.core.internal.fsm;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;
import p015io.getstream.chat.android.core.internal.fsm.builder.FSMBuilder;
import p015io.getstream.chat.android.core.internal.fsm.builder.FSMBuilderMarker;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001\u001fB\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012g\u0010\u0005\u001ac\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012Q\u0012O\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0007\u0012=\u0012;\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0002\b\n0\u00060\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00028\u0001¢\u0006\u0002\u0010\u0018J\u000b\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J)\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0002\u0010\u001b*\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001dHHø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0010\u0010\u000f\u001a\u00028\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0010R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015Ro\u0010\u0005\u001ac\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012Q\u0012O\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0007\u0012=\u0012;\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0002\b\n0\u00060\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, mo26107d2 = {"Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine;", "S", "", "E", "initialState", "stateFunctions", "", "Lkotlin/reflect/KClass;", "Lkotlin/Function3;", "Lio/getstream/chat/android/core/internal/fsm/StateFunction;", "Lkotlin/ExtensionFunctionType;", "defaultEventHandler", "Lkotlin/Function2;", "", "(Ljava/lang/Object;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "_state", "Ljava/lang/Object;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "state", "getState", "()Ljava/lang/Object;", "sendEvent", "event", "(Ljava/lang/Object;)V", "stay", "withLockIfNotLocked", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.core.internal.fsm.FiniteStateMachine */
/* compiled from: FiniteStateMachine.kt */
public final class FiniteStateMachine<S, E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public S _state;
    /* access modifiers changed from: private */
    public final Function2<S, E, Unit> defaultEventHandler;
    /* access modifiers changed from: private */
    public final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    /* access modifiers changed from: private */
    public final Map<KClass<? extends S>, Map<KClass<? extends E>, Function3<FiniteStateMachine<S, E>, S, E, S>>> stateFunctions;

    public FiniteStateMachine(S s, Map<KClass<? extends S>, ? extends Map<KClass<? extends E>, ? extends Function3<? super FiniteStateMachine<S, E>, ? super S, ? super E, ? extends S>>> map, Function2<? super S, ? super E, Unit> function2) {
        Intrinsics.checkNotNullParameter(s, "initialState");
        Intrinsics.checkNotNullParameter(map, "stateFunctions");
        Intrinsics.checkNotNullParameter(function2, "defaultEventHandler");
        this.stateFunctions = map;
        this.defaultEventHandler = function2;
        this._state = s;
    }

    private final /* synthetic */ <T> Object withLockIfNotLocked(Mutex mutex2, Function0<? extends T> function0, Continuation<? super T> continuation) {
        if (mutex2.isLocked()) {
            return function0.invoke();
        }
        InlineMarker.mark(0);
        mutex2.lock((Object) null, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex2.unlock((Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    public final S getState() {
        return BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new FiniteStateMachine$state$1(this, (Continuation) null), 1, (Object) null);
    }

    public final void sendEvent(E e) {
        Intrinsics.checkNotNullParameter(e, "event");
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new FiniteStateMachine$sendEvent$1(this, e, (Continuation) null), 1, (Object) null);
    }

    public final S stay() {
        return getState();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0001\"\b\b\u0003\u0010\u0006*\u00020\u00012#\u0010\u0007\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0002¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine$Companion;", "", "()V", "invoke", "Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine;", "S", "E", "builder", "Lkotlin/Function1;", "Lio/getstream/chat/android/core/internal/fsm/builder/FSMBuilder;", "", "Lkotlin/ExtensionFunctionType;", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.core.internal.fsm.FiniteStateMachine$Companion */
    /* compiled from: FiniteStateMachine.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @FSMBuilderMarker
        public final <S, E> FiniteStateMachine<S, E> invoke(Function1<? super FSMBuilder<S, E>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builder");
            FSMBuilder fSMBuilder = new FSMBuilder();
            function1.invoke(fSMBuilder);
            return fSMBuilder.build$stream_chat_android_core();
        }
    }
}
