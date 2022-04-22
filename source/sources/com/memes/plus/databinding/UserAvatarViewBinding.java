package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class UserAvatarViewBinding implements ViewBinding {
    public final AppCompatImageView avatarImageView;
    public final View borderView;
    public final ImageView proUserIndicatorView;
    private final View rootView;

    private UserAvatarViewBinding(View view, AppCompatImageView appCompatImageView, View view2, ImageView imageView) {
        this.rootView = view;
        this.avatarImageView = appCompatImageView;
        this.borderView = view2;
        this.proUserIndicatorView = imageView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static UserAvatarViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4199R.C4205layout.user_avatar_view, viewGroup);
        return bind(viewGroup);
    }

    public static UserAvatarViewBinding bind(View view) {
        int i = C4199R.C4203id.avatar_image_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C4199R.C4203id.avatar_image_view);
        if (appCompatImageView != null) {
            i = C4199R.C4203id.border_view;
            View findViewById = view.findViewById(C4199R.C4203id.border_view);
            if (findViewById != null) {
                i = C4199R.C4203id.pro_user_indicator_view;
                ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.pro_user_indicator_view);
                if (imageView != null) {
                    return new UserAvatarViewBinding(view, appCompatImageView, findViewById, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
