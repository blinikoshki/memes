package com.getstream.sdk.chat.adapter;

import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Attachment;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/AttachmentListItem;", "", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "(Lio/getstream/chat/android/client/models/Attachment;)V", "getAttachment", "()Lio/getstream/chat/android/client/models/Attachment;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentListItem.kt */
public final class AttachmentListItem {
    private final Attachment attachment;

    public static /* synthetic */ AttachmentListItem copy$default(AttachmentListItem attachmentListItem, Attachment attachment2, int i, Object obj) {
        if ((i & 1) != 0) {
            attachment2 = attachmentListItem.attachment;
        }
        return attachmentListItem.copy(attachment2);
    }

    public final Attachment component1() {
        return this.attachment;
    }

    public final AttachmentListItem copy(Attachment attachment2) {
        Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
        return new AttachmentListItem(attachment2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AttachmentListItem) && Intrinsics.areEqual((Object) this.attachment, (Object) ((AttachmentListItem) obj).attachment);
        }
        return true;
    }

    public int hashCode() {
        Attachment attachment2 = this.attachment;
        if (attachment2 != null) {
            return attachment2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AttachmentListItem(attachment=" + this.attachment + ")";
    }

    public AttachmentListItem(Attachment attachment2) {
        Intrinsics.checkNotNullParameter(attachment2, MessengerShareContentUtility.ATTACHMENT);
        this.attachment = attachment2;
    }

    public final Attachment getAttachment() {
        return this.attachment;
    }
}
