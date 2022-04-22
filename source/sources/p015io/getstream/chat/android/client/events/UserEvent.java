package p015io.getstream.chat.android.client.events;

import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/UserEvent;", "", "user", "Lio/getstream/chat/android/client/models/User;", "getUser", "()Lio/getstream/chat/android/client/models/User;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.UserEvent */
/* compiled from: ChatEvent.kt */
public interface UserEvent {
    User getUser();
}
