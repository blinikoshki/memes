package com.snapchat.kit.sdk.creative.media;

import android.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SnapLensLaunchData {

    /* renamed from: a */
    private String f1281a;

    /* synthetic */ SnapLensLaunchData(String str, byte b) {
        this(str);
    }

    private SnapLensLaunchData(String str) {
        this.f1281a = str;
    }

    public String getLensLaunchData() {
        return this.f1281a;
    }

    public static class Builder {

        /* renamed from: a */
        private Map<String, Object> f1282a = new HashMap();

        public Builder addStringKeyPair(String str, String str2) {
            this.f1282a.put(str, str2);
            return this;
        }

        public Builder addNumberKeyPair(String str, Number number) {
            this.f1282a.put(str, number);
            return this;
        }

        public Builder addStringArrayKeyPair(String str, String[] strArr) {
            this.f1282a.put(str, strArr);
            return this;
        }

        public Builder addNumberArrayKeyPair(String str, Number[] numberArr) {
            this.f1282a.put(str, numberArr);
            return this;
        }

        public SnapLensLaunchData build() {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry next : this.f1282a.entrySet()) {
                    Object value = next.getValue();
                    if (value != null) {
                        if (value.getClass().isArray()) {
                            jSONObject.put((String) next.getKey(), new JSONArray(value));
                        } else {
                            jSONObject.put((String) next.getKey(), value);
                        }
                    }
                }
                return new SnapLensLaunchData(Base64.encodeToString(jSONObject.toString().getBytes(), 2), (byte) 0);
            } catch (JSONException unused) {
                return null;
            }
        }
    }
}
