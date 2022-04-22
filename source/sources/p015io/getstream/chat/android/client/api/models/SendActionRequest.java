package p015io.getstream.chat.android.client.api.models;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J=\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/SendActionRequest;", "", "channelId", "", "messageId", "type", "formData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getChannelId", "()Ljava/lang/String;", "getFormData", "()Ljava/util/Map;", "getMessageId", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.SendActionRequest */
/* compiled from: SendActionRequest.kt */
public final class SendActionRequest {
    @SerializedName("channel_id")
    private final String channelId;
    @SerializedName("form_data")
    private final Map<Object, Object> formData;
    @SerializedName("message_id")
    private final String messageId;
    private final String type;

    public static /* synthetic */ SendActionRequest copy$default(SendActionRequest sendActionRequest, String str, String str2, String str3, Map<Object, Object> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sendActionRequest.channelId;
        }
        if ((i & 2) != 0) {
            str2 = sendActionRequest.messageId;
        }
        if ((i & 4) != 0) {
            str3 = sendActionRequest.type;
        }
        if ((i & 8) != 0) {
            map = sendActionRequest.formData;
        }
        return sendActionRequest.copy(str, str2, str3, map);
    }

    public final String component1() {
        return this.channelId;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.type;
    }

    public final Map<Object, Object> component4() {
        return this.formData;
    }

    public final SendActionRequest copy(String str, String str2, String str3, Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(map, "formData");
        return new SendActionRequest(str, str2, str3, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendActionRequest)) {
            return false;
        }
        SendActionRequest sendActionRequest = (SendActionRequest) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) sendActionRequest.channelId) && Intrinsics.areEqual((Object) this.messageId, (Object) sendActionRequest.messageId) && Intrinsics.areEqual((Object) this.type, (Object) sendActionRequest.type) && Intrinsics.areEqual((Object) this.formData, (Object) sendActionRequest.formData);
    }

    public int hashCode() {
        String str = this.channelId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.messageId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Map<Object, Object> map = this.formData;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "SendActionRequest(channelId=" + this.channelId + ", messageId=" + this.messageId + ", type=" + this.type + ", formData=" + this.formData + ")";
    }

    public SendActionRequest(String str, String str2, String str3, Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        Intrinsics.checkNotNullParameter(str3, "type");
        Intrinsics.checkNotNullParameter(map, "formData");
        this.channelId = str;
        this.messageId = str2;
        this.type = str3;
        this.formData = map;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getType() {
        return this.type;
    }

    public final Map<Object, Object> getFormData() {
        return this.formData;
    }
}
