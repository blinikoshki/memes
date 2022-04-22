package com.snapchat.kit.sdk;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.Cache;

/* renamed from: com.snapchat.kit.sdk.h */
public final class C4489h implements Factory<Cache> {

    /* renamed from: a */
    private final C4488g f1346a;

    private C4489h(C4488g gVar) {
        this.f1346a = gVar;
    }

    /* renamed from: a */
    public static Factory<Cache> m968a(C4488g gVar) {
        return new C4489h(gVar);
    }

    public final /* synthetic */ Object get() {
        return (Cache) Preconditions.checkNotNull(this.f1346a.mo61805g(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
