package p015io.getstream.chat.android.client.api.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.events.ChatEvent;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/EventResponse;", "", "event", "Lio/getstream/chat/android/client/events/ChatEvent;", "duration", "", "(Lio/getstream/chat/android/client/events/ChatEvent;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/String;", "setDuration", "(Ljava/lang/String;)V", "getEvent", "()Lio/getstream/chat/android/client/events/ChatEvent;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.EventResponse */
/* compiled from: EventResponse.kt */
public final class EventResponse {
    private String duration;
    private final ChatEvent event;

    public static /* synthetic */ EventResponse copy$default(EventResponse eventResponse, ChatEvent chatEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            chatEvent = eventResponse.event;
        }
        if ((i & 2) != 0) {
            str = eventResponse.duration;
        }
        return eventResponse.copy(chatEvent, str);
    }

    public final ChatEvent component1() {
        return this.event;
    }

    public final String component2() {
        return this.duration;
    }

    public final EventResponse copy(ChatEvent chatEvent, String str) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        Intrinsics.checkNotNullParameter(str, "duration");
        return new EventResponse(chatEvent, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventResponse)) {
            return false;
        }
        EventResponse eventResponse = (EventResponse) obj;
        return Intrinsics.areEqual((Object) this.event, (Object) eventResponse.event) && Intrinsics.areEqual((Object) this.duration, (Object) eventResponse.duration);
    }

    public int hashCode() {
        ChatEvent chatEvent = this.event;
        int i = 0;
        int hashCode = (chatEvent != null ? chatEvent.hashCode() : 0) * 31;
        String str = this.duration;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "EventResponse(event=" + this.event + ", duration=" + this.duration + ")";
    }

    public EventResponse(ChatEvent chatEvent, String str) {
        Intrinsics.checkNotNullParameter(chatEvent, "event");
        Intrinsics.checkNotNullParameter(str, "duration");
        this.event = chatEvent;
        this.duration = str;
    }

    public final ChatEvent getEvent() {
        return this.event;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EventResponse(ChatEvent chatEvent, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatEvent, (i & 2) != 0 ? "" : str);
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.duration = str;
    }
}
