package p015io.getstream.chat.android.client.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Device;", "", "id", "", "pushProvider", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getPushProvider", "setPushProvider", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Device */
/* compiled from: Device.kt */
public final class Device {
    @SerializedName("id")

    /* renamed from: id */
    private final String f1458id;
    @SerializedName("push_provider")
    private String pushProvider;

    public static /* synthetic */ Device copy$default(Device device, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = device.f1458id;
        }
        if ((i & 2) != 0) {
            str2 = device.pushProvider;
        }
        return device.copy(str, str2);
    }

    public final String component1() {
        return this.f1458id;
    }

    public final String component2() {
        return this.pushProvider;
    }

    public final Device copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "pushProvider");
        return new Device(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return Intrinsics.areEqual((Object) this.f1458id, (Object) device.f1458id) && Intrinsics.areEqual((Object) this.pushProvider, (Object) device.pushProvider);
    }

    public int hashCode() {
        String str = this.f1458id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pushProvider;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Device(id=" + this.f1458id + ", pushProvider=" + this.pushProvider + ")";
    }

    public Device(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "pushProvider");
        this.f1458id = str;
        this.pushProvider = str2;
    }

    public final String getId() {
        return this.f1458id;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Device(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2);
    }

    public final String getPushProvider() {
        return this.pushProvider;
    }

    public final void setPushProvider(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pushProvider = str;
    }
}
