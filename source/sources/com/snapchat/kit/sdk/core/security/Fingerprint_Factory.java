package com.snapchat.kit.sdk.core.security;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class Fingerprint_Factory implements Factory<Fingerprint> {
    private final Provider<Context> contextProvider;

    public Fingerprint_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public final Fingerprint get() {
        return new Fingerprint(this.contextProvider.get());
    }

    public static Factory<Fingerprint> create(Provider<Context> provider) {
        return new Fingerprint_Factory(provider);
    }
}
