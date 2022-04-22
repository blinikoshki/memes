package editor.editor.editorframehost;

import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.frame.FrameEntity;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.editor.equipment.text.TextEntity;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tj\u0002`\n0\bH&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0011\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tj\u0002`\nH&J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&¨\u0006\u001b"}, mo26107d2 = {"Leditor/editor/editorframehost/EditorEntityManager;", "", "deleteEntity", "", "token", "", "duplicateEntity", "getEntities", "", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/util/TypedCoreEntity;", "getFrameEntity", "Leditor/editor/equipment/frame/FrameEntity;", "getMediaEntity", "Leditor/editor/equipment/media/MediaEntity;", "getTextEntity", "Leditor/editor/equipment/text/TextEntity;", "getWatermarkEntity", "hasEntity", "", "hideEntity", "showEntity", "updateEntity", "bundle", "Leditor/editor/equipment/property/NicoPropertyBundle;", "updateMediaEntity", "updateTextEntity", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntityManager.kt */
public interface EditorEntityManager {
    void deleteEntity(String str);

    void duplicateEntity(String str);

    Collection<CoreEntity<?, ?>> getEntities();

    FrameEntity getFrameEntity();

    MediaEntity getMediaEntity(String str);

    TextEntity getTextEntity(String str);

    CoreEntity<?, ?> getWatermarkEntity();

    boolean hasEntity(String str);

    void hideEntity(String str);

    void showEntity(String str);

    void updateEntity(NicoPropertyBundle nicoPropertyBundle);

    void updateMediaEntity(NicoPropertyBundle nicoPropertyBundle);

    void updateTextEntity(NicoPropertyBundle nicoPropertyBundle);
}
