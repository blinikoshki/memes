package com.memes.chat.p036ui.channel.members;

import android.content.DialogInterface;
import androidx.lifecycle.Observer;
import com.memes.chat.p036ui.channel.events.dialogs.ChannelDeletedEventDialog;
import com.memes.chat.routing.ChatRouting;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "channelId", "", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$setupChannelMembers$11 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$setupChannelMembers$11<T> implements Observer<String> {
    final /* synthetic */ ChannelMembersActivity this$0;

    ChannelMembersActivity$setupChannelMembers$11(ChannelMembersActivity channelMembersActivity) {
        this.this$0 = channelMembersActivity;
    }

    public final void onChanged(String str) {
        new ChannelDeletedEventDialog(this.this$0).setOnDismissListener((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener(this) {
            final /* synthetic */ ChannelMembersActivity$setupChannelMembers$11 this$0;

            {
                this.this$0 = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                this.this$0.this$0.resultIntent.putExtra(ChatRouting.EXTRA_CHANNEL_DELETED, true);
                this.this$0.this$0.setResult(-1, this.this$0.this$0.resultIntent);
                this.this$0.this$0.finish();
            }
        }).show();
    }
}
