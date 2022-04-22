package p015io.getstream.chat.android.client.api.models;

import com.google.firebase.messaging.Constants;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/WatchChannelRequest;", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "()V", "withData", "data", "", "", "", "withMembers", "limit", "", "offset", "withMessages", "direction", "Lio/getstream/chat/android/client/api/models/Pagination;", "messageId", "withWatchers", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.WatchChannelRequest */
/* compiled from: WatchChannelRequest.kt */
public final class WatchChannelRequest extends QueryChannelRequest {
    public WatchChannelRequest() {
        setWatch(true);
        setPresence(false);
        setState(true);
    }

    public WatchChannelRequest withData(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        QueryChannelRequest withData = super.withData(map);
        Objects.requireNonNull(withData, "null cannot be cast to non-null type io.getstream.chat.android.client.api.models.WatchChannelRequest");
        return (WatchChannelRequest) withData;
    }

    public WatchChannelRequest withMembers(int i, int i2) {
        QueryChannelRequest withMembers = super.withMembers(i, i2);
        Objects.requireNonNull(withMembers, "null cannot be cast to non-null type io.getstream.chat.android.client.api.models.WatchChannelRequest");
        return (WatchChannelRequest) withMembers;
    }

    public WatchChannelRequest withWatchers(int i, int i2) {
        QueryChannelRequest withWatchers = super.withWatchers(i, i2);
        Objects.requireNonNull(withWatchers, "null cannot be cast to non-null type io.getstream.chat.android.client.api.models.WatchChannelRequest");
        return (WatchChannelRequest) withWatchers;
    }

    public WatchChannelRequest withMessages(int i) {
        QueryChannelRequest withMessages = super.withMessages(i);
        Objects.requireNonNull(withMessages, "null cannot be cast to non-null type io.getstream.chat.android.client.api.models.WatchChannelRequest");
        return (WatchChannelRequest) withMessages;
    }

    public WatchChannelRequest withMessages(Pagination pagination, String str, int i) {
        Intrinsics.checkNotNullParameter(pagination, QuerySort.KEY_DIRECTION);
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        QueryChannelRequest withMessages = super.withMessages(pagination, str, i);
        Objects.requireNonNull(withMessages, "null cannot be cast to non-null type io.getstream.chat.android.client.api.models.WatchChannelRequest");
        return (WatchChannelRequest) withMessages;
    }
}
