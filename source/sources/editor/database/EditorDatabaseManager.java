package editor.database;

import android.content.Context;
import editor.database.EditorDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Leditor/database/EditorDatabaseManager;", "", "()V", "database", "Leditor/database/EditorDatabase;", "db", "context", "Landroid/content/Context;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorDatabaseManager.kt */
public final class EditorDatabaseManager {
    public static final EditorDatabaseManager INSTANCE = new EditorDatabaseManager();
    /* access modifiers changed from: private */
    public static EditorDatabase database;

    private EditorDatabaseManager() {
    }

    public static final /* synthetic */ EditorDatabase access$getDatabase$p(EditorDatabaseManager editorDatabaseManager) {
        EditorDatabase editorDatabase = database;
        if (editorDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        }
        return editorDatabase;
    }

    /* renamed from: db */
    public final EditorDatabase mo63492db(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (database == null) {
            EditorDatabase.Companion companion = EditorDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            database = companion.create(applicationContext);
        }
        EditorDatabase editorDatabase = database;
        if (editorDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        }
        return editorDatabase;
    }
}
