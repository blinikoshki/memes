package com.snapchat.kit.sdk.core.networking;

import com.snapchat.kit.sdk.core.models.SnapKitFeatureOptions;

public interface AuthTokenManager {
    void clearToken();

    String getAccessToken();

    boolean hasAccessToScope(String str);

    boolean isUserLoggedIn();

    void refreshAccessToken(RefreshAccessTokenResult refreshAccessTokenResult);

    void startTokenGrant();

    void startTokenGrantWithOptions(SnapKitFeatureOptions snapKitFeatureOptions);
}
