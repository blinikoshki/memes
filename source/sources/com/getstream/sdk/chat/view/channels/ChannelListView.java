package com.getstream.sdk.chat.view.channels;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.adapter.ChannelListItemAdapter;
import com.getstream.sdk.chat.adapter.ChannelViewHolderFactory;
import java.util.List;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;

public class ChannelListView extends RecyclerView {
    /* access modifiers changed from: private */
    public ChannelListItemAdapter adapter;
    private ChannelClickListener channelClickListener;
    private ChannelClickListener channelLongClickListener;
    /* access modifiers changed from: private */
    public EndReachedListener endReachedListener;
    private LinearLayoutManager layoutManager;
    private final EndReachedScrollListener scrollListener = new EndReachedScrollListener();
    private ChannelListViewStyle style;
    private UserClickListener userClickListener;
    private ChannelViewHolderFactory viewHolderFactory;

    public interface ChannelClickListener {
        void onClick(Channel channel);
    }

    public interface EndReachedListener {
        void onEndReached();
    }

    public interface UserClickListener {
        void onUserClick(User user);
    }

    public ChannelListView(Context context) {
        super(context);
        setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.layoutManager = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        init();
    }

    public ChannelListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.layoutManager = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        parseAttr(context, attributeSet);
        init();
    }

    public ChannelListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.layoutManager = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        parseAttr(context, attributeSet);
        init();
    }

    private void parseAttr(Context context, AttributeSet attributeSet) {
        ChannelListViewStyle channelListViewStyle = new ChannelListViewStyle(context, attributeSet);
        this.style = channelListViewStyle;
        int i = -1;
        if (channelListViewStyle.getAvatarBorderColor() == -1) {
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                i = ((ColorDrawable) background).getColor();
            }
            this.style.setAvatarBorderColor(i);
        }
    }

    private void init() {
        ChannelListItemAdapter channelListItemAdapter = new ChannelListItemAdapter();
        this.adapter = channelListItemAdapter;
        setAdapterWithStyle(channelListItemAdapter);
        this.adapter.setChannelClickListener(this.channelClickListener);
        setOnLongClickListener(this.channelLongClickListener);
        this.adapter.setUserClickListener(this.userClickListener);
    }

    private boolean canScrollUpForChannelEvent() {
        return this.layoutManager.findFirstVisibleItemPosition() < 3;
    }

    public void setViewHolderFactory(ChannelViewHolderFactory channelViewHolderFactory) {
        this.viewHolderFactory = channelViewHolderFactory;
        ChannelListItemAdapter channelListItemAdapter = this.adapter;
        if (channelListItemAdapter != null) {
            channelListItemAdapter.setViewHolderFactory(channelViewHolderFactory);
        }
    }

    public void setOnUserClickListener(UserClickListener userClickListener2) {
        this.userClickListener = userClickListener2;
        ChannelListItemAdapter channelListItemAdapter = this.adapter;
        if (channelListItemAdapter != null) {
            channelListItemAdapter.setUserClickListener(userClickListener2);
        }
    }

    public void setOnChannelClickListener(ChannelClickListener channelClickListener2) {
        this.channelClickListener = channelClickListener2;
        ChannelListItemAdapter channelListItemAdapter = this.adapter;
        if (channelListItemAdapter != null) {
            channelListItemAdapter.setChannelClickListener(channelClickListener2);
        }
    }

    public void setOnLongClickListener(ChannelClickListener channelClickListener2) {
        this.channelLongClickListener = channelClickListener2;
        ChannelListItemAdapter channelListItemAdapter = this.adapter;
        if (channelListItemAdapter != null && channelClickListener2 != null) {
            channelListItemAdapter.setChannelLongClickListener(channelClickListener2);
        }
    }

    public void setOnEndReachedListener(EndReachedListener endReachedListener2) {
        this.endReachedListener = endReachedListener2;
        observeListEndRegion();
    }

    private void observeListEndRegion() {
        addOnScrollListener(this.scrollListener);
    }

    public void setPaginationEnabled(boolean z) {
        this.scrollListener.setPaginationEnabled(z);
    }

    public void setChannels(List<Channel> list) {
        this.adapter.replaceChannels(list);
    }

    public void setAdapter(RecyclerView.Adapter adapter2) {
        throw new IllegalArgumentException("Use setAdapterWithStyle instead please");
    }

    public void onVisibilityChanged(View view, int i) {
        ChannelListItemAdapter channelListItemAdapter;
        super.onVisibilityChanged(view, i);
        if (i == 0 && (channelListItemAdapter = this.adapter) != null) {
            channelListItemAdapter.notifyDataSetChanged();
        }
    }

    public void setAdapterWithStyle(ChannelListItemAdapter channelListItemAdapter) {
        super.setAdapter(channelListItemAdapter);
        channelListItemAdapter.setStyle(this.style);
        ChannelViewHolderFactory channelViewHolderFactory = this.viewHolderFactory;
        if (channelViewHolderFactory != null) {
            channelListItemAdapter.setViewHolderFactory(channelViewHolderFactory);
        }
    }

    private class EndReachedScrollListener extends RecyclerView.OnScrollListener {
        private boolean enabled;

        private EndReachedScrollListener() {
            this.enabled = false;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                boolean z = true;
                if (ChannelListView.this.adapter.getItemCount() - 1 != ((LinearLayoutManager) ChannelListView.this.getLayoutManager()).findLastVisibleItemPosition()) {
                    z = false;
                }
                if (z && this.enabled) {
                    ChannelListView.this.endReachedListener.onEndReached();
                }
            }
        }

        public void setPaginationEnabled(boolean z) {
            this.enabled = z;
        }
    }
}
