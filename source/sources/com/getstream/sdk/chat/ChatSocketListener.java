package com.getstream.sdk.chat;

import com.getstream.sdk.chat.enums.OnlineStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.events.ChannelCreatedEvent;
import p015io.getstream.chat.android.client.events.ChannelDeletedEvent;
import p015io.getstream.chat.android.client.events.ChannelHiddenEvent;
import p015io.getstream.chat.android.client.events.ChannelMuteEvent;
import p015io.getstream.chat.android.client.events.ChannelTruncatedEvent;
import p015io.getstream.chat.android.client.events.ChannelUnmuteEvent;
import p015io.getstream.chat.android.client.events.ChannelUpdatedByUserEvent;
import p015io.getstream.chat.android.client.events.ChannelUpdatedEvent;
import p015io.getstream.chat.android.client.events.ChannelUserBannedEvent;
import p015io.getstream.chat.android.client.events.ChannelUserUnbannedEvent;
import p015io.getstream.chat.android.client.events.ChannelVisibleEvent;
import p015io.getstream.chat.android.client.events.ChannelsMuteEvent;
import p015io.getstream.chat.android.client.events.ChannelsUnmuteEvent;
import p015io.getstream.chat.android.client.events.ChatEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
import p015io.getstream.chat.android.client.events.ConnectingEvent;
import p015io.getstream.chat.android.client.events.DisconnectedEvent;
import p015io.getstream.chat.android.client.events.ErrorEvent;
import p015io.getstream.chat.android.client.events.GlobalUserBannedEvent;
import p015io.getstream.chat.android.client.events.GlobalUserUnbannedEvent;
import p015io.getstream.chat.android.client.events.HealthEvent;
import p015io.getstream.chat.android.client.events.MarkAllReadEvent;
import p015io.getstream.chat.android.client.events.MemberAddedEvent;
import p015io.getstream.chat.android.client.events.MemberRemovedEvent;
import p015io.getstream.chat.android.client.events.MemberUpdatedEvent;
import p015io.getstream.chat.android.client.events.MessageDeletedEvent;
import p015io.getstream.chat.android.client.events.MessageReadEvent;
import p015io.getstream.chat.android.client.events.MessageUpdatedEvent;
import p015io.getstream.chat.android.client.events.NewMessageEvent;
import p015io.getstream.chat.android.client.events.NotificationAddedToChannelEvent;
import p015io.getstream.chat.android.client.events.NotificationChannelDeletedEvent;
import p015io.getstream.chat.android.client.events.NotificationChannelMutesUpdatedEvent;
import p015io.getstream.chat.android.client.events.NotificationChannelTruncatedEvent;
import p015io.getstream.chat.android.client.events.NotificationInviteAcceptedEvent;
import p015io.getstream.chat.android.client.events.NotificationInvitedEvent;
import p015io.getstream.chat.android.client.events.NotificationMarkReadEvent;
import p015io.getstream.chat.android.client.events.NotificationMessageNewEvent;
import p015io.getstream.chat.android.client.events.NotificationMutesUpdatedEvent;
import p015io.getstream.chat.android.client.events.NotificationRemovedFromChannelEvent;
import p015io.getstream.chat.android.client.events.ReactionDeletedEvent;
import p015io.getstream.chat.android.client.events.ReactionNewEvent;
import p015io.getstream.chat.android.client.events.ReactionUpdateEvent;
import p015io.getstream.chat.android.client.events.TypingStartEvent;
import p015io.getstream.chat.android.client.events.TypingStopEvent;
import p015io.getstream.chat.android.client.events.UnknownEvent;
import p015io.getstream.chat.android.client.events.UserDeletedEvent;
import p015io.getstream.chat.android.client.events.UserMutedEvent;
import p015io.getstream.chat.android.client.events.UserPresenceChangedEvent;
import p015io.getstream.chat.android.client.events.UserStartWatchingEvent;
import p015io.getstream.chat.android.client.events.UserStopWatchingEvent;
import p015io.getstream.chat.android.client.events.UserUnmutedEvent;
import p015io.getstream.chat.android.client.events.UserUpdatedEvent;
import p015io.getstream.chat.android.client.events.UsersMutedEvent;
import p015io.getstream.chat.android.client.events.UsersUnmutedEvent;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.socket.SocketListener;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BU\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcom/getstream/sdk/chat/ChatSocketListener;", "Lio/getstream/chat/android/client/socket/SocketListener;", "onOnlineStatusListener", "Lkotlin/Function1;", "Lcom/getstream/sdk/chat/enums/OnlineStatus;", "", "onMeListener", "Lio/getstream/chat/android/client/models/User;", "onTotalUnreadCountListener", "", "onUnreadChannels", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onConnected", "event", "Lio/getstream/chat/android/client/events/ConnectedEvent;", "onConnecting", "onError", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onEvent", "Lio/getstream/chat/android/client/events/ChatEvent;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatSocketListener.kt */
public final class ChatSocketListener extends SocketListener {
    private final Function1<User, Unit> onMeListener;
    private final Function1<OnlineStatus, Unit> onOnlineStatusListener;
    private final Function1<Integer, Unit> onTotalUnreadCountListener;
    private final Function1<Integer, Unit> onUnreadChannels;

