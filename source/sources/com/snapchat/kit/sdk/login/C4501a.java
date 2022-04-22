package com.snapchat.kit.sdk.login;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.snap.kit.sdk.model.SnapKitStorySnapView;
import com.snapchat.kit.sdk.SnapKitAppLifecycleObserver;
import com.snapchat.kit.sdk.SnapKitComponent;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.business.KitEventBaseFactory;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import com.snapchat.kit.sdk.core.networking.ClientFactory;
import com.snapchat.kit.sdk.login.networking.C4513a;
import com.snapchat.kit.sdk.login.networking.C4515b;
import com.snapchat.kit.sdk.login.networking.LoginClient;
import com.snapchat.kit.sdk.login.p046a.C4507a;
import com.snapchat.kit.sdk.login.p046a.C4508b;
import com.snapchat.kit.sdk.login.p047b.C4510a;
import com.snapchat.kit.sdk.login.p047b.C4511b;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.snapchat.kit.sdk.login.a */
public final class C4501a implements LoginComponent {

    /* renamed from: a */
    private SnapKitComponent f1360a;

    /* renamed from: b */
    private Provider<AuthTokenManager> f1361b;

    /* renamed from: c */
    private Provider<LoginStateController> f1362c;

    /* renamed from: d */
    private Provider<MetricQueue<OpMetric>> f1363d;

    /* renamed from: e */
    private Provider<C4507a> f1364e;

    /* renamed from: f */
    private Provider<C4510a> f1365f;

    /* renamed from: g */
    private Provider<ClientFactory> f1366g;

    /* renamed from: h */
    private Provider<LoginClient> f1367h;

    /* renamed from: i */
    private Provider<C4513a> f1368i;

    /* synthetic */ C4501a(C4502a aVar, byte b) {
        this(aVar);
    }

    private C4501a(C4502a aVar) {
        this.f1360a = aVar.f1370b;
        this.f1361b = new C4504c(aVar.f1370b);
        this.f1362c = new C4505d(aVar.f1370b);
        C4506e eVar = new C4506e(aVar.f1370b);
        this.f1363d = eVar;
        Factory<C4507a> a = C4508b.m981a(eVar);
        this.f1364e = a;
        this.f1365f = DoubleCheck.provider(C4511b.m984a(this.f1361b, this.f1362c, a));
        this.f1366g = new C4503b(aVar.f1370b);
        Provider<LoginClient> provider = DoubleCheck.provider(C4512c.m985a(aVar.f1369a, this.f1366g));
        this.f1367h = provider;
        this.f1368i = DoubleCheck.provider(C4515b.m989a(provider, this.f1364e));
    }

    /* renamed from: a */
    public static C4502a m973a() {
        return new C4502a((byte) 0);
    }

    public final Context context() {
        return (Context) Preconditions.checkNotNull(this.f1360a.context(), "Cannot return null from a non-@Nullable component method");
    }

    public final Gson gson() {
        return (Gson) Preconditions.checkNotNull(this.f1360a.gson(), "Cannot return null from a non-@Nullable component method");
    }

    public final AuthTokenManager authTokenManager() {
        return (AuthTokenManager) Preconditions.checkNotNull(this.f1360a.authTokenManager(), "Cannot return null from a non-@Nullable component method");
    }

    public final MetricQueue<ServerEvent> analyticsEventQueue() {
        return (MetricQueue) Preconditions.checkNotNull(this.f1360a.analyticsEventQueue(), "Cannot return null from a non-@Nullable component method");
    }

    public final MetricQueue<OpMetric> operationalMetricsQueue() {
        return (MetricQueue) Preconditions.checkNotNull(this.f1360a.operationalMetricsQueue(), "Cannot return null from a non-@Nullable component method");
    }

    public final MetricQueue<SnapKitStorySnapView> snapViewEventQueue() {
        return (MetricQueue) Preconditions.checkNotNull(this.f1360a.snapViewEventQueue(), "Cannot return null from a non-@Nullable component method");
    }

    public final ClientFactory apiFactory() {
        return (ClientFactory) Preconditions.checkNotNull(this.f1360a.apiFactory(), "Cannot return null from a non-@Nullable component method");
    }

