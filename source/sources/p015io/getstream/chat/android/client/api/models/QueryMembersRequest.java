package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0003J[\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\bHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R#\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00180\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001e¨\u00063"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QueryMembersRequest;", "", "channelType", "", "channelId", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "offset", "", "limit", "querySort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Member;", "members", "", "(Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/utils/FilterObject;IILio/getstream/chat/android/client/api/models/QuerySort;Ljava/util/List;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getFilter", "()Lio/getstream/chat/android/client/utils/FilterObject;", "setFilter", "(Lio/getstream/chat/android/client/utils/FilterObject;)V", "filter_conditions", "", "getFilter_conditions", "()Ljava/util/Map;", "getLimit", "()I", "getMembers", "()Ljava/util/List;", "getOffset", "getQuerySort", "()Lio/getstream/chat/android/client/api/models/QuerySort;", "setQuerySort", "(Lio/getstream/chat/android/client/api/models/QuerySort;)V", "sort", "getSort", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.QueryMembersRequest */
/* compiled from: QueryMembersRequest.kt */
public final class QueryMembersRequest {
    @SerializedName("id")
    private final String channelId;
    @SerializedName("type")
    private final String channelType;
    @IgnoreSerialisation
    private FilterObject filter;
    private final Map<String, Object> filter_conditions;
    private final int limit;
    private final List<Member> members;
    private final int offset;
    @IgnoreSerialisation
    private QuerySort<Member> querySort;
    private final List<Map<String, Object>> sort;

    public static /* synthetic */ QueryMembersRequest copy$default(QueryMembersRequest queryMembersRequest, String str, String str2, FilterObject filterObject, int i, int i2, QuerySort<Member> querySort2, List<Member> list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = queryMembersRequest.channelType;
        }
        if ((i3 & 2) != 0) {
            str2 = queryMembersRequest.channelId;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            filterObject = queryMembersRequest.filter;
        }
        FilterObject filterObject2 = filterObject;
        if ((i3 & 8) != 0) {
            i = queryMembersRequest.offset;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = queryMembersRequest.limit;
        }
        int i5 = i2;
        if ((i3 & 32) != 0) {
            querySort2 = queryMembersRequest.querySort;
        }
        QuerySort<Member> querySort3 = querySort2;
        if ((i3 & 64) != 0) {
            list = queryMembersRequest.members;
        }
        return queryMembersRequest.copy(str, str3, filterObject2, i4, i5, querySort3, list);
    }

    public final String component1() {
        return this.channelType;
    }

    public final String component2() {
        return this.channelId;
    }

    public final FilterObject component3() {
        return this.filter;
    }

    public final int component4() {
        return this.offset;
    }

    public final int component5() {
        return this.limit;
    }

    public final QuerySort<Member> component6() {
        return this.querySort;
    }

    public final List<Member> component7() {
        return this.members;
    }

    public final QueryMembersRequest copy(String str, String str2, FilterObject filterObject, int i, int i2, QuerySort<Member> querySort2, List<Member> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort2, "querySort");
        List<Member> list2 = list;
        Intrinsics.checkNotNullParameter(list2, ModelFields.MEMBERS);
        return new QueryMembersRequest(str, str2, filterObject, i, i2, querySort2, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryMembersRequest)) {
            return false;
        }
        QueryMembersRequest queryMembersRequest = (QueryMembersRequest) obj;
        return Intrinsics.areEqual((Object) this.channelType, (Object) queryMembersRequest.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) queryMembersRequest.channelId) && Intrinsics.areEqual((Object) this.filter, (Object) queryMembersRequest.filter) && this.offset == queryMembersRequest.offset && this.limit == queryMembersRequest.limit && Intrinsics.areEqual((Object) this.querySort, (Object) queryMembersRequest.querySort) && Intrinsics.areEqual((Object) this.members, (Object) queryMembersRequest.members);
    }

    public int hashCode() {
        String str = this.channelType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channelId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        FilterObject filterObject = this.filter;
        int hashCode3 = (((((hashCode2 + (filterObject != null ? filterObject.hashCode() : 0)) * 31) + this.offset) * 31) + this.limit) * 31;
        QuerySort<Member> querySort2 = this.querySort;
        int hashCode4 = (hashCode3 + (querySort2 != null ? querySort2.hashCode() : 0)) * 31;
        List<Member> list = this.members;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "QueryMembersRequest(channelType=" + this.channelType + ", channelId=" + this.channelId + ", filter=" + this.filter + ", offset=" + this.offset + ", limit=" + this.limit + ", querySort=" + this.querySort + ", members=" + this.members + ")";
    }

    public QueryMembersRequest(String str, String str2, FilterObject filterObject, int i, int i2, QuerySort<Member> querySort2, List<Member> list) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort2, "querySort");
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        this.channelType = str;
        this.channelId = str2;
        this.filter = filterObject;
        this.offset = i;
        this.limit = i2;
        this.querySort = querySort2;
        this.members = list;
        this.sort = querySort2.toDto();
        this.filter_conditions = this.filter.toMap();
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final String getChannelId() {
        return this.channelId;
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
    public /* synthetic */ QueryMembersRequest(String str, String str2, FilterObject filterObject, int i, int i2, QuerySort querySort2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, filterObject, i, i2, (i3 & 32) != 0 ? new QuerySort() : querySort2, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final QuerySort<Member> getQuerySort() {
        return this.querySort;
    }

    public final void setQuerySort(QuerySort<Member> querySort2) {
        Intrinsics.checkNotNullParameter(querySort2, "<set-?>");
        this.querySort = querySort2;
    }

    public final List<Member> getMembers() {
        return this.members;
    }

    public final List<Map<String, Object>> getSort() {
        return this.sort;
    }

    public final Map<String, Object> getFilter_conditions() {
        return this.filter_conditions;
    }
}
