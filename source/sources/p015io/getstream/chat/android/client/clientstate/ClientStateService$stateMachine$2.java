package p015io.getstream.chat.android.client.clientstate;

import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import p015io.getstream.chat.android.client.clientstate.ClientState;
import p015io.getstream.chat.android.client.clientstate.ClientStateService;
import p015io.getstream.chat.android.core.internal.fsm.FiniteStateMachine;
import p015io.getstream.chat.android.core.internal.fsm.builder.FSMBuilder;
import p015io.getstream.chat.android.core.internal.fsm.builder.StateHandlerBuilder;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lio/getstream/chat/android/core/internal/fsm/FiniteStateMachine;", "Lio/getstream/chat/android/client/clientstate/ClientState;", "Lio/getstream/chat/android/client/clientstate/ClientStateService$ClientStateEvent;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.clientstate.ClientStateService$stateMachine$2 */
/* compiled from: ClientStateService.kt */
final class ClientStateService$stateMachine$2 extends Lambda implements Function0<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>> {
    final /* synthetic */ ClientStateService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClientStateService$stateMachine$2(ClientStateService clientStateService) {
        super(0);
        this.this$0 = clientStateService;
    }

    public final FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent> invoke() {
        return FiniteStateMachine.Companion.invoke(new Function1<FSMBuilder<ClientState, ClientStateService.ClientStateEvent>, Unit>(this) {
            final /* synthetic */ ClientStateService$stateMachine$2 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FSMBuilder<ClientState, ClientStateService.ClientStateEvent>) (FSMBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FSMBuilder<ClientState, ClientStateService.ClientStateEvent> fSMBuilder) {
                Intrinsics.checkNotNullParameter(fSMBuilder, "$receiver");
                fSMBuilder.initialState(ClientState.Idle.INSTANCE);
                fSMBuilder.defaultHandler(new Function2<ClientState, ClientStateService.ClientStateEvent, Unit>(this) {
                    final /* synthetic */ C49501 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((ClientState) obj, (ClientStateService.ClientStateEvent) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ClientState clientState, ClientStateService.ClientStateEvent clientStateEvent) {
                        Intrinsics.checkNotNullParameter(clientState, "state");
                        Intrinsics.checkNotNullParameter(clientStateEvent, "event");
                        Void unused = this.this$0.this$0.this$0.failedToHandleEvent(clientState, clientStateEvent);
                        throw new KotlinNothingValueException();
                    }
                });
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClientState.Idle.class);
                StateHandlerBuilder stateHandlerBuilder = new StateHandlerBuilder();
                stateHandlerBuilder.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.SetUserEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$2$1.INSTANCE, 3));
                stateHandlerBuilder.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.SetAnonymousUserEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$2$2.INSTANCE, 3));
                stateHandlerBuilder.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$2$3.INSTANCE, 3));
                stateHandlerBuilder.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$2$4.INSTANCE, 3));
                stateHandlerBuilder.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.ConnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$2$5.INSTANCE, 3));
                Unit unit = Unit.INSTANCE;
                stateFunctions.put(orCreateKotlinClass, stateHandlerBuilder.get());
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions2 = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ClientState.User.Pending.WithoutToken.class);
                StateHandlerBuilder stateHandlerBuilder2 = new StateHandlerBuilder();
                stateHandlerBuilder2.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.TokenReceivedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$3$1.INSTANCE, 3));
                stateHandlerBuilder2.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$3$2.INSTANCE, 3));
                stateHandlerBuilder2.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$3$3.INSTANCE, 3));
                Unit unit2 = Unit.INSTANCE;
                stateFunctions2.put(orCreateKotlinClass2, stateHandlerBuilder2.get());
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions3 = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(ClientState.User.Pending.WithToken.class);
                StateHandlerBuilder stateHandlerBuilder3 = new StateHandlerBuilder();
                stateHandlerBuilder3.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.ConnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$4$1.INSTANCE, 3));
                stateHandlerBuilder3.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$4$2.INSTANCE, 3));
                stateHandlerBuilder3.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$4$3.INSTANCE, 3));
                Unit unit3 = Unit.INSTANCE;
                stateFunctions3.put(orCreateKotlinClass3, stateHandlerBuilder3.get());
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions4 = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(ClientState.User.Authorized.Connected.class);
                StateHandlerBuilder stateHandlerBuilder4 = new StateHandlerBuilder();
                stateHandlerBuilder4.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$5$1.INSTANCE, 3));
                stateHandlerBuilder4.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$5$2.INSTANCE, 3));
                stateHandlerBuilder4.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.ConnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$5$3.INSTANCE, 3));
                Unit unit4 = Unit.INSTANCE;
                stateFunctions4.put(orCreateKotlinClass4, stateHandlerBuilder4.get());
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions5 = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(ClientState.User.Authorized.Disconnected.class);
                StateHandlerBuilder stateHandlerBuilder5 = new StateHandlerBuilder();
                stateHandlerBuilder5.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$6$1.INSTANCE, 3));
                stateHandlerBuilder5.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$6$2.INSTANCE, 3));
                stateHandlerBuilder5.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.ConnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$6$3.INSTANCE, 3));
                Unit unit5 = Unit.INSTANCE;
                stateFunctions5.put(orCreateKotlinClass5, stateHandlerBuilder5.get());
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions6 = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(ClientState.Anonymous.Pending.WithoutToken.class);
                StateHandlerBuilder stateHandlerBuilder6 = new StateHandlerBuilder();
                stateHandlerBuilder6.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.TokenReceivedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$7$1.INSTANCE, 3));
                stateHandlerBuilder6.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$7$2.INSTANCE, 3));
                stateHandlerBuilder6.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$7$3.INSTANCE, 3));
                Unit unit6 = Unit.INSTANCE;
                stateFunctions6.put(orCreateKotlinClass6, stateHandlerBuilder6.get());
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions7 = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(ClientState.Anonymous.Pending.WithToken.class);
                StateHandlerBuilder stateHandlerBuilder7 = new StateHandlerBuilder();
                stateHandlerBuilder7.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.ConnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$8$1.INSTANCE, 3));
                stateHandlerBuilder7.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$8$2.INSTANCE, 3));
                stateHandlerBuilder7.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$8$3.INSTANCE, 3));
                Unit unit7 = Unit.INSTANCE;
                stateFunctions7.put(orCreateKotlinClass7, stateHandlerBuilder7.get());
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions8 = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(ClientState.Anonymous.Authorized.Connected.class);
                StateHandlerBuilder stateHandlerBuilder8 = new StateHandlerBuilder();
                stateHandlerBuilder8.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$9$1.INSTANCE, 3));
                stateHandlerBuilder8.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$9$2.INSTANCE, 3));
                stateHandlerBuilder8.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.ConnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$9$3.INSTANCE, 3));
                Unit unit8 = Unit.INSTANCE;
                stateFunctions8.put(orCreateKotlinClass8, stateHandlerBuilder8.get());
                Map<KClass<? extends ClientState>, Map<KClass<? extends ClientStateService.ClientStateEvent>, Function3<FiniteStateMachine<ClientState, ClientStateService.ClientStateEvent>, ClientState, ClientStateService.ClientStateEvent, ClientState>>> stateFunctions9 = fSMBuilder.getStateFunctions();
                KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(ClientState.Anonymous.Authorized.Disconnected.class);
                StateHandlerBuilder stateHandlerBuilder9 = new StateHandlerBuilder();
                stateHandlerBuilder9.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$10$1.INSTANCE, 3));
                stateHandlerBuilder9.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.DisconnectRequestedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$10$2.INSTANCE, 3));
                stateHandlerBuilder9.getEventHandlers().put(Reflection.getOrCreateKotlinClass(ClientStateService.ClientStateEvent.ConnectedEvent.class), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(ClientStateService$stateMachine$2$1$10$3.INSTANCE, 3));
                Unit unit9 = Unit.INSTANCE;
                stateFunctions9.put(orCreateKotlinClass9, stateHandlerBuilder9.get());
            }
        });
    }
}
