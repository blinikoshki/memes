package p015io.getstream.chat.android.livedata.repository.database;

import androidx.room.RoomDatabase;
import androidx.sqlite.p008db.SupportSQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"io/getstream/chat/android/livedata/repository/database/ChatDatabase$Companion$getDatabase$1$db$1", "Landroidx/room/RoomDatabase$Callback;", "onOpen", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.database.ChatDatabase$Companion$getDatabase$1$db$1 */
/* compiled from: ChatDatabase.kt */
public final class ChatDatabase$Companion$getDatabase$1$db$1 extends RoomDatabase.Callback {
    ChatDatabase$Companion$getDatabase$1$db$1() {
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        supportSQLiteDatabase.execSQL("PRAGMA synchronous = 1");
    }
}
