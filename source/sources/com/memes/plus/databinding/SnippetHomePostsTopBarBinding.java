package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.memes.plus.C4199R;

public final class SnippetHomePostsTopBarBinding implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final ImageView headerMemeImageView;
    public final TabLayout homeTabLayout;
    public final Button inviteTextView;
    private final AppBarLayout rootView;
    public final ImageView socialNotifiationsImageView;

    private SnippetHomePostsTopBarBinding(AppBarLayout appBarLayout2, AppBarLayout appBarLayout3, ImageView imageView, TabLayout tabLayout, Button button, ImageView imageView2) {
        this.rootView = appBarLayout2;
        this.appBarLayout = appBarLayout3;
        this.headerMemeImageView = imageView;
        this.homeTabLayout = tabLayout;
        this.inviteTextView = button;
        this.socialNotifiationsImageView = imageView2;
    }

    public AppBarLayout getRoot() {
        return this.rootView;
    }

    public static SnippetHomePostsTopBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SnippetHomePostsTopBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.snippet_home_posts_top_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SnippetHomePostsTopBarBinding bind(View view) {
        AppBarLayout appBarLayout2 = (AppBarLayout) view;
        int i = C4199R.C4203id.header_meme_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.header_meme_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.home_tab_layout;
            TabLayout tabLayout = (TabLayout) view.findViewById(C4199R.C4203id.home_tab_layout);
            if (tabLayout != null) {
                i = C4199R.C4203id.invite_text_view;
                Button button = (Button) view.findViewById(C4199R.C4203id.invite_text_view);
                if (button != null) {
                    i = C4199R.C4203id.social_notifiations_image_view;
                    ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.social_notifiations_image_view);
                    if (imageView2 != null) {
                        return new SnippetHomePostsTopBarBinding(appBarLayout2, appBarLayout2, imageView, tabLayout, button, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
