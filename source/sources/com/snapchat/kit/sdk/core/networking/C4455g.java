package com.snapchat.kit.sdk.core.networking;

import android.util.Log;
import com.snapchat.kit.sdk.core.security.Fingerprint;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.snapchat.kit.sdk.core.networking.g */
public final class C4455g extends C4457i {

    /* renamed from: a */
    private final Fingerprint f1264a;

    public final /* bridge */ /* synthetic */ Response intercept(Interceptor.Chain chain) throws IOException {
        return super.intercept(chain);
    }

    @Inject
    C4455g(@Named("client_id") String str, Fingerprint fingerprint) {
        super(str);
        this.f1264a = fingerprint;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Request.Builder mo61726a(Interceptor.Chain chain) {
        Request.Builder a = super.mo61726a(chain);
        String encryptedFingerprint = this.f1264a.getEncryptedFingerprint();
        if (encryptedFingerprint == null) {
            Log.e("FingerprintInterceptor", "Could not generate fingerprint");
        } else {
            a.header("X-Snap-SDK-Client-Auth-Token", encryptedFingerprint);
        }
        return a;
    }
}
