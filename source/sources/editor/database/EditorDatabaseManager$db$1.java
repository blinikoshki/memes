package editor.database;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorDatabaseManager.kt */
final /* synthetic */ class EditorDatabaseManager$db$1 extends MutablePropertyReference0Impl {
    EditorDatabaseManager$db$1(EditorDatabaseManager editorDatabaseManager) {
        super(editorDatabaseManager, EditorDatabaseManager.class, "database", "getDatabase()Leditor/database/EditorDatabase;", 0);
    }

    public Object get() {
        return EditorDatabaseManager.access$getDatabase$p((EditorDatabaseManager) this.receiver);
    }

    public void set(Object obj) {
        EditorDatabaseManager.database = (EditorDatabase) obj;
    }
}
