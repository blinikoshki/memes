package editor.mediaselection.targetedmediabrowser;

import com.memes.editor.C4175R;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo26107d2 = {"Leditor/mediaselection/targetedmediabrowser/MediaSelectionTarget;", "", "displayTextRes", "", "(Ljava/lang/String;II)V", "getDisplayTextRes", "()I", "GIPHY", "MEMES", "REDDIT", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaSelectionTarget.kt */
public enum MediaSelectionTarget {
    GIPHY(C4175R.string.media_selection_target_giphy),
    MEMES(C4175R.string.media_selection_target_memes),
    REDDIT(C4175R.string.media_selection_target_reddit);
    
    private final int displayTextRes;

    private MediaSelectionTarget(int i) {
        this.displayTextRes = i;
    }

    public final int getDisplayTextRes() {
        return this.displayTextRes;
    }
}
