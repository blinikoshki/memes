package p015io.getstream.chat.android.core.internal.fsm.builder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;
import p015io.getstream.chat.android.core.internal.fsm.FiniteStateMachine;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u0002H\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0005JU\u0010\u000f\u001aO\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\b\u0012=\u0012;\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0011¢\u0006\u0002\b\u000b0\u0010H\u0001JK\u0010\u0012\u001a\u00020\u0013\"\n\b\u0003\u0010\u0014\u0018\u0001*\u00028\u000121\b\b\u0010\u0015\u001a+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\u000bH\bø\u0001\u0000RY\u0010\u0006\u001a?\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\b\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\u000b0\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/core/internal/fsm/builder/StateHandlerBuilder;", "S", "", "E", "S1", "()V", "eventHandlers", "", "Lkotlin/reflect/KClass;", "Lkotlin/Function3;", "Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine;", "Lkotlin/ExtensionFunctionType;", "getEventHandlers$annotations", "getEventHandlers", "()Ljava/util/Map;", "get", "", "Lio/getstream/chat/android/core/internal/fsm/StateFunction;", "onEvent", "", "E1", "func", "stream-chat-android-core"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@FSMBuilderMarker
/* renamed from: io.getstream.chat.android.core.internal.fsm.builder.StateHandlerBuilder */
/* compiled from: StateHandlerBuilder.kt */
public final class StateHandlerBuilder<S, E, S1 extends S> {
    private final Map<KClass<? extends E>, Function3<FiniteStateMachine<S, E>, S1, E, S>> eventHandlers = new LinkedHashMap();

    public static /* synthetic */ void getEventHandlers$annotations() {
    }

    public final Map<KClass<? extends E>, Function3<FiniteStateMachine<S, E>, S1, E, S>> getEventHandlers() {
        return this.eventHandlers;
    }

    @FSMBuilderMarker
    public final /* synthetic */ <E1 extends E> void onEvent(Function3<? super FiniteStateMachine<S, E>, ? super S1, ? super E1, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(function3, "func");
        Map eventHandlers2 = getEventHandlers();
        Intrinsics.reifiedOperationMarker(4, "E1");
        eventHandlers2.put(Reflection.getOrCreateKotlinClass(Object.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3));
    }

    public final Map<KClass<? extends E>, Function3<FiniteStateMachine<S, E>, S, E, S>> get() {
        Map<KClass<? extends E>, Function3<FiniteStateMachine<S, E>, S1, E, S>> map = this.eventHandlers;
        Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.reflect.KClass<out E>, io.getstream.chat.android.core.internal.fsm.StateFunction<S, E> /* = io.getstream.chat.android.core.internal.fsm.FiniteStateMachine<S, E>.(S, E) -> S */>");
        return map;
    }
}
