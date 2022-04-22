package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.custom.ChatUserAvatarView;

public final class ChannelInfoChannelMemberItemBinding implements ViewBinding {
    public final View actionAnchor;
    public final TextView adminView;
    public final TextView removeTextView;
    private final ConstraintLayout rootView;
    public final ChatUserAvatarView userAvatarView;
    public final TextView usernameTextView;

    private ChannelInfoChannelMemberItemBinding(ConstraintLayout constraintLayout, View view, TextView textView, TextView textView2, ChatUserAvatarView chatUserAvatarView, TextView textView3) {
        this.rootView = constraintLayout;
        this.actionAnchor = view;
        this.adminView = textView;
        this.removeTextView = textView2;
        this.userAvatarView = chatUserAvatarView;
        this.usernameTextView = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ChannelInfoChannelMemberItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelInfoChannelMemberItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channel_info_channel_member_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelInfoChannelMemberItemBinding bind(View view) {
        int i = C4059R.C4063id.action_anchor;
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            i = C4059R.C4063id.admin_view;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4059R.C4063id.remove_text_view;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = C4059R.C4063id.user_avatar_view;
                    ChatUserAvatarView chatUserAvatarView = (ChatUserAvatarView) view.findViewById(i);
                    if (chatUserAvatarView != null) {
                        i = C4059R.C4063id.username_text_view;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            return new ChannelInfoChannelMemberItemBinding((ConstraintLayout) view, findViewById, textView, textView2, chatUserAvatarView, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
