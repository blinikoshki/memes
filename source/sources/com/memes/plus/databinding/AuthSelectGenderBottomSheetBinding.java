package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class AuthSelectGenderBottomSheetBinding implements ViewBinding {
    public final TextView doneTextView;
    public final TextView femaleGenderTextView;
    public final TextView maleGenderTextView;
    public final TextView noneGenderTextView;
    private final ConstraintLayout rootView;
    public final TextView unspecifiedGenderTextView;

    private AuthSelectGenderBottomSheetBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.doneTextView = textView;
        this.femaleGenderTextView = textView2;
        this.maleGenderTextView = textView3;
        this.noneGenderTextView = textView4;
        this.unspecifiedGenderTextView = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthSelectGenderBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthSelectGenderBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_select_gender_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthSelectGenderBottomSheetBinding bind(View view) {
        int i = C4199R.C4203id.done_text_view;
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.done_text_view);
        if (textView != null) {
            i = C4199R.C4203id.female_gender_text_view;
            TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.female_gender_text_view);
            if (textView2 != null) {
                i = C4199R.C4203id.male_gender_text_view;
                TextView textView3 = (TextView) view.findViewById(C4199R.C4203id.male_gender_text_view);
                if (textView3 != null) {
                    i = C4199R.C4203id.none_gender_text_view;
                    TextView textView4 = (TextView) view.findViewById(C4199R.C4203id.none_gender_text_view);
                    if (textView4 != null) {
                        i = C4199R.C4203id.unspecified_gender_text_view;
                        TextView textView5 = (TextView) view.findViewById(C4199R.C4203id.unspecified_gender_text_view);
                        if (textView5 != null) {
                            return new AuthSelectGenderBottomSheetBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
