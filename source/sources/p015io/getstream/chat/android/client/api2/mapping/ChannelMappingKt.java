package p015io.getstream.chat.android.client.api2.mapping;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api2.model.dto.ChannelInfoDto;
import p015io.getstream.chat.android.client.models.ChannelInfo;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, mo26107d2 = {"toDomain", "Lio/getstream/chat/android/client/models/ChannelInfo;", "Lio/getstream/chat/android/client/api2/model/dto/ChannelInfoDto;", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.mapping.ChannelMappingKt */
/* compiled from: ChannelMapping.kt */
public final class ChannelMappingKt {
    public static final ChannelInfo toDomain(ChannelInfoDto channelInfoDto) {
        Intrinsics.checkNotNullParameter(channelInfoDto, "$this$toDomain");
        return new ChannelInfo(channelInfoDto.getCid(), channelInfoDto.getId(), channelInfoDto.getType(), channelInfoDto.getMember_count(), channelInfoDto.getName());
    }
}
