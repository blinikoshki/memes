package com.snapchat.kit.sdk.p041a;

import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.OpMetricFactory;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import dagger.Lazy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.ClassUtils;

/* renamed from: com.snapchat.kit.sdk.a.a */
public final class C4381a {

    /* renamed from: a */
    private final Lazy<MetricQueue<OpMetric>> f1060a;

    /* renamed from: b */
    private final Map<C4382a, Long> f1061b = new ConcurrentHashMap();

    /* renamed from: com.snapchat.kit.sdk.a.a$a */
    public enum C4382a {
        REVOKE,
        REFRESH,
        GRANT
    }

    public C4381a(Lazy<MetricQueue<OpMetric>> lazy) {
        this.f1060a = lazy;
    }

    /* renamed from: a */
    public final synchronized void mo61301a(String str) {
        this.f1060a.get().push(OpMetricFactory.createCount(m819b(str), 1));
    }

    /* renamed from: a */
    public final synchronized void mo61299a(C4382a aVar) {
        this.f1060a.get().push(OpMetricFactory.createCount(m819b(aVar.toString().toLowerCase() + "TokenRequest"), 1));
        this.f1061b.put(aVar, Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0043, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo61300a(com.snapchat.kit.sdk.p041a.C4381a.C4382a r6, boolean r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            dagger.Lazy<com.snapchat.kit.sdk.core.metrics.MetricQueue<com.snapchat.kit.sdk.core.metrics.model.OpMetric>> r0 = r5.f1060a     // Catch:{ all -> 0x006c }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x006c }
            com.snapchat.kit.sdk.core.metrics.MetricQueue r0 = (com.snapchat.kit.sdk.core.metrics.MetricQueue) r0     // Catch:{ all -> 0x006c }
            if (r7 == 0) goto L_0x0044
            java.util.Map<com.snapchat.kit.sdk.a.a$a, java.lang.Long> r7 = r5.f1061b     // Catch:{ all -> 0x006c }
            java.lang.Object r7 = r7.remove(r6)     // Catch:{ all -> 0x006c }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x006c }
            if (r7 == 0) goto L_0x0042
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ all -> 0x006c }
            r1.append(r6)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = "TokenLatency"
            r1.append(r6)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x006c }
            java.lang.String r6 = m819b(r6)     // Catch:{ all -> 0x006c }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x006c }
            long r3 = r7.longValue()     // Catch:{ all -> 0x006c }
            long r1 = r1 - r3
            com.snapchat.kit.sdk.core.metrics.model.OpMetric r6 = com.snapchat.kit.sdk.core.metrics.OpMetricFactory.createTimer(r6, r1)     // Catch:{ all -> 0x006c }
            r0.push(r6)     // Catch:{ all -> 0x006c }
        L_0x0042:
            monitor-exit(r5)
            return
        L_0x0044:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r7.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ all -> 0x006c }
            r7.append(r6)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = "TokenFailure"
            r7.append(r6)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x006c }
            java.lang.String r6 = m819b(r6)     // Catch:{ all -> 0x006c }
            r1 = 1
            com.snapchat.kit.sdk.core.metrics.model.OpMetric r6 = com.snapchat.kit.sdk.core.metrics.OpMetricFactory.createCount(r6, r1)     // Catch:{ all -> 0x006c }
            r0.push(r6)     // Catch:{ all -> 0x006c }
            monitor-exit(r5)
            return
        L_0x006c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snapchat.kit.sdk.p041a.C4381a.mo61300a(com.snapchat.kit.sdk.a.a$a, boolean):void");
    }

    /* renamed from: b */
    private static String m819b(String str) {
        return String.format("%s:login:%s", new Object[]{"1.6.8".replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '_'), str});
    }
}
