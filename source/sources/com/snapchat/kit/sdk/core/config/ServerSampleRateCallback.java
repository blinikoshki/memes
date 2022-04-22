package com.snapchat.kit.sdk.core.config;

public interface ServerSampleRateCallback {
    void onServerSampleRateAvailable(double d);

    void onServerSampleRateFailure();
}
