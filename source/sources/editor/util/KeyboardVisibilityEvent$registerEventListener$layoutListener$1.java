package editor.util;

import android.app.Activity;
import android.view.ViewTreeObserver;
import editor.util.KeyboardVisibilityEvent;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo26107d2 = {"editor/util/KeyboardVisibilityEvent$registerEventListener$layoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "wasOpened", "", "onGlobalLayout", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: KeyboardVisibilityEvent.kt */
public final class KeyboardVisibilityEvent$registerEventListener$layoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KeyboardVisibilityEvent.KeyboardVisibilityEventListener $listener;
    private boolean wasOpened;

    KeyboardVisibilityEvent$registerEventListener$layoutListener$1(Activity activity, KeyboardVisibilityEvent.KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        this.$activity = activity;
        this.$listener = keyboardVisibilityEventListener;
    }

    public void onGlobalLayout() {
        boolean isKeyboardVisible = KeyboardVisibilityEvent.INSTANCE.isKeyboardVisible(this.$activity);
        if (isKeyboardVisible != this.wasOpened) {
            this.wasOpened = isKeyboardVisible;
            this.$listener.onVisibilityChanged(isKeyboardVisible);
        }
    }
}
