package p015io.getstream.chat.android.client.api2.mapping;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api2.model.dto.UserDto;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, mo26107d2 = {"toDomain", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/api2/model/dto/UserDto;", "toDto", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.mapping.UserMappingKt */
/* compiled from: UserMapping.kt */
public final class UserMappingKt {
    public static final UserDto toDto(User user) {
        Intrinsics.checkNotNullParameter(user, "$this$toDto");
        return new UserDto(user.getBanned(), user.getId(), user.getInvisible(), user.getRole(), user.getExtraData());
    }

    public static final User toDomain(UserDto userDto) {
        Intrinsics.checkNotNullParameter(userDto, "$this$toDomain");
        boolean banned = userDto.getBanned();
        return new User(userDto.getId(), userDto.getRole(), userDto.getInvisible(), banned, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, MapsKt.toMutableMap(userDto.getExtraData()), 32752, (DefaultConstructorMarker) null);
    }
}
