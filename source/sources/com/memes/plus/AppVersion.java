package com.memes.plus;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/plus/AppVersion;", "", "()V", "packageInfoAvailable", "", "<set-?>", "", "packageVersionCode", "getPackageVersionCode", "()J", "", "packageVersionName", "getPackageVersionName", "()Ljava/lang/String;", "init", "", "context", "Landroid/content/Context;", "isPackageInfoAvailable", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AppVersion.kt */
public final class AppVersion {
    public static final AppVersion INSTANCE = new AppVersion();
    private static boolean packageInfoAvailable;
    private static long packageVersionCode = ((long) 73);
    private static String packageVersionName = BuildConfig.VERSION_NAME;

    private AppVersion() {
    }

    public final String getPackageVersionName() {
        return packageVersionName;
    }

    public final long getPackageVersionCode() {
        return packageVersionCode;
    }

    public final boolean isPackageInfoAvailable() {
        return packageInfoAvailable;
    }

    public final void init(Context context) {
        long j;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            packageInfoAvailable = true;
            String str = packageInfo.versionName;
            Intrinsics.checkNotNullExpressionValue(str, "packageInfo.versionName");
            packageVersionName = str;
            if (Build.VERSION.SDK_INT >= 28) {
                Intrinsics.checkNotNullExpressionValue(packageInfo, "packageInfo");
                j = packageInfo.getLongVersionCode();
            } else {
                j = (long) packageInfo.versionCode;
            }
            packageVersionCode = j;
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfoAvailable = false;
        }
    }
}
