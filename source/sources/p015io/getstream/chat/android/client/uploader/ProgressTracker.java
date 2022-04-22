package p015io.getstream.chat.android.client.uploader;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, mo26107d2 = {"Lio/getstream/chat/android/client/uploader/ProgressTracker;", "", "()V", "currentProgress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isComplete", "", "maxValue", "", "getMaxValue", "()J", "setMaxValue", "(J)V", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/Flow;", "setComplete", "", "setProgress", "progress", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.uploader.ProgressTracker */
/* compiled from: ProgressTracker.kt */
public final class ProgressTracker {
    private final MutableStateFlow<Integer> currentProgress = StateFlowKt.MutableStateFlow(0);
    private final MutableStateFlow<Boolean> isComplete = StateFlowKt.MutableStateFlow(false);
    private long maxValue;

    public final long getMaxValue() {
        return this.maxValue;
    }

    public final void setMaxValue(long j) {
        this.maxValue = j;
    }

    public final void setProgress(int i) {
        this.currentProgress.setValue(Integer.valueOf(i));
    }

    public final StateFlow<Integer> currentProgress() {
        return this.currentProgress;
    }

    public final void setComplete(boolean z) {
        this.isComplete.setValue(Boolean.valueOf(z));
    }

    public final Flow<Boolean> isComplete() {
        return this.isComplete;
    }
}
