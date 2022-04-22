package p015io.getstream.chat.android.client.api;

import android.os.Handler;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001b\u0010\u0002\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, mo26107d2 = {"io/getstream/chat/android/client/api/RetrofitCallAdapterFactory$Companion$mainThreadExecutor$1", "Ljava/util/concurrent/Executor;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "execute", "", "command", "Ljava/lang/Runnable;", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.RetrofitCallAdapterFactory$Companion$mainThreadExecutor$1 */
/* compiled from: RetrofitCallAdapterFactory.kt */
public final class RetrofitCallAdapterFactory$Companion$mainThreadExecutor$1 implements Executor {
    private final Lazy handler$delegate = LazyKt.lazy(C4946xa3e93387.INSTANCE);

    public final Handler getHandler() {
        return (Handler) this.handler$delegate.getValue();
    }

    RetrofitCallAdapterFactory$Companion$mainThreadExecutor$1() {
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            getHandler().post(runnable);
        }
    }
}
