package editor.editor.editorframehost.frame;

import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.text.TextEntity;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\bj\u0002`\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u000f"}, mo26107d2 = {"Leditor/editor/editorframehost/frame/EditorFrameCallback;", "", "onEntityTapped", "", "entity", "Leditor/editor/equipment/media/MediaEntity;", "Leditor/editor/equipment/text/TextEntity;", "onSaveEntityAsWatermarkTapped", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "onTextEntityDoubleTapped", "onTotalEntityVisibilityCountChanged", "visible", "", "hidden", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrameCallback.kt */
public interface EditorFrameCallback {
    void onEntityTapped(MediaEntity mediaEntity);

    void onEntityTapped(TextEntity textEntity);

    void onSaveEntityAsWatermarkTapped(CoreEntity<?, ?> coreEntity);

    void onTextEntityDoubleTapped(TextEntity textEntity);

    void onTotalEntityVisibilityCountChanged(int i, int i2);
}
