package p015io.getstream.chat.android.client.api.models;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/UpdateChannelRequest;", "", "data", "", "", "message", "Lio/getstream/chat/android/client/models/Message;", "(Ljava/util/Map;Lio/getstream/chat/android/client/models/Message;)V", "getData", "()Ljava/util/Map;", "getMessage", "()Lio/getstream/chat/android/client/models/Message;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.UpdateChannelRequest */
/* compiled from: UpdateChannelRequest.kt */
public final class UpdateChannelRequest {
    private final Map<String, Object> data;
    private final Message message;

    public static /* synthetic */ UpdateChannelRequest copy$default(UpdateChannelRequest updateChannelRequest, Map<String, Object> map, Message message2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = updateChannelRequest.data;
        }
        if ((i & 2) != 0) {
            message2 = updateChannelRequest.message;
        }
        return updateChannelRequest.copy(map, message2);
    }

    public final Map<String, Object> component1() {
        return this.data;
    }

    public final Message component2() {
        return this.message;
    }

    public final UpdateChannelRequest copy(Map<String, ? extends Object> map, Message message2) {
        Intrinsics.checkNotNullParameter(map, "data");
        return new UpdateChannelRequest(map, message2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateChannelRequest)) {
            return false;
        }
        UpdateChannelRequest updateChannelRequest = (UpdateChannelRequest) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) updateChannelRequest.data) && Intrinsics.areEqual((Object) this.message, (Object) updateChannelRequest.message);
    }

    public int hashCode() {
        Map<String, Object> map = this.data;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        Message message2 = this.message;
        if (message2 != null) {
            i = message2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "UpdateChannelRequest(data=" + this.data + ", message=" + this.message + ")";
    }

    public UpdateChannelRequest(Map<String, ? extends Object> map, Message message2) {
        Intrinsics.checkNotNullParameter(map, "data");
        this.data = map;
        this.message = message2;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final Message getMessage() {
        return this.message;
    }
}
