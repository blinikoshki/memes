package com.memes.plus.p040ui.auth.signinsc;

import android.content.Context;
import com.snapchat.kit.sdk.SnapLogin;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthProvider;", "Lcom/snapchat/kit/sdk/core/controller/LoginStateController$OnLoginStateChangedListener;", "context", "Landroid/content/Context;", "callback", "Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthProvider$Callback;", "(Landroid/content/Context;Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthProvider$Callback;)V", "onDestroy", "", "onLoginFailed", "onLoginSucceeded", "onLogout", "startSignIn", "Callback", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinsc.SnapchatAuthProvider */
/* compiled from: SnapchatAuthProvider.kt */
public final class SnapchatAuthProvider implements LoginStateController.OnLoginStateChangedListener {
    private final Callback callback;
    private final Context context;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinsc/SnapchatAuthProvider$Callback;", "", "onSnapchatSignInFailed", "", "error", "", "onSnapchatSignInProgress", "shouldShow", "", "onSnapchatSignInSuccess", "accessToken", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signinsc.SnapchatAuthProvider$Callback */
    /* compiled from: SnapchatAuthProvider.kt */
    public interface Callback {
        void onSnapchatSignInFailed(String str);

        void onSnapchatSignInProgress(boolean z);

        void onSnapchatSignInSuccess(String str);
    }

    public SnapchatAuthProvider(Context context2, Callback callback2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.callback = callback2;
        SnapLogin.getAuthTokenManager(context2).clearToken();
        SnapLogin.getLoginStateController(context2).addOnLoginStateChangedListener(this);
    }

    public final void startSignIn() {
        this.callback.onSnapchatSignInProgress(true);
        SnapLogin.getAuthTokenManager(this.context).startTokenGrant();
    }

    public final void onDestroy() {
        SnapLogin.getLoginStateController(this.context).removeOnLoginStateChangedListener(this);
    }

    public void onLoginSucceeded() {
        boolean z = false;
        Timber.m300d("~> Snapchat onLoginSucceeded()", new Object[0]);
        if (!SnapLogin.isUserLoggedIn(this.context)) {
            this.callback.onSnapchatSignInFailed("Snapchat Sign In Failed.");
            return;
        }
        AuthTokenManager authTokenManager = SnapLogin.getAuthTokenManager(this.context);
        Intrinsics.checkNotNullExpressionValue(authTokenManager, "SnapLogin.getAuthTokenManager(context)");
        String accessToken = authTokenManager.getAccessToken();
        CharSequence charSequence = accessToken;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            z = true;
        }
        if (z) {
            this.callback.onSnapchatSignInFailed("Unable to access snapchat token.");
        } else {
            this.callback.onSnapchatSignInSuccess(accessToken);
        }
    }

    public void onLoginFailed() {
        Timber.m300d("~> Snapchat onLoginFailed()", new Object[0]);
        this.callback.onSnapchatSignInFailed("Snapchat Sign In Failed.");
    }

    public void onLogout() {
        Timber.m300d("~> Snapchat onLogout()", new Object[0]);
    }
}
