package com.snapchat.kit.sdk.core.metrics;

import com.snapchat.kit.sdk.core.networking.ClientFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.i */
public final class C4432i implements Factory<MetricsClient> {

    /* renamed from: a */
    private final Provider<ClientFactory> f1198a;

    private C4432i(Provider<ClientFactory> provider) {
        this.f1198a = provider;
    }

    /* renamed from: a */
    public static Factory<MetricsClient> m888a(Provider<ClientFactory> provider) {
        return new C4432i(provider);
    }

    public final /* synthetic */ Object get() {
        return (MetricsClient) Preconditions.checkNotNull((MetricsClient) this.f1198a.get().generateAuthedAndFingerprintedWireClient("https://api.snapkit.com", MetricsClient.class), "Cannot return null from a non-@Nullable @Provides method");
    }
}
