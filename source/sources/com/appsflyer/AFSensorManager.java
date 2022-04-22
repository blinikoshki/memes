package com.appsflyer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.appsflyer.internal.C1079t;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AFSensorManager {
    private static final BitSet AFDeepLinkManager;
    private static final Handler getRequestListener = new Handler(Looper.getMainLooper());
    public static volatile AFSensorManager sInstance;
    final Handler $$a;
    boolean $$b;
    final Object AFDateFormat = new Object();
    /* access modifiers changed from: private */
    public final Map<C1079t, C1079t> AFEvent;
    long collectIntentsFromActivities;
    /* access modifiers changed from: private */
    public final Map<C1079t, Map<String, Object>> context;
    final Runnable dateFormatUTC;
    /* access modifiers changed from: package-private */
    public int getDataFormatter;
    /* access modifiers changed from: package-private */
    public final Executor getInstance;
    /* access modifiers changed from: private */
    public final Runnable isEncrypt;
    /* access modifiers changed from: private */
    public final SensorManager requestListener;
    /* access modifiers changed from: private */
    public boolean urlString;
    final Runnable valueOf;
    final Runnable values;

    static {
        BitSet bitSet = new BitSet(6);
        AFDeepLinkManager = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private AFSensorManager(SensorManager sensorManager, Handler handler) {
        BitSet bitSet = AFDeepLinkManager;
        this.AFEvent = new HashMap(bitSet.size());
        this.context = new ConcurrentHashMap(bitSet.size());
        this.values = new Runnable() {
            public final void run() {
                synchronized (AFSensorManager.this.AFDateFormat) {
                    AFSensorManager aFSensorManager = AFSensorManager.this;
                    aFSensorManager.getInstance.execute(new Runnable() {
                        public final void run() {
                            try {
                                for (Sensor next : AFSensorManager.this.requestListener.getSensorList(-1)) {
                                    if (AFSensorManager.AFDateFormat(next.getType())) {
                                        C1079t tVar = new C1079t(next, AFSensorManager.this.getInstance);
                                        if (!AFSensorManager.this.AFEvent.containsKey(tVar)) {
                                            AFSensorManager.this.AFEvent.put(tVar, tVar);
                                        }
                                        AFSensorManager.this.requestListener.registerListener((SensorEventListener) AFSensorManager.this.AFEvent.get(tVar), next, 0);
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            boolean unused2 = AFSensorManager.this.urlString = true;
                        }
                    });
                    AFSensorManager.this.$$a.postDelayed(AFSensorManager.this.isEncrypt, 100);
                    AFSensorManager.this.$$b = true;
                }
            }
        };
        this.valueOf = new Runnable() {
            public final void run() {
                synchronized (AFSensorManager.this.AFDateFormat) {
                    AFSensorManager aFSensorManager = AFSensorManager.this;
                    aFSensorManager.getInstance.execute(new Runnable() {
                        public final void run() {
                            try {
                                if (!AFSensorManager.this.AFEvent.isEmpty()) {
                                    for (C1079t tVar : AFSensorManager.this.AFEvent.values()) {
                                        AFSensorManager.this.requestListener.unregisterListener(tVar);
                                        tVar.valueOf(AFSensorManager.this.context, true);
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            int unused2 = AFSensorManager.this.getDataFormatter = 0;
                            boolean unused3 = AFSensorManager.this.urlString = false;
                        }
                    });
                }
            }
        };
        this.dateFormatUTC = new Runnable() {
            public final void run() {
                synchronized (AFSensorManager.this.AFDateFormat) {
                    if (AFSensorManager.this.$$b) {
                        AFSensorManager.this.$$a.removeCallbacks(AFSensorManager.this.values);
                        AFSensorManager.this.$$a.removeCallbacks(AFSensorManager.this.valueOf);
                        AFSensorManager aFSensorManager = AFSensorManager.this;
                        aFSensorManager.getInstance.execute(new Runnable() {
                            public final void run() {
                                try {
                                    if (!AFSensorManager.this.AFEvent.isEmpty()) {
                                        for (C1079t tVar : AFSensorManager.this.AFEvent.values()) {
                                            AFSensorManager.this.requestListener.unregisterListener(tVar);
                                            tVar.valueOf(AFSensorManager.this.context, true);
                                        }
                                    }
                                } catch (Throwable unused) {
                                }
                                int unused2 = AFSensorManager.this.getDataFormatter = 0;
                                boolean unused3 = AFSensorManager.this.urlString = false;
                            }
                        });
                        AFSensorManager.this.$$b = false;
                    }
                }
            }
        };
        this.getDataFormatter = 1;
        this.collectIntentsFromActivities = 0;
        this.isEncrypt = new Runnable() {
            public final void run() {
                synchronized (AFSensorManager.this.AFDateFormat) {
                    if (AFSensorManager.this.getDataFormatter == 0) {
                        int unused = AFSensorManager.this.getDataFormatter = 1;
                    }
                    AFSensorManager.this.$$a.postDelayed(AFSensorManager.this.valueOf, ((long) AFSensorManager.this.getDataFormatter) * 500);
                }
            }
        };
        this.getInstance = Executors.newSingleThreadExecutor();
        this.requestListener = sensorManager;
        this.$$a = handler;
    }

    static AFSensorManager $$b(Context context2) {
        if (sInstance != null) {
            return sInstance;
        }
        return AFDateFormat((SensorManager) context2.getApplicationContext().getSystemService("sensor"), getRequestListener);
    }

    private static AFSensorManager AFDateFormat(SensorManager sensorManager, Handler handler) {
        if (sInstance == null) {
            synchronized (AFSensorManager.class) {
                if (sInstance == null) {
                    sInstance = new AFSensorManager(sensorManager, handler);
                }
            }
        }
        return sInstance;
    }

    /* access modifiers changed from: private */
    public static boolean AFDateFormat(int i) {
        return i >= 0 && AFDeepLinkManager.get(i);
    }

    /* access modifiers changed from: package-private */
    public final List<Map<String, Object>> valueOf() {
        for (C1079t valueOf2 : this.AFEvent.values()) {
            valueOf2.valueOf(this.context, true);
        }
        Map<C1079t, Map<String, Object>> map = this.context;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.context.values());
    }

    /* access modifiers changed from: package-private */
    public final List<Map<String, Object>> values() {
        synchronized (this.AFDateFormat) {
            if (!this.AFEvent.isEmpty() && this.urlString) {
                for (C1079t valueOf2 : this.AFEvent.values()) {
                    valueOf2.valueOf(this.context, false);
                }
            }
            if (this.context.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.context.values());
            return copyOnWriteArrayList2;
        }
    }
}
