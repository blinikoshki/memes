package com.getstream.sdk.chat.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.view.channels.ChannelListView;
import com.getstream.sdk.chat.view.channels.ChannelListViewStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&¨\u0006\u0017"}, mo26107d2 = {"Lcom/getstream/sdk/chat/adapter/BaseChannelListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "channelState", "Lio/getstream/chat/android/client/models/Channel;", "position", "", "payloads", "Lcom/getstream/sdk/chat/adapter/ChannelItemPayloadDiff;", "setChannelClickListener", "channelClickListener", "Lcom/getstream/sdk/chat/view/channels/ChannelListView$ChannelClickListener;", "setChannelLongClickListener", "setStyle", "style", "Lcom/getstream/sdk/chat/view/channels/ChannelListViewStyle;", "setUserClickListener", "userClickListener", "Lcom/getstream/sdk/chat/view/channels/ChannelListView$UserClickListener;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseChannelListItemViewHolder.kt */
public abstract class BaseChannelListItemViewHolder extends RecyclerView.ViewHolder {
    public abstract void bind(Channel channel, int i, ChannelItemPayloadDiff channelItemPayloadDiff);

    public abstract void setChannelClickListener(ChannelListView.ChannelClickListener channelClickListener);

    public abstract void setChannelLongClickListener(ChannelListView.ChannelClickListener channelClickListener);

    public abstract void setStyle(ChannelListViewStyle channelListViewStyle);

    public abstract void setUserClickListener(ChannelListView.UserClickListener userClickListener);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseChannelListItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }
}
