package com.getstream.sdk.chat.navigation;

import com.getstream.sdk.chat.navigation.destinations.ChatDestination;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/getstream/sdk/chat/navigation/ChatNavigatorImpl$Companion$EMPTY_HANDLER$1", "Lcom/getstream/sdk/chat/navigation/ChatNavigationHandler;", "navigate", "", "destination", "Lcom/getstream/sdk/chat/navigation/destinations/ChatDestination;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatNavigatorImpl.kt */
public final class ChatNavigatorImpl$Companion$EMPTY_HANDLER$1 implements ChatNavigationHandler {
    public boolean navigate(ChatDestination chatDestination) {
        Intrinsics.checkNotNullParameter(chatDestination, "destination");
        return false;
    }

    ChatNavigatorImpl$Companion$EMPTY_HANDLER$1() {
    }
}
