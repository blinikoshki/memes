package com.snapchat.kit.sdk.core.networking;

public interface RefreshAccessTokenResult {
    void onRefreshAccessTokenFailure(RefreshAccessTokenResultError refreshAccessTokenResultError);

    void onRefreshAccessTokenSuccess(String str);
}
