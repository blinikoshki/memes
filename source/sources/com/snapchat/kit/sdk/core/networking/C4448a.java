package com.snapchat.kit.sdk.core.networking;

import android.util.Log;
import com.snapchat.kit.sdk.C4475d;
import com.snapchat.kit.sdk.core.controller.C4396a;
import com.snapchat.kit.sdk.core.security.Fingerprint;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.Interceptor;
import okhttp3.Request;

/* renamed from: com.snapchat.kit.sdk.core.networking.a */
public final class C4448a extends C4452e {

    /* renamed from: a */
    private final Fingerprint f1247a;

    @Inject
    C4448a(C4475d dVar, C4396a aVar, @Named("client_id") String str, Fingerprint fingerprint) {
        super(dVar, aVar, str);
        this.f1247a = fingerprint;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Request.Builder mo61726a(Interceptor.Chain chain) {
        Request.Builder a = super.mo61726a(chain);
        String encryptedFingerprint = this.f1247a.getEncryptedFingerprint();
        if (encryptedFingerprint == null) {
            Log.e("AuthTokenFingerprintInt", "Could not generate fingerprint");
        } else {
            a.header("X-Snap-SDK-Client-Auth-Token", encryptedFingerprint);
        }
        return a;
    }
}
