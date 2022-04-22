package com.getstream.sdk.chat.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.utils.DateFormatter;
import com.getstream.sdk.chat.utils.DateFormatterKt;
import com.getstream.sdk.chat.utils.extensions.ChannelUtils;
import com.getstream.sdk.chat.utils.extensions.MemberUtils;
import com.getstream.sdk.chat.view.AvatarView;
import com.getstream.sdk.chat.view.ReadStateView;
import com.getstream.sdk.chat.view.channels.ChannelListView;
import com.getstream.sdk.chat.view.channels.ChannelListViewStyle;
import java.util.List;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Message;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.ChatDomain;

public class ChannelListItemViewHolder extends BaseChannelListItemViewHolder {
    protected AvatarView avatarView;
    protected ChannelListView.ChannelClickListener channelClickListener;
    protected ChannelListView.ChannelClickListener channelLongClickListener;
    protected View click_area;
    protected DateFormatter defaultDateFormatter = DateFormatter.CC.from(this.itemView.getContext());
    protected ImageView iv_attachment_type;
    protected ReadStateView read_state;
    protected ChannelListViewStyle style;
    protected TextView tv_date;
    protected TextView tv_last_message;
    protected TextView tv_name;
    protected ChannelListView.UserClickListener userClickListener;

    public ChannelListItemViewHolder(View view) {
        super(view);
        findReferences();
    }

    public void setUserClickListener(ChannelListView.UserClickListener userClickListener2) {
        this.userClickListener = userClickListener2;
    }

    public void setChannelClickListener(ChannelListView.ChannelClickListener channelClickListener2) {
        this.channelClickListener = channelClickListener2;
    }

    public void setChannelLongClickListener(ChannelListView.ChannelClickListener channelClickListener2) {
        this.channelLongClickListener = channelClickListener2;
    }

    /* access modifiers changed from: protected */
    public void findReferences() {
        this.tv_name = (TextView) this.itemView.findViewById(C1673R.C1677id.tv_name);
        this.tv_last_message = (TextView) this.itemView.findViewById(C1673R.C1677id.tv_last_message);
        this.iv_attachment_type = (ImageView) this.itemView.findViewById(C1673R.C1677id.iv_attachment_type);
        this.tv_date = (TextView) this.itemView.findViewById(C1673R.C1677id.tv_date);
        this.click_area = this.itemView.findViewById(C1673R.C1677id.click_area);
        this.avatarView = (AvatarView) this.itemView.findViewById(C1673R.C1677id.avatar_group);
        this.read_state = (ReadStateView) this.itemView.findViewById(C1673R.C1677id.read_state);
    }

    public void setStyle(ChannelListViewStyle channelListViewStyle) {
        this.style = channelListViewStyle;
    }

    public void bind(Channel channel, int i, ChannelItemPayloadDiff channelItemPayloadDiff) {
        if (channelItemPayloadDiff.getName()) {
            configChannelName(channel);
        }
        if (channelItemPayloadDiff.getAvatarView()) {
            configAvatarView(channel);
        }
        if (channelItemPayloadDiff.getLastMessage()) {
            configLastMessage(channel);
        }
        if (channelItemPayloadDiff.getLastMessageDate()) {
            configLastMessageDate(channel);
        }
        if (channelItemPayloadDiff.getReadState()) {
            configReadState(channel);
        }
        configClickListeners(channel);
        applyStyle(channel);
    }

    /* access modifiers changed from: protected */
    public void configChannelName(Channel channel) {
        String channelNameOrMembers = ChannelUtils.getChannelNameOrMembers(channel);
        TextView textView = this.tv_name;
        if (TextUtils.isEmpty(channelNameOrMembers)) {
            channelNameOrMembers = this.style.getChannelWithoutNameText();
        }
        textView.setText(channelNameOrMembers);
    }

