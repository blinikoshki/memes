package com.snapchat.kit.sdk.core.security;

import android.content.Context;
import javax.inject.Inject;

public class Fingerprint {
    private final String mPackageName;

    private native String sign(String str);

    @Inject
    public Fingerprint(Context context) {
        System.loadLibrary("pruneau");
        this.mPackageName = context.getPackageName();
    }

    public synchronized String getEncryptedFingerprint() {
        return sign(generateFingerprintPayload());
    }

    private String generateFingerprintPayload() {
        return String.format("%s:%d", new Object[]{this.mPackageName, Long.valueOf(System.currentTimeMillis())});
    }
}
