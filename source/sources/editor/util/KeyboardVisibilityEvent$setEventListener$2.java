package editor.util;

import android.app.Activity;
import editor.util.KeyboardVisibilityEvent;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, mo26107d2 = {"editor/util/KeyboardVisibilityEvent$setEventListener$2", "Leditor/util/KeyboardVisibilityEvent$AutoActivityLifecycleCallback;", "onTargetActivityDestroyed", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: KeyboardVisibilityEvent.kt */
public final class KeyboardVisibilityEvent$setEventListener$2 extends KeyboardVisibilityEvent.AutoActivityLifecycleCallback {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KeyboardVisibilityEvent.Unregistrar $unregistrar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeyboardVisibilityEvent$setEventListener$2(KeyboardVisibilityEvent.Unregistrar unregistrar, Activity activity, Activity activity2) {
        super(activity2);
        this.$unregistrar = unregistrar;
        this.$activity = activity;
    }

    /* access modifiers changed from: protected */
    public void onTargetActivityDestroyed() {
        this.$unregistrar.unregister();
    }
}
