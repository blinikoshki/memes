package com.getstream.sdk.chat.viewmodel.messages;

import com.facebook.share.internal.ShareConstants;
import com.getstream.sdk.chat.viewmodel.messages.MessageListViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "previousMessage", "Lio/getstream/chat/android/client/models/Message;", "message", "shouldAddDateSeparator"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewModel.kt */
final class MessageListViewModel$dateSeparatorHandler$1 implements MessageListViewModel.DateSeparatorHandler {
    public static final MessageListViewModel$dateSeparatorHandler$1 INSTANCE = new MessageListViewModel$dateSeparatorHandler$1();

    MessageListViewModel$dateSeparatorHandler$1() {
    }

    public final boolean shouldAddDateSeparator(Message message, Message message2) {
        Intrinsics.checkNotNullParameter(message2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return message == null || MessageListItemLiveDataKt.getCreatedAtOrThrow(message2).getTime() - MessageListItemLiveDataKt.getCreatedAtOrThrow(message).getTime() > ((long) 14400000);
    }
}
