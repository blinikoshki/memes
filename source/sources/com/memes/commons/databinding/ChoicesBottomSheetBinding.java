package com.memes.commons.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.commons.C4144R;

public final class ChoicesBottomSheetBinding implements ViewBinding {
    public final TextView cancelView;
    public final RecyclerView choicesRecyclerView;
    private final LinearLayout rootView;

    private ChoicesBottomSheetBinding(LinearLayout linearLayout, TextView textView, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.cancelView = textView;
        this.choicesRecyclerView = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChoicesBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ChoicesBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4144R.C4150layout.choices_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ChoicesBottomSheetBinding bind(View view) {
        int i = C4144R.C4148id.cancel_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4144R.C4148id.choices_recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
            if (recyclerView != null) {
                return new ChoicesBottomSheetBinding((LinearLayout) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
