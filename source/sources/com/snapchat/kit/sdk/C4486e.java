package com.snapchat.kit.sdk;

import com.snapchat.kit.sdk.core.controller.LoginStateController;
import dagger.MembersInjector;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.e */
public final class C4486e implements MembersInjector<SnapCFSActivity> {

    /* renamed from: a */
    private final Provider<C4475d> f1338a;

    /* renamed from: b */
    private final Provider<LoginStateController> f1339b;

    public final /* synthetic */ void injectMembers(Object obj) {
        SnapCFSActivity snapCFSActivity = (SnapCFSActivity) obj;
        snapCFSActivity.f1037a = this.f1338a.get();
        snapCFSActivity.f1038b = this.f1339b.get();
    }

    /* renamed from: a */
    public static void m950a(SnapCFSActivity snapCFSActivity, C4475d dVar) {
        snapCFSActivity.f1037a = dVar;
    }

    /* renamed from: a */
    public static void m949a(SnapCFSActivity snapCFSActivity, LoginStateController loginStateController) {
        snapCFSActivity.f1038b = loginStateController;
    }
}
