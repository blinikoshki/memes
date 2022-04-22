package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.messageinput.MessageInputView;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;
import com.memes.commons.contentlayout.ContentLayout;

public final class ChannelMessagesActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final ContentLayout channelAccessContentLayout;
    public final ImageView channelInfoView;
    public final MessageInputView messageInputView;
    public final MessageListView messageListView;
    private final LinearLayout rootView;
    public final ChatUserAvatarView titleAvatarView;
    public final LinearLayout titleContainer;
    public final TextView titleTextView;
    public final LinearLayout topBarLayout;

    private ChannelMessagesActivityBinding(LinearLayout linearLayout, ImageView imageView, ContentLayout contentLayout, ImageView imageView2, MessageInputView messageInputView2, MessageListView messageListView2, ChatUserAvatarView chatUserAvatarView, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.backImageView = imageView;
        this.channelAccessContentLayout = contentLayout;
        this.channelInfoView = imageView2;
        this.messageInputView = messageInputView2;
        this.messageListView = messageListView2;
        this.titleAvatarView = chatUserAvatarView;
        this.titleContainer = linearLayout2;
        this.titleTextView = textView;
        this.topBarLayout = linearLayout3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChannelMessagesActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelMessagesActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channel_messages_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelMessagesActivityBinding bind(View view) {
        int i = C4059R.C4063id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4059R.C4063id.channel_access_content_layout;
            ContentLayout contentLayout = (ContentLayout) view.findViewById(i);
            if (contentLayout != null) {
                i = C4059R.C4063id.channel_info_view;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = C4059R.C4063id.message_input_view;
                    MessageInputView messageInputView2 = (MessageInputView) view.findViewById(i);
                    if (messageInputView2 != null) {
                        i = C4059R.C4063id.message_list_view;
                        MessageListView messageListView2 = (MessageListView) view.findViewById(i);
                        if (messageListView2 != null) {
                            i = C4059R.C4063id.title_avatar_view;
                            ChatUserAvatarView chatUserAvatarView = (ChatUserAvatarView) view.findViewById(i);
                            if (chatUserAvatarView != null) {
                                i = C4059R.C4063id.title_container;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                if (linearLayout != null) {
                                    i = C4059R.C4063id.title_text_view;
                                    TextView textView = (TextView) view.findViewById(i);
                                    if (textView != null) {
                                        i = C4059R.C4063id.top_bar_layout;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                        if (linearLayout2 != null) {
                                            return new ChannelMessagesActivityBinding((LinearLayout) view, imageView, contentLayout, imageView2, messageInputView2, messageListView2, chatUserAvatarView, linearLayout, textView, linearLayout2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
