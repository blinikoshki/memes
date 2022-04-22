package p015io.getstream.chat.android.livedata.repository.domain.message;

import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b;\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0015\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\u0010\u001eJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0003J\u0015\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0015HÆ\u0003J\u0015\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u001aHÆ\u0003J\u0015\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0015HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\u000bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013HÆ\u0001J\u0013\u0010Q\u001a\u00020\u001a2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u000bHÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b8\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010 ¨\u0006U"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/MessageInnerEntity;", "", "id", "", "cid", "userId", "text", "type", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "replyCount", "", "createdAt", "Ljava/util/Date;", "createdLocallyAt", "updatedAt", "updatedLocallyAt", "deletedAt", "mentionedUsersId", "", "reactionCounts", "", "reactionScores", "parentId", "command", "shadowed", "", "extraData", "replyToId", "threadParticipantsIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/getstream/chat/android/client/utils/SyncStatus;ILjava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;Ljava/util/List;)V", "getCid", "()Ljava/lang/String;", "getCommand", "getCreatedAt", "()Ljava/util/Date;", "getCreatedLocallyAt", "getDeletedAt", "getExtraData", "()Ljava/util/Map;", "getId", "getMentionedUsersId", "()Ljava/util/List;", "getParentId", "getReactionCounts", "getReactionScores", "getReplyCount", "()I", "getReplyToId", "getShadowed", "()Z", "getSyncStatus", "()Lio/getstream/chat/android/client/utils/SyncStatus;", "getText", "getThreadParticipantsIds", "getType", "getUpdatedAt", "getUpdatedLocallyAt", "getUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity */
/* compiled from: MessageEntity.kt */
public final class MessageInnerEntity {
    private final String cid;
    private final String command;
    private final Date createdAt;
    private final Date createdLocallyAt;
    private final Date deletedAt;
    private final Map<String, Object> extraData;

    /* renamed from: id */
    private final String f1467id;
    private final List<String> mentionedUsersId;
    private final String parentId;
    private final Map<String, Integer> reactionCounts;
    private final Map<String, Integer> reactionScores;
    private final int replyCount;
    private final String replyToId;
    private final boolean shadowed;
    private final SyncStatus syncStatus;
    private final String text;
    private final List<String> threadParticipantsIds;
    private final String type;
    private final Date updatedAt;
    private final Date updatedLocallyAt;
    private final String userId;

    public static /* synthetic */ MessageInnerEntity copy$default(MessageInnerEntity messageInnerEntity, String str, String str2, String str3, String str4, String str5, SyncStatus syncStatus2, int i, Date date, Date date2, Date date3, Date date4, Date date5, List list, Map map, Map map2, String str6, String str7, boolean z, Map map3, String str8, List list2, int i2, Object obj) {
        MessageInnerEntity messageInnerEntity2 = messageInnerEntity;
        int i3 = i2;
        return messageInnerEntity.copy((i3 & 1) != 0 ? messageInnerEntity2.f1467id : str, (i3 & 2) != 0 ? messageInnerEntity2.cid : str2, (i3 & 4) != 0 ? messageInnerEntity2.userId : str3, (i3 & 8) != 0 ? messageInnerEntity2.text : str4, (i3 & 16) != 0 ? messageInnerEntity2.type : str5, (i3 & 32) != 0 ? messageInnerEntity2.syncStatus : syncStatus2, (i3 & 64) != 0 ? messageInnerEntity2.replyCount : i, (i3 & 128) != 0 ? messageInnerEntity2.createdAt : date, (i3 & 256) != 0 ? messageInnerEntity2.createdLocallyAt : date2, (i3 & 512) != 0 ? messageInnerEntity2.updatedAt : date3, (i3 & 1024) != 0 ? messageInnerEntity2.updatedLocallyAt : date4, (i3 & 2048) != 0 ? messageInnerEntity2.deletedAt : date5, (i3 & 4096) != 0 ? messageInnerEntity2.mentionedUsersId : list, (i3 & 8192) != 0 ? messageInnerEntity2.reactionCounts : map, (i3 & 16384) != 0 ? messageInnerEntity2.reactionScores : map2, (i3 & 32768) != 0 ? messageInnerEntity2.parentId : str6, (i3 & 65536) != 0 ? messageInnerEntity2.command : str7, (i3 & 131072) != 0 ? messageInnerEntity2.shadowed : z, (i3 & 262144) != 0 ? messageInnerEntity2.extraData : map3, (i3 & 524288) != 0 ? messageInnerEntity2.replyToId : str8, (i3 & 1048576) != 0 ? messageInnerEntity2.threadParticipantsIds : list2);
    }

