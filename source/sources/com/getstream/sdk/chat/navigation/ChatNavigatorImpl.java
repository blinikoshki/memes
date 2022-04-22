package com.getstream.sdk.chat.navigation;

import com.getstream.sdk.chat.navigation.destinations.ChatDestination;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/navigation/ChatNavigatorImpl;", "Lcom/getstream/sdk/chat/navigation/ChatNavigator;", "handler", "Lcom/getstream/sdk/chat/navigation/ChatNavigationHandler;", "(Lcom/getstream/sdk/chat/navigation/ChatNavigationHandler;)V", "navigate", "", "destination", "Lcom/getstream/sdk/chat/navigation/destinations/ChatDestination;", "performDefaultNavigation", "Companion", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatNavigatorImpl.kt */
public final class ChatNavigatorImpl implements ChatNavigator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ChatNavigationHandler EMPTY_HANDLER = new ChatNavigatorImpl$Companion$EMPTY_HANDLER$1();
    private final ChatNavigationHandler handler;

    public ChatNavigatorImpl(ChatNavigationHandler chatNavigationHandler) {
        Intrinsics.checkNotNullParameter(chatNavigationHandler, "handler");
        this.handler = chatNavigationHandler;
    }

    public void navigate(ChatDestination chatDestination) {
        Intrinsics.checkNotNullParameter(chatDestination, "destination");
        if (!this.handler.navigate(chatDestination)) {
            performDefaultNavigation(chatDestination);
        }
    }

    private final void performDefaultNavigation(ChatDestination chatDestination) {
        chatDestination.navigate();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/getstream/sdk/chat/navigation/ChatNavigatorImpl$Companion;", "", "()V", "EMPTY_HANDLER", "Lcom/getstream/sdk/chat/navigation/ChatNavigationHandler;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatNavigatorImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
