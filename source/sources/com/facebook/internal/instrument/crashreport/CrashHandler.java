package com.facebook.internal.instrument.crashreport;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final int MAX_CRASH_REPORT_NUM = 5;
    private static final String TAG = "com.facebook.internal.instrument.crashreport.CrashHandler";
    private static CrashHandler instance;
    private final Thread.UncaughtExceptionHandler mPreviousHandler;

    private CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mPreviousHandler = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (InstrumentUtility.isSDKRelatedException(th)) {
            ExceptionAnalyzer.execute(th);
            InstrumentData.Builder.build(th, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mPreviousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public static synchronized void enable() {
        synchronized (CrashHandler.class) {
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                sendExceptionReports();
            }
            if (instance != null) {
                Log.w(TAG, "Already enabled!");
                return;
            }
            CrashHandler crashHandler = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler());
            instance = crashHandler;
            Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        }
    }

    private static void sendExceptionReports() {
        if (!Utility.isDataProcessingRestricted()) {
            File[] listExceptionReportFiles = InstrumentUtility.listExceptionReportFiles();
            final ArrayList arrayList = new ArrayList();
            int i = 0;
            for (File load : listExceptionReportFiles) {
                InstrumentData load2 = InstrumentData.Builder.load(load);
                if (load2.isValid()) {
                    arrayList.add(load2);
                }
            }
            Collections.sort(arrayList, new Comparator<InstrumentData>() {
                public int compare(InstrumentData instrumentData, InstrumentData instrumentData2) {
                    return instrumentData.compareTo(instrumentData2);
                }
            });
            JSONArray jSONArray = new JSONArray();
            while (i < arrayList.size() && i < 5) {
                jSONArray.put(arrayList.get(i));
                i++;
            }
            InstrumentUtility.sendReports("crash_reports", jSONArray, new GraphRequest.Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    try {
                        if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                            for (int i = 0; arrayList.size() > i; i++) {
                                ((InstrumentData) arrayList.get(i)).clear();
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            });
        }
    }
}
