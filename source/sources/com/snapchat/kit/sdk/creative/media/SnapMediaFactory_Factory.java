package com.snapchat.kit.sdk.creative.media;

import com.snapchat.kit.sdk.creative.p045b.C4472c;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SnapMediaFactory_Factory implements Factory<SnapMediaFactory> {

    /* renamed from: a */
    private final Provider<C4472c> f1284a;

    public SnapMediaFactory_Factory(Provider<C4472c> provider) {
        this.f1284a = provider;
    }

    public final SnapMediaFactory get() {
        return new SnapMediaFactory(this.f1284a.get());
    }

    public static Factory<SnapMediaFactory> create(Provider<C4472c> provider) {
        return new SnapMediaFactory_Factory(provider);
    }

    public static SnapMediaFactory newSnapMediaFactory(C4472c cVar) {
        return new SnapMediaFactory(cVar);
    }
}
