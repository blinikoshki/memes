package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class AppRatingRequestBottomSheetBinding implements ViewBinding {
    public final AppRatingRequestItemBinding includedLayout;
    public final LinearLayout root;
    private final LinearLayout rootView;

    private AppRatingRequestBottomSheetBinding(LinearLayout linearLayout, AppRatingRequestItemBinding appRatingRequestItemBinding, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.includedLayout = appRatingRequestItemBinding;
        this.root = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AppRatingRequestBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AppRatingRequestBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.app_rating_request_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AppRatingRequestBottomSheetBinding bind(View view) {
        View findViewById = view.findViewById(C4199R.C4203id.included_layout);
        if (findViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new AppRatingRequestBottomSheetBinding(linearLayout, AppRatingRequestItemBinding.bind(findViewById), linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C4199R.C4203id.included_layout)));
    }
}
