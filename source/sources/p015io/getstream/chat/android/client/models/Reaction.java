package p015io.getstream.chat.android.client.models;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import com.memes.plus.p040ui.create_post.tagpeople.TagPeopleActivity;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.CustomObject;
import p015io.getstream.chat.android.client.parser.IgnoreDeserialisation;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b7\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u0015\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\t\u0010<\u001a\u00020\u0014HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010D\u001a\u00020\u000fHÆ\u0003J\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010F\u001a\u00020\u00142\b\u0010G\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\u0006\u0010H\u001a\u00020\u0003J\t\u0010I\u001a\u00020\u0006HÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00118\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R \u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'¨\u0006K"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Reaction;", "Lio/getstream/chat/android/client/models/CustomObject;", "messageId", "", "type", "score", "", "user", "Lio/getstream/chat/android/client/models/User;", "userId", "createdAt", "Ljava/util/Date;", "updatedAt", "deletedAt", "syncStatus", "Lio/getstream/chat/android/client/utils/SyncStatus;", "extraData", "", "", "enforceUnique", "", "(Ljava/lang/String;Ljava/lang/String;ILio/getstream/chat/android/client/models/User;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lio/getstream/chat/android/client/utils/SyncStatus;Ljava/util/Map;Z)V", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getDeletedAt", "setDeletedAt", "getEnforceUnique", "()Z", "setEnforceUnique", "(Z)V", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "getScore", "()I", "setScore", "(I)V", "getSyncStatus", "()Lio/getstream/chat/android/client/utils/SyncStatus;", "setSyncStatus", "(Lio/getstream/chat/android/client/utils/SyncStatus;)V", "getType", "setType", "getUpdatedAt", "setUpdatedAt", "getUser", "()Lio/getstream/chat/android/client/models/User;", "setUser", "(Lio/getstream/chat/android/client/models/User;)V", "getUserId", "setUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "fetchUserId", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Reaction */
/* compiled from: Reaction.kt */
public final class Reaction implements CustomObject {
    @SerializedName("created_at")
    private Date createdAt;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Date deletedAt;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private boolean enforceUnique;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Map<String, Object> extraData;
    @SerializedName("message_id")
    private String messageId;
    private int score;
    @IgnoreSerialisation
    private SyncStatus syncStatus;
    private String type;
    @SerializedName("updated_at")
    private Date updatedAt;
    private User user;
    @SerializedName("user_id")
    private String userId;

