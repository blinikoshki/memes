package p015io.getstream.chat.android.client.logger;

import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\tH\u0016J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/client/logger/ChatLoggerImpl;", "Lio/getstream/chat/android/client/logger/ChatLogger;", "level", "Lio/getstream/chat/android/client/logger/ChatLogLevel;", "handler", "Lio/getstream/chat/android/client/logger/ChatLoggerHandler;", "(Lio/getstream/chat/android/client/logger/ChatLogLevel;Lio/getstream/chat/android/client/logger/ChatLoggerHandler;)V", "getLevel", "getStackString", "", "t", "", "getTag", "tag", "", "logD", "", "message", "logE", "chatError", "Lio/getstream/chat/android/client/errors/ChatError;", "throwable", "logI", "logW", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.logger.ChatLoggerImpl */
/* compiled from: ChatLoggerImpl.kt */
public final class ChatLoggerImpl implements ChatLogger {
    private final ChatLoggerHandler handler;
    private final ChatLogLevel level;

    public ChatLoggerImpl() {
        this((ChatLogLevel) null, (ChatLoggerHandler) null, 3, (DefaultConstructorMarker) null);
    }

    public ChatLoggerImpl(ChatLogLevel chatLogLevel, ChatLoggerHandler chatLoggerHandler) {
        Intrinsics.checkNotNullParameter(chatLogLevel, FirebaseAnalytics.Param.LEVEL);
        this.level = chatLogLevel;
        this.handler = chatLoggerHandler;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatLoggerImpl(ChatLogLevel chatLogLevel, ChatLoggerHandler chatLoggerHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ChatLogLevel.NOTHING : chatLogLevel, (i & 2) != 0 ? null : chatLoggerHandler);
    }

    public void logE(Object obj, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(th, "throwable");
        if (this.level.isMoreOrEqualsThan$stream_chat_android_client_release(ChatLogLevel.ERROR)) {
            Log.e(getTag(obj), str);
            Log.e(getTag(obj), getStackString(th));
        }
        ChatLoggerHandler chatLoggerHandler = this.handler;
        if (chatLoggerHandler != null) {
            chatLoggerHandler.logE(obj, str, th);
        }
    }

    public void logE(Object obj, Throwable th) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(th, "throwable");
        if (this.level.isMoreOrEqualsThan$stream_chat_android_client_release(ChatLogLevel.ERROR)) {
            Log.e(getTag(obj), getStackString(th));
        }
        ChatLoggerHandler chatLoggerHandler = this.handler;
        if (chatLoggerHandler != null) {
            chatLoggerHandler.logT(getTag(obj), th);
        }
    }

    public void logE(Object obj, ChatError chatError) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(chatError, "chatError");
        Throwable cause = chatError.getCause();
        String message = chatError.getMessage();
        if (cause != null && message != null) {
            logE(obj, message, cause);
        } else if (cause != null) {
            logE(obj, cause);
        } else {
            if (message == null) {
                message = "";
            }
            logE(obj, message);
        }
    }

    public void logE(Object obj, String str, ChatError chatError) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(chatError, "chatError");
        Throwable cause = chatError.getCause();
        if (cause != null) {
            logE(obj, str, cause);
        } else {
            logE(obj, str);
        }
    }

    public void logI(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (this.level.isMoreOrEqualsThan$stream_chat_android_client_release(ChatLogLevel.ALL)) {
            Log.i(getTag(obj), str);
        }
        ChatLoggerHandler chatLoggerHandler = this.handler;
        if (chatLoggerHandler != null) {
            chatLoggerHandler.logI(getTag(obj), str);
        }
    }

    public void logD(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (this.level.isMoreOrEqualsThan$stream_chat_android_client_release(ChatLogLevel.DEBUG)) {
            Log.d(getTag(obj), str);
        }
        ChatLoggerHandler chatLoggerHandler = this.handler;
        if (chatLoggerHandler != null) {
            chatLoggerHandler.logD(getTag(obj), str);
        }
    }

    public void logW(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (this.level.isMoreOrEqualsThan$stream_chat_android_client_release(ChatLogLevel.WARN)) {
            Log.w(getTag(obj), str);
        }
        ChatLoggerHandler chatLoggerHandler = this.handler;
        if (chatLoggerHandler != null) {
            chatLoggerHandler.logW(getTag(obj), str);
        }
    }

    public void logE(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (this.level.isMoreOrEqualsThan$stream_chat_android_client_release(ChatLogLevel.ERROR)) {
            Log.e(getTag(obj), str);
        }
        ChatLoggerHandler chatLoggerHandler = this.handler;
        if (chatLoggerHandler != null) {
            chatLoggerHandler.logE(getTag(obj), str);
        }
    }

    public ChatLogLevel getLevel() {
        return this.level;
    }

    private final String getTag(Object obj) {
        String str;
        if (obj == null) {
            str = "null";
        } else if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(str, "tag.javaClass.simpleName");
        }
        return "Chat:" + str;
    }

    private final String getStackString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "errors.toString()");
        return stringWriter2;
    }
}
