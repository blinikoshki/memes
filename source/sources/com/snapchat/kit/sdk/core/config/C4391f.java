package com.snapchat.kit.sdk.core.config;

import android.content.SharedPreferences;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.config.f */
public final class C4391f {

    /* renamed from: a */
    private int f1111a = C4394a.f1117a;

    /* renamed from: b */
    private ConfigClient f1112b;

    /* renamed from: c */
    private ArrayList<ServerSampleRateCallback> f1113c = new ArrayList<>();

    /* renamed from: d */
    private SharedPreferences f1114d;

    /* renamed from: c */
    private static boolean m837c(double d) {
        return d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d <= 1.0d;
    }

    /* renamed from: com.snapchat.kit.sdk.core.config.f$a */
    protected enum C4394a {
        ;
        

        /* renamed from: a */
        public static final int f1117a = 1;

        /* renamed from: b */
        public static final int f1118b = 2;

        /* renamed from: c */
        public static final int f1119c = 3;

        static {
            f1120d = new int[]{1, 2, 3};
        }
    }

    @Inject
    public C4391f(ConfigClient configClient, SharedPreferences sharedPreferences) {
        this.f1112b = configClient;
        this.f1114d = sharedPreferences;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r4.onServerSampleRateFailure();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0016 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo61309a(com.snapchat.kit.sdk.core.config.ServerSampleRateCallback r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = r3.f1111a     // Catch:{ all -> 0x0048 }
            int r1 = com.snapchat.kit.sdk.core.config.C4391f.C4394a.f1119c     // Catch:{ all -> 0x0048 }
            if (r0 != r1) goto L_0x001b
            android.content.SharedPreferences r0 = r3.f1114d     // Catch:{ ClassCastException -> 0x0016 }
            java.lang.String r1 = "com.snapchat.kit.sdk.core.config.skateSampleRate"
            r2 = 0
            float r0 = r0.getFloat(r1, r2)     // Catch:{ ClassCastException -> 0x0016 }
            double r0 = (double) r0     // Catch:{ ClassCastException -> 0x0016 }
            r4.onServerSampleRateAvailable(r0)     // Catch:{ ClassCastException -> 0x0016 }
            monitor-exit(r3)
            return
        L_0x0016:
            r4.onServerSampleRateFailure()     // Catch:{ all -> 0x0048 }
            monitor-exit(r3)
            return
        L_0x001b:
            java.util.ArrayList<com.snapchat.kit.sdk.core.config.ServerSampleRateCallback> r0 = r3.f1113c     // Catch:{ all -> 0x0048 }
            r0.add(r4)     // Catch:{ all -> 0x0048 }
            int r4 = r3.f1111a     // Catch:{ all -> 0x0048 }
            int r0 = com.snapchat.kit.sdk.core.config.C4391f.C4394a.f1118b     // Catch:{ all -> 0x0048 }
            if (r4 != r0) goto L_0x0028
            monitor-exit(r3)
            return
        L_0x0028:
            int r4 = com.snapchat.kit.sdk.core.config.C4391f.C4394a.f1118b     // Catch:{ all -> 0x0048 }
            r3.f1111a = r4     // Catch:{ all -> 0x0048 }
            com.snapchat.kit.sdk.core.config.f$1 r4 = new com.snapchat.kit.sdk.core.config.f$1     // Catch:{ all -> 0x0048 }
            r4.<init>()     // Catch:{ all -> 0x0048 }
            com.snapchat.kit.sdk.core.config.ConfigClient r0 = r3.f1112b     // Catch:{ all -> 0x0048 }
            com.snapchat.kit.sdk.core.config.a r1 = new com.snapchat.kit.sdk.core.config.a     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "query($kitVersion: String!) {config(kitVersion: $kitVersion) {skateConfig{sampleRate}}}"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0048 }
            retrofit2.Call r4 = r0.fetchConfig(r1)     // Catch:{ all -> 0x0048 }
            com.snapchat.kit.sdk.core.config.f$2 r0 = new com.snapchat.kit.sdk.core.config.f$2     // Catch:{ all -> 0x0048 }
            r0.<init>()     // Catch:{ all -> 0x0048 }
            r4.enqueue(r0)     // Catch:{ all -> 0x0048 }
            monitor-exit(r3)
            return
        L_0x0048:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snapchat.kit.sdk.core.config.C4391f.mo61309a(com.snapchat.kit.sdk.core.config.ServerSampleRateCallback):void");
    }

    /* renamed from: a */
    public final void mo61308a(double d) {
        if (m837c(d)) {
            this.f1114d.edit().putFloat("com.snapchat.kit.sdk.core.config.skateSampleRate", (float) d).apply();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m833a() {
        this.f1111a = C4394a.f1117a;
        Iterator<ServerSampleRateCallback> it = this.f1113c.iterator();
        while (it.hasNext()) {
            it.next().onServerSampleRateFailure();
        }
        this.f1113c.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m836b(double d) {
        this.f1114d.edit().putFloat("com.snapchat.kit.sdk.core.config.skateSampleRate", (float) d).apply();
        this.f1111a = C4394a.f1119c;
        Iterator<ServerSampleRateCallback> it = this.f1113c.iterator();
        while (it.hasNext()) {
            it.next().onServerSampleRateAvailable(d);
        }
        this.f1113c.clear();
    }

    /* renamed from: a */
    static /* synthetic */ Double m832a(C4389d dVar) {
        if (dVar.mo61307a() == null || ((C4387b) dVar.mo61307a()).f1107a == null || ((C4387b) dVar.mo61307a()).f1107a.f1108a == null || ((C4387b) dVar.mo61307a()).f1107a.f1108a.f1110a == null) {
            return null;
        }
        Double d = ((C4387b) dVar.mo61307a()).f1107a.f1108a.f1110a;
        if (!m837c(d.doubleValue())) {
            return null;
        }
        return d;
    }
}
