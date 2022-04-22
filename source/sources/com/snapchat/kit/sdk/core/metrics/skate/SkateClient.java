package com.snapchat.kit.sdk.core.metrics.skate;

import com.snap.kit.sdk.model.MetricSampleRate;
import com.snapchat.kit.sdk.core.metrics.model.ServerEventBatch;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SkateClient {
    @POST("/v1/sdk/metrics/skate")
    Call<MetricSampleRate> postSkateEvents(@Body ServerEventBatch serverEventBatch);
}
