package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.CustomObject;
import p015io.getstream.chat.android.client.parser.IgnoreDeserialisation;
import p015io.getstream.chat.android.client.parser.IgnoreSerialisation;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\bC\b\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\t\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\u0010\u001cJ\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0011HÆ\u0003J\t\u0010K\u001a\u00020\u0011HÆ\u0003J\t\u0010L\u001a\u00020\u0011HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00150\tHÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00180\tHÆ\u0003J\u0015\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u0006HÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\rHÆ\u0003JÓ\u0001\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0001J\u0013\u0010Z\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\\\u001a\u00020\u0011HÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010)R*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R \u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010)R\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R$\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bC\u0010D\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R \u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&¨\u0006^"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/models/CustomObject;", "id", "", "role", "invisible", "", "banned", "devices", "", "Lio/getstream/chat/android/client/models/Device;", "online", "createdAt", "Ljava/util/Date;", "updatedAt", "lastActive", "totalUnreadCount", "", "unreadChannels", "unreadCount", "mutes", "Lio/getstream/chat/android/client/models/Mute;", "teams", "channelMutes", "Lio/getstream/chat/android/client/models/ChannelMute;", "extraData", "", "", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;ZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;IIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getBanned", "()Z", "setBanned", "(Z)V", "getChannelMutes", "()Ljava/util/List;", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getDevices", "setDevices", "(Ljava/util/List;)V", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getInvisible", "setInvisible", "getLastActive", "setLastActive", "getMutes", "setMutes", "getOnline", "setOnline", "getRole", "setRole", "getTeams", "getTotalUnreadCount", "()I", "setTotalUnreadCount", "(I)V", "getUnreadChannels", "setUnreadChannels", "getUnreadCount$annotations", "()V", "getUnreadCount", "setUnreadCount", "getUpdatedAt", "setUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.User */
/* compiled from: User.kt */
public final class User implements CustomObject {
    private boolean banned;
    @SerializedName("channel_mutes")
    @IgnoreSerialisation
    private final List<ChannelMute> channelMutes;
    @SerializedName("created_at")
    @IgnoreSerialisation
    private Date createdAt;
    private List<Device> devices;
    @IgnoreDeserialisation
    @IgnoreSerialisation
    private Map<String, Object> extraData;

    /* renamed from: id */
    private String f1460id;
    private boolean invisible;
    @SerializedName("last_active")
    @IgnoreSerialisation
    private Date lastActive;
    @SerializedName("mutes")
    @IgnoreSerialisation
    private List<Mute> mutes;
    @IgnoreSerialisation
    private boolean online;
    private String role;
    private final List<String> teams;
    @SerializedName("total_unread_count")
    @IgnoreSerialisation
    private int totalUnreadCount;
    @SerializedName("unread_channels")
    @IgnoreSerialisation
    private int unreadChannels;
    @SerializedName("unread_count")
    @IgnoreSerialisation
    private int unreadCount;
    @SerializedName("updated_at")
    @IgnoreSerialisation
    private Date updatedAt;

