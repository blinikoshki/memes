package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class UserListingItemBinding implements ViewBinding {
    public final Button followSwitchButton;
    public final TextView fullNameTextview;
    public final UserAvatarView profilePicImageView;
    public final Button removeButton;
    private final LinearLayout rootView;
    public final TextView userNameTextview;

    private UserListingItemBinding(LinearLayout linearLayout, Button button, TextView textView, UserAvatarView userAvatarView, Button button2, TextView textView2) {
        this.rootView = linearLayout;
        this.followSwitchButton = button;
        this.fullNameTextview = textView;
        this.profilePicImageView = userAvatarView;
        this.removeButton = button2;
        this.userNameTextview = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserListingItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static UserListingItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.user_listing_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UserListingItemBinding bind(View view) {
        int i = C4199R.C4203id.follow_switch_button;
        Button button = (Button) view.findViewById(C4199R.C4203id.follow_switch_button);
        if (button != null) {
            i = C4199R.C4203id.full_name_textview;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.full_name_textview);
            if (textView != null) {
                i = C4199R.C4203id.profile_pic_image_view;
                UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.profile_pic_image_view);
                if (userAvatarView != null) {
                    i = C4199R.C4203id.remove_button;
                    Button button2 = (Button) view.findViewById(C4199R.C4203id.remove_button);
                    if (button2 != null) {
                        i = C4199R.C4203id.user_name_textview;
                        TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.user_name_textview);
                        if (textView2 != null) {
                            return new UserListingItemBinding((LinearLayout) view, button, textView, userAvatarView, button2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
