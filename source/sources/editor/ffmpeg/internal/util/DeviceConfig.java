package editor.ffmpeg.internal.util;

import android.os.Build;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo26107d2 = {"Leditor/ffmpeg/internal/util/DeviceConfig;", "", "()V", "name", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DeviceConfig.kt */
public final class DeviceConfig {
    public static final DeviceConfig INSTANCE = new DeviceConfig();

    private DeviceConfig() {
    }

    public final String name() {
        return '\'' + Build.MANUFACTURER + ' ' + Build.MODEL + ' ' + Build.BRAND + ' ' + Build.DEVICE + '\'';
    }
}
