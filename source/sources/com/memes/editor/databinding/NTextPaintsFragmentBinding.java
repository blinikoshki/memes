package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.tabs.TabLayout;
import com.memes.editor.C4175R;

public final class NTextPaintsFragmentBinding implements ViewBinding {
    public final RecyclerView colorsRecyclerView;
    private final LinearLayout rootView;
    public final TabLayout tabLayout;

    private NTextPaintsFragmentBinding(LinearLayout linearLayout, RecyclerView recyclerView, TabLayout tabLayout2) {
        this.rootView = linearLayout;
        this.colorsRecyclerView = recyclerView;
        this.tabLayout = tabLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NTextPaintsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTextPaintsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_text_paints_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NTextPaintsFragmentBinding bind(View view) {
        int i = C4175R.C4179id.colors_recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        if (recyclerView != null) {
            i = C4175R.C4179id.tab_layout;
            TabLayout tabLayout2 = (TabLayout) view.findViewById(i);
            if (tabLayout2 != null) {
                return new NTextPaintsFragmentBinding((LinearLayout) view, recyclerView, tabLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
