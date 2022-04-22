package p015io.getstream.chat.android.client.api;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.RetrofitCallAdapterFactory$Companion$mainThreadExecutor$1$handler$2 */
/* compiled from: RetrofitCallAdapterFactory.kt */
final class C4946xa3e93387 extends Lambda implements Function0<Handler> {
    public static final C4946xa3e93387 INSTANCE = new C4946xa3e93387();

    C4946xa3e93387() {
        super(0);
    }

    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
