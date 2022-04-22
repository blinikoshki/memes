package com.getstream.sdk.chat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.getstream.sdk.chat.adapter.MessageListItem;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;
import java.util.List;
import p015io.getstream.chat.android.client.models.Attachment;
import p015io.getstream.chat.android.client.models.Message;
import top.defaults.drawabletoolbox.DrawableBuilder;

public class DefaultBubbleHelper {
    /* access modifiers changed from: private */
    public static int bgColor;
    /* access modifiers changed from: private */
    public static int bottomLeftRadius;
    /* access modifiers changed from: private */
    public static int bottomRightRadius;
    private static int strokeColor;
    private static int strokeWidth;
    /* access modifiers changed from: private */
    public static int topLeftRadius;
    /* access modifiers changed from: private */
    public static int topRightRadius;

    public static MessageListView.BubbleHelper initDefaultBubbleHelper(final MessageListViewStyle messageListViewStyle, final Context context) {
        return new MessageListView.BubbleHelper() {
            public Drawable getDrawableForMessage(Message message, boolean z, List<? extends MessageListItem.Position> list) {
                if (messageListViewStyle.getMessageBubbleDrawable(z) != -1) {
                    return ContextCompat.getDrawable(context, messageListViewStyle.getMessageBubbleDrawable(z));
                }
                DefaultBubbleHelper.configParams(messageListViewStyle, z, false);
                if (DefaultBubbleHelper.isDefaultBubble(messageListViewStyle, z, context)) {
                    DefaultBubbleHelper.applyStyleDefault(list, z, context);
                }
                if (z && message.getType().equals("error")) {
                    int unused = DefaultBubbleHelper.bgColor = context.getResources().getColor(C1673R.C1675color.stream_message_failed);
                }
                return DefaultBubbleHelper.getBubbleDrawable();
            }

            public Drawable getDrawableForAttachment(Message message, boolean z, List<? extends MessageListItem.Position> list, Attachment attachment) {
                if (attachment.getType() == null || attachment.getType().equals("unknown")) {
                    return null;
                }
                if (messageListViewStyle.getMessageBubbleDrawable(z) != -1) {
                    return ContextCompat.getDrawable(context, messageListViewStyle.getMessageBubbleDrawable(z));
                }
                DefaultBubbleHelper.configParams(messageListViewStyle, z, true);
                if (DefaultBubbleHelper.isDefaultBubble(messageListViewStyle, z, context)) {
                    DefaultBubbleHelper.applyStyleDefault(list, z, context);
                }
                if (!TextUtils.isEmpty(attachment.getTitle()) && !attachment.getType().equals("file")) {
                    int unused = DefaultBubbleHelper.bottomLeftRadius = DefaultBubbleHelper.bottomRightRadius = 0;
                }
                if (message.getAttachments().indexOf(attachment) != 0) {
                    if (z) {
                        int unused2 = DefaultBubbleHelper.topRightRadius = 0;
                    } else {
                        int unused3 = DefaultBubbleHelper.topLeftRadius = 0;
                    }
                }
                return DefaultBubbleHelper.getBubbleDrawable();
            }

            public Drawable getDrawableForAttachmentDescription(Message message, boolean z, List<? extends MessageListItem.Position> list) {
                if (messageListViewStyle.getMessageBubbleDrawable(z) != -1) {
                    return ContextCompat.getDrawable(context, messageListViewStyle.getMessageBubbleDrawable(z));
                }
                DefaultBubbleHelper.configParams(messageListViewStyle, z, true);
                if (DefaultBubbleHelper.isDefaultBubble(messageListViewStyle, z, context)) {
                    DefaultBubbleHelper.applyStyleDefault(list, z, context);
                }
                int unused = DefaultBubbleHelper.topLeftRadius = DefaultBubbleHelper.topRightRadius = 0;
                return DefaultBubbleHelper.getBubbleDrawable();
            }
        };
    }

    /* access modifiers changed from: private */
    public static void configParams(MessageListViewStyle messageListViewStyle, boolean z, boolean z2) {
        bgColor = z2 ? messageListViewStyle.getAttachmentBackgroundColor(z) : messageListViewStyle.getMessageBackgroundColor(z);
        strokeColor = z2 ? messageListViewStyle.getAttachmentBorderColor(z) : messageListViewStyle.getMessageBorderColor(z);
        strokeWidth = messageListViewStyle.getMessageBorderWidth(z);
        topLeftRadius = messageListViewStyle.getMessageTopLeftCornerRadius(z);
        topRightRadius = messageListViewStyle.getMessageTopRightCornerRadius(z);
        bottomRightRadius = messageListViewStyle.getMessageBottomRightCornerRadius(z);
        bottomLeftRadius = messageListViewStyle.getMessageBottomLeftCornerRadius(z);
    }

    /* access modifiers changed from: private */
    public static void applyStyleDefault(List<? extends MessageListItem.Position> list, boolean z, Context context) {
        if (z) {
            topLeftRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1);
            bottomLeftRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1);
            if (list.contains(MessageListItem.Position.TOP)) {
                topRightRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1);
                bottomRightRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2);
                return;
            }
            topRightRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2);
            bottomRightRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2);
            return;
        }
        topRightRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1);
        bottomRightRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1);
        if (list.contains(MessageListItem.Position.TOP)) {
            topLeftRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1);
            bottomLeftRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2);
            return;
        }
        topLeftRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2);
        bottomLeftRadius = context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2);
    }

    /* access modifiers changed from: private */
    public static boolean isDefaultBubble(MessageListViewStyle messageListViewStyle, boolean z, Context context) {
        if (z) {
            if (messageListViewStyle.getMessageTopLeftCornerRadius(z) == context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1) && messageListViewStyle.getMessageTopRightCornerRadius(z) == context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1) && messageListViewStyle.getMessageBottomRightCornerRadius(z) == context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2) && messageListViewStyle.getMessageBottomLeftCornerRadius(z) == context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1)) {
                return true;
            }
            return false;
        } else if (messageListViewStyle.getMessageTopLeftCornerRadius(z) == context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1) && messageListViewStyle.getMessageTopRightCornerRadius(z) == context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1) && messageListViewStyle.getMessageBottomRightCornerRadius(z) == context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius1) && messageListViewStyle.getMessageBottomLeftCornerRadius(z) == context.getResources().getDimensionPixelSize(C1673R.dimen.stream_message_corner_radius2)) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static Drawable getBubbleDrawable() {
        return new DrawableBuilder().rectangle().strokeColor(strokeColor).strokeWidth(strokeWidth).solidColor(bgColor).cornerRadii(topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius).build();
    }
}
