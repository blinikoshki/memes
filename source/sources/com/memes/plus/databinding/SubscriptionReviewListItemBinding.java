package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;

public final class SubscriptionReviewListItemBinding implements ViewBinding {
    public final RatingBar ratingBar;
    public final TextView reviewTextView;
    private final LinearLayout rootView;
    public final TextView userNameTextView;

    private SubscriptionReviewListItemBinding(LinearLayout linearLayout, RatingBar ratingBar2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ratingBar = ratingBar2;
        this.reviewTextView = textView;
        this.userNameTextView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SubscriptionReviewListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SubscriptionReviewListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.subscription_review_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SubscriptionReviewListItemBinding bind(View view) {
        int i = C4199R.C4203id.rating_bar;
        RatingBar ratingBar2 = (RatingBar) view.findViewById(C4199R.C4203id.rating_bar);
        if (ratingBar2 != null) {
            i = C4199R.C4203id.review_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.review_text_view);
            if (textView != null) {
                i = C4199R.C4203id.user_name_text_view;
                TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.user_name_text_view);
                if (textView2 != null) {
                    return new SubscriptionReviewListItemBinding((LinearLayout) view, ratingBar2, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
