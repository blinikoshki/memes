package com.memes.chat.p036ui.channel.create.stages.memberselection;

import java.util.List;
import kotlin.Metadata;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H&¨\u0006\b"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/OnChannelMembersSelectionChangedListener;", "", "onChannelMembersSelectionChanged", "", "channelMembers", "", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.OnChannelMembersSelectionChangedListener */
/* compiled from: OnChannelMembersSelectionChangedListener.kt */
public interface OnChannelMembersSelectionChangedListener {
    void onChannelMembersSelectionChanged(List<User> list);
}
