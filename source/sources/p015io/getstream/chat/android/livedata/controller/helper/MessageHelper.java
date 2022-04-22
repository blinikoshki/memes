package p015io.getstream.chat.android.livedata.controller.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.helpers.AttachmentHelper;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.ChannelInfo;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.SyncStatus;
import p015io.getstream.chat.android.client.utils.SystemTimeProvider;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002J.\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0012J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/helper/MessageHelper;", "", "attachmentHelper", "Lio/getstream/chat/android/client/helpers/AttachmentHelper;", "(Lio/getstream/chat/android/client/helpers/AttachmentHelper;)V", "updateValidAttachmentUrl", "Lio/getstream/chat/android/client/models/Attachment;", "newAttachment", "oldAttachment", "updateValidAttachmentsUrl", "Lio/getstream/chat/android/client/models/Message;", "newMessage", "oldMessage", "", "newAttachments", "oldAttachments", "newMessages", "oldMessages", "", "", "partialEquality", "", "other", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.helper.MessageHelper */
/* compiled from: MessageHelper.kt */
public final class MessageHelper {
    private final AttachmentHelper attachmentHelper;

    public MessageHelper() {
        this((AttachmentHelper) null, 1, (DefaultConstructorMarker) null);
    }

    public MessageHelper(AttachmentHelper attachmentHelper2) {
        Intrinsics.checkNotNullParameter(attachmentHelper2, "attachmentHelper");
        this.attachmentHelper = attachmentHelper2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageHelper(AttachmentHelper attachmentHelper2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AttachmentHelper((SystemTimeProvider) null, 1, (DefaultConstructorMarker) null) : attachmentHelper2);
    }

    public final List<Message> updateValidAttachmentsUrl(List<Message> list, Map<String, Message> map) {
        Intrinsics.checkNotNullParameter(list, "newMessages");
        Intrinsics.checkNotNullParameter(map, "oldMessages");
        if (map.isEmpty()) {
            return list;
        }
        Iterable<Message> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Message message : iterable) {
            arrayList.add(updateValidAttachmentsUrl(message, map.get(message.getId())));
        }
        return (List) arrayList;
    }

    private final Message updateValidAttachmentsUrl(Message message, Message message2) {
        if (message.getAttachments().isEmpty() || message2 == null) {
            return message;
        }
        return Message.copy$default(message, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, CollectionsKt.toMutableList(updateValidAttachmentsUrl(message.getAttachments(), message2.getAttachments())), (List) null, (List) null, 0, (Map) null, (Map) null, (SyncStatus) null, (String) null, (List) null, (List) null, (Date) null, (Date) null, (Date) null, (Date) null, (Date) null, (User) null, (Map) null, false, false, (Map) null, false, (ChannelInfo) null, (Message) null, (String) null, false, (Date) null, (Date) null, (User) null, (List) null, -65, 7, (Object) null);
    }

    private final List<Attachment> updateValidAttachmentsUrl(List<Attachment> list, List<Attachment> list2) {
        Object obj;
        Iterable<Attachment> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Attachment attachment : iterable) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (partialEquality((Attachment) obj, attachment)) {
                    break;
                }
            }
            arrayList.add(updateValidAttachmentUrl(attachment, (Attachment) obj));
        }
        return (List) arrayList;
    }

    private final Attachment updateValidAttachmentUrl(Attachment attachment, Attachment attachment2) {
        Attachment attachment3 = attachment2;
        if (attachment3 != null) {
            CharSequence imageUrl = attachment2.getImageUrl();
            if (!(imageUrl == null || imageUrl.length() == 0) && !Intrinsics.areEqual((Object) attachment2.getImageUrl(), (Object) attachment.getImageUrl())) {
                if (this.attachmentHelper.hasValidImageUrl(attachment3)) {
                    return Attachment.copy$default(attachment, (String) null, (String) null, (String) null, attachment2.getImageUrl(), (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (File) null, (Attachment.UploadState) null, (Map) null, 262135, (Object) null);
                }
                return attachment;
            }
        }
        return attachment;
    }

    private final boolean partialEquality(Attachment attachment, Attachment attachment2) {
        return Intrinsics.areEqual((Object) attachment.getAuthorName(), (Object) attachment2.getAuthorName()) && Intrinsics.areEqual((Object) attachment.getTitleLink(), (Object) attachment2.getTitleLink()) && Intrinsics.areEqual((Object) attachment.getMimeType(), (Object) attachment2.getMimeType()) && attachment.getFileSize() == attachment2.getFileSize() && Intrinsics.areEqual((Object) attachment.getTitle(), (Object) attachment2.getTitle()) && Intrinsics.areEqual((Object) attachment.getText(), (Object) attachment2.getText()) && Intrinsics.areEqual((Object) attachment.getType(), (Object) attachment2.getType()) && Intrinsics.areEqual((Object) attachment.getName(), (Object) attachment2.getName()) && Intrinsics.areEqual((Object) attachment.getFallback(), (Object) attachment2.getFallback());
    }
}
