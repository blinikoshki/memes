package p015io.getstream.chat.android.livedata.model;

import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003JK\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/model/SyncState;", "", "userId", "", "activeChannelIds", "", "activeQueryIds", "lastSyncedAt", "Ljava/util/Date;", "markedAllReadAt", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Date;Ljava/util/Date;)V", "getActiveChannelIds", "()Ljava/util/List;", "getActiveQueryIds", "getLastSyncedAt", "()Ljava/util/Date;", "getMarkedAllReadAt", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.model.SyncState */
/* compiled from: SyncState.kt */
public final class SyncState {
    private final List<String> activeChannelIds;
    private final List<String> activeQueryIds;
    private final Date lastSyncedAt;
    private final Date markedAllReadAt;
    private final String userId;

    public static /* synthetic */ SyncState copy$default(SyncState syncState, String str, List<String> list, List<String> list2, Date date, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = syncState.userId;
        }
        if ((i & 2) != 0) {
            list = syncState.activeChannelIds;
        }
        List<String> list3 = list;
        if ((i & 4) != 0) {
            list2 = syncState.activeQueryIds;
        }
        List<String> list4 = list2;
        if ((i & 8) != 0) {
            date = syncState.lastSyncedAt;
        }
        Date date3 = date;
        if ((i & 16) != 0) {
            date2 = syncState.markedAllReadAt;
        }
        return syncState.copy(str, list3, list4, date3, date2);
    }

    public final String component1() {
        return this.userId;
    }

    public final List<String> component2() {
        return this.activeChannelIds;
    }

    public final List<String> component3() {
        return this.activeQueryIds;
    }

    public final Date component4() {
        return this.lastSyncedAt;
    }

    public final Date component5() {
        return this.markedAllReadAt;
    }

    public final SyncState copy(String str, List<String> list, List<String> list2, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(list, "activeChannelIds");
        Intrinsics.checkNotNullParameter(list2, "activeQueryIds");
        return new SyncState(str, list, list2, date, date2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncState)) {
            return false;
        }
        SyncState syncState = (SyncState) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) syncState.userId) && Intrinsics.areEqual((Object) this.activeChannelIds, (Object) syncState.activeChannelIds) && Intrinsics.areEqual((Object) this.activeQueryIds, (Object) syncState.activeQueryIds) && Intrinsics.areEqual((Object) this.lastSyncedAt, (Object) syncState.lastSyncedAt) && Intrinsics.areEqual((Object) this.markedAllReadAt, (Object) syncState.markedAllReadAt);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.activeChannelIds;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.activeQueryIds;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Date date = this.lastSyncedAt;
        int hashCode4 = (hashCode3 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.markedAllReadAt;
        if (date2 != null) {
            i = date2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "SyncState(userId=" + this.userId + ", activeChannelIds=" + this.activeChannelIds + ", activeQueryIds=" + this.activeQueryIds + ", lastSyncedAt=" + this.lastSyncedAt + ", markedAllReadAt=" + this.markedAllReadAt + ")";
    }

    public SyncState(String str, List<String> list, List<String> list2, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(list, "activeChannelIds");
        Intrinsics.checkNotNullParameter(list2, "activeQueryIds");
        this.userId = str;
        this.activeChannelIds = list;
        this.activeQueryIds = list2;
        this.lastSyncedAt = date;
        this.markedAllReadAt = date2;
    }

    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncState(String str, List list, List list2, Date date, Date date2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? null : date, (i & 16) != 0 ? null : date2);
    }

    public final List<String> getActiveChannelIds() {
        return this.activeChannelIds;
    }

    public final List<String> getActiveQueryIds() {
        return this.activeQueryIds;
    }

    public final Date getLastSyncedAt() {
        return this.lastSyncedAt;
    }

    public final Date getMarkedAllReadAt() {
        return this.markedAllReadAt;
    }
}
