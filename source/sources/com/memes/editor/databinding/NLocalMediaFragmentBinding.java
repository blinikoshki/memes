package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.editor.C4175R;

public final class NLocalMediaFragmentBinding implements ViewBinding {
    public final ContentLayout contentLayout;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;

    private NLocalMediaFragmentBinding(LinearLayout linearLayout, ContentLayout contentLayout2, RecyclerView recyclerView2) {
        this.rootView = linearLayout;
        this.contentLayout = contentLayout2;
        this.recyclerView = recyclerView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NLocalMediaFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NLocalMediaFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_local_media_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NLocalMediaFragmentBinding bind(View view) {
        int i = C4175R.C4179id.content_layout;
        ContentLayout contentLayout2 = (ContentLayout) view.findViewById(i);
        if (contentLayout2 != null) {
            i = C4175R.C4179id.recycler_view;
            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(i);
            if (recyclerView2 != null) {
                return new NLocalMediaFragmentBinding((LinearLayout) view, contentLayout2, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
