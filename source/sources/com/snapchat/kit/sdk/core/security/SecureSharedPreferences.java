package com.snapchat.kit.sdk.core.security;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

public class SecureSharedPreferences implements KeyValueStore {
    private static final String TAG = "SecureSharedPreferences";
    private final EncryptDecryptAlgorithm mAlgorithm;
    private final Gson mGson;
    private final SharedPreferences mSharedPreferences;

    public SecureSharedPreferences(SharedPreferences sharedPreferences, EncryptDecryptAlgorithm encryptDecryptAlgorithm, Gson gson) {
        this.mSharedPreferences = sharedPreferences;
        this.mAlgorithm = encryptDecryptAlgorithm;
        this.mGson = gson;
    }

    public String getString(String str, String str2) {
        try {
            String string = this.mSharedPreferences.getString(str, (String) null);
            if (string == null) {
                return str2;
            }
            String decrypt = this.mAlgorithm.decrypt(string);
            if (decrypt != null) {
                return decrypt;
            }
            clearEntry(str);
            return str2;
        } catch (ClassCastException unused) {
            return str2;
        }
    }

    public void putString(String str, String str2) {
        this.mSharedPreferences.edit().putString(str, str2 == null ? null : this.mAlgorithm.encrypt(str2)).apply();
    }

    public <T> T get(String str, Class<T> cls) {
        String string = getString(str, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return this.mGson.fromJson(string, cls);
        } catch (JsonParseException unused) {
            clearEntry(str);
            return null;
        }
    }

    public void put(String str, Object obj) {
        putString(str, this.mGson.toJson(obj));
    }

    public void clearEntry(String str) {
        this.mSharedPreferences.edit().remove(str).apply();
    }
}
