package com.memes.chat.p035db;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.db.ChatDatabaseManager$db$1 */
/* compiled from: ChatDatabaseManager.kt */
final /* synthetic */ class ChatDatabaseManager$db$1 extends MutablePropertyReference0Impl {
    ChatDatabaseManager$db$1(ChatDatabaseManager chatDatabaseManager) {
        super(chatDatabaseManager, ChatDatabaseManager.class, "database", "getDatabase()Lcom/memes/chat/db/ChatDatabase;", 0);
    }

    public Object get() {
        return ChatDatabaseManager.access$getDatabase$p((ChatDatabaseManager) this.receiver);
    }

    public void set(Object obj) {
        ChatDatabaseManager.database = (ChatDatabase) obj;
    }
}
