package p015io.getstream.chat.android.client.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.logger.ChatLogger;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0017¨\u0006("}, mo26107d2 = {"Lio/getstream/chat/android/client/api/ChatClientConfig;", "", "apiKey", "", "httpUrl", "cdnHttpUrl", "wssUrl", "baseTimeout", "", "cdnTimeout", "warmUp", "", "loggerConfig", "Lio/getstream/chat/android/client/logger/ChatLogger$Config;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZLio/getstream/chat/android/client/logger/ChatLogger$Config;)V", "getApiKey", "()Ljava/lang/String;", "getBaseTimeout", "()J", "setBaseTimeout", "(J)V", "getCdnHttpUrl", "setCdnHttpUrl", "(Ljava/lang/String;)V", "getCdnTimeout", "setCdnTimeout", "enableMoshi", "getEnableMoshi$stream_chat_android_client_release", "()Z", "setEnableMoshi$stream_chat_android_client_release", "(Z)V", "getHttpUrl", "setHttpUrl", "isAnonymous", "setAnonymous", "getLoggerConfig", "()Lio/getstream/chat/android/client/logger/ChatLogger$Config;", "getWarmUp", "getWssUrl", "setWssUrl", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.ChatClientConfig */
/* compiled from: ChatClientConfig.kt */
public final class ChatClientConfig {
    private final String apiKey;
    private long baseTimeout;
    private String cdnHttpUrl;
    private long cdnTimeout;
    private boolean enableMoshi;
    private String httpUrl;
    private boolean isAnonymous;
    private final ChatLogger.Config loggerConfig;
    private final boolean warmUp;
    private String wssUrl;

    public ChatClientConfig(String str, String str2, String str3, String str4, long j, long j2, boolean z, ChatLogger.Config config) {
        Intrinsics.checkNotNullParameter(str, "apiKey");
        Intrinsics.checkNotNullParameter(str2, "httpUrl");
        Intrinsics.checkNotNullParameter(str3, "cdnHttpUrl");
        Intrinsics.checkNotNullParameter(str4, "wssUrl");
        Intrinsics.checkNotNullParameter(config, "loggerConfig");
        this.apiKey = str;
        this.httpUrl = str2;
        this.cdnHttpUrl = str3;
        this.wssUrl = str4;
        this.baseTimeout = j;
        this.cdnTimeout = j2;
        this.warmUp = z;
        this.loggerConfig = config;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getHttpUrl() {
        return this.httpUrl;
    }

    public final void setHttpUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.httpUrl = str;
    }

    public final String getCdnHttpUrl() {
        return this.cdnHttpUrl;
    }

    public final void setCdnHttpUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cdnHttpUrl = str;
    }

    public final String getWssUrl() {
        return this.wssUrl;
    }

    public final void setWssUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wssUrl = str;
    }

    public final long getBaseTimeout() {
        return this.baseTimeout;
    }

    public final void setBaseTimeout(long j) {
        this.baseTimeout = j;
    }

    public final long getCdnTimeout() {
        return this.cdnTimeout;
    }

    public final void setCdnTimeout(long j) {
        this.cdnTimeout = j;
    }

    public final boolean getWarmUp() {
        return this.warmUp;
    }

    public final ChatLogger.Config getLoggerConfig() {
        return this.loggerConfig;
    }

    public final boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final void setAnonymous(boolean z) {
        this.isAnonymous = z;
    }

    public final boolean getEnableMoshi$stream_chat_android_client_release() {
        return this.enableMoshi;
    }

    public final void setEnableMoshi$stream_chat_android_client_release(boolean z) {
        this.enableMoshi = z;
    }
}
