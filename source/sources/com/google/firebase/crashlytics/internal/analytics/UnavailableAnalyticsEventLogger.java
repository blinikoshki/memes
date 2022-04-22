package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;

public class UnavailableAnalyticsEventLogger implements AnalyticsEventLogger {
    public void logEvent(String str, Bundle bundle) {
        Logger.getLogger().mo53729d("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }
}
