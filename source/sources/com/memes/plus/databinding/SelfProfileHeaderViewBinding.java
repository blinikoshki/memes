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
import com.memes.plus.p040ui.profile.UserNameGradientTextView;
import java.util.Objects;

public final class SelfProfileHeaderViewBinding implements ViewBinding {
    public final ImageView coverImageView;
    public final TextView followerCountTextView;
    public final TextView followingCountTextView;
    public final TextView likeCountTextView;
    public final TextView postCountTextView;
    public final UserAvatarView profileImageView;
    public final ImageView profileOptionsImageView;
    public final View profileRoundedBackgroundView;
    public final LinearLayout profileStatsContainer;
    private final View rootView;
    public final UserNameGradientTextView usernameTextView;

    private SelfProfileHeaderViewBinding(View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, UserAvatarView userAvatarView, ImageView imageView2, View view2, LinearLayout linearLayout, UserNameGradientTextView userNameGradientTextView) {
        this.rootView = view;
        this.coverImageView = imageView;
        this.followerCountTextView = textView;
        this.followingCountTextView = textView2;
        this.likeCountTextView = textView3;
        this.postCountTextView = textView4;
        this.profileImageView = userAvatarView;
        this.profileOptionsImageView = imageView2;
        this.profileRoundedBackgroundView = view2;
        this.profileStatsContainer = linearLayout;
        this.usernameTextView = userNameGradientTextView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static SelfProfileHeaderViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4199R.C4205layout.self_profile_header_view, viewGroup);
        return bind(viewGroup);
    }

    public static SelfProfileHeaderViewBinding bind(View view) {
        int i = C4199R.C4203id.cover_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.cover_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.follower_count_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.follower_count_text_view);
            if (textView != null) {
                i = C4199R.C4203id.following_count_text_view;
                TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.following_count_text_view);
                if (textView2 != null) {
                    i = C4199R.C4203id.like_count_text_view;
                    TextView textView3 = (TextView) view.findViewById(C4199R.C4203id.like_count_text_view);
                    if (textView3 != null) {
                        i = C4199R.C4203id.post_count_text_view;
                        TextView textView4 = (TextView) view.findViewById(C4199R.C4203id.post_count_text_view);
                        if (textView4 != null) {
                            i = C4199R.C4203id.profile_image_view;
                            UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.profile_image_view);
                            if (userAvatarView != null) {
                                i = C4199R.C4203id.profile_options_image_view;
                                ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.profile_options_image_view);
                                if (imageView2 != null) {
                                    i = C4199R.C4203id.profile_rounded_background_view;
                                    View findViewById = view.findViewById(C4199R.C4203id.profile_rounded_background_view);
                                    if (findViewById != null) {
                                        i = C4199R.C4203id.profile_stats_container;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C4199R.C4203id.profile_stats_container);
                                        if (linearLayout != null) {
                                            i = C4199R.C4203id.username_text_view;
                                            UserNameGradientTextView userNameGradientTextView = (UserNameGradientTextView) view.findViewById(C4199R.C4203id.username_text_view);
                                            if (userNameGradientTextView != null) {
                                                return new SelfProfileHeaderViewBinding(view, imageView, textView, textView2, textView3, textView4, userAvatarView, imageView2, findViewById, linearLayout, userNameGradientTextView);
                                            }
                                        }
                                    }
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
