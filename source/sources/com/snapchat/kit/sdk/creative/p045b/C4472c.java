package com.snapchat.kit.sdk.creative.p045b;

import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.OpMetricFactory;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.creative.dagger.scope.CreativeScope;
import javax.inject.Inject;
import org.apache.commons.lang3.ClassUtils;

@CreativeScope
/* renamed from: com.snapchat.kit.sdk.creative.b.c */
public final class C4472c {

    /* renamed from: a */
    private static final String f1278a = "1.6.8".replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '_');

    /* renamed from: b */
    private final MetricQueue<OpMetric> f1279b;

    @Inject
    public C4472c(MetricQueue<OpMetric> metricQueue) {
        this.f1279b = metricQueue;
    }

    /* renamed from: a */
    public final synchronized void mo61749a(String str) {
        this.f1279b.push(OpMetricFactory.createCount(m926b(str), 1));
    }

    /* renamed from: a */
    public final synchronized void mo61750a(String str, long j) {
        this.f1279b.push(OpMetricFactory.createTimer(m926b(str), j));
    }

    /* renamed from: b */
    private static String m926b(String str) {
        return String.format("%s:creative:%s", new Object[]{f1278a, str});
    }
}
