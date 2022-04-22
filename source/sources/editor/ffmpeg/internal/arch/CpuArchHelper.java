package editor.ffmpeg.internal.arch;

import android.os.Build;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/ffmpeg/internal/arch/CpuArchHelper;", "", "()V", "CPU_ABI_ARM64", "", "CPU_ABI_ARMEABI", "CPU_ABI_X86", "CPU_ABI_X86_64", "getCpuArch", "Leditor/ffmpeg/internal/arch/CpuArch;", "getCpuArchFor", "abi", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: CpuArchHelper.kt */
public final class CpuArchHelper {
    private static final String CPU_ABI_ARM64 = "arm64-v8a";
    private static final String CPU_ABI_ARMEABI = "armeabi-v7a";
    private static final String CPU_ABI_X86 = "x86";
    private static final String CPU_ABI_X86_64 = "x86_64";
    public static final CpuArchHelper INSTANCE = new CpuArchHelper();

    private CpuArchHelper() {
    }

    public final CpuArch getCpuArch() {
        CpuArch cpuArchFor;
        CpuArch cpuArchFor2;
        String[] strArr = {CPU_ABI_X86, CPU_ABI_X86_64, CPU_ABI_ARMEABI, CPU_ABI_ARM64};
        for (String str : Build.SUPPORTED_ABIS) {
            if (ArraysKt.contains((T[]) strArr, str)) {
                Intrinsics.checkNotNullExpressionValue(str, "supportedAbi");
                CpuArch cpuArchFor3 = getCpuArchFor(str);
                if (cpuArchFor3 != CpuArch.NONE) {
                    return cpuArchFor3;
                }
            }
        }
        String str2 = Build.CPU_ABI;
        if (str2 != null && (cpuArchFor2 = INSTANCE.getCpuArchFor(str2)) != CpuArch.NONE) {
            return cpuArchFor2;
        }
        String str3 = Build.CPU_ABI2;
        if (str3 == null || (cpuArchFor = INSTANCE.getCpuArchFor(str3)) == CpuArch.NONE) {
            return CpuArch.NONE;
        }
        return cpuArchFor;
    }

    private final CpuArch getCpuArchFor(String str) {
        switch (str.hashCode()) {
            case -806050265:
                if (str.equals(CPU_ABI_X86_64)) {
                    return CpuArch.X86_64;
                }
                break;
            case 117110:
                if (str.equals(CPU_ABI_X86)) {
                    return CpuArch.X86;
                }
                break;
            case 145444210:
                if (str.equals(CPU_ABI_ARMEABI)) {
                    return CpuArch.ARMv7;
                }
                break;
            case 1431565292:
                if (str.equals(CPU_ABI_ARM64)) {
                    return CpuArch.ARMv8;
                }
                break;
        }
        return CpuArch.NONE;
    }
}
