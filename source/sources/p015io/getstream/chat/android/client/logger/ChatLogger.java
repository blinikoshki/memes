package p015io.getstream.chat.android.client.logger;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u0000 \u00112\u00020\u0001:\u0003\u0010\u0011\u0012J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u0013"}, mo26107d2 = {"Lio/getstream/chat/android/client/logger/ChatLogger;", "", "getLevel", "Lio/getstream/chat/android/client/logger/ChatLogLevel;", "logD", "", "tag", "message", "", "logE", "chatError", "Lio/getstream/chat/android/client/errors/ChatError;", "throwable", "", "logI", "logW", "Builder", "Companion", "Config", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.logger.ChatLogger */
/* compiled from: ChatLogger.kt */
public interface ChatLogger {
    public static final Companion Companion = Companion.$$INSTANCE;

    ChatLogLevel getLevel();

    void logD(Object obj, String str);

    void logE(Object obj, ChatError chatError);

    void logE(Object obj, String str);

    void logE(Object obj, String str, ChatError chatError);

    void logE(Object obj, String str, Throwable th);

    void logE(Object obj, Throwable th);

    void logI(Object obj, String str);

    void logW(Object obj, String str);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/logger/ChatLogger$Config;", "", "level", "Lio/getstream/chat/android/client/logger/ChatLogLevel;", "handler", "Lio/getstream/chat/android/client/logger/ChatLoggerHandler;", "(Lio/getstream/chat/android/client/logger/ChatLogLevel;Lio/getstream/chat/android/client/logger/ChatLoggerHandler;)V", "getHandler", "()Lio/getstream/chat/android/client/logger/ChatLoggerHandler;", "getLevel", "()Lio/getstream/chat/android/client/logger/ChatLogLevel;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.logger.ChatLogger$Config */
    /* compiled from: ChatLogger.kt */
    public static final class Config {
        private final ChatLoggerHandler handler;
        private final ChatLogLevel level;

        public static /* synthetic */ Config copy$default(Config config, ChatLogLevel chatLogLevel, ChatLoggerHandler chatLoggerHandler, int i, Object obj) {
            if ((i & 1) != 0) {
                chatLogLevel = config.level;
            }
            if ((i & 2) != 0) {
                chatLoggerHandler = config.handler;
            }
            return config.copy(chatLogLevel, chatLoggerHandler);
        }

        public final ChatLogLevel component1() {
            return this.level;
        }

        public final ChatLoggerHandler component2() {
            return this.handler;
        }

        public final Config copy(ChatLogLevel chatLogLevel, ChatLoggerHandler chatLoggerHandler) {
            Intrinsics.checkNotNullParameter(chatLogLevel, FirebaseAnalytics.Param.LEVEL);
            return new Config(chatLogLevel, chatLoggerHandler);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual((Object) this.level, (Object) config.level) && Intrinsics.areEqual((Object) this.handler, (Object) config.handler);
        }

        public int hashCode() {
            ChatLogLevel chatLogLevel = this.level;
            int i = 0;
            int hashCode = (chatLogLevel != null ? chatLogLevel.hashCode() : 0) * 31;
            ChatLoggerHandler chatLoggerHandler = this.handler;
            if (chatLoggerHandler != null) {
                i = chatLoggerHandler.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Config(level=" + this.level + ", handler=" + this.handler + ")";
        }

        public Config(ChatLogLevel chatLogLevel, ChatLoggerHandler chatLoggerHandler) {
            Intrinsics.checkNotNullParameter(chatLogLevel, FirebaseAnalytics.Param.LEVEL);
            this.level = chatLogLevel;
            this.handler = chatLoggerHandler;
        }

        public final ChatLoggerHandler getHandler() {
            return this.handler;
        }

        public final ChatLogLevel getLevel() {
            return this.level;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/client/logger/ChatLogger$Builder;", "", "config", "Lio/getstream/chat/android/client/logger/ChatLogger$Config;", "(Lio/getstream/chat/android/client/logger/ChatLogger$Config;)V", "handler", "Lio/getstream/chat/android/client/logger/ChatLoggerHandler;", "level", "Lio/getstream/chat/android/client/logger/ChatLogLevel;", "build", "Lio/getstream/chat/android/client/logger/ChatLogger;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.logger.ChatLogger$Builder */
    /* compiled from: ChatLogger.kt */
    public static final class Builder {
        private ChatLoggerHandler handler;
        private ChatLogLevel level;

        public Builder(Config config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.level = config.getLevel();
            this.handler = config.getHandler();
        }

        public final Builder level(ChatLogLevel chatLogLevel) {
            Intrinsics.checkNotNullParameter(chatLogLevel, FirebaseAnalytics.Param.LEVEL);
            this.level = chatLogLevel;
            return this;
        }

        public final Builder handler(ChatLoggerHandler chatLoggerHandler) {
            Intrinsics.checkNotNullParameter(chatLoggerHandler, "handler");
            this.handler = chatLoggerHandler;
            return this;
        }

        public final ChatLogger build() {
            ChatLogger chatLoggerImpl = new ChatLoggerImpl(this.level, this.handler);
            ChatLogger.Companion.setInstance(chatLoggerImpl);
            return chatLoggerImpl;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, mo26107d2 = {"Lio/getstream/chat/android/client/logger/ChatLogger$Companion;", "", "()V", "instance", "Lio/getstream/chat/android/client/logger/ChatLogger;", "getInstance", "()Lio/getstream/chat/android/client/logger/ChatLogger;", "setInstance", "(Lio/getstream/chat/android/client/logger/ChatLogger;)V", "get", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "tag", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.logger.ChatLogger$Companion */
    /* compiled from: ChatLogger.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static ChatLogger instance = new ChatSilentLogger();

        private Companion() {
        }

        public final ChatLogger getInstance() {
            return instance;
        }

        public final void setInstance(ChatLogger chatLogger) {
            Intrinsics.checkNotNullParameter(chatLogger, "<set-?>");
            instance = chatLogger;
        }

        public final TaggedLogger get(Object obj) {
            Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
            return new TaggedLoggerImpl(obj, instance);
        }
    }
}
