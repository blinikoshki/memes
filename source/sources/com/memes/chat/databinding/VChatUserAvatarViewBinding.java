package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;
import java.util.Objects;

public final class VChatUserAvatarViewBinding implements ViewBinding {
    public final AppCompatImageView avatarImageView;
    public final ImageView presenceIndicatorView;
    private final View rootView;

    private VChatUserAvatarViewBinding(View view, AppCompatImageView appCompatImageView, ImageView imageView) {
        this.rootView = view;
        this.avatarImageView = appCompatImageView;
        this.presenceIndicatorView = imageView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static VChatUserAvatarViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4059R.C4065layout.v_chat_user_avatar_view, viewGroup);
        return bind(viewGroup);
    }

    public static VChatUserAvatarViewBinding bind(View view) {
        int i = C4059R.C4063id.avatar_image_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i);
        if (appCompatImageView != null) {
            i = C4059R.C4063id.presence_indicator_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                return new VChatUserAvatarViewBinding(view, appCompatImageView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
