package com.memes.plus.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.memes.plus.C4199R;

public final class AuthSignUpEmailFragmentBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TextInputEditText emailEditText;
    public final ImageView facebookSignInButton;
    public final Guideline guidelineHeight90;
    public final TextInputEditText passwordEditText;
    private final ConstraintLayout rootView;
    public final TextView signInTextView;
    public final TextView signUpButton;
    public final ImageView snapchatSignInButton;
    public final TextView titleTextView;
    public final TextInputEditText usernameEditText;

    private AuthSignUpEmailFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, TextInputEditText textInputEditText, ImageView imageView2, Guideline guideline, TextInputEditText textInputEditText2, TextView textView, TextView textView2, ImageView imageView3, TextView textView3, TextInputEditText textInputEditText3) {
        this.rootView = constraintLayout;
        this.backImageView = imageView;
        this.emailEditText = textInputEditText;
        this.facebookSignInButton = imageView2;
        this.guidelineHeight90 = guideline;
        this.passwordEditText = textInputEditText2;
        this.signInTextView = textView;
        this.signUpButton = textView2;
        this.snapchatSignInButton = imageView3;
        this.titleTextView = textView3;
        this.usernameEditText = textInputEditText3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthSignUpEmailFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AuthSignUpEmailFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C4199R.C4205layout.auth_sign_up_email_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthSignUpEmailFragmentBinding bind(View view) {
        int i = C4199R.C4203id.back_image_view;
        ImageView imageView = (ImageView) view.findViewById(C4199R.C4203id.back_image_view);
        if (imageView != null) {
            i = C4199R.C4203id.email_edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C4199R.C4203id.email_edit_text);
            if (textInputEditText != null) {
                i = C4199R.C4203id.facebook_sign_in_button;
                ImageView imageView2 = (ImageView) view.findViewById(C4199R.C4203id.facebook_sign_in_button);
                if (imageView2 != null) {
                    i = C4199R.C4203id.guideline_height_90;
                    Guideline guideline = (Guideline) view.findViewById(C4199R.C4203id.guideline_height_90);
                    if (guideline != null) {
                        i = C4199R.C4203id.password_edit_text;
                        TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(C4199R.C4203id.password_edit_text);
                        if (textInputEditText2 != null) {
                            i = C4199R.C4203id.sign_in_text_view;
                            TextView textView = (TextView) view.findViewById(C4199R.C4203id.sign_in_text_view);
                            if (textView != null) {
                                i = C4199R.C4203id.sign_up_button;
                                TextView textView2 = (TextView) view.findViewById(C4199R.C4203id.sign_up_button);
                                if (textView2 != null) {
                                    i = C4199R.C4203id.snapchat_sign_in_button;
                                    ImageView imageView3 = (ImageView) view.findViewById(C4199R.C4203id.snapchat_sign_in_button);
                                    if (imageView3 != null) {
                                        i = C4199R.C4203id.title_text_view;
                                        TextView textView3 = (TextView) view.findViewById(C4199R.C4203id.title_text_view);
                                        if (textView3 != null) {
                                            i = C4199R.C4203id.username_edit_text;
                                            TextInputEditText textInputEditText3 = (TextInputEditText) view.findViewById(C4199R.C4203id.username_edit_text);
                                            if (textInputEditText3 != null) {
                                                return new AuthSignUpEmailFragmentBinding((ConstraintLayout) view, imageView, textInputEditText, imageView2, guideline, textInputEditText2, textView, textView2, imageView3, textView3, textInputEditText3);
                                            }
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
