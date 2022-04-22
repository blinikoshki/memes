package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/ChannelInfo;", "", "cid", "", "id", "type", "memberCount", "", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCid", "()Ljava/lang/String;", "getId", "getMemberCount", "()I", "getName", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.ChannelInfo */
/* compiled from: ChannelInfo.kt */
public final class ChannelInfo {
    private final String cid;

    /* renamed from: id */
    private final String f1457id;
    @SerializedName("member_count")
    private final int memberCount;
    private final String name;
    private final String type;

    public ChannelInfo() {
        this((String) null, (String) null, (String) null, 0, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChannelInfo copy$default(ChannelInfo channelInfo, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelInfo.cid;
        }
        if ((i2 & 2) != 0) {
            str2 = channelInfo.f1457id;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = channelInfo.type;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = channelInfo.memberCount;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = channelInfo.name;
        }
        return channelInfo.copy(str, str5, str6, i3, str4);
    }

    public final String component1() {
        return this.cid;
    }

    public final String component2() {
        return this.f1457id;
    }

    public final String component3() {
        return this.type;
    }

    public final int component4() {
        return this.memberCount;
    }

    public final String component5() {
        return this.name;
    }

    public final ChannelInfo copy(String str, String str2, String str3, int i, String str4) {
        return new ChannelInfo(str, str2, str3, i, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelInfo)) {
            return false;
        }
        ChannelInfo channelInfo = (ChannelInfo) obj;
        return Intrinsics.areEqual((Object) this.cid, (Object) channelInfo.cid) && Intrinsics.areEqual((Object) this.f1457id, (Object) channelInfo.f1457id) && Intrinsics.areEqual((Object) this.type, (Object) channelInfo.type) && this.memberCount == channelInfo.memberCount && Intrinsics.areEqual((Object) this.name, (Object) channelInfo.name);
    }

    public int hashCode() {
        String str = this.cid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1457id;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.memberCount) * 31;
        String str4 = this.name;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ChannelInfo(cid=" + this.cid + ", id=" + this.f1457id + ", type=" + this.type + ", memberCount=" + this.memberCount + ", name=" + this.name + ")";
    }

    public ChannelInfo(String str, String str2, String str3, int i, String str4) {
        this.cid = str;
        this.f1457id = str2;
        this.type = str3;
        this.memberCount = i;
        this.name = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChannelInfo(java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0008
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
        L_0x0008:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000f
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
        L_0x000f:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0017
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
        L_0x0017:
            r1 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001f
            r7 = 0
            r2 = 0
            goto L_0x0020
        L_0x001f:
            r2 = r7
        L_0x0020:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0027
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
        L_0x0027:
            r0 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.ChannelInfo.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getId() {
        return this.f1457id;
    }

    public final String getType() {
        return this.type;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final String getName() {
        return this.name;
    }
}
