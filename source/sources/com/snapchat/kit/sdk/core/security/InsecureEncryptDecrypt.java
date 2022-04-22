package com.snapchat.kit.sdk.core.security;

import android.util.Base64;

public class InsecureEncryptDecrypt implements EncryptDecryptAlgorithm {
    public String encrypt(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public String decrypt(String str) {
        if (str == null) {
            return null;
        }
        return new String(Base64.decode(str, 0));
    }
}
