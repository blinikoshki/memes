package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class SocialPostNotificationItemBinding implements ViewBinding {
    public final UserAvatarView notificationAuthorImageView;
    public final ImageView notificationContentImageView;
    public final TextView notificationTextView;
    private final LinearLayout rootView;

    private SocialPostNotificationItemBinding(LinearLayout linearLayout, UserAvatarView userAvatarView, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.notificationAuthorImageView = userAvatarView;
        this.notificationContentImageView = imageView;
        this.notificationTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SocialPostNotificationItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SocialPostNotificationItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.social_post_notification_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialPostNotificationItemBinding bind(View view) {
        int i = C4199R.C4203id.notification_author_image_view;
        UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.notification_author_image_view);
        if (userAvatarView != null) {
            i = C4199R.C4203id.notification_content_image_view;
            ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.notification_content_image_view);
            if (imageView != null) {
                i = C4199R.C4203id.notification_text_view;
                TextView textView = (TextView) view.findViewById(C4199R.C4203id.notification_text_view);
                if (textView != null) {
                    return new SocialPostNotificationItemBinding((LinearLayout) view, userAvatarView, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
