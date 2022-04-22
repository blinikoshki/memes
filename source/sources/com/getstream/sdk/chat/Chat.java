package com.getstream.sdk.chat;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.getstream.sdk.chat.UrlSigner;
import com.getstream.sdk.chat.enums.OnlineStatus;
import com.getstream.sdk.chat.navigation.ChatNavigationHandler;
import com.getstream.sdk.chat.navigation.ChatNavigator;
import com.getstream.sdk.chat.style.ChatFonts;
import com.getstream.sdk.chat.style.ChatFontsImpl;
import com.getstream.sdk.chat.style.ChatStyle;
import com.getstream.sdk.chat.utils.strings.ChatStrings;
import com.getstream.sdk.chat.utils.strings.ChatStringsImpl;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.logger.ChatLogLevel;
import p015io.getstream.chat.android.client.logger.ChatLoggerHandler;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.notifications.handler.ChatNotificationHandler;
import p015io.getstream.chat.android.client.notifications.handler.NotificationConfig;
import p015io.getstream.chat.android.client.socket.InitConnectionListener;
import p015io.getstream.chat.android.client.uploader.FileUploader;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 -2\u00020\u0001:\u0002,-J\b\u0010#\u001a\u00020$H&J\"\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020 2\b\b\u0002\u0010(\u001a\u00020)H&J\b\u0010*\u001a\u00020+H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0006R\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0006R\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006."}, mo26107d2 = {"Lcom/getstream/sdk/chat/Chat;", "", "currentUser", "Landroidx/lifecycle/LiveData;", "Lio/getstream/chat/android/client/models/User;", "getCurrentUser", "()Landroidx/lifecycle/LiveData;", "fonts", "Lcom/getstream/sdk/chat/style/ChatFonts;", "getFonts", "()Lcom/getstream/sdk/chat/style/ChatFonts;", "markdown", "Lcom/getstream/sdk/chat/ChatMarkdown;", "getMarkdown", "()Lcom/getstream/sdk/chat/ChatMarkdown;", "navigator", "Lcom/getstream/sdk/chat/navigation/ChatNavigator;", "getNavigator", "()Lcom/getstream/sdk/chat/navigation/ChatNavigator;", "onlineStatus", "Lcom/getstream/sdk/chat/enums/OnlineStatus;", "getOnlineStatus", "strings", "Lcom/getstream/sdk/chat/utils/strings/ChatStrings;", "getStrings", "()Lcom/getstream/sdk/chat/utils/strings/ChatStrings;", "unreadChannels", "", "getUnreadChannels", "unreadMessages", "getUnreadMessages", "version", "", "getVersion", "()Ljava/lang/String;", "disconnect", "", "setUser", "user", "token", "callbacks", "Lio/getstream/chat/android/client/socket/InitConnectionListener;", "urlSigner", "Lcom/getstream/sdk/chat/UrlSigner;", "Builder", "Companion", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(level = DeprecationLevel.ERROR, message = "The Chat interface has been replaced by ChatUI. Have a look at the updated Android tutorial for details.")
/* compiled from: Chat.kt */
public interface Chat {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* renamed from: com.getstream.sdk.chat.Chat$-CC  reason: invalid class name */
    /* compiled from: Chat.kt */
    public final /* synthetic */ class CC {
        @JvmStatic
        @Deprecated(level = DeprecationLevel.ERROR, message = "Use Chat.instance() instead", replaceWith = @ReplaceWith(expression = "Chat.instance()", imports = {}))
        public static Chat getInstance() {
            return Chat.Companion.getInstance();
        }

        @JvmStatic
        public static Chat instance() {
            return Chat.Companion.instance();
        }
    }

    void disconnect();

    LiveData<User> getCurrentUser();

    ChatFonts getFonts();

    ChatMarkdown getMarkdown();

    ChatNavigator getNavigator();

    LiveData<OnlineStatus> getOnlineStatus();

