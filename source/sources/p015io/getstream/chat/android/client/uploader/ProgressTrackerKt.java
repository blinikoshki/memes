package p015io.getstream.chat.android.client.uploader;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.utils.ProgressCallback;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo26107d2 = {"toProgressCallback", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "Lio/getstream/chat/android/client/uploader/ProgressTracker;", "stream-chat-android-client_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.uploader.ProgressTrackerKt */
/* compiled from: ProgressTracker.kt */
public final class ProgressTrackerKt {
    public static final ProgressCallback toProgressCallback(ProgressTracker progressTracker) {
        Intrinsics.checkNotNullParameter(progressTracker, "$this$toProgressCallback");
        return new ProgressTrackerKt$toProgressCallback$1(progressTracker);
    }
}
