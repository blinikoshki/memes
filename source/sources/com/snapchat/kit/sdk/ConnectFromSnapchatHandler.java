package com.snapchat.kit.sdk;

import com.snapchat.kit.sdk.core.networking.FetchCodeVerifierCallback;

public interface ConnectFromSnapchatHandler {
    void fetchCodeVerifier(String str, FetchCodeVerifierCallback fetchCodeVerifierCallback);

    boolean needsLoginRedirect();
}
