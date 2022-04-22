package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;

public final class NWireframesFragmentBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RecyclerView wireframesRecyclerView;

    private NWireframesFragmentBinding(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.wireframesRecyclerView = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NWireframesFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NWireframesFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_wireframes_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NWireframesFragmentBinding bind(View view) {
        int i = C4175R.C4179id.wireframes_recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        if (recyclerView != null) {
            return new NWireframesFragmentBinding((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
