package p015io.getstream.chat.android.livedata.controller;

import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/QueryChannelsSpec;", "", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "cids", "", "", "(Lio/getstream/chat/android/client/utils/FilterObject;Lio/getstream/chat/android/client/api/models/QuerySort;Ljava/util/List;)V", "getCids", "()Ljava/util/List;", "setCids", "(Ljava/util/List;)V", "getFilter", "()Lio/getstream/chat/android/client/utils/FilterObject;", "id", "getId", "()Ljava/lang/String;", "getSort", "()Lio/getstream/chat/android/client/api/models/QuerySort;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsSpec */
/* compiled from: QueryChannelsSpec.kt */
public final class QueryChannelsSpec {
    private List<String> cids;
    private final FilterObject filter;
    private final QuerySort<Channel> sort;

    public static /* synthetic */ QueryChannelsSpec copy$default(QueryChannelsSpec queryChannelsSpec, FilterObject filterObject, QuerySort<Channel> querySort, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            filterObject = queryChannelsSpec.filter;
        }
        if ((i & 2) != 0) {
            querySort = queryChannelsSpec.sort;
        }
        if ((i & 4) != 0) {
            list = queryChannelsSpec.cids;
        }
        return queryChannelsSpec.copy(filterObject, querySort, list);
    }

    public final FilterObject component1() {
        return this.filter;
    }

    public final QuerySort<Channel> component2() {
        return this.sort;
    }

    public final List<String> component3() {
        return this.cids;
    }

    public final QueryChannelsSpec copy(FilterObject filterObject, QuerySort<Channel> querySort, List<String> list) {
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort, "sort");
        Intrinsics.checkNotNullParameter(list, "cids");
        return new QueryChannelsSpec(filterObject, querySort, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryChannelsSpec)) {
            return false;
        }
        QueryChannelsSpec queryChannelsSpec = (QueryChannelsSpec) obj;
        return Intrinsics.areEqual((Object) this.filter, (Object) queryChannelsSpec.filter) && Intrinsics.areEqual((Object) this.sort, (Object) queryChannelsSpec.sort) && Intrinsics.areEqual((Object) this.cids, (Object) queryChannelsSpec.cids);
    }

    public int hashCode() {
        FilterObject filterObject = this.filter;
        int i = 0;
        int hashCode = (filterObject != null ? filterObject.hashCode() : 0) * 31;
        QuerySort<Channel> querySort = this.sort;
        int hashCode2 = (hashCode + (querySort != null ? querySort.hashCode() : 0)) * 31;
        List<String> list = this.cids;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "QueryChannelsSpec(filter=" + this.filter + ", sort=" + this.sort + ", cids=" + this.cids + ")";
    }

    public QueryChannelsSpec(FilterObject filterObject, QuerySort<Channel> querySort, List<String> list) {
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort, "sort");
        Intrinsics.checkNotNullParameter(list, "cids");
        this.filter = filterObject;
        this.sort = querySort;
        this.cids = list;
    }

    public final FilterObject getFilter() {
        return this.filter;
    }

    public final QuerySort<Channel> getSort() {
        return this.sort;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryChannelsSpec(FilterObject filterObject, QuerySort querySort, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(filterObject, querySort, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<String> getCids() {
        return this.cids;
    }

    public final void setCids(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cids = list;
    }

    public final String getId() {
        return String.valueOf(Objects.hash(new Object[]{this.filter.toMap()}) + Objects.hash(new Object[]{this.sort.toDto()}));
    }
}
