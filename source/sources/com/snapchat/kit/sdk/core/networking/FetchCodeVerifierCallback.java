package com.snapchat.kit.sdk.core.networking;

public interface FetchCodeVerifierCallback {
    void onCodeVerifierFetchFailed(Throwable th);

    void onCodeVerifierFetchedSuccessfully(String str);
}
