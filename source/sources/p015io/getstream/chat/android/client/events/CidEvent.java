package p015io.getstream.chat.android.client.events;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u001f\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%¨\u0006&"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/CidEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "()V", "cid", "", "getCid", "()Ljava/lang/String;", "Lio/getstream/chat/android/client/events/ChannelCreatedEvent;", "Lio/getstream/chat/android/client/events/ChannelDeletedEvent;", "Lio/getstream/chat/android/client/events/ChannelHiddenEvent;", "Lio/getstream/chat/android/client/events/ChannelTruncatedEvent;", "Lio/getstream/chat/android/client/events/ChannelUpdatedEvent;", "Lio/getstream/chat/android/client/events/ChannelUpdatedByUserEvent;", "Lio/getstream/chat/android/client/events/ChannelVisibleEvent;", "Lio/getstream/chat/android/client/events/MemberAddedEvent;", "Lio/getstream/chat/android/client/events/MemberRemovedEvent;", "Lio/getstream/chat/android/client/events/MemberUpdatedEvent;", "Lio/getstream/chat/android/client/events/MessageDeletedEvent;", "Lio/getstream/chat/android/client/events/MessageReadEvent;", "Lio/getstream/chat/android/client/events/MessageUpdatedEvent;", "Lio/getstream/chat/android/client/events/NewMessageEvent;", "Lio/getstream/chat/android/client/events/NotificationAddedToChannelEvent;", "Lio/getstream/chat/android/client/events/NotificationChannelDeletedEvent;", "Lio/getstream/chat/android/client/events/NotificationChannelTruncatedEvent;", "Lio/getstream/chat/android/client/events/NotificationInviteAcceptedEvent;", "Lio/getstream/chat/android/client/events/NotificationInvitedEvent;", "Lio/getstream/chat/android/client/events/NotificationMarkReadEvent;", "Lio/getstream/chat/android/client/events/NotificationMessageNewEvent;", "Lio/getstream/chat/android/client/events/NotificationRemovedFromChannelEvent;", "Lio/getstream/chat/android/client/events/ReactionDeletedEvent;", "Lio/getstream/chat/android/client/events/ReactionNewEvent;", "Lio/getstream/chat/android/client/events/ReactionUpdateEvent;", "Lio/getstream/chat/android/client/events/TypingStartEvent;", "Lio/getstream/chat/android/client/events/TypingStopEvent;", "Lio/getstream/chat/android/client/events/ChannelUserBannedEvent;", "Lio/getstream/chat/android/client/events/UserStartWatchingEvent;", "Lio/getstream/chat/android/client/events/UserStopWatchingEvent;", "Lio/getstream/chat/android/client/events/ChannelUserUnbannedEvent;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.CidEvent */
/* compiled from: ChatEvent.kt */
public abstract class CidEvent extends ChatEvent {
    public abstract String getCid();

    private CidEvent() {
        super((DefaultConstructorMarker) null);
    }

    public /* synthetic */ CidEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
