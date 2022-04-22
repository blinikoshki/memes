package p015io.getstream.chat.android.client.api2.model.dto;

import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "", "banned", "", "id", "", "invisible", "role", "extraData", "", "(ZLjava/lang/String;ZLjava/lang/String;Ljava/util/Map;)V", "getBanned", "()Z", "getExtraData", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getInvisible", "getRole", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.UserDto */
/* compiled from: UserDto.kt */
public final class UserDto {
    private final boolean banned;
    private final Map<String, Object> extraData;

    /* renamed from: id */
    private final String f1451id;
    private final boolean invisible;
    private final String role;

    public static /* synthetic */ UserDto copy$default(UserDto userDto, boolean z, String str, boolean z2, String str2, Map<String, Object> map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = userDto.banned;
        }
        if ((i & 2) != 0) {
            str = userDto.f1451id;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            z2 = userDto.invisible;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            str2 = userDto.role;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            map = userDto.extraData;
        }
        return userDto.copy(z, str3, z3, str4, map);
    }

    public final boolean component1() {
        return this.banned;
    }

    public final String component2() {
        return this.f1451id;
    }

    public final boolean component3() {
        return this.invisible;
    }

    public final String component4() {
        return this.role;
    }

    public final Map<String, Object> component5() {
        return this.extraData;
    }

    public final UserDto copy(boolean z, String str, boolean z2, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "role");
        Intrinsics.checkNotNullParameter(map, "extraData");
        return new UserDto(z, str, z2, str2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDto)) {
            return false;
        }
        UserDto userDto = (UserDto) obj;
        return this.banned == userDto.banned && Intrinsics.areEqual((Object) this.f1451id, (Object) userDto.f1451id) && this.invisible == userDto.invisible && Intrinsics.areEqual((Object) this.role, (Object) userDto.role) && Intrinsics.areEqual((Object) this.extraData, (Object) userDto.extraData);
    }

    public int hashCode() {
        boolean z = this.banned;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.f1451id;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.invisible;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (hashCode + (z2 ? 1 : 0)) * 31;
        String str2 = this.role;
        int hashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, Object> map = this.extraData;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "UserDto(banned=" + this.banned + ", id=" + this.f1451id + ", invisible=" + this.invisible + ", role=" + this.role + ", extraData=" + this.extraData + ")";
    }

    public UserDto(boolean z, String str, boolean z2, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "role");
        Intrinsics.checkNotNullParameter(map, "extraData");
        this.banned = z;
        this.f1451id = str;
        this.invisible = z2;
        this.role = str2;
        this.extraData = map;
    }

    public final boolean getBanned() {
        return this.banned;
    }

    public final String getId() {
        return this.f1451id;
    }

    public final boolean getInvisible() {
        return this.invisible;
    }

    public final String getRole() {
        return this.role;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }
}
