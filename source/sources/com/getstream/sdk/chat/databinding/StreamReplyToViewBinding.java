package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamReplyToViewBinding implements ViewBinding {
    public final ImageView ivClose;
    public final ImageView ivMode;
    private final ConstraintLayout rootView;
    public final TextView tvMessage;
    public final TextView tvUserName;

    private StreamReplyToViewBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivClose = imageView;
        this.ivMode = imageView2;
        this.tvMessage = textView;
        this.tvUserName = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamReplyToViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamReplyToViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_reply_to_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamReplyToViewBinding bind(View view) {
        int i = C1673R.C1677id.ivClose;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1673R.C1677id.ivMode;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1673R.C1677id.tvMessage;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C1673R.C1677id.tvUserName;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        return new StreamReplyToViewBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
