package p015io.getstream.chat.android.client.call;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "T", "", "result", "Lio/getstream/chat/android/client/utils/Result;", "onResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.CallKt$await$2$1 */
/* compiled from: Call.kt */
final class CallKt$await$2$1<T> implements Call.Callback<T> {
    final /* synthetic */ CancellableContinuation $continuation;

    CallKt$await$2$1(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public final void onResult(Result<T> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Result.Companion companion = kotlin.Result.Companion;
        this.$continuation.resumeWith(kotlin.Result.m1029constructorimpl(result));
    }
}
