package com.snapchat.kit.sdk;

import com.snapchat.kit.sdk.core.metrics.model.SnapKitInitType;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.snapchat.kit.sdk.t */
public final class C4522t implements Factory<SnapKitInitType> {

    /* renamed from: a */
    private final C4488g f1411a;

    private C4522t(C4488g gVar) {
        this.f1411a = gVar;
    }

    /* renamed from: a */
    public static Factory<SnapKitInitType> m996a(C4488g gVar) {
        return new C4522t(gVar);
    }

    public final /* synthetic */ Object get() {
        return (SnapKitInitType) Preconditions.checkNotNull(this.f1411a.mo61798a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
