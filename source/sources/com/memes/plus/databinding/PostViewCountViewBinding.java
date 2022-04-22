package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class PostViewCountViewBinding implements ViewBinding {
    public final ImageView iconView;
    private final View rootView;
    public final TextView textView;

    private PostViewCountViewBinding(View view, ImageView imageView, TextView textView2) {
        this.rootView = view;
        this.iconView = imageView;
        this.textView = textView2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static PostViewCountViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4199R.C4205layout.post_view_count_view, viewGroup);
        return bind(viewGroup);
    }

    public static PostViewCountViewBinding bind(View view) {
        int i = C4199R.C4203id.icon_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.icon_view);
        if (imageView != null) {
            i = C4199R.C4203id.text_view;
            TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.text_view);
            if (textView2 != null) {
                return new PostViewCountViewBinding(view, imageView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