    public User() {
        this((String) null, (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65535, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, boolean z, boolean z2, List list, boolean z3, Date date, Date date2, Date date3, int i, int i2, int i3, List list2, List list3, List list4, Map map, int i4, Object obj) {
        User user2 = user;
        int i5 = i4;
        return user.copy((i5 & 1) != 0 ? user2.f1460id : str, (i5 & 2) != 0 ? user2.role : str2, (i5 & 4) != 0 ? user2.invisible : z, (i5 & 8) != 0 ? user2.banned : z2, (i5 & 16) != 0 ? user2.devices : list, (i5 & 32) != 0 ? user2.online : z3, (i5 & 64) != 0 ? user2.createdAt : date, (i5 & 128) != 0 ? user2.updatedAt : date2, (i5 & 256) != 0 ? user2.lastActive : date3, (i5 & 512) != 0 ? user2.totalUnreadCount : i, (i5 & 1024) != 0 ? user2.unreadChannels : i2, (i5 & 2048) != 0 ? user2.unreadCount : i3, (i5 & 4096) != 0 ? user2.mutes : list2, (i5 & 8192) != 0 ? user2.teams : list3, (i5 & 16384) != 0 ? user2.channelMutes : list4, (i5 & 32768) != 0 ? user.getExtraData() : map);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This property is deprecated, it value could be wrong and will be removed in a future version", replaceWith = @ReplaceWith(expression = "this.totalUnreadCount", imports = {}))
    public static /* synthetic */ void getUnreadCount$annotations() {
    }

    public final String component1() {
        return this.f1460id;
    }

    public final int component10() {
        return this.totalUnreadCount;
    }

    public final int component11() {
        return this.unreadChannels;
    }

    public final int component12() {
        return this.unreadCount;
    }

    public final List<Mute> component13() {
        return this.mutes;
    }

    public final List<String> component14() {
        return this.teams;
    }

    public final List<ChannelMute> component15() {
        return this.channelMutes;
    }

    public final Map<String, Object> component16() {
        return getExtraData();
    }

    public final String component2() {
        return this.role;
    }

    public final boolean component3() {
        return this.invisible;
    }

    public final boolean component4() {
        return this.banned;
    }

    public final List<Device> component5() {
        return this.devices;
    }

    public final boolean component6() {
        return this.online;
    }

    public final Date component7() {
        return this.createdAt;
    }

    public final Date component8() {
        return this.updatedAt;
    }

    public final Date component9() {
        return this.lastActive;
    }

    public final User copy(String str, String str2, boolean z, boolean z2, List<Device> list, boolean z3, Date date, Date date2, Date date3, int i, int i2, int i3, List<Mute> list2, List<String> list3, List<ChannelMute> list4, Map<String, Object> map) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "id");
        Intrinsics.checkNotNullParameter(str2, "role");
        Intrinsics.checkNotNullParameter(list, "devices");
        Intrinsics.checkNotNullParameter(list2, "mutes");
        Intrinsics.checkNotNullParameter(list3, "teams");
        Intrinsics.checkNotNullParameter(list4, "channelMutes");
        Intrinsics.checkNotNullParameter(map, "extraData");
        return new User(str3, str2, z, z2, list, z3, date, date2, date3, i, i2, i3, list2, list3, list4, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Intrinsics.areEqual((Object) this.f1460id, (Object) user.f1460id) && Intrinsics.areEqual((Object) this.role, (Object) user.role) && this.invisible == user.invisible && this.banned == user.banned && Intrinsics.areEqual((Object) this.devices, (Object) user.devices) && this.online == user.online && Intrinsics.areEqual((Object) this.createdAt, (Object) user.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) user.updatedAt) && Intrinsics.areEqual((Object) this.lastActive, (Object) user.lastActive) && this.totalUnreadCount == user.totalUnreadCount && this.unreadChannels == user.unreadChannels && this.unreadCount == user.unreadCount && Intrinsics.areEqual((Object) this.mutes, (Object) user.mutes) && Intrinsics.areEqual((Object) this.teams, (Object) user.teams) && Intrinsics.areEqual((Object) this.channelMutes, (Object) user.channelMutes) && Intrinsics.areEqual((Object) getExtraData(), (Object) user.getExtraData());
    }

    public int hashCode() {
        String str = this.f1460id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.role;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.invisible;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.banned;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        List<Device> list = this.devices;
        int hashCode3 = (i3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z4 = this.online;
        if (!z4) {
            z2 = z4;
        }
        int i4 = (hashCode3 + (z2 ? 1 : 0)) * 31;
        Date date = this.createdAt;
        int hashCode4 = (i4 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.updatedAt;
        int hashCode5 = (hashCode4 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.lastActive;
        int hashCode6 = (((((((hashCode5 + (date3 != null ? date3.hashCode() : 0)) * 31) + this.totalUnreadCount) * 31) + this.unreadChannels) * 31) + this.unreadCount) * 31;
        List<Mute> list2 = this.mutes;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.teams;
        int hashCode8 = (hashCode7 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<ChannelMute> list4 = this.channelMutes;
        int hashCode9 = (hashCode8 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Map<String, Object> extraData2 = getExtraData();
        if (extraData2 != null) {
            i = extraData2.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "User(id=" + this.f1460id + ", role=" + this.role + ", invisible=" + this.invisible + ", banned=" + this.banned + ", devices=" + this.devices + ", online=" + this.online + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", lastActive=" + this.lastActive + ", totalUnreadCount=" + this.totalUnreadCount + ", unreadChannels=" + this.unreadChannels + ", unreadCount=" + this.unreadCount + ", mutes=" + this.mutes + ", teams=" + this.teams + ", channelMutes=" + this.channelMutes + ", extraData=" + getExtraData() + ")";
    }

    public User(String str, String str2, boolean z, boolean z2, List<Device> list, boolean z3, Date date, Date date2, Date date3, int i, int i2, int i3, List<Mute> list2, List<String> list3, List<ChannelMute> list4, Map<String, Object> map) {
        List<Mute> list5 = list2;
        List<String> list6 = list3;
        List<ChannelMute> list7 = list4;
        Map<String, Object> map2 = map;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "role");
        Intrinsics.checkNotNullParameter(list, "devices");
        Intrinsics.checkNotNullParameter(list5, "mutes");
        Intrinsics.checkNotNullParameter(list6, "teams");
        Intrinsics.checkNotNullParameter(list7, "channelMutes");
        Intrinsics.checkNotNullParameter(map2, "extraData");
        this.f1460id = str;
        this.role = str2;
        this.invisible = z;
        this.banned = z2;
        this.devices = list;
        this.online = z3;
        this.createdAt = date;
        this.updatedAt = date2;
        this.lastActive = date3;
        this.totalUnreadCount = i;
        this.unreadChannels = i2;
        this.unreadCount = i3;
        this.mutes = list5;
        this.teams = list6;
        this.channelMutes = list7;
        this.extraData = map2;
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

    public final String getId() {
        return this.f1460id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1460id = str;
    }

    public final String getRole() {
        return this.role;
    }

    public final void setRole(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.role = str;
    }

    public final boolean getInvisible() {
        return this.invisible;
    }

    public final void setInvisible(boolean z) {
        this.invisible = z;
    }

    public final boolean getBanned() {
        return this.banned;
    }

    public final void setBanned(boolean z) {
        this.banned = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ User(java.lang.String r18, java.lang.String r19, boolean r20, boolean r21, java.util.List r22, boolean r23, java.util.Date r24, java.util.Date r25, java.util.Date r26, int r27, int r28, int r29, java.util.List r30, java.util.List r31, java.util.List r32, java.util.Map r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r18
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = r19
        L_0x0013:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x001a
            r3 = 0
            goto L_0x001c
        L_0x001a:
            r3 = r20
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r21
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0030
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            goto L_0x0032
        L_0x0030:
            r6 = r22
        L_0x0032:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0038
            r7 = 0
            goto L_0x003a
        L_0x0038:
            r7 = r23
        L_0x003a:
            r8 = r0 & 64
            r9 = 0
            if (r8 == 0) goto L_0x0043
            r8 = r9
            java.util.Date r8 = (java.util.Date) r8
            goto L_0x0045
        L_0x0043:
            r8 = r24
        L_0x0045:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004d
            r10 = r9
            java.util.Date r10 = (java.util.Date) r10
            goto L_0x004f
        L_0x004d:
            r10 = r25
        L_0x004f:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0056
            java.util.Date r9 = (java.util.Date) r9
            goto L_0x0058
        L_0x0056:
            r9 = r26
        L_0x0058:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x005e
            r11 = 0
            goto L_0x0060
        L_0x005e:
            r11 = r27
        L_0x0060:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0066
            r12 = 0
            goto L_0x0068
        L_0x0066:
            r12 = r28
        L_0x0068:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r4 = r29
        L_0x006f:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x007b
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.List r13 = (java.util.List) r13
            goto L_0x007d
        L_0x007b:
            r13 = r30
        L_0x007d:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x0086
            java.util.List r14 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0088
        L_0x0086:
            r14 = r31
        L_0x0088:
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x0091
            java.util.List r15 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0093
        L_0x0091:
            r15 = r32
        L_0x0093:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x00a2
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            goto L_0x00a4
        L_0x00a2:
            r0 = r33
        L_0x00a4:
            r18 = r17
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r10
            r27 = r9
            r28 = r11
            r29 = r12
            r30 = r4
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.models.User.<init>(java.lang.String, java.lang.String, boolean, boolean, java.util.List, boolean, java.util.Date, java.util.Date, java.util.Date, int, int, int, java.util.List, java.util.List, java.util.List, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<Device> getDevices() {
        return this.devices;
    }

    public final void setDevices(List<Device> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.devices = list;
    }

    public final boolean getOnline() {
        return this.online;
    }

    public final void setOnline(boolean z) {
        this.online = z;
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

    public final Date getLastActive() {
        return this.lastActive;
    }

    public final void setLastActive(Date date) {
        this.lastActive = date;
    }

    public final int getTotalUnreadCount() {
        return this.totalUnreadCount;
    }

    public final void setTotalUnreadCount(int i) {
        this.totalUnreadCount = i;
    }

    public final int getUnreadChannels() {
        return this.unreadChannels;
    }

    public final void setUnreadChannels(int i) {
        this.unreadChannels = i;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    public final List<Mute> getMutes() {
        return this.mutes;
    }

    public final void setMutes(List<Mute> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mutes = list;
    }

    public final List<String> getTeams() {
        return this.teams;
    }

    public final List<ChannelMute> getChannelMutes() {
        return this.channelMutes;
    }

    public Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public void setExtraData(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraData = map;
    }
}
