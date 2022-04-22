package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;

public class InstrumentManager {
    public static void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new FeatureManager.Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        CrashHandler.enable();
                        if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                            ExceptionAnalyzer.enable();
                            CrashShieldHandler.enable();
                        }
                        if (FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck)) {
                            ThreadCheckHandler.enable();
                        }
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        ErrorReportHandler.enable();
                    }
                }
            });
        }
    }
}
