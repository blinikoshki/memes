package p015io.getstream.chat.android.client.api2.model.dto;

import com.squareup.moshi.JsonClass;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b4\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010>\u001a\u00020\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u000fHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0012HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\u0015\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001cHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010L\u001a\u00020\u000fHÆ\u0003Jý\u0001\u0010M\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001cHÆ\u0001J\u0013\u0010N\u001a\u00020\u000f2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020QHÖ\u0001J\t\u0010R\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0011\u0010\u0015\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0011\u0010\u0017\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/¨\u0006S"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/UpstreamMessageDto;", "", "attachments", "", "Lio/getstream/chat/android/client/api2/model/dto/AttachmentDto;", "cid", "", "command", "html", "id", "mentioned_users", "parent_id", "pin_expires", "Ljava/util/Date;", "pinned", "", "pinned_at", "pinned_by", "Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "quoted_message", "quoted_message_id", "shadowed", "show_in_channel", "silent", "text", "thread_participants", "user", "extraData", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;ZLjava/util/Date;Lio/getstream/chat/android/client/api2/model/dto/UserDto;Lio/getstream/chat/android/client/api2/model/dto/UpstreamMessageDto;Ljava/lang/String;ZZZLjava/lang/String;Ljava/util/List;Lio/getstream/chat/android/client/api2/model/dto/UserDto;Ljava/util/Map;)V", "getAttachments", "()Ljava/util/List;", "getCid", "()Ljava/lang/String;", "getCommand", "getExtraData", "()Ljava/util/Map;", "getHtml", "getId", "getMentioned_users", "getParent_id", "getPin_expires", "()Ljava/util/Date;", "getPinned", "()Z", "getPinned_at", "getPinned_by", "()Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "getQuoted_message", "()Lio/getstream/chat/android/client/api2/model/dto/UpstreamMessageDto;", "getQuoted_message_id", "getShadowed", "getShow_in_channel", "getSilent", "getText", "getThread_participants", "getUser", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto */
/* compiled from: UpstreamMessageDto.kt */
public final class UpstreamMessageDto {
    private final List<AttachmentDto> attachments;
    private final String cid;
    private final String command;
    private final Map<String, Object> extraData;
    private final String html;

    /* renamed from: id */
    private final String f1450id;
    private final List<String> mentioned_users;
    private final String parent_id;
    private final Date pin_expires;
    private final boolean pinned;
    private final Date pinned_at;
    private final UserDto pinned_by;
    private final UpstreamMessageDto quoted_message;
    private final String quoted_message_id;
    private final boolean shadowed;
    private final boolean show_in_channel;
    private final boolean silent;
    private final String text;
    private final List<UserDto> thread_participants;
    private final UserDto user;

    public static /* synthetic */ UpstreamMessageDto copy$default(UpstreamMessageDto upstreamMessageDto, List list, String str, String str2, String str3, String str4, List list2, String str5, Date date, boolean z, Date date2, UserDto userDto, UpstreamMessageDto upstreamMessageDto2, String str6, boolean z2, boolean z3, boolean z4, String str7, List list3, UserDto userDto2, Map map, int i, Object obj) {
        UpstreamMessageDto upstreamMessageDto3 = upstreamMessageDto;
        int i2 = i;
        return upstreamMessageDto.copy((i2 & 1) != 0 ? upstreamMessageDto3.attachments : list, (i2 & 2) != 0 ? upstreamMessageDto3.cid : str, (i2 & 4) != 0 ? upstreamMessageDto3.command : str2, (i2 & 8) != 0 ? upstreamMessageDto3.html : str3, (i2 & 16) != 0 ? upstreamMessageDto3.f1450id : str4, (i2 & 32) != 0 ? upstreamMessageDto3.mentioned_users : list2, (i2 & 64) != 0 ? upstreamMessageDto3.parent_id : str5, (i2 & 128) != 0 ? upstreamMessageDto3.pin_expires : date, (i2 & 256) != 0 ? upstreamMessageDto3.pinned : z, (i2 & 512) != 0 ? upstreamMessageDto3.pinned_at : date2, (i2 & 1024) != 0 ? upstreamMessageDto3.pinned_by : userDto, (i2 & 2048) != 0 ? upstreamMessageDto3.quoted_message : upstreamMessageDto2, (i2 & 4096) != 0 ? upstreamMessageDto3.quoted_message_id : str6, (i2 & 8192) != 0 ? upstreamMessageDto3.shadowed : z2, (i2 & 16384) != 0 ? upstreamMessageDto3.show_in_channel : z3, (i2 & 32768) != 0 ? upstreamMessageDto3.silent : z4, (i2 & 65536) != 0 ? upstreamMessageDto3.text : str7, (i2 & 131072) != 0 ? upstreamMessageDto3.thread_participants : list3, (i2 & 262144) != 0 ? upstreamMessageDto3.user : userDto2, (i2 & 524288) != 0 ? upstreamMessageDto3.extraData : map);
    }

