package p015io.getstream.chat.android.client.api2.model.dto;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/ChannelInfoDto;", "", "cid", "", "id", "member_count", "", "name", "type", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCid", "()Ljava/lang/String;", "getId", "getMember_count", "()I", "getName", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.ChannelInfoDto */
/* compiled from: ChannelInfoDto.kt */
public final class ChannelInfoDto {
    private final String cid;

    /* renamed from: id */
    private final String f1448id;
    private final int member_count;
    private final String name;
    private final String type;

    public static /* synthetic */ ChannelInfoDto copy$default(ChannelInfoDto channelInfoDto, String str, String str2, int i, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelInfoDto.cid;
        }
        if ((i2 & 2) != 0) {
            str2 = channelInfoDto.f1448id;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = channelInfoDto.member_count;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = channelInfoDto.name;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = channelInfoDto.type;
        }
        return channelInfoDto.copy(str, str5, i3, str6, str4);
    }

    public final String component1() {
        return this.cid;
    }

    public final String component2() {
        return this.f1448id;
    }

    public final int component3() {
        return this.member_count;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.type;
    }

    public final ChannelInfoDto copy(String str, String str2, int i, String str3, String str4) {
        return new ChannelInfoDto(str, str2, i, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelInfoDto)) {
            return false;
        }
        ChannelInfoDto channelInfoDto = (ChannelInfoDto) obj;
        return Intrinsics.areEqual((Object) this.cid, (Object) channelInfoDto.cid) && Intrinsics.areEqual((Object) this.f1448id, (Object) channelInfoDto.f1448id) && this.member_count == channelInfoDto.member_count && Intrinsics.areEqual((Object) this.name, (Object) channelInfoDto.name) && Intrinsics.areEqual((Object) this.type, (Object) channelInfoDto.type);
    }

    public int hashCode() {
        String str = this.cid;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f1448id;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.member_count) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.type;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ChannelInfoDto(cid=" + this.cid + ", id=" + this.f1448id + ", member_count=" + this.member_count + ", name=" + this.name + ", type=" + this.type + ")";
    }

    public ChannelInfoDto(String str, String str2, int i, String str3, String str4) {
        this.cid = str;
        this.f1448id = str2;
        this.member_count = i;
        this.name = str3;
        this.type = str4;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getId() {
        return this.f1448id;
    }

    public final int getMember_count() {
        return this.member_count;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }
}
