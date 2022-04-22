package com.memes.chat.util.extensions;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.errors.ChatNetworkError;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, mo26107d2 = {"displayableMessage", "", "Lio/getstream/chat/android/client/errors/ChatError;", "chat_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: ChatErrorExt.kt */
public final class ChatErrorExtKt {
    public static final String displayableMessage(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "$this$displayableMessage");
        Throwable cause = chatError.getCause();
        if ((cause instanceof SocketTimeoutException) || (cause instanceof UnknownHostException)) {
            return "Internet is not available.";
        }
        boolean z = true;
        if (chatError instanceof ChatNetworkError) {
            String description = ((ChatNetworkError) chatError).getDescription();
            CharSequence charSequence = description;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                if (cause == null || !StringsKt.contains$default(charSequence, (CharSequence) "See cause", false, 2, (Object) null)) {
                    return description;
                }
                return cause.getClass().getSimpleName() + ": " + cause.getMessage();
            }
        }
        String message = chatError.getMessage();
        CharSequence charSequence2 = message;
        if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
            z = false;
        }
        if (!z) {
            return message;
        }
        Timber.m303e("|> chat-error: " + chatError, new Object[0]);
        return "Something went wrong.";
    }
}
