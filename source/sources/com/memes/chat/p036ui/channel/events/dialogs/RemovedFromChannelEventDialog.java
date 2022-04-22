package com.memes.chat.p036ui.channel.events.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import com.memes.chat.C4059R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/events/dialogs/RemovedFromChannelEventDialog;", "Lcom/memes/chat/ui/channel/events/dialogs/BaseEventDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.events.dialogs.RemovedFromChannelEventDialog */
/* compiled from: RemovedFromChannelEventDialog.kt */
public final class RemovedFromChannelEventDialog extends BaseEventDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemovedFromChannelEventDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setTitle(C4059R.string.chat_removed_from_channel_title);
        setMessage((CharSequence) context.getString(C4059R.string.chat_removed_from_channel_msg));
        setCancelable(false);
        setPositiveButton(C4059R.string.chat_removed_from_channel_action, (DialogInterface.OnClickListener) null);
    }
}
