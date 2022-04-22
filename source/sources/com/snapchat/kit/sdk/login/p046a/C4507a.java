package com.snapchat.kit.sdk.login.p046a;

import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.OpMetricFactory;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import javax.inject.Inject;
import org.apache.commons.lang3.ClassUtils;

/* renamed from: com.snapchat.kit.sdk.login.a.a */
public final class C4507a {

    /* renamed from: a */
    private static final String f1375a = "1.6.8".replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '_');

    /* renamed from: b */
    private final MetricQueue<OpMetric> f1376b;

    @Inject
    public C4507a(MetricQueue<OpMetric> metricQueue) {
        this.f1376b = metricQueue;
    }

    /* renamed from: a */
    public final synchronized void mo61811a(String str) {
        this.f1376b.push(OpMetricFactory.createCount(m978b(str), 1));
    }

    /* renamed from: a */
    public final synchronized void mo61812a(String str, long j) {
        this.f1376b.push(OpMetricFactory.createTimer(m978b(str), j));
    }

    /* renamed from: b */
    private static String m978b(String str) {
        return String.format("%s:login:%s", new Object[]{f1375a, str});
    }
}
