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
import com.memes.chat.C4059R;

public final class CreateChannelActivityBinding implements ViewBinding {
    public final TextView actionTextView;
    public final ImageView backImageView;
    private final LinearLayout rootView;
    public final TextView titleTextView;
    public final FrameLayout topBarLayout;
    public final ViewPager2 viewPager;

    private CreateChannelActivityBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, FrameLayout frameLayout, ViewPager2 viewPager2) {
        this.rootView = linearLayout;
        this.actionTextView = textView;
        this.backImageView = imageView;
        this.titleTextView = textView2;
        this.topBarLayout = frameLayout;
        this.viewPager = viewPager2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CreateChannelActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CreateChannelActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.create_channel_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CreateChannelActivityBinding bind(View view) {
        int i = C4059R.C4063id.action_text_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4059R.C4063id.back_image_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4059R.C4063id.title_text_view;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = C4059R.C4063id.top_bar_layout;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                    if (frameLayout != null) {
                        i = C4059R.C4063id.view_pager;
                        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(i);
                        if (viewPager2 != null) {
                            return new CreateChannelActivityBinding((LinearLayout) view, textView, imageView, textView2, frameLayout, viewPager2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
