package com.snapchat.kit.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.snapchat.kit.sdk.core.controller.C4396a;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.business.C4422e;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.models.AuthToken;
import com.snapchat.kit.sdk.core.models.AuthorizationRequest;
import com.snapchat.kit.sdk.core.models.SnapKitFeatureOptions;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import com.snapchat.kit.sdk.core.networking.RefreshAccessTokenResult;
import com.snapchat.kit.sdk.core.networking.RefreshAccessTokenResultError;
import com.snapchat.kit.sdk.core.security.SecureSharedPreferences;
import com.snapchat.kit.sdk.p041a.C4381a;
import com.snapchat.kit.sdk.util.SnapUtils;
import dagger.Lazy;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* renamed from: com.snapchat.kit.sdk.d */
public final class C4475d implements AuthTokenManager {

    /* renamed from: a */
    static final Set<String> f1303a = new HashSet<String>() {
        {
            add("invalid_grant");
            add("invalid_request");
            add("invalid_scope");
            add("unsupported_grant_type");
        }
    };

    /* renamed from: b */
    private final String f1304b;

    /* renamed from: c */
    private final String f1305c;

    /* renamed from: d */
    private final List<String> f1306d;

    /* renamed from: e */
    private final Context f1307e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C4396a f1308f;

    /* renamed from: g */
    private final OkHttpClient f1309g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Gson f1310h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Lazy<MetricQueue<ServerEvent>> f1311i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C4422e f1312j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C4381a f1313k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public AuthorizationRequest f1314l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C4380a f1315m;

    /* renamed from: n */
    private final AtomicBoolean f1316n = new AtomicBoolean(false);

    /* renamed from: o */
    private int f1317o = 0;

    C4475d(String str, String str2, List<String> list, Context context, SecureSharedPreferences secureSharedPreferences, C4396a aVar, OkHttpClient okHttpClient, Gson gson, Lazy<MetricQueue<ServerEvent>> lazy, C4422e eVar, Lazy<MetricQueue<OpMetric>> lazy2) {
        this.f1304b = str;
        this.f1305c = str2;
        this.f1306d = list;
        this.f1307e = context;
        this.f1308f = aVar;
        this.f1309g = okHttpClient;
        this.f1310h = gson;
        this.f1311i = lazy;
        this.f1312j = eVar;
        this.f1313k = new C4381a(lazy2);
        C4380a aVar2 = new C4380a(secureSharedPreferences);
        this.f1315m = aVar2;
        if (aVar2.mo61291a()) {
            new C4483a(this, (byte) 0).execute(new Void[0]);
        }
    }

    public final boolean isUserLoggedIn() {
        return this.f1315m.mo61297f();
    }

    public final boolean hasAccessToScope(String str) {
        return this.f1315m.mo61292a(str);
    }

    public final void clearToken() {
        boolean f = this.f1315m.mo61297f();
        this.f1315m.mo61298g();
        if (f) {
            this.f1308f.mo61315a();
        }
    }

    public final void refreshAccessToken(RefreshAccessTokenResult refreshAccessTokenResult) {
        new C4484b(this, refreshAccessTokenResult, (byte) 0).execute(new Void[0]);
    }

    public final String getAccessToken() {
        return this.f1315m.mo61294c();
    }

    /* renamed from: a */
    public final String mo61785a() {
        return this.f1315m.mo61295d();
    }

    /* renamed from: com.snapchat.kit.sdk.d$c */
    public enum C4485c {
        ;
        

        /* renamed from: a */
        public static final int f1331a = 1;

        /* renamed from: b */
        public static final int f1332b = 2;

        /* renamed from: c */
        public static final int f1333c = 3;

        /* renamed from: d */
        public static final int f1334d = 4;

        /* renamed from: e */
        public static final int f1335e = 5;

        /* renamed from: f */
        public static final int f1336f = 6;

        static {
            f1337g = new int[]{1, 2, 3, 4, 5, 6};
        }

        /* renamed from: a */
        public static int[] m948a() {
            return (int[]) f1337g.clone();
        }
    }

