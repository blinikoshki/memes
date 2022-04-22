package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.view.AvatarView;

public final class StreamItemMentionBinding implements ViewBinding {
    public final AvatarView avatar;
    private final ConstraintLayout rootView;
    public final TextView tvUsername;

    private StreamItemMentionBinding(ConstraintLayout constraintLayout, AvatarView avatarView, TextView textView) {
        this.rootView = constraintLayout;
        this.avatar = avatarView;
        this.tvUsername = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemMentionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemMentionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_mention, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemMentionBinding bind(View view) {
        int i = C1673R.C1677id.avatar;
        AvatarView avatarView = (AvatarView) view.findViewById(i);
        if (avatarView != null) {
            i = C1673R.C1677id.tv_username;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new StreamItemMentionBinding((ConstraintLayout) view, avatarView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
