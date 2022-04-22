package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NHeaderTitleResetBinding implements ViewBinding {
    public final TextView resetView;
    private final ConstraintLayout rootView;
    public final TextView titleView;

    private NHeaderTitleResetBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.resetView = textView;
        this.titleView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NHeaderTitleResetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NHeaderTitleResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_header_title_reset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NHeaderTitleResetBinding bind(View view) {
        int i = C4175R.C4179id.reset_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4175R.C4179id.title_view;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new NHeaderTitleResetBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
