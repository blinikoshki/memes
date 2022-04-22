package com.snapchat.kit.sdk;

import android.text.TextUtils;
import com.snapchat.kit.sdk.core.models.AuthToken;
import com.snapchat.kit.sdk.core.security.SecureSharedPreferences;

/* renamed from: com.snapchat.kit.sdk.a */
final class C4380a {

    /* renamed from: a */
    private volatile AuthToken f1058a;

    /* renamed from: b */
    private final SecureSharedPreferences f1059b;

    C4380a(SecureSharedPreferences secureSharedPreferences) {
        this.f1059b = secureSharedPreferences;
        this.f1058a = (AuthToken) secureSharedPreferences.get("auth_token", AuthToken.class);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized boolean mo61292a(String str) {
        return this.f1058a != null && this.f1058a.hasAccessToScope(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized boolean mo61291a() {
        return this.f1058a != null && !this.f1058a.isComplete();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized boolean mo61293b() {
        if (this.f1058a == null) {
            return false;
        }
        if (this.f1058a.isExpired()) {
            return true;
        }
        return this.f1058a.willBeExpiredAfter(300000L);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized String mo61294c() {
        if (this.f1058a != null && !this.f1058a.isExpired()) {
            if (!this.f1058a.willBeExpiredAfter(300000L)) {
                return this.f1058a.getAccessToken();
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final synchronized String mo61295d() {
        if (this.f1058a == null) {
            return null;
        }
        return this.f1058a.getAccessToken();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final synchronized String mo61296e() {
        if (this.f1058a == null) {
            return null;
        }
        return this.f1058a.getRefreshToken();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo61297f() {
        return !TextUtils.isEmpty(mo61296e());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final synchronized void mo61298g() {
        this.f1058a = null;
        this.f1059b.clearEntry("auth_token");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo61290a(AuthToken authToken) {
        if (this.f1058a == null || this.f1058a.getLastUpdated() <= authToken.getLastUpdated()) {
            this.f1058a = authToken;
            this.f1059b.put("auth_token", this.f1058a);
        }
    }
}
