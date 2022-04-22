package com.snapchat.kit.sdk.login.p047b;

import android.view.View;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.models.SnapKitFeatureOptions;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import com.snapchat.kit.sdk.login.C4494R;
import com.snapchat.kit.sdk.login.dagger.scope.LoginScope;
import com.snapchat.kit.sdk.login.p046a.C4507a;
import javax.inject.Inject;

@LoginScope
/* renamed from: com.snapchat.kit.sdk.login.b.a */
public final class C4510a implements View.OnClickListener, LoginStateController.OnLoginStartListener, LoginStateController.OnLoginStateChangedListener {

    /* renamed from: a */
    private final AuthTokenManager f1378a;

    /* renamed from: b */
    private final LoginStateController f1379b;

    /* renamed from: c */
    private final C4507a f1380c;

    /* renamed from: d */
    private View f1381d;

    /* renamed from: e */
    private View f1382e;

    /* renamed from: f */
    private View f1383f;

    /* renamed from: g */
    private SnapKitFeatureOptions f1384g;

    public final void onLoginSucceeded() {
    }

    @Inject
    C4510a(AuthTokenManager authTokenManager, LoginStateController loginStateController, C4507a aVar) {
        this.f1378a = authTokenManager;
        this.f1379b = loginStateController;
        this.f1380c = aVar;
    }

    /* renamed from: a */
    public final void mo61813a(View view, SnapKitFeatureOptions snapKitFeatureOptions) {
        this.f1381d = view;
        this.f1384g = snapKitFeatureOptions;
        this.f1382e = view.findViewById(C4494R.C4497id.snap_connect_login_text_button);
        this.f1383f = view.findViewById(C4494R.C4497id.snap_connect_login_loading_icon);
        this.f1379b.addOnLoginStateChangedListener(this);
        this.f1379b.addOnLoginStartListener(this);
        this.f1380c.mo61811a("loginButton");
        this.f1381d.setOnClickListener(this);
    }

    public final void onClick(View view) {
        SnapKitFeatureOptions snapKitFeatureOptions = this.f1384g;
        if (snapKitFeatureOptions == null) {
            this.f1378a.startTokenGrant();
        } else {
            this.f1378a.startTokenGrantWithOptions(snapKitFeatureOptions);
        }
    }

    public final void onLoginFailed() {
        m982a(true);
    }

    public final void onLogout() {
        m982a(true);
    }

    public final void onLoginStart() {
        m982a(false);
    }

    /* renamed from: a */
    private void m982a(boolean z) {
        int i = 0;
        this.f1383f.setVisibility(z ? 8 : 0);
        View view = this.f1382e;
        if (!z) {
            i = 4;
        }
        view.setVisibility(i);
        this.f1381d.setEnabled(z);
    }
}
