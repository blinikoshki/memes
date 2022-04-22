package com.memes.chat.p036ui.channel.list.pages;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.getstream.sdk.chat.adapter.BaseChannelListItemViewHolder;
import com.getstream.sdk.chat.adapter.ChannelItemPayloadDiff;
import com.getstream.sdk.chat.adapter.ChannelListItemAdapter;
import com.getstream.sdk.chat.adapter.ChannelViewHolderFactory;
import com.getstream.sdk.chat.view.channels.ChannelListView;
import com.getstream.sdk.chat.view.channels.ChannelListViewStyle;
import com.memes.chat.p036ui.channel.list.ChannelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p015io.getstream.chat.android.client.models.Channel;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/pages/ChannelTypeAwareChannelViewHolderFactory;", "Lcom/getstream/sdk/chat/adapter/ChannelViewHolderFactory;", "context", "Landroid/content/Context;", "channelType", "", "(Landroid/content/Context;Ljava/lang/String;)V", "createChannelViewHolder", "Lcom/getstream/sdk/chat/adapter/BaseChannelListItemViewHolder;", "adapter", "Lcom/getstream/sdk/chat/adapter/ChannelListItemAdapter;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getChannelViewType", "channel", "Lio/getstream/chat/android/client/models/Channel;", "BadChannelTypeViewHolder", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.pages.ChannelTypeAwareChannelViewHolderFactory */
/* compiled from: ChannelTypeAwareChannelViewHolderFactory.kt */
public final class ChannelTypeAwareChannelViewHolderFactory extends ChannelViewHolderFactory {
    private static final int BAD_CHANNEL_TYPE = 1353;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String channelType;
    private final Context context;

    public ChannelTypeAwareChannelViewHolderFactory(Context context2, String str) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "channelType");
        this.context = context2;
        this.channelType = str;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/pages/ChannelTypeAwareChannelViewHolderFactory$Companion;", "", "()V", "BAD_CHANNEL_TYPE", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.list.pages.ChannelTypeAwareChannelViewHolderFactory$Companion */
    /* compiled from: ChannelTypeAwareChannelViewHolderFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public int getChannelViewType(Channel channel) {
        String typeFromCid;
        String cid = channel != null ? channel.getCid() : null;
        CharSequence charSequence = cid;
        if ((charSequence == null || StringsKt.isBlank(charSequence)) || (typeFromCid = ChannelType.INSTANCE.getTypeFromCid(cid)) == null || !(true ^ Intrinsics.areEqual((Object) typeFromCid, (Object) this.channelType))) {
            return super.getChannelViewType(channel);
        }
        Timber.m300d("|> Unmatched channel: required " + this.channelType + ", recevied " + typeFromCid + ", cid=" + cid, new Object[0]);
        return BAD_CHANNEL_TYPE;
    }

    public BaseChannelListItemViewHolder createChannelViewHolder(ChannelListItemAdapter channelListItemAdapter, ViewGroup viewGroup, int i) {
        if (i == BAD_CHANNEL_TYPE) {
            Timber.m300d("|> Asked for a viewholder for bad-channel; but using default", new Object[0]);
            View view = new View(this.context);
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
            view.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            return new BadChannelTypeViewHolder(this, view);
        }
        BaseChannelListItemViewHolder createChannelViewHolder = super.createChannelViewHolder(channelListItemAdapter, viewGroup, i);
        Intrinsics.checkNotNullExpressionValue(createChannelViewHolder, "super.createChannelViewH…dapter, parent, viewType)");
        return createChannelViewHolder;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/pages/ChannelTypeAwareChannelViewHolderFactory$BadChannelTypeViewHolder;", "Lcom/getstream/sdk/chat/adapter/BaseChannelListItemViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/memes/chat/ui/channel/list/pages/ChannelTypeAwareChannelViewHolderFactory;Landroid/view/View;)V", "bind", "", "channelState", "Lio/getstream/chat/android/client/models/Channel;", "position", "", "payloads", "Lcom/getstream/sdk/chat/adapter/ChannelItemPayloadDiff;", "setChannelClickListener", "channelClickListener", "Lcom/getstream/sdk/chat/view/channels/ChannelListView$ChannelClickListener;", "setChannelLongClickListener", "setStyle", "style", "Lcom/getstream/sdk/chat/view/channels/ChannelListViewStyle;", "setUserClickListener", "userClickListener", "Lcom/getstream/sdk/chat/view/channels/ChannelListView$UserClickListener;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.list.pages.ChannelTypeAwareChannelViewHolderFactory$BadChannelTypeViewHolder */
    /* compiled from: ChannelTypeAwareChannelViewHolderFactory.kt */
    private final class BadChannelTypeViewHolder extends BaseChannelListItemViewHolder {
        final /* synthetic */ ChannelTypeAwareChannelViewHolderFactory this$0;

        public void bind(Channel channel, int i, ChannelItemPayloadDiff channelItemPayloadDiff) {
            Intrinsics.checkNotNullParameter(channel, "channelState");
            Intrinsics.checkNotNullParameter(channelItemPayloadDiff, "payloads");
        }

        public void setChannelClickListener(ChannelListView.ChannelClickListener channelClickListener) {
        }

        public void setChannelLongClickListener(ChannelListView.ChannelClickListener channelClickListener) {
        }

        public void setStyle(ChannelListViewStyle channelListViewStyle) {
            Intrinsics.checkNotNullParameter(channelListViewStyle, "style");
        }

        public void setUserClickListener(ChannelListView.UserClickListener userClickListener) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BadChannelTypeViewHolder(ChannelTypeAwareChannelViewHolderFactory channelTypeAwareChannelViewHolderFactory, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = channelTypeAwareChannelViewHolderFactory;
            view.setVisibility(0);
        }
    }
}
