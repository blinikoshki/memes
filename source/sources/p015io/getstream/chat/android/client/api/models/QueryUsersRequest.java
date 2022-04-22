package p015io.getstream.chat.android.client.api.models;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003JA\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0013HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00120\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006/"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QueryUsersRequest;", "", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "offset", "", "limit", "querySort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/User;", "presence", "", "(Lio/getstream/chat/android/client/utils/FilterObject;IILio/getstream/chat/android/client/api/models/QuerySort;Z)V", "getFilter", "()Lio/getstream/chat/android/client/utils/FilterObject;", "setFilter", "(Lio/getstream/chat/android/client/utils/FilterObject;)V", "filter_conditions", "", "", "getFilter_conditions", "()Ljava/util/Map;", "getLimit", "()I", "getOffset", "getPresence", "()Z", "setPresence", "(Z)V", "getQuerySort", "()Lio/getstream/chat/android/client/api/models/QuerySort;", "setQuerySort", "(Lio/getstream/chat/android/client/api/models/QuerySort;)V", "sort", "", "getSort", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.QueryUsersRequest */
/* compiled from: QueryUsersRequest.kt */
public final class QueryUsersRequest {
    @IgnoreSerialisation
    private FilterObject filter;
    private final Map<String, Object> filter_conditions;
    private final int limit;
    private final int offset;
    private boolean presence;
    @IgnoreSerialisation
    private QuerySort<User> querySort;
    private final List<Map<String, Object>> sort;

    public QueryUsersRequest(FilterObject filterObject, int i, int i2) {
        this(filterObject, i, i2, (QuerySort) null, false, 24, (DefaultConstructorMarker) null);
    }

    public QueryUsersRequest(FilterObject filterObject, int i, int i2, QuerySort<User> querySort2) {
        this(filterObject, i, i2, querySort2, false, 16, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QueryUsersRequest copy$default(QueryUsersRequest queryUsersRequest, FilterObject filterObject, int i, int i2, QuerySort<User> querySort2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            filterObject = queryUsersRequest.filter;
        }
        if ((i3 & 2) != 0) {
            i = queryUsersRequest.offset;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = queryUsersRequest.limit;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            querySort2 = queryUsersRequest.querySort;
        }
        QuerySort<User> querySort3 = querySort2;
        if ((i3 & 16) != 0) {
            z = queryUsersRequest.presence;
        }
        return queryUsersRequest.copy(filterObject, i4, i5, querySort3, z);
    }

    public final FilterObject component1() {
        return this.filter;
    }

    public final int component2() {
        return this.offset;
    }

    public final int component3() {
        return this.limit;
    }

    public final QuerySort<User> component4() {
        return this.querySort;
    }

    public final boolean component5() {
        return this.presence;
    }

    public final QueryUsersRequest copy(FilterObject filterObject, int i, int i2, QuerySort<User> querySort2, boolean z) {
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort2, "querySort");
        return new QueryUsersRequest(filterObject, i, i2, querySort2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryUsersRequest)) {
            return false;
        }
        QueryUsersRequest queryUsersRequest = (QueryUsersRequest) obj;
        return Intrinsics.areEqual((Object) this.filter, (Object) queryUsersRequest.filter) && this.offset == queryUsersRequest.offset && this.limit == queryUsersRequest.limit && Intrinsics.areEqual((Object) this.querySort, (Object) queryUsersRequest.querySort) && this.presence == queryUsersRequest.presence;
    }

    public int hashCode() {
        FilterObject filterObject = this.filter;
        int i = 0;
        int hashCode = (((((filterObject != null ? filterObject.hashCode() : 0) * 31) + this.offset) * 31) + this.limit) * 31;
        QuerySort<User> querySort2 = this.querySort;
        if (querySort2 != null) {
            i = querySort2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.presence;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "QueryUsersRequest(filter=" + this.filter + ", offset=" + this.offset + ", limit=" + this.limit + ", querySort=" + this.querySort + ", presence=" + this.presence + ")";
    }

    public QueryUsersRequest(FilterObject filterObject, int i, int i2, QuerySort<User> querySort2, boolean z) {
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort2, "querySort");
        this.filter = filterObject;
        this.offset = i;
        this.limit = i2;
        this.querySort = querySort2;
        this.presence = z;
        this.sort = querySort2.toDto();
        this.filter_conditions = this.filter.toMap();
    }

    public final FilterObject getFilter() {
        return this.filter;
    }

    public final void setFilter(FilterObject filterObject) {
        Intrinsics.checkNotNullParameter(filterObject, "<set-?>");
        this.filter = filterObject;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryUsersRequest(FilterObject filterObject, int i, int i2, QuerySort querySort2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(filterObject, i, i2, (i3 & 8) != 0 ? new QuerySort() : querySort2, (i3 & 16) != 0 ? false : z);
    }

    public final QuerySort<User> getQuerySort() {
        return this.querySort;
    }

    public final void setQuerySort(QuerySort<User> querySort2) {
        Intrinsics.checkNotNullParameter(querySort2, "<set-?>");
        this.querySort = querySort2;
    }

    public final boolean getPresence() {
        return this.presence;
    }

    public final void setPresence(boolean z) {
        this.presence = z;
    }

    public final List<Map<String, Object>> getSort() {
        return this.sort;
    }

    public final Map<String, Object> getFilter_conditions() {
        return this.filter_conditions;
    }
}
