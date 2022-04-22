package com.snapchat.kit.sdk.core.controller;

import android.os.Handler;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.WeakHashMap;
import javax.inject.Inject;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.controller.a */
public final class C4396a implements LoginStateController {

    /* renamed from: a */
    private final WeakHashMap<LoginStateController.OnLoginStateChangedListener, Void> f1123a = new WeakHashMap<>();

    /* renamed from: b */
    private final WeakHashMap<LoginStateController.OnLoginStartListener, Void> f1124b = new WeakHashMap<>();

    /* renamed from: c */
    private final Handler f1125c;

    @Inject
    C4396a(Handler handler) {
        this.f1125c = handler;
    }

    public final void addOnLoginStateChangedListener(LoginStateController.OnLoginStateChangedListener onLoginStateChangedListener) {
        this.f1123a.put(onLoginStateChangedListener, (Object) null);
    }

    public final void removeOnLoginStateChangedListener(LoginStateController.OnLoginStateChangedListener onLoginStateChangedListener) {
        this.f1123a.remove(onLoginStateChangedListener);
    }

    public final void addOnLoginStartListener(LoginStateController.OnLoginStartListener onLoginStartListener) {
        this.f1124b.put(onLoginStartListener, (Object) null);
    }

    public final void removeOnLoginStartListener(LoginStateController.OnLoginStartListener onLoginStartListener) {
        this.f1124b.remove(onLoginStartListener);
    }

    /* renamed from: a */
    public final void mo61315a() {
        this.f1125c.post(new Runnable() {
            public final void run() {
                for (LoginStateController.OnLoginStateChangedListener onLogout : C4396a.m841a(C4396a.this)) {
                    onLogout.onLogout();
                }
            }
        });
    }

    /* renamed from: b */
    public final void mo61316b() {
        this.f1125c.post(new Runnable() {
            public final void run() {
                for (LoginStateController.OnLoginStateChangedListener onLoginSucceeded : C4396a.m841a(C4396a.this)) {
                    onLoginSucceeded.onLoginSucceeded();
                }
            }
        });
    }

    /* renamed from: c */
    public final void mo61317c() {
        this.f1125c.post(new Runnable() {
            public final void run() {
                for (LoginStateController.OnLoginStateChangedListener onLoginFailed : C4396a.m841a(C4396a.this)) {
                    onLoginFailed.onLoginFailed();
                }
            }
        });
    }

    /* renamed from: d */
    public final void mo61318d() {
        this.f1125c.post(new Runnable() {
            public final void run() {
                for (LoginStateController.OnLoginStartListener onLoginStart : C4396a.m842b(C4396a.this)) {
                    onLoginStart.onLoginStart();
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ Collection m841a(C4396a aVar) {
        return new ArrayList(aVar.f1123a.keySet());
    }

    /* renamed from: b */
    static /* synthetic */ Collection m842b(C4396a aVar) {
        return new ArrayList(aVar.f1124b.keySet());
    }
}
