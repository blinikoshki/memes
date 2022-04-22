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

public final class SocialUserFollowedNotificationItemBinding implements ViewBinding {
    public final Button authorToggleFollowButton;
    public final UserAvatarView notificationAuthorImageView;
    public final TextView notificationTextView;
    private final LinearLayout rootView;

    private SocialUserFollowedNotificationItemBinding(LinearLayout linearLayout, Button button, UserAvatarView userAvatarView, TextView textView) {
        this.rootView = linearLayout;
        this.authorToggleFollowButton = button;
        this.notificationAuthorImageView = userAvatarView;
        this.notificationTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SocialUserFollowedNotificationItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SocialUserFollowedNotificationItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.social_user_followed_notification_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialUserFollowedNotificationItemBinding bind(View view) {
        int i = C4199R.C4203id.author_toggle_follow_button;
        Button button = (Button) view.findViewById(C4199R.C4203id.author_toggle_follow_button);
        if (button != null) {
            i = C4199R.C4203id.notification_author_image_view;
            UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.notification_author_image_view);
            if (userAvatarView != null) {
                i = C4199R.C4203id.notification_text_view;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.notification_text_view);
                if (textView != null) {
                    return new SocialUserFollowedNotificationItemBinding((LinearLayout) view, button, userAvatarView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
