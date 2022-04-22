package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NSmallOptionButtonBinding implements ViewBinding {
    public final AppCompatImageView optionIconView;
    public final TextView optionTitleView;
    private final ConstraintLayout rootView;

    private NSmallOptionButtonBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView) {
        this.rootView = constraintLayout;
        this.optionIconView = appCompatImageView;
        this.optionTitleView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NSmallOptionButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NSmallOptionButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_small_option_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NSmallOptionButtonBinding bind(View view) {
        int i = C4175R.C4179id.option_icon_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i);
        if (appCompatImageView != null) {
            i = C4175R.C4179id.option_title_view;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new NSmallOptionButtonBinding((ConstraintLayout) view, appCompatImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
