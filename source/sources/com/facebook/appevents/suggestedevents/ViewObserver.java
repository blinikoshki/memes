package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int MAX_TEXT_LENGTH = 300;
    private static final String TAG = "com.facebook.appevents.suggestedevents.ViewObserver";
    private static final Map<Integer, ViewObserver> observers = new HashMap();
    /* access modifiers changed from: private */
    public WeakReference<Activity> activityWeakReference;
    private AtomicBoolean isTracking = new AtomicBoolean(false);
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    static void startTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        Map<Integer, ViewObserver> map = observers;
        if (!map.containsKey(Integer.valueOf(hashCode))) {
            ViewObserver viewObserver = new ViewObserver(activity);
            map.put(Integer.valueOf(hashCode), viewObserver);
            viewObserver.startTracking();
        }
    }

    static void stopTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        Map<Integer, ViewObserver> map = observers;
        if (map.containsKey(Integer.valueOf(hashCode))) {
            map.remove(Integer.valueOf(hashCode));
            map.get(Integer.valueOf(hashCode)).stopTracking();
        }
    }

    private ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }

    private void startTracking() {
        View rootView;
        if (!this.isTracking.getAndSet(true) && (rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get())) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                process();
                Activity activity = (Activity) this.activityWeakReference.get();
            }
        }
    }

    private void stopTracking() {
        View rootView;
        if (this.isTracking.getAndSet(false) && (rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get())) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                if (Build.VERSION.SDK_INT < 16) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                } else {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    public void onGlobalLayout() {
        process();
    }

    private void process() {
        C12751 r0 = new Runnable() {
            public void run() {
                try {
                    View rootView = AppEventUtility.getRootView((Activity) ViewObserver.this.activityWeakReference.get());
                    Activity activity = (Activity) ViewObserver.this.activityWeakReference.get();
                    if (rootView == null) {
                        return;
                    }
                    if (activity != null) {
                        for (View next : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                            if (!SensitiveUserDataUtils.isSensitiveUserData(next)) {
                                String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(next);
                                if (!textOfViewRecursively.isEmpty() && textOfViewRecursively.length() <= 300) {
                                    ViewOnClickListener.attachListener(next, rootView, activity.getLocalClassName());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
        } else {
            this.uiThreadHandler.post(r0);
        }
    }
}
