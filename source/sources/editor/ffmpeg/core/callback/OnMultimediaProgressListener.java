package editor.ffmpeg.core.callback;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, mo26107d2 = {"Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "Leditor/ffmpeg/core/callback/MultimediaCallback;", "onMultimediaTaskProgressAvailable", "", "progress", "", "preparedMessage", "", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OnMultimediaProgressListener.kt */
public interface OnMultimediaProgressListener extends MultimediaCallback {
    void onMultimediaTaskProgressAvailable(int i, String str);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: OnMultimediaProgressListener.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onMultimediaTaskProgressAvailable$default(OnMultimediaProgressListener onMultimediaProgressListener, int i, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = null;
                }
                onMultimediaProgressListener.onMultimediaTaskProgressAvailable(i, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMultimediaTaskProgressAvailable");
        }
    }
}
