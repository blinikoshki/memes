package p015io.getstream.chat.android.client.logger;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/client/logger/TaggedLoggerImpl;", "Lio/getstream/chat/android/client/logger/TaggedLogger;", "tag", "", "logger", "Lio/getstream/chat/android/client/logger/ChatLogger;", "(Ljava/lang/Object;Lio/getstream/chat/android/client/logger/ChatLogger;)V", "getLevel", "Lio/getstream/chat/android/client/logger/ChatLogLevel;", "logD", "", "message", "", "logE", "chatError", "Lio/getstream/chat/android/client/errors/ChatError;", "throwable", "", "logI", "logW", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.logger.TaggedLoggerImpl */
/* compiled from: TaggedLoggerImpl.kt */
public final class TaggedLoggerImpl implements TaggedLogger {
    private final ChatLogger logger;
    private final Object tag;

    public TaggedLoggerImpl(Object obj, ChatLogger chatLogger) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(chatLogger, "logger");
        this.tag = obj;
        this.logger = chatLogger;
    }

    public void logI(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.logger.logI(this.tag, str);
    }

    public void logD(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.logger.logD(this.tag, str);
    }

    public void logW(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.logger.logW(this.tag, str);
    }

    public void logE(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.logger.logE(this.tag, str);
    }

    public void logE(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        this.logger.logE(this.tag, th);
    }

    public void logE(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        this.logger.logE(this.tag, str, th);
    }

    public ChatLogLevel getLevel() {
        return this.logger.getLevel();
    }

    public void logE(String str, ChatError chatError) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(chatError, "chatError");
        this.logger.logE(this.tag, str, chatError);
    }

    public void logE(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "chatError");
        this.logger.logE(this.tag, chatError);
    }
}
