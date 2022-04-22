package editor.util;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0017"}, mo26107d2 = {"Leditor/util/KeyboardVisibilityEvent;", "", "()V", "getActivityRoot", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "getContentRoot", "Landroid/view/ViewGroup;", "isKeyboardVisible", "", "registerEventListener", "Leditor/util/KeyboardVisibilityEvent$Unregistrar;", "listener", "Leditor/util/KeyboardVisibilityEvent$KeyboardVisibilityEventListener;", "setEventListener", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "AutoActivityLifecycleCallback", "KeyboardVisibilityEventListener", "SimpleUnregistrar", "Unregistrar", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "unused, and there were talks of an official api being developed")
/* compiled from: KeyboardVisibilityEvent.kt */
public final class KeyboardVisibilityEvent {
    public static final KeyboardVisibilityEvent INSTANCE = new KeyboardVisibilityEvent();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo26107d2 = {"Leditor/util/KeyboardVisibilityEvent$KeyboardVisibilityEventListener;", "", "onVisibilityChanged", "", "isOpen", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: KeyboardVisibilityEvent.kt */
    public interface KeyboardVisibilityEventListener {
        void onVisibilityChanged(boolean z);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo26107d2 = {"Leditor/util/KeyboardVisibilityEvent$Unregistrar;", "", "unregister", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: KeyboardVisibilityEvent.kt */
    public interface Unregistrar {
        void unregister();
    }

    private KeyboardVisibilityEvent() {
    }

    @JvmStatic
    public static final void setEventListener(Activity activity, LifecycleOwner lifecycleOwner, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(keyboardVisibilityEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        lifecycleOwner.getLifecycle().addObserver(new KeyboardVisibilityEvent$setEventListener$1(lifecycleOwner, INSTANCE.registerEventListener(activity, keyboardVisibilityEventListener)));
    }

    @JvmStatic
    public static final void setEventListener(Activity activity, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(keyboardVisibilityEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        activity.getApplication().registerActivityLifecycleCallbacks(new KeyboardVisibilityEvent$setEventListener$2(INSTANCE.registerEventListener(activity, keyboardVisibilityEventListener), activity, activity));
    }

    public final Unregistrar registerEventListener(Activity activity, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        if (activity != null) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            if (!(((window.getAttributes().softInputMode & 240) & 48) != 48)) {
                throw new IllegalArgumentException("Parameter:activity window SoftInputMethod is SOFT_INPUT_ADJUST_NOTHING. In this case window will not be resized".toString());
            } else if (keyboardVisibilityEventListener != null) {
                View activityRoot = getActivityRoot(activity);
                ViewTreeObserver.OnGlobalLayoutListener keyboardVisibilityEvent$registerEventListener$layoutListener$1 = new KeyboardVisibilityEvent$registerEventListener$layoutListener$1(activity, keyboardVisibilityEventListener);
                activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(keyboardVisibilityEvent$registerEventListener$layoutListener$1);
                return new SimpleUnregistrar(activity, keyboardVisibilityEvent$registerEventListener$layoutListener$1);
            } else {
                throw new NullPointerException("Parameter:listener must not be null");
            }
        } else {
            throw new NullPointerException("Parameter:activity must not be null");
        }
    }

    public final boolean isKeyboardVisible(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        View activityRoot = getActivityRoot(activity);
        activityRoot.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        getContentRoot(activity).getLocationOnScreen(iArr);
        View rootView = activityRoot.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "activityRoot.rootView");
        int height = rootView.getHeight();
        return ((double) ((height - rect.height()) - iArr[1])) > ((double) height) * 0.15d;
    }

    /* access modifiers changed from: private */
    public final View getActivityRoot(Activity activity) {
        View childAt = getContentRoot(activity).getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "getContentRoot(activity).getChildAt(0)");
        return childAt;
    }

    private final ViewGroup getContentRoot(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(android.R.id.content)");
        return (ViewGroup) findViewById;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/util/KeyboardVisibilityEvent$SimpleUnregistrar;", "Leditor/util/KeyboardVisibilityEvent$Unregistrar;", "activity", "Landroid/app/Activity;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Landroid/app/Activity;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "onGlobalLayoutListenerWeakReference", "unregister", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: KeyboardVisibilityEvent.kt */
    public static final class SimpleUnregistrar implements Unregistrar {
        private final WeakReference<Activity> activityWeakReference;
        private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> onGlobalLayoutListenerWeakReference;

        public SimpleUnregistrar(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(onGlobalLayoutListener, "globalLayoutListener");
            this.activityWeakReference = new WeakReference<>(activity);
            this.onGlobalLayoutListenerWeakReference = new WeakReference<>(onGlobalLayoutListener);
        }

        public void unregister() {
            Activity activity = (Activity) this.activityWeakReference.get();
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener) this.onGlobalLayoutListenerWeakReference.get();
            if (!(activity == null || onGlobalLayoutListener == null)) {
                KeyboardVisibilityEvent.INSTANCE.getActivityRoot(activity).getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.activityWeakReference.clear();
            this.onGlobalLayoutListenerWeakReference.clear();
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0006H$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Leditor/util/KeyboardVisibilityEvent$AutoActivityLifecycleCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "targetActivity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "onActivityCreated", "", "activity", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "onTargetActivityDestroyed", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: KeyboardVisibilityEvent.kt */
    public static abstract class AutoActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        private final Activity targetActivity;

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
        }

        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        /* access modifiers changed from: protected */
        public abstract void onTargetActivityDestroyed();

        public AutoActivityLifecycleCallback(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "targetActivity");
            this.targetActivity = activity;
        }

        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Activity activity2 = this.targetActivity;
            if (activity == activity2) {
                activity2.getApplication().unregisterActivityLifecycleCallbacks(this);
                onTargetActivityDestroyed();
            }
        }
    }
}
