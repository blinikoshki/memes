package com.snapchat.kit.sdk.core.metrics;

import com.snapchat.kit.sdk.core.metrics.skate.SkateClient;
import com.snapchat.kit.sdk.core.networking.ClientFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.n */
public final class C4437n implements Factory<SkateClient> {

    /* renamed from: a */
    private final Provider<ClientFactory> f1206a;

    private C4437n(Provider<ClientFactory> provider) {
        this.f1206a = provider;
    }

    /* renamed from: a */
    public static Factory<SkateClient> m893a(Provider<ClientFactory> provider) {
        return new C4437n(provider);
    }

    public final /* synthetic */ Object get() {
        return (SkateClient) Preconditions.checkNotNull((SkateClient) this.f1206a.get().generateFingerprintedWireClient("https://api.snapkit.com", SkateClient.class), "Cannot return null from a non-@Nullable @Provides method");
    }
}
