package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NFooterCloseOnlyBinding implements ViewBinding {
    public final TextView closeView;
    private final ConstraintLayout rootView;

    private NFooterCloseOnlyBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.closeView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NFooterCloseOnlyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NFooterCloseOnlyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_footer_close_only, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NFooterCloseOnlyBinding bind(View view) {
        int i = C4175R.C4179id.close_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            return new NFooterCloseOnlyBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
