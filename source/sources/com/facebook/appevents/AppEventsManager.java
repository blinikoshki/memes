package com.facebook.appevents;

import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.p009ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;

public class AppEventsManager {
    public static void start() {
        FetchedAppSettingsManager.getAppSettingsAsync(new FetchedAppSettingsManager.FetchedAppSettingsCallback() {
            public void onError() {
            }

            public void onSuccess(FetchedAppSettings fetchedAppSettings) {
                FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() {
                    public void onCompleted(boolean z) {
                        if (z) {
                            MetadataIndexer.enable();
                        }
                    }
                });
                FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() {
                    public void onCompleted(boolean z) {
                        if (z) {
                            RestrictiveDataManager.enable();
                        }
                    }
                });
                FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() {
                    public void onCompleted(boolean z) {
                        if (z) {
                            ModelManager.enable();
                        }
                    }
                });
                FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() {
                    public void onCompleted(boolean z) {
                        if (z) {
                            EventDeactivationManager.enable();
                        }
                    }
                });
            }
        });
    }
}
