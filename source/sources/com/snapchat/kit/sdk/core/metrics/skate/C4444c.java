package com.snapchat.kit.sdk.core.metrics.skate;

import com.snapchat.kit.sdk.C4475d;
import com.snapchat.kit.sdk.core.config.C4391f;
import com.snapchat.kit.sdk.core.config.ServerSampleRateCallback;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.model.LoginRoute;
import com.snapchat.kit.sdk.core.metrics.model.SkateEvent;
import com.snapchat.kit.sdk.core.metrics.model.SnapKitInitType;
import com.snapchat.kit.sdk.core.models.Skate;
import com.snapchat.kit.sdk.core.models.SkateDate;
import com.snapchat.kit.sdk.util.ZonedDateUtils;
import java.util.Date;
import java.util.TimeZone;
import javax.inject.Inject;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.metrics.skate.c */
public final class C4444c {

    /* renamed from: a */
    private final C4391f f1229a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C4446d f1230b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MetricQueue<SkateEvent> f1231c;

    /* renamed from: d */
    private final ZonedDateUtils f1232d;

    /* renamed from: e */
    private final C4475d f1233e;

    /* renamed from: f */
    private final SnapKitInitType f1234f;

    @Inject
    public C4444c(C4391f fVar, C4446d dVar, MetricQueue<SkateEvent> metricQueue, C4475d dVar2, SnapKitInitType snapKitInitType) {
        this(fVar, dVar, metricQueue, dVar2, new ZonedDateUtils(TimeZone.getTimeZone("GMT-8")), snapKitInitType);
    }

    private C4444c(C4391f fVar, C4446d dVar, MetricQueue<SkateEvent> metricQueue, C4475d dVar2, ZonedDateUtils zonedDateUtils, SnapKitInitType snapKitInitType) {
        this.f1229a = fVar;
        this.f1230b = dVar;
        this.f1231c = metricQueue;
        this.f1233e = dVar2;
        this.f1232d = zonedDateUtils;
        this.f1234f = snapKitInitType;
    }

    /* renamed from: a */
    public final void mo61661a(Date date) {
        final Skate skate;
        final Skate a = this.f1230b.mo61662a();
        SkateDate skateDate = new SkateDate(this.f1232d.mo61835a(date), this.f1232d.mo61836b(date), this.f1232d.mo61837c(date));
        if (a == null || !skateDate.isSameDate(a.mDate)) {
            skate = new Skate(skateDate, 1);
        } else {
            a.incrementCount();
            skate = a;
        }
        this.f1230b.mo61663a(skate);
        this.f1229a.mo61309a((ServerSampleRateCallback) new ServerSampleRateCallback() {
            public final void onServerSampleRateFailure() {
            }

            public final void onServerSampleRateAvailable(double d) {
                if (d > C4444c.this.f1230b.mo61665c()) {
                    C4444c.this.f1231c.push(C4444c.m897a(C4444c.this, a, skate, d));
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ SkateEvent m897a(C4444c cVar, Skate skate, Skate skate2, double d) {
        SkateDate skateDate = skate2.mDate;
        SkateEvent.Builder snap_kit_init_type = new SkateEvent.Builder().daily_session_bucket(skate2.getDailySessionBucket()).day(Long.valueOf(skateDate.mDay)).month(Long.valueOf(skateDate.mMonth)).year(Long.valueOf(skateDate.mYear)).is_first_within_month(Boolean.valueOf(skate == null || !skate.mDate.isSameMonth(skateDate))).sample_rate(Double.valueOf(d)).snap_kit_init_type(cVar.f1234f);
        String b = cVar.f1230b.mo61664b();
        if (b != null) {
            snap_kit_init_type.kit_variants_string_list(b);
        }
        if (cVar.f1233e.isUserLoggedIn()) {
            snap_kit_init_type.login_route(LoginRoute.LOGIN_ROUTE);
        }
        return snap_kit_init_type.build();
    }
}
