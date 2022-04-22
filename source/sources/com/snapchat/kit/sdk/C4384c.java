package com.snapchat.kit.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.google.gson.Gson;
import com.snap.kit.sdk.model.SnapKitStorySnapView;
import com.snapchat.kit.sdk.core.config.C4391f;
import com.snapchat.kit.sdk.core.config.C4395g;
import com.snapchat.kit.sdk.core.config.ConfigClient;
import com.snapchat.kit.sdk.core.controller.C4396a;
import com.snapchat.kit.sdk.core.controller.C4401b;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.metrics.C4402a;
import com.snapchat.kit.sdk.core.metrics.C4428e;
import com.snapchat.kit.sdk.core.metrics.C4429f;
import com.snapchat.kit.sdk.core.metrics.C4430g;
import com.snapchat.kit.sdk.core.metrics.C4431h;
import com.snapchat.kit.sdk.core.metrics.C4432i;
import com.snapchat.kit.sdk.core.metrics.C4433j;
import com.snapchat.kit.sdk.core.metrics.C4434k;
import com.snapchat.kit.sdk.core.metrics.C4435l;
import com.snapchat.kit.sdk.core.metrics.C4436m;
import com.snapchat.kit.sdk.core.metrics.C4437n;
import com.snapchat.kit.sdk.core.metrics.C4438o;
import com.snapchat.kit.sdk.core.metrics.C4440p;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.MetricsClient;
import com.snapchat.kit.sdk.core.metrics.business.C4417a;
import com.snapchat.kit.sdk.core.metrics.business.C4419b;
import com.snapchat.kit.sdk.core.metrics.business.C4420c;
import com.snapchat.kit.sdk.core.metrics.business.C4421d;
import com.snapchat.kit.sdk.core.metrics.business.C4422e;
import com.snapchat.kit.sdk.core.metrics.business.C4423f;
import com.snapchat.kit.sdk.core.metrics.business.C4424g;
import com.snapchat.kit.sdk.core.metrics.business.C4425h;
import com.snapchat.kit.sdk.core.metrics.business.KitEventBaseFactory;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.metrics.model.SkateEvent;
import com.snapchat.kit.sdk.core.metrics.model.SnapKitInitType;
import com.snapchat.kit.sdk.core.metrics.p042a.C4410a;
import com.snapchat.kit.sdk.core.metrics.p042a.C4412b;
import com.snapchat.kit.sdk.core.metrics.p043b.C4414a;
import com.snapchat.kit.sdk.core.metrics.p043b.C4416b;
import com.snapchat.kit.sdk.core.metrics.skate.C4441a;
import com.snapchat.kit.sdk.core.metrics.skate.C4443b;
import com.snapchat.kit.sdk.core.metrics.skate.C4444c;
import com.snapchat.kit.sdk.core.metrics.skate.C4446d;
import com.snapchat.kit.sdk.core.metrics.skate.C4447e;
import com.snapchat.kit.sdk.core.metrics.skate.SkateClient;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import com.snapchat.kit.sdk.core.networking.C4448a;
import com.snapchat.kit.sdk.core.networking.C4449b;
import com.snapchat.kit.sdk.core.networking.C4450c;
import com.snapchat.kit.sdk.core.networking.C4452e;
import com.snapchat.kit.sdk.core.networking.C4454f;
import com.snapchat.kit.sdk.core.networking.C4455g;
import com.snapchat.kit.sdk.core.networking.C4456h;
import com.snapchat.kit.sdk.core.networking.ClientFactory;
import com.snapchat.kit.sdk.core.security.Fingerprint;
import com.snapchat.kit.sdk.core.security.Fingerprint_Factory;
import com.snapchat.kit.sdk.core.security.SecureSharedPreferences;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* renamed from: com.snapchat.kit.sdk.c */
public final class C4384c implements SnapKitComponent {

    /* renamed from: A */
    private Provider<C4475d> f1065A;

    /* renamed from: B */
    private C4488g f1066B;

    /* renamed from: C */
    private Provider<C4438o> f1067C;

    /* renamed from: D */
    private Provider<ConfigClient> f1068D;

    /* renamed from: E */
    private Provider<C4391f> f1069E;

    /* renamed from: F */
    private Provider<Random> f1070F;

    /* renamed from: G */
    private Provider<C4446d> f1071G;

    /* renamed from: H */
    private Provider<SkateClient> f1072H;

    /* renamed from: I */
    private Provider<C4441a> f1073I;

    /* renamed from: J */
    private Provider<MetricQueue<SkateEvent>> f1074J;

    /* renamed from: K */
    private Provider<SnapKitInitType> f1075K;

    /* renamed from: L */
    private Provider<C4444c> f1076L;