    ChatStrings getStrings();

    LiveData<Number> getUnreadChannels();

    LiveData<Number> getUnreadMessages();

    String getVersion();

    void setUser(User user, String str, InitConnectionListener initConnectionListener);

    UrlSigner urlSigner();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: Chat.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void setUser$default(Chat chat, User user, String str, InitConnectionListener initConnectionListener, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    initConnectionListener = new Chat$setUser$1();
                }
                chat.setUser(user, str, initConnectionListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setUser");
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010=\u001a\u00020>R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006?"}, mo26107d2 = {"Lcom/getstream/sdk/chat/Chat$Builder;", "", "apiKey", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "chatLogLevel", "Lio/getstream/chat/android/client/logger/ChatLogLevel;", "getChatLogLevel", "()Lio/getstream/chat/android/client/logger/ChatLogLevel;", "setChatLogLevel", "(Lio/getstream/chat/android/client/logger/ChatLogLevel;)V", "chatLoggerHandler", "Lio/getstream/chat/android/client/logger/ChatLoggerHandler;", "getChatLoggerHandler", "()Lio/getstream/chat/android/client/logger/ChatLoggerHandler;", "setChatLoggerHandler", "(Lio/getstream/chat/android/client/logger/ChatLoggerHandler;)V", "fileUploader", "Lio/getstream/chat/android/client/uploader/FileUploader;", "getFileUploader", "()Lio/getstream/chat/android/client/uploader/FileUploader;", "setFileUploader", "(Lio/getstream/chat/android/client/uploader/FileUploader;)V", "markdown", "Lcom/getstream/sdk/chat/ChatMarkdown;", "getMarkdown", "()Lcom/getstream/sdk/chat/ChatMarkdown;", "setMarkdown", "(Lcom/getstream/sdk/chat/ChatMarkdown;)V", "navigationHandler", "Lcom/getstream/sdk/chat/navigation/ChatNavigationHandler;", "getNavigationHandler", "()Lcom/getstream/sdk/chat/navigation/ChatNavigationHandler;", "setNavigationHandler", "(Lcom/getstream/sdk/chat/navigation/ChatNavigationHandler;)V", "notificationHandler", "Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "getNotificationHandler", "()Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;", "setNotificationHandler", "(Lio/getstream/chat/android/client/notifications/handler/ChatNotificationHandler;)V", "offlineEnabled", "", "getOfflineEnabled", "()Z", "setOfflineEnabled", "(Z)V", "style", "Lcom/getstream/sdk/chat/style/ChatStyle;", "getStyle", "()Lcom/getstream/sdk/chat/style/ChatStyle;", "setStyle", "(Lcom/getstream/sdk/chat/style/ChatStyle;)V", "urlSigner", "Lcom/getstream/sdk/chat/UrlSigner;", "getUrlSigner", "()Lcom/getstream/sdk/chat/UrlSigner;", "setUrlSigner", "(Lcom/getstream/sdk/chat/UrlSigner;)V", "build", "Lcom/getstream/sdk/chat/Chat;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Chat.kt */
    public static final class Builder {
        private final String apiKey;
        private ChatLogLevel chatLogLevel;
        private ChatLoggerHandler chatLoggerHandler;
        private final Context context;
        private FileUploader fileUploader;
        private ChatMarkdown markdown;
        private ChatNavigationHandler navigationHandler;
        private ChatNotificationHandler notificationHandler;
        private boolean offlineEnabled;
        private ChatStyle style = new ChatStyle.Builder().build();
        private UrlSigner urlSigner = new UrlSigner.DefaultUrlSigner();

        public Builder(String str, Context context2) {
            Intrinsics.checkNotNullParameter(str, "apiKey");
            Intrinsics.checkNotNullParameter(context2, "context");
            this.apiKey = str;
            this.context = context2;
            this.markdown = new ChatMarkdownImpl(context2);
            this.notificationHandler = new ChatNotificationHandler(context2, (NotificationConfig) null, 2, (DefaultConstructorMarker) null);
            this.chatLogLevel = ChatLogLevel.NOTHING;
        }

        public final ChatNavigationHandler getNavigationHandler() {
            return this.navigationHandler;
        }

        public final void setNavigationHandler(ChatNavigationHandler chatNavigationHandler) {
            this.navigationHandler = chatNavigationHandler;
        }

        public final ChatStyle getStyle() {
            return this.style;
        }

        public final void setStyle(ChatStyle chatStyle) {
            Intrinsics.checkNotNullParameter(chatStyle, "<set-?>");
            this.style = chatStyle;
        }

        public final UrlSigner getUrlSigner() {
            return this.urlSigner;
        }

        public final void setUrlSigner(UrlSigner urlSigner2) {
            Intrinsics.checkNotNullParameter(urlSigner2, "<set-?>");
            this.urlSigner = urlSigner2;
        }

        public final ChatMarkdown getMarkdown() {
            return this.markdown;
        }

        public final void setMarkdown(ChatMarkdown chatMarkdown) {
            Intrinsics.checkNotNullParameter(chatMarkdown, "<set-?>");
            this.markdown = chatMarkdown;
        }

        public final boolean getOfflineEnabled() {
            return this.offlineEnabled;
        }

        public final void setOfflineEnabled(boolean z) {
            this.offlineEnabled = z;
        }

        public final ChatNotificationHandler getNotificationHandler() {
            return this.notificationHandler;
        }

        public final void setNotificationHandler(ChatNotificationHandler chatNotificationHandler) {
            Intrinsics.checkNotNullParameter(chatNotificationHandler, "<set-?>");
            this.notificationHandler = chatNotificationHandler;
        }

        public final ChatLogLevel getChatLogLevel() {
            return this.chatLogLevel;
        }

        public final void setChatLogLevel(ChatLogLevel chatLogLevel2) {
            Intrinsics.checkNotNullParameter(chatLogLevel2, "<set-?>");
            this.chatLogLevel = chatLogLevel2;
        }

        public final ChatLoggerHandler getChatLoggerHandler() {
            return this.chatLoggerHandler;
        }

        public final void setChatLoggerHandler(ChatLoggerHandler chatLoggerHandler2) {
            this.chatLoggerHandler = chatLoggerHandler2;
        }

        public final FileUploader getFileUploader() {
            return this.fileUploader;
        }

        public final void setFileUploader(FileUploader fileUploader2) {
            this.fileUploader = fileUploader2;
        }

        public final Chat build() {
            Chat chatImpl = new ChatImpl(new ChatFontsImpl(this.style, this.context), new ChatStringsImpl(this.context), this.navigationHandler, this.urlSigner, this.markdown, this.apiKey, this.context, this.offlineEnabled, this.notificationHandler, this.chatLogLevel, this.chatLoggerHandler, this.fileUploader);
            Companion.instance = chatImpl;
            return chatImpl;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0003\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"Lcom/getstream/sdk/chat/Chat$Companion;", "", "()V", "instance", "Lcom/getstream/sdk/chat/Chat;", "getInstance", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: Chat.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        /* access modifiers changed from: private */
        public static Chat instance;

        private Companion() {
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.ERROR, message = "Use Chat.instance() instead", replaceWith = @ReplaceWith(expression = "Chat.instance()", imports = {}))
        public final Chat getInstance() {
            Chat chat = instance;
            if (chat != null) {
                return chat;
            }
            throw new IllegalStateException("Chat.Builder::build() must be called before obtaining Chat instance");
        }

        @JvmStatic
        public final Chat instance() {
            Chat chat = instance;
            if (chat != null) {
                return chat;
            }
            throw new IllegalStateException("Chat.Builder::build() must be called before obtaining Chat instance");
        }
    }
}
