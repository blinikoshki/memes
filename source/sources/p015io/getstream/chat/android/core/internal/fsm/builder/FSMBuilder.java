package p015io.getstream.chat.android.core.internal.fsm.builder;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;
import p015io.getstream.chat.android.core.internal.fsm.FiniteStateMachine;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0000¢\u0006\u0002\b\u0015J\"\u0010\u0016\u001a\u00020\u00072\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0015\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010\u0019JC\u0010\u0018\u001a\u00020\u0007\"\n\b\u0002\u0010\u001a\u0018\u0001*\u00028\u00002)\u0010\u001b\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u001a0\u001d\u0012\u0004\u0012\u00020\u00070\u001c¢\u0006\u0002\b\u0011H\bø\u0001\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\tRr\u0010\n\u001ac\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f\u0012Q\u0012O\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\f\u0012=\u0012;\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u000ej\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0010¢\u0006\u0002\b\u00110\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, mo26107d2 = {"Lio/getstream/chat/android/core/internal/fsm/builder/FSMBuilder;", "S", "", "E", "()V", "_defaultHandler", "Lkotlin/Function2;", "", "_initialState", "Ljava/lang/Object;", "stateFunctions", "", "Lkotlin/reflect/KClass;", "", "Lkotlin/Function3;", "Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine;", "Lio/getstream/chat/android/core/internal/fsm/StateFunction;", "Lkotlin/ExtensionFunctionType;", "getStateFunctions", "()Ljava/util/Map;", "build", "build$stream_chat_android_core", "defaultHandler", "initialState", "state", "(Ljava/lang/Object;)V", "S1", "stateHandlerBuilder", "Lkotlin/Function1;", "Lio/getstream/chat/android/core/internal/fsm/builder/StateHandlerBuilder;", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@FSMBuilderMarker
/* renamed from: io.getstream.chat.android.core.internal.fsm.builder.FSMBuilder */
/* compiled from: FSMBuilder.kt */
public final class FSMBuilder<S, E> {
    private Function2<? super S, ? super E, Unit> _defaultHandler = FSMBuilder$_defaultHandler$1.INSTANCE;
    /* access modifiers changed from: private */
    public S _initialState;
    private final Map<KClass<? extends S>, Map<KClass<? extends E>, Function3<FiniteStateMachine<S, E>, S, E, S>>> stateFunctions = new LinkedHashMap();

    public static final /* synthetic */ Object access$get_initialState$p(FSMBuilder fSMBuilder) {
        S s = fSMBuilder._initialState;
        if (s == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_initialState");
        }
        return s;
    }

    public final Map<KClass<? extends S>, Map<KClass<? extends E>, Function3<FiniteStateMachine<S, E>, S, E, S>>> getStateFunctions() {
        return this.stateFunctions;
    }

    @FSMBuilderMarker
    public final void initialState(S s) {
        Intrinsics.checkNotNullParameter(s, "state");
        this._initialState = s;
    }

    @FSMBuilderMarker
    public final void defaultHandler(Function2<? super S, ? super E, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "defaultHandler");
        this._defaultHandler = function2;
    }

    @FSMBuilderMarker
    public final /* synthetic */ <S1 extends S> void state(Function1<? super StateHandlerBuilder<S, E, S1>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "stateHandlerBuilder");
        Map stateFunctions2 = getStateFunctions();
        Intrinsics.reifiedOperationMarker(4, "S1");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        StateHandlerBuilder stateHandlerBuilder = new StateHandlerBuilder();
        function1.invoke(stateHandlerBuilder);
        stateFunctions2.put(orCreateKotlinClass, stateHandlerBuilder.get());
    }

    public final FiniteStateMachine<S, E> build$stream_chat_android_core() {
        if (this._initialState != null) {
            S s = this._initialState;
            if (s == null) {
                Intrinsics.throwUninitializedPropertyAccessException("_initialState");
            }
            return new FiniteStateMachine<>(s, this.stateFunctions, this._defaultHandler);
        }
        throw new IllegalStateException("Initial state must be set!".toString());
    }
}
