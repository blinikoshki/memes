package com.snapchat.kit.sdk.core.security;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.x500.X500Principal;

public class RSAEncryptDecrypt implements EncryptDecryptAlgorithm {
    private static final String ALGORITHM = "RSA";
    private static final String ALIAS = "SnapConnectSDK.RSA";
    private static final int KEY_SIZE = 8192;
    private static final String TAG = "RSAEncryptDecrypt";
    private static final String TRANSFORM = "RSA/None/NoPadding";
    private final KeyPair mKeyPair;

    public RSAEncryptDecrypt(KeyStore keyStore, Context context, PublicKeyParams publicKeyParams) throws NoSuchAlgorithmException, NoSuchProviderException, UnrecoverableEntryException, InvalidAlgorithmParameterException, KeyStoreException {
        this.mKeyPair = getKeyPair(keyStore, context, publicKeyParams);
    }

    public String encrypt(String str) {
        if (str == null) {
            return null;
        }
        try {
            return encryptInternal(str);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public String decrypt(String str) {
        if (str == null) {
            return null;
        }
        try {
            return decryptInternal(str);
        } catch (IllegalArgumentException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public PublicKeyParams getPublicKeyParams() {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) this.mKeyPair.getPublic();
        return new PublicKeyParams(rSAPublicKey.getModulus().toString(), rSAPublicKey.getPublicExponent().toString());
    }

    private String encryptInternal(String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance(TRANSFORM);
        instance.init(1, this.mKeyPair.getPublic());
        return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
    }

    private String decryptInternal(String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IllegalArgumentException {
        Cipher instance = Cipher.getInstance(TRANSFORM);
        instance.init(2, this.mKeyPair.getPrivate());
        return new String(instance.doFinal(Base64.decode(str, 0)));
    }

    private static KeyPair getKeyPair(KeyStore keyStore, Context context, PublicKeyParams publicKeyParams) throws NoSuchAlgorithmException, NoSuchProviderException, UnrecoverableEntryException, InvalidAlgorithmParameterException, KeyStoreException {
        if (!(publicKeyParams == null || publicKeyParams.mModulus == null || publicKeyParams.mPublicExp == null || !keyStore.containsAlias(ALIAS))) {
            try {
                return new KeyPair(KeyFactory.getInstance(ALGORITHM).generatePublic(new RSAPublicKeySpec(new BigInteger(publicKeyParams.mModulus), new BigInteger(publicKeyParams.mPublicExp))), ((KeyStore.PrivateKeyEntry) keyStore.getEntry(ALIAS, (KeyStore.ProtectionParameter) null)).getPrivateKey());
            } catch (InvalidKeySpecException unused) {
            }
        }
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        instance.add(1, 1);
        Date time2 = instance.getTime();
        KeyPairGenerator instance2 = KeyPairGenerator.getInstance(ALGORITHM, keyStore.getType());
        instance2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias(ALIAS).setStartDate(time).setEndDate(time2).setSubject(new X500Principal("CN=SnapConnectSDK.RSA")).setSerialNumber(BigInteger.ONE).setKeySize(8192).build());
        return instance2.generateKeyPair();
    }

    public static class PublicKeyParams {
        String mModulus;
        String mPublicExp;

        private PublicKeyParams(String str, String str2) {
            this.mModulus = str;
            this.mPublicExp = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PublicKeyParams)) {
                return false;
            }
            PublicKeyParams publicKeyParams = (PublicKeyParams) obj;
            if (!Objects.equals(this.mModulus, publicKeyParams.mModulus) || !Objects.equals(this.mPublicExp, publicKeyParams.mPublicExp)) {
                return false;
            }
            return true;
        }
    }
}
