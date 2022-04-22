package com.snapchat.kit.sdk;

import android.text.TextUtils;
import android.util.Base64;
import com.snapchat.kit.sdk.core.models.AuthorizationRequest;
import com.snapchat.kit.sdk.core.models.SnapKitFeatureOptions;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.snapchat.kit.sdk.b */
final class C4383b {

    /* renamed from: a */
    private static String f1062a = "AuthRequestFactory";

    /* renamed from: b */
    private static int f1063b = 32;

    /* renamed from: c */
    private static int f1064c = 32;

    /* renamed from: a */
    static AuthorizationRequest m823a(String str, String str2, List<String> list, SnapKitFeatureOptions snapKitFeatureOptions) {
        return m824a(str, str2, list, m825a(f1063b), m825a(f1064c), snapKitFeatureOptions);
    }

    /* renamed from: a */
    static AuthorizationRequest m824a(String str, String str2, List<String> list, String str3, String str4, SnapKitFeatureOptions snapKitFeatureOptions) {
        return new AuthorizationRequest().withResponseType("code").withClientId(str).withScope(TextUtils.join(StringUtils.SPACE, list)).withRedirectUri(str2).withCodeChallengeMethod("S256").withCodeVerifier(str4).withCodeChallenge(m826a(str4)).withState(str3).withFeatures(snapKitFeatureOptions.toUriValue());
    }

    /* renamed from: a */
    private static String m825a(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }

    /* renamed from: a */
    private static String m826a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes("US-ASCII"));
            return Base64.encodeToString(instance.digest(), 11);
        } catch (Exception unused) {
            return str;
        }
    }
}
