package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class SocialBasicNotificationItemBinding implements ViewBinding {
    public final UserAvatarView notificationAuthorImageView;
    public final TextView notificationTextView;
    private final LinearLayout rootView;

    private SocialBasicNotificationItemBinding(LinearLayout linearLayout, UserAvatarView userAvatarView, TextView textView) {
        this.rootView = linearLayout;
        this.notificationAuthorImageView = userAvatarView;
        this.notificationTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SocialBasicNotificationItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SocialBasicNotificationItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.social_basic_notification_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SocialBasicNotificationItemBinding bind(View view) {
        int i = C4199R.C4203id.notification_author_image_view;
        UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.notification_author_image_view);
        if (userAvatarView != null) {
            i = C4199R.C4203id.notification_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.notification_text_view);
            if (textView != null) {
                return new SocialBasicNotificationItemBinding((LinearLayout) view, userAvatarView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
