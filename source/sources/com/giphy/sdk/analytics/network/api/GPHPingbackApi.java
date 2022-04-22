package com.giphy.sdk.analytics.network.api;

import com.giphy.sdk.analytics.models.Session;
import com.giphy.sdk.analytics.network.response.PingbackResponse;
import com.giphy.sdk.analytics.network.response.RandomIdResponse;
import com.giphy.sdk.analytics.threading.ApiTask;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\"\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J(\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¨\u0006\u000f"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/network/api/GPHPingbackApi;", "", "randomIdTask", "Lcom/giphy/sdk/analytics/threading/ApiTask;", "Lcom/giphy/sdk/analytics/network/response/RandomIdResponse;", "submitSession", "Ljava/util/concurrent/Future;", "session", "Lcom/giphy/sdk/analytics/models/Session;", "completionHandler", "Lcom/giphy/sdk/analytics/network/api/CompletionHandler;", "Lcom/giphy/sdk/analytics/network/response/PingbackResponse;", "submitSessions", "sessions", "", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: GPHPingbackApi.kt */
public interface GPHPingbackApi {
    ApiTask<RandomIdResponse> randomIdTask();

    Future<?> submitSession(Session session, CompletionHandler<PingbackResponse> completionHandler);

    Future<?> submitSessions(List<Session> list, CompletionHandler<PingbackResponse> completionHandler);
}
