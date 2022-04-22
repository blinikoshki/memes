package com.getstream.sdk.chat.view.messageinput;

import com.getstream.sdk.chat.enums.MessageInputType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: AttachmentsController.kt */
final class AttachmentsController$onClickOpenMediaSelectView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MessageInputType $messageInputType;
    final /* synthetic */ AttachmentsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AttachmentsController$onClickOpenMediaSelectView$1(AttachmentsController attachmentsController, MessageInputType messageInputType) {
        super(0);
        this.this$0 = attachmentsController;
        this.$messageInputType = messageInputType;
    }

    public final void invoke() {
        this.this$0.onClickOpenMediaSelectView$stream_chat_android_release(this.$messageInputType);
    }
}
