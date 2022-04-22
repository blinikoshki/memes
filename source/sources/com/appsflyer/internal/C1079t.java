package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* renamed from: com.appsflyer.internal.t */
public final class C1079t implements SensorEventListener {
    double $$a;
    final long[] $$b = new long[2];
    long AFDateFormat;
    private final int AFDeepLinkManager;
    private final String collectIntentsFromActivities;
    private final Executor dateFormatUTC;
    private final String getInstance;
    final float[][] valueOf = new float[2][];
    private final int values;

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public C1079t(Sensor sensor, Executor executor) {
        this.dateFormatUTC = executor;
        int type = sensor.getType();
        this.values = type;
        String name = sensor.getName();
        String str = "";
        name = name == null ? str : name;
        this.getInstance = name;
        String vendor = sensor.getVendor();
        str = vendor != null ? vendor : str;
        this.collectIntentsFromActivities = str;
        this.AFDeepLinkManager = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
    }

    static double AFDateFormat(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < min; i++) {
            d += StrictMath.pow((double) (fArr[i] - fArr2[i]), 2.0d);
        }
        return Math.sqrt(d);
    }

    /* access modifiers changed from: private */
    public static boolean $$b(Sensor sensor) {
        return (sensor == null || sensor.getName() == null || sensor.getVendor() == null) ? false : true;
    }

    private static List<Float> $$b(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf2 : fArr) {
            arrayList.add(Float.valueOf(valueOf2));
        }
        return arrayList;
    }

    public final void onSensorChanged(final SensorEvent sensorEvent) {
        this.dateFormatUTC.execute(new Runnable() {
            public final void run() {
                SensorEvent sensorEvent = sensorEvent;
                if (sensorEvent != null && sensorEvent.values != null && C1079t.$$b(sensorEvent.sensor)) {
                    C1079t tVar = C1079t.this;
                    int type = sensorEvent.sensor.getType();
                    String name = sensorEvent.sensor.getName();
                    String vendor = sensorEvent.sensor.getVendor();
                    long j = sensorEvent.timestamp;
                    float[] fArr = sensorEvent.values;
                    if (tVar.values(type, name, vendor)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        float[] fArr2 = tVar.valueOf[0];
                        if (fArr2 == null) {
                            tVar.valueOf[0] = Arrays.copyOf(fArr, fArr.length);
                            tVar.$$b[0] = currentTimeMillis;
                            return;
                        }
                        float[] fArr3 = tVar.valueOf[1];
                        if (fArr3 == null) {
                            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                            tVar.valueOf[1] = copyOf;
                            tVar.$$b[1] = currentTimeMillis;
                            tVar.$$a = C1079t.AFDateFormat(fArr2, copyOf);
                        } else if (50000000 <= j - tVar.AFDateFormat) {
                            tVar.AFDateFormat = j;
                            if (Arrays.equals(fArr3, fArr)) {
                                tVar.$$b[1] = currentTimeMillis;
                                return;
                            }
                            double AFDateFormat2 = C1079t.AFDateFormat(fArr2, fArr);
                            if (AFDateFormat2 > tVar.$$a) {
                                tVar.valueOf[1] = Arrays.copyOf(fArr, fArr.length);
                                tVar.$$b[1] = currentTimeMillis;
                                tVar.$$a = AFDateFormat2;
                            }
                        }
                    }
                }
            }
        });
    }

    public final void valueOf(Map<C1079t, Map<String, Object>> map, boolean z) {
        if (valueOf()) {
            map.put(this, values());
            if (z) {
                int length = this.valueOf.length;
                for (int i = 0; i < length; i++) {
                    this.valueOf[i] = null;
                }
                int length2 = this.$$b.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.$$b[i2] = 0;
                }
                this.$$a = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                this.AFDateFormat = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, values());
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean values(int i, String str, String str2) {
        return this.values == i && this.getInstance.equals(str) && this.collectIntentsFromActivities.equals(str2);
    }

    private Map<String, Object> values() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.getInstance);
        concurrentHashMap.put("sV", this.collectIntentsFromActivities);
        float[] fArr = this.valueOf[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", $$b(fArr));
        }
        float[] fArr2 = this.valueOf[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", $$b(fArr2));
        }
        return concurrentHashMap;
    }

    private boolean valueOf() {
        return this.valueOf[0] != null;
    }

    public final int hashCode() {
        return this.AFDeepLinkManager;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1079t)) {
            return false;
        }
        C1079t tVar = (C1079t) obj;
        return values(tVar.values, tVar.getInstance, tVar.collectIntentsFromActivities);
    }
}
