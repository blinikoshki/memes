package p015io.getstream.chat.android.client.uploader;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.errors.ChatError;
import p015io.getstream.chat.android.client.utils.ProgressCallback;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo26107d2 = {"io/getstream/chat/android/client/uploader/ProgressTrackerKt$toProgressCallback$1", "Lio/getstream/chat/android/client/utils/ProgressCallback;", "onError", "", "error", "Lio/getstream/chat/android/client/errors/ChatError;", "onProgress", "progress", "", "onSuccess", "file", "", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.uploader.ProgressTrackerKt$toProgressCallback$1 */
/* compiled from: ProgressTracker.kt */
public final class ProgressTrackerKt$toProgressCallback$1 implements ProgressCallback {
    final /* synthetic */ ProgressTracker $this_toProgressCallback;

    public void onError(ChatError chatError) {
        Intrinsics.checkNotNullParameter(chatError, "error");
    }

    ProgressTrackerKt$toProgressCallback$1(ProgressTracker progressTracker) {
        this.$this_toProgressCallback = progressTracker;
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "file");
        this.$this_toProgressCallback.setComplete(true);
    }

    public void onProgress(long j) {
        this.$this_toProgressCallback.setProgress((int) j);
    }
}
