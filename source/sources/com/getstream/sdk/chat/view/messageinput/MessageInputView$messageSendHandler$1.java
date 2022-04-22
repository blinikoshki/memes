package com.getstream.sdk.chat.view.messageinput;

import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.view.messageinput.MessageInputView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u0014"}, mo26107d2 = {"com/getstream/sdk/chat/view/messageinput/MessageInputView$messageSendHandler$1", "Lcom/getstream/sdk/chat/view/messageinput/MessageInputView$MessageSendHandler;", "editMessage", "", "oldMessage", "Lio/getstream/chat/android/client/models/Message;", "newMessageText", "", "sendMessage", "messageText", "sendMessageWithAttachments", "message", "attachmentsFiles", "", "Ljava/io/File;", "sendToThread", "parentMessage", "alsoSendToChannel", "", "sendToThreadWithAttachments", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageInputView.kt */
public final class MessageInputView$messageSendHandler$1 implements MessageInputView.MessageSendHandler {
    MessageInputView$messageSendHandler$1() {
    }

    public void sendMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "messageText");
        throw new IllegalStateException("MessageInputView#messageSendHandler needs to be configured to send messages");
    }

    public void sendMessageWithAttachments(String str, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(list, "attachmentsFiles");
        throw new IllegalStateException("MessageInputView#messageSendHandler needs to be configured to send messages");
    }

    public void sendToThread(Message message, String str, boolean z) {
        Intrinsics.checkNotNullParameter(message, "parentMessage");
        Intrinsics.checkNotNullParameter(str, "messageText");
        throw new IllegalStateException("MessageInputView#messageSendHandler needs to be configured to send messages");
    }

    public void sendToThreadWithAttachments(Message message, String str, boolean z, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(message, "parentMessage");
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(list, "attachmentsFiles");
        throw new IllegalStateException("MessageInputView#messageSendHandler needs to be configured to send messages");
    }

    public void editMessage(Message message, String str) {
        Intrinsics.checkNotNullParameter(message, "oldMessage");
        Intrinsics.checkNotNullParameter(str, "newMessageText");
        throw new IllegalStateException("MessageInputView#messageSendHandler needs to be configured to send messages");
    }
}