    public Reaction() {
        this((String) null, (String) null, 0, (User) null, (String) null, (Date) null, (Date) null, (Date) null, (SyncStatus) null, (Map) null, false, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Reaction copy$default(Reaction reaction, String str, String str2, int i, User user2, String str3, Date date, Date date2, Date date3, SyncStatus syncStatus2, Map map, boolean z, int i2, Object obj) {
        Reaction reaction2 = reaction;
        int i3 = i2;
        return reaction.copy((i3 & 1) != 0 ? reaction2.messageId : str, (i3 & 2) != 0 ? reaction2.type : str2, (i3 & 4) != 0 ? reaction2.score : i, (i3 & 8) != 0 ? reaction2.user : user2, (i3 & 16) != 0 ? reaction2.userId : str3, (i3 & 32) != 0 ? reaction2.createdAt : date, (i3 & 64) != 0 ? reaction2.updatedAt : date2, (i3 & 128) != 0 ? reaction2.deletedAt : date3, (i3 & 256) != 0 ? reaction2.syncStatus : syncStatus2, (i3 & 512) != 0 ? reaction.getExtraData() : map, (i3 & 1024) != 0 ? reaction2.enforceUnique : z);
    }

    public final String component1() {
        return this.messageId;
    }

    public final Map<String, Object> component10() {
        return getExtraData();
    }

    public final boolean component11() {
        return this.enforceUnique;
    }

    public final String component2() {
        return this.type;
    }

    public final int component3() {
        return this.score;
    }

    public final User component4() {
        return this.user;
    }

    public final String component5() {
        return this.userId;
    }

    public final Date component6() {
        return this.createdAt;
    }

    public final Date component7() {
        return this.updatedAt;
    }

    public final Date component8() {
        return this.deletedAt;
    }

    public final SyncStatus component9() {
        return this.syncStatus;
    }

    public final Reaction copy(String str, String str2, int i, User user2, String str3, Date date, Date date2, Date date3, SyncStatus syncStatus2, Map<String, Object> map, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "type");
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, TagPeopleActivity.USER_ID);
        SyncStatus syncStatus3 = syncStatus2;
        Intrinsics.checkNotNullParameter(syncStatus3, "syncStatus");
        Map<String, Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extraData");
        return new Reaction(str, str2, i, user2, str4, date, date2, date3, syncStatus3, map2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reaction)) {
            return false;
        }
        Reaction reaction = (Reaction) obj;
        return Intrinsics.areEqual((Object) this.messageId, (Object) reaction.messageId) && Intrinsics.areEqual((Object) this.type, (Object) reaction.type) && this.score == reaction.score && Intrinsics.areEqual((Object) this.user, (Object) reaction.user) && Intrinsics.areEqual((Object) this.userId, (Object) reaction.userId) && Intrinsics.areEqual((Object) this.createdAt, (Object) reaction.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) reaction.updatedAt) && Intrinsics.areEqual((Object) this.deletedAt, (Object) reaction.deletedAt) && Intrinsics.areEqual((Object) this.syncStatus, (Object) reaction.syncStatus) && Intrinsics.areEqual((Object) getExtraData(), (Object) reaction.getExtraData()) && this.enforceUnique == reaction.enforceUnique;
    }

    public int hashCode() {
        String str = this.messageId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.score) * 31;
        User user2 = this.user;
        int hashCode3 = (hashCode2 + (user2 != null ? user2.hashCode() : 0)) * 31;
        String str3 = this.userId;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Date date = this.createdAt;
        int hashCode5 = (hashCode4 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode6 = (hashCode5 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.deletedAt;
        int hashCode7 = (hashCode6 + (date3 != null ? date3.hashCode() : 0)) * 31;
        SyncStatus syncStatus2 = this.syncStatus;
        int hashCode8 = (hashCode7 + (syncStatus2 != null ? syncStatus2.hashCode() : 0)) * 31;
        Map<String, Object> extraData2 = getExtraData();
        if (extraData2 != null) {
            i = extraData2.hashCode();
        }
        int i2 = (hashCode8 + i) * 31;
        boolean z = this.enforceUnique;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "Reaction(messageId=" + this.messageId + ", type=" + this.type + ", score=" + this.score + ", user=" + this.user + ", userId=" + this.userId + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", deletedAt=" + this.deletedAt + ", syncStatus=" + this.syncStatus + ", extraData=" + getExtraData() + ", enforceUnique=" + this.enforceUnique + ")";
    }

    public Reaction(String str, String str2, int i, User user2, String str3, Date date, Date date2, Date date3, SyncStatus syncStatus2, Map<String, Object> map, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, TagPeopleActivity.USER_ID);
        Intrinsics.checkNotNullParameter(syncStatus2, "syncStatus");
        Intrinsics.checkNotNullParameter(map, "extraData");
        this.messageId = str;
        this.type = str2;
        this.score = i;
        this.user = user2;
        this.userId = str3;
        this.createdAt = date;
        this.updatedAt = date2;
        this.deletedAt = date3;
        this.syncStatus = syncStatus2;
        this.extraData = map;
        this.enforceUnique = z;
    }

    public <T> T getExtraValue(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        return CustomObject.DefaultImpls.getExtraValue(this, str, t);
    }

    public void putExtraValue(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        CustomObject.DefaultImpls.putExtraValue(this, str, obj);
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.messageId = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final int getScore() {
        return this.score;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Reaction(java.lang.String r13, java.lang.String r14, int r15, p015io.getstream.chat.android.client.models.User r16, java.lang.String r17, java.util.Date r18, java.util.Date r19, java.util.Date r20, p015io.getstream.chat.android.client.utils.SyncStatus r21, java.util.Map r22, boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r13
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0012
        L_0x0011:
            r3 = r14
        L_0x0012:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001a
        L_0x0019:
            r4 = r15
        L_0x001a:
            r6 = r0 & 8
            r7 = 0
            if (r6 == 0) goto L_0x0023
            r6 = r7
            io.getstream.chat.android.client.models.User r6 = (p015io.getstream.chat.android.client.models.User) r6
            goto L_0x0025
        L_0x0023:
            r6 = r16
        L_0x0025:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r2 = r17
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0034
            r8 = r7
            java.util.Date r8 = (java.util.Date) r8
            goto L_0x0036
        L_0x0034:
            r8 = r18
        L_0x0036:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003e
            r9 = r7
            java.util.Date r9 = (java.util.Date) r9
            goto L_0x0040
        L_0x003e:
            r9 = r19
        L_0x0040:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0047
            java.util.Date r7 = (java.util.Date) r7
            goto L_0x0049
        L_0x0047:
            r7 = r20
        L_0x0049:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0050
            io.getstream.chat.android.client.utils.SyncStatus r10 = p015io.getstream.chat.android.client.utils.SyncStatus.COMPLETED
            goto L_0x0052
        L_0x0050:
            r10 = r21
        L_0x0052:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x005e
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            java.util.Map r11 = (java.util.Map) r11
            goto L_0x0060
        L_0x005e:
            r11 = r22
        L_0x0060:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r5 = r23
        L_0x0067:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r6
            r18 = r2
            r19 = r8
            r20 = r9
            r21 = r7
            r22 = r10
            r23 = r11
            r24 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.Reaction.<init>(java.lang.String, java.lang.String, int, io.getstream.chat.android.client.models.User, java.lang.String, java.util.Date, java.util.Date, java.util.Date, io.getstream.chat.android.client.utils.SyncStatus, java.util.Map, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        this.user = user2;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public final Date getDeletedAt() {
        return this.deletedAt;
    }

    public final void setDeletedAt(Date date) {
        this.deletedAt = date;
    }

    public final SyncStatus getSyncStatus() {
        return this.syncStatus;
    }

    public final void setSyncStatus(SyncStatus syncStatus2) {
        Intrinsics.checkNotNullParameter(syncStatus2, "<set-?>");
        this.syncStatus = syncStatus2;
    }

    public Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public void setExtraData(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraData = map;
    }

    public final boolean getEnforceUnique() {
        return this.enforceUnique;
    }

    public final void setEnforceUnique(boolean z) {
        this.enforceUnique = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fetchUserId() {
        /*
            r1 = this;
            io.getstream.chat.android.client.models.User r0 = r1.user
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.getId()
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            java.lang.String r0 = r1.userId
        L_0x000d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.Reaction.fetchUserId():java.lang.String");
    }
}
