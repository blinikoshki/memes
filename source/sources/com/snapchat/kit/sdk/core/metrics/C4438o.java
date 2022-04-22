package com.snapchat.kit.sdk.core.metrics;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Debug;
import com.snap.kit.common.model.DeviceEnvironmentInfo;
import com.snap.kit.common.model.OsType;
import com.snap.kit.common.model.Types;
import com.snap.kit.sdk.model.SnapKitStorySnapView;
import com.snap.kit.sdk.model.SnapKitStorySnapViews;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.MetricPublisher;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Named;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.metrics.o */
public final class C4438o implements MetricPublisher<SnapKitStorySnapView> {

    /* renamed from: a */
    private final SharedPreferences f1207a;

    /* renamed from: b */
    private final MetricsClient f1208b;

    /* renamed from: c */
    private final C4414a f1209c;

    /* renamed from: d */
    private final String f1210d;

    @Inject
    C4438o(SharedPreferences sharedPreferences, MetricsClient metricsClient, C4414a aVar, @Named("client_id") String str) {
        this.f1207a = sharedPreferences;
        this.f1208b = metricsClient;
        this.f1209c = aVar;
        this.f1210d = str;
    }

    public final void publishMetrics(List<SnapKitStorySnapView> list, final MetricPublisher.PublishCallback publishCallback) {
        MetricsClient metricsClient = this.f1208b;
        SnapKitStorySnapViews.Builder views = new SnapKitStorySnapViews.Builder().views(list);
        String str = "";
        DeviceEnvironmentInfo.Builder target_architecture = new DeviceEnvironmentInfo.Builder().os_type(OsType.Enum.ANDROID).os_version(Build.VERSION.RELEASE == null ? str : Build.VERSION.RELEASE).model(Build.MODEL).target_architecture(System.getProperty("os.arch"));
        Locale locale = Locale.getDefault();
        if (locale != null) {
            str = locale.toString();
        }
        metricsClient.postViewEvents(views.device_environment_info(target_architecture.locale(str).running_with_debugger_attached(Debug.isDebuggerConnected() ? Types.Trilean.TRUE : Types.Trilean.FALSE).running_in_tests(Types.Trilean.NONE).running_in_simulator(Types.Trilean.NONE).is_app_prerelease(Types.Trilean.NONE).build()).client_id(this.f1210d).build()).enqueue(new Callback<Void>() {
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

    public final void persistMetrics(List<C4426c<SnapKitStorySnapView>> list) {
        this.f1207a.edit().putString("unsent_snap_view_events", this.f1209c.mo61350a(list)).apply();
    }

    public final List<C4426c<SnapKitStorySnapView>> getPersistedEvents() {
        return this.f1209c.mo61351a(SnapKitStorySnapView.ADAPTER, this.f1207a.getString("unsent_snap_view_events", (String) null));
    }
}
