package com.getstream.sdk.chat.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.view.messages.AvatarStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0017\u001a\u00020\u0016*\u0002022\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0014\u0010$\u001a\u00020\u0016*\u0002022\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u001f\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001a\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u0011\u0010#\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010%\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000eR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010-\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0016\u0010/\u001a\n 1*\u0004\u0018\u00010000X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/ChannelHeaderViewStyle;", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarStyle", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "getAvatarStyle", "()Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "backButtonBackground", "Landroid/graphics/drawable/Drawable;", "getBackButtonBackground", "()Landroid/graphics/drawable/Drawable;", "channelTitleText", "Lcom/getstream/sdk/chat/style/TextStyle;", "getChannelTitleText", "()Lcom/getstream/sdk/chat/style/TextStyle;", "setChannelTitleText", "(Lcom/getstream/sdk/chat/style/TextStyle;)V", "channelWithoutNameText", "", "getChannelWithoutNameText", "()Ljava/lang/String;", "isActiveBadgeShow", "", "()Z", "isAvatarGroupShow", "isBackButtonShow", "isLastActiveShow", "isOptionsButtonShow", "lastActiveText", "getLastActiveText", "setLastActiveText", "offlineText", "getOfflineText", "optionsButtonBackground", "getOptionsButtonBackground", "optionsButtonHeight", "", "getOptionsButtonHeight", "()I", "optionsButtonTextSize", "getOptionsButtonTextSize", "optionsButtonWidth", "getOptionsButtonWidth", "res", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "Landroid/content/res/TypedArray;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelHeaderViewStyle.kt */
public final class ChannelHeaderViewStyle {
    private final AvatarStyle avatarStyle;
    private final Drawable backButtonBackground;
    private TextStyle channelTitleText;
    private final String channelWithoutNameText;
    private final boolean isActiveBadgeShow;
    private final boolean isAvatarGroupShow;
    private final boolean isBackButtonShow;
    private final boolean isLastActiveShow;
    private final boolean isOptionsButtonShow;
    private TextStyle lastActiveText;
    private final String offlineText;
    private final Drawable optionsButtonBackground;
    private final int optionsButtonHeight;
    private final int optionsButtonTextSize;
    private final int optionsButtonWidth;
    private final Resources res;

