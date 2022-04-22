package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.tabs.TabLayout;
import com.memes.editor.C4175R;
import java.util.Objects;

public final class NMediaSelectionCategoryBinding implements ViewBinding {
    public final TextView actionTextView;
    public final ConstraintLayout contentLayout;
    public final TextView messageTextView;
    public final ProgressBar progressBar;
    public final RecyclerView recyclerView;
    public final TextView retryView;
    private final View rootView;
    public final LinearLayout stateLayout;
    public final TabLayout tabLayout;

    private NMediaSelectionCategoryBinding(View view, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ProgressBar progressBar2, RecyclerView recyclerView2, TextView textView3, LinearLayout linearLayout, TabLayout tabLayout2) {
        this.rootView = view;
        this.actionTextView = textView;
        this.contentLayout = constraintLayout;
        this.messageTextView = textView2;
        this.progressBar = progressBar2;
        this.recyclerView = recyclerView2;
        this.retryView = textView3;
        this.stateLayout = linearLayout;
        this.tabLayout = tabLayout2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static NMediaSelectionCategoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        layoutInflater.inflate(C4175R.C4181layout.n_media_selection_category, viewGroup);
        return bind(viewGroup);
    }

    public static NMediaSelectionCategoryBinding bind(View view) {
        int i = C4175R.C4179id.action_text_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4175R.C4179id.content_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
            if (constraintLayout != null) {
                i = C4175R.C4179id.message_text_view;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = C4175R.C4179id.progress_bar;
                    ProgressBar progressBar2 = (ProgressBar) view.findViewById(i);
                    if (progressBar2 != null) {
                        i = C4175R.C4179id.recycler_view;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(i);
                        if (recyclerView2 != null) {
                            i = C4175R.C4179id.retry_view;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                i = C4175R.C4179id.state_layout;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                if (linearLayout != null) {
                                    i = C4175R.C4179id.tab_layout;
                                    TabLayout tabLayout2 = (TabLayout) view.findViewById(i);
                                    if (tabLayout2 != null) {
                                        return new NMediaSelectionCategoryBinding(view, textView, constraintLayout, textView2, progressBar2, recyclerView2, textView3, linearLayout, tabLayout2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
