package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.memes.plus.C4199R;
import com.memes.plus.custom.UserAvatarView;

public final class AppRatingRequestItemBinding implements ViewBinding {
    public final Button addReviewButton;
    public final TextView appRatingMessageLabel;
    public final ConstraintLayout bottomSheetLayout;
    public final Guideline guidelineVertical20;
    public final Guideline guidelineVertical80;
    public final UserAvatarView profileImageView;
    public final TextView reviewHeadingTextView;
    private final ConstraintLayout rootView;

    private AppRatingRequestItemBinding(ConstraintLayout constraintLayout, Button button, TextView textView, ConstraintLayout constraintLayout2, Guideline guideline, Guideline guideline2, UserAvatarView userAvatarView, TextView textView2) {
        this.rootView = constraintLayout;
        this.addReviewButton = button;
        this.appRatingMessageLabel = textView;
        this.bottomSheetLayout = constraintLayout2;
        this.guidelineVertical20 = guideline;
        this.guidelineVertical80 = guideline2;
        this.profileImageView = userAvatarView;
        this.reviewHeadingTextView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AppRatingRequestItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AppRatingRequestItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.app_rating_request_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AppRatingRequestItemBinding bind(View view) {
        int i = C4199R.C4203id.add_review_button;
        Button button = (Button) view.findViewById(C4199R.C4203id.add_review_button);
        if (button != null) {
            i = C4199R.C4203id.app_rating_message_label;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.app_rating_message_label);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = C4199R.C4203id.guideline_vertical_20;
                Guideline guideline = (Guideline) view.findViewById(C4199R.C4203id.guideline_vertical_20);
                if (guideline != null) {
                    i = C4199R.C4203id.guideline_vertical_80;
                    Guideline guideline2 = (Guideline) view.findViewById(C4199R.C4203id.guideline_vertical_80);
                    if (guideline2 != null) {
                        i = C4199R.C4203id.profile_image_view;
                        UserAvatarView userAvatarView = (UserAvatarView) view.findViewById(C4199R.C4203id.profile_image_view);
                        if (userAvatarView != null) {
                            i = C4199R.C4203id.review_heading_text_view;
                            TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.review_heading_text_view);
                            if (textView2 != null) {
                                return new AppRatingRequestItemBinding(constraintLayout, button, textView, constraintLayout, guideline, guideline2, userAvatarView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
