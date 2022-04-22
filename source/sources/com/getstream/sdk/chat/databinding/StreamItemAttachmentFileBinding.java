package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemAttachmentFileBinding implements ViewBinding {
    public final ConstraintLayout attachmentview;
    public final ImageView ivFileThumb;
    public final ImageView ivSelectMark;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView tvClose;
    public final TextView tvFileSize;
    public final TextView tvFileTitle;

    private StreamItemAttachmentFileBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.attachmentview = constraintLayout2;
        this.ivFileThumb = imageView;
        this.ivSelectMark = imageView2;
        this.progressBar = progressBar2;
        this.tvClose = textView;
        this.tvFileSize = textView2;
        this.tvFileTitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemAttachmentFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemAttachmentFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_attachment_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemAttachmentFileBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C1673R.C1677id.iv_file_thumb;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1673R.C1677id.iv_select_mark;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1673R.C1677id.progressBar;
                ProgressBar progressBar2 = (ProgressBar) view.findViewById(i);
                if (progressBar2 != null) {
                    i = C1673R.C1677id.tv_close;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = C1673R.C1677id.tv_file_size;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = C1673R.C1677id.tv_file_title;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                return new StreamItemAttachmentFileBinding(constraintLayout, constraintLayout, imageView, imageView2, progressBar2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
