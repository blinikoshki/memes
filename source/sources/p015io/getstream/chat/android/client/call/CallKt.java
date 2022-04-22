package p015io.getstream.chat.android.client.call;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.utils.Result;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a@\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0007*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\tH\u0007\u001aF\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u000b0\u0004\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0007*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo26107d2 = {"await", "Lio/getstream/chat/android/client/utils/Result;", "T", "", "Lio/getstream/chat/android/client/call/Call;", "(Lio/getstream/chat/android/client/call/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "map", "K", "mapper", "Lkotlin/Function1;", "zipWith", "Lkotlin/Pair;", "call", "stream-chat-android-core"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.CallKt */
/* compiled from: Call.kt */
public final class CallKt {
    public static final <T> Object await(Call<T> call, Continuation<? super Result<T>> continuation) {
        if (call instanceof CoroutineCall) {
            return ((CoroutineCall) call).getSuspendingTask().invoke(continuation);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        call.enqueue((Call.Callback<T>) new CallKt$await$2$1(cancellableContinuation));
        cancellableContinuation.invokeOnCancellation(new CallKt$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @InternalStreamChatApi
    public static final <T, K> Call<K> map(Call<T> call, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(call, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        return new MapCall<>(call, function1);
    }

    @InternalStreamChatApi
    public static final <T, K> Call<Pair<T, K>> zipWith(Call<T> call, Call<K> call2) {
        Intrinsics.checkNotNullParameter(call, "$this$zipWith");
        Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
        return new ZipCall<>(call, call2);
    }
}
