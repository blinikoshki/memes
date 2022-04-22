package com.snapchat.kit.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.snap.kit.sdk.model.SnapKitStorySnapView;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.business.KitEventBaseFactory;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import com.snapchat.kit.sdk.core.networking.ClientFactory;
import javax.inject.Named;

public interface SnapKitProvidingComponent {
    MetricQueue<ServerEvent> analyticsEventQueue();

    ClientFactory apiFactory();

    AuthTokenManager authTokenManager();

    @Named("client_id")
    String clientId();

    Context context();

    Gson gson();

    KitEventBaseFactory kitEventBaseFactory();

    LoginStateController logoutController();

    MetricQueue<OpMetric> operationalMetricsQueue();

    @Named("redirect_url")
    String redirectUrl();

    SharedPreferences sharedPreferences();

    SnapKitAppLifecycleObserver snapKitAppLifecycleObserver();

    MetricQueue<SnapKitStorySnapView> snapViewEventQueue();
}
