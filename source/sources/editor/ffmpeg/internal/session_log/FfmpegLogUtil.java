package editor.ffmpeg.internal.session_log;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.time.DateUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/ffmpeg/internal/session_log/FfmpegLogUtil;", "", "()V", "timePattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "retrieveFirstTimeStamp", "", "target", "timeStampToMillis", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FfmpegLogUtil.kt */
public final class FfmpegLogUtil {
    private final Pattern timePattern = Pattern.compile("(\\d{2}:\\d{2}:\\d{2}.\\d{1,3})");

    public final String retrieveFirstTimeStamp(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        Scanner scanner = new Scanner(str);
        String findWithinHorizon = scanner.findWithinHorizon(this.timePattern, 0);
        scanner.close();
        return findWithinHorizon;
    }

    public final long timeStampToMillis(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "target");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
        int parseInt = Integer.parseInt((String) split$default.get(0));
        int parseInt2 = Integer.parseInt((String) split$default.get(1));
        List split$default2 = StringsKt.split$default((CharSequence) split$default.get(2), new String[]{"."}, false, 0, 6, (Object) null);
        int parseInt3 = Integer.parseInt((String) split$default2.get(0));
        String str2 = (String) split$default2.get(1);
        if (str2.length() == 2) {
            i = Integer.parseInt(str2) * 10;
        } else {
            i = Integer.parseInt(str2);
        }
        return (((long) parseInt) * DateUtils.MILLIS_PER_HOUR) + (((long) parseInt2) * 60000) + (((long) parseInt3) * 1000) + ((long) i);
    }
}
