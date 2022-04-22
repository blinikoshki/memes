package p015io.getstream.chat.android.client.call;

import androidx.core.app.NotificationCompat;
import com.appsflyer.internal.referrer.Payload;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, mo26107d2 = {"io/getstream/chat/android/client/call/RetrofitCall$enqueue$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.call.RetrofitCall$enqueue$2 */
/* compiled from: RetrofitCall.kt */
public final class RetrofitCall$enqueue$2 implements Callback<T> {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ RetrofitCall this$0;

    RetrofitCall$enqueue$2(RetrofitCall retrofitCall, Function1 function1) {
        this.this$0 = retrofitCall;
        this.$callback = function1;
    }

    public void onResponse(Call<T> call, Response<T> response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, Payload.RESPONSE);
        this.this$0.callbackExecutor.execute(new RetrofitCall$enqueue$2$onResponse$1(this, response));
    }

    public void onFailure(Call<T> call, Throwable th) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(th, "t");
        this.this$0.callbackExecutor.execute(new RetrofitCall$enqueue$2$onFailure$1(this, th));
    }
}
