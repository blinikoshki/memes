package com.snapchat.kit.sdk.core.metrics;

import com.snapchat.kit.sdk.core.metrics.model.CounterMetric;
import com.snapchat.kit.sdk.core.metrics.model.LevelMetric;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.model.TimerMetric;
import com.snapchat.kit.sdk.core.metrics.model.Timestamp;
import java.util.concurrent.TimeUnit;

public class OpMetricFactory {

    /* renamed from: a */
    private static final long f1131a = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b */
    private static final int f1132b = ((int) TimeUnit.MILLISECONDS.toNanos(1));

    public static OpMetric createCount(String str, long j) {
        return new OpMetric.Builder().counter_metric(new CounterMetric.Builder().name(str).count(Long.valueOf(j)).timestamp(m848a()).build()).build();
    }

    public static OpMetric createTimer(String str, long j) {
        return new OpMetric.Builder().timer_metric(new TimerMetric.Builder().name(str).latency_millis(Long.valueOf(j)).timestamp(m848a()).build()).build();
    }

    public static OpMetric createLevel(String str, long j) {
        return new OpMetric.Builder().level_metric(new LevelMetric.Builder().name(str).level(Long.valueOf(j)).timestamp(m848a()).build()).build();
    }

    /* renamed from: a */
    private static Timestamp m848a() {
        long currentTimeMillis = System.currentTimeMillis();
        Timestamp.Builder builder = new Timestamp.Builder();
        long j = f1131a;
        return builder.seconds(Long.valueOf(currentTimeMillis / j)).nanos(Integer.valueOf(((int) (currentTimeMillis % j)) * f1132b)).build();
    }
}
