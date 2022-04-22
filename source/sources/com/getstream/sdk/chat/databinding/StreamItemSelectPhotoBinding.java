package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemSelectPhotoBinding implements ViewBinding {
    public final ImageView ivLargeFileMark;
    public final ImageView ivMedia;
    public final ImageView ivSelectMark;
    private final ConstraintLayout rootView;
    public final TextView tvLength;

    private StreamItemSelectPhotoBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.rootView = constraintLayout;
        this.ivLargeFileMark = imageView;
        this.ivMedia = imageView2;
        this.ivSelectMark = imageView3;
        this.tvLength = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemSelectPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemSelectPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_select_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemSelectPhotoBinding bind(View view) {
        int i = C1673R.C1677id.iv_large_file_mark;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1673R.C1677id.iv_media;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1673R.C1677id.iv_select_mark;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = C1673R.C1677id.tv_length;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        return new StreamItemSelectPhotoBinding((ConstraintLayout) view, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
