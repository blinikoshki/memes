package com.iab.omid.library.giphy.p032d;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.giphy.d.a */
public final class C3982a {
    /* renamed from: a */
    public static String m685a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    /* renamed from: b */
    public static String m686b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    /* renamed from: c */
    public static String m687c() {
        return "Android";
    }

    /* renamed from: d */
    public static JSONObject m688d() {
        JSONObject jSONObject = new JSONObject();
        C3983b.m694a(jSONObject, "deviceType", m685a());
        C3983b.m694a(jSONObject, "osVersion", m686b());
        C3983b.m694a(jSONObject, "os", m687c());
        return jSONObject;
    }
}
