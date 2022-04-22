package com.memes.commons.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.C4144R;
import java.util.Objects;

public final class IconTextHorizontalButtonBinding implements ViewBinding {
    public final AppCompatImageView iconView;
    private final View rootView;
    public final AppCompatTextView textView;

    private IconTextHorizontalButtonBinding(View view, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.rootView = view;
        this.iconView = appCompatImageView;
        this.textView = appCompatTextView;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static IconTextHorizontalButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4144R.C4150layout.icon_text_horizontal_button, viewGroup);
        return bind(viewGroup);
    }

    public static IconTextHorizontalButtonBinding bind(View view) {
        int i = C4144R.C4148id.icon_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i);
        if (appCompatImageView != null) {
            i = C4144R.C4148id.text_view;
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(i);
            if (appCompatTextView != null) {
                return new IconTextHorizontalButtonBinding(view, appCompatImageView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
