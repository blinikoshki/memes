package com.memes.chat.p036ui.channel.members;

import androidx.lifecycle.Observer;
import com.memes.chat.util.extensions.ChannelExtKt;
import kotlin.Metadata;
import kotlin.Pair;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005 \u0006*\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lio/getstream/chat/android/client/models/User;", "Lio/getstream/chat/android/client/models/Channel;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersActivity$setupChannelMembers$2 */
/* compiled from: ChannelMembersActivity.kt */
final class ChannelMembersActivity$setupChannelMembers$2<T> implements Observer<Pair<? extends User, ? extends Channel>> {
    final /* synthetic */ ChannelMembersActivity this$0;

    ChannelMembersActivity$setupChannelMembers$2(ChannelMembersActivity channelMembersActivity) {
        this.this$0 = channelMembersActivity;
    }

    public final void onChanged(Pair<User, Channel> pair) {
        User component1 = pair.component1();
        Channel component2 = pair.component2();
        if (component1 != null && component2 != null) {
            this.this$0.getChannelMembersAdapter().setOwnerAndCurrentUser(ChannelExtKt.owner(component2), component1);
        }
    }
}
