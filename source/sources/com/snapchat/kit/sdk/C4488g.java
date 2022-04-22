package com.snapchat.kit.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.p003v4.media.session.PlaybackStateCompat;
import com.google.gson.Gson;
import com.snapchat.kit.sdk.core.config.C4391f;
import com.snapchat.kit.sdk.core.controller.C4396a;
import com.snapchat.kit.sdk.core.controller.LoginStateController;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.business.C4422e;
import com.snapchat.kit.sdk.core.metrics.model.OpMetric;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.metrics.model.SkateEvent;
import com.snapchat.kit.sdk.core.metrics.model.SnapKitInitType;
import com.snapchat.kit.sdk.core.metrics.skate.C4444c;
import com.snapchat.kit.sdk.core.metrics.skate.C4446d;
import com.snapchat.kit.sdk.core.networking.AuthTokenManager;
import com.snapchat.kit.sdk.core.security.SecureSharedPreferences;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import java.util.Random;
import javax.inject.Named;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Module
/* renamed from: com.snapchat.kit.sdk.g */
class C4488g {

    /* renamed from: a */
    private final Context f1341a;

    /* renamed from: b */
    private final String f1342b;

    /* renamed from: c */
    private final String f1343c;

    /* renamed from: d */
    private final List<String> f1344d;

    /* renamed from: e */
    private final SnapKitInitType f1345e;

    @Provides
    /* renamed from: a */
    static LoginStateController m953a(C4396a aVar) {
        return aVar;
    }

    @Provides
    /* renamed from: a */
    static AuthTokenManager m955a(C4475d dVar) {
        return dVar;
    }

    C4488g(Context context, String str, String str2, List<String> list, SnapKitInitType snapKitInitType) {
        this.f1341a = context;
        this.f1342b = str;
        this.f1343c = str2;
        this.f1344d = list;
        this.f1345e = snapKitInitType;
    }

    /* access modifiers changed from: package-private */
    @Provides
    /* renamed from: a */
    public final SnapKitInitType mo61798a() {
        return this.f1345e;
    }

