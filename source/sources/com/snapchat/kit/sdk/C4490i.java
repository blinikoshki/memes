package com.snapchat.kit.sdk;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.snapchat.kit.sdk.i */
public final class C4490i implements Factory<String> {

    /* renamed from: a */
    private final C4488g f1347a;

    private C4490i(C4488g gVar) {
        this.f1347a = gVar;
    }

    /* renamed from: a */
    public static Factory<String> m969a(C4488g gVar) {
        return new C4490i(gVar);
    }

    public final /* synthetic */ Object get() {
        return (String) Preconditions.checkNotNull(this.f1347a.mo61802c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
