package com.snapchat.kit.sdk.core.metrics.p042a;

import android.content.SharedPreferences;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.C4426c;
import com.snapchat.kit.sdk.core.metrics.MetricPublisher;
import com.snapchat.kit.sdk.core.metrics.MetricsClient;
import com.snapchat.kit.sdk.core.metrics.model.Metrics;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.metrics.a.a */
public final class C4410a implements MetricPublisher<OpMetric> {

    /* renamed from: a */
    private final SharedPreferences f1151a;

    /* renamed from: b */
    private final MetricsClient f1152b;

    /* renamed from: c */
    private final C4414a f1153c;

    @Inject
    C4410a(SharedPreferences sharedPreferences, MetricsClient metricsClient, C4414a aVar) {
        this.f1151a = sharedPreferences;
        this.f1152b = metricsClient;
        this.f1153c = aVar;
    }

    public final void publishMetrics(List<OpMetric> list, final MetricPublisher.PublishCallback publishCallback) {
        MetricsClient metricsClient = this.f1152b;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (OpMetric next : list) {
            if (next.counter_metric != null) {
                arrayList.add(next.counter_metric);
            } else if (next.timer_metric != null) {
                arrayList2.add(next.timer_metric);
            } else if (next.level_metric != null) {
                arrayList3.add(next.level_metric);
            }
        }
        metricsClient.postOperationalMetrics(new Metrics.Builder().counters(arrayList).timers(arrayList2).levels(arrayList3).build()).enqueue(new Callback<Void>() {
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

    public final void persistMetrics(List<C4426c<OpMetric>> list) {
        this.f1151a.edit().putString("unsent_operational_metrics", this.f1153c.mo61350a(list)).apply();
    }

    public final List<C4426c<OpMetric>> getPersistedEvents() {
        return this.f1153c.mo61351a(OpMetric.ADAPTER, this.f1151a.getString("unsent_operational_metrics", (String) null));
    }
}
