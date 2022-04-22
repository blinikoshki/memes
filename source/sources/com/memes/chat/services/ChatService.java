package com.memes.chat.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import androidx.lifecycle.Observer;
import com.memes.chat.events.ChatEventCourier;
import com.memes.chat.events.custom.DeclaredChatEvent;
import com.memes.chat.events.custom.TotalUnreadCountEvent;
import com.memes.chat.p035db.ChatDatabase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.ChatEventListener;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.events.HealthEvent;
import p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent;
import p015io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent;
import p015io.getstream.chat.android.client.events.NotificationMarkReadEvent;
import p015io.getstream.chat.android.client.events.NotificationMessageNewEvent;
import p015io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.observable.Disposable;
import p015io.getstream.chat.android.livedata.ChatDomain;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0019\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0006\u0010&\u001a\u00020\u001aJ\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\b\u0010,\u001a\u00020%H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, mo26107d2 = {"Lcom/memes/chat/services/ChatService;", "Lcom/memes/chat/services/CoroutineLifecycleService;", "()V", "binder", "Lcom/memes/chat/services/ChatService$ChatBinder;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "getChatClient", "()Lio/getstream/chat/android/client/ChatClient;", "chatClient$delegate", "Lkotlin/Lazy;", "chatDatabase", "Lcom/memes/chat/db/ChatDatabase;", "getChatDatabase", "()Lcom/memes/chat/db/ChatDatabase;", "chatDatabase$delegate", "chatDomain", "Lio/getstream/chat/android/livedata/ChatDomain;", "getChatDomain", "()Lio/getstream/chat/android/livedata/ChatDomain;", "chatDomain$delegate", "chatEventListenerDisposable", "Lio/getstream/chat/android/client/utils/observable/Disposable;", "latestUnreadCount", "", "handleAddedToChannelNotificationEvent", "", "event", "Lio/getstream/chat/android/client/events/NotificationAddedToChannelEvent;", "handleChatEvent", "Lio/getstream/chat/android/client/events/ChatEvent;", "(Lio/getstream/chat/android/client/events/ChatEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleConnectedEvent", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "isMe", "", "user", "Lio/getstream/chat/android/client/models/User;", "notifyServiceBound", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "requireCurrentUser", "ChatBinder", "Connection", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatService.kt */
public final class ChatService extends CoroutineLifecycleService {
    private final ChatBinder binder;
    private final Lazy chatClient$delegate = LazyKt.lazy(ChatService$chatClient$2.INSTANCE);
    private final Lazy chatDatabase$delegate = LazyKt.lazy(new ChatService$chatDatabase$2(this));
    private final Lazy chatDomain$delegate = LazyKt.lazy(ChatService$chatDomain$2.INSTANCE);
    private Disposable chatEventListenerDisposable;
    /* access modifiers changed from: private */
    public int latestUnreadCount;

    private final ChatClient getChatClient() {
        return (ChatClient) this.chatClient$delegate.getValue();
    }

    private final ChatDatabase getChatDatabase() {
        return (ChatDatabase) this.chatDatabase$delegate.getValue();
    }

    private final ChatDomain getChatDomain() {
        return (ChatDomain) this.chatDomain$delegate.getValue();
    }

    public ChatService() {
        Timber.m303e("~> chat-service initialized.", new Object[0]);
        if (ChatClient.Companion.isInitialized()) {
            Disposable disposable = this.chatEventListenerDisposable;
            if (disposable != null) {
                disposable.dispose();
            }
            this.chatEventListenerDisposable = getChatClient().subscribe((ChatEventListener<ChatEvent>) new ChatEventListener<ChatEvent>(this) {
                final /* synthetic */ ChatService this$0;

                {
                    this.this$0 = r1;
                }

                @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
                @DebugMetadata(mo26807c = "com.memes.chat.services.ChatService$1$1", mo26808f = "ChatService.kt", mo26809i = {}, mo26810l = {47}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
                /* renamed from: com.memes.chat.services.ChatService$1$1 */
                /* compiled from: ChatService.kt */
                static final class C40791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ C40781 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Intrinsics.checkNotNullParameter(continuation, "completion");
                        return new C40791(this.this$0, chatEvent, continuation);
                    }

                    public final Object invoke(Object obj, Object obj2) {
                        return ((C40791) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            ChatService chatService = this.this$0.this$0;
                            ChatEvent chatEvent = chatEvent;
                            this.label = 1;
                            if (chatService.handleChatEvent(chatEvent, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }

                public final void onEvent(final ChatEvent chatEvent) {
                    Intrinsics.checkNotNullParameter(chatEvent, "event");
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.this$0, (CoroutineContext) null, (CoroutineStart) null, new C40791(this, (Continuation) null), 3, (Object) null);
                }
            });
            getChatDomain().getTotalUnreadCount().observe(this, new Observer<Integer>(this) {
                final /* synthetic */ ChatService this$0;

                {
                    this.this$0 = r1;
                }

                public final void onChanged(Integer num) {
                    ChatService chatService = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(num, "count");
                    chatService.latestUnreadCount = num.intValue();
                    ChatEventCourier.INSTANCE.post((DeclaredChatEvent) new TotalUnreadCountEvent(this.this$0.latestUnreadCount));
                }
            });
            this.binder = new ChatBinder();
            return;
        }
        throw new RuntimeException("Chat Client is not initialized.");
    }

    public final void notifyServiceBound() {
        Timber.m306i("~> chat-service bound.", new Object[0]);
        if (this.latestUnreadCount == 0) {
            this.latestUnreadCount = requireCurrentUser().getTotalUnreadCount();
        }
        ChatEventCourier.INSTANCE.post((DeclaredChatEvent) new TotalUnreadCountEvent(this.latestUnreadCount));
    }

    public void onDestroy() {
        Disposable disposable = this.chatEventListenerDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Timber.m303e("~> chat-service destroyed.", new Object[0]);
        super.onDestroy();
    }

    private final User requireCurrentUser() {
        User currentUser = ChatDomain.Companion.instance().getCurrentUser();
        if (currentUser != null) {
            return currentUser;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final boolean isMe(User user) {
        return user != null && Intrinsics.areEqual((Object) user.getId(), (Object) requireCurrentUser().getId());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object handleChatEvent(ChatEvent chatEvent, Continuation<? super Unit> continuation) {
        Timber.m300d("\n\n ~> chat-event received: " + chatEvent.getClass().getSimpleName() + " - " + chatEvent.getType(), new Object[0]);
        if (!(chatEvent instanceof HealthEvent) && !(chatEvent instanceof NotificationMessageNewEvent) && !(chatEvent instanceof NotificationMarkReadEvent)) {
            if (chatEvent instanceof ConnectedEvent) {
                handleConnectedEvent((ConnectedEvent) chatEvent);
            } else if (chatEvent instanceof NotificationAddedToChannelEvent) {
                handleAddedToChannelNotificationEvent((NotificationAddedToChannelEvent) chatEvent);
            } else if (chatEvent instanceof NotificationMutesUpdatedEvent) {
                getChatDatabase().getMutedUsersDao().replaceMutes(((NotificationMutesUpdatedEvent) chatEvent).getMe().getMutes());
            } else if (chatEvent instanceof NotificationChannelMutesUpdatedEvent) {
                getChatDatabase().getMutedChannelsDao().replaceChannelMutes(((NotificationChannelMutesUpdatedEvent) chatEvent).getMe().getChannelMutes());
            } else {
                ChatEventCourier.INSTANCE.post(chatEvent);
            }
        }
        return Unit.INSTANCE;
    }

    private final void handleConnectedEvent(ConnectedEvent connectedEvent) {
        this.latestUnreadCount = connectedEvent.getMe().getTotalUnreadCount();
        ChatEventCourier.INSTANCE.post((DeclaredChatEvent) new TotalUnreadCountEvent(this.latestUnreadCount));
    }

    private final void handleAddedToChannelNotificationEvent(NotificationAddedToChannelEvent notificationAddedToChannelEvent) {
        int i = this.latestUnreadCount;
        if (i == 0) {
            this.latestUnreadCount = i + 1;
            ChatEventCourier.INSTANCE.post((DeclaredChatEvent) new TotalUnreadCountEvent(this.latestUnreadCount));
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, mo26107d2 = {"Lcom/memes/chat/services/ChatService$Connection;", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "className", "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "chatService", "Lcom/memes/chat/services/ChatService;", "onServiceDisconnected", "arg0", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatService.kt */
    public interface Connection extends ServiceConnection {
        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceConnected(ChatService chatService);

        void onServiceDisconnected();

        void onServiceDisconnected(ComponentName componentName);

        @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
        /* compiled from: ChatService.kt */
        public static final class DefaultImpls {
            public static void onServiceConnected(Connection connection, ChatService chatService) {
                Intrinsics.checkNotNullParameter(chatService, "chatService");
            }

            public static void onServiceDisconnected(Connection connection) {
            }

            public static void onServiceConnected(Connection connection, ComponentName componentName, IBinder iBinder) {
                Intrinsics.checkNotNullParameter(componentName, "className");
                Intrinsics.checkNotNullParameter(iBinder, "binder");
                ChatService service = ((ChatBinder) iBinder).getService();
                service.notifyServiceBound();
                connection.onServiceConnected(service);
            }

            public static void onServiceDisconnected(Connection connection, ComponentName componentName) {
                Intrinsics.checkNotNullParameter(componentName, "arg0");
                connection.onServiceDisconnected();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onBind(intent);
        return this.binder;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/services/ChatService$ChatBinder;", "Landroid/os/Binder;", "(Lcom/memes/chat/services/ChatService;)V", "getService", "Lcom/memes/chat/services/ChatService;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatService.kt */
    public final class ChatBinder extends Binder {
        public ChatBinder() {
        }

        public final ChatService getService() {
            return ChatService.this;
        }
    }
}
