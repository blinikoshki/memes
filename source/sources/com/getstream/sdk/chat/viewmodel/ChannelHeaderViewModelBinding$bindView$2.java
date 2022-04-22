package com.getstream.sdk.chat.viewmodel;

import androidx.lifecycle.Observer;
import com.getstream.sdk.chat.utils.extensions.ChannelUtils;
import com.getstream.sdk.chat.view.ChannelHeaderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChannelHeaderViewModelBinding.kt */
final class ChannelHeaderViewModelBinding$bindView$2<T> implements Observer<Channel> {
    final /* synthetic */ ChannelHeaderView $view;

    ChannelHeaderViewModelBinding$bindView$2(ChannelHeaderView channelHeaderView) {
        this.$view = channelHeaderView;
    }

    public final void onChanged(Channel channel) {
        this.$view.setCurrentChannel(channel);
        Intrinsics.checkNotNullExpressionValue(channel, "channel");
        String str = null;
        String channelNameOrMembers$default = ChannelUtils.getChannelNameOrMembers$default(channel, (User) null, 1, (Object) null);
        if (!StringsKt.isBlank(channelNameOrMembers$default)) {
            str = channelNameOrMembers$default;
        }
        if (str != null) {
            this.$view.setHeaderTitle(str);
        }
    }
}
