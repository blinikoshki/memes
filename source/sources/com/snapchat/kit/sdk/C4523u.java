package com.snapchat.kit.sdk;

import android.os.Handler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.snapchat.kit.sdk.u */
public final class C4523u implements Factory<Handler> {

    /* renamed from: a */
    private final C4488g f1412a;

    private C4523u(C4488g gVar) {
        this.f1412a = gVar;
    }

    /* renamed from: a */
    public static Factory<Handler> m997a(C4488g gVar) {
        return new C4523u(gVar);
    }

    public final /* synthetic */ Object get() {
        return (Handler) Preconditions.checkNotNull(C4488g.m959j(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
