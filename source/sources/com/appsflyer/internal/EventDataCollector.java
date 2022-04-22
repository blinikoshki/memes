package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.appsflyer.AndroidUtils;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.ServerParameters;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class EventDataCollector {
    private final SharedPreferences AFDateFormat;
    private final Application values;

    public EventDataCollector(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.values = application;
        this.AFDateFormat = AppsFlyerLibCore.getSharedPreferences(application);
    }

    public String signature() throws CertificateException, NoSuchAlgorithmException, PackageManager.NameNotFoundException {
        return AndroidUtils.signature(this.values.getPackageManager(), this.values.getPackageName());
    }

    public long bootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public String disk() {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 18) {
            long blockSizeLong = statFs.getBlockSizeLong();
            j2 = statFs.getAvailableBlocksLong() * blockSizeLong;
            j = statFs.getBlockCountLong() * blockSizeLong;
        } else {
            int blockSize = statFs.getBlockSize();
            j2 = (long) (statFs.getAvailableBlocks() * blockSize);
            j = (long) (statFs.getBlockCount() * blockSize);
        }
        double pow = Math.pow(2.0d, 20.0d);
        StringBuilder sb = new StringBuilder();
        sb.append((long) (((double) j2) / pow));
        sb.append("/");
        sb.append((long) (((double) j) / pow));
        return sb.toString();
    }

    public long getLong(String str) {
        return this.AFDateFormat.getLong(str, 0);
    }

    public String getString(String str) {
        return this.AFDateFormat.getString(str, (String) null);
    }

    public void set(String str, long j) {
        this.AFDateFormat.edit().putLong(str, j).apply();
    }

    public void set(String str, String str2) {
        this.AFDateFormat.edit().putString(str, str2).apply();
    }

    public void init() {
        if ($$b()) {
            set(ServerParameters.INIT_TS, System.currentTimeMillis());
        }
    }

    public void foreground() {
        if ($$b()) {
            set(ServerParameters.FG_TS, System.currentTimeMillis());
        }
    }

    private boolean $$b() {
        return AppsFlyerLibCore.getInstance().getLaunchCounter(this.AFDateFormat, false) == 0;
    }
}
