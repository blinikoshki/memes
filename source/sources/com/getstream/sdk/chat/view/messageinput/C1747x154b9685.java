package com.getstream.sdk.chat.view.messageinput;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.getstream.sdk.chat.enums.MessageInputType;
import com.getstream.sdk.chat.model.AttachmentMetaData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo26107d2 = {"<anonymous>", "", "attachment", "Lcom/getstream/sdk/chat/model/AttachmentMetaData;", "invoke", "com/getstream/sdk/chat/view/messageinput/AttachmentsController$setTotalMediaAttachmentAdapter$2$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.view.messageinput.AttachmentsController$setTotalMediaAttachmentAdapter$$inlined$apply$lambda$1 */
/* compiled from: AttachmentsController.kt */
final class C1747x154b9685 extends Lambda implements Function1<AttachmentMetaData, Unit> {
    final /* synthetic */ MessageInputType $messageInputType$inlined;
    final /* synthetic */ List $totalAttachment$inlined;
    final /* synthetic */ AttachmentsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1747x154b9685(AttachmentsController attachmentsController, List list, MessageInputType messageInputType) {
        super(1);
        this.this$0 = attachmentsController;
        this.$totalAttachment$inlined = list;
        this.$messageInputType$inlined = messageInputType;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AttachmentMetaData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AttachmentMetaData attachmentMetaData) {
        Intrinsics.checkNotNullParameter(attachmentMetaData, MessengerShareContentUtility.ATTACHMENT);
        this.this$0.updateMediaAttachment(attachmentMetaData, this.$messageInputType$inlined);
    }
}
