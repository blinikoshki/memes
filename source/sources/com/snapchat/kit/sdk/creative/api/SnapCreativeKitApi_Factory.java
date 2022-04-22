package com.snapchat.kit.sdk.creative.api;

import android.content.Context;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.creative.p045b.C4470a;
import com.snapchat.kit.sdk.creative.p045b.C4472c;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SnapCreativeKitApi_Factory implements Factory<SnapCreativeKitApi> {
    private final Provider<String> clientIdProvider;
    private final Provider<Context> contextProvider;
    private final Provider<C4472c> creativeKitOpMetricsManagerProvider;
    private final Provider<C4470a> eventFactoryProvider;
    private final Provider<MetricQueue<ServerEvent>> eventQueueProvider;
    private final Provider<String> redirectUrlProvider;

    public SnapCreativeKitApi_Factory(Provider<Context> provider, Provider<String> provider2, Provider<String> provider3, Provider<C4472c> provider4, Provider<MetricQueue<ServerEvent>> provider5, Provider<C4470a> provider6) {
        this.contextProvider = provider;
        this.clientIdProvider = provider2;
        this.redirectUrlProvider = provider3;
        this.creativeKitOpMetricsManagerProvider = provider4;
        this.eventQueueProvider = provider5;
        this.eventFactoryProvider = provider6;
    }

    public final SnapCreativeKitApi get() {
        return new SnapCreativeKitApi(this.contextProvider.get(), this.clientIdProvider.get(), this.redirectUrlProvider.get(), this.creativeKitOpMetricsManagerProvider.get(), this.eventQueueProvider.get(), this.eventFactoryProvider.get());
    }

    public static Factory<SnapCreativeKitApi> create(Provider<Context> provider, Provider<String> provider2, Provider<String> provider3, Provider<C4472c> provider4, Provider<MetricQueue<ServerEvent>> provider5, Provider<C4470a> provider6) {
        return new SnapCreativeKitApi_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SnapCreativeKitApi newSnapCreativeKitApi(Context context, String str, String str2, C4472c cVar, MetricQueue<ServerEvent> metricQueue, C4470a aVar) {
        return new SnapCreativeKitApi(context, str, str2, cVar, metricQueue, aVar);
    }
}
