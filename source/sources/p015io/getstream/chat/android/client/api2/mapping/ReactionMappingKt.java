package p015io.getstream.chat.android.client.api2.mapping;

import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api2.model.dto.ReactionDto;
import p015io.getstream.chat.android.client.api2.model.dto.UserDto;
import p015io.getstream.chat.android.client.models.Reaction;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, mo26107d2 = {"toDomain", "Lio/getstream/chat/android/client/models/Reaction;", "Lio/getstream/chat/android/client/api2/model/dto/ReactionDto;", "toDto", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.mapping.ReactionMappingKt */
/* compiled from: ReactionMapping.kt */
public final class ReactionMappingKt {
    public static final ReactionDto toDto(Reaction reaction) {
        Intrinsics.checkNotNullParameter(reaction, "$this$toDto");
        Date createdAt = reaction.getCreatedAt();
        String messageId = reaction.getMessageId();
        int score = reaction.getScore();
        String type = reaction.getType();
        Date updatedAt = reaction.getUpdatedAt();
        User user = reaction.getUser();
        return new ReactionDto(createdAt, messageId, score, type, updatedAt, user != null ? UserMappingKt.toDto(user) : null, reaction.getUserId(), reaction.getExtraData());
    }

    public static final Reaction toDomain(ReactionDto reactionDto) {
        Intrinsics.checkNotNullParameter(reactionDto, "$this$toDomain");
        Date created_at = reactionDto.getCreated_at();
        String message_id = reactionDto.getMessage_id();
        int score = reactionDto.getScore();
        String type = reactionDto.getType();
        Date updated_at = reactionDto.getUpdated_at();
        UserDto user = reactionDto.getUser();
        return new Reaction(message_id, type, score, user != null ? UserMappingKt.toDomain(user) : null, reactionDto.getUser_id(), created_at, updated_at, (Date) null, (SyncStatus) null, MapsKt.toMutableMap(reactionDto.getExtraData()), false, 1408, (DefaultConstructorMarker) null);
    }
}
