package editor.ffmpeg.core.callback;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Leditor/ffmpeg/core/callback/MultimediaFrameworkErrorNotifier;", "Leditor/ffmpeg/core/callback/MultimediaCallback;", "onFrameworkErrorNotificationReceived", "", "message", "", "errorLog", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MultimediaFrameworkErrorNotifier.kt */
public interface MultimediaFrameworkErrorNotifier extends MultimediaCallback {
    void onFrameworkErrorNotificationReceived(String str, String str2);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: MultimediaFrameworkErrorNotifier.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onFrameworkErrorNotificationReceived$default(MultimediaFrameworkErrorNotifier multimediaFrameworkErrorNotifier, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                multimediaFrameworkErrorNotifier.onFrameworkErrorNotificationReceived(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFrameworkErrorNotificationReceived");
        }
    }
}
