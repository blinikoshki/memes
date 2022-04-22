package com.facebook.internal.logging.monitor;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;

public class MonitorManager {
    private static MonitorCreator monitorCreator = new MonitorCreator() {
        public void enable() {
            Monitor.enable();
        }
    };

    public interface MonitorCreator {
        void enable();
    }

    public static void start() {
        FetchedAppSettings appSettingsWithoutQuery;
        if (FacebookSdk.getMonitorEnabled() && (appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId())) != null && appSettingsWithoutQuery.getMonitorViaDialogEnabled()) {
            monitorCreator.enable();
        }
    }

    static void setMonitorCreator(MonitorCreator monitorCreator2) {
        monitorCreator = monitorCreator2;
    }
}
