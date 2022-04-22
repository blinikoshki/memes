package com.snapchat.kit.sdk.core.metrics;

import com.snapchat.kit.sdk.core.metrics.MetricPublisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.snapchat.kit.sdk.core.metrics.a */
public final class C4402a<T> implements MetricQueue<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final MetricPublisher<T> f1133a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ScheduledExecutorService f1134b;

    /* renamed from: c */
    private final C4413b f1135c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final LinkedHashSet<C4426c<T>> f1136d = new LinkedHashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final LinkedHashSet<C4426c<T>> f1137e = new LinkedHashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final AtomicReference<Future<?>> f1138f = new AtomicReference<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final int f1139g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Runnable f1140h = new Runnable() {
        public final void run() {
            C4402a.this.mo61334b();
        }
    };

    C4402a(MetricPublisher<T> metricPublisher, ScheduledExecutorService scheduledExecutorService, C4413b bVar, int i) {
        this.f1133a = metricPublisher;
        this.f1134b = scheduledExecutorService;
        this.f1139g = i;
        this.f1135c = bVar;
    }

    /* renamed from: a */
    public final void mo61333a() {
        this.f1134b.execute(new Runnable() {
            public final void run() {
                List persistedEvents = C4402a.this.f1133a.getPersistedEvents();
                if (persistedEvents != null && !persistedEvents.isEmpty()) {
                    C4402a.this.f1136d.addAll(persistedEvents);
                    C4402a.this.f1138f.set(C4402a.this.f1134b.schedule(C4402a.this.f1140h, 1000, TimeUnit.MILLISECONDS));
                }
            }
        });
        this.f1135c.mo61342a(this);
    }

    public final void push(final T t) {
        this.f1134b.execute(new Runnable() {
            public final void run() {
                C4402a.this.f1136d.add(new C4426c(t));
                C4402a.m855f(C4402a.this);
                if (C4402a.this.f1136d.size() >= C4402a.this.f1139g) {
                    C4402a.this.mo61334b();
                } else if (C4402a.this.f1138f.get() == null) {
                    C4402a.this.f1138f.set(C4402a.this.f1134b.schedule(C4402a.this.f1140h, 30000, TimeUnit.MILLISECONDS));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo61334b() {
        Future andSet = this.f1138f.getAndSet((Object) null);
        if (andSet != null) {
            andSet.cancel(false);
        }
        if (!this.f1136d.isEmpty()) {
            final ArrayList arrayList = new ArrayList(this.f1136d);
            this.f1136d.clear();
            this.f1137e.addAll(arrayList);
            this.f1133a.publishMetrics(m850a(arrayList), new MetricPublisher.PublishCallback() {
                public final void onSuccess() {
                    C4402a.this.f1134b.execute(new Runnable() {
                        public final void run() {
                            C4402a.this.f1137e.removeAll(arrayList);
                            C4402a.m855f(C4402a.this);
                        }
                    });
                }

                public final void onNetworkError() {
                    C4402a.this.f1134b.execute(new Runnable() {
                        public final void run() {
                            C4402a.this.f1137e.removeAll(arrayList);
                            C4402a.this.f1136d.addAll(arrayList);
                        }
                    });
                }

                public final void onServerError(final Error error) {
                    C4402a.this.f1134b.execute(new Runnable() {
                        public final void run() {
                            C4402a.this.f1137e.removeAll(arrayList);
                            for (C4426c cVar : arrayList) {
                                if (cVar.mo61361b() <= 0) {
                                    cVar.mo61360a();
                                    C4402a.this.f1136d.add(cVar);
                                }
                            }
                            C4402a.m855f(C4402a.this);
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Runnable mo61335c() {
        return this.f1140h;
    }

    /* renamed from: a */
    private static <T> List<T> m850a(Collection<C4426c<T>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (C4426c<T> c : collection) {
            arrayList.add(c.mo61362c());
        }
        return arrayList;
    }

    /* renamed from: f */
    static /* synthetic */ void m855f(C4402a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f1136d);
        arrayList.addAll(aVar.f1137e);
        aVar.f1133a.persistMetrics(arrayList);
    }
}
