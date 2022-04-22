package editor.tools.videotrim.rangeseekbar;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, mo26107d2 = {"Leditor/tools/videotrim/rangeseekbar/OnRangeSeekBarListener;", "", "onSeekRangeChanged", "", "view", "Leditor/tools/videotrim/rangeseekbar/RangeSeekBarView;", "type", "Leditor/tools/videotrim/rangeseekbar/ThumbType;", "value", "", "onSeekRangeCreated", "onSeekRangeStopped", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: OnRangeSeekBarListener.kt */
public interface OnRangeSeekBarListener {
    void onSeekRangeChanged(RangeSeekBarView rangeSeekBarView, ThumbType thumbType, float f);

    void onSeekRangeCreated(RangeSeekBarView rangeSeekBarView);

    void onSeekRangeStopped(RangeSeekBarView rangeSeekBarView, ThumbType thumbType, float f);
}
