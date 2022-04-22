package p015io.getstream.chat.android.client.api2.model.dto;

import com.facebook.AccessToken;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eHÆ\u0003Jk\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0007HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006+"}, mo26107d2 = {"Lio/getstream/chat/android/client/api2/model/dto/ReactionDto;", "", "created_at", "Ljava/util/Date;", "message_id", "", "score", "", "type", "updated_at", "user", "Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "user_id", "extraData", "", "(Ljava/util/Date;Ljava/lang/String;ILjava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/api2/model/dto/UserDto;Ljava/lang/String;Ljava/util/Map;)V", "getCreated_at", "()Ljava/util/Date;", "getExtraData", "()Ljava/util/Map;", "getMessage_id", "()Ljava/lang/String;", "getScore", "()I", "getType", "getUpdated_at", "getUser", "()Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "getUser_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.model.dto.ReactionDto */
/* compiled from: ReactionDto.kt */
public final class ReactionDto {
    private final Date created_at;
    private final Map<String, Object> extraData;
    private final String message_id;
    private final int score;
    private final String type;
    private final Date updated_at;
    private final UserDto user;
    private final String user_id;

    public static /* synthetic */ ReactionDto copy$default(ReactionDto reactionDto, Date date, String str, int i, String str2, Date date2, UserDto userDto, String str3, Map map, int i2, Object obj) {
        ReactionDto reactionDto2 = reactionDto;
        int i3 = i2;
        return reactionDto.copy((i3 & 1) != 0 ? reactionDto2.created_at : date, (i3 & 2) != 0 ? reactionDto2.message_id : str, (i3 & 4) != 0 ? reactionDto2.score : i, (i3 & 8) != 0 ? reactionDto2.type : str2, (i3 & 16) != 0 ? reactionDto2.updated_at : date2, (i3 & 32) != 0 ? reactionDto2.user : userDto, (i3 & 64) != 0 ? reactionDto2.user_id : str3, (i3 & 128) != 0 ? reactionDto2.extraData : map);
    }

    public final Date component1() {
        return this.created_at;
    }

    public final String component2() {
        return this.message_id;
    }

    public final int component3() {
        return this.score;
    }

    public final String component4() {
        return this.type;
    }

    public final Date component5() {
        return this.updated_at;
    }

    public final UserDto component6() {
        return this.user;
    }

    public final String component7() {
        return this.user_id;
    }

    public final Map<String, Object> component8() {
        return this.extraData;
    }

    public final ReactionDto copy(Date date, String str, int i, String str2, Date date2, UserDto userDto, String str3, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message_id");
        Intrinsics.checkNotNullParameter(str2, "type");
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, AccessToken.USER_ID_KEY);
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extraData");
        return new ReactionDto(date, str, i, str2, date2, userDto, str4, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactionDto)) {
            return false;
        }
        ReactionDto reactionDto = (ReactionDto) obj;
        return Intrinsics.areEqual((Object) this.created_at, (Object) reactionDto.created_at) && Intrinsics.areEqual((Object) this.message_id, (Object) reactionDto.message_id) && this.score == reactionDto.score && Intrinsics.areEqual((Object) this.type, (Object) reactionDto.type) && Intrinsics.areEqual((Object) this.updated_at, (Object) reactionDto.updated_at) && Intrinsics.areEqual((Object) this.user, (Object) reactionDto.user) && Intrinsics.areEqual((Object) this.user_id, (Object) reactionDto.user_id) && Intrinsics.areEqual((Object) this.extraData, (Object) reactionDto.extraData);
    }

    public int hashCode() {
        Date date = this.created_at;
        int i = 0;
        int hashCode = (date != null ? date.hashCode() : 0) * 31;
        String str = this.message_id;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.score) * 31;
        String str2 = this.type;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Date date2 = this.updated_at;
        int hashCode4 = (hashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
        UserDto userDto = this.user;
        int hashCode5 = (hashCode4 + (userDto != null ? userDto.hashCode() : 0)) * 31;
        String str3 = this.user_id;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Map<String, Object> map = this.extraData;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "ReactionDto(created_at=" + this.created_at + ", message_id=" + this.message_id + ", score=" + this.score + ", type=" + this.type + ", updated_at=" + this.updated_at + ", user=" + this.user + ", user_id=" + this.user_id + ", extraData=" + this.extraData + ")";
    }

    public ReactionDto(Date date, String str, int i, String str2, Date date2, UserDto userDto, String str3, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message_id");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(str3, AccessToken.USER_ID_KEY);
        Intrinsics.checkNotNullParameter(map, "extraData");
        this.created_at = date;
        this.message_id = str;
        this.score = i;
        this.type = str2;
        this.updated_at = date2;
        this.user = userDto;
        this.user_id = str3;
        this.extraData = map;
    }

    public final Date getCreated_at() {
        return this.created_at;
    }

    public final String getMessage_id() {
        return this.message_id;
    }

    public final int getScore() {
        return this.score;
    }

    public final String getType() {
        return this.type;
    }

    public final Date getUpdated_at() {
        return this.updated_at;
    }

    public final UserDto getUser() {
        return this.user;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }
}
