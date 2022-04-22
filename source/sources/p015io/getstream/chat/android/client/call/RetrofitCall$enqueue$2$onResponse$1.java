package p015io.getstream.chat.android.client.call;

import kotlin.Metadata;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "T", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.RetrofitCall$enqueue$2$onResponse$1 */
/* compiled from: RetrofitCall.kt */
final class RetrofitCall$enqueue$2$onResponse$1 implements Runnable {
    final /* synthetic */ Response $response;
    final /* synthetic */ RetrofitCall$enqueue$2 this$0;

    RetrofitCall$enqueue$2$onResponse$1(RetrofitCall$enqueue$2 retrofitCall$enqueue$2, Response response) {
        this.this$0 = retrofitCall$enqueue$2;
        this.$response = response;
    }

    public final void run() {
        this.this$0.$callback.invoke(this.this$0.this$0.getResult(this.$response));
    }
}
