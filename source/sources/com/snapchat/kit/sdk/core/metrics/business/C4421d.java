package com.snapchat.kit.sdk.core.metrics.business;

import com.snapchat.kit.sdk.core.metrics.C4402a;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.core.metrics.business.d */
public final class C4421d implements Factory<C4420c> {

    /* renamed from: a */
    private final Provider<C4425h> f1179a;

    /* renamed from: b */
    private final Provider<C4402a<ServerEvent>> f1180b;

    private C4421d(Provider<C4425h> provider, Provider<C4402a<ServerEvent>> provider2) {
        this.f1179a = provider;
        this.f1180b = provider2;
    }

    /* renamed from: a */
    public static Factory<C4420c> m869a(Provider<C4425h> provider, Provider<C4402a<ServerEvent>> provider2) {
        return new C4421d(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new C4420c(this.f1179a.get(), this.f1180b.get());
    }
}
