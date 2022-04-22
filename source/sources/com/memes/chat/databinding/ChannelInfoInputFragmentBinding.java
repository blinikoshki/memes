package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;

public final class ChannelInfoInputFragmentBinding implements ViewBinding {
    public final ImageView changeChannelAvatarAnchorView;
    public final ChatUserAvatarView channelAvatarView;
    public final TextInputEditText channelNameEditText;
    private final LinearLayout rootView;

    private ChannelInfoInputFragmentBinding(LinearLayout linearLayout, ImageView imageView, ChatUserAvatarView chatUserAvatarView, TextInputEditText textInputEditText) {
        this.rootView = linearLayout;
        this.changeChannelAvatarAnchorView = imageView;
        this.channelAvatarView = chatUserAvatarView;
        this.channelNameEditText = textInputEditText;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChannelInfoInputFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelInfoInputFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channel_info_input_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelInfoInputFragmentBinding bind(View view) {
        int i = C4059R.C4063id.change_channel_avatar_anchor_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4059R.C4063id.channel_avatar_view;
            ChatUserAvatarView chatUserAvatarView = (ChatUserAvatarView) view.findViewById(i);
            if (chatUserAvatarView != null) {
                i = C4059R.C4063id.channel_name_edit_text;
                TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(i);
                if (textInputEditText != null) {
                    return new ChannelInfoInputFragmentBinding((LinearLayout) view, imageView, chatUserAvatarView, textInputEditText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
