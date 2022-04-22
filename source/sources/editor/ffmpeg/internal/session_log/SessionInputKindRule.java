package editor.ffmpeg.internal.session_log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Leditor/ffmpeg/internal/session_log/SessionInputKindRule;", "Leditor/ffmpeg/internal/session_log/SessionKindRule;", "logUtil", "Leditor/ffmpeg/internal/session_log/FfmpegLogUtil;", "(Leditor/ffmpeg/internal/session_log/FfmpegLogUtil;)V", "getDurationMillis", "", "target", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getIndex", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "supported", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SessionInputKindRule.kt */
public final class SessionInputKindRule implements SessionKindRule {
    private final FfmpegLogUtil logUtil;

    public SessionInputKindRule(FfmpegLogUtil ffmpegLogUtil) {
        Intrinsics.checkNotNullParameter(ffmpegLogUtil, "logUtil");
        this.logUtil = ffmpegLogUtil;
    }

    public boolean supported(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        return StringsKt.startsWith$default(str, "Input #", false, 2, (Object) null);
    }

    public final Integer getIndex(String str) {
        String group;
        Intrinsics.checkNotNullParameter(str, "target");
        Matcher matcher = Pattern.compile("Input #(\\d+).*").matcher(str);
        if (!matcher.matches() || (group = matcher.group(1)) == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(group));
    }

    public final Long getDurationMillis(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        boolean z = false;
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "Duration:", false, 2, (Object) null)) {
            return null;
        }
        String retrieveFirstTimeStamp = this.logUtil.retrieveFirstTimeStamp(str);
        CharSequence charSequence = retrieveFirstTimeStamp;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            z = true;
        }
        if (z) {
            return null;
        }
        long timeStampToMillis = this.logUtil.timeStampToMillis(retrieveFirstTimeStamp);
        if (timeStampToMillis <= 0) {
            return null;
        }
        return Long.valueOf(timeStampToMillis);
    }
}
