package editor.tools.videotrim.rangeseekbar;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/tools/videotrim/rangeseekbar/NullThumb;", "Leditor/tools/videotrim/rangeseekbar/Thumb;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Thumb.kt */
public final class NullThumb extends Thumb {
    public static final NullThumb INSTANCE = new NullThumb();

    private NullThumb() {
        super(ThumbType.NONE);
    }
}
