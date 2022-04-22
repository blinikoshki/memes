package com.memes.chat.p036ui.channel.events.dialogs;

import android.content.Context;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/events/dialogs/BaseEventDialog;", "Lcom/google/android/material/dialog/MaterialAlertDialogBuilder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.events.dialogs.BaseEventDialog */
/* compiled from: BaseEventDialog.kt */
public abstract class BaseEventDialog extends MaterialAlertDialogBuilder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseEventDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
