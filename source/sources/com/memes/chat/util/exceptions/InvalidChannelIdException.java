package com.memes.chat.util.exceptions;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/util/exceptions/InvalidChannelIdException;", "Lcom/memes/chat/util/exceptions/ChatException;", "channelId", "", "(Ljava/lang/String;)V", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: InvalidChannelIdException.kt */
public final class InvalidChannelIdException extends ChatException {
    public InvalidChannelIdException(String str) {
        super("Channel ID is not valid: " + str, false, 2, (DefaultConstructorMarker) null);
    }
}
