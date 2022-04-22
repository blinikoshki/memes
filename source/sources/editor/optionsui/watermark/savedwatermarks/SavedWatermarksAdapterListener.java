package editor.optionsui.watermark.savedwatermarks;

import editor.optionsui.watermark.Watermark;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Leditor/optionsui/watermark/savedwatermarks/SavedWatermarksAdapterListener;", "", "onSavedWatermarkDeleteRequested", "", "watermark", "Leditor/optionsui/watermark/Watermark;", "onSavedWatermarkTapped", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SavedWatermarksAdapterListener.kt */
public interface SavedWatermarksAdapterListener {
    void onSavedWatermarkDeleteRequested(Watermark watermark);

    void onSavedWatermarkTapped(Watermark watermark);
}