    /* renamed from: M */
    private Provider<SnapKitAppLifecycleObserver> f1077M;

    /* renamed from: a */
    private Provider<Context> f1078a;

    /* renamed from: b */
    private Provider<Gson> f1079b;

    /* renamed from: c */
    private Provider<SharedPreferences> f1080c;

    /* renamed from: d */
    private Provider<SecureSharedPreferences> f1081d;

    /* renamed from: e */
    private Provider<Handler> f1082e;

    /* renamed from: f */
    private Provider<C4396a> f1083f;

    /* renamed from: g */
    private Provider<OkHttpClient> f1084g;

    /* renamed from: h */
    private Provider<C4425h> f1085h;

    /* renamed from: i */
    private Provider<Cache> f1086i;

    /* renamed from: j */
    private Provider<String> f1087j;

    /* renamed from: k */
    private Provider<Fingerprint> f1088k;

    /* renamed from: l */
    private Provider<C4448a> f1089l;

    /* renamed from: m */
    private Provider<C4452e> f1090m;

    /* renamed from: n */
    private Provider<C4455g> f1091n;

    /* renamed from: o */
    private Provider<ClientFactory> f1092o;

    /* renamed from: p */
    private Provider<MetricsClient> f1093p;

    /* renamed from: q */
    private Provider<C4414a> f1094q;

    /* renamed from: r */
    private Provider<C4417a> f1095r;

    /* renamed from: s */
    private Provider<ScheduledExecutorService> f1096s;

    /* renamed from: t */
    private Provider f1097t;

    /* renamed from: u */
    private Provider<C4402a<ServerEvent>> f1098u;

    /* renamed from: v */
    private Provider<C4420c> f1099v;

    /* renamed from: w */
    private Provider<KitEventBaseFactory> f1100w;

    /* renamed from: x */
    private Provider<C4422e> f1101x;

    /* renamed from: y */
    private Provider<C4410a> f1102y;

    /* renamed from: z */
    private Provider<MetricQueue<OpMetric>> f1103z;

    /* synthetic */ C4384c(C4385a aVar, byte b) {
        this(aVar);
    }

    private C4384c(C4385a aVar) {
        this.f1078a = DoubleCheck.provider(C4491j.m970a(aVar.f1104a));
        this.f1079b = DoubleCheck.provider(C4492k.m971a(aVar.f1104a));
        this.f1080c = DoubleCheck.provider(C4519p.m993a(aVar.f1104a));
        this.f1081d = DoubleCheck.provider(C4518o.m992a(aVar.f1104a, this.f1079b, this.f1080c));
        Factory<Handler> a = C4523u.m997a(aVar.f1104a);
        this.f1082e = a;
        this.f1083f = DoubleCheck.provider(C4401b.m847a(a));
        this.f1084g = DoubleCheck.provider(C4516m.m990a(aVar.f1104a));
        this.f1085h = C4436m.m892a(this.f1080c);
        this.f1086i = DoubleCheck.provider(C4489h.m968a(aVar.f1104a));
        this.f1065A = new DelegateFactory();
        this.f1087j = C4490i.m969a(aVar.f1104a);
        Factory<Fingerprint> create = Fingerprint_Factory.create(this.f1078a);
        this.f1088k = create;
        this.f1089l = C4449b.m910a(this.f1065A, this.f1083f, this.f1087j, create);
        this.f1090m = C4454f.m913a(this.f1065A, this.f1083f, this.f1087j);
        Factory<C4455g> a2 = C4456h.m915a(this.f1087j, this.f1088k);
        this.f1091n = a2;
        Provider<ClientFactory> provider = DoubleCheck.provider(C4450c.m911a(this.f1086i, this.f1079b, this.f1089l, this.f1090m, a2));
        this.f1092o = provider;
        this.f1093p = DoubleCheck.provider(C4432i.m888a(provider));
        Factory<C4414a> a3 = C4416b.m867a(this.f1079b);
        this.f1094q = a3;
        this.f1095r = DoubleCheck.provider(C4419b.m868a(this.f1080c, this.f1085h, this.f1093p, a3));
        Provider<ScheduledExecutorService> provider2 = DoubleCheck.provider(C4435l.m891a());
        this.f1096s = provider2;
        Provider<C4413b> provider3 = DoubleCheck.provider(C4433j.m889a(this.f1078a, provider2));
        this.f1097t = provider3;
        Factory<C4402a<ServerEvent>> a4 = C4428e.m884a(this.f1095r, this.f1096s, provider3);
        this.f1098u = a4;
        this.f1099v = DoubleCheck.provider(C4421d.m869a(this.f1085h, a4));
        Factory<KitEventBaseFactory> a5 = C4424g.m876a(this.f1087j);
        this.f1100w = a5;
        this.f1101x = C4423f.m874a(a5);
        Provider<C4410a> provider4 = DoubleCheck.provider(C4412b.m861a(this.f1080c, this.f1093p, this.f1094q));
        this.f1102y = provider4;
        this.f1103z = DoubleCheck.provider(C4434k.m890a(provider4, this.f1096s, this.f1097t));
        Provider<C4475d> provider5 = DoubleCheck.provider(C4493l.m972a(aVar.f1104a, this.f1081d, this.f1083f, this.f1084g, this.f1079b, this.f1099v, this.f1101x, this.f1103z));
        this.f1065A = provider5;
        ((DelegateFactory) this.f1065A).setDelegatedProvider(provider5);
        this.f1066B = aVar.f1104a;
        this.f1067C = DoubleCheck.provider(C4440p.m894a(this.f1080c, this.f1093p, this.f1094q, this.f1087j));
        Provider<ConfigClient> provider6 = DoubleCheck.provider(C4429f.m885a(this.f1092o));
        this.f1068D = provider6;
        this.f1069E = DoubleCheck.provider(C4395g.m840a(provider6, this.f1080c));
        Factory<Random> a6 = C4517n.m991a(aVar.f1104a);
        this.f1070F = a6;
        this.f1071G = C4447e.m907a(this.f1080c, a6);
        Provider<SkateClient> provider7 = DoubleCheck.provider(C4437n.m893a(this.f1092o));
        this.f1072H = provider7;
        Provider<C4441a> provider8 = DoubleCheck.provider(C4443b.m896a(this.f1069E, this.f1080c, this.f1085h, provider7, this.f1094q));
        this.f1073I = provider8;
        this.f1074J = DoubleCheck.provider(C4430g.m886a(provider8, this.f1096s, this.f1097t));
        this.f1075K = C4522t.m996a(aVar.f1104a);
        this.f1076L = DoubleCheck.provider(C4520q.m994a(aVar.f1104a, this.f1069E, this.f1071G, this.f1074J, this.f1065A, this.f1075K));
        this.f1077M = DoubleCheck.provider(C4521s.m995a(aVar.f1104a, this.f1076L));
    }

