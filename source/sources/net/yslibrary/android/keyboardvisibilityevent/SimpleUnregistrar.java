package net.yslibrary.android.keyboardvisibilityevent;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

public class SimpleUnregistrar implements Unregistrar {
    private WeakReference<Activity> mActivityWeakReference;
    private WeakReference<ViewTreeObserver.OnGlobalLayoutListener> mOnGlobalLayoutListenerWeakReference;

    SimpleUnregistrar(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.mOnGlobalLayoutListenerWeakReference = new WeakReference<>(onGlobalLayoutListener);
    }

    public void unregister() {
        Activity activity = (Activity) this.mActivityWeakReference.get();
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener) this.mOnGlobalLayoutListenerWeakReference.get();
        if (!(activity == null || onGlobalLayoutListener == null)) {
            View activityRoot = KeyboardVisibilityEvent.getActivityRoot(activity);
            if (Build.VERSION.SDK_INT >= 16) {
                activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            } else {
                activityRoot.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
        }
        this.mActivityWeakReference.clear();
        this.mOnGlobalLayoutListenerWeakReference.clear();
    }
}
