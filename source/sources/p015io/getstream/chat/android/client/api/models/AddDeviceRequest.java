package p015io.getstream.chat.android.client.api.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0011"}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/AddDeviceRequest;", "", "firebaseToken", "", "(Ljava/lang/String;)V", "getFirebaseToken", "()Ljava/lang/String;", "push_provider", "getPush_provider", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.AddDeviceRequest */
/* compiled from: AddDeviceRequest.kt */
public final class AddDeviceRequest {
    @SerializedName("id")
    private final String firebaseToken;
    private final String push_provider = "firebase";

    public static /* synthetic */ AddDeviceRequest copy$default(AddDeviceRequest addDeviceRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addDeviceRequest.firebaseToken;
        }
        return addDeviceRequest.copy(str);
    }

    public final String component1() {
        return this.firebaseToken;
    }

    public final AddDeviceRequest copy(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseToken");
        return new AddDeviceRequest(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AddDeviceRequest) && Intrinsics.areEqual((Object) this.firebaseToken, (Object) ((AddDeviceRequest) obj).firebaseToken);
        }
        return true;
    }

    public int hashCode() {
        String str = this.firebaseToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AddDeviceRequest(firebaseToken=" + this.firebaseToken + ")";
    }

    public AddDeviceRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseToken");
        this.firebaseToken = str;
    }

    public final String getFirebaseToken() {
        return this.firebaseToken;
    }

    public final String getPush_provider() {
        return this.push_provider;
    }
}
