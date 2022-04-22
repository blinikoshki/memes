package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.plus.C4199R;
import com.memes.plus.p040ui.home.bottomtabs.HomeBottomTabsView;

public final class HomeActivityBinding implements ViewBinding {
    public final HomeBottomTabsView bottomTabsView;
    public final CoordinatorLayout coordinatorLayout;
    public final FrameLayout fragmentContainer;
    public final Guideline guidelineHorizontal90;
    public final SnippetHomePostsTopBarBinding includedHomePostsBar;
    public final FrameLayout parentFrameLayout;
    public final ViewPager2 postsViewPager;
    private final CoordinatorLayout rootView;

    private HomeActivityBinding(CoordinatorLayout coordinatorLayout2, HomeBottomTabsView homeBottomTabsView, CoordinatorLayout coordinatorLayout3, FrameLayout frameLayout, Guideline guideline, SnippetHomePostsTopBarBinding snippetHomePostsTopBarBinding, FrameLayout frameLayout2, ViewPager2 viewPager2) {
        this.rootView = coordinatorLayout2;
        this.bottomTabsView = homeBottomTabsView;
        this.coordinatorLayout = coordinatorLayout3;
        this.fragmentContainer = frameLayout;
        this.guidelineHorizontal90 = guideline;
        this.includedHomePostsBar = snippetHomePostsTopBarBinding;
        this.parentFrameLayout = frameLayout2;
        this.postsViewPager = viewPager2;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static HomeActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HomeActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.home_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HomeActivityBinding bind(View view) {
        int i = C4199R.C4203id.bottom_tabs_view;
        HomeBottomTabsView homeBottomTabsView = (HomeBottomTabsView) view.findViewById(C4199R.C4203id.bottom_tabs_view);
        if (homeBottomTabsView != null) {
            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) view;
            i = C4199R.C4203id.fragment_container;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(C4199R.C4203id.fragment_container);
            if (frameLayout != null) {
                i = C4199R.C4203id.guideline_horizontal_90;
                Guideline guideline = (Guideline) view.findViewById(C4199R.C4203id.guideline_horizontal_90);
                if (guideline != null) {
                    i = C4199R.C4203id.included_home_posts_bar;
                    View findViewById = view.findViewById(C4199R.C4203id.included_home_posts_bar);
                    if (findViewById != null) {
                        SnippetHomePostsTopBarBinding bind = SnippetHomePostsTopBarBinding.bind(findViewById);
                        i = C4199R.C4203id.parent_frame_layout;
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(C4199R.C4203id.parent_frame_layout);
                        if (frameLayout2 != null) {
                            i = C4199R.C4203id.posts_view_pager;
                            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(C4199R.C4203id.posts_view_pager);
                            if (viewPager2 != null) {
                                return new HomeActivityBinding(coordinatorLayout2, homeBottomTabsView, coordinatorLayout2, frameLayout, guideline, bind, frameLayout2, viewPager2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