    public final List<AttachmentDto> component1() {
        return this.attachments;
    }

    public final Date component10() {
        return this.pinned_at;
    }

    public final UserDto component11() {
        return this.pinned_by;
    }

    public final UpstreamMessageDto component12() {
        return this.quoted_message;
    }

    public final String component13() {
        return this.quoted_message_id;
    }

    public final boolean component14() {
        return this.shadowed;
    }

    public final boolean component15() {
        return this.show_in_channel;
    }

    public final boolean component16() {
        return this.silent;
    }

    public final String component17() {
        return this.text;
    }

    public final List<UserDto> component18() {
        return this.thread_participants;
    }

    public final UserDto component19() {
        return this.user;
    }

    public final String component2() {
        return this.cid;
    }

    public final Map<String, Object> component20() {
        return this.extraData;
    }

    public final String component3() {
        return this.command;
    }

    public final String component4() {
        return this.html;
    }

    public final String component5() {
        return this.f1450id;
    }

    public final List<String> component6() {
        return this.mentioned_users;
    }

    public final String component7() {
        return this.parent_id;
    }

    public final Date component8() {
        return this.pin_expires;
    }

    public final boolean component9() {
        return this.pinned;
    }

    public final UpstreamMessageDto copy(List<AttachmentDto> list, String str, String str2, String str3, String str4, List<String> list2, String str5, Date date, boolean z, Date date2, UserDto userDto, UpstreamMessageDto upstreamMessageDto, String str6, boolean z2, boolean z3, boolean z4, String str7, List<UserDto> list3, UserDto userDto2, Map<String, ? extends Object> map) {
        List<AttachmentDto> list4 = list;
        Intrinsics.checkNotNullParameter(list4, "attachments");
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(str3, "html");
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(list2, "mentioned_users");
        Intrinsics.checkNotNullParameter(str7, "text");
        Intrinsics.checkNotNullParameter(list3, "thread_participants");
        Intrinsics.checkNotNullParameter(userDto2, "user");
        Intrinsics.checkNotNullParameter(map, "extraData");
        return new UpstreamMessageDto(list4, str, str2, str3, str4, list2, str5, date, z, date2, userDto, upstreamMessageDto, str6, z2, z3, z4, str7, list3, userDto2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpstreamMessageDto)) {
            return false;
        }
        UpstreamMessageDto upstreamMessageDto = (UpstreamMessageDto) obj;
        return Intrinsics.areEqual((Object) this.attachments, (Object) upstreamMessageDto.attachments) && Intrinsics.areEqual((Object) this.cid, (Object) upstreamMessageDto.cid) && Intrinsics.areEqual((Object) this.command, (Object) upstreamMessageDto.command) && Intrinsics.areEqual((Object) this.html, (Object) upstreamMessageDto.html) && Intrinsics.areEqual((Object) this.f1450id, (Object) upstreamMessageDto.f1450id) && Intrinsics.areEqual((Object) this.mentioned_users, (Object) upstreamMessageDto.mentioned_users) && Intrinsics.areEqual((Object) this.parent_id, (Object) upstreamMessageDto.parent_id) && Intrinsics.areEqual((Object) this.pin_expires, (Object) upstreamMessageDto.pin_expires) && this.pinned == upstreamMessageDto.pinned && Intrinsics.areEqual((Object) this.pinned_at, (Object) upstreamMessageDto.pinned_at) && Intrinsics.areEqual((Object) this.pinned_by, (Object) upstreamMessageDto.pinned_by) && Intrinsics.areEqual((Object) this.quoted_message, (Object) upstreamMessageDto.quoted_message) && Intrinsics.areEqual((Object) this.quoted_message_id, (Object) upstreamMessageDto.quoted_message_id) && this.shadowed == upstreamMessageDto.shadowed && this.show_in_channel == upstreamMessageDto.show_in_channel && this.silent == upstreamMessageDto.silent && Intrinsics.areEqual((Object) this.text, (Object) upstreamMessageDto.text) && Intrinsics.areEqual((Object) this.thread_participants, (Object) upstreamMessageDto.thread_participants) && Intrinsics.areEqual((Object) this.user, (Object) upstreamMessageDto.user) && Intrinsics.areEqual((Object) this.extraData, (Object) upstreamMessageDto.extraData);
    }

    public int hashCode() {
        List<AttachmentDto> list = this.attachments;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.cid;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.command;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.html;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f1450id;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<String> list2 = this.mentioned_users;
        int hashCode6 = (hashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str5 = this.parent_id;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Date date = this.pin_expires;
        int hashCode8 = (hashCode7 + (date != null ? date.hashCode() : 0)) * 31;
        boolean z = this.pinned;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode8 + (z ? 1 : 0)) * 31;
        Date date2 = this.pinned_at;
        int hashCode9 = (i2 + (date2 != null ? date2.hashCode() : 0)) * 31;
        UserDto userDto = this.pinned_by;
        int hashCode10 = (hashCode9 + (userDto != null ? userDto.hashCode() : 0)) * 31;
        UpstreamMessageDto upstreamMessageDto = this.quoted_message;
        int hashCode11 = (hashCode10 + (upstreamMessageDto != null ? upstreamMessageDto.hashCode() : 0)) * 31;
        String str6 = this.quoted_message_id;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z3 = this.shadowed;
        if (z3) {
            z3 = true;
        }
        int i3 = (hashCode12 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.show_in_channel;
        if (z4) {
            z4 = true;
        }
        int i4 = (i3 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.silent;
        if (!z5) {
            z2 = z5;
        }
        int i5 = (i4 + (z2 ? 1 : 0)) * 31;
        String str7 = this.text;
        int hashCode13 = (i5 + (str7 != null ? str7.hashCode() : 0)) * 31;
        List<UserDto> list3 = this.thread_participants;
        int hashCode14 = (hashCode13 + (list3 != null ? list3.hashCode() : 0)) * 31;
        UserDto userDto2 = this.user;
        int hashCode15 = (hashCode14 + (userDto2 != null ? userDto2.hashCode() : 0)) * 31;
        Map<String, Object> map = this.extraData;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode15 + i;
    }

    public String toString() {
        return "UpstreamMessageDto(attachments=" + this.attachments + ", cid=" + this.cid + ", command=" + this.command + ", html=" + this.html + ", id=" + this.f1450id + ", mentioned_users=" + this.mentioned_users + ", parent_id=" + this.parent_id + ", pin_expires=" + this.pin_expires + ", pinned=" + this.pinned + ", pinned_at=" + this.pinned_at + ", pinned_by=" + this.pinned_by + ", quoted_message=" + this.quoted_message + ", quoted_message_id=" + this.quoted_message_id + ", shadowed=" + this.shadowed + ", show_in_channel=" + this.show_in_channel + ", silent=" + this.silent + ", text=" + this.text + ", thread_participants=" + this.thread_participants + ", user=" + this.user + ", extraData=" + this.extraData + ")";
    }

    public UpstreamMessageDto(List<AttachmentDto> list, String str, String str2, String str3, String str4, List<String> list2, String str5, Date date, boolean z, Date date2, UserDto userDto, UpstreamMessageDto upstreamMessageDto, String str6, boolean z2, boolean z3, boolean z4, String str7, List<UserDto> list3, UserDto userDto2, Map<String, ? extends Object> map) {
        String str8 = str4;
        List<String> list4 = list2;
        String str9 = str7;
        List<UserDto> list5 = list3;
        UserDto userDto3 = userDto2;
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(list, "attachments");
        Intrinsics.checkNotNullParameter(str, "cid");
        Intrinsics.checkNotNullParameter(str3, "html");
        Intrinsics.checkNotNullParameter(str8, "id");
        Intrinsics.checkNotNullParameter(list4, "mentioned_users");
        Intrinsics.checkNotNullParameter(str9, "text");
        Intrinsics.checkNotNullParameter(list5, "thread_participants");
        Intrinsics.checkNotNullParameter(userDto3, "user");
        Intrinsics.checkNotNullParameter(map2, "extraData");
        this.attachments = list;
        this.cid = str;
        this.command = str2;
        this.html = str3;
        this.f1450id = str8;
        this.mentioned_users = list4;
        this.parent_id = str5;
        this.pin_expires = date;
        this.pinned = z;
        this.pinned_at = date2;
        this.pinned_by = userDto;
        this.quoted_message = upstreamMessageDto;
        this.quoted_message_id = str6;
        this.shadowed = z2;
        this.show_in_channel = z3;
        this.silent = z4;
        this.text = str9;
        this.thread_participants = list5;
        this.user = userDto3;
        this.extraData = map2;
    }

    public final List<AttachmentDto> getAttachments() {
        return this.attachments;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getCommand() {
        return this.command;
    }

    public final String getHtml() {
        return this.html;
    }

    public final String getId() {
        return this.f1450id;
    }

    public final List<String> getMentioned_users() {
        return this.mentioned_users;
    }

    public final String getParent_id() {
        return this.parent_id;
    }

    public final Date getPin_expires() {
        return this.pin_expires;
    }

    public final boolean getPinned() {
        return this.pinned;
    }

    public final Date getPinned_at() {
        return this.pinned_at;
    }

    public final UserDto getPinned_by() {
        return this.pinned_by;
    }

    public final UpstreamMessageDto getQuoted_message() {
        return this.quoted_message;
    }

    public final String getQuoted_message_id() {
        return this.quoted_message_id;
    }

    public final boolean getShadowed() {
        return this.shadowed;
    }

    public final boolean getShow_in_channel() {
        return this.show_in_channel;
    }

    public final boolean getSilent() {
        return this.silent;
    }

    public final String getText() {
        return this.text;
    }

    public final List<UserDto> getThread_participants() {
        return this.thread_participants;
    }

    public final UserDto getUser() {
        return this.user;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }
}
