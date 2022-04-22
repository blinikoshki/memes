package p015io.getstream.chat.android.livedata.repository.domain.queryChannels;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsEntity;", "", "id", "", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "cids", "", "(Ljava/lang/String;Lio/getstream/chat/android/client/utils/FilterObject;Ljava/util/List;)V", "getCids", "()Ljava/util/List;", "getFilter", "()Lio/getstream/chat/android/client/utils/FilterObject;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsEntity */
/* compiled from: QueryChannelsEntity.kt */
public final class QueryChannelsEntity {
    private final List<String> cids;
    private final FilterObject filter;

    /* renamed from: id */
    private String f1470id;

    public static /* synthetic */ QueryChannelsEntity copy$default(QueryChannelsEntity queryChannelsEntity, String str, FilterObject filterObject, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = queryChannelsEntity.f1470id;
        }
        if ((i & 2) != 0) {
            filterObject = queryChannelsEntity.filter;
        }
        if ((i & 4) != 0) {
            list = queryChannelsEntity.cids;
        }
        return queryChannelsEntity.copy(str, filterObject, list);
    }

    public final String component1() {
        return this.f1470id;
    }

    public final FilterObject component2() {
        return this.filter;
    }

    public final List<String> component3() {
        return this.cids;
    }

    public final QueryChannelsEntity copy(String str, FilterObject filterObject, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(list, "cids");
        return new QueryChannelsEntity(str, filterObject, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryChannelsEntity)) {
            return false;
        }
        QueryChannelsEntity queryChannelsEntity = (QueryChannelsEntity) obj;
        return Intrinsics.areEqual((Object) this.f1470id, (Object) queryChannelsEntity.f1470id) && Intrinsics.areEqual((Object) this.filter, (Object) queryChannelsEntity.filter) && Intrinsics.areEqual((Object) this.cids, (Object) queryChannelsEntity.cids);
    }

    public int hashCode() {
        String str = this.f1470id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        FilterObject filterObject = this.filter;
        int hashCode2 = (hashCode + (filterObject != null ? filterObject.hashCode() : 0)) * 31;
        List<String> list = this.cids;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "QueryChannelsEntity(id=" + this.f1470id + ", filter=" + this.filter + ", cids=" + this.cids + ")";
    }

    public QueryChannelsEntity(String str, FilterObject filterObject, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(list, "cids");
        this.f1470id = str;
        this.filter = filterObject;
        this.cids = list;
    }

    public final String getId() {
        return this.f1470id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1470id = str;
    }

    public final FilterObject getFilter() {
        return this.filter;
    }

    public final List<String> getCids() {
        return this.cids;
    }
}
