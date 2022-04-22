package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.view.AvatarView;

public final class StreamViewChannelHeaderBinding implements ViewBinding {
    public final AvatarView avatarGroup;
    public final Button btnBack;
    public final Button btnOption;
    public final ConstraintLayout header;
    public final ImageView ivActiveBadge;
    public final ImageView ivSeparator;
    private final ConstraintLayout rootView;
    public final TextView tvActive;
    public final TextView tvChannelName;

    private StreamViewChannelHeaderBinding(ConstraintLayout constraintLayout, AvatarView avatarView, Button button, Button button2, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.avatarGroup = avatarView;
        this.btnBack = button;
        this.btnOption = button2;
        this.header = constraintLayout2;
        this.ivActiveBadge = imageView;
        this.ivSeparator = imageView2;
        this.tvActive = textView;
        this.tvChannelName = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamViewChannelHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamViewChannelHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_view_channel_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamViewChannelHeaderBinding bind(View view) {
        int i = C1673R.C1677id.avatar_group;
        AvatarView avatarView = (AvatarView) view.findViewById(i);
        if (avatarView != null) {
            i = C1673R.C1677id.btn_back;
            Button button = (Button) view.findViewById(i);
            if (button != null) {
                i = C1673R.C1677id.btn_option;
                Button button2 = (Button) view.findViewById(i);
                if (button2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = C1673R.C1677id.iv_active_badge;
                    ImageView imageView = (ImageView) view.findViewById(i);
                    if (imageView != null) {
                        i = C1673R.C1677id.iv_separator;
                        ImageView imageView2 = (ImageView) view.findViewById(i);
                        if (imageView2 != null) {
                            i = C1673R.C1677id.tv_active;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C1673R.C1677id.tv_channel_name;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    return new StreamViewChannelHeaderBinding(constraintLayout, avatarView, button, button2, constraintLayout, imageView, imageView2, textView, textView2);
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
