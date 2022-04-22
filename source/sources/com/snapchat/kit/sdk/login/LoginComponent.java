package com.snapchat.kit.sdk.login;

import com.snapchat.kit.sdk.SnapKitComponent;
import com.snapchat.kit.sdk.SnapKitProvidingComponent;
import com.snapchat.kit.sdk.login.dagger.scope.LoginScope;
import com.snapchat.kit.sdk.login.networking.C4513a;
import com.snapchat.kit.sdk.login.networking.LoginClient;
import com.snapchat.kit.sdk.login.p047b.C4510a;
import dagger.Component;

@LoginScope
@Component(dependencies = {SnapKitComponent.class}, modules = {C4509b.class})
public interface LoginComponent extends SnapKitProvidingComponent {
    C4510a loginButtonController();

    LoginClient loginClient();

    C4513a snapLoginClient();
}
