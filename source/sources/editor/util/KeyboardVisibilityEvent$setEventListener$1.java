package editor.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import editor.util.KeyboardVisibilityEvent;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, mo26107d2 = {"editor/util/KeyboardVisibilityEvent$setEventListener$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: KeyboardVisibilityEvent.kt */
public final class KeyboardVisibilityEvent$setEventListener$1 implements LifecycleObserver {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ KeyboardVisibilityEvent.Unregistrar $unregistrar;

    KeyboardVisibilityEvent$setEventListener$1(LifecycleOwner lifecycleOwner, KeyboardVisibilityEvent.Unregistrar unregistrar) {
        this.$lifecycleOwner = lifecycleOwner;
        this.$unregistrar = unregistrar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.$lifecycleOwner.getLifecycle().removeObserver(this);
        this.$unregistrar.unregister();
    }
}