    /* access modifiers changed from: package-private */
    @SnapConnectScope
    @Provides
    /* renamed from: b */
    public final Context mo61801b() {
        return this.f1341a;
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("client_id")
    /* renamed from: c */
    public final String mo61802c() {
        return this.f1342b;
    }

    /* access modifiers changed from: package-private */
    @Provides
    @Named("redirect_url")
    /* renamed from: d */
    public final String mo61803d() {
        return this.f1343c;
    }

    @SnapConnectScope
    @Provides
    /* renamed from: e */
    static Gson m956e() {
        return new Gson();
    }

    /* access modifiers changed from: package-private */
    @SnapConnectScope
    @Provides
    /* renamed from: f */
    public final SharedPreferences mo61804f() {
        return this.f1341a.getSharedPreferences("com.snapchat.connect.sdk.sharedPreferences", 0);
    }

    /* access modifiers changed from: package-private */
    @SnapConnectScope
    @Provides
    /* renamed from: g */
    public final Cache mo61805g() {
        return new Cache(this.f1341a.getCacheDir(), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
        r1 = new com.snapchat.kit.sdk.core.security.InsecureEncryptDecrypt();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047 A[Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A[Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[ExcHandler: JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:10:0x0027] */
    @com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope
    @dagger.Provides
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.snapchat.kit.sdk.core.security.SecureSharedPreferences mo61799a(com.google.gson.Gson r7, android.content.SharedPreferences r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f1341a
            java.lang.String r1 = "com.snapchat.connect.sdk.secureSharedPreferences"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "AndroidKeyStore"
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            r2 = 0
            r1.load(r2)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            r4 = 23
            java.lang.String r5 = "rsa_public"
            if (r3 < r4) goto L_0x0027
            boolean r3 = r8.contains(r5)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            if (r3 == 0) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            com.snapchat.kit.sdk.core.security.SecretGenerationResult r8 = com.snapchat.kit.sdk.core.security.SecretKeyFactory.getFromKeyStore(r1)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            goto L_0x005e
        L_0x0027:
            java.lang.String r3 = r8.getString(r5, r2)     // Catch:{ JsonParseException -> 0x0034, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f }
            java.lang.Class<com.snapchat.kit.sdk.core.security.RSAEncryptDecrypt$PublicKeyParams> r4 = com.snapchat.kit.sdk.core.security.RSAEncryptDecrypt.PublicKeyParams.class
            java.lang.Object r3 = r7.fromJson((java.lang.String) r3, r4)     // Catch:{ JsonParseException -> 0x0034, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f }
            com.snapchat.kit.sdk.core.security.RSAEncryptDecrypt$PublicKeyParams r3 = (com.snapchat.kit.sdk.core.security.RSAEncryptDecrypt.PublicKeyParams) r3     // Catch:{ JsonParseException -> 0x0034, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f }
            r2 = r3
        L_0x0034:
            com.snapchat.kit.sdk.core.security.RSAEncryptDecrypt r3 = new com.snapchat.kit.sdk.core.security.RSAEncryptDecrypt     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            android.content.Context r4 = r6.f1341a     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            r3.<init>(r1, r4, r2)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            com.snapchat.kit.sdk.core.security.RSAEncryptDecrypt$PublicKeyParams r1 = r3.getPublicKeyParams()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            boolean r1 = r1.equals(r2)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x005a
            android.content.SharedPreferences$Editor r2 = r8.edit()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            com.snapchat.kit.sdk.core.security.RSAEncryptDecrypt$PublicKeyParams r4 = r3.getPublicKeyParams()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            java.lang.String r4 = r7.toJson((java.lang.Object) r4)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            android.content.SharedPreferences$Editor r2 = r2.putString(r5, r4)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            r2.apply()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
        L_0x005a:
            com.snapchat.kit.sdk.core.security.SecretGenerationResult r8 = com.snapchat.kit.sdk.core.security.SecretKeyFactory.getFromSharedPreferences(r8, r3, r1)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
        L_0x005e:
            boolean r1 = r8.isNewSecret()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            if (r1 == 0) goto L_0x006f
            android.content.SharedPreferences$Editor r1 = r0.edit()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            android.content.SharedPreferences$Editor r1 = r1.clear()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            r1.apply()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
        L_0x006f:
            com.snapchat.kit.sdk.core.security.AESEncryptDecrypt r1 = new com.snapchat.kit.sdk.core.security.AESEncryptDecrypt     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            javax.crypto.SecretKey r8 = r8.getSecretKey()     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            r1.<init>(r8, r7)     // Catch:{ JsonParseException | IOException | IllegalArgumentException | IllegalStateException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableEntryException | CertificateException -> 0x007f, Exception -> 0x0079 }
            goto L_0x0084
        L_0x0079:
            com.snapchat.kit.sdk.core.security.InsecureEncryptDecrypt r1 = new com.snapchat.kit.sdk.core.security.InsecureEncryptDecrypt
            r1.<init>()
            goto L_0x0084
        L_0x007f:
            com.snapchat.kit.sdk.core.security.InsecureEncryptDecrypt r1 = new com.snapchat.kit.sdk.core.security.InsecureEncryptDecrypt
            r1.<init>()
        L_0x0084:
            com.snapchat.kit.sdk.core.security.SecureSharedPreferences r8 = new com.snapchat.kit.sdk.core.security.SecureSharedPreferences
            r8.<init>(r0, r1, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snapchat.kit.sdk.C4488g.mo61799a(com.google.gson.Gson, android.content.SharedPreferences):com.snapchat.kit.sdk.core.security.SecureSharedPreferences");
    }

    @SnapConnectScope
    @Provides
    /* renamed from: h */
    static OkHttpClient m957h() {
        return new OkHttpClient();
    }

    /* access modifiers changed from: package-private */
    @SnapConnectScope
    @Provides
    /* renamed from: a */
    public final C4475d mo61800a(SecureSharedPreferences secureSharedPreferences, C4396a aVar, OkHttpClient okHttpClient, Gson gson, Lazy<MetricQueue<ServerEvent>> lazy, C4422e eVar, Lazy<MetricQueue<OpMetric>> lazy2) {
        return new C4475d(this.f1342b, this.f1343c, this.f1344d, this.f1341a, secureSharedPreferences, aVar, okHttpClient, gson, lazy, eVar, lazy2);
    }

    @SnapConnectScope
    @Provides
    /* renamed from: a */
    static C4444c m954a(C4391f fVar, C4446d dVar, MetricQueue<SkateEvent> metricQueue, C4475d dVar2, SnapKitInitType snapKitInitType) {
        return new C4444c(fVar, dVar, metricQueue, dVar2, snapKitInitType);
    }

    @SnapConnectScope
    @Provides
    /* renamed from: a */
    static SnapKitAppLifecycleObserver m952a(C4444c cVar) {
        return new SnapKitAppLifecycleObserver(cVar);
    }

    @Provides
    /* renamed from: i */
    static Random m958i() {
        return new Random();
    }

    @Provides
    /* renamed from: j */
    static Handler m959j() {
        return new Handler(Looper.getMainLooper());
    }
}
