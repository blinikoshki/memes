package editor.tools.videotrim;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, mo26107d2 = {"Leditor/tools/videotrim/TrimControlsListener;", "", "onCurrentPlaybackProgressChanged", "", "millis", "", "onTrimRangeChanged", "startMillis", "endMillis", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TrimControlsListener.kt */
public interface TrimControlsListener {
    void onCurrentPlaybackProgressChanged(int i);

    void onTrimRangeChanged(int i, int i2);
}
