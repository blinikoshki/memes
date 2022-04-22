package com.memes.editor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.memes.editor.C4175R;
import editor.common.sheetfooter.CancelDoneFooter;

public final class NTextTabsFragmentBinding implements ViewBinding {
    public final CancelDoneFooter footer;
    private final LinearLayout rootView;
    public final TabLayout tabLayout;
    public final ViewPager2 tabViewPager;

    private NTextTabsFragmentBinding(LinearLayout linearLayout, CancelDoneFooter cancelDoneFooter, TabLayout tabLayout2, ViewPager2 viewPager2) {
        this.rootView = linearLayout;
        this.footer = cancelDoneFooter;
        this.tabLayout = tabLayout2;
        this.tabViewPager = viewPager2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NTextTabsFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NTextTabsFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4175R.C4181layout.n_text_tabs_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NTextTabsFragmentBinding bind(View view) {
        int i = C4175R.C4179id.footer;
        CancelDoneFooter cancelDoneFooter = (CancelDoneFooter) view.findViewById(i);
        if (cancelDoneFooter != null) {
            i = C4175R.C4179id.tab_layout;
            TabLayout tabLayout2 = (TabLayout) view.findViewById(i);
            if (tabLayout2 != null) {
                i = C4175R.C4179id.tab_view_pager;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(i);
                if (viewPager2 != null) {
                    return new NTextTabsFragmentBinding((LinearLayout) view, cancelDoneFooter, tabLayout2, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