    public final String component1() {
        return this.f1467id;
    }

    public final Date component10() {
        return this.updatedAt;
    }

    public final Date component11() {
        return this.updatedLocallyAt;
    }

    public final Date component12() {
        return this.deletedAt;
    }

    public final List<String> component13() {
        return this.mentionedUsersId;
    }

    public final Map<String, Integer> component14() {
        return this.reactionCounts;
    }

    public final Map<String, Integer> component15() {
        return this.reactionScores;
    }

    public final String component16() {
        return this.parentId;
    }

    public final String component17() {
        return this.command;
    }

    public final boolean component18() {
        return this.shadowed;
    }

    public final Map<String, Object> component19() {
        return this.extraData;
    }

    public final String component2() {
        return this.cid;
    }

    public final String component20() {
        return this.replyToId;
    }

    public final List<String> component21() {
        return this.threadParticipantsIds;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.text;
    }

    public final String component5() {
        return this.type;
    }

    public final SyncStatus component6() {
        return this.syncStatus;
    }

    public final int component7() {
        return this.replyCount;
    }

    public final Date component8() {
        return this.createdAt;
    }

    public final Date component9() {
        return this.createdLocallyAt;
    }

    public final MessageInnerEntity copy(String str, String str2, String str3, String str4, String str5, SyncStatus syncStatus2, int i, Date date, Date date2, Date date3, Date date4, Date date5, List<String> list, Map<String, Integer> map, Map<String, Integer> map2, String str6, String str7, boolean z, Map<String, ? extends Object> map3, String str8, List<String> list2) {
        String str9 = str;
        Intrinsics.checkNotNullParameter(str9, "id");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str4, "text");
        Intrinsics.checkNotNullParameter(str5, "type");
        Intrinsics.checkNotNullParameter(syncStatus2, "syncStatus");
        Intrinsics.checkNotNullParameter(list, "mentionedUsersId");
        Intrinsics.checkNotNullParameter(map, "reactionCounts");
        Intrinsics.checkNotNullParameter(map2, "reactionScores");
        Intrinsics.checkNotNullParameter(map3, "extraData");
        Intrinsics.checkNotNullParameter(list2, "threadParticipantsIds");
        return new MessageInnerEntity(str9, str2, str3, str4, str5, syncStatus2, i, date, date2, date3, date4, date5, list, map, map2, str6, str7, z, map3, str8, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageInnerEntity)) {
            return false;
        }
        MessageInnerEntity messageInnerEntity = (MessageInnerEntity) obj;
        return Intrinsics.areEqual((Object) this.f1467id, (Object) messageInnerEntity.f1467id) && Intrinsics.areEqual((Object) this.cid, (Object) messageInnerEntity.cid) && Intrinsics.areEqual((Object) this.userId, (Object) messageInnerEntity.userId) && Intrinsics.areEqual((Object) this.text, (Object) messageInnerEntity.text) && Intrinsics.areEqual((Object) this.type, (Object) messageInnerEntity.type) && Intrinsics.areEqual((Object) this.syncStatus, (Object) messageInnerEntity.syncStatus) && this.replyCount == messageInnerEntity.replyCount && Intrinsics.areEqual((Object) this.createdAt, (Object) messageInnerEntity.createdAt) && Intrinsics.areEqual((Object) this.createdLocallyAt, (Object) messageInnerEntity.createdLocallyAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) messageInnerEntity.updatedAt) && Intrinsics.areEqual((Object) this.updatedLocallyAt, (Object) messageInnerEntity.updatedLocallyAt) && Intrinsics.areEqual((Object) this.deletedAt, (Object) messageInnerEntity.deletedAt) && Intrinsics.areEqual((Object) this.mentionedUsersId, (Object) messageInnerEntity.mentionedUsersId) && Intrinsics.areEqual((Object) this.reactionCounts, (Object) messageInnerEntity.reactionCounts) && Intrinsics.areEqual((Object) this.reactionScores, (Object) messageInnerEntity.reactionScores) && Intrinsics.areEqual((Object) this.parentId, (Object) messageInnerEntity.parentId) && Intrinsics.areEqual((Object) this.command, (Object) messageInnerEntity.command) && this.shadowed == messageInnerEntity.shadowed && Intrinsics.areEqual((Object) this.extraData, (Object) messageInnerEntity.extraData) && Intrinsics.areEqual((Object) this.replyToId, (Object) messageInnerEntity.replyToId) && Intrinsics.areEqual((Object) this.threadParticipantsIds, (Object) messageInnerEntity.threadParticipantsIds);
    }

    public int hashCode() {
        String str = this.f1467id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.userId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.text;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.type;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        SyncStatus syncStatus2 = this.syncStatus;
        int hashCode6 = (((hashCode5 + (syncStatus2 != null ? syncStatus2.hashCode() : 0)) * 31) + this.replyCount) * 31;
        Date date = this.createdAt;
        int hashCode7 = (hashCode6 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.createdLocallyAt;
        int hashCode8 = (hashCode7 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.updatedAt;
        int hashCode9 = (hashCode8 + (date3 != null ? date3.hashCode() : 0)) * 31;
        Date date4 = this.updatedLocallyAt;
        int hashCode10 = (hashCode9 + (date4 != null ? date4.hashCode() : 0)) * 31;
        Date date5 = this.deletedAt;
        int hashCode11 = (hashCode10 + (date5 != null ? date5.hashCode() : 0)) * 31;
        List<String> list = this.mentionedUsersId;
        int hashCode12 = (hashCode11 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, Integer> map = this.reactionCounts;
        int hashCode13 = (hashCode12 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, Integer> map2 = this.reactionScores;
        int hashCode14 = (hashCode13 + (map2 != null ? map2.hashCode() : 0)) * 31;
        String str6 = this.parentId;
        int hashCode15 = (hashCode14 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.command;
        int hashCode16 = (hashCode15 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z = this.shadowed;
        if (z) {
            z = true;
        }
        int i2 = (hashCode16 + (z ? 1 : 0)) * 31;
        Map<String, Object> map3 = this.extraData;
        int hashCode17 = (i2 + (map3 != null ? map3.hashCode() : 0)) * 31;
        String str8 = this.replyToId;
        int hashCode18 = (hashCode17 + (str8 != null ? str8.hashCode() : 0)) * 31;
        List<String> list2 = this.threadParticipantsIds;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode18 + i;
    }

    public String toString() {
        return "MessageInnerEntity(id=" + this.f1467id + ", cid=" + this.cid + ", userId=" + this.userId + ", text=" + this.text + ", type=" + this.type + ", syncStatus=" + this.syncStatus + ", replyCount=" + this.replyCount + ", createdAt=" + this.createdAt + ", createdLocallyAt=" + this.createdLocallyAt + ", updatedAt=" + this.updatedAt + ", updatedLocallyAt=" + this.updatedLocallyAt + ", deletedAt=" + this.deletedAt + ", mentionedUsersId=" + this.mentionedUsersId + ", reactionCounts=" + this.reactionCounts + ", reactionScores=" + this.reactionScores + ", parentId=" + this.parentId + ", command=" + this.command + ", shadowed=" + this.shadowed + ", extraData=" + this.extraData + ", replyToId=" + this.replyToId + ", threadParticipantsIds=" + this.threadParticipantsIds + ")";
    }

    public MessageInnerEntity(String str, String str2, String str3, String str4, String str5, SyncStatus syncStatus2, int i, Date date, Date date2, Date date3, Date date4, Date date5, List<String> list, Map<String, Integer> map, Map<String, Integer> map2, String str6, String str7, boolean z, Map<String, ? extends Object> map3, String str8, List<String> list2) {
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        SyncStatus syncStatus3 = syncStatus2;
        List<String> list3 = list;
        Map<String, Integer> map4 = map;
        Map<String, Integer> map5 = map2;
        Map<String, ? extends Object> map6 = map3;
        List<String> list4 = list2;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "cid");
        Intrinsics.checkNotNullParameter(str9, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(str10, "text");
        Intrinsics.checkNotNullParameter(str11, "type");
        Intrinsics.checkNotNullParameter(syncStatus3, "syncStatus");
        Intrinsics.checkNotNullParameter(list3, "mentionedUsersId");
        Intrinsics.checkNotNullParameter(map4, "reactionCounts");
        Intrinsics.checkNotNullParameter(map5, "reactionScores");
        Intrinsics.checkNotNullParameter(map6, "extraData");
        Intrinsics.checkNotNullParameter(list4, "threadParticipantsIds");
        this.f1467id = str;
        this.cid = str2;
        this.userId = str9;
        this.text = str10;
        this.type = str11;
        this.syncStatus = syncStatus3;
        this.replyCount = i;
        this.createdAt = date;
        this.createdLocallyAt = date2;
        this.updatedAt = date3;
        this.updatedLocallyAt = date4;
        this.deletedAt = date5;
        this.mentionedUsersId = list3;
        this.reactionCounts = map4;
        this.reactionScores = map5;
        this.parentId = str6;
        this.command = str7;
        this.shadowed = z;
        this.extraData = map6;
        this.replyToId = str8;
        this.threadParticipantsIds = list4;
    }

    public final String getId() {
        return this.f1467id;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessageInnerEntity(java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, p015io.getstream.chat.android.client.utils.SyncStatus r31, int r32, java.util.Date r33, java.util.Date r34, java.util.Date r35, java.util.Date r36, java.util.Date r37, java.util.List r38, java.util.Map r39, java.util.Map r40, java.lang.String r41, java.lang.String r42, boolean r43, java.util.Map r44, java.lang.String r45, java.util.List r46, int r47, kotlin.jvm.internal.DefaultConstructorMarker r48) {
        /*
            r25 = this;
            r0 = r47
            r1 = r0 & 8
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r7 = r2
            goto L_0x000c
        L_0x000a:
            r7 = r29
        L_0x000c:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0012
            r8 = r2
            goto L_0x0014
        L_0x0012:
            r8 = r30
        L_0x0014:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001c
            io.getstream.chat.android.client.utils.SyncStatus r1 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            r9 = r1
            goto L_0x001e
        L_0x001c:
            r9 = r31
        L_0x001e:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0025
            r10 = 0
            goto L_0x0027
        L_0x0025:
            r10 = r32
        L_0x0027:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r3 = 0
            if (r1 == 0) goto L_0x0031
            r1 = r3
            java.util.Date r1 = (java.util.Date) r1
            r11 = r1
            goto L_0x0033
        L_0x0031:
            r11 = r33
        L_0x0033:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003c
            r1 = r3
            java.util.Date r1 = (java.util.Date) r1
            r12 = r1
            goto L_0x003e
        L_0x003c:
            r12 = r34
        L_0x003e:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0047
            r1 = r3
            java.util.Date r1 = (java.util.Date) r1
            r13 = r1
            goto L_0x0049
        L_0x0047:
            r13 = r35
        L_0x0049:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0052
            r1 = r3
            java.util.Date r1 = (java.util.Date) r1
            r14 = r1
            goto L_0x0054
        L_0x0052:
            r14 = r36
        L_0x0054:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x005d
            r1 = r3
            java.util.Date r1 = (java.util.Date) r1
            r15 = r1
            goto L_0x005f
        L_0x005d:
            r15 = r37
        L_0x005f:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x006a
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r16 = r1
            goto L_0x006c
        L_0x006a:
            r16 = r38
        L_0x006c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0077
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r17 = r1
            goto L_0x0079
        L_0x0077:
            r17 = r39
        L_0x0079:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0084
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r18 = r1
            goto L_0x0086
        L_0x0084:
            r18 = r40
        L_0x0086:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0092
            r1 = r3
            java.lang.String r1 = (java.lang.String) r1
            r19 = r1
            goto L_0x0094
        L_0x0092:
            r19 = r41
        L_0x0094:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009f
            r1 = r3
            java.lang.String r1 = (java.lang.String) r1
            r20 = r1
            goto L_0x00a1
        L_0x009f:
            r20 = r42
        L_0x00a1:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a9
            r21 = 0
            goto L_0x00ab
        L_0x00a9:
            r21 = r43
        L_0x00ab:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b7
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r22 = r1
            goto L_0x00b9
        L_0x00b7:
            r22 = r44
        L_0x00b9:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00c5
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r24 = r0
            goto L_0x00c7
        L_0x00c5:
            r24 = r46
        L_0x00c7:
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r23 = r45
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.message.MessageInnerEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, io.getstream.chat.android.client.utils.SyncStatus, int, java.util.Date, java.util.Date, java.util.Date, java.util.Date, java.util.Date, java.util.List, java.util.Map, java.util.Map, java.lang.String, java.lang.String, boolean, java.util.Map, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final SyncStatus getSyncStatus() {
        return this.syncStatus;
    }

    public final int getReplyCount() {
        return this.replyCount;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getCreatedLocallyAt() {
        return this.createdLocallyAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final Date getUpdatedLocallyAt() {
        return this.updatedLocallyAt;
    }

    public final Date getDeletedAt() {
        return this.deletedAt;
    }

    public final List<String> getMentionedUsersId() {
        return this.mentionedUsersId;
    }

    public final Map<String, Integer> getReactionCounts() {
        return this.reactionCounts;
    }

    public final Map<String, Integer> getReactionScores() {
        return this.reactionScores;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final String getCommand() {
        return this.command;
    }

    public final boolean getShadowed() {
        return this.shadowed;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final String getReplyToId() {
        return this.replyToId;
    }

    public final List<String> getThreadParticipantsIds() {
        return this.threadParticipantsIds;
    }
}
