package p015io.getstream.chat.android.client.events;

import java.util.Date;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0017\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ChatEvent;", "", "()V", "createdAt", "Ljava/util/Date;", "getCreatedAt", "()Ljava/util/Date;", "type", "", "getType", "()Ljava/lang/String;", "Lio/getstream/chat/android/client/events/CidEvent;", "Lio/getstream/chat/android/client/events/ChannelMuteEvent;", "Lio/getstream/chat/android/client/events/ChannelsMuteEvent;", "Lio/getstream/chat/android/client/events/ChannelUnmuteEvent;", "Lio/getstream/chat/android/client/events/ChannelsUnmuteEvent;", "Lio/getstream/chat/android/client/events/HealthEvent;", "Lio/getstream/chat/android/client/events/NotificationChannelMutesUpdatedEvent;", "Lio/getstream/chat/android/client/events/MarkAllReadEvent;", "Lio/getstream/chat/android/client/events/NotificationMutesUpdatedEvent;", "Lio/getstream/chat/android/client/events/GlobalUserBannedEvent;", "Lio/getstream/chat/android/client/events/UserDeletedEvent;", "Lio/getstream/chat/android/client/events/UserMutedEvent;", "Lio/getstream/chat/android/client/events/UsersMutedEvent;", "Lio/getstream/chat/android/client/events/UserPresenceChangedEvent;", "Lio/getstream/chat/android/client/events/GlobalUserUnbannedEvent;", "Lio/getstream/chat/android/client/events/UserUnmutedEvent;", "Lio/getstream/chat/android/client/events/UsersUnmutedEvent;", "Lio/getstream/chat/android/client/events/UserUpdatedEvent;", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "Lio/getstream/chat/android/client/events/ConnectingEvent;", "Lio/getstream/chat/android/client/events/DisconnectedEvent;", "Lio/getstream/chat/android/client/events/ErrorEvent;", "Lio/getstream/chat/android/client/events/UnknownEvent;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ChatEvent */
/* compiled from: ChatEvent.kt */
public abstract class ChatEvent {
    public abstract Date getCreatedAt();

    public abstract String getType();

    private ChatEvent() {
    }

    public /* synthetic */ ChatEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
