package com.getstream.sdk.chat.navigation.destinations;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo26107d2 = {"Lcom/getstream/sdk/chat/navigation/destinations/ChatDestination;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "navigate", "", "start", "intent", "Landroid/content/Intent;", "startForResult", "requestCode", "", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatDestination.kt */
public abstract class ChatDestination {
    private final Context context;

    public abstract void navigate();

    public ChatDestination(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public final void start(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public final void startForResult(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Context context2 = this.context;
        if (context2 instanceof Activity) {
            ((Activity) context2).startActivityForResult(intent, i);
            return;
        }
        throw new IllegalStateException("startForResult can only be used if your destination uses an Activity as its Context".toString());
    }
}
