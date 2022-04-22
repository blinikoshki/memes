package com.snapchat.kit.sdk.core.metrics;

import com.snap.kit.sdk.model.SnapKitStorySnapViews;
import com.snapchat.kit.sdk.core.metrics.model.Metrics;
import com.snapchat.kit.sdk.core.metrics.model.ServerEventBatch;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MetricsClient {
    @POST("/v1/sdk/metrics/business")
    Call<Void> postAnalytics(@Body ServerEventBatch serverEventBatch);

    @POST("/v1/sdk/metrics/operational")
    Call<Void> postOperationalMetrics(@Body Metrics metrics);

    @POST("/v1/stories/app/view")
    Call<Void> postViewEvents(@Body SnapKitStorySnapViews snapKitStorySnapViews);
}
