package com.getstream.sdk.chat.view.channels;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.adapter.ChannelViewHolderFactory;
import com.getstream.sdk.chat.view.channels.ChannelListView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u0010J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u0010J\u001a\u0010\u001f\u001a\u00020\u00142\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140!J\u0014\u0010\"\u001a\u00020\u00142\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140#J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010 \u001a\u00020%J\u000e\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u0014J\u0006\u0010-\u001a\u00020\u0014R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/channels/ChannelsView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CHANNEL_LIST_VIEW_ID", "channelListView", "Lcom/getstream/sdk/chat/view/channels/ChannelListView;", "emptyStateView", "Landroid/view/View;", "loadingView", "defaultChildLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "defaultEmptyStateView", "defaultLoadingView", "hideEmptyStateView", "", "hideLoadingView", "parseAttrs", "setChannels", "channels", "", "Lio/getstream/chat/android/client/models/Channel;", "setEmptyStateView", "view", "layoutParams", "setLoadingView", "setOnChannelClickListener", "listener", "Lkotlin/Function1;", "setOnEndReachedListener", "Lkotlin/Function0;", "setOnLongClickListener", "Lcom/getstream/sdk/chat/view/channels/ChannelListView$ChannelClickListener;", "setPaginationEnabled", "enabled", "", "setViewHolderFactory", "factory", "Lcom/getstream/sdk/chat/adapter/ChannelViewHolderFactory;", "showEmptyStateView", "showLoadingView", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelsView.kt */
public final class ChannelsView extends FrameLayout {
    private final int CHANNEL_LIST_VIEW_ID;
    private final ChannelListView channelListView;
    private View emptyStateView;
    private View loadingView;

    public ChannelsView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public ChannelsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = C1673R.C1677id.stream_channels_list_view_id;
        this.CHANNEL_LIST_VIEW_ID = i2;
        this.emptyStateView = defaultEmptyStateView();
        this.loadingView = defaultLoadingView();
        ChannelListView channelListView2 = new ChannelListView(context, attributeSet, i);
        channelListView2.setId(i2);
        Unit unit = Unit.INSTANCE;
        this.channelListView = channelListView2;
        addView(channelListView2, new FrameLayout.LayoutParams(-1, -1));
        View view = this.emptyStateView;
        view.setVisibility(8);
        addView(view, defaultChildLayoutParams());
        this.loadingView.setVisibility(8);
        addView(this.loadingView, defaultChildLayoutParams());
        parseAttrs(attributeSet);
    }

    private final void parseAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1673R.styleable.ChannelsView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.ChannelsView, 0, 0)");
        CharSequence text = obtainStyledAttributes.getText(C1673R.styleable.ChannelsView_streamChannelsEmptyStateLabelText);
        if (text != null) {
            View view = this.emptyStateView;
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void setEmptyStateView$default(ChannelsView channelsView, View view, FrameLayout.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = channelsView.defaultChildLayoutParams();
        }
        channelsView.setEmptyStateView(view, layoutParams);
    }

    public final void setEmptyStateView(View view, FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        removeView(this.emptyStateView);
        this.emptyStateView = view;
        addView(view, layoutParams);
    }

    public static /* synthetic */ void setLoadingView$default(ChannelsView channelsView, View view, FrameLayout.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = channelsView.defaultChildLayoutParams();
        }
        channelsView.setLoadingView(view, layoutParams);
    }

    public final void setLoadingView(View view, FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        removeView(this.loadingView);
        this.loadingView = view;
        addView(view, layoutParams);
    }

    public final void setViewHolderFactory(ChannelViewHolderFactory channelViewHolderFactory) {
        Intrinsics.checkNotNullParameter(channelViewHolderFactory, "factory");
        this.channelListView.setViewHolderFactory(channelViewHolderFactory);
    }

    public final void setOnChannelClickListener(Function1<? super Channel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.channelListView.setOnChannelClickListener(new C1743xa06668da(function1));
    }

    public final void setOnLongClickListener(ChannelListView.ChannelClickListener channelClickListener) {
        Intrinsics.checkNotNullParameter(channelClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.channelListView.setOnLongClickListener(channelClickListener);
    }

    public final void setOnEndReachedListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.channelListView.setOnEndReachedListener(new C1744xe62cd14c(function0));
    }

    public final void setChannels(List<Channel> list) {
        Intrinsics.checkNotNullParameter(list, "channels");
        this.channelListView.setChannels(list);
    }

    public final void hideLoadingView() {
        this.loadingView.setVisibility(8);
    }

    public final void showLoadingView() {
        this.loadingView.setVisibility(0);
    }

    public final void showEmptyStateView() {
        this.emptyStateView.setVisibility(0);
    }

    public final void hideEmptyStateView() {
        this.emptyStateView.setVisibility(8);
    }

    public final void setPaginationEnabled(boolean z) {
        this.channelListView.setPaginationEnabled(z);
    }

    private final FrameLayout.LayoutParams defaultChildLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2, 17);
    }

    private final View defaultLoadingView() {
        return new ProgressBar(getContext());
    }

    private final View defaultEmptyStateView() {
        TextView textView = new TextView(getContext());
        textView.setText(C1673R.string.stream_channels_empty_state_label);
        return textView;
    }
}
