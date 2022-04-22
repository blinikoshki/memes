package p015io.getstream.chat.android.client.clientstate;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.clientstate.ClientState;
import p015io.getstream.chat.android.client.clientstate.ClientStateService;
import p015io.getstream.chat.android.core.internal.fsm.FiniteStateMachine;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/client/clientstate/ClientState;", "Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "<anonymous parameter 0>", "Lio/getstream/chat/android/client/clientstate/ClientState$Idle;", "<anonymous parameter 1>", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent$DisconnectRequestedEvent;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$stateMachine$2$1$2$4 */
/* compiled from: ClientStateService.kt */
final class ClientStateService$stateMachine$2$1$2$4 extends Lambda implements Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState.Idle, ClientStateService.ClientStateEvent.DisconnectRequestedEvent, ClientState> {
    public static final ClientStateService$stateMachine$2$1$2$4 INSTANCE = new ClientStateService$stateMachine$2$1$2$4();

    ClientStateService$stateMachine$2$1$2$4() {
        super(3);
    }

    public final ClientState invoke(FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent> finiteStateMachine, ClientState.Idle idle, ClientStateService.ClientStateEvent.DisconnectRequestedEvent disconnectRequestedEvent) {
        Intrinsics.checkNotNullParameter(finiteStateMachine, "$receiver");
        Intrinsics.checkNotNullParameter(idle, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(disconnectRequestedEvent, "<anonymous parameter 1>");
        return finiteStateMachine.stay();
    }
}
