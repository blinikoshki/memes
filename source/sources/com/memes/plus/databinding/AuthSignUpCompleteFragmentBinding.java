package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.plus.C4199R;

public final class AuthSignUpCompleteFragmentBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TextView birthdayTextView;
    public final TextView genderTextView;
    public final TextInputEditText nameEditText;
    public final TextView pageInfoView;
    public final TextView pageTitleView;
    public final ImageView profilePictureImageView;
    public final ImageView profilePicturePlaceholderView;
    private final ConstraintLayout rootView;
    public final TextView submitButton;

    private AuthSignUpCompleteFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextInputEditText textInputEditText, TextView textView3, TextView textView4, ImageView imageView2, ImageView imageView3, TextView textView5) {
        this.rootView = constraintLayout;
        this.backImageView = imageView;
        this.birthdayTextView = textView;
        this.genderTextView = textView2;
        this.nameEditText = textInputEditText;
        this.pageInfoView = textView3;
        this.pageTitleView = textView4;
        this.profilePictureImageView = imageView2;
        this.profilePicturePlaceholderView = imageView3;
        this.submitButton = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthSignUpCompleteFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthSignUpCompleteFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_sign_up_complete_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthSignUpCompleteFragmentBinding bind(View view) {
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.birthday_text_view;
            TextView textView = (TextView) view.findViewById(C4199R.C4203id.birthday_text_view);
            if (textView != null) {
                i = C4199R.C4203id.gender_text_view;
                TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.gender_text_view);
                if (textView2 != null) {
                    i = C4199R.C4203id.name_edit_text;
                    TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C4199R.C4203id.name_edit_text);
                    if (textInputEditText != null) {
                        i = C4199R.C4203id.page_info_view;
                        TextView textView3 = (TextView) view.findViewById(C4199R.C4203id.page_info_view);
                        if (textView3 != null) {
                            i = C4199R.C4203id.page_title_view;
                            TextView textView4 = (TextView) view.findViewById(C4199R.C4203id.page_title_view);
                            if (textView4 != null) {
                                i = C4199R.C4203id.profile_picture_image_view;
                                ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.profile_picture_image_view);
                                if (imageView2 != null) {
                                    i = C4199R.C4203id.profile_picture_placeholder_view;
                                    ImageView imageView3 = (ImageView) view.findViewById(C4199R.C4203id.profile_picture_placeholder_view);
                                    if (imageView3 != null) {
                                        i = C4199R.C4203id.submit_button;
                                        TextView textView5 = (TextView) view.findViewById(C4199R.C4203id.submit_button);
                                        if (textView5 != null) {
                                            return new AuthSignUpCompleteFragmentBinding((ConstraintLayout) view, imageView, textView, textView2, textInputEditText, textView3, textView4, imageView2, imageView3, textView5);
                                        }
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
