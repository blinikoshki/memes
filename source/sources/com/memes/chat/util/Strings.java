package com.memes.chat.util;

import com.memes.chat.util.extensions.ChatErrorExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/chat/util/Strings;", "", "()V", "channelRenameTextNotValid", "", "errorCreatingChannelWithoutMembers", "errorCreatingChannelWithoutName", "errorLeavingChannel", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "errorRemovingChannelMember", "errorRenamingChannel", "userExistenceCheckFailed", "userNotOnStream", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Strings.kt */
public final class Strings {
    public static final Strings INSTANCE = new Strings();

    public final String channelRenameTextNotValid() {
        return "Invalid New Chat Name.";
    }

    public final String errorCreatingChannelWithoutMembers() {
        return "Unable to create a chat with no members.";
    }

    public final String errorCreatingChannelWithoutName() {
        return "Unable to create channel without name.";
    }

    public final String userExistenceCheckFailed() {
        return "Unable to find user";
    }

    public final String userNotOnStream() {
        return "Selected user does not have latest version of Memes. You cannot add this user in the conversation at this moment.";
    }

    private Strings() {
    }

    public final String errorLeavingChannel(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
        return "Unable to leave chat: " + ChatErrorExtKt.displayableMessage(chatError);
    }

    public final String errorRemovingChannelMember(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
        return "Unable to remove member: " + ChatErrorExtKt.displayableMessage(chatError);
    }

    public final String errorRenamingChannel(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
        return "Unable to rename chat: " + ChatErrorExtKt.displayableMessage(chatError);
    }
}
