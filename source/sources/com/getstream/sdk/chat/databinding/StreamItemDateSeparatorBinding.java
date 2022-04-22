package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemDateSeparatorBinding implements ViewBinding {
    public final ConstraintLayout clHeader;
    public final ImageView ivLineLeft;
    public final ImageView ivLineRight;
    private final ConstraintLayout rootView;
    public final TextView tvDate;

    private StreamItemDateSeparatorBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = constraintLayout;
        this.clHeader = constraintLayout2;
        this.ivLineLeft = imageView;
        this.ivLineRight = imageView2;
        this.tvDate = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemDateSeparatorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemDateSeparatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_date_separator, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemDateSeparatorBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C1673R.C1677id.iv_line_left;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1673R.C1677id.iv_line_right;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1673R.C1677id.tv_date;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    return new StreamItemDateSeparatorBinding(constraintLayout, constraintLayout, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
