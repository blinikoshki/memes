package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.tabs.TabLayout;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.contentlayout.NestedContentLayout;
import com.memes.commons.enhancedtext.socialtext.SocialTextView;
import com.memes.commons.p039ui.IconTextHorizontalButton;
import com.memes.plus.C4199R;
import com.memes.plus.p040ui.profile.self_profile.header.SelfProfileHeaderView;

public final class SelfProfileFragmentBinding implements ViewBinding {
    public final ContentLayout fullPageContentLayout;
    public final NestedScrollView nestedScrollView;
    public final NestedContentLayout postsContentLayout;
    public final RecyclerView postsRecyclerView;
    public final TabLayout postsTabLayout;
    public final LinearLayout profileBioLayout;
    public final SocialTextView profileBioTextView;
    public final LinearLayout profileButtonsContainer;
    public final IconTextHorizontalButton profileEditButton;
    public final SelfProfileHeaderView profileHeaderView;
    public final IconTextHorizontalButton profileShareButton;
    public final IconTextHorizontalButton profileSnapchatShareButton;
    public final View profileStatsBottomDivider;
    private final ContentLayout rootView;
    public final Button seeAllPostsButton;

    private SelfProfileFragmentBinding(ContentLayout contentLayout, ContentLayout contentLayout2, NestedScrollView nestedScrollView2, NestedContentLayout nestedContentLayout, RecyclerView recyclerView, TabLayout tabLayout, LinearLayout linearLayout, SocialTextView socialTextView, LinearLayout linearLayout2, IconTextHorizontalButton iconTextHorizontalButton, SelfProfileHeaderView selfProfileHeaderView, IconTextHorizontalButton iconTextHorizontalButton2, IconTextHorizontalButton iconTextHorizontalButton3, View view, Button button) {
        this.rootView = contentLayout;
        this.fullPageContentLayout = contentLayout2;
        this.nestedScrollView = nestedScrollView2;
        this.postsContentLayout = nestedContentLayout;
        this.postsRecyclerView = recyclerView;
        this.postsTabLayout = tabLayout;
        this.profileBioLayout = linearLayout;
        this.profileBioTextView = socialTextView;
        this.profileButtonsContainer = linearLayout2;
        this.profileEditButton = iconTextHorizontalButton;
        this.profileHeaderView = selfProfileHeaderView;
        this.profileShareButton = iconTextHorizontalButton2;
        this.profileSnapchatShareButton = iconTextHorizontalButton3;
        this.profileStatsBottomDivider = view;
        this.seeAllPostsButton = button;
    }

    public ContentLayout getRoot() {
        return this.rootView;
    }

    public static SelfProfileFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SelfProfileFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.self_profile_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SelfProfileFragmentBinding bind(View view) {
        View view2 = view;
        ContentLayout contentLayout = (ContentLayout) view2;
        int i = C4199R.C4203id.nested_scroll_view;
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
                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(C4199R.C4203id.profile_bio_layout);
                        if (linearLayout != null) {
                            i = C4199R.C4203id.profile_bio_text_view;
                            SocialTextView socialTextView = (SocialTextView) view2.findViewById(C4199R.C4203id.profile_bio_text_view);
                            if (socialTextView != null) {
                                i = C4199R.C4203id.profile_buttons_container;
                                LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C4199R.C4203id.profile_buttons_container);
                                if (linearLayout2 != null) {
                                    i = C4199R.C4203id.profile_edit_button;
                                    IconTextHorizontalButton iconTextHorizontalButton = (IconTextHorizontalButton) view2.findViewById(C4199R.C4203id.profile_edit_button);
                                    if (iconTextHorizontalButton != null) {
                                        i = C4199R.C4203id.profile_header_view;
                                        SelfProfileHeaderView selfProfileHeaderView = (SelfProfileHeaderView) view2.findViewById(C4199R.C4203id.profile_header_view);
                                        if (selfProfileHeaderView != null) {
                                            i = C4199R.C4203id.profile_share_button;
                                            IconTextHorizontalButton iconTextHorizontalButton2 = (IconTextHorizontalButton) view2.findViewById(C4199R.C4203id.profile_share_button);
                                            if (iconTextHorizontalButton2 != null) {
                                                i = C4199R.C4203id.profile_snapchat_share_button;
                                                IconTextHorizontalButton iconTextHorizontalButton3 = (IconTextHorizontalButton) view2.findViewById(C4199R.C4203id.profile_snapchat_share_button);
                                                if (iconTextHorizontalButton3 != null) {
                                                    i = C4199R.C4203id.profile_stats_bottom_divider;
                                                    View findViewById = view2.findViewById(C4199R.C4203id.profile_stats_bottom_divider);
                                                    if (findViewById != null) {
                                                        i = C4199R.C4203id.see_all_posts_button;
                                                        Button button = (Button) view2.findViewById(C4199R.C4203id.see_all_posts_button);
                                                        if (button != null) {
                                                            return new SelfProfileFragmentBinding(contentLayout, contentLayout, nestedScrollView2, nestedContentLayout, recyclerView, tabLayout, linearLayout, socialTextView, linearLayout2, iconTextHorizontalButton, selfProfileHeaderView, iconTextHorizontalButton2, iconTextHorizontalButton3, findViewById, button);
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
