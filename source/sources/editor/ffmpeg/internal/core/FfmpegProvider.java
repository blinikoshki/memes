package editor.ffmpeg.internal.core;

import android.content.Context;
import android.os.Build;
import editor.ffmpeg.internal.arch.CpuArch;
import editor.ffmpeg.internal.arch.CpuArchHelper;
import editor.ffmpeg.internal.exception.FfmpegMissingException;
import editor.ffmpeg.internal.exception.FfmpegNotSupportedException;
import editor.ffmpeg.internal.util.DeviceConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo26107d2 = {"Leditor/ffmpeg/internal/core/FfmpegProvider;", "", "()V", "ffmpegLibPath", "", "isDeveloperMode", "", "createFor", "Leditor/ffmpeg/internal/core/FfmpegBinary;", "context", "Landroid/content/Context;", "getFfmpegFilePath", "environmentVars", "", "printCpuAbis", "", "printDeviceName", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegProvider.kt */
public final class FfmpegProvider {
    public static final FfmpegProvider INSTANCE = new FfmpegProvider();
    /* access modifiers changed from: private */
    public static String ffmpegLibPath;
    private static boolean isDeveloperMode;

    private FfmpegProvider() {
    }

    public static final /* synthetic */ String access$getFfmpegLibPath$p(FfmpegProvider ffmpegProvider) {
        String str = ffmpegLibPath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ffmpegLibPath");
        }
        return str;
    }

    public final FfmpegBinary createFor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isDeveloperMode = true;
        String absolutePath = new FfmpegLibraryFinder(context).find().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "FfmpegLibraryFinder(context).find().absolutePath");
        ffmpegLibPath = absolutePath;
        if (CpuArchHelper.INSTANCE.getCpuArch() != CpuArch.NONE) {
            return new Ffmpeg();
        }
        throw new FfmpegNotSupportedException();
    }

    public static /* synthetic */ String getFfmpegFilePath$default(FfmpegProvider ffmpegProvider, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        return ffmpegProvider.getFfmpegFilePath(map);
    }

    public final String getFfmpegFilePath(Map<String, String> map) {
        String str = ffmpegLibPath;
        if (str == null) {
            throw new FfmpegMissingException();
        } else if (map == null) {
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ffmpegLibPath");
            }
            return str;
        } else {
            String str2 = "";
            for (Map.Entry next : map.entrySet()) {
                str2 = str2 + ((String) next.getKey()) + '=' + ((String) next.getValue()) + ' ';
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            String str3 = ffmpegLibPath;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ffmpegLibPath");
            }
            sb.append(str3);
            return sb.toString();
        }
    }

    public final void printCpuAbis() {
        Timber.m300d("Build.CPU_ABI : " + Build.CPU_ABI, new Object[0]);
        Timber.m300d("Build.CPU_ABI2 : " + Build.CPU_ABI2, new Object[0]);
        Timber.m300d("Build.SUPPORTED_ABIS : " + Build.SUPPORTED_ABIS, new Object[0]);
        Timber.m300d("Build.SUPPORTED_32_BIT_ABIS : " + Build.SUPPORTED_32_BIT_ABIS, new Object[0]);
        Timber.m300d("Build.SUPPORTED_64_BIT_ABIS : " + Build.SUPPORTED_64_BIT_ABIS, new Object[0]);
    }

    public final void printDeviceName() {
        Timber.m300d("Device Name: " + DeviceConfig.INSTANCE.name(), new Object[0]);
    }
}
