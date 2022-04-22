package com.snapchat.kit.sdk.core.metrics;

import com.snap.kit.sdk.model.SnapKitStorySnapView;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Named;

@Module
/* renamed from: com.snapchat.kit.sdk.core.metrics.d */
public abstract class C4427d {
    @Provides
    /* renamed from: a */
    static MetricQueue<SnapKitStorySnapView> m883a(C4438o oVar, @Named("metrics_serial_executor") ScheduledExecutorService scheduledExecutorService, C4413b bVar) {
        C4402a aVar = new C4402a(oVar, scheduledExecutorService, bVar, 10);
        aVar.mo61333a();
        return aVar;
    }
}
