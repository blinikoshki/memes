package com.snapchat.kit.sdk.core.metrics.skate;

import android.content.SharedPreferences;
import com.snap.kit.sdk.model.MetricSampleRate;
import com.snapchat.kit.sdk.core.config.C4391f;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.C4426c;
import com.snapchat.kit.sdk.core.metrics.MetricPublisher;
import com.snapchat.kit.sdk.core.metrics.business.C4425h;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.metrics.model.ServerEventBatch;
import com.snapchat.kit.sdk.core.metrics.model.ServerEventData;
import com.snapchat.kit.sdk.core.metrics.model.SkateEvent;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.metrics.skate.a */
public final class C4441a implements MetricPublisher<SkateEvent> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C4391f f1217a;

    /* renamed from: b */
    private final SharedPreferences f1218b;

    /* renamed from: c */
    private final C4425h f1219c;

    /* renamed from: d */
    private final SkateClient f1220d;

    /* renamed from: e */
    private final C4414a f1221e;

    @Inject
    C4441a(C4391f fVar, SharedPreferences sharedPreferences, C4425h hVar, SkateClient skateClient, C4414a aVar) {
        this.f1217a = fVar;
        this.f1218b = sharedPreferences;
        this.f1219c = hVar;
        this.f1220d = skateClient;
        this.f1221e = aVar;
    }

    public final void persistMetrics(List<C4426c<SkateEvent>> list) {
        this.f1218b.edit().putString("com.snapchat.kit.sdk.core.metrics.skate.unsentSkateEvents", this.f1221e.mo61350a(list)).apply();
    }

    public final List<C4426c<SkateEvent>> getPersistedEvents() {
        try {
            return this.f1221e.mo61351a(SkateEvent.ADAPTER, this.f1218b.getString("com.snapchat.kit.sdk.core.metrics.skate.unsentSkateEvents", (String) null));
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void publishMetrics(List<SkateEvent> list, final MetricPublisher.PublishCallback publishCallback) {
        ArrayList arrayList = new ArrayList();
        for (SkateEvent skate_event : list) {
            arrayList.add(new ServerEvent.Builder().event_data(new ServerEventData.Builder().skate_event(skate_event).build()).build());
        }
        this.f1220d.postSkateEvents(new ServerEventBatch.Builder().server_events(arrayList).max_sequence_id_on_instance(Long.valueOf(this.f1219c.mo61359c())).build()).enqueue(new Callback<MetricSampleRate>() {
            public final void onResponse(Call<MetricSampleRate> call, Response<MetricSampleRate> response) {
                try {
                    if (response.isSuccessful()) {
                        MetricSampleRate body = response.body();
                        if (!(body == null || body.rate == null)) {
                            C4441a.this.f1217a.mo61308a(body.rate.doubleValue());
                        }
                        publishCallback.onSuccess();
                        return;
                    }
                    publishCallback.onServerError(new Error(response.errorBody().string()));
                } catch (IOException | NullPointerException unused) {
                    publishCallback.onServerError(new Error("response unsuccessful"));
                }
            }

            public final void onFailure(Call<MetricSampleRate> call, Throwable th) {
                if (th instanceof IOException) {
                    publishCallback.onNetworkError();
                } else {
                    publishCallback.onServerError(new Error(th));
                }
            }
        });
    }
}
