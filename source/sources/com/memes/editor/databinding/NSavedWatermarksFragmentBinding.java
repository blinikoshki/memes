package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.editor.C4175R;
import editor.common.sheetfooter.CloseOnlyFooter;

public final class NSavedWatermarksFragmentBinding implements ViewBinding {
    public final CloseOnlyFooter footer;
    private final LinearLayout rootView;
    public final TextView savedWatermarksHintView;
    public final RecyclerView watermarksRecyclerView;

    private NSavedWatermarksFragmentBinding(LinearLayout linearLayout, CloseOnlyFooter closeOnlyFooter, TextView textView, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.footer = closeOnlyFooter;
        this.savedWatermarksHintView = textView;
        this.watermarksRecyclerView = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NSavedWatermarksFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NSavedWatermarksFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_saved_watermarks_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NSavedWatermarksFragmentBinding bind(View view) {
        int i = C4175R.C4179id.footer;
        CloseOnlyFooter closeOnlyFooter = (CloseOnlyFooter) view.findViewById(i);
        if (closeOnlyFooter != null) {
            i = C4175R.C4179id.saved_watermarks_hint_view;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4175R.C4179id.watermarks_recycler_view;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                if (recyclerView != null) {
                    return new NSavedWatermarksFragmentBinding((LinearLayout) view, closeOnlyFooter, textView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
