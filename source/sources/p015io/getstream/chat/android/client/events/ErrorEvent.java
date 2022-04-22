package p015io.getstream.chat.android.client.events;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo26107d2 = {"Lio/getstream/chat/android/client/events/ErrorEvent;", "Lio/getstream/chat/android/client/events/ChatEvent;", "type", "", "createdAt", "Ljava/util/Date;", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "(Ljava/lang/String;Ljava/util/Date;Lio/getstream/chat/android/client/errors/ChatError;)V", "getCreatedAt", "()Ljava/util/Date;", "getError", "()Lio/getstream/chat/android/client/errors/ChatError;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.events.ErrorEvent */
/* compiled from: ChatEvent.kt */
public final class ErrorEvent extends ChatEvent {
    private final Date createdAt;
    private final ChatError error;
    private final String type;

    public static /* synthetic */ ErrorEvent copy$default(ErrorEvent errorEvent, String str, Date date, ChatError chatError, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorEvent.getType();
        }
        if ((i & 2) != 0) {
            date = errorEvent.getCreatedAt();
        }
        if ((i & 4) != 0) {
            chatError = errorEvent.error;
        }
        return errorEvent.copy(str, date, chatError);
    }

    public final String component1() {
        return getType();
    }

    public final Date component2() {
        return getCreatedAt();
    }

    public final ChatError component3() {
        return this.error;
    }

    public final ErrorEvent copy(String str, Date date, ChatError chatError) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(chatError, "error");
        return new ErrorEvent(str, date, chatError);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorEvent)) {
            return false;
        }
        ErrorEvent errorEvent = (ErrorEvent) obj;
        return Intrinsics.areEqual((Object) getType(), (Object) errorEvent.getType()) && Intrinsics.areEqual((Object) getCreatedAt(), (Object) errorEvent.getCreatedAt()) && Intrinsics.areEqual((Object) this.error, (Object) errorEvent.error);
    }

    public int hashCode() {
        String type2 = getType();
        int i = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
        Date createdAt2 = getCreatedAt();
        int hashCode2 = (hashCode + (createdAt2 != null ? createdAt2.hashCode() : 0)) * 31;
        ChatError chatError = this.error;
        if (chatError != null) {
            i = chatError.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ErrorEvent(type=" + getType() + ", createdAt=" + getCreatedAt() + ", error=" + this.error + ")";
    }

    public String getType() {
        return this.type;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public final ChatError getError() {
        return this.error;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorEvent(String str, Date date, ChatError chatError) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(date, "createdAt");
        Intrinsics.checkNotNullParameter(chatError, "error");
        this.type = str;
        this.createdAt = date;
        this.error = chatError;
    }
}
