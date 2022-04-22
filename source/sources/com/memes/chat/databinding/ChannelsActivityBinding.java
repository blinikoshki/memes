package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.memes.chat.C4059R;

public final class ChannelsActivityBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TabLayout channelsTabLayout;
    public final ViewPager2 channelsViewPager;
    public final ImageView createChannelImageView;
    private final LinearLayout rootView;
    public final TextView titleTextView;
    public final FrameLayout topBarLayout;

    private ChannelsActivityBinding(LinearLayout linearLayout, ImageView imageView, TabLayout tabLayout, ViewPager2 viewPager2, ImageView imageView2, TextView textView, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.backImageView = imageView;
        this.channelsTabLayout = tabLayout;
        this.channelsViewPager = viewPager2;
        this.createChannelImageView = imageView2;
        this.titleTextView = textView;
        this.topBarLayout = frameLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChannelsActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChannelsActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.channels_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChannelsActivityBinding bind(View view) {
        int i = C4059R.C4063id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4059R.C4063id.channels_tab_layout;
            TabLayout tabLayout = (TabLayout) view.findViewById(i);
            if (tabLayout != null) {
                i = C4059R.C4063id.channels_view_pager;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(i);
                if (viewPager2 != null) {
                    i = C4059R.C4063id.create_channel_image_view;
                    ImageView imageView2 = (ImageView) view.findViewById(i);
                    if (imageView2 != null) {
                        i = C4059R.C4063id.title_text_view;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = C4059R.C4063id.top_bar_layout;
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                            if (frameLayout != null) {
                                return new ChannelsActivityBinding((LinearLayout) view, imageView, tabLayout, viewPager2, imageView2, textView, frameLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
