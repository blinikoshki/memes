package com.getstream.sdk.chat.view.channels;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.view.ReadStateStyle;
import com.getstream.sdk.chat.view.messages.AvatarStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00101\u001a\u00020\u001dR&\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010$\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010&\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010(\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\n 0*\u0004\u0018\u00010/0/X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/channels/ChannelListViewStyle;", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "avatarBorderColor", "getAvatarBorderColor", "()I", "setAvatarBorderColor", "(I)V", "avatarStyle", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "getAvatarStyle", "()Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "setAvatarStyle", "(Lcom/getstream/sdk/chat/view/messages/AvatarStyle;)V", "channelPreviewLayout", "getChannelPreviewLayout", "channelTitleText", "Lcom/getstream/sdk/chat/style/TextStyle;", "getChannelTitleText", "()Lcom/getstream/sdk/chat/style/TextStyle;", "channelTitleUnreadText", "getChannelTitleUnreadText", "channelWithoutNameText", "", "itemSeparatorDrawable", "Landroid/graphics/drawable/Drawable;", "getItemSeparatorDrawable", "()Landroid/graphics/drawable/Drawable;", "lastMessage", "getLastMessage", "lastMessageDateText", "getLastMessageDateText", "lastMessageDateUnreadText", "getLastMessageDateUnreadText", "lastMessageUnread", "getLastMessageUnread", "readStateStyle", "Lcom/getstream/sdk/chat/view/ReadStateStyle;", "getReadStateStyle", "()Lcom/getstream/sdk/chat/view/ReadStateStyle;", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "getChannelWithoutNameText", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelListViewStyle.kt */
public final class ChannelListViewStyle {
    private AvatarStyle avatarStyle;
    private final int channelPreviewLayout;
    private final TextStyle channelTitleText;
    private final TextStyle channelTitleUnreadText;
    private String channelWithoutNameText = "";
    private final Drawable itemSeparatorDrawable;
    private final TextStyle lastMessage;
    private final TextStyle lastMessageDateText;
    private final TextStyle lastMessageDateUnreadText;
    private final TextStyle lastMessageUnread;
    private final ReadStateStyle readStateStyle;
    private final Resources resources;

    public ChannelListViewStyle(Context context, AttributeSet attributeSet) {
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        Intrinsics.checkNotNullParameter(context2, "context");
        Resources resources2 = context.getResources();
        this.resources = resources2;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, C1673R.styleable.ChannelListView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "attributes");
        TextStyle.Builder builder = new TextStyle.Builder(obtainStyledAttributes);
        builder.size(C1673R.styleable.ChannelListView_streamChannelTitleTextSize, resources2.getDimensionPixelSize(C1673R.dimen.stream_channel_item_title));
        builder.color(C1673R.styleable.ChannelListView_streamChannelTitleTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_channel_item_text_color));
        builder.font(C1673R.styleable.ChannelListView_streamChannelTitleTextFontAssets, C1673R.styleable.ChannelListView_streamChannelTitleTextFont);
        builder.style(C1673R.styleable.ChannelListView_streamChannelTitleTextStyle, 1);
        Unit unit = Unit.INSTANCE;
        this.channelTitleText = builder.build();
        TextStyle.Builder builder2 = new TextStyle.Builder(obtainStyledAttributes);
        builder2.size(C1673R.styleable.ChannelListView_streamChannelTitleTextSize, resources2.getDimensionPixelSize(C1673R.dimen.stream_channel_item_title));
        builder2.color(C1673R.styleable.ChannelListView_streamChannelTitleUnreadTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_channel_item_text_color));
        builder2.font(C1673R.styleable.ChannelListView_streamChannelTitleTextFontAssets, C1673R.styleable.ChannelListView_streamChannelTitleTextFont);
        builder2.style(C1673R.styleable.ChannelListView_streamChannelTitleUnreadTextStyle, 1);
        Unit unit2 = Unit.INSTANCE;
        this.channelTitleUnreadText = builder2.build();
        String string = obtainStyledAttributes.getString(C1673R.styleable.ChannelListView_streamChannelWithOutNameTitleText);
        if (string != null) {
            Intrinsics.checkNotNullExpressionValue(string, "it");
            this.channelWithoutNameText = string;
        }
        TextStyle.Builder builder3 = new TextStyle.Builder(obtainStyledAttributes);
        builder3.size(C1673R.styleable.ChannelListView_streamLastMessageTextSize, resources2.getDimensionPixelSize(C1673R.dimen.stream_channel_item_message));
        builder3.color(C1673R.styleable.ChannelListView_streamLastMessageTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark));
        builder3.font(C1673R.styleable.ChannelListView_streamLastMessageTextFontAssets, C1673R.styleable.ChannelListView_streamLastMessageTextFont);
        builder3.style(C1673R.styleable.ChannelListView_streamLastMessageTextStyle, 0);
        Unit unit3 = Unit.INSTANCE;
        this.lastMessage = builder3.build();
        TextStyle.Builder builder4 = new TextStyle.Builder(obtainStyledAttributes);
        builder4.size(C1673R.styleable.ChannelListView_streamLastMessageTextSize, resources2.getDimensionPixelSize(C1673R.dimen.stream_channel_item_message));
        builder4.color(C1673R.styleable.ChannelListView_streamLastMessageUnreadTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_channel_item_text_color));
        builder4.font(C1673R.styleable.ChannelListView_streamLastMessageTextFontAssets, C1673R.styleable.ChannelListView_streamLastMessageTextFont);
        builder4.style(C1673R.styleable.ChannelListView_streamLastMessageUnreadTextStyle, 1);
        Unit unit4 = Unit.INSTANCE;
        this.lastMessageUnread = builder4.build();
        TextStyle.Builder builder5 = new TextStyle.Builder(obtainStyledAttributes);
        builder5.size(C1673R.styleable.ChannelListView_streamLastMessageDateTextSize, resources2.getDimensionPixelSize(C1673R.dimen.stream_channel_item_message_date));
        builder5.color(C1673R.styleable.ChannelListView_streamLastMessageDateTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark));
        builder5.font(C1673R.styleable.ChannelListView_streamLastMessageDateTextFontAssets, C1673R.styleable.ChannelListView_streamLastMessageDateTextFont);
        builder5.style(C1673R.styleable.ChannelListView_streamLastMessageDateTextStyle, 0);
        Unit unit5 = Unit.INSTANCE;
        this.lastMessageDateText = builder5.build();
        TextStyle.Builder builder6 = new TextStyle.Builder(obtainStyledAttributes);
        builder6.size(C1673R.styleable.ChannelListView_streamLastMessageDateTextSize, resources2.getDimensionPixelSize(C1673R.dimen.stream_channel_item_message_date));
        builder6.color(C1673R.styleable.ChannelListView_streamLastMessageDateUnreadTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_channel_item_text_color));
        builder6.font(C1673R.styleable.ChannelListView_streamLastMessageDateTextFontAssets, C1673R.styleable.ChannelListView_streamLastMessageDateTextFont);
        builder6.style(C1673R.styleable.ChannelListView_streamLastMessageDateUnreadTextStyle, 1);
        Unit unit6 = Unit.INSTANCE;
        this.lastMessageDateUnreadText = builder6.build();
        this.channelPreviewLayout = obtainStyledAttributes.getResourceId(C1673R.styleable.ChannelListView_streamChannelPreviewLayout, C1673R.C1679layout.stream_item_channel);
        this.avatarStyle = AvatarStyle.Builder.avatarInitialText$default(new AvatarStyle.Builder(obtainStyledAttributes, context2).avatarWidth(C1673R.styleable.ChannelListView_streamAvatarWidth, C1673R.dimen.stream_channel_avatar_width).avatarHeight(C1673R.styleable.ChannelListView_streamAvatarHeight, C1673R.dimen.stream_channel_avatar_height).avatarBorderWidth(C1673R.styleable.ChannelListView_streamAvatarBorderWidth, C1673R.dimen.stream_channel_avatar_border_width).avatarBorderColor(C1673R.styleable.ChannelListView_streamAvatarBorderColor, -1).avatarBackgroundColor(C1673R.styleable.ChannelListView_streamAvatarBackGroundColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)), C1673R.styleable.ChannelListView_streamAvatarTextSize, C1673R.dimen.stream_channel_initials, C1673R.styleable.ChannelListView_streamAvatarTextColor, -1, C1673R.styleable.ChannelListView_streamAvatarTextFontAssets, C1673R.styleable.ChannelListView_streamAvatarTextFont, C1673R.styleable.ChannelListView_streamAvatarTextStyle, 0, 128, (Object) null).build();
        this.readStateStyle = new ReadStateStyle.Builder(obtainStyledAttributes, context2).isReadStateEnabled(C1673R.styleable.ChannelListView_streamShowReadState, true).readStateAvatarWidth(C1673R.styleable.ChannelListView_streamReadStateAvatarWidth, obtainStyledAttributes.getResources().getDimensionPixelSize(C1673R.dimen.stream_read_state_avatar_width)).readStateAvatarHeight(C1673R.styleable.ChannelListView_streamReadStateAvatarHeight, obtainStyledAttributes.getResources().getDimensionPixelSize(C1673R.dimen.stream_read_state_avatar_height)).readStateText(C1673R.styleable.ChannelListView_streamReadStateTextSize, C1673R.dimen.stream_read_state_text_size, C1673R.styleable.ChannelListView_streamReadStateTextColor, -16777216, C1673R.styleable.ChannelListView_streamReadStateTextFontAssets, C1673R.styleable.ChannelListView_streamReadStateTextFont, C1673R.styleable.ChannelListView_streamReadStateTextStyle, 1).build();
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet2, C1673R.styleable.ChannelsView, 0, 0);
        this.itemSeparatorDrawable = obtainStyledAttributes2.getDrawable(C1673R.styleable.ChannelsView_streamChannelsItemSeparatorDrawable);
        obtainStyledAttributes2.recycle();
    }

    public final int getChannelPreviewLayout() {
        return this.channelPreviewLayout;
    }

    public final TextStyle getChannelTitleText() {
        return this.channelTitleText;
    }

    public final TextStyle getChannelTitleUnreadText() {
        return this.channelTitleUnreadText;
    }

    public final TextStyle getLastMessage() {
        return this.lastMessage;
    }

    public final TextStyle getLastMessageUnread() {
        return this.lastMessageUnread;
    }

    public final TextStyle getLastMessageDateText() {
        return this.lastMessageDateText;
    }

    public final TextStyle getLastMessageDateUnreadText() {
        return this.lastMessageDateUnreadText;
    }

    public final AvatarStyle getAvatarStyle() {
        return this.avatarStyle;
    }

    public final void setAvatarStyle(AvatarStyle avatarStyle2) {
        Intrinsics.checkNotNullParameter(avatarStyle2, "<set-?>");
        this.avatarStyle = avatarStyle2;
    }

    public final ReadStateStyle getReadStateStyle() {
        return this.readStateStyle;
    }

    public final Drawable getItemSeparatorDrawable() {
        return this.itemSeparatorDrawable;
    }

    public final String getChannelWithoutNameText() {
        String str = this.channelWithoutNameText;
        if (!(!StringsKt.isBlank(str))) {
            str = null;
        }
        if (str != null) {
            return str;
        }
        String string = this.resources.getString(C1673R.string.stream_channel_unknown_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…am_channel_unknown_title)");
        return string;
    }

    public final int getAvatarBorderColor() {
        return this.avatarStyle.getAvatarBorderColor();
    }

    public final void setAvatarBorderColor(int i) {
        this.avatarStyle = AvatarStyle.copy$default(this.avatarStyle, 0, 0, 0, i, 0, (TextStyle) null, 55, (Object) null);
    }
}
