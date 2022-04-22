package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class PostSuggestedProfilesItemBinding implements ViewBinding {
    public final RecyclerView profilesRecyclerView;
    private final LinearLayout rootView;
    public final TextView seeAllTextView;

    private PostSuggestedProfilesItemBinding(LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.profilesRecyclerView = recyclerView;
        this.seeAllTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PostSuggestedProfilesItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PostSuggestedProfilesItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.post_suggested_profiles_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PostSuggestedProfilesItemBinding bind(View view) {
        int i = C4199R.C4203id.profiles_recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C4199R.C4203id.profiles_recycler_view);
        if (recyclerView != null) {
            i = C4199R.C4203id.see_all_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.see_all_text_view);
            if (textView != null) {
                return new PostSuggestedProfilesItemBinding((LinearLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
