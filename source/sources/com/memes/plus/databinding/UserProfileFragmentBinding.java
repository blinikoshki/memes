package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.NestedContentLayout;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;
import com.memes.plus.p040ui.profile.UserNameGradientTextView;

public final class UserProfileFragmentBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final ImageView backgroundImage;
    public final TextView followerCountTextView;
    public final TextView followingCountTextView;
    public final ContentLayout fullPageContentLayout;
    public final Guideline h10;
    public final Guideline h11;

    /* renamed from: h9 */
    public final Guideline f1023h9;
    public final ImageView ivStatus;
    public final TextView likesCountTextView;
    public final TextView likesTextView;
    public final LinearLayout linearProfile;
    public final LinearLayout linearfollow;
    public final NestedScrollView nestedScrollView;
    public final NestedContentLayout postsContentLayout;
    public final RecyclerView postsRecyclerView;
    public final TabLayout postsTabLayout;
    public final LinearLayout profileBioLayout;
    public final TextView profileBioTextView;
    public final LinearLayout profileButtonsContainer;
    public final LinearLayout profileContainer;
    public final AppCompatButton profileFollowButton;
    public final UserAvatarView profileImage;
    public final AppCompatButton profileMessageButton;
    public final ImageView profileOptionsImageView;
    private final ContentLayout rootView;
    public final Button seeAllPostsButton;
    public final TextView textFollowers;
    public final TextView textFollowing;
    public final TextView textPosts;
    public final CollapsingToolbarLayout toolbarLayout;
    public final TextView tvPostcount;
    public final UserNameGradientTextView tvUsername;
    public final Guideline v13;
    public final Guideline v32;

    /* renamed from: v9 */
    public final Guideline f1024v9;
    public final Guideline vertical10;
    public final Guideline vertical30;
    public final Guideline vertical50;
    public final Guideline vertical70;
    public final Guideline vertical90;
    public final View viewLine;
    public final View viewLinePost;
    public final View viewPosts;
    public final View viewfollow;
    public final View viewfollowing;

    private UserProfileFragmentBinding(ContentLayout contentLayout, AppBarLayout appBarLayout, ImageView imageView, TextView textView, TextView textView2, ContentLayout contentLayout2, Guideline guideline, Guideline guideline2, Guideline guideline3, ImageView imageView2, TextView textView3, TextView textView4, LinearLayout linearLayout, LinearLayout linearLayout2, NestedScrollView nestedScrollView2, NestedContentLayout nestedContentLayout, RecyclerView recyclerView, TabLayout tabLayout, LinearLayout linearLayout3, TextView textView5, LinearLayout linearLayout4, LinearLayout linearLayout5, AppCompatButton appCompatButton, UserAvatarView userAvatarView, AppCompatButton appCompatButton2, ImageView imageView3, Button button, TextView textView6, TextView textView7, TextView textView8, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView9, UserNameGradientTextView userNameGradientTextView, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, View view, View view2, View view3, View view4, View view5) {
        this.rootView = contentLayout;
        this.appBar = appBarLayout;
        this.backgroundImage = imageView;
        this.followerCountTextView = textView;
        this.followingCountTextView = textView2;
        this.fullPageContentLayout = contentLayout2;
        this.h10 = guideline;
        this.h11 = guideline2;
        this.f1023h9 = guideline3;
        this.ivStatus = imageView2;
        this.likesCountTextView = textView3;
        this.likesTextView = textView4;
        this.linearProfile = linearLayout;
        this.linearfollow = linearLayout2;
        this.nestedScrollView = nestedScrollView2;
        this.postsContentLayout = nestedContentLayout;
        this.postsRecyclerView = recyclerView;
        this.postsTabLayout = tabLayout;
        this.profileBioLayout = linearLayout3;
        this.profileBioTextView = textView5;
        this.profileButtonsContainer = linearLayout4;
        this.profileContainer = linearLayout5;
        this.profileFollowButton = appCompatButton;
        this.profileImage = userAvatarView;
        this.profileMessageButton = appCompatButton2;
        this.profileOptionsImageView = imageView3;
        this.seeAllPostsButton = button;
        this.textFollowers = textView6;
        this.textFollowing = textView7;
        this.textPosts = textView8;
        this.toolbarLayout = collapsingToolbarLayout;
        this.tvPostcount = textView9;
        this.tvUsername = userNameGradientTextView;
        this.v13 = guideline4;
        this.v32 = guideline5;
        this.f1024v9 = guideline6;
        this.vertical10 = guideline7;
        this.vertical30 = guideline8;
        this.vertical50 = guideline9;
        this.vertical70 = guideline10;
        this.vertical90 = guideline11;
        this.viewLine = view;
        this.viewLinePost = view2;
        this.viewPosts = view3;
        this.viewfollow = view4;
        this.viewfollowing = view5;
    }

    public ContentLayout getRoot() {
        return this.rootView;
    }

    public static UserProfileFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static UserProfileFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.user_profile_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UserProfileFragmentBinding bind(View view) {
        View view2 = view;
        int i = C4199R.C4203id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view2.findViewById(C4199R.C4203id.app_bar);
        if (appBarLayout != null) {
            i = C4199R.C4203id.backgroundImage;
            ImageView imageView = (ImageView) view2.findViewById(C4199R.C4203id.backgroundImage);
            if (imageView != null) {
                i = C4199R.C4203id.follower_count_text_view;
                TextView textView = (TextView) view2.findViewById(C4199R.C4203id.follower_count_text_view);
                if (textView != null) {
                    i = C4199R.C4203id.following_count_text_view;
                    TextView textView2 = (TextView) view2.findViewById(C4199R.C4203id.following_count_text_view);
                    if (textView2 != null) {
                        ContentLayout contentLayout = (ContentLayout) view2;
                        i = C4199R.C4203id.h_10;
                        Guideline guideline = (Guideline) view2.findViewById(C4199R.C4203id.h_10);
                        if (guideline != null) {
                            i = C4199R.C4203id.h_11;
                            Guideline guideline2 = (Guideline) view2.findViewById(C4199R.C4203id.h_11);
                            if (guideline2 != null) {
                                i = C4199R.C4203id.h_9;
                                Guideline guideline3 = (Guideline) view2.findViewById(C4199R.C4203id.h_9);
                                if (guideline3 != null) {
                                    i = C4199R.C4203id.iv_status;
                                    ImageView imageView2 = (ImageView) view2.findViewById(C4199R.C4203id.iv_status);
                                    if (imageView2 != null) {
                                        i = C4199R.C4203id.likes_count_text_view;
                                        TextView textView3 = (TextView) view2.findViewById(C4199R.C4203id.likes_count_text_view);
                                        if (textView3 != null) {
                                            i = C4199R.C4203id.likes_text_view;
                                            TextView textView4 = (TextView) view2.findViewById(C4199R.C4203id.likes_text_view);
                                            if (textView4 != null) {
                                                i = C4199R.C4203id.linear_profile;
                                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.linear_profile);
                                                if (linearLayout != null) {
                                                    i = C4199R.C4203id.linearfollow;
                                                    LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C4199R.C4203id.linearfollow);
                                                    if (linearLayout2 != null) {
                                                        i = C4199R.C4203id.nested_scroll_view;
                                                        NestedScrollView nestedScrollView2 = (NestedScrollView) view2.findViewById(C4199R.C4203id.nested_scroll_view);
                                                        if (nestedScrollView2 != null) {
                                                            i = C4199R.C4203id.posts_content_layout;
                                                            NestedContentLayout nestedContentLayout = (NestedContentLayout) view2.findViewById(C4199R.C4203id.posts_content_layout);
                                                            if (nestedContentLayout != null) {
                                                                i = C4199R.C4203id.posts_recycler_view;
                                                                RecyclerView recyclerView = (RecyclerView) view2.findViewById(C4199R.C4203id.posts_recycler_view);
                                                                if (recyclerView != null) {
                                                                    i = C4199R.C4203id.posts_tab_layout;
                                                                    TabLayout tabLayout = (TabLayout) view2.findViewById(C4199R.C4203id.posts_tab_layout);
                                                                    if (tabLayout != null) {
                                                                        i = C4199R.C4203id.profile_bio_layout;
                                                                        LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(C4199R.C4203id.profile_bio_layout);
                                                                        if (linearLayout3 != null) {
                                                                            i = C4199R.C4203id.profile_bio_text_view;
                                                                            TextView textView5 = (TextView) view2.findViewById(C4199R.C4203id.profile_bio_text_view);
                                                                            if (textView5 != null) {
                                                                                i = C4199R.C4203id.profile_buttons_container;
                                                                                LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(C4199R.C4203id.profile_buttons_container);
                                                                                if (linearLayout4 != null) {
                                                                                    i = C4199R.C4203id.profile_container;
                                                                                    LinearLayout linearLayout5 = (LinearLayout) view2.findViewById(C4199R.C4203id.profile_container);
                                                                                    if (linearLayout5 != null) {
                                                                                        i = C4199R.C4203id.profile_follow_button;
                                                                                        AppCompatButton appCompatButton = (AppCompatButton) view2.findViewById(C4199R.C4203id.profile_follow_button);
                                                                                        if (appCompatButton != null) {
                                                                                            i = C4199R.C4203id.profile_image;
                                                                                            UserAvatarView userAvatarView = (UserAvatarView) view2.findViewById(C4199R.C4203id.profile_image);
                                                                                            if (userAvatarView != null) {
                                                                                                i = C4199R.C4203id.profile_message_button;
                                                                                                AppCompatButton appCompatButton2 = (AppCompatButton) view2.findViewById(C4199R.C4203id.profile_message_button);
                                                                                                if (appCompatButton2 != null) {
                                                                                                    i = C4199R.C4203id.profile_options_image_view;
                                                                                                    ImageView imageView3 = (ImageView) view2.findViewById(C4199R.C4203id.profile_options_image_view);
                                                                                                    if (imageView3 != null) {
                                                                                                        i = C4199R.C4203id.see_all_posts_button;
                                                                                                        Button button = (Button) view2.findViewById(C4199R.C4203id.see_all_posts_button);
                                                                                                        if (button != null) {
                                                                                                            i = C4199R.C4203id.textFollowers;
                                                                                                            TextView textView6 = (TextView) view2.findViewById(C4199R.C4203id.textFollowers);
                                                                                                            if (textView6 != null) {
                                                                                                                i = C4199R.C4203id.textFollowing;
                                                                                                                TextView textView7 = (TextView) view2.findViewById(C4199R.C4203id.textFollowing);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = C4199R.C4203id.textPosts;
                                                                                                                    TextView textView8 = (TextView) view2.findViewById(C4199R.C4203id.textPosts);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = C4199R.C4203id.toolbar_layout;
                                                                                                                        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view2.findViewById(C4199R.C4203id.toolbar_layout);
                                                                                                                        if (collapsingToolbarLayout != null) {
                                                                                                                            i = C4199R.C4203id.tv_postcount;
                                                                                                                            TextView textView9 = (TextView) view2.findViewById(C4199R.C4203id.tv_postcount);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i = C4199R.C4203id.tv_username;
                                                                                                                                UserNameGradientTextView userNameGradientTextView = (UserNameGradientTextView) view2.findViewById(C4199R.C4203id.tv_username);
                                                                                                                                if (userNameGradientTextView != null) {
                                                                                                                                    i = C4199R.C4203id.v_13;
                                                                                                                                    Guideline guideline4 = (Guideline) view2.findViewById(C4199R.C4203id.v_13);
                                                                                                                                    if (guideline4 != null) {
                                                                                                                                        i = C4199R.C4203id.v_32;
                                                                                                                                        Guideline guideline5 = (Guideline) view2.findViewById(C4199R.C4203id.v_32);
                                                                                                                                        if (guideline5 != null) {
                                                                                                                                            i = C4199R.C4203id.v_9;
                                                                                                                                            Guideline guideline6 = (Guideline) view2.findViewById(C4199R.C4203id.v_9);
                                                                                                                                            if (guideline6 != null) {
                                                                                                                                                i = C4199R.C4203id.vertical_10;
                                                                                                                                                Guideline guideline7 = (Guideline) view2.findViewById(C4199R.C4203id.vertical_10);
                                                                                                                                                if (guideline7 != null) {
                                                                                                                                                    i = C4199R.C4203id.vertical_30;
                                                                                                                                                    Guideline guideline8 = (Guideline) view2.findViewById(C4199R.C4203id.vertical_30);
                                                                                                                                                    if (guideline8 != null) {
                                                                                                                                                        i = C4199R.C4203id.vertical_50;
                                                                                                                                                        Guideline guideline9 = (Guideline) view2.findViewById(C4199R.C4203id.vertical_50);
                                                                                                                                                        if (guideline9 != null) {
                                                                                                                                                            i = C4199R.C4203id.vertical_70;
                                                                                                                                                            Guideline guideline10 = (Guideline) view2.findViewById(C4199R.C4203id.vertical_70);
                                                                                                                                                            if (guideline10 != null) {
                                                                                                                                                                i = C4199R.C4203id.vertical_90;
                                                                                                                                                                Guideline guideline11 = (Guideline) view2.findViewById(C4199R.C4203id.vertical_90);
                                                                                                                                                                if (guideline11 != null) {
                                                                                                                                                                    i = C4199R.C4203id.viewLine;
                                                                                                                                                                    View findViewById = view2.findViewById(C4199R.C4203id.viewLine);
                                                                                                                                                                    if (findViewById != null) {
                                                                                                                                                                        i = C4199R.C4203id.viewLinePost;
                                                                                                                                                                        View findViewById2 = view2.findViewById(C4199R.C4203id.viewLinePost);
                                                                                                                                                                        if (findViewById2 != null) {
                                                                                                                                                                            i = C4199R.C4203id.viewPosts;
                                                                                                                                                                            View findViewById3 = view2.findViewById(C4199R.C4203id.viewPosts);
                                                                                                                                                                            if (findViewById3 != null) {
                                                                                                                                                                                i = C4199R.C4203id.viewfollow;
                                                                                                                                                                                View findViewById4 = view2.findViewById(C4199R.C4203id.viewfollow);
                                                                                                                                                                                if (findViewById4 != null) {
                                                                                                                                                                                    i = C4199R.C4203id.viewfollowing;
                                                                                                                                                                                    View findViewById5 = view2.findViewById(C4199R.C4203id.viewfollowing);
                                                                                                                                                                                    if (findViewById5 != null) {
                                                                                                                                                                                        return new UserProfileFragmentBinding(contentLayout, appBarLayout, imageView, textView, textView2, contentLayout, guideline, guideline2, guideline3, imageView2, textView3, textView4, linearLayout, linearLayout2, nestedScrollView2, nestedContentLayout, recyclerView, tabLayout, linearLayout3, textView5, linearLayout4, linearLayout5, appCompatButton, userAvatarView, appCompatButton2, imageView3, button, textView6, textView7, textView8, collapsingToolbarLayout, textView9, userNameGradientTextView, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, findViewById, findViewById2, findViewById3, findViewById4, findViewById5);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
