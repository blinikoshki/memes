package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;

public final class AddChannelMembersActivityBinding implements ViewBinding {
    public final TextView actionImageView;
    public final ImageView backImageView;
    public final FragmentContainerView fragmentContainerView;
    private final LinearLayout rootView;
    public final TextView titleTextView;
    public final FrameLayout topBarLayout;

    private AddChannelMembersActivityBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, FragmentContainerView fragmentContainerView2, TextView textView2, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.actionImageView = textView;
        this.backImageView = imageView;
        this.fragmentContainerView = fragmentContainerView2;
        this.titleTextView = textView2;
        this.topBarLayout = frameLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AddChannelMembersActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AddChannelMembersActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.add_channel_members_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AddChannelMembersActivityBinding bind(View view) {
        int i = C4059R.C4063id.action_image_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4059R.C4063id.back_image_view;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4059R.C4063id.fragment_container_view;
                FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(i);
                if (fragmentContainerView2 != null) {
                    i = C4059R.C4063id.title_text_view;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C4059R.C4063id.top_bar_layout;
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                        if (frameLayout != null) {
                            return new AddChannelMembersActivityBinding((LinearLayout) view, textView, imageView, fragmentContainerView2, textView2, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
