package com.memes.chat.p035db;

import android.content.Context;
import com.memes.chat.p035db.ChatDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lcom/memes/chat/db/ChatDatabaseManager;", "", "()V", "database", "Lcom/memes/chat/db/ChatDatabase;", "db", "context", "Landroid/content/Context;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.db.ChatDatabaseManager */
/* compiled from: ChatDatabaseManager.kt */
public final class ChatDatabaseManager {
    public static final ChatDatabaseManager INSTANCE = new ChatDatabaseManager();
    /* access modifiers changed from: private */
    public static ChatDatabase database;

    private ChatDatabaseManager() {
    }

    public static final /* synthetic */ ChatDatabase access$getDatabase$p(ChatDatabaseManager chatDatabaseManager) {
        ChatDatabase chatDatabase = database;
        if (chatDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        }
        return chatDatabase;
    }

    /* renamed from: db */
    public final ChatDatabase mo56374db(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (database == null) {
            ChatDatabase.Companion companion = ChatDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            database = companion.create(applicationContext);
        }
        ChatDatabase chatDatabase = database;
        if (chatDatabase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("database");
        }
        return chatDatabase;
    }
}
