package coil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.StatFs;
import androidx.core.content.ContextCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\n2\b\b\u0001\u0010\u0015\u001a\u00020\n2\b\b\u0001\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\""}, mo26107d2 = {"Lcoil/util/Utils;", "", "()V", "CACHE_DIRECTORY_NAME", "", "DEFAULT_BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "DEFAULT_MEMORY_CLASS_MEGABYTES", "", "DISK_CACHE_PERCENTAGE", "", "LOW_MEMORY_MULTIPLIER", "MAX_DISK_CACHE_SIZE_BYTES", "", "MIN_DISK_CACHE_SIZE_BYTES", "REQUEST_TYPE_ENQUEUE", "REQUEST_TYPE_EXECUTE", "STANDARD_MULTIPLIER", "calculateAllocationByteCount", "width", "height", "config", "calculateAvailableMemorySize", "context", "Landroid/content/Context;", "percentage", "calculateDiskCacheSize", "cacheDirectory", "Ljava/io/File;", "getDefaultAvailableMemoryPercentage", "getDefaultBitmapPoolPercentage", "getDefaultCacheDirectory", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: Utils.kt */
public final class Utils {
    private static final String CACHE_DIRECTORY_NAME = "image_cache";
    private static final int DEFAULT_MEMORY_CLASS_MEGABYTES = 256;
    private static final double DISK_CACHE_PERCENTAGE = 0.02d;
    public static final Utils INSTANCE = new Utils();
    private static final double LOW_MEMORY_MULTIPLIER = 0.15d;
    private static final long MAX_DISK_CACHE_SIZE_BYTES = 262144000;
    private static final long MIN_DISK_CACHE_SIZE_BYTES = 10485760;
    public static final int REQUEST_TYPE_ENQUEUE = 0;
    public static final int REQUEST_TYPE_EXECUTE = 1;
    private static final double STANDARD_MULTIPLIER = 0.2d;

    private Utils() {
    }

    public final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return Build.VERSION.SDK_INT >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
    }

    public final int calculateAllocationByteCount(int i, int i2, Bitmap.Config config) {
        return i * i2 * Bitmaps.getBytesPerPixel(config);
    }

    public final File getDefaultCacheDirectory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getCacheDir(), CACHE_DIRECTORY_NAME);
        file.mkdirs();
        return file;
    }

    public final long calculateDiskCacheSize(File file) {
        Intrinsics.checkNotNullParameter(file, "cacheDirectory");
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return RangesKt.coerceIn((long) (DISK_CACHE_PERCENTAGE * ((double) (Build.VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount())) * ((double) (Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize()))), (long) MIN_DISK_CACHE_SIZE_BYTES, (long) MAX_DISK_CACHE_SIZE_BYTES);
        } catch (Exception unused) {
            return MIN_DISK_CACHE_SIZE_BYTES;
        }
    }

    public final double getDefaultBitmapPoolPercentage() {
        if (Build.VERSION.SDK_INT >= 24) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return Build.VERSION.SDK_INT >= 19 ? 0.5d : 0.25d;
    }

    public final long calculateAvailableMemorySize(Context context, double d) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            if (systemService != null) {
                ActivityManager activityManager = (ActivityManager) systemService;
                i = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                double d2 = (double) 1024;
                return (long) (d * ((double) i) * d2 * d2);
            }
            throw new IllegalStateException(("System service of type " + ActivityManager.class + " was not found.").toString());
        } catch (Exception unused) {
            i = 256;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double getDefaultAvailableMemoryPercentage(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            java.lang.Class<android.app.ActivityManager> r2 = android.app.ActivityManager.class
            java.lang.Object r5 = androidx.core.content.ContextCompat.getSystemService(r5, r2)     // Catch:{ Exception -> 0x0050 }
            if (r5 == 0) goto L_0x002c
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5     // Catch:{ Exception -> 0x0050 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0050 }
            r3 = 19
            if (r2 < r3) goto L_0x0023
            boolean r5 = r5.isLowRamDevice()     // Catch:{ Exception -> 0x0050 }
            if (r5 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r5 = 0
            goto L_0x0024
        L_0x0023:
            r5 = 1
        L_0x0024:
            if (r5 == 0) goto L_0x0050
            r0 = 4594572339843380019(0x3fc3333333333333, double:0.15)
            goto L_0x0050
        L_0x002c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r5.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = "System service of type "
            r5.append(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.Class<android.app.ActivityManager> r2 = android.app.ActivityManager.class
            r5.append(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = " was not found."
            r5.append(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0050 }
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0050 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0050 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ Exception -> 0x0050 }
            throw r2     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Utils.getDefaultAvailableMemoryPercentage(android.content.Context):double");
    }
}
