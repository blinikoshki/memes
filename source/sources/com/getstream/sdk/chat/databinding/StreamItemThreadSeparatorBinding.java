package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemThreadSeparatorBinding implements ViewBinding {
    public final ConstraintLayout clHeader;
    private final ConstraintLayout rootView;
    public final TextView tvText;

    private StreamItemThreadSeparatorBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.clHeader = constraintLayout2;
        this.tvText = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemThreadSeparatorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemThreadSeparatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_thread_separator, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemThreadSeparatorBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C1673R.C1677id.tv_text;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            return new StreamItemThreadSeparatorBinding(constraintLayout, constraintLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
