package p015io.getstream.chat.android.client.call;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "T", "", "run"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.RetrofitCall$enqueue$2$onFailure$1 */
/* compiled from: RetrofitCall.kt */
final class RetrofitCall$enqueue$2$onFailure$1 implements Runnable {

    /* renamed from: $t */
    final /* synthetic */ Throwable f1452$t;
    final /* synthetic */ RetrofitCall$enqueue$2 this$0;

    RetrofitCall$enqueue$2$onFailure$1(RetrofitCall$enqueue$2 retrofitCall$enqueue$2, Throwable th) {
        this.this$0 = retrofitCall$enqueue$2;
        this.f1452$t = th;
    }

    public final void run() {
        this.this$0.$callback.invoke(this.this$0.this$0.failedResult(this.f1452$t));
    }
}
