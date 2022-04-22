package p015io.getstream.chat.android.client.utils;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/UuidGeneratorImpl;", "Lio/getstream/chat/android/client/utils/UuidGenerator;", "()V", "generate", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.UuidGeneratorImpl */
/* compiled from: UuidGeneratorImpl.kt */
public final class UuidGeneratorImpl implements UuidGenerator {
    public String generate() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        return uuid;
    }
}
