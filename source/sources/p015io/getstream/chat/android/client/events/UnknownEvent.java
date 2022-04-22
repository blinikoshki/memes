package p015io.getstream.chat.android.client.events;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/UnknownEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "type", "", "createdAt", "Ljava/util/Date;", "rawData", "", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Map;)V", "getCreatedAt", "()Ljava/util/Date;", "getRawData", "()Ljava/util/Map;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.UnknownEvent */
/* compiled from: ChatEvent.kt */
public final class UnknownEvent extends ChatEvent {
    @SerializedName("created_at")
    private final Date createdAt;
    private final Map<?, ?> rawData;
    private final String type;

    public static /* synthetic */ UnknownEvent copy$default(UnknownEvent unknownEvent, String str, Date date, Map<?, ?> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unknownEvent.getType();
        }
        if ((i & 2) != 0) {
            date = unknownEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            map = unknownEvent.rawData;
        }
        return unknownEvent.copy(str, date, map);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final Map<?, ?> component3() {
        return this.rawData;
    }

    public final UnknownEvent copy(String str, Date date, Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(map, Constants.MessagePayloadKeys.RAW_DATA);
        return new UnknownEvent(str, date, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnknownEvent)) {
            return false;
        }
        UnknownEvent unknownEvent = (UnknownEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) unknownEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) unknownEvent.getCreatedAt()) && Intrinsics.areEqual((Object) this.rawData, (Object) unknownEvent.rawData);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        Map<?, ?> map = this.rawData;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "UnknownEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", rawData=" + this.rawData + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public final Map<?, ?> getRawData() {
        return this.rawData;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnknownEvent(String str, Date date, Map<?, ?> map) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(map, Constants.MessagePayloadKeys.RAW_DATA);
        this.type = str;
        this.createdAt = date;
        this.rawData = map;
    }
}