    public ChatSocketListener(Function1<? super OnlineStatus, Unit> function1, Function1<? super User, Unit> function12, Function1<? super Integer, Unit> function13, Function1<? super Integer, Unit> function14) {
        Intrinsics.checkNotNullParameter(function1, "onOnlineStatusListener");
        Intrinsics.checkNotNullParameter(function12, "onMeListener");
        Intrinsics.checkNotNullParameter(function13, "onTotalUnreadCountListener");
        Intrinsics.checkNotNullParameter(function14, "onUnreadChannels");
        this.onOnlineStatusListener = function1;
        this.onMeListener = function12;
        this.onTotalUnreadCountListener = function13;
        this.onUnreadChannels = function14;
    }

    public void onConnected(ConnectedEvent connectedEvent) {
        Intrinsics.checkNotNullParameter(connectedEvent, "event");
        this.onMeListener.invoke(connectedEvent.getMe());
        this.onOnlineStatusListener.invoke(OnlineStatus.CONNECTED);
    }

    public void onConnecting() {
        this.onOnlineStatusListener.invoke(OnlineStatus.CONNECTING);
    }

    public void onError(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
        this.onOnlineStatusListener.invoke(OnlineStatus.FAILED);
    }

    public void onEvent(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        if (chatEvent instanceof NewMessageEvent) {
            NewMessageEvent newMessageEvent = (NewMessageEvent) chatEvent;
            Integer totalUnreadCount = newMessageEvent.getTotalUnreadCount();
            if (totalUnreadCount != null) {
                Unit invoke = this.onTotalUnreadCountListener.invoke(totalUnreadCount);
            }
            Integer unreadChannels = newMessageEvent.getUnreadChannels();
            if (unreadChannels != null) {
                Unit invoke2 = this.onUnreadChannels.invoke(unreadChannels);
            }
        } else if (chatEvent instanceof NotificationMarkReadEvent) {
            NotificationMarkReadEvent notificationMarkReadEvent = (NotificationMarkReadEvent) chatEvent;
            Integer totalUnreadCount2 = notificationMarkReadEvent.getTotalUnreadCount();
            if (totalUnreadCount2 != null) {
                Unit invoke3 = this.onTotalUnreadCountListener.invoke(totalUnreadCount2);
            }
            Integer unreadChannels2 = notificationMarkReadEvent.getUnreadChannels();
            if (unreadChannels2 != null) {
                Unit invoke4 = this.onUnreadChannels.invoke(unreadChannels2);
            }
        } else if (chatEvent instanceof NotificationMessageNewEvent) {
            NotificationMessageNewEvent notificationMessageNewEvent = (NotificationMessageNewEvent) chatEvent;
            Integer totalUnreadCount3 = notificationMessageNewEvent.getTotalUnreadCount();
            if (totalUnreadCount3 != null) {
                Unit invoke5 = this.onTotalUnreadCountListener.invoke(totalUnreadCount3);
            }
            Integer unreadChannels3 = notificationMessageNewEvent.getUnreadChannels();
            if (unreadChannels3 != null) {
                Unit invoke6 = this.onUnreadChannels.invoke(unreadChannels3);
            }
        } else if (chatEvent instanceof MarkAllReadEvent) {
            MarkAllReadEvent markAllReadEvent = (MarkAllReadEvent) chatEvent;
            this.onTotalUnreadCountListener.invoke(Integer.valueOf(markAllReadEvent.getTotalUnreadCount()));
            Unit invoke7 = this.onUnreadChannels.invoke(Integer.valueOf(markAllReadEvent.getUnreadChannels()));
        } else if (chatEvent instanceof ConnectedEvent) {
            onConnected((ConnectedEvent) chatEvent);
            Unit unit = Unit.INSTANCE;
        } else if (!(chatEvent instanceof ChannelCreatedEvent) && !(chatEvent instanceof ChannelTruncatedEvent) && !(chatEvent instanceof ChannelMuteEvent) && !(chatEvent instanceof ChannelUnmuteEvent) && !(chatEvent instanceof ChannelDeletedEvent) && !(chatEvent instanceof ChannelHiddenEvent) && !(chatEvent instanceof ChannelUpdatedEvent) && !(chatEvent instanceof ChannelUpdatedByUserEvent) && !(chatEvent instanceof ChannelVisibleEvent) && !(chatEvent instanceof MemberAddedEvent) && !(chatEvent instanceof MemberRemovedEvent) && !(chatEvent instanceof MemberUpdatedEvent) && !(chatEvent instanceof MessageDeletedEvent) && !(chatEvent instanceof MessageReadEvent) && !(chatEvent instanceof MessageUpdatedEvent) && !(chatEvent instanceof NotificationAddedToChannelEvent) && !(chatEvent instanceof NotificationChannelDeletedEvent) && !(chatEvent instanceof NotificationChannelTruncatedEvent) && !(chatEvent instanceof NotificationInviteAcceptedEvent) && !(chatEvent instanceof NotificationInvitedEvent) && !(chatEvent instanceof NotificationRemovedFromChannelEvent) && !(chatEvent instanceof ReactionDeletedEvent) && !(chatEvent instanceof ReactionNewEvent) && !(chatEvent instanceof ReactionUpdateEvent) && !(chatEvent instanceof TypingStartEvent) && !(chatEvent instanceof TypingStopEvent) && !(chatEvent instanceof ChannelUserBannedEvent) && !(chatEvent instanceof UserStartWatchingEvent) && !(chatEvent instanceof UserStopWatchingEvent) && !(chatEvent instanceof ChannelUserUnbannedEvent) && !(chatEvent instanceof ChannelsMuteEvent) && !(chatEvent instanceof ChannelsUnmuteEvent) && !(chatEvent instanceof HealthEvent) && !(chatEvent instanceof NotificationChannelMutesUpdatedEvent) && !(chatEvent instanceof NotificationMutesUpdatedEvent) && !(chatEvent instanceof GlobalUserBannedEvent) && !(chatEvent instanceof UserDeletedEvent) && !(chatEvent instanceof UserMutedEvent) && !(chatEvent instanceof UsersMutedEvent) && !(chatEvent instanceof UserPresenceChangedEvent) && !(chatEvent instanceof GlobalUserUnbannedEvent) && !(chatEvent instanceof UserUnmutedEvent) && !(chatEvent instanceof UsersUnmutedEvent) && !(chatEvent instanceof UserUpdatedEvent) && !(chatEvent instanceof ConnectingEvent) && !(chatEvent instanceof DisconnectedEvent) && !(chatEvent instanceof ErrorEvent) && !(chatEvent instanceof UnknownEvent)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
