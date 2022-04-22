package p015io.getstream.chat.android.livedata.repository.domain.reaction;

import com.google.firebase.messaging.Constants;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0011HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J\u0015\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000fHÆ\u0003J\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0007HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 ¨\u00066"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionEntity;", "", "messageId", "", "userId", "type", "score", "", "createdAt", "Ljava/util/Date;", "updatedAt", "deletedAt", "enforceUnique", "", "extraData", "", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Date;Ljava/util/Date;Ljava/util/Date;ZLjava/util/Map;Lio/getstream/chat/android/client/utils/SyncStatus;)V", "getCreatedAt", "()Ljava/util/Date;", "getDeletedAt", "getEnforceUnique", "()Z", "getExtraData", "()Ljava/util/Map;", "id", "getId", "()I", "setId", "(I)V", "getMessageId", "()Ljava/lang/String;", "getScore", "getSyncStatus", "()Lio/getstream/chat/android/client/utils/SyncStatus;", "getType", "getUpdatedAt", "getUserId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity */
/* compiled from: ReactionEntity.kt */
public final class ReactionEntity {
    private final Date createdAt;
    private final Date deletedAt;
    private final boolean enforceUnique;
    private final Map<String, Object> extraData;

    /* renamed from: id */
    private int f1471id;
    private final String messageId;
    private final int score;
    private final SyncStatus syncStatus;
    private final String type;
    private final Date updatedAt;
    private final String userId;

    public static /* synthetic */ ReactionEntity copy$default(ReactionEntity reactionEntity, String str, String str2, String str3, int i, Date date, Date date2, Date date3, boolean z, Map map, SyncStatus syncStatus2, int i2, Object obj) {
        ReactionEntity reactionEntity2 = reactionEntity;
        int i3 = i2;
        return reactionEntity.copy((i3 & 1) != 0 ? reactionEntity2.messageId : str, (i3 & 2) != 0 ? reactionEntity2.userId : str2, (i3 & 4) != 0 ? reactionEntity2.type : str3, (i3 & 8) != 0 ? reactionEntity2.score : i, (i3 & 16) != 0 ? reactionEntity2.createdAt : date, (i3 & 32) != 0 ? reactionEntity2.updatedAt : date2, (i3 & 64) != 0 ? reactionEntity2.deletedAt : date3, (i3 & 128) != 0 ? reactionEntity2.enforceUnique : z, (i3 & 256) != 0 ? reactionEntity2.extraData : map, (i3 & 512) != 0 ? reactionEntity2.syncStatus : syncStatus2);
    }

    public final String component1() {
        return this.messageId;
    }

    public final SyncStatus component10() {
        return this.syncStatus;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.type;
    }

    public final int component4() {
        return this.score;
    }

    public final Date component5() {
        return this.createdAt;
    }

    public final Date component6() {
        return this.updatedAt;
    }

    public final Date component7() {
        return this.deletedAt;
    }

    public final boolean component8() {
        return this.enforceUnique;
    }

    public final Map<String, Object> component9() {
        return this.extraData;
    }

    public final ReactionEntity copy(String str, String str2, String str3, int i, Date date, Date date2, Date date3, boolean z, Map<String, ? extends Object> map, SyncStatus syncStatus2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str3, "type");
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extraData");
        SyncStatus syncStatus3 = syncStatus2;
        Intrinsics.checkNotNullParameter(syncStatus3, "syncStatus");
        return new ReactionEntity(str, str2, str3, i, date, date2, date3, z, map2, syncStatus3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactionEntity)) {
            return false;
        }
        ReactionEntity reactionEntity = (ReactionEntity) obj;
        return Intrinsics.areEqual((Object) this.messageId, (Object) reactionEntity.messageId) && Intrinsics.areEqual((Object) this.userId, (Object) reactionEntity.userId) && Intrinsics.areEqual((Object) this.type, (Object) reactionEntity.type) && this.score == reactionEntity.score && Intrinsics.areEqual((Object) this.createdAt, (Object) reactionEntity.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) reactionEntity.updatedAt) && Intrinsics.areEqual((Object) this.deletedAt, (Object) reactionEntity.deletedAt) && this.enforceUnique == reactionEntity.enforceUnique && Intrinsics.areEqual((Object) this.extraData, (Object) reactionEntity.extraData) && Intrinsics.areEqual((Object) this.syncStatus, (Object) reactionEntity.syncStatus);
    }

    public int hashCode() {
        String str = this.messageId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.score) * 31;
        Date date = this.createdAt;
        int hashCode4 = (hashCode3 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode5 = (hashCode4 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.deletedAt;
        int hashCode6 = (hashCode5 + (date3 != null ? date3.hashCode() : 0)) * 31;
        boolean z = this.enforceUnique;
        if (z) {
            z = true;
        }
        int i2 = (hashCode6 + (z ? 1 : 0)) * 31;
        Map<String, Object> map = this.extraData;
        int hashCode7 = (i2 + (map != null ? map.hashCode() : 0)) * 31;
        SyncStatus syncStatus2 = this.syncStatus;
        if (syncStatus2 != null) {
            i = syncStatus2.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "ReactionEntity(messageId=" + this.messageId + ", userId=" + this.userId + ", type=" + this.type + ", score=" + this.score + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ", enforceUnique=" + this.enforceUnique + ", extraData=" + this.extraData + ", syncStatus=" + this.syncStatus + ")";
    }

    public ReactionEntity(String str, String str2, String str3, int i, Date date, Date date2, Date date3, boolean z, Map<String, ? extends Object> map, SyncStatus syncStatus2) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(map, "extraData");
        Intrinsics.checkNotNullParameter(syncStatus2, "syncStatus");
        this.messageId = str;
        this.userId = str2;
        this.type = str3;
        this.score = i;
        this.createdAt = date;
        this.updatedAt = date2;
        this.deletedAt = date3;
        this.enforceUnique = z;
        this.extraData = map;
        this.syncStatus = syncStatus2;
        this.f1471id = str.hashCode() + str2.hashCode() + str3.hashCode();
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getType() {
        return this.type;
    }

    public final int getScore() {
        return this.score;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ReactionEntity(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, java.util.Date r18, java.util.Date r19, java.util.Date r20, boolean r21, java.util.Map r22, p015io.getstream.chat.android.client.utils.SyncStatus r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0009
            r1 = 1
            r6 = 1
            goto L_0x000b
        L_0x0009:
            r6 = r17
        L_0x000b:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0015
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r7 = r1
            goto L_0x0017
        L_0x0015:
            r7 = r18
        L_0x0017:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0020
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r8 = r1
            goto L_0x0022
        L_0x0020:
            r8 = r19
        L_0x0022:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002b
            r1 = r2
            java.util.Date r1 = (java.util.Date) r1
            r9 = r1
            goto L_0x002d
        L_0x002b:
            r9 = r20
        L_0x002d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            r10 = 0
            goto L_0x0036
        L_0x0034:
            r10 = r21
        L_0x0036:
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r11 = r22
            r12 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.util.Date, java.util.Date, java.util.Date, boolean, java.util.Map, io.getstream.chat.android.client.utils.SyncStatus, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final Date getDeletedAt() {
        return this.deletedAt;
    }

    public final boolean getEnforceUnique() {
        return this.enforceUnique;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final SyncStatus getSyncStatus() {
        return this.syncStatus;
    }

    public final int getId() {
        return this.f1471id;
    }

    public final void setId(int i) {
        this.f1471id = i;
    }
}
