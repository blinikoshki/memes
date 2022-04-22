package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;

public final class ChannelItemBinding implements ViewBinding {
    public final ChatUserAvatarView avatarView;
    public final Guideline guidelineNameMessageSeparator;
    public final TextView lastMessageTextView;
    public final TextView nameTextView;
    public final AppCompatImageView optionsImageView;
    private final ConstraintLayout rootView;

    private ChannelItemBinding(ConstraintLayout constraintLayout, ChatUserAvatarView chatUserAvatarView, Guideline guideline, TextView textView, TextView textView2, AppCompatImageView appCompatImageView) {
        this.rootView = constraintLayout;
        this.avatarView = chatUserAvatarView;
        this.guidelineNameMessageSeparator = guideline;
        this.lastMessageTextView = textView;
        this.nameTextView = textView2;
        this.optionsImageView = appCompatImageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ChannelItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channel_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelItemBinding bind(View view) {
        int i = C4059R.C4063id.avatar_view;
        ChatUserAvatarView chatUserAvatarView = (ChatUserAvatarView) view.findViewById(i);
        if (chatUserAvatarView != null) {
            i = C4059R.C4063id.guideline_name_message_separator;
            Guideline guideline = (Guideline) view.findViewById(i);
            if (guideline != null) {
                i = C4059R.C4063id.last_message_text_view;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4059R.C4063id.name_text_view;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C4059R.C4063id.options_image_view;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i);
                        if (appCompatImageView != null) {
                            return new ChannelItemBinding((ConstraintLayout) view, chatUserAvatarView, guideline, textView, textView2, appCompatImageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
