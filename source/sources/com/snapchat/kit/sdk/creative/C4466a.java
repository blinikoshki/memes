package com.snapchat.kit.sdk.creative;

import android.content.Context;
import com.snapchat.kit.sdk.SnapKitComponent;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.business.KitEventBaseFactory;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.creative.api.SnapCreativeKitApi;
import com.snapchat.kit.sdk.creative.api.SnapCreativeKitApi_Factory;
import com.snapchat.kit.sdk.creative.media.SnapMediaFactory;
import com.snapchat.kit.sdk.creative.media.SnapMediaFactory_Factory;
import com.snapchat.kit.sdk.creative.p045b.C4471b;
import com.snapchat.kit.sdk.creative.p045b.C4472c;
import com.snapchat.kit.sdk.creative.p045b.C4473d;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.creative.a */
public final class C4466a implements CreativeComponent {

    /* renamed from: a */
    private SnapKitComponent f1269a;

    /* renamed from: b */
    private Provider<MetricQueue<OpMetric>> f1270b;

    /* renamed from: c */
    private Provider<C4472c> f1271c;

    /* synthetic */ C4466a(C4467a aVar, byte b) {
        this(aVar);
    }

    private C4466a(C4467a aVar) {
        this.f1269a = aVar.f1272a;
        C4468b bVar = new C4468b(aVar.f1272a);
        this.f1270b = bVar;
        this.f1271c = DoubleCheck.provider(C4473d.m929a(bVar));
    }

    /* renamed from: a */
    public static C4467a m919a() {
        return new C4467a((byte) 0);
    }

    public final SnapCreativeKitApi getApi() {
        return SnapCreativeKitApi_Factory.newSnapCreativeKitApi((Context) Preconditions.checkNotNull(this.f1269a.context(), "Cannot return null from a non-@Nullable component method"), (String) Preconditions.checkNotNull(this.f1269a.clientId(), "Cannot return null from a non-@Nullable component method"), (String) Preconditions.checkNotNull(this.f1269a.redirectUrl(), "Cannot return null from a non-@Nullable component method"), this.f1271c.get(), (MetricQueue) Preconditions.checkNotNull(this.f1269a.analyticsEventQueue(), "Cannot return null from a non-@Nullable component method"), C4471b.m925a((KitEventBaseFactory) Preconditions.checkNotNull(this.f1269a.kitEventBaseFactory(), "Cannot return null from a non-@Nullable component method")));
    }

    public final SnapMediaFactory getMediaFactory() {
        return SnapMediaFactory_Factory.newSnapMediaFactory(this.f1271c.get());
    }

    /* renamed from: com.snapchat.kit.sdk.creative.a$a */
    public static final class C4467a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public SnapKitComponent f1272a;

        /* synthetic */ C4467a(byte b) {
            this();
        }

        private C4467a() {
        }

        /* renamed from: a */
        public final CreativeComponent mo61741a() {
            if (this.f1272a != null) {
                return new C4466a(this, (byte) 0);
            }
            throw new IllegalStateException(SnapKitComponent.class.getCanonicalName() + " must be set");
        }

        /* renamed from: a */
        public final C4467a mo61742a(SnapKitComponent snapKitComponent) {
            this.f1272a = (SnapKitComponent) Preconditions.checkNotNull(snapKitComponent);
            return this;
        }
    }

    /* renamed from: com.snapchat.kit.sdk.creative.a$b */
    private static class C4468b implements Provider<MetricQueue<OpMetric>> {

        /* renamed from: a */
        private final SnapKitComponent f1273a;

        C4468b(SnapKitComponent snapKitComponent) {
            this.f1273a = snapKitComponent;
        }

        public final /* synthetic */ Object get() {
            return (MetricQueue) Preconditions.checkNotNull(this.f1273a.operationalMetricsQueue(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
