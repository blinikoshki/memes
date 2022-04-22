package net.yslibrary.android.keyboardvisibilityevent;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.Objects;

public class KeyboardVisibilityEvent {
    private static final double KEYBOARD_MIN_HEIGHT_RATIO = 0.15d;

    public static void setEventListener(Activity activity, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        final Unregistrar registerEventListener = registerEventListener(activity, keyboardVisibilityEventListener);
        activity.getApplication().registerActivityLifecycleCallbacks(new AutoActivityLifecycleCallback(activity) {
            /* access modifiers changed from: protected */
            public void onTargetActivityDestroyed() {
                registerEventListener.unregister();
            }
        });
    }

    public static Unregistrar registerEventListener(Activity activity, final KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        Objects.requireNonNull(activity, "Parameter:activity must not be null");
        if ((activity.getWindow().getAttributes().softInputMode & 240 & 48) != 48) {
            Objects.requireNonNull(keyboardVisibilityEventListener, "Parameter:listener must not be null");
            final View activityRoot = getActivityRoot(activity);
            C23762 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {

                /* renamed from: r */
                private final Rect f460r = new Rect();
                private boolean wasOpened = false;

                public void onGlobalLayout() {
                    activityRoot.getWindowVisibleDisplayFrame(this.f460r);
                    int height = activityRoot.getRootView().getHeight();
                    boolean z = ((double) (height - this.f460r.height())) > ((double) height) * KeyboardVisibilityEvent.KEYBOARD_MIN_HEIGHT_RATIO;
                    if (z != this.wasOpened) {
                        this.wasOpened = z;
                        keyboardVisibilityEventListener.onVisibilityChanged(z);
                    }
                }
            };
            activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(r1);
            return new SimpleUnregistrar(activity, r1);
        }
        throw new IllegalArgumentException("Parameter:activity window SoftInputMethod is SOFT_INPUT_ADJUST_NOTHING. In this case window will not be resized");
    }

    public static boolean isKeyboardVisible(Activity activity) {
        Rect rect = new Rect();
        View activityRoot = getActivityRoot(activity);
        activityRoot.getWindowVisibleDisplayFrame(rect);
        int height = activityRoot.getRootView().getHeight();
        return ((double) (height - rect.height())) > ((double) height) * KEYBOARD_MIN_HEIGHT_RATIO;
    }

    static View getActivityRoot(Activity activity) {
        return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
    }
}
