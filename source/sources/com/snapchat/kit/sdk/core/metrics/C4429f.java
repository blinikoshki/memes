package com.snapchat.kit.sdk.core.metrics;

import com.snapchat.kit.sdk.core.config.ConfigClient;
import com.snapchat.kit.sdk.core.networking.ClientFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.f */
public final class C4429f implements Factory<ConfigClient> {

    /* renamed from: a */
    private final Provider<ClientFactory> f1191a;

    private C4429f(Provider<ClientFactory> provider) {
        this.f1191a = provider;
    }

    /* renamed from: a */
    public static Factory<ConfigClient> m885a(Provider<ClientFactory> provider) {
        return new C4429f(provider);
    }

    public final /* synthetic */ Object get() {
        return (ConfigClient) Preconditions.checkNotNull((ConfigClient) this.f1191a.get().generateFingerprintedClient("https://api.snapkit.com", ConfigClient.class), "Cannot return null from a non-@Nullable @Provides method");
    }
}
