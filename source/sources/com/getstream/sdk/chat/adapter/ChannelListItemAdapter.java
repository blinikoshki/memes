package com.getstream.sdk.chat.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.view.channels.ChannelListView;
import com.getstream.sdk.chat.view.channels.ChannelListViewStyle;
import java.util.ArrayList;
import java.util.List;
import p015io.getstream.chat.android.client.models.Channel;

public class ChannelListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final ChannelItemPayloadDiff EMPTY_CHANNEL_ITEM_PAYLOAD_DIFF = new ChannelItemPayloadDiff(false, false, false, false, false, false);
    private static final ChannelItemPayloadDiff FULL_CHANNEL_ITEM_PAYLOAD_DIFF = new ChannelItemPayloadDiff(true, true, true, true, true, true);
    private ChannelListView.ChannelClickListener channelClickListener;
    private ChannelListView.ChannelClickListener channelLongClickListener;
    private List<Channel> channels;
    private ChannelListViewStyle style;
    private ChannelListView.UserClickListener userClickListener;
    private ChannelViewHolderFactory viewHolderFactory = new ChannelViewHolderFactory();

    public ChannelListItemAdapter(List<Channel> list) {
        this.channels = list;
    }

    public ChannelListItemAdapter() {
        this(new ArrayList());
    }

    public ChannelListView.ChannelClickListener getChannelClickListener() {
        return this.channelClickListener;
    }

    public void setChannelClickListener(ChannelListView.ChannelClickListener channelClickListener2) {
        this.channelClickListener = channelClickListener2;
    }

    public ChannelListView.ChannelClickListener getChannelLongClickListener() {
        return this.channelLongClickListener;
    }

    public void setChannelLongClickListener(ChannelListView.ChannelClickListener channelClickListener2) {
        this.channelLongClickListener = channelClickListener2;
    }

    public ChannelListView.UserClickListener getUserClickListener() {
        return this.userClickListener;
    }

    public void setUserClickListener(ChannelListView.UserClickListener userClickListener2) {
        this.userClickListener = userClickListener2;
    }

    public void replaceChannels(List<Channel> list) {
        ArrayList arrayList = new ArrayList(new ArrayList(list));
        DiffUtil.calculateDiff(new ChannelListDiffCallback(this.channels, arrayList), true).dispatchUpdatesTo((RecyclerView.Adapter) this);
        this.channels = arrayList;
    }

    public int getItemViewType(int i) {
        return this.viewHolderFactory.getChannelViewType(this.channels.get(i));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.viewHolderFactory.createChannelViewHolder(this, viewGroup, i);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((BaseChannelListItemViewHolder) viewHolder).bind(this.channels.get(i), i, FULL_CHANNEL_ITEM_PAYLOAD_DIFF);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        ChannelItemPayloadDiff channelItemPayloadDiff;
        Channel channel = this.channels.get(i);
        ChannelItemPayloadDiff channelItemPayloadDiff2 = EMPTY_CHANNEL_ITEM_PAYLOAD_DIFF;
        if (list.isEmpty()) {
            channelItemPayloadDiff = FULL_CHANNEL_ITEM_PAYLOAD_DIFF;
        } else {
            for (int i2 = 0; i2 < list.size(); i2++) {
                channelItemPayloadDiff2 = channelItemPayloadDiff2.plus((ChannelItemPayloadDiff) list.get(i2));
            }
            channelItemPayloadDiff = channelItemPayloadDiff2;
        }
        ((BaseChannelListItemViewHolder) viewHolder).bind(channel, i, channelItemPayloadDiff);
    }

    public int getItemCount() {
        return this.channels.size();
    }

    public ChannelListViewStyle getStyle() {
        return this.style;
    }

    public void setStyle(ChannelListViewStyle channelListViewStyle) {
        this.style = channelListViewStyle;
    }

    public void setViewHolderFactory(ChannelViewHolderFactory channelViewHolderFactory) {
        this.viewHolderFactory = channelViewHolderFactory;
    }
}
