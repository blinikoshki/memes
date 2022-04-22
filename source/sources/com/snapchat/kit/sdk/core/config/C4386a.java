package com.snapchat.kit.sdk.core.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* renamed from: com.snapchat.kit.sdk.core.config.a */
public final class C4386a implements Serializable {
    @SerializedName("query")

    /* renamed from: a */
    private final String f1105a;
    @SerializedName("variables")

    /* renamed from: b */
    private final Map<String, Object> f1106b;

    public C4386a(String str, Map<String, Object> map) {
        this.f1105a = str;
        this.f1106b = map;
    }
}
