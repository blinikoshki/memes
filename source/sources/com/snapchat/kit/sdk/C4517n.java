package com.snapchat.kit.sdk;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Random;

/* renamed from: com.snapchat.kit.sdk.n */
public final class C4517n implements Factory<Random> {

    /* renamed from: a */
    private final C4488g f1398a;

    private C4517n(C4488g gVar) {
        this.f1398a = gVar;
    }

    /* renamed from: a */
    public static Factory<Random> m991a(C4488g gVar) {
        return new C4517n(gVar);
    }

    public final /* synthetic */ Object get() {
        return (Random) Preconditions.checkNotNull(C4488g.m958i(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
