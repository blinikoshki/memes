package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.memes.plus.C4199R;
import java.util.Objects;

public final class AuthAccountRecoveryActivityBinding implements ViewBinding {
    private final ViewPager2 rootView;
    public final ViewPager2 viewPager;

    private AuthAccountRecoveryActivityBinding(ViewPager2 viewPager2, ViewPager2 viewPager22) {
        this.rootView = viewPager2;
        this.viewPager = viewPager22;
    }

    public ViewPager2 getRoot() {
        return this.rootView;
    }

    public static AuthAccountRecoveryActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthAccountRecoveryActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_account_recovery_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthAccountRecoveryActivityBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        ViewPager2 viewPager2 = (ViewPager2) view;
        return new AuthAccountRecoveryActivityBinding(viewPager2, viewPager2);
    }
}
