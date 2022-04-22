package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class NotificationSettingsActivityBinding implements ViewBinding {
    public final ImageView backNavigationImage;
    public final SwitchCompat commentNotificationSwitch;
    public final SwitchCompat followingNotificationSwitch;
    public final SwitchCompat likeNotificationSwitch;
    public final SwitchCompat newPostNotificationSwitch;
    private final LinearLayout rootView;
    public final Button saveButton;
    public final SwitchCompat tagPeopleNotificationSwitch;

    private NotificationSettingsActivityBinding(LinearLayout linearLayout, ImageView imageView, SwitchCompat switchCompat, SwitchCompat switchCompat2, SwitchCompat switchCompat3, SwitchCompat switchCompat4, Button button, SwitchCompat switchCompat5) {
        this.rootView = linearLayout;
        this.backNavigationImage = imageView;
        this.commentNotificationSwitch = switchCompat;
        this.followingNotificationSwitch = switchCompat2;
        this.likeNotificationSwitch = switchCompat3;
        this.newPostNotificationSwitch = switchCompat4;
        this.saveButton = button;
        this.tagPeopleNotificationSwitch = switchCompat5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NotificationSettingsActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NotificationSettingsActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.notification_settings_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NotificationSettingsActivityBinding bind(View view) {
        int i = C4199R.C4203id.back_navigation_image;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_navigation_image);
        if (imageView != null) {
            i = C4199R.C4203id.comment_notification_switch;
            SwitchCompat switchCompat = (SwitchCompat) view.findViewById(C4199R.C4203id.comment_notification_switch);
            if (switchCompat != null) {
                i = C4199R.C4203id.following_notification_switch;
                SwitchCompat switchCompat2 = (SwitchCompat) view.findViewById(C4199R.C4203id.following_notification_switch);
                if (switchCompat2 != null) {
                    i = C4199R.C4203id.like_notification_switch;
                    SwitchCompat switchCompat3 = (SwitchCompat) view.findViewById(C4199R.C4203id.like_notification_switch);
                    if (switchCompat3 != null) {
                        i = C4199R.C4203id.new_post_notification_switch;
                        SwitchCompat switchCompat4 = (SwitchCompat) view.findViewById(C4199R.C4203id.new_post_notification_switch);
                        if (switchCompat4 != null) {
                            i = C4199R.C4203id.save_button_;
                            Button button = (Button) view.findViewById(C4199R.C4203id.save_button_);
                            if (button != null) {
                                i = C4199R.C4203id.tag_people_notification_switch;
                                SwitchCompat switchCompat5 = (SwitchCompat) view.findViewById(C4199R.C4203id.tag_people_notification_switch);
                                if (switchCompat5 != null) {
                                    return new NotificationSettingsActivityBinding((LinearLayout) view, imageView, switchCompat, switchCompat2, switchCompat3, switchCompat4, button, switchCompat5);
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
