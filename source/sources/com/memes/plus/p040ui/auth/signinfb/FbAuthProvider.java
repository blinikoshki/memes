package com.memes.plus.p040ui.auth.signinfb;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0006\u0010\u001e\u001a\u00020\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinfb/FbAuthProvider;", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "loginButton", "Lcom/facebook/login/widget/LoginButton;", "callback", "Lcom/memes/plus/ui/auth/signinfb/FbAuthProvider$Callback;", "(Lcom/facebook/login/widget/LoginButton;Lcom/memes/plus/ui/auth/signinfb/FbAuthProvider$Callback;)V", "callbackManager", "Lcom/facebook/CallbackManager;", "kotlin.jvm.PlatformType", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "callbackManager$delegate", "Lkotlin/Lazy;", "handleActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "initSetup", "", "onCancel", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "loginResult", "signOut", "Callback", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthProvider */
/* compiled from: FbAuthProvider.kt */
public final class FbAuthProvider implements FacebookCallback<LoginResult> {
    private final Callback callback;
    private final Lazy callbackManager$delegate = LazyKt.lazy(FbAuthProvider$callbackManager$2.INSTANCE);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/ui/auth/signinfb/FbAuthProvider$Callback;", "", "onFacebookAuthFailed", "", "wasCanceled", "", "error", "", "onFacebookAuthSuccess", "result", "Lcom/facebook/login/LoginResult;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthProvider$Callback */
    /* compiled from: FbAuthProvider.kt */
    public interface Callback {
        void onFacebookAuthFailed(boolean z, String str);

        void onFacebookAuthSuccess(LoginResult loginResult);
    }

    private final CallbackManager getCallbackManager() {
        return (CallbackManager) this.callbackManager$delegate.getValue();
    }

    public FbAuthProvider(LoginButton loginButton, Callback callback2) {
        Intrinsics.checkNotNullParameter(loginButton, "loginButton");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
        loginButton.setPermissions((List<String>) CollectionsKt.listOf("email", "public_profile"));
        signOut();
        initSetup();
    }

    private final void initSetup() {
        LoginManager instance = LoginManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "LoginManager.getInstance()");
        instance.setLoginBehavior(LoginBehavior.WEB_ONLY);
        LoginManager.getInstance().registerCallback(getCallbackManager(), this);
    }

    public final boolean handleActivityResult(int i, int i2, Intent intent) {
        return getCallbackManager().onActivityResult(i, i2, intent);
    }

    public final void signOut() {
        LoginManager.getInstance().logOut();
    }

    public void onSuccess(LoginResult loginResult) {
        Intrinsics.checkNotNullParameter(loginResult, "loginResult");
        this.callback.onFacebookAuthSuccess(loginResult);
    }

    public void onCancel() {
        this.callback.onFacebookAuthFailed(true, "Facebook Login canceled.");
    }

    public void onError(FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookException, "error");
        Timber.m303e("facebook-login-error: " + facebookException, new Object[0]);
        Callback callback2 = this.callback;
        callback2.onFacebookAuthFailed(false, "Error: " + facebookException.getMessage());
    }
}
