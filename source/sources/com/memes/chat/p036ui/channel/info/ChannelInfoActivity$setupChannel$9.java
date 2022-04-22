package com.memes.chat.p036ui.channel.info;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import androidx.lifecycle.Observer;
import com.memes.chat.routing.ChatRouting;
import com.memes.chat.util.extensions.ChannelExtKt;
import com.memes.commons.util.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "channel", "Lio/getstream/chat/android/client/models/Channel;", "kotlin.jvm.PlatformType", "onChanged"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoActivity$setupChannel$9 */
/* compiled from: ChannelInfoActivity.kt */
final class ChannelInfoActivity$setupChannel$9<T> implements Observer<Channel> {
    final /* synthetic */ ChannelInfoActivity this$0;

    ChannelInfoActivity$setupChannel$9(ChannelInfoActivity channelInfoActivity) {
        this.this$0 = channelInfoActivity;
    }

    public final void onChanged(Channel channel) {
        ExtensionsKt.toast((Context) this.this$0, "Chat information updated.");
        EditText editText = this.this$0.getBinding().multiUserChannelNameEditText;
        Intrinsics.checkNotNullExpressionValue(channel, "channel");
        editText.setText(ChannelExtKt.channelName(channel));
        this.this$0.getBinding().multiUserChannelNameEditText.clearFocus();
        Intent intent = new Intent();
        intent.putExtra(ChatRouting.EXTRA_CHANNEL_NAME_CHANGED, ChannelExtKt.channelName(channel));
        intent.putExtra(ChatRouting.EXTRA_CHANNEL_IMAGE_CHANGED, ChannelExtKt.channelImage(channel));
        this.this$0.setResult(-1, intent);
    }
}