    /* renamed from: b */
    public final int mo61789b() {
        if (!this.f1315m.mo61293b()) {
            return C4485c.f1336f;
        }
        return mo61790c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.snapchat.kit.sdk.core.models.TokenErrorResponse} */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r1 = com.snapchat.kit.sdk.C4475d.C4485c.f1334d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0102, code lost:
        r8.f1316n.set(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0107, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fa */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f5 A[Catch:{ IOException -> 0x00fa }] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo61790c() {
        /*
            r8 = this;
            com.snapchat.kit.sdk.a r0 = r8.f1315m
            java.lang.String r0 = r0.mo61296e()
            if (r0 != 0) goto L_0x000b
            int r0 = com.snapchat.kit.sdk.C4475d.C4485c.f1331a
            return r0
        L_0x000b:
            okhttp3.FormBody$Builder r1 = new okhttp3.FormBody$Builder
            r1.<init>()
            java.lang.String r2 = "grant_type"
            java.lang.String r3 = "refresh_token"
            r1.add(r2, r3)
            r1.add(r3, r0)
            java.lang.String r0 = r8.f1304b
            java.lang.String r2 = "client_id"
            r1.add(r2, r0)
            okhttp3.FormBody r0 = r1.build()
            java.lang.String r1 = "/accounts/oauth2/token"
            okhttp3.Request r0 = m931a((okhttp3.RequestBody) r0, (java.lang.String) r1)
            java.util.concurrent.atomic.AtomicBoolean r1 = r8.f1316n
            r2 = 0
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 != 0) goto L_0x0038
            int r0 = com.snapchat.kit.sdk.C4475d.C4485c.f1333c
            return r0
        L_0x0038:
            com.snapchat.kit.sdk.a.a r1 = r8.f1313k
            com.snapchat.kit.sdk.a.a$a r4 = com.snapchat.kit.sdk.p041a.C4381a.C4382a.REFRESH
            r1.mo61299a((com.snapchat.kit.sdk.p041a.C4381a.C4382a) r4)
            int r1 = com.snapchat.kit.sdk.C4475d.C4485c.f1335e
            okhttp3.OkHttpClient r4 = r8.f1309g     // Catch:{ IOException -> 0x00fa }
            okhttp3.Call r0 = r4.newCall(r0)     // Catch:{ IOException -> 0x00fa }
            okhttp3.Response r0 = r0.execute()     // Catch:{ IOException -> 0x00fa }
            r4 = 0
            if (r0 == 0) goto L_0x0077
            boolean r5 = r0.isSuccessful()     // Catch:{ IOException -> 0x00fa }
            if (r5 == 0) goto L_0x0077
            okhttp3.ResponseBody r5 = r0.body()     // Catch:{ IOException -> 0x00fa }
            if (r5 == 0) goto L_0x0077
            okhttp3.ResponseBody r5 = r0.body()     // Catch:{ IOException -> 0x00fa }
            java.io.Reader r5 = r5.charStream()     // Catch:{ IOException -> 0x00fa }
            if (r5 == 0) goto L_0x0077
            com.google.gson.Gson r5 = r8.f1310h     // Catch:{ IOException -> 0x00fa }
            okhttp3.ResponseBody r6 = r0.body()     // Catch:{ IOException -> 0x00fa }
            java.io.Reader r6 = r6.charStream()     // Catch:{ IOException -> 0x00fa }
            java.lang.Class<com.snapchat.kit.sdk.core.models.AuthToken> r7 = com.snapchat.kit.sdk.core.models.AuthToken.class
            java.lang.Object r5 = r5.fromJson((java.io.Reader) r6, r7)     // Catch:{ IOException -> 0x00fa }
            com.snapchat.kit.sdk.core.models.AuthToken r5 = (com.snapchat.kit.sdk.core.models.AuthToken) r5     // Catch:{ IOException -> 0x00fa }
            goto L_0x0078
        L_0x0077:
            r5 = r4
        L_0x0078:
            if (r5 == 0) goto L_0x00a7
            java.lang.String r6 = r5.getRefreshToken()     // Catch:{ IOException -> 0x00fa }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IOException -> 0x00fa }
            if (r6 == 0) goto L_0x008d
            com.snapchat.kit.sdk.a r6 = r8.f1315m     // Catch:{ IOException -> 0x00fa }
            java.lang.String r6 = r6.mo61296e()     // Catch:{ IOException -> 0x00fa }
            r5.setRefreshToken(r6)     // Catch:{ IOException -> 0x00fa }
        L_0x008d:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00fa }
            r5.setLastUpdated(r6)     // Catch:{ IOException -> 0x00fa }
            boolean r6 = r5.isComplete()     // Catch:{ IOException -> 0x00fa }
            if (r6 == 0) goto L_0x00a7
            com.snapchat.kit.sdk.a r0 = r8.f1315m     // Catch:{ IOException -> 0x00fa }
            r0.mo61290a((com.snapchat.kit.sdk.core.models.AuthToken) r5)     // Catch:{ IOException -> 0x00fa }
            com.snapchat.kit.sdk.a.a r0 = r8.f1313k     // Catch:{ IOException -> 0x00fa }
            com.snapchat.kit.sdk.a.a$a r4 = com.snapchat.kit.sdk.p041a.C4381a.C4382a.REFRESH     // Catch:{ IOException -> 0x00fa }
            r0.mo61300a(r4, r3)     // Catch:{ IOException -> 0x00fa }
            goto L_0x00f3
        L_0x00a7:
            if (r0 == 0) goto L_0x00ca
            boolean r3 = r0.isSuccessful()     // Catch:{ IOException -> 0x00fa }
            if (r3 != 0) goto L_0x00ca
            int r3 = r0.code()     // Catch:{ IOException -> 0x00fa }
            r5 = 400(0x190, float:5.6E-43)
            if (r3 != r5) goto L_0x00ca
            com.google.gson.Gson r3 = r8.f1310h     // Catch:{ IOException -> 0x00fa }
            okhttp3.ResponseBody r0 = r0.body()     // Catch:{ IOException -> 0x00fa }
            java.io.Reader r0 = r0.charStream()     // Catch:{ IOException -> 0x00fa }
            java.lang.Class<com.snapchat.kit.sdk.core.models.TokenErrorResponse> r4 = com.snapchat.kit.sdk.core.models.TokenErrorResponse.class
            java.lang.Object r0 = r3.fromJson((java.io.Reader) r0, r4)     // Catch:{ IOException -> 0x00fa }
            r4 = r0
            com.snapchat.kit.sdk.core.models.TokenErrorResponse r4 = (com.snapchat.kit.sdk.core.models.TokenErrorResponse) r4     // Catch:{ IOException -> 0x00fa }
        L_0x00ca:
            if (r4 == 0) goto L_0x00eb
            java.lang.String r0 = r4.getError()     // Catch:{ IOException -> 0x00fa }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException -> 0x00fa }
            if (r0 != 0) goto L_0x00eb
            java.util.Set<java.lang.String> r0 = f1303a     // Catch:{ IOException -> 0x00fa }
            java.lang.String r3 = r4.getError()     // Catch:{ IOException -> 0x00fa }
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ IOException -> 0x00fa }
            boolean r0 = r0.contains(r3)     // Catch:{ IOException -> 0x00fa }
            if (r0 == 0) goto L_0x00eb
            com.snapchat.kit.sdk.a r0 = r8.f1315m     // Catch:{ IOException -> 0x00fa }
            r0.mo61298g()     // Catch:{ IOException -> 0x00fa }
        L_0x00eb:
            com.snapchat.kit.sdk.a.a r0 = r8.f1313k     // Catch:{ IOException -> 0x00fa }
            com.snapchat.kit.sdk.a.a$a r3 = com.snapchat.kit.sdk.p041a.C4381a.C4382a.REFRESH     // Catch:{ IOException -> 0x00fa }
            r0.mo61300a(r3, r2)     // Catch:{ IOException -> 0x00fa }
            r3 = 0
        L_0x00f3:
            if (r3 != 0) goto L_0x00fc
            int r1 = com.snapchat.kit.sdk.C4475d.C4485c.f1332b     // Catch:{ IOException -> 0x00fa }
            goto L_0x00fc
        L_0x00f8:
            r0 = move-exception
            goto L_0x0102
        L_0x00fa:
            int r1 = com.snapchat.kit.sdk.C4475d.C4485c.f1334d     // Catch:{ all -> 0x00f8 }
        L_0x00fc:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f1316n
            r0.set(r2)
            return r1
        L_0x0102:
            java.util.concurrent.atomic.AtomicBoolean r1 = r8.f1316n
            r1.set(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snapchat.kit.sdk.C4475d.mo61790c():int");
    }

    public final void startTokenGrant() {
        startTokenGrantWithOptions(new SnapKitFeatureOptions());
    }

    public final void startTokenGrantWithOptions(SnapKitFeatureOptions snapKitFeatureOptions) {
        boolean z;
        if (!TextUtils.isEmpty(this.f1305c)) {
            List<String> list = this.f1306d;
            if (list == null || list.isEmpty()) {
                throw new IllegalStateException("Valid scopes must be set");
            }
            AuthorizationRequest a = C4383b.m823a(this.f1304b, this.f1305c, this.f1306d, snapKitFeatureOptions);
            this.f1314l = a;
            PackageManager packageManager = this.f1307e.getPackageManager();
            if (this.f1317o < 3 && SnapUtils.isSnapchatInstalled(packageManager, "com.snapchat.android")) {
                Context context = this.f1307e;
                Intent intent = new Intent("android.intent.action.VIEW", a.toUri("snapchat://", "oauth2", context.getPackageName(), (String) null));
                intent.setPackage("com.snapchat.android");
                intent.setFlags(268435456);
                if (intent.resolveActivity(packageManager) != null) {
                    context.startActivity(intent);
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.f1313k.mo61301a("authSnapchat");
                    this.f1311i.get().push(this.f1312j.mo61355a(snapKitFeatureOptions));
                    this.f1317o++;
                    return;
                }
            }
            Uri uri = a.toUri("https://accounts.snapchat.com/accounts", "/oauth2/auth", (String) null, "snapkit_web");
            this.f1313k.mo61301a("authWeb");
            Context context2 = this.f1307e;
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                intent2.setFlags(268435456);
                context2.startActivity(intent2);
            } catch (Exception unused) {
            }
            this.f1311i.get().push(this.f1312j.mo61355a(snapKitFeatureOptions));
            return;
        }
        throw new IllegalStateException("Redirect URL must be set!");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo61787a(Uri uri, String str) {
        String queryParameter = uri.getQueryParameter("code");
        String queryParameter2 = uri.getQueryParameter("state");
        if (TextUtils.isEmpty("code") || TextUtils.isEmpty("state")) {
            this.f1311i.get().push(this.f1312j.mo61356a(false));
            this.f1308f.mo61317c();
            return;
        }
        m932a(C4383b.m824a(this.f1304b, uri.buildUpon().query((String) null).build().toString(), this.f1306d, queryParameter2, str, new SnapKitFeatureOptions()), queryParameter, queryParameter2);
    }

    /* renamed from: a */
    private void m932a(AuthorizationRequest authorizationRequest, String str, String str2) {
        if (authorizationRequest == null || !TextUtils.equals(str2, authorizationRequest.getState()) || TextUtils.isEmpty(authorizationRequest.getRedirectUri()) || TextUtils.isEmpty(authorizationRequest.getCodeVerifier())) {
            this.f1311i.get().push(this.f1312j.mo61356a(false));
            this.f1308f.mo61317c();
            return;
        }
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("grant_type", "authorization_code");
        builder.add("code", str);
        builder.add(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, authorizationRequest.getRedirectUri());
        builder.add("client_id", this.f1304b);
        builder.add("code_verifier", authorizationRequest.getCodeVerifier());
        Request a = m931a((RequestBody) builder.build(), "/accounts/oauth2/token");
        if (a == null) {
            this.f1311i.get().push(this.f1312j.mo61356a(false));
            this.f1308f.mo61317c();
            return;
        }
        this.f1308f.mo61318d();
        this.f1313k.mo61299a(C4381a.C4382a.GRANT);
        this.f1309g.newCall(a).enqueue(new Callback() {
            public final void onFailure(Call call, IOException iOException) {
                C4475d.m936b((Runnable) new Runnable() {
                    public final void run() {
                        ((MetricQueue) C4475d.this.f1311i.get()).push(C4475d.this.f1312j.mo61356a(false));
                        C4475d.this.f1313k.mo61300a(C4381a.C4382a.GRANT, false);
                        C4475d.this.f1308f.mo61317c();
                    }
                });
            }

            public final void onResponse(Call call, Response response) {
                if (!(!response.isSuccessful() || response.body() == null || response.body().charStream() == null)) {
                    AuthToken authToken = (AuthToken) C4475d.this.f1310h.fromJson(response.body().charStream(), AuthToken.class);
                    authToken.setLastUpdated(System.currentTimeMillis());
                    if (authToken.isComplete()) {
                        C4475d.this.f1315m.mo61290a(authToken);
                        AuthorizationRequest unused = C4475d.this.f1314l = null;
                        C4475d.this.f1313k.mo61300a(C4381a.C4382a.GRANT, true);
                        C4475d.m936b((Runnable) new Runnable() {
                            public final void run() {
                                ((MetricQueue) C4475d.this.f1311i.get()).push(C4475d.this.f1312j.mo61356a(true));
                                C4475d.this.f1308f.mo61316b();
                            }
                        });
                        return;
                    }
                }
                C4475d.m936b((Runnable) new Runnable() {
                    public final void run() {
                        ((MetricQueue) C4475d.this.f1311i.get()).push(C4475d.this.f1312j.mo61356a(false));
                        C4475d.this.f1313k.mo61300a(C4381a.C4382a.GRANT, false);
                        C4475d.this.f1308f.mo61317c();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo61788a(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return false;
        }
        return data.toString().startsWith(this.f1305c);
    }

    /* renamed from: a */
    private static Request m931a(RequestBody requestBody, String str) {
        return new Request.Builder().header(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded").url(String.format("%s%s", new Object[]{"https://accounts.snapchat.com", str})).post(requestBody).build();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m936b(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    /* renamed from: com.snapchat.kit.sdk.d$b */
    private static class C4484b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private final WeakReference<C4475d> f1329a;

        /* renamed from: b */
        private final RefreshAccessTokenResult f1330b;

        /* synthetic */ C4484b(C4475d dVar, RefreshAccessTokenResult refreshAccessTokenResult, byte b) {
            this(dVar, refreshAccessTokenResult);
        }

        private C4484b(C4475d dVar, RefreshAccessTokenResult refreshAccessTokenResult) {
            this.f1329a = new WeakReference<>(dVar);
            this.f1330b = refreshAccessTokenResult;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            RefreshAccessTokenResultError refreshAccessTokenResultError;
            C4475d dVar = (C4475d) this.f1329a.get();
            if (dVar == null) {
                return null;
            }
            int c = dVar.mo61790c();
            String accessToken = dVar.getAccessToken();
            if (c != C4485c.f1335e || accessToken == null) {
                int i = C44824.f1327a[c - 1];
                if (i == 1) {
                    refreshAccessTokenResultError = RefreshAccessTokenResultError.REVOKED_SESSION;
                } else if (i == 2) {
                    refreshAccessTokenResultError = RefreshAccessTokenResultError.NO_REFRESH_TOKEN;
                } else if (i == 3) {
                    refreshAccessTokenResultError = RefreshAccessTokenResultError.NETWORK_ERROR;
                } else if (i != 4) {
                    refreshAccessTokenResultError = RefreshAccessTokenResultError.UNKNOWN;
                } else {
                    refreshAccessTokenResultError = RefreshAccessTokenResultError.BUSY;
                }
                C4475d.m933a(dVar, this.f1330b, false, (String) null, refreshAccessTokenResultError);
                return null;
            }
            C4475d.m933a(dVar, this.f1330b, true, accessToken, (RefreshAccessTokenResultError) null);
            return null;
        }
    }

    /* renamed from: com.snapchat.kit.sdk.d$4 */
    static /* synthetic */ class C44824 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1327a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        static {
            /*
                int[] r0 = com.snapchat.kit.sdk.C4475d.C4485c.m948a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1327a = r0
                r1 = 1
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1332b     // Catch:{ NoSuchFieldError -> 0x000f }
                int r2 = r2 - r1
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f1327a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1331a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = r2 - r1
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r0 = f1327a     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1334d     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = r2 - r1
                r3 = 3
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1327a     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = com.snapchat.kit.sdk.C4475d.C4485c.f1333c     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = r2 - r1
                r1 = 4
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.snapchat.kit.sdk.C4475d.C44824.<clinit>():void");
        }
    }

    /* renamed from: com.snapchat.kit.sdk.d$a */
    private static class C4483a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private final WeakReference<C4475d> f1328a;

        /* synthetic */ C4483a(C4475d dVar, byte b) {
            this(dVar);
        }

        private C4483a(C4475d dVar) {
            this.f1328a = new WeakReference<>(dVar);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            C4475d dVar = (C4475d) this.f1328a.get();
            if (dVar == null) {
                return null;
            }
            dVar.mo61790c();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo61786a(Uri uri) {
        AuthorizationRequest authorizationRequest = this.f1314l;
        if (authorizationRequest == null || uri == null || TextUtils.isEmpty(uri.getQueryParameter("code")) || TextUtils.isEmpty(uri.getQueryParameter("state"))) {
            this.f1311i.get().push(this.f1312j.mo61356a(false));
            this.f1308f.mo61317c();
            return;
        }
        this.f1317o = 0;
        m932a(authorizationRequest, uri.getQueryParameter("code"), uri.getQueryParameter("state"));
    }

    /* renamed from: a */
    static /* synthetic */ void m933a(C4475d dVar, RefreshAccessTokenResult refreshAccessTokenResult, boolean z, String str, RefreshAccessTokenResultError refreshAccessTokenResultError) {
        final boolean z2 = z;
        final RefreshAccessTokenResult refreshAccessTokenResult2 = refreshAccessTokenResult;
        final String str2 = str;
        final RefreshAccessTokenResultError refreshAccessTokenResultError2 = refreshAccessTokenResultError;
        m936b((Runnable) new Runnable() {
            public final void run() {
                if (z2) {
                    refreshAccessTokenResult2.onRefreshAccessTokenSuccess(str2);
                } else {
                    refreshAccessTokenResult2.onRefreshAccessTokenFailure(refreshAccessTokenResultError2);
                }
            }
        });
    }
}
