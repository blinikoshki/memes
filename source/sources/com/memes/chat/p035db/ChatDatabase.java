package com.memes.chat.p035db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.memes.chat.p035db.mutedchannels.MutedChannelsDao;
import com.memes.chat.p035db.mutedusers.MutedUsersDao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, mo26107d2 = {"Lcom/memes/chat/db/ChatDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getMutedChannelsDao", "Lcom/memes/chat/db/mutedchannels/MutedChannelsDao;", "getMutedUsersDao", "Lcom/memes/chat/db/mutedusers/MutedUsersDao;", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.db.ChatDatabase */
/* compiled from: ChatDatabase.kt */
public abstract class ChatDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public abstract MutedChannelsDao getMutedChannelsDao();

    public abstract MutedUsersDao getMutedUsersDao();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/db/ChatDatabase$Companion;", "", "()V", "create", "Lcom/memes/chat/db/ChatDatabase;", "applicationContext", "Landroid/content/Context;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.db.ChatDatabase$Companion */
    /* compiled from: ChatDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChatDatabase create(Context context) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            ChatDatabase build = Room.databaseBuilder(context, ChatDatabase.class, "chat-database").fallbackToDestructiveMigration().build();
            Intrinsics.checkNotNullExpressionValue(build, "Room.databaseBuilder(\n\t\t…uctiveMigration().build()");
            return build;
        }
    }
}
