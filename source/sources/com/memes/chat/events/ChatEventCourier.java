package com.memes.chat.events;

import com.memes.chat.events.custom.DeclaredChatEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u0012\u0010\t\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bJ\u0012\u0010\f\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b¨\u0006\r"}, mo26107d2 = {"Lcom/memes/chat/events/ChatEventCourier;", "", "()V", "onEventConsumed", "", "event", "post", "Lcom/memes/chat/events/custom/DeclaredChatEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "startReceiving", "receiver", "Lcom/memes/chat/events/ChatEventReceiver;", "stopReceiving", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatEventCourier.kt */
public final class ChatEventCourier {
    public static final ChatEventCourier INSTANCE = new ChatEventCourier();

    public final void onEventConsumed(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
    }

    private ChatEventCourier() {
    }

    public final void startReceiving(ChatEventReceiver<?> chatEventReceiver) {
        Intrinsics.checkNotNullParameter(chatEventReceiver, "receiver");
        if (!EventBus.getDefault().isRegistered(chatEventReceiver)) {
            EventBus.getDefault().register(chatEventReceiver);
        }
    }

    public final void stopReceiving(ChatEventReceiver<?> chatEventReceiver) {
        Intrinsics.checkNotNullParameter(chatEventReceiver, "receiver");
        if (EventBus.getDefault().isRegistered(chatEventReceiver)) {
            EventBus.getDefault().unregister(chatEventReceiver);
        }
    }

    public final void post(ChatEvent chatEvent) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        EventBus.getDefault().post(chatEvent);
    }

    public final void post(DeclaredChatEvent declaredChatEvent) {
        Intrinsics.checkNotNullParameter(declaredChatEvent, "event");
        EventBus.getDefault().post(declaredChatEvent);
    }
}
