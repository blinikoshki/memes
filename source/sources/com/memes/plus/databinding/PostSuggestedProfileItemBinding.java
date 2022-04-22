package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class PostSuggestedProfileItemBinding implements ViewBinding {
    public final Button followButton;
    public final UserAvatarView profilePicImageView;
    private final CardView rootView;
    public final TextView userNameTextView;

    private PostSuggestedProfileItemBinding(CardView cardView, Button button, UserAvatarView userAvatarView, TextView textView) {
        this.rootView = cardView;
        this.followButton = button;
        this.profilePicImageView = userAvatarView;
        this.userNameTextView = textView;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static PostSuggestedProfileItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostSuggestedProfileItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_suggested_profile_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostSuggestedProfileItemBinding bind(View view) {
        int i = C4199R.C4203id.follow_button;
        Button button = (Button) view.findViewById(C4199R.C4203id.follow_button);
        if (button != null) {
            i = C4199R.C4203id.profile_pic_image_view;
            UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.profile_pic_image_view);
            if (userAvatarView != null) {
                i = C4199R.C4203id.user_name_text_view;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.user_name_text_view);
                if (textView != null) {
                    return new PostSuggestedProfileItemBinding((CardView) view, button, userAvatarView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
