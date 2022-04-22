package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = "LegacyTokenHelper";
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    public LegacyTokenHelper(Context context) {
        this(context, (String) null);
    }

    public LegacyTokenHelper(Context context, String str) {
        Validate.notNull(context, "context");
        this.cacheKey = Utility.isNullOrEmpty(str) ? DEFAULT_CACHE_KEY : str;
        Context applicationContext = context.getApplicationContext();
        this.cache = (applicationContext != null ? applicationContext : context).getSharedPreferences(this.cacheKey, 0);
    }

    public Bundle load() {
        Bundle bundle = new Bundle();
        for (String next : this.cache.getAll().keySet()) {
            try {
                deserializeKey(next, bundle);
            } catch (JSONException e) {
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = TAG;
                Logger.log(loggingBehavior, 5, str, "Error reading cached value for key: '" + next + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    public void save(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        SharedPreferences.Editor edit = this.cache.edit();
        for (String str : bundle.keySet()) {
            try {
                serializeKey(str, bundle, edit);
            } catch (JSONException e) {
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str2 = TAG;
                Logger.log(loggingBehavior, 5, str2, "Error processing value for key: '" + str + "' -- " + e);
                return;
            }
        }
        edit.apply();
    }

    public void clear() {
        this.cache.edit().clear().apply();
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        String string;
        if (bundle == null || (string = bundle.getString(TOKEN_KEY)) == null || string.length() == 0 || bundle.getLong(EXPIRATION_DATE_KEY, 0) == 0) {
            return false;
        }
        return true;
    }

    public static String getToken(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString(TOKEN_KEY);
    }

    public static void putToken(Bundle bundle, String str) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(str, "value");
        bundle.putString(TOKEN_KEY, str);
    }

    public static Date getExpirationDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, EXPIRATION_DATE_KEY);
    }

    public static void putExpirationDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, EXPIRATION_DATE_KEY, date);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong(EXPIRATION_DATE_KEY);
    }

    public static void putExpirationMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong(EXPIRATION_DATE_KEY, j);
    }

    public static Set<String> getPermissions(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(PERMISSIONS_KEY);
        if (stringArrayList == null) {
            return null;
        }
        return new HashSet(stringArrayList);
    }

    public static void putPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(PERMISSIONS_KEY, new ArrayList(collection));
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(DECLINED_PERMISSIONS_KEY, new ArrayList(collection));
    }

    public static void putExpiredPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(EXPIRED_PERMISSIONS_KEY, new ArrayList(collection));
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        if (bundle.containsKey(TOKEN_SOURCE_KEY)) {
            return (AccessTokenSource) bundle.getSerializable(TOKEN_SOURCE_KEY);
        }
        return bundle.getBoolean(IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        Validate.notNull(bundle, "bundle");
        bundle.putSerializable(TOKEN_SOURCE_KEY, accessTokenSource);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, LAST_REFRESH_DATE_KEY);
    }

    public static void putLastRefreshDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, LAST_REFRESH_DATE_KEY, date);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong(LAST_REFRESH_DATE_KEY);
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong(LAST_REFRESH_DATE_KEY, j);
    }

    public static String getApplicationId(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString(APPLICATION_ID_KEY);
    }

    public static void putApplicationId(Bundle bundle, String str) {
        Validate.notNull(bundle, "bundle");
        bundle.putString(APPLICATION_ID_KEY, str);
    }

    static Date getDate(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, Long.MIN_VALUE);
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return new Date(j);
    }

    static void putDate(Bundle bundle, String str, Date date) {
        bundle.putLong(str, date.getTime());
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void serializeKey(java.lang.String r9, android.os.Bundle r10, android.content.SharedPreferences.Editor r11) throws org.json.JSONException {
        /*
            r8 = this;
            java.lang.Object r10 = r10.get(r9)
            if (r10 != 0) goto L_0x0007
            return
        L_0x0007:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            boolean r1 = r10 instanceof java.lang.Byte
            r2 = 0
            java.lang.String r3 = "value"
            if (r1 == 0) goto L_0x0023
            java.lang.Byte r10 = (java.lang.Byte) r10
            int r10 = r10.intValue()
            r0.put(r3, r10)
            java.lang.String r10 = "byte"
        L_0x001f:
            r1 = r2
            r2 = r10
            goto L_0x019f
        L_0x0023:
            boolean r1 = r10 instanceof java.lang.Short
            if (r1 == 0) goto L_0x0034
            java.lang.Short r10 = (java.lang.Short) r10
            int r10 = r10.intValue()
            r0.put(r3, r10)
            java.lang.String r10 = "short"
            goto L_0x001f
        L_0x0034:
            boolean r1 = r10 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x0044
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r0.put(r3, r10)
            java.lang.String r10 = "int"
            goto L_0x001f
        L_0x0044:
            boolean r1 = r10 instanceof java.lang.Long
            if (r1 == 0) goto L_0x0054
            java.lang.Long r10 = (java.lang.Long) r10
            long r4 = r10.longValue()
            r0.put(r3, r4)
            java.lang.String r10 = "long"
            goto L_0x001f
        L_0x0054:
            boolean r1 = r10 instanceof java.lang.Float
            if (r1 == 0) goto L_0x0064
            java.lang.Float r10 = (java.lang.Float) r10
            double r4 = r10.doubleValue()
            r0.put(r3, r4)
            java.lang.String r10 = "float"
            goto L_0x001f
        L_0x0064:
            boolean r1 = r10 instanceof java.lang.Double
            if (r1 == 0) goto L_0x0074
            java.lang.Double r10 = (java.lang.Double) r10
            double r4 = r10.doubleValue()
            r0.put(r3, r4)
            java.lang.String r10 = "double"
            goto L_0x001f
        L_0x0074:
            boolean r1 = r10 instanceof java.lang.Boolean
            if (r1 == 0) goto L_0x0084
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r0.put(r3, r10)
            java.lang.String r10 = "bool"
            goto L_0x001f
        L_0x0084:
            boolean r1 = r10 instanceof java.lang.Character
            if (r1 == 0) goto L_0x0092
            java.lang.String r10 = r10.toString()
            r0.put(r3, r10)
            java.lang.String r10 = "char"
            goto L_0x001f
        L_0x0092:
            boolean r1 = r10 instanceof java.lang.String
            if (r1 == 0) goto L_0x009f
            java.lang.String r10 = (java.lang.String) r10
            r0.put(r3, r10)
            java.lang.String r10 = "string"
            goto L_0x001f
        L_0x009f:
            boolean r1 = r10 instanceof java.lang.Enum
            if (r1 == 0) goto L_0x00bb
            java.lang.String r1 = r10.toString()
            r0.put(r3, r1)
            java.lang.Class r10 = r10.getClass()
            java.lang.String r10 = r10.getName()
            java.lang.String r1 = "enumType"
            r0.put(r1, r10)
            java.lang.String r10 = "enum"
            goto L_0x001f
        L_0x00bb:
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            boolean r4 = r10 instanceof byte[]
            r5 = 0
            if (r4 == 0) goto L_0x00d8
            byte[] r10 = (byte[]) r10
            byte[] r10 = (byte[]) r10
            int r2 = r10.length
        L_0x00ca:
            if (r5 >= r2) goto L_0x00d4
            byte r4 = r10[r5]
            r1.put(r4)
            int r5 = r5 + 1
            goto L_0x00ca
        L_0x00d4:
            java.lang.String r2 = "byte[]"
            goto L_0x019f
        L_0x00d8:
            boolean r4 = r10 instanceof short[]
            if (r4 == 0) goto L_0x00f0
            short[] r10 = (short[]) r10
            short[] r10 = (short[]) r10
            int r2 = r10.length
        L_0x00e1:
            if (r5 >= r2) goto L_0x00eb
            short r4 = r10[r5]
            r1.put(r4)
            int r5 = r5 + 1
            goto L_0x00e1
        L_0x00eb:
            java.lang.String r2 = "short[]"
            goto L_0x019f
        L_0x00f0:
            boolean r4 = r10 instanceof int[]
            if (r4 == 0) goto L_0x0107
            int[] r10 = (int[]) r10
            int[] r10 = (int[]) r10
            int r2 = r10.length
        L_0x00f9:
            if (r5 >= r2) goto L_0x0103
            r4 = r10[r5]
            r1.put(r4)
            int r5 = r5 + 1
            goto L_0x00f9
        L_0x0103:
            java.lang.String r2 = "int[]"
            goto L_0x019f
        L_0x0107:
            boolean r4 = r10 instanceof long[]
            if (r4 == 0) goto L_0x011e
            long[] r10 = (long[]) r10
            long[] r10 = (long[]) r10
            int r2 = r10.length
        L_0x0110:
            if (r5 >= r2) goto L_0x011a
            r6 = r10[r5]
            r1.put(r6)
            int r5 = r5 + 1
            goto L_0x0110
        L_0x011a:
            java.lang.String r2 = "long[]"
            goto L_0x019f
        L_0x011e:
            boolean r4 = r10 instanceof float[]
            if (r4 == 0) goto L_0x0136
            float[] r10 = (float[]) r10
            float[] r10 = (float[]) r10
            int r2 = r10.length
        L_0x0127:
            if (r5 >= r2) goto L_0x0132
            r4 = r10[r5]
            double r6 = (double) r4
            r1.put(r6)
            int r5 = r5 + 1
            goto L_0x0127
        L_0x0132:
            java.lang.String r2 = "float[]"
            goto L_0x019f
        L_0x0136:
            boolean r4 = r10 instanceof double[]
            if (r4 == 0) goto L_0x014c
            double[] r10 = (double[]) r10
            double[] r10 = (double[]) r10
            int r2 = r10.length
        L_0x013f:
            if (r5 >= r2) goto L_0x0149
            r6 = r10[r5]
            r1.put(r6)
            int r5 = r5 + 1
            goto L_0x013f
        L_0x0149:
            java.lang.String r2 = "double[]"
            goto L_0x019f
        L_0x014c:
            boolean r4 = r10 instanceof boolean[]
            if (r4 == 0) goto L_0x0162
            boolean[] r10 = (boolean[]) r10
            boolean[] r10 = (boolean[]) r10
            int r2 = r10.length
        L_0x0155:
            if (r5 >= r2) goto L_0x015f
            boolean r4 = r10[r5]
            r1.put(r4)
            int r5 = r5 + 1
            goto L_0x0155
        L_0x015f:
            java.lang.String r2 = "bool[]"
            goto L_0x019f
        L_0x0162:
            boolean r4 = r10 instanceof char[]
            if (r4 == 0) goto L_0x017c
            char[] r10 = (char[]) r10
            char[] r10 = (char[]) r10
            int r2 = r10.length
        L_0x016b:
            if (r5 >= r2) goto L_0x0179
            char r4 = r10[r5]
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.put(r4)
            int r5 = r5 + 1
            goto L_0x016b
        L_0x0179:
            java.lang.String r2 = "char[]"
            goto L_0x019f
        L_0x017c:
            boolean r4 = r10 instanceof java.util.List
            if (r4 == 0) goto L_0x019e
            java.util.List r10 = (java.util.List) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0186:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x019a
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0196
            java.lang.Object r2 = org.json.JSONObject.NULL
        L_0x0196:
            r1.put(r2)
            goto L_0x0186
        L_0x019a:
            java.lang.String r2 = "stringList"
            goto L_0x019f
        L_0x019e:
            r1 = r2
        L_0x019f:
            if (r2 == 0) goto L_0x01b3
            java.lang.String r10 = "valueType"
            r0.put(r10, r2)
            if (r1 == 0) goto L_0x01ac
            r0.putOpt(r3, r1)
        L_0x01ac:
            java.lang.String r10 = r0.toString()
            r11.putString(r9, r10)
        L_0x01b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.serializeKey(java.lang.String, android.os.Bundle, android.content.SharedPreferences$Editor):void");
    }

    private void deserializeKey(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject(this.cache.getString(str, "{}"));
        String string = jSONObject.getString(JSON_VALUE_TYPE);
        if (string.equals(TYPE_BOOLEAN)) {
            bundle.putBoolean(str, jSONObject.getBoolean("value"));
            return;
        }
        int i = 0;
        if (string.equals(TYPE_BOOLEAN_ARRAY)) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            int length = jSONArray.length();
            boolean[] zArr = new boolean[length];
            while (i < length) {
                zArr[i] = jSONArray.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
        } else if (string.equals(TYPE_BYTE)) {
            bundle.putByte(str, (byte) jSONObject.getInt("value"));
        } else if (string.equals(TYPE_BYTE_ARRAY)) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("value");
            int length2 = jSONArray2.length();
            byte[] bArr = new byte[length2];
            while (i < length2) {
                bArr[i] = (byte) jSONArray2.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
        } else if (string.equals(TYPE_SHORT)) {
            bundle.putShort(str, (short) jSONObject.getInt("value"));
        } else if (string.equals(TYPE_SHORT_ARRAY)) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("value");
            int length3 = jSONArray3.length();
            short[] sArr = new short[length3];
            while (i < length3) {
                sArr[i] = (short) jSONArray3.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
        } else if (string.equals(TYPE_INTEGER)) {
            bundle.putInt(str, jSONObject.getInt("value"));
        } else if (string.equals(TYPE_INTEGER_ARRAY)) {
            JSONArray jSONArray4 = jSONObject.getJSONArray("value");
            int length4 = jSONArray4.length();
            int[] iArr = new int[length4];
            while (i < length4) {
                iArr[i] = jSONArray4.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
        } else if (string.equals(TYPE_LONG)) {
            bundle.putLong(str, jSONObject.getLong("value"));
        } else if (string.equals(TYPE_LONG_ARRAY)) {
            JSONArray jSONArray5 = jSONObject.getJSONArray("value");
            int length5 = jSONArray5.length();
            long[] jArr = new long[length5];
            while (i < length5) {
                jArr[i] = jSONArray5.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
        } else if (string.equals(TYPE_FLOAT)) {
            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
        } else if (string.equals(TYPE_FLOAT_ARRAY)) {
            JSONArray jSONArray6 = jSONObject.getJSONArray("value");
            int length6 = jSONArray6.length();
            float[] fArr = new float[length6];
            while (i < length6) {
                fArr[i] = (float) jSONArray6.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
        } else if (string.equals(TYPE_DOUBLE)) {
            bundle.putDouble(str, jSONObject.getDouble("value"));
        } else if (string.equals(TYPE_DOUBLE_ARRAY)) {
            JSONArray jSONArray7 = jSONObject.getJSONArray("value");
            int length7 = jSONArray7.length();
            double[] dArr = new double[length7];
            while (i < length7) {
                dArr[i] = jSONArray7.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
        } else if (string.equals(TYPE_CHAR)) {
            String string2 = jSONObject.getString("value");
            if (string2 != null && string2.length() == 1) {
                bundle.putChar(str, string2.charAt(0));
            }
        } else if (string.equals(TYPE_CHAR_ARRAY)) {
            JSONArray jSONArray8 = jSONObject.getJSONArray("value");
            int length8 = jSONArray8.length();
            char[] cArr = new char[length8];
            for (int i2 = 0; i2 < length8; i2++) {
                String string3 = jSONArray8.getString(i2);
                if (string3 != null && string3.length() == 1) {
                    cArr[i2] = string3.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
        } else if (string.equals(TYPE_STRING)) {
            bundle.putString(str, jSONObject.getString("value"));
        } else if (string.equals(TYPE_STRING_LIST)) {
            JSONArray jSONArray9 = jSONObject.getJSONArray("value");
            int length9 = jSONArray9.length();
            ArrayList arrayList = new ArrayList(length9);
            while (i < length9) {
                Object obj = jSONArray9.get(i);
                arrayList.add(i, obj == JSONObject.NULL ? null : (String) obj);
                i++;
            }
            bundle.putStringArrayList(str, arrayList);
        } else if (string.equals(TYPE_ENUM)) {
            try {
                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString("value")));
            } catch (ClassNotFoundException | IllegalArgumentException unused) {
            }
        }
    }
}
