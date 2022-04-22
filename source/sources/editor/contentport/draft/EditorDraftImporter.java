package editor.contentport.draft;

import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTarget;
import editor.contentport.ContentPortUtil;
import editor.editor.dashboard.drafts.EditorDraft;
import editor.editor.equipment.media.MediaStyle;
import editor.editor.equipment.media.content.CropSpec;
import editor.editor.equipment.media.content.FilterSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/contentport/draft/EditorDraftImporter;", "", "portUtil", "Leditor/contentport/ContentPortUtil;", "(Leditor/contentport/ContentPortUtil;)V", "import", "", "draft", "Leditor/editor/dashboard/drafts/EditorDraft;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftImporter.kt */
public final class EditorDraftImporter {
    private final ContentPortUtil portUtil;

    public EditorDraftImporter(ContentPortUtil contentPortUtil) {
        Intrinsics.checkNotNullParameter(contentPortUtil, "portUtil");
        this.portUtil = contentPortUtil;
    }

    /* renamed from: import  reason: not valid java name */
    public final void m2579import(EditorDraft editorDraft) {
        Intrinsics.checkNotNullParameter(editorDraft, "draft");
        String str = OutputTarget.FOLDER_WORKSPACE + '/' + editorDraft.getUid();
        this.portUtil.deleteFolder(str);
        this.portUtil.requireFreeSpace(200);
        List<MediaStyle> mediaStyles = editorDraft.getMediaStyles();
        if (mediaStyles != null) {
            for (MediaStyle mediaStyle : mediaStyles) {
                this.portUtil.copyMediaContentTo(mediaStyle.getOriginalContent(), str);
                ContentPortUtil contentPortUtil = this.portUtil;
                CropSpec cropSpec = mediaStyle.getCropSpec();
                MediaContent mediaContent = null;
                contentPortUtil.copyMediaContentTo(cropSpec != null ? cropSpec.getContent() : null, str);
                ContentPortUtil contentPortUtil2 = this.portUtil;
                FilterSpec filterSpec = mediaStyle.getFilterSpec();
                if (filterSpec != null) {
                    mediaContent = filterSpec.getContent();
                }
                contentPortUtil2.copyMediaContentTo(mediaContent, str);
            }
        }
    }
}
