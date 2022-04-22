package com.iab.omid.library.giphy.p032d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.giphy.d.b */
public class C3983b {

    /* renamed from: a */
    static float f858a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b */
    private static WindowManager f859b;

    /* renamed from: c */
    private static String[] f860c = {"x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY};

    /* renamed from: com.iab.omid.library.giphy.d.b$a */
    private static class C3984a {

        /* renamed from: a */
        final float f861a;

        /* renamed from: b */
        final float f862b;

        C3984a(float f, float f2) {
            this.f861a = f;
            this.f862b = f2;
        }
    }

    /* renamed from: a */
    static float m689a(int i) {
        return ((float) i) / f858a;
    }

    /* renamed from: a */
    public static JSONObject m690a(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) m689a(i));
            jSONObject.put("y", (double) m689a(i2));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (double) m689a(i3));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (double) m689a(i4));
        } catch (JSONException e) {
            C3985c.m705a("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m691a(Context context) {
        if (context != null) {
            f858a = context.getResources().getDisplayMetrics().density;
            f859b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: a */
    public static void m692a(JSONObject jSONObject) {
        C3984a b = m698b(jSONObject);
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (double) b.f861a);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (double) b.f862b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m693a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C3985c.m705a("Error with setting ad session id", e);
        }
    }

    /* renamed from: a */
    public static void m694a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            C3985c.m705a("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: a */
    public static void m695a(JSONObject jSONObject, List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
        } catch (JSONException e) {
            C3985c.m705a("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: a */
    public static void m696a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m697a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: b */
    private static C3984a m698b(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT < 17) {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f3 = 0.0f;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                        double optDouble4 = optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                        f2 = Math.max(f2, (float) (optDouble + optDouble3));
                        f3 = Math.max(f3, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f3;
                return new C3984a(f2, f);
            }
        } else if (f859b != null) {
            Point point = new Point(0, 0);
            f859b.getDefaultDisplay().getRealSize(point);
            f2 = m689a(point.x);
            f = m689a(point.y);
            return new C3984a(f2, f);
        }
        f = 0.0f;
        return new C3984a(f2, f);
    }

    /* renamed from: b */
    public static boolean m699b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m700c(jSONObject, jSONObject2) && m701d(jSONObject, jSONObject2) && m702e(jSONObject, jSONObject2) && m703f(jSONObject, jSONObject2);
    }

    /* renamed from: c */
    private static boolean m700c(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f860c) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m701d(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    /* renamed from: e */
    private static boolean m702e(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m697a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!optJSONArray.optString(i, "").equals(optJSONArray2.optString(i, ""))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private static boolean m703f(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!m697a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            if (!m699b(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                return false;
            }
        }
        return true;
    }
}
