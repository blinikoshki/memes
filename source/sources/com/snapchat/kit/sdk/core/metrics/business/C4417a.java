package com.snapchat.kit.sdk.core.metrics.business;

import android.content.SharedPreferences;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.C4426c;
import com.snapchat.kit.sdk.core.metrics.MetricPublisher;
import com.snapchat.kit.sdk.core.metrics.MetricsClient;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.metrics.model.ServerEventBatch;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.metrics.business.a */
public final class C4417a implements MetricPublisher<ServerEvent> {

    /* renamed from: a */
    private final SharedPreferences f1167a;

    /* renamed from: b */
    private final C4425h f1168b;

    /* renamed from: c */
    private final MetricsClient f1169c;

    /* renamed from: d */
    private final C4414a f1170d;

    @Inject
    C4417a(SharedPreferences sharedPreferences, C4425h hVar, MetricsClient metricsClient, C4414a aVar) {
        this.f1167a = sharedPreferences;
        this.f1168b = hVar;
        this.f1169c = metricsClient;
        this.f1170d = aVar;
    }

    public final void publishMetrics(List<ServerEvent> list, final MetricPublisher.PublishCallback publishCallback) {
        this.f1169c.postAnalytics(new ServerEventBatch.Builder().server_events(list).max_sequence_id_on_instance(Long.valueOf(this.f1168b.mo61359c())).build()).enqueue(new Callback<Void>() {
            public final void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    publishCallback.onSuccess();
                    return;
                }
                try {
                    publishCallback.onServerError(new Error(response.errorBody().string()));
                } catch (IOException | NullPointerException unused) {
                    publishCallback.onServerError(new Error("response unsuccessful"));
                }
            }

            public final void onFailure(Call<Void> call, Throwable th) {
                if (th instanceof IOException) {
                    publishCallback.onNetworkError();
                } else {
                    publishCallback.onServerError(new Error(th));
                }
            }
        });
    }

    public final void persistMetrics(List<C4426c<ServerEvent>> list) {
        this.f1167a.edit().putString("unsent_analytics_events", this.f1170d.mo61350a(list)).apply();
    }

    public final List<C4426c<ServerEvent>> getPersistedEvents() {
        return this.f1170d.mo61351a(ServerEvent.ADAPTER, this.f1167a.getString("unsent_analytics_events", (String) null));
    }
}
