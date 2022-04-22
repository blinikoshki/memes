package p015io.getstream.chat.android.client.uploader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lio/getstream/chat/android/client/uploader/ProgressTrackerFactory;", "", "()V", "instanceMap", "", "", "Lio/getstream/chat/android/client/uploader/ProgressTracker;", "getOrCreate", "id", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.uploader.ProgressTrackerFactory */
/* compiled from: ProgressTrackerFactory.kt */
public final class ProgressTrackerFactory {
    public static final ProgressTrackerFactory INSTANCE = new ProgressTrackerFactory();
    private static final Map<String, ProgressTracker> instanceMap = new ConcurrentHashMap();

    private ProgressTrackerFactory() {
    }

    public final ProgressTracker getOrCreate(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Map<String, ProgressTracker> map = instanceMap;
        if (map.containsKey(str)) {
            ProgressTracker progressTracker = map.get(str);
            Intrinsics.checkNotNull(progressTracker);
            return progressTracker;
        }
        ProgressTracker progressTracker2 = new ProgressTracker();
        map.put(str, progressTracker2);
        return progressTracker2;
    }
}
