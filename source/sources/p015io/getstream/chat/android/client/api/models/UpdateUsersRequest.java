package p015io.getstream.chat.android.client.api.models;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/UpdateUsersRequest;", "", "users", "", "", "Lio/getstream/chat/android/client/models/User;", "(Ljava/util/Map;)V", "getUsers", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.UpdateUsersRequest */
/* compiled from: UpdateUsersRequest.kt */
public final class UpdateUsersRequest {
    private final Map<String, User> users;

    public static /* synthetic */ UpdateUsersRequest copy$default(UpdateUsersRequest updateUsersRequest, Map<String, User> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = updateUsersRequest.users;
        }
        return updateUsersRequest.copy(map);
    }

    public final Map<String, User> component1() {
        return this.users;
    }

    public final UpdateUsersRequest copy(Map<String, User> map) {
        Intrinsics.checkNotNullParameter(map, "users");
        return new UpdateUsersRequest(map);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UpdateUsersRequest) && Intrinsics.areEqual((Object) this.users, (Object) ((UpdateUsersRequest) obj).users);
        }
        return true;
    }

    public int hashCode() {
        Map<String, User> map = this.users;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "UpdateUsersRequest(users=" + this.users + ")";
    }

    public UpdateUsersRequest(Map<String, User> map) {
        Intrinsics.checkNotNullParameter(map, "users");
        this.users = map;
    }

    public final Map<String, User> getUsers() {
        return this.users;
    }
}
