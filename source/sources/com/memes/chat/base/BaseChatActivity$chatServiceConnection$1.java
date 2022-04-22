package com.memes.chat.base;

import android.content.ComponentName;
import android.os.IBinder;
import com.memes.chat.services.ChatService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/memes/chat/base/BaseChatActivity$chatServiceConnection$1", "Lcom/memes/chat/services/ChatService$Connection;", "onServiceConnected", "", "chatService", "Lcom/memes/chat/services/ChatService;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseChatActivity.kt */
public final class BaseChatActivity$chatServiceConnection$1 implements ChatService.Connection {
    public void onServiceConnected(ChatService chatService) {
        Intrinsics.checkNotNullParameter(chatService, "chatService");
    }

    BaseChatActivity$chatServiceConnection$1() {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.checkNotNullParameter(componentName, "className");
        Intrinsics.checkNotNullParameter(iBinder, "binder");
        ChatService.Connection.DefaultImpls.onServiceConnected(this, componentName, iBinder);
    }

    public void onServiceDisconnected() {
        ChatService.Connection.DefaultImpls.onServiceDisconnected(this);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "arg0");
        ChatService.Connection.DefaultImpls.onServiceDisconnected(this, componentName);
    }
}
