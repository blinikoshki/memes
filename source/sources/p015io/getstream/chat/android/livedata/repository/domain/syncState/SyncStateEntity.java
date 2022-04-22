package p015io.getstream.chat.android.livedata.repository.domain.syncState;

import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/syncState/SyncStateEntity;", "", "userId", "", "activeChannelIds", "", "activeQueryIds", "lastSyncedAt", "Ljava/util/Date;", "markedAllReadAt", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Date;Ljava/util/Date;)V", "getActiveChannelIds", "()Ljava/util/List;", "setActiveChannelIds", "(Ljava/util/List;)V", "getActiveQueryIds", "setActiveQueryIds", "getLastSyncedAt", "()Ljava/util/Date;", "setLastSyncedAt", "(Ljava/util/Date;)V", "getMarkedAllReadAt", "setMarkedAllReadAt", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.syncState.SyncStateEntity */
/* compiled from: SyncStateEntity.kt */
public final class SyncStateEntity {
    private List<String> activeChannelIds;
    private List<String> activeQueryIds;
    private Date lastSyncedAt;
    private Date markedAllReadAt;
    private String userId;

    public static /* synthetic */ SyncStateEntity copy$default(SyncStateEntity syncStateEntity, String str, List<String> list, List<String> list2, Date date, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = syncStateEntity.userId;
        }
        if ((i & 2) != 0) {
            list = syncStateEntity.activeChannelIds;
        }
        List<String> list3 = list;
        if ((i & 4) != 0) {
            list2 = syncStateEntity.activeQueryIds;
        }
        List<String> list4 = list2;
        if ((i & 8) != 0) {
            date = syncStateEntity.lastSyncedAt;
        }
        Date date3 = date;
        if ((i & 16) != 0) {
            date2 = syncStateEntity.markedAllReadAt;
        }
        return syncStateEntity.copy(str, list3, list4, date3, date2);
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

    public final SyncStateEntity copy(String str, List<String> list, List<String> list2, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(str, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(list, "activeChannelIds");
        Intrinsics.checkNotNullParameter(list2, "activeQueryIds");
        return new SyncStateEntity(str, list, list2, date, date2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncStateEntity)) {
            return false;
        }
        SyncStateEntity syncStateEntity = (SyncStateEntity) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) syncStateEntity.userId) && Intrinsics.areEqual((Object) this.activeChannelIds, (Object) syncStateEntity.activeChannelIds) && Intrinsics.areEqual((Object) this.activeQueryIds, (Object) syncStateEntity.activeQueryIds) && Intrinsics.areEqual((Object) this.lastSyncedAt, (Object) syncStateEntity.lastSyncedAt) && Intrinsics.areEqual((Object) this.markedAllReadAt, (Object) syncStateEntity.markedAllReadAt);
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
        return "SyncStateEntity(userId=" + this.userId + ", activeChannelIds=" + this.activeChannelIds + ", activeQueryIds=" + this.activeQueryIds + ", lastSyncedAt=" + this.lastSyncedAt + ", markedAllReadAt=" + this.markedAllReadAt + ")";
    }

    public SyncStateEntity(String str, List<String> list, List<String> list2, Date date, Date date2) {
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

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncStateEntity(String str, List list, List list2, Date date, Date date2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? new ArrayList() : list2, (i & 8) != 0 ? null : date, (i & 16) != 0 ? null : date2);
    }

    public final List<String> getActiveChannelIds() {
        return this.activeChannelIds;
    }

    public final void setActiveChannelIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.activeChannelIds = list;
    }

    public final List<String> getActiveQueryIds() {
        return this.activeQueryIds;
    }

    public final void setActiveQueryIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.activeQueryIds = list;
    }

    public final Date getLastSyncedAt() {
        return this.lastSyncedAt;
    }

    public final void setLastSyncedAt(Date date) {
        this.lastSyncedAt = date;
    }

    public final Date getMarkedAllReadAt() {
        return this.markedAllReadAt;
    }

    public final void setMarkedAllReadAt(Date date) {
        this.markedAllReadAt = date;
    }
}
