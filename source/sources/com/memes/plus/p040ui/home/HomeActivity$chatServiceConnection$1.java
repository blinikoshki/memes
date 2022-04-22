package com.memes.plus.p040ui.home;

import android.content.ComponentName;
import android.os.IBinder;
import com.memes.chat.services.ChatService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, mo26107d2 = {"com/memes/plus/ui/home/HomeActivity$chatServiceConnection$1", "Lcom/memes/chat/services/ChatService$Connection;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.home.HomeActivity$chatServiceConnection$1 */
/* compiled from: HomeActivity.kt */
public final class HomeActivity$chatServiceConnection$1 implements ChatService.Connection {
    HomeActivity$chatServiceConnection$1() {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.checkNotNullParameter(componentName, "className");
        Intrinsics.checkNotNullParameter(iBinder, "binder");
        ChatService.Connection.DefaultImpls.onServiceConnected(this, componentName, iBinder);
    }

    public void onServiceConnected(ChatService chatService) {
        Intrinsics.checkNotNullParameter(chatService, "chatService");
        ChatService.Connection.DefaultImpls.onServiceConnected(this, chatService);
    }

    public void onServiceDisconnected() {
        ChatService.Connection.DefaultImpls.onServiceDisconnected(this);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "arg0");
        ChatService.Connection.DefaultImpls.onServiceDisconnected(this, componentName);
    }
}
