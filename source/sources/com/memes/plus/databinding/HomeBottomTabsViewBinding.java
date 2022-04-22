package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class HomeBottomTabsViewBinding implements ViewBinding {
    public final RecyclerView bottomTabsRecyclerView;
    private final RecyclerView rootView;

    private HomeBottomTabsViewBinding(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.bottomTabsRecyclerView = recyclerView2;
    }

    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static HomeBottomTabsViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HomeBottomTabsViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.home_bottom_tabs_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HomeBottomTabsViewBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new HomeBottomTabsViewBinding(recyclerView, recyclerView);
    }
}
