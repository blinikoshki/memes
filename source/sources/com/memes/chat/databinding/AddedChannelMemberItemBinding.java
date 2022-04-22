package com.memes.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.chat.C4059R;

public final class AddedChannelMemberItemBinding implements ViewBinding {
    public final ImageView removeImageView;
    private final LinearLayout rootView;
    public final TextView textView;

    private AddedChannelMemberItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView2) {
        this.rootView = linearLayout;
        this.removeImageView = imageView;
        this.textView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AddedChannelMemberItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AddedChannelMemberItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4059R.C4065layout.added_channel_member_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AddedChannelMemberItemBinding bind(View view) {
        int i = C4059R.C4063id.remove_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4059R.C4063id.text_view;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new AddedChannelMemberItemBinding((LinearLayout) view, imageView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
