package com.memes.commons.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.commons.C4144R;

public final class MediaContentViewerActivityBinding implements ViewBinding {
    public final ImageView exitImageView;
    private final FrameLayout rootView;
    public final ViewPager2 viewPager;

    private MediaContentViewerActivityBinding(FrameLayout frameLayout, ImageView imageView, ViewPager2 viewPager2) {
        this.rootView = frameLayout;
        this.exitImageView = imageView;
        this.viewPager = viewPager2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MediaContentViewerActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MediaContentViewerActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4144R.C4150layout.media_content_viewer_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MediaContentViewerActivityBinding bind(View view) {
        int i = C4144R.C4148id.exit_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4144R.C4148id.view_pager;
            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(i);
            if (viewPager2 != null) {
                return new MediaContentViewerActivityBinding((FrameLayout) view, imageView, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
