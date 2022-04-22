package com.snapchat.kit.sdk.core.security;

import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SecretKeyFactory {
    private static final String ALGORITHM = "AES";
    private static final String ALIAS = "SnapConnectSDK.AES";
    private static final int KEY_LENGTH = 256;
    private static final int KEY_LENGTH_IN_BYTES = 32;
    private static final String SECRET_KEY_KEY = "encoded_secret";
    private static final String TAG = "SecretKeyFactory";

    private SecretKeyFactory() {
    }

    public static SecretGenerationResult getFromKeyStore(KeyStore keyStore) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            if (keyStore.containsAlias(ALIAS)) {
                return new SecretGenerationResult(((KeyStore.SecretKeyEntry) keyStore.getEntry(ALIAS, (KeyStore.ProtectionParameter) null)).getSecretKey(), false);
            }
        } catch (KeyStoreException | UnrecoverableEntryException unused) {
        }
        KeyGenerator instance = KeyGenerator.getInstance(ALGORITHM, keyStore.getType());
        instance.init(new KeyGenParameterSpec.Builder(ALIAS, 3).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build());
        return new SecretGenerationResult(instance.generateKey(), true);
    }

    public static SecretGenerationResult getFromSharedPreferences(SharedPreferences sharedPreferences, EncryptDecryptAlgorithm encryptDecryptAlgorithm, boolean z) throws NoSuchAlgorithmException {
        boolean z2;
        String string;
        SecretKey secretKey = null;
        if (!z && (string = sharedPreferences.getString(SECRET_KEY_KEY, (String) null)) != null) {
            secretKey = decodeSecret(string, 32, encryptDecryptAlgorithm);
        }
        if (secretKey == null) {
            z2 = true;
            secretKey = generate();
            sharedPreferences.edit().putString(SECRET_KEY_KEY, encodeSecret(secretKey, encryptDecryptAlgorithm)).apply();
        } else {
            z2 = false;
        }
        return new SecretGenerationResult(secretKey, z2);
    }

    private static SecretKey generate() throws NoSuchAlgorithmException {
        KeyGenerator instance = KeyGenerator.getInstance(ALGORITHM);
        instance.init(256);
        return instance.generateKey();
    }

    private static String encodeSecret(SecretKey secretKey, EncryptDecryptAlgorithm encryptDecryptAlgorithm) {
        return encryptDecryptAlgorithm.encrypt(new String(secretKey.getEncoded()));
    }

    private static SecretKey decodeSecret(String str, int i, EncryptDecryptAlgorithm encryptDecryptAlgorithm) {
        String decrypt = encryptDecryptAlgorithm.decrypt(str);
        if (decrypt == null) {
            return null;
        }
        return new SecretKeySpec(decrypt.getBytes(), decrypt.length() - i, i, ALGORITHM);
    }
}
