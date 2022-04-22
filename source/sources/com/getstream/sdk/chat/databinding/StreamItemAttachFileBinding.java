package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemAttachFileBinding implements ViewBinding {
    public final Barrier barrier;
    public final ImageView ivClose;
    public final ImageView ivFileThumb;
    public final ImageView ivLargeFileMark;
    public final ImageView ivSelectMark;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView tvFileSize;
    public final TextView tvFileTitle;

    private StreamItemAttachFileBinding(ConstraintLayout constraintLayout, Barrier barrier2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ProgressBar progressBar2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.barrier = barrier2;
        this.ivClose = imageView;
        this.ivFileThumb = imageView2;
        this.ivLargeFileMark = imageView3;
        this.ivSelectMark = imageView4;
        this.progressBar = progressBar2;
        this.tvFileSize = textView;
        this.tvFileTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemAttachFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemAttachFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_attach_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemAttachFileBinding bind(View view) {
        int i = C1673R.C1677id.barrier;
        Barrier barrier2 = (Barrier) view.findViewById(i);
        if (barrier2 != null) {
            i = C1673R.C1677id.iv_close;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C1673R.C1677id.iv_file_thumb;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = C1673R.C1677id.iv_large_file_mark;
                    ImageView imageView3 = (ImageView) view.findViewById(i);
                    if (imageView3 != null) {
                        i = C1673R.C1677id.iv_select_mark;
                        ImageView imageView4 = (ImageView) view.findViewById(i);
                        if (imageView4 != null) {
                            i = C1673R.C1677id.progressBar;
                            ProgressBar progressBar2 = (ProgressBar) view.findViewById(i);
                            if (progressBar2 != null) {
                                i = C1673R.C1677id.tv_file_size;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C1673R.C1677id.tv_file_title;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        return new StreamItemAttachFileBinding((ConstraintLayout) view, barrier2, imageView, imageView2, imageView3, imageView4, progressBar2, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
