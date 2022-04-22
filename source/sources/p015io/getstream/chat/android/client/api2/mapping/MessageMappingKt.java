package p015io.getstream.chat.android.client.api2.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api2.model.dto.AttachmentDto;
import p015io.getstream.chat.android.client.api2.model.dto.ChannelInfoDto;
import p015io.getstream.chat.android.client.api2.model.dto.DownstreamMessageDto;
import p015io.getstream.chat.android.client.api2.model.dto.ReactionDto;
import p015io.getstream.chat.android.client.api2.model.dto.UpstreamMessageDto;
import p015io.getstream.chat.android.client.api2.model.dto.UserDto;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.ChannelInfo;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.SyncStatus;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0001H\u0000¨\u0006\u0005"}, mo26107d2 = {"toDomain", "Lio/getstream/chat/android/client/models/Message;", "Lio/getstream/chat/android/client/api2/model/dto/DownstreamMessageDto;", "toDto", "Lio/getstream/chat/android/client/api2/model/dto/UpstreamMessageDto;", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api2.mapping.MessageMappingKt */
/* compiled from: MessageMapping.kt */
public final class MessageMappingKt {
    public static final UpstreamMessageDto toDto(Message message) {
        Intrinsics.checkNotNullParameter(message, "$this$toDto");
        Iterable<Attachment> attachments = message.getAttachments();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(attachments, 10));
        for (Attachment dto : attachments) {
            arrayList.add(AttachmentMappingKt.toDto(dto));
        }
        List list = (List) arrayList;
        String cid = message.getCid();
        String command = message.getCommand();
        String html = message.getHtml();
        String id = message.getId();
        List<String> mentionedUsersIds = message.getMentionedUsersIds();
        String parentId = message.getParentId();
        Date pinExpires = message.getPinExpires();
        boolean pinned = message.getPinned();
        Date pinnedAt = message.getPinnedAt();
        User pinnedBy = message.getPinnedBy();
        UserDto dto2 = pinnedBy != null ? UserMappingKt.toDto(pinnedBy) : null;
        Message replyTo = message.getReplyTo();
        UpstreamMessageDto dto3 = replyTo != null ? toDto(replyTo) : null;
        String replyMessageId = message.getReplyMessageId();
        boolean shadowed = message.getShadowed();
        boolean showInChannel = message.getShowInChannel();
        boolean silent = message.getSilent();
        String text = message.getText();
        Iterable<User> threadParticipants = message.getThreadParticipants();
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(threadParticipants, 10));
        for (User dto4 : threadParticipants) {
            arrayList2.add(UserMappingKt.toDto(dto4));
        }
        return new UpstreamMessageDto(list, cid, command, html, id, mentionedUsersIds, parentId, pinExpires, pinned, pinnedAt, dto2, dto3, replyMessageId, shadowed, showInChannel, silent, text, (List) arrayList2, UserMappingKt.toDto(message.getUser()), message.getExtraData());
    }

    public static final Message toDomain(DownstreamMessageDto downstreamMessageDto) {
        Intrinsics.checkNotNullParameter(downstreamMessageDto, "$this$toDomain");
        Collection arrayList = new ArrayList();
        for (AttachmentDto domain : downstreamMessageDto.getAttachments()) {
            arrayList.add(AttachmentMappingKt.toDomain(domain));
        }
        List list = (List) arrayList;
        ChannelInfoDto channel = downstreamMessageDto.getChannel();
        ChannelInfo domain2 = channel != null ? ChannelMappingKt.toDomain(channel) : null;
        String cid = downstreamMessageDto.getCid();
        String command = downstreamMessageDto.getCommand();
        Date created_at = downstreamMessageDto.getCreated_at();
        Date deleted_at = downstreamMessageDto.getDeleted_at();
        String html = downstreamMessageDto.getHtml();
        Map<String, String> i18n = downstreamMessageDto.getI18n();
        String id = downstreamMessageDto.getId();
        Collection arrayList2 = new ArrayList();
        for (ReactionDto domain3 : downstreamMessageDto.getLatest_reactions()) {
            arrayList2.add(ReactionMappingKt.toDomain(domain3));
        }
        List list2 = (List) arrayList2;
        Collection arrayList3 = new ArrayList();
        for (UserDto domain4 : downstreamMessageDto.getMentioned_users()) {
            arrayList3.add(UserMappingKt.toDomain(domain4));
        }
        List list3 = (List) arrayList3;
        Collection arrayList4 = new ArrayList();
        for (ReactionDto domain5 : downstreamMessageDto.getOwn_reactions()) {
            arrayList4.add(ReactionMappingKt.toDomain(domain5));
        }
        List list4 = (List) arrayList4;
        String parent_id = downstreamMessageDto.getParent_id();
        Date pin_expires = downstreamMessageDto.getPin_expires();
        boolean pinned = downstreamMessageDto.getPinned();
        Date pinned_at = downstreamMessageDto.getPinned_at();
        UserDto pinned_by = downstreamMessageDto.getPinned_by();
        User domain6 = pinned_by != null ? UserMappingKt.toDomain(pinned_by) : null;
        Map<String, Integer> mutableMap = MapsKt.toMutableMap(downstreamMessageDto.getReaction_counts());
        Map<String, Integer> mutableMap2 = MapsKt.toMutableMap(downstreamMessageDto.getReaction_scores());
        int reply_count = downstreamMessageDto.getReply_count();
        String quoted_message_id = downstreamMessageDto.getQuoted_message_id();
        DownstreamMessageDto quoted_message = downstreamMessageDto.getQuoted_message();
        Message domain7 = quoted_message != null ? toDomain(quoted_message) : null;
        boolean shadowed = downstreamMessageDto.getShadowed();
        boolean show_in_channel = downstreamMessageDto.getShow_in_channel();
        boolean silent = downstreamMessageDto.getSilent();
        String text = downstreamMessageDto.getText();
        Iterable<UserDto> thread_participants = downstreamMessageDto.getThread_participants();
        Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(thread_participants, 10));
        for (UserDto domain8 : thread_participants) {
            arrayList5.add(UserMappingKt.toDomain(domain8));
        }
        return new Message(id, cid, text, html, parent_id, command, list, (List) null, list3, reply_count, mutableMap, mutableMap2, (SyncStatus) null, downstreamMessageDto.getType(), list2, list4, created_at, downstreamMessageDto.getUpdated_at(), deleted_at, (Date) null, (Date) null, UserMappingKt.toDomain(downstreamMessageDto.getUser()), MapsKt.toMutableMap(downstreamMessageDto.getExtraData()), silent, shadowed, i18n, show_in_channel, domain2, domain7, quoted_message_id, pinned, pinned_at, pin_expires, domain6, (List) arrayList5, 1577088, 0, (DefaultConstructorMarker) null);
    }
}