    public ChannelHeaderViewStyle(Context context, AttributeSet attributeSet) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Resources resources = context.getResources();
        this.res = resources;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C1673R.styleable.ChannelHeaderView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "attributes");
        TextStyle.Builder builder = new TextStyle.Builder(obtainStyledAttributes);
        builder.size(C1673R.styleable.ChannelHeaderView_streamChannelHeaderTitleTextSize, resources.getDimensionPixelSize(C1673R.dimen.stream_channel_header_initials));
        builder.color(C1673R.styleable.ChannelHeaderView_streamChannelHeaderTitleTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_channel_initials));
        builder.style(C1673R.styleable.ChannelHeaderView_streamChannelHeaderTitleTextStyle, 1);
        builder.font(C1673R.styleable.ChannelHeaderView_streamChannelHeaderTitleTextFontAssets, C1673R.styleable.ChannelHeaderView_streamChannelHeaderTitleTextFont);
        Unit unit = Unit.INSTANCE;
        this.channelTitleText = builder.build();
        TextStyle.Builder builder2 = new TextStyle.Builder(obtainStyledAttributes);
        builder2.size(C1673R.styleable.ChannelHeaderView_streamChannelHeaderLastActiveTextSize, resources.getDimensionPixelSize(C1673R.dimen.stream_channel_preview_date));
        builder2.color(C1673R.styleable.ChannelHeaderView_streamChannelHeaderLastActiveTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark));
        builder2.font(C1673R.styleable.ChannelHeaderView_streamChannelHeaderLastActiveTextFontAssets, C1673R.styleable.ChannelHeaderView_streamChannelHeaderLastActiveTextFont);
        builder2.style(C1673R.styleable.ChannelHeaderView_streamChannelHeaderLastActiveTextStyle, 0);
        Unit unit2 = Unit.INSTANCE;
        this.lastActiveText = builder2.build();
        this.channelWithoutNameText = getChannelWithoutNameText(obtainStyledAttributes, context2);
        this.offlineText = getOfflineText(obtainStyledAttributes, context2);
        this.avatarStyle = AvatarStyle.Builder.avatarInitialText$default(new AvatarStyle.Builder(obtainStyledAttributes, context2).avatarWidth(C1673R.styleable.ChannelHeaderView_streamAvatarWidth, C1673R.dimen.stream_channel_avatar_width).avatarHeight(C1673R.styleable.ChannelHeaderView_streamAvatarHeight, C1673R.dimen.stream_channel_avatar_height).avatarBorderWidth(C1673R.styleable.ChannelHeaderView_streamAvatarBorderWidth, C1673R.dimen.stream_channel_avatar_border_width).avatarBorderColor(C1673R.styleable.ChannelHeaderView_streamAvatarBorderColor, -1).avatarBackgroundColor(C1673R.styleable.ChannelHeaderView_streamAvatarBackGroundColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)), C1673R.styleable.ChannelHeaderView_streamAvatarTextSize, C1673R.dimen.stream_channel_initials, C1673R.styleable.ChannelHeaderView_streamAvatarTextColor, -1, C1673R.styleable.ChannelHeaderView_streamAvatarTextFontAssets, C1673R.styleable.ChannelHeaderView_streamAvatarTextFont, C1673R.styleable.ChannelHeaderView_streamAvatarTextStyle, 0, 128, (Object) null).build();
        this.isLastActiveShow = obtainStyledAttributes.getBoolean(C1673R.styleable.ChannelHeaderView_streamChannelHeaderLastActiveShow, true);
        this.isBackButtonShow = obtainStyledAttributes.getBoolean(C1673R.styleable.ChannelHeaderView_streamChannelHeaderBackButtonShow, true);
        Drawable drawable = obtainStyledAttributes.getDrawable(C1673R.styleable.ChannelHeaderView_streamChannelHeaderBackButtonBackground);
        this.backButtonBackground = drawable == null ? ContextCompat.getDrawable(context2, C1673R.C1676drawable.stream_arrow_left) : drawable;
        this.isAvatarGroupShow = obtainStyledAttributes.getBoolean(C1673R.styleable.ChannelHeaderView_streamChannelHeaderAvatarShow, true);
        this.isActiveBadgeShow = obtainStyledAttributes.getBoolean(C1673R.styleable.ChannelHeaderView_streamChannelHeaderActiveBadgeShow, true);
        this.isOptionsButtonShow = obtainStyledAttributes.getBoolean(C1673R.styleable.ChannelHeaderView_streamChannelHeaderOptionsButtonShow, false);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C1673R.styleable.ChannelHeaderView_streamChannelHeaderOptionsButtonBackground);
        this.optionsButtonBackground = drawable2 == null ? ContextCompat.getDrawable(context2, C1673R.C1676drawable.stream_ic_settings) : drawable2;
        this.optionsButtonTextSize = (int) obtainStyledAttributes.getDimension(C1673R.styleable.ChannelHeaderView_streamChannelHeaderOptionsButtonTextSize, (float) resources.getDimensionPixelSize(C1673R.dimen.stream_channel_header_initials));
        this.optionsButtonWidth = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.ChannelHeaderView_streamChannelHeaderOptionsButtonWidth, resources.getDimensionPixelSize(C1673R.dimen.stream_channel_avatar_width));
        this.optionsButtonHeight = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.ChannelHeaderView_streamChannelHeaderOptionsButtonHeight, resources.getDimensionPixelSize(C1673R.dimen.stream_channel_avatar_height));
        obtainStyledAttributes.recycle();
    }

    public final TextStyle getChannelTitleText() {
        return this.channelTitleText;
    }

    public final void setChannelTitleText(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.channelTitleText = textStyle;
    }

    public final TextStyle getLastActiveText() {
        return this.lastActiveText;
    }

    public final void setLastActiveText(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.lastActiveText = textStyle;
    }

    public final boolean isBackButtonShow() {
        return this.isBackButtonShow;
    }

    public final boolean isLastActiveShow() {
        return this.isLastActiveShow;
    }

    public final boolean isAvatarGroupShow() {
        return this.isAvatarGroupShow;
    }

    public final boolean isOptionsButtonShow() {
        return this.isOptionsButtonShow;
    }

    public final int getOptionsButtonTextSize() {
        return this.optionsButtonTextSize;
    }

    public final int getOptionsButtonWidth() {
        return this.optionsButtonWidth;
    }

    public final int getOptionsButtonHeight() {
        return this.optionsButtonHeight;
    }

    public final boolean isActiveBadgeShow() {
        return this.isActiveBadgeShow;
    }

    public final Drawable getBackButtonBackground() {
        return this.backButtonBackground;
    }

    public final Drawable getOptionsButtonBackground() {
        return this.optionsButtonBackground;
    }

    public final String getOfflineText() {
        return this.offlineText;
    }

    public final String getChannelWithoutNameText() {
        return this.channelWithoutNameText;
    }

    public final AvatarStyle getAvatarStyle() {
        return this.avatarStyle;
    }

    private final String getOfflineText(TypedArray typedArray, Context context) {
        String string = typedArray.getString(C1673R.styleable.ChannelHeaderView_streamChannelHeaderOfflineText);
        if (string != null) {
            if (!(!StringsKt.isBlank(string))) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        String string2 = context.getString(C1673R.string.stream_channel_offlineText);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…ream_channel_offlineText)");
        return string2;
    }

    private final String getChannelWithoutNameText(TypedArray typedArray, Context context) {
        String string = typedArray.getString(C1673R.styleable.ChannelHeaderView_streamChannelWithOutNameTitleText);
        if (string != null) {
            if (!(!StringsKt.isBlank(string))) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        String string2 = context.getString(C1673R.string.stream_channel_unknown_title);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…am_channel_unknown_title)");
        return string2;
    }
}
