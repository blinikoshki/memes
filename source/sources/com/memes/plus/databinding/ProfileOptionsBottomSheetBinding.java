package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class ProfileOptionsBottomSheetBinding implements ViewBinding {
    public final TextView blockUserTextView;
    public final TextView cancelTextView;
    private final CardView rootView;
    public final TextView shareProfileTextView;
    public final View viewDividerOne;

    private ProfileOptionsBottomSheetBinding(CardView cardView, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = cardView;
        this.blockUserTextView = textView;
        this.cancelTextView = textView2;
        this.shareProfileTextView = textView3;
        this.viewDividerOne = view;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static ProfileOptionsBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ProfileOptionsBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.profile_options_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ProfileOptionsBottomSheetBinding bind(View view) {
        int i = C4199R.C4203id.block_user_text_view;
        TextView textView = (TextView) view.findViewById(C4199R.C4203id.block_user_text_view);
        if (textView != null) {
            i = C4199R.C4203id.cancel_text_view;
            TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.cancel_text_view);
            if (textView2 != null) {
                i = C4199R.C4203id.share_profile_text_view;
                TextView textView3 = (TextView) view.findViewById(C4199R.C4203id.share_profile_text_view);
                if (textView3 != null) {
                    i = C4199R.C4203id.view_divider_one;
                    View findViewById = view.findViewById(C4199R.C4203id.view_divider_one);
                    if (findViewById != null) {
                        return new ProfileOptionsBottomSheetBinding((CardView) view, textView, textView2, textView3, findViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
