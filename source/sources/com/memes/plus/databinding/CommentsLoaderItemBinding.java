package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class CommentsLoaderItemBinding implements ViewBinding {
    public final TextView loaderTextView;
    private final ConstraintLayout rootView;

    private CommentsLoaderItemBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.loaderTextView = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CommentsLoaderItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CommentsLoaderItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.comments_loader_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CommentsLoaderItemBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.loader_text_view);
        if (textView != null) {
            return new CommentsLoaderItemBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C4199R.C4203id.loader_text_view)));
    }
}
