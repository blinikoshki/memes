package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class PostTaggedUsersItemBinding implements ViewBinding {
    public final TextView profileNameTextView;
    public final UserAvatarView profilePicView;
    public final TextView profileUsernameTextView;
    private final FrameLayout rootView;
    public final TextView viewProfileTextView;

    private PostTaggedUsersItemBinding(FrameLayout frameLayout, TextView textView, UserAvatarView userAvatarView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.profileNameTextView = textView;
        this.profilePicView = userAvatarView;
        this.profileUsernameTextView = textView2;
        this.viewProfileTextView = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PostTaggedUsersItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostTaggedUsersItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_tagged_users_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostTaggedUsersItemBinding bind(View view) {
        int i = C4199R.C4203id.profile_name_text_view;
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.profile_name_text_view);
        if (textView != null) {
            i = C4199R.C4203id.profile_pic_view;
            UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.profile_pic_view);
            if (userAvatarView != null) {
                i = C4199R.C4203id.profile_username_text_view;
                TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.profile_username_text_view);
                if (textView2 != null) {
                    i = C4199R.C4203id.view_profile_text_view;
                    TextView textView3 = (TextView) view.findViewById(C4199R.C4203id.view_profile_text_view);
                    if (textView3 != null) {
                        return new PostTaggedUsersItemBinding((FrameLayout) view, textView, userAvatarView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
