package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001f\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003JN\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/BanUserRequest;", "", "targetUserId", "", "timeout", "", "reason", "channelType", "channelId", "shadow", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "getChannelType", "setChannelType", "getReason", "setReason", "getShadow", "()Z", "getTargetUserId", "setTargetUserId", "getTimeout", "()Ljava/lang/Integer;", "setTimeout", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/getstream/chat/android/client/api/models/BanUserRequest;", "equals", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.BanUserRequest */
/* compiled from: BanUserRequest.kt */
public final class BanUserRequest {
    @SerializedName("id")
    private String channelId;
    @SerializedName("type")
    private String channelType;
    private String reason;
    private final boolean shadow;
    @SerializedName("target_user_id")
    private String targetUserId;
    private Integer timeout;

    public static /* synthetic */ BanUserRequest copy$default(BanUserRequest banUserRequest, String str, Integer num, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = banUserRequest.targetUserId;
        }
        if ((i & 2) != 0) {
            num = banUserRequest.timeout;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            str2 = banUserRequest.reason;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = banUserRequest.channelType;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = banUserRequest.channelId;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            z = banUserRequest.shadow;
        }
        return banUserRequest.copy(str, num2, str5, str6, str7, z);
    }

    public final String component1() {
        return this.targetUserId;
    }

    public final Integer component2() {
        return this.timeout;
    }

    public final String component3() {
        return this.reason;
    }

    public final String component4() {
        return this.channelType;
    }

    public final String component5() {
        return this.channelId;
    }

    public final boolean component6() {
        return this.shadow;
    }

    public final BanUserRequest copy(String str, Integer num, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetUserId");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        return new BanUserRequest(str, num, str2, str3, str4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BanUserRequest)) {
            return false;
        }
        BanUserRequest banUserRequest = (BanUserRequest) obj;
        return Intrinsics.areEqual((Object) this.targetUserId, (Object) banUserRequest.targetUserId) && Intrinsics.areEqual((Object) this.timeout, (Object) banUserRequest.timeout) && Intrinsics.areEqual((Object) this.reason, (Object) banUserRequest.reason) && Intrinsics.areEqual((Object) this.channelType, (Object) banUserRequest.channelType) && Intrinsics.areEqual((Object) this.channelId, (Object) banUserRequest.channelId) && this.shadow == banUserRequest.shadow;
    }

    public int hashCode() {
        String str = this.targetUserId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.timeout;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.reason;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channelType;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.channelId;
        if (str4 != null) {
            i = str4.hashCode();
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z = this.shadow;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "BanUserRequest(targetUserId=" + this.targetUserId + ", timeout=" + this.timeout + ", reason=" + this.reason + ", channelType=" + this.channelType + ", channelId=" + this.channelId + ", shadow=" + this.shadow + ")";
    }

    public BanUserRequest(String str, Integer num, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "targetUserId");
        Intrinsics.checkNotNullParameter(str3, "channelType");
        Intrinsics.checkNotNullParameter(str4, "channelId");
        this.targetUserId = str;
        this.timeout = num;
        this.reason = str2;
        this.channelType = str3;
        this.channelId = str4;
        this.shadow = z;
    }

    public final String getTargetUserId() {
        return this.targetUserId;
    }

    public final void setTargetUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetUserId = str;
    }

    public final Integer getTimeout() {
        return this.timeout;
    }

    public final void setTimeout(Integer num) {
        this.timeout = num;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(String str) {
        this.reason = str;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final void setChannelType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelType = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final boolean getShadow() {
        return this.shadow;
    }
}
