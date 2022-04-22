package com.getstream.sdk.chat.view.messageinput;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.enums.MessageInputType;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "attachment", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentsController.kt */
final class AttachmentsController$setSelectedMediaAttachmentAdapter$1 extends Lambda implements Function1<AttachmentMetaData, Unit> {
    final /* synthetic */ MessageInputType $messageInputType;
    final /* synthetic */ AttachmentsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AttachmentsController$setSelectedMediaAttachmentAdapter$1(AttachmentsController attachmentsController, MessageInputType messageInputType) {
        super(1);
        this.this$0 = attachmentsController;
        this.$messageInputType = messageInputType;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AttachmentMetaData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        this.this$0.cancelAttachment$stream_chat_android_release(attachmentMetaData, this.$messageInputType, true);
    }
}
