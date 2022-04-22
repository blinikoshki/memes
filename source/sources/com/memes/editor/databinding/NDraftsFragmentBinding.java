package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NDraftsFragmentBinding implements ViewBinding {
    public final ImageView backImageView;
    public final RecyclerView draftsRecyclerView;
    public final TextView noDraftsView;
    private final ConstraintLayout rootView;
    public final FrameLayout topbar;

    private NDraftsFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.backImageView = imageView;
        this.draftsRecyclerView = recyclerView;
        this.noDraftsView = textView;
        this.topbar = frameLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static NDraftsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NDraftsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_drafts_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NDraftsFragmentBinding bind(View view) {
        int i = C4175R.C4179id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4175R.C4179id.drafts_recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
            if (recyclerView != null) {
                i = C4175R.C4179id.no_drafts_view;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4175R.C4179id.topbar;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                    if (frameLayout != null) {
                        return new NDraftsFragmentBinding((ConstraintLayout) view, imageView, recyclerView, textView, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
