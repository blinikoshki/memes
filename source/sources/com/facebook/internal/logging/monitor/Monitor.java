package com.facebook.internal.logging.monitor;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LoggingManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Monitor {
    private static final AtomicLong UNIQUE_EXTRA_ID = new AtomicLong(0);
    private static Integer defaultSamplingRate = 1000;
    private static boolean isEnabled;
    private static final MetricsUtil metricsUtil = MetricsUtil.getInstance();
    private static final LoggingManager monitorLoggingManager = MonitorLoggingManager.getInstance(MonitorLoggingQueue.getInstance(), MonitorLoggingStore.getInstance());
    private static final Random random = new Random();
    private static final Map<String, Integer> samplingRatesMap = new HashMap();

    private Monitor() {
    }

    protected static void enable() {
        if (!isEnabled) {
            isEnabled = true;
            loadSamplingRatesMapAsync();
            monitorLoggingManager.flushLoggingStore();
        }
    }

    static void loadSamplingRatesMapAsync() {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                JSONObject fetchSamplingRate = Monitor.fetchSamplingRate();
                if (fetchSamplingRate != null) {
                    Monitor.updateSamplingRateMap(fetchSamplingRate);
                }
            }
        });
    }

    static JSONObject fetchSamplingRate() {
        Bundle bundle = new Bundle();
        bundle.putString("fields", MonitorLogServerProtocol.MONITOR_CONFIG);
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest((AccessToken) null, FacebookSdk.getApplicationId(), (GraphRequest.Callback) null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest.executeAndWait().getJSONObject();
    }

    static void updateSamplingRateMap(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONObject(MonitorLogServerProtocol.MONITOR_CONFIG).getJSONArray(MonitorLogServerProtocol.SAMPLE_RATES);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("key");
                int i2 = jSONObject2.getInt("value");
                if (MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY.equals(string)) {
                    defaultSamplingRate = Integer.valueOf(i2);
                } else {
                    samplingRatesMap.put(string, Integer.valueOf(i2));
                }
            }
        } catch (JSONException unused) {
        }
    }

    public static void startMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        if (isEnabled && isSampled(performanceEventName.toString())) {
            metricsUtil.startMeasureFor(performanceEventName, j);
        }
    }

    public static void startMeasurePerfFor(PerformanceEventName performanceEventName) {
        startMeasurePerfFor(performanceEventName, getCurrentThreadID());
    }

    public static void stopMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        MonitorLog stopMeasureFor = metricsUtil.stopMeasureFor(performanceEventName, j);
        if (stopMeasureFor.isValid()) {
            addLog(stopMeasureFor);
        }
    }

    public static void stopMeasurePerfFor(PerformanceEventName performanceEventName) {
        stopMeasurePerfFor(performanceEventName, getCurrentThreadID());
    }

    public static void cancelMeasurePerfFor(PerformanceEventName performanceEventName) {
        metricsUtil.removeTempMetricsDataFor(performanceEventName, getCurrentThreadID());
    }

    public static void cancelMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        metricsUtil.removeTempMetricsDataFor(performanceEventName, j);
    }

    public static long generateExtraId() {
        return UNIQUE_EXTRA_ID.incrementAndGet();
    }

    private static long getCurrentThreadID() {
        return Thread.currentThread().getId();
    }

    static void addLog(ExternalLog externalLog) {
        if (isEnabled) {
            monitorLoggingManager.addLog(externalLog);
        }
    }

    public static boolean isEnabled() {
        return isEnabled;
    }

    static boolean isSampled(String str) {
        if (Utility.isNullOrEmpty(str)) {
            return false;
        }
        int intValue = defaultSamplingRate.intValue();
        Map<String, Integer> map = samplingRatesMap;
        if (map.containsKey(str)) {
            intValue = map.get(str).intValue();
        }
        if (intValue <= 0 || random.nextInt(intValue) != 0) {
            return false;
        }
        return true;
    }

    static Integer getDefaultSamplingRate() {
        return defaultSamplingRate;
    }
}
