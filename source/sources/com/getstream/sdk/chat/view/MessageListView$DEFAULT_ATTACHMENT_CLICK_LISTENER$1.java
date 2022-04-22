package com.getstream.sdk.chat.view;

import android.content.Context;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.ChatUI;
import com.getstream.sdk.chat.navigation.ChatNavigator;
import com.getstream.sdk.chat.navigation.destinations.AttachmentDestination;
import com.getstream.sdk.chat.view.MessageListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "message", "Lio/getstream/chat/android/client/models/Message;", "attachment", "Lio/getstream/chat/android/client/models/Attachment;", "onAttachmentClick"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListView.kt */
final class MessageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1 implements MessageListView.AttachmentClickListener {
    final /* synthetic */ MessageListView this$0;

    MessageListView$DEFAULT_ATTACHMENT_CLICK_LISTENER$1(MessageListView messageListView) {
        this.this$0 = messageListView;
    }

    public final void onAttachmentClick(Message message, Attachment attachment) {
        Intrinsics.checkNotNullParameter(message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(attachment, MessengerShareContentUtility.ATTACHMENT);
        ChatNavigator navigator = ChatUI.Companion.instance().getNavigator();
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        navigator.navigate(new AttachmentDestination(message, attachment, context));
    }
}
