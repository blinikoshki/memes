package com.snapchat.kit.sdk.login.networking;

public interface SnapLoginClientCallback<T> {
    void onFailure(boolean z, int i);

    void onSuccess(T t);
}
