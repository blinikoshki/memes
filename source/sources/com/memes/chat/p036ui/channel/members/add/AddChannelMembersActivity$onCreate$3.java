package com.memes.chat.p036ui.channel.members.add;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.memes.chat.routing.ChatRouting;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\b\u0012\u00060\u0004j\u0002`\u0005 \u0006*\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "members", "", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.add.AddChannelMembersActivity$onCreate$3 */
/* compiled from: AddChannelMembersActivity.kt */
final class AddChannelMembersActivity$onCreate$3<T> implements Observer<List<? extends User>> {
    final /* synthetic */ AddChannelMembersActivity this$0;

    AddChannelMembersActivity$onCreate$3(AddChannelMembersActivity addChannelMembersActivity) {
        this.this$0 = addChannelMembersActivity;
    }

    public final void onChanged(List<User> list) {
        Intrinsics.checkNotNullExpressionValue(list, ModelFields.MEMBERS);
        if (!list.isEmpty()) {
            Intent intent = new Intent();
            intent.putExtra(ChatRouting.EXTRA_CHANNEL_MEMBERS_UPDATED, true);
            this.this$0.setResult(-1, intent);
        }
        this.this$0.finish();
    }
}
