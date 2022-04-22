package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonKeysetReader implements KeysetReader {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final boolean closeStreamAfterReading;
    private final InputStream inputStream;
    private final JSONObject json;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream2, boolean z) {
        this.inputStream = inputStream2;
        this.closeStreamAfterReading = z;
        this.json = null;
    }

    private JsonKeysetReader(JSONObject jSONObject) {
        this.json = jSONObject;
        this.inputStream = null;
        this.closeStreamAfterReading = false;
    }

    public static KeysetReader withInputStream(InputStream inputStream2) throws IOException {
        return new JsonKeysetReader(inputStream2, false);
    }

    public static JsonKeysetReader withJsonObject(JSONObject jSONObject) {
        return new JsonKeysetReader(jSONObject);
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader(new ByteArrayInputStream(str.getBytes(UTF_8)), true);
    }

    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader(new ByteArrayInputStream(bArr), true);
    }

    public static JsonKeysetReader withFile(File file) throws IOException {
        return new JsonKeysetReader(new FileInputStream(file), true);
    }

    public static JsonKeysetReader withPath(String str) throws IOException {
        return withFile(new File(str));
    }

    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withFile(path.toFile());
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }

    public Keyset read() throws IOException {
        try {
            JSONObject jSONObject = this.json;
            if (jSONObject != null) {
                Keyset keysetFromJson = keysetFromJson(jSONObject);
                InputStream inputStream2 = this.inputStream;
                if (inputStream2 != null && this.closeStreamAfterReading) {
                    inputStream2.close();
                }
                return keysetFromJson;
            }
            Keyset keysetFromJson2 = keysetFromJson(new JSONObject(new String(Util.readAll(this.inputStream), UTF_8)));
            InputStream inputStream3 = this.inputStream;
            if (inputStream3 != null && this.closeStreamAfterReading) {
                inputStream3.close();
            }
            return keysetFromJson2;
        } catch (JSONException e) {
            throw new IOException(e);
        } catch (Throwable th) {
            InputStream inputStream4 = this.inputStream;
            if (inputStream4 != null && this.closeStreamAfterReading) {
                inputStream4.close();
            }
            throw th;
        }
    }

    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            JSONObject jSONObject = this.json;
            if (jSONObject != null) {
                EncryptedKeyset encryptedKeysetFromJson = encryptedKeysetFromJson(jSONObject);
                InputStream inputStream2 = this.inputStream;
                if (inputStream2 != null && this.closeStreamAfterReading) {
                    inputStream2.close();
                }
                return encryptedKeysetFromJson;
            }
            EncryptedKeyset encryptedKeysetFromJson2 = encryptedKeysetFromJson(new JSONObject(new String(Util.readAll(this.inputStream), UTF_8)));
            InputStream inputStream3 = this.inputStream;
            if (inputStream3 != null && this.closeStreamAfterReading) {
                inputStream3.close();
            }
            return encryptedKeysetFromJson2;
        } catch (JSONException e) {
            throw new IOException(e);
        } catch (Throwable th) {
            InputStream inputStream4 = this.inputStream;
            if (inputStream4 != null && this.closeStreamAfterReading) {
                inputStream4.close();
            }
            throw th;
        }
    }

    private Keyset keysetFromJson(JSONObject jSONObject) throws JSONException {
        validateKeyset(jSONObject);
        Keyset.Builder newBuilder = Keyset.newBuilder();
        if (jSONObject.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(jSONObject.getInt("primaryKeyId"));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("key");
        for (int i = 0; i < jSONArray.length(); i++) {
            newBuilder.addKey(keyFromJson(jSONArray.getJSONObject(i)));
        }
        return (Keyset) newBuilder.build();
    }

    private EncryptedKeyset encryptedKeysetFromJson(JSONObject jSONObject) throws JSONException {
        byte[] bArr;
        validateEncryptedKeyset(jSONObject);
        if (this.urlSafeBase64) {
            bArr = Base64.urlSafeDecode(jSONObject.getString("encryptedKeyset"));
        } else {
            bArr = Base64.decode(jSONObject.getString("encryptedKeyset"));
        }
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArr)).setKeysetInfo(keysetInfoFromJson(jSONObject.getJSONObject("keysetInfo"))).build();
    }

    private Keyset.Key keyFromJson(JSONObject jSONObject) throws JSONException {
        validateKey(jSONObject);
        return (Keyset.Key) Keyset.Key.newBuilder().setStatus(getStatus(jSONObject.getString("status"))).setKeyId(jSONObject.getInt("keyId")).setOutputPrefixType(getOutputPrefixType(jSONObject.getString("outputPrefixType"))).setKeyData(keyDataFromJson(jSONObject.getJSONObject("keyData"))).build();
    }

    private static KeysetInfo keysetInfoFromJson(JSONObject jSONObject) throws JSONException {
        KeysetInfo.Builder newBuilder = KeysetInfo.newBuilder();
        if (jSONObject.has("primaryKeyId")) {
            newBuilder.setPrimaryKeyId(jSONObject.getInt("primaryKeyId"));
        }
        if (jSONObject.has("keyInfo")) {
            JSONArray jSONArray = jSONObject.getJSONArray("keyInfo");
            for (int i = 0; i < jSONArray.length(); i++) {
                newBuilder.addKeyInfo(keyInfoFromJson(jSONArray.getJSONObject(i)));
            }
        }
        return (KeysetInfo) newBuilder.build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JSONObject jSONObject) throws JSONException {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(jSONObject.getString("status"))).setKeyId(jSONObject.getInt("keyId")).setOutputPrefixType(getOutputPrefixType(jSONObject.getString("outputPrefixType"))).setTypeUrl(jSONObject.getString("typeUrl")).build();
    }

    private KeyData keyDataFromJson(JSONObject jSONObject) throws JSONException {
        byte[] bArr;
        validateKeyData(jSONObject);
        if (this.urlSafeBase64) {
            bArr = Base64.urlSafeDecode(jSONObject.getString("value"));
        } else {
            bArr = Base64.decode(jSONObject.getString("value"));
        }
        return (KeyData) KeyData.newBuilder().setTypeUrl(jSONObject.getString("typeUrl")).setValue(ByteString.copyFrom(bArr)).setKeyMaterialType(getKeyMaterialType(jSONObject.getString("keyMaterialType"))).build();
    }

    private static KeyStatusType getStatus(String str) throws JSONException {
        if (str.equals("ENABLED")) {
            return KeyStatusType.ENABLED;
        }
        if (str.equals("DISABLED")) {
            return KeyStatusType.DISABLED;
        }
        throw new JSONException("unknown status: " + str);
    }

    private static OutputPrefixType getOutputPrefixType(String str) throws JSONException {
        if (str.equals("TINK")) {
            return OutputPrefixType.TINK;
        }
        if (str.equals("RAW")) {
            return OutputPrefixType.RAW;
        }
        if (str.equals("LEGACY")) {
            return OutputPrefixType.LEGACY;
        }
        if (str.equals("CRUNCHY")) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new JSONException("unknown output prefix type: " + str);
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String str) throws JSONException {
        if (str.equals("SYMMETRIC")) {
            return KeyData.KeyMaterialType.SYMMETRIC;
        }
        if (str.equals("ASYMMETRIC_PRIVATE")) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
        }
        if (str.equals("ASYMMETRIC_PUBLIC")) {
            return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
        }
        if (str.equals("REMOTE")) {
            return KeyData.KeyMaterialType.REMOTE;
        }
        throw new JSONException("unknown key material type: " + str);
    }

    private static void validateKeyset(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("key") || jSONObject.getJSONArray("key").length() == 0) {
            throw new JSONException("invalid keyset");
        }
    }

    private static void validateEncryptedKeyset(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("encryptedKeyset")) {
            throw new JSONException("invalid encrypted keyset");
        }
    }

    private static void validateKey(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("keyData") || !jSONObject.has("status") || !jSONObject.has("keyId") || !jSONObject.has("outputPrefixType")) {
            throw new JSONException("invalid key");
        }
    }

    private static void validateKeyData(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("typeUrl") || !jSONObject.has("value") || !jSONObject.has("keyMaterialType")) {
            throw new JSONException("invalid keyData");
        }
    }
}
