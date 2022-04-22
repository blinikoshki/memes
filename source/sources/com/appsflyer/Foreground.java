package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Foreground {
    public static long CHECK_DELAY = 500;
    public static Listener listener;

    public interface Listener {
        void onBecameBackground(Context context);

        void onBecameForeground(Activity activity);
    }

    static void $$a(Context context, final Listener listener2) {
        listener = listener2;
        C10232 r0 = new Application.ActivityLifecycleCallbacks() {
            private Executor AFDateFormat = Executors.newSingleThreadExecutor();
            boolean valueOf;
            boolean values = true;

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }

            public final void onActivityResumed(final Activity activity) {
                this.AFDateFormat.execute(new Runnable() {
                    public final void run() {
                        if (!C10232.this.valueOf) {
                            try {
                                listener2.onBecameForeground(activity);
                            } catch (Exception e) {
                                AFLogger.afErrorLog("Listener thrown an exception: ", e, true);
                            }
                        }
                        C10232.this.values = false;
                        C10232.this.valueOf = true;
                    }
                });
            }

            public final void onActivityPaused(final Activity activity) {
                this.AFDateFormat.execute(new Runnable() {
                    public final void run() {
                        C10232.this.values = true;
                        final Context applicationContext = activity.getApplicationContext();
                        try {
                            new Timer().schedule(new TimerTask() {
                                public final void run() {
                                    if (C10232.this.valueOf && C10232.this.values) {
                                        C10232.this.valueOf = false;
                                        try {
                                            listener2.onBecameBackground(applicationContext);
                                        } catch (Exception e) {
                                            AFLogger.afErrorLog("Listener threw exception! ", e);
                                        }
                                    }
                                }
                            }, Foreground.CHECK_DELAY);
                        } catch (Throwable th) {
                            AFLogger.afErrorLog("Background task failed with a throwable: ", th);
                        }
                    }
                });
            }

            public final void onActivityCreated(final Activity activity, Bundle bundle) {
                this.AFDateFormat.execute(new Runnable() {
                    public final void run() {
                        AFDeepLinkManager.getInstance().collectIntentsFromActivities(activity.getIntent());
                    }
                });
            }
        };
        if (context instanceof Activity) {
            r0.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(r0);
    }
}
