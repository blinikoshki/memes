package p015io.getstream.chat.android.client.notifications;

import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/FirebaseMessageParser;", "", "isValidRemoteMessage", "", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "parse", "Lio/getstream/chat/android/client/notifications/FirebaseMessageParser$Data;", "Data", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.notifications.FirebaseMessageParser */
/* compiled from: FirebaseMessageParser.kt */
public interface FirebaseMessageParser {
    boolean isValidRemoteMessage(RemoteMessage remoteMessage);

    Data parse(RemoteMessage remoteMessage);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo26107d2 = {"Lio/getstream/chat/android/client/notifications/FirebaseMessageParser$Data;", "", "messageId", "", "channelType", "channelId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "getMessageId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.notifications.FirebaseMessageParser$Data */
    /* compiled from: FirebaseMessageParser.kt */
    public static final class Data {
        private final String channelId;
        private final String channelType;
        private final String messageId;

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.messageId;
            }
            if ((i & 2) != 0) {
                str2 = data.channelType;
            }
            if ((i & 4) != 0) {
                str3 = data.channelId;
            }
            return data.copy(str, str2, str3);
        }

        public final String component1() {
            return this.messageId;
        }

        public final String component2() {
            return this.channelType;
        }

        public final String component3() {
            return this.channelId;
        }

        public final Data copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
            Intrinsics.checkNotNullParameter(str2, "channelType");
            Intrinsics.checkNotNullParameter(str3, "channelId");
            return new Data(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.messageId, (Object) data.messageId) && Intrinsics.areEqual((Object) this.channelType, (Object) data.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) data.channelId);
        }

        public int hashCode() {
            String str = this.messageId;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.channelType;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.channelId;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Data(messageId=" + this.messageId + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ")";
        }

        public Data(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
            Intrinsics.checkNotNullParameter(str2, "channelType");
            Intrinsics.checkNotNullParameter(str3, "channelId");
            this.messageId = str;
            this.channelType = str2;
            this.channelId = str3;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getChannelType() {
            return this.channelType;
        }

        public final String getMessageId() {
            return this.messageId;
        }
    }
}
