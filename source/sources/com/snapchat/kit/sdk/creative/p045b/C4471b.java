package com.snapchat.kit.sdk.creative.p045b;

import com.snapchat.kit.sdk.core.metrics.business.KitEventBaseFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.creative.b.b */
public final class C4471b implements Factory<C4470a> {

    /* renamed from: a */
    private final Provider<KitEventBaseFactory> f1277a;

    /* renamed from: a */
    public static C4470a m925a(KitEventBaseFactory kitEventBaseFactory) {
        return new C4470a(kitEventBaseFactory);
    }

    public final /* synthetic */ Object get() {
        return new C4470a(this.f1277a.get());
    }
}
