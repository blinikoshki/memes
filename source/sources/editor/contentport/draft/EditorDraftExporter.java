package editor.contentport.draft;

import com.memes.commons.output.OutputTarget;
import editor.contentport.ContentPortUtil;
import editor.editor.dashboard.drafts.EditorDraft;
import editor.editor.editorframehost.frame.EditorFrame;
import editor.editor.editorframehost.frame.EditorFrameUtil;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.frame.FrameLayer;
import editor.editor.equipment.frame.FrameStyle;
import editor.editor.equipment.media.MediaEntity;
import editor.editor.equipment.media.MediaLayer;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.text.TextEntity;
import editor.editor.equipment.text.TextLayer;
import editor.editor.equipment.text.TextStyle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Leditor/contentport/draft/EditorDraftExporter;", "", "frame", "Leditor/editor/editorframehost/frame/EditorFrame;", "portUtil", "Leditor/contentport/ContentPortUtil;", "thumbnailPath", "", "(Leditor/editor/editorframehost/frame/EditorFrame;Leditor/contentport/ContentPortUtil;Ljava/lang/String;)V", "export", "Leditor/editor/dashboard/drafts/EditorDraft;", "id", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftExporter.kt */
public final class EditorDraftExporter {
    private final EditorFrame frame;
    private final ContentPortUtil portUtil;
    private final String thumbnailPath;

    public EditorDraftExporter(EditorFrame editorFrame, ContentPortUtil contentPortUtil, String str) {
        Intrinsics.checkNotNullParameter(editorFrame, "frame");
        Intrinsics.checkNotNullParameter(contentPortUtil, "portUtil");
        Intrinsics.checkNotNullParameter(str, "thumbnailPath");
        this.frame = editorFrame;
        this.portUtil = contentPortUtil;
        this.thumbnailPath = str;
    }

    public final EditorDraft export(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str2 = OutputTarget.FOLDER_DRAFTS + '/' + str;
        this.portUtil.deleteFolder(str2);
        this.portUtil.requireFreeSpace(200);
        FrameStyle frameStyle = (FrameStyle) this.frame.getFrameEntity().getStyle();
        int width = ((FrameLayer) this.frame.getFrameEntity().getLayer()).getWidth();
        int height = ((FrameLayer) this.frame.getFrameEntity().getLayer()).getHeight();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (CoreEntity coreEntity : EditorFrameUtil.INSTANCE.createSortedEntities(this.frame)) {
            if (coreEntity instanceof TextEntity) {
                TextStyle textStyle = new TextStyle();
                TextEntity textEntity = (TextEntity) coreEntity;
                ((TextStyle) textEntity.getStyle()).copy(textStyle);
                textStyle.setPlacement(((TextLayer) textEntity.getLayer()).getHitRect());
                textStyle.setScale(((TextLayer) textEntity.getLayer()).getScale());
                textStyle.setRotation(((TextLayer) textEntity.getLayer()).getRotation());
                textStyle.getMetadata().update(textEntity.getLayer(), width, height);
                arrayList.add(textStyle);
            } else if (coreEntity instanceof MediaEntity) {
                MediaEntity mediaEntity = (MediaEntity) coreEntity;
                MediaStyle copyMediaStyle = this.portUtil.copyMediaStyle((MediaStyle) mediaEntity.getStyle(), str2);
                copyMediaStyle.setPlacement(((MediaLayer) mediaEntity.getLayer()).getHitRect());
                copyMediaStyle.setScale(((MediaLayer) mediaEntity.getLayer()).getScale());
                copyMediaStyle.setRotation(((MediaLayer) mediaEntity.getLayer()).getRotation());
                copyMediaStyle.getMetadata().update(mediaEntity.getLayer(), width, height);
                arrayList2.add(copyMediaStyle);
            } else {
                throw new RuntimeException("Unknown Entity: " + coreEntity);
            }
        }
        String copyFileToFolder = this.portUtil.copyFileToFolder(new File(this.thumbnailPath), str2);
        if (copyFileToFolder == null) {
            copyFileToFolder = this.thumbnailPath;
        }
        return new EditorDraft(str, copyFileToFolder, width, height, System.currentTimeMillis(), arrayList, arrayList2, frameStyle);
    }
}
