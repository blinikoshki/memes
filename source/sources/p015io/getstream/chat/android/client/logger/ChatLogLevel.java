package p015io.getstream.chat.android.client.logger;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, mo26107d2 = {"Lio/getstream/chat/android/client/logger/ChatLogLevel;", "", "severity", "", "(Ljava/lang/String;II)V", "isMoreOrEqualsThan", "", "level", "isMoreOrEqualsThan$stream_chat_android_client_release", "ALL", "DEBUG", "WARN", "ERROR", "NOTHING", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.logger.ChatLogLevel */
/* compiled from: ChatLogLevel.kt */
public enum ChatLogLevel {
    ALL(0),
    DEBUG(1),
    WARN(2),
    ERROR(3),
    NOTHING(4);
    
    private final int severity;

    private ChatLogLevel(int i) {
        this.severity = i;
    }

    public final boolean isMoreOrEqualsThan$stream_chat_android_client_release(ChatLogLevel chatLogLevel) {
        Intrinsics.checkNotNullParameter(chatLogLevel, FirebaseAnalytics.Param.LEVEL);
        return chatLogLevel.severity >= this.severity;
    }
}
