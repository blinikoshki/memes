package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class HomeBottomTabItemBinding implements ViewBinding {
    public final TextView badgeTextView;
    public final Guideline guidelineX65;
    public final Guideline guidelineY30;
    public final AppCompatImageView iconImageView;
    private final ConstraintLayout rootView;

    private HomeBottomTabItemBinding(ConstraintLayout constraintLayout, TextView textView, Guideline guideline, Guideline guideline2, AppCompatImageView appCompatImageView) {
        this.rootView = constraintLayout;
        this.badgeTextView = textView;
        this.guidelineX65 = guideline;
        this.guidelineY30 = guideline2;
        this.iconImageView = appCompatImageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HomeBottomTabItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HomeBottomTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.home_bottom_tab_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HomeBottomTabItemBinding bind(View view) {
        int i = C4199R.C4203id.badge_text_view;
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.badge_text_view);
        if (textView != null) {
            i = C4199R.C4203id.guideline_x_65;
            Guideline guideline = (Guideline) view.findViewById(C4199R.C4203id.guideline_x_65);
            if (guideline != null) {
                i = C4199R.C4203id.guideline_y_30;
                Guideline guideline2 = (Guideline) view.findViewById(C4199R.C4203id.guideline_y_30);
                if (guideline2 != null) {
                    i = C4199R.C4203id.icon_image_view;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C4199R.C4203id.icon_image_view);
                    if (appCompatImageView != null) {
                        return new HomeBottomTabItemBinding((ConstraintLayout) view, textView, guideline, guideline2, appCompatImageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
