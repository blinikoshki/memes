package com.getstream.sdk.chat.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.appsflyer.share.Constants;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.style.TextStyle;
import com.getstream.sdk.chat.view.ReadStateStyle;
import com.getstream.sdk.chat.view.messages.AvatarStyle;
import editor.ffmpeg.api.FfmpegCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010~\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001a\u00020)R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u0011\u0010/\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0011\u00101\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0011\u00103\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u0011\u00105\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0011\u00107\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b8\u0010+R\u0011\u00109\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0011\u0010;\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0011\u0010<\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0011\u0010=\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0011\u0010>\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0013\u0010?\u001a\u0004\u0018\u00010@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010C\u001a\u0004\u0018\u00010D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010G\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000fR\u000e\u0010I\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R\u001a\u0010X\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000f\"\u0004\bZ\u0010\u0011R\u000e\u0010[\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011R\u001a\u0010`\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u000f\"\u0004\bb\u0010\u0011R\u000e\u0010c\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010g\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u000f\"\u0004\bi\u0010\u0011R\u0011\u0010j\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u001dR\u0011\u0010l\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u001dR\u0011\u0010n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u001dR\u0011\u0010p\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u001dR\u0011\u0010r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u001dR\u0011\u0010t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u001dR\u0011\u0010v\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u001dR\u0011\u0010x\u001a\u00020y¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0011\u0010|\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b}\u0010+¨\u0006\u0001"}, mo26107d2 = {"Lcom/getstream/sdk/chat/view/MessageListViewStyle;", "", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attachmentBackgroundColorMine", "", "attachmentBackgroundColorTheirs", "attachmentBorderColorMine", "attachmentBorderColorTheirs", "attachmentDescriptionTextMine", "Lcom/getstream/sdk/chat/style/TextStyle;", "getAttachmentDescriptionTextMine", "()Lcom/getstream/sdk/chat/style/TextStyle;", "setAttachmentDescriptionTextMine", "(Lcom/getstream/sdk/chat/style/TextStyle;)V", "attachmentDescriptionTextTheirs", "getAttachmentDescriptionTextTheirs", "setAttachmentDescriptionTextTheirs", "attachmentFileSizeTextMine", "getAttachmentFileSizeTextMine", "setAttachmentFileSizeTextMine", "attachmentFileSizeTextTheirs", "getAttachmentFileSizeTextTheirs", "setAttachmentFileSizeTextTheirs", "attachmentPreviewMaxLines", "getAttachmentPreviewMaxLines", "()I", "attachmentTitleTextMine", "getAttachmentTitleTextMine", "setAttachmentTitleTextMine", "attachmentTitleTextTheirs", "getAttachmentTitleTextTheirs", "setAttachmentTitleTextTheirs", "avatarStyle", "Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "getAvatarStyle", "()Lcom/getstream/sdk/chat/view/messages/AvatarStyle;", "copyMessageActionEnabled", "", "getCopyMessageActionEnabled", "()Z", "dateSeparatorDateText", "getDateSeparatorDateText", "setDateSeparatorDateText", "dateSeparatorLineColor", "getDateSeparatorLineColor", "dateSeparatorLineDrawable", "getDateSeparatorLineDrawable", "dateSeparatorLineWidth", "getDateSeparatorLineWidth", "deleteMessageActionEnabled", "getDeleteMessageActionEnabled", "editMessageActionEnabled", "getEditMessageActionEnabled", "flagMessageActionEnabled", "getFlagMessageActionEnabled", "isMessageDateShow", "isReactionEnabled", "isThreadEnabled", "isUserNameShow", "messageActionButtonsBackground", "Landroid/graphics/drawable/Drawable;", "getMessageActionButtonsBackground", "()Landroid/graphics/drawable/Drawable;", "messageActionButtonsIconTint", "Landroid/content/res/ColorStateList;", "getMessageActionButtonsIconTint", "()Landroid/content/res/ColorStateList;", "messageActionButtonsTextStyle", "getMessageActionButtonsTextStyle", "messageBackgroundColorMine", "messageBackgroundColorTheirs", "messageBorderColorMine", "messageBorderColorTheirs", "messageBorderWidthMine", "messageBorderWidthTheirs", "messageBottomLeftCornerRadiusMine", "messageBottomLeftCornerRadiusTheirs", "messageBottomRightCornerRadiusMine", "messageBottomRightCornerRadiusTheirs", "messageBubbleDrawableMine", "messageBubbleDrawableTheirs", "messageDateTextMine", "getMessageDateTextMine", "setMessageDateTextMine", "messageDateTextTheirs", "getMessageDateTextTheirs", "setMessageDateTextTheirs", "messageLinkTextColorMine", "messageLinkTextColorTheirs", "messageTextMine", "getMessageTextMine", "setMessageTextMine", "messageTextTheirs", "getMessageTextTheirs", "setMessageTextTheirs", "messageTopLeftCornerRadiusMine", "messageTopLeftCornerRadiusTheirs", "messageTopRightCornerRadiusMine", "messageTopRightCornerRadiusTheirs", "messageUserNameText", "getMessageUserNameText", "setMessageUserNameText", "reactionInputBgColor", "getReactionInputBgColor", "reactionInputEmojiMargin", "getReactionInputEmojiMargin", "reactionInputEmojiSize", "getReactionInputEmojiSize", "reactionViewBgColor", "getReactionViewBgColor", "reactionViewBgDrawable", "getReactionViewBgDrawable", "reactionViewEmojiMargin", "getReactionViewEmojiMargin", "reactionViewEmojiSize", "getReactionViewEmojiSize", "readStateStyle", "Lcom/getstream/sdk/chat/view/ReadStateStyle;", "getReadStateStyle", "()Lcom/getstream/sdk/chat/view/ReadStateStyle;", "startThreadMessageActionEnabled", "getStartThreadMessageActionEnabled", "getAttachmentBackgroundColor", "isMine", "getAttachmentBorderColor", "getMessageBackgroundColor", "getMessageBorderColor", "getMessageBorderWidth", "getMessageBottomLeftCornerRadius", "getMessageBottomRightCornerRadius", "getMessageBubbleDrawable", "getMessageLinkTextColor", "getMessageTopLeftCornerRadius", "getMessageTopRightCornerRadius", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MessageListViewStyle.kt */
public final class MessageListViewStyle {
    private final int attachmentBackgroundColorMine;
    private final int attachmentBackgroundColorTheirs;
    private final int attachmentBorderColorMine;
    private final int attachmentBorderColorTheirs;
    private TextStyle attachmentDescriptionTextMine;
    private TextStyle attachmentDescriptionTextTheirs;
    private TextStyle attachmentFileSizeTextMine;
    private TextStyle attachmentFileSizeTextTheirs;
    private final int attachmentPreviewMaxLines;
    private TextStyle attachmentTitleTextMine;
    private TextStyle attachmentTitleTextTheirs;
    private final AvatarStyle avatarStyle;
    private final boolean copyMessageActionEnabled;
    private TextStyle dateSeparatorDateText;
    private final int dateSeparatorLineColor;
    private final int dateSeparatorLineDrawable;
    private final int dateSeparatorLineWidth;
    private final boolean deleteMessageActionEnabled;
    private final boolean editMessageActionEnabled;
    private final boolean flagMessageActionEnabled;
    private final boolean isMessageDateShow;
    private final boolean isReactionEnabled;
    private final boolean isThreadEnabled;
    private final boolean isUserNameShow;
    private final Drawable messageActionButtonsBackground;
    private final ColorStateList messageActionButtonsIconTint;
    private final TextStyle messageActionButtonsTextStyle;
    private final int messageBackgroundColorMine;
    private final int messageBackgroundColorTheirs;
    private final int messageBorderColorMine;
    private final int messageBorderColorTheirs;
    private final int messageBorderWidthMine;
    private final int messageBorderWidthTheirs;
    private final int messageBottomLeftCornerRadiusMine;
    private final int messageBottomLeftCornerRadiusTheirs;
    private final int messageBottomRightCornerRadiusMine;
    private final int messageBottomRightCornerRadiusTheirs;
    private final int messageBubbleDrawableMine;
    private final int messageBubbleDrawableTheirs;
    private TextStyle messageDateTextMine;
    private TextStyle messageDateTextTheirs;
    private final int messageLinkTextColorMine;
    private final int messageLinkTextColorTheirs;
    private TextStyle messageTextMine;
    private TextStyle messageTextTheirs;
    private final int messageTopLeftCornerRadiusMine;
    private final int messageTopLeftCornerRadiusTheirs;
    private final int messageTopRightCornerRadiusMine;
    private final int messageTopRightCornerRadiusTheirs;
    private TextStyle messageUserNameText;
    private final int reactionInputBgColor;
    private final int reactionInputEmojiMargin;
    private final int reactionInputEmojiSize;
    private final int reactionViewBgColor;
    private final int reactionViewBgDrawable;
    private final int reactionViewEmojiMargin;
    private final int reactionViewEmojiSize;
    private final ReadStateStyle readStateStyle;
    private final boolean startThreadMessageActionEnabled;

    public MessageListViewStyle(Context context, AttributeSet attributeSet) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, Constants.URL_CAMPAIGN);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C1673R.styleable.MessageListView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, FfmpegCommand.AUDIO_STREAM);
        this.messageTextMine = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamMessageTextSizeMine, resources.getDimensionPixelSize(C1673R.dimen.stream_message_text_font_size)).color(C1673R.styleable.MessageListView_streamMessageTextColorMine, -16777216).font(C1673R.styleable.MessageListView_streamMessageTextFontMineAssets, C1673R.styleable.MessageListView_streamMessageTextFontMine).style(C1673R.styleable.MessageListView_streamMessageTextStyleMine, 0).build();
        this.messageTextTheirs = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamMessageTextSizeTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_message_text_font_size)).color(C1673R.styleable.MessageListView_streamMessageTextColorTheirs, -16777216).font(C1673R.styleable.MessageListView_streamMessageTextFontTheirsAssets, C1673R.styleable.MessageListView_streamMessageTextFontTheirs).style(C1673R.styleable.MessageListView_streamMessageTextStyleTheirs, 0).build();
        this.messageBubbleDrawableMine = obtainStyledAttributes.getResourceId(C1673R.styleable.MessageListView_streamMessageBubbleDrawableMine, -1);
        this.messageBubbleDrawableTheirs = obtainStyledAttributes.getResourceId(C1673R.styleable.MessageListView_streamMessageBubbleDrawableTheirs, -1);
        this.messageTopLeftCornerRadiusMine = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageTopLeftCornerRadiusMine, resources.getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1));
        this.messageTopRightCornerRadiusMine = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageTopRightCornerRadiusMine, resources.getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1));
        this.messageBottomRightCornerRadiusMine = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageBottomRightCornerRadiusMine, resources.getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2));
        this.messageBottomLeftCornerRadiusMine = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageBottomLeftCornerRadiusMine, resources.getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1));
        this.messageTopLeftCornerRadiusTheirs = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageTopLeftCornerRadiusTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1));
        this.messageTopRightCornerRadiusTheirs = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageTopRightCornerRadiusTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1));
        this.messageBottomRightCornerRadiusTheirs = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageBottomRightCornerRadiusTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1));
        this.messageBottomLeftCornerRadiusTheirs = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageBottomLeftCornerRadiusTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2));
        int color = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamMessageBackgroundColorMine, ContextCompat.getColor(context2, C1673R.C1675color.stream_message_background_outgoing));
        this.messageBackgroundColorMine = color;
        int color2 = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamMessageBackgroundColorTheirs, ContextCompat.getColor(context2, C1673R.C1675color.stream_message_background_incoming));
        this.messageBackgroundColorTheirs = color2;
        int color3 = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamMessageBorderColorMine, ContextCompat.getColor(context2, C1673R.C1675color.stream_message_stroke));
        this.messageBorderColorMine = color3;
        int color4 = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamMessageBorderColorTheirs, ContextCompat.getColor(context2, C1673R.C1675color.stream_message_stroke));
        this.messageBorderColorTheirs = color4;
        this.messageBorderWidthMine = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageBorderWidthMine, resources.getDimensionPixelSize(C1673R.dimen.stream_message_stroke));
        this.messageBorderWidthTheirs = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamMessageBorderWidthTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_message_stroke));
        this.messageLinkTextColorMine = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamMessageLinkTextColorMine, 0);
        this.messageLinkTextColorTheirs = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamMessageLinkTextColorTheirs, 0);
        this.messageUserNameText = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamMessageUserNameTextSize, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_description_text)).color(C1673R.styleable.MessageListView_streamMessageUserNameTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)).font(C1673R.styleable.MessageListView_streamMessageUserNameTextFontAssets, C1673R.styleable.MessageListView_streamMessageUserNameTextFont).style(C1673R.styleable.MessageListView_streamMessageUserNameTextStyle, 1).build();
        this.messageDateTextMine = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamMessageDateTextSizeMine, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_description_text)).color(C1673R.styleable.MessageListView_streamMessageDateTextColorMine, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)).font(C1673R.styleable.MessageListView_streamMessageDateTextFontAssetsMine, C1673R.styleable.MessageListView_streamMessageDateTextFontMine).style(C1673R.styleable.MessageListView_streamMessageDateTextStyleMine, 0).build();
        this.messageDateTextTheirs = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamMessageDateTextSizeTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_description_text)).color(C1673R.styleable.MessageListView_streamMessageDateTextColorTheirs, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)).font(C1673R.styleable.MessageListView_streamMessageDateTextFontAssetsTheirs, C1673R.styleable.MessageListView_streamMessageDateTextFontTheirs).style(C1673R.styleable.MessageListView_streamMessageDateTextStyleTheirs, 0).build();
        this.attachmentTitleTextMine = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamAttachmentTitleTextSizeMine, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_title_text)).color(C1673R.styleable.MessageListView_streamAttachmentTitleTextColorMine, ContextCompat.getColor(context2, C1673R.C1675color.stream_attach_title_text)).font(C1673R.styleable.MessageListView_streamAttachmentTitleTextFontAssetsMine, C1673R.styleable.MessageListView_streamAttachmentTitleTextFontMine).style(C1673R.styleable.MessageListView_streamAttachmentTitleTextStyleMine, 1).build();
        this.attachmentTitleTextTheirs = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamAttachmentTitleTextSizeTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_title_text)).color(C1673R.styleable.MessageListView_streamAttachmentTitleTextColorTheirs, ContextCompat.getColor(context2, C1673R.C1675color.stream_attach_title_text)).font(C1673R.styleable.MessageListView_streamAttachmentTitleTextFontAssetsTheirs, C1673R.styleable.MessageListView_streamAttachmentTitleTextFontTheirs).style(C1673R.styleable.MessageListView_streamAttachmentTitleTextStyleTheirs, 1).build();
        this.attachmentBackgroundColorMine = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamAttachmentBackgroundColorMine, color);
        this.attachmentBackgroundColorTheirs = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamAttachmentBackgroundColorTheirs, color2);
        this.attachmentBorderColorMine = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamAttachmentBorderColorMine, color3);
        this.attachmentBorderColorTheirs = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamAttachmentBorderColorTheirs, color4);
        this.attachmentDescriptionTextMine = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamAttachmentDescriptionTextSizeMine, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_description_text)).color(C1673R.styleable.MessageListView_streamAttachmentDescriptionTextColorMine, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)).font(C1673R.styleable.MessageListView_streamAttachmentDescriptionTextFontAssetsMine, C1673R.styleable.MessageListView_streamAttachmentDescriptionTextFontMine).style(C1673R.styleable.MessageListView_streamAttachmentDescriptionTextStyleMine, 0).build();
        this.attachmentDescriptionTextTheirs = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamAttachmentDescriptionTextSizeTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_description_text)).color(C1673R.styleable.MessageListView_streamAttachmentDescriptionTextColorTheirs, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)).font(C1673R.styleable.MessageListView_streamAttachmentDescriptionTextFontAssetsTheirs, C1673R.styleable.MessageListView_streamAttachmentDescriptionTextFontTheirs).style(C1673R.styleable.MessageListView_streamAttachmentDescriptionTextStyleTheirs, 0).build();
        this.attachmentFileSizeTextMine = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamAttachmentFileSizeTextSizeMine, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_file_size_text)).color(C1673R.styleable.MessageListView_streamAttachmentFileSizeTextColorMine, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)).font(C1673R.styleable.MessageListView_streamAttachmentFileSizeTextFontAssetsMine, C1673R.styleable.MessageListView_streamAttachmentFileSizeTextFontMine).style(C1673R.styleable.MessageListView_streamAttachmentFileSizeTextStyleMine, 1).build();
        this.attachmentFileSizeTextTheirs = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamAttachmentFileSizeTextSizeTheirs, resources.getDimensionPixelSize(C1673R.dimen.stream_attach_file_size_text)).color(C1673R.styleable.MessageListView_streamAttachmentFileSizeTextColorTheirs, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)).font(C1673R.styleable.MessageListView_streamAttachmentFileSizeTextFontAssetsTheirs, C1673R.styleable.MessageListView_streamAttachmentFileSizeTextFontTheirs).style(C1673R.styleable.MessageListView_streamAttachmentFileSizeTextStyleTheirs, 1).build();
        int i = obtainStyledAttributes.getInt(C1673R.styleable.MessageListView_streamAttachmentPreviewMaxLines, resources.getInteger(C1673R.integer.stream_attachment_preview_max_lines));
        this.attachmentPreviewMaxLines = i;
        if (i > 0) {
            this.isReactionEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamReactionEnabled, true);
            this.reactionViewBgDrawable = obtainStyledAttributes.getResourceId(C1673R.styleable.MessageListView_streamReactionViewBgDrawable, -1);
            this.reactionViewBgColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamReactionViewBgColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_reaction_input_background));
            this.reactionViewEmojiSize = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamReactionViewEmojiSize, resources.getDimensionPixelSize(C1673R.dimen.stream_reaction_view_emoji_size));
            this.reactionViewEmojiMargin = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamReactionViewEmojiMargin, resources.getDimensionPixelSize(C1673R.dimen.stream_reaction_view_emoji_margin));
            this.reactionInputBgColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamReactionInputbgColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_reaction_input_background));
            this.reactionInputEmojiSize = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamReactionInputEmojiSize, resources.getDimensionPixelSize(C1673R.dimen.stream_reaction_input_emoji_size));
            this.reactionInputEmojiMargin = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamReactionInputEmojiMargin, resources.getDimensionPixelSize(C1673R.dimen.stream_reaction_input_emoji_margin));
            this.avatarStyle = AvatarStyle.Builder.avatarInitialText$default(new AvatarStyle.Builder(obtainStyledAttributes, context2).avatarWidth(C1673R.styleable.MessageListView_streamAvatarWidth, C1673R.dimen.stream_message_avatar_width).avatarHeight(C1673R.styleable.MessageListView_streamAvatarHeight, C1673R.dimen.stream_message_avatar_height).avatarBorderWidth(C1673R.styleable.MessageListView_streamAvatarBorderWidth, C1673R.dimen.stream_channel_avatar_border_width).avatarBorderColor(C1673R.styleable.MessageListView_streamAvatarBorderColor, -1).avatarBackgroundColor(C1673R.styleable.MessageListView_streamAvatarBackGroundColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)), C1673R.styleable.MessageListView_streamAvatarTextSize, C1673R.dimen.stream_channel_initials, C1673R.styleable.MessageListView_streamAvatarTextColor, -1, C1673R.styleable.MessageListView_streamAvatarTextFontAssets, C1673R.styleable.MessageListView_streamAvatarTextFont, C1673R.styleable.MessageListView_streamAvatarTextStyle, 0, 128, (Object) null).build();
            this.readStateStyle = ReadStateStyle.Builder.readStateText$default(new ReadStateStyle.Builder(obtainStyledAttributes, context2).isReadStateEnabled(C1673R.styleable.MessageListView_streamShowReadState, true).readStateAvatarWidth(C1673R.styleable.MessageListView_streamReadStateAvatarWidth, resources.getDimensionPixelSize(C1673R.dimen.stream_read_state_avatar_width)).readStateAvatarHeight(C1673R.styleable.MessageListView_streamReadStateAvatarHeight, resources.getDimensionPixelSize(C1673R.dimen.stream_read_state_avatar_height)), C1673R.styleable.MessageListView_streamReadStateTextSize, C1673R.dimen.stream_read_state_text_size, C1673R.styleable.MessageListView_streamReadStateTextColor, -16777216, C1673R.styleable.MessageListView_streamReadStateTextFontAssets, C1673R.styleable.MessageListView_streamReadStateTextFont, C1673R.styleable.MessageListView_streamReadStateTextStyle, 0, 128, (Object) null).isDeliveredIndicatorEnabled(C1673R.styleable.MessageListView_streamShowDeliveredState, true).build();
            this.isThreadEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamThreadEnabled, true);
            this.dateSeparatorDateText = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamDateSeparatorDateTextSize, resources.getDimensionPixelSize(C1673R.dimen.stream_date_separator_text)).color(C1673R.styleable.MessageListView_streamDateSeparatorDateTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark)).font(C1673R.styleable.MessageListView_streamDateSeparatorDateTextFontAssets, C1673R.styleable.MessageListView_streamDateSeparatorDateTextFont).style(C1673R.styleable.MessageListView_streamDateSeparatorDateTextStyle, 1).build();
            this.dateSeparatorLineWidth = obtainStyledAttributes.getDimensionPixelSize(C1673R.styleable.MessageListView_streamDateSeparatorLineWidth, resources.getDimensionPixelSize(C1673R.dimen.stream_date_separator_line_width));
            this.dateSeparatorLineColor = obtainStyledAttributes.getColor(C1673R.styleable.MessageListView_streamDateSeparatorLineColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_gray_dark));
            this.dateSeparatorLineDrawable = obtainStyledAttributes.getResourceId(C1673R.styleable.MessageListView_streamDateSeparatorLineDrawable, -1);
            this.isUserNameShow = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamUserNameShow, true);
            this.isMessageDateShow = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamMessageDateShow, true);
            this.messageActionButtonsBackground = obtainStyledAttributes.getDrawable(C1673R.styleable.MessageListView_streamMessageActionButtonsBackground);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C1673R.styleable.MessageListView_streamMessageActionButtonsIconTint);
            this.messageActionButtonsIconTint = colorStateList == null ? ContextCompat.getColorStateList(context2, C1673R.C1675color.stream_black_54) : colorStateList;
            this.messageActionButtonsTextStyle = new TextStyle.Builder(obtainStyledAttributes).size(C1673R.styleable.MessageListView_streamMessageActionButtonsTextSize, resources.getDimensionPixelSize(C1673R.dimen.stream_message_action_buttons_text_size)).color(C1673R.styleable.MessageListView_streamMessageActionButtonsTextColor, ContextCompat.getColor(context2, C1673R.C1675color.stream_black_54)).font(C1673R.styleable.MessageListView_streamMessageActionButtonsTextFontAssets, C1673R.styleable.MessageListView_streamMessageActionButtonsTextFont).style(C1673R.styleable.MessageListView_streamMessageActionButtonsTextStyle, 0).build();
            this.startThreadMessageActionEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamStartThreadMessageActionEnabled, true);
            this.copyMessageActionEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamCopyMessageActionEnabled, true);
            this.flagMessageActionEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamFlagMessageActionEnabled, true);
            this.deleteMessageActionEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamDeleteMessageActionEnabled, true);
            this.editMessageActionEnabled = obtainStyledAttributes.getBoolean(C1673R.styleable.MessageListView_streamEditMessageActionEnabled, true);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("streamAttachmentPreviewMaxLines value must be greater than 0".toString());
    }

    public final TextStyle getMessageTextMine() {
        return this.messageTextMine;
    }

    public final void setMessageTextMine(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.messageTextMine = textStyle;
    }

    public final TextStyle getMessageTextTheirs() {
        return this.messageTextTheirs;
    }

    public final void setMessageTextTheirs(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.messageTextTheirs = textStyle;
    }

    public final TextStyle getMessageUserNameText() {
        return this.messageUserNameText;
    }

    public final void setMessageUserNameText(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.messageUserNameText = textStyle;
    }

    public final TextStyle getMessageDateTextMine() {
        return this.messageDateTextMine;
    }

    public final void setMessageDateTextMine(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.messageDateTextMine = textStyle;
    }

    public final TextStyle getMessageDateTextTheirs() {
        return this.messageDateTextTheirs;
    }

    public final void setMessageDateTextTheirs(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.messageDateTextTheirs = textStyle;
    }

    public final TextStyle getAttachmentTitleTextMine() {
        return this.attachmentTitleTextMine;
    }

    public final void setAttachmentTitleTextMine(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.attachmentTitleTextMine = textStyle;
    }

    public final TextStyle getAttachmentTitleTextTheirs() {
        return this.attachmentTitleTextTheirs;
    }

    public final void setAttachmentTitleTextTheirs(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.attachmentTitleTextTheirs = textStyle;
    }

    public final TextStyle getAttachmentDescriptionTextMine() {
        return this.attachmentDescriptionTextMine;
    }

    public final void setAttachmentDescriptionTextMine(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.attachmentDescriptionTextMine = textStyle;
    }

    public final TextStyle getAttachmentDescriptionTextTheirs() {
        return this.attachmentDescriptionTextTheirs;
    }

    public final void setAttachmentDescriptionTextTheirs(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.attachmentDescriptionTextTheirs = textStyle;
    }

    public final TextStyle getAttachmentFileSizeTextMine() {
        return this.attachmentFileSizeTextMine;
    }

    public final void setAttachmentFileSizeTextMine(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.attachmentFileSizeTextMine = textStyle;
    }

    public final TextStyle getAttachmentFileSizeTextTheirs() {
        return this.attachmentFileSizeTextTheirs;
    }

    public final void setAttachmentFileSizeTextTheirs(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.attachmentFileSizeTextTheirs = textStyle;
    }

    public final int getAttachmentPreviewMaxLines() {
        return this.attachmentPreviewMaxLines;
    }

    public final boolean isReactionEnabled() {
        return this.isReactionEnabled;
    }

    public final int getReactionViewBgDrawable() {
        return this.reactionViewBgDrawable;
    }

    public final int getReactionViewBgColor() {
        return this.reactionViewBgColor;
    }

    public final int getReactionViewEmojiSize() {
        return this.reactionViewEmojiSize;
    }

    public final int getReactionViewEmojiMargin() {
        return this.reactionViewEmojiMargin;
    }

    public final int getReactionInputBgColor() {
        return this.reactionInputBgColor;
    }

    public final int getReactionInputEmojiSize() {
        return this.reactionInputEmojiSize;
    }

    public final int getReactionInputEmojiMargin() {
        return this.reactionInputEmojiMargin;
    }

    public final boolean isThreadEnabled() {
        return this.isThreadEnabled;
    }

    public final boolean isUserNameShow() {
        return this.isUserNameShow;
    }

    public final boolean isMessageDateShow() {
        return this.isMessageDateShow;
    }

    public final TextStyle getDateSeparatorDateText() {
        return this.dateSeparatorDateText;
    }

    public final void setDateSeparatorDateText(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.dateSeparatorDateText = textStyle;
    }

    public final int getDateSeparatorLineColor() {
        return this.dateSeparatorLineColor;
    }

    public final int getDateSeparatorLineWidth() {
        return this.dateSeparatorLineWidth;
    }

    public final int getDateSeparatorLineDrawable() {
        return this.dateSeparatorLineDrawable;
    }

    public final AvatarStyle getAvatarStyle() {
        return this.avatarStyle;
    }

    public final ReadStateStyle getReadStateStyle() {
        return this.readStateStyle;
    }

    public final Drawable getMessageActionButtonsBackground() {
        return this.messageActionButtonsBackground;
    }

    public final ColorStateList getMessageActionButtonsIconTint() {
        return this.messageActionButtonsIconTint;
    }

    public final TextStyle getMessageActionButtonsTextStyle() {
        return this.messageActionButtonsTextStyle;
    }

    public final boolean getStartThreadMessageActionEnabled() {
        return this.startThreadMessageActionEnabled;
    }

    public final boolean getCopyMessageActionEnabled() {
        return this.copyMessageActionEnabled;
    }

    public final boolean getFlagMessageActionEnabled() {
        return this.flagMessageActionEnabled;
    }

    public final boolean getDeleteMessageActionEnabled() {
        return this.deleteMessageActionEnabled;
    }

    public final boolean getEditMessageActionEnabled() {
        return this.editMessageActionEnabled;
    }

    public final int getMessageBubbleDrawable(boolean z) {
        return z ? this.messageBubbleDrawableMine : this.messageBubbleDrawableTheirs;
    }

    public final int getMessageTopLeftCornerRadius(boolean z) {
        return z ? this.messageTopLeftCornerRadiusMine : this.messageTopLeftCornerRadiusTheirs;
    }

    public final int getMessageTopRightCornerRadius(boolean z) {
        return z ? this.messageTopRightCornerRadiusMine : this.messageTopRightCornerRadiusTheirs;
    }

    public final int getMessageBottomRightCornerRadius(boolean z) {
        return z ? this.messageBottomRightCornerRadiusMine : this.messageBottomRightCornerRadiusTheirs;
    }

    public final int getMessageBottomLeftCornerRadius(boolean z) {
        return z ? this.messageBottomLeftCornerRadiusMine : this.messageBottomLeftCornerRadiusTheirs;
    }

    public final int getMessageBackgroundColor(boolean z) {
        return z ? this.messageBackgroundColorMine : this.messageBackgroundColorTheirs;
    }

    public final int getMessageBorderColor(boolean z) {
        return z ? this.messageBorderColorMine : this.messageBorderColorTheirs;
    }

    public final int getMessageBorderWidth(boolean z) {
        return z ? this.messageBorderWidthMine : this.messageBorderWidthTheirs;
    }

    public final int getMessageLinkTextColor(boolean z) {
        return z ? this.messageLinkTextColorMine : this.messageLinkTextColorTheirs;
    }

    public final int getAttachmentBackgroundColor(boolean z) {
        return z ? this.attachmentBackgroundColorMine : this.attachmentBackgroundColorTheirs;
    }

    public final int getAttachmentBorderColor(boolean z) {
        return z ? this.attachmentBorderColorMine : this.attachmentBorderColorTheirs;
    }
}
