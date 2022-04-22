package com.snapchat.kit.sdk.core.security;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AESEncryptDecrypt implements EncryptDecryptAlgorithm {
    private static final String TAG = "AESEncryptDecrypt";
    private static final int TAG_LENGTH = 128;
    private static final String TRANSFORM = "AES/GCM/NoPadding";
    private final Gson mGson;
    private final SecretKey mSecretKey;

    public AESEncryptDecrypt(SecretKey secretKey, Gson gson) {
        this.mSecretKey = secretKey;
        this.mGson = gson;
    }

    public String encrypt(String str) {
        if (str == null) {
            return null;
        }
        try {
            return this.mGson.toJson((Object) encryptInternal(str));
        } catch (JsonParseException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public String decrypt(String str) {
        EncryptedData encryptedData;
        try {
            encryptedData = (EncryptedData) this.mGson.fromJson(str, EncryptedData.class);
        } catch (JsonParseException unused) {
            encryptedData = null;
        }
        if (!(encryptedData == null || encryptedData.mData == null || encryptedData.mIv == null)) {
            try {
                return decryptInternal(encryptedData);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | InvalidParameterException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused2) {
            }
        }
        return null;
    }

    private EncryptedData encryptInternal(String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance(TRANSFORM);
        instance.init(1, this.mSecretKey);
        return new EncryptedData(Base64.encodeToString(instance.getIV(), 0), Base64.encodeToString(instance.doFinal(str.getBytes()), 0));
    }

    private String decryptInternal(EncryptedData encryptedData) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IllegalArgumentException {
        byte[] decode = Base64.decode(encryptedData.mIv, 0);
        byte[] decode2 = Base64.decode(encryptedData.mData, 0);
        Cipher instance = Cipher.getInstance(TRANSFORM);
        instance.init(2, this.mSecretKey, new GCMParameterSpec(128, decode));
        return new String(instance.doFinal(decode2));
    }

    private static class EncryptedData {
        String mData;
        String mIv;

        EncryptedData(String str, String str2) {
            this.mIv = str;
            this.mData = str2;
        }
    }
}