    /* access modifiers changed from: protected */
    public void configAvatarView(Channel channel) {
        List<User> otherUsers = MemberUtils.getOtherUsers(channel.getMembers());
        this.avatarView.setChannelAndLastActiveUsers(channel, otherUsers, this.style.getAvatarStyle());
        this.avatarView.setOnClickListener(new View.OnClickListener(otherUsers, channel) {
            public final /* synthetic */ List f$1;
            public final /* synthetic */ Channel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                ChannelListItemViewHolder.this.lambda$configAvatarView$0$ChannelListItemViewHolder(this.f$1, this.f$2, view);
            }
        });
    }

    public /* synthetic */ void lambda$configAvatarView$0$ChannelListItemViewHolder(List list, Channel channel, View view) {
        ChannelListView.UserClickListener userClickListener2;
        if (list.size() != 1 || (userClickListener2 = this.userClickListener) == null) {
            ChannelListView.ChannelClickListener channelClickListener2 = this.channelClickListener;
            if (channelClickListener2 != null) {
                channelClickListener2.onClick(channel);
                return;
            }
            return;
        }
        userClickListener2.onUserClick((User) list.get(0));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
        if (r2.equals("file") == false) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configLastMessage(p015io.getstream.chat.android.client.models.Channel r6) {
        /*
            r5 = this;
            io.getstream.chat.android.client.models.Message r6 = com.getstream.sdk.chat.utils.extensions.ChannelUtils.computeLastMessage(r6)
            android.widget.ImageView r0 = r5.iv_attachment_type
            r1 = 8
            r0.setVisibility(r1)
            java.lang.String r0 = ""
            if (r6 != 0) goto L_0x0015
            android.widget.TextView r6 = r5.tv_last_message
            r6.setText(r0)
            return
        L_0x0015:
            java.lang.String r1 = r6.getText()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0031
            java.lang.String r6 = com.getstream.sdk.chat.utils.StringUtility.getDeletedOrMentionedText(r6)
            com.getstream.sdk.chat.ChatUI r0 = com.getstream.sdk.chat.ChatUI.instance()
            com.getstream.sdk.chat.ChatMarkdown r0 = r0.getMarkdown()
            android.widget.TextView r1 = r5.tv_last_message
            r0.setText(r1, r6)
            return
        L_0x0031:
            java.util.List r1 = r6.getAttachments()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0041
            android.widget.TextView r6 = r5.tv_last_message
            r6.setText(r0)
            return
        L_0x0041:
            java.util.List r6 = r6.getAttachments()
            r0 = 0
            java.lang.Object r6 = r6.get(r0)
            io.getstream.chat.android.client.models.Attachment r6 = (p015io.getstream.chat.android.client.models.Attachment) r6
            java.lang.String r1 = r6.getType()
            if (r1 == 0) goto L_0x0103
            android.widget.ImageView r1 = r5.iv_attachment_type
            android.content.Context r1 = r1.getContext()
            android.widget.ImageView r2 = r5.iv_attachment_type
            r2.setVisibility(r0)
            java.lang.String r2 = r6.getType()
            r2.hashCode()
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case 3143036: goto L_0x0084;
                case 98361695: goto L_0x0079;
                case 100313435: goto L_0x006e;
                default: goto L_0x006c;
            }
        L_0x006c:
            r0 = -1
            goto L_0x008d
        L_0x006e:
            java.lang.String r0 = "image"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0077
            goto L_0x006c
        L_0x0077:
            r0 = 2
            goto L_0x008d
        L_0x0079:
            java.lang.String r0 = "giphy"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0082
            goto L_0x006c
        L_0x0082:
            r0 = 1
            goto L_0x008d
        L_0x0084:
            java.lang.String r4 = "file"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x008d
            goto L_0x006c
        L_0x008d:
            switch(r0) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x00b3;
                case 2: goto L_0x00a6;
                default: goto L_0x0090;
            }
        L_0x0090:
            java.lang.String r0 = r6.getTitle()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x009f
            java.lang.String r6 = r6.getTitle()
            goto L_0x00a3
        L_0x009f:
            java.lang.String r6 = r6.getFallback()
        L_0x00a3:
            int r0 = com.getstream.sdk.chat.C1673R.C1676drawable.stream_ic_file
            goto L_0x00f5
        L_0x00a6:
            android.content.res.Resources r6 = r1.getResources()
            int r0 = com.getstream.sdk.chat.C1673R.string.stream_last_message_attachment_photo
            java.lang.String r6 = r6.getString(r0)
            int r0 = com.getstream.sdk.chat.C1673R.C1676drawable.stream_ic_image
            goto L_0x00f5
        L_0x00b3:
            android.content.res.Resources r6 = r1.getResources()
            int r0 = com.getstream.sdk.chat.C1673R.string.stream_last_message_attachment_giphy
            java.lang.String r6 = r6.getString(r0)
            int r0 = com.getstream.sdk.chat.C1673R.C1676drawable.stream_ic_gif
            goto L_0x00f5
        L_0x00c0:
            java.lang.String r0 = r6.getMimeType()
            if (r0 == 0) goto L_0x00e0
            java.lang.String r0 = r6.getMimeType()
            java.lang.String r2 = "video"
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x00e0
            android.content.res.Resources r6 = r1.getResources()
            int r0 = com.getstream.sdk.chat.C1673R.string.stream_last_message_attachment_video
            java.lang.String r6 = r6.getString(r0)
            int r0 = com.getstream.sdk.chat.C1673R.C1676drawable.stream_ic_video
            goto L_0x00f5
        L_0x00e0:
            java.lang.String r0 = r6.getTitle()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ef
            java.lang.String r6 = r6.getTitle()
            goto L_0x00f3
        L_0x00ef:
            java.lang.String r6 = r6.getFallback()
        L_0x00f3:
            int r0 = com.getstream.sdk.chat.C1673R.C1676drawable.stream_ic_file
        L_0x00f5:
            android.widget.TextView r2 = r5.tv_last_message
            r2.setText(r6)
            android.widget.ImageView r6 = r5.iv_attachment_type
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r1, r0)
            r6.setImageDrawable(r0)
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.adapter.ChannelListItemViewHolder.configLastMessage(io.getstream.chat.android.client.models.Channel):void");
    }

    /* access modifiers changed from: protected */
    public void configLastMessageDate(Channel channel) {
        this.tv_date.setText(DateFormatterKt.formatDate(this.defaultDateFormatter, channel.getLastMessageAt()));
    }

    /* access modifiers changed from: protected */
    public void configReadState(Channel channel) {
        this.read_state.setReads(channel.getRead(), true, this.style.getReadStateStyle(), this.style.getAvatarStyle());
    }

    /* access modifiers changed from: protected */
    public void configClickListeners(Channel channel) {
        this.click_area.setOnClickListener(new View.OnClickListener(channel) {
            public final /* synthetic */ Channel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ChannelListItemViewHolder.this.lambda$configClickListeners$1$ChannelListItemViewHolder(this.f$1, view);
            }
        });
        this.click_area.setOnLongClickListener(new View.OnLongClickListener(channel) {
            public final /* synthetic */ Channel f$1;

            {
                this.f$1 = r2;
            }

            public final boolean onLongClick(View view) {
                return ChannelListItemViewHolder.this.lambda$configClickListeners$2$ChannelListItemViewHolder(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$configClickListeners$1$ChannelListItemViewHolder(Channel channel, View view) {
        ChannelListView.ChannelClickListener channelClickListener2 = this.channelClickListener;
        if (channelClickListener2 != null) {
            channelClickListener2.onClick(channel);
        }
    }

    public /* synthetic */ boolean lambda$configClickListeners$2$ChannelListItemViewHolder(Channel channel, View view) {
        ChannelListView.ChannelClickListener channelClickListener2 = this.channelLongClickListener;
        if (channelClickListener2 == null) {
            return true;
        }
        channelClickListener2.onClick(channel);
        return true;
    }

    /* access modifiers changed from: protected */
    public void applyStyle(Channel channel) {
        boolean z = false;
        this.tv_name.setTextSize(0, (float) this.style.getChannelTitleText().getSize());
        this.tv_last_message.setTextSize(0, (float) this.style.getLastMessage().getSize());
        this.tv_date.setTextSize(0, (float) this.style.getChannelTitleText().getSize());
        String id = ChatDomain.CC.instance().getCurrentUser().getId();
        Message computeLastMessage = ChannelUtils.computeLastMessage(channel);
        if (computeLastMessage != null && computeLastMessage.getUser().getId().equals(id)) {
            z = true;
        }
        if (ChannelUtils.readLastMessage(channel) || z) {
            applyReadStyle();
        } else {
            applyUnreadStyle();
        }
    }

    /* access modifiers changed from: protected */
    public void applyReadStyle() {
        this.style.getChannelTitleText().apply(this.tv_name);
        this.style.getLastMessage().apply(this.tv_last_message);
        this.style.getLastMessageDateText().apply(this.tv_date);
        if (this.iv_attachment_type.getDrawable() != null) {
            DrawableCompat.setTint(this.iv_attachment_type.getDrawable(), this.style.getLastMessage().getColor());
        }
    }

    /* access modifiers changed from: protected */
    public void applyUnreadStyle() {
        this.style.getChannelTitleUnreadText().apply(this.tv_name);
        this.style.getLastMessageUnread().apply(this.tv_last_message);
        this.style.getLastMessageDateUnreadText().apply(this.tv_date);
        if (this.iv_attachment_type.getDrawable() != null) {
            DrawableCompat.setTint(this.iv_attachment_type.getDrawable(), this.style.getLastMessageUnread().getColor());
        }
    }
}
