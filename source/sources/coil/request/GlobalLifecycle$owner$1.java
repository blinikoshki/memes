package coil.request;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Landroidx/lifecycle/Lifecycle;", "getLifecycle"}, mo26108k = 3, mo26109mv = {1, 4, 1})
/* compiled from: GlobalLifecycle.kt */
final class GlobalLifecycle$owner$1 implements LifecycleOwner {
    public static final GlobalLifecycle$owner$1 INSTANCE = new GlobalLifecycle$owner$1();

    GlobalLifecycle$owner$1() {
    }

    public final Lifecycle getLifecycle() {
        return GlobalLifecycle.INSTANCE;
    }
}
