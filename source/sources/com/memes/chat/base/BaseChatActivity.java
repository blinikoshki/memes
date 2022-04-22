package com.memes.chat.base;

import android.content.Intent;
import androidx.core.app.NotificationManagerCompat;
import com.memes.chat.services.ChatService;
import com.memes.commons.activity.BaseActivity;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, mo26107d2 = {"Lcom/memes/chat/base/BaseChatActivity;", "Lcom/memes/commons/activity/BaseActivity;", "()V", "chatServiceConnection", "com/memes/chat/base/BaseChatActivity$chatServiceConnection$1", "Lcom/memes/chat/base/BaseChatActivity$chatServiceConnection$1;", "bindChatService", "", "onStart", "onStop", "removeAllNotifications", "unbindChatService", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseChatActivity.kt */
public class BaseChatActivity extends BaseActivity {
    private final BaseChatActivity$chatServiceConnection$1 chatServiceConnection = new BaseChatActivity$chatServiceConnection$1();

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        bindChatService();
        removeAllNotifications();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        unbindChatService();
    }

    private final void removeAllNotifications() {
        NotificationManagerCompat.from(this).cancelAll();
    }

    private final void bindChatService() {
        bindService(new Intent(this, ChatService.class), this.chatServiceConnection, 1);
    }

    private final void unbindChatService() {
        unbindService(this.chatServiceConnection);
    }
}
