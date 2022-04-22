package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemTypeIndicatorBinding implements ViewBinding {
    public final ImageView ivTypingIndicator;
    public final LinearLayout llTypingIndicator;
    private final ConstraintLayout rootView;

    private StreamItemTypeIndicatorBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.ivTypingIndicator = imageView;
        this.llTypingIndicator = linearLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemTypeIndicatorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemTypeIndicatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_type_indicator, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemTypeIndicatorBinding bind(View view) {
        int i = C1673R.C1677id.iv_typing_indicator;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1673R.C1677id.ll_typing_indicator;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
            if (linearLayout != null) {
                return new StreamItemTypeIndicatorBinding((ConstraintLayout) view, imageView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
