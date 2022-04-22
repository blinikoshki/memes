package com.snapchat.kit.sdk.core.security;

import javax.crypto.SecretKey;

public class SecretGenerationResult {
    private final boolean mIsNewSecret;
    private final SecretKey mSecretKey;

    public SecretGenerationResult(SecretKey secretKey, boolean z) {
        this.mSecretKey = secretKey;
        this.mIsNewSecret = z;
    }

    public SecretKey getSecretKey() {
        return this.mSecretKey;
    }

    public boolean isNewSecret() {
        return this.mIsNewSecret;
    }
}
