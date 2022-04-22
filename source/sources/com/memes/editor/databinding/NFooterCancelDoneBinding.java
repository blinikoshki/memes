package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NFooterCancelDoneBinding implements ViewBinding {
    public final TextView cancelView;
    public final TextView doneView;
    private final ConstraintLayout rootView;

    private NFooterCancelDoneBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.cancelView = textView;
        this.doneView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NFooterCancelDoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NFooterCancelDoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_footer_cancel_done, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NFooterCancelDoneBinding bind(View view) {
        int i = C4175R.C4179id.cancel_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4175R.C4179id.done_view;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                return new NFooterCancelDoneBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
