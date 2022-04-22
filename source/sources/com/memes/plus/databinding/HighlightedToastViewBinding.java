package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class HighlightedToastViewBinding implements ViewBinding {
    public final FrameLayout content;
    public final ImageView iconView;
    private final FrameLayout rootView;
    public final TextView textView;

    private HighlightedToastViewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, TextView textView2) {
        this.rootView = frameLayout;
        this.content = frameLayout2;
        this.iconView = imageView;
        this.textView = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HighlightedToastViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HighlightedToastViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.highlighted_toast_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HighlightedToastViewBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = C4199R.C4203id.icon_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.icon_view);
        if (imageView != null) {
            i = C4199R.C4203id.text_view;
            TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.text_view);
            if (textView2 != null) {
                return new HighlightedToastViewBinding(frameLayout, frameLayout, imageView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