    public final SharedPreferences sharedPreferences() {
        return (SharedPreferences) Preconditions.checkNotNull(this.f1360a.sharedPreferences(), "Cannot return null from a non-@Nullable component method");
    }

    public final SnapKitAppLifecycleObserver snapKitAppLifecycleObserver() {
        return (SnapKitAppLifecycleObserver) Preconditions.checkNotNull(this.f1360a.snapKitAppLifecycleObserver(), "Cannot return null from a non-@Nullable component method");
    }

    public final LoginStateController logoutController() {
        return (LoginStateController) Preconditions.checkNotNull(this.f1360a.logoutController(), "Cannot return null from a non-@Nullable component method");
    }

    public final KitEventBaseFactory kitEventBaseFactory() {
        return (KitEventBaseFactory) Preconditions.checkNotNull(this.f1360a.kitEventBaseFactory(), "Cannot return null from a non-@Nullable component method");
    }

    public final String clientId() {
        return (String) Preconditions.checkNotNull(this.f1360a.clientId(), "Cannot return null from a non-@Nullable component method");
    }

    public final String redirectUrl() {
        return (String) Preconditions.checkNotNull(this.f1360a.redirectUrl(), "Cannot return null from a non-@Nullable component method");
    }

    public final C4510a loginButtonController() {
        return this.f1365f.get();
    }

    public final LoginClient loginClient() {
        return this.f1367h.get();
    }

    public final C4513a snapLoginClient() {
        return this.f1368i.get();
    }

    /* renamed from: com.snapchat.kit.sdk.login.a$a */
    public static final class C4502a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public C4509b f1369a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public SnapKitComponent f1370b;

        /* synthetic */ C4502a(byte b) {
            this();
        }

        private C4502a() {
        }

        /* renamed from: a */
        public final LoginComponent mo61809a() {
            if (this.f1369a == null) {
                this.f1369a = new C4509b();
            }
            if (this.f1370b != null) {
                return new C4501a(this, (byte) 0);
            }
            throw new IllegalStateException(SnapKitComponent.class.getCanonicalName() + " must be set");
        }

        /* renamed from: a */
        public final C4502a mo61810a(SnapKitComponent snapKitComponent) {
            this.f1370b = (SnapKitComponent) Preconditions.checkNotNull(snapKitComponent);
            return this;
        }
    }

    /* renamed from: com.snapchat.kit.sdk.login.a$c */
    private static class C4504c implements Provider<AuthTokenManager> {

        /* renamed from: a */
        private final SnapKitComponent f1372a;

        C4504c(SnapKitComponent snapKitComponent) {
            this.f1372a = snapKitComponent;
        }

        public final /* synthetic */ Object get() {
            return (AuthTokenManager) Preconditions.checkNotNull(this.f1372a.authTokenManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.snapchat.kit.sdk.login.a$d */
    private static class C4505d implements Provider<LoginStateController> {

        /* renamed from: a */
        private final SnapKitComponent f1373a;

        C4505d(SnapKitComponent snapKitComponent) {
            this.f1373a = snapKitComponent;
        }

        public final /* synthetic */ Object get() {
            return (LoginStateController) Preconditions.checkNotNull(this.f1373a.logoutController(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.snapchat.kit.sdk.login.a$e */
    private static class C4506e implements Provider<MetricQueue<OpMetric>> {

        /* renamed from: a */
        private final SnapKitComponent f1374a;

        C4506e(SnapKitComponent snapKitComponent) {
            this.f1374a = snapKitComponent;
        }

        public final /* synthetic */ Object get() {
            return (MetricQueue) Preconditions.checkNotNull(this.f1374a.operationalMetricsQueue(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.snapchat.kit.sdk.login.a$b */
    private static class C4503b implements Provider<ClientFactory> {

        /* renamed from: a */
        private final SnapKitComponent f1371a;

        C4503b(SnapKitComponent snapKitComponent) {
            this.f1371a = snapKitComponent;
        }

        public final /* synthetic */ Object get() {
            return (ClientFactory) Preconditions.checkNotNull(this.f1371a.apiFactory(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
