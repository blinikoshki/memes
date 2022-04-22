package p015io.getstream.chat.android.client.parser;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
import p015io.getstream.chat.android.client.events.CidEvent;
import p015io.getstream.chat.android.client.events.ConnectedEvent;
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
import p015io.getstream.chat.android.client.extensions.MessageExtensionsKt;
import p015io.getstream.chat.android.client.models.EventType;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lio/getstream/chat/android/client/parser/EventAdapter;", "Lcom/google/gson/TypeAdapter;", "Lio/getstream/chat/android/client/events/ChatEvent;", "gson", "Lcom/google/gson/Gson;", "chatEventAdapter", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapter;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.parser.EventAdapter */
/* compiled from: EventAdapter.kt */
public final class EventAdapter extends TypeAdapter<ChatEvent> {
    private final TypeAdapter<ChatEvent> chatEventAdapter;
    private final Gson gson;

    public EventAdapter(Gson gson2, TypeAdapter<ChatEvent> typeAdapter) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(typeAdapter, "chatEventAdapter");
        this.gson = gson2;
        this.chatEventAdapter = typeAdapter;
    }

    public void write(JsonWriter jsonWriter, ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        this.chatEventAdapter.write(jsonWriter, chatEvent);
    }

    public ChatEvent read(JsonReader jsonReader) {
        String str;
        Object obj;
        Object obj2;
        ChatEvent chatEvent;
        CidEvent cidEvent;
        Object obj3;
        ChatEvent chatEvent2;
        ChatEvent chatEvent3;
        Object obj4;
        Object obj5;
        Object obj6;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        HashMap read = this.gson.getAdapter(HashMap.class).read(jsonReader);
        Objects.requireNonNull(read, "null cannot be cast to non-null type kotlin.collections.HashMap<*, *> /* = java.util.HashMap<*, *> */");
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : read.entrySet()) {
            if (!(entry.getValue() == null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Object obj7 = linkedHashMap.get("type");
        if (!(obj7 instanceof String)) {
            obj7 = null;
        }
        String str2 = (String) obj7;
        String json = this.gson.toJson((Object) linkedHashMap);
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -2088332870:
                    if (str2.equals(EventType.USER_UNBANNED)) {
                        if (linkedHashMap.containsKey("cid")) {
                            obj = this.gson.fromJson(json, ChannelUserUnbannedEvent.class);
                        } else {
                            obj = this.gson.fromJson(json, GlobalUserUnbannedEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(obj, "if (mapData.containsKey(…s.java)\n                }");
                        return (ChatEvent) obj;
                    }
                    break;
                case -2075946506:
                    if (str2.equals(EventType.REACTION_UPDATED)) {
                        Object fromJson = this.gson.fromJson(json, ReactionUpdateEvent.class);
                        ReactionUpdateEvent reactionUpdateEvent = (ReactionUpdateEvent) fromJson;
                        MessageExtensionsKt.enrichWithCid(reactionUpdateEvent.getMessage(), reactionUpdateEvent.getCid());
                        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(data, Reac…sage.enrichWithCid(cid) }");
                        return (ChatEvent) fromJson;
                    }
                    break;
                case -1991571309:
                    if (str2.equals(EventType.CHANNEL_TRUNCATED)) {
                        Object fromJson2 = this.gson.fromJson(json, ChannelTruncatedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson2, "gson.fromJson(data, Chan…uncatedEvent::class.java)");
                        return (ChatEvent) fromJson2;
                    }
                    break;
                case -1891614361:
                    if (str2.equals(EventType.MEMBER_UPDATED)) {
                        Object fromJson3 = this.gson.fromJson(json, MemberUpdatedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson3, "gson.fromJson(data, Memb…UpdatedEvent::class.java)");
                        return (ChatEvent) fromJson3;
                    }
                    break;
                case -1717161893:
                    if (str2.equals(EventType.REACTION_NEW)) {
                        Object fromJson4 = this.gson.fromJson(json, ReactionNewEvent.class);
                        ReactionNewEvent reactionNewEvent = (ReactionNewEvent) fromJson4;
                        MessageExtensionsKt.enrichWithCid(reactionNewEvent.getMessage(), reactionNewEvent.getCid());
                        Intrinsics.checkNotNullExpressionValue(fromJson4, "gson.fromJson(data, Reac…sage.enrichWithCid(cid) }");
                        return (ChatEvent) fromJson4;
                    }
                    break;
                case -1634848648:
                    if (str2.equals(EventType.NOTIFICATION_INVITED)) {
                        Object fromJson5 = this.gson.fromJson(json, NotificationInvitedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson5, "gson.fromJson(data, Noti…InvitedEvent::class.java)");
                        return (ChatEvent) fromJson5;
                    }
                    break;
                case -1527862027:
                    if (str2.equals(EventType.CHANNEL_HIDDEN)) {
                        Object fromJson6 = this.gson.fromJson(json, ChannelHiddenEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson6, "gson.fromJson(data, Chan…lHiddenEvent::class.java)");
                        return (ChatEvent) fromJson6;
                    }
                    break;
                case -1464370004:
                    if (str2.equals(EventType.MEMBER_ADDED)) {
                        Object fromJson7 = this.gson.fromJson(json, MemberAddedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson7, "gson.fromJson(data, MemberAddedEvent::class.java)");
                        return (ChatEvent) fromJson7;
                    }
                    break;
                case -1460800646:
                    if (str2.equals(EventType.USER_WATCHING_STOP)) {
                        Object fromJson8 = this.gson.fromJson(json, UserStopWatchingEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson8, "gson.fromJson(data, User…atchingEvent::class.java)");
                        return (ChatEvent) fromJson8;
                    }
                    break;
                case -1331396835:
                    if (str2.equals(EventType.MESSAGE_READ)) {
                        if (linkedHashMap.containsKey("cid")) {
                            obj2 = this.gson.fromJson(json, MessageReadEvent.class);
                        } else {
                            obj2 = this.gson.fromJson(json, MarkAllReadEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(obj2, "when {\n                m…class.java)\n            }");
                        return (ChatEvent) obj2;
                    }
                    break;
                case -1314458489:
                    if (str2.equals(EventType.CHANNEL_UNMUTED)) {
                        if (linkedHashMap.containsKey("mute")) {
                            chatEvent = (ChatEvent) this.gson.fromJson(json, ChannelUnmuteEvent.class);
                        } else {
                            chatEvent = (ChatEvent) this.gson.fromJson(json, ChannelsUnmuteEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(chatEvent, "if (mapData.containsKey(…s.java)\n                }");
                        return chatEvent;
                    }
                    break;
                case -1266107696:
                    if (str2.equals(EventType.CHANNEL_UPDATED)) {
                        if (linkedHashMap.containsKey("user")) {
                            Object fromJson9 = this.gson.fromJson(json, ChannelUpdatedByUserEvent.class);
                            ChannelUpdatedByUserEvent channelUpdatedByUserEvent = (ChannelUpdatedByUserEvent) fromJson9;
                            Message message = channelUpdatedByUserEvent.getMessage();
                            if (message != null) {
                                MessageExtensionsKt.enrichWithCid(message, channelUpdatedByUserEvent.getCid());
                            }
                            cidEvent = (CidEvent) fromJson9;
                        } else {
                            Object fromJson10 = this.gson.fromJson(json, ChannelUpdatedEvent.class);
                            ChannelUpdatedEvent channelUpdatedEvent = (ChannelUpdatedEvent) fromJson10;
                            Message message2 = channelUpdatedEvent.getMessage();
                            if (message2 != null) {
                                MessageExtensionsKt.enrichWithCid(message2, channelUpdatedEvent.getCid());
                            }
                            cidEvent = (CidEvent) fromJson10;
                        }
                        Intrinsics.checkNotNullExpressionValue(cidEvent, "if (mapData.containsKey(…(cid) }\n                }");
                        return cidEvent;
                    }
                    break;
                case -1192399199:
                    if (str2.equals(EventType.USER_BANNED)) {
                        if (linkedHashMap.containsKey("cid")) {
                            obj3 = this.gson.fromJson(json, ChannelUserBannedEvent.class);
                        } else {
                            obj3 = this.gson.fromJson(json, GlobalUserBannedEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(obj3, "if (mapData.containsKey(…s.java)\n                }");
                        return (ChatEvent) obj3;
                    }
                    break;
                case -1132674032:
                    if (str2.equals(EventType.NOTIFICATION_REMOVED_FROM_CHANNEL)) {
                        Object fromJson11 = this.gson.fromJson(json, NotificationRemovedFromChannelEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson11, "gson.fromJson(data, Noti…ChannelEvent::class.java)");
                        return (ChatEvent) fromJson11;
                    }
                    break;
                case -1049195388:
                    if (str2.equals(EventType.USER_PRESENCE_CHANGED)) {
                        Object fromJson12 = this.gson.fromJson(json, UserPresenceChangedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson12, "gson.fromJson(data, User…ChangedEvent::class.java)");
                        return (ChatEvent) fromJson12;
                    }
                    break;
                case -1030434342:
                    if (str2.equals(EventType.NOTIFICATION_CHANNEL_DELETED)) {
                        Object fromJson13 = this.gson.fromJson(json, NotificationChannelDeletedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson13, "gson.fromJson(data, Noti…DeletedEvent::class.java)");
                        return (ChatEvent) fromJson13;
                    }
                    break;
                case -934872620:
                    if (str2.equals(EventType.MESSAGE_UPDATED)) {
                        Object fromJson14 = this.gson.fromJson(json, MessageUpdatedEvent.class);
                        MessageUpdatedEvent messageUpdatedEvent = (MessageUpdatedEvent) fromJson14;
                        MessageExtensionsKt.enrichWithCid(messageUpdatedEvent.getMessage(), messageUpdatedEvent.getCid());
                        Intrinsics.checkNotNullExpressionValue(fromJson14, "gson.fromJson(data, Mess…sage.enrichWithCid(cid) }");
                        return (ChatEvent) fromJson14;
                    }
                    break;
                case -874236103:
                    if (str2.equals(EventType.MESSAGE_NEW)) {
                        Object fromJson15 = this.gson.fromJson(json, NewMessageEvent.class);
                        NewMessageEvent newMessageEvent = (NewMessageEvent) fromJson15;
                        MessageExtensionsKt.enrichWithCid(newMessageEvent.getMessage(), newMessageEvent.getCid());
                        Intrinsics.checkNotNullExpressionValue(fromJson15, "gson.fromJson(data, NewM…sage.enrichWithCid(cid) }");
                        return (ChatEvent) fromJson15;
                    }
                    break;
                case -852016853:
                    if (str2.equals(EventType.TYPING_START)) {
                        Object fromJson16 = this.gson.fromJson(json, TypingStartEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson16, "gson.fromJson(data, TypingStartEvent::class.java)");
                        return (ChatEvent) fromJson16;
                    }
                    break;
                case -720220647:
                    if (str2.equals(EventType.TYPING_STOP)) {
                        Object fromJson17 = this.gson.fromJson(json, TypingStopEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson17, "gson.fromJson(data, TypingStopEvent::class.java)");
                        return (ChatEvent) fromJson17;
                    }
                    break;
                case -717213450:
                    if (str2.equals(EventType.USER_DELETED)) {
                        Object fromJson18 = this.gson.fromJson(json, UserDeletedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson18, "gson.fromJson(data, UserDeletedEvent::class.java)");
                        return (ChatEvent) fromJson18;
                    }
                    break;
                case -565348084:
                    if (str2.equals(EventType.MEMBER_REMOVED)) {
                        Object fromJson19 = this.gson.fromJson(json, MemberRemovedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson19, "gson.fromJson(data, Memb…RemovedEvent::class.java)");
                        return (ChatEvent) fromJson19;
                    }
                    break;
                case -564934009:
                    if (str2.equals(EventType.CHANNEL_VISIBLE)) {
                        Object fromJson20 = this.gson.fromJson(json, ChannelVisibleEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson20, "gson.fromJson(data, Chan…VisibleEvent::class.java)");
                        return (ChatEvent) fromJson20;
                    }
                    break;
                case -557080842:
                    if (str2.equals(EventType.HEALTH_CHECK)) {
                        if (linkedHashMap.containsKey("me")) {
                            chatEvent2 = (ChatEvent) this.gson.fromJson(json, ConnectedEvent.class);
                        } else {
                            chatEvent2 = (ChatEvent) this.gson.fromJson(json, HealthEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(chatEvent2, "if (mapData.containsKey(…s.java)\n                }");
                        return chatEvent2;
                    }
                    break;
                case -438266561:
                    if (str2.equals(EventType.NOTIFICATION_CHANNEL_TRUNCATED)) {
                        Object fromJson21 = this.gson.fromJson(json, NotificationChannelTruncatedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson21, "gson.fromJson(data, Noti…uncatedEvent::class.java)");
                        return (ChatEvent) fromJson21;
                    }
                    break;
                case -291053228:
                    if (str2.equals(EventType.REACTION_DELETED)) {
                        Object fromJson22 = this.gson.fromJson(json, ReactionDeletedEvent.class);
                        ReactionDeletedEvent reactionDeletedEvent = (ReactionDeletedEvent) fromJson22;
                        MessageExtensionsKt.enrichWithCid(reactionDeletedEvent.getMessage(), reactionDeletedEvent.getCid());
                        Intrinsics.checkNotNullExpressionValue(fromJson22, "gson.fromJson(data, Reac…sage.enrichWithCid(cid) }");
                        return (ChatEvent) fromJson22;
                    }
                    break;
                case -3122947:
                    if (str2.equals(EventType.CHANNEL_CREATED)) {
                        Object fromJson23 = this.gson.fromJson(json, ChannelCreatedEvent.class);
                        ChannelCreatedEvent channelCreatedEvent = (ChannelCreatedEvent) fromJson23;
                        Message message3 = channelCreatedEvent.getMessage();
                        if (message3 != null) {
                            MessageExtensionsKt.enrichWithCid(message3, channelCreatedEvent.getCid());
                        }
                        Intrinsics.checkNotNullExpressionValue(fromJson23, "gson.fromJson(data, Chan…age?.enrichWithCid(cid) }");
                        return (ChatEvent) fromJson23;
                    }
                    break;
                case 371346624:
                    if (str2.equals(EventType.CHANNEL_MUTED)) {
                        if (linkedHashMap.containsKey("mute")) {
                            chatEvent3 = (ChatEvent) this.gson.fromJson(json, ChannelMuteEvent.class);
                        } else {
                            chatEvent3 = (ChatEvent) this.gson.fromJson(json, ChannelsMuteEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(chatEvent3, "if (mapData.containsKey(…s.java)\n                }");
                        return chatEvent3;
                    }
                    break;
                case 518785582:
                    if (str2.equals(EventType.CHANNEL_DELETED)) {
                        Object fromJson24 = this.gson.fromJson(json, ChannelDeletedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson24, "gson.fromJson(data, Chan…DeletedEvent::class.java)");
                        return (ChatEvent) fromJson24;
                    }
                    break;
                case 526484872:
                    if (str2.equals(EventType.USER_MUTED)) {
                        if (linkedHashMap.containsKey("target_user")) {
                            obj4 = this.gson.fromJson(json, UserMutedEvent.class);
                        } else {
                            obj4 = this.gson.fromJson(json, UsersMutedEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(obj4, "if (mapData.containsKey(…s.java)\n                }");
                        return (ChatEvent) obj4;
                    }
                    break;
                case 539667738:
                    if (str2.equals(EventType.NOTIFICATION_INVITE_ACCEPTED)) {
                        Object fromJson25 = this.gson.fromJson(json, NotificationInviteAcceptedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson25, "gson.fromJson(data, Noti…cceptedEvent::class.java)");
                        return (ChatEvent) fromJson25;
                    }
                    break;
                case 748333875:
                    if (str2.equals(EventType.NOTIFICATION_MUTES_UPDATED)) {
                        Object fromJson26 = this.gson.fromJson(json, NotificationMutesUpdatedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson26, "gson.fromJson(data, Noti…UpdatedEvent::class.java)");
                        return (ChatEvent) fromJson26;
                    }
                    break;
                case 850020658:
                    if (str2.equals(EventType.MESSAGE_DELETED)) {
                        Object fromJson27 = this.gson.fromJson(json, MessageDeletedEvent.class);
                        MessageDeletedEvent messageDeletedEvent = (MessageDeletedEvent) fromJson27;
                        MessageExtensionsKt.enrichWithCid(messageDeletedEvent.getMessage(), messageDeletedEvent.getCid());
                        Intrinsics.checkNotNullExpressionValue(fromJson27, "gson.fromJson(data, Mess…sage.enrichWithCid(cid) }");
                        return (ChatEvent) fromJson27;
                    }
                    break;
                case 1282886273:
                    if (str2.equals(EventType.NOTIFICATION_ADDED_TO_CHANNEL)) {
                        Object fromJson28 = this.gson.fromJson(json, NotificationAddedToChannelEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson28, "gson.fromJson(data, Noti…ChannelEvent::class.java)");
                        return (ChatEvent) fromJson28;
                    }
                    break;
                case 1332341751:
                    if (str2.equals(EventType.NOTIFICATION_CHANNEL_MUTES_UPDATED)) {
                        Object fromJson29 = this.gson.fromJson(json, NotificationChannelMutesUpdatedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson29, "gson.fromJson(data, Noti…UpdatedEvent::class.java)");
                        return (ChatEvent) fromJson29;
                    }
                    break;
                case 1744509775:
                    if (str2.equals(EventType.USER_UNMUTED)) {
                        if (linkedHashMap.containsKey("target_user")) {
                            obj5 = this.gson.fromJson(json, UserUnmutedEvent.class);
                        } else {
                            obj5 = this.gson.fromJson(json, UsersUnmutedEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(obj5, "if (mapData.containsKey(…s.java)\n                }");
                        return (ChatEvent) obj5;
                    }
                    break;
                case 1792860568:
                    if (str2.equals(EventType.USER_UPDATED)) {
                        Object fromJson30 = this.gson.fromJson(json, UserUpdatedEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson30, "gson.fromJson(data, UserUpdatedEvent::class.java)");
                        return (ChatEvent) fromJson30;
                    }
                    break;
                case 1830106757:
                    if (str2.equals(EventType.NOTIFICATION_MARK_READ)) {
                        if (linkedHashMap.containsKey("cid")) {
                            obj6 = this.gson.fromJson(json, NotificationMarkReadEvent.class);
                        } else {
                            obj6 = this.gson.fromJson(json, MarkAllReadEvent.class);
                        }
                        Intrinsics.checkNotNullExpressionValue(obj6, "when {\n                m…class.java)\n            }");
                        return (ChatEvent) obj6;
                    }
                    break;
                case 1959806954:
                    if (str2.equals(EventType.USER_WATCHING_START)) {
                        Object fromJson31 = this.gson.fromJson(json, UserStartWatchingEvent.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson31, "gson.fromJson(data, User…atchingEvent::class.java)");
                        return (ChatEvent) fromJson31;
                    }
                    break;
                case 2015081701:
                    if (str2.equals(EventType.NOTIFICATION_MESSAGE_NEW)) {
                        Object fromJson32 = this.gson.fromJson(json, NotificationMessageNewEvent.class);
                        NotificationMessageNewEvent notificationMessageNewEvent = (NotificationMessageNewEvent) fromJson32;
                        MessageExtensionsKt.enrichWithCid(notificationMessageNewEvent.getMessage(), notificationMessageNewEvent.getCid());
                        Intrinsics.checkNotNullExpressionValue(fromJson32, "gson.fromJson(data, Noti…sage.enrichWithCid(cid) }");
                        return (ChatEvent) fromJson32;
                    }
                    break;
            }
        }
        UnknownEvent unknownEvent = (UnknownEvent) this.gson.fromJson(json, UnknownEvent.class);
        Object obj8 = linkedHashMap.get("type");
        if (obj8 == null || (str = obj8.toString()) == null) {
            str = EventType.UNKNOWN;
        }
        return UnknownEvent.copy$default(unknownEvent, str, (Date) null, linkedHashMap, 2, (Object) null);
    }
}
