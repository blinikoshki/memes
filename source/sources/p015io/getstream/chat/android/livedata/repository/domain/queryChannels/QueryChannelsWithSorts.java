package p015io.getstream.chat.android.livedata.repository.domain.queryChannels;

import com.google.android.gms.actions.SearchIntents;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsWithSorts;", "", "query", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsEntity;", "sortInnerEntities", "", "Lio/getstream/chat/android/livedata/repository/domain/queryChannels/ChannelSortInnerEntity;", "(Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsEntity;Ljava/util/List;)V", "getQuery", "()Lio/getstream/chat/android/livedata/repository/domain/queryChannels/QueryChannelsEntity;", "getSortInnerEntities", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.queryChannels.QueryChannelsWithSorts */
/* compiled from: QueryChannelsEntity.kt */
public final class QueryChannelsWithSorts {
    private final QueryChannelsEntity query;
    private final List<ChannelSortInnerEntity> sortInnerEntities;

    public static /* synthetic */ QueryChannelsWithSorts copy$default(QueryChannelsWithSorts queryChannelsWithSorts, QueryChannelsEntity queryChannelsEntity, List<ChannelSortInnerEntity> list, int i, Object obj) {
        if ((i & 1) != 0) {
            queryChannelsEntity = queryChannelsWithSorts.query;
        }
        if ((i & 2) != 0) {
            list = queryChannelsWithSorts.sortInnerEntities;
        }
        return queryChannelsWithSorts.copy(queryChannelsEntity, list);
    }

    public final QueryChannelsEntity component1() {
        return this.query;
    }

    public final List<ChannelSortInnerEntity> component2() {
        return this.sortInnerEntities;
    }

    public final QueryChannelsWithSorts copy(QueryChannelsEntity queryChannelsEntity, List<ChannelSortInnerEntity> list) {
        Intrinsics.checkNotNullParameter(queryChannelsEntity, SearchIntents.EXTRA_QUERY);
        Intrinsics.checkNotNullParameter(list, "sortInnerEntities");
        return new QueryChannelsWithSorts(queryChannelsEntity, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryChannelsWithSorts)) {
            return false;
        }
        QueryChannelsWithSorts queryChannelsWithSorts = (QueryChannelsWithSorts) obj;
        return Intrinsics.areEqual((Object) this.query, (Object) queryChannelsWithSorts.query) && Intrinsics.areEqual((Object) this.sortInnerEntities, (Object) queryChannelsWithSorts.sortInnerEntities);
    }

    public int hashCode() {
        QueryChannelsEntity queryChannelsEntity = this.query;
        int i = 0;
        int hashCode = (queryChannelsEntity != null ? queryChannelsEntity.hashCode() : 0) * 31;
        List<ChannelSortInnerEntity> list = this.sortInnerEntities;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "QueryChannelsWithSorts(query=" + this.query + ", sortInnerEntities=" + this.sortInnerEntities + ")";
    }

    public QueryChannelsWithSorts(QueryChannelsEntity queryChannelsEntity, List<ChannelSortInnerEntity> list) {
        Intrinsics.checkNotNullParameter(queryChannelsEntity, SearchIntents.EXTRA_QUERY);
        Intrinsics.checkNotNullParameter(list, "sortInnerEntities");
        this.query = queryChannelsEntity;
        this.sortInnerEntities = list;
    }

    public final QueryChannelsEntity getQuery() {
        return this.query;
    }

    public final List<ChannelSortInnerEntity> getSortInnerEntities() {
        return this.sortInnerEntities;
    }
}
