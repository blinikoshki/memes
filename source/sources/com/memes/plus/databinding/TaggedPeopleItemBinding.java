package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class TaggedPeopleItemBinding implements ViewBinding {
    public final FrameLayout deleteItemView;
    public final TextView nameTextView;
    public final UserAvatarView profilePicImageView;
    private final ConstraintLayout rootView;
    public final LinearLayout usernameLinearLayout;
    public final TextView usernameTextView;

    private TaggedPeopleItemBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, TextView textView, UserAvatarView userAvatarView, LinearLayout linearLayout, TextView textView2) {
        this.rootView = constraintLayout;
        this.deleteItemView = frameLayout;
        this.nameTextView = textView;
        this.profilePicImageView = userAvatarView;
        this.usernameLinearLayout = linearLayout;
        this.usernameTextView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TaggedPeopleItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TaggedPeopleItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.tagged_people_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TaggedPeopleItemBinding bind(View view) {
        int i = C4199R.C4203id.delete_item_view;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C4199R.C4203id.delete_item_view);
        if (frameLayout != null) {
            i = C4199R.C4203id.name_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.name_text_view);
            if (textView != null) {
                i = C4199R.C4203id.profile_pic_image_view;
                UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.profile_pic_image_view);
                if (userAvatarView != null) {
                    i = C4199R.C4203id.username_linear_layout;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C4199R.C4203id.username_linear_layout);
                    if (linearLayout != null) {
                        i = C4199R.C4203id.username_text_view;
                        TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.username_text_view);
                        if (textView2 != null) {
                            return new TaggedPeopleItemBinding((ConstraintLayout) view, frameLayout, textView, userAvatarView, linearLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
