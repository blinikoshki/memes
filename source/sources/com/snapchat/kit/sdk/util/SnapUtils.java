package com.snapchat.kit.sdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import androidx.core.content.FileProvider;
import java.io.File;

public class SnapUtils {
    public static boolean isSnapchatInstalled(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (applicationInfo.enabled) {
                if (packageInfo.versionCode >= 1729) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static String getFileProviderAuthority(Context context) {
        return context.getPackageName() + ".fileprovider";
    }

    public static boolean isUiThread() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Looper.getMainLooper().isCurrentThread();
        }
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static Uri getFileProviderUri(Context context, File file) {
        if (file == null) {
            return null;
        }
        return FileProvider.getUriForFile(context, getFileProviderAuthority(context), file);
    }
}