    /* renamed from: a */
    public static C4385a m827a() {
        return new C4385a((byte) 0);
    }

    public final Context context() {
        return this.f1078a.get();
    }

    public final Gson gson() {
        return this.f1079b.get();
    }

    public final AuthTokenManager authTokenManager() {
        return (AuthTokenManager) Preconditions.checkNotNull(C4488g.m955a(this.f1065A.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final MetricQueue<ServerEvent> analyticsEventQueue() {
        return this.f1099v.get();
    }

    public final MetricQueue<OpMetric> operationalMetricsQueue() {
        return this.f1103z.get();
    }

    public final MetricQueue<SnapKitStorySnapView> snapViewEventQueue() {
        return (MetricQueue) Preconditions.checkNotNull(C4431h.m887a(this.f1067C.get(), this.f1096s.get(), this.f1097t.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final ClientFactory apiFactory() {
        return this.f1092o.get();
    }

    public final SharedPreferences sharedPreferences() {
        return this.f1080c.get();
    }

    public final SnapKitAppLifecycleObserver snapKitAppLifecycleObserver() {
        return this.f1077M.get();
    }

    public final LoginStateController logoutController() {
        return (LoginStateController) Preconditions.checkNotNull(C4488g.m953a(this.f1083f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final KitEventBaseFactory kitEventBaseFactory() {
        return C4424g.m875a(clientId());
    }

    public final String clientId() {
        return (String) Preconditions.checkNotNull(this.f1066B.mo61802c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final String redirectUrl() {
        return (String) Preconditions.checkNotNull(this.f1066B.mo61803d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: com.snapchat.kit.sdk.c$a */
    public static final class C4385a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public C4488g f1104a;

        /* synthetic */ C4385a(byte b) {
            this();
        }

        private C4385a() {
        }

        /* renamed from: a */
        public final SnapKitComponent mo61302a() {
            if (this.f1104a != null) {
                return new C4384c(this, (byte) 0);
            }
            throw new IllegalStateException(C4488g.class.getCanonicalName() + " must be set");
        }

        /* renamed from: a */
        public final C4385a mo61303a(C4488g gVar) {
            this.f1104a = (C4488g) Preconditions.checkNotNull(gVar);
            return this;
        }
    }

    public final void inject(SnapKitActivity snapKitActivity) {
        C4487f.m951a(snapKitActivity, this.f1065A.get());
    }

    public final void inject(SnapCFSActivity snapCFSActivity) {
        C4486e.m950a(snapCFSActivity, this.f1065A.get());
        C4486e.m949a(snapCFSActivity, logoutController());
    }
}
