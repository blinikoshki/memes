package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;
import com.getstream.sdk.chat.utils.roundedImageView.PorterShapeImageView;

public final class StreamItemAttachedMediaBinding implements ViewBinding {
    public final Button btnClose;
    public final ImageView ivMask;
    public final PorterShapeImageView ivMedia;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView tvLength;

    private StreamItemAttachedMediaBinding(ConstraintLayout constraintLayout, Button button, ImageView imageView, PorterShapeImageView porterShapeImageView, ProgressBar progressBar2, TextView textView) {
        this.rootView = constraintLayout;
        this.btnClose = button;
        this.ivMask = imageView;
        this.ivMedia = porterShapeImageView;
        this.progressBar = progressBar2;
        this.tvLength = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemAttachedMediaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemAttachedMediaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_attached_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemAttachedMediaBinding bind(View view) {
        int i = C1673R.C1677id.btn_close;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1673R.C1677id.iv_mask;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C1673R.C1677id.iv_media;
                PorterShapeImageView porterShapeImageView = (PorterShapeImageView) view.findViewById(i);
                if (porterShapeImageView != null) {
                    i = C1673R.C1677id.progressBar;
                    ProgressBar progressBar2 = (ProgressBar) view.findViewById(i);
                    if (progressBar2 != null) {
                        i = C1673R.C1677id.tv_length;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            return new StreamItemAttachedMediaBinding((ConstraintLayout) view, button, imageView, porterShapeImageView, progressBar2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
