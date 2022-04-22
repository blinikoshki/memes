package com.facebook.appevents.aam;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.AppEventUtility;
import editor.editor.equipment.core.CoreConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

final class MetadataViewObserver implements ViewTreeObserver.OnGlobalFocusChangeListener {
    private static final int MAX_TEXT_LENGTH = 100;
    private static final String TAG = "com.facebook.appevents.aam.MetadataViewObserver";
    private static final Map<Integer, MetadataViewObserver> observers = new HashMap();
    private WeakReference<Activity> activityWeakReference;
    private AtomicBoolean isTracking;
    private final Set<String> processedText = new HashSet();
    private final Handler uiThreadHandler;

    private MetadataViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.isTracking = new AtomicBoolean(false);
    }

    static void startTrackingActivity(Activity activity) {
        MetadataViewObserver metadataViewObserver;
        int hashCode = activity.hashCode();
        Map<Integer, MetadataViewObserver> map = observers;
        if (!map.containsKey(Integer.valueOf(hashCode))) {
            metadataViewObserver = new MetadataViewObserver(activity);
            map.put(Integer.valueOf(activity.hashCode()), metadataViewObserver);
        } else {
            metadataViewObserver = map.get(Integer.valueOf(hashCode));
        }
        metadataViewObserver.startTracking();
    }

    static void stopTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        Map<Integer, MetadataViewObserver> map = observers;
        if (map.containsKey(Integer.valueOf(hashCode))) {
            map.remove(Integer.valueOf(hashCode));
            map.get(Integer.valueOf(activity.hashCode())).stopTracking();
        }
    }

    private void startTracking() {
        View rootView;
        if (!this.isTracking.getAndSet(true) && (rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get())) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalFocusChangeListener(this);
            }
        }
    }

    private void stopTracking() {
        View rootView;
        if (this.isTracking.getAndSet(false) && (rootView = AppEventUtility.getRootView((Activity) this.activityWeakReference.get())) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalFocusChangeListener(this);
            }
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        if (view != null) {
            process(view);
        }
        if (view2 != null) {
            process(view2);
        }
    }

    private void process(final View view) {
        runOnUIThread(new Runnable() {
            public void run() {
                View view = view;
                if (view instanceof EditText) {
                    MetadataViewObserver.this.processEditText(view);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void processEditText(View view) {
        String lowerCase = ((EditText) view).getText().toString().trim().toLowerCase();
        if (!lowerCase.isEmpty() && !this.processedText.contains(lowerCase) && lowerCase.length() <= 100) {
            this.processedText.add(lowerCase);
            HashMap hashMap = new HashMap();
            List<String> currentViewIndicators = MetadataMatcher.getCurrentViewIndicators(view);
            List<String> list = null;
            for (MetadataRule next : MetadataRule.getRules()) {
                String preNormalize = preNormalize(next.getName(), lowerCase);
                if (next.getValRule().isEmpty() || MetadataMatcher.matchValue(preNormalize, next.getValRule())) {
                    if (MetadataMatcher.matchIndicator(currentViewIndicators, next.getKeyRules())) {
                        putUserData(hashMap, next.getName(), preNormalize);
                    } else {
                        if (list == null) {
                            list = MetadataMatcher.getAroundViewIndicators(view);
                        }
                        if (MetadataMatcher.matchIndicator(list, next.getKeyRules())) {
                            putUserData(hashMap, next.getName(), preNormalize);
                        }
                    }
                }
            }
            InternalAppEventsLogger.setInternalUserData(hashMap);
        }
    }

    private static String preNormalize(String str, String str2) {
        return "r2".equals(str) ? str2.replaceAll("[^\\d.]", "") : str2;
    }

    private static void putUserData(Map<String, String> map, String str, String str2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 3585:
                if (str.equals("r3")) {
                    c = 0;
                    break;
                }
                break;
            case 3586:
                if (str.equals("r4")) {
                    c = 1;
                    break;
                }
                break;
            case 3587:
                if (str.equals("r5")) {
                    c = 2;
                    break;
                }
                break;
            case 3588:
                if (str.equals("r6")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (!str2.startsWith("m") && !str2.startsWith("b") && !str2.startsWith(UserDataStore.GENDER)) {
                    str2 = "f";
                    break;
                } else {
                    str2 = "m";
                    break;
                }
                break;
            case 1:
            case 2:
                str2 = str2.replaceAll("[^a-z]+", "");
                break;
            case 3:
                if (str2.contains(CoreConfig.ENTITY_TOKEN_PREFIX)) {
                    str2 = str2.split(CoreConfig.ENTITY_TOKEN_PREFIX)[0];
                    break;
                }
                break;
        }
        map.put(str, str2);
    }

    private void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.uiThreadHandler.post(runnable);
        }
    }
}
