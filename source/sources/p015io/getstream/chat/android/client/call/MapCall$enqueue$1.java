package p015io.getstream.chat.android.client.call;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.utils.Result;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "T", "", "K", "it", "Lio/getstream/chat/android/client/utils/Result;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.MapCall$enqueue$1 */
/* compiled from: MapCall.kt */
final class MapCall$enqueue$1<T> implements Call.Callback<T> {
    final /* synthetic */ Call.Callback $callback;
    final /* synthetic */ MapCall this$0;

    MapCall$enqueue$1(MapCall mapCall, Call.Callback callback) {
        this.this$0 = mapCall;
        this.$callback = callback;
    }

    /* renamed from: invoke */
    public final void onResult(Result<T> result) {
        Intrinsics.checkNotNullParameter(result, "it");
        if (!this.this$0.getCanceled().get()) {
            if (result.isSuccess()) {
                this.$callback.onResult(new Result(this.this$0.mapper.invoke(result.data())));
                return;
            }
            this.$callback.onResult(new Result(result.error()));
        }
    }
}
