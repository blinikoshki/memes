package p015io.getstream.chat.android.livedata.extensions;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Message;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0016\u0010\t\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0016\u0010\n\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, mo26107d2 = {"NEVER", "Ljava/util/Date;", "getNEVER", "()Ljava/util/Date;", "wasCreatedAfter", "", "Lio/getstream/chat/android/client/models/Message;", "date", "wasCreatedAfterOrAt", "wasCreatedBefore", "wasCreatedBeforeOrAt", "stream-chat-android-offline_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.extensions.MessageExtensionsKt */
/* compiled from: MessageExtensions.kt */
public final class MessageExtensionsKt {
    private static final Date NEVER = new Date(0);

    public static final boolean wasCreatedAfterOrAt(Message message, Date date) {
        Intrinsics.checkNotNullParameter(message, "$this$wasCreatedAfterOrAt");
        Date createdAt = message.getCreatedAt();
        if (createdAt == null) {
            createdAt = message.getCreatedLocallyAt();
        }
        if (createdAt == null) {
            createdAt = NEVER;
        }
        return createdAt.compareTo(date) >= 0;
    }

    public static final boolean wasCreatedAfter(Message message, Date date) {
        Intrinsics.checkNotNullParameter(message, "$this$wasCreatedAfter");
        Date createdAt = message.getCreatedAt();
        if (createdAt == null) {
            createdAt = message.getCreatedLocallyAt();
        }
        if (createdAt == null) {
            createdAt = NEVER;
        }
        return createdAt.compareTo(date) > 0;
    }

    public static final boolean wasCreatedBefore(Message message, Date date) {
        Intrinsics.checkNotNullParameter(message, "$this$wasCreatedBefore");
        Date createdAt = message.getCreatedAt();
        if (createdAt == null) {
            createdAt = message.getCreatedLocallyAt();
        }
        if (createdAt == null) {
            createdAt = NEVER;
        }
        return createdAt.compareTo(date) < 0;
    }

    public static final boolean wasCreatedBeforeOrAt(Message message, Date date) {
        Intrinsics.checkNotNullParameter(message, "$this$wasCreatedBeforeOrAt");
        Date createdAt = message.getCreatedAt();
        if (createdAt == null) {
            createdAt = message.getCreatedLocallyAt();
        }
        if (createdAt == null) {
            createdAt = NEVER;
        }
        return createdAt.compareTo(date) <= 0;
    }

    public static final Date getNEVER() {
        return NEVER;
    }
}
