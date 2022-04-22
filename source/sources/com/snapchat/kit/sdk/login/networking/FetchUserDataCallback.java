package com.snapchat.kit.sdk.login.networking;

import com.snapchat.kit.sdk.login.models.UserDataResponse;

public interface FetchUserDataCallback extends SnapLoginClientCallback<UserDataResponse> {
    void onFailure(boolean z, int i);

    void onSuccess(UserDataResponse userDataResponse);
}
