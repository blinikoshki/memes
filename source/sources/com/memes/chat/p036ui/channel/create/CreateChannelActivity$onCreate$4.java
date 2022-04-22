package com.memes.chat.p036ui.channel.create;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "createdChannel", "Lio/getstream/chat/android/client/models/Channel;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.CreateChannelActivity$onCreate$4 */
/* compiled from: CreateChannelActivity.kt */
final class CreateChannelActivity$onCreate$4<T> implements Observer<Channel> {
    final /* synthetic */ CreateChannelActivity this$0;

    CreateChannelActivity$onCreate$4(CreateChannelActivity createChannelActivity) {
        this.this$0 = createChannelActivity;
    }

    public final void onChanged(Channel channel) {
        CreateChannelActivity createChannelActivity = this.this$0;
        Intrinsics.checkNotNullExpressionValue(channel, "createdChannel");
        createChannelActivity.showChannel(channel);
    }
}
