package p015io.getstream.chat.android.client.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/TypingEvent;", "", "channelId", "", "users", "", "Lio/getstream/chat/android/client/models/User;", "(Ljava/lang/String;Ljava/util/List;)V", "getChannelId", "()Ljava/lang/String;", "getUsers", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.TypingEvent */
/* compiled from: TypingEvent.kt */
public final class TypingEvent {
    private final String channelId;
    private final List<User> users;

    public static /* synthetic */ TypingEvent copy$default(TypingEvent typingEvent, String str, List<User> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = typingEvent.channelId;
        }
        if ((i & 2) != 0) {
            list = typingEvent.users;
        }
        return typingEvent.copy(str, list);
    }

    public final String component1() {
        return this.channelId;
    }

    public final List<User> component2() {
        return this.users;
    }

    public final TypingEvent copy(String str, List<User> list) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(list, "users");
        return new TypingEvent(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypingEvent)) {
            return false;
        }
        TypingEvent typingEvent = (TypingEvent) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) typingEvent.channelId) && Intrinsics.areEqual((Object) this.users, (Object) typingEvent.users);
    }

    public int hashCode() {
        String str = this.channelId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<User> list = this.users;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "TypingEvent(channelId=" + this.channelId + ", users=" + this.users + ")";
    }

    public TypingEvent(String str, List<User> list) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(list, "users");
        this.channelId = str;
        this.users = list;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final List<User> getUsers() {
        return this.users;
    }
}
