package com.memes.chat.util;

import com.memes.chat.util.exceptions.InvalidChannelIdException;
import com.memes.chat.util.exceptions.InvalidCurrentUserException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¨\u0006\f"}, mo26107d2 = {"Lcom/memes/chat/util/Verifications;", "", "()V", "requireChannelId", "", "channelId", "requireSignedIn", "Lio/getstream/chat/android/client/models/User;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "requireUserId", "userId", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Verifications.kt */
public final class Verifications {
    public static final Verifications INSTANCE = new Verifications();

    private Verifications() {
    }

    public final User requireSignedIn(ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(chatClient, "chatClient");
        User currentUser = chatClient.getCurrentUser();
        if (currentUser != null) {
            return currentUser;
        }
        throw new InvalidCurrentUserException();
    }

    public final String requireChannelId(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            throw new InvalidChannelIdException(str);
        } else if (StringsKt.contains$default(charSequence, (CharSequence) ":", false, 2, (Object) null)) {
            return str;
        } else {
            throw new InvalidChannelIdException(str);
        }
    }

    public final String requireUserId(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return str;
        }
        throw new InvalidChannelIdException(str);
    }
}
