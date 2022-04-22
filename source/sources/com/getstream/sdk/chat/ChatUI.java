package com.getstream.sdk.chat;

import android.content.Context;
import com.getstream.sdk.chat.UrlSigner;
import com.getstream.sdk.chat.navigation.ChatNavigationHandler;
import com.getstream.sdk.chat.navigation.ChatNavigator;
import com.getstream.sdk.chat.navigation.ChatNavigatorImpl;
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
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, mo26107d2 = {"Lcom/getstream/sdk/chat/ChatUI;", "", "fonts", "Lcom/getstream/sdk/chat/style/ChatFonts;", "strings", "Lcom/getstream/sdk/chat/utils/strings/ChatStrings;", "navigator", "Lcom/getstream/sdk/chat/navigation/ChatNavigator;", "markdown", "Lcom/getstream/sdk/chat/ChatMarkdown;", "urlSigner", "Lcom/getstream/sdk/chat/UrlSigner;", "(Lcom/getstream/sdk/chat/style/ChatFonts;Lcom/getstream/sdk/chat/utils/strings/ChatStrings;Lcom/getstream/sdk/chat/navigation/ChatNavigator;Lcom/getstream/sdk/chat/ChatMarkdown;Lcom/getstream/sdk/chat/UrlSigner;)V", "getFonts", "()Lcom/getstream/sdk/chat/style/ChatFonts;", "getMarkdown", "()Lcom/getstream/sdk/chat/ChatMarkdown;", "getNavigator", "()Lcom/getstream/sdk/chat/navigation/ChatNavigator;", "getStrings", "()Lcom/getstream/sdk/chat/utils/strings/ChatStrings;", "getUrlSigner", "()Lcom/getstream/sdk/chat/UrlSigner;", "version", "", "getVersion", "()Ljava/lang/String;", "Builder", "Companion", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatUI.kt */
public final class ChatUI {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static ChatUI instance;
    private final ChatFonts fonts;
    private final ChatMarkdown markdown;
    private final ChatNavigator navigator;
    private final ChatStrings strings;
    private final UrlSigner urlSigner;

    @JvmStatic
    public static final ChatUI instance() {
        return Companion.instance();
    }

    public final String getVersion() {
        return "release:4.6.0";
    }

    public ChatUI(ChatFonts chatFonts, ChatStrings chatStrings, ChatNavigator chatNavigator, ChatMarkdown chatMarkdown, UrlSigner urlSigner2) {
        Intrinsics.checkNotNullParameter(chatFonts, "fonts");
        Intrinsics.checkNotNullParameter(chatStrings, "strings");
        Intrinsics.checkNotNullParameter(chatNavigator, "navigator");
        Intrinsics.checkNotNullParameter(chatMarkdown, "markdown");
        Intrinsics.checkNotNullParameter(urlSigner2, "urlSigner");
        this.fonts = chatFonts;
        this.strings = chatStrings;
        this.navigator = chatNavigator;
        this.markdown = chatMarkdown;
        this.urlSigner = urlSigner2;
    }

    public final ChatFonts getFonts() {
        return this.fonts;
    }

    public final ChatStrings getStrings() {
        return this.strings;
    }

    public final ChatNavigator getNavigator() {
        return this.navigator;
    }

    public final ChatMarkdown getMarkdown() {
        return this.markdown;
    }

    public final UrlSigner getUrlSigner() {
        return this.urlSigner;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo26107d2 = {"Lcom/getstream/sdk/chat/ChatUI$Builder;", "", "client", "Lio/getstream/chat/android/client/ChatClient;", "chatDomain", "Lio/getstream/chat/android/livedata/ChatDomain;", "appContext", "Landroid/content/Context;", "(Lio/getstream/chat/android/client/ChatClient;Lio/getstream/chat/android/livedata/ChatDomain;Landroid/content/Context;)V", "(Landroid/content/Context;)V", "fonts", "Lcom/getstream/sdk/chat/style/ChatFonts;", "markdown", "Lcom/getstream/sdk/chat/ChatMarkdown;", "navigationHandler", "Lcom/getstream/sdk/chat/navigation/ChatNavigationHandler;", "strings", "Lcom/getstream/sdk/chat/utils/strings/ChatStrings;", "style", "Lcom/getstream/sdk/chat/style/ChatStyle;", "urlSigner", "Lcom/getstream/sdk/chat/UrlSigner;", "build", "Lcom/getstream/sdk/chat/ChatUI;", "withFonts", "withMarkdown", "withNavigationHandler", "handler", "withStrings", "withStyle", "withUrlSigner", "signer", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatUI.kt */
    public static final class Builder {
        private final Context appContext;
        private ChatFonts fonts;
        private ChatMarkdown markdown;
        private ChatNavigationHandler navigationHandler;
        private ChatStrings strings;
        private ChatStyle style;
        private UrlSigner urlSigner;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "appContext");
            this.appContext = context;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated constructor, `ChatClient` and `ChatDomain` is not needed anymore to build a `ChatUI` instance", replaceWith = @ReplaceWith(expression = "ChatUI.Builder(appContext)", imports = {}))
        public Builder(ChatClient chatClient, ChatDomain chatDomain, Context context) {
            this(context);
            Intrinsics.checkNotNullParameter(chatClient, "client");
            Intrinsics.checkNotNullParameter(chatDomain, "chatDomain");
            Intrinsics.checkNotNullParameter(context, "appContext");
        }

        public final Builder withStyle(ChatStyle chatStyle) {
            Intrinsics.checkNotNullParameter(chatStyle, "style");
            Builder builder = this;
            builder.style = chatStyle;
            return builder;
        }

        public final Builder withMarkdown(ChatMarkdown chatMarkdown) {
            Intrinsics.checkNotNullParameter(chatMarkdown, "markdown");
            Builder builder = this;
            builder.markdown = chatMarkdown;
            return builder;
        }

        public final Builder withUrlSigner(UrlSigner urlSigner2) {
            Intrinsics.checkNotNullParameter(urlSigner2, "signer");
            Builder builder = this;
            builder.urlSigner = urlSigner2;
            return builder;
        }

        public final Builder withNavigationHandler(ChatNavigationHandler chatNavigationHandler) {
            Intrinsics.checkNotNullParameter(chatNavigationHandler, "handler");
            Builder builder = this;
            builder.navigationHandler = chatNavigationHandler;
            return builder;
        }

        public final Builder withFonts(ChatFonts chatFonts) {
            Intrinsics.checkNotNullParameter(chatFonts, "fonts");
            Builder builder = this;
            builder.fonts = chatFonts;
            return builder;
        }

        public final Builder withStrings(ChatStrings chatStrings) {
            Intrinsics.checkNotNullParameter(chatStrings, "strings");
            Builder builder = this;
            builder.strings = chatStrings;
            return builder;
        }

        public final ChatUI build() {
            ChatStyle chatStyle = this.style;
            if (chatStyle == null) {
                chatStyle = new ChatStyle.Builder().build();
            }
            ChatFonts chatFonts = this.fonts;
            if (chatFonts == null) {
                chatFonts = new ChatFontsImpl(chatStyle, this.appContext);
            }
            ChatFonts chatFonts2 = chatFonts;
            ChatStrings chatStrings = this.strings;
            if (chatStrings == null) {
                chatStrings = new ChatStringsImpl(this.appContext);
            }
            ChatStrings chatStrings2 = chatStrings;
            ChatNavigationHandler chatNavigationHandler = this.navigationHandler;
            if (chatNavigationHandler == null) {
                chatNavigationHandler = ChatNavigatorImpl.EMPTY_HANDLER;
            }
            ChatNavigator chatNavigatorImpl = new ChatNavigatorImpl(chatNavigationHandler);
            ChatMarkdown chatMarkdown = this.markdown;
            if (chatMarkdown == null) {
                chatMarkdown = new ChatMarkdownImpl(this.appContext);
            }
            ChatMarkdown chatMarkdown2 = chatMarkdown;
            UrlSigner urlSigner2 = this.urlSigner;
            if (urlSigner2 == null) {
                urlSigner2 = new UrlSigner.DefaultUrlSigner();
            }
            ChatUI.instance = new ChatUI(chatFonts2, chatStrings2, chatNavigatorImpl, chatMarkdown2, urlSigner2);
            return ChatUI.Companion.instance();
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/getstream/sdk/chat/ChatUI$Companion;", "", "()V", "instance", "Lcom/getstream/sdk/chat/ChatUI;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChatUI.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ChatUI instance() {
            ChatUI access$getInstance$cp = ChatUI.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            throw new IllegalStateException("Be sure to call ChatUI.Builder().build() before using ChatUI.instance()".toString());
        }
    }
}
