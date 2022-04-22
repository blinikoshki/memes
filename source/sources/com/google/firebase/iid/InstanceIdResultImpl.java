package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
final class InstanceIdResultImpl implements InstanceIdResult {

    /* renamed from: id */
    private final String f772id;
    private final String token;

    InstanceIdResultImpl(String str, String str2) {
        this.f772id = str;
        this.token = str2;
    }

    public String getId() {
        return this.f772id;
    }

    public String getToken() {
        return this.token;
    }
}
