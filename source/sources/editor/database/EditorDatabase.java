package editor.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import editor.database.dao.EditorDraftsDao;
import editor.database.dao.RecentFontsDao;
import editor.database.dao.SavedWatermarksDao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, mo26107d2 = {"Leditor/database/EditorDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getEditorDraftsDao", "Leditor/database/dao/EditorDraftsDao;", "getRecentFontsDao", "Leditor/database/dao/RecentFontsDao;", "getSavedWatermarksDao", "Leditor/database/dao/SavedWatermarksDao;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorDatabase.kt */
public abstract class EditorDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public abstract EditorDraftsDao getEditorDraftsDao();

    public abstract RecentFontsDao getRecentFontsDao();

    public abstract SavedWatermarksDao getSavedWatermarksDao();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/database/EditorDatabase$Companion;", "", "()V", "create", "Leditor/database/EditorDatabase;", "applicationContext", "Landroid/content/Context;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EditorDatabase create(Context context) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            EditorDatabase build = Room.databaseBuilder(context, EditorDatabase.class, "editor-database").fallbackToDestructiveMigration().build();
            Intrinsics.checkNotNullExpressionValue(build, "Room.databaseBuilder(\n\t\t…uctiveMigration().build()");
            return build;
        }
    }
}
