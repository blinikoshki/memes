package p015io.getstream.chat.android.livedata.repository.domain.message;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.livedata.repository.domain.message.attachment.AttachmentEntity;
import p015io.getstream.chat.android.livedata.repository.domain.reaction.ReactionEntity;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/message/MessageEntity;", "", "messageInnerEntity", "Lio/getstream/chat/android/livedata/repository/domain/message/MessageInnerEntity;", "attachments", "", "Lio/getstream/chat/android/livedata/repository/domain/message/attachment/AttachmentEntity;", "ownReactions", "Lio/getstream/chat/android/livedata/repository/domain/reaction/ReactionEntity;", "latestReactions", "(Lio/getstream/chat/android/livedata/repository/domain/message/MessageInnerEntity;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAttachments", "()Ljava/util/List;", "getLatestReactions", "getMessageInnerEntity", "()Lio/getstream/chat/android/livedata/repository/domain/message/MessageInnerEntity;", "getOwnReactions", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.message.MessageEntity */
/* compiled from: MessageEntity.kt */
public final class MessageEntity {
    private final List<AttachmentEntity> attachments;
    private final List<ReactionEntity> latestReactions;
    private final MessageInnerEntity messageInnerEntity;
    private final List<ReactionEntity> ownReactions;

    public static /* synthetic */ MessageEntity copy$default(MessageEntity messageEntity, MessageInnerEntity messageInnerEntity2, List<AttachmentEntity> list, List<ReactionEntity> list2, List<ReactionEntity> list3, int i, Object obj) {
        if ((i & 1) != 0) {
            messageInnerEntity2 = messageEntity.messageInnerEntity;
        }
        if ((i & 2) != 0) {
            list = messageEntity.attachments;
        }
        if ((i & 4) != 0) {
            list2 = messageEntity.ownReactions;
        }
        if ((i & 8) != 0) {
            list3 = messageEntity.latestReactions;
        }
        return messageEntity.copy(messageInnerEntity2, list, list2, list3);
    }

    public final MessageInnerEntity component1() {
        return this.messageInnerEntity;
    }

    public final List<AttachmentEntity> component2() {
        return this.attachments;
    }

    public final List<ReactionEntity> component3() {
        return this.ownReactions;
    }

    public final List<ReactionEntity> component4() {
        return this.latestReactions;
    }

    public final MessageEntity copy(MessageInnerEntity messageInnerEntity2, List<AttachmentEntity> list, List<ReactionEntity> list2, List<ReactionEntity> list3) {
        Intrinsics.checkNotNullParameter(messageInnerEntity2, "messageInnerEntity");
        Intrinsics.checkNotNullParameter(list, "attachments");
        Intrinsics.checkNotNullParameter(list2, "ownReactions");
        Intrinsics.checkNotNullParameter(list3, "latestReactions");
        return new MessageEntity(messageInnerEntity2, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageEntity)) {
            return false;
        }
        MessageEntity messageEntity = (MessageEntity) obj;
        return Intrinsics.areEqual((Object) this.messageInnerEntity, (Object) messageEntity.messageInnerEntity) && Intrinsics.areEqual((Object) this.attachments, (Object) messageEntity.attachments) && Intrinsics.areEqual((Object) this.ownReactions, (Object) messageEntity.ownReactions) && Intrinsics.areEqual((Object) this.latestReactions, (Object) messageEntity.latestReactions);
    }

    public int hashCode() {
        MessageInnerEntity messageInnerEntity2 = this.messageInnerEntity;
        int i = 0;
        int hashCode = (messageInnerEntity2 != null ? messageInnerEntity2.hashCode() : 0) * 31;
        List<AttachmentEntity> list = this.attachments;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<ReactionEntity> list2 = this.ownReactions;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ReactionEntity> list3 = this.latestReactions;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "MessageEntity(messageInnerEntity=" + this.messageInnerEntity + ", attachments=" + this.attachments + ", ownReactions=" + this.ownReactions + ", latestReactions=" + this.latestReactions + ")";
    }

    public MessageEntity(MessageInnerEntity messageInnerEntity2, List<AttachmentEntity> list, List<ReactionEntity> list2, List<ReactionEntity> list3) {
        Intrinsics.checkNotNullParameter(messageInnerEntity2, "messageInnerEntity");
        Intrinsics.checkNotNullParameter(list, "attachments");
        Intrinsics.checkNotNullParameter(list2, "ownReactions");
        Intrinsics.checkNotNullParameter(list3, "latestReactions");
        this.messageInnerEntity = messageInnerEntity2;
        this.attachments = list;
        this.ownReactions = list2;
        this.latestReactions = list3;
    }

    public final MessageInnerEntity getMessageInnerEntity() {
        return this.messageInnerEntity;
    }

    public final List<AttachmentEntity> getAttachments() {
        return this.attachments;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageEntity(MessageInnerEntity messageInnerEntity2, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(messageInnerEntity2, list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? CollectionsKt.emptyList() : list3);
    }

    public final List<ReactionEntity> getOwnReactions() {
        return this.ownReactions;
    }

    public final List<ReactionEntity> getLatestReactions() {
        return this.latestReactions;
    }
}
