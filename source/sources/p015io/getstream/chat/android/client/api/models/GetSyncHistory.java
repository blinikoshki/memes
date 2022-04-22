package p015io.getstream.chat.android.client.api.models;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/GetSyncHistory;", "", "channel_cids", "", "", "last_sync_at", "Ljava/util/Date;", "(Ljava/util/List;Ljava/util/Date;)V", "getChannel_cids", "()Ljava/util/List;", "getLast_sync_at", "()Ljava/util/Date;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.GetSyncHistory */
/* compiled from: GetSyncHistory.kt */
public final class GetSyncHistory {
    private final List<String> channel_cids;
    private final Date last_sync_at;

    public static /* synthetic */ GetSyncHistory copy$default(GetSyncHistory getSyncHistory, List<String> list, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            list = getSyncHistory.channel_cids;
        }
        if ((i & 2) != 0) {
            date = getSyncHistory.last_sync_at;
        }
        return getSyncHistory.copy(list, date);
    }

    public final List<String> component1() {
        return this.channel_cids;
    }

    public final Date component2() {
        return this.last_sync_at;
    }

    public final GetSyncHistory copy(List<String> list, Date date) {
        Intrinsics.checkNotNullParameter(list, "channel_cids");
        Intrinsics.checkNotNullParameter(date, "last_sync_at");
        return new GetSyncHistory(list, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetSyncHistory)) {
            return false;
        }
        GetSyncHistory getSyncHistory = (GetSyncHistory) obj;
        return Intrinsics.areEqual((Object) this.channel_cids, (Object) getSyncHistory.channel_cids) && Intrinsics.areEqual((Object) this.last_sync_at, (Object) getSyncHistory.last_sync_at);
    }

    public int hashCode() {
        List<String> list = this.channel_cids;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Date date = this.last_sync_at;
        if (date != null) {
            i = date.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GetSyncHistory(channel_cids=" + this.channel_cids + ", last_sync_at=" + this.last_sync_at + ")";
    }

    public GetSyncHistory(List<String> list, Date date) {
        Intrinsics.checkNotNullParameter(list, "channel_cids");
        Intrinsics.checkNotNullParameter(date, "last_sync_at");
        this.channel_cids = list;
        this.last_sync_at = date;
    }

    public final List<String> getChannel_cids() {
        return this.channel_cids;
    }

    public final Date getLast_sync_at() {
        return this.last_sync_at;
    }
}
