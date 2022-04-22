package com.getstream.sdk.chat.adapter;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/getstream/sdk/chat/view/MessageListView$AttachmentClickListener;", "realListener", "Lkotlin/Function0;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ListenerContainerImpl.kt */
final class ListenerContainerImpl$attachmentClickListener$2 extends Lambda implements Function1<Function0<? extends MessageListView.AttachmentClickListener>, MessageListView.AttachmentClickListener> {
    public static final ListenerContainerImpl$attachmentClickListener$2 INSTANCE = new ListenerContainerImpl$attachmentClickListener$2();

    ListenerContainerImpl$attachmentClickListener$2() {
        super(1);
    }

    public final MessageListView.AttachmentClickListener invoke(final Function0<? extends MessageListView.AttachmentClickListener> function0) {
        Intrinsics.checkNotNullParameter(function0, "realListener");
        return new MessageListView.AttachmentClickListener() {
            public final void onAttachmentClick(Message message, Attachment attachment) {
                Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                Intrinsics.checkNotNullParameter(attachment, MessengerShareContentUtility.ATTACHMENT);
                ((MessageListView.AttachmentClickListener) function0.invoke()).onAttachmentClick(message, attachment);
            }
        };
    }
}
