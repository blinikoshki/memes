package p015io.getstream.chat.android.client.api.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QueryUserListResponse;", "", "users", "", "Lio/getstream/chat/android/client/models/User;", "(Ljava/util/List;)V", "getUsers", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.QueryUserListResponse */
/* compiled from: QueryUserListResponse.kt */
public final class QueryUserListResponse {
    private final List<User> users;

    public QueryUserListResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QueryUserListResponse copy$default(QueryUserListResponse queryUserListResponse, List<User> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = queryUserListResponse.users;
        }
        return queryUserListResponse.copy(list);
    }

    public final List<User> component1() {
        return this.users;
    }

    public final QueryUserListResponse copy(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        return new QueryUserListResponse(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof QueryUserListResponse) && Intrinsics.areEqual((Object) this.users, (Object) ((QueryUserListResponse) obj).users);
        }
        return true;
    }

    public int hashCode() {
        List<User> list = this.users;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "QueryUserListResponse(users=" + this.users + ")";
    }

    public QueryUserListResponse(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        this.users = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryUserListResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<User> getUsers() {
        return this.users;
    }
}
