package com.snapchat.kit.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.models.SnapKitFeatureOptions;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import com.snapchat.kit.sdk.login.C4494R;
import com.snapchat.kit.sdk.login.C4501a;
import com.snapchat.kit.sdk.login.LoginComponent;
import com.snapchat.kit.sdk.login.networking.FetchUserDataCallback;
import java.util.Map;

public class SnapLogin {

    /* renamed from: a */
    static LoginComponent f1057a;

    static synchronized LoginComponent getComponent(Context context) {
        LoginComponent loginComponent;
        synchronized (SnapLogin.class) {
            if (f1057a == null) {
                SnapKitComponent component = SnapKit.getComponent(context);
                component.kitEventBaseFactory().setLoginKitVersion("1.6.8");
                f1057a = C4501a.m973a().mo61810a(component).mo61809a();
            }
            loginComponent = f1057a;
        }
        return loginComponent;
    }

    public static View getButton(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(C4494R.C4499layout.snap_connect_login_button, viewGroup, false);
        getComponent(context).loginButtonController().mo61813a(inflate, (SnapKitFeatureOptions) null);
        viewGroup.addView(inflate);
        return inflate;
    }

    public static View getButtonWithFlags(Context context, ViewGroup viewGroup, SnapKitFeatureOptions snapKitFeatureOptions) {
        View inflate = LayoutInflater.from(context).inflate(C4494R.C4499layout.snap_connect_login_button, viewGroup, false);
        getComponent(context).loginButtonController().mo61813a(inflate, snapKitFeatureOptions);
        viewGroup.addView(inflate);
        return inflate;
    }

    public static LoginStateController getLoginStateController(Context context) {
        return SnapKit.getComponent(context).logoutController();
    }

    public static boolean isUserLoggedIn(Context context) {
        return SnapKit.getComponent(context).authTokenManager().isUserLoggedIn();
    }

    public static AuthTokenManager getAuthTokenManager(Context context) {
        return SnapKit.getComponent(context).authTokenManager();
    }

    public static void fetchUserData(Context context, String str, Map<String, Object> map, FetchUserDataCallback fetchUserDataCallback) {
        getComponent(context).snapLoginClient().mo61834a(str, map, fetchUserDataCallback);
    }
}
