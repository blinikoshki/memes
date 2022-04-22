package com.snapchat.kit.sdk;

import dagger.MembersInjector;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.f */
public final class C4487f implements MembersInjector<SnapKitActivity> {

    /* renamed from: a */
    private final Provider<C4475d> f1340a;

    public final /* synthetic */ void injectMembers(Object obj) {
        ((SnapKitActivity) obj).f1055a = this.f1340a.get();
    }

    /* renamed from: a */
    public static void m951a(SnapKitActivity snapKitActivity, C4475d dVar) {
        snapKitActivity.f1055a = dVar;
    }
}
