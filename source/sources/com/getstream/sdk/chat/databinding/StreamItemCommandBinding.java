package com.getstream.sdk.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.getstream.sdk.chat.C1673R;

public final class StreamItemCommandBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvArg;
    public final TextView tvCommand;
    public final TextView tvDes;

    private StreamItemCommandBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvArg = textView;
        this.tvCommand = textView2;
        this.tvDes = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StreamItemCommandBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StreamItemCommandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1673R.C1679layout.stream_item_command, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StreamItemCommandBinding bind(View view) {
        int i = C1673R.C1677id.tv_arg;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C1673R.C1677id.tv_command;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                i = C1673R.C1677id.tv_des;
                TextView textView3 = (TextView) view.findViewById(i);
                if (textView3 != null) {
                    return new StreamItemCommandBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
