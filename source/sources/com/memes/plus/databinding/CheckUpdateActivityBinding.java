package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class CheckUpdateActivityBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView textView;

    private CheckUpdateActivityBinding(ConstraintLayout constraintLayout, ProgressBar progressBar2, TextView textView2) {
        this.rootView = constraintLayout;
        this.progressBar = progressBar2;
        this.textView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CheckUpdateActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CheckUpdateActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.check_update_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CheckUpdateActivityBinding bind(View view) {
        int i = C4199R.C4203id.progress_bar;
        ProgressBar progressBar2 = (ProgressBar) view.findViewById(C4199R.C4203id.progress_bar);
        if (progressBar2 != null) {
            i = C4199R.C4203id.text_view;
            TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.text_view);
            if (textView2 != null) {
                return new CheckUpdateActivityBinding((ConstraintLayout) view, progressBar2, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
