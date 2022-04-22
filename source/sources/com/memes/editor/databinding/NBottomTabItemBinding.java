package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NBottomTabItemBinding implements ViewBinding {
    public final AppCompatImageView iconImageView;
    private final LinearLayout rootView;
    public final TextView textView;

    private NBottomTabItemBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView2) {
        this.rootView = linearLayout;
        this.iconImageView = appCompatImageView;
        this.textView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NBottomTabItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NBottomTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_bottom_tab_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NBottomTabItemBinding bind(View view) {
        int i = C4175R.C4179id.icon_image_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i);
        if (appCompatImageView != null) {
            i = C4175R.C4179id.text_view;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new NBottomTabItemBinding((LinearLayout) view, appCompatImageView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
