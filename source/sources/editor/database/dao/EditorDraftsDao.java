package editor.database.dao;

import editor.editor.dashboard.drafts.EditorDraft;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH'J!\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000e\"\u00020\u0005H'¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, mo26107d2 = {"Leditor/database/dao/EditorDraftsDao;", "", "delete", "", "draft", "Leditor/editor/dashboard/drafts/EditorDraft;", "deleteById", "id", "", "get", "getAll", "", "insertAll", "drafts", "", "([Leditor/editor/dashboard/drafts/EditorDraft;)V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorDraftsDao.kt */
public interface EditorDraftsDao {
    void delete(EditorDraft editorDraft);

    void deleteById(String str);

    EditorDraft get(String str);

    List<EditorDraft> getAll();

    void insertAll(EditorDraft... editorDraftArr);
}
