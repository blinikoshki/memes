package com.getstream.sdk.chat.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.view.channels.ChannelListViewStyle;
import p015io.getstream.chat.android.client.models.Channel;

public class ChannelViewHolderFactory {
    public static int CHANNEL_GENERAL;

    public int getChannelViewType(Channel channel) {
        return CHANNEL_GENERAL;
    }

    /* access modifiers changed from: protected */
    public void configureHolder(BaseChannelListItemViewHolder baseChannelListItemViewHolder, ChannelListItemAdapter channelListItemAdapter) {
        baseChannelListItemViewHolder.setStyle(channelListItemAdapter.getStyle());
        baseChannelListItemViewHolder.setChannelClickListener(channelListItemAdapter.getChannelClickListener());
        baseChannelListItemViewHolder.setChannelLongClickListener(channelListItemAdapter.getChannelLongClickListener());
        baseChannelListItemViewHolder.setUserClickListener(channelListItemAdapter.getUserClickListener());
    }

    public BaseChannelListItemViewHolder createChannelViewHolder(ChannelListItemAdapter channelListItemAdapter, ViewGroup viewGroup, int i) {
        Drawable itemSeparatorDrawable;
        ChannelListViewStyle style = channelListItemAdapter.getStyle();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(style.getChannelPreviewLayout(), viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(C1673R.C1677id.iv_separator);
        if (!(imageView == null || (itemSeparatorDrawable = style.getItemSeparatorDrawable()) == null)) {
            imageView.setImageDrawable(itemSeparatorDrawable);
        }
        ChannelListItemViewHolder channelListItemViewHolder = new ChannelListItemViewHolder(inflate);
        configureHolder(channelListItemViewHolder, channelListItemAdapter);
        return channelListItemViewHolder;
    }
}
